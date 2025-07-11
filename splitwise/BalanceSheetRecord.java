package splitwise;

public class BalanceSheetRecord {

    Expense expense;

    double amount;

    BalanceType balanceType;

    User user;

    public BalanceSheetRecord( Expense expense, double amount, BalanceType balanceType,User user) {
        this.expense = expense;
        this.amount = amount;
        this.balanceType = balanceType;
        this.user=user;
    }


    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public double getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }
}
