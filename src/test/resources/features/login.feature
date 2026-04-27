@login
Feature: Login

  @valid-login
  Scenario: Login berhasil dengan akun valid
    Given user berada di halaman login
    When user memasukkan username "standard_user"
    And user memasukkan password "secret_sauce"
    And user klik tombol login
    Then user di inventory page

  @invalid-login
  Scenario: Login dengan username kosong
    Given user berada di halaman login
    When user memasukkan username ""
    And user memasukkan password "secret_sauce"
    And user klik tombol login
    Then muncul pesan error

  @invalid-login
  Scenario: Login dengan password kosong
    Given user berada di halaman login
    When user memasukkan username "standard_user"
    And user memasukkan password ""
    And user klik tombol login
    Then muncul pesan error

  @invalid-login
  Scenario: Login gagal dengan password salah
    Given user berada di halaman login
    When user memasukkan username "standard_user"
    And user memasukkan password "salah_password"
    And user klik tombol login
    Then muncul pesan error