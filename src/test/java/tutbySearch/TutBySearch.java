package tutbySearch;

import org.testng.annotations.Test;
import tutbyPage.MainPage;


public class TutBySearch extends TutBySearchBaseTest {

    @Test
    public void letsSearchForLus() {
        MainPage mainPage = new MainPage(driver);
        mainPage.Url()
                .searchLu();
    }
}
