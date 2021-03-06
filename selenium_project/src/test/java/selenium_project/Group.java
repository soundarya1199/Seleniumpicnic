package selenium_project;


	
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;
	 
	public class Group {
	 
	WebDriver driver;
	 
	/**
	* This function will execute before each Test tag in testng.xml
	* @param browser
	* @throws Exception
	*/
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
	//Check if parameter passed from TestNG is 'firefox'
	if(browser.equalsIgnoreCase("firefox")){
	//create firefox instance
	System.setProperty("webdriver.gecko.driver","C:\\\\Users\\\\soundaryav\\\\eclipse-workspace-selinium\\\\Selinium_Project\\\\drivers\\\\geckodriver.exe");
	driver = new FirefoxDriver();
	}
	 
	//Check if parameter passed as 'chrome'
	else if (browser.equalsIgnoreCase("chrome")){
	//set path to chromedriver.exe
	System.setProperty("webdriver.chrome.driver","C:\\Users\\soundaryav\\eclipse-workspace-selinium\\Selinium_Project\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	 
	}

	else{
	//If no browser passed throw exception
	throw new Exception("Browser is not correct");
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	 
	@Test
	public void testParameterWithXML() throws InterruptedException{
		driver.get("https://opensource-demo.orangehrmlive.com/");   
		
		if(driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/svg[1]/switch[1]/g[1]/g[1]/image[1]")).isDisplayed())
	    {
	           System.out.println("Image is  present");
	    }
	    else {
	           System.out.println("Image is not present");
	    }

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#btnLogin")).click();
		
		if(driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/canvas[2]")).isDisplayed())
	    {
	           System.out.println("Image is  present");
	    }
	    else {
	           System.out.println("Image is not present");
	    }
		
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#menu_recruitment_viewCandidates")).click();
		
		driver.findElement(By.id("frmSrchCandidates")).getAttribute("candidateSearch_jobTitle");
		driver.equals("23");
	
		
	}
	}
	
	
		
		
		
		
		
		