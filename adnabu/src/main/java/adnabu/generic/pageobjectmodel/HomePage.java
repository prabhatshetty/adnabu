package adnabu.generic.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import adnabu.utils.WebDriverActions;

public class HomePage {

	WebDriver driver;
	WebDriverActions webDriverActions=new WebDriverActions();

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//span[text()='Catalog']")
	private WebElement catalog;

	@FindBy(xpath="//span[text()='Cart']")
	private WebElement cart;

	@FindBy(xpath="//div[@id='CartCount']")
	private WebElement cartcount;



	public WebElement getCartcount() {
		return cartcount;
	}

	public WebElement getCatalog() {
		return catalog;
	}

	public WebElement getCart() {
		return cart;
	}

	public void catalogclick()
	{
		catalog.click();
	}
	public void carticonclick()
	{

		webDriverActions.javascriptClick(cart);
		//cart.clear();
	}
	public void cartcount()
	{
		webDriverActions.waitForElementToAppear(cartcount);
	}




}
