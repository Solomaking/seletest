package com.ui.steps;

import com.ui.util.DriverManagement;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        if (scenario.getName() != null) {
            System.out.println("************* Scenario " + scenario.getName() + " ***********");
        }
        DriverManagement driver = new DriverManagement();
        driver.init();
    }
}