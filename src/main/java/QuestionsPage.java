import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QuestionsPage extends AbstractPageObject {

    public QuestionsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getUniqueElement() {
        return By.cssSelector(".youarehere #nav-questions");
    }

    By questionsTabSelectedLocator = By.cssSelector(".youarehere #nav-questions");
    By usersTabLocator = By.id("nav-users");

    public Boolean isUsersTabDisplayed() {
        List<WebElement> usersTab = driver.findElements(usersTabLocator);
        return usersTab.size() > 0;
    }
}
