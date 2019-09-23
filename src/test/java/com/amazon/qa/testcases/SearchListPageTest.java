package com.amazon.qa.testcases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.ProductDetailsPage;
import com.amazon.qa.pages.SearchListPage;

public class SearchListPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	SearchListPage searchListPage;
	ProductDetailsPage productDetailsPage;
	
	public SearchListPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException, InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("email"), prop.getProperty("password"));
		searchListPage = homePage.searchProduct();
		
	}
	//click on desired product from search list and navigate to product details page
	@Test
	public void validateSearchProductTest() throws InterruptedException {
		searchListPage.selectProductusingScroll();
		productDetailsPage = searchListPage.fetchingProduct();
		loggingOutApp();
	}
	
	@AfterMethod
	public void closingBrowser() {
		tearDown();
	}
}
