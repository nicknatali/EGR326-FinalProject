package strategy;


public enum StrategyType {
    RANDOM(), UPPERSECTIONER(), ONEOFAKIND(), FOURANDUP(), SMART();

    public static Strategy toStrategy(StrategyType type){
        switch (type){
            case RANDOM: return new RandomStrategy();
            case UPPERSECTIONER: return new UpperSectionerStrategy();
            case ONEOFAKIND: return new OneOfAKindStrategy();
            case FOURANDUP: return new FourAndUpStrategy();
            case SMART: return new SmartStrategy();
            default: return null;
        }
    }
}
