package splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserBalanceSheetController {
    Map<Integer, BalanceSheet> userVsBalanceSheet=new HashMap<>();

    BalanceSheet getUserBalanceSheet(int userId){
        BalanceSheet balanceSheet=userVsBalanceSheet.get(userId);
        if(balanceSheet==null){
            System.out.println("Invalid user id no balance sheet exist");
        }

        return balanceSheet;
    }

    public void addBalanceSheetForUser(int userId,BalanceSheet balanceSheet){
        if(userVsBalanceSheet.containsKey(userId)){
            System.out.println("Balance sheet already exist for user");
        }else{
            userVsBalanceSheet.put(userId,balanceSheet);
        }
    }

    public void updateBalanceSheetOfUsers(Expense expense,List<Split> splits){
        int userWhoPaidId=expense.getPaidByUser().getId();
        for(Split split:splits){
            int id=split.getUser().getId();
            BalanceSheet balanceSheet=userVsBalanceSheet.get(id);
            if(id==userWhoPaidId){

                for(Split splitInstance:splits) {
                    int idOfOtherUser=splitInstance.getUser().getId();
                    if(idOfOtherUser!=userWhoPaidId){
                        balanceSheet.addBalanceSheetRecord(new BalanceSheetRecord(expense,splitInstance.getNumber(),BalanceType.GETBACK,splitInstance.getUser()));
                        double amount=balanceSheet.getTotalAmountGetBack();
                        balanceSheet.setTotalAmountGetBack(amount+splitInstance.getNumber());
                    }
                }
            }else{
                balanceSheet.addBalanceSheetRecord(new BalanceSheetRecord(expense,split.getNumber(),BalanceType.OWES,expense.getPaidByUser()));
                double amount= balanceSheet.getTotalAmountOwe();
                balanceSheet.setTotalAmountOwe(amount+split.getNumber());
            }
        }
    }


}
