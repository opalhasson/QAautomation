package Store;
import junit.framework.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
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

public class EditingAndViewingCart {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	Logger logger=LogManager.getLogger(EditingAndViewingCart.class);
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
		public void ViewShoppingCartStep1() throws InterruptedException { 
			Thread.sleep(1500);
			driver.get("https://www.demoblaze.com/index.html");
		    logger.info("View Shopping Cart Step1 start running - connected user viewing empty shopping cart");
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
		    logger.debug("read user password from exel file and enter it to the loginpassword field");
			driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
			Thread.sleep(500);
			driver.findElement(By.id("cartur")).click();
		    logger.debug("clicking on the button cart");
		    logger.debug("connected user can see the empty shopping cart");
		    logger.debug("View Shopping Cart Step1 - test passed");
			Thread.sleep(500);

		}
		
		@Test
		public void ViewShoppingCartStep2() throws InterruptedException {  
			Thread.sleep(1500);
			driver.get("https://www.demoblaze.com/");
		    logger.info("View Shopping Cart Step2 start running - connected user viewing shopping cart");
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
		    logger.debug("logged user can see the shopping cart");
		    logger.debug("View Shopping Cart Step2 - test passed");
			Thread.sleep(500);

	   }

		@Test
		public void ViewShoppingCartStep3() throws InterruptedException {  
			Thread.sleep(1500);
			driver.get("https://www.demoblaze.com/index.html");
		    logger.info("View Shopping Cart Step1 start running - offline user viewing shopping cart");
		    logger.debug("opening webiste");
			driver.manage().window().setSize(new Dimension(1200, 779));
			logger.debug("entering size");			
			driver.findElement(By.id("cartur")).click();
			logger.debug("clicking on the button cart");
			logger.debug("offline user can see the shopping cart");
		    logger.debug("View Shopping Cart Step3 - test failed");
			Thread.sleep(500);

		}

		@Test
		public void DeleteProductStep1() throws InterruptedException { 
			Thread.sleep(1500);
			driver.get("https://www.demoblaze.com/");
			logger.info("Delete Product Step1 start running - connected user delete product from shopping cart");
		    logger.debug("opening webiste");
		    driver.manage().window().setSize(new Dimension(1200, 650));
			logger.debug("entering size");
			driver.findElement(By.id("login2")).click();
			Thread.sleep(500);
			Sheet thsSheet=ReadExcl.getsheet();
			Row row = thsSheet.getRow(0);
			logger.debug("reading from exel file - sheet 1 - row 0");
			driver.findElement(By.id("loginusername")).sendKeys(row.getCell(0).getStringCellValue()); //opalhasson
		    logger.debug("read user name from exel file and enter it to the loginusername field ");
			driver.findElement(By.id("loginpassword")).sendKeys(row.getCell(1).getStringCellValue()); //op123456
		    logger.debug("read user password from exel file and enter it to the loginpassword field");
			driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
			Thread.sleep(500);
		    driver.findElement(By.id("cartur")).click();
		    driver.findElement(By.cssSelector(".active > .nav-link")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector(".col-lg-4:nth-child(1) .card-img-top")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Add to cart")).click();
		    logger.debug("add product to shopping cart");
		    driver.findElement(By.cssSelector(".active > .nav-link")).click();
		    driver.findElement(By.id("cartur")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Delete")).click();
		    logger.debug("clicking on the delete button");
			logger.debug("connected user can delete product from shopping cart");
		    logger.debug("Delete Product Step1 - test passed");
			Thread.sleep(500);

		    
		}

		@Test
		public void DeleteProductStep2() throws InterruptedException { 
			Thread.sleep(1500);
			driver.get("https://www.demoblaze.com/");
			logger.info("Delete Product Step2 start running - offline user delete product from shopping cart");
		    logger.debug("opening webiste");
		    driver.manage().window().setSize(new Dimension(1200, 650));
			logger.debug("entring size");		    
			driver.findElement(By.id("cartur")).click();
		    driver.findElement(By.cssSelector(".active > .nav-link")).click();
			Thread.sleep(500);
			driver.findElement(By.linkText("Samsung galaxy s6")).click();
			Thread.sleep(500);
			driver.findElement(By.linkText("Add to cart")).click();
			logger.debug("add product to the cart");
		    driver.findElement(By.cssSelector(".active > .nav-link")).click();
			Thread.sleep(500);
			driver.findElement(By.id("cartur")).click();
			logger.debug("clicking on the cart button");
			Thread.sleep(500);
			driver.findElement(By.linkText("Delete")).click();
			logger.debug("clicking on the delete button");
			logger.debug("offline user can delete product from shopping cart");
			logger.debug("Delete Product Step1 - test faild");  
			Thread.sleep(500);

		}

		@Test
		public void AddToCartStep1() throws InterruptedException { 		
			Thread.sleep(1500);
			driver.get("https://www.demoblaze.com/");
			logger.info("Add To Cart Step1 start running - connected user add product to shopping cart");
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
		    logger.debug("read user password from exel file and enter it to the loginpassword field");
			driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
			Thread.sleep(500);
		    driver.findElement(By.id("cartur")).click();		    
		    driver.findElement(By.cssSelector(".active > .nav-link")).click();
		    Thread.sleep(500);
		    driver.findElement(By.cssSelector(".col-lg-4:nth-child(1) .card-img-top")).click();
		    Thread.sleep(500);
		    driver.findElement(By.linkText("Add to cart")).click();
		    logger.debug("add product to shopping cart");
		    logger.debug("connected user can add product to shopping cart");
		    logger.debug("Add To Cart Step1 - test passed");
			Thread.sleep(500);

		}

		@Test
		public void AddToCartStep2() throws InterruptedException { 
			Thread.sleep(1500);
			driver.get("https://www.demoblaze.com/");
			logger.info("Add To Cart Step2 start running - offline user add product to shopping cart");
			logger.debug("opening webiste");
			driver.manage().window().setSize(new Dimension(1200, 779));
			logger.debug("entering size");
			Thread.sleep(500);
			driver.findElement(By.linkText("Samsung galaxy s6")).click();
			Thread.sleep(500);
			driver.findElement(By.linkText("Add to cart")).click();
			logger.debug("add product to shopping cart");
			logger.debug("offline user can add product to shopping cart");
			logger.debug("Add To Cart Step2 - test faild");
			Thread.sleep(500);

		}

}
