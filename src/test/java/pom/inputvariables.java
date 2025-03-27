package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ScreenshotUtility;

public class inputvariables {
    WebDriver driver;
    
    inputvariables inputvars;

     @FindBy(xpath = "//a[text() ='Inputs']")
    public WebElement selectInput;

    @FindBy(xpath = "//input[@type ='number']")
    public WebElement passValue;
        
    @FindBy(xpath = "//a[text() ='Dropdown']")
    public WebElement selectDropDown;

    @FindBy(id = "dropdown")
    public WebElement passOpt;


    // Constructor to initialize elements
    public inputvariables(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize WebElements
        
    }
    
    public void getUrl()
    {
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void Selectclick()
    {
        selectInput.click();
    }

    public void passinp()
    {
        passValue.sendKeys("-3");
        ScreenshotUtility.takeScreenshot(driver, "Input");
        driver.navigate().back();
    }

    public void selectDrop()
    {
        selectDropDown.click();Select selectopt = new Select(passOpt);
        selectopt.selectByContainsVisibleText("Option 2");
    }

    public void quitdriver()
    {
        driver.quit();
    }
}
