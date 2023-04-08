import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<User> users;
    private int balance;

    public Bank() {
        this.balance = 0;
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int deposit) {
        balance += deposit;
    }

    public boolean withdraw(int withdraw) {
        if (withdraw > balance) {
            return false;
        } else {
            balance -= withdraw;
            return true;
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }
}
