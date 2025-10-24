import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccessModifiersPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Access Modifiers & Encapsulation
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * access modifiers, encapsulation, dan data protection.
         */

        // ===== MASALAH DENGAN PUBLIC VARIABLES =====
        System.out.println("=== MASALAH DENGAN PUBLIC VARIABLES ===");

        // Latihan 1: Tunjukkan masalah dengan public instance variables
        // Buat object dengan public variables
        // Tunjukkan bagaimana data bisa dirusak dari luar

        BadExample badPerson = new BadExample("Andi", 30, 5000000.0, "andi@contoh.com");
        System.out.println("Data awal BadExample:");
        badPerson.displayData();

        System.out.println("\nMencoba merusak data secara langsung:");
        badPerson.age = -5;
        badPerson.salary = -1000000.0;
        badPerson.email = "bukan email";
        badPerson.name = null;

        System.out.println("Data BadExample yang rusak:");
        badPerson.displayData();
        System.out.println("Masalah: Data dapat diubah dengan sembarangan tanpa validasi, menyebabkan inkonsistensi.");


        // ===== ENCAPSULATION SOLUTION =====
        System.out.println("\n=== ENCAPSULATION SOLUTION ===");

        // Latihan 2: Implementasi encapsulation
        // Gunakan private variables dengan getter/setter
        // Tambahkan validasi dalam setter

        GoodExample goodPerson = new GoodExample("Budi", 25, 6000000.0, "budi@contoh.com");
        System.out.println("Data awal GoodExample:");
        System.out.println("Nama: " + goodPerson.getName());
        System.out.println("Usia: " + goodPerson.getAge());
        System.out.println("Gaji: " + goodPerson.getSalary());
        System.out.println("Email: " + goodPerson.getEmail());

        System.out.println("\nMencoba mengatur data yang tidak valid menggunakan setter:");
        goodPerson.setAge(-10);
        goodPerson.setSalary(-500000.0);
        goodPerson.setEmail("email.tidak.valid");
        goodPerson.setName("");
        goodPerson.setName(null);

        System.out.println("\nMencoba mengatur data yang valid menggunakan setter:");
        goodPerson.setAge(35);
        goodPerson.setSalary(7500000.0);
        goodPerson.setEmail("budi.update@contoh.com");
        goodPerson.setName("Budi Santoso");

        System.out.println("\nData GoodExample yang diperbarui:");
        System.out.println("Nama: " + goodPerson.getName());
        System.out.println("Usia: " + goodPerson.getAge());
        System.out.println("Gaji: " + goodPerson.getSalary());
        System.out.println("Email: " + goodPerson.getEmail());
        System.out.println("Apakah usia pensiun? " + goodPerson.isRetirementAge());


        // ===== ACCESS MODIFIER COMBINATIONS =====
        System.out.println("\n=== ACCESS MODIFIER COMBINATIONS ===");

        // Latihan 3: Berbagai kombinasi access modifiers
        // Tunjukkan perbedaan private, public, protected, default

        AccessModifierDemo demo = new AccessModifierDemo();
        System.out.println("Mengakses field dari package yang sama (kelas utama):");
        // System.out.println("Private field: " + demo.privateField);
        System.out.println("Protected field: " + demo.protectedField);
        System.out.println("Default field: " + demo.defaultField);
        System.out.println("Public field: " + demo.publicField);

        System.out.println("\nMemanggil method dari package yang sama (kelas utama):");
        // demo.privateMethod();
        demo.protectedMethod();
        demo.defaultMethod();
        demo.publicMethod();

        System.out.println("\nMenguji akses dari dalam kelas AccessModifierDemo:");
        demo.testAccess();


        // ===== GETTER/SETTER BEST PRACTICES =====
        System.out.println("\n=== GETTER/SETTER BEST PRACTICES ===");

        // Latihan 4: Implementasi getter/setter yang proper
        // Naming conventions
        // Validation dalam setter
        // Read-only dan write-only properties

        BankAccountSecure myAccount = new BankAccountSecure("1234567890", 1000000.0, "1234");
        System.out.println("Nomor Akun (Read-only): " + myAccount.getAccountNumber());
        System.out.println("Saldo Awal: " + myAccount.checkBalance("1234"));
        System.out.println("Status Akun: " + myAccount.getAccountStatus());

        System.out.println("\n--- Menguji Setoran dan Penarikan ---");
        myAccount.deposit(500000.0);
        myAccount.deposit(-100000.0);
        System.out.println("Saldo setelah setoran: " + myAccount.checkBalance("1234"));

        myAccount.withdraw(200000.0, "1234");
        myAccount.withdraw(2000000.0, "1234");
        myAccount.withdraw(100000.0, "pin_salah");
        System.out.println("Saldo setelah penarikan: " + myAccount.checkBalance("1234"));

        System.out.println("\n--- Menguji Perubahan PIN ---");
        myAccount.changePin("pin_lama_salah", "4321");
        myAccount.changePin("1234", "4321");
        System.out.println("Saldo dengan PIN baru: " + myAccount.checkBalance("4321"));
        System.out.println("Saldo dengan PIN lama: " + myAccount.checkBalance("1234"));

        System.out.println("\n--- Menguji Penguncian Akun ---");
        myAccount.withdraw(100000.0, "pin_salah_coba1");
        myAccount.withdraw(100000.0, "pin_salah_coba2");
        myAccount.withdraw(100000.0, "pin_salah_coba3");
        System.out.println("Status Akun setelah beberapa kali PIN salah: " + myAccount.getAccountStatus());
        myAccount.deposit(100000.0);
    }
}

