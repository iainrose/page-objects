import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    public ExampleTest() {
        super();
    }

    @Test(groups = {"group1"})
    public void clickSchedulesMenu() {
        LandingPage landingPage = new LandingPage(driver);
        SchedulesPage schedulesPage = landingPage.clickSchedulesMenu();
        Assert.assertTrue(schedulesPage.isSchedulesMenuDisplayed());
    }

    @Test(groups = {"group1"})
    public void verifySchedulesMenuDisplayed() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isSchedulesMenuDisplayed());
    }

}

