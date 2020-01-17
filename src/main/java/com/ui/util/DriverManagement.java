package com.ui.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.ui.util.TestParams.IMPLCICITLY_WAIT;
import static com.ui.util.TestParams.PAGE_LOAD_TIMEOUT;
import static java.util.Objects.requireNonNull;
import static java.util.concurrent.TimeUnit.SECONDS;

public class DriverManagement {

    private WebDriver driver;

    public void init() {
        Properties prop = null;
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(new File(
                    requireNonNull(DriverManagement.class.getClassLoader().getResource("config.properties")).getFile()));
            prop.load(fis);

        } catch (IOException e) {
            e.getMessage();
        }

        String browserName = System.getProperty("browser");

        if (null == browserName) {
            browserName = prop.getProperty("browser").toLowerCase();
        } else {
            browserName = browserName.toLowerCase();
        }

        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        DriverFactory.addDriver(driver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLCICITLY_WAIT, SECONDS);
        driver.get(prop.getProperty("url"));
        BasePage basePage = new BasePage();
        basePage.setWebDriver(driver);
    }
}