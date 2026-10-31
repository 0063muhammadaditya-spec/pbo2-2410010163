# Praktikum PBO 2 -- Pertemuan 6

## Validasi Input dan Kegunaan

**Nama:** Muhammad Aditya\
**Objek:** Form Pendaftaran Anggota Perpustakaan
(`FormAnggotaPerpustakaan`)\
**Peninjau:**

------------------------------------------------------------------------

## 1. Lembar Peer Review

Lembar peer review dilampirkan pada bagian berikut.

![Lembar peer review dari M. Hafiz
Ilmi](dokumentasi/peer-review-.jpg)

> Ganti gambar di atas dengan foto/pindaian asli lembar peer review yang
> sudah diterima. Draf tabel peer review bukan pengganti bukti lembar
> yang ditandatangani atau dikonfirmasi peninjau.

## 2. Temuan Peer Review dan Tindak Lanjut

 --------------------------------------------------------------------------
 No.        Temuan dari teman Perbaikan/tindak  Commit
                   lanjut       
 ----------------- ----------------- ------------------ -------------------
 1         Status      Memanfaatkan    `ISI_HASH_COMMIT`
          pendaftaran dan  `statusLabel` dan 
          jumlah isian yang label pesan    
          perlu diperbaiki validasi di dekat 
          perlu terlihat  kolom terkait agar 
          jelas.      status dan     
                   kesalahan lebih  
                   mudah diketahui.  

 2         Istilah pada   Dipertahankan;   `ISI_HASH_COMMIT`
          label form sudah label NPM, Nama,  
          mudah dipahami.  Program Studi,   
                   Email, Nomor HP,  
                   dan Alamat     
                   digunakan secara  
                   konsisten.     

 3         Tombol Batal   Mempertahankan   `ISI_HASH_COMMIT`
          sudah meminta   dialog konfirmasi; 
          konfirmasi    data hanya     
          sebelum menghapus dikosongkan jika  
          isian.      pengguna memilih  
                   Ya.        

 4         Ukuran, jarak,  Mempertahankan   `ISI_HASH_COMMIT`
          dan gaya komponen susunan form yang 
          perlu dijaga   memisahkan data  
          konsistensinya.  anggota dan kontak 
                   serta merapikan  
                   tampilan komponen. 

 5         Pencegahan input Menambahkan    `ISI_HASH_COMMIT`
          dan validasi NPM, pembatasan     
          email, serta   karakter angka   
          nomor HP perlu  pada NPM/HP dan  
          diuji untuk input melakukan validasi 
          kosong dan    ulang melalui   
          karakter yang   `ValidatorTugas`  
          tidak sesuai.   ketika tombol   
                   Daftar ditekan.  

 6         Placeholder dan  Menambahkan    `ISI_HASH_COMMIT`
          tooltip membantu tooltip pada NPM, 
          pengguna     Nama, Email, dan  
          mengenali format Nomor HP.     
          input.                

 7         Mnemonic dan   Mempertahankan   `ISI_HASH_COMMIT`
          urutan Tab    mnemonic yang   
          membantu     sudah diatur pada 
          penggunaan    GUI Builder dan  
          keyboard.     menguji navigasi  
                   keyboard.     

 8         Pemisahan bagian Mempertahankan   `ISI_HASH_COMMIT`
          Data Anggota dan pengelompokan   
          Kontak membuat  tersebut dan    
          form lebih    menghindari    
          terstruktur.   informasi yang   
                   tidak diperlukan. 

 9         Pesan validasi  Menampilkan pesan `ISI_HASH_COMMIT`
          harus spesifik  pada label pesan  
          dan ditempatkan  masing-masing   
          dekat kolom    kolom serta    
          terkait.     memberi penanda  
                   border pada input 
                   yang tidak valid. 

 10        Tooltip pada   Tooltip      `ISI_HASH_COMMIT`
          isian lain yang  ditambahkan pada  
          memiliki aturan  isian Nama, Email, 
          khusus perlu   dan Nomor HP    
          dilengkapi.    selain NPM.    
 --------------------------------------------------------------------------

**Catatan:** Skor pada lembar peninjau yang tersedia berada pada rentang
0--2. Tabel ini mencatat tindak lanjut yang dilakukan pada form;
sesuaikan kembali setiap baris dengan lembar peer review asli dan
riwayat Git. Ganti `ISI_HASH_COMMIT` dengan hash commit yang benar
setelah melihat `git log --oneline`. Jangan mengarang hash commit.

## 3. Bukti Tampilan Form dengan Pesan Kesalahan

Tangkapan layar berikut menunjukkan form ketika pengguna memasukkan data
yang tidak sesuai sehingga pesan kesalahan tampil pada form.

![Form dengan pesan kesalahan
validasi](dokumentasi/form-pesan-kesalahan.png)

**Saran pengambilan screenshot:** jalankan form, isi NPM/email/nomor HP
dengan data yang tidak valid, lalu klik Daftar. Pastikan pesan kesalahan
dan penanda pada kolom terlihat jelas.

## 4. Bukti Navigator

