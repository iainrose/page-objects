import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    public ExampleTest() {
        super();
    }

    @Test(groups = { "group1" })
    public void clickQuestionsTest() {
        LandingPage landingPage = new LandingPage(driver);
        QuestionsPage questionsPage = landingPage.clickQuestionsTab();
        Assert.assertTrue(questionsPage.isUsersTabDisplayed());
    }

    @Test(groups = { "group2" })
    public void isLogoDisplayedTest() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isQuestionsTabDisplayed());
    }

}