package apiscript;




import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsIterableContaining.hasItem;


public class Persona   {
    //私人订制接口

    /*有A面喷绘的商品code对应参数值*/
    public static Integer code1 = 1004441;
    /*无A面喷绘的商品code*/
    public static Integer code_no = 1004442;
    private static int code =0;
    private static int pic_code =0;
    @Test
    //存在A面喷绘的商品code及获取定制商品图片编码code
    public void testGetHtml1() {
//        获取code值，验证
      code=
        given()
                .queryParam("code",code1)
                .when()
                .get()
                .then()
                .log().all()
//               校验A面喷绘数据
                .body("result.A面.showPrice",hasItems("A面喷绘费(299.00)","A面喷绘费0元(0.00)","A面喷绘费1元(1.00)"))
                .body("massage",equalTo("查询成功"))
        .extract().path("result.A面[0].code");

    }

    @Test
    //不存在A面喷绘的商品code
    public void testGetHtml2() {

        given()
                .queryParam("code",code_no)
                .when()
                .get()
                .then()
                .log().all()
//               校验A面喷绘数据
                .body("massage",equalTo("未查出有效数据"));


    }
    @Test
    //根据图片编码查询图片分类名称
    public void testGetHtml3() {
        pic_code=
        given()
                .queryParam("code",code)
                .when()
                .get()
                .then()
                .log().all()
                .body("result.data.cateName",hasItem("世界杯系列"))
                .extract().path("result.data.picArr[0].code[0]");


    }
    @Test
    //查询喷绘效果图
    public void testGetHtml4() {
        given()
                .queryParam("code",pic_code)
                .queryParam("materialNumber","81QM000XCD")
                .when()
                .get()
                .then()
                .log().all()
                .body("result.code",equalTo("10000053_81QM000XCD"))
                .body("result.data[0]",equalTo(""));

    }
}
