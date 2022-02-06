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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.logging.log4j.*;

public class General {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	Logger logger=LogManager.getLogger(General.class);
		
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
		public void ContactDevelopersStep1() throws InterruptedException { 
			driver.get("https://www.demoblaze.com/index.html");
			logger.info("Contact Developers Step1 start running - connected user contact the developers of the website");
			logger.debug("opening webiste");
			driver.manage().window().setSize(new Dimension(1200, 650));		
			logger.debug("entering size");
			driver.findElement(By.id("login2")).click();
			logger.debug("clicking on login button");
			Thread.sleep(500);
			Sheet thsSheet=ReadExcl.getsheet();
			Row row = thsSheet.getRow(0);
			logger.debug("reading from exel file - sheet 1 - row 0");
			driver.findElement(By.id("loginusername")).sendKeys(row.getCell(0).getStringCellValue()); //opalhasson
		    logger.debug("read user name from exel file and enter it to the loginusername field ");
			driver.findElement(By.id("loginpassword")).sendKeys(row.getCell(1).getStringCellValue()); //op123456
		    logger.debug("read user password from exel file and enter it to the loginpassword field ");
			driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
			Thread.sleep(500);
			driver.findElement(By.linkText("Contact")).click();
			logger.debug("clicking on contact button");
			Thread.sleep(500);
			driver.findElement(By.id("recipient-email")).sendKeys(row.getCell(2).getStringCellValue());
		    logger.debug("read user mail from exel file and enter it to the recipient-email field ");
			driver.findElement(By.id("recipient-name")).sendKeys(row.getCell(3).getStringCellValue());
		    logger.debug("read user name from exel file and enter it to the recipient-name field ");
			driver.findElement(By.id("message-text")).sendKeys(row.getCell(4).getStringCellValue());
		    logger.debug("read user massage from exel file and enter it to the message-text field ");
			driver.findElement(By.cssSelector("#exampleModal .btn-primary")).click();
			logger.debug("clicking on send massage");
			logger.debug("connected user can contact the developers of the website");
			logger.debug("Contact Developers Step1 - test passed");
		}

		@Test
		public void ContactDevelopersStep2() throws InterruptedException { 
			driver.get("https://www.demoblaze.com/index.html");
			logger.info("Contact Developers Step2 start running - offline user contact the developers of the website");
			logger.debug("opening webiste");
			driver.manage().window().setSize(new Dimension(1200, 650));		
			logger.debug("entering size");
			driver.findElement(By.linkText("Contact")).click();
			logger.debug("clicking on contact button");
			Thread.sleep(500);
			Sheet thsSheet=ReadExcl.getsheet();
			Row row = thsSheet.getRow(0);			
			logger.debug("reading from exel file - sheet 1 - row 0");
			driver.findElement(By.id("recipient-email")).sendKeys(row.getCell(2).getStringCellValue());
			logger.debug("read user mail from exel file and enter it to the recipient-email field ");
			driver.findElement(By.id("recipient-name")).sendKeys(row.getCell(3).getStringCellValue());
			logger.debug("read user name from exel file and enter it to the recipient-name field ");
			driver.findElement(By.id("message-text")).sendKeys(row.getCell(4).getStringCellValue());
			logger.debug("read user massage from exel file and enter it to the message-text field ");
			driver.findElement(By.cssSelector("#exampleModal .btn-primary")).click();
			logger.debug("clickin on send massage");
			logger.debug("offline user can contact the developers of the website");
			logger.debug("Contact Developers Step2 - test failed");
		}

