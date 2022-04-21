package org.test.pro.add_new_repo;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC41_Unsaved_Warning extends BaseClass {
	
	@Test(enabled = true)
	public static void chrome() throws InterruptedException, IOException, AWTException {
		
		//enable password for the EA user then runn the script
		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		//TC 41 ,42.1, 42.2
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		System.out.println("TC41 Check if the user is shown Unsaved Changes warning when tries to go away from the Add repository form without saving");

		
		//click edit button of repository
		WebElement edit = driver.findElement(By.xpath("(//span[contains(text(),'Edit')])[1]"));
		edit.click();
		
		WebElement repoNme = driver.findElement(By.xpath("//input[@placeholder='Enter a suitable name']"));
		elementWait(repoNme);
		blank();
		System.out.println("Current Repo Name : "+ repoNme.getAttribute("value"));
		repoNme.clear();
		textFill(repoNme, "testt");// updating the Repository name
		blank();
		System.out.println("Updated Repo Name : "+repoNme.getAttribute("value"));
		blank();		
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		System.out.println("Alias Name : "+aliasNme.getAttribute("value"));
		//Clicking cancel button
		blank();
		p.getRepoCancel().click();
		p.getEditGoBack().click();
		//clicking Header Prolaborate icon
		p.getProlabHeaderIcon().click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(goBack)));
		p.getEditGoBack().click();
		//clicking bread crumbs 
		p.getRepoBreadcrumbs().click();
		
		p.getEditGoBack().click();
		System.out.println("Unsaved changes warning is verified by clicking cancel , Bread crumbs & Header icons");
		blank();
		System.out.println("TC42 Check if the data entered in the for get retained when click on Go back button  in the Unsaved changes warning");
		String reponame = repoNme.getAttribute("value");
		System.out.println("Unchanged Rpeo Name : "+repoNme.getAttribute("value"));
		if (reponame.equalsIgnoreCase("testt")) {
			System.out.println("Data entered is retained after multiple unsaved warning message");
			
		} else {
			System.out.println("Data entered is not retained after multiple unsaved warning message");

		}
		blank();
		System.out.println("TC42 Check if the form get closed and redirectes to appropriate page when click on discard in Usaved Changes warning");
		//clicking cancel btn & discard btn to get to main page
		System.out.println("clicking cancel btn & discard btn to get to main page");
		p.getRepoCancel().click();
		p.getEditDiscard().click();// POM for Discard btn
		waits();
		
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		System.out.println(driver.getCurrentUrl());
		
		p.getRepoEdit().click();// POM for 1st repo edit btn
		waits();
		p.getReponame().clear();// POM for Repo name in edit page
		p.getReponame().sendKeys("testta");// updating the Repository name
		blank();
		System.out.println("clicking repositories breadcrumbs & discard btn to get to main page");
		p.getRepoBreadcrumbs().click();// POM for repositories bread crumbs btn
		
		p.getEditDiscard().click();// POM for Discard btn
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		
		p.getRepoEdit().click();// POM for 1st repo edit btn
		waits();
		p.getReponame().clear();// POM for Repo name in edit page
		p.getReponame().sendKeys("testta");// updating the Repository name
		blank();
		System.out.println("clicking Header Prolaborate icon & discard btn to get to main page");
		p.getProlabHeaderIcon().click();

		p.getEditDiscard().click();// POM for Discard btn
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		
		blank();
		System.out.println("**Test Successful**");
		
		
	}
	
	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {
		
		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();

		//TC 41 ,42.1, 42.2
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		System.out.println("TC41 Check if the user is shown Unsaved Changes warning when tries to go away from the Add repository form without saving");

		
		//click edit button of repository
		WebElement edit = driver.findElement(By.xpath("(//span[contains(text(),'Edit')])[1]"));
		edit.click();
		
		WebElement repoNme = driver.findElement(By.xpath("//input[@placeholder='Enter a suitable name']"));
		elementWait(repoNme);
		blank();
		System.out.println("Current Repo Name : "+ repoNme.getAttribute("value"));
		repoNme.clear();
		textFill(repoNme, "testt");// updating the Repository name
		blank();
		System.out.println("Updated Repo Name : "+repoNme.getAttribute("value"));
		blank();		
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		System.out.println("Alias Name : "+aliasNme.getAttribute("value"));
		//Clicking cancel button
		blank();
		p.getRepoCancel().click();
		p.getEditGoBack().click();
		//clicking Header Prolaborate icon
		p.getProlabHeaderIcon().click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(goBack)));
		p.getEditGoBack().click();
		//clicking bread crumbs 
		sleep();
		p.getRepoBreadcrumbs().click();
		
		p.getEditGoBack().click();
		System.out.println("Unsaved changes warning is verified by clicking cancel , Bread crumbs & Header icons");
		blank();
		System.out.println("TC42 Check if the data entered in the for get retained when click on Go back button  in the Unsaved changes warning");
		String reponame = repoNme.getAttribute("value");
		System.out.println("Unchanged Rpeo Name : "+repoNme.getAttribute("value"));
		if (reponame.equalsIgnoreCase("testt")) {
			System.out.println("Data entered is retained after multiple unsaved warning message");
			
		} else {
			System.out.println("Data entered is not retained after multiple unsaved warning message");

		}
		blank();
		System.out.println("TC42 Check if the form get closed and redirectes to appropriate page when click on discard in Usaved Changes warning");
		//clicking cancel btn & discard btn to get to main page
		System.out.println("clicking cancel btn & discard btn to get to main page");
		p.getRepoCancel().click();
		p.getEditDiscard().click();// POM for Discard btn
		waits();
		
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		System.out.println(driver.getCurrentUrl());
		
		p.getRepoEdit().click();// POM for 1st repo edit btn
		waits();
		p.getReponame().clear();// POM for Repo name in edit page
		p.getReponame().sendKeys("testta");// updating the Repository name
		blank();
		System.out.println("clicking repositories breadcrumbs & discard btn to get to main page");
		p.getRepoBreadcrumbs().click();// POM for repositories bread crumbs btn
		
		p.getEditDiscard().click();// POM for Discard btn
		waits();
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		
		p.getRepoEdit().click();// POM for 1st repo edit btn
		waits();
		p.getReponame().clear();// POM for Repo name in edit page
		p.getReponame().sendKeys("testta");// updating the Repository name
		blank();
		System.out.println("clicking Header Prolaborate icon & discard btn to get to main page");
		p.getProlabHeaderIcon().click();
		waits();
		p.getEditDiscard().click();// POM for Discard btn
		waits();
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
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
		
		
		//TC 41 ,42.1, 42.2
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		System.out.println("TC41 Check if the user is shown Unsaved Changes warning when tries to go away from the Add repository form without saving");

		
		//click edit button of repository
		WebElement edit = driver.findElement(By.xpath("(//span[contains(text(),'Edit')])[1]"));
		edit.click();
		
		WebElement repoNme = driver.findElement(By.xpath("//input[@placeholder='Enter a suitable name']"));
		elementWait(repoNme);
		blank();
		System.out.println("Current Repo Name : "+ repoNme.getAttribute("value"));
		repoNme.clear();
		textFill(repoNme, "testt");// updating the Repository name
		blank();
		System.out.println("Updated Repo Name : "+repoNme.getAttribute("value"));
		blank();		
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		System.out.println("Alias Name : "+aliasNme.getAttribute("value"));
		//Clicking cancel button
		blank();
		p.getRepoCancel().click();
		p.getEditGoBack().click();
		//clicking Header Prolaborate icon
		p.getProlabHeaderIcon().click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(goBack)));
		p.getEditGoBack().click();
		//clicking bread crumbs 
		p.getRepoBreadcrumbs().click();
		
		p.getEditGoBack().click();
		System.out.println("Unsaved changes warning is verified by clicking cancel , Bread crumbs & Header icons");
		blank();
		System.out.println("TC42 Check if the data entered in the for get retained when click on Go back button  in the Unsaved changes warning");
		String reponame = repoNme.getAttribute("value");
		System.out.println("Unchanged Rpeo Name : "+repoNme.getAttribute("value"));
		if (reponame.equalsIgnoreCase("testt")) {
			System.out.println("Data entered is retained after multiple unsaved warning message");
			
		} else {
			System.out.println("Data entered is not retained after multiple unsaved warning message");

		}
		blank();
		System.out.println("TC42 Check if the form get closed and redirectes to appropriate page when click on discard in Usaved Changes warning");
		//clicking cancel btn & discard btn to get to main page
		System.out.println("clicking cancel btn & discard btn to get to main page");
		p.getRepoCancel().click();
		p.getEditDiscard().click();// POM for Discard btn
		waits();
		
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		System.out.println(driver.getCurrentUrl());
		
		p.getRepoEdit().click();// POM for 1st repo edit btn
		waits();
		p.getReponame().clear();// POM for Repo name in edit page
		p.getReponame().sendKeys("testta");// updating the Repository name
		blank();
		System.out.println("clicking repositories breadcrumbs & discard btn to get to main page");
		p.getRepoBreadcrumbs().click();// POM for repositories bread crumbs btn
		
		p.getEditDiscard().click();// POM for Discard btn
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		
		p.getRepoEdit().click();// POM for 1st repo edit btn
		waits();
		p.getReponame().clear();// POM for Repo name in edit page
		p.getReponame().sendKeys("testta");// updating the Repository name
		blank();
		System.out.println("clicking Header Prolaborate icon & discard btn to get to main page");
		p.getProlabHeaderIcon().click();

		p.getEditDiscard().click();// POM for Discard btn
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("RepositoryManagement/List")) {
			System.out.println("Successfully landed in main page");
		} else {
			System.out.println("failed to land in main page");
		}
		
		blank();
		System.out.println("**Test Successful**");
		
	}
}
