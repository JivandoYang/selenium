Proyek ini merupakan implementasi automation testing untuk Web UI menggunakan:
- Cucumber (BDD)
- Selenium WebDriver
- Java
- Gradle
Framework ini menggunakan pendekatan Page Object Model (POM) untuk memisahkan logic test dan element UI agar lebih maintainable dan scalable.

Alur Penerapan
Setup Dependencies
1. Menambahkan dependency Cucumber dan Selenium pada build.gradle.
2. Pembuatan Feature File (Gherkin)
- Menulis test case menggunakan format Gherkin (Given - When - Then).
- Mendukung parameterisasi input.
3. Step Definition
- Menghubungkan langkah di Gherkin ke kode Java.
- Parameter dari feature akan diteruskan ke method di step definition.
4. Hooks & Driver Management
- @Before → inisialisasi WebDriver
- @After → menutup browser
Driver dikelola menggunakan DriverManager
5. Page Object Model (POM)
Setiap halaman dibuat dalam class terpisah. Berisi:
- Locator element
- Method interaksi (click, input, validation)
6. Eksekusi Test
- Cucumber menjalankan scenario berdasarkan Gherkin
- Setiap step akan memanggil method di Step Definition
- Step Definition memanggil method di Page Object untuk interaksi UI
