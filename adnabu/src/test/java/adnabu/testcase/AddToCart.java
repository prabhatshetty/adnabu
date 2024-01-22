package adnabu.testcase;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import adnabu.generic.pageobjectmodel.CartPage;
import adnabu.generic.pageobjectmodel.CatalogPage;
import adnabu.generic.pageobjectmodel.HomePage;
import adnabu.generic.pageobjectmodel.ItemPage;
import adnabu.utils.BaseClass;
//@Listeners(adnabu.generic.pageobjectmodel.ListnerImp.class)
public class AddToCart extends BaseClass{

	@Test
	public void endtoend()
	{
		HomePage homepage=new HomePage(driver);
		CatalogPage catalogPage = new CatalogPage(driver);
		ItemPage itemPage = new ItemPage(driver);
		CartPage cartpage = new CartPage(driver);
		homepage.catalogclick();
		catalogPage.selectfilter();
		catalogPage.ClickOnItem();
		String itemname = itemPage.ItemText();
		//System.out.println(itemPage.ItemText());
		itemPage.AddItemToCart();
		//-----------------------
		//homepage.cartcount();
		homepage.carticonclick();
		cartpage.cartitemname();
		//System.out.println(cartpage.cartitemname());
		Assert.assertEquals(cartpage.cartitemname(),itemname,"Sucessfully added to the cart");
	}
	
}
