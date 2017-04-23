package util;


import model.Computer;
import model.Human;
import model.Player;
import strategy.*;

public class PlayerFactory {

    public static Player createPlayer(String type){
        switch (type){
            case "Human": return new Human("");
            case "Four & Up": return new Computer("", new FourAndUpStrategy());
            case "One-of-a-Kind": return new Computer("", new OneOfAKindStrategy());
            case "Random": return new Computer("", new RandomStrategy());
            case "Smart": return new Computer("", new SmartStrategy());
            case "Upper-Sectioner": return new Computer("", new UpperSectionerStrategy());
            default: return null;
        }
    }
}
