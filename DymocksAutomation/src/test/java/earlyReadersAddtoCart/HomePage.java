package earlyReadersAddtoCart;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import genericUtilities.BaseClass;
import genericUtilities.ExcelFile;
import objectRepository.CheckoutPage;
import objectRepository.ChildrenBookFilter;
import objectRepository.DymocksHomePage_Repo;
import objectRepository.viewCartPage;

/**
 * Class to execute test script.
 * Login- Goto Early readers- provide filter conditions -select the book- add to cart-checkout- logout-close
 */
public class HomePage extends BaseClass {
@Test(priority=1) 	
	public void HomePageActions() throws IOException, InterruptedException
	{
		//creating reference variable of DymocksHomePage_Repo page.
		DymocksHomePage_Repo homePageRepoobj = new DymocksHomePage_Repo(driver);
		//Calling clickKidsBook to naviage to kids book section
		homePageRepoobj.clickKidsBook();
		
		//creating reference variable of ChildrenBookFilter page.
		ChildrenBookFilter filterobj = new ChildrenBookFilter(driver);		
			    
		//retrieving data to filter the books
		//From and To prices, 
		ExcelFile excelFileObj = new ExcelFile();
		String fromPrice = excelFileObj.getExcelData("filterData",0,0);
		String toPrice = excelFileObj.getExcelData("filterData",0,1);
		
		//Calling filter method to filter the books
		filterobj.filter(driver,fromPrice,toPrice);
		
		//get title url of page after filtering books.
		String titleBookSelectPage = driver.getTitle();
		//System.out.println(titleBookSelectPage);
		//Check if the currennt URL has board book.
		Assert.assertTrue(titleBookSelectPage.contains("Board Books"));
		
		//Method to choose a book
		filterobj.selectBook(driver);
		
		//Creating reference variable of viewCartPage
		viewCartPage viewCart = new viewCartPage(driver);
		String bookSelected = driver.getTitle();
		//System.out.println("Cart page title is "+bookSelected);
		
		//Calling CartPage method to view the cart.
		viewCart.cartPageActions(driver);
		
		//Check if current page points to Checkout page
		String titleCheckout1 = driver.getCurrentUrl();
		//System.out.println(titleCheckout1);
		Assert.assertTrue(titleCheckout1.contains("checkout"));
		
		//Creating reference variable of Checkout page
		CheckoutPage checkout = new CheckoutPage(driver);
		String countryName = excelFileObj.getExcelData("checkOutPlace", 0, 0);
		String stateValue = excelFileObj.getExcelData("checkOutPlace", 1, 0);
		checkout.countryOptions(driver,countryName,stateValue);			
	}
}
