package data;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public HomePage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.aerogear.androidshowcase:id/toolbar")
	public WebElement toolbar;
	
	@AndroidFindBy(className="android.widget.TextView")
	public WebElement toolbarTextView;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	public WebElement openMenuButton;
	
	@AndroidFindBy(id="com.aerogear.androidshowcase:id/home_icon")
	public WebElement aerogearLogo;
	
	@AndroidFindBy(id="com.aerogear.androidshowcase:id/home_title")
	public WebElement homeInfoText;
	
	public static final String HOME_TEXT = "This app demonstrates how to use the AeroGear Mobile services, "
			+ "backed by OpenShift to perform a wide range of common mobile tasks such as Identity Management, "
			+ "Device Security, Metrics Capture, Push Notifications and more.";
	
	public static final String HOME_TOOLBAR_TEXT = "Home";
}
