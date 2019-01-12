package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.EtsyPage;

public class EtsySteps {
	
	private WebDriver driver;
	private EtsyPage etsy;
	
	@Given("User in on Etsy homepage")
	public void user_in_on_Etsy_homepage() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().fullscreen();
	    driver.get("https://etsy.com");
	    Assert.assertEquals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone",
	    		driver.getTitle());
	}

	@When("User searches for {string}")
	public void user_searches_for(String keyword) {
	    etsy = new EtsyPage(driver);
	    etsy.searchBox.sendKeys(keyword + Keys.ENTER);
	}

	@Then("Search results should be displayed")
	public void search_results_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
