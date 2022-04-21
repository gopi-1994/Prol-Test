package org.test.pro.update_repository;

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

public class TC08_update_PCS_details extends BaseClass {

	@Test(enabled = true)
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		System.out.println("Testing in Chrome Browser");

		// TC08,09,10,11(Included in the previous TC error msg output will be printed in
		// the console)
		// TC12,13,15

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

		WebDriverWait wait = new WebDriverWait(driver, 30);

		System.out.println("TC08 Check if the user can update the protocol of the PCS connection");
		System.out.println("Changing the protocol of PCS connection");
		p.getRepoEdit().click();
		System.out.println("From HTTP to HTTPS");
		driver.findElement(By.xpath("(//div[@class='ng-input'])[1]")).click();// clicking the protocol dropdown
		driver.findElement(By.xpath("//span[contains(text(),'https://')]")).click();// changing HTTP to HTTPS
		p.getRepoSave().click();

		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//ngb-alert[contains(text(),'Invalid Pro Cloud Server details! Please check the details in the Application Server')])")))
				.getText();
		waits();
		System.out.println(text);

		System.out.println("From HTTPS to HTTP");
		driver.findElement(By.xpath("(//div[@class='ng-input'])[1]")).click();// clicking the protocol dropdown
		driver.findElement(By.xpath("//span[contains(text(),'http://')]")).click();// changing HTTPS to HTTP
		p.getRepoSave().click();
		System.out.println("Protocol Updated Successfully");

		blank();
		System.out.println("TC09 Check if the user can update the Port of the pcs connection");
		System.out.println("Changing the port of PCS connection");
		refresh();
		waits();
		p.getRepoEdit().click();
		System.out.println("From 804 to 803");
		WebElement port = driver.findElement(By.xpath("//input[@placeholder='Enter the Port']"));
		port.clear();
		textFill(port, "803");
		p.getRepoSave().click();

		String text2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//ngb-alert[contains(text(),'Invalid Pro Cloud Server details! Please check the details in the Application Server')])")))
				.getText();
		waits();
		System.out.println(text2);
		port.clear();
		textFill(port, "804");// updating the correct port
		p.getRepoSave().click();
		System.out.println("Port Updated Successfully");

		blank();
		System.out.println("TC10 Check if the user can update the status of the repository to Inactive");
		System.out.println("Changing the Active status to inactive ");
		refresh();
		waits();
		p.getRepoEdit().click();
		WebElement inactive = driver.findElement(By.xpath("//input[@id='activeRepository']"));
		inactive.click();
		p.getRepoSave().click();
		driver.findElement(By.xpath("//span[contains(text(),'Test1')]")).click();
		String inactiveText = driver.findElement(By.xpath("//span[contains(text(),'Inactive')]")).getText();

		if (inactiveText.contains("Inactive")) {
			System.out.println("Repository status changed to inactive successfully");
		} else {
			System.out.println("Repository status not changed to inactive");
		}

		refresh();
		System.out.println("Changing the Inactive status to Active ");

		WebElement inactive1 = driver.findElement(By.xpath("//input[@id='activeRepository']"));
		inactive1.click();
		blank();