		@Test
		public void ContactDevelopersStep3() throws InterruptedException { 
			driver.get("https://www.demoblaze.com/index.html");
			logger.info("Contact Developers Step3 start running - connected user contact the developers of the website");
			logger.debug("opening webiste");
			driver.manage().window().setSize(new Dimension(1200, 650));		
			logger.debug("entering size");
			driver.findElement(By.id("login2")).click();
			logger.debug("clicking on login button");
			Thread.sleep(500);
			Sheet thsSheet=ReadExcl.getsheet();
			Row row = thsSheet.getRow(6);
			logger.debug("reading from exel file - sheet 1 - row 6");
			driver.findElement(By.id("loginusername")).sendKeys(row.getCell(0).getStringCellValue()); //opalhasson
			logger.debug("read user name from exel file and enter it to the loginusername field ");
			driver.findElement(By.id("loginpassword")).sendKeys(row.getCell(1).getStringCellValue()); //op123456
			logger.debug("read user password from exel file and enter it to the loginpassword field ");
			driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
			Thread.sleep(500);
			driver.findElement(By.linkText("Contact")).click();
			logger.debug("clicking on contact button");
			Thread.sleep(500);
			driver.findElement(By.id("recipient-email")).sendKeys(row.getCell(2).getStringCellValue());
			logger.debug("read user mail from exel file and enter it to the recipient-email field ");
			driver.findElement(By.id("recipient-name")).sendKeys(row.getCell(3).getStringCellValue());
			logger.debug("read user name from exel file and enter it to the recipient-name field ");
			driver.findElement(By.id("message-text")).sendKeys(row.getCell(4).getStringCellValue());
			logger.debug("read user massage from exel file and enter it to the message-text field ");
			driver.findElement(By.cssSelector("#exampleModal .btn-primary")).click();
			logger.debug("clicking on send massage");
			logger.debug("connected user can contact the developers of the website");
			logger.debug("Contact Developers Step3 - test failed");
		}

		@Test
		public void SignUpStep1() throws InterruptedException {      
			driver.get("https://www.demoblaze.com/");
			logger.info("SignUp Step1 start running - user signup with a new user name");
			logger.debug("opening webiste");				
			driver.manage().window().setSize(new Dimension(1200, 650));
			logger.debug("entering size");
			driver.findElement(By.id("signin2")).click();
			logger.debug("pressing the button signin");
			Thread.sleep(500);
			Sheet thsSheet=ReadExcl.getsheet();
			Row row = thsSheet.getRow(3);	
			logger.debug("reading from exel file - sheet 1 - row 3");
			driver.findElement(By.id("sign-username")).sendKeys(row.getCell(0).getStringCellValue());
			logger.debug("read user name from exel file and enter it to the sign-username field ");
			driver.findElement(By.id("sign-password")).sendKeys(row.getCell(1).getStringCellValue());
			logger.debug("read user password from exel file and enter it to the sign-password field ");
			driver.findElement(By.cssSelector("#signInModal .btn-primary")).click();
			Thread.sleep(500);
			logger.debug("clicking on signup button");
			logger.debug("user can signup with a new user name");
			logger.debug("SignUp Step1 - test passed");

		}

		@Test
		public void SignUpStep2() throws InterruptedException { 
			driver.get("https://www.demoblaze.com/");
			logger.info("SignUp Step2 start running - user signup with an existing user name");
			logger.debug("opening webiste");	
			driver.manage().window().setSize(new Dimension(1200, 650));
			logger.debug("entering size");
			driver.findElement(By.id("signin2")).click();
			logger.debug("pressing the button signin");
			Thread.sleep(500);
			Sheet thsSheet=ReadExcl.getsheet();
			Row row = thsSheet.getRow(1);	
			logger.debug("reading from exel file - sheet 1 - row 1");
			driver.findElement(By.id("sign-username")).sendKeys(row.getCell(0).getStringCellValue());
			logger.debug("read user name from exel file and enter it to the sign-username field ");
			driver.findElement(By.id("sign-password")).sendKeys(row.getCell(1).getStringCellValue());
			logger.debug("read user password from exel file and enter it to the sign-password field ");
			driver.findElement(By.cssSelector("#signInModal .btn-primary")).click();
			logger.debug("clicking on signup button");
			logger.debug("user can't signup with an existing user name");
			logger.debug("SignUp Step2 - test passed");
		}

