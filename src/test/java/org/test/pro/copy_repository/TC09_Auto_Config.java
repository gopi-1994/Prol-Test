package org.test.pro.copy_repository;

import java.awt.AWTException;
import java.io.IOException;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09_Auto_Config extends BaseClass {

	@Test
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		System.out.println("Testing in Chrome Browser");

		// TC09

		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		blank();
		// locator for submit button
		p.getSignIn().click();
		waits();
		System.out.println("login as admin user");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		p.getMore1().click();//clicking more option
		System.out.println("Copying the Repository");
		driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).click();
		waits();		
		p.getRepoSave().click();
		waits();
		blank();
		
		WebElement copySuccess = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		String text = copySuccess.getText();
		System.out.println("Success Msg : "+text);
		System.out.println("TC 09 : Check if the sections, Access Permissions and MDG are configured automatically when we click on Automatic config in repository copied success modal dialog");
		p.getAutoConfig().click();
		waits();
		
		WebElement sectionConfig = driver.findElement(By.xpath("//div[contains(text(),'Configuring Sections ...')]"));
		String sectionText = sectionConfig.getText();
		
		WebElement accessConfig = driver.findElement(By.xpath("//div[contains(text(),'Configuring Access Permissions ...')]"));
		String accessText = accessConfig.getText();
		
		WebElement mdgConfig = driver.findElement(By.xpath("//div[contains(text(),'Configuring Modelling Language ...')]"));
		String mdgText = mdgConfig.getText();
		
		WebElement openRepo = driver.findElement(By.xpath("//span[contains(text(),'Open Repository')]"));
		sleep();
		String openText = openRepo.getText();
		System.out.println(openText);
		
		if (openText.equals("Open Repository")) {
			System.out.println("Sections configured automatically, MSG : "+sectionText);
			System.out.println("Access permisions configured automatically, MSG : "+accessText);
			System.out.println("MDG configured automatically, MSG : "+mdgText);
			System.out.println("Repository successfully configured automatically");
		} else {
			System.out.println("Repository did not configured automatically");
		}
		
		// quit();
		blank();
		System.out.println("**Test Successful**");

	}

	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();
		System.out.println("Testing in Firefox Browser");

		// TC09

		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		blank();
		// locator for submit button
		p.getSignIn().click();
		waits();
		System.out.println("login as admin user");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		p.getMore1().click();//clicking more option
		System.out.println("Copying the Repository");
		driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).click();
		waits();		
		p.getRepoSave().click();
		waits();
		blank();
		
		WebElement copySuccess = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		String text = copySuccess.getText();
		System.out.println("Success Msg : "+text);
		System.out.println("TC 09 : Check if the sections, Access Permissions and MDG are configured automatically when we click on Automatic config in repository copied success modal dialog");
		p.getAutoConfig().click();
		waits();
		
		WebElement sectionConfig = driver.findElement(By.xpath("//div[contains(text(),'Configuring Sections ...')]"));
		String sectionText = sectionConfig.getText();
		
		WebElement accessConfig = driver.findElement(By.xpath("//div[contains(text(),'Configuring Access Permissions ...')]"));
		String accessText = accessConfig.getText();
		
		WebElement mdgConfig = driver.findElement(By.xpath("//div[contains(text(),'Configuring Modelling Language ...')]"));
		String mdgText = mdgConfig.getText();
		
		WebElement openRepo = driver.findElement(By.xpath("//span[contains(text(),'Open Repository')]"));
		sleep();
		String openText = openRepo.getText();
		System.out.println(openText);
		
		if (openText.equals("Open Repository")) {
			System.out.println("Sections configured automatically, MSG : "+sectionText);
			System.out.println("Access permisions configured automatically, MSG : "+accessText);
			System.out.println("MDG configured automatically, MSG : "+mdgText);
			System.out.println("Repository successfully configured automatically");
		} else {
			System.out.println("Repository did not configured automatically");
		}

		quit();
		blank();
		System.out.println("**Test Successful**");

	}

	@Test(enabled = false)
	public static void edge() throws InterruptedException, IOException {

		edgeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();
		System.out.println("Testing in Edge Browser");

		// TC09

		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		blank();
		// locator for submit button
		p.getSignIn().click();
		waits();
		System.out.println("login as admin user");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		p.getMore1().click();//clicking more option
		System.out.println("Copying the Repository");
		driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).click();
		waits();		
		p.getRepoSave().click();
		waits();
		blank();
		
		WebElement copySuccess = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		String text = copySuccess.getText();
		System.out.println("Success Msg : "+text);
		System.out.println("TC 09 : Check if the sections, Access Permissions and MDG are configured automatically when we click on Automatic config in repository copied success modal dialog");
		p.getAutoConfig().click();
		waits();
		
		WebElement sectionConfig = driver.findElement(By.xpath("//div[contains(text(),'Configuring Sections ...')]"));
		String sectionText = sectionConfig.getText();
		
		WebElement accessConfig = driver.findElement(By.xpath("//div[contains(text(),'Configuring Access Permissions ...')]"));
		String accessText = accessConfig.getText();
		
		WebElement mdgConfig = driver.findElement(By.xpath("//div[contains(text(),'Configuring Modelling Language ...')]"));
		String mdgText = mdgConfig.getText();
		
		WebElement openRepo = driver.findElement(By.xpath("//span[contains(text(),'Open Repository')]"));
		sleep();
		String openText = openRepo.getText();
		System.out.println(openText);
		
		if (openText.equals("Open Repository")) {
			System.out.println("Sections configured automatically, MSG : "+sectionText);
			System.out.println("Access permisions configured automatically, MSG : "+accessText);
			System.out.println("MDG configured automatically, MSG : "+mdgText);
			System.out.println("Repository successfully configured automatically");
		} else {
			System.out.println("Repository did not configured automatically");
		}

		quit();
		blank();
		System.out.println("**Test Successful**");
	}
}
