package rh.appium.showcase;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import data.AuthPage;
import data.Config;
import data.HomePage;
import data.IdentityPage;
import data.MenuItems;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AuthE2Etest {

	private AndroidDriver<AndroidElement> driver;
	private HomePage homePage;
	private MenuItems menuItems;
	private AuthPage authPage;
	private IdentityPage identityPage;

	@Before
	public void init() throws MalformedURLException {
		driver = Config.getCapabilities();
		homePage = new HomePage(driver);
		menuItems = new MenuItems(driver);
		authPage = new AuthPage(driver);
		identityPage = new IdentityPage(driver);
	}
	
	@Test
	public void authE2E() throws InterruptedException {
		homePage.openMenuButton.click();
		menuItems.navItems.get(3).click();
		assertTrue(authPage.authButton.isDisplayed());
		authPage.authButton.click();
		assertTrue(authPage.usernameTextField.isDisplayed());
		authPage.usernameTextField.clear();
		authPage.usernameTextField.sendKeys(AuthPage.USERNAME);
		assertTrue(authPage.passwordTextField.isDisplayed());
		authPage.passwordTextField.clear();
		authPage.passwordTextField.sendKeys(AuthPage.PASSWORD);
		assertTrue(authPage.loginButton.isDisplayed());
		authPage.loginButton.click();
		assertTrue(identityPage.identityTextViews.get(0).isDisplayed());
		assertTrue(identityPage.identityTextViews.get(0).getText().equals(IdentityPage.TOOLBAR_TITLE));
	}
}
