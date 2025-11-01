package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage  extends BasePage
{
	private UserDetails userDetails;
	
	@FindBy(id = "customer.firstName")
    private WebElement firstNameInput;

    @FindBy(id = "customer.lastName")
    private WebElement lastNameInput;

    @FindBy(id = "customer.address.street")
    private WebElement addressInput;

    @FindBy(id = "customer.address.city")
    private WebElement cityInput;

    @FindBy(id = "customer.address.state")
    private WebElement stateInput;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCodeInput;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneInput;

    @FindBy(id = "customer.ssn")
    private WebElement ssnInput;

    // Account details
    @FindBy(id = "customer.username")
    private WebElement usernameInput;

    @FindBy(id = "customer.password")
    private WebElement passwordInput;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPasswordInput;

    // Submit (if present)
    @FindBy(css = "input[value='Register']")
    private WebElement registerBtn;
    
    @FindBy(css="#rightPanel > p")
    private WebElement successMsg ;
    
    
    @FindBy(css="a[href='logout.htm']")
    private WebElement logoutBtn  ;
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
		userDetails = new UserDetails(driver);
	}
	
	public String registerPageTitle()
	{
		return getTitle();
	}
	
	public String registerPageUrl()
	{
		return getCurrentUrl();
	}
	
  
	// Personal Details using component
    public UserDetails personalDetails() 
    {
        return userDetails;
    }

    public void enterSSN(String ssn) 
    {
        type(ssn, ssnInput);
    }

    // Account Details
    public void enterUsername(String username)
    {
        type(username, usernameInput);
    }

    public void enterPassword(String password)
    {
        type(password, passwordInput);
    }

    public void enterConfirmPassword(String confirmPassword) 
    {
        type(confirmPassword, confirmPasswordInput);
    }

    // Actions 
    public void clickOnRegister() 
    {
        click(registerBtn);
    }
    
    
    public void clickOnLogout() 
    {
        click(logoutBtn);
    }
    
    public boolean validateAccountCreation() 
    {
        return successMsg.isDisplayed();
    }

    
	
	
	
}