Tangkapan layar berikut memperlihatkan jendela Navigator NetBeans yang
menampilkan label pesan validasi.

![Navigator menampilkan label pesan
validasi](dokumentasi/navigator-label-pesan.png)

**Komponen label pesan yang digunakan:** - `npmPesanLabel` -
`namaPesanLabel` - `programPesanLabel` - `emailPesanLabel` -
`hpPesanLabel` - `alamatPesanLabel`

**Saran pengambilan screenshot:** buka panel Navigator di NetBeans,
perluas bagian komponen form, lalu ambil screenshot ketika nama-nama
label pesan terlihat.

## 5. Jawaban Eksperimen Praktikum 4

### 1. Ketik huruf pada isian NPM. Apa yang terjadi dan bagian kode mana yang menyebabkannya?

Huruf tidak dimasukkan ke kolom NPM. Event `keyTyped` memeriksa karakter
yang diketik menggunakan kondisi `!Character.isDigit(evt.getKeyChar())`.
Jika karakter bukan angka, `evt.consume()` membatalkan input tersebut.
Pemeriksaan batas panjang juga mencegah jumlah karakter melebihi 10
digit.

### 2. Isi email dengan `siti@`, lalu tekan Tab. Kapan pesan kesalahan muncul?

Pada rancangan eksperimen modul, pesan muncul ketika fokus meninggalkan
kolom Email. Event `focusLost` memanggil pemeriksaan email jika kolom
tidak kosong. Format `siti@` tidak valid karena belum memiliki domain
dan ekstensi yang benar, sehingga pesan kesalahan ditampilkan.

### 3. Klik isian Nama tanpa mengetik, lalu tekan Tab. Mengapa tidak ada pesan kesalahan?

Isian kosong tidak langsung ditandai ketika fokus berpindah karena
pemeriksaan saat `focusLost` hanya dijalankan jika kolom Nama tidak
kosong. Isian wajib yang masih kosong diperiksa ketika pengguna menekan
tombol Daftar. Cara ini menghindari pesan kesalahan terlalu dini saat
pengguna baru melewati kolom.

### 4. Centang persetujuan, lalu klik Daftar dengan form kosong. Isian mana yang mendapat fokus?

Fokus diarahkan ke kolom NPM sebagai isian pertama yang tidak valid.
Form memeriksa input, menentukan kesalahan pertama, lalu memindahkan
fokus ke komponen tersebut agar pengguna dapat langsung memperbaikinya.

### 5. Tekan tombol Alt bersama huruf mnemonic pada label Nama. Isian mana yang mendapat fokus, dan properti apa yang mengaturnya?

Fokus berpindah ke kolom yang terhubung dengan label Nama. Hal ini
diatur oleh properti `displayedMnemonic` pada label dan `labelFor` yang
menghubungkan label dengan komponen input. Pada form ini, gunakan huruf
mnemonic yang benar-benar terpasang pada label Nama di GUI Builder;
jangan mengasumsikan huruf `N` apabila mnemonic yang aktif berbeda.

### 6. Isi beberapa isian, lalu klik Batal dan pilih No. Apakah data tetap ada?

Ya, data tetap ada. Ketika pengguna memilih No pada dialog konfirmasi,
proses pembatalan dihentikan dan method untuk mengosongkan form tidak
dijalankan. Data yang sudah dimasukkan tetap berada di setiap kolom.

## 6. Deklarasi Penggunaan AI

Saya menyatakan bahwa dalam pengerjaan dan penyusunan dokumentasi
Praktikum PBO 2 Pertemuan 6 ini, saya menggunakan bantuan kecerdasan
buatan (AI).

**Alat AI yang digunakan:** ChatGPT (OpenAI).

**Keperluan penggunaan:** 1. Membantu memahami instruksi modul dan
menyusun struktur README. 2. Membantu merapikan penjelasan temuan peer
review dan tindak lanjutnya. 3. Membantu menyusun jawaban eksperimen
Praktikum 4 berdasarkan materi modul. 4. Membantu memeriksa konsistensi
dokumentasi dan penamaan komponen.

**Batas penggunaan:** AI digunakan sebagai alat bantu. Implementasi
program, pengujian langsung di NetBeans, pengambilan screenshot,
pencocokan hasil peer review asli, serta pemeriksaan riwayat commit
dilakukan dan diverifikasi oleh mahasiswa.

------------------------------------------------------------------------

## 7. Checklist Sebelum Dikumpulkan

-  [ ] Ganti gambar peer review dengan foto/pindaian asli dari M. Hafiz
  Ilmi.
-  [ ] Tambahkan screenshot form yang menampilkan pesan kesalahan.
-  [ ] Tambahkan screenshot Navigator yang memperlihatkan label pesan.
-  [ ] Ganti semua `ISI_HASH_COMMIT` dengan hash commit Git yang benar.
-  [ ] Pastikan nama file gambar dan lokasi folder `dokumentasi/`
  sesuai dengan tautan gambar di README.
-  [ ] Pastikan repository memuat file `.java` dan `.form` proyek.
