package apiscript;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsIterableContaining.hasItem;


public class Stock_Interface {

    public static String STOCK_SERVER_URL = "";
    /*以下为普通商品库存、秒杀活动库存、预约抢购库存*/
    public static String proInfos_Nor = "[{activityType:0, productCode:1005193}]";
    public static String proInfos_Sec = "[{activityType:2, productCode:1000552}]";
    public static String proInfos_Re = "[{activityType:3, productCode:1004014}]";
    /*不存在的活动类型*/
    public static String proInfos_Null = "[{activityType:Test, productCode:1004014}]";
    /*不存在的商品code*/
    public static String proInfos_code = "[{activityType:0, productCode:Test4014}]";

    @Test
    //普通商品库存
    public void testGetHtml1() {
        given()
                .queryParam("proInfos",proInfos_Nor)
         .when()
                .get(STOCK_SERVER_URL)
          .then()
                .log().all()
//               校验库存数量和活动类型
//                .body("salesNumber",hasItem("657"))
                .body("activityType",hasItem("0"));

    }
    @Test
    //秒杀商品库存
    public void testGetHtml2() {
        given()
                .queryParam("proInfos",proInfos_Sec)
                .when()
                .get(STOCK_SERVER_URL)
                .then()
                .log().all()
//                .body("salesNumber",hasItem("12"))
                .body("activityType",hasItem("2"));
    }
      @Test
    //预约商品库存
    public void testGetHtml3() {
        given()
                .queryParam("proInfos",proInfos_Re)
                .when()
                .get(STOCK_SERVER_URL)
                .then()
                .log().all()
                .body("salesNumber",hasItem("11"))
                .body("activityType",hasItem("3"));
    }
    @Test
    //活动类型不存
    public void testGetHtml4() {
        given()
                .queryParam("proInfos",proInfos_Null)
                .when()
                .get(STOCK_SERVER_URL)
                .then()
                .log().all()
                .body("msg",equalTo("参数解析错误"));
    }
    @Test
    //不存在的商品code
    public void testGetHtml5() {
        given()
                .queryParam("proInfos",proInfos_code)
                .when()
                .get(STOCK_SERVER_URL)
                .then()
                .log().all()
                .body("msg",equalTo("参数解析错误"))
                .body("rc",equalTo(401));
    }

}
