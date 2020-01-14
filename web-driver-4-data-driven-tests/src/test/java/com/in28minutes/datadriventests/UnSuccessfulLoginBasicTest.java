package com.seliniumtest.datadriventests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnSuccessfulLoginBasicTest {

	@Test
	public void testUnsuccessfulLoginWithseliniumtest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/login");
		driver.findElement(By.id("name")).sendKeys("seliniumtest");
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
