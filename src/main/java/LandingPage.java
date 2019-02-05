import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class LandingPage extends AbstractPageObject {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    By menuBarLocator = By.cssSelector("#primary-links");
    By schedulesMenuLocator = By.className("Schedules");

    @Override
    protected By getUniqueElement() {
        return By.cssSelector("head title");
    }

    protected void isLoaded() throws Error {
        //Define a list of WebElements that match the unique element locator for the page
        List<WebElement> uniqueElement = driver.findElements(getUniqueElement());

        // Assert that the unique element is present in the DOM
        Assert.assertTrue((uniqueElement.size() > 0),
                "Unique Element \'" + getUniqueElement().toString() + "\' not found for " + this.getClass().getSimpleName());

        // Wait until the unique element is visible in the browser and ready to use. This helps make sure the page is
        // loaded before the next step of the tests continue.
        wait.until(ExpectedConditions.titleContains("Home"));
    }

    public SchedulesPage clickSchedulesMenu() {
        WebElement SchedulesMenu = driver.findElement(schedulesMenuLocator);
        SchedulesMenu.click();
        return new SchedulesPage(driver);
    }

    public Boolean isSchedulesMenuDisplayed() {
        List<WebElement> schedulesMenu = driver.findElements(schedulesMenuLocator);
        return schedulesMenu.size() > 0;
    }
}
