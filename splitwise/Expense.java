package splitwise;

import java.time.LocalDateTime;
import java.util.List;

public class Expense {
    int id;
    User paidByUser;
    String description;

    double totalAmount;

    List<Split> splittingCriteria;

    SplitType splitType;

    LocalDateTime createdAt;

    Group group;

    public Expense(int id, User paidByUser, String description, double totalAmount, List<Split> splittingCriteria, SplitType splitType,Group group) {
        this.id = id;
        this.paidByUser = paidByUser;
        this.description = description;
        this.totalAmount = totalAmount;
        this.splittingCriteria = splittingCriteria;
        this.splitType = splitType;
        this.group=group;
        createdAt=LocalDateTime.now();
    }


    public int getId() {
        return id;
    }

    public User getPaidByUser() {
        return paidByUser;
    }

    public String getDescription() {
        return description;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<Split> getSplittingCriteria() {
        return splittingCriteria;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Group getGroup() {
        return group;
    }
}
