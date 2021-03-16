package BookMyShow.Book;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BookMyShowClass {
	public static String browser,URL,LoginLink,emailid,pageSource;
	public static WebElement list;
	public static WebDriver driver = null;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\chrom\\chromedriver.exe");  
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://www.google.com");
	  driver.manage().window().maximize();
  }
}
