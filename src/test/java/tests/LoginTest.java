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
    public void loginValidPhoneAndPassword(ٍ) {
        password = PageBase.reader.getValidPassword();
        number = PageBase.reader.getValidMobile();
        loginPage = new LoginPage(driver);
        String A1 = loginPage.userLogin_logout(number, password);
        Assert.assertTrue(A1.contains( "MainActivity"));
        System.out.println(A1);

    }





    public void loginValidPhoneAndInValidPassword() {

        password = PageBase.reader.getInValidPassword();
        number = PageBase.reader.getValidMobile();
        loginPage = new LoginPage(driver);
        String A1 = loginPage.UserLogin(number, password);
        Assert.assertTrue(!(A1.contains("MainActivity")));
        System.out.println(A1);

    }



    public void loginValidUnregisteredPhone() {
        password = PageBase.reader.getValidPassword();
        number = PageBase.reader.getValidUnregisteredPhone();
        loginPage = new LoginPage(driver);
        Boolean A1 = loginPage.register(number, password);
        driver.navigate().back();
        driver.navigate().back();
        Assert.assertTrue(A1);
    }


    public void loginInValidPhone()
    {
        password = PageBase.reader.getValidPassword();
        number = PageBase.reader.getInValidMobile();
        loginPage = new LoginPage(driver);
        loginPage.UserLogin(number,password);
        //Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }


    public void restPassword()
    {
        password = PageBase.reader.getValidPassword();
        number = PageBase.reader.getValidMobile();
        loginPage = new LoginPage(driver);
        loginPage.UserLogin(number,password);
        //Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }



}
