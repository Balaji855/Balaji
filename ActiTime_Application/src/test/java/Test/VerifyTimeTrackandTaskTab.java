package Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Base;
import Pom.ActiTimeHeader;
import Pom.Entertimetrack;
import Pom.Loginpage;
import Pom.Opentasks;
import UtilExceelsheet.Utility;


public class VerifyTimeTrackandTaskTab extends Base{
	
	private WebDriver driver; 
	private ActiTimeHeader actiTimeHeader;
	private SoftAssert softassert;
	private Opentasks opentasks;
	private Loginpage loginpage;
	private Entertimetrack entertimetrack;
	private int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	 
	@BeforeTest()
	@Parameters("browser")
	public void LaunchBrowser(String browser) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		System.out.println("Launch the browser");

		if(browser.equals("Chrome")) 
		{
			driver = openChromeBrowser();
		}
		if(browser.equals("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@BeforeClass()
	public void initilizationpomclasses() {
		 loginpage = new Loginpage(driver);
		 actiTimeHeader=new ActiTimeHeader(driver);
		 opentasks = new Opentasks(driver);
		 entertimetrack=new Entertimetrack(driver);
	}
	
	@BeforeMethod()
	public void loginActiTime() throws EncryptedDocumentException, IOException {
		System.out.println("LoginActTime");
		driver.get("http://localhost/login.do");
		loginpage.sendusername();
		loginpage.sendpass();
		loginpage.clickonlogin();
	    softassert=new SoftAssert();
	}
	
	@Test()
	public void ToVerifyTimeTrackTab() {
		testID = 101;
		System.out.println("ToVerifyTimeTrackTab");
		actiTimeHeader.clickontimetracktab();
		System.out.println(driver.getCurrentUrl());
		String url=driver.getCurrentUrl();
		System.out.println("url");
		Assert.assertEquals(url, "http://localhost/user/submit_tt.do");
		boolean message = entertimetrack.showtheTimetrack();
		softassert.assertEquals(message, true);
		softassert.assertAll();
	  
	}
	@Test()
	public void ToVerifyTaskTab() throws InterruptedException {
		testID=102;
		System.out.println(" ToVerifyTaskTab");
		actiTimeHeader.clicktasktab();
		System.out.println(driver.getCurrentUrl());
		String url=driver.getCurrentUrl();
		System.out.println("url");
	
		Assert.assertEquals(url, "http://localhost/tasks/otasklist.do");
		String tital = driver.getTitle();
		System.out.println(tital);
		softassert.assertEquals(tital, "actiTIME - Open Tasks");
		boolean enabled = opentasks.verifycreatetasks();
		softassert.assertEquals(enabled, true);
		softassert.assertAll();
		
	}
	
	@AfterMethod()
	public void logoutActiTime(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.saveScreenshot(driver, testID);
		}
		actiTimeHeader.clickonlogout();
		System.out.println("LogoutFromActiTime");
	}
	
	@AfterClass()
	public void Clearobject() {
		loginpage=null;
		actiTimeHeader=null;
		opentasks=null;
	}
	
	@AfterTest()
	public void closeBrowser() {
		System.out.println("ClosedBrowser");
		driver.quit();
		driver=null;
		System.gc();
	}
	

}
