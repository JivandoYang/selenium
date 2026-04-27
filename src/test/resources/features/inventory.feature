@inventory
Feature: inventory

  @addInventory
  Scenario: user berhasil menambahkan produk ke keranjang
    Given user login dengan username "standard_user" dan password "secret_sauce"
    When user klik tombol tambah pada satu produk
    Then jumlah cart bertambah

  @removeInventory
  Scenario: user berhasil menghapus produk ke keranjang
    Given user login dengan username "standard_user" dan password "secret_sauce"
    And user sudah menambahkan 1 produk
    When user klik tombol hapus
    Then jumlah cart berkurang

