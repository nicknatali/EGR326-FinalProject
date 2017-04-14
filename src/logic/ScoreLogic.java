package logic;

import model.Category;
import model.Die;
import java.util.LinkedHashMap;

public class ScoreLogic {

    public LinkedHashMap<Category, Integer> generateScores(Die[] dice){
        LinkedHashMap<Category, Integer> scores = new LinkedHashMap<>();
        //Generate Scores for lower half of score card
        for(int i = 1; i <= 6; i++){
            scores.put(Category.fromInteger(i), calculateLowerScores(dice, i));
        }
        return scores;
    }

    public int calculateLowerScores(Die[] dice, int value){
        int total = 0;
        for(Die each : dice){
            if(each.getValue() == value)
                total += value;
        }
        return total;
    }

    public int calculateThreeOfAKind(){
        return 0;
    }

    public int calculateFourOfAKind(){
        return 0;
    }

    public int calculateFullHouse() { return 0; }

    public int calculateSmallStraight(){
        return 0;
    }

    public int calculateLargeStraight(){
        return 0;
    }

    public int calculateYahtzee(){
        return 0;
    }

    public int calculateChance(){
        return 0;
    }

}
