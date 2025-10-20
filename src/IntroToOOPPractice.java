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

        System.out.println("\\n=== MASALAH DENGAN CARA PROSEDURAL ===");
        // Tuliskan dalam komentar 3 masalah yang Anda lihat dari cara di atas
        System.out.println("1. Tidak Terstruktur : Data (nama, nim, jurusan, ipk) untuk satu entitas (mahasiswa) tersebar di variabel-variabel yang berbeda.");
        System.out.println("2. Sulit Dikelola : Jika ingin menambah data harus mengubah di banyak tempat dan membuat variabel baru. jika datanya ada ratusan maka akan banyak yang harus di ubah.");
        System.out.println("3. Tidak Ada Perilaku : Tidak ada fungsi/method yang melekat padanya. Jika ingin menghitung predikat, kita harus membuat fungsi terpisah.");
        // ===== DENGAN OOP: CARA OBJECT-ORIENTED =====
        System.out.println("\\n=== DENGAN OOP: CARA OBJECT-ORIENTED ===");

        // Latihan 2: Menggunakan class Mahasiswa (akan dibuat di bawah)
        // Buat 3 object Mahasiswa
        String namaMahs1 = "Dina";
        String nimMahs1 = "10122670";
        String jurusanMahs1 = "Sastra Mesin";
        double ipkMahs1 = 3.6;

        String namaMahs2 = "Caldera";
        String nimMahs2 = "2282010";
        String jurusanMahs2 = "Agroteknologi";
        double ipkMahs2 = 3.8;

        String namaMahs3 = "Mendung";
        String nimMahs3 = "2382010";
        String jurusanMahs3 = "Ilmu Komputer";
        double ipkMahs3 = 3.2;
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


        // ===== ANALOGI DUNIA NYATA =====
        System.out.println("\\n=== ANALOGI DUNIA NYATA ===");

        // Latihan 3: Implementasi analogi perpustakaan
        // Buat beberapa object Buku
        // Buat object Mahasiswa yang meminjam buku
        // Simulasikan proses peminjaman

        // Implementasikan analogi perpustakaan

        // ===== KEUNTUNGAN OOP =====
        System.out.println("\\n=== KEUNTUNGAN OOP ===");
        // Tuliskan dalam komentar 5 keuntungan OOP yang Anda rasakan
    }

    private static class mhs {
    }
}

// ===== DEFINISI CLASS =====

// Buat class Mahasiswa dengan struktur berikut:
class Mahasiswa {
    // Instance variables
    // Definisikan instance variables untuk nama, nim, jurusan, ipk

    // Constructor
    // Buat constructor untuk inisialisasi data mahasiswa

    // Methods
    // Buat method untuk menampilkan informasi mahasiswa
    // Buat method untuk mengecek apakah mahasiswa lulus (IPK >= 2.75)
    // Buat method untuk menghitung predikat berdasarkan IPK
}

// Buat class Buku dengan struktur berikut:
class Buku {
    // Instance variables
    // Definisikan variables untuk judul, penulis, isbn, tahunTerbit, tersedia

    // Constructor
    // Buat constructor

    // Methods
    // Buat method untuk menampilkan info buku
    // Buat method untuk meminjam buku
    // Buat method untuk mengembalikan buku
}

// Buat class Perpustakaan yang mengelola buku dan peminjaman
class Perpustakaan {
    // Implementasikan class perpustakaan
}
