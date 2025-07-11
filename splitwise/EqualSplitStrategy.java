package splitwise;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplittingStrategy{
    @Override
    public List<Split> validateAndComputeSplitAmount(Expense expense) {
        double totalAmount=expense.getTotalAmount();
        List<Split> splits=new ArrayList<>(expense.getSplittingCriteria());
        int numberOfUsers=splits.size();
        double amountToPayByEachValidUser=totalAmount/numberOfUsers;

        for(Split split:splits)
        {
            if(split.getUnit()==SplitUnit.AMOUNT){
                if(split.getNumber()!=amountToPayByEachValidUser){
                    split.setNumber(amountToPayByEachValidUser);
                    split.setUnit(SplitUnit.AMOUNT);
                }
            }else {
                double amount=(split.getNumber()*totalAmount)/100;
                if(amount!=amountToPayByEachValidUser){
                    split.setNumber(amountToPayByEachValidUser);
                    split.setUnit(SplitUnit.AMOUNT);
                }
            }
        }
        return splits;
    }
}
