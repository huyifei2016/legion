package apiscript;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestAcct3633 {

private static RequestSpecification requestSpecification;
@DataProvider
public Object[][] acct3633()
{
    return new Object[][]{new String[]{"/weekday","[0].id","WEEKDAY_MONDAY"},new String[]{"/PaymentTransactionType","[0].id","PAYMENTTRANSACTIONTYPE_REFUND_STANDALONE"}
            ,new String[]{"CheckoutPaymentType","[0].id","CHECKOUTPAYMENTTYPE_MERCADOPAGO"}};
}

@BeforeClass
    public void beforeClass()
{
    requestSpecification=new RequestSpecBuilder().setBaseUri("http:///v3/enum").build();
}
@Test(dataProvider = "acct3633")
    public void testAcct3633(String[] data)
{
    RestAssured.given().spec(requestSpecification).get(data[0])
            .then()
            .assertThat()
            .body(data[1],equalTo(data[2]));
}


}
