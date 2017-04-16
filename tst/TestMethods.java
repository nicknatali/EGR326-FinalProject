import logic.ScoreLogic;
import model.Category;
import model.Die;
import org.junit.Test;

import java.util.LinkedHashMap;

public class TestMethods {
    @Test
    public void ScoreLogicTest(){
        ScoreLogic logic = new ScoreLogic();
        Die[] dice = {new Die(2), new Die(4), new Die(3), new Die(1), new Die(4)};
        //Get all scores from current dice roll
        LinkedHashMap<Category, Integer> scores = logic.generateScores(dice);
        //Print scores
        System.out.println("\n\nSCORES:");
        for(Category each : scores.keySet()) System.out.println(each + " : " + scores.get(each));
    }

}
