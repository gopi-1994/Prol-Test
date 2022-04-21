package org.test.pro.repo_listing;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC01_Repo_List extends BaseClass{
	
	@Test(enabled=true)
	public static void chrome() throws InterruptedException, IOException {
		
		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();
		
		//TC 01
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com" );// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button

		//TC01
		
		System.out.println("TC01 Check if the repositories page shows list of repsotories in which user have access");
		
		waits();
		WebElement table = driver.findElement(By.xpath("//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-management-page[1]/app-repository-management-list[1]/div[1]/div[2]/app-datatable[1]/div[1]/p-table[1]/div[1]/div[2]/table[1]"));
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			java.util.List<WebElement> headings = row.findElements(By.tagName("th"));
			for (int j = 0; j <headings.size(); j++) {
				WebElement head = headings.get(j);
				String texthead = head.getText();
				System.out.println(texthead);
			}
			
			java.util.List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(j);
				String textdata = data.getText();
				
				System.out.println(textdata);
			}
		}
	
		System.out.println("**Test Successful**");
		quit();
	}
	
	@Test(enabled = false)
	public static void firefox() throws InterruptedException, IOException {

		firefoxBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC 01
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com" );// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button

		//TC01
		
		System.out.println("TC01 Check if the repositories page shows list of repsotories in which user have access");
		
		waits();
		WebElement table = driver.findElement(By.xpath("//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-management-page[1]/app-repository-management-list[1]/div[1]/div[2]/app-datatable[1]/div[1]/p-table[1]/div[1]/div[2]/table[1]"));
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			java.util.List<WebElement> headings = row.findElements(By.tagName("th"));
			for (int j = 0; j <headings.size(); j++) {
				WebElement head = headings.get(j);
				String texthead = head.getText();
				System.out.println(texthead);
			}
			
			java.util.List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(j);
				String textdata = data.getText();
				
				System.out.println(textdata);
			}
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

		//TC 01
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com" );// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button

		//TC01
		
		System.out.println("TC01 Check if the repositories page shows list of repsotories in which user have access");
		
		waits();
		WebElement table = driver.findElement(By.xpath("//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-management-page[1]/app-repository-management-list[1]/div[1]/div[2]/app-datatable[1]/div[1]/p-table[1]/div[1]/div[2]/table[1]"));
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			java.util.List<WebElement> headings = row.findElements(By.tagName("th"));
			for (int j = 0; j <headings.size(); j++) {
				WebElement head = headings.get(j);
				String texthead = head.getText();
				System.out.println(texthead);
			}
			
			java.util.List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(j);
				String textdata = data.getText();
				
				System.out.println(textdata);
			}
		}
		
		blank();
		System.out.println("**Test Successful**");
		
	}

}
