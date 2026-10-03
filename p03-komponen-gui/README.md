# Penggunaan AI

## Nama AI

**ChatGPT (GPT-5.6 Luna)**

Dalam pengerjaan `FormTiketTravel`, AI dimanfaatkan sebagai pendamping untuk membantu memahami implementasi Java Swing, khususnya dalam menghubungkan komponen pada form dengan proses yang dijalankan ketika pengguna berinteraksi dengan aplikasi. AI juga digunakan untuk membantu menganalisis error dan memberikan alternatif penyelesaian yang sesuai dengan struktur project NetBeans.

---

## Prompt 1 – Mengambil dan Menampilkan Informasi Form

### Prompt

> "Saya mempunyai form pemesanan tiket travel menggunakan Java Swing. Ketika pengguna menekan tombol Pesan, saya ingin seluruh informasi yang sudah diisi ditampilkan kembali dalam sebuah dialog. Data yang perlu ditampilkan meliputi nama, nomor telepon, tujuan, pilihan kelas, fasilitas yang dipilih, dan keterangan tambahan. Buatkan contoh implementasi Java Swing yang sederhana dan jelaskan cara kerjanya."

### Hasil Jawaban AI

AI menyarankan agar setiap nilai diambil langsung dari komponen yang terdapat pada form. Input teks diperoleh menggunakan `getText()`, pilihan dari `JComboBox` diambil menggunakan `getSelectedItem()`, sedangkan pilihan `JRadioButton` dan `JCheckBox` diperiksa menggunakan `isSelected()`.

Data yang sudah diperoleh kemudian disusun menjadi satu informasi pemesanan dan ditampilkan menggunakan `JOptionPane`. Dengan pendekatan tersebut, pengguna dapat melihat kembali seluruh data yang telah dimasukkan tanpa harus berpindah halaman.

Contoh kode:

```java
private void tampilkanDataPemesanan() {

    String nama = namaPemesanField.getText();
    String nomor = nomorHpField.getText();
    String tujuan = String.valueOf(
            kotaTujuanCombo.getSelectedItem()
    );

    String kelas = "Belum dipilih";

    if (ekonomiRadio.isSelected()) {
        kelas = "Ekonomi";
    }

    if (bisnisRadio.isSelected()) {
        kelas = "Bisnis";
    }

    if (eksekutifRadio.isSelected()) {
        kelas = "Eksekutif";
    }

    String fasilitas = "";

    if (bagasiCheck.isSelected()) {
        fasilitas += "Bagasi ";
    }

    if (makanCheck.isSelected()) {
        fasilitas += "Makan ";
    }

    if (asuransiCheck.isSelected()) {
        fasilitas += "Asuransi ";
    }

    if (fasilitas.isEmpty()) {
        fasilitas = "Tidak ada";
    }

    String informasi =
            "DATA PEMESANAN\n\n"
            + "Nama       : " + nama
            + "\nNomor HP   : " + nomor
            + "\nTujuan     : " + tujuan
            + "\nKelas      : " + kelas
            + "\nFasilitas  : " + fasilitas
            + "\nCatatan    : " + catatanArea.getText();

    JOptionPane.showMessageDialog(
            this,
            informasi,
            "Informasi Tiket",
            JOptionPane.INFORMATION_MESSAGE
    );
}
```

---

## Prompt 2 – Mengatur Mode Tampilan Aplikasi

### Prompt

> "Saya ingin menambahkan fitur mode tampilan pada aplikasi Java Swing menggunakan FlatLaf. Jika toggle dalam keadaan aktif, form menggunakan tema gelap, sedangkan jika tidak aktif menggunakan tema terang. Buatkan contoh kode yang mudah dipahami dan jelaskan bagian yang harus dipanggil ketika toggle berubah."

### Hasil Jawaban AI

AI memberikan pendekatan dengan memanfaatkan dua tema FlatLaf, yaitu `FlatDarkLaf` untuk tampilan gelap dan `FlatLightLaf` untuk tampilan terang.

