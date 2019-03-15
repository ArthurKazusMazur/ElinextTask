package tutbyPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends TutByBasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    String tutByUrl = "https://www.tut.by";

    By listLu = By.xpath("//*[contains(text(),'Лукашенко')]");

    public MainPage Url() {
        driver.get(tutByUrl);
        return this;
    }

    public void searchLu() {
        System.out.print("Лукашенко встречается " + driver.findElements(listLu).size() + " раз.");

    }
}
