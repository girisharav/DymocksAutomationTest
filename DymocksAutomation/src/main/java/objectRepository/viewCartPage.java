package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class viewCartPage {
	/**
	 * POM class to check out the items from view cart page.
	 */
	public viewCartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	//WebElement Checkout link
	@FindBy(partialLinkText="CHECKOUT")
	private WebElement checkoutItems;
	
	public WebElement getCheckoutItems() {
		return checkoutItems;
	}
	// method to click the check out link.
	public void cartPageActions(WebDriver driver)
	{
		checkoutItems.click();
	}

}
