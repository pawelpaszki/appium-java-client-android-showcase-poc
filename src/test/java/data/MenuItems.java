package data;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuItems {

	public MenuItems(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.aerogear.androidshowcase:id/imageView")
	public WebElement menuLogo;
	
	@AndroidFindBy(id="com.aerogear.androidshowcase:id/title")
	public WebElement menuTitle;
	
	@AndroidFindBy(id="com.aerogear.androidshowcase:id/description")
	public WebElement menuSubtitle;
	
	@AndroidFindBy(className="android.widget.CheckedTextView")
	public List<WebElement> navItems;
	
	public static final String MENU_TITLE = "AeroGear";
	public static final String MENU_SUBTITLE = "aerogear.org";
	public static final String[] NAV_HEADINGS_TOP_HALF = {"Home", "Identity Management", "Documentation", 
			"Authentication", "SSO", "Security", "Documentation", "Device Trust", "Secure Storage", "Cert Pinning"};
	public static final String[] NAV_HEADINGS_BOTTOM_HALF = {"Push Notifications", "Documentation", "Push Messages",
			"Metrics", "Documentation", "Device Profile Info", "Trust Check Info"};
}
