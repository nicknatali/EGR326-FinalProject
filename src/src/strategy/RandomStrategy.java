package strategy;


import model.Category;
import model.Die;
import java.util.HashMap;

public class RandomStrategy extends Strategy{
    @Override
    public Die[] rollStrategy(Die[] dice) {
        return new Die[0];
    }

    @Override
    public Category categoryStrategy(HashMap<Category, Integer> validCategories) {
        return null;
    }
}

//Let Rand choose dice to roll
//Then let it randomly select a cattegory.
