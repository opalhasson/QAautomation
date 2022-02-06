package Store;


import junit.framework.Assert;
import static org.junit.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.logging.log4j.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class portionOfSanity {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	Logger logger=LogManager.getLogger(portionOfSanity.class);
	
	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver","//Users//opalhasson//Desktop//chromedriver");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		ReadExcl objExcelFile = new ReadExcl();
		objExcelFile.readExcel("exlFiles","inputXLS.xls","sheet1");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginStep1() throws InterruptedException { 		
		driver.get("https://www.demoblaze.com/");
		logger.info("login Step1 start running - user login with correct username and password");
		logger.debug("opening webiste");
		driver.manage().window().setSize(new Dimension(1200, 650));
		logger.debug("entring size");
		driver.findElement(By.id("login2")).click();
		logger.debug("select login button");
		Thread.sleep(500);
		Sheet thsSheet=ReadExcl.getsheet();
		Row row = thsSheet.getRow(0);
		logger.debug("reading from exel file - sheet 1 - row 0");
		driver.findElement(By.id("loginusername")).sendKeys(row.getCell(0).getStringCellValue()); //opalhasson
	    logger.debug("read user name from exel file and enter it to the loginusername field ");
		driver.findElement(By.id("loginpassword")).sendKeys(row.getCell(1).getStringCellValue()); //op123456
	    logger.debug("read user password from exel file and enter it to the loginpassword field ");
		driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
		logger.debug("clicking on login button");
		logger.debug("user can login with currect username and password");
		logger.debug("login Step1 - test passed");
	}
	
	@Test
	public void loginStep2() throws InterruptedException { 
		driver.get("https://www.demoblaze.com/");
		logger.info("login Step2 start running - user login with incorrect password");
		logger.debug("opening webiste");
		driver.manage().window().setSize(new Dimension(1200, 650));		
		logger.debug("entring size");
		driver.findElement(By.id("login2")).click();
		logger.debug("select login button");
	    Thread.sleep(500);
	    Sheet thsSheet=ReadExcl.getsheet();
		Row row = thsSheet.getRow(1);
		logger.debug("reading from exel file - sheet 1 - row 1");
		driver.findElement(By.id("loginusername")).sendKeys(row.getCell(0).getStringCellValue()); //opalhasson
	    logger.debug("read user name from exel file and enter it to the loginusername field ");
		driver.findElement(By.id("loginpassword")).sendKeys(row.getCell(1).getStringCellValue()); //op112345
	    logger.debug("read user password from exel file and enter it to the loginpassword field ");
		driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
		logger.debug("clicking on login button");
		logger.debug("user can't login with incorrect password");
		logger.debug("login Step2 - test passed");
	}
	
	@Test
	public void loginStep3() throws InterruptedException { 
		driver.get("https://www.demoblaze.com/");
		logger.info("login Step3 start running - user login with incorrect username and password");
		logger.debug("opening webiste");
		driver.manage().window().setSize(new Dimension(1200, 650));	
		logger.debug("entring size");
		driver.findElement(By.id("login2")).click();
		logger.debug("select login button");
	    Thread.sleep(500);
	    Sheet thsSheet=ReadExcl.getsheet();
		Row row = thsSheet.getRow(2); 
		logger.debug("reading from exel file - sheet 1 - row 2");
		driver.findElement(By.id("loginusername")).sendKeys(row.getCell(0).getStringCellValue()); //naomie
	    logger.debug("read user name from exel file and enter it to the loginusername field ");
		driver.findElement(By.id("loginpassword")).sendKeys(row.getCell(1).getStringCellValue()); //na123456
	    logger.debug("read user password from exel file and enter it to the loginpassword field ");
		driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
		logger.debug("clicking on login button");
		logger.debug("user can't login with incorrect username and password");
		logger.debug("login Step3 - test passed");
	}

	@Test
	public void logOutStep1() throws InterruptedException { 
	    driver.get("https://www.demoblaze.com/index.html");
	    logger.info("logOut Step1 start running - connected user logout");
		logger.debug("opening webiste");
	    driver.manage().window().setSize(new Dimension(1200, 650));
	    logger.debug("entring size");
	    driver.findElement(By.id("login2")).click();    
	    logger.debug("click on Login button");
	    Thread.sleep(500);
	    Sheet thsSheet=ReadExcl.getsheet();
	    Row row = thsSheet.getRow(0); 
	    logger.debug("reading from exel file - sheet 1 - row 0");
	    driver.findElement(By.id("loginusername")).sendKeys(row.getCell(0).getStringCellValue()); //opalhasson
	    logger.debug("read user name from exel file and enter it to the loginusername field ");
	    driver.findElement(By.id("loginpassword")).sendKeys(row.getCell(1).getStringCellValue()); //op123456
	    logger.debug("read user password from exel file and enter it to the loginpassword field ");
	    driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
	    logger.debug("login");
	    Thread.sleep(500);
	    driver.findElement(By.id("cartur")).click();
	    driver.findElement(By.cssSelector(".active > .nav-link")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("logout2")).click();	    
	    logger.debug("click on logout button");
	    logger.debug("connected user can logout");
		logger.debug("logOut Step1 - test passed");   
	}
	
	public void logOutStep2() throws InterruptedException { 
	    driver.get("https://www.demoblaze.com/index.html");
	    logger.info("logOut Step2 start running - offline user logout");
		logger.debug("opening webiste");
		driver.manage().window().setSize(new Dimension(1200, 650));
	    logger.debug("entring size");	    
	    driver.findElement(By.id("cartur")).click();
	    logger.debug("click on cart button");
	    driver.findElement(By.cssSelector(".active > .nav-link")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("logout2")).click();	    
	    logger.debug("click on logout button");
	    logger.debug("offline user can't logout");
		logger.debug("logOut Step1 - test passed");   
	}

	@Test
	public void PaymentStep1() throws InterruptedException { 
		driver.get("https://www.demoblaze.com/");
		logger.info("Payment Step1 start running - connected user purchases");
		logger.debug("opening webiste");
		driver.manage().window().setSize(new Dimension(1200, 650));	  
		logger.debug("entring size");
		driver.findElement(By.id("login2")).click();
		logger.debug("pressing the button login");
	    Thread.sleep(500);	
	
		Sheet thsSheet=ReadExcl.getsheet();
	    Row row = thsSheet.getRow(4); 
	    logger.debug("reading from exel file - sheet 1 - row 4");
	    driver.findElement(By.id("loginusername")).sendKeys(row.getCell(0).getStringCellValue()); //opalhasson
	    logger.debug("read user name from exel file and enter it to the loginusername field ");
	    driver.findElement(By.id("loginpassword")).sendKeys(row.getCell(1).getStringCellValue()); //op123456
	    logger.debug("read user password from exel file and enter it to the loginpassword field ");
	    driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
	    logger.debug("clicking on login button");
	    Thread.sleep(500);		
		driver.findElement(By.id("cartur")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector(".active > .nav-link")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector(".col-lg-4:nth-child(1) .card-img-top")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Add to cart")).click();
		logger.debug("Adding Samsung galaxy s6 to the shopping cart");
		driver.findElement(By.id("cartur")).click();
		driver.findElement(By.cssSelector(".btn-success")).click();
		Thread.sleep(500);
		driver.findElement(By.id("name")).sendKeys(row.getCell(2).getStringCellValue());//opal
	    logger.debug("read user name from exel file and enter it to the name field ");
		driver.findElement(By.id("country")).sendKeys(row.getCell(3).getStringCellValue());//israel
	    logger.debug("read user country from exel file and enter it to the country field ");
		driver.findElement(By.id("city")).sendKeys(row.getCell(4).getStringCellValue());	 //holon
	    logger.debug("read user city from exel file and enter it to the city field ");
		driver.findElement(By.id("card")).sendKeys(row.getCell(5).getStringCellValue());  //3256123443211234  
	    logger.debug("read user card from exel file and enter it to the card field ");
		driver.findElement(By.id("month")).sendKeys((int)(row.getCell(6).getNumericCellValue())+"");//12
	    logger.debug("read user card month from exel file and enter it to the month field ");
		driver.findElement(By.id("year")).sendKeys((int)(row.getCell(7).getNumericCellValue())+"");//2028
	    logger.debug("read user card year from exel file and enter it to the year field ");
		driver.findElement(By.cssSelector("#orderModal .btn-primary")).click();
		driver.findElement(By.cssSelector(".confirm")).click();
		logger.debug("click on purchase button");
		logger.debug("connected user can purchases");
		logger.debug("Payment Step1 - test passed"); 


	}

	@Test
	public void PaymentStep2() throws InterruptedException { 
		driver.get("https://www.demoblaze.com/");
		logger.info("Payment Step2 start running - offline user purchases");
		logger.debug("opening webiste");
		driver.manage().window().setSize(new Dimension(1200, 650)); 
		logger.debug("entring size");		
		driver.findElement(By.linkText("Nokia lumia 1520")).click(); 
		Thread.sleep(500);
		driver.findElement(By.linkText("Add to cart")).click();
		logger.debug("pressing the button add to cart");
		Sheet thsSheet=ReadExcl.getsheet();
	    Row row = thsSheet.getRow(4);
	    logger.debug("reading from exel file - sheet 1 - row 4");
		driver.findElement(By.id("cartur")).click();
		driver.findElement(By.cssSelector(".btn-success")).click();
		Thread.sleep(500);
		driver.findElement(By.id("name")).sendKeys(row.getCell(2).getStringCellValue());//opal
	    logger.debug("read user name from exel file and enter it to the name field ");
		driver.findElement(By.id("country")).sendKeys(row.getCell(3).getStringCellValue());//israel
	    logger.debug("read user country from exel file and enter it to the country field ");
		driver.findElement(By.id("city")).sendKeys(row.getCell(4).getStringCellValue());	 //holon
	    logger.debug("read user city from exel file and enter it to the city field ");
		driver.findElement(By.id("card")).sendKeys(row.getCell(5).getStringCellValue());  //3256123443211234  
	    logger.debug("read user card from exel file and enter it to the card field ");
		driver.findElement(By.id("month")).sendKeys((int)(row.getCell(6).getNumericCellValue())+"");//12
	    logger.debug("read user card month from exel file and enter it to the month field ");
		driver.findElement(By.id("year")).sendKeys((int)(row.getCell(7).getNumericCellValue())+"");//2028
	    logger.debug("read user card year from exel file and enter it to the year field ");
		driver.findElement(By.cssSelector("#orderModal .btn-primary")).click();
		driver.findElement(By.cssSelector(".confirm")).click();
		logger.debug("click on purchase button");
		logger.debug("offline user can purchases");
		logger.debug("Payment Step2 - test failed"); 
	}

	@Test
	public void PaymentStep3() throws InterruptedException { 
		driver.get("https://www.demoblaze.com/");
		logger.info("Payment Step3 start running - connected user purchases with invalid card");
		logger.debug("opening webiste");
		driver.manage().window().setSize(new Dimension(1200, 650));	   
		logger.debug("entring size");
		driver.findElement(By.id("login2")).click();
		logger.debug("pressing the button login");
	    Thread.sleep(500);	
	
		Sheet thsSheet=ReadExcl.getsheet();
	    Row row = thsSheet.getRow(5); 
	    logger.debug("reading from exel file - sheet 1 - row 5");
	    driver.findElement(By.id("loginusername")).sendKeys(row.getCell(0).getStringCellValue()); //opalhasson
	    logger.debug("read user name from exel file and enter it to the loginusername field ");
	    driver.findElement(By.id("loginpassword")).sendKeys(row.getCell(1).getStringCellValue()); //op123456
	    logger.debug("read user password from exel file and enter it to the loginpassword field ");
	    driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
	    logger.debug("clicking on login button");
	    Thread.sleep(500);		
		driver.findElement(By.id("cartur")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector(".active > .nav-link")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector(".col-lg-4:nth-child(1) .card-img-top")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Add to cart")).click();
		logger.debug("Adding Samsung galaxy s6 to the shopping cart");
		driver.findElement(By.id("cartur")).click();
		driver.findElement(By.cssSelector(".btn-success")).click();
		Thread.sleep(500);
		driver.findElement(By.id("name")).sendKeys(row.getCell(2).getStringCellValue());//opal
	    logger.debug("read user name from exel file and enter it to the name field ");
		driver.findElement(By.id("country")).sendKeys(row.getCell(3).getStringCellValue());//israel
	    logger.debug("read user country from exel file and enter it to the country field ");
		driver.findElement(By.id("city")).sendKeys(row.getCell(4).getStringCellValue());	 //holon
	    logger.debug("read user city from exel file and enter it to the city field ");
		driver.findElement(By.id("card")).sendKeys(row.getCell(5).getStringCellValue());  //3256123443211234  
	    logger.debug("read user card from exel file and enter it to the card field ");
		driver.findElement(By.id("month")).sendKeys((int)(row.getCell(6).getNumericCellValue())+"");//12
	    logger.debug("read user card month from exel file and enter it to the month field ");
		driver.findElement(By.id("year")).sendKeys((int)(row.getCell(7).getNumericCellValue())+"");//1997
	    logger.debug("read user card year from exel file and enter it to the year field ");
		driver.findElement(By.cssSelector("#orderModal .btn-primary")).click();
		driver.findElement(By.cssSelector(".confirm")).click();
		logger.debug("click on purchase button");
		logger.debug("connected user can purchases with invalid card");
		logger.debug("Payment Step3 - test failed"); 
	}
	
}
