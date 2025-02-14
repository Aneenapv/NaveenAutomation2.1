package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.*;
import pageFactory.LoginPageFactory;
import java.util.List;
import org.openqa.selenium.WebElement;

public class LoginDemoSteps_PF {
	
	WebDriver driver = null;
	LoginPageFactory loginPageFactoryObj;
	
	@Given("Browser is open")
	public void browser_is_open() {
		
		System.out.println("....I am inside login Page Factory step definition file...");
		
	   System.out.println("Inside step- browser is opened");
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	   
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside step- user is on login page");
		
		loginPageFactoryObj = new LoginPageFactory(driver);
	}


	@When("^user enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username, String password) throws InterruptedException {
		  System.out.println("Inside step-user enters valid username and password");
		  
		  loginPageFactoryObj.enterUsername(username);
		  loginPageFactoryObj.enterPassword(password);
		  
		  //hardcoded values
		 //driver.findElement(By.name("email")).sendKeys("centanvin68@gmail.com");
		  //driver.findElement(By.name("password")).sendKeys("Password@1234");
		 
		  //datadriven and parameterization
		 // driver.findElement(By.id("input-email")).sendKeys(username);
		  //driver.findElement(By.name("password")).sendKeys(password);
		  
		  Thread.sleep(2000);
	}
	
	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		System.out.println("Inside step- user clicks on login button");
		
		loginPageFactoryObj.clickLogin();
		
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() throws InterruptedException {
	   System.out.println("Inside step- user is navigated to home page");
	   
	   loginPageFactoryObj.wishListDisplayed();
	   
	
	   
	   List<WebElement> mylinkslist = loginPageFactoryObj.getMyLinks();
	     
//	   List<WebElement> mylinkslist = driver.findElements(By.className("list-group"));
//	
	for(WebElement links: mylinkslist)
	{
		String strList = links.getText();
		System.out.println("list list =="+strList);
	}
	   
	   //driver.findElement(By.cssSelector("div.list-group a:last-of-type")).isDisplayed();
		  Thread.sleep(2000);
	   
	   driver.quit();
	}


	

}
