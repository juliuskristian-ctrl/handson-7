import java.util.Random;
import java.util.ArrayList;
import java.util.Date;

public class InstanceMembersPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Instance Variables & Methods
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * instance variables, instance methods, dan perbedaannya dengan static.
         */

        // ===== INSTANCE VARIABLES BASICS =====
        System.out.println("=== INSTANCE VARIABLES BASICS ===");

        // Latihan 1: Memahami instance variables
        // Buat beberapa object dari class BankAccount
        // Tunjukkan bahwa setiap object memiliki data sendiri

        // Buat 3 object BankAccount dengan data berbeda
        BankAccount acc1 = new BankAccount("1001", "Alice", 1500.0, "Savings");
        BankAccount acc2 = new BankAccount("1002", "Bob", 750.0, "Checking");
        BankAccount acc3 = new BankAccount("1003", "Charlie", 2500.0, "Savings");

        // Tampilkan saldo masing-masing account
        System.out.println("Initial Balances:");
        acc1.displayBalance();
        acc2.displayBalance();
        acc3.displayBalance();

        // Lakukan transaksi pada masing-masing account
        System.out.println("\n--- Performing Transactions ---");
        acc1.deposit(200.0);
        acc2.withdraw(100.0);
        acc3.deposit(500.0);

        // Tunjukkan bahwa perubahan pada satu object tidak mempengaruhi yang lain
        System.out.println("\nBalances After Transactions:");
        acc1.displayBalance();
        acc2.displayBalance();
        acc3.displayBalance();


        // ===== INSTANCE METHODS ADVANCED =====
        System.out.println("\n=== INSTANCE METHODS ADVANCED ===");

        // Latihan 2: Instance methods yang bekerja dengan instance variables
        // Implementasikan berbagai jenis instance methods
        // Methods yang mengubah state object
        // Methods yang mengembalikan nilai berdasarkan state
        // Methods yang berinteraksi dengan object lain

        // Demonstrasikan berbagai jenis instance methods
        System.out.println("\n--- Demonstrating Instance Methods ---");

        System.out.println("Account Info for " + acc1.getAccountHolderName() + ":");
        acc1.getAccountInfo();
        System.out.println("Is " + acc1.getAccountHolderName() + "'s account active? " + acc1.isActive());

        System.out.println("\nDeactivating " + acc2.getAccountHolderName() + "'s account.");
        acc2.deactivateAccount();
        System.out.println("Is " + acc2.getAccountHolderName() + "'s account active? " + acc2.isActive());
        acc2.withdraw(50.0);

        System.out.println("\nCalculating potential interest for " + acc3.getAccountHolderName() + " (rate 0.02):");
        double interest = acc3.calculateInterest(0.02);
        System.out.println("Calculated Interest: " + interest);
        System.out.println("New Balance after interest: " + (acc3.getBalance() + interest));


        // ===== METHOD INTERACTION =====
        System.out.println("\n=== METHOD INTERACTION ===");

        // Latihan 3: Methods yang memanggil methods lain
        // Buat methods yang memanggil methods lain dalam class yang sama
        // Demonstrasikan method chaining

        // Implementasikan method chaining dan interaction
        System.out.println("\n--- Demonstrating Method Interaction (printStatement) ---");
        acc1.printStatement();

        System.out.println("\n--- Demonstrating Method Interaction (canWithdraw) ---");
        System.out.println(acc1.getAccountHolderName() + " can withdraw $100? " + acc1.canWithdraw(100.0));
        System.out.println(acc1.getAccountHolderName() + " can withdraw $5000? " + acc1.canWithdraw(5000.0));
        acc1.withdraw(100.0);
        System.out.println("Balance after withdraw: " + acc1.getBalance());
        System.out.println(acc1.getAccountHolderName() + " can withdraw $100? " + acc1.canWithdraw(100.0));


        // ===== OBJECT COLLABORATION =====
        System.out.println("\n=== OBJECT COLLABORATION ===");

        // Latihan 4: Object yang berinteraksi dengan object lain
        // Implementasikan transfer uang antar account
        // Buat history transaksi

        // Implementasikan object collaboration
        System.out.println("\n--- Demonstrating Object Collaboration (Transfer) ---");
        System.out.println("Initial balances before transfer:");
        acc1.displayBalance();
        acc2.displayBalance();

        System.out.println("\n" + acc1.getAccountHolderName() + " transfer $300 to " + acc2.getAccountHolderName() + ".");
        acc1.transfer(acc2, 300.0);

        System.out.println("\nBalances after transfer:");
        acc1.displayBalance();
        acc2.displayBalance();

        System.out.println("\n--- Transaction History for " + acc1.getAccountHolderName() + " ---");
        for (Transaction t : acc1.getTransactionHistory()) {
            System.out.println(t.getFormattedTransaction());
        }

        System.out.println("\n--- Transaction History for " + acc2.getAccountHolderName() + " ---");
        for (Transaction t : acc2.getTransactionHistory()) {
            System.out.println(t.getFormattedTransaction());
        }

        System.out.println("\n--- Customer Accounts ---");
        Customer customer1 = new Customer("CUST001", "Eva", "08123456789", "eva@mail.com");
        customer1.addAccount(acc1);
        customer1.addAccount(acc3);
        customer1.displayCustomerInfo();
        customer1.displayAllAccounts();

        System.out.println("\n--- Deposit via Customer object for " + customer1.getName() + "'s account " + acc1.getAccountNumber() + " ---");
        customer1.depositToAccount(acc1.getAccountNumber(), 100.0);
        acc1.displayBalance();
    }
}

