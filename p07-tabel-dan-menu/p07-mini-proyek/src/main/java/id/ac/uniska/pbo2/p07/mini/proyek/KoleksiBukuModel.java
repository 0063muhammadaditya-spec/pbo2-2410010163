
package id.ac.uniska.pbo2.p07.mini.proyek;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class KoleksiBukuModel extends AbstractTableModel {

    private final String[] namaKolom = {
        "Kode Buku", "Judul Buku", "Penulis", "Tahun", "Ketersediaan"
    };

    private final List<DataBuku> daftarBuku = new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftarBuku.size();
    }

    @Override
    public int getColumnCount() {
        return namaKolom.length;
    }

    @Override
    public String getColumnName(int column) {
        return namaKolom[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DataBuku buku = daftarBuku.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return buku.getKode();
            case 1:
                return buku.getJudul();
            case 2:
                return buku.getPenulis();
            case 3:
                return buku.getTahun();
            case 4:
                return buku.getKetersediaan();
            default:
                return null;
        }
    }

    public void tambahBuku(DataBuku buku) {
        daftarBuku.add(buku);
        fireTableRowsInserted(
                daftarBuku.size() - 1,
                daftarBuku.size() - 1
        );
    }

    public void ubahBuku(int index, DataBuku buku) {
        daftarBuku.set(index, buku);
        fireTableRowsUpdated(index, index);
    }

    public void hapusBuku(int index) {
        daftarBuku.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public DataBuku ambilBuku(int index) {
        return daftarBuku.get(index);
    }

    public int hitungBukuTersedia() {
        int jumlah = 0;

        for (DataBuku buku : daftarBuku) {
            if (buku.getKetersediaan() == Ketersediaan.TERSEDIA) {
                jumlah++;
            }
        }

        return jumlah;
    }
}
