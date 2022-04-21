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

public class TC28_Enable_Security_EA_pswd_incorrect extends BaseClass {

	@Test(enabled = true)
	public static void chrome() throws InterruptedException, IOException, AWTException {
		// enable password for the EA user then runn the script
		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();

		// TC28
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
				"TC28 Check if the proper error message is shown when try to add repository with incorrect password");
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name

		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		p.getModelName().sendKeys("Testdb");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		p.getEnableSecurity().click();
		sleep();

		WebElement security = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		js.executeScript("arguments[0].scrollIntoView(true)", security);
		p.getEaLogin().sendKeys("gopi");// updating the correct EA name
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("1234");// updating the
																								// incorrect EA password
		p.getRepoSave().click();

		blank();
		waits();
		msg("Error Message :");

		WebElement error = driver.findElement(By.xpath(
				"//ngb-alert[contains(text(),'Invalid Login and/or Password! Please enter valid credentials')]"));
		getText(error);

		blank();
		System.out.println(
				"TC27 Check if the proper error message is shown when try to add repository with incorrect EA user name");
		p.getModelName().clear();
		p.getEaLogin().clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).clear();
		p.getModelName().sendKeys("demo2");// updating the correct model name
		p.getEaLogin().sendKeys("gop");// updating the correct EA name
		msg("Error Message :");

		WebElement error1 = driver.findElement(By.xpath(
				"//ngb-alert[contains(text(),'Invalid Login and/or Password! Please enter valid credentials')]"));
		getText(error1);

		blank();
		System.out.println("**Test Successful**");

	}

	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		// TC28
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
				"TC28 Check if the proper error message is shown when try to add repository with incorrect password");
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name

		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		p.getModelName().sendKeys("Testdb");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		p.getEnableSecurity().click();
		sleep();

		WebElement security = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		js.executeScript("arguments[0].scrollIntoView(true)", security);
		p.getEaLogin().sendKeys("gopi");// updating the correct EA name
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("1234");// updating the
																								// incorrect EA password
		p.getRepoSave().click();

		blank();
		waits();
		msg("Error Message :");

		WebElement error = driver.findElement(By.xpath(
				"//ngb-alert[contains(text(),'Invalid Login and/or Password! Please enter valid credentials')]"));
		getText(error);

		blank();
		System.out.println(
				"TC27 Check if the proper error message is shown when try to add repository with incorrect EA user name");
		p.getModelName().clear();
		p.getEaLogin().clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).clear();
		p.getModelName().sendKeys("demo2");// updating the correct model name
		p.getEaLogin().sendKeys("gop");// updating the correct EA name
		msg("Error Message :");

		WebElement error1 = driver.findElement(By.xpath(
				"//ngb-alert[contains(text(),'Invalid Login and/or Password! Please enter valid credentials')]"));
		getText(error1);

		blank();
		System.out.println("**Test Successful**");

	}

	@Test(enabled = false)
	public static void edge() throws InterruptedException, IOException {

		edgeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		// TC28
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
				"TC28 Check if the proper error message is shown when try to add repository with incorrect password");
		waits();
		p.getAddRepoBtn().click();
		p.getReponame().sendKeys("Test Demo");// updating the Repository name

		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		p.getModelName().sendKeys("Testdb");// updating the correct model name
		p.getServerName().sendKeys("localhost");// updating the correct server name
		p.getPortNo().sendKeys("804");// updating the correct port
		p.getEnableSecurity().click();
		sleep();

		WebElement security = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		js.executeScript("arguments[0].scrollIntoView(true)", security);
		p.getEaLogin().sendKeys("gopi");// updating the correct EA name
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("1234");// updating the
																								// incorrect EA password
		p.getRepoSave().click();

		blank();
		waits();
		msg("Error Message :");

		WebElement error = driver.findElement(By.xpath(
				"//ngb-alert[contains(text(),'Invalid Login and/or Password! Please enter valid credentials')]"));
		getText(error);

		blank();
		System.out.println(
				"TC27 Check if the proper error message is shown when try to add repository with incorrect EA user name");
		p.getModelName().clear();
		p.getEaLogin().clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).clear();
		p.getModelName().sendKeys("demo2");// updating the correct model name
		p.getEaLogin().sendKeys("gop");// updating the correct EA name
		msg("Error Message :");

		WebElement error1 = driver.findElement(By.xpath(
				"//ngb-alert[contains(text(),'Invalid Login and/or Password! Please enter valid credentials')]"));
		getText(error1);

		blank();
		System.out.println("**Test Successful**");

	}
}
