package hiltonPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Logger log;

    //Construtor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        log = LogManager.getRootLogger();
    }

    //Wait method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Click method for single element
    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Show Random from listed hotels
    public void showRandom(By elementBy) {
        waitVisibility(elementBy);
        List<WebElement> hotels = driver.findElements(elementBy);
        Random random = new Random();
        System.out.println("Рекомендуемый отель: " + "'" + hotels.get(random.nextInt(hotels.size())).getText() + "'.");

    }

    //Show Expensive from listed hotels
    public void showExpensive(By elementBy) {
        List<WebElement> hotels = driver.findElements(elementBy);

        System.out.println("\n" + "Самая дорогая стоимость проживания за ночь: " +"'"
                +hotels.get(hotels.size()-1).getText()+"'.");

    }

    //Write text method
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

}

