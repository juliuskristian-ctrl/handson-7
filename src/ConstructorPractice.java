import java.time.LocalDate;

public class ConstructorPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Constructors
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * constructors, constructor overloading, dan keyword this.
         */

        // ===== DEFAULT VS CUSTOM CONSTRUCTOR =====
        System.out.println("=== DEFAULT VS CUSTOM CONSTRUCTOR ===");

        // Latihan 1: Memahami default constructor
        // Buat class dengan dan tanpa custom constructor
        // Tunjukkan perbedaan penggunaan default constructor

        // Demonstrasikan penggunaan default constructor
        System.out.println("--- Class tanpa custom constructor (SimpleClass) ---");
        SimpleClass obj1 = new SimpleClass(); // Menggunakan default constructor (dibuat otomatis oleh Java)
        System.out.println("obj1.data: " + obj1.data); // Akan menampilkan nilai default (0 untuk int)

        System.out.println("\n--- Class dengan custom constructor (SimpleClassWithConstructor) ---");
        SimpleClassWithConstructor obj2 = new SimpleClassWithConstructor(); // Menggunakan custom constructor tanpa parameter
        System.out.println("obj2.value: " + obj2.value); // Akan menampilkan nilai yang diinisialisasi di constructor

        // ===== CONSTRUCTOR OVERLOADING =====
        System.out.println("\n=== CONSTRUCTOR OVERLOADING ===");

        // Latihan 2: Multiple constructors untuk berbagai skenario
        // Implementasikan class Product dengan multiple constructors
        // Setiap constructor untuk kasus penggunaan yang berbeda

        // Buat object Product menggunakan berbagai constructors
        System.out.println("--- Membuat objek Product dengan berbagai constructor ---");
        // Constructor 1: Full parameters
        Product product1 = new Product("P001", "Laptop Gaming", "Laptop kencang untuk game", 15_000_000.0, "Elektronik", 10, "ABC Tech");
        System.out.println("Product 1 (Full):");
        product1.displayProductInfo();

        // Constructor 2: Essential parameters only
        Product product2 = new Product("P002", "Mouse Wireless", 250_000.0);
        System.out.println("\nProduct 2 (Essential):");
        product2.displayProductInfo();

        // Constructor 3: Copy constructor
        Product product3 = new Product(product1);
        System.out.println("\nProduct 3 (Copy dari Product 1):");
        product3.displayProductInfo();

        // Constructor 4: Default constructor with default values
        Product product4 = new Product();
        System.out.println("\nProduct 4 (Default):");
        product4.displayProductInfo();


        // ===== KEYWORD THIS =====
        System.out.println("\n=== KEYWORD THIS ===");

        // Latihan 3: Penggunaan this dalam constructor dan methods
        // Demonstrasikan this untuk menghindari name collision
        // Gunakan this untuk memanggil constructor lain
        // Gunakan this untuk mereferensikan current object

        // Demonstrasikan berbagai penggunaan this
        System.out.println("--- Penggunaan 'this' dalam Employee ---");
        // 'this' untuk memanggil constructor lain (Constructor Chaining)
        Employee emp1 = new Employee("E001", "Budi", "Doremi"); // Memanggil constructor (String id, String first, String last)
        System.out.println("Karyawan 1 (Nama Saja):");
        emp1.getEmployeeInfo();

        Employee emp2 = new Employee("E002", "Citra", "Dewi", "Pemasaran"); // Memanggil constructor (String id, String first, String last, String dept)
        System.out.println("\nKaryawan 2 (Nama & Departemen):");
        emp2.getEmployeeInfo();

        // 'this' untuk mereferensikan current object (misal: di giveRaise)
        System.out.println("\n--- Menggunakan 'this' di Method (giveRaise) ---");
        System.out.println("Gaji Budi sebelum naik gaji: " + emp1.salary);
        emp1.giveRaise(0.10); // Memberi kenaikan gaji 10%
        System.out.println("Gaji Budi setelah naik gaji: " + emp1.salary);


        // ===== CONSTRUCTOR CHAINING =====
        System.out.println("\n=== CONSTRUCTOR CHAINING ===");

        // Latihan 4: Constructor yang memanggil constructor lain
        // Implementasikan constructor chaining dengan this()
        // Tunjukkan keuntungan constructor chaining

        // Implementasikan constructor chaining (sudah terdemonstrasi di Latihan 3 pada class Employee)
        System.out.println("Keuntungan Constructor Chaining pada class Employee:\n" +
                "1. Mengurangi duplikasi kode: Constructor yang lebih kompleks dapat memanggil constructor yang lebih sederhana.\n" +
                "2. Memudahkan pemeliharaan: Perubahan pada inisialisasi dasar hanya perlu dilakukan di satu tempat.\n" +
                "3. Fleksibilitas: Memberikan banyak cara untuk membuat objek dengan parameter berbeda.");


        // ===== INITIALIZATION ORDER =====
        System.out.println("\n=== INITIALIZATION ORDER ===");

        // Latihan 5: Urutan inisialisasi object
        // Tunjukkan urutan eksekusi saat object dibuat
        // Instance variable initialization vs constructor

        // Demonstrasikan urutan inisialisasi
        System.out.println("--- Membuat objek InitializationDemo ---");
        InitializationDemo initDemo = new InitializationDemo();
        System.out.println("Nilai instance variable 'instanceVar' setelah objek dibuat: " + initDemo.instanceVar);
        System.out.println("Nilai instance variable 'anotherVar' setelah objek dibuat: " + initDemo.anotherVar);
    }
}

