package testPackage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	private String dest;
	
	public String getScreenshotPath() {
		return dest;				
	}
	
	public void captureScreenshot(WebDriver driver, String screenshotname) 
	{
		try
		{
			TakesScreenshot screenshot =(TakesScreenshot)driver;
			
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			
			dest = "./Screenshots/"+screenshotname+".png";
			
			
			
			File destination = new File(dest);
			
			FileUtils.copyFile(source, destination);
			
			System.out.println("Screenshot Taken");
			
		}catch(Exception excep)
		{
			System.out.println("Throwing exception while taking screenshot" +excep.getMessage());
		}

	}


}
