package splitwise;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Group {

    List<User> users;
    int id;

    String name;

    User createdBy;

    List<Expense> expenses;

    LocalDateTime createdAt;

    ExpenseController expenseController;

    public Group(int id, String name,User createdBy,ExpenseController expenseController) {
        users=new ArrayList<>();
        this.id = id;
        this.name = name;
        expenses=new ArrayList<>();
        createdAt=LocalDateTime.now();
        this.expenseController =expenseController;
        this.createdBy=createdBy;
    }

    public Expense addExpense(int id ,User user,String description,double totalAmount,List<Split> splits,SplitType splitType) throws Exception {
        Expense expense=expenseController.createExpense(id,user,description,totalAmount,splits,splitType,this);
        expenses.add(expense);
        return expense;
    }

    public void addUser(User user){
        users.add(user);
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }
    public List<Expense> getExpenses() {
        return expenses;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
