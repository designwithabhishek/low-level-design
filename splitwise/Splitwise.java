package splitwise;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {


    static UserBalanceSheetController userBalanceSheetController=new UserBalanceSheetController();
    static ExpenseController expenseController=new ExpenseController(userBalanceSheetController);

    static GroupController groupController=new GroupController(expenseController);
    static UserController userController=new UserController(userBalanceSheetController);

    public static void main(String[] args) throws Exception {


        // create User
        User abhi=new User(1,"Abhi","8712129920");
        User adam=new User(2,"Adam","8712129929");
        User chris=new User(3,"Chris","8712129930");

        userController.addUser(abhi);
        userController.addUser(adam);
        userController.addUser(chris);


        // Create Group and add friends in it
       Group friends= initialiseGroup(1,"Friends",userController.getUserList(),userController.getUser(1));

        // Expense and Split

        Split split1=new Split(abhi,1000,SplitUnit.AMOUNT);
        Split split2=new Split(adam,1000,SplitUnit.AMOUNT);
        Split split3=new Split(chris,1000,SplitUnit.AMOUNT);
        List<Split> splits=new ArrayList<>();
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);


        friends.addExpense(1,abhi,"Dinner at oberoi",3000,splits,SplitType.EQUAL);

        // get abhi balance sheet

        BalanceSheet balanceSheet=userBalanceSheetController.getUserBalanceSheet(abhi.getId());
        balanceSheet.showAllBalanceSheetRecords(abhi);
        balanceSheet.showBalanceSummary(abhi);


        BalanceSheet balanceSheetOfAdam=userBalanceSheetController.getUserBalanceSheet(adam.getId());
        balanceSheetOfAdam.showAllBalanceSheetRecords(adam);
        balanceSheetOfAdam.showBalanceSummary(adam);

        BalanceSheet balanceSheetOfChris=userBalanceSheetController.getUserBalanceSheet(chris.getId());
        balanceSheetOfChris.showAllBalanceSheetRecords(chris);
        balanceSheetOfChris.showBalanceSummary(chris);

        System.out.println("2nd Request --------------------------- ");

        // 2nd request to split between 2 people

        Split split4=new Split(abhi,5000,SplitUnit.AMOUNT);
        Split split5=new Split(adam,5000,SplitUnit.AMOUNT);

        List<Split> splits2=new ArrayList<>();
        splits2.add(split4);
        splits2.add(split5);

        friends.addExpense(2,adam,"Lunch",10000,splits2,SplitType.EQUAL);


        balanceSheet.showBalanceSummary(abhi);

        balanceSheetOfChris.showBalanceSummary(chris);

        balanceSheetOfAdam.showBalanceSummary(adam);

    }

    static Group initialiseGroup(int groupId,String groupName,List<User> users,User createdBy){

        Group friends=groupController.createGroup(groupId,groupName,createdBy);


        for(User user:users){
            friends.addUser(user);
        }

        return friends;

    }


}
