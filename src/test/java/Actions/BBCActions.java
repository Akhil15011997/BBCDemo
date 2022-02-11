package Actions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BBCActions {
	
	WebDriver driver; 
	public BBCActions(WebDriver driver) 
	{ this.driver = driver; 
	PageFactory.initElements(driver,this); 	}
	
	@FindBy(xpath="//p[contains(text(),'Consent')]")
	public static WebElement cookies;
	
	@FindBy(xpath="(//a[contains(text(),'News')])[1]")
	WebElement News;
	
	@FindBy(xpath="//input[@id ='orb-search-q']")
	WebElement searchBox;
	
	public void navigatetoBBCUrl() throws InterruptedException {
		driver.navigate().to("https://bbc.com");
		//driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	public void accpetingcookies() {
		try {
				cookies.click(); 
		} catch (Exception e) {
			System.out.println(e + "Cookies question does not exist");
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	//similar method can be used to verify all top navigation links
	public void verifysportnavigationlink() {
		try {
			URL link = new URL("https://bbc.com/sport");
		HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
		httpConn.setConnectTimeout(3000);
		httpConn.connect();
		if(httpConn.getResponseCode()== 200) {
			System.out.println(link+" - "+httpConn.getResponseMessage());
			}
			if(httpConn.getResponseCode()== 404) {
			System.out.println(link+" - "+httpConn.getResponseMessage());
			}		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifydayanddate() {

		Date thisdate = new Date();
		SimpleDateFormat dateform = new SimpleDateFormat("EEEE, dd MMMM");
		String dateInString = dateform.format(thisdate); 
		try {
		if(driver.findElement(By.xpath("//*[contains(text(),'"+dateInString+"')]")).isDisplayed()) {
			System.out.println(dateInString+" is the current date and showing as expected");
		} } catch(Exception e) { System.out.print(e.getMessage()+ "\n" + e.getStackTrace()); }
		
	}
	
	public void NavigatetoNewsPage()  throws InterruptedException {
		News.click(); Thread.sleep(2000);
	}
	
	public void VerifyNewsPage() {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.bbc.com/news" );
	}
	
	public void searchinputtext(String inputtext) {
		searchBox.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		searchBox.sendKeys(inputtext+Keys.ENTER);
	}
	
	public void verifyifsearchisasexpected(String inputtext) {
		if(driver.findElement(By.xpath("//*[contains(text(),'"+inputtext+"')]")).isDisplayed()) {
			System.out.println(inputtext+" is shown in the search result as expected"); }
	}
	
}
