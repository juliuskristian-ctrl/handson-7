import java.util.Random;

public class StaticVsInstancePractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Static vs Instance
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * perbedaan static dan instance members, kapan menggunakan masing-masing.
         */

        // ===== STATIC VARIABLES DEMO =====
        System.out.println("=== STATIC VARIABLES DEMO ===");

        // Latihan 1: Static variables sebagai shared data
        // Buat beberapa object dari class yang memiliki static counter
        // Tunjukkan bahwa static variable di-share oleh semua object

        Counter counter1 = new Counter("Counter A");
        Counter counter2 = new Counter("Counter B");
        Counter counter3 = new Counter("Counter C");

        System.out.println("Global count dari counter1: " + counter1.getGlobalCount());
        System.out.println("Global count dari counter2: " + counter2.getGlobalCount());
        System.out.println("Global count dari class Counter: " + Counter.getGlobalCount());

        counter1.incrementInstance();
        counter2.incrementInstance();
        counter2.incrementInstance();

        System.out.println("\nSetelah beberapa increment:");
        counter1.displayCounterInfo();
        counter2.displayCounterInfo();
        counter3.displayCounterInfo();
        System.out.println("Global count setelah increment: " + Counter.getGlobalCount());

        System.out.println("\n--- Aplikasi Info ---");
        Counter.displayAppInfo();


        // ===== STATIC METHODS DEMO =====
        System.out.println("\n=== STATIC METHODS DEMO ===");

        // Latihan 2: Static methods sebagai utility functions
        // Implementasikan utility methods yang tidak butuh object
        // Tunjukkan cara memanggil static methods

        System.out.println("--- Menggunakan MathUtils ---");
        double radius = 7.0;
        System.out.println("Luas lingkaran dengan radius " + radius + ": " + MathUtils.calculateCircleArea(radius));

        double x1 = 0, y1 = 0, x2 = 3, y2 = 4;
        System.out.println("Jarak antara (" + x1 + "," + y1 + ") dan (" + x2 + "," + y2 + "): " + MathUtils.calculateDistance(x1, y1, x2, y2));

        int num1 = 17;
        int num2 = 10;
        System.out.println(num1 + " adalah prima? " + MathUtils.isPrime(num1));
        System.out.println(num2 + " adalah prima? " + MathUtils.isPrime(num2));

        int factNum = 5;
        System.out.println(factNum + "! = " + MathUtils.factorial(factNum));

        System.out.println("2 pangkat 3 = " + MathUtils.power(2, 3));


        // ===== STATIC VS INSTANCE COMPARISON =====
        System.out.println("\n=== STATIC VS INSTANCE COMPARISON ===");

        // Latihan 3: Perbandingan langsung static vs instance
        // Tunjukkan memory usage difference
        // Performance comparison

        System.out.println("--- Perbandingan Static vs Instance (Konseptual) ---");
        System.out.println("Static: Data/metode milik kelas, hanya ada satu salinan di memori, di-share oleh semua objek.");
        System.out.println("Instance: Data/metode milik objek, setiap objek punya salinan sendiri di memori.");

        System.out.println("\n--- Contoh DatabaseConnection ---");
        System.out.println("Status inisialisasi pool: " + DatabaseConnection.isInitialized);
        System.out.println("Koneksi aktif: " + DatabaseConnection.getActiveConnectionCount());

        DatabaseConnection dbConn1 = DatabaseConnection.getConnection();
        DatabaseConnection dbConn2 = DatabaseConnection.getConnection();
        DatabaseConnection dbConn3 = DatabaseConnection.getConnection(); // Max 3 koneksi

        if (dbConn1 != null) {
            dbConn1.connect();
            dbConn1.executeQuery("SELECT * FROM users");
        }
        if (dbConn2 != null) {
            dbConn2.connect();
            dbConn2.executeQuery("INSERT INTO products");
        }
        if (dbConn3 != null) {
            dbConn3.connect();
        }

        System.out.println("Koneksi aktif setelah membuat objek: " + DatabaseConnection.getActiveConnectionCount());

        DatabaseConnection dbConn4 = DatabaseConnection.getConnection(); // Akan gagal jika melebihi maxConnections


        // ===== STATIC INITIALIZATION =====
        System.out.println("\n=== STATIC INITIALIZATION ===");

        // Latihan 4: Static initialization blocks
        // Tunjukkan kapan static variables diinisialisasi
        // Static blocks vs static variable initialization

        System.out.println("--- Static Initialization Demo ---");
        // Static block dari Counter dan DatabaseConnection sudah dieksekusi saat kelas pertama kali diakses.
        // Tidak ada output tambahan di sini karena sudah dipanggil di awal.
        System.out.println("APP_NAME dari Counter: " + Counter.APP_NAME);
        System.out.println("isInitialized dari DatabaseConnection: " + DatabaseConnection.isInitialized);
        // Memanggil StaticInitDemo untuk menunjukkan eksekusi static block-nya
        StaticInitDemo.staticMethodCall();


        // ===== BEST PRACTICES =====
        System.out.println("\n=== BEST PRACTICES ===");

        // Latihan 5: Kapan menggunakan static vs instance
        // Constants (static final)
        // Utility methods (static)
        // Counters/global state (static)
        // Object-specific data (instance)

        System.out.println("--- Contoh Best Practices (Student) ---");
        System.out.println("Nama Universitas (static): " + Student.getUniversityName());
        System.out.println("Total Mahasiswa (static): " + Student.getTotalStudents());

        Student student1 = new Student("S001", "Ani", "Informatika", 3.8);
        Student student2 = new Student("S002", "Budi", "Sistem Informasi", 3.5);

        System.out.println("\nSetelah membuat 2 mahasiswa:");
        System.out.println("Total Mahasiswa (static): " + Student.getTotalStudents());
        student1.displayStudentInfo();
        student2.displayStudentInfo();

        System.out.println("Ani adalah mahasiswa kehormatan? " + student1.isHonorStudent());

        student1.updateGPA(3.95);
        System.out.println("\nSetelah Ani update GPA:");
        student1.displayStudentInfo();
        System.out.println("Ani adalah mahasiswa kehormatan? " + student1.isHonorStudent());

        Student.setUniversityName("Universitas Maju Jaya");
        System.out.println("\nNama Universitas setelah diubah: " + Student.getUniversityName());

        System.out.println("\n--- Ringkasan Penggunaan ---");
        System.out.println("Static (milik kelas): Untuk nilai konstan (MathUtils.PI), metode utilitas (MathUtils.isPrime), data yang dibagi semua objek (Counter.globalCount, Student.totalStudents), \n sumber daya tunggal (DatabaseConnection pool).");
        System.out.println("Instance (milik objek): Untuk data unik per objek (Student.name, Student.gpa), perilaku yang bergantung pada state objek (student.displayStudentInfo).");
    }
}

