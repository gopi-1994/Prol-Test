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

public class TC44__Navi_RepoPage_Model extends BaseClass {
	
	@Test
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		System.out.println("Testing in Chrome Browser");
		
		//TC 44,45,46
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		blank();
		p.getSignIn().click();// locator for submit button
		System.out.println("TC46 Check if the user is navigated to Repositories page when click on cancel in Add Repository page when no details are added");
		waits();
		p.getAddRepoBtn().click();//clicking add repo button
		p.getRepoCancel().click();//clicking cancel button
		System.out.println("Clicking Cancel button without putting any data");
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		getUrl();
		getTitle();
		blank();
		System.out.println("TC44 Check if the user can navigate to the Repositories page from Add Repository page");
		p.getAddRepoBtn().click();//clicking add repo button
		System.out.println("Clicking repositories in bread crumbs without putting any data");
		p.getRepoBreadcrumbs().click(); //clicking repositories in bread crumbs
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		getUrl();
		getTitle();
		blank();
		System.out.println("TC45 Check if the user can navigate to the Portal settings page from Add Repository page");
		p.getAddRepoBtn().click();
		WebElement portalSetting = driver.findElement(By.xpath("//a[contains(text(),'Portal Settings')]"));
		portalSetting.click();//clicking Portal Settings in bread crumbs
		if (driver.getCurrentUrl().contains("/Settings/Portal")) {
			System.out.println("Successfully landed in Poratl setting page");
		} else {
			System.out.println("failed to land in main page");
		}
		
		getUrl();
		getTitle();
		blank();
		
		blank();
		System.out.println("**Test Successful**");
		
		
	}
	
	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();
		System.out.println("Testing in Firefix Browser");
		
		//TC 44,45,46
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		blank();
		p.getSignIn().click();// locator for submit button
		System.out.println("TC46 Check if the user is navigated to Repositories page when click on cancel in Add Repository page when no details are added");
		waits();
		p.getAddRepoBtn().click();//clicking add repo button
		p.getRepoCancel().click();//clicking cancel button
		System.out.println("Clicking Cancel button without putting any data");
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		getUrl();
		getTitle();
		blank();
		System.out.println("TC44 Check if the user can navigate to the Repositories page from Add Repository page");
		p.getAddRepoBtn().click();//clicking add repo button
		System.out.println("Clicking repositories in bread crumbs without putting any data");
		p.getRepoBreadcrumbs().click(); //clicking repositories in bread crumbs
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		getUrl();
		getTitle();
		blank();
		System.out.println("TC45 Check if the user can navigate to the Portal settings page from Add Repository page");
		p.getAddRepoBtn().click();
		WebElement portalSetting = driver.findElement(By.xpath("//a[contains(text(),'Portal Settings')]"));
		portalSetting.click();//clicking Portal Settings in bread crumbs
		if (driver.getCurrentUrl().contains("/Settings/Portal")) {
			System.out.println("Successfully landed in Poratl setting page");
		} else {
			System.out.println("failed to land in main page");
		}
		
		getUrl();
		getTitle();
		blank();
		
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
		
		//TC 44,45,46
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		blank();
		p.getSignIn().click();// locator for submit button
		System.out.println("TC46 Check if the user is navigated to Repositories page when click on cancel in Add Repository page when no details are added");
		waits();
		p.getAddRepoBtn().click();//clicking add repo button
		p.getRepoCancel().click();//clicking cancel button
		System.out.println("Clicking Cancel button without putting any data");
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		getUrl();
		getTitle();
		blank();
		System.out.println("TC44 Check if the user can navigate to the Repositories page from Add Repository page");
		p.getAddRepoBtn().click();//clicking add repo button
		System.out.println("Clicking repositories in bread crumbs without putting any data");
		p.getRepoBreadcrumbs().click(); //clicking repositories in bread crumbs
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		getUrl();
		getTitle();
		blank();
		System.out.println("TC45 Check if the user can navigate to the Portal settings page from Add Repository page");
		p.getAddRepoBtn().click();
		WebElement portalSetting = driver.findElement(By.xpath("//a[contains(text(),'Portal Settings')]"));
		portalSetting.click();//clicking Portal Settings in bread crumbs
		if (driver.getCurrentUrl().contains("/Settings/Portal")) {
			System.out.println("Successfully landed in Poratl setting page");
		} else {
			System.out.println("failed to land in main page");
		}
		
		getUrl();
		getTitle();
		blank();
		
		getUrl();
		getTitle();
		blank();
		
		blank();
		System.out.println("**Test Successful**");
	}
}
