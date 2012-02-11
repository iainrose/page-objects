import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage extends AbstractPageObject {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getUniqueElement() {
        return By.cssSelector("div#hmenus");
    }

    By menuBarLocator = By.cssSelector("div#hmenus");
    By questionsTabLocator = By.id("nav-questions");

    public QuestionsPage clickQuestionsTab() {
        WebElement questionsTab = driver.findElement(questionsTabLocator);
        questionsTab.click();
        return new QuestionsPage(driver);
    }

    public Boolean isQuestionsTabDisplayed() {
        List<WebElement> questionsTab = driver.findElements(questionsTabLocator);
        return questionsTab.size() > 0;
    }
}