		System.out.println("changing the model name with no EA login");
		WebElement modelNme = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		modelNme.clear();
		blank();
		System.out.println("TC12 Check if the user can edit and disable the modal security");
		textFill(modelNme, "nosec");
		WebElement securityDisable = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityDisable.click();
		p.getRepoSave().click();
		waits();
		refresh();
		p.getRepoEdit().click();
		waits();
		WebElement disabledText = driver.findElement(By.xpath("//span[contains(text(),'Disabled')]"));
		System.out.println("Model Security : " + disabledText.getText());
		refresh();
		System.out.println("Successfully changed the Model name with no EA login");
		blank();
		System.out.println("TC11 Check if the proper error message is shown when incorrect PCS details are updated");
		System.out.println("Changing the disable to enable model security");
		WebElement securityDisable1 = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityDisable1.click();
		p.getRepoSave().click();
		blank();
		System.out.println("changing the model name with EA login");
		refresh();
		p.getRepoEdit().click();
		refresh();
		WebElement modelNme1 = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		modelNme1.clear();
		textFill(modelNme1, "demo1");
		blank();
		System.out.println(
				"TC13 Check if proper error message is shown when we edit and disable the modal security while modal requires it");
		System.out.println("Changing the Enable to Disable model security");
		WebElement securityEnable = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnable.click();
		p.getRepoSave().click();
		waits();
		WebElement errorMsg = driver.findElement(By.xpath(
				"//ngb-alert[text()=\"Security has been enabled in the EA repository. Toggle 'Model Security' and provide valid credentials.\"]"));
		System.out.println("Error Msg : " + errorMsg.getText());
		waits();
		System.out.println("TC15 Check if the proper error message is shown when incorrect EA user login is updated");
		System.out.println("Entering the incorrect EA login creds");
		WebElement securityEnable1 = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnable1.click();
		WebElement eaLogin = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		eaLogin.clear();
		textFill(eaLogin, "Incorrect");
		p.getRepoSave().click();
		String text3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//ngb-alert[text()='Invalid Login and/or Password! Please enter valid credentials']")))
				.getText();
		waits();
		System.out.println("Error Msg : " + text3);

		// refresh();

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

		// TC08,09,10,11(Included in the previous TC error msg output will be printed in
		// the console)
		// TC12,13,15

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

		WebDriverWait wait = new WebDriverWait(driver, 30);

		System.out.println("TC08 Check if the user can update the protocol of the PCS connection");
		System.out.println("Changing the protocol of PCS connection");
		p.getRepoEdit().click();
		System.out.println("From HTTP to HTTPS");
		driver.findElement(By.xpath("(//div[@class='ng-input'])[1]")).click();// clicking the protocol dropdown
		driver.findElement(By.xpath("//span[contains(text(),'https://')]")).click();// changing HTTP to HTTPS
		p.getRepoSave().click();

		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//ngb-alert[contains(text(),'Invalid Pro Cloud Server details! Please check the details in the Application Server')])")))
				.getText();
		waits();
		System.out.println(text);

		System.out.println("From HTTPS to HTTP");
		driver.findElement(By.xpath("(//div[@class='ng-input'])[1]")).click();// clicking the protocol dropdown
		driver.findElement(By.xpath("//span[contains(text(),'http://')]")).click();// changing HTTPS to HTTP
		p.getRepoSave().click();
		System.out.println("Protocol Updated Successfully");

		blank();
		System.out.println("TC09 Check if the user can update the Port of the pcs connection");
		System.out.println("Changing the port of PCS connection");
		refresh();
		waits();
		p.getRepoEdit().click();
		System.out.println("From 804 to 803");
		WebElement port = driver.findElement(By.xpath("//input[@placeholder='Enter the Port']"));
		port.clear();
		textFill(port, "803");
		p.getRepoSave().click();

		String text2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//ngb-alert[contains(text(),'Invalid Pro Cloud Server details! Please check the details in the Application Server')])")))
				.getText();
		waits();
		System.out.println(text2);
		port.clear();
		textFill(port, "804");// updating the correct port
		p.getRepoSave().click();
		System.out.println("Port Updated Successfully");

		blank();
		System.out.println("TC10 Check if the user can update the status of the repository to Inactive");
		System.out.println("Changing the Active status to inactive ");
		refresh();
		waits();
		p.getRepoEdit().click();
		WebElement inactive = driver.findElement(By.xpath("//input[@id='activeRepository']"));
		inactive.click();
		p.getRepoSave().click();
		driver.findElement(By.xpath("//span[contains(text(),'Test1')]")).click();
		String inactiveText = driver.findElement(By.xpath("//span[contains(text(),'Inactive')]")).getText();

