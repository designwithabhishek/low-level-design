package parkinglot;

public class UPIPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(Payment payment) {

        System.out.println("Process payment of "+payment.getAmount()+" through UPI ");
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        return true;

    }
}
