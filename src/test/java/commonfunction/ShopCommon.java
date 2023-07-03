package commonfunction;

import pages.ShopPage;

public class ShopCommon {
    public static void login(ShopPage shopPage, String emailId, String password){
        shopPage.loginBtn.click();
        shopPage.Login_EmailTextBox.sendKeys(emailId);
        shopPage.Login_PasswordTextBox.clear();
        shopPage.Login_PasswordTextBox.sendKeys(password);
        shopPage.Login_SignInButton.click();
    }
}
