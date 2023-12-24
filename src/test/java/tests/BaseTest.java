package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public static AppiumDriverLocalService service;
	public static AndroidDriver driver;
	
	@BeforeClass
	public static void cofigurationSetup() throws MalformedURLException {
		  service =new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\shrut\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Android 13 Pixel 2 XL");
		options.setApp("\\Users\\shrut\\eclipse-workspace\\RS_mobile_framework\\src\\test\\resources\\ApiDemos-debug.apk");
		
		  driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/"), options);
	}
	
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
		service.stop();
	}
	
	public void longPressAction(WebElement element) {
		
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()),"duration",2000);
	}
}
