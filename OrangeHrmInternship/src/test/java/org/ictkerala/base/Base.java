package org.ictkerala.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Base {

	public WebDriver driver;
	Properties prop;
	
	public void propload() throws IOException  {
		
		 try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("config.properties not found in classpath");
            }
            prop.load(input);
        }
		prop=new Properties();
		prop.load(propobj);
	}
	@BeforeTest
	public void configurations() throws IOException {
		propload();
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		
		// Basic if-else structure to choose   browser
	       if (browser.equalsIgnoreCase("chrome")) {
	           driver = new ChromeDriver();
	       } else if (browser.equalsIgnoreCase("firefox")) {
	           driver = new FirefoxDriver();
	       } else if (browser.equalsIgnoreCase("edge")) {
	           driver = new EdgeDriver();
	       } else {
	           System.out.println("Invalid browser name in config file.");
	           return;
	       }
	       driver.get(url);
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));


	}
	
}
