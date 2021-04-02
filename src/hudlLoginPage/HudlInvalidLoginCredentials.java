package hudlLoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HudlInvalidLoginCredentials {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.hudl.com/";
		String expectedTitle = "Hudl: We Help Teams and Athletes Win";
		String actualTitle = "";

		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		actualTitle = driver.getTitle();
		System.out.println(actualTitle);

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Login page succesfully loaded");
		} else {
			System.out.println("Page not loaded");
		}

		driver.findElement(By.partialLinkText("Log")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("ambreen.shameem@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123InvalidPassword");
		driver.findElement(By.id("logIn")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String text = driver.findElement(By.xpath("//div[@class='login-error-container']/p")).getText();

		System.out.println(text);

		driver.close();

	}

}
