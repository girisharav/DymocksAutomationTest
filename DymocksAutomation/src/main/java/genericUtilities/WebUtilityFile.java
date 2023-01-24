 package genericUtilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

/**
 * generic class which contains web driver specific reusable actions like mousehover, right click, double click, wait for page to load  etc
 * @author ManjuAnju
 */
public class WebUtilityFile {
	/**
	 * Method for implicitly Wait action for 10 seconds	 
	 */
	public void waitPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * Method for script timeout action for 10 seconds	 
	 */
	public void scriptTimeout(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(10));
	}
	/**
	 * Method for Fluent Wait action for 20 seconds	 
	 */
	public void waitForElementWithCustomTimeout(WebDriver driver,WebElement Element,int pollingTime)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));			
	}
	/**
	 * Method for script timeout action	 
	 */
	public void switchToWindow(WebDriver driver, String PartialWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(PartialWindowTitle))
			{
				break;
			}
		}		
	}
	/**
	 * Method for Switch to alert and accept action.	 
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * Method for Switch to alert and dismiss action. 
	 */
	public void SwitchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * Method for Switch to frame window based on index 
	 */	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * Method for Switch to frame window based on attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_attributes)
	{		
		driver.switchTo().frame(id_name_attributes);
	}
	/**
	 * Method to select value from dropdown based on Text 
	 */
	public void selectbyText(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * Method to select value from dropdown based on index 
	 */
	public void selectbyIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * Method to select value from dropdown based on Text 
	 */
	public void selectbyValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * Method to perform mousehover action 
	 */
	public void Mouse_Hover(WebDriver driver,WebElement element)
	{
		Actions m_hover = new Actions(driver);
		m_hover.moveToElement(element).perform();		
	}
	

}
