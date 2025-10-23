import java.util.Scanner;

public class IntroToOOPPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Introduction to OOP
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk memahami
         * perbedaan antara pemrograman prosedural dan object-oriented.
         */

        // ===== SEBELUM OOP: CARA PROSEDURAL =====
        System.out.println("=== SEBELUM OOP: CARA PROSEDURAL ===");

        // Latihan 1: Data mahasiswa dengan variabel terpisah (cara lama)
        // Buat variabel untuk menyimpan data 3 mahasiswa
        // Setiap mahasiswa memiliki: nama, nim, jurusan, ipk

        String namaMhs1 = "Dina"; // Isi dengan data mahasiswa 1
        String nimMhs1 = "10122670";
        String jurusanMhs1 = "Sastra Mesin";
        double ipkMhs1 = 3.6;

        String namaMhs2 = "Caldera"; // Isi dengan data mahasiswa 2
        String nimMhs2 = "2282010";
        String jurusanMhs2 = "Agroteknologi";
        double ipkMhs2 = 3.8;

        String namaMhs3 = "Mendung"; // Isi dengan data mahasiswa 3
        String nimMhs3 = "2382010";
        String jurusanMhs3 = "Ilmu Komputer";
        double ipkMhs3 = 3.2;

        // Print semua data mahasiswa menggunakan cara prosedural
        // Implementasikan printing untuk semua mahasiswa
        System.out.println("-- MAHASISWA 1 --");
        System.out.println("Nama : " + namaMhs1);
        System.out.println("NIM : " + nimMhs1);
        System.out.println("Jurusan : " + jurusanMhs1);
        System.out.println("IPK : " + ipkMhs1);

        System.out.println("-- MAHASISWA 2 --");
        System.out.println("Nama : " + namaMhs2);
        System.out.println("NIM : " + nimMhs2);
        System.out.println("Jurusan : " + jurusanMhs2);
        System.out.println("IPK : " + ipkMhs2);

        System.out.println("-- MAHASISWA 3 --");
        System.out.println("Nama : " + namaMhs3);
        System.out.println("NIM : " + nimMhs3);
        System.out.println("Jurusan : " + jurusanMhs3);
        System.out.println("IPK : " + ipkMhs3);

        System.out.println("\n=== MASALAH DENGAN CARA PROSEDURAL ===");
        // Tuliskan dalam komentar 3 masalah yang Anda lihat dari cara di atas
        System.out.println("1. Tidak Terstruktur : Data (nama, nim, jurusan, ipk) untuk satu entitas (mahasiswa) tersebar di variabel-variabel yang berbeda.");
        System.out.println("2. Sulit Dikelola : Jika ingin menambah data harus mengubah di banyak tempat dan membuat variabel baru. \n jika datanya ada ratusan maka akan banyak yang harus di ubah.");
        System.out.println("3. Tidak Ada Perilaku : Tidak ada fungsi/method yang melekat padanya. Jika ingin menghitung predikat, kita harus membuat fungsi terpisah.");
        // ===== DENGAN OOP: CARA OBJECT-ORIENTED =====
        System.out.println("\n=== DENGAN OOP: CARA OBJECT-ORIENTED ===");

        // Latihan 2: Menggunakan class Mahasiswa (akan dibuat di bawah)
        // Buat 3 object Mahasiswa
        // Set data untuk setiap mahasiswa
        // Print menggunakan method dari class
        // Buat object mahasiswa dan isi datanya

        System.out.println("--- Membuat Objek Mahasiswa ---");
        Mahasiswa mhs1 = new Mahasiswa("Dina", "10122670", "Sastra Mesin", 3.6);
        Mahasiswa mhs2 = new Mahasiswa("Caldera", "2282010", "Agroteknologi", 3.8);
        Mahasiswa mhs3 = new Mahasiswa("Mendung", "2382010", "Ilmu Komputer", 3.2);

        System.out.println("\n--- Menampilkan Info dari Setiap Objek ---");
        mhs1.tampilInfo();
        mhs2.tampilInfo();
        mhs3.tampilInfo();

        System.out.println("\n--- Mengecek Status Kelulusan ---");
        System.out.println(mhs1.getNama() + " lulus? " + mhs1.cekLulus());
        System.out.println(mhs2.getNama() + " lulus? " + mhs2.cekLulus());
        System.out.println(mhs3.getNama() + " lulus? " + mhs3.cekLulus());

        System.out.println("\n--- Menghitung Predikat ---");
        System.out.println(mhs1.getNama() + " predikat: " + mhs1.hitungPredikat());
        System.out.println(mhs2.getNama() + " predikat: " + mhs2.hitungPredikat());
        System.out.println(mhs3.getNama() + " predikat: " + mhs3.hitungPredikat());


        // ===== ANALOGI DUNIA NYATA =====
        System.out.println("\n=== ANALOGI DUNIA NYATA ===");

        // Latihan 3: Implementasi analogi perpustakaan
        // Buat beberapa object Buku
        // Buat object Mahasiswa yang meminjam buku
        // Simulasikan proses peminjaman

        // Implementasikan analogi perpustakaan
        System.out.println("\n--- Simulasi Perpustakaan ---");
        Buku buku1 = new Buku("OOP with Java", "Budi Darmawan", "978-602-04-1234-5", 2022);
        Buku buku2 = new Buku("Dasar-Dasar Struktur Data", "Citra Kirana", "978-602-04-5678-9", 2020);

        // Menampilkan info buku
        buku1.tampilInfoBuku();
        buku2.tampilInfoBuku();

        // Mahasiswa meminjam buku
        System.out.println("\n--- Proses Peminjaman ---");
        System.out.println(mhs1.getNama() + " mencoba meminjam " + buku1.getJudul());
        mhs1.pinjamBuku(buku1);

        System.out.println(mhs2.getNama() + " mencoba meminjam " + buku2.getJudul());
        mhs2.pinjamBuku(buku2);

        System.out.println(mhs3.getNama() + " mencoba meminjam " + buku1.getJudul()); // Buku1 sudah dipinjam Dina
        mhs3.pinjamBuku(buku1);

        System.out.println("\n--- Status Buku Setelah Peminjaman ---");
        buku1.tampilInfoBuku();
        buku2.tampilInfoBuku();

        // Mahasiswa mengembalikan buku
        System.out.println("\n--- Proses Pengembalian ---");
        System.out.println(mhs1.getNama() + " mengembalikan " + buku1.getJudul());
        mhs1.kembalikanBuku(buku1);

        System.out.println("\n--- Status Buku Setelah Pengembalian ---");
        buku1.tampilInfoBuku();


        // ===== KEUNTUNGAN OOP =====
        System.out.println("\n=== KEUNTUNGAN OOP ===");
        // Tuliskan dalam komentar 5 keuntungan OOP yang Anda rasakan
        System.out.println("1. Reusability (Dapat Digunakan Kembali) : Kode yang sudah ditulis dalam bentuk class bisa digunakan berkali-kali \n untuk membuat banyak objek tanpa harus menulis ulang. Contoh: class Mahasiswa bisa dipakai untuk ratusan mahasiswa.");
        System.out.println("2. Modularity (Modularitas) : Program dipecah menjadi bagian-bagian kecil (objek) yang saling berinteraksi. \n Ini membuat kode lebih terorganisir dan mudah dipahami, seperti memecah tugas besar menjadi sub-tugas.");
        System.out.println("3. Maintainability (Kemudahan Perawatan) : Karena kode modular, jika ada perubahan atau perbaikan yang perlu dilakukan, \n kita hanya perlu mengubah di satu tempat (dalam class tertentu) tanpa memengaruhi bagian lain dari program.");
        System.out.println("4. Scalability (Skalabilitas) : Lebih mudah untuk mengembangkan atau menambah fitur baru ke program. \n Jika kita ingin menambah fitur untuk Buku, kita hanya perlu memodifikasi class Buku, bukan seluruh program.");
        System.out.println("5. Abstraction dan Encapsulation (Abstraksi dan Enkapsulasi) : Objek menyembunyikan detail internalnya (enkapsulasi) \n dan hanya menampilkan fungsionalitas yang relevan (abstraksi). Ini membuat kode lebih aman dan mudah digunakan, \n karena pengguna objek tidak perlu tahu bagaimana detail internalnya bekerja.");
    }

    // private static class mhs { // Komentar ini dihapus karena tidak digunakan dan mengganggu struktur
    // }
}

