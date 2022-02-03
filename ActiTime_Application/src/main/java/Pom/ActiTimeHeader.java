package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeHeader {

	@FindBy (xpath="//a[@class='content tt_selected selected']") 
	private WebElement timetrack;
	
	@FindBy(xpath="//a[@class='content tasks']") 
	private WebElement task; 
	
	@FindBy (xpath="//a[@class='content reports']")
	private WebElement report;
	
	@FindBy (xpath="//a[@class='logout']")
	private WebElement logout;
	
	public ActiTimeHeader(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickontimetracktab() {
		timetrack.click();
	}
	public void clicktasktab() {
		task.click();
	}
	public void clickreporttab() {
		report.click();
	}
	public void clickonlogout() {
		logout.click();
	}
	
}
