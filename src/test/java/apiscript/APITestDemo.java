package apiscript;

import commonfunction.Dailylog;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITestDemo {
    @Test
    public void apiTestDemo() {
        RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri("http://service-store.sit.online.lenovo.com/v3/item").build();
        given().spec(requestSpecification)
                .body("{\"type\":\"NemoSMBEnumList\",\"key\":\"typePkString\",\"value\":\"8796183658578\"}")
                .contentType(ContentType.JSON).log().all()
                .post()
                .then()
                .assertThat()
                .body("[0].settings.typePkString", equalTo("8796183658578"));

    }

    @Test
    public void testProductDetailAPI() {
        //get product name
        RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri("https://papi.lenovo.com.cn/batch/get").build();
        String paramsString = "[{\"uri\":\"/batch/openapi/goods/detail/mget/B00001\",\"param\":{\"code\":1008232,\"ss\":798}},{\"uri\":\"/batch/promoapi/api/front/getPromoMsg.jhtm\",\"param\":{\"gcode\":1008232,\"terminal\":1,\"shopId\":1, \"ss\":798}}]";
        ResponseBody body = given()
                .spec(requestSpecification)
                .param("params", paramsString).urlEncodingEnabled(true).contentType(ContentType.HTML)
                .get()
                .getBody();
        String name = body.jsonPath().getString("data.result.1008232.detail.name");
        Dailylog.logInfo("Product name is: " + name);

        //get String response
        String res = given().spec(requestSpecification).
                param("params", paramsString).urlEncodingEnabled(true).contentType(ContentType.HTML)
                .log().all()
                .get().getBody()
                .asString();
        Dailylog.logInfo(res);
    }
}
