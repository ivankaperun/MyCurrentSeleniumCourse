package day26;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2iFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		
		// Frame:
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(frame);
		WebElement form = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
		form.clear();
		form.sendKeys("Welcome to automation!");
		
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		
		driver.quit();
		

	}

}
