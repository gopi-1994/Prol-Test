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

public class TC20__withoutmodelSecurity extends BaseClass {
	
	@Test(enabled = true)
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();

		//TC 20
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		//System.out.println("Add security Enabled without model security ");
		// locator for submit button
		p.getSignIn().click();
		waits();
		
		System.out.println("TC20 Check if the user can successfully add the modal without security");
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");
		
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		p.getModelName().sendKeys("nosec");// updating the correct model name without security
		
		p.getServerName().sendKeys("localhost");// updating the correct server name
		
		p.getPortNo().sendKeys("804");// updating the correct port
		
		p.getRepoSave().click();
		
		
		WebElement repoAdded = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		getText(repoAdded);
		p.getAutoConfig().click();
		Thread.sleep(5000);
		
		System.out.println("Repository created with EA model without security");
		//WebElement eaLogin = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		//textFill(eaLogin, "Gopi");// updating the correct EA name
		
		
		blank();
		System.out.println("**Test Successful**");
		
		
	}
	
	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC 20
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		//System.out.println("Add security Enabled without model security ");
		// locator for submit button
		WebElement sbmit = driver.findElement(By.xpath("//button[@type='submit']"));
		sbmit.click();
		waits();
		
		System.out.println("TC20 Check if the user can successfully add the modal without security");
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");
		
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		p.getModelName().sendKeys("nosec");// updating the correct model name without security
		
		p.getServerName().sendKeys("localhost");// updating the correct server name
		
		p.getPortNo().sendKeys("804");// updating the correct port
		
		p.getRepoSave().click();
		
		
		WebElement repoAdded = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		getText(repoAdded);
		p.getAutoConfig().click();
		Thread.sleep(5000);
		
		System.out.println("Repository created with EA model without security");
		//WebElement eaLogin = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		//textFill(eaLogin, "Gopi");// updating the correct EA name
		
		blank();
		System.out.println("**Test Successful**");
		
	}
	
	@Test(enabled = false)
	public static void edge() throws InterruptedException, IOException {

		edgeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC 20
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		//System.out.println("Add security Enabled without model security ");
		// locator for submit button
		WebElement sbmit = driver.findElement(By.xpath("//button[@type='submit']"));
		sbmit.click();
		waits();
		
		System.out.println("TC20 Check if the user can successfully add the modal without security");
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");
		
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		p.getModelName().sendKeys("nosec");// updating the correct model name without security
		
		p.getServerName().sendKeys("localhost");// updating the correct server name
		
		p.getPortNo().sendKeys("804");// updating the correct port
		
		p.getRepoSave().click();
		
		
		WebElement repoAdded = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		getText(repoAdded);
		p.getAutoConfig().click();
		Thread.sleep(5000);
		
		System.out.println("Repository created with EA model without security");
		//WebElement eaLogin = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		//textFill(eaLogin, "Gopi");// updating the correct EA name
		
		blank();
		System.out.println("**Test Successful**");
		
	}
}
