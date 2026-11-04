# Jawaban Praktikum 5 – PBO 2 Pertemuan 7

## Identitas Praktikum
**Materi:** JTable, Menu, Dialog, dan Model Data  
**Aplikasi yang digunakan:** Aplikasi Daftar Kontak  
**Sumber:** Modul Praktikum PBO 2 Pertemuan 7, halaman 11–12

## Jawaban Eksperimen

### 1. Mengomentari `fireTableRowsInserted(baris, baris)`

**Pertanyaan:** Di `KontakTableModel`, jadikan baris `fireTableRowsInserted(baris, baris);` sebagai komentar, lalu tambah kontak baru. Apakah tabel langsung berubah?

**Jawaban:** Tidak. Data kontak memang ditambahkan ke dalam koleksi pada model, tetapi JTable tidak langsung mengetahui bahwa ada baris baru. Pemanggilan `fireTableRowsInserted(baris, baris)` berfungsi memberi tahu JTable bahwa data pada model bertambah sehingga tabel perlu memperbarui tampilannya. Jika baris tersebut dikomentari, perubahan data tidak otomatis diberitahukan kepada JTable.

### 2. Mengubah method `barisTerpilih()`

**Pertanyaan:** Di method `barisTerpilih`, ganti isinya menjadi `return kontakTable.getSelectedRow();`. Cari kata “ah”, pilih Ahmad Fauzi, lalu klik Hapus dan pilih No. Nama siapa yang muncul di dialog konfirmasi?

**Jawaban:** Nama yang muncul adalah **Siti Rahmah**. Setelah pencarian “ah”, Ahmad Fauzi menjadi baris pertama pada tampilan tabel. Namun, `getSelectedRow()` mengembalikan indeks baris tampilan, bukan indeks pada model. Ketika indeks tersebut langsung digunakan untuk mengambil data dari model, indeks 0 menunjuk ke data pertama pada model, yaitu Siti Rahmah. Hal ini menunjukkan pentingnya `convertRowIndexToModel()` ketika tabel menggunakan sorting atau filtering.

### 3. Mengubah dialog menjadi modeless

**Pertanyaan:** Di konstruktor `DialogKontak`, ubah `super(pemilik, judul, true)` menjadi `false`. Saat dialog terbuka, coba klik jendela utama. Apa yang terjadi pada kontak yang ditambahkan?

**Jawaban:** Jendela utama tetap dapat diklik karena dialog menjadi **modeless**. Berbeda dengan dialog modal, pemanggilan `setVisible(true)` pada dialog modeless tidak menahan alur program sampai dialog ditutup. Akibatnya, kode pemanggil dapat melanjutkan proses sebelum pengguna menyimpan data pada dialog. Jika hasil dialog langsung diperiksa setelah `setVisible(true)`, data baru dapat belum diterima dan tidak langsung ditambahkan ke tabel.

### 4. Menguji shortcut keyboard

**Pertanyaan:** Tekan Ctrl+N, Ctrl+E, dan Ctrl+D. Mengapa Ctrl+E dan Ctrl+D tidak bekerja saat tidak ada baris yang dipilih?

**Jawaban:** Ctrl+N tetap dapat digunakan karena fungsi tambah tidak membutuhkan baris yang dipilih. Sementara itu, Ctrl+E untuk ubah dan Ctrl+D untuk hapus tidak bekerja ketika tidak ada baris yang dipilih karena menu Ubah dan Hapus dinonaktifkan. Keduanya hanya diaktifkan ketika pengguna memilih salah satu baris pada tabel.

### 5. Mengubah accelerator menu Hapus

**Pertanyaan:** Di tab Design, ubah accelerator `hapusItem` menjadi tombol Delete tanpa Ctrl. Baris apa yang berubah di `initComponents()`?

**Jawaban:** Baris pengaturan accelerator pada komponen `hapusItem` berubah. Sebelumnya shortcut menggunakan kombinasi Ctrl+D. Setelah diubah menjadi tombol Delete tanpa Ctrl, kode `setAccelerator` akan menggunakan tombol `VK_DELETE` dengan modifier `0`, misalnya:

```java
hapusItem.setAccelerator(
    javax.swing.KeyStroke.getKeyStroke(
        java.awt.event.KeyEvent.VK_DELETE, 0
    )
);
```

Baris tersebut merupakan kode yang dihasilkan GUI Builder untuk menetapkan shortcut menu Hapus.

### 6. Mengubah inisialisasi atribut model

**Pertanyaan:** Ubah deklarasi atribut menjadi `private KontakTableModel model;` lalu isi `model = new KontakTableModel();` setelah `initComponents()`. Jalankan. Pesan error apa yang muncul dan mengapa?

**Jawaban:** Jika `model` digunakan oleh proses inisialisasi komponen atau method lain sebelum baris `model = new KontakTableModel();` dijalankan, akan terjadi **NullPointerException**. Hal ini karena atribut objek yang belum diberi nilai secara otomatis bernilai `null`. Ketika program mencoba memanggil method atau menggunakan model tersebut sebelum objek dibuat, program mengalami error. Oleh karena itu, objek model harus dibuat sebelum pertama kali digunakan.

## Kesimpulan

Dari eksperimen ini dapat dipahami bahwa:

1. `AbstractTableModel` perlu memberi notifikasi kepada JTable ketika data berubah.
2. Indeks baris tampilan dan indeks baris model dapat berbeda ketika tabel menggunakan pencarian atau sorting.
3. Dialog modal menahan interaksi dengan jendela utama, sedangkan dialog modeless tidak.
4. Menu dan shortcut dapat diaktifkan atau dinonaktifkan sesuai kondisi pemilihan baris.
5. Accelerator pada menu dapat diatur melalui GUI Builder.
6. Objek model harus diinisialisasi sebelum digunakan agar tidak terjadi `NullPointerException`.

## Referensi
Modul Praktikum PBO 2 Pertemuan 7, halaman 11–12, bagian Eksperimen sebelum Praktikum 6.
