package model;

public enum Category {
    ACES(),
    TWOS(),
    THREES(),
    FOURS(),
    FIVES(),
    SIXES(),
    THREEOFAKIND(),
    FOUROFAKIND(),
    FULLHOUSE(),
    SMALLSTRAIGHT(),
    LARGESTRAIGHT(),
    YAHTZEE(),
    CHANCE();

    public static Category fromInteger(int value){
        switch (value){
            case 0: return ACES;
            case 1: return TWOS;
            case 2: return THREES;
            case 3: return FOURS;
            case 4: return FIVES;
            case 5: return SIXES;
            case 6: return THREEOFAKIND;
            case 7: return FOUROFAKIND;
            case 8: return FULLHOUSE;
            case 9: return SMALLSTRAIGHT;
            case 10: return LARGESTRAIGHT;
            case 11: return YAHTZEE;
            case 12: return CHANCE;
            default: return null;
        }
    }

    public String toString(){
        switch (this){
            case ACES: return "Aces";
            case TWOS: return "Twos";
            case THREES: return "Threes";
            case FOURS: return "Fours";
            case FIVES: return "Fives";
            case SIXES: return "Sixes";
            case THREEOFAKIND: return "Three of a Kind";
            case FOUROFAKIND: return "Four of a Kind";
            case FULLHOUSE: return "Full House";
            case SMALLSTRAIGHT: return "Small Straight";
            case LARGESTRAIGHT: return "Large Straight";
            case YAHTZEE: return "Yahtzee";
            case CHANCE: return "Chance";
            default: return "";
        }
    }
}
