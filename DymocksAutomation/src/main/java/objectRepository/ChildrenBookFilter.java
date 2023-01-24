package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebUtilityFile;

public class ChildrenBookFilter {
	/**
	 * @author ManjuAnju POM class for Dymocks Children Book Filtering WebElements.
	 */
	public ChildrenBookFilter(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//WebElement Filter button
	@FindBy(xpath = "(//i[(@class='fal fa-filter')])[2]")
	private WebElement FilterMenu;
	//WebElement Check boardbooks check box
	@FindBy(xpath = "//span[text()='Board Book']")
	private WebElement BoardBookCheckBox;
	//WebElement from price textbox
	@FindBy(xpath = "//input[@class='form-control product-filter-pricing-from-input']")
	private WebElement PriceFromText;
	//WebElement to price textbox
	@FindBy(xpath = "//input[@class='form-control product-filter-pricing-to-input']")
	private WebElement PriceToText;
	//WebElement Check 0-2 years check box
	@FindBy(xpath = "//span[text()='0-2 years']")
	private WebElement twoYearsCheckbox;
	//WebElement apply button
	@FindBy(xpath = "//button[contains(@class,'page-filter-apply-btn')]")
	private WebElement ApplyButton;
	//WebElement select book link
	@FindBy(xpath="(//a[contains(@title,'The Wiggles: Toot Toot')])[2]")
	private WebElement selectBook;
	//WebElement add to cart button
	@FindBy(xpath="//a[@class='btn btn-primary full-width text-center']")
	private WebElement addToCart;
	//WebElement viewcart button
	@FindBy(xpath="//a[@class='btn btn-default full-width text-center']")
	private WebElement viewCart;

	public WebElement getViewCart() {
		return viewCart;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getSelectBook() {
		return selectBook;
	}

	public WebElement getFilterMenu() {
		return FilterMenu;
	}

	public WebElement getBoardBookCheckBox() {
		return BoardBookCheckBox;
	}

	public WebElement getPriceFromText() {
		return PriceFromText;
	}

	public WebElement getPriceToText() {
		return PriceToText;
	}

	public WebElement getTwoYearsCheckbox() {
		return twoYearsCheckbox;
	}

	public WebElement getApplyButton() {
		return ApplyButton;
	}
	/**
	 * MEthod to filter the book for selection
	 */
	public void filter(WebDriver driver, String fromPrice, String toPrice)
			throws InterruptedException {	
		FilterMenu.click();
		BoardBookCheckBox.click();
		PriceFromText.sendKeys(fromPrice);
		PriceToText.sendKeys(toPrice);
		twoYearsCheckbox.click();
		ApplyButton.click();		
	}	
	/**
	 * Method to select the book, add to cart and view the cart.
	 */
	public void selectBook(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub	
		WebUtilityFile wlib = new WebUtilityFile();
		wlib.waitPageToLoad(driver);
		selectBook.click();
		addToCart.click();
		viewCart.click();		
	}
}
