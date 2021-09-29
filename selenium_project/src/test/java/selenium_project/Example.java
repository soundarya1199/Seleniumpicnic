package selenium_project;



import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example {

	
	
	//public static void main(String[] args) throws InterruptedException {
	@Test
	
	public void sample() throws Exception {

		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\soundaryav\\eclipse-workspace-selinium\\Selinium_Project\\drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\soundaryav\\eclipse-workspace-selinium\\Selinium_Project\\drivers\\geckodriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		takeSnapShot(driver, "C:\\Users\\soundaryav\\Pictures\\Screenshots\\testss.png") ; 

		
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		driver.quit();
	}
		public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =((TakesScreenshot)webdriver);
			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			File DestFile=new File(fileWithPath);
			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
			
		
	}

}
