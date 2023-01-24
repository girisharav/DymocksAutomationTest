/**
 * 
 */
package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DymocksLoginPage_Repo {
	/**
	 * @author ManjuAnju
	 * Login Page of dymocks Page
	 */
	public DymocksLoginPage_Repo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//span[@class='loginLinkLabel visible-lg']")
	private WebElement LoginClick;
	
	@FindBy(xpath="//input[@class='form-control login-username']")
	private WebElement UsernameText;
	
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement PasswordText;
	
	@FindBy(xpath="//input[@class='btn btn-primary login-btn']")
	private WebElement LoginSubmitButton;

	public WebElement getLoginClick() {
		return LoginClick;
	}

	public WebElement getUsernameText() {
		return UsernameText;
	}

	public WebElement getPasswordText() {
		return PasswordText;
	}

	public WebElement getLoginSubmitButton() {
		return LoginSubmitButton;
	}
	/**
	 * Enter user name and password and login into dymocks home page.
	 */
	public void DymocksLogin(String username, String password)
	{
		//LoginClick.click();			
		UsernameText.sendKeys(username);
		PasswordText.sendKeys(password);
		LoginSubmitButton.click();
	}
	
	
}
