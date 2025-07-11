package splitwise;

public class User {
    int id;
    String name;
    String contactNumber;

    BalanceSheet balanceSheet;

    public User(int id, String name, String contactNumber) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        balanceSheet=new BalanceSheet();
    }

    public int getId() {
        return id;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
