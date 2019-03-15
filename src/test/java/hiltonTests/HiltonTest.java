package hiltonTests;


import hiltonPages.ResultPage;
import hiltonPages.StartPage;
import hiltonPages.SearchForm;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HiltonTest extends BaseTest {
    @Test(priority = 0)
    public void enterAdvancedSearchForm() {
        //PAGE INSTANCE
        StartPage startPage = new StartPage(driver);
        //PAGE METHODS
        startPage.goToUrl()
                .chooseLangRadio()
                .clickContinue()
                .clickAdvancedSearch();

        //risky point
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www3.hilton.com/en/index.html?ignoreGateway=true");

    }

    @Test(priority = 1)
    public void fillSearchForm() {
        //PAGE INSTANCE
        SearchForm searchForm = new SearchForm(driver);
        //PAGE METHODS
        searchForm.specifyCityToStay()
                .numberOfGuests()
                //  .periodToStay()
                .confirm();


    }

    @Test(priority = 2)
    public void chooseRandomHotel() {
        //PAGE INSTANCE
        ResultPage result = new ResultPage(driver);
        //PAGE METHODS
        result.chooseRandom();
        //Вывести в лог название отеля и сумму за проживание

    }

    @Test(priority = 3)
    public void chooseExpensiveHotel() {
        //PAGE INSTANCE
        ResultPage resultExpensive = new ResultPage(driver);
        //PAGE METHODS
        resultExpensive.chooseExpensive();
        //Вывести в лог название отеля и сумму за проживание

    }

}
