package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\balaji\\\\chromedriver_win32\\\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
		return driver;	    
	}

	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\balaji\\edgedriver_win32\\msedgedriver.exe");
	    WebDriver driver=new EdgeDriver();
		return driver;	    
	}

}
