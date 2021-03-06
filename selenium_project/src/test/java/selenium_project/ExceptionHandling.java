package selenium_project;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionHandling {
public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver","C:\\\\\\\\Users\\\\\\\\soundaryav\\\\\\\\eclipse-workspace-selinium\\\\\\\\Selinium_Project\\\\\\\\drivers\\\\\\\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("http://demo.guru99.com/popup.php");
driver.manage().window().maximize();
try {
driver.findElement(By.id("//*[contains(@href,'popup.php')]")).click();
}
catch (NoSuchElementException e) {
System.out.println("-----------------xpath exception----------------------");
}
String MainWindow=driver.getWindowHandle();
// To handle all new opened window.
Set<String> s1=driver.getWindowHandles();
Iterator<String> i1=s1.iterator();
while(i1.hasNext())
{
String ChildWindow=i1.next();
if(!MainWindow.equalsIgnoreCase(ChildWindow))
{
Thread.sleep(3000);
// Switching to Child window
driver.switchTo().window(ChildWindow);
driver.findElement(By.name("emailid"))
.sendKeys("gaurav.3n@gmail.com");
driver.findElement(By.name("btnLogin")).click();

// Closing the Child Window.
driver.close();
}
}

 }

}