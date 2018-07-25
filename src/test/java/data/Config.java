package data;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Config {
	public static AndroidDriver<AndroidElement> getCapabilities() throws MalformedURLException {
		File file = new File("src");
		File appFile = new File(file, "24_07_keycloak_notes_services.apk"); // app name
		
		DesiredCapabilities dCaps = new DesiredCapabilities();
		dCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Simulator"); // replace with "Android Device" to run on a device
		dCaps.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
		
		
		// uiautomator2 added due to problems with sending keys -> instead of desired text
		// the content of the clipboard was sent to EditText
		dCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dCaps);
		
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		
		return driver;
	}
}