// ===== CLASS DEFINITIONS =====

// Implementasikan class Counter dengan static dan instance counters
class Counter {
    static int globalCount = 0;
    static final String APP_NAME;

    int instanceCount = 0;
    String counterName;

    static {
        System.out.println("Static block Counter dieksekusi. Menginisialisasi APP_NAME.");
        APP_NAME = "Aplikasi Penghitung Universal";
    }

    public Counter(String name) {
        this.counterName = name;
        globalCount++;
        this.instanceCount = 1; // Mulai dari 1 setiap kali objek dibuat
        System.out.println("Counter " + name + " dibuat. Global count: " + globalCount);
    }

    public static int getGlobalCount() {
        return globalCount;
    }

    public static void resetGlobalCount() {
        globalCount = 0;
        System.out.println("Global count direset.");
    }

    public static void displayAppInfo() {
        System.out.println("Nama Aplikasi: " + APP_NAME);
        System.out.println("Total Objek Counter yang pernah dibuat: " + globalCount);
    }

    public int getInstanceCount() {
        return instanceCount;
    }

    public void incrementInstance() {
        this.instanceCount++;
        System.out.println("Counter " + counterName + " di-increment. Instance count: " + this.instanceCount);
    }

    public void displayCounterInfo() {
        System.out.println("Info Counter " + counterName + ": Instance Count = " + instanceCount + ", Global Count = " + globalCount);
    }
}

// Implementasikan class MathUtils dengan static utility methods
class MathUtils {
    static final double PI = 3.1415926535;
    static final double E = 2.71828;

