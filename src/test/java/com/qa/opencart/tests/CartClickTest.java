package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class CartClickTest extends BaseTest {
	
	@Test
	public void CartAdd()
	{
		homePage.phoneClick();
		homePage.IphoneClick();
		homePage.CartClick();
		Assert.assertTrue(homePage.CartSuccess());
	}

}
