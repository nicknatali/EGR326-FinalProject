package model;

public class Human extends Player {

    @Override
    public boolean makeMove() {
        return false;
    }

    public Human(String name){
       super(name);
    }

}
