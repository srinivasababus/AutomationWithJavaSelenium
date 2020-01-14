package com.seliniumtest.datadriventests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnSuccessfulLoginDataDrivenBasicTest {
		
	//Create the Data Provider and give the data provider a name
	@DataProvider(name="user-ids-data-provider")
	public String[] userIdsDataProvider() {
		return new String[]{"seliniumtest","adam","eve"};
	}	
	
	//Use the data provider
	@Test(dataProvider="user-ids-data-provider")
	public void testUnsuccessfulLoginWithseliniumtest(String userId) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/login");
		driver.findElement(By.id("name")).sendKeys(userId);
		//driver.findElement(By.id("name")).sendKeys("seliniumtest");
		WebElement passwordElement = driver.findElement(By.id("password"));
		passwordElement.sendKeys("");
		passwordElement.submit();
		// driver.findElement(By.id("submit")).click();

		// welcome-message
		String errorMessageText = driver.findElement(By.id("error-message")).getText();
		System.out.println(errorMessageText);
		assertEquals(errorMessageText,"Invalid Credentials");
		driver.quit();
	}
}
