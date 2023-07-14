package day26;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Asssignment1Windows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("java");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		List<WebElement> links = driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div/a"));
		
		System.out.println("Number of available links: " + links.size());
		for(WebElement link: links)
		{
			System.out.println(link.getText());
			link.click();
		}
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		System.out.println("Switching to each browser window and getting the titles........"); 
		for(String winid: windowIDs)
		{
			String title=driver.switchTo().window(winid).getTitle();
			System.out.println(title);
		}
		driver.quit();
		
	}

}
