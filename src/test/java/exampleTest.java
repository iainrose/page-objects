import org.testng.Assert;
import org.testng.annotations.Test;

public class exampleTest extends BaseTest {

    public exampleTest() {
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