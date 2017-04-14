package model;


import logic.ScoreLogic;
import logic.YahtzeeLogic;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Yahtzee {
    private static Yahtzee uniqueInstance;
    YahtzeeLogic logic = new YahtzeeLogic();

    public static Yahtzee getInstance(){
        if(uniqueInstance == null){
            return uniqueInstance = new Yahtzee();
        }
        return uniqueInstance;
    }



    private Yahtzee(){
        logic.getCurrPlayer().setTurn(true);
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        while(!logic.isGameOver()){
            //Alert user it is there turn
            System.out.println("\nIt is " + logic.getCurrPlayer() + " turn!");


            /*
                Let Current Player Role Dice
             */
            for(int i = 0; i < 3; i++) {
                //Roll die initially for each player
                logic.rollDie();
                //Get which dice the user doesn't want to roll
                System.out.print("Die: ");
                for (Die each : logic.getDice()) {
                    System.out.print(each.getValue() + " ");
                }
                if(i < 2) {
                    System.out.print("\nEnter a number: ");
                    String[] n = reader.nextLine().split(",");
                    //break loop if n
                    if(n[0].equals("n")) break;
                    //Set each dice as rollable
                    logic.setDiceRollable();
                    //Set specific dice as unrollable
                    for (String each : n) {
                        logic.getDice()[Integer.parseInt(each) - 1].setRollable(false);
                    }
                } else {
                    logic.setDiceRollable();
                }
            }


            /*
                Allow User to pick which category to put there win in
            */
            ScoreLogic calc = new ScoreLogic();
            //Get all scores from current dice roll
            LinkedHashMap<Category, Integer> scores = calc.generateScores(logic.getDice());
            System.out.println("\n\nSCORES:");
            for(Category each : scores.keySet()){
                System.out.println(each + " : " + scores.get(each));
            }




        }
    }

    public void gameLoop(){

    }
}
