package adnabu.generic.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import adnabu.utils.WebDriverActions;

public class CatalogPage {
	WebDriver driver;
	WebDriverActions webDriverActions=new WebDriverActions();
	
	public CatalogPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id="FilterTags")
	private WebElement filtertag;
	
	@FindBy(xpath="//div[@class='grid-view-item product-card']/a/span")
	private WebElement item;
	
	public WebElement getFiltertag() {
		return filtertag;
	}

	public WebElement getItem() {
		return item;
	}

	
	
	//@FindBy(xpath="//span[text()='Catalog']")
	//private WebElement catalog;
	
	public void selectfilter(){
		webDriverActions.selectByIndex(filtertag,3);
		
	}
	public void ClickOnItem(){
		webDriverActions.javascriptClick(item);
	}
	}
	
	