// ===== CLASS DEFINITIONS =====

class BadExample {
    public String name;
    public int age;
    public double salary;
    public String email;

    public BadExample(String name, int age, double salary, String email) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.email = email;
    }

    public void displayData() {
        System.out.println("Nama: " + name);
        System.out.println("Usia: " + age);
        System.out.println("Gaji: " + salary);
        System.out.println("Email: " + email);
    }
}

class GoodExample {
    private String name;
    private int age;
    private double salary;
    private String email;

    public GoodExample(String name, int age, double salary, String email) {
        setName(name);
        setAge(age);
        setSalary(salary);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Nama tidak boleh null atau kosong.");
        }
    }

    public void setAge(int age) {
        if (age >= 17 && age <= 65) {
            this.age = age;
        } else {
            System.out.println("Error: Usia harus antara 17 dan 65 tahun. Diberikan: " + age);
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Error: Gaji tidak boleh negatif. Diberikan: " + salary);
        }
    }

    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Error: Format email tidak valid. Diberikan: " + email);
        }
    }

    private boolean validateEmail(String email) {
        if (email == null) return false;
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isRetirementAge() {
        return age >= 60;
    }

    public double calculateTax() {
        if (salary > 5000000) {
            return salary * 0.15;
        } else {
            return salary * 0.10;
        }
    }
}

class BankAccountSecure {
    private String accountNumber;
    private double balance;
    private String pin;
    private boolean isLocked;
    private int failedPinAttempts;
    private static final int MAX_FAILED_ATTEMPTS = 3;

