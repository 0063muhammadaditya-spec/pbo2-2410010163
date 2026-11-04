
package id.ac.uniska.pbo2.p07.mini.proyek;

public class DataBuku {

    private String kode;
    private String judul;
    private String penulis;
    private int tahun;
    private Ketersediaan ketersediaan;

    public DataBuku(String kode, String judul, String penulis,
                    int tahun, Ketersediaan ketersediaan) {
        this.kode = kode;
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
        this.ketersediaan = ketersediaan;
    }

    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahun() {
        return tahun;
    }

    public Ketersediaan getKetersediaan() {
        return ketersediaan;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void setKetersediaan(Ketersediaan ketersediaan) {
        this.ketersediaan = ketersediaan;
    }
}
