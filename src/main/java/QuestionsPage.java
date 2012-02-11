import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: iainrose
 * Date: 12-02-10
 * Time: 9:04 PM
 * To change this template use File | Settings | File Templates.
 */
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
