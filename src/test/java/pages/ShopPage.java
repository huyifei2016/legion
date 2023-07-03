package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopPage {
    public WebDriver PageDriver;

    public ShopPage(WebDriver driver) {
        this.PageDriver = driver;
        PageFactory.initElements(PageDriver, this);
    }
    //home page login
    @FindBy(how = How.CLASS_NAME, using = "login")
    public WebElement loginBtn;
    @FindBy(how = How.XPATH, using = "//input[contains(@class,'input account')]")
    public WebElement Login_EmailTextBox;
    @FindBy(how = How.XPATH, using = "//input[contains(@class,'input pwd')]")
    public WebElement Login_PasswordTextBox;
    @FindBy(how = How.CLASS_NAME, using = "submit")
    public WebElement Login_SignInButton;
    @FindBy(how = How.XPATH, using = "//*[@class='login_type login_account']")
    public WebElement LoginWithPwdOption;

    @FindBy(how = How.LINK_TEXT, using = "商城")
    public WebElement shop;

    //slide
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'swiper-button-prev')]")
    public WebElement slidePrevArrow;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'swiper-button-next')]")
    public WebElement slideNextArrow;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'swiper-wrapper') and contains(@style,'transform')]")
    public WebElement slideStyleValue;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class,'pagination-bullet')])[2]")
    public WebElement navBullet1;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class,'pagination-bullet')])[3]")
    public WebElement navBullet2;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class,'swiper-slide')])[1]/a")
    public WebElement slideImg;

    //list navigation
    @FindBy(how = How.LINK_TEXT, using = "Lenovo电脑")
    public WebElement lenovoPC;
    @FindBy(how = How.XPATH, using = "//a[contains(@latag,'横向导航二级_0_游戏本')]")
    public WebElement gameLaptop;
    @FindBy(how = How.LINK_TEXT, using = "轻薄本")
    public WebElement ultrabook;
    @FindBy(how = How.XPATH, using = "//a[contains(@latag,'2_便携本')]")
    public WebElement portableBook;
    @FindBy(how = How.XPATH, using = "//a[contains(@latag,'3_常规本')]")
    public WebElement normalPC;

    @FindBy(how = How.LINK_TEXT, using = "ThinkPad电脑")
    public WebElement thinkpadPC;
    @FindBy(how = How.XPATH, using = "//a[contains(@latag,'0_ThinkPad')]")
    public WebElement thinkPad;
    @FindBy(how = How.XPATH, using = "//a[contains(@latag,'_thinkplus_')]")
    public WebElement thinkplus;


    @FindBy(how = How.LINK_TEXT, using = "手机/通信")
    public WebElement mobileAndCommunicate;
    @FindBy(how = How.LINK_TEXT, using = "充值中心")
    public WebElement chargeCenter;

    @FindBy(how = How.LINK_TEXT, using = "智能产品")
    public WebElement smartPro;
    @FindBy(how = How.XPATH, using = "//a[contains(@latag,'家居_')]")
    public WebElement housePro;

    @FindBy(how = How.LINK_TEXT, using = "平板电脑")
    public WebElement tablet;
    @FindBy(how = How.LINK_TEXT, using = "配件/办公")
    public WebElement accAndOffice;
    @FindBy(how = How.XPATH, using = "//a[contains(@latag,'_电脑配件_')]")
    public WebElement pcAcc;
    @FindBy(how = How.LINK_TEXT, using = "增值服务")
    public WebElement valueAddService;
    @FindBy(how = How.XPATH, using = "//a[contains(@latag,'_系统服务_')]")
    public WebElement systemService;

    //quick access
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'quick-access-link') and contains(@latag,'充值中心')]")
    public WebElement chargeCenter_quick;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'quick-access-link') and contains(@latag,'会员福利')]")
    public WebElement vipBenefit;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'quick-access-link') and contains(@latag,'驱动下载')]")
    public WebElement driverDownload;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'quick-access-link') and contains(@latag,'小新铺子')]")
    public WebElement xiaoxinStore;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'quick-access-link') and contains(@latag,'拯救者联盟')]")
    public WebElement legionLeague;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'quick-access-link') and contains(@latag,'Think家族')]")
    public WebElement thinkFamily;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'quick-access-link') and contains(@latag,'手机新品')]")
    public WebElement mobileNewPro;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'quick-access-link') and contains(@latag,'刃天堂')]")
    public WebElement gamePC;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'quick-access-link') and contains(@latag,'选件')]")
    public WebElement accessory;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'quick-access-link') and contains(@latag,'智能')]")
    public WebElement smartThings;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'quick-access-link') and contains(@latag,'服务')]")
    public WebElement service;

    //charge center page
    @FindBy(how = How.XPATH, using = "//button[contains(@latag,'recharge_centrer_cost')]")
    public WebElement phoneRecharge;
    @FindBy(how = How.XPATH, using = "//button[contains(@latag,'recharge_centrer_data')]")
    public WebElement dataRecharge;

    //miaosha area
    @FindBy(how = How.XPATH, using = "//i[@class='left-txt-icon']")
    public WebElement lenovoMiaoshaTitle;
    @FindBy(how = How.XPATH, using = "//i[@class='slash-icon']")
    public WebElement slashIcon;
    @FindBy(how = How.XPATH, using = "//span[@class='left-round']")
    public WebElement leftRoundTime;
    @FindBy(how = How.XPATH, using = "//div[@class='flash-countdown-txt']")
    public WebElement leftTime;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'left-countdown-wrap timer')])[1]")
    public WebElement countdownTimer;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'left-countdown-wrap timer')]/i)[1]")
    public WebElement countdownHour;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'left-countdown-wrap timer')]/i)[2]")
    public WebElement countdownMin;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'left-countdown-wrap timer')]/i)[3]")
    public WebElement countdownSec;

    @FindBy(how = How.XPATH, using = "//span[@class='middle-round']")
    public WebElement middleRoundTime;
    @FindBy(how = How.XPATH, using = "//span[@class='current-round-txt']")
    public WebElement currentRoundText;
    @FindBy(how = How.XPATH, using = "//ul[@class='middle-product-list-ul']")
    public WebElement miaoshaProducts;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'selkill-pro')]//*/img)[1]")
    public WebElement miaoshaProImg1;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'selkill-pro')]//*/img)[2]")
    public WebElement discountProImg2;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'selkill-pro')]//*/img)[3]")
    public WebElement discountProImg3;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'selkill-pro')]//*/img)[4]")
    public WebElement discountProImg4;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'selkill-pro')]//*/span[@class='pro-detail-txt'])[1]")
    public WebElement miaoshaProInfo1;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'selkill-pro')]//*/span[@class='pro-detail-txt'])[2]")
    public WebElement discountProInfo2;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'selkill-pro')]//*/span[@class='pro-detail-txt'])[3]")
    public WebElement discountProInfo3;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'selkill-pro')]//*/span[@class='pro-detail-txt'])[4]")
    public WebElement discountProInfo4;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'pro-icon seckill')]/i")
    public WebElement miaoshaIcon1;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'pro-icon seckill')]/i")
    public WebElement miaoshaText1;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'pro-icon discount')]/i)[1]")
    public WebElement discountIcon2;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'pro-icon discount')]/span)[1]")
    public WebElement discountText2;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'pro-icon discount')]/i)[2]")
    public WebElement discountIcon3;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'pro-icon discount')]/span)[2]")
    public WebElement discountText3;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'pro-icon discount')]/i)[3]")
    public WebElement discountIcon4;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'pro-icon discount')]/span)[3]")
    public WebElement discountText4;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'currency-sign')])[1]")
    public WebElement currencySign;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'pro-cur-price')]/span[@class='pro-price'])[1]")
    public WebElement miaoshaPrice1;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'pro-cur-price')]/span[@class='pro-price'])[2]")
    public WebElement discountPrice2;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'pro-cur-price')]/span[@class='pro-price'])[3]")
    public WebElement discountPrice3;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'pro-cur-price')]/span[@class='pro-price'])[4]")
    public WebElement discountPrice4;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'del-sign')])[1]")
    public WebElement originCurrencySign;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'del-price')])[1]")
    public WebElement originPrice1;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'del-price')])[2]")
    public WebElement originPrice2;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'del-price')])[3]")
    public WebElement originPrice3;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'del-price')])[4]")
    public WebElement originPrice4;
    @FindBy(how = How.XPATH, using = "//a[contains(@latag,'更多_秒杀')]")
    public WebElement moreMiaosha;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'mdtitle')]")
    public WebElement miaoshaPageTitle;



    @FindBy(how = How.CSS, using = "#.about_lenovo > a:nth-child(1)")
    public WebElement aboutLenovo;

    @FindBy(how = How.XPATH, using = "//*[@id='jrgwc']")
    public WebElement addToCart;
    @FindBy(how = How.ID, using = "button_dhtz")
    public WebElement arrivalNote;
    @FindBy(how = How.ID, using = "ljgm")
    public WebElement buyNow;
    @FindBy(how = How.XPATH, using = "//p[contains(@class, 'cnxh-txt')]")
    public WebElement seeOther;
    @FindBy(how = How.XPATH, using = "//*[@id='image-wrap']")
    public WebElement seeOtherContentWrap;
    @FindBy(how = How.XPATH, using = "(//*[@class='pro-img-wrap']/img)[1]")
    public WebElement seeOtherProduct1;



    //cart page
    @FindBy(how = How.ID, using = "totalmoneyf")
    public WebElement totalPrice;

    // PassCode GateKeeper
    @FindBy(how = How.ID, using = "gatekeeper.passcode.id")
    public WebElement PasscodeGateKeeper_PasscodeTextBox;

    // SerialNumber GateKeeper
    @FindBy(how = How.ID, using = "gatekeeper.serialNumber.id")
    public WebElement SerialNumberGateKeeper_SerialNumberTextBox;
    @FindBy(how = How.ID, using = "gatekeeper.lastname.id")
    public WebElement SerialNumberGateKeeper_LastNameTextBox;

    // Registration GateKeeper
    @FindBy(how = How.ID, using = "gatekeeper.login.email.id")
    public WebElement RegistrationGateKeeper_LenovoIdTextBox;
    @FindBy(how = How.ID, using = "gatekeeper.login.password.id")
    public WebElement RegistrationGateKeeper_PasswordTextBox;

    // GateKeeper Common Login Button
    @FindBy(how = How.XPATH, using = "//*[@id='nemoGatekeeperForm']/button")
    public WebElement GateKeeper_LoginButton;
    // GateKeeper Common Login Button
    @FindBy(how = How.XPATH, using = "//*[@id='nemoLoginForm']//button")
    public WebElement RegisterGateKeeper_LoginButton;
    // GateKeeper Common Login Button
    @FindBy(how = How.XPATH, using = "//button[@class='mfp-close']")
    public WebElement HomePage_CloseAdvButton;

    // Account Elements
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'createAccount') or contains(@class,'register-button')] ")
    public WebElement Login_CreateAnAccountButton;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'register-button')]")
    public WebElement RegisterGateKeeper_CreateAnAccountButton;
    @FindBy(how = How.XPATH, using = "//input[contains(@id,'login.email.id')]")
    public WebElement Login_LenovoIDTextBox;
    @FindBy(how = How.XPATH, using = "//input[contains(@id,'login.password')]")
    public WebElement Login_LenovoPasswordTextBox;
    @FindBy(how = How.XPATH, using = ".//*[@id='nemoLoginForm']//button")
    public WebElement Login_LogInButton;
    @FindBy(how = How.XPATH, using = ".//*[@id='accErrorMsgs']/ul/li")
    public WebElement Login_ErrorMsg;
    @FindBy(how = How.XPATH, using = ".//div[@class='signInModule-content']//a[contains(@href,'my-account/orders')]")
    public WebElement MyAccount_ViewOrderHistoryLink;
    @FindBy(how = How.ID, using = "trackOrderStatus")
    public WebElement OrderHistory_TrackOrderStatus;
    @FindBy(how = How.XPATH, using = ".//*[@id='myAccount']//a[@class='linkLevel_2 link-hasNoChildren']")
    public WebElement MyAccount_LoginLink;

    //product detail page
    @FindBy(how = How.XPATH, using = "//*[@id='span_product_name']")
    public WebElement productName;
    @FindBy(how = How.XPATH, using = "//*[@class='dec']")
    public WebElement productBrief;
    @FindBy(how = How.XPATH, using = "//*[@class='price-show']")
    public WebElement price;
    @FindBy(how = How.XPATH, using = "//*[@class='price-show-del']")
    public WebElement price_origin;
    @FindBy(how = How.XPATH, using = "(//*[@class='guige-item-detail']/span)[1]")
    public WebElement proConfig;
    @FindBy(how = How.XPATH, using = "//*[@id='mayi_info']")
    public WebElement huabeiPay;
    @FindBy(how = How.XPATH, using = "//*[@class='good_code']/span")
    public WebElement productCode;
    @FindBy(how = How.XPATH, using = "(//*[@id='mayi_ul']//*[@class='inner'])[1]")
    public WebElement installmentSelect;
    @FindBy(how = How.XPATH, using = "//*[@class='button-pay']")
    public WebElement installmentPayButton;
    @FindBy(how = How.XPATH, using = "//*[@class='ppWrapper']/a")
    public WebElement loginCloseButton;
    @FindBy(how = How.XPATH, using = "//*[@class='bc_table_img']")
    public WebElement cartProImg;
    @FindBy(how = How.XPATH, using = "(//*[@class='ul-box']/li)[1]")
    public WebElement proDetail;
    @FindBy(how = How.XPATH, using = "(//*[@class='ul-box']/li)[2]")
    public WebElement configInfo;
    @FindBy(how = How.XPATH, using = "(//*[@class='ul-box']/li)[3]")
    public WebElement proEvaluation;
    @FindBy(how = How.XPATH, using = "//*[@id='tab_ljgm']/span[@class='button-pay tab-button-pay']")
    public WebElement buyNowTab;
    @FindBy(how = How.XPATH, using = "//*[@class='assess_tLeft']")
    public WebElement applauseRate;
    @FindBy(how = How.XPATH, using = "(//*[@class='good_item'])[1]")
    public WebElement configInfo_part1;
    @FindBy(how = How.XPATH, using = "//*[@id='total-evaluate-count']")
    public WebElement totalEvaluateCount;

    //checkout page
    @FindBy(how = How.XPATH, using = "//*[@class='infoBox goodsList']/p")
    public WebElement productList;
    @FindBy(how = How.XPATH, using = "//*[@class='fl proTitle']")
    public WebElement proName_checkout;

//    miaosha product detail page
    @FindBy(how = How.XPATH, using = "(//*[@class='contentImg'])[1]")
    public WebElement proImg1;
    @FindBy(how = How.XPATH, using = "//*[@id='countdown-text']")
    public WebElement countDownTimerTxt;

}


