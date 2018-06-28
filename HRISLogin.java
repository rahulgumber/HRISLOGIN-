package com.qait.automation.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HRISLogin {
	WebDriver driver;
	public void OpenBrowserAndOpenHris()
	{	 System.setProperty("webdriver.chrome.driver","C:\\Users\\rahulgumber\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://hris.qainfotech.com/login.php");
		driver.findElement(By.className("active")).click();
	}
	public String URL()
	{
		return driver.getCurrentUrl();
	}
	
	
	public void Login(String username,String password)
	{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	public void clearFields() 
	{	driver.findElement(By.className("active")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).clear();
	}
	public void Logout() 
	{	
		driver.findElement(By.cssSelector("a[class='profile-btn']")).click();
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a[href=\"https://hris.qainfotech.com:8086/user/logoff\"]")));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement lgtBtn =driver.findElement(By.
				cssSelector("a[href='https://hris.qainfotech.com:8086/user/logoff']"));
		js.executeScript("arguments[0].click();", lgtBtn);
		driver.findElement(By.className("active")).click();
		
		
	}

}
