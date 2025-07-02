package parkinglot;

public class CashPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(Payment payment) {

        System.out.println("Process payment of "+payment.getAmount()+" through Cash");
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        return true;

    }
}
