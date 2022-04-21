package org.test.pro.copy_repository;

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

public class TC01_Copy_Option_visible extends BaseClass {

	@Test
	public static void chrome() throws InterruptedException, IOException, AWTException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/Account/Login");// get the URL
		maxWindows();
		waits();
		System.out.println("Testing in Chrome Browser");

		// TC01,02,03,04,05,06,07,08

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
		System.out.println("TC01 Check if the option is visible  to the Admin user");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		p.getMore1().click();//clicking more option
		WebElement copy = driver.findElement(By.xpath("//span[contains(text(),'Copy')]"));
		String copyText = copy.getText();
		Assert.assertEquals(copyText, "Copy");
		System.out.println("Copy option is visible for Admin user");
		
		p.getProfileIcon().click();
		p.getSignout().click();
		System.out.println("TC02 Check if the copy option is not visible to the non-admin users");
		System.out.println("Switching to Non admin user");
		
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();
		waits();
		
		p.getMore1().click();
		try {
			boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).isDisplayed();
			
		} catch (Exception e) {
			System.out.println("Copy option is not available for non Admin user");
		}
		p.getProfileIcon().click();
		p.getSignout().click();
		blank();
		System.out.println("TC 03: copy repository form brings all Repository Information");
		System.out.println("Switching to admin user");
		p.getTextEmail().sendKeys("admin@prolaborate.com");
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();
		
		p.getRepoEdit().click();
		String repoName = p.getReponame().getAttribute("value");
		String aliasName = p.getAliasName().getAttribute("value");
		String desc = p.getRepoDescription().getAttribute("value");
		String modelName = p.getModelName().getAttribute("value");
		String protocolName = p.getProtocolName().getText();
		String serverName = p.getServerName().getAttribute("value");
		String portNo = p.getPortNo().getAttribute("value");
		String status = p.getStatusActive().getText();
		String eaLogin = p.getEaLogin().getAttribute("value");
		p.getProlabHeaderIcon().click();
		p.getMore1().click();
		System.out.println("Copying the Repository");
		driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).click();
		String repoNamecp = p.getReponame().getAttribute("value");
		
		String aliasNamecp = p.getAliasName().getAttribute("value");
		
		String desccp = p.getRepoDescription().getAttribute("value");
		String modelNamecp = p.getModelName().getAttribute("value");
		String protocolNamecp = p.getProtocolName().getText();
		String serverNamecp = p.getServerName().getAttribute("value");
		String portNocp = p.getPortNo().getAttribute("value");
		String statuscp = p.getStatusActive().getText();
		String eaLogincp = p.getEaLogin().getAttribute("value");
		//verifying RepoName
		if (repoNamecp.contains(repoName)) {
			System.out.println("Repository name is same as the original : "+repoNamecp);
		} else {
			System.out.println("Repository name is not same as the original : "+repoNamecp);
		}
		
		if (aliasNamecp.contains(aliasName)) {
			System.out.println("Alias name is same as the original : "+aliasNamecp);
		} else {
			System.out.println("Alias name is not same as the original : "+aliasNamecp);
		}
		if (desccp.contains(desc)) {
			System.out.println("Description is same as the original : "+desccp);
		} else {
			System.out.println("Description is not same as the original : "+desccp);
		}
		blank();
		System.out.println("TC 04 : Check if the Copy is added as sufix to the Repository Name and Alias name ");
		if (repoNamecp.contains("Copy")) {
			System.out.println("Repository name contains Copy as sufix : "+repoNamecp);
		} else {
			System.out.println("Repository name does not contains Copy as sufix : "+repoNamecp);
		}

		if (aliasNamecp.contains("copy")) {
			System.out.println("Alias name contains copy as sufix : "+aliasNamecp);
		} else {
			System.out.println("Alias name does not contains Copy as sufix : "+aliasNamecp);
		}
		blank();
		System.out.println("TC 05: Check if the Pro Cloud Server details are retained properly");
		if (modelNamecp.equals(modelName)) {
			System.out.println("Model name is same as the original : "+modelNamecp);
		} else {
			System.out.println("Model name is not same as the original : "+modelNamecp);
		}
		if (protocolNamecp.equals(protocolName)) {
			System.out.println("Protocol is same as the original : "+protocolNamecp);
		} else {
			System.out.println("Protocol is not same as the original : "+protocolNamecp);
		}
		if (serverNamecp.equals(serverName)) {
			System.out.println("Server name is same as the original : "+serverNamecp);
		} else {
			System.out.println("Server name is not same as the original : "+serverNamecp);
		}		
		if (portNocp.equals(portNo)) {
			System.out.println("Port No is same as the original : "+portNocp);
		} else {
			System.out.println("Port No is not same as the original : "+portNocp);
		}
		if (statuscp.equals(status)) {
			System.out.println("Status is same as the original : "+statuscp);
		} else {
			System.out.println("Status is not same as the original : "+statuscp);
		}
		blank();
		System.out.println("TC 06 : Check if the Model Security information are retained properly");
		if (eaLogincp.equals(eaLogin)) {
			System.out.println("EA login is same as the original : "+eaLogincp);
		} else {
			System.out.println("EA login is not same as the original : "+eaLogincp);
		}
		
		p.getRepoSave().click();
		waits();
		blank();
		System.out.println("TC 07 : Check if the proper message is shown in success modal dialog when we copy and save the repository");
		WebElement copySuccess = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		String text = copySuccess.getText();
		System.out.println("Success Msg : "+text);
		
		blank();
		System.out.println("TC 08 : Check if the sections page is shown when click on manual config in repository copied Success modal dialog");
		p.getManualConfig().click();
		waits();
		WebElement sectionManual = driver.findElement(By.xpath("(//span[contains(text(),'Sections')])[2]"));
		String sectionText = sectionManual.getText();
		String title = driver.getTitle();
		
		if (title.contains("Sections")) {
			System.out.println("landed in sections page, page title is : "+title);
		} else {
			System.out.println("not landed in sections page, page title is : "+title);
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

		// TC01,02,03,04,05,06,07,08

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
		System.out.println("TC01 Check if the option is visible  to the Admin user");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		p.getMore1().click();//clicking more option
		WebElement copy = driver.findElement(By.xpath("//span[contains(text(),'Copy')]"));
		String copyText = copy.getText();
		Assert.assertEquals(copyText, "Copy");
		System.out.println("Copy option is visible for Admin user");
		
		p.getProfileIcon().click();
		p.getSignout().click();
		System.out.println("TC02 Check if the copy option is not visible to the non-admin users");
		System.out.println("Switching to Non admin user");
		
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();
		waits();
		
		p.getMore1().click();
		try {
			boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).isDisplayed();
			
		} catch (Exception e) {
			System.out.println("Copy option is not available for non Admin user");
		}
		p.getProfileIcon().click();
		p.getSignout().click();
		blank();
		System.out.println("TC 03: copy repository form brings all Repository Information");
		System.out.println("Switching to admin user");
		p.getTextEmail().sendKeys("admin@prolaborate.com");
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();
		
		p.getRepoEdit().click();
		String repoName = p.getReponame().getAttribute("value");
		String aliasName = p.getAliasName().getAttribute("value");
		String desc = p.getRepoDescription().getAttribute("value");
		String modelName = p.getModelName().getAttribute("value");
		String protocolName = p.getProtocolName().getText();
		String serverName = p.getServerName().getAttribute("value");
		String portNo = p.getPortNo().getAttribute("value");
		String status = p.getStatusActive().getText();
		String eaLogin = p.getEaLogin().getAttribute("value");
		p.getProlabHeaderIcon().click();
		p.getMore1().click();
		System.out.println("Copying the Repository");
		driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).click();
		String repoNamecp = p.getReponame().getAttribute("value");
		
		String aliasNamecp = p.getAliasName().getAttribute("value");
		
		String desccp = p.getRepoDescription().getAttribute("value");
		String modelNamecp = p.getModelName().getAttribute("value");
		String protocolNamecp = p.getProtocolName().getText();
		String serverNamecp = p.getServerName().getAttribute("value");
		String portNocp = p.getPortNo().getAttribute("value");
		String statuscp = p.getStatusActive().getText();
		String eaLogincp = p.getEaLogin().getAttribute("value");
		//verifying RepoName
		if (repoNamecp.contains(repoName)) {
			System.out.println("Repository name is same as the original : "+repoNamecp);
		} else {
			System.out.println("Repository name is not same as the original : "+repoNamecp);
		}
		
		if (aliasNamecp.contains(aliasName)) {
			System.out.println("Alias name is same as the original : "+aliasNamecp);
		} else {
			System.out.println("Alias name is not same as the original : "+aliasNamecp);
		}
		if (desccp.contains(desc)) {
			System.out.println("Description is same as the original : "+desccp);
		} else {
			System.out.println("Description is not same as the original : "+desccp);
		}
		blank();
		System.out.println("TC 04 : Check if the Copy is added as sufix to the Repository Name and Alias name ");
		if (repoNamecp.contains("Copy")) {
			System.out.println("Repository name contains Copy as sufix : "+repoNamecp);
		} else {
			System.out.println("Repository name does not contains Copy as sufix : "+repoNamecp);
		}

		if (aliasNamecp.contains("copy")) {
			System.out.println("Alias name contains copy as sufix : "+aliasNamecp);
		} else {
			System.out.println("Alias name does not contains Copy as sufix : "+aliasNamecp);
		}
		blank();
		System.out.println("TC 05: Check if the Pro Cloud Server details are retained properly");
		if (modelNamecp.equals(modelName)) {
			System.out.println("Model name is same as the original : "+modelNamecp);
		} else {
			System.out.println("Model name is not same as the original : "+modelNamecp);
		}
		if (protocolNamecp.equals(protocolName)) {
			System.out.println("Protocol is same as the original : "+protocolNamecp);
		} else {
			System.out.println("Protocol is not same as the original : "+protocolNamecp);
		}
		if (serverNamecp.equals(serverName)) {
			System.out.println("Server name is same as the original : "+serverNamecp);
		} else {
			System.out.println("Server name is not same as the original : "+serverNamecp);
		}		
		if (portNocp.equals(portNo)) {
			System.out.println("Port No is same as the original : "+portNocp);
		} else {
			System.out.println("Port No is not same as the original : "+portNocp);
		}
		if (statuscp.equals(status)) {
			System.out.println("Status is same as the original : "+statuscp);
		} else {
			System.out.println("Status is not same as the original : "+statuscp);
		}
		blank();
		System.out.println("TC 06 : Check if the Model Security information are retained properly");
		if (eaLogincp.equals(eaLogin)) {
			System.out.println("EA login is same as the original : "+eaLogincp);
		} else {
			System.out.println("EA login is not same as the original : "+eaLogincp);
		}
		
		p.getRepoSave().click();
		waits();
		blank();
		System.out.println("TC 07 : Check if the proper message is shown in success modal dialog when we copy and save the repository");
		WebElement copySuccess = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		String text = copySuccess.getText();
		System.out.println("Success Msg : "+text);
		
		blank();
		System.out.println("TC 08 : Check if the sections page is shown when click on manual config in repository copied Success modal dialog");
		p.getManualConfig().click();
		waits();
		WebElement sectionManual = driver.findElement(By.xpath("(//span[contains(text(),'Sections')])[2]"));
		String sectionText = sectionManual.getText();
		String title = driver.getTitle();
		
		if (title.contains("Sections")) {
			System.out.println("landed in sections page, page title is : "+title);
		} else {
			System.out.println("not landed in sections page, page title is : "+title);
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

		// TC01,02,03,04,05,06,07,08

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
		System.out.println("TC01 Check if the option is visible  to the Admin user");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		p.getMore1().click();//clicking more option
		WebElement copy = driver.findElement(By.xpath("//span[contains(text(),'Copy')]"));
		String copyText = copy.getText();
		Assert.assertEquals(copyText, "Copy");
		System.out.println("Copy option is visible for Admin user");
		
		p.getProfileIcon().click();
		p.getSignout().click();
		System.out.println("TC02 Check if the copy option is not visible to the non-admin users");
		System.out.println("Switching to Non admin user");
		
		p.getTextEmail().sendKeys("test@email.com");
		p.getTextPass().sendKeys("Abcd@1234");
		p.getSignIn().click();
		waits();
		
		p.getMore1().click();
		try {
			boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).isDisplayed();
			
		} catch (Exception e) {
			System.out.println("Copy option is not available for non Admin user");
		}
		p.getProfileIcon().click();
		p.getSignout().click();
		blank();
		System.out.println("TC 03: copy repository form brings all Repository Information");
		System.out.println("Switching to admin user");
		p.getTextEmail().sendKeys("admin@prolaborate.com");
		p.getTextPass().sendKeys("Welcome@123");
		p.getSignIn().click();
		
		p.getRepoEdit().click();
		String repoName = p.getReponame().getAttribute("value");
		String aliasName = p.getAliasName().getAttribute("value");
		String desc = p.getRepoDescription().getAttribute("value");
		String modelName = p.getModelName().getAttribute("value");
		String protocolName = p.getProtocolName().getText();
		String serverName = p.getServerName().getAttribute("value");
		String portNo = p.getPortNo().getAttribute("value");
		String status = p.getStatusActive().getText();
		String eaLogin = p.getEaLogin().getAttribute("value");
		p.getProlabHeaderIcon().click();
		p.getMore1().click();
		System.out.println("Copying the Repository");
		driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).click();
		String repoNamecp = p.getReponame().getAttribute("value");
		
		String aliasNamecp = p.getAliasName().getAttribute("value");
		
		String desccp = p.getRepoDescription().getAttribute("value");
		String modelNamecp = p.getModelName().getAttribute("value");
		String protocolNamecp = p.getProtocolName().getText();
		String serverNamecp = p.getServerName().getAttribute("value");
		String portNocp = p.getPortNo().getAttribute("value");
		String statuscp = p.getStatusActive().getText();
		String eaLogincp = p.getEaLogin().getAttribute("value");
		//verifying RepoName
		if (repoNamecp.contains(repoName)) {
			System.out.println("Repository name is same as the original : "+repoNamecp);
		} else {
			System.out.println("Repository name is not same as the original : "+repoNamecp);
		}
		
		if (aliasNamecp.contains(aliasName)) {
			System.out.println("Alias name is same as the original : "+aliasNamecp);
		} else {
			System.out.println("Alias name is not same as the original : "+aliasNamecp);
		}
		if (desccp.contains(desc)) {
			System.out.println("Description is same as the original : "+desccp);
		} else {
			System.out.println("Description is not same as the original : "+desccp);
		}
		blank();
		System.out.println("TC 04 : Check if the Copy is added as sufix to the Repository Name and Alias name ");
		if (repoNamecp.contains("Copy")) {
			System.out.println("Repository name contains Copy as sufix : "+repoNamecp);
		} else {
			System.out.println("Repository name does not contains Copy as sufix : "+repoNamecp);
		}

		if (aliasNamecp.contains("copy")) {
			System.out.println("Alias name contains copy as sufix : "+aliasNamecp);
		} else {
			System.out.println("Alias name does not contains Copy as sufix : "+aliasNamecp);
		}
		blank();
		System.out.println("TC 05: Check if the Pro Cloud Server details are retained properly");
		if (modelNamecp.equals(modelName)) {
			System.out.println("Model name is same as the original : "+modelNamecp);
		} else {
			System.out.println("Model name is not same as the original : "+modelNamecp);
		}
		if (protocolNamecp.equals(protocolName)) {
			System.out.println("Protocol is same as the original : "+protocolNamecp);
		} else {
			System.out.println("Protocol is not same as the original : "+protocolNamecp);
		}
		if (serverNamecp.equals(serverName)) {
			System.out.println("Server name is same as the original : "+serverNamecp);
		} else {
			System.out.println("Server name is not same as the original : "+serverNamecp);
		}		
		if (portNocp.equals(portNo)) {
			System.out.println("Port No is same as the original : "+portNocp);
		} else {
			System.out.println("Port No is not same as the original : "+portNocp);
		}
		if (statuscp.equals(status)) {
			System.out.println("Status is same as the original : "+statuscp);
		} else {
			System.out.println("Status is not same as the original : "+statuscp);
		}
		blank();
		System.out.println("TC 06 : Check if the Model Security information are retained properly");
		if (eaLogincp.equals(eaLogin)) {
			System.out.println("EA login is same as the original : "+eaLogincp);
		} else {
			System.out.println("EA login is not same as the original : "+eaLogincp);
		}
		
		p.getRepoSave().click();
		waits();
		blank();
		System.out.println("TC 07 : Check if the proper message is shown in success modal dialog when we copy and save the repository");
		WebElement copySuccess = driver.findElement(By.xpath("//span[contains(text(),'Repository Added Successfully')]"));
		String text = copySuccess.getText();
		System.out.println("Success Msg : "+text);
		
		blank();
		System.out.println("TC 08 : Check if the sections page is shown when click on manual config in repository copied Success modal dialog");
		p.getManualConfig().click();
		waits();
		WebElement sectionManual = driver.findElement(By.xpath("(//span[contains(text(),'Sections')])[2]"));
		String sectionText = sectionManual.getText();
		String title = driver.getTitle();
		
		if (title.contains("Sections")) {
			System.out.println("landed in sections page, page title is : "+title);
		} else {
			System.out.println("not landed in sections page, page title is : "+title);
		}

		quit();
		blank();
		System.out.println("**Test Successful**");
	}
}
