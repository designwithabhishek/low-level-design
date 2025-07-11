package splitwise;

import java.util.ArrayList;
import java.util.List;

public class BalanceSheet {
    List<BalanceSheetRecord> balanceSheetRecords=new ArrayList<>();
     double totalAmountOwe;
     double totalAmountGetBack;

    public  void addBalanceSheetRecord(BalanceSheetRecord balanceSheetRecord){
        balanceSheetRecords.add(balanceSheetRecord);
    }
    public double getTotalAmountOwe() {
        return totalAmountOwe;
    }

    public void setTotalAmountOwe(double totalAmountOwe) {
        this.totalAmountOwe = totalAmountOwe;
    }

    public double getTotalAmountGetBack() {
        return totalAmountGetBack;
    }

    public void setTotalAmountGetBack(double totalAmountGetBack) {
        this.totalAmountGetBack = totalAmountGetBack;
    }

    public void showAllBalanceSheetRecords(User user){
        for(BalanceSheetRecord balanceSheetRecord:balanceSheetRecords){
            if(balanceSheetRecord.getBalanceType()==BalanceType.OWES)
            {
                System.out.println(user.getName()+" "+balanceSheetRecord.getBalanceType()+" "+balanceSheetRecord.getAmount()+" to "+balanceSheetRecord.getUser().getName()+" for "+ balanceSheetRecord.getExpense().getDescription());
            }else{
                System.out.println(user.getName()+" "+balanceSheetRecord.getBalanceType()+" "+balanceSheetRecord.getAmount()+" from "+balanceSheetRecord.getUser().getName()+" for "+ balanceSheetRecord.getExpense().getDescription());
            }
        }
    }

    public void showBalanceSummary(User user){
        System.out.println(user.getName()+" balance summary: ");
        System.out.println("Total Amount Owe: "+totalAmountOwe);
        System.out.println("Total Amount getback: "+totalAmountGetBack);
    }
}
