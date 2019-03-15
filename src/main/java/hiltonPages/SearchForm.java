package hiltonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchForm extends BasePage {
    //********************************Construtor*********************************
    public SearchForm(WebDriver driver) {
        super(driver);
    }

    //*********************************Page variables******************************
    String city = "Washington, DC";
    //********************************Web Elements*********************************
    By cityToStay = By.id("hotelSearchOneBox");
    By guestsDropDown = By.id("room1Adults");
    By numberOfGuests = By.xpath("//select[@id='room1Adults'=true()]/option[@value='2']");
    By confirmBtn = By.xpath("//span[text()=' Go']");

    //********************************Page Methods*********************************
    public SearchForm specifyCityToStay() {
        writeText(cityToStay, city);
        return new SearchForm(driver);
    }

    public SearchForm numberOfGuests() {
        click(guestsDropDown);
        click(numberOfGuests);
        return new SearchForm(driver);
    }

    public SearchForm confirm() {
        click(confirmBtn);
        return this;
    }
}


