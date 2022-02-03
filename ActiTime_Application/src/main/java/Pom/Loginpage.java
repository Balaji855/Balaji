package Pom;




import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilExceelsheet.Utility;

public class Loginpage extends Utility{

	@FindBy (xpath= "//input[@name='username']") 
	private WebElement username;
	
	@FindBy (xpath="//input[@name='pwd']")
	private WebElement password;
	
	@FindBy (xpath="//div[text()='Login ']")
	private WebElement login;
	
	public Loginpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public String sendusername() throws EncryptedDocumentException, IOException {
		String userID = getDataFromsheet(1,0);
		username.sendKeys(userID);
		return userID;
	}


	public String sendpass() throws EncryptedDocumentException, IOException {
		String pass = getDataFromsheet(1,1);
		password.sendKeys(pass);
		return pass;
	}
	
	public void clickonlogin() {
		login.click();
	}
}
