public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        User user1 = new User("user1", "password1");
        bank.addUser(user1);


        ATM atm = new ATM(bank);
        atm.start();
    }
}
