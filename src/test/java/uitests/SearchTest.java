package uitests;

import base.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import pages.SearchPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchTest extends BaseTest {
    SearchPage searchPage;
    @Test
    public void search(){
        searchPage = new SearchPage(driver);
        String keyword = "phone";
        searchPage.search(keyword);
        Assertions.assertTrue(searchPage.checkPageTitle(keyword),"Title Error");
        Assertions.assertTrue(searchPage.checkUrl(keyword));
    }
}
