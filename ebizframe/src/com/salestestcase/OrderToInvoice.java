package com.salestestcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class OrderToInvoice 
{
    public static void main(String[] args) throws InterruptedException 
    {
    	System.setProperty("webdriver.gecko.driver", "D:\\\\Selenium\\\\drivers\\\\new\\\\geckodriver.exe");
    	//System.setProperty("webdriver.gecko.driver", "D:\\Testingwhiz\\Others\\Software\\geckodriver\\geckodriver.exe");
    	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");//deletes the unnecessary Browser log files
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		WebDriverWait myWaitVar=new WebDriverWait(driver,20);
		//driver.manage().window().maximize();
        String baseUrl = "http://192.168.1.241:7003/ebiz/faces/login.jspx";
        String expectedTitle = "Login Page";
        String expectedTitle1 = "Start Page";
        String expectedTitle2= "ebizframe 10";
        
        //String actualTitle = "";
        driver.get(baseUrl);
        Thread.sleep(6000);
        System.out.println(driver.getTitle());
        //actualTitle = driver.getTitle();
        if (driver.getTitle().equals(expectedTitle))
        {
            System.out.println("Welcome to Login Page");
        } 
        else
        {
            System.out.println("Failed");
        }
      
      // Handling login Criticality
        Thread.sleep(5000);
            System.out.println("Welcome to Login Page");
            
            driver.findElement(By.xpath("//input[@placeholder=' User Name']")).sendKeys("ANUDIP");
            Thread.sleep(3000);
            myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
            Thread.sleep(5000);
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
            Thread.sleep(3000);
            myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=' Login']")));
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[text()=' Login']")).click();
            Thread.sleep(7000);
         
        if(driver.getTitle().equals(expectedTitle2))
        {
        	Thread.sleep(5000);
            System.out.println("Welcome to ebizframe and need to click here");
            driver.findElement(By.xpath("//span[text()='CLICK HERE']")).click(); 
            Thread.sleep(5000);
            myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=' User Name']")));
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder=' User Name']")).sendKeys("ANUDIP");
            Thread.sleep(3000);
            myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
            Thread.sleep(3000);
            myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=' Login']")));
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[text()=' Login']")).click();
        }
        Thread.sleep(3000);
        System.out.println("Login Successfully");
        Thread.sleep(3000);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Organisation']/../following-sibling::td//select")));
        Select drpOrg=new Select(driver.findElement(By.xpath("//label[text()='Organisation']/../following-sibling::td//select")));
        Thread.sleep(3000);
        System.out.println("Select Org");
        drpOrg.selectByVisibleText("Supreme Plastic US LTD.");
        Thread.sleep(3000);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Sub Division']/../following-sibling::td//select")));
        Select drpPrj=new Select(driver.findElement(By.xpath("//label[text()='Sub Division']/../following-sibling::td//select")));
        Thread.sleep(3000);
        drpPrj.selectByVisibleText("DEFAULT PROJECT");
        System.out.println("Select Project");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@title='Financials']")).click();
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Sales']")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@alt='Sales']")).click();
        Thread.sleep(5000);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Go to']/../following-sibling::td//input")));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//label[text()='Go to']/../following-sibling::td//input")).clear();
        driver.findElement(By.xpath("//label[text()='Go to']/../following-sibling::td//input")).sendKeys("21503");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Registered To :']")).click();
        Thread.sleep(5000);
        if(driver.findElement(By.xpath("//img[@title='New Sales Order (Alt+Shift+N)']")).isDisplayed())
        {
        	driver.findElement(By.xpath("//img[@title='New Sales Order (Alt+Shift+N)']")).click();
            Thread.sleep(5000);
        }	
        else
        {
        	 Thread.sleep(5000);
             driver.findElement(By.xpath("//label[text()='Go to']/../following-sibling::td//input")).clear();
             driver.findElement(By.xpath("//label[text()='Go to']/../following-sibling::td//input")).sendKeys("21503");
             Thread.sleep(5000);
        	driver.findElement(By.xpath("//label[text()='Registered To :']")).click();
        	Thread.sleep(5000);
        	driver.findElement(By.xpath("//img[@title='New Sales Order (Alt+Shift+N)']")).click();
            Thread.sleep(5000);
        	
        }
        //myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='New Sales Order (Alt+Shift+N)']")));
        //Thread.sleep(3000);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Sales Order']")));
        System.out.println("Sales Order Page Opened");
        Select OrdType=new Select(driver.findElement(By.xpath("//label[text()='Order Type']/../following-sibling::td/select")));
        OrdType.selectByVisibleText("DIRECT ORDER");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//label[text()='Customer'])[1]/../following-sibling::td//input")).sendKeys("SUPREME  INDUSTRIES LIMITED");
        Thread.sleep(3000);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'AFAutoSuggest')]")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[contains(@class,'AFAutoSuggest')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Item')]")).click();
        Thread.sleep(3000);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Add Item (Alt+Shift+I)']")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@title='Add Item (Alt+Shift+I)']")).click();
        Thread.sleep(3000);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Item Name']/../following-sibling::td//input)[1]")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//label[text()='Item Name']/../following-sibling::td//input)[1]")).sendKeys("Designer Plastic cup");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[contains(@class,'AFAutoSuggest')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Order Quantity']/../following-sibling::td//input")).clear();
        driver.findElement(By.xpath("//label[text()='Order Quantity']/../following-sibling::td//input")).sendKeys("10");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//img[@title='Save and Forward (Alt+Shift+G)']")).click();
        Thread.sleep(7000);
        if(driver.findElement(By.xpath("//span[text()='Yes']")).isDisplayed())
        {
        	driver.findElement(By.xpath("//span[text()='Yes']")).click();
        }
        Thread.sleep(3000);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='OK'])[2]")));
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//button[text()='OK'])[2]")).click();
        Thread.sleep(5000);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Approved')]")));
        String OrdId=driver.findElement(By.xpath("//label[text()='Order Number : ']/../following-sibling::td//span")).getText();
        Thread.sleep(2000);
        System.out.println("Order Id is:" +OrdId);
        driver.close();
        
    }
}