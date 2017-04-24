package strategy;


import model.Category;
import model.Die;
import model.ScoreCard;
import model.YahtzeeGame;

import java.util.ArrayList;
import java.util.HashMap;

public class FourAndUpStrategy extends Strategy{


    public Die[] rollStrategy(YahtzeeGame game) {
        return new Die[0];
    }

    @Override
    public ArrayList<Object> categoryStrategy(YahtzeeGame game) {

        //If the scorecard is a chance
            //Get the max score of the roll

        //If the score card is in the upperNumbers
            //Get the max score for the amount of upper nums

        //if the score card is "{something} of a kind"
            //Get the max score for the amount of nums

        //If scorecard is a full house


        //If it is a small straight


        //If it is a straight

        //If it is a yahtzee


        //If the category hasn't been selected
        //Select a category from the upper category that
        //Hasn't been chosen yet





    }





}
