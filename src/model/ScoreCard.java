package model;

import java.util.LinkedHashMap;

public class ScoreCard {
    private LinkedHashMap<Category, Integer> scores = new LinkedHashMap<>();

    public ScoreCard(){
        scores.put(Category.ACES, null);
        scores.put(Category.TWOS, null);
        scores.put(Category.THREES, null);
        scores.put(Category.FOURS, null);
        scores.put(Category.FIVES, null);
        scores.put(Category.SIXES, null);
        scores.put(Category.THREEOFAKIND, null);
        scores.put(Category.FOUROFAKIND, null);
        scores.put(Category.FULLHOUSE, null);
        scores.put(Category.SMALLSTRAIGHT, null);
        scores.put(Category.LARGESTRAIGHT, null);
        scores.put(Category.YAHTZEE, null);
        scores.put(Category.CHANCE, null);
    }

    public void setScore(Category category, int score){
        scores.put(category, score);
    }

    public void getScore(Category category){
        scores.get(category);
    }

    public boolean isCardFull(){
        return !scores.containsValue(null);
    }

    public void reset(){
        for(Category each : scores.keySet()){
            scores.put(each, null);
        }
    }
}
