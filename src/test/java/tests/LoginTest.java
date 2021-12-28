package tests;

import framework.PageBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    String password;
    String number;

    @Test(priority = 1)
    public void loginValidPhoneAndPassword() {
        password = PageBase.reader.getValidPassword();
        number = PageBase.reader.getValidMobile();
        loginPage = new LoginPage(driver);
        String A1 = loginPage.userLogin(number, password);
        Assert.assertTrue(A1.contains("MainActivity"));
        System.out.println(A1);

    }


    public void loginValidPhoneAndInValidPassword() {

        password = PageBase.reader.getInValidPassword();
        number = PageBase.reader.getValidMobile();
        loginPage = new LoginPage(driver);
        String A1 = loginPage.userLogin(number, password);
        Assert.assertTrue(!(A1.contains("MainActivity")));
        System.out.println(A1);

    }


    public void loginValidUnregisteredPhone() {

    }


    public void loginInValidPhone() {

    }


    public void restPassword() {

    }


}
