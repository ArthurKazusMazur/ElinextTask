package tutbySearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public class TutBySearchBaseTest {
    public WebDriver driver;

    @BeforeClass
    public void runTutBy() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public void browserClose() {
        driver.quit();
    }
}

