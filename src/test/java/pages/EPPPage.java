package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EPPPage {
    public WebDriver PageDriver;

    public EPPPage(WebDriver driver) {
        this.PageDriver = driver;
        PageFactory.initElements(PageDriver, this);
    }
    //EPP header
    @FindBy(how = How.XPATH, using = "(//*[@id='top-nav']/li/a)[1]")
    public WebElement lenovoOffcial;
    @FindBy(how = How.XPATH, using = "(//*[@id='top-nav']/li/a)[2]")
    public WebElement internalBuyMall;

    //home page login

    @FindBy(how = How.XPATH, using = "//input[contains(@class,'input account')]")
    public WebElement Login_EmailTextBox;
    @FindBy(how = How.XPATH, using = "//input[contains(@class,'input pwd')]")
    public WebElement Login_PasswordTextBox;
    @FindBy(how = How.CLASS_NAME, using = "submit")
    public WebElement Login_SignInButton;
    @FindBy(how = How.LINK_TEXT, using = "商城")
    public WebElement shop;

}


