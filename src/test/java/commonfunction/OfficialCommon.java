package commonfunction;

import org.openqa.selenium.WebDriver;
import pages.OfficialHomePage;
import utils.SuperTestClass;

public class OfficialCommon {
    public static void login(OfficialHomePage officialHomePage, String emailId, String password){
        officialHomePage.loginBtn.click();
        officialHomePage.Login_EmailTextBox.sendKeys(emailId);
        officialHomePage.Login_PasswordTextBox.clear();
        officialHomePage.Login_PasswordTextBox.sendKeys(password);
        officialHomePage.Login_SignInButton.click();
    }

    public static void closePopup(WebDriver driver) {
        OfficialHomePage officialHomePage = new OfficialHomePage(driver);
        if (Common.checkElementDisplays(driver, officialHomePage.lenovoHomePopup, 5)) {
            officialHomePage.lenovoHomePopup.click();
            Dailylog.logInfo("Popup is closed!");
        }
    }

}
