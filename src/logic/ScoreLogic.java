package logic;

import model.Category;
import model.Die;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ScoreLogic {

    public LinkedHashMap<Category, Integer> generateScores(Die[] dice){
        LinkedHashMap<Category, Integer> scores = new LinkedHashMap<>();
        //Generate Scores for upper half of score card
        for(int i = 1; i <= 6; i++) scores.put(Category.fromInteger(i), calculateLowerScores(dice, i));
        //Generate scores for lower half of score card
        scores.put(Category.THREEOFAKIND, calculateThreeOfAKind(dice));
        scores.put(Category.FOUROFAKIND, calculateFourOfAKind(dice));
        scores.put(Category.FULLHOUSE, calculateFullHouse(dice));
        scores.put(Category.SMALLSTRAIGHT, calculateSmallStraight(dice));
        scores.put(Category.LARGESTRAIGHT, calculateLargeStraight(dice));
        scores.put(Category.YAHTZEE, calculateYahtzee(dice));
        scores.put(Category.CHANCE, calculateChance(dice));
        //Return all results
        return scores;
    }



    private int calculateLowerScores(Die[] dice, int value){
        //Create total
        int total = 0;
        //Add dice values where applicable
        for(Die each : dice){
            if(each.getValue() == value)
                total += value;
        }
        //Return total
        return total;
    }



    private int calculateThreeOfAKind(Die[] dice){
        //Create a new hash map
        HashMap<Integer, Integer> diceValues = generateHashMap(dice);
        //Check for 3 of a kind
        for(Integer key : diceValues.keySet()){
            if(diceValues.get(key) == 3) return calculateChance(dice);
        }
        //Three of a kind not applicable
        return 0;
    }



    private int calculateFourOfAKind(Die[] dice){
        //Create a new hash map
        HashMap<Integer, Integer> diceValues = generateHashMap(dice);
        //Check for 4 of a kind
        for(Integer key : diceValues.keySet()){
            if(diceValues.get(key) == 4) return calculateChance(dice);
        }
        //Three of a kind not applicable
        return 0;
    }



    private int calculateFullHouse(Die[] dice) {
        //Create a new hash map
        HashMap<Integer, Integer> diceValues = generateHashMap(dice);
        //Check for 3 of a kind and a 2 of a kind
        if(diceValues.keySet().size() == 2){
            Integer[] keys = diceValues.keySet().toArray(new Integer[diceValues.size()]);
            if((diceValues.get(keys[0]) == 2 && diceValues.get(keys[1]) == 3)
                    || (diceValues.get(keys[0]) == 3 && diceValues.get(keys[1]) == 2)){
                return 25;
            }
        }
        //Three of a kind not applicable
        return 0;
    }



    private int calculateSmallStraight(Die[] dice){
        //Create a variable to count how many are in ascending order
        int totalInOrder = numberOrderedDice(dice);
        //Return score based on results
        return totalInOrder >= 4 ? 30 : 0;
    }



    private int calculateLargeStraight(Die[] dice){
        //Create a variable to count how many are in ascending order
        int totalInOrder = numberOrderedDice(dice);
        //Return score based on results
        return totalInOrder == 5 ? 40 : 0;
    }



    private int calculateYahtzee(Die[] dice){
        //Create a new hash map
        HashMap<Integer, Integer> diceValues = generateHashMap(dice);
        //Check for 5 of a kind
        if(diceValues.keySet().size() == 1) return 50;
        //Three of a kind not applicable
        return 0;
    }



    private int calculateChance(Die[] dice){
        //Create total
        int total = 0;
        //Add dice values where applicable
        for(Die each : dice) total += each.getValue();
        //Return total
        return total;
    }



    private HashMap<Integer, Integer> generateHashMap(Die[] dice){
        //Create a new hash map
        HashMap<Integer, Integer> diceValues = new HashMap<>();
        //Loop over dice
        for(Die die : dice){
            //Put if not present or add to number of occurrences
            if(diceValues.containsKey(die.getValue()))
                diceValues.put(die.getValue(), diceValues.get(die.getValue()) + 1);
            else
                diceValues.putIfAbsent(die.getValue(), 1);
        }
        //Return hashmap
        return diceValues;
    }



    private int numberOrderedDice(Die[] dice){
        //Create a variable to count how many are in ascending order
        int totalInOrder = 1;
        //Create a new hash map
        HashMap<Integer, Integer> diceValues = generateHashMap(dice);
        //Turn keys to ordered array
        Integer[] keys = diceValues.keySet().toArray(new Integer[diceValues.size()]);
        //Sort key values
        Arrays.sort(keys);
        //Loop over list of values
        for(int i = 0; i < keys.length - 1; i++){
            if(keys[i+1] - keys[i] == 1)
                totalInOrder++;
            else
                totalInOrder = 1;
        }
        //Check to see if a straight has been achieved
        return totalInOrder;
    }
}