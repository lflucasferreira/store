package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesFile {
	
	static String projectLocation = System.getProperty("user.dir");
	static String location = projectLocation+"\\src\\config\\config.properties";
	static Properties prop = new Properties();	
	public static String browser;
	public static String path;
	public static WebDriver driver;
	private static String email;
	private static String password;
	
	public static void readPropertiesFile()
	{
		try 
		{
			InputStream input = new FileInputStream(location);
			prop.load(input);
			browser = prop.getProperty("browser");
			path = prop.getProperty("path");
			setEmail(prop.getProperty("email"));
			setPassword(prop.getProperty("password"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void setBrowserConfig() {
		
		// FIREFOX
		if(browser.contains("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\firefox\\geckodriver_v0.21.0.exe");
			//System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
		}
		// CHROME
		else if(browser.contains("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chrome\\chromedriver_v2.40.exe");
			driver = new ChromeDriver();
		}
	}
	
	public static void writePropertiesFile()
	{
		try 
		{
			OutputStream output = new FileOutputStream(location);
			
			if(browser.contains("Chrome")) {
				prop.setProperty("browser", "Firefox");
			}
			else if(browser.contains("Firefox")){
				prop.setProperty("browser", "Chrome");
			}
			prop.store(output, null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * @return the email
	 */
	public static String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public static void setEmail(String email) {
		PropertiesFile.email = email;
	}

	/**
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public static void setPassword(String password) {
		PropertiesFile.password = password;
	}
}
