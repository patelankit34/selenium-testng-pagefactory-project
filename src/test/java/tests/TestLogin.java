package tests;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLandingPage;

/**
 * @author Jaspal
 *
 */
public class TestLogin extends CommonSteps {
	
	HomePage homePage;
	UserLandingPage userLandingPage;
	
	@BeforeClass
	public void beforeThisClass() {
		homePage = PageFactory.initElements(super.driver, HomePage.class);
		userLandingPage = PageFactory.initElements(super.driver, UserLandingPage.class);
	}
	
	@Test(description = "Verify login with valid credentials", enabled = true)
	@Parameters({"loginEmail", "loginPassword"})
	private void verifyValidLogin(String loginEmail, String loginPassword)
	{
		homePage.openHomePage(super.baseUrl);
		homePage.login(loginEmail, loginPassword);
		String actualText = userLandingPage.getTextFromUserProfileLink();
		String expectedText = "Jaspal";
		Assert.assertEquals(expectedText, actualText);
		Reporter.log("Text verified successfully, which is equals to: " + expectedText, true);
	}
	
	@Test(description = "Verify login with valid credentials 2", enabled = true)
	@Parameters({"loginEmail", "loginPassword"})
	private void verifyValidLogin2(String loginEmail, String loginPassword)
	{
		homePage.openHomePage(super.baseUrl);
		homePage.login(loginEmail, loginPassword);
		String actualText = userLandingPage.getTextFromUserProfileLink();
		String expectedText = "Jaspal";
		Assert.assertEquals(expectedText, actualText);
		Reporter.log("Text verified successfully, which is equals to: " + expectedText, true);
	}
	
}
