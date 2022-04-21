package org.test.pro.update_repository;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.apache.hc.core5.util.Asserts;
import org.apache.http.impl.io.SocketInputBuffer;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_Section_Retained extends BaseClass {

	@Test
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		System.out.println("Testing in Chrome Browser");

		// TC07 for this test case have to change the Alias name in PCS and execute this
		// program

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
		System.out.println("TC07 Check if the sections are retained when user  update the EA modal name");
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'Test1')]"));
		repo.click();
		sleep();
		p.getRepoMenu().click();
		WebElement sections = driver.findElement(By.xpath("//div[contains(text(),'Sections')]"));
		sections.click();
		WebElement secModels = driver.findElement(By.xpath("(//span[contains(text(),'Example Model')])[2]"));
		String text1 = secModels.getText();
		System.out.println("Section model : " + text1);

		p.getProlabHeaderIcon().click();

		p.getRepoEdit().click();

		p.getReponame().clear();
		p.getReponame().sendKeys("Test1");
		p.getRepoSave().click();
		sleep();
		screenshot("Repo name changed again ");
		System.out.println("Repo name changed Successfully");
		p.getRepoEdit().click();
		WebElement editModel = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		System.out.println("Updating the PCS model name");
		editModel.clear();
		editModel.sendKeys("demo11");
		p.getRepoSave().click();
		System.out.println("PCS model name updated successfully");
		waits();
		blank();
		System.out.println("Checking the Section page is retained or not");
		WebElement test1Repo = driver.findElement(By.xpath("//span[contains(text(),'Test1')]"));
		test1Repo.click();
		sleep();
		p.getRepoMenu().click();
		WebElement sections1 = driver.findElement(By.xpath("//div[contains(text(),'Sections')]"));
		sections1.click();
		sleep();
		String text2 = p.getSectionsExMod().getText();

		System.out.println("Sectoin Name after Changing PCS details : " + text2);
		System.out.println("Sections details are retained after changing the PCS details");

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

		// TC07 for this test case have to change the Alias name in PCS and execute this
		// program

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
		System.out.println("TC07 Check if the sections are retained when user  update the EA modal name");
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'Test1')]"));
		repo.click();
		sleep();
		p.getRepoMenu().click();
		WebElement sections = driver.findElement(By.xpath("//div[contains(text(),'Sections')]"));
		sections.click();
		WebElement secModels = driver.findElement(By.xpath("(//span[contains(text(),'Example Model')])[2]"));
		String text1 = secModels.getText();
		System.out.println("Section model : " + text1);

		p.getProlabHeaderIcon().click();

		p.getRepoEdit().click();

		p.getReponame().clear();
		p.getReponame().sendKeys("Test1");
		p.getRepoSave().click();
		sleep();
		screenshot("Repo name changed again ");
		System.out.println("Repo name changed Successfully");
		p.getRepoEdit().click();
		WebElement editModel = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		System.out.println("Updating the PCS model name");
		editModel.clear();
		editModel.sendKeys("demo11");
		p.getRepoSave().click();
		System.out.println("PCS model name updated successfully");
		waits();
		blank();
		System.out.println("Checking the Section page is retained or not");
		WebElement test1Repo = driver.findElement(By.xpath("//span[contains(text(),'Test1')]"));
		test1Repo.click();
		sleep();
		p.getRepoMenu().click();
		WebElement sections1 = driver.findElement(By.xpath("//div[contains(text(),'Sections')]"));
		sections1.click();
		sleep();
		String text2 = p.getSectionsExMod().getText();

		System.out.println("Sectoin Name after Changing PCS details : " + text2);
		System.out.println("Sections details are retained after changing the PCS details");

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

		// TC07 for this test case have to change the Alias name in PCS and execute this
		// program

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
		System.out.println("TC07 Check if the sections are retained when user  update the EA modal name");
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'Test1')]"));
		repo.click();
		sleep();
		p.getRepoMenu().click();
		WebElement sections = driver.findElement(By.xpath("//div[contains(text(),'Sections')]"));
		sections.click();
		WebElement secModels = driver.findElement(By.xpath("(//span[contains(text(),'Example Model')])[2]"));
		String text1 = secModels.getText();
		System.out.println("Section model : " + text1);

		p.getProlabHeaderIcon().click();

		p.getRepoEdit().click();

		p.getReponame().clear();
		p.getReponame().sendKeys("Test1");
		p.getRepoSave().click();
		sleep();
		screenshot("Repo name changed again ");
		System.out.println("Repo name changed Successfully");
		p.getRepoEdit().click();
		WebElement editModel = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		System.out.println("Updating the PCS model name");
		editModel.clear();
		editModel.sendKeys("demo11");
		p.getRepoSave().click();
		System.out.println("PCS model name updated successfully");
		waits();
		blank();
		System.out.println("Checking the Section page is retained or not");
		WebElement test1Repo = driver.findElement(By.xpath("//span[contains(text(),'Test1')]"));
		test1Repo.click();
		sleep();
		p.getRepoMenu().click();
		WebElement sections1 = driver.findElement(By.xpath("//div[contains(text(),'Sections')]"));
		sections1.click();
		sleep();
		String text2 = p.getSectionsExMod().getText();

		System.out.println("Sectoin Name after Changing PCS details : " + text2);
		System.out.println("Sections details are retained after changing the PCS details");

		quit();
		blank();
		System.out.println("**Test Successful**");
	}
}
