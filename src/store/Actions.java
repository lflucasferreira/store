package store;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.PropertiesFile;

public class Actions {

	public static void clearByID(String id) {
		PropertiesFile.driver.findElement(By.id(id)).clear();
	}

	public static void clickByID(String id) {
		PropertiesFile.driver.findElement(By.id(id)).click();
	}

	public static void clickByClassName(String classname) {
		PropertiesFile.driver.findElement(By.className(classname)).click();
	}
	
	public static void clickByLinkText(String title) {
		PropertiesFile.driver.findElement(By.linkText(title)).click();
	}
	
	public static void clickByCssSeletor(Integer id) {
		PropertiesFile.driver.findElement(By.cssSelector("a[data-id-product='"+id+"']")).click();
	}
	
	public static void signIn() {
		wait("login");
		clickByClassName("login");
	}
	
	public static void signOut() {
		wait("logout");
		clickByClassName("logout");
		PropertiesFile.driver.get(PropertiesFile.path);
	}
	
	public static void properties() {
		PropertiesFile.readPropertiesFile();
		PropertiesFile.setBrowserConfig();
		PropertiesFile.driver.manage().window().maximize();
		PropertiesFile.driver.get(PropertiesFile.path);
	}

	public static void selectByID(String select, String index) {
		Select box = new Select(PropertiesFile.driver.findElement(By.id(select)));
		box.selectByValue(index);
	}

	public static void sendKeysByID(String id, String text) {
		PropertiesFile.driver.findElement(By.id(id)).sendKeys(text);
	}

	public static void wait(String text) {
		WebDriverWait wait = new WebDriverWait(PropertiesFile.driver, 10);
		wait.until(ExpectedConditions.or(
			ExpectedConditions.elementToBeClickable(By.className(text)),
			ExpectedConditions.elementToBeClickable(By.id(text)),
			ExpectedConditions.presenceOfElementLocated(By.className(text)),
			ExpectedConditions.presenceOfElementLocated(By.id(text)),
			ExpectedConditions.visibilityOfElementLocated(By.className(text)),
			ExpectedConditions.visibilityOfElementLocated(By.id(text))
		));
	}

	public Actions() {
		super();
	}

}