package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.inputvariables;

public class printinput {
    WebDriver driver = new ChromeDriver();
    inputvariables getinput = new inputvariables(driver);

    // inputvariables value = new inputvariables(driver);
    @Given("Open the application")
    public void open_the_application() {
        getinput.getUrl();
    }
    @When("Select the task")
    public void select_the_task() {
        getinput.Selectclick();
    }
    @Then("Select the value")
    public void select_the_value() {
        getinput.passinp();
        getinput.selectDrop();
    }

    @After
    public void tearDown() {
        getinput.quitdriver();
    }
}
