package adnabu.generic.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import adnabu.utils.WebDriverActions;

public class CartPage {

	WebDriver driver;
	WebDriverActions webDriverActions=new WebDriverActions();

	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//div[@class='list-view-item__title']/a")
	private WebElement Cartitemname;

	public WebElement Cartitemname() {
		return Cartitemname;
	}
	public String cartitemname()
	{
		String itemname = webDriverActions.getText(Cartitemname);
		return itemname;
	}

}
