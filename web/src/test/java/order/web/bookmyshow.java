package order.web;

import org.testng.annotations.Test;
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

public class bookmyshow {
	public static String browser,URL,loginLink,emailId,pageSource;
	public static WebElement list;
	public static WebDriver driver =null;
	public static FileInputStream filein =null;
	public static XSSFWorkbook workbook =null;
	public static XSSFSheet sheet =null;
	public static XSSFRow row =null;
	public static XSSFRow row1 =null;
	public static XSSFRow row2=null;
	public static XSSFRow row3 =null;
	static String path =System.getProperty("user.dir");
  @Test
  public void f() {
  }
}
