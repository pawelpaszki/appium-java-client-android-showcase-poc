package rh.appium.showcase;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.*;

import data.Config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import data.HomePage;

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
		assertTrue(homePage.aerogearLogo.isDisplayed());
		assertTrue(homePage.homeInfoText.isDisplayed());
		assertTrue(homePage.homeInfoText.getText().contains(HomePage.HOME_TEXT));
		assertTrue(homePage.toolbar.isDisplayed());
		assertTrue(homePage.openMenuButton.isDisplayed());
		assertTrue(homePage.toolbarTextView.isDisplayed());
		assertTrue(homePage.toolbarTextView.getText().equals(HomePage.HOME_TOOLBAR_TEXT));
	}

//	@After
//	public void quitDriver() {
//		driver.close();
//	}
}
