package org.test.prolaborate.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.session.FirefoxFilter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
		public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

	}
	public static void firefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		//WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();

	}
	public static void edgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	public static void launchURL(String url) {
		driver.get(url);

	}
	public static void maxWindows() {
		driver.manage().window().maximize();

	}
	public static void close() {
		driver.close();

	}
	public static void quit() {
		driver.quit();

	}
	
	public static void waits() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	}
	public static void elementWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public static void sleep() throws InterruptedException {
		Thread.sleep(5000);

	}
	
	public static void textFill(WebElement element, String input) {
		element.sendKeys(input);

	}
	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);

	}
	public static void getUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URl : "+currentUrl);

	}
	public static void getTitle() {
		String currentTitle = driver.getTitle();
		System.out.println("Page Title : "+currentTitle);


	}
	public static void getValue(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
	}
	
	public static void click(WebElement element) {
		element.click();

	}
	public static void screenshot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\IdeapadG3-05\\eclipse-workspace\\Repository_Listing\\ScreenShots\\"+filename+".png");
		FileUtils.copyFile(source, destination);
	}
	public static void forward() {
		driver.navigate().forward();

	}
	public static void backward() {
		driver.navigate().back();
		
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static void blank() {
		System.out.println("");

	}
	public static void doubleClick(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	public static void delete() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_DELETE);
		
	}
	
	public static void backspace() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		
	}
	
	public static void selectAll() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	
	public static void msg(String text) {
		System.out.println(text);

	}
	
}
