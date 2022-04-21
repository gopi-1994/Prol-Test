package org.test.pro.repo_listing;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC35_Config_Menu extends BaseClass{
	
	@Test
	public static void chrome() throws InterruptedException, IOException {
		
		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();
		
		//TC35
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com" );// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		
		
		System.out.println("TC35 Check if the Repository configuration menu shows all the respective links for  admin users");
		waits();
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'Test2')]"));
		repo.click();
		sleep();
		WebElement menu = driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-bars fa-w-14']"));
		menu.click();
		waits();
		WebElement accessPermi = driver.findElement(By.xpath("//div[contains(text(),'Access Permissions')]"));
		accessPermi.click();
		sleep();
		screenshot("Access Permissions");
		backward();
		waits();
		refresh();
		sleep();
		WebElement menu1 = driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-bars fa-w-14']"));
		menu1.click();
		waits();
		WebElement modelingLang = driver.findElement(By.xpath("//div[contains(text(),' Modeling Languages')]"));
		modelingLang.click();
		sleep();
		screenshot("Modeling Languages");
		
		blank();
		System.out.println("**Test Successful**");
		
		
		quit();
	}
	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC35
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com" );// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		
		
		System.out.println("TC35 Check if the Repository configuration menu shows all the respective links for  admin users");
		waits();
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'Test2')]"));
		repo.click();
		sleep();
		WebElement menu = driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-bars fa-w-14']"));
		menu.click();
		waits();
		WebElement accessPermi = driver.findElement(By.xpath("//div[contains(text(),'Access Permissions')]"));
		accessPermi.click();
		sleep();
		screenshot("Access Permissions");
		backward();
		waits();
		refresh();
		sleep();
		WebElement menu1 = driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-bars fa-w-14']"));
		menu1.click();
		waits();
		WebElement modelingLang = driver.findElement(By.xpath("//div[contains(text(),' Modeling Languages')]"));
		modelingLang.click();
		sleep();
		screenshot("Modeling Languages");
		
		blank();
		System.out.println("**Test Successful**");
		
	}
	
	@Test(enabled = false)
	public static void edge() throws InterruptedException, IOException {

		edgeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC35
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com" );// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		
		
		System.out.println("TC35 Check if the Repository configuration menu shows all the respective links for  admin users");
		waits();
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'Test2')]"));
		repo.click();
		sleep();
		WebElement menu = driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-bars fa-w-14']"));
		menu.click();
		waits();
		WebElement accessPermi = driver.findElement(By.xpath("//div[contains(text(),'Access Permissions')]"));
		accessPermi.click();
		sleep();
		screenshot("Access Permissions");
		backward();
		waits();
		refresh();
		sleep();
		WebElement menu1 = driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-bars fa-w-14']"));
		menu1.click();
		waits();
		WebElement modelingLang = driver.findElement(By.xpath("//div[contains(text(),' Modeling Languages')]"));
		modelingLang.click();
		sleep();
		screenshot("Modeling Languages");
		
		blank();
		System.out.println("**Test Successful**");
		
	}



}

