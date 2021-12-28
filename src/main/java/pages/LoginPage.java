package pages;

import framework.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailTxtBox ;

    @FindBy(id = "password")
    WebElement passwordTxtBox;

    @FindBy(id = "btn_login kt_login_signin_submit")
    WebElement sighInButton;


    public String userLogin(String email, String password) {
        setTextElementText(emailTxtBox,email);
        setTextElementText(passwordTxtBox,password);
        clickButton(sighInButton);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getCurrentUrl();
    }



}