		if (inactiveText.contains("Inactive")) {
			System.out.println("Repository status changed to inactive successfully");
		} else {
			System.out.println("Repository status not changed to inactive");
		}

		refresh();
		System.out.println("Changing the Inactive status to Active ");

		WebElement inactive1 = driver.findElement(By.xpath("//input[@id='activeRepository']"));
		inactive1.click();
		blank();

		System.out.println("changing the model name with no EA login");
		WebElement modelNme = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		modelNme.clear();
		blank();
		System.out.println("TC12 Check if the user can edit and disable the modal security");
		textFill(modelNme, "nosec");
		WebElement securityDisable = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityDisable.click();
		p.getRepoSave().click();
		waits();
		refresh();
		p.getRepoEdit().click();
		waits();
		WebElement disabledText = driver.findElement(By.xpath("//span[contains(text(),'Disabled')]"));
		System.out.println("Model Security : " + disabledText.getText());
		refresh();
		System.out.println("Successfully changed the Model name with no EA login");
		blank();
		System.out.println("TC11 Check if the proper error message is shown when incorrect PCS details are updated");
		System.out.println("Changing the disable to enable model security");
		WebElement securityDisable1 = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityDisable1.click();
		p.getRepoSave().click();
		blank();
		System.out.println("changing the model name with EA login");
		refresh();
		p.getRepoEdit().click();
		refresh();
		WebElement modelNme1 = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		modelNme1.clear();
		textFill(modelNme1, "demo1");
		blank();
		System.out.println(
				"TC13 Check if proper error message is shown when we edit and disable the modal security while modal requires it");
		System.out.println("Changing the Enable to Disable model security");
		WebElement securityEnable = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnable.click();
		p.getRepoSave().click();
		waits();
		WebElement errorMsg = driver.findElement(By.xpath(
				"//ngb-alert[text()=\"Security has been enabled in the EA repository. Toggle 'Model Security' and provide valid credentials.\"]"));
		System.out.println("Error Msg : " + errorMsg.getText());
		waits();
		System.out.println("TC15 Check if the proper error message is shown when incorrect EA user login is updated");
		System.out.println("Entering the incorrect EA login creds");
		WebElement securityEnable1 = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnable1.click();
		WebElement eaLogin = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		eaLogin.clear();
		textFill(eaLogin, "Incorrect");
		p.getRepoSave().click();
		String text3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//ngb-alert[text()='Invalid Login and/or Password! Please enter valid credentials']")))
				.getText();
		waits();
		System.out.println("Error Msg : " + text3);

		// refresh();

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

		// TC08,09,10,11(Included in the previous TC error msg output will be printed in
		// the console)
		// TC12,13,15

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

		WebDriverWait wait = new WebDriverWait(driver, 30);

		System.out.println("TC08 Check if the user can update the protocol of the PCS connection");
		System.out.println("Changing the protocol of PCS connection");
		p.getRepoEdit().click();
		System.out.println("From HTTP to HTTPS");
		driver.findElement(By.xpath("(//div[@class='ng-input'])[1]")).click();// clicking the protocol dropdown
		driver.findElement(By.xpath("//span[contains(text(),'https://')]")).click();// changing HTTP to HTTPS
		p.getRepoSave().click();

		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//ngb-alert[contains(text(),'Invalid Pro Cloud Server details! Please check the details in the Application Server')])")))
				.getText();
		waits();
		System.out.println(text);

		System.out.println("From HTTPS to HTTP");
		driver.findElement(By.xpath("(//div[@class='ng-input'])[1]")).click();// clicking the protocol dropdown
		driver.findElement(By.xpath("//span[contains(text(),'http://')]")).click();// changing HTTPS to HTTP
		p.getRepoSave().click();
		System.out.println("Protocol Updated Successfully");

