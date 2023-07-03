package commonfunction;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.log4j.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

import commonfunction.Dailylog;
import pages.OfficialHomePage;
import testdata.PropsUtils;

public class Common {

    private static BigDecimal Decimal1;
    private static BigDecimal Decimal2;
    private static Logger logger = Logger.getLogger("Dailylog");

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Get current date time as string yyyyMMddHHmmssSSS
     */
    public static String getDateTimeString() {
        Date datetime = new Date();
        DateFormat milliFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return milliFormat.format(datetime);
    }

    /**
     * @Owner suyi3
     * @Parameter
     * @Usage Get current date time as string ddHHmmssSSS
     */
    public static String getTimeString() {
        Date datetime = new Date();
        DateFormat milliFormat = new SimpleDateFormat("ddHHmmssSSS");
        return milliFormat.format(datetime);
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Wait WebElement to be clickable within timeout
     */
    public static void waitElementClickable(WebDriver driver, WebElement element, int timeoutInSeconds) throws NoSuchElementException {
        new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Wait WebElement to be visible with default timeout (probably 60
     *        seconds)
     */
    public static void waitElementVisible(WebDriver driver, WebElement element) throws InterruptedException {
        Thread.sleep(3000);
        new WebDriverWait(driver, PropsUtils.getDefaultTimeout()).until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Return if element editable or not
     */
    public static boolean isEditable(WebElement element) throws InterruptedException {
        return element.isEnabled() && element.getAttribute("readonly") == null;// &&
        // !element.getAttribute("readonly").equals("readonly");
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Wait WebElement disappear with default timeout (probably 60
     *        seconds)
     */
    public static void waitElementDisappear(WebDriver driver, WebElement element, int timeoutInSecond) throws InterruptedException {
        Thread.sleep(3000);
        new WebDriverWait(driver, timeoutInSecond).until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * @Owner luorong3
     * @Parameter
     * @Usage Check if WebElement exists or not within timeout
     */
    public static Boolean checkElementExists(WebDriver driver,WebElement webElement, int timeOutInSeconds) {
        Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    // if scroll succeed, means exists, but not sure if it is displayed or not.
                    Common.scrollToElement(driver, webElement);
                    return true;
                } catch (NoSuchElementException | InterruptedException e) {
                    return false;
                }
            }
        };
        Boolean exist = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            exist = wait.until(waitFn);
        }catch (Exception e){
            return false;
        }
        return exist;
    }

    public static Boolean checkElementDisplays(WebDriver driver,WebElement webElement, int timeOutInSeconds) {
        Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    Common.scrollToElement(driver, webElement);
                    return webElement.isDisplayed();
                } catch (NoSuchElementException | InterruptedException e) {
                    return false;
                }
            }
        };
        Boolean display = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            display = wait.until(waitFn);
        }catch (Exception e){
            return false;
        }
        return display;
    }


    /**
     * @throws InterruptedException
     * @Owner Songli
     * @Parameter
     * @Usage Check if WebElement exists or not within timeout
     */
    public static boolean checkElementInvisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            int time = 0;
            while (element.isDisplayed() && 2 * time <= timeoutInSeconds) {
                Thread.sleep(2000);
                time++;
            }
            return false;
        } catch (NoSuchElementException | InterruptedException e) {
            return true;
        } finally {
            driver.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        }
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Check if Element exist
     */
    public static boolean isElementExist(WebDriver driver, By by) {
        boolean flag = false;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            WebElement element = driver.findElement(by);
            flag = element != null;
        } catch (Exception e) {
        }
        driver.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        return flag;
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Check if element exist within timeout
     */
    public static boolean isElementExist(WebDriver driver, By by, int timeoutInSecond) {
        boolean flag = false;
        driver.manage().timeouts().implicitlyWait(timeoutInSecond, TimeUnit.SECONDS);
        try {
            WebElement element = driver.findElement(by);
            flag = element != null;
        } catch (Exception e) {
        }
        driver.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        return flag;
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Check if element exist under a parent element within timeout
     */
    public static boolean isElementExist(WebDriver driver, WebElement parentElement, By by, int timeoutInSecond) {
        boolean flag = false;
        driver.manage().timeouts().implicitlyWait(timeoutInSecond, TimeUnit.SECONDS);
        try {
            WebElement element = parentElement.findElement(by);
            flag = element != null;
        } catch (Exception e) {
        }
        driver.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        return flag;
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Subtract method for floats
     */
    public static float floatSubtract(float num1, float num2) {
        Decimal1 = new BigDecimal(Float.toString(num1));
        Decimal2 = new BigDecimal(Float.toString(num2));
        return Decimal1.subtract(Decimal2).floatValue();
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Mouse hover on an element
     */
    public static void mouseHover(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Double click on a element
     */
    public static void doubleClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element);
        actions.perform();
        // ((JavascriptExecutor) driver).executeScript("var evt =
        // document.createEvent('MouseEvents');"+
        // "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0,
        // false,
        // false, false, false, 0,null);"+
        // "arguments[0].dispatchEvent(evt);", element);
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Right click on an element
     */
    public static void rightClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element);
        actions.perform();
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Wait alert window appears within timeout
     */
    public static void waitAlertPresent(WebDriver driver, int timeoutInSecond) {
        new WebDriverWait(driver, timeoutInSecond).until(ExpectedConditions.alertIsPresent());
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Send enter key event
     */
    public static void KeyEventEnter() {
        try {
            Robot rebot = new Robot();
            rebot.keyPress(KeyEvent.VK_ENTER);
        } catch (AWTException e) {

        }
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Sleep in millisecond
     */
    public static void sleep(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @Owner Zhongxu
     * @Parameter:
     * @Usage:
     */
    public static boolean switchToWindow_Title(WebDriver driver, String windowTitle) {
        boolean flag = false;
        try {
            String currentHandle = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for (String s : handles) {
                if (s.equals(currentHandle))
                    continue;
                else {
                    driver.switchTo().window(s);
                    if (driver.getTitle().contains(windowTitle)) {
                        flag = true;
                        Dailylog.logInfo("Switch to Window: " + windowTitle + "  successfully~~~!");
                        break;
                    } else
                        continue;
                }
            }
        } catch (NoSuchWindowException e) {
            Dailylog.logInfo("Window: " + windowTitle + " cound not find!!!" + e.fillInStackTrace());
            flag = false;
        }
        return flag;
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Scroll to make sure target element is on screen and clickable
     */
    public static void scrollToElement(WebDriver driver, WebElement element) throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("window.scrollBy(0, -100)");
        Thread.sleep(2000);
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Used in data-driven
     */
    public static Object[][] getFactoryData(Object[][] fullList, String target) {
        if (target.toUpperCase().equals("ALL")) {
            return fullList;
        } else {
            List<String> targetList = Arrays.asList(target.split(","));
            List<Object[]> result = new ArrayList<Object[]>();
            for (int i = 0; i < fullList.length; i++) {
                if (targetList.contains(fullList[i][0].toString())) {
                    result.add(fullList[i]);
                }
            }
            return result.toArray(new Object[0][]);
        }
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Used in data-driven for 19353 and 19422 specifically
     */
    public static Object[][] getFactoryDataPayment(Object[][] fullList, ArrayList<String[]> target) {
        if (target.get(0)[0].toUpperCase().equals("ALL")) {
            if (System.getProperty("targetStore").toUpperCase().equals("ALL")) // false
                // -
                // ALL
                return fullList;
            else {
                // false - CA CA,JP
                String[] targetList = System.getProperty("targetStore").split(",");
                List<Object[]> result = new ArrayList<Object[]>();
                for (String tar : targetList) {
                    for (int i = 0; i < fullList.length; i++) {
                        if (fullList[i][0].equals(tar)) {
                            result.add(fullList[i]);
                        }
                    }
                }
                return result.toArray(new Object[0][]);
            }
        } else {
            // true - ALL & CA CA,JP
            List<Object[]> result = new ArrayList<Object[]>();
            for (int i = 0; i < fullList.length; i++) {
                if (isTargetListContains(target, fullList[i])) {
                    result.add(fullList[i]);
                }
            }
            return result.toArray(new Object[0][]);
        }
    }

    private static boolean isTargetListContains(ArrayList<String[]> target, Object[] item) {
        for (String[] tar : target) {
            if (tar[0].equals(item[0]) && tar[1].equals(item[1].toString()))
                return true;
        }
        return false;
    }

    /**
     * @Owner Xianen
     * @Parameter:
     * @Usage:
     */
    public static String[] getSeriesURL(OfficialHomePage page, WebDriver driver, String type) {
        String[] urlArray = null;
        By ViewSeriesButton = By.xpath(".//*[@id='product-']/div/div[6]/a");

        if (type.equals("Laptops") || type.equals("Compare and Buy Laptops") || type.equals("Laptops & Ultrabooks")) {
            List<WebElement> urlItems = driver.findElements(By.cssSelector(".seriesPreview-viewLink.seriesPreview-fakeLink"));

            urlArray = new String[urlItems.size()];
            int i = 0;
            for (WebElement e : urlItems) {
                urlArray[i] = e.getAttribute("href").toString();
                i++;
            }
        } else if (type.equals("Accessories and upgrades") || type.equals("Accessories & Software")) {

            List<WebElement> urlItems = driver.findElements(By.xpath(".//*[@id='productGrid-target']//div[1]/div[2]/h2/a"));
            urlArray = new String[urlItems.size()];
            int i = 0;
            for (WebElement e : urlItems) {
                urlArray[i] = e.getAttribute("href").toString();
                i++;
            }

        } else if (type.equals("Tablets") || type.equals("Desktops & All-in-ones") || type.equals("Windows & Android Tablet PCs") || type.equals("Tablets & Detachable PCs")) {
            if (isElementExist(driver, ViewSeriesButton)) {
                List<WebElement> urlItems = driver.findElements(By.xpath(".//*[@id='product-']/div/div[6]/a"));
                urlArray = new String[urlItems.size()];
                int i = 0;
                for (WebElement e : urlItems) {
                    urlArray[i] = e.getAttribute("href").toString();
                    i++;
                }
            } else {
                List<WebElement> urlItems = driver.findElements(By.cssSelector(".seriesPreview-viewLink.seriesPreview-fakeLink"));

                urlArray = new String[urlItems.size()];
                int i = 0;
                for (WebElement e : urlItems) {
                    urlArray[i] = e.getAttribute("href").toString();
                    i++;
                }
            }

        }

        return urlArray;
    }

    /**
     * @Owner Xianen
     * @Parameter:
     * @Usage:
     */
    public static void NavigateToUrl(WebDriver driver, String Browser, String url) {
        if (Browser.toLowerCase().startsWith("ie")) {
            if (url.contains("LIeCommerce")) {
                url = url.replace("LIeCommerce:M0C0v0n3L!@", "");
            }
        }
        // Common.IElogin(url, driver);
        // } else {
        driver.get(url);
        if (Common.isAlertPresent(driver)) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    //
    // }

    /**
     * @Owner Xianen
     * @Parameter:
     * @Usage:
     */
    public static void IElogin(String URL, WebDriver driver) {
        // driver.get(URL);
        //
        // if (Common.isAlertPresent(driver)) {
        // Alert alert = driver.switchTo().alert();
        // alert.accept();
        // }

        // Alert aa = driver.switchTo().alert();
        // aa.sendKeys(Keys.ENTER);
        // try {
        // Thread.sleep(1000);
        // driver.switchTo().alert().accept();
        // }catch (Exception e)
        // {}
        // aa.sendKeys("ENTER");
        // final Runtime runtime = Runtime.getRuntime();
        //
        // try {
        // runtime.exec("src/test/resources/NemoLogin.exe");
        //
        // } catch (final Exception e) {
        // Dailylog.logInfo("Error exec!");
        // }
        // try {
        // Thread.sleep(5000);
        // } catch (InterruptedException e1) {
        // e1.printStackTrace();
        // }

    }

    public static void sendFieldValue(WebElement locator, String value) {
        locator.clear();
        locator.sendKeys(value);
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Click on an element with Javascript
     */
    public static void javascriptClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void switchToWindow(WebDriver driver, int windowNo) {
        Common.sleep(2000);
        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(windowNo));
    }

    /**
     * @Owner Pan
     * @Parameter
     * @Usage get the text when the element is not visible
     */

    public static String javaScriptGetText(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = (String) js.executeScript("var result = arguments[0].innerHTML;return result", element);

        return text;
    }

    /**
     * @Owner Pan
     * @Parameter:
     * @Usage:
     */
    public static void deleteFile(String path) {
        File f = new File(path);
        if (f.exists()) {
            f.delete();
        }
    }

    /**
     * @Owner Pan
     * @Parameter:
     * @Usage:
     */
    public static String[] GetAllFilePath(String folderpath) {
        File file = new File(folderpath);
        String FindName[];
        FindName = file.list();
        String[] path = new String[FindName.length];

        for (int i = 0; i < FindName.length; i++) {
            path[i] = folderpath + "\\" + FindName[i];

        }
        return path;
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Wait for element text change to target text
     */
    public static void waitElementText(WebDriver driver, By by, String targetText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, targetText));
    }

    /**
     * @Owner Pan
     * @Parameter:
     * @Usage:
     */
    public static Boolean isAttributePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null) {
                result = true;
            }
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Conver Element locator to xpath (only works for elements located
     *        with xpath)
     */
    public static String convertWebElementToString(WebElement locatorAsWebElement) {
        String temp1[] = locatorAsWebElement.toString().split("xpath: ");
        int temp2 = temp1[1].lastIndexOf("]");
        String locatorAsString = temp1[1].substring(0, temp2);
        // String after = temp1[1].substring(temp2 + 1);
        return locatorAsString;
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Check element displays within timeout
     */
    public static boolean checkElementDisplays(WebDriver driver, By by, int timeoutInSeconds) {
        try {
            driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
            Common.scrollToElement(driver, driver.findElement(by));
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException | InterruptedException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        }
    }

    /**
     * @Owner Xianen
     * @Parameter:
     * @Usage:
     */
    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception Ex) {
            return false;
        }
    }

    /**
     * @author lijie
     * @param driver
     */
    public static void closeAlertPop(WebDriver driver) {
        if (isAlertPresent(driver)) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    /**
     * @Owner Xianen
     * @Parameter:
     * @Usage:
     */
    public static void WaitUntilSpinner(WebDriver driver) {
        String spinner = "//*[@id='full_preloader']/i[2]";
        if (Common.isElementExist(driver, By.xpath(spinner))) {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(spinner))));
        } else {
            Common.sleep(3000);
        }
    }

    /**
     * @Owner Xianen
     * @Parameter:
     * @Usage: scroll to the right within pages
     */
    public static void InnerScrollRight(WebDriver driver, String className, String scrollDistance) {
        JavascriptExecutor j = (JavascriptExecutor) driver;

        j.executeScript("document.getElementsByClassName('" + className + "')[0].scrollLeft=" + scrollDistance);
    }

    /**
     * @Owner Xianen
     * @Parameter:
     * @Usage: scroll to the bottom within pages
     */
    public static void InnerScrollTop(WebDriver driver, String className, String scrollDistance) {
        JavascriptExecutor j = (JavascriptExecutor) driver;

        j.executeScript("document.getElementsByClassName('" + className + "')[0].scrollTop=" + scrollDistance);
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Open a new browser and return the driver, but remember to quit it
     *        at the end of case and catch clause
     */
    public static WebDriver openNewBrowser() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Scroll to element to make sure it is in screen, and then use
     *        selenium normal click
     */
    public static void scrollAndClick(WebDriver driver, WebElement element) {
        try {
            Common.scrollToElement(driver, element);
            sleep(1000);
            element.click();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * @Owner gaopan
     * @Parameter
     * @Usage return float value with two digits
     */
    public static float getFloat(float f) {

        DecimalFormat df = new DecimalFormat(".##");
        String st = df.format(f);
        float ff = Float.parseFloat(st);

        return ff;
    }

    public static void click(WebDriver driver, WebElement e, String operateName) throws Exception {
        // if Element didn't exist, then test case filed
        elementIsNull(driver, e, operateName);
        highlightElement(driver, e);
        for (int i = 0; i < 3; i++) {
            try {
                e.click();
                break;
            } catch (Exception err) {
                e.click();
                if (i == 2) {
                    Dailylog.logInfo(operateName + "fail");
                    Assert.fail(operateName + "fail");
                    assert false;
                }
            }
        }
    }

    public static void sendKeys(WebDriver driver, WebElement e, String values, String operateName) throws InterruptedException, IOException {
        // if Element didn't exist, then test case filed
        elementIsNull(driver, e, operateName);
        highlightElement(driver, e);
        for (int i = 0; i < 3; i++) {
            try {
                e.clear();
                e.sendKeys(values);
                break;
            } catch (Exception err) {
                if (i == 2) {
                    Assert.fail(operateName + " fail");
                    assert false;
                }
                Thread.sleep(1000);
                e.sendKeys(values);
            }
        }
    }

    public static void select(WebDriver driver, WebElement selector, String value, String operateName) throws Exception {
        // if Element didn't exist, then test case filed
        elementIsNull(driver, selector, operateName);
        Select select = new Select(selector);
        List<WebElement> options;
        String optionContent = null;
        try {
            options = select.getOptions();
            for (WebElement webElement : options) {
                optionContent = webElement.getText();
                if (optionContent.contains(value)) {
                    break;
                }
            }
            if (optionContent != null) {
                select.selectByVisibleText(optionContent);
            } else {
                Assert.fail("select " + value + " fail!");
                assert false;
            }

        } catch (Exception e) {
            Assert.fail("select " + value + " fail!" + e.getMessage());
            assert false;
        }
        Thread.sleep(5000);
    }

    /**
     * @Title: select
     * @Description: TODO
     * @param selector
     * @param index
     *            if index<0, select random number, else, select index
     * @param operateName
     * @throws Exception
     * @author: 88881616
     * @date: Aug 30, 2017 9:37:06 AM
     * @return: void
     */
    public void select(WebDriver driver, WebElement selector, int index, String operateName) throws Exception {
        // if Element didn't exist, then test case filed
        elementIsNull(driver, selector, operateName);
        Select select = new Select(selector);
        List<WebElement> options;
        try {
            options = select.getOptions();
            if (options.size() == 0) {
                Assert.fail("select No." + index + " value fail!");
            }

            if (index < 1) {
                index = RadomInt(0, options.size() - 1);
            }
            select.selectByIndex(index);

        } catch (Exception e) {
            Assert.fail("select No." + index + " value fail!" + e.getMessage());
            assert false;
        }
        // Thread.sleep(5000);
    }

    public static int RadomInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static void elementIsNull(WebDriver driver, WebElement e, String operateName) throws IOException {

        try {
            if (waitForElement(driver, e) == null) {
                Assert.fail("can't find element: " + e + " ," + operateName + " fail!");
                assert false;
            }
        } catch (Exception ex) {
            Assert.fail("Exception can't find element: " + e + " ," + operateName + " fail!");
            assert false;
        }
    }

    public static WebElement waitForElement(WebDriver driver, final WebElement element) {
        // Waiting 60 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
        WebElement e = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver t) {
                // Dailylog.logInfo("wait element load for time: 5s");
                if (element.isDisplayed()) {
                    return element;
                } else {
                    return null;
                }
            }
        });
        return e;
    }

    public static void highlightElement(WebDriver driver, WebElement element) {

        String originalStyle = element.getAttribute("style");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid black;');", element);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        // js.executeScript("arguments[0].setAttribute('style', '" +
        // originalStyle + "');", element);

    }

    public static void jsSendkeysById(JavascriptExecutor js, String id, String valueStr) {
        String jsName = "document.getElementById(\"" + id + "\").value=\"" + valueStr + "\"";
        js.executeScript(jsName);
    }

    public static void jsSendkeysByName(JavascriptExecutor js, String id, String valueStr) {
        String jsName = "var els=document.getElementsByName(\"" + id + "\");els[0].value=\"" + valueStr + "\"";
        js.executeScript(jsName);
    }

    public static boolean searchForElementDisplayedByID(WebDriver wd, String elementStr, String operaterDescription, int num, Long timeout) {
        boolean bl = false;
        wd.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Dailylog.logInfo("Current Operation：" + operaterDescription);
        int i = 0;
        for (; i < num; i++) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                bl = wd.findElement(By.id(elementStr)).isDisplayed();
                if(true==bl){
                    Dailylog.logInfo("Find the element, times：" + i + "\n");
                    break;
                }

            } catch (Exception e) {
                Dailylog.logInfo("Is not here!" + i);
                // cf.printLogs(e.toString());

            }
        }
        // Dailylog.logInfo("n is :"+n);
        if (i == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + i + "\n");

        }
        wd.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        return bl;
    }

    public static boolean searchForElementVisibleByID(WebDriver wd, String elementStr, String operaterDescription, int num, Long timeout) {
        boolean bl = true;
        wd.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Dailylog.logInfo("Current Operation：" + operaterDescription);
        int n = 0;
        for (int i = 0; i < num; i++) {
            try {
                // Dailylog.logInfo("begin to sleep!");
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                // Dailylog.logInfo("begin to find element!");

                wd.findElement(By.id(elementStr));
                Dailylog.logInfo("Find the element, times：" + n + "\n");
                break;
            } catch (Exception e) {
                // Dailylog.logInfo("Is not here!" + i);
                // cf.printLogs(e.toString());
                n++;
            }
        }
        // Dailylog.logInfo("n is :"+n);
        if (n == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + n + "\n");

        }
        wd.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        return bl;
    }


    public static boolean searchForElementVisibleByXpath(WebDriver wd, String elementStr, String operaterDescription, int num, Long timeout) {
        boolean bl = true;
        wd.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Dailylog.logInfo("Current Operation：" + operaterDescription);
        int n = 0;
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                wd.findElement(By.xpath(elementStr));
                Dailylog.logInfo("Find the element, times：" + n + "\n");
                break;
            } catch (Exception e) {
                // Dailylog.logInfo("Is not here!" + i);
                // cf.printLogs(e.toString());
                n++;
            }
        }
        // Dailylog.logInfo("n is :"+n);
        if (n == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + n + "\n");

        }
        return bl;
    }

    public static boolean searchForElementVisibleByXpath(WebElement wd, String elementStr, String operaterDescription, int num, Long timeout) {
        boolean bl = true;
        Dailylog.logInfo("Current Operation：" + operaterDescription);
        int n = 0;
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                wd.findElement(By.xpath(elementStr));
                Dailylog.logInfo("Find the element, times：" + n + "\n");
                break;
            } catch (Exception e) {
                // Dailylog.logInfo("Is not here!" + i);
                // cf.printLogs(e.toString());
                n++;
            }
        }
        // Dailylog.logInfo("n is :"+n);
        if (n == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + n + "\n");

        }

        return bl;
    }

    public static boolean searchForElementVisibleByCSS(WebElement we, String elementStr, String operaterDescription, int num, Long timeout) {
        boolean bl = true;
        // wd.manage().timeouts().implicitlyWait(1L,TimeUnit.SECONDS);
        Dailylog.logInfo("Current Operation：" + operaterDescription);
        // Dailylog.logInfo("Current Operation：" + operaterDescription);
        int n = 0;
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                we.findElement(By.cssSelector(elementStr));
                Dailylog.logInfo("Find the element, times：" + n + "\n");
                break;
            } catch (Exception e) {
                // Dailylog.logInfo("Is not here!" + i);
                // cf.printLogs(e.toString());
                n++;
            }
        }
        // Dailylog.logInfo("n is :"+n);
        if (n == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + n + "\n");

        }
        return bl;
    }

    public static boolean searchForElementVisibleByCSS(WebDriver wd, String elementStr, String operaterDescription, int num, Long timeout) {
        boolean bl = true;
        wd.manage().timeouts().implicitlyWait(1L,TimeUnit.SECONDS);
        Dailylog.logInfo("Current Operation：" + operaterDescription);
        int i = 0;
        String[] strSplit = elementStr.split("\\|\\|");
        for (; i < num; i++) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            boolean innerBl = false;
            for (int m = 0; m < strSplit.length; m++) {
                try {
                    Dailylog.logInfo("Find the element:" + strSplit[m].toString() + "***times：" + m );
                    wd.findElement(By.cssSelector(strSplit[m].toString()));
                    Dailylog.logInfo("Find it here! time i:" + i);
                    innerBl = true;
                    break;
                } catch (Exception e) {
                    Dailylog.logInfo("Is not here! element m:" + m);

                }
            }
            if (true == innerBl) {
                break;
            }

            Dailylog.logInfo("i::::::" + i);

        }
        Dailylog.logInfo("i::::::************" + i);
        if (i == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + i );
        }
        wd.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        System.out.println("bl::::::::"+bl+ "\n");
        return bl;
    }
    public static boolean searchForElementDisplayedByXpath(WebDriver wd, String elementStr, String operaterDescription, int num, Long timeout) {
        boolean bl = false;
        wd.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Dailylog.logInfo("Current Operation：" + operaterDescription);
        int i = 0;
        for (; i < num; i++) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                bl = wd.findElement(By.xpath(elementStr)).isDisplayed();

                if(true==bl){
                    Dailylog.logInfo("Find the element, times：" + i + "\n");
                    break;
                }

            } catch (Exception e) {
                // Dailylog.logInfo("Is not here!" + i);
                // cf.printLogs(e.toString());
                i++;
            }
        }
        // Dailylog.logInfo("n is :"+n);
        if (i == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + i + "\n");

        }
        wd.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        return bl;
    }

    public static boolean searchForElementVisible(WebDriver wd, WebElement we, String operaterDescription, int num, Long timeout) {
        boolean bl = true;
        wd.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Dailylog.logInfo("Current Operation：" + operaterDescription);
        int n = 0;
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                Common.scrollToElement(wd, we);
                if (we.isDisplayed()) {
                    Dailylog.logInfo("Find the element, times：" + n + "\n");
                    break;
                }

            } catch (Exception e) {
                // Dailylog.logInfo("Is not here!" + i);
                // cf.printLogs(e.toString());
                n++;
            }
        }
        // Dailylog.logInfo("n is :"+n);
        if (n == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + n + "\n");

        }
        wd.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        return bl;
    }

    public static boolean searchForElementByIdValueIsNot(WebDriver wd, String elementStr, String valueStr, String operaterDescription, int num, Long timeout) {
        boolean bl = true;
        wd.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Dailylog.logInfo("Current Operation：" + operaterDescription);
        int n = 0;
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                String getStr = wd.findElement(By.id(elementStr)).getText();
                // cf.printLogs("getStr:"+getStr);
                n++;
                if (!valueStr.equals(getStr)) {
                    Dailylog.logInfo("Find the element, times：" + n + "\n");
                    break;
                }

            } catch (Exception e) {
                Dailylog.logInfo("Is not here!" + i);
                // cf.printLogs(e.toString());
                n++;
            }
        }
        // Dailylog.logInfo("n is :"+n);
        if (n == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + n + "\n");

        }
        wd.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        return bl;
    }

    public static boolean searchForElementByXpathValueIsNot(WebDriver wd, String elementStr, String valueStr, String operaterDescription, int num, Long timeout) {
        boolean bl = true;
        wd.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Dailylog.logInfo("Current Operation：" + operaterDescription);
        int n = 0;
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                String getStr = wd.findElement(By.xpath(elementStr)).getText();
                // cf.printLogs("getStr:"+getStr);
                n++;
                if (!valueStr.equals(getStr)) {
                    Dailylog.logInfo("Find the element, times：" + n + "\n");
                    break;
                }

            } catch (Exception e) {
                Dailylog.logInfo("Is not here!" + i);
                // cf.printLogs(e.toString());
                n++;
            }
        }
        // Dailylog.logInfo("n is :"+n);
        if (n == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + n + "\n");

        }
        wd.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        return bl;
    }

    public static boolean searchForElementByXpathValueContains(WebDriver wd, String elementStr, String valueStr, String operaterDescription, int num, Long timeout) {
        boolean bl = true;
        wd.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Dailylog.logInfo("Current Operation：" + operaterDescription);
        int n = 0;
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                String getStr = wd.findElement(By.xpath(elementStr)).getText();
                // cf.printLogs("getStr:"+getStr);
                n++;
                if (valueStr.equals(getStr)) {
                    Dailylog.logInfo("Find the element, times：" + n + "\n");
                    break;
                }

            } catch (Exception e) {
                Dailylog.logInfo("Is not here!" + i);
                // cf.printLogs(e.toString());
                n++;
            }
        }
        // Dailylog.logInfo("n is :"+n);
        if (n == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + n + "\n");

        }
        wd.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        return bl;
    }

    public static boolean judgeCurrentUrl(WebDriver wd, String urlStr, String operaterDescription, int num, Long timeout) {
        boolean bl = true;
        wd.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        System.out.println("\nCurrent Operation：" + operaterDescription);
        int n = 0;
        String currentUrl = "";
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(timeout);
                currentUrl = wd.getCurrentUrl();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                Dailylog.logInfo("Error occure，currentUrl:" + currentUrl);
            }
            if (currentUrl.contains(urlStr)) {

                // se.wait(100l);
                System.out.println("Find the element.\n");
                break;

            } else {
                Dailylog.logInfo("Is not here!" + i);
            }
            n++;

        }
        // System.out.println("n is :"+n);
        if (n == num) {
            bl = false;
            Dailylog.logInfo("Can't find the element. Try times:" + n + "\n");

        }
        wd.manage().timeouts().implicitlyWait(PropsUtils.getDefaultTimeout(), TimeUnit.SECONDS);
        return bl;
    }

    public static String getTimeStamp() {
        // Dailylog.logInfo(Long.toString(System.currentTimeMillis()));
        return Long.toString(System.currentTimeMillis());
    }

    /*
     * Use a regular expression match string regEx: regular expression
     * checkString: to validate the string
     */
    public static boolean contrastRegExStrings(String checkString, String regEx) {
        boolean rs;
        if ("".equals(checkString)) {
            if (("".equals(regEx)) || ("空".equals(regEx))) {
                rs = true;
            } else {
                rs = false;
            }

        } else {
            try {
                Pattern pat = Pattern.compile(regEx);
                Matcher mat = pat.matcher(checkString);
                rs = mat.find();
            } catch (Exception e) {
                rs = false;
            }

        }

        return rs;
    }

    public static boolean contrastResultFloat(String actualValue, String expectValue) {
        boolean b = false;
        DecimalFormat dfNum = new DecimalFormat("##0.00");
        // Float
        // actualValueFloat=Float.parseFloat(subtrahend)-Float.parseFloat(minuend);//取得实际值
        // System.out.println("actualValue111111:"+actualValue);
        if (("0".equals(actualValue)) || (actualValue == null)) {
            actualValue = "0";
        }
        if (("0".equals(expectValue)) || (expectValue == null)) {
            expectValue = "0";
        }
        // System.out.println("actualValue22222:"+actualValue);
        String actualValueFinal = dfNum.format(Float.parseFloat(actualValue));
        String expectValueFinal = dfNum.format(Float.parseFloat(expectValue));
        if (actualValueFinal.equals(expectValueFinal)) {
            b = true;
        }
        return b;

    }

    public static String CutStringWithRE(String regularExpression, String cutStringSource) {
        Pattern p = Pattern.compile(regularExpression);
        Matcher m = p.matcher(cutStringSource);
        String rtn = "";
        if (m.find()) {
            rtn = m.group(1);
        }
        return rtn;
    }

    /**
     * @author lijie32
     * @param msg
     */
    public static void logger_info(String msg) {
        if (System.getProperty("DebugLocal").equals("true")) {
            Dailylog.logInfo(msg);
        }
    }

    /**
     * @author lijie32
     * @param msg
     */
    public static void logger_error(String msg) {
        if (System.getProperty("DebugLocal").equals("true")) {
            Dailylog.logError(msg);
        }
        Assert.fail(msg);
    }

    /**
     * @author lijie32
     * @param second
     */
    public static void waitSleep(int second) {
        try {
            int sec = second;
            do {
                Thread.sleep(1000);
                second -= 1;
                logger_info("wait " + String.valueOf(sec - second) + " second!!");
            } while (second > 0);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @author lijie32
     * @param driver
     * @return
     */
    public static String getCurrentHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    /**
     * @author lijie32
     * @param driver
     * @param hd
     */
    public static void switchToPopPage(WebDriver driver, String hd) {
        Common.waitSleep(2);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String hanedle : windowHandles) {
            if (!hanedle.equals(hd)) {
                driver.switchTo().window(hanedle);
            }
        }
    }

    /**
     * @author lijie32
     * @param driver
     * @param handle
     */
    public static void restoreWindow(WebDriver driver, String handle) {
        driver.switchTo().window(handle);
    }

    public static String getNumericalFromString(String originString) {
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(originString);
        String numberString=m.replaceAll("").trim();
        return numberString;
    }

    public static double priceHandle(String priceStr) {
        String number=getNumericalFromString(priceStr);
        if (priceStr.contains(".")) {
            return Integer.valueOf(number)*1.0/100;
        }else {
            return Integer.valueOf(number);
        }
    }

    public static void acceptPop(WebDriver driver) {
        waitAlertPresent(driver, 3);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void scrollElementIntoViewByXpath(String element, WebDriver driver) {
        try {
            int i = 0;
            while (i < 5) {
                try {
                    WebElement destElement = driver.findElement(By.xpath(element));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                            destElement);
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200)");
                    // To quit loop.
                    i = 5;
                } catch (StaleElementReferenceException ex) {
                    i += 1;
                }
                // Wait for 500 milliseconds to let the view update.
                Thread.sleep(500);
            }

        } catch (NoSuchElementException ex) {
            Dailylog.logInfo("Could not scroll element into view; element not found with xpath: " + element);
            // Do not throw exception here.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean waitUntilElementNotDisplayedByXpath(String element, int timeoutInSeconds,WebDriver driver) {
        // Set WebDriver's wait time to 1 seconds to speed up unnecessary waiting.
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        boolean isDisplayed = true;

        try {
            for (int i = 0; i < timeoutInSeconds; i++) {
                Thread.sleep(1000);

                try {
                    if (!driver.findElement(By.xpath(element)).isDisplayed()) {
                        isDisplayed = false;
                        break;
                    }
                } catch (StaleElementReferenceException ex) {
                    // Element not attached to DOM any more, so check in next iteration.
                }
            }

            if (isDisplayed) {
                logger.warn("Element still displayed after " + timeoutInSeconds + " seconds, XPath: " + element);
            }

        } catch (NoSuchElementException ex) {
            // Element not found.
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Reset WebDriver's wait time to default.
            //driver.manage().timeouts().implicitlyWait(Long.parseLong(Base.timeout), TimeUnit.SECONDS);
        }

        return isDisplayed;
    }

    public static boolean waitUntilElementDisplayedByXpath(String element, int timeoutInSeconds, WebDriver driver) {
        // Set WebDriver's wait time to 1 second. So each iteration will wait for at
        // most 1 second.
//		this.driver = driver;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        boolean isDisplayed = false;

        try {

            for (int i = 0; i < timeoutInSeconds; i++) {
                try {

                    WebElement elem = driver.findElement(By.xpath(element));
                    // Element is found, check its visibility.
                    if (elem.isDisplayed()) {
                        isDisplayed = true;
                        break;
                    } else {
                        Thread.sleep(1000);
                    }

                } catch (NoSuchElementException ex) {
                    // Element not found, go to next iteration.
                } catch (StaleElementReferenceException ex) {
                    // Element not attached to DOM any more, leave for checking in next iteration.

                    // Sleep for 1 second in case wait was not performed in previous code.
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!isDisplayed) {
                Dailylog.logInfo("Element still not displayed after " + timeoutInSeconds + " seconds, XPath: " + element);
            }

        } catch (WebDriverException ex) {
            // Catch all WebDriver exceptions.
            throw ex;
        } finally {
            // Reset WebDriver's wait time to default.
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        return isDisplayed;
    }
//    /**
//     * handle with the special characters for regEx: '$', '(', ')', '*', '+', '.', '[', ']', '?', '\\', '^', '{', '}', '|'
//     * @param originString
//     * @return
//     */
//    public static String preHandleWithRegExString(String RegExString) {
//        String[] arrSpec = {"\\","$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|"};
//        for(String key : arrSpec) {
//            if(RegExString.contains(key)) {
//                RegExString = RegExString.replace(key, "\\"+key);
//            }
//        }
//        return RegExString;
//    }
//
//    /**
//     *
//     * @Title: getItemFromArray
//     * @Description: get the item form a array that item's value was contains reg
//     * @param object[]
//     * @param reg
//     * @return
//     * @return: Object
//     * @author: lijie32
//     * @date: 2019/11/21 16:22:09
//     */
//    public static Object getItemFromArray(Object[] object,String reg) {
//        for (int i = 0; i < object.length; i++) {
//            if (object[i].toString().contains(reg)) {
//                return object[i];
//            }
//        }
//        return null;
//    }


    /**
     * @author suyi3
     */
    public static void setWindowToPhone(WebDriver driver) {
        Dimension d = new Dimension(360,640);
        driver.manage().window().setSize(d);
    }
    public static void setWindowToTablet(WebDriver driver) {
        Dimension d = new Dimension(768,1024);
        driver.manage().window().setSize(d);
    }
    public static void setWindowToDesktop(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void loadpageInNewTab(WebDriver driver,int winIndex ,String url) {
        ((JavascriptExecutor)driver).executeScript("(window.open(''))");
        switchToWindow(driver, winIndex);
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    /**
     * Check if the given element is upper than the specific position on the page
     * @author liufang23
     * @param driver
     * @param el - element be verified
     * @param tarPos - decimal fraction which represent the position of page. range: 0~1(0-top,1-bottom)
     * @return true - upper than the spec position, false - lower than the spec position
     */
    public static boolean checkElementUpperSpecificPositionOnPage(WebDriver driver, WebElement el, float tarPos) {
        JavascriptExecutor jsdriver = (JavascriptExecutor) driver;

        // get element's offsetTop - distance between element and upper(level) element
        long elOffsetTop = (long)jsdriver.executeScript("return parseInt(arguments[0].offsetTop); ", el);
        // get browser's inner height
        long winHeight = (long)jsdriver.executeScript("return parseInt(window.innerHeight);");
        // get distance of scroll moves down
        long winScrollTop = (long)jsdriver.executeScript("return parseInt($(window).scrollTop());");

        // get the distance of the element from top of the view
        long disTopEL = elOffsetTop-winScrollTop;
        // calculate target position
        long tarTop = (long)(winHeight * tarPos);

        // Verify if the position of the element is in the expected place on page
        if(disTopEL<tarTop) {
            return true;
        }
        else {
            return false;
        }
    }

//    public static void publishUSProductV3(APIInfos api,String pn) throws IOException {
//        String resp=HttpCommon.getRequest(api.getV3Prodcut(pn, APIInfos.Contextstring.V3PRODUCT_US));
//        String pk=APIResponseHandle.v3Product_id(resp, pn);
//        HttpCommon.getRequest(api.getV3Publish(pk));
//    }

//    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
//        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
//        ObjectOutputStream out = new ObjectOutputStream(byteOut);
//        out.writeObject(src);
//
//        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
//        ObjectInputStream in = new ObjectInputStream(byteIn);
//        @SuppressWarnings("unchecked")
//        List<T> dest = (List<T>) in.readObject();
//        return dest;
//    }

    /**
     *
     * @param file
     * @Usage:Delete folder
     */

    public static void delFile(File file){
        if(file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File f : files){
                    delFile(f);
                }
            }
            file.delete();
        }
    }

    public static List<String> getKeysFromMap(HashMap<String, String> hm) {
        Iterator<Map.Entry<String, String>> iter = hm.entrySet().iterator();
        List<String> keys= new ArrayList<String>();
        while(iter.hasNext()){
            Map.Entry<String, String> entry = iter.next();
            keys.add(entry.getKey());
        }
        return keys;
    }

}