    private MathUtils() {
        // Private constructor untuk mencegah instansiasi
    }

    public static double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Faktorial tidak didefinisikan untuk angka negatif.");
        }
        if (n == 0 || n == 1) return 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double power(double base, int exponent) {
        return Math.pow(base, exponent);
    }
}

// Implementasikan class DatabaseConnection dengan static connection pool
class DatabaseConnection {
    static int maxConnections = 3;
    static int activeConnections = 0;
    static boolean isInitialized = false;

    String connectionId;
    boolean isConnected;
    String database;

    static {
        System.out.println("Static block DatabaseConnection dieksekusi. Menyiapkan pool koneksi.");
        isInitialized = true;
    }

    private DatabaseConnection(String id, String db) {
        this.connectionId = id;
        this.database = db;
        this.isConnected = false;
    }

    public static DatabaseConnection getConnection() {
        if (activeConnections < maxConnections) {
            activeConnections++;
            Random rand = new Random();
            String id = "DB-" + (100 + rand.nextInt(900));
            System.out.println("Mendapatkan koneksi baru: " + id + ". Total aktif: " + activeConnections);
            return new DatabaseConnection(id, "DefaultDB");
        } else {
            System.out.println("Error: Batas maksimal koneksi tercapai (" + maxConnections + "). Tidak dapat membuat koneksi baru.");
            return null;
        }
    }

    public static void closeAllConnections() {
        activeConnections = 0;
        System.out.println("Semua koneksi ditutup. Koneksi aktif: " + activeConnections);
    }

    public static int getActiveConnectionCount() {
        return activeConnections;
    }

    public void connect() {
        if (!this.isConnected) {
            this.isConnected = true;
            System.out.println("Koneksi " + connectionId + " ke " + database + " berhasil tersambung.");
        } else {
            System.out.println("Koneksi " + connectionId + " sudah tersambung.");
        }
    }

    public void disconnect() {
        if (this.isConnected) {
            this.isConnected = false;
            activeConnections--;
            System.out.println("Koneksi " + connectionId + " terputus. Total aktif: " + activeConnections);
        } else {
            System.out.println("Koneksi " + connectionId + " sudah terputus.");
        }
    }

    public void executeQuery(String query) {
        if (this.isConnected) {
            System.out.println("Koneksi " + connectionId + " menjalankan query: '" + query + "'");
        } else {
            System.out.println("Error: Koneksi " + connectionId + " tidak aktif. Tidak dapat menjalankan query.");
        }
    }
}

// Implementasikan class Student dengan mixed static/instance
class Student {
    static String universityName = "Universitas Contoh";
    static int totalStudents = 0;

    String studentId;
    String name;
    String major;
    double gpa;

    public Student(String studentId, String name, String major, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
        totalStudents++; // Setiap kali objek Student dibuat, totalStudents bertambah
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public static void setUniversityName(String name) {
        universityName = name;
        System.out.println("Nama Universitas diperbarui menjadi: " + universityName);
    }

    public static String getUniversityName() {
        return universityName;
    }

    public void updateGPA(double newGPA) {
        if (newGPA >= 0.0 && newGPA <= 4.0) {
            this.gpa = newGPA;
            System.out.println("GPA " + name + " diperbarui menjadi " + newGPA);
        } else {
            System.out.println("GPA tidak valid (harus antara 0.0 dan 4.0).");
        }
    }

    public void displayStudentInfo() {
        System.out.println("--- Info Mahasiswa ---");
        System.out.println("ID: " + studentId);
        System.out.println("Nama: " + name);
        System.out.println("Jurusan: " + major);
        System.out.println("GPA: " + gpa);
        System.out.println("Universitas: " + universityName);
    }

    public boolean isHonorStudent() {
        return gpa >= 3.75;
    }
}

class StaticInitDemo {
    static String staticMessage = "Static variable diinisialisasi.";

    static {
        System.out.println("Static block StaticInitDemo dieksekusi.");
        System.out.println(staticMessage);
        staticMethodCall(); // Memanggil static method dari static block
    }

    public static void staticMethodCall() {
        System.out.println("Static method staticMethodCall dipanggil.");
    }
}