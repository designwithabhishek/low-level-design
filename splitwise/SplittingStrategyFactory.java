package splitwise;

public class SplittingStrategyFactory {

    public static SplittingStrategy getSplittingStrategy(SplitType splitType) throws Exception{
        switch (splitType){
            case EQUAL :{
                return new EqualSplitStrategy();
            }
            case UNEQUAL :{ return new UnequalSplitStrategy();}
            case  PERCENTAGE :{ return new PercentageSplitStrategy();}
            default: {
                System.out.println("Invalid split type");
                throw new Exception("Invalid split type");
            }
        }

    }
}
