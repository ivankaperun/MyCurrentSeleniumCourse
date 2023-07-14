package day25;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//1) Auto suggesting box:
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("javascript");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[role='option']"));
		System.out.println(options.size());
		for(int i=0; i < options.size(); i++)
		{
			String text = options.get(i).getAttribute("query");
			if(text.equals("javascript array"))
			{
				options.get(i).click();
				break;
			}
			//System.out.println(options.get(i).getAttribute("query"));
		}
		

	}

}
