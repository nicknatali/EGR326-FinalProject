package model;

public abstract class Player {
    protected String name;
    protected int points = 0;
    protected boolean isTurn;
    protected int wins;
    protected int losses;
    protected ScoreCard scoreCard = new ScoreCard();



    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public void addWin() {
        wins++;
    }

    public int getLosses() {
        return losses;
    }

    public void addLoss() {
        losses++;
    }

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

    public int calculateScore(){
        points = 0;
        for(int each : scoreCard.getScores().values()){
            points += each;
        }
        return points;
    }

    public void reset() {
        points = 0;
        wins = 0;
        losses = 0;
    }

    public void copyPlayerAttributes(Player other){
        //Get other players attributes
        String name = other.getName();
        int wins = other.getWins();
        int losses = other.getLosses();
        int points = other.getPoints();
        boolean isTurn = other.isTurn();
        ScoreCard scoreCard = other.getScoreCard();
        //Copy player values
        this.setName(name);
        this.setPoints(points);
        this.setWins(wins);
        this.setLosses(losses);
        this.setScoreCard(scoreCard);
    }
}
