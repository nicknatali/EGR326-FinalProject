package model;

import strategy.Strategy;
import strategy.StrategyType;

public class Computer extends Player{
    private Strategy strategy;

    public boolean reRoll() {
        return false;
    }

    public boolean chooseCategory() {
        return false;
    }

    public Computer(String name) { super(name); }
    public Computer(String name, Strategy strategy){
        super(name);
        this.strategy = strategy;
    }
    public Computer(String name, StrategyType type){
        super(name);
        strategy = StrategyType.toStrategy(type);
    }


}
