package strategy;


import logic.ScoreLogic;
import model.Category;
import model.Die;
import model.YahtzeeGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomStrategy extends Strategy{

    @Override
    public Die[] rollStrategy(YahtzeeGame game) {
        Random r = new Random();
        //Max amount of rolls that can be done
        for(int i = 0; i < 2; i++) {
            //Randomly choose if the player should continue rolling or not
            if(r.nextBoolean()) break;
            //Randomly set each dice to rollable or not
            for(int j = 0; j < 5; j++) game.getDice()[j].setRollable(r.nextBoolean());
            //Roll dice
            game.rollDice();
            game.setDiceRollState(true);
            //Update gui
            updateView(game);
        }
        //Return dice in final form
        return game.getDice();
    }

    @Override
    public ArrayList<Object> categoryStrategy(YahtzeeGame game) {
        Random r = new Random();
        ArrayList<Object> returningPair = new ArrayList<>();
        //Generate score logic from dice
        ArrayList<Category> validCategories = getValidCategories(game);
        HashMap<Category, Integer> scores = game.getCurrScores();
        //Generate random category
        Category randCategory = validCategories.get(r.nextInt(validCategories.size()));
        //Create random category value pair
        returningPair.add(randCategory);
        returningPair.add(scores.get(randCategory));
        //Return random category
        updateView(game);
        //Return the chosen pair
        return returningPair;
    }
}
