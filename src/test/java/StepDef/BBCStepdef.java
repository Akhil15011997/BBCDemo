package StepDef;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import Actions.BBCActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BBCStepdef {
	
	WebDriver driver = null; BBCActions	BBCActions; 
	
	@Before (order=1)
	public void BrowserSetup() { System.out.println("Hooks Browser Setup");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
		//driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		BBCActions = new BBCActions(driver);
	}
	
	@Given("Browser is open")
	public void browser_is_open() {	}

	@When("User is navigated to BBC webpage")
	public void user_is_navigated_to_bbc_webpage() throws InterruptedException {
		BBCActions.navigatetoBBCUrl();
	}

	@And("User Accepts Cookies if shown")
	public void user_accepts_cookies_if_shown() {
		BBCActions.accpetingcookies();
	}

	@Then("User validates the top navigation links")
	public void user_validates_the_top_navigation_links() {
		BBCActions.verifysportnavigationlink();
	}
	
	@Then("User validates the day and date")
	public void user_validates_the_day_and_date() {
		BBCActions.verifydayanddate();
	}
	
	@And("Navigate to the News webpage and verify URL")
	public void user_navigates_to_news_and_validates_URL()  throws InterruptedException {
		BBCActions.NavigatetoNewsPage();
		BBCActions.VerifyNewsPage();
	}
	
	@And("Search {string} via searchbox")
	public void search_input_via_searchbox(String inputtext) {
		BBCActions.searchinputtext(inputtext);
	}
	
	@And("Verify if search is related to {string}") 
	public void Verify_if_search_is_related_to_input(String inputtext) {
		BBCActions.verifyifsearchisasexpected(inputtext);
	}
	
	@After
	public void teardown() {
		//Can add Failure Screenshot code here if required
		driver.close(); driver.quit();
	}

}
