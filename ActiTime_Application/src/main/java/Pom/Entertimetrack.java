package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Entertimetrack {
	
	@FindBy (xpath="((//table[@align='center'])[3]//td)[5]//div") 
	private WebElement checkthedate;
	
	public Entertimetrack(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean showtheTimetrack() {
		boolean result = checkthedate.isEnabled();
		return result;
		
	}

}
