package hiltonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StartPage extends BasePage {
    //Construtor
    public StartPage(WebDriver driver) {
        super(driver);
    }

    //Page variables
    String url = "http://www3.hilton.com";

    //Web Elements
    By langRadio = By.id("languageCode8");
    By continueButton = By.xpath("//button[text()='Продолжить']");
    By advancedSearch = By.xpath("//span[text()='ADVANCED SEARCH']");

    //Page Methods
    public StartPage goToUrl() {
        driver.get(url);
        return this;
    }

    public StartPage chooseLangRadio() {
        click(langRadio);
        return new StartPage(driver);
    }

    public StartPage clickContinue() {
        click(continueButton);
        return new StartPage(driver);
    }

    public StartPage clickAdvancedSearch() {
        click(advancedSearch);
        return new StartPage(driver);
    }


}