// ===== CLASS DEFINITIONS =====

// Implementasikan class SimpleClass (tanpa custom constructor)
class SimpleClass {
    // Hanya instance variables, tanpa constructor
    int data; // Akan diinisialisasi ke 0 secara default oleh Java

    // Java akan otomatis menyediakan public SimpleClass() {}
}

// Class ini dibuat untuk membandingkan dengan SimpleClass
class SimpleClassWithConstructor {
    int value;

    public SimpleClassWithConstructor() {
        System.out.println("Custom constructor SimpleClassWithConstructor dipanggil.");
        value = 100; // Inisialisasi custom
    }
}


// Implementasikan class Product dengan constructor overloading
class Product {
    // Instance variables
    String productId;
    String name;
    String description;
    double price;
    String category;
    int inStock;
    String supplier;

    // Constructor 1: Full parameters
    public Product(String productId, String name, String description, double price, String category, int inStock, String supplier) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
        this.supplier = supplier;
    }

    // Constructor 2: Essential parameters only
    public Product(String productId, String name, double price) {
        this(productId, name, "Tidak ada deskripsi", price, "Umum", 0, "Tidak diketahui"); // Memanggil constructor full parameter
        System.out.println("Product " + name + " dibuat dengan parameter esensial.");
    }

    // Constructor 3: Copy constructor
    public Product(Product other) {
        this(other.productId, other.name, other.description, other.price, other.category, other.inStock, other.supplier);
        System.out.println("Product " + other.name + " dibuat sebagai salinan.");
    }

    // Constructor 4: Default constructor with default values
    public Product() {
        this("UNKNOWN", "Produk Baru", 0.0); // Memanggil constructor esensial
        this.description = "Produk default";
        this.category = "Lain-lain";
        this.inStock = 1;
        this.supplier = "Vendor Default";
        System.out.println("Product default dibuat.");
    }

    // Methods
    public void displayProductInfo() {
        System.out.println("ID Produk: " + productId);
        System.out.println("Nama: " + name);
        System.out.println("Deskripsi: " + description);
        System.out.println("Harga: " + price);
        System.out.println("Kategori: " + category);
        System.out.println("Stok: " + inStock);
        System.out.println("Supplier: " + supplier);
    }

    public void updateStock(int quantity) {
        this.inStock += quantity;
        System.out.println("Stok " + name + " diperbarui. Stok baru: " + this.inStock);
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage < 1) {
            this.price -= this.price * percentage;
            System.out.println("Diskon " + (percentage * 100) + "% diterapkan pada " + name + ". Harga baru: " + this.price);
        } else {
            System.out.println("Persentase diskon tidak valid.");
        }
    }

    public boolean isAvailable() {
        return this.inStock > 0;
    }
}

