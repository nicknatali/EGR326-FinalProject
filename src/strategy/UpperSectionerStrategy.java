package strategy;


import model.Category;
import model.Die;
import model.YahtzeeGame;

import java.util.ArrayList;
import java.util.HashMap;

public class UpperSectionerStrategy extends Strategy {
    @Override
    public Die[] rollStrategy(YahtzeeGame game) {
        return new Die[0];
    }

    @Override
    public ArrayList<Object> categoryStrategy(YahtzeeGame game) {
        return null;
    }
}