Ketika nilai toggle berubah, program akan menentukan tema berdasarkan status `isSelected()`. Setelah tema diterapkan, `FlatLaf.updateUI()` digunakan agar seluruh komponen pada form segera memperbarui tampilannya.

Contoh implementasinya:

```java
private void ubahTampilan() {

    if (temaToggle.isSelected()) {
        FlatDarkLaf.setup();
        temaToggle.setText("Light Mode");
    } else {
        FlatLightLaf.setup();
        temaToggle.setText("Dark Mode");
    }

    FlatLaf.updateUI();
}
```

Kemudian method tersebut dipanggil melalui event tombol:

```java
private void temaToggleActionPerformed(
        java.awt.event.ActionEvent evt) {

    ubahTampilan();
}
```

Dengan cara tersebut, perubahan tema dapat dilakukan langsung dari form tanpa harus menjalankan ulang aplikasi.

---

## Prompt 3 – Mencari Penyebab Komponen Tidak Dikenali

### Prompt

> "Pada project Java Swing yang dibuat menggunakan NetBeans, saya sudah membuat sebuah Toggle Button tetapi ketika digunakan dalam source code muncul pesan bahwa variabel tersebut tidak ditemukan. Bagaimana cara mengecek nama variabel komponen tersebut melalui GUI Builder dan apa yang harus diperhatikan agar tidak mengubah bagian kode yang dibuat otomatis?"

### Hasil Jawaban AI

AI menjelaskan bahwa masalah tersebut biasanya muncul karena nama variabel yang digunakan dalam source code tidak sama dengan nama komponen yang dibuat pada GUI Builder.

Untuk mengatasinya, komponen Toggle Button dapat dipilih melalui tampilan **Design**, kemudian nama variabelnya diperiksa melalui pengaturan komponen. Jika diperlukan, nama variabel dapat diubah menggunakan opsi **Change Variable Name**.

Sebagai contoh, apabila kode menggunakan:

```java
temaToggle.isSelected();
```

maka komponen Toggle Button pada GUI Builder harus memiliki nama variabel `temaToggle`.

AI juga menjelaskan bahwa bagian kode yang dikelola NetBeans, terutama `initComponents()`, sebaiknya tidak diedit secara manual. Perubahan komponen sebaiknya dilakukan melalui GUI Builder agar kode generated tetap dapat dikelola oleh NetBeans.

---

# Alasan Menggunakan AI

AI digunakan dalam praktikum ini sebagai sarana pendukung untuk memahami implementasi program Java Swing dan mencari solusi ketika terdapat kendala dalam proses pembuatan aplikasi.

Beberapa hal yang dibantu oleh AI meliputi pengambilan nilai dari komponen input, pemeriksaan pilihan pengguna, penyusunan informasi pemesanan, penerapan tema FlatLaf, serta analisis pesan error yang muncul ketika program dijalankan.

Jawaban dari AI tidak langsung digunakan seluruhnya tanpa pemeriksaan. Kode yang diberikan terlebih dahulu dipahami, kemudian disesuaikan dengan nama komponen dan struktur `FormTiketTravel` yang dibuat dalam NetBeans. Dengan demikian, proses pengerjaan tetap dilakukan dengan memahami fungsi dari setiap bagian kode.

Pembuatan tampilan form, penempatan komponen, serta pengaturan desain tetap dilakukan menggunakan **NetBeans GUI Builder**. AI hanya digunakan sebagai bantuan pada bagian logika pemrograman dan pemecahan masalah teknis.

Melalui penggunaan AI tersebut, pemahaman terhadap beberapa fungsi Java Swing seperti `getText()`, `getSelectedItem()`, `isSelected()`, `JOptionPane`, dan event handler menjadi lebih mudah. AI juga membantu dalam memahami cara menghubungkan interaksi pengguna dengan proses yang dijalankan oleh program.
