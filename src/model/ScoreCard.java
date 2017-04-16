package model;

import java.util.LinkedHashMap;

public class ScoreCard {
    private LinkedHashMap<Category, Integer> scores = new LinkedHashMap<>();

    public ScoreCard(){
        scores.put(Category.ACES, -1);
        scores.put(Category.TWOS, -1);
        scores.put(Category.THREES, -1);
        scores.put(Category.FOURS, -1);
        scores.put(Category.FIVES, -1);
        scores.put(Category.SIXES, -1);
        scores.put(Category.THREEOFAKIND, -1);
        scores.put(Category.FOUROFAKIND, -1);
        scores.put(Category.FULLHOUSE, -1);
        scores.put(Category.SMALLSTRAIGHT, -1);
        scores.put(Category.LARGESTRAIGHT, -1);
        scores.put(Category.YAHTZEE, -1);
        scores.put(Category.CHANCE, -1);
    }

    public void setScore(Category category, int score){
        scores.put(category, score);
    }

    public int getScore(Category category){
        return scores.get(category);
    }

    public LinkedHashMap<Category, Integer> getScores() { return scores; }

    public boolean isCardFull(){
        return !scores.containsValue(-1);
    }

    public void reset(){
        for(Category each : scores.keySet()){
            scores.put(each, null);
        }
    }
}
