package com.amazon.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CheckOutPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.ProductDetailsPage;
import com.amazon.qa.pages.SearchListPage;

public class ProductDetailsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	SearchListPage searchListPage;
	ProductDetailsPage productDetailsPage;
	CheckOutPage checkOutPage;
	
	public ProductDetailsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException, InterruptedException {
		
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("email"), prop.getProperty("password"));
		searchListPage = homePage.searchProduct();
		searchListPage.selectProductusingScroll();
		productDetailsPage = searchListPage.fetchingProduct();
	}
	
	
	//Method to validate product details  and scroll to click on Buy now button in product details page 
    @Test
    public void validateProductDetailsTest() throws InterruptedException {
    	
    	String productName=productDetailsPage.validateProductDetails();
    	System.out.println("TV name: "+productName);
    	Assert.assertEquals(productName, "TCL 163.96 cm (65 inches) 4K Ultra HD Smart Certified Android LED TV 65P8E (Black) (2019 Model)");
    	
    	for(int i=0;i<=8;i++) {
    		searchListPage.selectProductusingScroll();
    		Thread.sleep(3000);
    	}
//    	productDetailsPage.validateScrollTo();
    	
    	checkOutPage=productDetailsPage.validateCheckOut();
    	loggingOutApp();
    }
	
    @AfterMethod
    public void closingBrowser() {
    	tearDown();
    }

}
