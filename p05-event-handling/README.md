# Laporan Praktikum Pemrograman Berorientasi Objek
## Modul P04: Desain Antarmuka Pengguna & Manajemen Layout (Java GUI)

---

## 📌 Identitas Praktikum
- **Topik:** Layout Manager pada Java Swing (`BorderLayout`, `FlowLayout`, `GridLayout`, `GridBagLayout`, `BoxLayout`)
- **Studi Kasus:** `FormAnggotaPerpustakaan`
- **Tanggal Uji Coba:** *(Isi tanggal praktikum)*
- **Nama Praktikan:** *(Isi nama mahasiswa)*
- **NIM:** *(Isi NIM)*

---

## 📑 Daftar Isi
1. [Arsitektur & Rancangan Komponen](#1-arsitektur--rancangan-komponen)
2. [Refleksi & Pemahaman Konseptual](#2-refleksi--pemahaman-konseptual)
3. [Hasil Pengamatan & Eksperimen Laboratorium](#3-hasil-pengamatan--eksperimen-laboratorium)
4. [Tinjauan Sejawat (Peer Review)](#4-tinjauan-sejawat-peer-review)
5. [Integritas Akademik & Penggunaan AI](#5-integritas-akademik--penggunaan-ai)
6. [Daftar Periksa Berkas & Lampiran](#6-daftar-periksa-berkas--lampiran)

---

## 1. Arsitektur & Rancangan Komponen

### 1.1 Spesifikasi Panel & Hirarki Layout
Struktur form perpustakaan menggunakan kombinasi beberapa layout manager untuk menjaga skalabilitas visual antarmuka:

| No | Komponen / Kontainer | Nama Variabel | Tipe Layout Manager | Konfigurasi Utama |
|---|---|---|---|---|
| 1 | Jendela Utama | `FormAnggotaPerpustakaan` (`JFrame`) | `BorderLayout` | Penampung seluruh root panel |
| 2 | Area Atas | `headerPanel` | `BoxLayout` | Sumbu Y (`Y_AXIS`) |
| 3 | Area Tengah (Wrapper) | `isiPanel` | `BorderLayout` | Menjaga posisi form tetap di atas |
| 4 | Formulir Masukan | `formPanel` | `GridBagLayout` | Label (kolom 1), Input (kolom 2) |
| 5 | Area Aksi / Navigasi | `tombolPanel` | `FlowLayout` | Rata kanan (`FlowLayout.RIGHT`) |

### 1.2 Hirarki Pohon Komponen (Component Tree)
```text
FormAnggotaPerpustakaan (JFrame - BorderLayout)
│
├── [NORTH]  headerPanel (BoxLayout: Y_AXIS)
│    └── Label Header & Subjudul
│
├── [CENTER] isiPanel (BorderLayout)
│    └── [NORTH] formPanel (GridBagLayout)
│         ├── Label Kolom 1 (weightx = 0.0)
│         └── Input Kolom 2 (weightx = 1.0, fill = HORIZONTAL)
│
└── [SOUTH]  tombolPanel (FlowLayout: RIGHT)
     ├── JButton [Batal]
     └── JButton [Daftar] (Aksi Utama)
```

> **Catatan Pengaturan UI:**
> - Terapkan `EmptyBorder` secukupnya pada tepi panel agar antarmuka tidak menempel langsung ke bingkai jendela.
> - Komponen input pada `formPanel` menggunakan parameter constraints `weightx = 1.0` dan `fill = GridBagConstraints.HORIZONTAL`.

---

## 2. Refleksi & Pemahaman Konseptual

### 2.1 Mengapa Menghindari Null / Absolute Layout?
- **Masalah Kompatibilitas:** Penempatan elemen dengan koordinat manual $(x, y)$ dan ukuran tetap sangat rentan rusak ketika aplikasi dibuka pada resolusi layar berbeda, DPI/skala font sistem operasi berubah, atau jendela diperbesar.
- **Solusi Layout Manager:** Mengotomatisasi penataan ruang komponen secara adaptif dan menjaga konsistensi tampilan lintas platform.

### 2.2 Karakteristik Perubahan Dimensi: FlowLayout vs GridLayout
| Parameter Uji | `FlowLayout` | `GridLayout` |
|---|---|---|
| **Perilaku Ukuran Komponen** | Mempertahankan *preferred size* asli komponen. | Memaksa seluruh komponen memiliki ukuran sel yang identik. |
| **Respon saat Jendela Melebar** | Menambah jumlah elemen dalam satu baris sebelum membungkus ke baris baru. | Membesarkan ukuran tiap sel secara merata sebanding dengan pelebaran jendela. |

### 2.3 Parameter Kunci GridBagLayout
- **`weightx`:** Menentukan alokasi pembagian ruang sisa horizontal. Nilai `1.0` pada field input memberikan porsi ekspansi penuh, sedangkan nilai `0.0` pada label membuat lebar kolom label tetap statis.
- **`fill = GridBagConstraints.HORIZONTAL`:** Menginstruksikan komponen agar mengisi seluruh lebar sel grid yang telah dialokasikan kepadanya.

### 2.4 Strategi Penempatan `formPanel` di `BorderLayout.NORTH`
`isiPanel` berperan sebagai pembungkus berorientasi `BorderLayout`. Dengan menempatkan `formPanel` pada posisi `NORTH`:
- Baris isian form terkunci rapi di bagian atas saat dimensi vertikal jendela ditingkatkan.
- Ruang ekstra bertambah di sisi bawah formulir, menghindari form tertarik melar atau terpecah ke area tengah yang tidak proporsional.

### 2.5 Prinsip UI/UX yang Diterapkan
1. **Konsistensi Visual:** Standardisasi tinggi komponen kontrol, jarak seragam antar baris, serta penyesuaian dimensi tombol `[Batal]` dan `[Daftar]`.
2. **Hierarki & Urutan Logis:** Alur pengisian dimulai dari identitas data, informasi kontak, hingga persetujuan. Tombol aksi ditempatkan pada sudut kanan bawah dengan tombol `[Daftar]` sebagai tindakan primer.

---

## 3. Hasil Pengamatan & Eksperimen Laboratorium

### 3.1 Eksperimen Praktikum 2 (Evaluasi Komponen Dasar)
- **Modifikasi `FlowLayout` ke Alignment Center:**
  - *Hasil:* Tombol tersusun simetris di tengah baris. Jika jendela menyempit, elemen terdorong berantai ke baris bawahnya.
  - *Perubahan Kode:* Mengubah parameter konstruktor dari `FlowLayout.LEFT` menjadi `FlowLayout.CENTER`.
- **Konfigurasi `GridLayout(0, 2)` pada 9 Komponen:**
  - *Hasil:* Terbentuk struktur 5 baris (4 baris berisi 2 tombol, 1 baris terakhir berisi 1 tombol). Parameter baris bernilai `0` membuat kalkulasi baris terjadi otomatis berdasarkan kuota kolom.
- **Penerapan Maximum Size & Vertical Strut pada `BoxLayout`:**
  - *Hasil:* Batas maksimum memberi ruang komponen meregang secara horizontal, sementara `Box.createVerticalStrut()` menyisipkan jarak vertikal yang stabil antar kontrol.

### 3.2 Eksperimen Praktikum 4 (Uji Ketahanan Form & Constraints)
- **Efek Nilai `weightx = 0.0` pada `namaField`:**
  - *Pengamatan:* Field input kehilangan prioritas ekspansi horizontal. Ketika jendela diperbesar, field tetap berukuran default dan menyisakan ruang kosong di sisi kanannya.
- **Relokasi `formPanel` dari `NORTH` ke `CENTER`:**
  - *Pengamatan:* Kontrol form terpusat secara vertikal di tengah jendela. Ketika jendela ditinggikan, posisi formulir terlihat mengambang di area tengah.
- **Penghapusan Batasan `setMinimumSize(getSize())`:**
  - *Pengamatan:* Form dapat diperkecil melewati batas aman hingga teks label terpotong atau field input saling tumpang-tindih.

---

## 4. Tinjauan Sejawat (Peer Review)

*Pemeriksaan dilakukan silang bersama rekan praktikan untuk menguji fungsionalitas dan tampilan antarmuka.*

### 4.1 Rekomendasi & Catatan Perbaikan
> *"Jarak label dan input sebaiknya dibuat lebih konsisten. Coba lebarkan jendela untuk memastikan kolom input ikut menyesuaikan tanpa membuat susunan form terlihat renggang."*

### 4.2 Lembar Evaluasi Checklist Kualitas
- [x] Label ringkas, lugas, dan sejajar dengan kontrol input terkait.
- [x] Bidang isian terkelompok berdasarkan tema/seksi yang jelas.
- [x] Tersedia petunjuk format (*placeholder*) untuk nomor HP dan email.
- [x] Tipe kontrol antarmuka sesuai dengan kebutuhan data.
- [x] Tombol aksi utama (*Daftar*) kontras dan diletakkan di kanan bawah.
- [x] Spasi serta margin antar-elemen konsisten.
- [x] Tampilan tidak terpotong atau rusak saat jendela di-*maximize*.
- [x] Menggunakan hirarki `JFrame Form` resmi dan layout manager (tanpa Null Layout).

---

## 5. Integritas Akademik & Penggunaan AI
Dokumen ini disusun dengan bantuan AI (ChatGPT) untuk merapikan dokumentasi, memformulasikan sintesis konsep layout manager, serta merumuskan analisis eksperimen. Seluruh pengamatan teknis telah diverifikasi dan disesuaikan langsung melalui pengujian proyek pada NetBeans IDE.

---

## 6. Daftar Periksa Berkas & Lampiran
Sebelum mengumpulkan berkas akhir, pastikan lampiran berikut sudah disertakan dalam repositori/laporan:
- [ ] Foto sketsa awal wireframe/desain form.
- [ ] Screenshot jendela `FormAnggotaPerpustakaan` pada ukuran default.
- [ ] Screenshot form saat jendela diperbesar (*maximized / stretched*).
- [ ] Screenshot tab *Design* dan panel *Navigator* NetBeans yang memperlihatkan hierarki komponen.