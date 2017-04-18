import logic.ScoreLogic;
import model.Category;
import model.Computer;
import model.Die;
import model.YahtzeeGame;
import org.junit.Test;
import strategy.StrategyType;

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

    @Test
    public void RandomStrategyTest(){
        YahtzeeGame game = YahtzeeGame.getInstance();
        game.rollDice();

        System.out.print("*** ");
        for(Die die : game.getDice()) System.out.print(die.getValue() + " ");
        System.out.println();

        Computer computer = new Computer("Bob", StrategyType.RANDOM);
        computer.makeMove(game);

        for(int i = 0; i < 13; i++){
            System.out.println(Category.fromInteger(i) + " - " + computer.getScoreCard().getScore(Category.fromInteger(i)));
        }
    }

}
