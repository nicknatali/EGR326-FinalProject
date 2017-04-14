import javafx.application.Application;
import javafx.stage.Stage;
import model.ScoreCard;
import model.Yahtzee;
import view.YahtzeeGUI;

public class YahtzeeMain /*extends Application*/ {
    //Launch application

    /*
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        Yahtzee yahtzee = new Yahtzee();
        YahtzeeGUI game = new YahtzeeGUI();
    }
    */
    public static void main(String[] args){
        Yahtzee yahtzee = Yahtzee.getInstance();
    }
}
