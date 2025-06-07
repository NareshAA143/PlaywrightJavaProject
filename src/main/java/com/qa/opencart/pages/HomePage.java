package com.qa.opencart.pages;

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
		String title=  page.title();
		System.out.println("page title: "+title);
		return title;
		
	}
	
	public String getHomePageURL()
	{
		String url= page.url();
		System.out.println("page title: "+url);
		return url;
		
	}
	
	public String doSearch(String productName)
	{
	    page.fill(search, productName);
	    page.click(searchIcon);
	    String header= page.textContent(searchPageHeader);
	    System.out.println("search header:"+header);
	    return header;
	}
	
	public LoginPage navigateToLoginPage()
	{
		page.click(myAccountLink);
		page.click(loginlink);
		return new LoginPage(page);
	}
	
	public void phoneClick()
	{
		page.click(phones);
	}
	
	public void IphoneClick()
	{
		page.click(Iphone);
	}
	public void CartClick()
	{
		page.click(cartBtn);
	}
	
	public boolean CartSuccess()
	{
		return page.isVisible(cartsuccess);
		
	}
}
