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

public class TC47_ManualConfig_Repo_Model2 extends BaseClass {
	
	@Test(enabled=true)
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		
		//TC 47
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		
		p.getSignIn().click();// locator for submit button
		System.out.println(
				"TC47 Check if the user is navigated to sections page when click on manual configuration in Repository added modal dialog");
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name

		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		p.getModelName().sendKeys("demo2");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		p.getEnableSecurity().click();
		sleep();

		WebElement security = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		js.executeScript("arguments[0].scrollIntoView(true)", security);
		p.getEaLogin().sendKeys("gopi");// updating the correct EA name
		
		p.getRepoSave().click();

		
		WebElement repoAdded = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		getText(repoAdded);
		System.out.println("Configuration done manually");
		p.getManualConfig().click();
		waits();
		WebElement sectionPage = driver.findElement(By.xpath("(//span[contains(text(),'Sections')])[2]"));
		System.out.println("Page Title : " +driver.getTitle());
		getUrl();
		if (driver.getCurrentUrl().contains("http://localhost/repositories/sections/repId/")) {
			System.out.println("Successfully landed in Sections page");
			
		} else {
			System.out.println("Failed to land in Sections page");
		}
		
		
		blank();
		System.out.println("**Test Successful**");
		
		
	}
	
	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC 47
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		
		p.getSignIn().click();// locator for submit button
		System.out.println(
				"TC47 Check if the user is navigated to sections page when click on manual configuration in Repository added modal dialog");
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name

		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		p.getModelName().sendKeys("demo2");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		p.getEnableSecurity().click();
		sleep();

		WebElement security = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		js.executeScript("arguments[0].scrollIntoView(true)", security);
		p.getEaLogin().sendKeys("gopi");// updating the correct EA name
		
		p.getRepoSave().click();

		
		WebElement repoAdded = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		getText(repoAdded);
		System.out.println("Configuration done manually");
		p.getManualConfig().click();
		waits();
		WebElement sectionPage = driver.findElement(By.xpath("(//span[contains(text(),'Sections')])[2]"));
		System.out.println("Page Title : " +driver.getTitle());
		getUrl();
		if (driver.getCurrentUrl().contains("http://localhost/repositories/sections/repId/")) {
			System.out.println("Successfully landed in Sections page");
			
		} else {
			System.out.println("Failed to land in Sections page");
		}
		
		blank();
		System.out.println("**Test Successful**");
		
	}
	
	@Test(enabled = false)
	public static void edge() throws InterruptedException, IOException {

		edgeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC 47
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		
		p.getSignIn().click();// locator for submit button
		System.out.println(
				"TC47 Check if the user is navigated to sections page when click on manual configuration in Repository added modal dialog");
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name

		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		p.getModelName().sendKeys("demo2");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		p.getEnableSecurity().click();
		sleep();

		WebElement security = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		js.executeScript("arguments[0].scrollIntoView(true)", security);
		p.getEaLogin().sendKeys("gopi");// updating the correct EA name
		
		p.getRepoSave().click();

		
		WebElement repoAdded = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		getText(repoAdded);
		System.out.println("Configuration done manually");
		p.getManualConfig().click();
		waits();
		WebElement sectionPage = driver.findElement(By.xpath("(//span[contains(text(),'Sections')])[2]"));
		System.out.println("Page Title : " +driver.getTitle());
		getUrl();
		if (driver.getCurrentUrl().contains("http://localhost/repositories/sections/repId/")) {
			System.out.println("Successfully landed in Sections page");
			
		} else {
			System.out.println("Failed to land in Sections page");
		}
		
		blank();
		System.out.println("**Test Successful**");
		
	}
}
