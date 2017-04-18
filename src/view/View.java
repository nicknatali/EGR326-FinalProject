package view;

import model.YahtzeeGame;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public abstract class View extends JPanel implements Observer {
    private static final long serialVersionUID = 1L;
    protected YahtzeeGame game;

    public View(YahtzeeGame game){
        this.game = game;
        game.addObserver(this);
    }

    public abstract void update(Observable o, Object arg);

    public abstract boolean setState();

    public void goAway(){
        game.deleteObserver(this);
    }
}
