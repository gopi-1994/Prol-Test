package org.test.pro.add_new_repo;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.test.prolaborate.baseclass.BaseClass;
import org.test.prolaborate.baseclass.PojoClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_Create_Repo_Descrip extends BaseClass {
	@Test
	public static void chrome() throws InterruptedException, IOException {

		chromeBrowser();// set up the browser driver
		launchURL("http://localhost/RepositoryManagement/List");// get the URL
		maxWindows();
		waits();
//TC 07,08,09,10
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
		boolean display = add.isDisplayed();
		System.out.println("Add Repository Option is visible : " + display);
		add.click();
		
		WebElement save = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
		save.click();
		WebElement repoNme = driver.findElement(By.xpath("//input[@placeholder='Enter a suitable name']"));
		textFill(repoNme, "Test_Model");
		String repoValue = repoNme.getAttribute("value");
		WebElement aliasNme = driver.findElement(By.xpath("//input[@placeholder='Enter Alias Name']"));
		getValue(aliasNme);
		WebElement inactive = driver.findElement(By.xpath("//input[@id='activeRepository']"));
		inactive.click();
		
		System.out.println("TC07 Check if the user can add repostory without description");
		WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Give a summary of this repository to your users (Optional)']"));
		//for large description Dummy paragraph is used 
//		textFill(description, "Both versions convey a topic; it’s pretty easy to predict that the paragraph will be about epidemiological evidence, but only the second version establishes an argumentative point and puts it in context. The paragraph doesn’t just describe the epidemiological evidence; it shows how epidemiology is telling the same story as etiology. Similarly, while Version A doesn’t relate to anything in particular, Version B immediately suggests that the prior paragraph addresses the biological pathway (i.e. etiology) of a disease and that the new paragraph will bolster the emerging hypothesis with a different kind of evidence. As a reader, it’s easy to keep track of how the paragraph about cells and chemicals and such relates to the paragraph about populations in different places.\r\n" + 
//				"\r\n" + 
//				"A last thing to note about key sentences is that academic readers expect them to be at the beginning of the paragraph. (The first sentence this paragraph is a good example of this in action!) This placement helps readers comprehend your argument. To see how, try this: find an academic piece (such as a textbook or scholarly article) that strikes you as well written and go through part of it reading just the first sentence of each paragraph. You should be able to easily follow the sequence of logic. When you’re writing for professors, it is especially effective to put your key sentences first because they usually convey your own original thinking. It’s a very good sign when your paragraphs are typically composed of a telling key sentence followed by evidence and explanation.\r\n" + 
//				"\r\n" + 
//				"Knowing this convention of academic writing can help you both read and write more effectively. When you’re reading a complicated academic piece for the first time, you might want to go through reading only the first sentence or two of each paragraph to get the overall outline of the argument. Then you can go back and read all of it with a clearer picture of how each of the details fit in. And when you’re writing, you may also find it useful to write the first sentence of each paragraph (instead of a topic-based outline) to map out a thorough argument before getting immersed in sentence-level wordsmithing.");
//		
		System.out.println("description : "+description.getAttribute("value"));
		WebElement modelNme = driver.findElement(By.xpath("//input[@placeholder='Enter the Model Name']"));
		textFill(modelNme, "demo1");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sequrity = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)",sequrity );
		//WebElement protocol = driver.findElement(By.xpath("((//div[@class='ng-input'])"));
		//protocol.click();
		//WebElement http = driver.findElement(By.xpath("(//span[contains(text(),'http://')])[2]"));
		//http.click();
		WebElement server = driver.findElement(By.xpath("//input[@placeholder='Enter the Server DNS or IP address']"));
		textFill(server, "localhost");
		WebElement port = driver.findElement(By.xpath("//input[@placeholder='Enter the Port']"));
		textFill(port, "804");
		WebElement securityEnbl = driver.findElement(By.xpath("//input[@id='enableRequiredAuthendication']"));
		securityEnbl.click();
		WebElement eaLogin = driver.findElement(By.xpath("//input[@placeholder='Enter Login of an EA user']"));
		textFill(eaLogin, "Gopi");
		WebElement savebtn = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
		savebtn.click();
		sleep();
		blank();
		System.out.println("TC10 Check if the user can add repository with inactive status");
		WebElement inactiveTab = driver.findElement(By.xpath("//span[contains(text(),'Repository is Inactive')]"));
		System.out.println("MSG : "+inactiveTab.getText());
		WebElement close = driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
		close.click();
		WebElement test2 = driver.findElement(By.xpath("(//span[contains(text(),'Test_Model')])[1]"));
		test2.click();
		WebElement verify = driver.findElement(By.xpath("(//span[contains(text(),'Inactive')])[1]"));
		String text = verify.getText();
		
		if (text.contains("Inactive")) {
			System.out.println(repoValue+" repository is Inactive");
			
		} else {
			System.out.println(repoValue+" repository is active");

		}
		refresh();
		blank();
		
		System.out.println("TC08 Check if the user can add repository with large content in the description");
		p.getRepoDescription().sendKeys("To find out how fast you type, just start typing in the blank textbox on the right of the test prompt. You will see your progress, including errors on the left side as you type.\r\n" + 
				"\r\n" + 
				"You can fix errors as you go, or correct them at the end with the help of the spell checker. If you need to restart the test, delete the text in the text box. Interactive feedback shows you your current wpm and accuracy.\r\n" + 
				"\r\n" + 
				"In order to complete the test and share your results, you need to get 100% accuracy. You can review your progress for this session with the feedback chart below. Just hover over a dot to see what your average speed and accuracy are for that key.");
		String desc = p.getRepoDescription().getAttribute("value");
		if (desc.isEmpty()) {
			System.out.println("Description is Empty");
		} else {
			System.out.println("Large Description is given");
		}
		blank();
		System.out.println("TC09 Check if the user can add repository with Active status");
		p.getStatusBtn().click();
		String status = p.getStatusActive().getText();
		if (status.equals("Active")) {
			System.out.println("Repository is Active");
		} else {
			System.out.println("Repository is Inctive");
		}
		p.getRepoSave().click();
		
		
		blank();
		System.out.println("**Test Successful**");

	}
}
