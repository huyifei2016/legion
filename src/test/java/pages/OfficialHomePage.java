package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class OfficialHomePage {
    public WebDriver PageDriver;

    public OfficialHomePage(WebDriver driver) {
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
    @FindBy(how = How.XPATH, using = "//div[@class='hd-logo']")
    public WebElement headLogo;
    @FindBy(how = How.LINK_TEXT, using = "商城")
    public WebElement shop;
    @FindBy(how = How.LINK_TEXT, using = "服务")
    public WebElement service;
    @FindBy(how = How.LINK_TEXT, using = "品牌")
    public WebElement brand;
    @FindBy(how = How.LINK_TEXT, using = "社区")
    public WebElement community;
    @FindBy(how = How.LINK_TEXT, using = "会员")
    public WebElement vip;
    @FindBy(how = How.LINK_TEXT, using = "门店")
    public WebElement stores;
    @FindBy(how = How.LINK_TEXT, using = "企业购")
    public WebElement enterprisePurchase;
    @FindBy(how = How.XPATH, using = "//li[@class='hd-right-search']")
    public WebElement searchButton;
    @FindBy(how = How.XPATH, using = "//a[@class='login']")
    public WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//a[@class='regist_btn_plat']")
    public WebElement registerButton;
    @FindBy(how = How.XPATH, using = "//img[@class='hd-shopping-car']")
    public WebElement cartButton;

    @FindBy(how = How.XPATH, using = "(//div[@class='content-area']/ul/li)[1]")
    public WebElement personHeader;
    @FindBy(how = How.XPATH, using = "(//div[@class='content-area']/ul/li)[2]/a")
    public WebElement smbHeader;
    @FindBy(how = How.CSS, using = "li.hd-cc-li:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > p:nth-child(1) > span:nth-child(1)")
    public WebElement majorClientHeader;


    @FindBy(how = How.LINK_TEXT, using = "游戏本")
    public WebElement gameLaptop;
    @FindBy(how = How.LINK_TEXT, using = "轻薄本")
    public WebElement ultrabook;
    @FindBy(how = How.LINK_TEXT, using = "便携本")
    public WebElement portableBook;
    @FindBy(how = How.XPATH, using = "//*[contains(@latag,'_ThinkPad电脑')]")
    public WebElement ThinkPad;
    @FindBy(how = How.LINK_TEXT, using = "智能产品")
    public WebElement smartProducts;
    @FindBy(how = How.LINK_TEXT, using = "智能平板")
    public WebElement smartPad;
    @FindBy(how = How.LINK_TEXT, using = "存储设备")
    public WebElement storageDevice;

    @FindBy(how = How.LINK_TEXT, using = "硬件升级")
    public WebElement hardwareUpgrade;
    @FindBy(how = How.LINK_TEXT, using = "Motorola")
    public WebElement motorola;
    @FindBy(how = How.LINK_TEXT, using = "台式电脑")
    public WebElement desktop;

    @FindBy(how = How.LINK_TEXT, using = "智能电视")
    public WebElement smartTV;
    @FindBy(how = How.LINK_TEXT, using = "清洁保养")
    public WebElement cleanAndMaintain;
    @FindBy(how = How.LINK_TEXT, using = "诊断维修")
    public WebElement diagnose;
    @FindBy(how = How.LINK_TEXT, using = "数据恢复")
    public WebElement dataRecovery;
    @FindBy(how = How.LINK_TEXT, using = "微视频服务专区")
    public WebElement microVideoService;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "品牌愿景")
    public WebElement brandVision;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "品牌荣誉")
    public WebElement brandHonor;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "品牌纪事")
    public WebElement brandChronicle;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "品牌行动")
    public WebElement brandOperation;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "品牌公益")
    public WebElement brandPublicWelfare;

    @FindBy(how = How.CSS, using = ".right")
    public WebElement slideArrow_right;
    @FindBy(how = How.CSS, using = ".left")
    public WebElement slideArrow_left;
    @FindBy(how = How.XPATH, using = "(//div[@class='fi-item']/a/img)[1]")
    public WebElement slideImg;
    @FindBy(how = How.XPATH, using = "(//div[@class='fi-item'])[1]")
    public WebElement slideStyleValue;


    @FindBy(how = How.XPATH, using = "(//div[@class='tab_navTop ']/ul/li/p)[1]")
    public WebElement personTab;
    @FindBy(how = How.XPATH, using = "(//div[@class='tab_navTop ']/ul/li/p)[2]")
    public WebElement smbTab;
    @FindBy(how = How.XPATH, using = "(//div[@class='tab_navTop ']/ul/li/p)[3]")
    public WebElement governTab;
    @FindBy(how = How.XPATH, using = "(//div[@class='tab_navTop ']/ul/li/p)[4]")
    public WebElement dataCenterTab;
    @FindBy(how = How.XPATH, using = "(//div[@class='tab_navTop ']/ul/li/p)[5]")
    public WebElement smartProTab;

    @FindBy(how = How.LINK_TEXT, using = " 台式机")
    public WebElement lenovoDesktop;
    @FindBy(how = How.LINK_TEXT, using = " 笔记本")
    public WebElement lenovoNotebook;
    @FindBy(how = How.LINK_TEXT, using = " 电脑")
    public WebElement thinkpadComputer;
    @FindBy(how = How.LINK_TEXT, using = "选件/服务")
    public WebElement optionsServices;
    @FindBy(how = How.LINK_TEXT, using = "网课平板")
    public WebElement onlineTablet;

    @FindBy(how = How.LINK_TEXT, using = "办公电脑采购")
    public WebElement officeComputer;
    @FindBy(how = How.LINK_TEXT, using = "企业服务产品")
    public WebElement enterpriseServicePro;
    @FindBy(how = How.LINK_TEXT, using = "企业办公软件")
    public WebElement officeSoftware;
    @FindBy(how = How.LINK_TEXT, using = "企业会员中心")
    public WebElement enterpriseVipCenter;
    @FindBy(how = How.XPATH, using = "//*[contains(@latag,'ThinkPad_null')]/p")
    public WebElement thinkpad_smb;


    @FindBy(how = How.LINK_TEXT, using = "商用电脑")
    public WebElement businessComputer;
    @FindBy(how = How.LINK_TEXT, using = "商用IOT")
    public WebElement businessIOT;
    @FindBy(how = How.LINK_TEXT, using = "联想E采")
    public WebElement lenovoEPurchase;
    @FindBy(how = How.LINK_TEXT, using = "商用解决方案")
    public WebElement commercialSolutions;
    @FindBy(how = How.LINK_TEXT, using = "商用服务")
    public WebElement bussinessService;

    @FindBy(how = How.LINK_TEXT, using = "数据中心产品")
    public WebElement dataCenterPro;
    @FindBy(how = How.LINK_TEXT, using = "数据中心解决方案")
    public WebElement getDataCenterSolutions;

    @FindBy(how = How.LINK_TEXT, using = "")
    public WebElement leapPlatSoftware;
    @FindBy(how = How.LINK_TEXT, using = "专业技术服务")
    public WebElement specialTechServices;

    //    dibg.lenovo.com.cn header
    @FindBy(how = How.XPATH, using = "//li[@_t_nav='home']/a")
    public WebElement dataSmartHome;
    @FindBy(how = How.XPATH, using = "//li[@_t_nav='product']/a")
    public WebElement platSoftwarePro;
    @FindBy(how = How.XPATH, using = "//li[@_t_nav='solution']/a")
    public WebElement industrySolution;
    @FindBy(how = How.XPATH, using = "//li[@_t_nav='technicalService']/a")
    public WebElement technicalService;
    @FindBy(how = How.LINK_TEXT, using = "新闻资讯")
    public WebElement newsInfo;
    @FindBy(how = How.XPATH, using = "//li[@_t_nav='aboutUs']/a")
    public WebElement aboutUs;

    // dibg.lenovo.com.cn content
    @FindBy(how = How.XPATH, using = "//div[@class='center-eight']/div/h3")
    public WebElement dataSmartPlatPro;
    @FindBy(how = How.XPATH, using = "(//div/div[contains(@class, 'titleA')]/h4)[1]")
    public WebElement industrySolutionTitle;
    @FindBy(how = How.XPATH, using = "(//div/div[contains(@class, 'titleA')]/h4)[2]")
    public WebElement professionTechServTitle;
    @FindBy(how = How.XPATH, using = "(//div[@class='center-eight']/div/h4)[1]")
    public WebElement energizeCustomer;
    @FindBy(how = How.XPATH, using = "(//div[@class='center-eight']/div/h4)[2]")
    public WebElement cooperationPartner;
    //recommend products
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='name'])[1]")
    public WebElement recommendName1;
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='berif'])[1]")
    public WebElement recommendBrief1;
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='prie'])[1]")
    public WebElement recommendPrice1;
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='name'])[2]")
    public WebElement recommendName2;
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='berif'])[2]")
    public WebElement recommendBrief2;
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='prie'])[2]")
    public WebElement recommendPrice2;
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='name'])[3]")
    public WebElement recommendName3;
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='berif'])[3]")
    public WebElement recommendBrief3;
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='prie'])[3]")
    public WebElement recommendPrice3;
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='prie'])[1]/span")
    public WebElement recommendPriceNum1;
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='prie'])[2]/span")
    public WebElement recommendPriceNum2;
    @FindBy(how = How.XPATH, using = "(//div[@class='content']/p[@class='prie'])[3]/span")
    public WebElement recommendPriceNum3;


    //banner
    @FindBy(how = How.XPATH, using = "(//div[@class='gg_banner']/div[@class='gg_left']/a)[1]")
    public WebElement banner_left_personal;
    @FindBy(how = How.XPATH, using = "(//div[@class='gg_banner']/div[@class='gg_right']/div/a/img)[1]")
    public WebElement banner_right1;
    @FindBy(how = How.XPATH, using = "(//div[@class='gg_banner']/div[@class='gg_right']/div/a/img)[2]")
    public WebElement banner_right2;
    @FindBy(how = How.XPATH, using = "//div/a[contains(@latag,'_扬天')]")
    public WebElement banner_left_smb;
    @FindBy(how = How.XPATH, using = "//div/a[contains(@latag,'商用解决方案_0') or contains(@latag,'商用IOT_0') or contains(@latag,'商用电脑_0')]")
    public WebElement banner_left_govern;
    @FindBy(how = How.XPATH, using = "//div/a[contains(@latag,'数据中心产品_0') or contains(@latag,'数据中心解决方案_0')]")
    public WebElement banner_left_data;
    @FindBy(how = How.XPATH, using = "//div/a[contains(@latag,'平台级软件产品_0') or contains(@latag,'专业技术服务_0')]")
    public WebElement banner_left_smartPro;

    @FindBy(how = How.CSS, using = "#Header > a")
    public WebElement ileapcloudHeader;
    @FindBy(how = How.XPATH, using = "(//div[@class='title max'])[1]")
    public WebElement ileapTitle1;
    @FindBy(how = How.XPATH, using = "(//div[@class='title max'])[2]")
    public WebElement ileapTitle2;
    @FindBy(how = How.XPATH, using = "(//div[@class='title max'])[3]")
    public WebElement ileapTitle3;


    //successful case
    @FindBy(how = How.XPATH, using = "(//div/h2[@class='hotH2'])[1]")
    public WebElement successCase;
    @FindBy(how = How.XPATH, using = "(//div/a[@class='Hotmor'])[1]")
    public WebElement successCase_more;

    @FindBy(how = How.XPATH, using = "(//div[@class='swiper-wrapper']/div[@data-swiper-slide-index='0']/a/img)[2]")
    public WebElement successImg1;
    @FindBy(how = How.XPATH, using = "(//div[@class='swiper-wrapper']/div[@data-swiper-slide-index='1']/a/img)[2]")
    public WebElement successImg2;
    @FindBy(how = How.XPATH, using = "(//div[@class='swiper-wrapper']/div[@data-swiper-slide-index='2']/a/img)[2]")
    public WebElement successImg3;

    //market activity
    @FindBy(how = How.XPATH, using = "(//div/h2[@class='hotH2'])[2]")
    public WebElement marketActivity;
    @FindBy(how = How.XPATH, using = "(//div/a[@class='Hotmor'])[2]")
    public WebElement marketActivity_more;
    @FindBy(how = How.XPATH, using = "((//div[contains(@class,'Hotplate')])[2]/div/div[@data-swiper-slide-index='0']/a/img)[2]")
    public WebElement marketImg1;
    @FindBy(how = How.XPATH, using = "((//div[contains(@class,'Hotplate')])[2]/div/div[@data-swiper-slide-index='1']/a/img)[2]")
    public WebElement marketImg2;
    @FindBy(how = How.XPATH, using = "((//div[contains(@class,'Hotplate')])[2]/div/div[@data-swiper-slide-index='2']/a/img)[2]")
    public WebElement marketImg3;

    @FindBy(how = How.XPATH, using = "//div[@data-id='intro']")
    public WebElement conferenceIntro;
    @FindBy(how = How.LINK_TEXT, using = "返回官网")
    public WebElement returnOfficialSite;
    @FindBy(how = How.XPATH, using = "//span[@class='moblie-text']")
    public WebElement mobileWatch;
    @FindBy(how = How.XPATH, using = "//div[@class='img-banner']/img")
    public WebElement marketActBanner;
    @FindBy(how = How.XPATH, using = "//p[@class='btn-sign']")
    public WebElement attendMeeting;
    @FindBy(how = How.XPATH, using = "//p[@data-smarket-name='会议简介']")
    public WebElement conferenceBrief;
    @FindBy(how = How.XPATH, using = "//p[@data-smarket-name='底部版权']")
    public WebElement copyright;


    //news center
    @FindBy(how = How.XPATH, using = "//div/h2[@class='news_name']")
    public WebElement news_name;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'news_banner')]/div/div[@data-swiper-slide-index='0']/a/img)[2]")
    public WebElement newsImg;
    @FindBy(how = How.XPATH, using = "(//div[@class='news_left'])[1]")
    public WebElement news_left1;
    @FindBy(how = How.XPATH, using = "(//div[@class='news_left'])[2]")
    public WebElement news_left2;
    @FindBy(how = How.XPATH, using = "(//div[@class='news_left'])[3]")
    public WebElement news_left3;
    @FindBy(how = How.XPATH, using = "(//div[@class='news_right'])[1]")
    public WebElement news_right1;
    @FindBy(how = How.XPATH, using = "(//div[@class='news_right'])[2]")
    public WebElement news_right2;
    @FindBy(how = How.XPATH, using = "(//div[@class='news_right'])[3]")
    public WebElement news_right3;

    @FindBy(how = How.XPATH, using = "//div/a[@class='news_mor']")
    public WebElement news_more;

    @FindBy(how = How.XPATH, using = "//div/p[@class='details-title']")
    public WebElement newsDetailTitle;
    @FindBy(how = How.XPATH, using = "//p[@class='new-title']")
    public WebElement newsTitle;
    @FindBy(how = How.XPATH, using = "//div/span[@class='time']")
    public WebElement newsTime;
    @FindBy(how = How.XPATH, using = "//div/span[@class='browse look-over']")
    public WebElement browseTime;
    @FindBy(how = How.XPATH, using = "//div/span[@class='share']")
    public WebElement newsShare;
    @FindBy(how = How.LINK_TEXT, using = "品牌故事")
    public WebElement brandStory;
    @FindBy(how = How.LINK_TEXT, using = "合作伙伴&案例")
    public WebElement partnerAndCases;
    @FindBy(how = How.LINK_TEXT, using = "新闻&图像")
    public WebElement newsAndImages;
    @FindBy(how = How.LINK_TEXT, using = "市场活动")
    public WebElement marketingActivity;
    @FindBy(how = How.LINK_TEXT, using = "关于联想")
    public WebElement aboutLenovo_newsDetailTab;
    @FindBy(how = How.LINK_TEXT, using = "联想首页")
    public WebElement lenovoHomeLink;
    @FindBy(how = How.XPATH, using = "//li[@class='lis app_down']/span")
    public WebElement downloadApp;
    @FindBy(how = How.LINK_TEXT, using = "成功案例")
    public WebElement successCase_newsDetail;
    @FindBy(how = How.XPATH, using = "//*[contains(@latag,'_产品发布_')]")
    public WebElement productRelease;
    @FindBy(how = How.LINK_TEXT, using = "合作伙伴")
    public WebElement cooperatePartner;
    @FindBy(how = How.LINK_TEXT, using = "新闻")
    public WebElement brandNewsLink;
