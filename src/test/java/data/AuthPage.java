package data;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AuthPage {

	public AuthPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.aerogear.androidshowcase:id/keycloakLogin")
	public WebElement authButton;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Username or email']")
	public WebElement usernameTextField;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Password']")
	public WebElement passwordTextField;
	
	@AndroidFindBy(xpath="//*[@content-desc='Log in']")
	public WebElement loginButton;
	
	@AndroidFindBy(id="com.aerogear.androidshowcase:id/keycloakLogout")
	public WebElement logoutButton;
	
	public static final String USERNAME = "";
	public static final String PASSWORD = "";
	public static final String LOGOUT_TEXT = "Logout";
}
