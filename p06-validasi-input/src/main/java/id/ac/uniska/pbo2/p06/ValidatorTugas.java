//Muhammad Aditya - 2410010163
package id.ac.uniska.pbo2.p06;

public class ValidatorTugas {

    // Validasi input wajib diisi
    public static String wajibDiisi(String nilai, String namaField) {
        if (nilai == null || nilai.trim().isEmpty()) {
            return namaField + " wajib diisi";
        }

        return null;
    }

    // Validasi NPM
    public static String npm(String npm) {
        String kosong = wajibDiisi(npm, "NPM");

        if (kosong != null) {
            return kosong;
        }

        if (!npm.matches("\\d+")) {
            return "NPM hanya boleh berisi angka";
        }

        if (npm.length() != 10) {
            return "NPM harus terdiri dari 10 digit";
        }

        return null;
    }

    // Validasi nama
    public static String nama(String nama) {
        String kosong = wajibDiisi(nama, "Nama");

        if (kosong != null) {
            return kosong;
        }

        if (nama.trim().matches(".*\\d.*")) {
            return "Nama tidak boleh mengandung angka";
        }

        if (nama.trim().length() < 3) {
            return "Nama minimal 3 karakter";
        }

        return null;
    }

    // Validasi email
    public static String email(String email) {
        String kosong = wajibDiisi(email, "Email");

        if (kosong != null) {
            return kosong;
        }

        String polaEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (!email.matches(polaEmail)) {
            return "Format email tidak valid";
        }

        return null;
    }

    // Validasi nomor HP
    public static String hp(String hp) {
        String kosong = wajibDiisi(hp, "Nomor HP");

        if (kosong != null) {
            return kosong;
        }

        if (!hp.matches("\\d+")) {
            return "Nomor HP hanya boleh berisi angka";
        }

        if (hp.length() < 10 || hp.length() > 13) {
            return "Nomor HP harus terdiri dari 10-13 digit";
        }

        return null;
    }
}
