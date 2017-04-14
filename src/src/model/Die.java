package model;


import java.util.Random;

public class Die {
    int value;
    boolean rollable = true;


    public Die(){}
    public Die(int value){ this.value = value; }


    public boolean isRollable() {
        return rollable;
    }


    public void setRollable(boolean rollable) {
        this.rollable = rollable;
    }


    public int rollDie(){
        Random random = new Random();
        value = random.nextInt(5)+1;
        return value;
    }


    public void setValue(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
