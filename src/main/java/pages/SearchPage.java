package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static elements.Elements.SEARCHBOX;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        clear(SEARCHBOX);
        sendKeys(SEARCHBOX, text);
        sendKeys(SEARCHBOX, Keys.ENTER);
    }

    public boolean checkUrl(String keyword){
        return getCurrentUrl().split("q=")[1].substring(0, keyword.length()).toLowerCase().equals(keyword.toLowerCase());
    }

    public boolean checkPageTitle(String keyword) {
        return getTitle().contains(keyword);
    }
}
