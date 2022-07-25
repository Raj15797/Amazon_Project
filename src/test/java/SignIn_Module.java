import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignIn_Module {
	
	public static WebDriver driver;
	public void setproperty() {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
	}
	
	@BeforeMethod
	public void beforemethod() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust&prevRID=QEC8P51VJKQNPF6TMW1R&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");		
	}
	
	@Test(priority=1) //TC10 When "E-mail address or mobile phone number" field keep blank
	public void SigninEmaiidBlank() throws InterruptedException {
		driver.findElement(By.id("ap_email")).sendKeys("");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=2)  //TC11 When wrtie down wrong E-mail address or mobile phone number
	public void SigninEmailidWrong() throws InterruptedException {
		driver.findElement(By.id("ap_email")).sendKeys("solankirrr11@gmail.com");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=3)  //TC12 Check the functionality of continue button
	public void SigninCont() throws InterruptedException {
		driver.findElement(By.id("ap_email")).sendKeys("solankiraj1997@gmail.com");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=4)  //TC13 Check the functionality of "Keep me signed in" box
	public void SigninPass() throws InterruptedException {
		driver.findElement(By.id("ap_email")).sendKeys("solankiraj1997@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name("rememberMe")).click();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void aftermethod() {
		driver.close();
	}
	

}
