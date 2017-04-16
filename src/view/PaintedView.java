package view;


import model.YahtzeeGame;

import java.util.Observable;

public class PaintedView extends View{

    public PaintedView(YahtzeeGame game){
        super(game);
    }

    public View createView(){
        return null;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
