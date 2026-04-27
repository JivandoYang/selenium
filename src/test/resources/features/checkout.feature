@checkout
Feature: Checkout

  @accessCheckout
  Scenario: user berhasil membuka halaman checkout
    Given user login dengan username "standard_user" dan password "secret_sauce"
    And user menekan icon cart
    When user menekan tombol checkout
    Then user berada di halaman checkout

  @valid-checkout
  Scenario: user mengisi informasi checkout dengan data valid
    Given user login dengan username "standard_user" dan password "secret_sauce"
    And user menekan icon cart
    And user menekan tombol checkout
    And user berada di halaman checkout
    When user memasukkan firstname "jivando"
    And user memasukkan lastname "yang"
    And user memasukkan postalcode "14152"
    And user klik tombol continue
    Then user pergi ke halaman overview

  @invalid-checkout
  Scenario: user mengisi informasi checkout dengan data tidak valid
    Given user login dengan username "standard_user" dan password "secret_sauce"
    And user menekan icon cart
    And user menekan tombol checkout
    And user berada di halaman checkout
    When user memasukkan firstname ""
    And user memasukkan lastname ""
    And user memasukkan postalcode "14152"
    And user klik tombol continue
    Then sistem muncul pesan error
