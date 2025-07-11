package splitwise;

import java.util.List;

public class ExpenseController {

    UserBalanceSheetController userBalanceSheetController;

    public ExpenseController(UserBalanceSheetController userBalanceSheetController) {
        this.userBalanceSheetController = userBalanceSheetController;
    }

    public Expense createExpense(int id,User user,String description,double totalAmount,List<Split> splits,SplitType splitType,Group group) throws Exception {
       Expense expense=new Expense(id,user,description,totalAmount,splits,splitType,group);
        SplittingStrategy splittingStrategy= SplittingStrategyFactory.getSplittingStrategy(expense.getSplitType());
       List<Split> validatedSplits=splittingStrategy.validateAndComputeSplitAmount(expense);
       userBalanceSheetController.updateBalanceSheetOfUsers(expense,validatedSplits);
       return expense;

    }
}
