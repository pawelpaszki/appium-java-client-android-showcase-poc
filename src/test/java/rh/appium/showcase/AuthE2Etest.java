package rh.appium.showcase;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.AuthPage;
import data.Config;
import data.HomePage;
import data.MenuItems;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AuthE2Etest {

	private AndroidDriver<AndroidElement> driver;
	private HomePage homePage;
	private MenuItems menuItems;
	private AuthPage authPage;

	@Before
	public void init() throws MalformedURLException {
		driver = Config.getCapabilities();
		homePage = new HomePage(driver);
		menuItems = new MenuItems(driver);
		authPage = new AuthPage(driver);
	}
	
	@Test
	public void authE2E() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(homePage.openMenuButton));
		homePage.openMenuButton.click();
		wait.until(ExpectedConditions.visibilityOf(menuItems.navItems.get(3)));	
		menuItems.navItems.get(3).click();
		assertTrue(authPage.authButton.isDisplayed());
		authPage.authButton.click();
		wait.until(ExpectedConditions.visibilityOf(authPage.usernameTextField));
		assertTrue(authPage.usernameTextField.isDisplayed());
		authPage.usernameTextField.clear();
		authPage.usernameTextField.sendKeys(AuthPage.USERNAME);
		wait.until(ExpectedConditions.visibilityOf(authPage.passwordTextField));
		assertTrue(authPage.passwordTextField.isDisplayed());
		authPage.passwordTextField.clear();
		authPage.passwordTextField.sendKeys(AuthPage.PASSWORD);
		wait.until(ExpectedConditions.visibilityOf(authPage.loginButton));
		assertTrue(authPage.loginButton.isDisplayed());
		authPage.loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(authPage.logoutButton));
		assertTrue(authPage.logoutButton.isDisplayed());
		assertTrue(authPage.logoutButton.getText().equals(AuthPage.LOGOUT_TEXT));
		authPage.logoutButton.click();
		if(authPage.logoutButton.isDisplayed()) {
			// for some reason the click does not work the first time
			authPage.logoutButton.click();
		}
		
		
	}
}
