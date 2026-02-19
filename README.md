# Tugas Praktikum 2 Pengembangan Aplikasi Mobile

Nama: Bening Apni Prameswari
---
NIM: 123140089
---
Mata Kuliah: Pengembangan Aplikasi Mobile RB
---

# News Feed Simulator
### Deskripsi

News Feed Simulator merupakan aplikasi Android berbasis Kotlin yang mensimulasikan feed berita yang terus diperbarui secara otomatis.  
Aplikasi ini memanfaatkan **Flow, StateFlow, dan Coroutines** untuk mengelola data secara reaktif.

---

### Fitur Aplikasi

- Berita baru muncul otomatis setiap 2 detik menggunakan Flow
- Filter berita berdasarkan kategori (Sports, Technology, Politics)
- Data berita ditampilkan dalam format yang sudah ditransformasi
- Menggunakan StateFlow untuk menyimpan jumlah berita yang telah dibaca
- Detail berita diambil secara asynchronous menggunakan Coroutines
- Tampilan dibuat menggunakan Jetpack Compose (Material 3)

---

### Cara Menjalankan Project

1. Clone atau download repository ini
2. Buka project menggunakan Android Studio
3. Tunggu hingga proses Gradle Sync selesai
4. Jalankan emulator atau hubungkan perangkat Android
5. Klik tombol **Run**
6. Aplikasi akan berjalan dan berita akan bertambah otomatis setiap 2 detik

---

### Screenshot Aplikasi
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/94f493a7-c51b-473b-a59e-9c81b1ae9722" />
