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
            case 1: return ACES;
            case 2: return TWOS;
            case 3: return THREES;
            case 4: return FOURS;
            case 5: return FIVES;
            case 6: return SIXES;
            default: return null;
        }
    }
}
