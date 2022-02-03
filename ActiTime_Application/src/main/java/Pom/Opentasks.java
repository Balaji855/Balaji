package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opentasks {

	@FindBy (xpath="//div[@id='ext-comp-1016']")
	private WebElement opentasks;
	
	public Opentasks(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycreatetasks() {
		boolean result =opentasks.isEnabled();
		return result;
		
	}
}
