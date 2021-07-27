package info.seleniumcucumber.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Linkgroup_asset_step {

	public WebDriver driver;
	
	@When("I open the home page")
	public void i_open_the_home_page() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\Desktop\\Selenium\\browser\\geckodriver.exe");
	    
		WebDriver driver= new FirefoxDriver();
	    driver.manage().window().maximize();
        driver.get("https://www.linkgroup.eu/");
    	
	}

	@Then("the page is displayed")
	public void the_page_is_displayed() {
		boolean pagePresence = driver.findElement(By.xpath("//*[@id='LinkGroupEU']")).isDisplayed();
        System.out.println(pagePresence);
	}
   
	@Given("I have opened the home page")
	public void i_have_opened_the_home_page() {

      if (driver.getCurrentUrl().contains("https://www.linkgroup.eu/")==true) {
    	  System.out.println("I have opened the home page");
      }else {
    	  
       System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\Desktop\\Selenium\\browser\\geckodriver.exe");
	    
		WebDriver driver= new FirefoxDriver();
	    driver.manage().window().maximize();
        driver.get("https://www.linkgroup.eu/");
		
	}}

	@Given("I have agreed to the cookie policy")
	public void i_have_agreed_to_the_cookie_policy() {
	
    driver.findElement(By.cssSelector("a[class='cc-btn cc-dismiss']")).click();

   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		
	}

	@When("I search for {string}")
	public void i_search_for(String string) {
		
		driver.findElement(By.cssSelector("i[class='fa fa-search']")).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		driver.findElement(By.cssSelector("input[type='search']")).sendKeys("Leeds");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.findElement(By.cssSelector("button[class='btn btn-outline-default my-2 my-sm-0']")).click();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Then("the search results are displayed")
	public void the_search_results_are_displayed() {
		boolean ResultsPresence=driver.findElement(By.xpath("//div[@class='offset-1 col-10 col-sm-12']/child::h1")).isDisplayed();
		 
		 System.out.println(ResultsPresence);
	}
}
