package ui.tests;

import com.ui.PageGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;

    private String browser = "Chrome";

    @BeforeEach
    public void setUp() {
        switch (browser) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
        }

        wait = new WebDriverWait(driver, 15);
        page = new PageGenerator(driver);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
