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

    By searchButtonLocator = By.cssSelector("[value=\"Google Search\"]");

    @Override
    protected By getUniqueElement() {
        return By.cssSelector("[name=q]");
    }

    public Boolean isSearchButtonDisplayed() {
        List<WebElement> searchButton = driver.findElements(searchButtonLocator);
        return searchButton.size() > 0;
    }
}
