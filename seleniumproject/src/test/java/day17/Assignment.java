package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1) Launch browser
2) open url
	URL: https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
3) Provide username  - admin@yourstore.com
4) Provide password  - admin
5) Click on Login button 
6) Verify the title of dashboard page   
	Exp title : Dashboard / nopCommerce administration
7) Verify Dashboard
 */

public class Assignment {
	public static void main(String[] args) throws InterruptedException {
		
		//1) Launch browser
		WebDriver driver = new ChromeDriver();
		
		//2) open url
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//3) Provide username  - admin@yourstore.com
		WebElement email = driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys("admin@yourstore.com");
		
		//4) Provide password  - admin
		WebElement password = driver.findElement(By.id("Password"));
		password.clear();
		password.sendKeys("admin");
		
		//5) Click on Login button
		driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
		Thread.sleep(5000);
		
		//6) Verify the title of dashboard page
		String act_title = driver.getTitle();
		String exp_title = "Dashboard / nopCommerce administration";
		
		if (act_title.equals(exp_title))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		//7) Verify Dashboard
		String act_label = "";
		try
		{
		act_label = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
		}
		catch(NoSuchElementException e)
		{
		}
		
		String exp_label = "Dashboard";
		if (act_label.equals(exp_label))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		//close browser
		driver.quit();
		
	}

}
