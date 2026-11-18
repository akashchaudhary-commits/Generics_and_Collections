package Collections_Practice;
import java.util.Scanner;
import java.util.ArrayList;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        setBalance(balance);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        if (balance >= 0.0) {
            this.balance = balance;
        } else {
            this.balance = 0.0;
        }
    }

    protected void setRawBalance(double balance) {
        this.balance = balance; // Allows negative balance for overdraft
    }

    public void deposit(double amount) {
        if (amount > 0.0) {
            this.balance += amount;
        }
    }

    public abstract void processMonthlyInterest();
    public abstract boolean withdraw(double amount);

    public void displaySummary() {
        System.out.printf("%s, %s, %.2f\n", accountNumber, holderName, balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void processMonthlyInterest() {
        double monthlyInterest = getBalance() * (interestRate / 100.0) / 12.0;
        deposit(monthlyInterest);
    }

    @Override
    public boolean withdraw(double amount) {
        if ((getBalance() - amount) >= 500.0) {
            setRawBalance(getBalance() - amount);
            return true;
        }
        return false;
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void processMonthlyInterest() {
        if (getBalance() < 0.0) {
            double penalty = Math.abs(getBalance()) * 0.02;
            setRawBalance(getBalance() - penalty);
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if ((getBalance() - amount) >= -overdraftLimit) {
            setRawBalance(getBalance() - amount);
            return true;
        }
        return false;
    }
}

class BankBranch {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount acc) {
        accounts.add(acc);
    }

    public void executeBatchDeposit(double amount) {
        for (BankAccount acc : accounts) {
            acc.deposit(amount);
        }
    }

    public void applyBatchInterest() {
        for (BankAccount acc : accounts) {
            acc.processMonthlyInterest();
        }
    }

    public void processWithdrawal(String accNo, double amount) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNo)) {
                acc.withdraw(amount);
                break;
            }
        }
    }

    public void auditAccounts() {
        double totalBalance = 0.0;
        int savingsCount = 0;
        int currentCount = 0;

        for (BankAccount acc : accounts) {
            totalBalance += acc.getBalance();
            if (acc instanceof SavingsAccount) {
                savingsCount++;
            } else if (acc instanceof CurrentAccount) {
                currentCount++;
            }
        }

        System.out.printf("Total Branch Balance: %.2f\n", totalBalance);
        System.out.println("Savings Accounts: " + savingsCount);
        System.out.println("Current Accounts: " + currentCount);
    }

    public void printAllSummaries() {
        for (BankAccount acc : accounts) {
            acc.displaySummary();
        }
    }
}

public class Ques3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        BankBranch branch = new BankBranch();

        for (int i = 0; i < n; i++) {
            String type = scanner.nextLine().trim().toUpperCase();
            String accNo = scanner.nextLine().trim();
            String name = scanner.nextLine().trim();
            double balance = Double.parseDouble(scanner.nextLine().trim());

            if (type.equals("SAVINGS")) {
                double rate = Double.parseDouble(scanner.nextLine().trim());
                branch.addAccount(new SavingsAccount(accNo, name, balance, rate));
            } else if (type.equals("CURRENT")) {
                double overdraft = Double.parseDouble(scanner.nextLine().trim());
                branch.addAccount(new CurrentAccount(accNo, name, balance, overdraft));
            }
        }

        double batchDeposit = Double.parseDouble(scanner.nextLine().trim());
        String wAccNo = scanner.nextLine().trim();
        double wAmount = Double.parseDouble(scanner.nextLine().trim());

        branch.executeBatchDeposit(batchDeposit);
        branch.processWithdrawal(wAccNo, wAmount);
        branch.applyBatchInterest();

        branch.auditAccounts();
        branch.printAllSummaries();

    }
}
