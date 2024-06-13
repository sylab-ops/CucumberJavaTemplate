package StepsDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
	    System.out.println("Inside Step - browser is open");
	    
	    //Global project path
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("The project path is:" +projectPath);
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void user_on_google_search_page() {
		 System.out.println("Inside Step - user is on google search page");
		 driver.navigate().to("https://google.com");
	}

	@When("user enters a text in the search box")
	public void user_enters_a_text_in_the_search_box() throws InterruptedException {
		 System.out.println("Inside Step - user enters a text in the search box");
		 driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		 Thread.sleep(3000);
	}

	@And("hit enter")
	public void hit_enter() throws InterruptedException {
		 System.out.println("Inside Step - hit enter");
		 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		 Thread.sleep(3000);
		 
	}

	@Then("user is re-directed to search results page")
	public void user_is_re_directed_to_search_results() {
		 System.out.println("Inside Step - user is re-directed to search results page");
		 driver.getPageSource().contains("Online Courses");
		 driver.close();
		 driver.quit();
	}
}
