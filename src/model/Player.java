package model;

public abstract class Player {
    protected String name;
    protected int points = 0;
    protected boolean isTurn;
    protected ScoreCard scoreCard = new ScoreCard();




    public abstract boolean makeMove();

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    protected Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ScoreCard getScoreCard() {
        return scoreCard;
    }

    public void setScoreCard(ScoreCard scoreCard) {
        this.scoreCard = scoreCard;
    }

    public void calculateScore(){
        //TODO:
    }

    public void reset() { points = 0; }
}
