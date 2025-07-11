package splitwise;

public class Split {
    User user;
    double number;

    SplitUnit unit;

    public Split(User user, double number, SplitUnit unit) {
        this.user = user;
        this.number = number;
        this.unit = unit;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public void setUnit(SplitUnit unit) {
        this.unit = unit;
    }

    public User getUser() {
        return user;
    }

    public double getNumber() {
        return number;
    }

    public SplitUnit getUnit() {
        return unit;
    }
}
