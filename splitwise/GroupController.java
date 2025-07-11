package splitwise;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groups=new ArrayList<>();

    ExpenseController expenseController;

    public GroupController(ExpenseController expenseController) {
        this.expenseController = expenseController;
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public Group createGroup(int id,String name,User createdBy){
        Group group=new Group(id,name,createdBy,expenseController);
        return group;
    }


}
