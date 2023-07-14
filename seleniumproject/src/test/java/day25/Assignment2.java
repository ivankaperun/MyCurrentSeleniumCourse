package day25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		
		driver.switchTo().alert().accept();
		
		String act_result = driver.findElement(By.xpath("//div[@class='create-new-account']")).getText();
		String exp_result = "Don't have a Rediffmail ID?";
		 System.out.println(act_result);
		if(act_result.contains(exp_result))
		{
			System.out.println("Test passed");
		} else
		{
			System.out.println("Test failed");
		}

	}

}
