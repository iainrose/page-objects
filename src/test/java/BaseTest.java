import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static final String WEB_SERVER = System.getProperty("WEB_SERVER", "http://stackoverflow.com/");
    protected static final String BROWSER = System.getProperty("BROWSER", "firefox");
    protected static final boolean REMOTE_DRIVER = Boolean.valueOf(System.getProperty("REMOTE_DRIVER", "false"));
    protected static final String SELENIUM_HOST = System.getProperty("SELENIUM_HOST", "10.0.1.20");
    protected static final int SELENIUM_PORT = Integer.valueOf(System.getProperty("SELENIUM_PORT", "4444"));

    public static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void suiteSetup() throws Exception {
        if (REMOTE_DRIVER) {
            DesiredCapabilities capabilities;
            if (BROWSER.equals("firefox")) {
                capabilities = DesiredCapabilities.firefox();
            } else if (BROWSER.equals("internetExplorer")) {
                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            } else if (BROWSER.equals("chrome")) {
                capabilities = DesiredCapabilities.chrome();
            } else {
                throw new RuntimeException("Browser type unsupported");
            }
            driver = new RemoteWebDriver(
                    new URL("http://" + SELENIUM_HOST + ":" + SELENIUM_PORT + "/wd/hub"),
                    capabilities);
        } else if (BROWSER.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (BROWSER.equals("chrome")) {
            String path = "lib/chromedriver";
            if (System.getProperty("os.name").contains("Windows")) {
                path = "lib/chromedriver.exe";
            }
            System.setProperty("webdriver.chrome.driver", path);
            driver = new ChromeDriver();
        } else if (BROWSER.equals("internetExplorer")) {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(capabilities);
        } else {
            throw new RuntimeException("Browser type unsupported");
        }
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

    @AfterClass(alwaysRun = true)
    public void suiteTearDown() {
        driver.quit();
    }

}