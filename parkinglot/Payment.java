package parkinglot;

import java.time.LocalDateTime;

public class Payment {

    double amount;
    LocalDateTime startTime;


    LocalDateTime endTime;

    PaymentStatus paymentStatus;

    public Payment(double amount, LocalDateTime startTime) {
        this.amount = amount;
        this.startTime = startTime;
        this.paymentStatus=PaymentStatus.PENDING;
    }


    public double getAmount() {
        return amount;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }




}
