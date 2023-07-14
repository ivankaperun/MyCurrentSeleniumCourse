package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

// Handle dropdown without using Select Class 

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		//1) select Country
		
		//click on dropdown:
		driver.findElement(By.xpath("//select[@id='country-list']")).click();
		
		//save all options into variable:
		List<WebElement> countries = driver.findElements(By.xpath("//select[@id='country-list']//option"));
		
		//select some Country from the list:
		for(WebElement country: countries)
		{
			String myOption = country.getText();
			if(myOption.equals("USA"))
			{
				country.click();
			}
		}
		
		//2) Select State
		
		//click on dropdown:
		driver.findElement(By.xpath("//select[@id='state-list']")).click();
		
		Thread.sleep(5000);
		
		//save all options into variable:
		List<WebElement> states = driver.findElements(By.xpath("//select[@id='state-list']//option"));
		//List<WebElement> states = mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='state-list']//option")));
		
		//select some State from the list:
		
		for (int i=0; i<states.size(); i++)
		{
			if(states.get(i).getText().equals("New York"))
			{
				states.get(i).click();
				break;
			}
		}

	}

}
