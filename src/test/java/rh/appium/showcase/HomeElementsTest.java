package rh.appium.showcase;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.Config;
import data.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Unit test for simple App.
 */
public class HomeElementsTest {
	private AndroidDriver<AndroidElement> driver;
	private HomePage homePage;

	@Before
	public void init() throws MalformedURLException {
		driver = Config.getCapabilities();
		homePage = new HomePage(driver);
	}

	@Test
	public void shouldEvaluatePresenceOfHomeElements() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(homePage.aerogearLogo));
		assertTrue(homePage.aerogearLogo.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(homePage.homeInfoText));
		assertTrue(homePage.homeInfoText.isDisplayed());
		assertTrue(homePage.homeInfoText.getText().contains(HomePage.HOME_TEXT));
		wait.until(ExpectedConditions.visibilityOf(homePage.toolbar));
		assertTrue(homePage.toolbar.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(homePage.openMenuButton));
		assertTrue(homePage.openMenuButton.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(homePage.toolbarTextView));
		assertTrue(homePage.toolbarTextView.isDisplayed());
		assertTrue(homePage.toolbarTextView.getText().equals(HomePage.HOME_TOOLBAR_TEXT));
	}

//	@After
//	public void quitDriver() {
//		driver.close();
//	}
}
