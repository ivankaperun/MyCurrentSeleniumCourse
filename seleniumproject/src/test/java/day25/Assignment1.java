package day25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		driver.switchTo().alert().accept();
		
		String act_result = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String exp_result = "You successfully clicked an alert";
		
		if(exp_result.equals(act_result))
		{
			System.out.println("Test passed");
		} else
		{
			System.out.println("Test failed");
		}

	}

}
