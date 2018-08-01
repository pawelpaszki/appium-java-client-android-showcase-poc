package data;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChromeWelcomePage {
	public ChromeWelcomePage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.android.chrome:id/terms_accept")
	public WebElement acceptButton;
	
	@AndroidFindBy(id="com.android.chrome:id/negative_button")
	public WebElement declineSignInButton;
	
	// PIN warning
	@AndroidFindBy(xpath="//android.widget.Button[@text='CANCEL']")
	public WebElement cancelWarningButton;
}
