package saucedemo.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import saucedemo.driver.DriverManager;

public class CucumberHooks {

    @Before
    public void beforeTest() {
        System.out.println("HOOK JALAN");
        DriverManager.init();
    }

    @After
    public void afterTest() {
        DriverManager.quit();
    }
}