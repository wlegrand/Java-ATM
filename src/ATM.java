import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Scanner input;
    private User user;

    public ATM(Bank bank) {
        this.bank = bank;
        this.input = new Scanner(System.in);
        this.user = null;
    }

    public void start() {
        while (user == null) {
            System.out.println("Enter your username:");
            String username = input.nextLine();
            System.out.println("Enter your password:");
            String password = input.nextLine();
            user = bank.login(username, password);
            if (user == null) {
                System.out.println("Invalid username or password");
            }
        }
        int option;
        System.out.println("Welcome to the ATM, " + user.getUsername());
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            option = input.nextInt();
            switch (option) {
                case 1:
                    bank.checkBalance();
                    break;
                case 2:
                    System.out.println("Enter the amount you want to deposit:");
                    int deposit = input.nextInt();
                    input.nextLine();
                    bank.deposit(deposit);
                    System.out.println("Your updated balance is: " + bank.getBalance());
                    break;
                case 3:
                    System.out.println("Enter the amount you want to withdraw:");
                    int withdraw = input.nextInt();
                    input.nextLine();
                    if (bank.withdraw(withdraw)) {
                        System.out.println("Your updated balance is: " + bank.getBalance());
                    } else {
                        System.out.println("Insufficient balance");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option != 4);
        input.close();
    }
}
