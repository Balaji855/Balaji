package UtilExceelsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String getDataFromsheet(int row,int col) throws EncryptedDocumentException, IOException {
		
		String data = null;
		
		String path="C:\\Users\\balaji\\OneDrive\\Desktop\\TestDataforActtime.xlsx";
		
		FileInputStream file=new FileInputStream(path);
		
//		 WorkbookFactory.create(file).getSheet("Sheet1");
//		 
		 try
		 {
		  data =  WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(col).getStringCellValue();
			 
		 }
		 catch(IllegalStateException e)
		 {
			double d = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(col).getNumericCellValue();
			data=String.valueOf(d);
		 }
		catch(NullPointerException g)
		{
			System.out.println("cell is Blank");
		}
		catch(Exception c)
		{
		  c.printStackTrace();	
		}
		return data;
		
	}
	
	public static void saveScreenshot(WebDriver driver,int testID) throws IOException {
	
	   Date d=new Date(); 
	   String s1=d.toString().replace(":", "-").replace(" ", "-");
	   File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File destination=new File("C:\\Users\\balaji\\Screenshot\\testID"+testID+s1+".jpg");
	   FileHandler.copy(source, destination);
	  // return testID;
	   System.out.println("Hi");
         //Hello GitHub
	}
}
