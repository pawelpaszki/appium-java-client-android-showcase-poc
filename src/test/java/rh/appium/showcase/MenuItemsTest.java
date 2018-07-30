package rh.appium.showcase;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.Config;
import data.HomePage;
import data.MenuItems;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MenuItemsTest {

	private AndroidDriver<AndroidElement> driver;
	private HomePage homePage;
	private MenuItems menuItems;

	@Before
	public void init() throws MalformedURLException {
		driver = Config.getCapabilities();
		homePage = new HomePage(driver);
		menuItems = new MenuItems(driver);
	}
	
	@Test
	public void shouldEvaluatePresenceOfHomeElements() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(homePage.openMenuButton));
		assertTrue(homePage.openMenuButton.isDisplayed());
		homePage.openMenuButton.click();
		wait.until(ExpectedConditions.visibilityOf(menuItems.menuLogo));
		assertTrue(menuItems.menuLogo.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(menuItems.menuTitle));
		assertTrue(menuItems.menuTitle.isDisplayed());
		assertTrue(menuItems.menuTitle.getText().equals(MenuItems.MENU_TITLE));
		wait.until(ExpectedConditions.visibilityOf(menuItems.menuSubtitle));
		assertTrue(menuItems.menuSubtitle.isDisplayed());
		// before the menu scroll
		for (int i = 0; i < MenuItems.NAV_HEADINGS_TOP_HALF.length; i++) {
			wait.until(ExpectedConditions.visibilityOf(menuItems.navItems.get(i)));
			assertTrue(menuItems.navItems.get(i).getText().contains(MenuItems.NAV_HEADINGS_TOP_HALF[i]));;
		}
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"  Trust Check Info\"));");
		for (int i = MenuItems.NAV_HEADINGS_BOTTOM_HALF.length - 1, j = menuItems.navItems.size() - 1; i >= 0 ; i--, j--) {
			wait.until(ExpectedConditions.visibilityOf(menuItems.navItems.get(j)));
			assertTrue(menuItems.navItems.get(j).getText().contains(MenuItems.NAV_HEADINGS_BOTTOM_HALF[i]));;
		}
		
		
	}
}
