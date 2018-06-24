package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class UserLandingPage {
	
    WebDriver driver;
	
	public UserLandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using="//div[@data-click='profile_icon']") WebElement userProfileLink;
	
	public String getTextFromUserProfileLink() {
		String text = userProfileLink.getText();
		Reporter.log("Text captured from user profile link", true);
		return text;
	}
	
}
