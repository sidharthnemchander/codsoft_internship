import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("The withdrawl is sucessful!!!!");
            return true;
        } else {
            System.out.println("You don't have enough balance!!!");
            return false;
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Please enter your withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0) {
                        bankAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid withdrawal amount.");
                    }
                    break;

                case 2:
                    System.out.print("Please enter your deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        bankAccount.deposit(depositAmount);
                        System.out.println("Your money is sucessfully deposited!");
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.println("Your current balance: $" + bankAccount.getBalance());
                    break;

                case 4:
                    System.out.println(" Thank you for using our ATM! ");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

public class THEATM {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(0.0);

        ATM atm = new ATM(bankAccount);

        atm.run();
    }
}
