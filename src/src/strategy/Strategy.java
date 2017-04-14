package strategy;


import model.Category;
import model.Die;
import java.util.HashMap;

public abstract class Strategy {

    public abstract Die[] rollStrategy(Die[] dice);

    public abstract Category categoryStrategy(HashMap<Category, Integer> validCategories);

}