    public BankAccountSecure(String accountNumber, double initialBalance, String pin) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            System.out.println("Error: Nomor akun tidak boleh kosong.");
            return;
        }
        if (pin == null || pin.length() != 4) {
            System.out.println("Error: PIN harus 4 digit.");
            return;
        }
        if (initialBalance < 0) {
            System.out.println("Error: Saldo awal tidak boleh negatif.");
            return;
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = pin;
        this.isLocked = false;
        this.failedPinAttempts = 0;
        System.out.println("Akun " + accountNumber + " berhasil dibuat.");
    }

    public void deposit(double amount) {
        if (isLocked) {
            System.out.println("Akun terkunci. Tidak dapat melakukan setoran.");
            return;
        }
        if (isValidAmount(amount)) {
            this.balance += amount;
            System.out.println("Setoran sebesar " + amount + " berhasil. Saldo baru: " + this.balance);
        } else {
            System.out.println("Jumlah setoran tidak valid.");
        }
    }

    public void withdraw(double amount, String pin) {
        if (isLocked) {
            System.out.println("Akun terkunci. Tidak dapat melakukan penarikan.");
            return;
        }
        if (!validatePin(pin)) {
            this.failedPinAttempts++;
            System.out.println("PIN salah. Sisa percobaan: " + (MAX_FAILED_ATTEMPTS - failedPinAttempts));
            if (failedPinAttempts >= MAX_FAILED_ATTEMPTS) {
                lockAccount();
            }
            return;
        }
        if (!isValidAmount(amount)) {
            System.out.println("Jumlah penarikan tidak valid.");
            return;
        }
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Penarikan sebesar " + amount + " berhasil. Saldo baru: " + this.balance);
            this.failedPinAttempts = 0;
        } else {
            System.out.println("Saldo tidak mencukupi. Saldo saat ini: " + this.balance);
        }
    }

    public double checkBalance(String pin) {
        if (isLocked) {
            System.out.println("Akun terkunci. Tidak dapat mengecek saldo.");
            return -1;
        }
        if (validatePin(pin)) {
            this.failedPinAttempts = 0;
            return this.balance;
        } else {
            this.failedPinAttempts++;
            System.out.println("PIN salah. Sisa percobaan: " + (MAX_FAILED_ATTEMPTS - failedPinAttempts));
            if (failedPinAttempts >= MAX_FAILED_ATTEMPTS) {
                lockAccount();
            }
            return -1;
        }
    }

    public void changePin(String oldPin, String newPin) {
        if (isLocked) {
            System.out.println("Akun terkunci. Tidak dapat mengubah PIN.");
            return;
        }
        if (!validatePin(oldPin)) {
            this.failedPinAttempts++;
            System.out.println("PIN lama salah. Sisa percobaan: " + (MAX_FAILED_ATTEMPTS - failedPinAttempts));
            if (failedPinAttempts >= MAX_FAILED_ATTEMPTS) {
                lockAccount();
            }
            return;
        }
        if (newPin == null || newPin.length() != 4) {
            System.out.println("Error: PIN baru harus 4 digit.");
            return;
        }
        this.pin = newPin;
        this.failedPinAttempts = 0;
        System.out.println("PIN berhasil diubah.");
    }

    private boolean validatePin(String pin) {
        return this.pin.equals(pin);
    }

    private void lockAccount() {
        this.isLocked = true;
        System.out.println("Akun " + this.accountNumber + " telah dikunci karena terlalu banyak percobaan PIN yang salah.");
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountStatus() {
        return isLocked ? "TERKUNCI" : "AKTIF";
    }

    private int securityLevel;
    public void setSecurityLevel(int level) {
        if (level >= 1 && level <= 5) {
            this.securityLevel = level;
            System.out.println("Tingkat keamanan diatur ke: " + level);
        } else {
            System.out.println("Tingkat keamanan tidak valid. Harus antara 1 dan 5.");
        }
    }
}

class AccessModifierDemo {
    private String privateField = "Private Field";
    protected String protectedField = "Protected Field";
    String defaultField = "Default Field";
    public String publicField = "Public Field";

    private void privateMethod() {
        System.out.println("Private method dipanggil dari dalam kelas.");
    }

    protected void protectedMethod() {
        System.out.println("Protected method dipanggil dari dalam kelas.");
    }

    void defaultMethod() {
        System.out.println("Default method dipanggil dari dalam kelas.");
    }

    public void publicMethod() {
        System.out.println("Public method dipanggil dari dalam kelas.");
    }

    public void testAccess() {
        System.out.println("Mengakses field dari dalam AccessModifierDemo:");
        System.out.println("Private Field: " + privateField);
        System.out.println("Protected Field: " + protectedField);
        System.out.println("Default Field: " + defaultField);
        System.out.println("Public Field: " + publicField);

        System.out.println("\nMemanggil method dari dalam AccessModifierDemo:");
        privateMethod();
        protectedMethod();
        defaultMethod();
        publicMethod();
    }
}