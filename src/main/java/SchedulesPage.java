import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SchedulesPage extends AbstractPageObject {

    public SchedulesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getUniqueElement() {
        return By.cssSelector(".schedules");
    }

    By schedulesMenuSelector = By.cssSelector("#secondary.menu");

    public Boolean isSchedulesMenuDisplayed() {
        List<WebElement> schedulesMenu = driver.findElements(schedulesMenuSelector);
        return schedulesMenu.size() > 0;
    }
}
