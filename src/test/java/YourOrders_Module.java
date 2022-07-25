import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YourOrders_Module {
	
	public static WebDriver driver;
	public void setprop() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	}
	
	@BeforeMethod
	public void setUrl() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		//driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust&prevRID=QEC8P51VJKQNPF6TMW1R&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		//driver.findElement(By.id("ap_email")).sendKeys("solankiraj1997@gmail.com");
		//driver.findElement(By.id("continue")).click();
		//driver.findElement(By.id("ap_password")).sendKeys("");
		//driver.findElement(By.id("signInSubmit")).click();
		//driver.get("https://www.amazon.ca/gp/yourstore/home?ie=UTF8&ref_=nav_newcust&");
	}
	
	@Test(priority=1) // TC17 Check whether there is 3 Options available or not
	public void YourOrder3Options() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.id("nav_prefetch_yourorders")).click();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}


}
