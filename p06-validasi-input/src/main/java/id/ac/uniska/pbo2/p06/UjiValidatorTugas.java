
package id.ac.uniska.pbo2.p06;

public class UjiValidatorTugas {

    // Method untuk memeriksa hasil validasi
    public static void cek(String namaPengujian, String hasil, boolean seharusnyaValid) {

        boolean valid = (hasil == null);

        if (valid == seharusnyaValid) {
            System.out.println("[BERHASIL] " + namaPengujian);
        } else {
            System.out.println("[GAGAL] " + namaPengujian);

            if (hasil != null) {
                System.out.println("   Pesan: " + hasil);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("===== PENGUJIAN VALIDATOR TUGAS =====");

        // Pengujian NPM
        System.out.println("\n--- Validasi NPM ---");
        cek("NPM valid", ValidatorTugas.npm("2410010021"), true);
        cek("NPM kosong", ValidatorTugas.npm(""), false);
        cek("NPM mengandung huruf", ValidatorTugas.npm("24100ABCDE"), false);
        cek("NPM kurang dari 10 digit", ValidatorTugas.npm("12345"), false);

        // Pengujian Nama
        System.out.println("\n--- Validasi Nama ---");
        cek("Nama valid", ValidatorTugas.nama("Muhammad Aditya"), true);
        cek("Nama kosong", ValidatorTugas.nama(""), false);
        cek("Nama mengandung angka", ValidatorTugas.nama("Aditya123"), false);
        cek("Nama kurang dari 3 karakter", ValidatorTugas.nama("Ad"), false);

        // Pengujian Email
        System.out.println("\n--- Validasi Email ---");
        cek("Email valid", ValidatorTugas.email("aditya@gmail.com"), true);
        cek("Email kosong", ValidatorTugas.email(""), false);
        cek("Email tanpa @", ValidatorTugas.email("adityagmail.com"), false);
        cek("Email tanpa domain", ValidatorTugas.email("aditya@"), false);

        // Pengujian Nomor HP
        System.out.println("\n--- Validasi Nomor HP ---");
        cek("HP valid", ValidatorTugas.hp("081234567890"), true);
        cek("HP kosong", ValidatorTugas.hp(""), false);
        cek("HP mengandung huruf", ValidatorTugas.hp("08123ABC"), false);
        cek("HP kurang dari 10 digit", ValidatorTugas.hp("08123"), false);

        System.out.println("\n===== PENGUJIAN SELESAI =====");
    }
}
