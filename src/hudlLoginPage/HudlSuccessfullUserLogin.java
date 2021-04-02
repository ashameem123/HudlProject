package hudlLoginPage;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HudlSuccessfullUserLogin {

	 public static void main(String[] args) {
		 
		 System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver_win32\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();
			String baseUrl = "https://www.hudl.com/";
	        String expectedTitle = "Hudl: We Help Teams and Athletes Win";
	        String actualTitle = "";
	        

	        driver.get(baseUrl);
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        actualTitle = driver.getTitle();
	        System.out.println(actualTitle);
	        
	        if(actualTitle.contentEquals(expectedTitle)) {
	        	System.out.println("Login page succesfully loaded");
	        }
	        	else {
	        		System.out.println("Page not loaded");
	        }
	       
              driver.findElement(By.partialLinkText("Log")).click();
              driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
              
              driver.findElement(By.id("email")).sendKeys("ambreen.shameem@gmail.com");
              driver.findElement(By.name("password")).sendKeys("Hudl@2021");
              driver.findElement(By.id("logIn")).click();
              driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
              String loginPageExpTitle = "Log In - Hudl";
              String loginPageActualTitle = driver.getTitle();
              System.out.println(loginPageActualTitle);
              driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
              
               if(loginPageActualTitle.contentEquals(loginPageExpTitle)) {
  	        	System.out.println("Successfully logged in");
  	        }
  	        	else {
  	        		System.out.println("Login not successful");
  	        }
           
              driver.close();
	    	
	 }
	 
	 
}
