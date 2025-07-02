package parkinglot;

public class ComputePriceFactory {

    static PriceStrategy getComputingPriceStrategy(VehicleType vehicleType) throws Exception {
        switch (vehicleType){
            case vehicleType.TWO_WHEELER :{
                return new HourlyPriceStrategy();
            }

            case vehicleType.FOUR_WHEELER:{
                return  new MinutePriceStrategy();
            }
            default:{throw  new Exception("In correct vehicle type cant chose price strategy");}
        }
    }
}
