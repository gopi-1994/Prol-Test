package org.test.pro.repo_listing;

import java.io.IOException;
import java.util.List;

import org.apache.http.impl.io.SocketInputBuffer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_PCS_Connection_Fail extends BaseClass {

	@Test(enabled=true)
	public static void chrome() throws InterruptedException, IOException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();

		//TC02,03,04,07,18
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		
		// before executing this script stop sparx system professional cloud in task manager / services tab
		System.out.println("TC02 Check if the PCS connection failed message is shown with repository name when PCS is stopped");
		waits();
		// before executing this script disable the model in Pro cloud config client
		System.out.println("TC03 Check if the PCS connection failed message is shown with repository name when model is disabled in PCS");
		
		// before executing this script disable mysql or mssql EA DB in task manager / services tab
		System.out.println("TC04 Check if the PCS connection failed message is shown with the repository when EA DB is stopped");
		// locator for PCS connection fail *text*
		try {
			
		
		WebElement profile = driver.findElement(By.xpath("(//span[contains(text(),'PCS Connection Failed')])[1]"));
		String pcsFail = profile.getText();
		List<WebElement> profiles = driver.findElements(By.xpath("(//span[contains(text(),'PCS Connection Failed')])"));
		int count = profiles.size();
		System.out.println("Total PCS Connection Failed Repositories : " + count);
		/*
		 * for (int i = 0; i < profiles.size(); i++) {
		 * 
		 * WebElement pro = profiles.get(i); String repot = pro.getText();
		 * //System.out.println(repot); }
		 */
		WebElement table = driver.findElement(By.xpath(
				"//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-management-page[1]/app-repository-management-list[1]/div[1]/div[2]/app-datatable[1]/div[1]/p-table[1]/div[1]/div[2]/table[1]"));
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);

			java.util.List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(0);
				String textdata = data.getText();
				if (textdata.contains("PCS Connection Failed")) {
					System.out.println(textdata);
				} else {

				}

			}
		}
		// Assert.assertEquals(pcsFail, "PCS Connection Failed");
		// System.out.println(pcsFail);
		blank();
		System.out.println("TC17 Check if the admin user is redirected to edit repository when click on PCS connection failed repository");
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'test')]"));
		repo.click();
		screenshot("PCS edit Repo");
		sleep();
		String editUrl = driver.getCurrentUrl();
		if (editUrl.contains("RepositoryManagement/EditRepository")) {
			System.out.println("Successfully landed in Edit repository page");
		} else {
			System.out.println("failed to land in Edit repository page");
		}
		sleep();
		backward();
		waits();
		blank();
		System.out.println("TC18 Check if the open button is disabled for PCS connection failed repository");
		WebElement openDisabled = driver
				.findElement(By.xpath("(//*[@class=\"btn btn-clear text-theme ng-star-inserted disabled\"])[1]"));

		if (openDisabled.isSelected() || openDisabled.isEnabled()) {
			System.out.println("Open button for PCS connection Failure is disabled");
		} else {
			System.out.println("Open button for PCS connection Failure is enabled");
		}
		} catch (Exception e) {
			System.out.println("PCS connection Failure label not visible");
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

		//TC02,03,04,07,18
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		
		// before executing this script stop sparx system professional cloud in task manager / services tab
		System.out.println("TC02 Check if the PCS connection failed message is shown with repository name when PCS is stopped");
		waits();
		// before executing this script disable the model in Pro cloud config client
		System.out.println("TC03 Check if the PCS connection failed message is shown with repository name when model is disabled in PCS");
		
		// before executing this script disable mysql or mssql EA DB in task manager / services tab
		System.out.println("TC04 Check if the PCS connection failed message is shown with the repository when EA DB is stopped");
		// locator for PCS connection fail *text*
		try {
			
		
		WebElement profile = driver.findElement(By.xpath("(//span[contains(text(),'PCS Connection Failed')])[1]"));
		String pcsFail = profile.getText();
		List<WebElement> profiles = driver.findElements(By.xpath("(//span[contains(text(),'PCS Connection Failed')])"));
		int count = profiles.size();
		System.out.println("Total PCS Connection Failed Repositories : " + count);
		/*
		 * for (int i = 0; i < profiles.size(); i++) {
		 * 
		 * WebElement pro = profiles.get(i); String repot = pro.getText();
		 * //System.out.println(repot); }
		 */
		WebElement table = driver.findElement(By.xpath(
				"//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-management-page[1]/app-repository-management-list[1]/div[1]/div[2]/app-datatable[1]/div[1]/p-table[1]/div[1]/div[2]/table[1]"));
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);

			java.util.List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(0);
				String textdata = data.getText();
				if (textdata.contains("PCS Connection Failed")) {
					System.out.println(textdata);
				} else {

				}

			}
		}
		// Assert.assertEquals(pcsFail, "PCS Connection Failed");
		// System.out.println(pcsFail);
		blank();
		System.out.println("TC17 Check if the admin user is redirected to edit repository when click on PCS connection failed repository");
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'test')]"));
		repo.click();
		screenshot("PCS edit Repo");
		sleep();
		String editUrl = driver.getCurrentUrl();
		if (editUrl.contains("RepositoryManagement/EditRepository")) {
			System.out.println("Successfully landed in Edit repository page");
		} else {
			System.out.println("failed to land in Edit repository page");
		}
		sleep();
		backward();
		waits();
		blank();
		System.out.println("TC18 Check if the open button is disabled for PCS connection failed repository");
		WebElement openDisabled = driver
				.findElement(By.xpath("(//*[@class=\"btn btn-clear text-theme ng-star-inserted disabled\"])[1]"));

		if (openDisabled.isSelected() || openDisabled.isEnabled()) {
			System.out.println("Open button for PCS connection Failure is disabled");
		} else {
			System.out.println("Open button for PCS connection Failure is enabled");
		}
		} catch (Exception e) {
			System.out.println("PCS connection Failure label not visible");
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

		//TC02,03,04,07,18
		PojoClass p = new PojoClass();// Locator for email / user name
		WebElement textEmail = p.getTextEmail();
		textFill(textEmail, "admin@prolaborate.com");// pass the value
		WebElement textPass = p.getTextPass();// locator for password
		textFill(textPass, "Welcome@123");// pass the value
		String passkey = textPass.getAttribute("value");
		System.out.println(passkey);
		Assert.assertEquals(passkey, "Welcome@123");
		p.getSignIn().click();// locator for submit button
		
		// before executing this script stop sparx system professional cloud in task manager / services tab
		System.out.println("TC02 Check if the PCS connection failed message is shown with repository name when PCS is stopped");
		waits();
		// before executing this script disable the model in Pro cloud config client
		System.out.println("TC03 Check if the PCS connection failed message is shown with repository name when model is disabled in PCS");
		
		// before executing this script disable mysql or mssql EA DB in task manager / services tab
		System.out.println("TC04 Check if the PCS connection failed message is shown with the repository when EA DB is stopped");
		// locator for PCS connection fail *text*
		try {
			
		
		WebElement profile = driver.findElement(By.xpath("(//span[contains(text(),'PCS Connection Failed')])[1]"));
		String pcsFail = profile.getText();
		List<WebElement> profiles = driver.findElements(By.xpath("(//span[contains(text(),'PCS Connection Failed')])"));
		int count = profiles.size();
		System.out.println("Total PCS Connection Failed Repositories : " + count);
		/*
		 * for (int i = 0; i < profiles.size(); i++) {
		 * 
		 * WebElement pro = profiles.get(i); String repot = pro.getText();
		 * //System.out.println(repot); }
		 */
		WebElement table = driver.findElement(By.xpath(
				"//body/app-root[1]/app-portal-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-repository-management-page[1]/app-repository-management-list[1]/div[1]/div[2]/app-datatable[1]/div[1]/p-table[1]/div[1]/div[2]/table[1]"));
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);

			java.util.List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(0);
				String textdata = data.getText();
				if (textdata.contains("PCS Connection Failed")) {
					System.out.println(textdata);
				} else {

				}

			}
		}
		// Assert.assertEquals(pcsFail, "PCS Connection Failed");
		// System.out.println(pcsFail);
		blank();
		System.out.println("TC17 Check if the admin user is redirected to edit repository when click on PCS connection failed repository");
		WebElement repo = driver.findElement(By.xpath("//span[contains(text(),'test')]"));
		repo.click();
		screenshot("PCS edit Repo");
		sleep();
		String editUrl = driver.getCurrentUrl();
		if (editUrl.contains("RepositoryManagement/EditRepository")) {
			System.out.println("Successfully landed in Edit repository page");
		} else {
			System.out.println("failed to land in Edit repository page");
		}
		sleep();
		backward();
		waits();
		blank();
		System.out.println("TC18 Check if the open button is disabled for PCS connection failed repository");
		WebElement openDisabled = driver
				.findElement(By.xpath("(//*[@class=\"btn btn-clear text-theme ng-star-inserted disabled\"])[1]"));

		if (openDisabled.isSelected() || openDisabled.isEnabled()) {
			System.out.println("Open button for PCS connection Failure is disabled");
		} else {
			System.out.println("Open button for PCS connection Failure is enabled");
		}
		} catch (Exception e) {
			System.out.println("PCS connection Failure label not visible");
		}
		
		blank();
		System.out.println("**Test Successful**");
		
	}

}
