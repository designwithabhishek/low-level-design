package parkinglot;

public class PaymentProcessorFactory {
    PaymentProcessor getPaymentProcessor(PaymentProcessorType paymentProcessorType) throws Exception {

        switch (paymentProcessorType) {
            case UPI -> {
                return new UPIPaymentProcessor();
            }
            case CASH -> {
                return new CashPaymentProcessor();
            }
            default -> throw new Exception("Invalid payment type");
        }
    }
}
