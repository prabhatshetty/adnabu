package adnabu.generic.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import adnabu.utils.WebDriverActions;

public class ItemPage {

	WebDriver driver;
	WebDriverActions webDriverActions=new WebDriverActions();

	public ItemPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//h1[@class='product-single__title']")
	private WebElement itemtext;


	public WebElement getItemtext() {
		return itemtext;
	}

	@FindBy(xpath="//button[@class='btn product-form__cart-submit btn--secondary-accent']")
	private WebElement addtocart;

	public WebElement getAddtocart() {
		return addtocart;
	}

	public void AddItemToCart()
	{
		webDriverActions.javascriptClick(addtocart);
		//webDriverActions.clickOnElement(addtocart);	
	}
	public String ItemText() 
	{
		webDriverActions.waitForElementToAppear(itemtext);
		String item = webDriverActions.getText(itemtext);
		return item;

	}
}