// ===== CLASS DEFINITIONS =====

// Implementasikan class BankAccount
class BankAccount {
    // Instance variables
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private boolean isActive;
    private ArrayList<Transaction> transactionHistory;

    // Constructor(s)
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.isActive = true;
        this.transactionHistory = new ArrayList<>();
        addTransaction("OPEN", initialBalance, "Account opened with initial deposit.");
    }

    public BankAccount(String accountNumber, String accountHolderName) {
        this(accountNumber, accountHolderName, 0.0, "Savings");
    }

    // Instance methods untuk account operations
    public void deposit(double amount) {
        if (!isActive) {
            System.out.println("Error: Account " + accountNumber + " is inactive. Cannot deposit.");
            return;
        }
        if (amount > 0) {
            this.balance += amount;
            addTransaction("DEPOSIT", amount, "Deposit successful.");
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (!isActive) {
            System.out.println("Error: Account " + accountNumber + " is inactive. Cannot withdraw.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return;
        }
        if (this.balance >= amount) {
            this.balance -= amount;
            addTransaction("WITHDRAW", amount, "Withdrawal successful.");
        } else {
            System.out.println("Error: Insufficient funds for withdrawal. Current balance: " + this.balance);
        }
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (!isActive) {
            System.out.println("Error: Your account " + this.accountNumber + " is inactive. Cannot transfer.");
            return;
        }
        if (!targetAccount.isActive) {
            System.out.println("Error: Target account " + targetAccount.getAccountNumber() + " is inactive. Cannot transfer.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Error: Transfer amount must be positive.");
            return;
        }
        if (this.balance >= amount) {
            this.balance -= amount;
            targetAccount.balance += amount;
            addTransaction("TRANSFER_OUT", amount, "Transfer to " + targetAccount.getAccountNumber());
            targetAccount.addTransaction("TRANSFER_IN", amount, "Transfer from " + this.accountNumber);
            System.out.println("Transfer of " + amount + " from " + this.accountNumber + " to " + targetAccount.getAccountNumber() + " successful.");
        } else {
            System.out.println("Error: Insufficient funds for transfer. Current balance: " + this.balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public boolean isActive() {
        return isActive;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void getAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
    }

    public void activateAccount() {
        this.isActive = true;
        System.out.println("Account " + accountNumber + " activated.");
    }

    public void deactivateAccount() {
        this.isActive = false;
        System.out.println("Account " + accountNumber + " deactivated.");
    }

    // Instance methods untuk business logic
    public double calculateInterest(double rate) {
        if (this.accountType.equals("Savings") && isActive) {
            return this.balance * rate;
        }
        return 0.0;
    }

    public boolean canWithdraw(double amount) {
        return isActive && this.balance >= amount;
    }

    public String getAccountStatus() {
        return isActive ? "Active" : "Inactive";
    }

    // Instance methods untuk formatting/display
    public void displayBalance() {
        System.out.printf("Account %s (%s): Balance = $%.2f%n", accountNumber, accountHolderName, balance);
    }

    public void printStatement() {
        System.out.println("\n--- Statement for Account " + accountNumber + " ---");
        getAccountInfo();
        System.out.printf("Current Balance: $%.2f%n", balance);
        System.out.println("--- Transaction History ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction t : transactionHistory) {
                System.out.println(t.getFormattedTransaction());
            }
        }
        System.out.println("--- End of Statement ---");
    }

    private void addTransaction(String type, double amount, String description) {
        Random random = new Random();
        String id = String.format("%04d", random.nextInt(10000));
        transactionHistory.add(new Transaction("TRX" + id, type, amount, new Date(), description));
    }
}

// Implementasikan class Transaction (untuk history)
class Transaction {
    private String transactionId;
    private String type;
    private double amount;
    private Date timestamp;
    private String description;

    // Constructor
    public Transaction(String transactionId, String type, double amount, Date timestamp, String description) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.description = description;
    }

    // Getters
    public String getTransactionId() { return transactionId; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public Date getTimestamp() { return timestamp; }
    public String getDescription() { return description; }

    // Method untuk menampilkan transaksi dalam format tertentu
    public String getFormattedTransaction() {
        return String.format("[%s] %s: $%.2f - %s (%s)", timestamp.toString(), type, amount, description, transactionId);
    }
}

// Implementasikan class Customer
class Customer {
    private String customerId;
    private String name;
    private String phone;
    private String email;
    private ArrayList<BankAccount> accounts;

    public Customer(String customerId, String name, String phone, String email) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.accounts = new ArrayList<>();
    }

    // Methods untuk mengelola multiple accounts
    public void addAccount(BankAccount account) {
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public void removeAccount(String accountNumber) {
        accounts.removeIf(acc -> acc.getAccountNumber().equals(accountNumber));
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void displayCustomerInfo() {
        System.out.println("\n--- Customer Info ---");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Number of Accounts: " + accounts.size());
    }

    public void displayAllAccounts() {
        System.out.println("\n--- Accounts for " + name + " ---");
        if (accounts.isEmpty()) {
            System.out.println("No accounts linked.");
        } else {
            for (BankAccount acc : accounts) {
                acc.getAccountInfo();
                acc.displayBalance();
                System.out.println("---");
            }
        }
    }

    public void depositToAccount(String accountNumber, double amount) {
        BankAccount targetAcc = getAccount(accountNumber);
        if (targetAcc != null) {
            targetAcc.deposit(amount);
        } else {
            System.out.println("Error: Account " + accountNumber + " not found for " + name);
        }
    }

    public String getName() {
        return name;
    }
}