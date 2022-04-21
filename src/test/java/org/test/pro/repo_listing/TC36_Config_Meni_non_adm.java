package org.test.pro.repo_listing;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC36_Config_Meni_non_adm extends BaseClass{
	
	@Test(enabled=true)
	public static void chrome() throws InterruptedException, IOException {
		
		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();
		
		//TC36
		PojoClass p = new PojoClass();// Locator for email / user name
		p.getTextEmail().sendKeys("test@email.com");// pass the value
		
		p.getTextPass().sendKeys("Abcd@1234");// locator for password// pass the value
		p.getSignIn().click();// locator for submit button
		
		
		System.out.println("TC36 Check if the Repository configuration menu shows respective links for  non admin users");
		waits();
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'Test2')]"));
		repo.click();
		sleep();
		WebElement menu = driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-bars fa-w-14']"));
		menu.click();
		waits();
		WebElement review = driver.findElement(By.xpath("//div[contains(text(),' Reviews ')]"));
		review.click();
		sleep();
		String reviewUrl = driver.getCurrentUrl();
		if (reviewUrl.contains("repositories/Reviews")) {
			System.out.println("successfully landed in Reviews page");
		} else {
			System.out.println("failed to land in Reviews page");
		}
		screenshot("Reviews");
		waits();
		
		blank();
		System.out.println("**Test Successful**");
		
		
		quit();
	}
	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC36
		PojoClass p = new PojoClass();// Locator for email / user name
		p.getTextEmail().sendKeys("test@email.com");// pass the value
		
		p.getTextPass().sendKeys("Abcd@1234");// locator for password// pass the value
		p.getSignIn().click();// locator for submit button
		
		
		System.out.println("TC36 Check if the Repository configuration menu shows respective links for  non admin users");
		waits();
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'Test2')]"));
		repo.click();
		sleep();
		WebElement menu = driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-bars fa-w-14']"));
		menu.click();
		waits();
		WebElement review = driver.findElement(By.xpath("//div[contains(text(),' Reviews ')]"));
		review.click();
		sleep();
		String reviewUrl = driver.getCurrentUrl();
		if (reviewUrl.contains("repositories/Reviews")) {
			System.out.println("successfully landed in Reviews page");
		} else {
			System.out.println("failed to land in Reviews page");
		}
		screenshot("Reviews");
		waits();
		
		blank();
		System.out.println("**Test Successful**");
		
	}
	
	@Test(enabled = false)
	public static void edge() throws InterruptedException, IOException {

		edgeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC36
		PojoClass p = new PojoClass();// Locator for email / user name
		p.getTextEmail().sendKeys("test@email.com");// pass the value
		
		p.getTextPass().sendKeys("Abcd@1234");// locator for password// pass the value
		p.getSignIn().click();// locator for submit button
		
		
		System.out.println("TC36 Check if the Repository configuration menu shows respective links for  non admin users");
		waits();
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'Test2')]"));
		repo.click();
		sleep();
		WebElement menu = driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-bars fa-w-14']"));
		menu.click();
		waits();
		WebElement review = driver.findElement(By.xpath("//div[contains(text(),' Reviews ')]"));
		review.click();
		sleep();
		String reviewUrl = driver.getCurrentUrl();
		if (reviewUrl.contains("repositories/Reviews")) {
			System.out.println("successfully landed in Reviews page");
		} else {
			System.out.println("failed to land in Reviews page");
		}
		screenshot("Reviews");
		waits();
		
		blank();
		System.out.println("**Test Successful**");
		
	}



}

