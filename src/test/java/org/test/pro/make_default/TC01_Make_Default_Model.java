package org.test.pro.make_default;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

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

public class TC01_Make_Default_Model extends BaseClass {

	@Test
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		System.out.println("Testing in Chrome Browser");

		// TC01,02,03,04,05,06,07,10,11,12
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

		System.out.println("TC01 Check if the Make Default option visible to Admin users");
		waits();
		// clicking the profile icon to verify super admin user
		p.getProfileIcon().click();

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

		blank();
		System.out.println("TC02 Check if the Make default option visible to non admin users");
		p.getProfileIcon().click();// signing out to switch non admin user
		p.getSignout().click();

		blank();
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();
		p.getProfileIcon().click();

		WebElement nonAdmin = driver.findElement(By.xpath("//div[contains(text(),'Test Tst')]"));
		String nonadminText = nonAdmin.getText();

		if (adminText.equalsIgnoreCase("Super Admin")) {
			System.out.println("User is not an Admin");

		} else {
			System.out.println("User is an Admin");
		}
		System.out.println("clicking more option in the 1st repository");

		p.getMore1().click();

		String defalt = p.getMakeDefault1().getText();

		if (defalt.equals("Make Default")) {
			System.out.println("Make Default is visible to non admin user");
		} else {
			System.out.println("Make Default is not visible to non admin user");
		}

		blank();
		System.out.println("TC03 Check if the proper message shown when user set the Repository as default");
		p.getProfileIcon().click();// signing out to admin user
		p.getSignout().click();
		blank();
		p.getTextEmail().sendKeys("admin@prolaborate.com");// signing in
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();
		System.out.println("Making Repository as default");
		System.out.println("clicking more option in the 1st repository");
		p.getMore1().click();
		p.getMakeDefault1().click();

		sleep();
		System.out.println("successfully Reporitory added as Default Repo");
		screenshot("Default Repo");

		blank();
		System.out.println("TC04 Check if the Default label is shown to  the repository name when it is set default");
		WebElement profile = driver.findElement(By.xpath("(//span[contains(text(),'Default')])[2]"));
		String defaultLable = profile.getText();
		List<WebElement> profiles = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count = profiles.size();
		System.out.println("Total Default Repositories : " + count);

