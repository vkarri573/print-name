package com.shespeaks.automation;
import org.openqa.selenium.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AppTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException{		
		System.setProperty("webdriver.chrome.driver","F:\\Deepu\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.shespeaks.com/");
		driver.findElement(By.xpath("//a[text()='JOIN NOW']")).click();
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,400)");
WebElement dropdown = driver.findElement(By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[1]"));
dropdown.click();
WebElement stateDropDown = driver.findElement(By.name("state"));
Select dropdownstate = new Select(stateDropDown);

List<WebElement> states = dropdownstate.getOptions();

// List<WebElement> states=driver.findElements(By.xpath("//select[@name='state']//option"));
System.out.println(states.size());

// dropdownstate.selectByValue("AL");
dropdownstate.selectByIndex(1);

/*//states=driver.findElements(By.tagName("span"));
for(int i =0;i<states.size();i++)
{
	System.out.println(states.get(i).getTagName());
	System.out.println(states.get(i).getAttribute("value"));
	if(states.get(i).getAttribute("value").equals("OU"))
	{
		Thread.sleep(5000);
		states.get(i).click();
	    break;
		
	}
	
}*/
System.out.println("exit");
driver.close();
		
	}
	
}
