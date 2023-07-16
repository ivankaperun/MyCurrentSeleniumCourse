package day28;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		//////////////////////////////////////////////////////////////////////////////////////////
		//select FROM city and click on one option:
		WebElement dropdownFromCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select fromCities = new Select(dropdownFromCity);
		List<WebElement> fromCityOptions = fromCities.getOptions();
		
		for(WebElement fromCity:fromCityOptions)
		{
			if(fromCity.getText().equals("Boston"))
			{
				fromCity.click();
				break;
			}
		}
		
		//select TO city and click on one option:
		WebElement dropdownToCity = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select toCities = new Select(dropdownToCity);
		List<WebElement> toCityOptions = toCities.getOptions();
		
		for(WebElement toCity:toCityOptions)
		{
			if(toCity.getText().equals("New York"))
			{
				toCity.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		//Verify result
		String expected_result1 = "Flights from Boston to New York";
		String actual_result1 = driver.findElement(By.xpath("//h3")).getText();
		
		if(actual_result1.contains(expected_result1))
		 {
			 System.out.println("Page 2: Test passed");
		 }
		 else
		 {
			 System.out.println("Page 2: Test failed");
		 }
		
		///////////////////////////////////////////////////////////////////////////////////////
		//Select flight with lowest cost:
		//table size:
		int rows = driver.findElements(By.xpath("//table//tbody//tr")).size();
		int cols = driver.findElements(By.xpath("//table//thead//th")).size();
		
		Double pricesArray[] = new Double[rows];
		
		for(int r=1; r <= rows; r++)
		{
			String price = driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td["+cols+"]")).getText();
			pricesArray[r-1]=Double.parseDouble(price.replace("$", ""));
		}
		 
		 Arrays.sort(pricesArray); // sort array to get lowest value first
		 String lowestCost = "$" + pricesArray[0];
		 
		 for (int r=1; r <= rows; r++)
		 {
			 WebElement price = driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td["+cols+"]"));
			 if(price.getText().equals(lowestCost))
			 {
				 driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td[1]/input[@value='Choose This Flight']")).click();
				 break;
			 }
		 }
		 
		 //Verify the result
		 String expected_result2 = "Your flight from TLV to SFO has been reserved.";
		 String actual_result2 = driver.findElement(By.xpath("//h2")).getText();
		 
		 if(actual_result2.equals(expected_result2))
		 {
			 System.out.println("Page 3: Test passed");
		 }
		 else
		 {
			 System.out.println("Page 3: Test failed");
		 }
		 
		 //////////////////////////////////////////////////////////////////////////////////////
		 //Fill all the data to the flight:
		 driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("John Wick");
		 driver.findElement(By.xpath("//input[@id='address']")).sendKeys("1235 Norman Street");
		 driver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York");
		 driver.findElement(By.xpath("//input[@id='state']")).sendKeys("NY");
		 driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("10001");
		 
		 WebElement dropdownCardType = driver.findElement(By.xpath("//select[@id='cardType']"));
		 Select cardTypes = new Select(dropdownCardType);
		 List<WebElement> cardOptions = cardTypes.getOptions();
		 for(WebElement option:cardOptions)
		 {
			 if(option.getText().equals("American Express"))
			 {
				 option.click();
				 break;
			 }
		 }
		 
		 driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("5149612222222229");
		 
		 WebElement creditCardMonth = driver.findElement(By.xpath("//input[@id='creditCardMonth']"));
		 creditCardMonth.clear();
		 creditCardMonth.sendKeys("01");
		 
		 WebElement creditCardYear = driver.findElement(By.xpath("//input[@id='creditCardYear']"));
		 creditCardYear.clear();
		 creditCardYear.sendKeys("2039");
		 
		 driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("John Wick");
		 driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		 
		 //Click on Purchase Flight button
		 driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		 
		 
		 /////////////////////////////////////////////////////////////////////////////
		 //Verify that the flight was booked: 
		 String expected_result3 = "Thank you for your purchase today!";
		 String actual_result3 = driver.findElement(By.xpath("//h1")).getText();
		 
		 if(actual_result3.equals(expected_result3))
		 {
			 System.out.println("Page 4: Test passed");
		 }
		 else
		 {
			 System.out.println("Page 4: Test failed");
		 }
		 	 
		 driver.close();
	}

}
