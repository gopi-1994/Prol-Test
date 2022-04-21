package org.test.pro.repo_listing;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC10_Default_Label extends BaseClass{
	
	@Test(enabled=true)
	public static void chrome() throws InterruptedException, IOException {
		
		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();
		
		//TC 10
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com" );// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		
		System.out.println("TC10 Check if the Default label is shown with the repsoitory name when repository is made default");
		waits();
		WebElement more = driver.findElement(By.xpath("(//span[contains(text(),'More')])[1]"));
		more.click();
		WebElement defalt = driver.findElement(By.xpath("//span[contains(text(),'Make Default')]"));
		defalt.click();
		screenshot("Default Repo");
		waits();
		WebElement repoDefault = driver.findElement(By.xpath("(//span[contains(text(),'Default')])[2]"));
		String text = repoDefault.getText();
		Assert.assertEquals(text, "Default");
		System.out.println("**Test Successful**");
		quit();
	}
	
	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC 10
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com" );// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		
		System.out.println("TC10 Check if the Default label is shown with the repsoitory name when repository is made default");
		waits();
		WebElement more = driver.findElement(By.xpath("(//span[contains(text(),'More')])[1]"));
		more.click();
		WebElement defalt = driver.findElement(By.xpath("//span[contains(text(),'Make Default')]"));
		defalt.click();
		screenshot("Default Repo");
		waits();
		WebElement repoDefault = driver.findElement(By.xpath("(//span[contains(text(),'Default')])[2]"));
		String text = repoDefault.getText();
		Assert.assertEquals(text, "Default");
		
		blank();
		System.out.println("**Test Successful**");
		
	}
	
	@Test(enabled = false)
	public static void edge() throws InterruptedException, IOException {

		edgeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC 10
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com" );// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		
		System.out.println("TC10 Check if the Default label is shown with the repsoitory name when repository is made default");
		waits();
		WebElement more = driver.findElement(By.xpath("(//span[contains(text(),'More')])[1]"));
		more.click();
		WebElement defalt = driver.findElement(By.xpath("//span[contains(text(),'Make Default')]"));
		defalt.click();
		screenshot("Default Repo");
		waits();
		WebElement repoDefault = driver.findElement(By.xpath("(//span[contains(text(),'Default')])[2]"));
		String text = repoDefault.getText();
		Assert.assertEquals(text, "Default");
		
		blank();
		System.out.println("**Test Successful**");
		
	}


}
