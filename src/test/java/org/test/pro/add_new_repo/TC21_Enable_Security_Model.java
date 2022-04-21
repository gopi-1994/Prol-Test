package org.test.pro.add_new_repo;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC21_Enable_Security_Model extends BaseClass {
	
	@Test(enabled= true)
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		
		// TC 21
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		System.out.println("TC21 Check if the user can add security enabled modal successfully");
		// locator for submit button
		WebElement sbmit = driver.findElement(By.xpath("//button[@type='submit']"));
		sbmit.click();
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name
				
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sequrity = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)",sequrity );
		p.getModelName().sendKeys("demo1");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		
		WebElement securityEnbl = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnbl.click();
		p.getEaLogin().sendKeys("gopi");// updating the correct EA name
		p.getRepoSave().click();

		
		WebElement repoAdded = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		getText(repoAdded);
		System.out.println("Configuration Done Automatically");
		p.getAutoConfig().click();
		waits();
		System.out.println("Repository Opened Successfully");
		WebElement openRepo = driver.findElement(By.xpath("//span[contains(text(),'Open Repository')]"));
		openRepo.click();
		WebElement repoName = driver.findElement(By.xpath("//span[contains(text(),'Test Demo')]"));
		String repoText = repoName.getText();
		Assert.assertEquals(repoText, "Test Demo");
		
		blank();
		System.out.println("**Test Successful**");
		
		
	}
	
	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		// TC 21
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		System.out.println("TC21 Check if the user can add security enabled modal successfully");
		// locator for submit button
		WebElement sbmit = driver.findElement(By.xpath("//button[@type='submit']"));
		sbmit.click();
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name
				
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sequrity = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)",sequrity );
		p.getModelName().sendKeys("demo1");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		
		WebElement securityEnbl = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnbl.click();
		p.getEaLogin().sendKeys("gopi");// updating the correct EA name
		p.getRepoSave().click();

		
		WebElement repoAdded = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		getText(repoAdded);
		System.out.println("Configuration Done Automatically");
		p.getAutoConfig().click();
		waits();
		System.out.println("Repository Opened Successfully");
		WebElement openRepo = driver.findElement(By.xpath("//span[contains(text(),'Open Repository')]"));
		openRepo.click();
		WebElement repoName = driver.findElement(By.xpath("//span[contains(text(),'Test Demo')]"));
		String repoText = repoName.getText();
		Assert.assertEquals(repoText, "Test Demo");
		
		blank();
		System.out.println("**Test Successful**");
		
	}
	
	@Test(enabled = false)
	public static void edge() throws InterruptedException, IOException {

		edgeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		// TC 21
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		System.out.println("TC21 Check if the user can add security enabled modal successfully");
		// locator for submit button
		WebElement sbmit = driver.findElement(By.xpath("//button[@type='submit']"));
		sbmit.click();
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name
				
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sequrity = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)",sequrity );
		p.getModelName().sendKeys("demo1");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		
		WebElement securityEnbl = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnbl.click();
		p.getEaLogin().sendKeys("gopi");// updating the correct EA name
		p.getRepoSave().click();

		
		WebElement repoAdded = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		getText(repoAdded);
		System.out.println("Configuration Done Automatically");
		p.getAutoConfig().click();
		waits();
		System.out.println("Repository Opened Successfully");
		WebElement openRepo = driver.findElement(By.xpath("//span[contains(text(),'Open Repository')]"));
		openRepo.click();
		WebElement repoName = driver.findElement(By.xpath("//span[contains(text(),'Test Demo')]"));
		String repoText = repoName.getText();
		Assert.assertEquals(repoText, "Test Demo");
		
		blank();
		System.out.println("**Test Successful**");
		
	}
}
