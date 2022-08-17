package base;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;

public class BaseApiTest {
    public BaseApi baseApi;
    @Before
    public void setup(){
        baseApi = new BaseApi();
        String baseUrl = "https://www.google.com.tr/";
        RestAssured.baseURI = baseUrl;
        System.out.println("Test is starting");
    }

    @After
    public void tearDown(){
        System.out.println("Test is finish");
    }
}
