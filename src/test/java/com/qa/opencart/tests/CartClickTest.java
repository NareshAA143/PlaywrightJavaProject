package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class CartClickTest extends BaseTest {
	
	@Test
	public void CartAdd() throws InterruptedException
	{
		homePage.phoneClick();
		homePage.IphoneClick();
		homePage.CartClick();
		Thread.sleep(3000);
		//homePage.CartSuccess();
	}

}
