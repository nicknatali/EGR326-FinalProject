package strategy;


import logic.Yahtzee;
import model.Category;
import model.Die;
import model.YahtzeeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

public abstract class Strategy {

    public abstract Die[] rollStrategy(YahtzeeGame game);

    public abstract ArrayList<Object> categoryStrategy(YahtzeeGame game);

    protected void updateView(YahtzeeGame game){
        game.getGui().getView().setState();
        //Delay goes here
        // TODO:
    }

    protected ArrayList<Category> getValidCategories(YahtzeeGame game){
        //Create a list to return of the valid scores
        ArrayList<Category> validScores = new ArrayList<>();
        //Get current scores for current dice config
        LinkedHashMap<Category, Integer> currScores = game.getCurrPlayer().getScoreCard().getScores();
        //Add values to return map that are empty
        for(Category each : currScores.keySet()){
            int score = currScores.get(each);
            if(score == -1) {
                validScores.add(each);
            }
        }
        //Return a map of valid scores
        return validScores;
    }
}
