package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Stepdefs {
    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();          
    }
    
    @Given("^user with username \"([^\"]*)\" with password \"([^\"]*)\" is successfully created$")
    public void user_created(String username, String password) throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));  
        element.click();
        createAccountWith(username, password);
//        element = driver.findElement(By.name("continue to application mainpage")); 
//        element.click();
//        element = driver.findElement(By.name("logout")); 
//        element.click();
    }
    
    @Given("^new user is selected$")
    public void new_user_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();          
    }
    
    @Given("^user with username \"([^\"]*)\" and password \"([^\"]*)\" is unsuccessfully created$")
    public void unsuccessfully_created(String username, String password) throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));  
        element.click();
        createAccountWith(username, password);
    }
    
    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @When("^incorrect username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void incorrect_username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @When("^unused username \"([^\"]*)\" and correct password \"([^\"]*)\" are given$")
    public void unused_username__and_password_are_given(String username, String password) throws Throwable {
        createAccountWith(username, password);
    }
    
    @When("^short username \"([^\"]*)\" and correct password \"([^\"]*)\" are given$")
    public void short_username__and_correct_password_are_given(String username, String password) throws Throwable {
        createAccountWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and short password \"([^\"]*)\" are given$")
    public void correct_username__and_short_password_are_given(String username, String password) throws Throwable {
        createAccountWith(username, password);
    }
    
    @When("^correct username \"([^\"]*)\" and letter password \"([^\"]*)\" are given$")
    public void correct_username__and_letter_password_are_given(String username, String password) throws Throwable {
        createAccountWith(username, password);
    }
    
    @When("^existing username \"([^\"]*)\" correct password \"([^\"]*)\" are given$")
    public void existing_username__and_correct_password_are_given(String username, String password) throws Throwable {
        createAccountWith(username, password);
    }
    
    @When("^unused username \"([^\"]*)\" and correct password \"([^\"]*)\" and wrong confirmation \"([^\"]*)\" are given$")
    public void existing_username__and_correct_password_are_given(String username, String password, String conf) throws Throwable {
        createAccountWith(username, password, conf);
    }
    
    @When("^short username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void short_username__and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    
    
    
    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }
    
    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    
    @Then("^nonexistent user is not logged in and error message is given$")
    public void nonexistent_user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    
    @Then("^user is not created and error \"([^\"]*)\" is reported$")
    public void user_is_not_created_and_error_message_is_given(String error) throws Throwable {
        pageHasContent(error);
    }
    
    
    
    @Then("^account is created successfully$")
    public void account_is_created() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }
    
    private void createAccountWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    }
    
    private void createAccountWith(String username, String password, String conf) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(conf);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    }
}
