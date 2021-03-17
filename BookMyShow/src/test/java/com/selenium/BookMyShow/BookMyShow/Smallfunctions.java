package com.selenium.BookMyShow.BookMyShow;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Smallfunctions {
	public static WebDriver driver = null;
	static String path = System.getProperty("user.dir");
  @Test
  public void f() {
		System.setProperty("webdriver.chrome.driver",
				path+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com/explore/home/erode");
		driver.findElement(By.id("wzrk-cancel")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Sports")).click();										//The sports event page is clicked
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(@class,'style__StyledText-sc-7o7nez-0 boewjJ') and contains(text(),'This Weekend')]")).click(); 	 		//The events were sorted for this weekend
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//a[contains(@class,'commonStyles__LinkWrapper-sc-133848s-11 style__CardContainer-sc-1ljcxl3-1 Xdzak')]"));
		List<WebElement> link = driver. findElements(By.xpath("//a[contains(@class,'commonStyles__LinkWrapper-sc-133848s-11 style__CardContainer-sc-1ljcxl3-1 Xdzak')]"));
		System.out.println(link.size());
		for(int i=0;i<link.size();i++){
			//List<WebElement> text = driver.findElements(By.xpath("//a[contains(@class,'commonStyles__LinkWrapper-sc-133848s-11 style__CardContainer-sc-1ljcxl3-1 Xdzak')][i]"));
			//System.out.println(driver. findElement(By.xpath("//a[contains(@class,'commonStyles__LinkWrapper-sc-133848s-11 style__CardContainer-sc-1ljcxl3-1 Xdzak')]")).getText());
			System.out.println(link.get(i).getText());
			System.out.println(i);
			System.out.println("-----------------------------------------------------------------------------------");
			
		}
		
  }
}