// Implementasikan class Employee dengan constructor chaining
class Employee {
    // Instance variables
    String employeeId;
    String firstName;
    String lastName;
    String department;
    String position;
    double salary;
    LocalDate hireDate;

    // Constructor 1: Full parameters
    public Employee(String employeeId, String firstName, String lastName, String department, String position, double salary, LocalDate hireDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
        System.out.println("Constructor Full: Karyawan " + getFullName() + " dibuat.");
    }

    // Constructor 2: Dengan sedikit parameter, memanggil constructor full
    public Employee(String employeeId, String firstName, String lastName, String department, String position, double salary) {
        this(employeeId, firstName, lastName, department, position, salary, LocalDate.now()); // hireDate hari ini
        System.out.println("Constructor Parsial (tanpa hireDate): Karyawan " + getFullName() + " dibuat.");
    }

    // Constructor 3: Lebih sedikit parameter, memanggil constructor di atasnya
    public Employee(String employeeId, String firstName, String lastName, String department) {
        this(employeeId, firstName, lastName, department, "Staf", 3_000_000.0); // Posisi default 'Staf', gaji default
        System.out.println("Constructor Minimal (nama & departemen): Karyawan " + getFullName() + " dibuat.");
    }

    // Constructor 4: Sangat minimal, memanggil constructor di atasnya
    public Employee(String employeeId, String firstName, String lastName) {
        this(employeeId, firstName, lastName, "Umum"); // Departemen default 'Umum'
        System.out.println("Constructor Sangat Minimal (nama): Karyawan " + getFullName() + " dibuat.");
    }

    // Methods
    public String getFullName() {
        return this.firstName + " " + this.lastName; // 'this' secara implisit
    }

    public int calculateYearsOfService() {
        if (this.hireDate != null) {
            return LocalDate.now().getYear() - this.hireDate.getYear();
        }
        return 0;
    }

    public void getEmployeeInfo() {
        System.out.println("ID Karyawan: " + employeeId);
        System.out.println("Nama: " + getFullName());
        System.out.println("Departemen: " + department);
        System.out.println("Posisi: " + position);
        System.out.println("Gaji: " + salary);
        System.out.println("Tanggal Bergabung: " + hireDate);
        System.out.println("Lama Bekerja: " + calculateYearsOfService() + " tahun");
    }

    public void giveRaise(double percentage) {
        if (percentage > 0) {
            this.salary += this.salary * percentage; // 'this' menghindari name collision jika ada parameter 'salary'
            System.out.println(this.getFullName() + " mendapatkan kenaikan gaji " + (percentage * 100) + "%. Gaji baru: " + this.salary);
        } else {
            System.out.println("Persentase kenaikan gaji tidak valid.");
        }
    }
}

// Implementasikan class InitializationDemo
class InitializationDemo {
    // Tunjukkan instance variable initialization
    String instanceVar = "Nilai dari inisialisasi instance variable"; // Ini dieksekusi duluan
    int anotherVar; // Ini akan default 0, lalu bisa diubah di constructor

    // Static block (dieksekusi saat class dimuat, sebelum objek dibuat)
    static {
        System.out.println("Static block dieksekusi.");
    }

    // Instance initializer block (dieksekusi setiap kali objek dibuat, setelah instance variables, sebelum constructor)
    {
        System.out.println("Instance initializer block dieksekusi.");
        anotherVar = 50; // Inisialisasi di instance block
    }

    public InitializationDemo() {
        System.out.println("Constructor InitializationDemo dipanggil.");
        // instanceVar = "Nilai diubah oleh constructor"; // Bisa diubah di sini
    }
}