		WebElement table = driver.findElement(By.xpath(
				"//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-management-page[1]/app-repository-management-list[1]/div[1]/div[2]/app-datatable[1]/div[1]/p-table[1]/div[1]/div[2]/table[1]"));
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);

			java.util.List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(0);
				String textdata = data.getText();
				if (textdata.contains("Default")) {
					System.out.println(textdata);
				} else {

				}

			}

		}

		blank();
		System.out.println("TC05 Check if the option changes to Remove Default for the default repository");
		System.out.println("clicking more option in the 1st repository");
		p.getMore1().click();// clicking more option in the 1st repository
		WebElement rmveDefault = driver.findElement(By.xpath("//span[contains(text(),'Remove Default')]"));// Locator of
																											// Remove
																											// Default
		String rmveText = rmveDefault.getText();
		if (rmveText.contains("Remove Default")) {
			System.out.println("Remove Default option is availblae for Default Repository");
		} else {
			System.out.println("Remove Default option is not availblae for Default Repository");
		}

		p.getProfileIcon().click();// signing out to check user get in to the default repository
		p.getSignout().click();

		blank();
		System.out.println(
				"TC06 Check if the user login to the application they should be navigated to the default repository");

		p.getTextEmail().sendKeys("admin@prolaborate.com");// signing in
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();
		WebElement defaultRepo = driver.findElement(By.xpath("//span[contains(text(),'test1')]"));
		String defaText = defaultRepo.getText();
		if (defaText.contains("Test")) {
			System.out.println("Default Repository is : " + defaText);
			System.out.println("User successfully logged into Default Repository");
		} else {
			System.out.println("User not logged into Default Repository");
		}
		p.getProfileIcon().click();// signing out to other user
		p.getSignout().click();

		blank();
		System.out.println(
				"TC07 Check if the deafult repository set by one user is not applied to another user with the same repository");
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();

		System.out.println("Check if another user dont have default repository");
		List<WebElement> profiles1 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count1 = profiles1.size();
		System.out.println("Total Default Repositories : " + count1);
		System.out.println("Making Repository as default");
		System.out.println("clicking more option in the 1st repository");
		p.getMore1().click();
		p.getMakeDefault1().click();
		refresh();
		List<WebElement> profiles2 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count2 = profiles2.size();
		System.out.println("Total Default Repositories : " + count2);

		blank();
		System.out.println("TC11 Check if the user can remove the default status of the repository");

		p.getMore1().click();
		WebElement rmveDflt = driver.findElement(By.xpath("//span[contains(text(),'Remove Default')]"));
		rmveDflt.click();
		System.out.println("Default status of repository removed successfully");
		screenshot("Default status removed");
		sleep();
		refresh();
		blank();
		System.out.println(
				"TC12 Check if any other repository is made default then the default status should be removed for earlier repository");
		List<WebElement> profiles3 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count3 = profiles3.size();
		System.out.println("Total Default Repositories : " + count3);
		refresh();
		System.out.println("Check if Make Default option is available");
		p.getMore1().click();
		String deflttext = p.getMakeDefault1().getText();
		if (deflttext.equals("Make Default")) {
			System.out.println("Make Default option is available");
		} else {
			System.out.println("Make Default option is not available");
		}
		refresh();
		sleep();
		blank();
		System.out.println("Making another repository as default");
		p.getMore2().click();// clicking 2nd Repository More option
		sleep();
		p.getMakeDefault1().click();// making 2nd Repository as default repository

		refresh();
		WebElement profile2 = driver.findElement(By.xpath("(//span[contains(text(),'Default')])[2]"));
		String defaultLable1 = profile2.getText();
		List<WebElement> profiles4 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count4 = profiles4.size();
		System.out.println("Total Default Repositories : " + count4);

		System.out.println("Successfully made another repository as default");

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

		// TC01,02,03,04,05,06,07,10,11,12
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

		System.out.println("TC01 Check if the Make Default option visible to Admin users");
		waits();
		// clicking the profile icon to verify super admin user
		p.getProfileIcon().click();

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

		blank();
		System.out.println("TC02 Check if the Make default option visible to non admin users");
		p.getProfileIcon().click();// signing out to switch non admin user
		p.getSignout().click();

		blank();
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();
		p.getProfileIcon().click();

		WebElement nonAdmin = driver.findElement(By.xpath("//div[contains(text(),'Test Tst')]"));
		String nonadminText = nonAdmin.getText();

		if (adminText.equalsIgnoreCase("Super Admin")) {
			System.out.println("User is not an Admin");

		} else {
			System.out.println("User is an Admin");
		}
		System.out.println("clicking more option in the 1st repository");

		p.getMore1().click();

		String defalt = p.getMakeDefault1().getText();

		if (defalt.equals("Make Default")) {
			System.out.println("Make Default is visible to non admin user");
		} else {
			System.out.println("Make Default is not visible to non admin user");
		}

		blank();
		System.out.println("TC03 Check if the proper message shown when user set the Repository as default");
		p.getProfileIcon().click();// signing out to admin user
		p.getSignout().click();
		blank();
		p.getTextEmail().sendKeys("admin@prolaborate.com");// signing in
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();
		System.out.println("Making Repository as default");
		System.out.println("clicking more option in the 1st repository");
		p.getMore1().click();
		p.getMakeDefault1().click();

		sleep();
		System.out.println("successfully Reporitory added as Default Repo");
		screenshot("Default Repo");

		blank();
		System.out.println("TC04 Check if the Default label is shown to  the repository name when it is set default");
		WebElement profile = driver.findElement(By.xpath("(//span[contains(text(),'Default')])[2]"));
		String defaultLable = profile.getText();
		List<WebElement> profiles = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count = profiles.size();
		System.out.println("Total Default Repositories : " + count);

		WebElement table = driver.findElement(By.xpath(
				"//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-management-page[1]/app-repository-management-list[1]/div[1]/div[2]/app-datatable[1]/div[1]/p-table[1]/div[1]/div[2]/table[1]"));
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);

			java.util.List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(0);
				String textdata = data.getText();
				if (textdata.contains("Default")) {
					System.out.println(textdata);
				} else {

				}

			}

		}

		blank();
		System.out.println("TC05 Check if the option changes to Remove Default for the default repository");
		System.out.println("clicking more option in the 1st repository");
		p.getMore1().click();// clicking more option in the 1st repository
		WebElement rmveDefault = driver.findElement(By.xpath("//span[contains(text(),'Remove Default')]"));// Locator of
																											// Remove
																											// Default
		String rmveText = rmveDefault.getText();
		if (rmveText.contains("Remove Default")) {
			System.out.println("Remove Default option is availblae for Default Repository");
		} else {
			System.out.println("Remove Default option is not availblae for Default Repository");
		}

		p.getProfileIcon().click();// signing out to check user get in to the default repository
		p.getSignout().click();

		blank();
		System.out.println(
				"TC06 Check if the user login to the application they should be navigated to the default repository");

		p.getTextEmail().sendKeys("admin@prolaborate.com");// signing in
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();
		WebElement defaultRepo = driver.findElement(By.xpath("//span[contains(text(),'test1')]"));
		String defaText = defaultRepo.getText();
		if (defaText.contains("Test")) {
			System.out.println("Default Repository is : " + defaText);
			System.out.println("User successfully logged into Default Repository");
		} else {
			System.out.println("User not logged into Default Repository");
		}
		p.getProfileIcon().click();// signing out to other user
		p.getSignout().click();

		blank();
		System.out.println(
				"TC07 Check if the deafult repository set by one user is not applied to another user with the same repository");
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();

		System.out.println("Check if another user dont have default repository");
		List<WebElement> profiles1 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count1 = profiles1.size();
		System.out.println("Total Default Repositories : " + count1);
		System.out.println("Making Repository as default");
		System.out.println("clicking more option in the 1st repository");
		p.getMore1().click();
		p.getMakeDefault1().click();
		refresh();
		List<WebElement> profiles2 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count2 = profiles2.size();
		System.out.println("Total Default Repositories : " + count2);

		blank();
		System.out.println("TC11 Check if the user can remove the default status of the repository");

		p.getMore1().click();
		WebElement rmveDflt = driver.findElement(By.xpath("//span[contains(text(),'Remove Default')]"));
		rmveDflt.click();
		System.out.println("Default status of repository removed successfully");
		screenshot("Default status removed");
		sleep();
		refresh();
		blank();
		System.out.println(
				"TC12 Check if any other repository is made default then the default status should be removed for earlier repository");
		List<WebElement> profiles3 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count3 = profiles3.size();
		System.out.println("Total Default Repositories : " + count3);
		refresh();
		System.out.println("Check if Make Default option is available");
		p.getMore1().click();
		String deflttext = p.getMakeDefault1().getText();
		if (deflttext.equals("Make Default")) {
			System.out.println("Make Default option is available");
		} else {
			System.out.println("Make Default option is not available");
		}
		refresh();
		sleep();
		blank();
		System.out.println("Making another repository as default");
		p.getMore2().click();// clicking 2nd Repository More option
		sleep();
		p.getMakeDefault1().click();// making 2nd Repository as default repository

		refresh();
		WebElement profile2 = driver.findElement(By.xpath("(//span[contains(text(),'Default')])[2]"));
		String defaultLable1 = profile2.getText();
		List<WebElement> profiles4 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count4 = profiles4.size();
		System.out.println("Total Default Repositories : " + count4);

		System.out.println("Successfully made another repository as default");

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

		// TC01,02,03,04,05,06,07,10,11,12
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

		System.out.println("TC01 Check if the Make Default option visible to Admin users");
		waits();
		// clicking the profile icon to verify super admin user
		p.getProfileIcon().click();

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

		blank();
		System.out.println("TC02 Check if the Make default option visible to non admin users");
		p.getProfileIcon().click();// signing out to switch non admin user
		p.getSignout().click();

		blank();
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();
		p.getProfileIcon().click();

		WebElement nonAdmin = driver.findElement(By.xpath("//div[contains(text(),'Test Tst')]"));
		String nonadminText = nonAdmin.getText();

		if (adminText.equalsIgnoreCase("Super Admin")) {
			System.out.println("User is not an Admin");

		} else {
			System.out.println("User is an Admin");
		}
		System.out.println("clicking more option in the 1st repository");

		p.getMore1().click();

		String defalt = p.getMakeDefault1().getText();

		if (defalt.equals("Make Default")) {
			System.out.println("Make Default is visible to non admin user");
		} else {
			System.out.println("Make Default is not visible to non admin user");
		}

		blank();
		System.out.println("TC03 Check if the proper message shown when user set the Repository as default");
		p.getProfileIcon().click();// signing out to admin user
		p.getSignout().click();
		blank();
		p.getTextEmail().sendKeys("admin@prolaborate.com");// signing in
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();
		System.out.println("Making Repository as default");
		System.out.println("clicking more option in the 1st repository");
		p.getMore1().click();
		p.getMakeDefault1().click();

		sleep();
		System.out.println("successfully Reporitory added as Default Repo");
		screenshot("Default Repo");

		blank();
		System.out.println("TC04 Check if the Default label is shown to  the repository name when it is set default");
		WebElement profile = driver.findElement(By.xpath("(//span[contains(text(),'Default')])[2]"));
		String defaultLable = profile.getText();
		List<WebElement> profiles = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count = profiles.size();
		System.out.println("Total Default Repositories : " + count);

		WebElement table = driver.findElement(By.xpath(
				"//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-management-page[1]/app-repository-management-list[1]/div[1]/div[2]/app-datatable[1]/div[1]/p-table[1]/div[1]/div[2]/table[1]"));
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);

			java.util.List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(0);
				String textdata = data.getText();
				if (textdata.contains("Default")) {
					System.out.println(textdata);
				} else {

				}

			}

		}

		blank();
		System.out.println("TC05 Check if the option changes to Remove Default for the default repository");
		System.out.println("clicking more option in the 1st repository");
		p.getMore1().click();// clicking more option in the 1st repository
		WebElement rmveDefault = driver.findElement(By.xpath("//span[contains(text(),'Remove Default')]"));// Locator of
																											// Remove
																											// Default
		String rmveText = rmveDefault.getText();
		if (rmveText.contains("Remove Default")) {
			System.out.println("Remove Default option is availblae for Default Repository");
		} else {
			System.out.println("Remove Default option is not availblae for Default Repository");
		}

		p.getProfileIcon().click();// signing out to check user get in to the default repository
		p.getSignout().click();

		blank();
		System.out.println(
				"TC06 Check if the user login to the application they should be navigated to the default repository");

		p.getTextEmail().sendKeys("admin@prolaborate.com");// signing in
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();
		WebElement defaultRepo = driver.findElement(By.xpath("//span[contains(text(),'test1')]"));
		String defaText = defaultRepo.getText();
		if (defaText.contains("Test")) {
			System.out.println("Default Repository is : " + defaText);
			System.out.println("User successfully logged into Default Repository");
		} else {
			System.out.println("User not logged into Default Repository");
		}
		p.getProfileIcon().click();// signing out to other user
		p.getSignout().click();

		blank();
		System.out.println(
				"TC07 Check if the deafult repository set by one user is not applied to another user with the same repository");
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();

		System.out.println("Check if another user dont have default repository");
		List<WebElement> profiles1 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count1 = profiles1.size();
		System.out.println("Total Default Repositories : " + count1);
		System.out.println("Making Repository as default");
		System.out.println("clicking more option in the 1st repository");
		p.getMore1().click();
		p.getMakeDefault1().click();
		refresh();
		List<WebElement> profiles2 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count2 = profiles2.size();
		System.out.println("Total Default Repositories : " + count2);

		blank();
		System.out.println("TC11 Check if the user can remove the default status of the repository");

		p.getMore1().click();
		WebElement rmveDflt = driver.findElement(By.xpath("//span[contains(text(),'Remove Default')]"));
		rmveDflt.click();
		System.out.println("Default status of repository removed successfully");
		screenshot("Default status removed");
		sleep();
		refresh();
		blank();
		System.out.println(
				"TC12 Check if any other repository is made default then the default status should be removed for earlier repository");
		List<WebElement> profiles3 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count3 = profiles3.size();
		System.out.println("Total Default Repositories : " + count3);
		refresh();
		System.out.println("Check if Make Default option is available");
		p.getMore1().click();
		String deflttext = p.getMakeDefault1().getText();
		if (deflttext.equals("Make Default")) {
			System.out.println("Make Default option is available");
		} else {
			System.out.println("Make Default option is not available");
		}
		refresh();
		sleep();
		blank();
		System.out.println("Making another repository as default");
		p.getMore2().click();// clicking 2nd Repository More option
		sleep();
		p.getMakeDefault1().click();// making 2nd Repository as default repository

		refresh();
		WebElement profile2 = driver.findElement(By.xpath("(//span[contains(text(),'Default')])[2]"));
		String defaultLable1 = profile2.getText();
		List<WebElement> profiles4 = driver.findElements(By.xpath("(//span[(text()='Default')])"));
		int count4 = profiles4.size();
		System.out.println("Total Default Repositories : " + count4);

		System.out.println("Successfully made another repository as default");

		quit();
		blank();
		System.out.println("**Test Successful**");
	}
}
