package model;

import logic.ScoreLogic;
import strategy.Strategy;
import strategy.StrategyType;

import java.util.ArrayList;
import java.util.HashMap;

public class Computer extends Player{
    private Strategy strategy;

    public Computer(String name) { super(name); }

    public Computer(String name, Strategy strategy){
        super(name);
        this.strategy = strategy;
    }

    public Computer(String name, StrategyType type){
        super(name);
        strategy = StrategyType.toStrategy(type);
    }




    public void makeMove(YahtzeeGame game){
        //Allow computer to roll dice according to strategy
        strategy.rollStrategy(game);
        //Allow computer to pick a category according to strategy
        ArrayList<Object> picked = strategy.categoryStrategy(game);
        //Generate score logic for the specific dice roll
        try {
            scoreCard.setScore((Category) picked.get(0), (Integer) picked.get(1));
        } catch (Exception e){
            System.out.println("Unable to cast!");
        }
    }
}
