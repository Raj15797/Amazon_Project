import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YourAddress_Module {
	
	public static WebDriver driver;
	public void setprop() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	}
	
	@BeforeMethod
	public void setUrl() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		//driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust&prevRID=QEC8P51VJKQNPF6TMW1R&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		//driver.findElement(By.id("ap_email")).sendKeys("solankiraj1997@gmail.com");
		//driver.findElement(By.id("continue")).click();
		//driver.findElement(By.id("ap_password")).sendKeys("");
		//driver.findElement(By.id("signInSubmit")).click();
		//driver.get("https://www.amazon.ca/gp/yourstore/home?ie=UTF8&ref_=nav_newcust&");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test(priority=1) //TC18 Checking the functionality of "Your Addresses" button
	public void YourAddressPage() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(2) > span")).click();
		driver.findElement(By.cssSelector("#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > h2")).click();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}



}
