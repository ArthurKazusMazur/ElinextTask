package hiltonPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.System.*;

public class ResultPage extends BasePage {
    //Construtor
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    //Web Elements
    By randomHotel = By.xpath("(//h2/a/span)[not(text()=' link opens in a new tab.')]");
    By sortByprice = By.id("sortHotelSearchResults");
    By priceClick = By.xpath("//option[text()='Price']");
 //   By expensiveHotel = By.xpath("//h3/ins");

    //Page Methods
    public ResultPage chooseRandom() {
        showRandom(randomHotel);
        return this;
    }

    public ResultPage chooseExpensive() {
        click(sortByprice);
        click(priceClick);
        showExpensive(randomHotel);
        return this;

    }
}