		@Test
		public void ProductDescriptionStep1() throws InterruptedException { 
			driver.get("https://www.demoblaze.com/");
			logger.info("Product Description Step1 start running - connected user see the product description");
			logger.debug("opening webiste");				
			driver.manage().window().setSize(new Dimension(1200, 779));
			logger.debug("entering size");
			driver.findElement(By.id("login2")).click();
			Thread.sleep(500);
			Sheet thsSheet=ReadExcl.getsheet();
			Row row = thsSheet.getRow(0);
			logger.debug("reading from exel file - sheet 1 - row 0");
			driver.findElement(By.id("loginusername")).sendKeys(row.getCell(0).getStringCellValue()); //opalhasson
			logger.debug("read user name from exel file and enter it to the loginusername field ");
			driver.findElement(By.id("loginpassword")).sendKeys(row.getCell(1).getStringCellValue()); //op123456
			logger.debug("read user password from exel file and enter it to the loginpassword field ");
			driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
			Thread.sleep(500);
			driver.findElement(By.id("cartur")).click();
			driver.findElement(By.cssSelector(".active > .nav-link")).click();
			Thread.sleep(500);
			driver.findElement(By.cssSelector(".col-lg-4:nth-child(1) .card-img-top")).click();
			logger.debug("clicking on product");
			logger.debug("connected user can see the product description");
			logger.debug("Product Description Step1 - test passed");

		}

		@Test
		public void ProductDescriptionStep2() throws InterruptedException { 
			driver.get("https://www.demoblaze.com/");
			logger.info("Product Description Step2 start running - offline user see the product description");
			logger.debug("opening webiste");	
			driver.manage().window().setSize(new Dimension(1200, 650));
			logger.debug("entering size");
			Thread.sleep(500);
			driver.findElement(By.linkText("Nokia lumia 1520")).click();
			logger.debug("clicking on product");
			logger.debug("connected user can see the product description");
			logger.debug("Product Description Step2 - test faild");
		}

		@Test
		public void tableOfProductStep1() throws InterruptedException { 
			driver.get("https://www.demoblaze.com/");
			logger.info("table Of Product Step1 start running - connected user see the table Of Product");
			logger.debug("opening webiste");	
			driver.manage().window().setSize(new Dimension(1200, 779));
			logger.debug("entering size");
			driver.findElement(By.id("login2")).click();
			logger.debug("pressing the button login");
			Thread.sleep(500);
			Sheet thsSheet=ReadExcl.getsheet();
			Row row = thsSheet.getRow(0);
			logger.debug("reading from exel file - sheet 1 - row 0");
			driver.findElement(By.id("loginusername")).sendKeys(row.getCell(0).getStringCellValue()); //opalhasson
			logger.debug("read user name from exel file and enter it to the loginusername field ");
			driver.findElement(By.id("loginpassword")).sendKeys(row.getCell(1).getStringCellValue()); //op123456
			logger.debug("read user password from exel file and enter it to the loginpassword field ");
			driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
			Thread.sleep(500);
			driver.findElement(By.id("itemc")).click();
			driver.findElement(By.linkText("Laptops")).click();
			logger.debug("click on laptops");
			driver.findElement(By.linkText("Monitors")).click();
			logger.debug("click on Monitors");
			logger.debug("connected user can see the table Of Product");
			logger.debug("table Of Product Step1 - test passed");
		}

		@Test
		public void tableOfProductStep2() { 
			driver.get("https://www.demoblaze.com/index.html");
			logger.info("table Of Product Step2 start running - offline user see the table Of Product");
			logger.debug("opening webiste");	
			driver.manage().window().setSize(new Dimension(1200, 779));
			logger.debug("entering size");
			driver.findElement(By.id("itemc")).click(); 
			driver.findElement(By.linkText("Laptops")).click();
			logger.debug("click on laptops ");
			driver.findElement(By.linkText("Monitors")).click();
			logger.debug("click on monitors");
			logger.debug("offline user can see the table Of Product");
			logger.debug("table Of Product Step2 - test failed");
		}
}
