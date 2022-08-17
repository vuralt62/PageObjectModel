package apitests;

import base.BaseApiTest;
import io.restassured.response.Response;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static elements.ApiElements.SEARCHPATH;

public class SearchApiTest extends BaseApiTest {
    @Test
    public void searchtest() {
        String keyword = "telefon";
        Map<String,String> params = new HashMap<>();
        params.put("q", keyword);
        Response res = baseApi.get(params, SEARCHPATH);
        Document document = baseApi.toHtml(res);

        Assertions.assertEquals(res.statusCode(), 200, "Başarısız istek");
        Assertions.assertTrue(baseApi.checkTitle(document, keyword), "Hatalı başlık");
    }
}
