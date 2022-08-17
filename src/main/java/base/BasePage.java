package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class BasePage {

    private WebDriver driver;
    private Wait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait <WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    protected WebElement findElement(By locator){
        return (WebElement) wait.until(new Function<WebDriver, WebElement>(){
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    protected List<WebElement> findElements(By locator){
        return (List<WebElement>) wait.until(new Function<WebDriver, List<WebElement>>(){
            @Override
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(locator);
            }
        });
    }

    protected void click(By locator){
        findElement(locator).click();
    }

    protected String getText(By locator){
        return findElement(locator).getText();
    }

    protected void sendKeys(By locator, CharSequence text){
        findElement(locator).sendKeys(text);
    }

    protected void clear(By locator) {
        findElement(locator).clear();
    }

    protected String getAttribute(By locator,String name){
        return findElement(locator).getAttribute(name);
    }

    public void driverWait(int miliSeconds){
        try {
            synchronized (driver)
            {
                driver.wait(miliSeconds);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
