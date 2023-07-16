package day28;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		List<WebElement> tickets = driver.findElements(By.xpath("//ul[@id='checkout-products']//li"));
		
		for(WebElement ticket:tickets)
		{
			System.out.println(ticket.getText());
		}
		
		for(int i=0; i < tickets.size(); i++)
		{	
			if(tickets.get(i).getText().contains("booking"))
			{
				driver.findElement(By.xpath("//ul[@id='checkout-products']/li["+(i+1)+"]//input")).click();
				String price = driver.findElement(By.xpath("//ul[@id='checkout-products']/li["+(i+1)+"]//span[@class='price']")).getText();
				System.out.println(price);
				break;
			}
		}
		
		//Verification 1
		Thread.sleep(5000);
		String expected_result = "booking";
		String actual_result = driver.findElement(By.xpath("//div[@class='product-details']")).getText();
		System.out.println(actual_result);
		if(actual_result.contains(expected_result))
		{
			System.out.println("Test 1 passed");
		} else
		{
			System.out.println("Test 1 failed");
		}
		
		//Verification 2
		String expected_price = "20.00";
		String actual_price = driver.findElement(By.xpath("//tr[@class='cart-subtotal']//span")).getText();
		if(actual_price.contains(expected_price))
		{
			System.out.println("Test 2 passed");
		} else
		{
			System.out.println("Test 2 failed");
		}
	}

}
