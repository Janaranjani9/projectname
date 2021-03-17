package com.selenium.BookMyShow.BookMyShow;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BookMyShowClass {
	public static String browser,URL,loginLink,emailId,pageSource;
	public static WebElement list;
	public static WebDriver driver = null;
	public static FileInputStream filein = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFRow row1 = null;
	public static XSSFRow row2 = null;
	public static XSSFRow row3 = null;
	static String path = System.getProperty("user.dir");
	
	@BeforeTest
	public void openFile() throws InterruptedException, IOException {							//To open file and store data as global variable
		try
		{
			filein = new FileInputStream(path+"\\Excel\\BookMyShowTestData.xlsx");							
			workbook = new XSSFWorkbook(filein);
			sheet = workbook.getSheet("Sheet1");
			row = sheet.getRow(0);
			browser = row.getCell(1).toString();
			row1 = sheet.getRow(1);
			URL = row1.getCell(1).toString();
			row2=sheet.getRow(2);
			loginLink=row2.getCell(1).toString();
			row3=sheet.getRow(3);
			emailId=row3.getCell(1).toString();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
	}
		
	@Test
	public static void bookMyShowFunctions() {													//The required steps are executed here
		String browserdriver = browser;															//To use the browser from user requirement
		String link = URL;
		if (browserdriver.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver",
					path+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browserdriver.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",
			"C:\\chrom\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Not a valid browser");
		}
		driver.manage().window().maximize();
		driver.get(link);																		//The BookMyShow Website is loaded
		
		String Actual = driver.getTitle();														
		String Expected = "Movie Tickets, Plays, Sports, Events & Cinemas near Erode - BookMyShow";
        if (Actual.equals(Expected)) {
                   System.out.println("Test Passed!");
        } else {
                   System.out.println("Test Failed");
        }
        driver.findElement(By.id("wzrk-cancel")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		BookMyShowClass.sports();
		BookMyShowClass.sortThisWeekend();
		BookMyShowClass.list();
		BookMyShowClass.language();
		BookMyShowClass.signin();
	}
	
	public static void sports(){
		driver.findElement(By.linkText("Sports")).click();										//The sports event page is clicked
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public static void sortThisWeekend(){
		driver.findElement(By.xpath("//div[contains(@class,'style__StyledText-sc-7o7nez-0 boewjJ') and contains(text(),'This Weekend')]")).click(); 	 		//The events were sorted for this weekend
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);																							//As there is no sort by fee
	}

	public static void list(){
		List<WebElement> links = driver.findElements(By.xpath("//a[contains(@class,'commonStyles__LinkWrapper-sc-133848s-11 style__CardContainer-sc-1ljcxl3-1 Xdzak')]"));
		for(int i=0;i<links.size();i++){
			System.out.println("Sports And Title");
			System.out.println(links.get(i).getText());
			System.out.println("-----------------------------------------------------------------------------------");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
	}
	
	public static void language(){
		driver.get("https://in.bookmyshow.com/explore/movies-erode");										//The Movies event page is clicked
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='super-container']/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div[1]")).click();
		List<WebElement> languages = driver.findElements(By.xpath("//div[contains(@class,'commonStyles__VerticalFlexBox-sc-133848s-2 style__ChipWrapper-sc-7naidv-0 bMcwPJ')]"));
		for(int i=0;i<languages.size();i++){																//The languages list is stored
			System.out.println("Languages For Movies");
			System.out.println(languages.get(i).getText());
			System.out.println("-----------------------------------------------------------------------------------");
		}
	}
			
	public static void signin(){	
		driver.findElement(By.xpath("//div[contains(text(),'Sign in')]")).click();				//Sign in the website using google
		driver.findElement(By.xpath("//div[contains(text(),'Continue with Google')]")).click();
		driver.get(loginLink);
		WebElement email=driver.findElement(By.xpath("//input[contains(@class,'whsOnd zHQkBf')and contains(@name,'identifier')]"));
		email.sendKeys(emailId);
		email.submit();
		driver.findElement(By.xpath("//button[contains(@class,'VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b')]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		System.out.println("The error message is:" +driver.findElement(By.xpath("//div[contains(@class,'o6cuMc')]")).getText());  
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);							//Capturing the error message
	}
	
	@AfterTest																					
	public static void closeBrowser(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;						 
		driver.quit();																			//The driver is closed 
	}
}
