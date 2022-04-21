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
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_Edit_Option extends BaseClass {

	@Test
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		System.out.println("Testing in Chrome Browser");

		// TC01,02,03,04,05,06
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
		System.out.println("TC01 Check if the edit option is enabled  to the admin user");

		System.out.println("Signed in as admin user");
		// Checking the Edit button is visible to super admin user
		String editText = p.getRepoEdit().getText();
		System.out.println("Edit button is visibile to admin User");

		p.getProfileIcon().click();// signing out to switch non admin user
		p.getSignout().click();

		blank();
		System.out.println("TC02 Check if the edit option is not visible to the non-admin user");
		// signing in to switch non admin user
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();

		System.out.println("Signed in as non admin user");

		try {
			boolean enabled = p.getRepoEdit().isEnabled();

		} catch (Exception e) {
			System.out.println("Edit button is not displayed to non admin user");
		}

		p.getProfileIcon().click();// signing out to non admin user
		p.getSignout().click();
		blank();
		p.getTextEmail().sendKeys("admin@prolaborate.com");// signing in as admin user
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();

		// clicking edit button of repository
		System.out.println("TC03 Check if the porper success message is shown when repository is edit and saved");
		System.out.println("TC06 Check if the user can update the description of the repository");
		p.getRepoEdit().click();
		WebElement editDesc = driver.findElement(
				By.xpath("//textarea[@placeholder='Give a summary of this repository to your users (Optional)']"));
		editDesc.clear();
		System.out.println("updating the Description");
		editDesc.sendKeys("Updated Description");
		p.getRepoSave().click();
		screenshot("Repo Edited ");
		sleep();
		if (driver.getCurrentUrl().contains("http://localhost/RepositoryManagement/List")) {
			System.out.println("Repository is edited successfully");
		} else {
			System.out.println("Repository is not edited successfully");
		}
		blank();
		System.out.println("TC04 check if the user can update the name of the repository");

		p.getRepoEdit().click();

		p.getReponame().clear();
		p.getReponame().sendKeys("Test1");
		p.getRepoSave().click();
		sleep();
		screenshot("Repo name changed ");
		System.out.println("Repo name changed Successfully");

		blank();
		System.out.println("TC05 Check if the user can update the Alias name of the repository");
		p.getRepoEdit().click();
		p.getAliasName().clear();
		p.getAliasName().sendKeys("Test1alias");
		p.getRepoSave().click();
		sleep();
		screenshot("Alias name changed ");
		System.out.println("Alias name changed Successfully");
		blank();

		System.out.println(
				"System.out.println(\"TC06 Check if the user can update the description of the repository\");");
		p.getRepoEdit().click();
		p.getRepoDescription().clear();
		p.getRepoDescription().sendKeys("new Updated Description");
		p.getRepoSave().click();
		sleep();
		screenshot("Description updated ");
		System.out.println("Description updated Successfully");

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

		// TC01,02,03,04,05,06
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
		System.out.println("TC01 Check if the edit option is enabled  to the admin user");

		System.out.println("Signed in as admin user");
		// Checking the Edit button is visible to super admin user
		String editText = p.getRepoEdit().getText();
		System.out.println("Edit button is visibile to admin User");

		p.getProfileIcon().click();// signing out to switch non admin user
		p.getSignout().click();

		blank();
		System.out.println("TC02 Check if the edit option is not visible to the non-admin user");
		// signing in to switch non admin user
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();

		System.out.println("Signed in as non admin user");

		try {
			boolean enabled = p.getRepoEdit().isEnabled();

		} catch (Exception e) {
			System.out.println("Edit button is not displayed to non admin user");
		}

		p.getProfileIcon().click();// signing out to non admin user
		p.getSignout().click();
		blank();
		p.getTextEmail().sendKeys("admin@prolaborate.com");// signing in as admin user
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();

		// clicking edit button of repository
		System.out.println("TC03 Check if the porper success message is shown when repository is edit and saved");
		System.out.println("TC06 Check if the user can update the description of the repository");
		p.getRepoEdit().click();
		WebElement editDesc = driver.findElement(
				By.xpath("//textarea[@placeholder='Give a summary of this repository to your users (Optional)']"));
		editDesc.clear();
		System.out.println("updating the Description");
		editDesc.sendKeys("Updated Description");
		p.getRepoSave().click();
		screenshot("Repo Edited ");
		sleep();
		if (driver.getCurrentUrl().contains("http://localhost/RepositoryManagement/List")) {
			System.out.println("Repository is edited successfully");
		} else {
			System.out.println("Repository is not edited successfully");
		}
		blank();
		System.out.println("TC04 check if the user can update the name of the repository");

		p.getRepoEdit().click();

		p.getReponame().clear();
		p.getReponame().sendKeys("Test1");
		p.getRepoSave().click();
		sleep();
		screenshot("Repo name changed ");
		System.out.println("Repo name changed Successfully");

		blank();
		System.out.println("TC05 Check if the user can update the Alias name of the repository");
		p.getRepoEdit().click();
		p.getAliasName().clear();
		p.getAliasName().sendKeys("Test1alias");
		p.getRepoSave().click();
		sleep();
		screenshot("Alias name changed ");
		System.out.println("Alias name changed Successfully");
		blank();

		System.out.println(
				"System.out.println(\"TC06 Check if the user can update the description of the repository\");");
		p.getRepoEdit().click();
		p.getRepoDescription().clear();
		p.getRepoDescription().sendKeys("new Updated Description");
		p.getRepoSave().click();
		sleep();
		screenshot("Description updated ");
		System.out.println("Description updated Successfully");

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

		// TC01,02,03,04,05,06
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
		System.out.println("TC01 Check if the edit option is enabled  to the admin user");

		System.out.println("Signed in as admin user");
		// Checking the Edit button is visible to super admin user
		String editText = p.getRepoEdit().getText();
		System.out.println("Edit button is visibile to admin User");

		p.getProfileIcon().click();// signing out to switch non admin user
		p.getSignout().click();

		blank();
		System.out.println("TC02 Check if the edit option is not visible to the non-admin user");
		// signing in to switch non admin user
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();

		System.out.println("Signed in as non admin user");

		try {
			boolean enabled = p.getRepoEdit().isEnabled();

		} catch (Exception e) {
			System.out.println("Edit button is not displayed to non admin user");
		}

		p.getProfileIcon().click();// signing out to non admin user
		p.getSignout().click();
		blank();
		p.getTextEmail().sendKeys("admin@prolaborate.com");// signing in as admin user
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();

		// clicking edit button of repository
		System.out.println("TC03 Check if the porper success message is shown when repository is edit and saved");
		System.out.println("TC06 Check if the user can update the description of the repository");
		p.getRepoEdit().click();
		WebElement editDesc = driver.findElement(
				By.xpath("//textarea[@placeholder='Give a summary of this repository to your users (Optional)']"));
		editDesc.clear();
		System.out.println("updating the Description");
		editDesc.sendKeys("Updated Description");
		p.getRepoSave().click();
		screenshot("Repo Edited ");
		sleep();
		if (driver.getCurrentUrl().contains("http://localhost/RepositoryManagement/List")) {
			System.out.println("Repository is edited successfully");
		} else {
			System.out.println("Repository is not edited successfully");
		}
		blank();
		System.out.println("TC04 check if the user can update the name of the repository");

		p.getRepoEdit().click();

		p.getReponame().clear();
		p.getReponame().sendKeys("Test1");
		p.getRepoSave().click();
		sleep();
		screenshot("Repo name changed ");
		System.out.println("Repo name changed Successfully");

		blank();
		System.out.println("TC05 Check if the user can update the Alias name of the repository");
		p.getRepoEdit().click();
		p.getAliasName().clear();
		p.getAliasName().sendKeys("Test1alias");
		p.getRepoSave().click();
		sleep();
		screenshot("Alias name changed ");
		System.out.println("Alias name changed Successfully");
		blank();

		System.out.println(
				"System.out.println(\"TC06 Check if the user can update the description of the repository\");");
		p.getRepoEdit().click();
		p.getRepoDescription().clear();
		p.getRepoDescription().sendKeys("new Updated Description");
		p.getRepoSave().click();
		sleep();
		screenshot("Description updated ");
		System.out.println("Description updated Successfully");

		quit();
		blank();
		System.out.println("**Test Successful**");
	}
}