//    @FindBy(how = How.LINK_TEXT, using = "媒体图像")
//    public WebElement mediaImages;
    @FindBy(how = How.XPATH, using = "//a[contains(@latag,'媒体图像_1')]")
    public WebElement mediaImages;
    @FindBy(how = How.LINK_TEXT, using = "公司简介")
    public WebElement companyProfile;

    //news home page
    @FindBy(how = How.XPATH, using = "//span[@class='select_year']")
    public WebElement selectYear;
    @FindBy(how = How.XPATH, using = "//*[@id='time']")
    public WebElement time_newsHome;
    @FindBy(how = How.XPATH, using = "//*[@id='search']")
    public WebElement search_NewsHome;
    @FindBy(how = How.XPATH, using = "(//*[@class='btn-share share'])[1]")
    public WebElement share_newsHome;


    @FindBy(how = How.XPATH, using = "//p[@class='busuness-title']")
    public WebElement successCase_title;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'swiper-slide')]/a/img)[1]")
    public WebElement successSlideimg;
    @FindBy(how = How.XPATH, using = "//div[@id='startTimeAggs']/span[@class='type_title']")
    public WebElement year_successCase;
    @FindBy(how = How.XPATH, using = "//div[@id='industryCategory']/span[@class='type_title']")
    public WebElement industryCategory;
    @FindBy(how = How.XPATH, using = "//div[@id='industryKeyWord']/span[@class='type_title']")
    public WebElement industryKeyWord;
    @FindBy(how = How.XPATH, using = "//*[@id='search']")
    public WebElement searchBtn_successCase;
    @FindBy(how = How.XPATH, using = "//*[@id='time']")
    public WebElement time_successCase;
    @FindBy(how = How.XPATH, using = "//*[@id='icon-time-arrows']")
    public WebElement timeArrow;
    @FindBy(how = How.XPATH, using = "//*[@id='page-view']")
    public WebElement pageView;
    @FindBy(how = How.XPATH, using = "//*[@id='icon-pv-arrows']")
    public WebElement pageViewArrow;
    @FindBy(how = How.XPATH, using = "//div[@class='item-list']")
    public WebElement itemList;
    @FindBy(how = How.XPATH, using = "//div[@class='list-footer']")
    public WebElement listFooter;
    @FindBy(how = How.XPATH, using = "//*[@class='current prev']")
    public WebElement prevArrow;
    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'next')]")
    public WebElement nextArrow;
    @FindBy(how = How.XPATH, using = "//span[@class='item-show-txt']")
    public WebElement itemShowTxt;
    @FindBy(how = How.XPATH, using = "//div[@class='items-show-box']")
    public WebElement itemShowBox;
    @FindBy(how = How.XPATH, using = "//p[@class='logo-title-txt']")
    public WebElement parterTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='logo-wall-pic']")
    public WebElement parterImg;
    @FindBy(how = How.XPATH, using = "//div[@class='goTop']")
    public WebElement goTop;
    @FindBy(how = How.XPATH, using = "//div[@class='footer']")
    public WebElement footerArea;

    //hot plates
    @FindBy(how = How.XPATH, using = "(//div/h2[@class='hotH2'])[3]")
    public WebElement hotPlate;
    @FindBy(how = How.XPATH, using = "((//div[contains(@class,'Hotplate')])[3]/div/div[@data-swiper-slide-index='0']/a/img)[1]")
    public WebElement hotImg1;
    @FindBy(how = How.XPATH, using = "((//div[contains(@class,'Hotplate')])[3]/div/div[@data-swiper-slide-index='1']/a/img)[1]")
    public WebElement hotImg2;
    @FindBy(how = How.XPATH, using = "((//div[contains(@class,'Hotplate')])[3]/div/div[@data-swiper-slide-index='2']/a/img)[1]")
    public WebElement hotImg3;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'Hotplate')])[3]/*[@class='swiper-button-next']")
    public WebElement hotArrow_next;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'Hotplate')])[3]/*[@class='swiper-button-prev']")
    public WebElement hotArrow_prev;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'Hotplate')]/div[@class='swiper-wrapper'])[3]")
    public WebElement swiperStyleValue;



    //footer
    @FindBy(how = How.XPATH, using = "//li[@class='fl about_lenovo']")
    public WebElement aboutLenovo;
    @FindBy(how = How.LINK_TEXT, using = "投资者关系")
    public WebElement investorRelations;
    @FindBy(how = How.XPATH, using = "//a[@title='加入我们']")
    public WebElement joinUs;
    @FindBy(how = How.LINK_TEXT, using = "联系我们")
    public WebElement contactUs;
    @FindBy(how = How.LINK_TEXT, using = "参观联想")
    public WebElement visitLenovo;
    @FindBy(how = How.XPATH, using = "//a[@title='销售网点查询']")
    public WebElement saleSiteQuery;
    @FindBy(how = How.XPATH, using = "//a[@title='服务网点查询']")
    public WebElement serviceSiteQuery;

    @FindBy(how = How.XPATH, using = "//div[@class='mbx-nav']")
    public WebElement breadNavigation;


    @FindBy(how = How.XPATH, using = "//li[@class='fl shop_lenovo']")
    public WebElement lenovoShop;
    @FindBy(how = How.XPATH, using = "//a[@title='今日秒杀']")
    public WebElement todaySecondsKill;
    @FindBy(how = How.XPATH, using = "//a[@title='联想合伙人']")
    public WebElement lenovoPartner;
    @FindBy(how = How.XPATH, using = "//a[@title='私人定制']")
    public WebElement privateCustomize;
    @FindBy(how = How.XPATH, using = "//a[@title='以旧换新']")
    public WebElement oldChangeNew;
    @FindBy(how = How.XPATH, using = "//a[@title='积分商城']")
    public WebElement integralMall;


    @FindBy(how = How.XPATH, using = "//li[@class='fl service_lenovo']")
    public WebElement lenovoService;
    @FindBy(how = How.XPATH, using = "//a[@title='驱动与软件下载']")
    public WebElement driverSoftDownload;
    @FindBy(how = How.XPATH, using = "//a[@title='热门解决方案']")
    public WebElement hotSolutions;
    @FindBy(how = How.XPATH, using = "//a[@title='Lenovo Quick Fix工具']")
    public WebElement lenovoQuickFixTool;
    @FindBy(how = How.XPATH, using = "//a[@title='24小时智能客服']")
    public WebElement smartCustomerService;
    @FindBy(how = How.XPATH, using = "//a[@title='保修配置查询']")
    public WebElement warrantyConfigQuery;
    @FindBy(how = How.XPATH, using = "//a[@title='服务政策查询']")
    public WebElement servicePolicyQuery;
    @FindBy(how = How.XPATH, using = "//a[@title='上门快修']")
    public WebElement homeQuickRepair;
    @FindBy(how = How.XPATH, using = "//a[@title='延长保修']")
    public WebElement extendWarranty;
    @FindBy(how = How.XPATH, using = "//a[@title='更多服务']")
    public WebElement moreService;

    @FindBy(how = How.XPATH, using = "//li[@class='fl lenovo_website_group part-1']")
    public WebElement lenovoSites;
    @FindBy(how = How.XPATH, using = "//a[@title='联想创投']")
    public WebElement lenovoVenture;
    @FindBy(how = How.XPATH, using = "//a[@title='聚享汇']")
    public WebElement juxianghui;
    @FindBy(how = How.XPATH, using = "//a[@title='联想电脑管家']")
    public WebElement lenovoComputerButler;
    @FindBy(how = How.XPATH, using = "//a[@title='联想超融合']")
    public WebElement lenovoSuperfusion;
    @FindBy(how = How.XPATH, using = "//a[@title='联想研究院']")
    public WebElement lenovoResearchInstitute;
    @FindBy(how = How.XPATH, using = "(//a[@title='联想数据中心'])[1]")
    public WebElement lenovoDataCenter;
    @FindBy(how = How.XPATH, using = "(//a[@title='联想数据中心'])[2]")
    public WebElement lenovoFilez;

    @FindBy(how = How.XPATH, using = "//a[@title='联想百应平台']")
    public WebElement lenovoBaiyingPlat;
    @FindBy(how = How.XPATH, using = "//a[@title='联想租赁商城']")
    public WebElement lenovoLeasingMall;
    @FindBy(how = How.XPATH, using = "//a[@title='联想企业网盘']")
    public WebElement lenovoEnterpriseNetDisk;
    @FindBy(how = How.XPATH, using = "//a[@title='ThinkPad官网']")
    public WebElement thinkpadOfficialSite;
    @FindBy(how = How.XPATH, using = "//a[@title='lecoo商城']")
    public WebElement lecooMall;
    @FindBy(how = How.XPATH, using = "//a[@title='“联想大数据']")
    public WebElement lenovoBigData;
    @FindBy(how = How.XPATH, using = "//a[@title='联想商用官网']")
    public WebElement lenovoCommercialSite;


    @FindBy(how = How.XPATH, using = "//*[@class='clearfix social_plat']")
    public WebElement lenovoSocial;
    @FindBy(how = How.XPATH, using = "//div[@class='kef_phone']")
    public WebElement customerService;

    @FindBy(how = How.XPATH, using = "//div[@class='select_country']")
    public WebElement selectCountry;
    @FindBy(how = How.XPATH, using = "//div[@id='cn_img']")
    public WebElement chinaCountryImg;
    @FindBy(how = How.LINK_TEXT, using = "法律公告")
    public WebElement legalNotice;
    @FindBy(how = How.LINK_TEXT, using = "隐私权政策")
    public WebElement privacyPolicy;
    @FindBy(how = How.LINK_TEXT, using = "产品安全")
    public WebElement productSafty;
    @FindBy(how = How.XPATH, using = "//a[@title='营业执照']")
    public WebElement businessLicense;


    @FindBy(how = How.CSS, using = "#jrgwc")
    public WebElement addToCart;
    @FindBy(how = How.ID, using = "button_dhtz")
    public WebElement arrivalNote;
    @FindBy(how = How.ID, using = "ljgm")
    public WebElement buyNow;
    @FindBy(how = How.XPATH, using = "//p[contains(@class, 'cnxh-txt')]")
    public WebElement seeOther;

    //cart page
    @FindBy(how = How.ID, using = "totalmoneyf")
    public WebElement totalPrice;

    //thinkpad site
    @FindBy(how = How.XPATH, using = "//a[@class='logo']/img")
    public WebElement thinkpadLogo;
    @FindBy(how = How.XPATH, using = "//div[@class='official-title']")
    public WebElement officialSelection;

    //contact us page
    @FindBy(how = How.XPATH, using = "//div[@class='conpany_title']/span")
    public WebElement companyInfoTitle;
    @FindBy(how = How.XPATH, using = "(//div[@class='content_top']/div/p)[1]")
    public WebElement lenovoHeadquarter;
    @FindBy(how = How.XPATH, using = "(//div[@class='content_top']/div/p)[3]")
    public WebElement lenovoHeadAddr;
    @FindBy(how = How.XPATH, using = "(//div[@class='content_top']/div/p)[5]")
    public WebElement lenovoHeadTel;
    @FindBy(how = How.XPATH, using = "(//div[@class='content_top']/div/p)[6]")
    public WebElement lenovoAdmin;
    @FindBy(how = How.XPATH, using = "(//div[@class='content_top']/div/p)[8]")
    public WebElement lenovoAdminAddr;
    @FindBy(how = How.XPATH, using = "(//div[@class='content_top']/div/p)[9]")
    public WebElement lenovoAdminTel;
    @FindBy(how = How.XPATH, using = "//div[@class='content_center']/p")
    public WebElement lenovoChinaOperationCenter;
    @FindBy(how = How.XPATH, using = "(//div[@class='content_center']/ul/li)[1]")
    public WebElement lenovoChinaOperationBJ;
    @FindBy(how = How.XPATH, using = "//div[@class='content_bottom']/div/h2")
    public WebElement visitLenovo_contactUs;

    @FindBy(how = How.XPATH, using = "//div[@class='product_title']/span")
    public WebElement productTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='product_top']/h2")
    public WebElement PCMobile;
    @FindBy(how = How.XPATH, using = "//div[@class='product_first']/h3")
    public WebElement productFirst;
    @FindBy(how = How.XPATH, using = "//div[@class='product_second']/h3")
    public WebElement productSecond;
    @FindBy(how = How.XPATH, using = "//div[@class='product_four']/h3")
    public WebElement productFour;


    @FindBy(how = How.XPATH, using = "//div[@class='product_bottom']/h2")
    public WebElement commercialPCDCG;
    @FindBy(how = How.XPATH, using = "(//div[@class='product_first']/div/h3)")
    public WebElement commercialPCPurchaseConsult;


    @FindBy(how = How.XPATH, using = "//div[@class='fixed_titile']/span")
    public WebElement fixedTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='fixed_left']/div/h2")
    public WebElement onlineWarranty;
    @FindBy(how = How.XPATH, using = "//div[@class='fixed_center']/div/h2")
    public WebElement wechatService;
    @FindBy(how = How.XPATH, using = "//div[@class='fixed_right']/div/a/h2")
    public WebElement onlineCustomerService;

    //contact us footer
    @FindBy(how = How.XPATH, using = "(//a[@class='foot_top_title'])[1]")
    public WebElement shoppingGuideTitle;
    @FindBy(how = How.XPATH, using = "(//a[@class='foot_top_title'])[2]")
    public WebElement deliveryMethod;
    @FindBy(how = How.XPATH, using = "(//a[@class='foot_top_title'])[3]")
    public WebElement payMethod;
    @FindBy(how = How.XPATH, using = "(//a[@class='foot_top_title'])[4]")
    public WebElement orderInfo;
    @FindBy(how = How.XPATH, using = "(//a[@class='foot_top_title'])[5]")
    public WebElement afterSaleService;
    @FindBy(how = How.XPATH, using = "(//a[@class='foot_top_title'])[6]")
    public WebElement otherInstructions;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "购买流程")
    public WebElement buyProcess;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "物流查询")
    public WebElement deliveryQuery;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "分期支付")
    public WebElement installmentPayment;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "发票信息")
    public WebElement invoiceInfo;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "联想服务入口")
    public WebElement lenovoServiceEntry;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "账户安全")
    public WebElement accountSecurity;

    @FindBy(how = How.XPATH, using = "(//li[@class='fl social_platform'])")
    public WebElement customerServiceContact;

    //market activity home page(https://events.lenovo.com/)
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "首页")
    public WebElement homePage;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "总体介绍")
    public WebElement generalIntro;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "即将进行")
    public WebElement comingSoon;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "精彩专题")
    public WebElement goodSubject;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "全部活动")
    public WebElement allActivities;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "成功案例")
    public WebElement successCase_marketHome;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "热门资讯")
    public WebElement popularInfo;
    @FindBy(how = How.XPATH, using = "//div[@class='pc-image']/img")
    public WebElement marketActHomeImg;
    @FindBy(how = How.XPATH, using = "(//div[@id='introduction']/div/div/span)[1]")
    public WebElement generalIntroTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='info-desc']")
    public WebElement introInfo;
   @FindBy(how = How.XPATH, using = "(//div[@id='coming']//*/span)[1]")
    public WebElement comingSoonTitle;
   @FindBy(how = How.XPATH, using = "(//div[@class='item_content'])[1]")
    public WebElement marketAct1;
   @FindBy(how = How.XPATH, using = "(//div[@class='swiper-button-prev'])[1]")
    public WebElement comingSoonPrevArrow;
   @FindBy(how = How.XPATH, using = "(//div[@class='swiper-button-next'])[1]")
    public WebElement comingSoonNextArrow;
   @FindBy(how = How.XPATH, using = "//div[@id='topic']")
    public WebElement specTopic;
   @FindBy(how = How.XPATH, using = "//div[@class='swiper-button-prev']")
    public WebElement specTopicPreArrow;
   @FindBy(how = How.XPATH, using = "//div[@class='swiper-button-next']")
    public WebElement specTopicNextArrow;
   @FindBy(how = How.XPATH, using = "(//div[@class='img-box-content-desc '])[1]")
    public WebElement specTopic1;
    @FindBy(how = How.XPATH, using = "//div[@id='review']//*[@class='kj-title-container']/span")
    public WebElement allActivitiesTitle;
    @FindBy(how = How.XPATH, using = "//input[contains(@latag,'filter_keyword')]")
    public WebElement actSearchInput;
    @FindBy(how = How.XPATH, using = "//div[contains(@latag,'filter_select_行业')]")
    public WebElement actIndustryFilter;
    @FindBy(how = How.XPATH, using = "//div[contains(@latag,'filter_select_话题')]")
    public WebElement actTopicFilter;
    @FindBy(how = How.XPATH, using = "//div[contains(@latag,'filter_select_date')]")
    public WebElement actDateFilter;
    @FindBy(how = How.XPATH, using = "(//div[@class='replay-button'])[1]")
    public WebElement replayButton;
    @FindBy(how = How.XPATH, using = "(//div[@class='more']/span)[1]")
    public WebElement seeMore;
    @FindBy(how = How.XPATH, using = "//div[@id='successCase']")
    public WebElement successCase_marketAct;
    @FindBy(how = How.XPATH, using = "//div[@id='successCase']//div/span")
    public WebElement successCaseTitle_marketAct;
    @FindBy(how = How.XPATH, using = "(//*[@class='success-case-item-container']/a/img)[1]")
    public WebElement successCaseImg_marketAct1;
    @FindBy(how = How.XPATH, using = "(//*[@class='success-case-item-container']/a/p)[1]")
    public WebElement successCaseBrief_marketAct1;
    @FindBy(how = How.XPATH, using = "//*[@class='news-container']/div/span")
    public WebElement hotInfoTitle;
    @FindBy(how = How.XPATH, using = "//*[@class='news-container']/a")
    public WebElement hotInfoMoreBtn;
    @FindBy(how = How.XPATH, using = "(//*[@class='news-items-another']/div/img)[1]")
    public WebElement newsImg1_marketAct;
    @FindBy(how = How.XPATH, using = "(//*[@class='items-content']/div)[1]")
    public WebElement newsTitle1_marketAct;
    @FindBy(how = How.XPATH, using = "//div[@class='copyright-left']")
    public WebElement copyright_marketAct;

    @FindBy(how = How.XPATH, using = "//*[@class='list-footer']//*[contains(@class,'next')]")
    public WebElement nextArrow_successCaseHome;

    //investor relation page
    @FindBy(how = How.XPATH, using = "//div[@class='mobile-nav-icon']")
    public WebElement exploreIcon;
    @FindBy(how = How.XPATH, using = "//div[@class='logo']")
    public WebElement lenovoLogo;
    @FindBy(how = How.XPATH, using = "//form[@id='searchForm']")
    public WebElement searchForm;
    @FindBy(how = How.XPATH, using = "//a[@class='lang-btn']")
    public WebElement languageButton;
    @FindBy(how = How.XPATH, using = "//div[@class='slick-prev slick-arrow']")
    public WebElement slidePrevArrow;
    @FindBy(how = How.XPATH, using = "//div[@class='slick-next slick-arrow']")
    public WebElement slideNextArrow;
    @FindBy(how = How.XPATH, using = "(//div[@id='slick-slide01']/a/img)[1]")
    public WebElement slideImg_investor;
    @FindBy(how = How.XPATH, using = "//div[@class='slick-track']")
    public WebElement slideStyle_investor;
    @FindBy(how = How.XPATH, using = "//div[@class='pageTitle full-width']")
    public WebElement investorRelationsTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='width-50 newsWrapper']/h1")
    public WebElement latestInfoTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='width-50 newsWrapper']//*/a[@class='more']")
    public WebElement latestInfoMore;
    @FindBy(how = How.XPATH, using = "//div[@class='width-50 stockQuote']/h1")
    public WebElement stockInfoTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='width-50 stockQuote']//*/a[@class='more']")
    public WebElement stockInfoMore;
    @FindBy(how = How.XPATH, using = "//div[@class='homeBusiness']")
    public WebElement homeBusiness;
    @FindBy(how = How.XPATH, using = "//div[@class='homeBusiness']//*/a[@class='more']")
    public WebElement homeBusinessMore;
    @FindBy(how = How.XPATH, using = "//div[@class='homeData']")
    public WebElement homeData;
    @FindBy(how = How.XPATH, using = "//div[@class='homeData']//*/a[@class='more']")
    public WebElement homeDataMore;
    @FindBy(how = How.XPATH, using = "//div[@class='homeLatest']")
    public WebElement homeLatestPerform;
    @FindBy(how = How.XPATH, using = "//div[@class='homeReports']")
    public WebElement homeReports;
    @FindBy(how = How.XPATH, using = "(//div[@class='homeReports']//*/a[@class='more more_report'])[1]")
    public WebElement homeReportsMore;
    @FindBy(how = How.XPATH, using = "//div[@class='homeTeam']")
    public WebElement homeTeam;
    @FindBy(how = How.XPATH, using = "//div[@class='contentWrapper contact']")
    public WebElement investorContactInfo;
    @FindBy(how = How.XPATH, using = "//div[@class='row footer']")
    public WebElement investorFooter;
    @FindBy(how = How.XPATH, using = "//div[@class='footer-copywrite']")
    public WebElement copyright_investor;
    @FindBy(how = How.XPATH, using = "//*[@class='mfp-close']")
    public WebElement dialogCloseButton;
    @FindBy(how = How.XPATH, using = "//*[@class='tip_close']")
    public WebElement lenovoHomePopup;

    //join us: http://lenovocareers.com/chi/index.html
    @FindBy(how = How.XPATH, using = "//img[@alt='Lenovo logo']")
    public WebElement lenovoLogo_career;
    @FindBy(how = How.XPATH, using = "//a[@href='about.html']")
    public WebElement ahoutLenovo;
    @FindBy(how = How.XPATH, using = "//a[@href='why.html']")
    public WebElement whyLenovo;
    @FindBy(how = How.XPATH, using = "//a[@href='areas.html']")
    public WebElement careerArea;
    @FindBy(how = How.XPATH, using = "//a[@href='campus.html']")
    public WebElement campusRecruit;
    @FindBy(how = How.XPATH, using = "//a[@href='locations.html']")
    public WebElement locationsPage;
    @FindBy(how = How.XPATH, using = "(//li[@class='no-block']/a)[1]")
    public WebElement English;
    @FindBy(how = How.XPATH, using = "(//li[@class='no-block']/a)[2]")
    public WebElement Português;
    @FindBy(how = How.XPATH, using = "(//li[@class='no-block']/a)[3]")
    public WebElement Chinese;
    @FindBy(how = How.XPATH, using = "//div[@class='header-image header-homepage']")
    public WebElement headerImg;
    @FindBy(how = How.XPATH, using = "//img[@alt='search for jobs']")
    public WebElement searchJob;
    @FindBy(how = How.XPATH, using = "//div[@class='col-md-12 social-title']/h5")
    public WebElement shareJob;
    @FindBy(how = How.XPATH, using = "(//div[@class='col-md-12']/p)[1]")
    public WebElement content_career;
    @FindBy(how = How.XPATH, using = "//div[@class='col-md-9 footer-menu']")
    public WebElement footer_career;

    //visit Lenovo :http://www.lenovofuturecenter.com/Home
    @FindBy(how = How.XPATH, using = "//div[@class='navLogo']")
    public WebElement lenovoLogo_future;
    @FindBy(how = How.XPATH, using = "//a[@class='nav-home active']")
    public WebElement homeLink_future;
    @FindBy(how = How.XPATH, using = "//a[@class='nav-InnovationCenter']")
    public WebElement centerBrief;
    @FindBy(how = How.XPATH, using = "//a[@class='nav-Activities']")
    public WebElement groupAppointment;
    @FindBy(how = How.XPATH, using = "//a[@class='nav-intlActivities']")
    public WebElement publicActivity;
    @FindBy(how = How.XPATH, using = "//a[@class='nav-AboutUs']")
    public WebElement aboutUsFuture;
    @FindBy(how = How.XPATH, using = "//a[@class='nav-News']")
    public WebElement latestActivity;
    @FindBy(how = How.XPATH, using = "//div[@class='icoEN']")
    public WebElement iconEnglish;
    @FindBy(how = How.XPATH, using = "(//div[@class='slick-slide']//*/img)[1]")
    public WebElement slideImg_future;
    @FindBy(how = How.XPATH, using = "//div[@class='indexUs']")
    public WebElement lenovoFutureIndex;
    @FindBy(how = How.XPATH, using = "(//a[@class='btn btn-hollow'])[1]")
    public WebElement intoLenovoButton;
    @FindBy(how = How.XPATH, using = "//div[@class='datetimeP']")
    public WebElement dateSelection;
    @FindBy(how = How.XPATH, using = "(//div[@class='indexPhoto']//*/img)[1]")
    public WebElement indexPhoto;
    @FindBy(how = How.XPATH, using = "//ul[@class='indexAcitivites']")
    public WebElement indexActivities;
    @FindBy(how = How.XPATH, using = "(//a[@class='btn btn-hollow'])[2]")
    public WebElement indexActivitiesMore;
    @FindBy(how = How.XPATH, using = "//div[@class='footer']")
    public WebElement footer_future;

    //store query page: https://mall.lenovo.com.cn/
    @FindBy(how = How.LINK_TEXT, using = "门店查询")
    public WebElement storeQuery;
    @FindBy(how = How.LINK_TEXT, using = "每日秒杀")
    public WebElement dailyMiaosha;
    @FindBy(how = How.LINK_TEXT, using = "ThinkPad回收换新")
    public WebElement thinkpadRecycle;
    @FindBy(how = How.XPATH, using = "//a[@tag='searchButton']")
    public WebElement searchButton_mallHeader;
    @FindBy(how = How.XPATH, using = "(//a[contains(@latag,'门店首页')]/img)[1]")
    public WebElement banner_store;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'search_ipt')]")
    public WebElement searchButton_mall;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'choose-city')]")
    public WebElement chooseCity;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'BMap_mask')]")
    public WebElement storeMap;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'search_left')]")
    public WebElement searchLeft;
    @FindBy(how = How.XPATH, using = "//select[contains(@latag,'产品分类')]")
    public WebElement selectByProType;
    @FindBy(how = How.XPATH, using = "//select[contains(@latag,'门店分类')]")
    public WebElement selectByStoreType;
    @FindBy(how = How.XPATH, using = "//li[contains(@id,'comprehensive')]")
    public WebElement sortByComprehensive;
    @FindBy(how = How.XPATH, using = "//li[contains(@id,'praise')]")
    public WebElement sortByPraise;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'result_box')]")
    public WebElement storeResult;

    //service store query: https://newsupport.lenovo.com.cn/serverNet.html
    @FindBy(how = How.LINK_TEXT, using = "联想服务")
    public WebElement lenovoService_service;
    @FindBy(how = How.LINK_TEXT, using = "Think服务")
    public WebElement thinkService;
    @FindBy(how = How.LINK_TEXT, using = "大客户服务")
    public WebElement majorCustomerService;
    @FindBy(how = How.LINK_TEXT, using = "手机服务")
    public WebElement mobileService;
    @FindBy(how = How.LINK_TEXT, using = "官方微信")
    public WebElement officialWechat;
    @FindBy(how = How.LINK_TEXT, using = "服务商城")
    public WebElement serviceMall;
    @FindBy(how = How.LINK_TEXT, using = "企业级整体维保")
    public WebElement companyOverallMaintain;
    @FindBy(how = How.XPATH, using = "//*[@id='topCrumbs']")
    public WebElement topCrumbs;
    @FindBy(how = How.XPATH, using = "//*[@class='glsb']/span")
    public WebElement connectDevice;
    @FindBy(how = How.XPATH, using = "//*[@class='product-choose']")
    public WebElement productChoose;
    @FindBy(how = How.XPATH, using = "//*[@title='笔记本']")
    public WebElement LenovoNotebook;
    @FindBy(how = How.XPATH, using = "//*[@title='台式']")
    public WebElement LenovoDesktop;
    @FindBy(how = How.XPATH, using = "//*[@class='thinkpad']")
    public WebElement thinkpadNotebook;
    @FindBy(how = How.XPATH, using = "//*[@title='NewThinkCentre']")
    public WebElement thinkCenter;
    @FindBy(how = How.XPATH, using = "//*[@title='打印机、多功能一体机']")
    public WebElement printer;
    @FindBy(how = How.XPATH, using = "//*[@title='服务器']")
    public WebElement lenovoServer;
    @FindBy(how = How.XPATH, using = "//*[@class='open-products-ul']")
    public WebElement openOtherPro;
    @FindBy(how = How.XPATH, using = "//*[@class='map-article']")
    public WebElement mapArticle;
    @FindBy(how = How.XPATH, using = "//*[@class='map-lookup']")
    public WebElement mapLookup;
    @FindBy(how = How.XPATH, using = "//*[@class='placeInput placeInput3']")
    public WebElement addressInput;
    @FindBy(how = How.XPATH, using = "//*[@class='fwzNum']")
    public WebElement addressResultNum;
    @FindBy(how = How.XPATH, using = "//*[@class='inputBtn-left']")
    public WebElement sortByDistance;
    @FindBy(how = How.XPATH, using = "//*[@class='inputBtn-right inputBtnHover']")
    public WebElement sortByRecommend;
    @FindBy(how = How.XPATH, using = "//*[@class='placeUl']")
    public WebElement addressResultList;
    @FindBy(how = How.XPATH, using = "//*[@class='amap-labels']")
    public WebElement serviceMap;
    @FindBy(how = How.XPATH, using = "//*[@class='tips-text']")
    public WebElement warmTips;
    @FindBy(how = How.XPATH, using = "(//*[@class='relief-detail']//*/a)[1]")
    public WebElement globalServiceLink;
    @FindBy(how = How.XPATH, using = "(//*[@class='relief-detail']//*/a)[2]")
    public WebElement lenovoCareLink;
    @FindBy(how = How.XPATH, using = "//*[@class='footer mobile']")
    public WebElement footerService;

    //hot solutions: https://iknow.lenovo.com.cn/
    @FindBy(how = How.XPATH, using = "//*[@class='logoCon']/img")
    public WebElement lenovoLogo_solution;
    @FindBy(how = How.XPATH, using = "//*[@class='logoCon']/span")
    public WebElement lenovoKnwledgeTitle;
    @FindBy(how = How.XPATH, using = "//*[@id='headLogin']")
    public WebElement headLogin;
    @FindBy(how = How.XPATH, using = "//*[@class='queryBox']")
    public WebElement queryBox;
    @FindBy(how = How.XPATH, using = "//*[@class='queryBtn']")
    public WebElement queryBtn;
    @FindBy(how = How.XPATH, using = "(//*[@class='indexNav'])[1]")
    public WebElement homeLink_solution;
    @FindBy(how = How.LINK_TEXT, using = "Lenovo笔记本")
    public WebElement lenovNotebookSolutionLink;
    @FindBy(how = How.LINK_TEXT, using = "Lenovo台式机")
    public WebElement lenovDesktopSolutionLink;
    @FindBy(how = How.LINK_TEXT, using = "ThinkPad")
    public WebElement thinkpadSolutionLink;
    @FindBy(how = How.LINK_TEXT, using = "ThinkCentre")
    public WebElement thinkCenterSolutionLink;
    @FindBy(how = How.LINK_TEXT, using = "联想手机")
    public WebElement lenovoMobileSolutionLink;
    @FindBy(how = How.LINK_TEXT, using = "外设数码")
    public WebElement peripheralDigitalLink;
    @FindBy(how = How.LINK_TEXT, using = "服务器")
    public WebElement serverSolutionLink;
    @FindBy(how = How.LINK_TEXT, using = "智能设备")
    public WebElement smartDeviceSolutionLink;
    @FindBy(how = How.XPATH, using = "(//*[@class='indexNav'])[2]")
    public WebElement drverDownloadLink;
    @FindBy(how = How.XPATH, using = "//*[@class='flex-prev']")
    public WebElement prevArrow_solution;
    @FindBy(how = How.XPATH, using = "//*[@class='flex-next']")
    public WebElement nextArrow_solution;
    @FindBy(how = How.XPATH, using = "//*[@class='banner']")
    public WebElement banner_solution;
    @FindBy(how = How.XPATH, using = "//*[@class='box-title']")
    public WebElement knowledgeZoneTitle;
    @FindBy(how = How.XPATH, using = "//*[@class='knowledge clearfix']")
    public WebElement knowledgeClearfix;
    @FindBy(how = How.XPATH, using = "//*[@id='adlist']")
    public WebElement adList;
    @FindBy(how = How.XPATH, using = "//*[@class='topWrapper']")
    public WebElement solutionCaseList;
    @FindBy(how = How.XPATH, using = "//*[@class='footer']")
    public WebElement footerSolution;

    //quick fix tool page :https://iknow.lenovo.com.cn/detail/dc_172545.html
    @FindBy(how = How.XPATH, using = "//*[@class='logoCon']")
    public WebElement lenovoLogo_quickFix;
    @FindBy(how = How.XPATH, using = "//*[@class='queryBox']")
    public WebElement queryBox_quickFix;
    @FindBy(how = How.XPATH, using = "//*[@class='nowPositionBox clearfix']")
    public WebElement breadNav_quickFix;
    @FindBy(how = How.XPATH, using = "//*[@class='banner']")
    public WebElement banner_quickFix;
    @FindBy(how = How.XPATH, using = "//*[@class='knowledgeDetail']")
    public WebElement knowledgeDetail;
    @FindBy(how = How.XPATH, using = "//*[@class='xiangguanwenda']")
    public WebElement relatedKnowledge;
    @FindBy(how = How.XPATH, using = "//*[@class='pointwarp']")
    public WebElement thumbUp;
    @FindBy(how = How.XPATH, using = "//*[@class='shareBox']")
    public WebElement shareBox;
    @FindBy(how = How.XPATH, using = "//*[@class='copyText']")
    public WebElement copyText;

    //warranty config query page: https://newsupport.lenovo.com.cn/guardeploySearch.html
    @FindBy(how = How.XPATH, using = "//*[@class='search-input']/input")
    public WebElement searchInputBox;
    @FindBy(how = How.XPATH, using = "//*[@class='searchlistbtn']")
    public WebElement searchButton_warranty;
    @FindBy(how = How.XPATH, using = "//*[@class='carenew']")
    public WebElement careNewImg;
    @FindBy(how = How.XPATH, using = "//*[@class='text-tips']")
    public WebElement textTips;
    @FindBy(how = How.XPATH, using = "//*[@id='note-book']/span")
    public WebElement noteBookTab;
    @FindBy(how = How.XPATH, using = "//*[@id='note-computer']/span")
    public WebElement desktpTab;
    @FindBy(how = How.XPATH, using = "//*[@id='note-yiti']/span")
    public WebElement allInOneTab;
    @FindBy(how = How.XPATH, using = "//*[@id='note-thinkpad']/span")
    public WebElement thinkpadTab;
    @FindBy(how = How.XPATH, using = "(//*[@class='img-tips']/img)[1]")
    public WebElement tipsImg1;
    @FindBy(how = How.XPATH, using = "//*[@class='footer-wrap clear']")
    public WebElement footer_warranty;

}


