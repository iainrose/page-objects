import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static final String WEB_SERVER = System.getProperty("WEB_SERVER", "http://stackoverflow.com/");
    protected static final String BROWSER = System.getProperty("BROWSER", "firefox");

    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void suiteSetup() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void loadWebApplication() {
        driver.get(WEB_SERVER);
    }

    @AfterMethod(alwaysRun = true)
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite(alwaysRun = true)
    public void suiteTearDown() {
        driver.quit();
    }

}