import javafx.application.Application;
import javafx.stage.Stage;
import model.YahtzeeGame;

public class YahtzeeMain extends Application {
    //Launch application
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Yahtzee yahtzee = Yahtzee.getInstance();
        YahtzeeGame game = YahtzeeGame.getInstance();
    }
}
