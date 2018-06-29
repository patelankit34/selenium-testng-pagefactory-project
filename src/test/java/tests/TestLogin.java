package tests;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLandingPage;


public class TestLogin extends CommonSteps {
	
	HomePage homePage;
	UserLandingPage userLandingPage;
	
	@BeforeClass
	public void beforeThisClass() {

		homePage = PageFactory.initElements(super.driver, HomePage.class);
		userLandingPage = PageFactory.initElements(super.driver, UserLandingPage.class);
	}

	@Test(description = "Verify login with valid credentials")
	@Parameters({"loginEmail", "loginPassword","SearchUser"})
	private void verifyValidLogin(String loginEmail, String loginPassword,String name)
	{


		homePage.openHomePage(super.baseUrl);
		homePage.login(loginEmail, loginPassword);
		String actualText = userLandingPage.getTextFromUserProfileLink();
		System.out.print("title is: "+userLandingPage.GetTitle());
		String expectedText = "Andy";
		Assert.assertEquals(expectedText, actualText);

		Reporter.log("Text verified successfully, which is equals to: " + expectedText, true);
		userLandingPage.SearchName(name);
	}
	@Test(description = "Verify login with valid credentials 2",enabled=false)
	@Parameters({"loginEmail", "loginPassword"})
	private void verifyValidLogin2(String loginEmail, String loginPassword)
	{
		homePage.openHomePage(super.baseUrl);
		homePage.login(loginEmail, loginPassword);
		String actualText = userLandingPage.getTextFromUserProfileLink();
		String expectedText = "Ankit";
		Assert.assertEquals(expectedText, actualText);
		Reporter.log("Text verified successfully, which is equals to: " + expectedText, true);
	}

}
