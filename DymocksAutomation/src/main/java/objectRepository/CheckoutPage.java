package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebUtilityFile;
public class CheckoutPage {	
	/**
	 *  POM class for checkout page
	 */
		public CheckoutPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Webelement to locate country selection dropdown
		@FindBy(xpath="//select[@placeholder='Country']")
		private WebElement selectCountry;
		//Webelement to locate country selected from dropdown
		@FindBy(xpath="(//option[@selected='selected'])[1]")
		private WebElement selectedCountry;
		//Webelement to locate State selection dropdown
		@FindBy(xpath="//select[@placeholder='State']")
		private WebElement selectState;
		//Webelement to locate State selected from dropdown
		@FindBy(xpath="(//option[@selected='selected'])[2]")
		private   WebElement selectedState;

		public WebElement getSelectedState() {
			return selectedState;
		}

		public WebElement getSelectCountry() {
			return selectCountry;
		}
		
		public WebElement getSelectedCountry() {
			return selectedCountry;
		}
		
		public WebElement getSelectState() {
			return selectState;
		}
		
		//method to select australia and ACT
		public void countryOptions(WebDriver driver,String Countryname,String Statevalue)
		{
			WebUtilityFile wlib = new WebUtilityFile();			
			//Retrieving value of country that is selected
			String countrySelectedValue = selectedCountry.getText();
			//System.out.println(countrySelectedValue);
			//Retrieving value of state that is selected			
			//Logic to select country as Australia and State as Adelaide
			if(countrySelectedValue.contains(Countryname))
			{				
				wlib.selectbyValue(selectState, Statevalue);
			}
			else
			{	
				wlib.selectbyText(selectCountry, Countryname);
				wlib.selectbyValue(selectState, Statevalue);
			}			
		}	
}
