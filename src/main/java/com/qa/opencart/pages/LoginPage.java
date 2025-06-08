package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;
	
	//1.String Locators
	private String emailId = "#input-email";
	private String password="#input-password";
	private String loginBtn = "input[value='Login']";
	private String forgotPwdLink ="div[class='form-group'] a";
	private String returningCustomer = "//h2[normalize-space()='Returning Customer']";
	
	//2.page constructor
	public LoginPage(Page page)
	{
		this.page=page;
	}

	//3.page actions/methods
	
	public String getLoginPageTitle()
	{
		return this.page.title();
	}
	
	public boolean isForgotPwdLinkExist()
	{
		return this.page.isVisible(forgotPwdLink);
	}
	
	public boolean doLogin(String appUserName, String appPassword)
	{
		System.out.println("App creds: " + appUserName + ":"+appPassword);
		this.page.fill(emailId, appUserName);
		this.page.fill(password, appPassword);
		this.page.click(loginBtn);
		if(this.page.isVisible(returningCustomer))
		{
			System.out.println("User is logged in successfully....");
			return true;
		}
		return false;
	}
}
