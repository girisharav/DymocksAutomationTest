package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signoutPage 
/**
 * POM class to sign out of dymocks
 */
{
	public signoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//i[@class='icon-user']")
	private WebElement signoutIcon;
	
	@FindBy(xpath="//a[@class='logout-link']")
	private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getSignoutIcon() {
		return signoutIcon;
	}
	//Method to log out of the dymocks page.
	public void signoutDymocks(WebDriver driver)
	{
		signoutIcon.click();
		logoutLink.click();
	}

}
