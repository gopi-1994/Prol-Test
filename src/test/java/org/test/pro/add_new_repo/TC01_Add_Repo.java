package org.test.pro.add_new_repo;

import java.awt.Window;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_Add_Repo extends BaseClass {
	@Test
	public static void chrome() throws InterruptedException, IOException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		// TC 01,02,03,04,05,06.1, 06.2
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");

		// locator for submit button
		WebElement sbmit = driver.findElement(By.xpath("//button[@type='submit']"));
		sbmit.click();
		waits();
		System.out.println("TC 01 : Check if the Add Repository option is visible to the Admin users");

		WebElement add = driver.findElement(By.xpath("//span[contains(text(),'Add Repository')]"));// click add
																									// repository button
		boolean display = add.isDisplayed();
		System.out.println("Add Repository Option is visible : " + display);
		add.click();
		WebElement save = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));// click save button
		save.click();
		blank();
		System.out.println("TC04 Check if the proper error message is shown when try to add repository without Name");
		WebElement repoBlnk = driver
				.findElement(By.xpath("//span[contains(text(),'Repository Name should not be blank')]"));
		System.out.println("Error MSG : ");
		getText(repoBlnk);
		blank();
		System.out.println(
				"TC 05 Check if the proper error message is shown when try to add repository without Alias name");
		WebElement aliasBlnk = driver
				.findElement(By.xpath("//span[contains(text(),'Alias Name should not be blank')]"));
		System.out.println("Error MSG : ");
		getText(aliasBlnk);
		blank();
		System.out.println(
				"TC06 Check if the proper error message is shown when the existing alias name is give to the repository");
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		textFill(aliasNme, "test2");
		System.out.println("Error MSG : ");
		getValue(aliasNme);
		WebElement aliasExists = driver.findElement(By.xpath("//span[contains(text(),'Alias Name already exists')]"));
		getText(aliasExists);
		String alis = aliasNme.getAttribute("value");
		blank();
		System.out.println("TC06 Check if the user can't insert space in alias name");
		if (alis.contains(" ")) {
			System.out.println("Alias Name accepts SPACE bwn words");
		} else {
			System.out.println("Alias Name SPACE is converted into \"-\" hypen");
		}
		blank();
		String mainwindow = driver.getWindowHandle();
		WebElement learn = driver.findElement(By.linkText("Learn more"));
		learn.click();
		sleep();
		Set<String> allWindows = driver.getWindowHandles();

		for (String all : allWindows) {
			driver.switchTo().window(all);
		}

		String addRepoURL = driver.getCurrentUrl();

		System.out.println("TC03 Check if the Learn More link navigates to the Add Repository Document");
		System.out.println("Learn more URL : " + addRepoURL);
		if (addRepoURL.contains("add-repositories")) {
			System.out.println("Learn more link successfully navigated to Add Repository Document");
		}
		blank();
		close();
		driver.switchTo().window(mainwindow);
		System.out.println("TC02 Check if the Add Repository option is not shown to the non-admin user");
		p.getProfileIcon().click();
		p.getSignout().click();
		System.out.println("switching to non admin user");
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();
		waits();
		p.getProlabHeaderIcon().click();
		try {
			WebElement add1 = driver.findElement(By.xpath("//span[contains(text(),'Add Repository')]"));// click add
																										// repository
																										// button
			boolean display1 = add1.isDisplayed();
			System.out.println("Add Repository Option is visible : " + display1);

		} catch (Exception e) {
			System.out.println("Add Repository option not available for non admin user");
		}

		blank();
		System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		System.out.println("**Test Successful**");

	}

	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		// TC 01,02,03,04,05,06.1, 06.2
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");

		// locator for submit button
		WebElement sbmit = driver.findElement(By.xpath("//button[@type='submit']"));
		sbmit.click();
		waits();
		System.out.println("TC 01 : Check if the Add Repository option is visible to the Admin users");

		WebElement add = driver.findElement(By.xpath("//span[contains(text(),'Add Repository')]"));// click add
																									// repository button
		boolean display = add.isDisplayed();
		System.out.println("Add Repository Option is visible : " + display);
		add.click();
		WebElement save = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));// click save button
		save.click();
		blank();
		System.out.println("TC04 Check if the proper error message is shown when try to add repository without Name");
		WebElement repoBlnk = driver
				.findElement(By.xpath("//span[contains(text(),'Repository Name should not be blank')]"));
		System.out.println("Error MSG : ");
		getText(repoBlnk);
		blank();
		System.out.println(
				"TC 05 Check if the proper error message is shown when try to add repository without Alias name");
		WebElement aliasBlnk = driver
				.findElement(By.xpath("//span[contains(text(),'Alias Name should not be blank')]"));
		System.out.println("Error MSG : ");
		getText(aliasBlnk);
		blank();
		System.out.println(
				"TC06 Check if the proper error message is shown when the existing alias name is give to the repository");
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		textFill(aliasNme, "Test1");
		System.out.println("Error MSG : ");
		getValue(aliasNme);
		WebElement aliasExists = driver.findElement(By.xpath("//span[contains(text(),'Alias Name already exists')]"));
		getText(aliasExists);
		String alis = aliasNme.getAttribute("value");
		blank();
		System.out.println("TC06 Check if the user can't insert space in alias name");
		if (alis.contains("-")) {
			System.out.println("Alias Name accepts SPACE bwn words");
		} else {
			System.out.println("Alias Name SPACE is not converted into \"-\" hypen");
		}
		blank();
		String mainwindow = driver.getWindowHandle();
		WebElement learn = driver.findElement(By.linkText("Learn more"));
		learn.click();
		sleep();
		Set<String> allWindows = driver.getWindowHandles();

		for (String all : allWindows) {
			driver.switchTo().window(all);
		}

		String addRepoURL = driver.getCurrentUrl();

		System.out.println("TC03 Check if the Learn More link navigates to the Add Repository Document");
		System.out.println("Learn more URL : " + addRepoURL);
		if (addRepoURL.contains("AddRepository")) {
			System.out.println("Learn more link successfully navigated to Add Repository Document");
		}
		blank();
		close();
		driver.switchTo().window(mainwindow);
		System.out.println("TC02 Check if the Add Repository option is not shown to the non-admin user");
		p.getProfileIcon().click();
		p.getSignout().click();
		System.out.println("switching to non admin user");
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();
		waits();
		p.getProlabHeaderIcon().click();
		try {
			WebElement add1 = driver.findElement(By.xpath("//span[contains(text(),'Add Repository')]"));// click add
																										// repository
																										// button
			boolean display1 = add1.isDisplayed();
			System.out.println("Add Repository Option is visible : " + display1);

		} catch (Exception e) {
			System.out.println("Add Repository option not available for non admin user");
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

		// TC 01,02,03,04,05,06.1, 06.2
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");

		// locator for submit button
		WebElement sbmit = driver.findElement(By.xpath("//button[@type='submit']"));
		sbmit.click();
		waits();
		System.out.println("TC 01 : Check if the Add Repository option is visible to the Admin users");

		WebElement add = driver.findElement(By.xpath("//span[contains(text(),'Add Repository')]"));// click add
																									// repository button
		boolean display = add.isDisplayed();
		System.out.println("Add Repository Option is visible : " + display);
		add.click();
		WebElement save = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));// click save button
		save.click();
		blank();
		System.out.println("TC04 Check if the proper error message is shown when try to add repository without Name");
		WebElement repoBlnk = driver
				.findElement(By.xpath("//span[contains(text(),'Repository Name should not be blank')]"));
		System.out.println("Error MSG : ");
		getText(repoBlnk);
		blank();
		System.out.println(
				"TC 05 Check if the proper error message is shown when try to add repository without Alias name");
		WebElement aliasBlnk = driver
				.findElement(By.xpath("//span[contains(text(),'Alias Name should not be blank')]"));
		System.out.println("Error MSG : ");
		getText(aliasBlnk);
		blank();
		System.out.println(
				"TC06 Check if the proper error message is shown when the existing alias name is give to the repository");
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		textFill(aliasNme, "Test1");
		System.out.println("Error MSG : ");
		getValue(aliasNme);
		WebElement aliasExists = driver.findElement(By.xpath("//span[contains(text(),'Alias Name already exists')]"));
		getText(aliasExists);
		String alis = aliasNme.getAttribute("value");
		blank();
		System.out.println("TC06 Check if the user can't insert space in alias name");
		if (alis.contains("-")) {
			System.out.println("Alias Name accepts SPACE bwn words");
		} else {
			System.out.println("Alias Name SPACE is not converted into \"-\" hypen");
		}
		blank();
		String mainwindow = driver.getWindowHandle();
		WebElement learn = driver.findElement(By.linkText("Learn more"));
		learn.click();
		sleep();
		Set<String> allWindows = driver.getWindowHandles();

		for (String all : allWindows) {
			driver.switchTo().window(all);
		}

		String addRepoURL = driver.getCurrentUrl();

		System.out.println("TC03 Check if the Learn More link navigates to the Add Repository Document");
		System.out.println("Learn more URL : " + addRepoURL);
		if (addRepoURL.contains("AddRepository")) {
			System.out.println("Learn more link successfully navigated to Add Repository Document");
		}
		blank();
		close();
		driver.switchTo().window(mainwindow);
		System.out.println("TC02 Check if the Add Repository option is not shown to the non-admin user");
		p.getProfileIcon().click();
		p.getSignout().click();
		System.out.println("switching to non admin user");
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();
		waits();
		p.getProlabHeaderIcon().click();
		try {
			WebElement add1 = driver.findElement(By.xpath("//span[contains(text(),'Add Repository')]"));// click add
																										// repository
																										// button
			boolean display1 = add1.isDisplayed();
			System.out.println("Add Repository Option is visible : " + display1);

		} catch (Exception e) {
			System.out.println("Add Repository option not available for non admin user");
		}

		blank();
		System.out.println("**Test Successful**");

	}

}
