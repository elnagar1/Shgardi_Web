package tests;

import framework.PageBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import utilities.Helper;

import java.util.concurrent.TimeUnit;

public class TestBase  {
	public static WebDriver driver;
	LoginPage loginPage;

	public String USERNAME = PageBase.reader.getR_User();
	public String ACCESS_KEY = PageBase.reader.getR_Password();
	String browser = PageBase.reader.getBrowser().toLowerCase();
	public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

	//مؤجل
    /*
	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
*/

	@BeforeSuite
	public void startDriver() {

	     System.out.println("Selected Browser is: "+browser);

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser is Started" + driver.hashCode());

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Chrome Browser is Started" + driver.hashCode());

		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			System.out.println("Chrome Browser is Started" + driver.hashCode());
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://dashboard-dev.shgardi.app/auth/login");
		System.out.println("Open: "+driver.getCurrentUrl());

		USERNAME = PageBase.reader.getValidPassword();
		ACCESS_KEY = PageBase.reader.getValidMobile();
		loginPage = new LoginPage(driver);
		String A1 = loginPage.UserLogin(ACCESS_KEY, USERNAME);
		Assert.assertTrue(A1.contains( "MainActivity"));
		System.out.println(A1);
	}


	@AfterSuite
	public void stopDriver() {
		//driver.quit();
	}

	// take screenshot when test case fail and add it in the Screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}
