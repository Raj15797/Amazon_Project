import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUp_Module {
	public static WebDriver driver;

	public void setproperty() {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
	}
	
	@BeforeMethod
	public void beforemethod() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.ca/ap/register?_encoding=UTF8&openid.assoc_handle=caflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust");
	}
	
	@Test(priority=1) //When Your Name field is empty
	public void NameEmp() throws InterruptedException {
		driver.findElement(By.id("ap_customer_name")).sendKeys(" ");
		driver.findElement(By.id("ap_email")).sendKeys("Solankiraj@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("Solankiraj");
		driver.findElement(By.id("ap_password_check")).sendKeys("Solankiraj");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=2)  //When Mobile or Email id field is empty
	public void MobileEmailEmp() throws InterruptedException {
		driver.findElement(By.id("ap_customer_name")).sendKeys("Solanki Raj");
		driver.findElement(By.id("ap_email")).sendKeys(" ");
		driver.findElement(By.id("ap_password")).sendKeys("Solankiraj");
		driver.findElement(By.id("ap_password_check")).sendKeys("Solankiraj");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=3)  //Enable "Verify Mobile number" button
	public void Mobile() throws InterruptedException {
		driver.findElement(By.id("ap_customer_name")).sendKeys("Solanki Raj");
		driver.findElement(By.id("ap_email")).sendKeys("solankiraj@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("Solankiraj");
		driver.findElement(By.id("ap_password_check")).sendKeys("Solankiraj");
		boolean a1 = driver.findElement(By.xpath("//*[@id=\"auth-continue-announce\"]/span[3]")).isDisplayed();
		String a2 =Boolean.toString(a1);
		//System.out.println(a1);
		
		if(a2.equals("true")) {
			System.out.println("Verify Email is Displayed");}
		else if(a2.equals("false")) {
			System.out.println("Verify Mobile Number is Displayed");}
		
		Thread.sleep(5000);
	}
	
	@Test(priority=5)  //When keep the Password field empty
	public void PassEmp() throws InterruptedException {
		driver.findElement(By.id("ap_customer_name")).sendKeys("Solanki Raj");
		driver.findElement(By.id("ap_email")).sendKeys("solankiraj@gmail.com ");
		driver.findElement(By.id("ap_password")).sendKeys("");
		driver.findElement(By.id("ap_password_check")).sendKeys("Solankiraj");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=6)  //When write down less than 6 character in password field
	public void PassLessthan6() throws InterruptedException {
		driver.findElement(By.id("ap_customer_name")).sendKeys("Solanki Raj");
		driver.findElement(By.id("ap_email")).sendKeys("solankiraj@gmail.com ");
		driver.findElement(By.id("ap_password")).sendKeys("solan");
		driver.findElement(By.id("ap_password_check")).sendKeys("Solan");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=7)  //When Password again field should not be the same as Password
	public void PassAgain() throws InterruptedException {
		driver.findElement(By.id("ap_customer_name")).sendKeys("Solanki Raj");
		driver.findElement(By.id("ap_email")).sendKeys("solankiraj@gmail.com ");
		driver.findElement(By.id("ap_password")).sendKeys("solanki");
		driver.findElement(By.id("ap_password_check")).sendKeys("Solankiraj");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=8)  //When user has entered mobile number or email id that has already been registed
	public void ReturnUser() throws InterruptedException {
		driver.findElement(By.id("ap_customer_name")).sendKeys("Solanki Raj");
		driver.findElement(By.id("ap_email")).sendKeys("solankiraj1997@gmail.com ");
		driver.findElement(By.id("ap_password")).sendKeys("solankiraj");
		driver.findElement(By.id("ap_password_check")).sendKeys("solankiraj");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void closewindow() {
		driver.close();
	}

}
