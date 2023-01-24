/**
 * 
 */
package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DymocksHomePage_Repo {
	/**
	 * @author ManjuAnju
	 * POM class for Dymocks home page webelements
	 */
	public DymocksHomePage_Repo(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[text()='Kids'][1]")
	private WebElement clickKids;

	public WebElement getClickKids() {
		return clickKids;
	}
	//Method to kids link in the homepage.
	public void clickKidsBook()
	{
		clickKids.click();
	}

}
