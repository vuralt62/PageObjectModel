package base;

import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseApi {

    public Response get(Map<String,?> params, String path) {
        return given().params(params).get(path).then().extract().response();
    }

    public Document toHtml(Response response) {
        return Jsoup.parse(response.asString());
    }

    public boolean checkTitle(Document document, String keyword) {
        return document.title().contains(keyword);
    }

}
