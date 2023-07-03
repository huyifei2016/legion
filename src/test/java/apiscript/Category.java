package apiscript;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Category {
    public static String  Category_URL="";
    public static Integer code_no = 1004442;
    public static Integer cate_code = 1000552;
    public  static String configuration_92812="i7-7700/Windows 10 家庭中文版/16G DDR4内存/1T+128G SSD/独立显卡/银黑色";
    public  static String configuration_1000552="i5-8400/8G DDR4内存/1T/独立显卡/Windows 10 家庭中文版/银黑色";
        @Test
    //商品配置了规格关联
    public void category1() {
            Response response=
                    given()
                            .params("code",cate_code)
                            .params("version",1.0)
                            .get(Category_URL)
                            .then()
                            .log().all()
                            .extract().response();
            Object json1=response.jsonPath().get("result.92812.选择配置");
            Object json2=response.jsonPath().get("result.1000552.选择配置");
            Assert.assertTrue(json1.equals(configuration_92812));
            Assert.assertTrue(json2.equals(configuration_1000552));
    }
    @Test
    //商品未配置规格关联
   public void category2() {
Response response=
        given()
                .params("code",code_no)
                .params("version",1.0)
                .get(Category_URL)
                .then()
                .log().all()
                .extract().response();
        Object json1=response.jsonPath().get("result.1004442");
        Assert.assertEquals(json1,null);

    }

    }
