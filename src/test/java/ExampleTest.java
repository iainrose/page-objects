import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    public ExampleTest() {
        super();
    }

    @Test(groups = {"group1"})
    public void verifyGoogleSearchDisplayed() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isSearchButtonDisplayed());
    }

}

