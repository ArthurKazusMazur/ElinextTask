package hiltonTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void run() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public void browserClose() {
        driver.quit();
    }
}
