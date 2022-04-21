package org.test.pro.delete_repository;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_Delete_Option_visible extends BaseClass {

	@Test
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		System.out.println("Testing in Chrome Browser");

		// TC01
		//before executing Make a copy of currrent repo n rename to "aTest1"
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
		System.out.println("TC01 Check if the delete option is visible to the admin user");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		p.getMore1().click();// clicking more option
		WebElement delete = driver.findElement(By.xpath("//span[contains(text(),'Delete')]"));
		String deleteText = delete.getText();
		Assert.assertEquals(deleteText, "Delete");
		System.out.println("Delete option is visible for Admin user");

		p.getProfileIcon().click();
		p.getSignout().click();
		System.out.println("TC02 Check if the delete option is not shown to the non admin users");
		System.out.println("Switching to Non admin user");

		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();
		waits();

		p.getMore1().click();
		try {
			boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).isDisplayed();

		} catch (Exception e) {
			System.out.println("Delete option is not available for non Admin user");
		}
		p.getProfileIcon().click();
		p.getSignout().click();
		blank();
		System.out.println("TC 06 : Check if the delete confirmation message closes when click on cancel");
		System.out.println("Switching to admin user");
		p.getTextEmail().sendKeys("admin@prolaborate.com");
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();

		p.getMore1().click();// clicking more option
		WebElement delete1 = driver.findElement(By.xpath("//span[contains(text(),'Delete')]"));
		delete1.click();
		p.getRepoCancel().click();
		sleep();
		try {
			boolean displayed = driver.findElement(By.xpath("//h4[contains(text(),'Delete Repository')]"))
					.isDisplayed();

		} catch (Exception e) {
			System.out.println("Delete confirmation window closed successfully when click on cancel");
		}

		refresh();
		waits();
		blank();
		System.out.println("TC 03 : Check if the delete confirmation message is shown when click on delete");
		p.getMore1().click();
		waits();
		p.getRepoDelete().click();
		WebElement deleteRepo = driver
				.findElement(By.xpath("//h4[contains(text(),'Delete Repository')]"));
		String text = deleteRepo.getText();
		System.out.println("Msg : " + text);
		sleep();
		blank();
		System.out.println("TC 04 : Check if the user is shown proper message after deleting the repository");
		p.getDeleteAnyway().click();
		Thread.sleep(3000);
		screenshot("Delete msg");
		System.out.println("Reposiroty deleted & screenshot the message");
		blank();
		System.out.println("TC 05 : Check if the deleted repository is removed from the repositories list");
		try {
			driver.findElement(By.xpath("//span[text()='aTest1')]")).click();
					

		} catch (Exception e) {
			System.out.println("Repository deleted successfully from the repository list");
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
		WebElement sbmit = driver.findElement(By.xpath("//button[@type='submit']"));
		sbmit.click();
		waits();

		WebElement admin = driver.findElement(By.xpath("//img[@class='d-inline-block rounded-circle user-icon']"));
		admin.click();
		WebElement superAdmin = driver.findElement(By.xpath("//div[contains(text(),'Super Admin')]"));
		String adminText = superAdmin.getText();

		if (adminText.equalsIgnoreCase("Super Admin")) {
			System.out.println("User is Admin");

		} else {
			System.out.println("User is not an Admin");
		}
		System.out.println("clicking more option in the 1st repository");
		WebElement more = driver.findElement(By.xpath("(//span[contains(text(),'More')])[1]"));
		more.click();
		WebElement defult = driver.findElement(By.xpath("//span[contains(text(),'Make Default')]"));
		String attribute = defult.getText();
		if (attribute.equals("Make Default")) {
			System.out.println("Make Default is visible to admin user");
		} else {
			System.out.println("Make Default is not visible to admin user");
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
		WebElement sbmit = driver.findElement(By.xpath("//button[@type='submit']"));
		sbmit.click();
		waits();

		WebElement admin = driver.findElement(By.xpath("//img[@class='d-inline-block rounded-circle user-icon']"));
		admin.click();
		WebElement superAdmin = driver.findElement(By.xpath("//div[contains(text(),'Super Admin')]"));
		String adminText = superAdmin.getText();

		if (adminText.equalsIgnoreCase("Super Admin")) {
			System.out.println("User is Admin");

		} else {
			System.out.println("User is not an Admin");
		}

		System.out.println("clicking more option in the 1st repository");
		WebElement more = driver.findElement(By.xpath("(//span[contains(text(),'More')])[1]"));
		more.click();
		WebElement defult = driver.findElement(By.xpath("//span[contains(text(),'Make Default')]"));
		String attribute = defult.getText();
		if (attribute.contains("Make Default")) {
			System.out.println("Make Default is visible to admin user");
		} else {
			System.out.println("Make Default is not visible to admin user");
		}

		quit();
		blank();
		System.out.println("**Test Successful**");
	}
}
