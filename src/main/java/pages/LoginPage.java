package pages;

import framework.PageBase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    AndroidDriver driver1 = (AndroidDriver) driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailTxtBox ;

    @FindBy(id = "password")
    WebElement passwordTxtBox;

    @FindBy(id = "btn_login kt_login_signin_submit")
    WebElement sighUpButton ;


    public String UserLogin(String number, String password) {
        setTextElementText();
        driver.navigate().back();

        return driver1.currentActivity();
    }



}
