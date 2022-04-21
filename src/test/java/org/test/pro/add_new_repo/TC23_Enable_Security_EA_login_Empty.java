package org.test.pro.add_new_repo;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC23_Enable_Security_EA_login_Empty extends BaseClass {
	
	@Test(enabled=true)
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		
		//TC23
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		
		p.getSignIn().click();// locator for submit button
		System.out.println("TC23 Check if the proper error message is shown when EA login is left empty");
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name
				
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		p.getModelName().sendKeys("demo1");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		p.getEnableSecurity().click();
		sleep();	
		
		
		WebElement security = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		js.executeScript("arguments[0].scrollIntoView(true)",security );
		p.getRepoSave().click();
		System.out.println("Error message :");
		WebElement loginMsg = driver.findElement(By.xpath("//span[contains(text(),'User Name should not be blank')]"));
		getText(loginMsg);
		
		
		blank();
		System.out.println("**Test Successful**");
		
		
	}
	
	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC23
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		
		p.getSignIn().click();// locator for submit button
		System.out.println("TC23 Check if the proper error message is shown when EA login is left empty");
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name
				
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		p.getModelName().sendKeys("demo1");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		p.getEnableSecurity().click();
		sleep();	
		
		
		WebElement security = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		js.executeScript("arguments[0].scrollIntoView(true)",security );
		p.getRepoSave().click();
		System.out.println("Error message :");
		WebElement loginMsg = driver.findElement(By.xpath("//span[contains(text(),'User Name should not be blank')]"));
		getText(loginMsg);

		
		blank();
		System.out.println("**Test Successful**");
		
	}
	
	@Test(enabled = false)
	public static void edge() throws InterruptedException, IOException {

		edgeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC23
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		
		p.getSignIn().click();// locator for submit button
		System.out.println("TC23 Check if the proper error message is shown when EA login is left empty");
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name
				
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		p.getModelName().sendKeys("demo1");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		p.getEnableSecurity().click();
		sleep();	
		
		
		WebElement security = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		js.executeScript("arguments[0].scrollIntoView(true)",security );
		p.getRepoSave().click();
		System.out.println("Error message :");
		WebElement loginMsg = driver.findElement(By.xpath("//span[contains(text(),'User Name should not be blank')]"));
		getText(loginMsg);

		
		blank();
		System.out.println("**Test Successful**");
		
	}
}