// ===== DEFINISI CLASS =====

// Buat class Mahasiswa dengan struktur berikut:
class Mahasiswa {
    // Instance variables
    // Definisikan instance variables untuk nama, nim, jurusan, ipk
    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;
    private Buku bukuPinjaman; // Untuk Latihan 3: Mahasiswa bisa meminjam 1 buku

    // Constructor
    // Buat constructor untuk inisialisasi data mahasiswa
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
        this.bukuPinjaman = null; // Awalnya tidak meminjam buku
    }

    // Methods
    // Buat method untuk menampilkan informasi mahasiswa
    public void tampilInfo() {
        System.out.println("-- Info Mahasiswa --");
        System.out.println("Nama : " + nama);
        System.out.println("NIM : " + nim);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("IPK : " + ipk);
    }

    // Buat method untuk mengecek apakah mahasiswa lulus (IPK >= 2.75)
    public boolean cekLulus() {
        return ipk >= 2.75;
    }

    // Buat method untuk menghitung predikat berdasarkan IPK
    public String hitungPredikat() {
        if (ipk >= 3.75) {
            return "Cum Laude";
        } else if (ipk >= 3.5) {
            return "Sangat Memuaskan";
        } else if (ipk >= 2.75) {
            return "Memuaskan";
        } else {
            return "Cukup";
        }
    }

    // Getter untuk nama (untuk digunakan di main method)
    public String getNama() {
        return nama;
    }

    // Latihan 3: Metode Peminjaman/Pengembalian Buku
    public void pinjamBuku(Buku buku) {
        if (this.bukuPinjaman == null) { // Belum meminjam buku lain
            if (buku.isTersedia()) { // Buku yang ingin dipinjam tersedia
                this.bukuPinjaman = buku;
                buku.setTersedia(false);
                System.out.println(this.nama + " berhasil meminjam buku: " + buku.getJudul());
            } else {
                System.out.println("Maaf, buku '" + buku.getJudul() + "' tidak tersedia.");
            }
        } else {
            System.out.println(this.nama + " sedang meminjam buku lain (" + this.bukuPinjaman.getJudul() + "). Harap kembalikan dulu.");
        }
    }

    public void kembalikanBuku(Buku buku) {
        if (this.bukuPinjaman != null && this.bukuPinjaman.equals(buku)) {
            buku.setTersedia(true);
            this.bukuPinjaman = null;
            System.out.println(this.nama + " berhasil mengembalikan buku: " + buku.getJudul());
        } else if (this.bukuPinjaman == null) {
            System.out.println(this.nama + " tidak sedang meminjam buku apapun.");
        } else {
            System.out.println(this.nama + " tidak meminjam buku '" + buku.getJudul() + "', dia sedang meminjam '" + this.bukuPinjaman.getJudul() + "'.");
        }
    }
}

