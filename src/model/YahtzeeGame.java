package model;

import logic.ScoreLogic;
import logic.Yahtzee;
import strategy.StrategyType;
import view.YahtzeeGUI;

import java.util.LinkedHashMap;
import java.util.Observable;

public class YahtzeeGame extends Observable{
    //This unique instance of the yahtzee game
    private static YahtzeeGame uniqueInstance = null;

    private YahtzeeGUI gui;
    private Player[] players = {new Human("Player 1"), new Human("Player 2")};
    private Player currPlayer = players[0];
    private Die[] dice = {new Die(), new Die(), new Die(), new Die(), new Die()};
    private ScoreLogic currScores = new ScoreLogic();
    private boolean isStarted = false;
    private int rerolls = 0;

    public static YahtzeeGame getInstance(){
        if(uniqueInstance == null){
            return uniqueInstance = new YahtzeeGame();
        }
        return uniqueInstance;
    }

    private YahtzeeGame(){
       this.gui = new YahtzeeGUI(this);
    }


    public YahtzeeGUI getGui() { return gui; }
    public boolean isStarted() { return isStarted; }
    public void setStarted(boolean started) { isStarted = started; }

    public Die[] rollDice(){
        //If the dice has been rolled less than 2 times
        if(isPlayerAbleToRoll()) {
            //Roll each die if rollable
            for (int i = 0; i < dice.length; i++) {
                if(dice[i].isRollable()) dice[i].rollDie();
            }
            //Increment rerolls
            rerolls++;
        }
        //Return dice
        return dice;
    }

    public boolean isPlayerAbleToRoll() { return rerolls < 3; }

    public LinkedHashMap<Category, Integer> getCurrScores() {
        return currScores.generateScores(dice);
    }

    public int getRerolls() {
        return rerolls;
    }

    public void resetRerolls() {
        this.rerolls = 0;
    }

    public boolean isGameOver(){
        return players[0].getScoreCard().isCardFull() && players[1].getScoreCard().isCardFull();
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getCurrPlayer() {
        return currPlayer;
    }

    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }

    public Die[] getDice() {
        return dice;
    }

    public void setDice(Die[] dice) {
        this.dice = dice;
    }

    public void setDiceRollState(boolean rollable){
        for(int i = 0; i < dice.length; i++){ dice[i].setRollable(rollable); }
    }

    public void swapCurrentPlayer(){ setCurrPlayer(currPlayer == players[0] ? players[1] : players[0]); }

    public void resetGame(){
        setCurrPlayer(getPlayers()[0]);
        getPlayers()[0].setScoreCard(new ScoreCard());
        getPlayers()[1].setScoreCard(new ScoreCard());
        rerolls = 0;
    }

    public Player declareWinner(){
        //Get current scores
        int p1Score = getPlayers()[0].calculateScore();
        int p2Score = getPlayers()[1].calculateScore();
        //Compare and return winner
        if(p1Score > p2Score) {
            getPlayers()[0].addWin();
            getPlayers()[1].addLoss();
            return getPlayers()[0];
        }
        else if(p1Score < p2Score) {
            getPlayers()[1].addWin();
            getPlayers()[0].addLoss();
            return getPlayers()[1];
        }
        else
            return null;
    }
}
