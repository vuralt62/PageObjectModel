package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    public WebDriver driver;

    public enum Browsers{
        CHROME, EDGE, FIREFOX,
    }

    @Before
    public void setUp() {
        driverSetup(Browsers.CHROME);
        driver = getDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void driverSetup(Browsers browserType){
        switch (browserType){
            case CHROME:
                WebDriverManager.chromedriver().setup();
            case EDGE:
                WebDriverManager.edgedriver().setup();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
            default: WebDriverManager.chromedriver().setup();
        }
    }

    private WebDriver getDriver(Browsers browserType){
        return switch (browserType) {
            case CHROME -> new ChromeDriver();
            case EDGE -> new EdgeDriver();
            case FIREFOX -> new FirefoxDriver();
        };
    }
}