// Buat class Buku dengan struktur berikut:
class Buku {
    // Instance variables
    // Definisikan variables untuk judul, penulis, isbn, tahunTerbit, tersedia
    private String judul;
    private String penulis;
    private String isbn;
    private int tahunTerbit;
    private boolean tersedia; // true jika tersedia, false jika sedang dipinjam

    // Constructor
    // Buat constructor
    public Buku(String judul, String penulis, String isbn, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.isbn = isbn;
        this.tahunTerbit = tahunTerbit;
        this.tersedia = true; // Secara default, buku baru tersedia
    }

    // Methods
    // Buat method untuk menampilkan info buku
    public void tampilInfoBuku() {
        System.out.println("-- Info Buku --");
        System.out.println("Judul        : " + judul);
        System.out.println("Penulis      : " + penulis);
        System.out.println("ISBN         : " + isbn);
        System.out.println("Tahun Terbit : " + tahunTerbit);
        System.out.println("Status       : " + (tersedia ? "Tersedia" : "Dipinjam"));
    }

    // Getter untuk judul (untuk digunakan di main method)
    public String getJudul() {
        return judul;
    }

    // Getter dan Setter untuk ketersediaan buku
    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    // Override equals untuk perbandingan objek Buku
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Buku buku = (Buku) obj;
        return isbn.equals(buku.isbn); // Membandingkan berdasarkan ISBN
    }
}

// Buat class Perpustakaan yang mengelola buku dan peminjaman
// Untuk tujuan latihan ini, kita tidak perlu mengimplementasikan class Perpustakaan secara penuh
// karena interaksi peminjaman sudah dihandle oleh Mahasiswa dan Buku.
// Namun, jika ingin, class ini bisa berisi List<Buku> dan method untuk menambah/menghapus buku
// atau mencatat peminjaman secara terpusat.
/*
class Perpustakaan {
    // Contoh:
    private java.util.List<Buku> daftarBuku;

    public Perpustakaan() {
        this.daftarBuku = new java.util.ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        System.out.println(buku.getJudul() + " telah ditambahkan ke perpustakaan.");
    }

    public void tampilkanSemuaBuku() {
        System.out.println("\nDaftar Buku di Perpustakaan:");
        for (Buku buku : daftarBuku) {
            buku.tampilInfoBuku();
        }
    }
}
*/