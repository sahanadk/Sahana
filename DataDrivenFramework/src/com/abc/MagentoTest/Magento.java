package com.abc.MagentoTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Magento {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("E:\\\\selenium\\DataDrivenFramework\\src\\com\\abc\\Utilities\\data.properties");
		Properties p=new Properties();
		
		p.load(fis);
		
		String urldata=p.getProperty("url");
		String emaildata=p.getProperty("email");
		String passdata=p.getProperty("password");
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(urldata);
		
		driver.findElement(By.linkText("My Account")).click();
		
		driver.findElement(By.id("email")).sendKeys(emaildata);
		driver.findElement(By.id("pass")).sendKeys(passdata);
		
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.linkText("Log Out")).click();
		
		Thread.sleep(3000);
		
	}

}
