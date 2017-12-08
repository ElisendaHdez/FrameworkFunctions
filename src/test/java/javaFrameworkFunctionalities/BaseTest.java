package javaFrameworkFunctionalities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class BaseTest {
    public RemoteWebDriver driver;
    public Actions hover;
    public static long timeOut = 120;
    public static LocalRemoteWebDriverWait wait;
    public static JavascriptExecutor jse;

    @Before
    public void setUp() throws IOException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //Per Linux: System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" +
                //File.separator + "chromedriver-linux");
        //Per Windows:
        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources"
                + File.separator + "chromedriver.exe");
        driver = new ChromeDriver(capabilities);
        //Per Firefox:
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //System.setProperty("webdriver.gecko.driver",
        //        "src" + File.separator + "main"
        //                + File.separator + "resources"
        //                + File.separator + "geckodriver-linux");
       // driver = new FirefoxDriver(capabilities);
        wait = new LocalRemoteWebDriverWait(driver, timeOut);
        hover = new Actions(driver);
        driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(timeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
