package logic;


import model.Die;
import model.Human;
import model.Player;

public class YahtzeeLogic {
    Player[] players = {new Human("p1"), new Human("p2")};
    Player currPlayer = players[0];
    Die[] dice = {new Die(), new Die(), new Die(), new Die(), new Die()};


    public Die[] rollDie(){
        for(int i = 0; i < dice.length; i++){
            if(dice[i].isRollable()){
                dice[i].rollDie();
            }
        }
        return dice;
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

    public void setDiceRollable(){
        for(int i = 0; i < dice.length; i++){ dice[i].setRollable(true); }
    }

    public void swapCurrentPlayer(){
        currPlayer = currPlayer == players[0] ? players[1] : players[0];
    }

    public void resetGame(){
        currPlayer = players[0];
        Die[] dice = {new Die(), new Die(), new Die(), new Die(), new Die()};
    }
}
