@cart
Feature: Cart

  @accessCart
  Scenario: user berhasil membuka halaman cart
    Given user login dengan username "standard_user" dan password "secret_sauce"
    When user menekan icon cart
    Then user berada di halaman cart

  @cancelCart
  Scenario: user balik ke halaman inventory
    Given user login dengan username "standard_user" dan password "secret_sauce"
    And user menekan icon cart
    And user berada di halaman cart
    When user menekan tombol continue shopping
    Then user di inventory page