		blank();
		System.out.println("TC09 Check if the user can update the Port of the pcs connection");
		System.out.println("Changing the port of PCS connection");
		refresh();
		waits();
		p.getRepoEdit().click();
		System.out.println("From 804 to 803");
		WebElement port = driver.findElement(By.xpath("//input[@placeholder='Enter the Port']"));
		port.clear();
		textFill(port, "803");
		p.getRepoSave().click();

		String text2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//ngb-alert[contains(text(),'Invalid Pro Cloud Server details! Please check the details in the Application Server')])")))
				.getText();
		waits();
		System.out.println(text2);
		port.clear();
		textFill(port, "804");// updating the correct port
		p.getRepoSave().click();
		System.out.println("Port Updated Successfully");

		blank();
		System.out.println("TC10 Check if the user can update the status of the repository to Inactive");
		System.out.println("Changing the Active status to inactive ");
		refresh();
		waits();
		p.getRepoEdit().click();
		WebElement inactive = driver.findElement(By.xpath("//input[@id='activeRepository']"));
		inactive.click();
		p.getRepoSave().click();
		driver.findElement(By.xpath("//span[contains(text(),'Test1')]")).click();
		String inactiveText = driver.findElement(By.xpath("//span[contains(text(),'Inactive')]")).getText();

		if (inactiveText.contains("Inactive")) {
			System.out.println("Repository status changed to inactive successfully");
		} else {
			System.out.println("Repository status not changed to inactive");
		}

		refresh();
		System.out.println("Changing the Inactive status to Active ");

		WebElement inactive1 = driver.findElement(By.xpath("//input[@id='activeRepository']"));
		inactive1.click();
		blank();

		System.out.println("changing the model name with no EA login");
		WebElement modelNme = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		modelNme.clear();
		blank();
		System.out.println("TC12 Check if the user can edit and disable the modal security");
		textFill(modelNme, "nosec");
		WebElement securityDisable = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityDisable.click();
		p.getRepoSave().click();
		waits();
		refresh();
		p.getRepoEdit().click();
		waits();
		WebElement disabledText = driver.findElement(By.xpath("//span[contains(text(),'Disabled')]"));
		System.out.println("Model Security : " + disabledText.getText());
		refresh();
		System.out.println("Successfully changed the Model name with no EA login");
		blank();
		System.out.println("TC11 Check if the proper error message is shown when incorrect PCS details are updated");
		System.out.println("Changing the disable to enable model security");
		WebElement securityDisable1 = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityDisable1.click();
		p.getRepoSave().click();
		blank();
		System.out.println("changing the model name with EA login");
		refresh();
		p.getRepoEdit().click();
		refresh();
		WebElement modelNme1 = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		modelNme1.clear();
		textFill(modelNme1, "demo1");
		blank();
		System.out.println(
				"TC13 Check if proper error message is shown when we edit and disable the modal security while modal requires it");
		System.out.println("Changing the Enable to Disable model security");
		WebElement securityEnable = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnable.click();
		p.getRepoSave().click();
		waits();
		WebElement errorMsg = driver.findElement(By.xpath(
				"//ngb-alert[text()=\"Security has been enabled in the EA repository. Toggle 'Model Security' and provide valid credentials.\"]"));
		System.out.println("Error Msg : " + errorMsg.getText());
		waits();
		System.out.println("TC15 Check if the proper error message is shown when incorrect EA user login is updated");
		System.out.println("Entering the incorrect EA login creds");
		WebElement securityEnable1 = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnable1.click();
		WebElement eaLogin = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		eaLogin.clear();
		textFill(eaLogin, "Incorrect");
		p.getRepoSave().click();
		String text3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//ngb-alert[text()='Invalid Login and/or Password! Please enter valid credentials']")))
				.getText();
		waits();
		System.out.println("Error Msg : " + text3);

		// refresh();

		quit();
		blank();
		System.out.println("**Test Successful**");
	}
}
