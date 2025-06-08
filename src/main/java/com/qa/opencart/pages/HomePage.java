package com.qa.opencart.pages;

import org.testng.Assert;

import com.microsoft.playwright.Page;


public class HomePage {
	Page page;
	
	//1.String locators
	private String search ="input[placeholder='Search']";
	private String searchIcon ="button[class='btn btn-default btn-lg']";
	private String searchPageHeader="div[id='content'] h1";
	private String myAccountLink ="a[title='My Account']";
	private String loginlink ="//a[normalize-space()='Login']";
	private String phones ="//a[normalize-space()='Phones & PDAs']";
	private String Iphone="//div[@class='caption']//a[contains(text(),'iPhone')]";
	private String cartBtn ="#button-cart";
	private String cartsuccess=".alert.alert-success.alert-dismissible";
	
	//2.page constructor
	public HomePage(Page page)
	{
		this.page=page;
	}

	//3.page actions/methods
	public String getHomePageTitle()
	{
		String title=  this.page.title();
		System.out.println("page title: "+title);
		return title;
		
	}
	
	public String getHomePageURL()
	{
		String url= this.page.url();
		System.out.println("page title: "+url);
		return url;
		
	}
	
	public String doSearch(String productName)
	{
	    this.page.fill(search, productName);
	    this.page.click(searchIcon);
	    String header= this.page.textContent(searchPageHeader);
	    System.out.println("search header:"+header);
	    return header;
	}
	
	public LoginPage navigateToLoginPage()
	{
		this.page.click(myAccountLink);
		this.page.click(loginlink);
		return new LoginPage(page);
	}
	
	public void phoneClick()
	{
		this.page.click(phones);
	}
	
	public void IphoneClick()
	{
		this.page.click(Iphone);
	}
	public void CartClick()
	{
		this.page.click(cartBtn);
	}
	
	public void CartSuccess()
	{
		String actualMessage =this.page.locator(cartsuccess).textContent().trim();
	    Assert.assertTrue(actualMessage.contains("Success: You have added iPhone to your shopping cart!"), "Success message displayed");
		String expectedMessage="Success: You have added iPhone to your shopping cart!";
		Assert.assertEquals(actualMessage, expectedMessage,"not matched");
	}
}
