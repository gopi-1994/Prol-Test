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

public class TC11_Without_EA_Modal extends BaseClass {

	@Test(enabled = true)
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();
		// TC 11,12.1,12.2, 13,17,18,19
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
		WebElement add = driver.findElement(By.xpath("//span[contains(text(),'Add Repository')]"));
		add.click();
		WebElement repoNme = driver.findElement(By.xpath("//input[@placeholder='Enter a suitable name']"));
		textFill(repoNme, "Test Demo");
		String repoValue = repoNme.getAttribute("value");
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sequrity = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)", sequrity);
		// WebElement protocol =
		// driver.findElement(By.xpath("((//div[@class='ng-input'])"));
		// protocol.click();
		// WebElement http =
		// driver.findElement(By.xpath("(//span[contains(text(),'http://')])[2]"));
		// http.click();
		WebElement server = driver.findElement(By.xpath("//input[@placeholder='Enter the Server DNS or IP address']"));
		textFill(server, "localhost");
		WebElement port = driver.findElement(By.xpath("//input[@placeholder='Enter the Port']"));
		textFill(port, "804");
		WebElement securityEnbl = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnbl.click();
		WebElement eaLogin = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		textFill(eaLogin, "Gopi");
		blank();
		System.out.println(
				"TC11 Check if the proper error message is shown when user tries to add repository without EA modal name");
		WebElement savebtn = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
		savebtn.click();
		WebElement modelBlank = driver
				.findElement(By.xpath("//span[contains(text(),'Model Name should not be blank')]"));
		System.out.println("Error Message :");
		getText(modelBlank);
		blank();
		System.out.println("TC12 Check if the proper error message is shown when the model name is incorrect");
		System.out.println("updating the incorrect model name");
		WebElement modelNme = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		textFill(modelNme, "Demo_modal");// updating the incorrect model name
		waits();
		doubleClick(savebtn);

		WebElement appServer = driver
				.findElement(By.xpath("//body/app-root[1]/app-portal-layout[1]/div[1]/app-alert[1]/p[1]/ngb-alert[1]"));
		System.out.println("Error Message :");
		getText(appServer);
		modelNme.clear();// clearing the value
		blank();
		System.out.println("Updating the Correct Modle name");
		textFill(modelNme, "demo1");
		getValue(modelNme);
		blank();
		System.out.println(
				"TC13 Check if the proper error message is shown when user tries to add repository with incorrect server name");
		server.clear();// clearing the value
		System.out.println("Updating the incorrect server name");
		textFill(server, "localhostt");// updating the incorrect server
		savebtn.click();
		WebElement alert2 = driver.findElement(By.xpath(
				"(//ngb-alert[contains(text(),'Invalid Pro Cloud Server details! Please check the details in the Application Server')])"));
		System.out.println("Error Message :");
		getText(alert2);
		blank();
		System.out.println(
				"TC12 Check if the proper error message is shown when user tries to add repository with incorrect protocol");
		System.out.println("Updating the correct server name");
		server.clear();
		textFill(server, "localhost");// updating the correct server
		System.out.println("Changing protocol from HTTP to HTTPS");
		WebElement protocol = driver.findElement(By.xpath(
				"//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-add-edit-page[1]/div[2]/app-repository-management-config-form[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/app-select[1]/ng-select[1]/div[1]/div[1]/div[3]"));
		protocol.click();
		WebElement https = driver.findElement(By.xpath("//span[contains(text(),'https://')]"));
		https.click();

		savebtn.click();
		waits();
		System.out.println("Error MSG: " + p.getInvalidPCS().getText());
		blank();
		waits();
		Thread.sleep(10000);
		protocol.click();
		System.out.println("TC17 Check if the proper error message is shown when the server name is not given");
		System.out.println("Changing protocol from HTTPS to HTTP");
		WebElement http = driver.findElement(By.xpath("//span[contains(text(),'http://')]"));
		http.click();
		sleep();
		doubleClick(server); // servername can be deleted in two ways
		sleep();
		backspace();
		String serverName = p.getServerName().getAttribute("value");
		if (serverName.isEmpty()) {
			System.out.println("Servername is blank");
		} else {
			System.out.println("server name : " + serverName);
		}

		// 1st method
		// server.clear(); // 2nd method
		// screenshot("Server name is Empty");
		// savebtn.click();
		// Thread.sleep(5000);
		// screenshot("Repository is created");
		WebElement clearServer = driver.findElement(By.xpath("//span[contains(text(),'Server should not be blank')]"));
		System.out.println("error MSG :");
		getText(clearServer);

		blank();
		savebtn.click();
		waits();
		System.out.println("TC18 Check if the proper error message is shown when the port is not given");
		System.out.println("updating correect server name");
		p.getServerName().sendKeys("localhost");
		doubleClick(port);
		delete();
		waits();
		WebElement porterror = driver.findElement(By.xpath("//span[contains(text(),'Port should not be blank')]"));
		System.out.println("Error MSG : " + porterror.getText());
		sleep();

		blank();
		System.out.println("TC19 Check if the proper error message is shown when the port is incorrect");
		System.out.println("updating incorrect port no");
		p.getPortNo().sendKeys("123");
		p.getRepoSave().click();
		waits();
		System.out.println("error MSG : " + p.getInvalidPCS().getText());
		sleep();

		blank();
		System.out.println("**Test Successful**");

	}

	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException, AWTException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		// TC 11,12.1,12.2, 13,17
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
		WebElement add = driver.findElement(By.xpath("//span[contains(text(),'Add Repository')]"));
		add.click();
		WebElement repoNme = driver.findElement(By.xpath("//input[@placeholder='Enter a suitable name']"));
		textFill(repoNme, "Test Demo");
		String repoValue = repoNme.getAttribute("value");
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sequrity = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)", sequrity);
		// WebElement protocol =
		// driver.findElement(By.xpath("((//div[@class='ng-input'])"));
		// protocol.click();
		// WebElement http =
		// driver.findElement(By.xpath("(//span[contains(text(),'http://')])[2]"));
		// http.click();
		WebElement server = driver.findElement(By.xpath("//input[@placeholder='Enter the Server DNS or IP address']"));
		textFill(server, "localhost");
		WebElement port = driver.findElement(By.xpath("//input[@placeholder='Enter the Port']"));
		textFill(port, "804");
		WebElement securityEnbl = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnbl.click();
		WebElement eaLogin = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		textFill(eaLogin, "Gopi");
		blank();
		System.out.println(
				"TC11 Check if the proper error message is shown when user tries to add repository without EA modal name");
		WebElement savebtn = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
		savebtn.click();
		WebElement modelBlank = driver
				.findElement(By.xpath("//span[contains(text(),'Model Name should not be blank')]"));
		System.out.println("Error Message :");
		getText(modelBlank);
		blank();
		System.out.println("TC12 Check if the proper error message is shown when the model name is incorrect");
		System.out.println("updating the incorrect model name");
		WebElement modelNme = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		textFill(modelNme, "Demo_modal");// updating the incorrect model name
		waits();
		doubleClick(savebtn);

		WebElement appServer = driver
				.findElement(By.xpath("//body/app-root[1]/app-portal-layout[1]/div[1]/app-alert[1]/p[1]/ngb-alert[1]"));
		System.out.println("Error Message :");
		getText(appServer);
		modelNme.clear();// clearing the value
		blank();
		System.out.println("Updating the Correct Modle name");
		textFill(modelNme, "demo1");
		getValue(modelNme);
		blank();
		System.out.println(
				"TC13 Check if the proper error message is shown when user tries to add repository with incorrect server name");
		server.clear();// clearing the value
		System.out.println("Updating the incorrect server name");
		textFill(server, "localhostt");// updating the incorrect server
		savebtn.click();
		WebElement alert2 = driver.findElement(By.xpath(
				"(//ngb-alert[contains(text(),'Invalid Pro Cloud Server details! Please check the details in the Application Server')])"));
		System.out.println("Error Message :");
		getText(alert2);
		blank();
		System.out.println(
				"TC12 Check if the proper error message is shown when user tries to add repository with incorrect protocol");
		System.out.println("Updating the correct server name");
		server.clear();
		textFill(server, "localhost");// updating the correct server
		System.out.println("Changing protocol from HTTP to HTTPS");
		WebElement protocol = driver.findElement(By.xpath(
				"//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-add-edit-page[1]/div[2]/app-repository-management-config-form[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/app-select[1]/ng-select[1]/div[1]/div[1]/div[3]"));
		protocol.click();
		WebElement https = driver.findElement(By.xpath("//span[contains(text(),'https://')]"));
		https.click();

		savebtn.click();
		waits();
		System.out.println("Error MSG: " + p.getInvalidPCS().getText());
		blank();
		waits();
		Thread.sleep(10000);
		protocol.click();
		System.out.println("TC17 Check if the proper error message is shown when the server name is not given");
		System.out.println("Changing protocol from HTTPS to HTTP");
		WebElement http = driver.findElement(By.xpath("//span[contains(text(),'http://')]"));
		http.click();
		sleep();
		doubleClick(server); // servername can be deleted in two ways
		sleep();
		delete();
		backspace();
		String serverName = p.getServerName().getAttribute("value");
		if (serverName.isEmpty()) {
			System.out.println("Servername is blank");
		} else {
			System.out.println("server name : " + serverName);
		}

		// 1st method
		// server.clear(); // 2nd method
		// screenshot("Server name is Empty");
		// savebtn.click();
		// Thread.sleep(5000);
		// screenshot("Repository is created");
		WebElement clearServer = driver.findElement(By.xpath("//span[contains(text(),'Server should not be blank')]"));
		System.out.println("error MSG :");
		getText(clearServer);

		blank();
		savebtn.click();
		waits();
		System.out.println("TC18 Check if the proper error message is shown when the port is not given");
		System.out.println("updating correect server name");
		p.getServerName().sendKeys("localhost");
		sleep();
		doubleClick(port);
		selectAll();
		delete();
		waits();
		WebElement porterror = driver.findElement(By.xpath("//span[contains(text(),'Port should not be blank')]"));
		System.out.println("Error MSG : " + porterror.getText());
		sleep();

		blank();
		System.out.println("TC19 Check if the proper error message is shown when the port is incorrect");
		System.out.println("updating incorrect port no");
		p.getPortNo().sendKeys("123");
		p.getRepoSave().click();
		waits();
		System.out.println("error MSG : " + p.getInvalidPCS().getText());
		sleep();

		blank();
		System.out.println("**Test Successful**");

	}

	@Test(enabled = false)
	public static void edge() throws InterruptedException, IOException, AWTException {

		edgeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		// TC 11,12.1,12.2, 13,17
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
		WebElement add = driver.findElement(By.xpath("//span[contains(text(),'Add Repository')]"));
		add.click();
		WebElement repoNme = driver.findElement(By.xpath("//input[@placeholder='Enter a suitable name']"));
		textFill(repoNme, "Test Demo");
		String repoValue = repoNme.getAttribute("value");
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sequrity = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)", sequrity);
		// WebElement protocol =
		// driver.findElement(By.xpath("((//div[@class='ng-input'])"));
		// protocol.click();
		// WebElement http =
		// driver.findElement(By.xpath("(//span[contains(text(),'http://')])[2]"));
		// http.click();
		WebElement server = driver.findElement(By.xpath("//input[@placeholder='Enter the Server DNS or IP address']"));
		textFill(server, "localhost");
		WebElement port = driver.findElement(By.xpath("//input[@placeholder='Enter the Port']"));
		textFill(port, "804");
		WebElement securityEnbl = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnbl.click();
		WebElement eaLogin = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		textFill(eaLogin, "Gopi");
		blank();
		System.out.println(
				"TC11 Check if the proper error message is shown when user tries to add repository without EA modal name");
		WebElement savebtn = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
		savebtn.click();
		WebElement modelBlank = driver
				.findElement(By.xpath("//span[contains(text(),'Model Name should not be blank')]"));
		System.out.println("Error Message :");
		getText(modelBlank);
		blank();
		System.out.println("TC12 Check if the proper error message is shown when the model name is incorrect");
		System.out.println("updating the incorrect model name");
		WebElement modelNme = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		textFill(modelNme, "Demo_modal");// updating the incorrect model name
		waits();
		doubleClick(savebtn);

		WebElement appServer = driver
				.findElement(By.xpath("//body/app-root[1]/app-portal-layout[1]/div[1]/app-alert[1]/p[1]/ngb-alert[1]"));
		System.out.println("Error Message :");
		getText(appServer);
		modelNme.clear();// clearing the value
		blank();
		System.out.println("Updating the Correct Modle name");
		textFill(modelNme, "demo1");
		getValue(modelNme);
		blank();
		System.out.println(
				"TC13 Check if the proper error message is shown when user tries to add repository with incorrect server name");
		server.clear();// clearing the value
		System.out.println("Updating the incorrect server name");
		textFill(server, "localhostt");// updating the incorrect server
		savebtn.click();
		WebElement alert2 = driver.findElement(By.xpath(
				"(//ngb-alert[contains(text(),'Invalid Pro Cloud Server details! Please check the details in the Application Server')])"));
		System.out.println("Error Message :");
		getText(alert2);
		blank();
		System.out.println(
				"TC12 Check if the proper error message is shown when user tries to add repository with incorrect protocol");
		System.out.println("Updating the correct server name");
		server.clear();
		textFill(server, "localhost");// updating the correct server
		System.out.println("Changing protocol from HTTP to HTTPS");
		WebElement protocol = driver.findElement(By.xpath(
				"//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-add-edit-page[1]/div[2]/app-repository-management-config-form[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/app-select[1]/ng-select[1]/div[1]/div[1]/div[3]"));
		protocol.click();
		WebElement https = driver.findElement(By.xpath("//span[contains(text(),'https://')]"));
		https.click();

		savebtn.click();
		waits();
		System.out.println("Error MSG: " + p.getInvalidPCS().getText());
		blank();
		waits();
		Thread.sleep(10000);
		protocol.click();
		System.out.println("TC17 Check if the proper error message is shown when the server name is not given");
		System.out.println("Changing protocol from HTTPS to HTTP");
		WebElement http = driver.findElement(By.xpath("//span[contains(text(),'http://')]"));
		http.click();
		sleep();
		doubleClick(server); // servername can be deleted in two ways
		sleep();
		backspace();
		String serverName = p.getServerName().getAttribute("value");
		if (serverName.isEmpty()) {
			System.out.println("Servername is blank");
		} else {
			System.out.println("server name : " + serverName);
		}

		// 1st method
		// server.clear(); // 2nd method
		// screenshot("Server name is Empty");
		// savebtn.click();
		// Thread.sleep(5000);
		// screenshot("Repository is created");
		WebElement clearServer = driver.findElement(By.xpath("//span[contains(text(),'Server should not be blank')]"));
		System.out.println("error MSG :");
		getText(clearServer);

		blank();
		savebtn.click();
		waits();
		System.out.println("TC18 Check if the proper error message is shown when the port is not given");
		System.out.println("updating correect server name");
		p.getServerName().sendKeys("localhost");
		doubleClick(port);
		delete();
		waits();
		WebElement porterror = driver.findElement(By.xpath("//span[contains(text(),'Port should not be blank')]"));
		System.out.println("Error MSG : " + porterror.getText());
		sleep();

		blank();
		System.out.println("TC19 Check if the proper error message is shown when the port is incorrect");
		System.out.println("updating incorrect port no");
		p.getPortNo().sendKeys("123");
		p.getRepoSave().click();
		waits();
		System.out.println("error MSG : " + p.getInvalidPCS().getText());
		sleep();

		blank();
		System.out.println("**Test Successful**");

	}
}
