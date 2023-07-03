package apiscript;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Servicelist {
    //服务捆绑
    public static String  Service_URL="";
    /*有规格关联的商品code*/
    public static Integer cate_code = 1000552;
    /*未做服务捆绑*/
    public static Integer ser_code = 1005193;
    @Test
    //有服务捆绑的商品
    public void testGetHtml1() {
        Response response=
        given()
                .queryParam("code",cate_code)
                .when()
                .get(Service_URL)
                .then()
                .log().all()
                .extract().response();
        Object json1=response.jsonPath().get("data[0].code");
        Object json2=response.jsonPath().get("data[0].serviceGoodsAppPrice");
        Object json2_1=response.jsonPath().get("data[0].serviceGoodsPcPrice");
        Object json3=response.jsonPath().get("data[0].serviceGoodsName");
        Object json4=response.jsonPath().get("data[1].code");
        Object json5=response.jsonPath().get("data[2].code");
        Object json6=response.jsonPath().get("data[3].code");
        Assert.assertEquals(json1,"50569");
        Assert.assertTrue(json2.equals(88));
        Assert.assertTrue(json2_1.equals(88));
        Assert.assertTrue(json3.equals("【新机特惠】新机开荒"));
        Assert.assertEquals(json4,"1003981");
        Assert.assertEquals(json5,"1004883");
        Assert.assertEquals(json6,"1004774");

    }
    @Test
    //无服务捆绑的商品
    public void testGetHtml2() {
        Response response=
                given()
                        .queryParam("code",ser_code)
                        .when()
                        .get(Service_URL)
                        .then()
                        .log().all()
                        .extract().response();
        Object json1=response.jsonPath().get("data");
        Assert.assertEquals(json1,null);

    }
}
