package pages;

import org.openqa.selenium.Keys;
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
	
	//@FindBy(how = How.XPATH, using="//div[@data-click='profile_icon']") WebElement userProfileLink;
	@FindBy(css="span._1vp5")
	WebElement userProfileLink;

	@FindBy(css="input[aria-label='Search']")
	WebElement SearchBox;

 @FindBy(css="div div._52eh")
 WebElement FirstName;

	public String GetTitle(){
		return driver.getTitle();
	}
  public void SearchName(String name){
		SearchBox.sendKeys(name);
	  SearchBox.sendKeys(Keys.RETURN);
	  FirstName.click();

  }
	public String getTextFromUserProfileLink() {
		String text = userProfileLink.getText();
		Reporter.log("Text captured from user profile link", true);
		sum();
		sum1(1,3);
		return text;

	}


	public void sum()
	{
		int a,b,c;
		a=1;
		b=3;
		c=a+b;

	}

	public void sum1(int a,int b){
		int c=a+b;
	}
}
