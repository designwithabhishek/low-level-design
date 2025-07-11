package splitwise;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> userList;

    UserBalanceSheetController userBalanceSheetController;
    public UserController(UserBalanceSheetController userBalanceSheetController) {
        this.userList = new ArrayList<>();
        this.userBalanceSheetController=userBalanceSheetController;
    }

    public void  addUser(User user){
        userList.add(user);
        userBalanceSheetController.addBalanceSheetForUser(user.getId(), user.getBalanceSheet());
    }

    public User getUser(int id){
        for(User user:userList){
            if(user.getId()==id)
                return user;
        }
        return null;
    }

    public List<User> getUserList() {
        return userList;
    }
}
