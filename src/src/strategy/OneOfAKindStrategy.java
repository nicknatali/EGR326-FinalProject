package strategy;


import model.Category;
import model.Die;
import java.util.HashMap;

public class OneOfAKindStrategy extends Strategy{
    @Override
    public Die[] rollStrategy(Die[] dice) {
        return new Die[0];
    }

    @Override
    public Category categoryStrategy(HashMap<Category, Integer> validCategories) {
        return null;
    }

    //Create an array of the die that have been picked
    //Loop through each die
    //If the die number == a value increment a dif array that holds
    //The amount ofAKind for that value

    //Reuse the code of them selecting a category.





}
