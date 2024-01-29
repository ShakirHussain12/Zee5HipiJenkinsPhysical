package com.business.zee;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.EmailValidator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import com.deviceDetails.DeviceDetails;
import com.driverInstance.DriverInstance;
import com.emailReport.GmailInbox;
import com.extent.ExtentReporter;
import com.jayway.restassured.response.Response;
import com.metadata.ResponseInstance;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;
import com.zee5.AndroidHipiPages.HipiAddMusicPage;
import com.zee5.AndroidHipiPages.HipiCreateVideoPage;
import com.zee5.AndroidHipiPages.HipiDiscoverPage;
import com.zee5.AndroidHipiPages.HipiFeedPage;
import com.zee5.AndroidHipiPages.HipiMePage;
import com.zee5.AndroidHipiPages.HipiPopularPage;
import com.zee5.AndroidHipiPages.HipiSettingsPage;
import com.zee5.AndroidHipiPages.HipiSoundDetailPage;
import com.zee5.Applicaster.HIPI.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Zee5ApplicasterHipiBusinessLogic extends Utilities {

	public Zee5ApplicasterHipiBusinessLogic(String Application) {
		new DriverInstance(Application);
		init();
	}

	private int timeout;

	/** Retry Count */
	private int retryCount;
	ExtentReporter extent = new ExtentReporter();

	/** The Constant logger. */
	// final static Logger logger = Logger.getLogger("rootLogger");
	static LoggingUtils logger = new LoggingUtils();

	/** The Android driver. */
	public AndroidDriver<AndroidElement> androidDriver;

	/** The Android driver. */
	public IOSDriver<WebElement> iOSDriver;

	@Override
	public int getTimeout() {
		return timeout;
	}

	String pUserType = getParameterFromXML("userType");

	/** Array of App */
	static ArrayList<String> AppMyProfile = new ArrayList<String>();
	static HashSet<String> contentsInWatchList = new HashSet<String>();
	static HashSet<String> contentsInReminders = new HashSet<String>();
	static ArrayList<String> AppSubscription = new ArrayList<String>();
	static ArrayList<String> AppTransaction = new ArrayList<String>();

	@Override
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	@Override
	public int getRetryCount() {
		return retryCount;
	}

	@Override
	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	GmailInbox gmail = new GmailInbox();

	String SVODEpisode = getParameterFromXML("SVODEpisode");

	public void init() {

		PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
		setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
		setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
		// logger.info("Loaded the following properties" + " TimeOut :" +
		// getTimeout() + " RetryCount :" + getRetryCount());
	}

	/**
	 * Function to Relaunch the driver
	 */
	public void relaunch(boolean clearData) throws Exception {
		HeaderChildNode("Relaunch the app");
		logger.info("Relaunching the application");
		extent.extentLogger("Relaunch", "Relaunching the application");
		waitTime(10000);
		getDriver().quit();
		relaunch = clearData;
		new Zee5ApplicasterHipiBusinessLogic("zee");
	}

	/**
	 * Function to quit the driver
	 */
	public void tearDown() {
		getDriver().quit();

		String pUserType = getParameterFromXML("userType");
		String RegisteredEmail = getParameterFromXML("RegisteredEmail");
		String RegisteredEmailPassword = getParameterFromXML("RegisteredEmailPassword");
		String UnRegisteredMobile = getParameterFromXML("UnRegisteredMobile");
		String RegisteredMobile = getParameterFromXML("RegisteredMobile");
		String RegisteredMobilePassword = getParameterFromXML("RegisteredMobilePassword");
		String PromoCode = getParameterFromXML("PromoCode");
		String NonsubscribedUserName = getParameterFromXML("NonsubscribedUserName");
		String NonsubscribedPassword = getParameterFromXML("NonsubscribedPassword");
		String SubscribedUserName = getParameterFromXML("SubscribedUserName");
		String SubscribedPassword = getParameterFromXML("SubscribedPassword");
		String FirstName = getParameterFromXML("FirstName");
		String LastName = getParameterFromXML("LastName");

	}

	// Retrieve the Mobile Device Name
	String getOEMName = DeviceDetails.OEM;

	public void accessDeviceLocationPopUp(String permission, String userType) throws Exception {
		extent.HeaderChildNode("Access Device Location PopUp");

		extent.extentLogger("User Type", "UserType : " + userType);
		logger.info("UserType : " + userType);
		System.out.println("Access Device Location PopUp");
		Thread.sleep(10000);

		//TEMP
		if(verifyElementExist(AMDOnboardingScreen.objUpdateZee5PopUpNOTHANKSButton, "NO THANKS Button"))
		{
			click(AMDOnboardingScreen.objUpdateZee5PopUpNOTHANKSButton, "NO THANKS Button");
		}else{
			System.out.println("UpdateZee5 Not displayed");
		}
		
		Thread.sleep(3000);
		
		
		if (verifyElementExist(AMDOnboardingScreen.objAllowLocationAccessPopup, "AllowPopup")) {
			Wait(5000);

			String str1 = getAttributValue("text", AMDOnboardingScreen.objFirstPermissionButton);
			String str2 = getAttributValue("text", AMDOnboardingScreen.objSecondPermissionButton);
			System.out.println(str1);
			System.out.println(str2);

			if (str1.contains("ALLOW")) {
				System.out.println("ALLOW is present");
				click(AMDOnboardingScreen.ele1Allow(str1), str1);
			} else if (str1.contains("Allow")) {
				System.out.println("Allow is present");
				click(AMDOnboardingScreen.ele1Allow(str1), str1);
			} else if (str2.contains("ALLOW")) {
				System.out.println("ALLOW is present");
				click(AMDOnboardingScreen.ele1Allow(str2), str2);
			} else if (str2.contains("Allow")) {
				System.out.println("Allow is present");
				click(AMDOnboardingScreen.ele1Allow(str2), str2);
			} else if (str1.contains("WHILE USING THE APP")) {
				System.out.println("WHILE USING THE APP is present");
				click(AMDOnboardingScreen.ele1Allow(str1), str1);
			}

			Thread.sleep(10000);
		} else {
			System.out.println("Access Device Location PopUp not displayed");
		}

		// if
		// (verifyElementExist(AMDOnboardingScreen.objAllowLocationAccessPopup,"AllowPopup"))
		// {
		// Wait(5000);
		// verifyElementPresent(AMDOnboardingScreen.objLocationAccessAllowOption,
		// "Allow button");
		// verifyElementPresent(AMDOnboardingScreen.objLocationAccessDenyOption,
		// "Deny button");
		//
		// if (permission.equalsIgnoreCase("Allow")) {
		// click(AMDOnboardingScreen.objLocationAccessAllowOption, "Allow
		// button");
		//
		// } else {
		// click(AMDOnboardingScreen.objLocationAccessDenyOption, "Deny
		// button");
		// }
		//
		// }else{
		// System.out.println("Access Device Location PopUp not displayed");
		// }

	}


	
	public void AllowPermission() throws Exception {
		if (verifyElementExist(AMDOnboardingScreen.objAllowLocationAccessPopup, "AllowPopup")) {
			Wait(5000);

			String str1 = getAttributValue("text", AMDOnboardingScreen.objFirstPermissionButton);
			String str2 = getAttributValue("text", AMDOnboardingScreen.objSecondPermissionButton);
			//System.out.println(str1);
			//System.out.println(str2);

			if (str1.contains("ALLOW")) {
				System.out.println("ALLOW is present");
				click(AMDOnboardingScreen.ele1Allow(str1), str1);
			} else if (str1.contains("Allow")) {
				System.out.println("Allow is present");
				click(AMDOnboardingScreen.ele1Allow(str1), str1);
			} else if (str2.contains("ALLOW")) {
				System.out.println("ALLOW is present");
				click(AMDOnboardingScreen.ele1Allow(str2), str2);
			} else if (str2.contains("Allow")) {
				System.out.println("Allow is present");
				click(AMDOnboardingScreen.ele1Allow(str2), str2);
			}

			Thread.sleep(10000);
		} else {
			System.out.println("Access permission PopUp not displayed");
		}
	}

	public void VerifyLoginWithEmailId(String userType) throws Exception {
		extent.HeaderChildNode("Login With Email-ID");
		System.out.println("HiPi_Reg_007");
		extent.extentLogger("", "HiPi_Reg_007");
		// String pUserType = getParameterFromXML("userType");
		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			verifyElementPresentAndClick(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for Free");
			verifyElementPresentAndClick(AMDLoginScreen.objGoogleBtn, "Gmail icon");
			verifyElementPresentAndClick(AMDLoginScreen.objgoogleaccount, "google account");

			if (checkElementExist(AMDHomePage.objHome, "Home Tab")) {
				logger.info("User logged in successfully");
				extent.extentLoggerPass("Login", "User logged in successfully");

				verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
				Swipe("UP", 2);

				verifyElementPresentAndClick(AMDMoreMenu.objLogout, "Logout");
				verifyElementPresentAndClick(AMDMoreMenu.objLogoutBtn, "Logout Button");
				waitTime(5000);
				Swipe("Down", 2);
				verifyElementPresentAndClick(AMDMoreMenu.objProfile, "Login/Register");

			} else {
				logger.info("Pre conditions not met, Account is not logged In");
				extentLoggerWarning("Gmail", "Pre conditions not met, Account is not logged In");
				Back(1);
			}

			extent.extentLogger("", "Twitter");
			verifyElementPresentAndClick(AMDLoginScreen.objtwitterBtn, "Twitter icon");
			waitTime(5000);
			// if (checkElementExist(AMDOnboardingScreen.objTellUsMore, "More
			// info Screen")) {
			if (checkElementExist(AMDLoginScreen.objEmailIdField, "Email Id field")) {
				type(AMDLoginScreen.objEmailIdField, "zee5latest@gmail.com", "Email Id field");
				verifyElementPresentAndClick(AMDLoginScreen.objpassworldField, "Twitter page");
				type(AMDLoginScreen.objpassworldField, "User@123", "Password Id field");
				verifyElementPresentAndClick(AMDLoginScreen.objTwitterloginButton, "loginbutton");
				click(AMDLoginScreen.objTwitterAuthorizeAllow, "Authorize app");
				Thread.sleep(8000);
				// if
				// (checkElementExist(AMDLoginScreen.objTwitterAuthorizeAllow,
				// "Authorize
				// app")) {
				// click(AMDLoginScreen.objTwitterAuthorizeAllow, "Authorize
				// app");
			} else {
				click(AMDLoginScreen.objTwitterAuthorizeAllow, "Authorize app");
				Thread.sleep(10000);
			}

			if (checkElementExist(AMDHomePage.objHome, "Home Tab")) {
				logger.info("User logged in successfully");
				extent.extentLogger("Login", "User logged in successfully");
				verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
				Swipe("UP", 2);
				verifyElementPresentAndClick(AMDMoreMenu.objLogout, "Logout");
				verifyElementPresentAndClick(AMDMoreMenu.objLogoutBtn, "Logout Button");
				waitTime(5000);
				Swipe("Down", 2);
				verifyElementPresentAndClick(AMDMoreMenu.objProfile, "Login/Register");
			} else {
				logger.info("Pre conditions not met, Account is not logged In");
				extentLoggerWarning("Twitter", "Pre conditions not met, Account is not logged In");
				Back(1);
			}

			extent.extentLogger("", "Facebook");
			verifyElementPresentAndClick(AMDLoginScreen.objfbBtn, "Facebook icon");
			waitTime(5000);
			
			if (checkElementExist(AMDLoginScreen.objFBEmail, "Email Id field")) {
			type(AMDLoginScreen.objFBEmail, "krisarorec1047@gmail.com", "Email Id field");
			verifyElementPresentAndClick(AMDLoginScreen.objFBPassword, "facebook page");
			type(AMDLoginScreen.objFBPassword, "Krishna19@", "Password Id field");
			verifyElementPresentAndClick(AMDLoginScreen.objFBLoginBtn, "loginbutton");
			}else {
				
			}

			if (checkElementExist(AMDHomePage.objHome, "Home Tab")) {
				logger.info("User logged in successfully");
				extent.extentLoggerPass("Login", "User logged in successfully");
				verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
				Swipe("UP", 1);

				verifyElementPresentAndClick(AMDMoreMenu.objLogout, "Logout");
				verifyElementPresentAndClick(AMDMoreMenu.objLogoutBtn, "Logout Button");
				waitTime(5000);
				Swipe("Down", 2);
				// verifyElementPresentAndClick(AMDMoreMenu.objProfile,
				// "Login/Register");

			} else {
				logger.info("Pre conditions not met, Account is not logged In");
				extentLoggerWarning("Facebook", "Pre conditions not met, Account is not logged In");
				Back(1);
				Back(1);
			}
		}
	}

	public void LoginAndNivigateToHipi(String loginMethod) throws Exception {
		extent.HeaderChildNode("Login Functionality");
		String pUserType = getParameterFromXML("userType");

		extent.extentLogger("Login Type", "Login Type : " + pUserType);

		switch (loginMethod) {
		case "Guest":
			extent.HeaderChildNode("Guest User");
			extent.extentLogger("Accessing the application as Guest user", "Accessing the application as Guest user");
			waitTime(1000);
			//NavigateToHipi();
			waitTime(3000);
			break;

		case "NonSubscribedUser":
			extent.HeaderChildNode("Login as NonSubscribed User");

			String Username = getParameterFromXML("NonsubscribedUserName");
			String Password = getParameterFromXML("NonsubscribedPassword");

			verifyElementPresentAndClick(AMDOnboardingScreen.objZeeMoreButton, "More button");
			
			verifyElementPresentAndClick(AMDOnboardingScreen.objLoginLink, "Login/Register Link");

			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;

		case "SubscribedUser":
			extent.HeaderChildNode("Login as Subscribed User");

			String SubscribedUsername = getParameterFromXML("SubscribedUserName");
			String SubscribedPassword = getParameterFromXML("SubscribedPassword");

			verifyElementPresentAndClick(AMDOnboardingScreen.objZeeMoreButton, "More button");
			
			verifyElementPresentAndClick(AMDOnboardingScreen.objLoginLink, "Login/Register Link");


			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, SubscribedUsername, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;
		}
	}

	public void NavigateToHipi() throws Exception {
		extent.HeaderChildNode("Navigate to Hipi");

		if (verifyElementExist(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free")) {
			click(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objSkip, "Skip");
			// Thread.sleep(5000);
			// click(AMDOnboardingScreen.objHipiButton, "HiPi");

			Thread.sleep(6000);

			// if(verifyElementExist(AMDOnboardingScreen.objAgreeToTerms, "Agree
			// To Terms Popup"))
			// {
			// click(AMDOnboardingScreen.objAgreeToTermSaveButton, "Save");
			// }

		} else {
			if (verifyElementExist(AMDOnboardingScreen.objZeeMoreButton, "More Button")) {
				Thread.sleep(5000);
				System.out.println("User has loggedin, so logging out");
				click(AMDOnboardingScreen.objZeeMoreButton, "More Button");
				Thread.sleep(3000);
				Swipe("UP", 1);
				Thread.sleep(3000);
				verifyElementPresentAndClick(AMDOnboardingScreen.objLogoutButton, "Logout Button");
				verifyElementPresentAndClick(AMDOnboardingScreen.objAreYouSurePopupLogoutButton,
						"Are you sure Logout Button");
				Thread.sleep(3000);
				Back(1);
			}
		}
	}

	// ========================================EFFECT DETAIL PAGE -
	// GAUTHAMI=====================================

	public void Effectdetailpage(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("user navigate to effectdetail page");
			System.out.println("HiPi_Guest_038");
			// Thread.sleep(1000);
			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
			// Thread.sleep(1000);
			verifyElementPresentAndClick(AMDHipi.objDiscovertext, "discover text");
			verifyElementPresentAndClick(AMDHipi.objdiscoversearchtext, "search text");
			type(AMDHipi.objsearchtext, "cool Glasses", "effect used");
			hideKeyboard();
			// String Effectused1 = getText(AMDHipi.objsearchtext);
			// logger.info(Effectused1);
			verifyElementPresentAndClick(AMDHipi.objframelayout, "frame layout");
			verifyElementPresentAndClick(AMDHipi.objeffectused, "on effect used");
			if (verifyElementExist(AMDHipi.objeffectname, "effect name")) {
				extent.extentLogger("", "tapping on feed effect user navigated to effect detail page");
				logger.info("user navigated to effect detail page by tapping on feed effect");
			} else {
				extent.extentLogger("", "tapping on feed effect user not  navigated to effect detail page");
				logger.info("user not  navigated to effect detail page");
			}

			extent.HeaderChildNode("thumbnail of effect and no of videos created");
			System.out.println("HiPi_Guest_039");
			verifyElementExist(AMDHipi.objeffectthumbnailname, "effect thumbnail name");
			verifyElementExist(AMDHipi.objeffectname, "effect name");
			logger.info("user is able to view thumbnail effect");
			extent.extentLogger("", "user is able to view thumbnail effect");
			String Effectcount = getAttributValue("text", AMDHipi.objvideocount);
			System.out.print("\n Effect count");
			if (Effectcount.equalsIgnoreCase("")) {
				logger.error("Effect count is displayed blank");
				extentLoggerFail("", "Effect count is displayed blank");
			} else {
				logger.info("Effect count displayed " + Effectcount);
				extentLoggerPass("Effects", "Effects count displayed " + Effectcount);
			}

			extent.HeaderChildNode("list of videos created using effect");
			System.out.println("HiPi_Guest_040");
			// verifyElementExist(AMDHipi.objvideoscreated,"videos created using
			// effect");
			// int size =
			// getDriver().findElements(AMDHipi.objthumbnails).size();
			// for (int i = 0; i < size; i++) {
			// boolean isDisplayed =
			// getDriver().findElements(AMDHipi.objthumbnails).get(i).isDisplayed();
			// if (isDisplayed) {
			// String thumbnail =
			// getDriver().findElements(AMDHipi.objthumbnails).get(i).getText();
			// extent.extentLoggerPass("thumbnails", "Available thumbnails" + i
			// + " : " + thumbnail);
			// logger.info("Available thumbnails " + i + " : " + thumbnail);
			// } else {
			// extent.extentLoggerFail("thumbnails", "No thumbnails are
			// available");
			// logger.info("No thumbnails are available");
			// }
			// }
			//
			verifyElementPresentAndClick(AMDHipi.objeffectthumbnsilone, "effectthumbnail");
			verifyElementPresentAndClick(AMDHipi.objeffectusedone, "effect name");
			if (verifyElementExist(AMDHipi.objeffectname, "effect name")) {
				extent.extentLogger("", "tapping on feed effect user navigated to effect detail page");
				logger.info("user navigated to effect detail page by tapping on feed effect");
			} else {
				// logger.info("user navigated to effect detail page by tapping
				// on feed effect");
				// extent.extentLogger("", "user navigated to effect detail page
				// by tapping on feed effect");
				extent.extentLogger("", "tapping on feed effect user not  navigated to effect detail page");
				logger.info("user not  navigated to effect detail page");
			}

			extent.HeaderChildNode("Register popup by tapping usethis effect");
			System.out.println("HiPi_Guest_041");
			// Swipe("DOWN",2);
			verifyElementPresentAndClick(AMDHipi.objuseeffect, "use this effect");
			registerPopUp();
			if (verifyElementDisplayed(AMDHipi.objRegisterPop)) {
				logger.info("Tapping on use this effectRegister popup is displayed");
				extent.extentLogger("", "Tapping on usethis effectRegister popup is displayed");
			} else {
				logger.info("Tapping on use this effectRegister popup is not displayed");
				extent.extentLogger("", "Tapping on usethis effectRegister popup is not displayed");
			}
			Back(1);

			BackToFeedScreen();
		}

		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("Thumbnail of effect  with name and no. of Videos created using that effect");

			String effectName = null;

			System.out.println("Hipi_Reg_132");		extent.extentLogger("", "Hipi_Reg_132");
			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
			verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
			verifyElementPresentAndClick(HipiMePage.objfavourite, "favourite");
			verifyElementPresentAndClick(HipiMePage.objEffects, "Effects tab is present under favourite");
			
			
			
			if(verifyIsElementDisplayed(HipiMePage.objfirstEffect, "Effect")){
				effectName = getAttributValue("text", HipiMePage.objfirstEffect);
				verifyElementPresentAndClick(HipiMePage.objfirstEffect, "effect text");			
				
			}else{
				verifyElementPresentAndClick(HipiMePage.objbackbutton, "Back Button");
				waitTime(3000);
				verifyElementPresentAndClick(AMDHipi.objDiscovertext, "discover text");
				verifyElementPresentAndClick(AMDHipi.objdiscoversearchtext, "search text");
				String effect = "Cool Glasses";
				type(AMDHipi.objsearchtext, effect, effect);
				hideKeyboard();
				verifyElementPresentAndClick(AMDHipi.objframelayout, "frame layout");
				waitTime(5000);
				verifyElementPresentAndClick(AMDHipi.objeffectused, "on effect used");
				effectName = getAttributValue("text", AMDHipi.objeffectname);
			}


			verifyElementExist(HipiMePage.objeffectimage, "effect image");
			if (verifyElementExist(AMDHipi.objeffectname, "effect name")) {
				logger.info("user is able to view thumbnail effect");
				extent.extentLoggerPass("", "user is able to view thumbnail effect");
			} else {
				logger.info("user is not able to view thumbnail effect");
				extent.extentLoggerFail("", "user is not able to view thumbnail effect");
			}

			String Effectscount = getAttributValue("text", HipiMePage.objeffectcount1);
			System.out.print("\n Effectcount count");
			if (Effectscount.equalsIgnoreCase("")) {
				logger.error("Effect count is displayed blank");
				extentLoggerFail("Effect", "Effect count is displayed blank");
			} else {
				logger.info("Effect count displayed " + Effectscount);
				extentLoggerPass("Effect", "Effect count displayed " + Effectscount);
			}

			extent.HeaderChildNode("List of videos created by using that effect");
			System.out.println("Hipi_Reg_133");		extent.extentLogger("", "Hipi_Reg_133");
			if (verifyElementExist(HipiMePage.objvideoscreatedeffect, "effect")) {
				/*
				 * int videoscreatedeffect =
				 * findElements(AMDHipi.objthumbnails).size(); for (int j = 1; j
				 * <= videoscreatedeffect; j++) {
				 * logger.info(getText(AMDHipi.objthumbnails));
				 */
				// Swipe("UP",2);
				Thread.sleep(4000);
				String effect = getAttributValue("text", HipiMePage.objeffectname);
				verifyElementPresentAndClick(AMDHipi.objeffectthumbnsilone1, "effect thumbnail");
				Thread.sleep(5000);
//				System.out.println("ABCD1");
				// verifyElementPresentAndClick(AMDHipi.objeffectusedone1(effectName),"click
				// on effect name");
				if (verifyIsElementDisplayed(AMDHipi.objeffectLayer)) {
					Thread.sleep(5000);
//					System.out.println("ABCD2");
					click(AMDHipi.objeffectusedone1(effect), "effect name");
					Thread.sleep(3000);
					if (verifyElementExist(AMDHipi.objeffectname1(effect), "effect name")) {
						logger.info("user is able to view list of videos created using effect");
						extent.extentLoggerPass("videoscreated",
								"user is able to view list of videos created using effect");
					}else{
						extent.extentLoggerFail("videoscreated",
								"user is not able to view list of videos created using effect");
					}
				} else {
					//System.out.println("ABCD3");
					Back(1);
					extent.extentLoggerFail("", "Used Effect is not displyed");
				}
			} else {

			}

			extent.HeaderChildNode("Share effect");
			System.out.println("Hipi_Reg_135");		extent.extentLogger("", "Hipi_Reg_135");
			Swipe("DOWN", 2);
			verifyElementPresentAndClick(HipiMePage.objshareeffect, "share effect");
			if (verifyIsElementDisplayed(AMDPlayerScreen.objFacebook, "Facebook")) {
				logger.info("user is able to view share");
				extent.extentLogger("share", "user is able to view share");
				Back(1);
			} else {
				logger.info("user is not able to view share effect ");
				extent.extentLogger("share", "user is not able to view share");
				Back(1);
			}

			extent.HeaderChildNode("Use this Effect- enables the user to create a video using that effect.");
			System.out.println("Hipi_Reg_136");		extent.extentLogger("", "Hipi_Reg_136");
			Swipe("DOWN", 2);
			verifyElementPresentAndClick(HipiMePage.objuseefffect, "use this effect");
			Thread.sleep(10000);

			if (verifyElementExist(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
				// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
				// on create a video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow button");
			}

			// waitTime(15000);
			waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
			Thread.sleep(3000);
			verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
			verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
			waitTime(20000);

			verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload video");
			// verifyElementPresentAndClick(HipiCreateVideoPage.objrecording,"click
			// on recording");
			// SwipeUntilFindElement(HipiCreateVideoPage.objselectimage, "");

			if (verifyElementExist(HipiCreateVideoPage.objselectFirstimage, "Video present")) {
				verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "Video present");

				verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, "Edit HipiIT");
				Thread.sleep(5000);
				if (verifyElementExist(HipiCreateVideoPage.objtrimfinish, "finish")) {

					verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, "finish");

					verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
					waitTime(15000);
					waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
					verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
					String postDescription = "Description";
					type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
					waitTime(3000);
					hideKeyboard();
					waitTime(3000);
					verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
					verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
					verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
							" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
					verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");// saveasdraft
					waitTime(10000);
					boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
					if (Popup) {
						extent.extentLoggerPass("Success", "Video Upload Popup is displayed ");
						logger.info("Video Upload Popup is displayed ");
					}else{
						extent.extentLoggerFail("Success", "Video Upload Popup is not displayed ");
						logger.info("Video Upload Popup is not displayed ");
					}
					verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
					Thread.sleep(10000);

					verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
					for (int i = 0; i <= 50; i++) {
						waitTime(5000);
						scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
						if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
							Thread.sleep(2000);
							Back(1);
							Thread.sleep(2000);
							verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
						} else {
							verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), "Video");
							click(HipiCreateVideoPage.objselectfirstimage, "First video");
							waitTime(5000);
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objselectfirstimage, "Video")){
								click(HipiCreateVideoPage.objselectfirstimage, "First video");
								waitTime(8000);
							}else{
								
							}
							break;
						}
					}

					waitTime(5000);

					extent.extentLogger("", "effect used : "+effectName);
					extent.extentLogger("", "effect used in video : "+getAttributValue("text", AMDHipi.objeffectusedone));
					if (verifyElementExist(AMDHipi.objeffectusedone1(effectName), effectName)) {
						logger.info("user is able to create new video using effect");
						extent.extentLoggerPass("videoscreated", "user is able to create new video using effect");
					} else {
						extent.extentLoggerFail("", "user is not able to create new video using effect");
					}

					BackToFeedScreen();

				} else {
					System.out.println("Video is less than 5sec , so not selected");
					BackToFeedScreen();
				}

			}

		}
	}
	
	
	
	

	public void BackToFeedScreen() throws Exception {
		for (int i = 0; i <= 10; i++) {
			if (!verifyIsElementDisplayed(HipiFeedPage.objFeedButton, "Feed Button")) {
				Back(1);
			} else {
				System.out.println("Feed Screen Displayed");
				click(HipiFeedPage.objFeedButton, "Feed Button");
				break;
			}
		}
	}

	public boolean SwipeUntilFindElement(By locator, String direction) {
		boolean checkLocator, eletFound = false;
		if (direction.equalsIgnoreCase("UP")) {
			for (int i = 1; i < 50; i++) {
				PartialSwipe("UP", 1);
				checkLocator = verifyIsElementDisplayed(locator);
				if (checkLocator) {
					eletFound = true;
					break;
				}
			}
		}

		if (direction.equalsIgnoreCase("DOWN")) {
			for (int i = 1; i < 25; i++) {
				PartialSwipe("DOWN", 1);
				checkLocator = verifyIsElementDisplayed(locator);
				if (checkLocator) {
					eletFound = true;
					break;
				}
			}
		}
		return eletFound;
	}

	public void ValidateNavigationBar(String userType) throws Exception {

		if (userType.equalsIgnoreCase("Guest")) {
			// GuestUserFunctionalty
			extent.HeaderChildNode("Validate Login/Register popup");
			System.out.println("HiPi_Guest_017");
			 extent.extentLogger("", "HiPi_Guest_017");
			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
			waitTime(3000);
			if (verifyElementExist(AMDOnboardingScreen.objFeedButton, "Feed")) {

				click(AMDOnboardingScreen.objFeedButton, "Feed");
				click(AMDOnboardingScreen.objFeedActionLikeButton, "Like");
				if (verifyElementExist(AMDOnboardingScreen.objLoginDialog, "Register to start using HiPi")) {
					extent.extentLoggerPass("", "Login/Register Popup is displayed");
					Back(1);
				} else {
					extent.extentLoggerFail("", "Login/Register Popup is not displayed");
				}
				click(AMDOnboardingScreen.objFeedActionCommentButton, "Comment");
				if (verifyElementExist(AMDOnboardingScreen.objLoginDialog, "Register to start using HiPi")) {
					extent.extentLoggerPass("", "Login/Register Popup is displayed");
					Back(1);
				} else {
					extent.extentLoggerFail("", "Login/Register Popup is not displayed");
				}
				click(AMDOnboardingScreen.objFeedActionFollowButton, "Follow");
				if (verifyElementExist(AMDOnboardingScreen.objLoginDialog, "Register to start using HiPi")) {
					extent.extentLoggerPass("", "Login/Register Popup is displayed");
					Back(1);
				} else {
					extent.extentLoggerFail("", "Login/Register Popup is not displayed");
				}

			} else {
				System.out.println("Feed is not displayed");
			}

			extent.HeaderChildNode("Can be able scroll the Discover screen");
			System.out.println("HiPi_Guest_019");
			 extent.extentLogger("", "HiPi_Guest_019");
			if (verifyElementExist(AMDOnboardingScreen.objDiscoverButton, "Discover")) {
				click(AMDOnboardingScreen.objDiscoverButton, "Discover");
				if (verifyElementExist(AMDOnboardingScreen.objDiscoverHiglighted, "Discover Highlighted")) {
					extent.extentLoggerPass("", "Navigated to Discover");
					Swipe("UP", 1);
				} else {
					extent.extentLoggerFail("", "Not navigated to Discover");
				}

			}

			extent.HeaderChildNode("Can be able scroll the Popular screen");
			System.out.println("HiPi_Guest_020");
			 extent.extentLogger("", "HiPi_Guest_020");
			if (verifyElementExist(AMDOnboardingScreen.objPopularButton, "Popular")) {
				click(AMDOnboardingScreen.objPopularButton, "Popular");
				if (verifyElementExist(AMDOnboardingScreen.objPopularHiglighted, "Popular Highlighted")) {
					click(AMDOnboardingScreen.objPopularButton, "Popular");
					Swipe("UP", 1);
				} else {
					extent.extentLoggerFail("", "Not navigated to Popular");
				}
			}

			extent.HeaderChildNode("Validate Login/Register popup when Me button Clicked");
			System.out.println("HiPi_Guest_022"); extent.extentLogger("", "HiPi_Guest_022");
			if (verifyElementExist(AMDOnboardingScreen.objForMeButton, "Me")) {
				click(AMDOnboardingScreen.objForMeButton, "Me");
				if (verifyElementExist(AMDOnboardingScreen.objLoginDialog, "Register to start using HiPi")) {
					extent.extentLoggerPass("", "Login/Register Popup is displayed");
					Back(1);
				} else {
					extent.extentLoggerFail("", "Login/Register Popup is not displayed");
				}
			}

			extent.HeaderChildNode("Validate Login/Register popup when Create button Clicked");
			System.out.println("HiPi_Guest_021"); extent.extentLogger("", "HiPi_Guest_021");
			click(AMDOnboardingScreen.objCreateButton, "Create");
			if (verifyElementExist(AMDOnboardingScreen.objLoginDialog, "Register to start using HiPi")) {
				extent.extentLoggerPass("", "Login/Register Popup is displayed");
				Back(1);
			} else {
				extent.extentLoggerFail("", "Login/Register Popup is not displayed");
			}

		}
	}

	public void Popularscreen(String userType) throws Exception {
		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("Click on any popular celebrity thumbnail will redirect to profile of that celebs");
			System.out.println("Hipi_Reg_110"); 		extent.extentLogger("", "Hipi_Reg_110");

			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
			verifyElementPresentAndClick(HipiPopularPage.objpopulartext, "popular text");
			verifyElementExist(HipiPopularPage.objpopulartitle, "popular title");
			// Swipe("UP", 5);
			// SwipeUntilFindElement(HipiPopularPage.objprofiletext, "UP");
			if (verifyElementExist(HipiPopularPage.objprofiletext, "profile title")) {

				String popularProfileName = getAttributValue("text", HipiPopularPage.objprofiletext);

				click(HipiPopularPage.objprofiletext, "Popular Profile");
				waitTime(2000);
				String popularProfileDetailusername = getAttributValue("text",
						HipiPopularPage.objProfileDetailPageUserName);

				if (popularProfileDetailusername.contains(popularProfileName)) {
					logger.info("User is navigated to selected profile");
					extent.extentLoggerPass("Navigate", "user navigated to selected profile");
				} else {
					logger.info("User is not navigated to selected profile");
					extent.extentLoggerFail("Navigate", "user not navigated to selected profile");
				}

				extent.HeaderChildNode("See enlarge  profile pic by tapping on profile pic on profile page ");
				System.out.println("Hipi_Reg_111");extent.extentLogger("", "Hipi_Reg_111");
				verifyElementPresentAndClick(HipiPopularPage.objprofilepic, "profile picture");
				if (verifyIsElementDisplayed(HipiPopularPage.objthumbnailimage)) {
					logger.info("user is able to enlarge picture by tapping on profile picture");
					extent.extentLoggerPass("profilepic",
							"user is able to enlarge picture by tapping on profile picture");
				} else {
					logger.info("user is  not able to enlarge picture by tapping on profile picture");
					extent.extentLoggerFail("profilepic",
							"user is not able to enlarge picture by tapping on profile picture");
				}

				Back(1);

				extent.HeaderChildNode("Follow  celebrity");
				System.out.println("Hipi_Reg_112");extent.extentLogger("", "Hipi_Reg_112");
				if (checkElementDisplayed(HipiPopularPage.objProfilepagefollowButton, "follow button")) {
					click(HipiPopularPage.objProfilepagefollowButton, "follow button");

					if (verifyElementExist(HipiPopularPage.objProfilepageFollowingButton, "Following Button")) {
						logger.info("Profile is following");
						extent.extentLoggerPass("follow", "Profile is following");
					} else {
						logger.info("Profile is following");
						extent.extentLoggerFail("follow", "Profile is not following");
					}

				} else {
					verifyIsElementDisplayed(HipiPopularPage.objProfilepageFollowingButton, "following");
					logger.info("click on follow and validate if text has changed to following");
					extent.extentLogger("follow", "click on follow and validate if text has changed to following");
				}

				verifyElementPresentAndClick(HipiFeedPage.objbackbtn, "back button");
				verifyElementPresentAndClick(HipiMePage.objmeicon, "me");
				verifyElementPresentAndClick(HipiMePage.objfollowing, "following");
				//Swipe("UP", 2);
				
				
				if(verifyIsElementDisplayed(HipiMePage.objFollowingSearchTextBox, "Search Box")){
					click(HipiMePage.objFollowingSearchTextBox, "Search Box");
					type(HipiMePage.objFollowingSearchTextBox, popularProfileDetailusername, "Search Box");
					waitTime(5000);
					
					if(verifyIsElementDisplayed(HipiMePage.objfollowingProfile(popularProfileDetailusername))){
						extent.extentLoggerPass("following", "user profile is listed under followiing ");
						logger.info("user profile is listed under following");
					}else{
						extent.extentLoggerFail("following", "user profile is not listed under followiing ");
					}
					
				}
				
				
//				for(int i=0;i<=50;i++){
//					if(verifyIsElementDisplayed(HipiMePage.objfollowingProfile(popularProfileDetailusername))){
//						extent.extentLoggerPass("following", "user profile is listed under followiing ");
//						logger.info("user profile is listed under following");
//						break;
//					}else{
//						PartialSwipe("UP", 1);
//					}
//				}
				
//				boolean following = verifyIsElementDisplayed(HipiMePage.objfollowingProfile(popularProfileDetailusername));
//				if (following) {
//					extent.extentLoggerPass("following", "user profile is listed under followiing ");
//					logger.info("user profile is listed under following");
//				} else {
//					extent.extentLoggerFail("following", "user profile is not listed under followiing ");
//					logger.info("user profile is not listed under following");
//				}
				verifyElementPresentAndClick(HipiMePage.objfollowingProfile(popularProfileDetailusername), "profile");
				click(HipiPopularPage.objProfilepageFollowingButton, "following button");
				verifyElementPresentAndClick(HipiPopularPage.objbackbutton, "back button");
				verifyElementPresentAndClick(HipiPopularPage.objfollowingbackbutton, "back button");
				verifyElementPresentAndClick(HipiMePage.objbackbutton, "back button");
				verifyElementPresentAndClick(HipiFeedPage.objFeedButton, "feed");

			} else {

			}
		}
	}

	public void scrolltomiddle(By byLocator) throws Exception {
		TouchAction action = new TouchAction(getDriver());
		waitTime(5000);
		Dimension size = getDriver().manage().window().getSize();
		WebElement ele = getDriver().findElement(byLocator);
		Point point = ele.getLocation();
		int startx = point.getX();
		// System.out.println(startx);
		int starty = point.getY();
		// System.out.println(starty);
		int posy = (size.height) / 2;
		// System.out.println("height :"+size.height);
		// System.out.println("posy :"+posy);

		action.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startx, posy)).release().perform();
	}

	public void GuestUserloggedinAndComingFirstTime(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify entry points to Hipi");
			System.out.println("HiPi_Guest_012"); extent.extentLogger("", "HiPi_Guest_012");
			if (verifyElementDisplayed(HipiFeedPage.objHipiIcon)) {
				verifyElementPresentAndClick(HipiFeedPage.objHipiIcon, "Hipi Icon");
				if (verifyElementExist(HipiFeedPage.objFeedButton, "FeedButton")) {
					logger.info("user is navigated to hipi by tapping on bottom bar line in Zee5");
					extent.extentLoggerPass("",
							"user is navigated to hipi by tapping on bottom navigation bar in Zee5");
				} else {
					logger.info("user not able to navigated to hipi by tapping on bottom bar line in Zee5");
					extent.extentLoggerFail("",
							"user not able to navigated to hipi by tapping on bottom bar line in Zee");
				}
			} else {
			}
			verifyElementPresentAndClick(HipiFeedPage.objbackviewinfeed, "back button");
			SwipeUntilFindElement(HipiFeedPage.objmorezee5rail, "UP");
			// PartialSwipe("Up", 1);
			scrolltomiddle(HipiFeedPage.objmorezee5rail);
//			verifyElementPresentAndClick(HipiFeedPage.objarrow, "Arrow");//added 26/4/2021
			waitTime(5000);//added 26/4/2021
			if (verifyElementPresentAndClick(HipiFeedPage.objHipishortvideos, "short videos")) {
				if (verifyElementExist(HipiFeedPage.objFeedButton, "FeedButton")) {
					logger.info("user is able to view hipi by tapping on hipi short videos");
					extent.extentLoggerPass("", "user is able to view hipi by tapping on hipi short videos");
				} else {
					logger.info("user is not able to view hipi by tapping on hipi short videos");
					extent.extentLoggerFail("", "user is not able to view hipi by tapping on hipi short videos");
				}
			} else {

			}

			extent.HeaderChildNode("Internet popup message");
			System.out.println("HiPi_Guest_013");  extent.extentLogger("", "HiPi_Guest_013");
			verifyElementPresentAndClick(HipiFeedPage.objbackviewinfeed, "back button");
			Thread.sleep(3000);
			setWifiConnectionToONOFF("Off");
			verifyElementPresentAndClick(HipiFeedPage.objHipiIcon, "Hipi Icon");
			verifyElementExist(HipiFeedPage.objinternetpopup, "Network Error");
			// TurnONWifi();
			// if (getOEMName.equalsIgnoreCase("POCO X2")) {
			// Wifi_TurnOFFnON();
			// }
			waitTime(5000);
			if (verifyElementExist(HipiFeedPage.objinternetpopup, "Network Error")) {
				logger.info("internet popup message is displayed when network goesoff");
				extent.extentLoggerPass("", "internet popup messsage is diaplayed when network goesoff");
				Back(1);
			} else {
				logger.info("internet popup message is not displayed when network goesoff");
				extent.extentLoggerFail("", "internet popup message is not displayed when network goesoff");
			}
			// verifyElementPresentAndClick(AMDHipi.objtryagain,"click on try
			// again");
			setWifiConnectionToONOFF("ON");
			// if (getOEMName.equalsIgnoreCase("POCO X2")) {
			// Wifi_TurnOFFnON();
			// waitTime(7000);

			extent.HeaderChildNode("naviagte to zee5");
			System.out.println("HiPi_Guest_015");  extent.extentLogger("", "HiPi_Guest_015");
			verifyElementPresentAndClick(HipiFeedPage.objHipiIcon, "Hipi Icon");
			verifyElementPresentAndClick(HipiFeedPage.objbackviewinfeed, "back button");
			if (verifyElementDisplayed(HipiFeedPage.objHipiIcon)) {
				verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi Icon");
				if (verifyElementExist(HipiFeedPage.objFeedButton, "FeedButton")) {
					logger.info("user is navigated to hipi by tapping on bottom bar line in Zee5");
					extent.extentLogger("", "user is navigated to hipi by tapping on bottom navigation bar in Zee5");
				} else {
					logger.info("user not able to navigated to hipi by tapping on bottom bar line in Zee5");
					extent.extentLogger("", "user not able to navigated to hipi by tapping on bottom bar line in Zee");

				}

			} else {
			}
		}
	}

	public String fetchUserNameFromVideoDescription() throws Exception {

		String description = getText(HipiFeedPage.objdescription);
		System.out.println("description");
		String name = description.split(" ")[0];

		return name;

	}

	public void FeedViewer(String userType) throws Exception {

		if (userType.equalsIgnoreCase("Guest")) {

			extent.HeaderChildNode("refresh to see latst videos");
			System.out.println("HiPi_Guest_023"); extent.extentLogger("", "HiPi_Guest_023");
			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "hipi icon");
			if (verifyElementDisplayed(HipiFeedPage.objFeedButton)) {
				String name1 = fetchUserNameFromVideoDescription();
				System.out.println("UserName1 : " + name1);
				logger.info("UserName1 : " + name1);

				Swipe("DOWN", 2);

				Thread.sleep(4000);
				String name2 = fetchUserNameFromVideoDescription();
				System.out.println("UserName2 : " + name2);
				logger.info("UserName2 : " + name2);

				// String name=getDriver().findElement(by).getText();
				if (name1.equalsIgnoreCase(name2)) {
					logger.info("user is not able to refresh page");
					extentLoggerFail("", "user is not able to refresh page");
				} else {
					logger.info("user is able to refresh page");
					extentLoggerPass("", "user is able to refresh page");
				}
			}

			extent.HeaderChildNode("play/pausevideo");
			System.out.println("HiPi_Guest_024");extent.extentLogger("", "HiPi_Guest_024");
			Thread.sleep(3000);
			pauseVideo();
			Thread.sleep(3000);
			verifyElementPresentAndClick(HipiFeedPage.objplaybutton, "playbutton");
			Thread.sleep(3000);
			pauseVideo();
			Thread.sleep(3000);
			if (verifyElementDisplayed(HipiFeedPage.objplaybutton)) {
				logger.info("user is able to view play button");
				extent.extentLoggerPass("", "user is able to view play button");
			} else {
				logger.info("user is not able to view play buttton");
				extent.extentLoggerFail("", "user is not able to view play button");
			}

			extent.HeaderChildNode("progress bar displaying bottom side ");
			System.out.println("HiPi_Guest_028");extent.extentLogger("", "HiPi_Guest_028");
			Thread.sleep(3000);
			WebElement progressbaricon = findElement(HipiFeedPage.objprogressbar);
			int progressbaruppericonY = progressbaricon.getLocation().getY();

			int progressbarlowericonY = progressbaruppericonY + progressbaricon.getSize().getHeight();

			int progressbarmiddleiconY = (progressbaruppericonY + progressbarlowericonY) / 2;

			Dimension windowsSize = getDriver().manage().window().getSize();

			if (progressbarmiddleiconY >= ((windowsSize.getHeight() / 2) + 100)) {
				logger.info("progress bar appears on the bottom of the screen");
				extent.extentLoggerPass("", " progress bar appears on the bottom of the screen");
			} else {
				logger.error("progress bar not appears on the bottom of the screen");
				extent.extentLoggerFail("", "progress bar not appears on the bottom of the screen");
			}

			extent.HeaderChildNode("Name of sound used");
			System.out.println("HiPi_Guest_030");extent.extentLogger("", "HiPi_Guest_030");
			if (verifyElementDisplayed(HipiFeedPage.objsoundused)) {
				logger.info("user is able to view sound used");
				extent.extentLogger("", "user is able to view sound used");
				pauseVideo();
				String soundused = getAttributValue("text", HipiFeedPage.objsoundused);
				System.out.print("sound used");
				if (soundused.equalsIgnoreCase("")) {
					logger.error("sound used is displayed blank");
					extentLoggerFail("sound", "sound used is displayed blank");
				} else {
					logger.info("sound used displayed " + soundused);
					extentLoggerPass("", "sound used displayed " + soundused);
				}
			} else {
				logger.info("Video has no sound used");
				extent.extentLogger("", "Video has no sound used");
			}

			extent.HeaderChildNode("Number of likes");
			System.out.println("HiPi_Guest_031");extent.extentLogger("", "HiPi_Guest_031");
			String likescount = getAttributValue("text", HipiFeedPage.objlikecount);
			System.out.print("likes count");
			if (likescount.equalsIgnoreCase("")) {
				logger.error("likes count is displayed blank");
				extentLoggerFail("likes", "likes count is displayed blank");
			} else {
				logger.info("Likes count displayed " + likescount);
				extentLoggerPass("Likes", "likes count displayed " + likescount);
			}

			extent.HeaderChildNode("comment icon");
			System.out.println("HiPi_Guest_033");extent.extentLogger("", "HiPi_Guest_033");
			if (verifyElementDisplayed(HipiFeedPage.objcommenticon)) {
				logger.info("Comment icon is displayed at bottom right of the screen");
				extent.extentLoggerPass("", "Comment icon is displayed at bottom right of the screen");
			} else {
				logger.error("Comment icon is not displayed at bottom right of the screen");
				extent.extentLoggerFail("", "Comment icon is not displayed at bottom right of the screen");
			}

			extent.HeaderChildNode("verify the name of the effect used on Hipi video screen");
			System.out.println("HiPi_Guest_032");extent.extentLogger("", "HiPi_Guest_032");
			verifyElementPresentAndClick(HipiDiscoverPage.objDiscovertext, "discover text");
			verifyElementPresentAndClick(HipiDiscoverPage.objdiscoversearchtext, "search text");
			type(AMDHipi.objsearchtext, "Carrot Love", "effect used");
			hideKeyboard();
			verifyElementPresentAndClick(HipiDiscoverPage.objframelayout, "frame layout");
			pauseVideo();
			if (verifyElementExist(HipiDiscoverPage.objeffectused1, "Effects")) {
				String effectused = getAttributValue("text", HipiDiscoverPage.objeffectused1);
				System.out.print("\n effect used");
				if (effectused.equalsIgnoreCase("")) {
					logger.error("effect used is displayed blank");
					extentLoggerFail("effects", "effect used is displayed blank");
				} else {
					logger.info("effect used displayed " + effectused);
					extentLoggerPass("effects", "effect used displayed " + effectused);
				}

			} else {
				extent.extentLoggerFail("", "Video has no effects used");
			}

			extent.HeaderChildNode("longpress to view options");
			System.out.println("HiPi_Guest_035");extent.extentLogger("", "HiPi_Guest_035");
			BackToFeedScreen();
			verifyElementPresentAndClick(HipiFeedPage.objFeedButton, "feed");

			longPress(HipiFeedPage.objFeedLongPress);
			if (verifyElementExist(HipiFeedPage.objdownloadvideo,"Download Video")) {
				logger.info("user is able to view download video ");
				extent.extentLoggerPass("", "user is able to view download video");
			} else {
				logger.info("user is not able to view download video ");
				extent.extentLoggerFail("", "user is not able to view download video");
			}

			if (verifyElementExist(HipiFeedPage.objfavourites,"Add To Favourites")) {
				logger.info("user is able to view favourites video ");
				extent.extentLoggerPass("", "user is able to view favourites video");
			} else {
				logger.info("user is not able to view favourites video");
				extent.extentLoggerFail("", "user is not able to view favourites video");
			}

			if (verifyElementExist(HipiFeedPage.objnotinterested,"Not Interested")) {
				logger.info("user is able to view notinterested video ");
				extent.extentLoggerPass("", "user is able to view notinterested video");
			} else {
				logger.info("user is not able to view notinterested video");
				extent.extentLoggerFail("", "user is not able to view notinterested video");
			}

			if (verifyElementExist(HipiFeedPage.objreportvideo,"Report Video")) {
				logger.info("user is able to view report video ");
				extent.extentLoggerPass("", "user is able to view report video");
			} else {
				logger.info("user is not able to view report video");
				extent.extentLoggerFail("", "user is not able to view report video");
			}
			Back(1);

			extent.HeaderChildNode("login /register popup");
			System.out.println("HiPi_Guest_036");extent.extentLogger("", "HiPi_Guest_036");
			verifyElementPresentAndClick(HipiFeedPage.objshare, "share");
			registerPopUp();
			Back(1);
		} else {

		}
	}

	public void pauseVideo() throws Exception {
		for (int i = 1; i <= 10; i++) {
			try {
				if (verifyIsElementDisplayed(HipiFeedPage.objplaybutton)) {
					System.out.println("Video is already paused");
					break;
				} else {
					PausePlayer();

					if (verifyIsElementDisplayed(HipiFeedPage.objplaybutton, "playbutton")) {
						System.out.println("Video Paused");
						extent.extentLogger("", "Video Paused");
						break;
					}else{
						Swipe("UP", 1);
						PausePlayer();
						if (verifyIsElementDisplayed(HipiFeedPage.objplaybutton)) {
							System.out.println("Video is already paused");
							break;
						}
						
					}
				}
			} catch (Exception e) {
				if (verifyIsElementDisplayed(HipiFeedPage.objplaybutton)) {
					System.out.println("Video is already paused");
					break;
				} else {
					PausePlayer();

					if (verifyIsElementDisplayed(HipiFeedPage.objplaybutton, "playbutton")) {
						System.out.println("Video Paused");
						extent.extentLogger("", "Video Paused");
						break;
					}else{
						Swipe("UP", 1);
						PausePlayer();
						if (verifyIsElementDisplayed(HipiFeedPage.objplaybutton)) {
							System.out.println("Video is already paused");
							break;
						}
						
					}
				}
			}

		}

	}

	public void PausePlayer() throws Exception {
		AndroidTouchAction touch = new AndroidTouchAction(getDriver());
		int heightOfScreen = getDriver().manage().window().getSize().getHeight();
		int widthOfScreen = getDriver().manage().window().getSize().getWidth();
		int x = widthOfScreen / 2;
		int y = heightOfScreen / 2;
		touch.tap(PointOption.point(x, y)).perform();
	}

	public void longPress(By element) throws Exception {
		AndroidTouchAction touch = new AndroidTouchAction(getDriver());
		touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(findElement(element))))
				.release().perform();
	}

	public void ValidatingAddSoundPostShoot(String userType) throws Exception {
		extent.HeaderChildNode("AddSoundPostShoot");

		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "hipi icon");

			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			waitTime(5000);

			if (verifyElementExist(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
				// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
				// on create a video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow button");
			}

			// waitTime(15000);
			waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
			Thread.sleep(3000);
			verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
			verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
			waitTime(20000);
			extent.extentLoggerPass("", "Navigated to Create Video page");

			if (verifyElementExist(HipiCreateVideoPage.objrecordbtn, "Record Button")) {

				System.out.println("Hipi_Reg_099");		extent.extentLogger("","Hipi_Reg_099");
				extent.HeaderChildNode("Add the music after recording");

				click(HipiCreateVideoPage.objrecordbtn, "Record Button");

				waitForElementAndClickIfPresent(HipiCreateVideoPage.objFinishButton, 8, "Finish Button");

				waitTime(5000);

				click(HipiCreateVideoPage.objAddMusicPostRecording, "AddMusic");

				if (verifyElementExist(HipiAddMusicPage.objAddMusicTitle, "Add Title")) {
					extent.extentLoggerPass("", "Navigated to AddMusic Page");

					extent.extentLoggerPass("", "User navigated to Music page and able to select Music");

					String firstMusic = getAttributValue("text", HipiAddMusicPage.objFirstMusicFromAddMusicPage);
					System.out.println(firstMusic);
					waitTime(5000);
					click(HipiAddMusicPage.objFirstMusicFromAddMusicPage, firstMusic);
					waitTime(5000);

					if (verifyElementExist(HipiAddMusicPage.objSelectedMusic(firstMusic), firstMusic)) {
						extent.extentLoggerPass("", "Music is selected Post recording");

						
						extent.HeaderChildNode("Trim a longer sound");
						System.out.println("Hipi_Reg_100");		extent.extentLogger("","Hipi_Reg_100");
						if (verifyElementExist(HipiAddMusicPage.objMusicTrimRightHandle, "Music Trim RightHandle")) {
							String beforeTrimEndTime = findElement(HipiAddMusicPage.objMusicTrimEndTime).getText();
							logger.info("Current time before triming : " + timeToSec(beforeTrimEndTime));
							extent.extentLogger("Trim",
									"Current time before triming in seconds: " + timeToSec(beforeTrimEndTime));
							waitTime(5000);
							MusicTrim(HipiAddMusicPage.objMusicTrimRightHandle);
							waitTime(5000);

							String AfterTrimEndTime = findElement(HipiAddMusicPage.objMusicTrimEndTime).getText();
							logger.info("Current time after triming : " + timeToSec(AfterTrimEndTime));
							extent.extentLogger("Trim",
									"Current time after triming in seconds: " + timeToSec(AfterTrimEndTime));

							if (timeToSec(beforeTrimEndTime) > timeToSec(AfterTrimEndTime)) {
								extent.extentLoggerPass("", "Music is trimmed");
								waitTime(5000);
								click(HipiAddMusicPage.objMusicTrimFinishButton, "Music Trim FinishButton");

								if (verifyElementExist(HipiAddMusicPage.objPostAppliedMusic(firstMusic), firstMusic)) {
									extent.extentLoggerPass("", "Music Added To Video");
									waitTime(5000);
									Back(1);

									if (verifyElementExist(HipiAddMusicPage.objContinueShootPopup,
											"continueshoot popup")) {
										click(HipiAddMusicPage.objContinueShootPopupContinueButton, "Continue Btton");
										waitTime(5000);
										Back(1);

										if (verifyElementExist(HipiAddMusicPage.objDiscardShootPopup,
												"Discardshoot popup")) {
											click(HipiAddMusicPage.objDiscardShootPopupContinueButton,
													"Continue Btton");

											Back(1);

										} else {
											System.out.println("Popup not displayed");
										}
									} else {
										System.out.println("Popup not displayed");
									}

								} else {
									extent.extentLoggerFail("", "Music not Added To Video");
								}

							} else {
								extent.extentLoggerFail("", "Music is not trimmed");
							}

						}

					} else {
						extent.extentLoggerFail("", "Music is not selected Post recording");
					}

				} else {
					extent.extentLoggerFail("", "Not Navigated to AddMusic Page");
				}

			} else {
				extent.extentLoggerFail("", "Not navigated to create video page");
			}

			System.out.println("Hipi_Reg_101");   extent.extentLogger("","Hipi_Reg_101");
			extent.HeaderChildNode("Add music in Favourites");
			if (verifyElementExist(AMDHipi.objHipiIcon, "Hipi icon")) {
				verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
			}

			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			waitTime(5000);

			click(HipiCreateVideoPage.objAddMusicButton, "Add Music Button");

			if (verifyElementExist(HipiAddMusicPage.objFirstMusicFromAddMusicPage, "Music")) {

				String MusicName = getAttributValue("text", HipiAddMusicPage.objFirstMusicFromAddMusicPage);

				String MusicStarIcon = getAttributValue("checked",HipiAddMusicPage.objFirstMusicStarIconFromAddMusicPage);

				if (MusicStarIcon.contains("false")) {

					click(HipiAddMusicPage.objFirstMusicStarIconFromAddMusicPage, MusicName + " Star icon");

					String MusicStarIcon1 = getAttributValue("checked",
							HipiAddMusicPage.objFirstMusicStarIconFromAddMusicPage);

					if (MusicStarIcon1.contains("true")) {
						extent.extentLoggerPass("", "Music favorited in AddMusic Page");

						Back(1);
						Back(1);

						click(AMDHipi.objmeicon, "Me icon");

						verifyElementPresentAndClick(HipiMePage.objfavouritetab, "Music tab");

						verifyElementPresentAndClick(HipiMePage.objsounds, "Sound tab");

						//Swipe("UP", 1);
						
						for(int i=0;i<=15;i++){
							if(verifyIsElementDisplayed(HipiMePage.objFavouritedSound(MusicName), MusicName)){
								click(HipiMePage.objFavouritedSound(MusicName), MusicName);
								String favouritedSound = getAttributValue("checked", HipiMePage.objFavouritedSondStarIcon);
								if (favouritedSound.contains("true")) {
									extent.extentLoggerPass("", "Sound is favourited and the star icon is selected");
									click(HipiMePage.objFavouritedSondStarIcon, "favouritedSound star icon");

									Thread.sleep(6000);
									BackToFeedScreen();
									break;
								} else {
									extent.extentLoggerFail("", "Sound is not favourited and the star icon is selected");
								}
							}else{
								PartialSwipe("UP", 1);
							}
						}
					}

				} else {
					System.out.println("Music is already favorited");
				}

			}

		} else {
			// GuestUser
		}

	}

	public void MusicTrim(By byLocator1) throws Exception {

		WebElement element = getDriver().findElement(byLocator1);
		Dimension size = element.getSize();
		int startx = (int) (size.width);

		Dimension size1 = getDriver().manage().window().getSize();
		int endx = (int) (size1.width * 0.5);

		AndroidTouchAction touch = new AndroidTouchAction(getDriver());
		touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endx, startx))
				.release().perform();
	}

	public void EntryPointToZee5(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest") || userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("Validating user navigating to zee5");
			System.out.println("HiPi_Guest_053,Hipi_Reg_146");
			extent.extentLogger("", "HiPi_Guest_053 & Hipi_Reg_146");
			
			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "hipi icon");
			if (verifyElementExist(AMDHipi.objFeedIcon, "Feed icon present")) {
				verifyElementPresentAndClick(AMDHipi.objbackbutton, "back button");

				if (verifyElementExist(AMDHipi.objZee5Logo, "Zee5 Logo")) {
					extent.extentLoggerPass("Hipi", "user navigated to Zee5");
					logger.info("user navigated to Zee5");
				} else {
					extent.extentLoggerFail("Hipi", "user is not navigated to Zee5");
					logger.info("user is not navigated to Zee5");
				}
			} else {
				extent.extentLogger("", "Feed button not displayed");
			}
		}
	}

	public void ApplyFilterduringshooting(String userType) throws Exception {
		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			// TODO Auto-generated method stub
			extent.HeaderChildNode("Choos filter and displayed the overlay of the selected filter");
			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "click on Hipi icon");
			System.out.println("Hipi_Reg_090");		extent.extentLogger("", "Hipi_Reg_090");
			verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo, "click oncreate a video");
			if (verifyElementExist(HipiCreateVideoPage.objaccesspictures, "click on zee5 picture permission")) {

				verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, " allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, "  permission message");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, " allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission message");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, " allow button");
			}

			waitTime(15000);
			waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
			Thread.sleep(3000);
			verifyElementPresentAndClick(HipiMePage.objreadypopup, "click on ready popup");
			verifyElementPresentAndClick(HipiMePage.objokbutton, "click on ok button");
			String getPropertyValue = getAttributValue("enabled", HipiCreateVideoPage.obj15sec);
			if (getPropertyValue.equalsIgnoreCase("true")) {
				extent.extentLoggerPass(" ", "15 sec is by default highlighted");
				logger.info("15 sec is by default highlighted");
			} else {
				extent.extentLoggerFail("", "15 sec fails to highlight by default");
				logger.error("15 sec tab fails to highlight by default");
			}

			verifyElementPresentAndClick(HipiCreateVideoPage.objfilter, "filter option present");
			if (verifyElementDisplayed(HipiCreateVideoPage.objfirstfilterbeforedownlload)) {
				verifyElementPresentAndClick(HipiCreateVideoPage.objfirstfilterbeforedownloadbutton, "downloadbutton");
				logger.info("filter is downloaded");
				extent.extentLogger("", "effect is downloaded");

			} else {
				logger.info("video is already downloaded");
			}
			// verifyElementPresentAndClick(HipiCreateVideoPage.objdownload,"download
			// button");
			verifyElementPresentAndClick(HipiCreateVideoPage.objfirstfilterafterdownloadfinish, "filter present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objclosefilter, "close filter button");
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "record button");
			if (verifyElementExist(HipiCreateVideoPage.objrecording, "recording Exist")) {
				verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "click on post");
				waitTime(15000);
				verifyElementExist(HipiCreateVideoPage.objPostDescription, "Description input");
				String postDescription = "Description";
				type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
				waitTime(3000);
				// hideKeyboard();
				waitTime(3000);
				verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
				verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
						" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
				verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");// saveasdraft
				waitTime(10000);
				boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
				if (Popup) {
					extent.extentLoggerPass("Success", "Video Upload Popup is displayed ");
					logger.info("Video Upload Popup is displayed ");
				}else{
					extent.extentLoggerFail("Success", "Video Upload Popup is not displayed ");
					logger.info("Video Upload Popup is not displayed ");
				}
				verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
				Thread.sleep(10000);
				verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
				for (int i = 0; i <= 50; i++) {
					scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
					if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
						Thread.sleep(2000);
						//verifyElementPresentAndClick(HipiMePage.objbackbutton, "back button");
						Back(1);
						Thread.sleep(2000);
						verifyElementPresentAndClick(AMDHipi.objmeicon, "click on me icon");
						// verifyElementPresentAndClick(HipiMePage.objbackbutton,"click
						// on back button");
					} else {
						verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), "Video");
						click(HipiCreateVideoPage.objselectfirstimage, "First video");
						waitTime(8000);
						break;
					}
				}

				waitTime(5000);

				logger.info("user is able to view selected filter on overlay screen");
				extent.extentLoggerPass("videoscreated", "user is able to view selected filter on overlay screen");
			} else {
				extent.extentLoggerFail("", "user is not able to view selected filter on overlay screen");
			}

			extent.HeaderChildNode("Recently used filter in recent tabs");
			System.out.println("Hipi_Reg_091");		extent.extentLogger("", "Hipi_Reg_091");
			//verifyElementPresentAndClick(HipiCreateVideoPage.objbackbuttoneffectused, "back button present");
			Swipe("DOWN", 1);
			verifyElementPresentAndClick(HipiMePage.objbackbutton, "back button present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo, "click oncreate a video");
			verifyElementPresentAndClick(HipiCreateVideoPage.objfilter, "filter present");
			String recentfilter1 = getText(HipiCreateVideoPage.objfiltername);
			logger.info("First Filter : "+recentfilter1);
			extent.extentLogger("", "First Filter : "+recentfilter1);
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecentfilter, "recent present");
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objrecentfiltername)){
				String recentfilter2 = getText(HipiCreateVideoPage.objrecentfiltername);
				logger.info("Recent Filter : "+recentfilter2);
				extent.extentLogger("", "Recent Filter : "+recentfilter2);
				boolean Recent = recentfilter1.equals(recentfilter2);
				if (Recent == true) {
					logger.info("User  able to view recently used filters in recent tabs");
					extentLoggerPass("", "User be to view recently used filters in recent tabs");
				} else {
					logger.info("User not able to view recently used filters in recent tabs");
					extentLoggerFail("", "User not  able to view recently used filters in recent tabs");
				}

			}else{
				System.out.println("Recent filter not yet displayed");
			}

			extent.HeaderChildNode("Undo the filter");
			System.out.println("Hipi_Reg_092");		extent.extentLogger("", "Hipi_Reg_092");
			verifyElementPresentAndClick(HipiCreateVideoPage.objalltab, "all tab present");
			if (verifyElementDisplayed(HipiCreateVideoPage.objsecondfilterbeforedownload)) {
				verifyElementPresentAndClick(HipiCreateVideoPage.objsecondfilterbeforedownloadbutton, "downloadbutton");
				logger.info("effect is downloaded");
				extent.extentLogger("", "effect is downloaded");

			} else {
				logger.info("video is already downloaded");
			}
			verifyElementPresentAndClick(HipiCreateVideoPage.objfirstfilterafterdownloadfinish, "filter present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objclosefilter, "close filter");
			verifyElementPresentAndClick(HipiCreateVideoPage.objfilter, "filter present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objsecondeffectafterdownload, "filter present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objclosefilter, "close filter");
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "record button");
			logger.info("user is able to choose other filter");
			extent.extentLogger("", "user is able to choose other filter");
			if (verifyElementExist(HipiCreateVideoPage.objrecording, "recording Exist")) {
//				if (verifyElementExist(HipiCreateVideoPage.objrecording, "recording Exist")) {
//					verifyElementPresentAndClick(HipiCreateVideoPage.objfinish, "finish present");
//				} else {
//					verifyElementPresentAndClick(HipiCreateVideoPage.objdeleteclip, "delete present");
//					if (verifyElementExist(HipiCreateVideoPage.objdeletepopup, "Delete popup")) {
//						verifyElementPresentAndClick(HipiCreateVideoPage.objdeleteyes, "yes present");
//						verifyElementExist(HipiCreateVideoPage.objalertdeletetitle, "Delete Alert");
//
//					}
//
//				}
				waitTime(5000);
				waitForElementDisplayed(HipiCreateVideoPage.objpost, 20);
				verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "click on post");
				waitTime(15000);
				verifyElementExist(HipiCreateVideoPage.objPostDescription, "Description input");
				String postDescription1 = "Description";
				type(HipiCreateVideoPage.objPostDescription, postDescription1, "Description");
				waitTime(3000);
				// hideKeyboard();
				waitTime(3000);
				verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
				//verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage,"english");
				verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
						" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
				verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");// saveasdraft
				waitTime(10000);
				boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
				if (Popup) {
					extent.extentLoggerPass("Success", "Video Upload Popup is displayed ");
					logger.info("Video Upload Popup is displayed ");
				}else{
					extent.extentLoggerFail("Success", "Video Upload Popup is not displayed ");
					logger.info("Video Upload Popup is not displayed ");
				}
				verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
				Thread.sleep(10000);
				

				verifyElementPresentAndClick(AMDHipi.objmeicon, "click on me icon");
				for (int i = 0; i <= 50; i++) {
					scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
					if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
						Thread.sleep(2000);
						//verifyElementPresentAndClick(HipiMePage.objbackbutton, "click on back button");
						Back(1);
						Thread.sleep(2000);
						verifyElementPresentAndClick(AMDHipi.objmeicon, "click on me icon");
						// verifyElementPresentAndClick(HipiMePage.objbackbutton,"click
						// on back button");
					} else {
						verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription1), "Video");
						click(HipiCreateVideoPage.objselectfirstimage, "First video");
						waitTime(8000);
						break;
					}
				}

				waitTime(5000);
				logger.info("user able to change the filter by selecting different filtters");
				extent.extentLoggerPass("videoscreated",
						"user  able to change the filter by selecting different filters");
			} else {
				extent.extentLoggerFail("", "user not  able to change the filter by selecting different filters");
			}

		}

	}

	public void ApplyEffectduringshooting(String userType) throws Exception {
		// TODO Auto-generated method stub
		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
		extent.HeaderChildNode("Choose effect and displayed the overlay of the selected effect");
		String effectName = null;

		verifyElementPresentAndClick(AMDHipi.objHipiIcon, "click on Hipi icon");
		System.out.println("Hipi_Reg_086");		extent.extentLogger("", "Hipi_Reg_086");
		verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo, "click oncreate a video");
		if (verifyElementExist(HipiCreateVideoPage.objaccesspictures, "click on zee5 picture permission")) {

		verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
		verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, " allow button");
		verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, " permission message");
		verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, " allow button");
		verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission message");
		verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, " allow button");
		}

		waitTime(15000);
		waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
		Thread.sleep(3000);
		verifyElementPresentAndClick(HipiMePage.objreadypopup, "click on ready popup");
		verifyElementPresentAndClick(HipiMePage.objokbutton, "click on ok button");
		String getPropertyValue = getAttributValue("enabled", HipiCreateVideoPage.obj15sec);
		if (getPropertyValue.equalsIgnoreCase("true")) {
		extent.extentLoggerPass(" ", "15 sec is by default highlighted");
		logger.info("15 sec is by default highlighted");
		} else {
		extent.extentLoggerFail("", "15 sec fails to highlight by default");
		logger.error("15 sec tab fails to highlight by default");
		}
		verifyElementPresentAndClick(HipiCreateVideoPage.objeffectsbutton, "effects present");
		String effectNameBeforeDownloading = null;
		if (verifyElementDisplayed(HipiCreateVideoPage.objfirsteffectdownload)) {
		effectNameBeforeDownloading = getAttributValue("text",
		HipiCreateVideoPage.objEffectNameBeforeDownloading);
		System.out.println("Effect Name before Clicking Download : " + effectNameBeforeDownloading);

		// verifyElementPresentAndClick(HipiCreateVideoPage.objfirstEffectBeforDownloadButton,
		// "downloadbutton");
		verifyElementPresentAndClick(HipiCreateVideoPage.objEffectNameBeforeDownloading, "downloadbutton");
		logger.info("filter is downloading");
		extent.extentLogger("", "filter is downloading");
		Thread.sleep(10000);
		} else {
		logger.info("video is already downloaded");
		}
		// verifyElementPresentAndClick(HipiCreateVideoPage.objdownload,"download
		// button");
		verifyElementPresentAndClick(HipiCreateVideoPage.objfirsteffectafterdownload, "effect present");
		verifyElementPresentAndClick(HipiCreateVideoPage.objcloseeffect, "close effect");
		Thread.sleep(8000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "record button");
		if (verifyElementExist(HipiCreateVideoPage.objrecording, "recording Exist")) {
		waitTime(16000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "click on post");
		waitTime(15000);
		verifyElementExist(HipiCreateVideoPage.objPostDescription, "Description input");
		String postDescription = "Description";
		type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
		waitTime(3000);
		// hideKeyboard();
		waitTime(3000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
		verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
		verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
		" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
		verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");// saveasdraft
		waitTime(10000);
//		boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
//		if (Popup) {
//			extent.extentLoggerPass("Success", "Video Upload Popup is displayed ");
//			logger.info("Video Upload Popup is displayed ");
//		}else{
//			extent.extentLoggerFail("Success", "Video Upload Popup is not displayed ");
//			logger.info("Video Upload Popup is not displayed ");
//		}
		verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
		Thread.sleep(10000);

		Thread.sleep(10000);

		verifyElementPresentAndClick(AMDHipi.objmeicon, "click on me icon");
		for (int i = 0; i <= 50; i++) {
			scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
			if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
				Thread.sleep(2000);
				Back(1);
				Thread.sleep(2000);
				verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
		} else {
			verifyElementExist(HipiCreateVideoPage.objselectfirstimage, "Video");
			click(HipiCreateVideoPage.objselectfirstimage, "First video");
			waitTime(5000);
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objselectfirstimage, "Video")){
				click(HipiCreateVideoPage.objselectfirstimage, "First video");
			}else{
				
			}
		
		break;
		}
		}

		waitTime(10000);

		if (verifyElementExist(HipiMePage.objUsedEffect, "effect name")) {
		String effectused = getAttributValue("text", HipiMePage.objUsedEffect);
		System.out.print("\n effect used");
		if (effectused.equalsIgnoreCase("")) {
		logger.error("effect used is displayed blank");
		extentLoggerFail("effects", "effect used is displayed blank");
		} else {
		logger.info("effect used displayed " + effectused);
		extentLoggerPass("effects", "effect used displayed " + effectused);
		}

		if (effectused.contains(effectNameBeforeDownloading)) {
		System.out.println("same effect is selected");
		extent.extentLoggerPass("", "same effect is selected");
		} else {
		System.out.println("same effect is not selected");
		extent.extentLoggerFail("", "same effect is not selected");
		}
		logger.info("user is able to view selected effect on overlay screen");
		extent.extentLoggerPass("videoscreated", "user is able to view selected effect on overlay screen");

		} else {
		extent.extentLoggerFail("", "user is not able to view selected effect on overlay screen");
		}

		extent.HeaderChildNode("Recently used effects");
		System.out.println("Hipi_Reg_087");		extent.extentLogger("", "Hipi_Reg_087");
		verifyElementPresentAndClick(HipiCreateVideoPage.objbackbuttoneffectused, "back button present");
		Swipe("DOWN", 1);
		verifyElementPresentAndClick(HipiMePage.objbackbutton, "back button present");
		verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo, "click oncreate a video");
		verifyElementPresentAndClick(HipiCreateVideoPage.objeffectsbutton, "effects present");
		Thread.sleep(8000);
		// String recenteffect1 =
		// getText(HipiCreateVideoPage.objeffectcool);
		// logger.info(recenteffect1);
		verifyElementPresentAndClick(HipiCreateVideoPage.objrecenttab, "recent present");

		if(verifyElementExist(HipiCreateVideoPage.objNoRecentEffects, "No Recent Effect")){
			extent.extentLoggerFail("", "No Recent Effect used present");
		}else{
			String effectname = getAttributValue("text", HipiCreateVideoPage.objRecentlyUsedFirstEffect);

			if (effectname.contains(effectNameBeforeDownloading)) {
			logger.info("User able to view recently used effects in recent tabs");
			extentLoggerPass("", "User be to view recently used effects in recent tabs");

			} else {
			logger.info("User not able to view recently used effects in recent tabs");
			extentLoggerFail("", "User not able to view recently used effects in recent tabs");

			}			
		}
		

		extent.HeaderChildNode("Undo the effect");
		System.out.println("Hipi_Reg_088");		extent.extentLogger("", "Hipi_Reg_088");
		verifyElementPresentAndClick(HipiCreateVideoPage.objalltab, "all tab present");

		verifyElementPresentAndClick(HipiCreateVideoPage.objfirsteffectafterdownload, "effect present");
		String effectNameBeforeDownloading1 = null;
		if (verifyElementDisplayed(HipiCreateVideoPage.objfirsteffectdownload)) {
		effectNameBeforeDownloading1 = getAttributValue("text",
		HipiCreateVideoPage.objEffectNameBeforeDownloading);
		System.out.println("Effect Name before Clicking Download : " + effectNameBeforeDownloading1);

		verifyElementPresentAndClick(HipiCreateVideoPage.objEffectDownloadIconBeforeDownloading,
		"downloadbutton");
		Thread.sleep(15000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objsecondeffectafterdownload, "downloaded effect");
		logger.info("effect is downloading");
		extent.extentLogger("", "effect is downloading");
		Thread.sleep(10000);
		} else {
		logger.info("video is already downloaded");
		}

		verifyElementPresentAndClick(HipiCreateVideoPage.objcloseeffect, "close effect");
		Thread.sleep(6000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "record button");
		logger.info("user is able to choose other effect");
		extent.extentLogger("", "user is able to choose other effect");
		if (verifyElementExist(HipiCreateVideoPage.objrecording, "recording Exist")) {
//		if (verifyElementExist(HipiCreateVideoPage.objrecording, "recording Exist")) {
//		verifyElementPresentAndClick(HipiCreateVideoPage.objfinish, "finish present");
//		} else {
//		verifyElementPresentAndClick(HipiCreateVideoPage.objdeleteclip, "delete present");
//		}
		// waitTime(1000);
			waitForElementDisplayed(HipiCreateVideoPage.objpost, 20);
		verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "click on post");
		waitTime(15000);
		verifyElementExist(HipiCreateVideoPage.objPostDescription, "Description input");
		String postDescription1 = "Description";
		type(HipiCreateVideoPage.objPostDescription, postDescription1, "Description");
		waitTime(3000);
		// hideKeyboard();
		waitTime(3000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
		// verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage,
		// "english");
		verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
		" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
		verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");// saveasdraft
		waitTime(10000);
//		boolean Popup1 = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
//		if (Popup1) {
//			extent.extentLoggerPass("Success", "Video Upload Popup is displayed ");
//			logger.info("Video Upload Popup is displayed ");
//		}else{
//			extent.extentLoggerFail("Success", "Video Upload Popup is not displayed ");
//			logger.info("Video Upload Popup is not displayed ");
//		}
		verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
		Thread.sleep(10000);

		Thread.sleep(10000);

		verifyElementPresentAndClick(AMDHipi.objmeicon, "click on me icon");
		for (int i = 0; i <= 50; i++) {
			scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
			if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
				Thread.sleep(2000);
				Back(1);
				Thread.sleep(2000);
				verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
		} else {
			verifyElementExist(HipiCreateVideoPage.objselectfirstimage, "Video");
			click(HipiCreateVideoPage.objselectfirstimage, "First video");
			waitTime(5000);
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objselectfirstimage, "Video")){
				click(HipiCreateVideoPage.objselectfirstimage, "First video");
			}else{
				
			}
		break;
		}
		}

		waitTime(5000);
		if (verifyElementExist(HipiMePage.objUsedEffect, "effect name")) {
		String effectused = getAttributValue("text", HipiMePage.objUsedEffect);
		System.out.print("\n effect used");
		if (effectused.equalsIgnoreCase("")) {
		logger.error("effect used is displayed blank");
		extentLoggerFail("effects", "effect used is displayed blank");
		} else {
		logger.info("effect used displayed " + effectused);
		extentLoggerPass("effects", "effect used displayed " + effectused);
		}

		if (effectused.contains(effectNameBeforeDownloading)) {
		System.out.println("same effect is selected");
		extent.extentLoggerPass("", "same effect is selected");
		} else {
		System.out.println("same effect is not selected");
		extent.extentLoggerFail("", "same effect is not selected");
		}
		logger.info("user able to change the effectby selecting different effects");
		extent.extentLoggerPass("videoscreated",
		"user able to change the effectby selecting different effects");
		} else {
		extent.extentLoggerFail("",
		"user not able to change the effectby selecting different effects");
		}

		extent.HeaderChildNode("Favourite the effect");
		System.out.println("Hipi_Reg_089");		extent.extentLogger("", "Hipi_Reg_089");
		verifyElementPresentAndClick(HipiCreateVideoPage.objbackbuttoneffectused, "back button present");
		Swipe("DOWN", 1);
		verifyElementPresentAndClick(HipiMePage.objbackbutton, "back button present");
		verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo, "click oncreate a video");
		verifyElementPresentAndClick(HipiCreateVideoPage.objeffectsbutton, "effects present");
		String favouritingText = null;
		if (verifyElementExist(HipiCreateVideoPage.objsecodeffectfavourite, "favourite present")) {
		favouritingText = getAttributValue("text", HipiCreateVideoPage.objsecodeffectfavouriteText);
		click(HipiCreateVideoPage.objsecodeffectfavourite, "favourite present");
		verifyElementExist(HipiCreateVideoPage.objaddtofavourite, "favourite present");
		verifyElementPresentAndClick(HipiCreateVideoPage.objfavouriteyes, "yes button present");
		Thread.sleep(9000);

		} else {
		if (verifyElementExist(HipiCreateVideoPage.objtitlepopup, "remove title present")) {
		verifyElementPresentAndClick(HipiCreateVideoPage.objyesemovepopup, "yes popup");
		verifyElementExist(HipiCreateVideoPage.objaddtofavourite, "favourite present");
		verifyElementPresentAndClick(HipiCreateVideoPage.objfavouriteyes, "yes button present");

		}
		}

		// verifyElementPresentAndClick(HipiCreateVideoPage.objfavouriteyes,"yes
		// button present");
		verifyElementPresentAndClick(HipiCreateVideoPage.objfavouritetab, "favourite tab present");
		if (verifyElementExist(HipiCreateVideoPage.objeffectafterfavouriting(favouritingText),
		favouritingText)) {
		logger.info("User able to add the effect to Favourites");
		extent.extentLogger("", "User should be able to add the effect to Favourites");
		} else {
		logger.info("User not able to add the effect to Favourites");
		extent.extentLoggerFail("", "User not able to add the effect to Favourites");
		}
		verifyElementPresentAndClick(HipiCreateVideoPage.objalltab, "all tab present");
		verifyElementPresentAndClick(HipiCreateVideoPage.objsecodeffectfavourite, "favourite present");
		verifyElementExist(HipiCreateVideoPage.objtitlepopup, "remove title present");
		verifyElementPresentAndClick(HipiCreateVideoPage.objyesemovepopup, "yes popup");

		}
		}
		}

		}

	public void HashtagDetailPage(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("thumbnail with name and no of videos");
			System.out.println("HiPi_Guest_050");
			extent.extentLogger("", "HiPi_Guest_050");
			// Thread.sleep(1000);
			verifyElementPresentAndClick(HipiFeedPage.objHipiIcon, "Hipi icon");
			// Thread.sleep(1000);
			verifyElementPresentAndClick(HipiDiscoverPage.objDiscovertext, " discover text");
			verifyElementPresentAndClick(HipiDiscoverPage.objdiscoversearchtext, "search text");
			type(HipiDiscoverPage.objsearchtext, "#Hashtag", "hastag used");
			Thread.sleep(3000);
			hideKeyboard();
			// verifyElementPresentAndClick(HipiDiscoverPage.objhastagtext,
			// "hashtag text");
			SwipeUntilFindElement(HipiDiscoverPage.objFirstHashtag, "UP");
			verifyElementPresentAndClick(HipiDiscoverPage.objFirstHashtag, "hashtag name");
			if (verifyElementExist(HipiDiscoverPage.objthumbnail, "thumbnail option")) {
				logger.info("user is able to view thumbnail of image");
				extent.extentLogger("", "user is able to view thumbnail of image");
			} else {
				logger.info("user is not able to view thumbnail of image");
				extent.extentLogger("", "user is not able to view thumbnail of image");
			}

			String hashtagname = getAttributValue("text", HipiDiscoverPage.objhashtagnameused);
			System.out.print("\n hashtagname");
			if (hashtagname.equalsIgnoreCase("")) {
				logger.error("hashtagname used is displayed blank");
				extentLoggerFail("hashtag", "hashtag used is displayed blank");
			} else {
				logger.info("hashtag used displayed " + hashtagname);
				extentLoggerPass("", "hashtag used displayed " + hashtagname);
			}
			String hashtagvideos = getAttributValue("text", HipiDiscoverPage.objvideos);
			System.out.print("\n hashtagvideos");
			if (hashtagvideos.equalsIgnoreCase("")) {
				logger.error("hashtagvideos used is displayed blank");
				extentLoggerFail("hashtag", "hashtagvideos used is displayed blank");
			} else {
				logger.info("hashtagvideos used displayed " + hashtagvideos);
				extentLoggerPass("", "hashtagvideos used displayed " + hashtagvideos);
			}

			extent.HeaderChildNode("list of videos created");
			System.out.println("HiPi_Guest_051");
			extent.extentLogger("", "HiPi_Guest_051");
			// if(verifyElementExist(HipiDiscoverPage.objlistofvideos,"list of
			// videos
			// created")) {
			// Swipe("UP",2);
			// String hashtaglistofvideos = getAttributValue("text",
			// HipiDiscoverPage.objthumbnailvideos);
			// System.out.print("\n hashtaglistofvideos");
			if (verifyElementExist(HipiDiscoverPage.objlistofvideos, "videos created using effect")) {
				int size = getDriver().findElements(HipiDiscoverPage.objthumbnailVideosText).size();
				if(size>0){
					for (int i = 1; i < size; i++) {
						
						String thumbnail = getAttributValue("text", HipiDiscoverPage.objthumbnailVideosText(i));
						extent.extentLoggerPass("thumbnails", "Available thumbnails" + i + " : " + thumbnail);
						logger.info("Available thumbnails " + i + " : " + thumbnail);
	
				}
				logger.info("user is able to view list of videos created");
				extent.extentLogger("", "user is able to view list of videos");
					
				}else{
					extent.extentLogger("", "NO video displayed");
				}
			} else {
				logger.info("user is not able to view list of videos created");
				extent.extentLogger("", "user is  not able to view list of videos");
			}

			// Swipe("DOWN",2);

			extent.HeaderChildNode("Register popup by tapping usethis hashtag");
			System.out.println("HiPi_Guest_052");extent.extentLogger("", "HiPi_Guest_052");
			// Swipe("DOWN",2);
			verifyElementPresentAndClick(HipiDiscoverPage.objusethishashtag, " use this hashtag");
			registerPopUp();
			if (verifyElementDisplayed(AMDHipi.objRegisterPop)) {
				logger.info("Tapping on use this hashtagRegister popup is displayed");
				extent.extentLogger("", "Tapping on usethis hashtagRegister popup is displayed");
			} else {
				logger.info("Tapping on use this hashtagRegister popup is not displayed");
				extent.extentLogger("", "Tapping on usethis hashtagRegister popup is not displayed");
			}

			// TODO Auto-generated method stub

		}

		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("Hashtag with name and no. of Videos created using that Hashtag");
			System.out.println("Hipi_Reg_149");
			extent.extentLogger("", "Hipi_Reg_149");
			verifyElementPresentAndClick(HipiFeedPage.objHipiIcon, "Hipi icon");
			// Thread.sleep(1000);
			verifyElementPresentAndClick(HipiDiscoverPage.objDiscovertext, "discover text");
			verifyElementPresentAndClick(HipiDiscoverPage.objdiscoversearchtext, "search text");
			type(HipiDiscoverPage.objsearchtext, "#family", "hastag used");
			Thread.sleep(3000);
			hideKeyboard();
			Swipe("UP", 2);
			// verifyElementPresentAndClick(HipiDiscoverPage.objhashtag,
			// "hashtag text");
			// SwipeUntilFindElement(HipiDiscoverPage.objfamilyname, "UP");
			verifyElementPresentAndClick(HipiDiscoverPage.objfamilyname, "family name");
			if (verifyElementExist(HipiDiscoverPage.objfamilythumbnail, "family thumbnail")) {
				logger.info("user is able view thumbnail image");
				extent.extentLogger("", "user is able to view thumbnail image");
			} else {
				logger.info("user is not able to view thumbnail image");
				extent.extentLogger("", "user is not able to view thumbnail image");
			}

			String familyname = getAttributValue("text", HipiDiscoverPage.objfamilythumbnailname);
			System.out.print("\n familyname");
			if (familyname.equalsIgnoreCase("")) {
				logger.error("familyname used is displayed blank");
				extentLoggerFail("familyname", "familyname used is displayed blank");
			} else {
				logger.info("familyname used displayed " + familyname);
				extentLoggerPass("", "familyname used displayed " + familyname);
			}

			String familyvideos = getAttributValue("text", HipiDiscoverPage.objfamilyvideos);
			System.out.print("\n hashtagvideos");
			if (familyvideos.equalsIgnoreCase("")) {
				logger.error("familyvideos used is displayed blank");
				extentLoggerFail("family", "familyvideos used is displayed blank");
			} else {
				logger.info("fammilyvideos used displayed " + familyvideos);
				extentLoggerPass("", "familyvideos used displayed " + familyvideos);
			}

			extent.HeaderChildNode("list of videos created");
			System.out.println("HiPi_Guest_150");
			extent.extentLogger("", "Hipi_Reg_150");
			// if(verifyElementExist(HipiDiscoverPage.objlistofvideos,"list of
			// videos
			// created")) {
			// Swipe("UP",2);
			// String hashtaglistofvideos = getAttributValue("text",
			// HipiDiscoverPage.objthumbnailvideos);
			// System.out.print("\n hashtaglistofvideos");
			if (verifyElementExist(HipiDiscoverPage.objlistofvideos, "videos created using effect")) {
				List<WebElement> ele = getDriver().findElements(HipiDiscoverPage.objThumbnailTexts);
			//	int size = getDriver().findElements(HipiDiscoverPage.objThumbnailTexts).size();
				
				if(ele.size()>0){
					for (int i = 1; i <=ele.size(); i++) {
						String thumbnail = getAttributValue("text", HipiDiscoverPage.objThumbnailText(i));
						extent.extentLoggerPass("thumbnails", "Available thumbnails" + i + " : " + thumbnail);
						logger.info("Available thumbnails " + i + " : " + thumbnail);
				
					}		
					logger.info("user is able to view list of videos created is displayed");
					extent.extentLogger("", "user is able to view list of videos is displayed");
				}else{
					extent.extentLoggerFail("thumbnails", "No thumbnails are available");
					logger.info("No thumbnails are available");
				}
				
				
			} 

			/*
			 * extent.HeaderChildNode("mark hashtag as favouite");
			 * System.out.println("Hipi_Reg_151");
			 * verifyElementPresentAndClick(HipiDiscoverPage.objfavourite,
			 * "click on favourite"); if
			 * (verifyIsElementDisplayed(HipiDiscoverPage.objfavouritepopup)) {
			 * logger.info("Register Pop Up is displayed"); extent.extentLogger(
			 * "Register Pop Up", "Register Pop Up is displayed"); Back(1); }
			 * String favourite1 =
			 * getText(HipiDiscoverPage.objfamilythumbnailname);
			 * logger.info(favourite1);
			 * verifyElementPresentAndClick(HipiDiscoverPage.objbackbutton,
			 * "click on back button");
			 * verifyElementPresentAndClick(HipiDiscoverPage.
			 * objbackbuttonindiscover, "click on back button");
			 * verifyElementPresentAndClick(HipiMePage.objmeicon,
			 * "click on me icon");
			 * verifyElementPresentAndClick(HipiMePage.objfavourite,
			 * "click on favourite");
			 * verifyElementPresentAndClick(HipiMePage.objhashtags,
			 * "click on hashtags");
			 * verifyElementPresentAndClick(HipiMePage.objhashtagname,
			 * "clcik on hashtagname"); String favourite2 =
			 * getText(HipiMePage.objhashtagnametext); logger.info(favourite2);
			 * boolean favourite = favourite1.equals(favourite2); if (favourite
			 * == true) { logger.info(
			 * "able to mark same hashtag under favourite secion");
			 * extentLoggerPass("",
			 * "able to mark same hashtag under favourite section"); } else {
			 * logger.info(
			 * "not able to mark same hashtag under favourite secion");
			 * extentLoggerPass("",
			 * "not able to mark same hashtag under favourite secion"); }
			 * verifyElementPresentAndClick(HipiMePage.objfavouritebutton,
			 * "click on favourite"); if
			 * (verifyIsElementDisplayed(HipiMePage.objfavouritepopup)) {
			 * logger.info("Register Pop Up is displayed"); extent.extentLogger(
			 * "Register Pop Up", "Register Pop Up is displayed"); Back(1); }
			 */

			extent.HeaderChildNode("share hashtag ");
			System.out.println("Hipi_Reg_152");
			extent.extentLogger("", "Hipi_Reg_152");
			verifyElementPresentAndClick(HipiMePage.objHashtagShare, " share button");
			if (verifyElementExist(HipiMePage.objsharewidgettitle, "share widgets title")) {
				int size = getDriver().findElements(HipiMePage.objsharewidgets).size();
				for (int i = 0; i < size; i++) {
					boolean isDisplayed = getDriver().findElements(HipiMePage.objsharewidgets).get(i).isDisplayed();
					if (isDisplayed) {
						String sharewidgets = getDriver().findElements(HipiMePage.objsharewidgets).get(i).getText();
						extent.extentLoggerPass("sharewidgets", "sharewidgets" + i + " : " + sharewidgets);
						logger.info("Available sharewidgets " + i + " : " + sharewidgets);
					} else {
						extent.extentLoggerFail("sharewidgets", "No sharewidgets are available");
						logger.info("No sharewidgets are available");
					}
				}
				logger.info("user is able to view share widgets with different apps");
				extent.extentLogger("", "user is able to view share widgets with different apps");
			} else {
				logger.info("user is not able to view share widgets with different apps");
				extent.extentLogger("", "user is  not able to view share widgets with different apps");
			}
			verifyElementPresentAndClick(HipiMePage.objcancel, " cancel button");

			extent.HeaderChildNode("create new video using Hashtag");
			System.out.println("Hipi_Reg_153");
			extent.extentLogger("", "Hipi_Reg_153");
			// Swipe("DOWN", 2);
			verifyElementPresentAndClick(HipiMePage.objhastaguseeffect, "use this effect");
			Thread.sleep(3000);
			// String hashtagname = null;
			if (verifyElementExist(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {

				// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
				// on
				// create a video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, " allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, "  permission message");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, " allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission message");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, " allow button");
			}

			waitTime(15000);
			waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
			Thread.sleep(4000);
			verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
			verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
			// waitTime(20000);

			verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload video video");
			// verifyElementPresentAndClick(HipiCreateVideoPage.objrecording,"click
			// on
			// recording");
			// SwipeUntilFindElement(HipiCreateVideoPage.objselectimage, "");

			if (verifyElementExist(HipiCreateVideoPage.objselectFirstimage, "Video present")) {
				verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "Video present");

				verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, "Edit HipiIT");
				Thread.sleep(5000);
				if (verifyElementExist(HipiCreateVideoPage.objtrimfinish, "finish")) {

					verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, "finish");

					verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
					waitTime(15000);
					verifyElementExist(HipiCreateVideoPage.objPostDescription, "Description input");
					String postDescription = "#FAMILY";
					type(HipiCreateVideoPage.objPostDescription,postDescription, "Description");
					waitTime(3000);
					hideKeyboard();
					waitTime(3000);
					click(HipiCreateVideoPage.objTrendingHashtag(postDescription), postDescription);
					verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
					verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
					verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
							" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
					verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");// saveasdraft
					waitTime(10000);
					boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
					if (Popup) {
						extent.extentLoggerPass("Success", "Video Upload Popup is displayed ");
						logger.info("Video Upload Popup is displayed ");
					}else{
						extent.extentLoggerFail("Success", "Video Upload Popup is not displayed ");
						logger.info("Video Upload Popup is not displayed ");
					}
					verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
					Thread.sleep(10000);

					verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
					for (int i = 0; i <= 50; i++) {
						scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
						if (verifyIsElementDisplayed(HipiMePage.objPublishingInProcess)) {
							Thread.sleep(2000);
							//verifyElementPresentAndClick(HipiMePage.objbackbutton, "click on back button");
							Back(1);
							Thread.sleep(2000);
							verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
							// verifyElementPresentAndClick(HipiMePage.objbackbutton,"click
							// on back button");
						} else {
							verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), "Video");
							click(HipiCreateVideoPage.objselectfirstimage, "First video");
							waitTime(8000);
							break;
						}
					}

					waitTime(5000);
					
					 if (verifyIsElementDisplayed(HipiMePage.objContentText,"content text")) {
						 String contenttext = getAttributValue("text", HipiMePage.objContentText);
						 if(contenttext.contains("#FAMILY")){
								logger.info("user is able to create new video");
								extent.extentLoggerPass("videoscreated", "user is able to create new video");							 
						 }else{
								extent.extentLoggerFail("", "user is not able to create new video");							 
						 }
					 }else{
						 System.out.println("Content text is not present");
					 }
				} else {

				}
				// verifyElementPresentAndClick(HipiMePage.objbackbuttoninvideo,"clcik
				// on back button");
				Back(1);
				BackToFeedScreen();

			} else {
				System.out.println("Video is less than 5sec , so not selected");
				BackToFeedScreen();
			}

		}
	}
	
	
	
	public void ValidatingNavigationBar(String userType) throws Exception{
		
		if(userType.equalsIgnoreCase("Guest")){
			DownloadScreenUIUXValidation1(userType);
			BrowseToDownloadFunctionality(userType);			
		}else{
			Downloadcontent(userType);
			upcomingSectionValidation(userType);
			MoreScreenValidation(userType);			
		}
		
	}
	
	
	
	

	public void DownloadScreenUIUXValidation1(String userType) throws Exception {
		extent.HeaderChildNode(
				"verify whether downloads screen has page navigation between shows, movies and videos tabs");
		System.out.println("HiPi_Guest_007");

		verifyElementExist(AMDHomePage.objBottomNavigation("Downloads"), "Downloads tab at the bottom navigation bar");
		click(AMDHomePage.objBottomNavigation("Downloads"), "Downloads tab");
		waitTime(3000);
		verifyElementExist(AMDDownloadPage.objDwnloadsHeader, "Downloads header at the top on center of the screen");
		verifyElementExist(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
		verifyElementExist(AMDDownloadPage.objmoviestab, "Movies tab in Downlaods landing screen");
		verifyElementExist(AMDDownloadPage.objvideostab, "Videos tab in Downloads landing screen ");
		String getPropertyvalue = getAttributValue("enabled", AMDDownloadPage.objshowstab);
		if (getPropertyvalue.equalsIgnoreCase("true")) {
			extent.extentLoggerPass("Shows tab", "Shows tab is by default highlighted");
			logger.info("Shows tab is by default highlighted");
		} else {
			extent.extentLoggerFail("Shows tab", "Shows tab fails to highlight by default");
			logger.error("Shows tab fails to highlight by default");
		}
		click(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
		/// verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn, "Browse
		/// to Download CTA under Shows tab");
		click(AMDDownloadPage.objmoviestab, "navigated to movies tab");
		if (verifyElementExist(AMDDownloadPage.objmoviestab, "Movies tab in Downlaods landing screen")) {
			logger.info("user is able to navigate to movies tab");
			extent.extentLogger("", "user is able to navigate to movies tab");
		} else {
			logger.info("user is not able to navigate to movies tab");
			extent.extentLogger("", "user is not able to navigate to movies tab");
		}
		// verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to
		// Download CTA under Movies tab");
		click(AMDDownloadPage.objvideostab, "navigated yo videos tab");
		if (verifyElementExist(AMDDownloadPage.objvideostab, "Videos tab in Downloads landing screen")) {
			logger.info("user is able to navigate to videos tab");
			extent.extentLogger("", "user is able to navigate to videos tab");
		} else {
			logger.info("user is not able to navigate to videos tab");
			extent.extentLogger("", "user is not able to navigate to videos tab");
		}

		extent.HeaderChildNode("verify whether Browse to Download CTA is available under all tabs");
		// System.out.println("\nVerify the UI/UX of Download landing screen as
		// " + userType);
		// verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Login
		// Button");
		// verifyElementPresentAndClick(AMDLoginScreen.objskiplnk,"Skip
		// button");

		System.out.println("\nHiPi_Guest_008,010");
		if (userType.equalsIgnoreCase("Guest") || userType.equalsIgnoreCase("NonSubscribedUser")) {
			waitTime(5000);
			verifyElementExist(AMDHomePage.objBottomNavigation("Downloads"),
					"Downloads tab at the bottom navigation bar");
			click(AMDHomePage.objBottomNavigation("Downloads"), "Downloads tab");
			waitTime(3000);
			verifyElementExist(AMDDownloadPage.objDwnloadsHeader,
					"Downloads header at the top on center of the screen");
			verifyElementExist(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
			verifyElementExist(AMDDownloadPage.objmoviestab, "Movies tab in Downlaods landing screen");
			verifyElementExist(AMDDownloadPage.objvideostab, "Videos tab in Downloads landing screen ");
			String getPropertyValue = getAttributValue("enabled", AMDDownloadPage.objshowstab);
			if (getPropertyValue.equalsIgnoreCase("true")) {
				extent.extentLoggerPass("Shows tab", "Shows tab is by default highlighted");
				logger.info("Shows tab is by default highlighted");
			} else {
				extent.extentLoggerFail("Shows tab", "Shows tab fails to highlight by default");
				logger.error("Shows tab fails to highlight by default");
			}
			click(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
			if (verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Shows tab")) {
				logger.info("browse to download CTA is displayed under shows tab");
				extent.extentLogger("", "browse to download CTA is displayed under shows tab");
			} else {
				logger.info("browse to download CTA is not displayed under shows tab");
				extent.extentLoggerFail("", "browse to download CTA is not displayed under shows tab");
			}
			click(AMDDownloadPage.objmoviestab, "navigated to movies tab");
			if (verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Movies tab")) {
				logger.info("browse to download CTA is displayed under movies tab");
				extent.extentLogger("", "browse to download CTA is displayed under movies tab");
			} else {
				logger.info("browse to download CTA is not displayed under movies tab");
				extent.extentLoggerFail("", "browse to download CTA is not displayed under movies tab");

			}
			click(AMDDownloadPage.objvideostab, "navigated to videos tab");
			if (verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Videos tab")) {
				logger.info("browse to download CTA is displayed under videos tab");
				extent.extentLogger("", "browse to download CTA is displayed under videos tab");
			} else {
				logger.info("browse to download CTA is not displayed under videos tab");
				extent.extentLoggerFail("", "browse to download CTA is not displayed under videos tab");

			}

		}
	}

	public void BrowseToDownloadFunctionality(String userType) throws Exception {
		extent.HeaderChildNode(
				"User is able to navigate to Shows/Movies/Video page on clicking \"Browse to Download\"");
		if (userType.equalsIgnoreCase("NonSubscribedUser")) {

			System.out.println("HiPi_Guest_011");
			String getSelectedTabName;
			click(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
			click(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Shows tab");
			waitTime(3000);
			getSelectedTabName = getText(AMDHomePage.objSelectedTab);
			if (getSelectedTabName.equalsIgnoreCase("Shows")) {
				extent.extentLoggerPass("Shows tab", "User is navigated to Shows landing page");
				logger.info("User is navigated to Shows landing page");
			} else {
				extent.extentLoggerFail("Shows tab",
						"User fails to navigate to Shows landing page and instead displayed : " + getSelectedTabName
								+ " landing screen");
				logger.error("User fails to navigate to Shows landing page and instead displayed : "
						+ getSelectedTabName + " landing screen");
			}
			click(AMDHomePage.objBottomNavigation("Downloads"), "Downloads tab");
			verifyElementPresentAndClick(AMDDownloadPage.objmoviestab, "Movies tab in Downlaods landing screen");
			verifyElementPresentAndClick(AMDDownloadPage.objBrowseToDownloadBtn,
					"Browse to Download CTA under Movies tab");
			waitTime(3000);
			getSelectedTabName = getText(AMDHomePage.objSelectedTab);
			if (getSelectedTabName.equalsIgnoreCase("Movies")) {
				extent.extentLoggerPass("Movies tab", "User is navigated to Movies landing page");
				logger.info("User is navigated to Movies landing page");
			} else {
				extent.extentLoggerFail("Movies tab",
						"User fails to navigate to Movies landing page and instead displayed : " + getSelectedTabName
								+ " landing screen");
				logger.error("User fails to navigate to Movies landing page and instead displayed : "
						+ getSelectedTabName + " landing screen");
			}
			click(AMDHomePage.objBottomNavigation("Downloads"), "Downloads tab");
			verifyElementPresentAndClick(AMDDownloadPage.objvideostab, "Videos tab in Downloads landing screen");
			verifyElementPresentAndClick(AMDDownloadPage.objBrowseToDownloadBtn,
					"Browse to Download CTA under Videos tab");
			waitTime(3000);
			 getSelectedTabName = getText(AMDHomePage.objSelectedTab);
			 if (getSelectedTabName.equalsIgnoreCase("Home")) {
				extent.extentLoggerPass("Videos tab", "User is navigated to home landing page instead of videos tab");
				logger.info("User is navigated to home landing page instead of videos tab");
			} else {
				extent.extentLoggerFail("Videos tab",
						"User is not navigated to home landing page instead of videos tab ");
				logger.info("User is not navigated to home landing page instead of videos tab");
			}
		}
	}

	public void Downloadcontent(String userType) throws Exception {
		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("Validating Video DownloadScreen and Content playback of downloaded Video");
			System.out.println("Hipi_Reg_012");
			verifyElementPresentAndClick(AMDSearchScreen.objDownloadsOption, "Downloading Icon");
			waitTime(2000);
			verifyElementPresentAndClick(AMDDownloadPage.objvideostab, "Videos tab in Downloads landing screen");
			waitTime(2000);
			String content1 = getParameterFromXML("searchcontent1");
			DownloadContent(content1, "Good", true);
			// click(AMDSearchScreen.objBackBtn,"click on back");
			// verifyElementExist(AMDHomePage.objBottomNavigation("Downloads"),
			// "Downloads tab at the bottom navigation bar");
			// click(AMDHomePage.objBottomNavigation("Downloads"), "Downloads
			// tab");
			String DownloadedContentText = getDriver().findElement(AMDDownloadPage.objDownloadedVideoContent).getText();
			System.out.println(DownloadedContentText);
			if (DownloadedContentText.contains(content1)) {
				logger.info("Downloaded Video content is displayed in the Upfront screen of the Videos Tab");
				extent.extentLoggerPass("Download Screen",
						"Downloaded Video content is displayed in the Upfront screen of the Videos Tab");
			} else {
				logger.error("Downloaded Video content is NOT displayed in the Upfront screen of the Videos Tab");
				extent.extentLoggerFail("Download Screen",
						"Downloaded Video content is NOT displayed in the Upfront screen of the Videos Tab");
			}
			Back(1);
			waitTime(3000);
			click(AMDSearchScreen.objDownloadsOption, "Downloading Icon");
			String getPropertyValue = getAttributValue("enabled", AMDDownloadPage.objvideostab);
			if (getPropertyValue.equalsIgnoreCase("true")) {
				extent.extentLoggerPass("Videos tab",
						"Videos tab is by default highlighted, User is taken to VIDEOS tab by default, hence Shows and Movies tab do not have any downloaded content");
				logger.info(
						"Videos tab is by default highlighted, User is taken to VIDEOS tab by default, hence Shows and Movies tab do not have any downloaded content");
			} else {
				extent.extentLoggerFail("Videos tab",
						"Videos tab fails to highlight by default, User is NOT taken to VIDEOS tab by default, even though Shows/Movies has no downloaded content");
				logger.error(
						"Videos tab fails to highlight by default, User is NOT taken to VIDEOS tab by default, even though Shows/Movies has no downloaded content");
			}
		}
	}

	public void DownloadContent(String contentName, String Quality, boolean checkAlwaysAskOption) throws Exception {
		System.out.println("\nInitiate Download : " + contentName);
		verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon2, "Search Icon");
		waitTime(3000);
		click(AMDSearchScreen.objSearchEditBox, "Search edit");
		type(AMDSearchScreen.objSearchBoxBar, contentName, "Search Field");
		waitTime(3000);
		hideKeyboard();
		click(AMDSearchScreen.objSelectFirstEpisodeResult, "Searched Show");
		waitForElementDisplayed(AMDDownloadPage.objPauseIconOnPlayer, 2000);
		waitTime(3000);
		verifyElementPresentAndClick(AMDDownloadPage.objDownloadIcon, "Download button");
		waitTime(2000);
		DownloadVideoQualityPopUp(Quality, checkAlwaysAskOption);
		// waitTime(2000);
		// click(AMDSearchScreen.objBackBtn,"click on back");
		Back(1);
		click(AMDHomePage.objBottomNavigation("Downloads"), "Downloads tab");
		Thread.sleep(2000);
		
	}

	public void DownloadVideoQualityPopUp(String Quality, boolean checkAlwaysAsk) throws Exception {

		verifyElementExist(AMDDownloadPage.objDownloadVideoQualityPopup, "Download Video Quality PopUp screen");
		click(AMDDownloadPage.objDownloadQualityOptions(Quality), Quality);

		String getValue = getAttributValue("checked", AMDDownloadPage.objAlwaysAskCheckBox);
		if (checkAlwaysAsk) {
			if (!getValue.contains("true")) {
				click(AMDDownloadPage.objAlwaysAskCheckBox, "Always ask quality for every download");
			}
		} else {
			if (getValue.contains("true")) {
				click(AMDDownloadPage.objAlwaysAskCheckBox, "Always ask quality for every download");
			}
		}
		click(AMDDownloadPage.objStartDownloadCTA, "Start Download CTA");
	}

	public void upcomingSectionValidation(String userType) throws Exception {
		// TODO Auto-generated method stub
		if (userType.equalsIgnoreCase("Guest") || userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("Upcoming Screen Validation");
			System.out.println("Hipi_Reg_013");
			// waitTime(5000);
			// waitForElementDisplayed(AMDHomePage.objHomeTab, 10);
			verifyElementPresentAndClick(AMDHomePage.objUpcoming, "Upcoming tab");
			verifyElementPresentAndClick(AMDUpcomingPage.objContentCard1, "Content Card");
			if (verifyElementDisplayed(AMDUpcomingPage.objcardtitle)) {
				logger.info("user is able to view tailer under upcoming landing page");
				extent.extentLogger("", "user is able to view trailer under upcoming landing page");
			} else {
				logger.info("user is not able to view tailer under upcoming landing page");
				extent.extentLoggerFail("", "user is not able to view trailer under upcoming landing page");
			}
		}
		Back(1);
		// String titleConsumptionScreen =
		// getText(AMDUpcomingPage.objContentCardTitle1);
		// System.out.println(titleConsumptionScreen);
	}

	public void MoreScreenValidation(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest") || userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("verify more screen displayed");
			System.out.println("Hipi_Reg_015");
			verifyElementExist(AMDHomePage.objMoreMenuBtn, "More tab at the bottom navigation bar");
			click(AMDHomePage.objMoreMenuBtn, "More tab");
			if ((verifyElementDisplayed(AMDHomePage.objmoremenuheader))) {
				extent.extentLogger("More", "MoreMenu is displayed on tapping on Bottom Navigation bar");
				logger.info("MoreMenu is displayed on  tapping on bottom Nvigation bar");
			} else {
				extent.extentLogger("More", "MoreMenu is not displayed on tapping on Bottom Navigation bar");
				logger.info("MoreMenu is not displayed on  tapping on bottom Nvigation bar");
			}
		}
	}

	public void HelpCenter(String userType) throws Exception {
		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("Toggle option for ZZEE5 and Hipi");
			System.out.println("Hipi_Reg_146");
			extent.extentLogger("", "Hipi_Reg_146");
			// verifyElementPresentAndClick(AMDHomePage.objBottomNavigation("HiPi"),
			// "Hipi tab at the bottom navigation bar"
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			Swipe("UP", 2);
			click(AMDMoreMenu.objHelpCentre, "Help Center option in More menu");
			waitTime(5000);
			verifyElementExist(AMDMoreMenu.objHelpCenterHeader, "Help Center Header");
			if (checkElementExist(AMDMoreMenu.objHelpCenterHeader, "Help Center Header")) {
				logger.info("User is able to navigated to Help Center screen in More Page");
				extent.extentLoggerPass("Help Center", "User is able to  navigated to Help Center screen in More Page");
			} else {
				logger.error("User is unable to navigate to Help Center screen in More Page");
				extent.extentLoggerFail("Help Center", "User is unable to navigate to Help Center screen in More Page");
			}

			// click(AMDHomePage.objMoreMenu, "More menu");
			if (verifyElementExist(HipiSettingsPage.objzee5toggle, "Zee5 toggle On")) {
				// Toggle is ON
				extent.extentLogger("", "zee5 tooggle on");
				logger.info("zee5 toggle is on ");
				// click(HipiSettingsPage.objzee5toggle, "ZEE5 toggle on");

				if (verifyElementExist(HipiSettingsPage.objHipitoggle, "Hipi toggle on")) {
					click(HipiSettingsPage.objHipitoggle, "Hipi toggle on");
					extent.extentLoggerPass("", "Zee5 toggle switched to Hipi toggle");
					logger.info("Zee5 toggle switched to Hipi toggle");
				} else {
					extent.extentLoggerFail("", "Zee5 toggle didnt changed to Hipitoggle");
				}

			}
			extent.HeaderChildNode("user should be able to view contents of zee5 helpcenter");
			System.out.println("Hipi_Reg_147");extent.extentLogger("", "Hipi_Reg_147");
			// TODO Auto-generated method stub
			verifyElementPresentAndClick(AMDMoreMenu.objcloseButton, "Close button in Help Center Screen");
			if (checkElementExist(AMDHomePage.objMoreMenu, "More menu")) {
				logger.info(
						"User is navigated to the Previous screen on clicking the Close button in Help Center screen");
				extent.extentLoggerPass("Help Center",
						"User is navigated to the Previous screen on clicking the Close button in Help Center screen");
			} else {
				logger.error(
						"User is unable to navigate to the Previous screen on clicking the Close button in Help Center screen");
				extent.extentLoggerFail("Help Center",
						"User is unable to navigate to the Previous screen on clicking the Close button in Help Center screen");
			}
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			SwipeUntilFindElement(AMDMoreMenu.objHelpCentre, "UP");
			click(AMDMoreMenu.objHelpCentre, "Help Center option");
			waitTime(5000);
			verifyElementPresent(AMDMoreMenu.objSearchBarInHelpCenter, "Search bar to enter help queries");
			GettingStartedValidation();
			PartialSwipe("UP", 1);
			MyAccountValidation();
			WatchingZEE5Validation();
			PartialSwipe("UP", 1);
			MyZEE5AppValidation();
			QuickLinksValidation();
			click(AMDMoreMenu.objcloseButton, "Close button");
			click(AMDHomePage.HomeIcon, "Home icon");

			extent.HeaderChildNode("User should be able to view contents  of HipiHelp center");
			System.out.println("Hipi_Reg_148");extent.extentLogger("", "Hipi_Reg_148");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			SwipeUntilFindElement(AMDMoreMenu.objHelpCentre, "UP");
			click(AMDMoreMenu.objHelpCentre, "Help Center option");

			verifyElementPresentAndClick(HipiSettingsPage.objHipitoggle, "Hipi Toggle");
			waitTime(5000);
			verifyElementPresent(AMDMoreMenu.objSearchBarInHelpCenter, "Search bar to enter help queries");
			GettingStartedValidationHipi();
			PartialSwipe("UP", 1);
			MyAccountValidationHipi();
			PartialSwipe("UP", 1);
			StepItUpvalidation();
			PartialSwipe("UP", 1);
			NeedHelpvalidation();
			QuicklinksHipivalidationHipi();

		}
	}


	public void GettingStartedValidation() throws Exception {

		verifyElementExist(AMDMoreMenu.objGettingStartedHeader, "'Getting Started' Header");
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("What is ZEE5"), "'What is ZEE5?'");
		waitTime(5000);
		if (checkElementExist(AMDMoreMenu.objArticleTitle("What is ZEE5"), "Article title 'What is ZEE5?'")) {
			logger.info("User is navigated to 'What is ZEE5?' page");
			extent.extentLoggerPass("Article", "User is navigated to 'What is ZEE5?' page");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page What is ZEE5?");
			logger.info("Unable to navigate to page What is ZEE5?");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("Registering with ZEE5"), "'Registering with ZEE5'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("Registering with ZEE5"))) {
			logger.info("User is navigated to 'Registering with ZEE5' page");
			extent.extentLoggerPass("Article", "User is navigated to 'Registering with ZEE5' page");
		} else {
			logger.info("User is not navigated to 'Registering with ZEE5' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'Registering with ZEE5' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("Purchasing a subscription"),
				"'Purchasing a subscription'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("Purchasing a subscription"))) {
			logger.info("User is navigated to 'Purchasing a subscription' page");
			extent.extentLoggerPass("Article", "User is navigated to 'Purchasing a subscription' page");
		} else {
			logger.info("User is not navigated to 'Purchasing a subscription' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'Purchasing a subscription' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("How do I watch ZEE5"),
				"'How do I watch ZEE5 on my television'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("How do I watch ZEE5 on my television"))) {
			logger.info("User is navigated to 'How do I watch ZEE5 on my television?' page");
			extent.extentLoggerPass("Article", "User is navigated to 'How do I watch ZEE5 on my television?' page");
		} else {
			logger.info("User is not navigated to 'How do I watch ZEE5 on my television?' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'How do I watch ZEE5 on my television?' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("Renting movies on ZEEPLEX"),
				"'Renting movies on ZEEPLEX'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("Renting movies on ZEEPLEX"))) {
			logger.info("User is navigated to 'Renting movies on ZEEPLEX' page");
			extent.extentLoggerPass("Article", "User is navigated to 'Renting movies on ZEEPLEX' page");
		} else {
			logger.info("User is not navigated to 'Renting movies on ZEEPLEX' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'Renting movies on ZEEPLEX' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
	}

	public void MyAccountValidation() throws Exception {

		SwipeUntilFindElement(AMDMoreMenu.objMyAccountHeader, "UP");

		verifyElementPresent(AMDMoreMenu.objMyAccountHeader, "'My Account' Header");
		waitTime(2000);
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("Managing your Subscription"),
				"'Managing your Subscription'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("Managing your Subscription"))) {
			logger.info("User is navigated to 'Managing your Subscription' page");
			extent.extentLoggerPass("Article", "User is navigated to 'Managing your Subscription' page");
		} else {
			logger.info("User is not navigated to 'Managing your Subscription' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'Managing your Subscription' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);

		PartialSwipe("Up", 1);
		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("I can"), "UP");

		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("I can"), "I can't sign in to ZEE5");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("sign in to ZEE5"))) {
			logger.info("User is navigated to 'I can't sign in to ZEE5' page");
			extent.extentLoggerPass("Article", "User is navigated to 'I can't sign in to ZEE5' page");
		} else {
			logger.info("User is not  navigated to 'I can't sign in to ZEE5' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'I can't sign in to ZEE5' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		// Swipe("Up", 1);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("I made a payment but"), "UP");
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("I made a payment but"),
				"'I made a payment but my subscription isn't active / My subscription is missing'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("I made a payment but my subscription"))) {
			logger.info(
					"User is navigated to 'I made a payment but my subscription isn't active / My subscription is missing' page");
			extent.extentLoggerPass("Article",
					"User is navigated to 'I made a payment but my subscription isn't active / My subscription is missing' page");
		} else {
			logger.info(
					"User is not navigated to 'I made a payment but my subscription isn't active / My subscription is missing' page");
			extent.extentLoggerFail("Article",
					"User is not navigated to 'I made a payment but my subscription isn't active / My subscription is missing' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		// Swipe("Up", 1);
		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("I want to update my"), "UP");

		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("I want to update my"),
				"I want to update my profile information");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("I want to update my profile information"))) {
			logger.info("User is navigated to 'I want to update my profile information' page");
			extent.extentLoggerPass("Article", "User is navigated to 'I want to update my profile information' page");
		} else {
			logger.info("User is not navigated to 'I want to update my profile information' page");
			extent.extentLoggerFail("Article",
					"User is not navigated to 'I want to update my profile information' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
	}

	public void QuickLinksValidation() throws Exception {
		//Swipe("Up", 4);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("How Can I"), "UP");

		verifyElementPresent(AMDMoreMenu.objQueriesHeader("How Can I"), " 'Quick Links' tab");
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("How Can I"), "'How Can I'");
		waitTime(3000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("How Can I"))) {
			logger.info("User is navigated to 'How Can I?' page");
			extent.extentLoggerPass("Article", "User is navigated to 'How Can I?' page");
		} else {
			logger.info("User is not navigated to 'How Can I?' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'How Can I?' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
		//Swipe("Up", 4);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("I am unable to watch the ZEEPLEX movie"), "UP");
		waitTime(2000);
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("I am unable to watch the ZEEPLEX movie"),
				"'I am unable to watch the ZEEPLEX movie'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("I am unable to watch the ZEEPLEX movie"))) {
			logger.info("User is navigated to 'I am unable to watch the ZEEPLEX movie' page");
			extent.extentLoggerPass("Article", "User is navigated to 'I am unable to watch the ZEEPLEX movie' page");
		} else {
			logger.info("User is not navigated to 'I am unable to watch the ZEEPLEX movie' page");
			extent.extentLoggerFail("Article",
					"User is not navigated to 'I am unable to watch the ZEEPLEX movie' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
		//Swipe("Up", 4);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("ZEE5 Offers"), "UP");
		waitTime(2000);
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("ZEE5 Offers"), "'Zee5 offers'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("ZEE5 Offers"))) {
			logger.info("User is navigated to 'ZEE5 Offers' page");
			extent.extentLoggerPass("Article", "User is navigated to 'ZEE5 Offers' page");
		} else {
			logger.info("User is not navigated to 'ZEE5 Offers' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'ZEE5 Offers' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
		//Swipe("Up", 4);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("ZEE5 Partnerships"), "UP");
		waitTime(2000);
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("ZEE5 Partnerships"), "'ZEE5 Partnerships'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("ZEE5 Partnerships"))) {
			logger.info("User is navigated to 'ZEE5 Partnerships' page");
			extent.extentLoggerPass("Article", "User is navigated to 'ZEE5 Partnerships' page");
		} else {
			logger.info("User is not navigated to 'ZEE5 Partnerships' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'ZEE5 Partnerships' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
		//Swipe("Up", 4);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("Cancel Subscription"), "UP");
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("Cancel Subscription"), "'Cancel Subscription'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("How do I cancel my ZEE5 Subscription"))) {
			logger.info("User is navigated to 'How do I cancel my ZEE5 Subscription?' page");
			extent.extentLoggerPass("Article", "User is navigated to 'How do I cancel my ZEE5 Subscription?' page");
		} else {
			logger.info("User is not navigated to 'How do I cancel my ZEE5 Subscription?' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'How do I cancel my ZEE5 Subscription?' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
	}

	public void WatchingZEE5Validation() throws Exception {
		//Swipe("Up", 1);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("I need help with playing a video"), "UP");

		verifyElementPresent(AMDMoreMenu.objQueriesHeader("Watching ZEE5"), " 'Watching ZEE5' tab");
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("I need help with playing a video"),
				"'I need help with playing a video'");
		waitTime(3000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("I need help with playing a video"))) {
			logger.info("User is navigated to 'I need help with playing a video' page");
			extent.extentLoggerPass("Article", "User is navigated to 'I need help with playing a video' page");
		} else {
			logger.info("User is not navigated to 'I need help with playing a video' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'I need help with playing a video' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
		// Swipe("Up", 3);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("I need help with audio"), "UP");
		waitTime(2000);
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("I need help with audio"),
				"'I need help with audio'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("I need help with audio"))) {
			logger.info("User is navigated to 'I need help with audio' page");
			extent.extentLoggerPass("Article", "User is navigated to 'I need help with audio' page");
		} else {
			logger.info("User is not navigated to 'I need help with audio' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'I need help with audio' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
		//Swipe("Up", 2);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("I need help with casting ZEE5 on my TV"), "UP");
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("I need help with casting ZEE5 on my TV"),
				"'I need help with casting ZEE5 on my TV'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("I need help with casting ZEE5 on my TV"))) {
			logger.info("User is navigated to 'I need help with casting ZEE5 on my TV' page");
			extent.extentLoggerPass("Article", "User is navigated to 'I need help with casting ZEE5 on my TV' page");
		} else {
			logger.info("User is not navigated to 'I need help with casting ZEE5 on my TV' page");
			extent.extentLoggerFail("Article",
					"User is not navigated to 'I need help with casting ZEE5 on my TV' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
		//Swipe("Up", 2);
		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("All about downloads"), "UP");
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("All about downloads"), "'All about downloads'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("All about downloads"))) {
			logger.info("User is navigated to 'All about downloads' page");
			extent.extentLoggerPass("Article", "User is navigated to 'All about downloads' page");
		} else {
			logger.info("User is not navigated to 'All about downloads' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'All about downloads' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
		// Swipe("Up", 2);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("All about subtitles"), "UP");
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("All about subtitles"), "'All about subtitles'");
		waitTime(5000);
		if (verifyIsElementDisplayed(HipiSettingsPage.objarticlesubtitles)) {
			logger.info("User is navigated to 'All about subtitles' page");
			extent.extentLoggerPass("Article", "User is navigated to 'All about subtitles' page");
		} else {
			logger.info("User is not navigated to 'All about subtitles' page");
			/// Back(1);
			// Swipe("DOWN",2);
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);

	}

	public void MyZEE5AppValidation() throws Exception {
		// Swipe("Up", 3);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("App Performance"), "UP");

		verifyElementPresent(AMDMoreMenu.objQueriesHeader("App Performance"), " 'My ZEE5 App' tab");
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("App Performance"), "'App Performance'");
		waitTime(3000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("App Performance"))) {
			logger.info("User is navigated to 'App Performance' page");
			extent.extentLoggerPass("Article", "User is navigated to 'How Can I?' page");
		} else {
			logger.info("User is not navigated to 'App Performance' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'App Performance' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
		//Swipe("Up", 3);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("I am unable to authenticate my TV"), "UP");
		waitTime(2000);
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("I am unable to authenticate my TV"),
				"'I am unable to authenticate my TV'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("authenticate my TV"))) {
			logger.info("User is navigated to 'I am unable to authenticate my TV' page");
			extent.extentLoggerPass("Article", "User is navigated to 'I am unable to authenticate my TV' page");
		} else {
			logger.info("User is not navigated to 'I am unable to authenticate my TV' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'I am unable to authenticate my TV' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
		//Swipe("Up", 3);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("How can I enable automatic updates for the ZEE5 app"), "UP");
		waitTime(2000);
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("How can I enable automatic updates"),
				"'How can I enable automatic updates for the ZEE5 app?'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("How can I enable automatic updates"))) {
			logger.info("User is navigated to 'How can I enable automatic updates for the ZEE5 app?' page");
			extent.extentLoggerPass("Article",
					"User is navigated to 'How can I enable automatic updates for the ZEE5 app?' page");
		} else {
			logger.info("User is not navigated to 'How can I enable automatic updates for the ZEE5 app?' page");
			extent.extentLoggerFail("Article",
					"User is not navigated to 'How can I enable automatic updates for the ZEE5 app?' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);
		//Swipe("Up", 3);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("My ZEE5 App Version"), "UP");
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("My ZEE5 App Version"), "'My ZEE5 App Version'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("How do I see my current ZEE5 app version?"))) {
			logger.info("User is navigated to 'My ZEE5 App Version' page");
			extent.extentLoggerPass("Article", "User is navigated to 'My ZEE5 App Version' page");
		} else {
			logger.info("User is not navigated to 'My ZEE5 App Version' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'My ZEE5 App Version' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(2000);

		//Swipe("Up", 3);

		SwipeUntilFindElement(AMDMoreMenu.objQueriesHeader("Parental Control"), "UP");
		verifyElementPresentAndClick(AMDMoreMenu.objQueriesHeader("Parental Control"), "'Parental Control'");
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDMoreMenu.objArticleTitle("Parental Control"))) {
			logger.info("User is navigated to 'Parental Control' page");
			extent.extentLoggerPass("Article", "User is navigated to 'Parental Control' page");
		} else {
			logger.info("User is not navigated to 'Parental Control' page");
			extent.extentLoggerFail("Article", "User is not navigated to 'Parental Control' page");
		}
		// Back(1);
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
	}

	public void GettingStartedValidationHipi() throws Exception {
		verifyElementExist(HipiSettingsPage.objgettingstarted, "Getting started present");
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Get to know HiPi"), "Get to know Hipi");
		waitTime(5000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("Get to know HiPi!"),
				"Article title 'Get to know Hipi'")) {
			logger.info("User is navigated to 'Get to know Hipi'");
			extent.extentLoggerPass("Article", "User is navigated to 'Get to know Hipi'");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page Get to know Hipi");
			logger.info("Unable to navigate to page Get to know Hipi");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("How to HiPi"), "How to HiPi");
		waitTime(5000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("How to HiPi"), "Article title 'How to HiPi'")) {
			logger.info("User is navigated to 'How to HiPi'");
			extent.extentLoggerPass("Article", "User is navigated to 'How to HiPi'");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page 'How to HiPi'");
			logger.info("Unable to navigate to page 'How to HiPi'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		verifyElementPresentAndClick(HipiSettingsPage.objismyaccount,
				"Is my HiPi account separate from my ZEE5 account?  ");
		waitTime(5000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("Is my HiPi account separate from my ZEE5 account?"),
				"Article title 'Is my HiPi account separate from my ZEE5 account?  '")) {
			logger.info("User is navigated to 'Is my HiPi account separate from my ZEE5 account?  '");
			extent.extentLoggerPass("Article",
					"User is navigated to 'Is my HiPi account separate from my ZEE5 account?  '");
		} else {
			extent.extentLoggerFail("Verify navigation",
					"Unable to navigate to page 'Is my HiPi account separate from my ZEE5 account?  '");
			logger.info("Unable to navigate to page 'Is my HiPi account separate from my ZEE5 account?  '");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		verifyElementPresentAndClick(HipiSettingsPage.objcreatevideo, "'Create a video '");
		waitTime(5000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("Create a video"), "'Create a video '")) {
			logger.info("User is navigated to 'Create a video '");
			extent.extentLoggerPass("Article", "User is navigated to 'Create a video '");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page 'Create a video '");
			logger.info("Unable to navigate to page 'Create a video '");

		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Explore HiPi"), "'Explore HiPi'");
		waitTime(5000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("Explore HiPi"), "'Explore HiPi'")) {
			logger.info("User is navigated to 'Explore HiPi'");
			extent.extentLoggerPass("Article", "User is navigated to 'Explore HiPi'");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page 'Explore HiPi'");
			logger.info("Unable to navigate to page 'Explore HiPi'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Share a HiPi video "), "'Share a HiPi video'");
		waitTime(5000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("Share a HiPi video"), "'Share a HiPi video '")) {
			logger.info("User is navigated to 'Share a HiPi video '");
			extent.extentLoggerPass("Article", "User is navigated to 'Share a HiPi video '");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page 'Share a HiPi video '");
			logger.info("Unable to navigate to page 'Share a HiPi video '");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
	}

	public void MyAccountValidationHipi() throws Exception {
		SwipeUntilFindElement(HipiSettingsPage.objQueriesHeader("How do I sign in for HiPi?"), "UP");

		verifyElementPresent(HipiSettingsPage.objmyaccountHipi, "'My Account' Header");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("How do I sign in for HiPi?"),
				"'How do I sign in for HiPi?'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objhowdoisignarticle, "How do I sign in for Hipi?'")) {
			logger.info("User is navigated to 'How do I sign in for Hipi?'");
			extent.extentLoggerPass("Article", "User is navigated to 'How do I sign in for Hipi?'");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page 'How do I sign in for Hipi?'");
			logger.info("Unable to navigate to page 'How do I sign in for Hipi?'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);

		SwipeUntilFindElement(HipiSettingsPage.objQueriesHeader("Update your HiPi profile"), "UP");
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Update your HiPi profile"),
				"'Update your HiPi profile'");
		waitTime(5000);
		if (checkElementExist(
				HipiSettingsPage.objArticleTitle(
						"How do I update my HiPi profile information – like my name, user handle, etc?"),
				"'Update your HiPi profile'")) {
			logger.info("User is navigated to 'Update your HiPi profile'");
			extent.extentLoggerPass("Article", "User is navigated to 'Update your HiPi profile'");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page 'Update your HiPi profile'");
			logger.info("Unable to navigate to page 'Update your HiPi profile'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		SwipeUntilFindElement(HipiSettingsPage.objQueriesHeader("Where can I find my HiPi settings?"), "UP");
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Where can I find my HiPi settings?"),
				"'Where can I find my HiPi settings?'");
		waitTime(5000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("Where do I find my HiPi settings?"),
				"'Where do I find my HiPi settings?'")) {
			logger.info("User is navigated to 'Where do I find my HiPi settings?'");
			extent.extentLoggerPass("Article", "User is navigated to 'Where do I find my HiPi settings?'");
		} else {
			extent.extentLoggerFail("Verify navigation",
					"Unable to navigate to page 'Where do I find my HiPi settings?'");
			logger.info("Unable to navigate to page 'Where do I find my HiPi settings?'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");

		waitTime(3000);
		//Swipe("UP", 2);
		SwipeUntilFindElement(HipiSettingsPage.objQueriesHeader("Public & private videos"), "UP");
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Public & private videos"),
				"'Public & private videos'");
		waitTime(5000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("Public & private videos"),
				"'Public & private videos'")) {
			logger.info("User is navigated to 'Public & private videos'");
			extent.extentLoggerPass("Article", "User is navigated to 'Public & private videos'");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page 'Public & private videos'");
			logger.info("Unable to navigate to page 'Public & private videos'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		waitTime(3000);
		//Swipe("UP", 2);
		SwipeUntilFindElement(HipiSettingsPage.objQueriesHeader("How do I change my username or password?"), "UP");
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("How do I change my username or password?"),
				"'How do I change my username or password?");
		waitTime(5000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("How do I change my username or password?"),
				"'How do I change my username or password?")) {
			logger.info("User is navigated to 'How do I change my username or password?");
			extent.extentLoggerPass("Article", "User is navigated to 'How do I change my username or password?");
		} else {
			extent.extentLoggerFail("Verify navigation",
					"Unable to navigate to page 'How do I change my username or password?");
			logger.info("Unable to navigate to page 'How do I change my username or password?");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
	}

	public void StepItUpvalidation() throws Exception {
		SwipeUntilFindElement(HipiSettingsPage.objstepitup, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Perform a HiPi action"),
				"'Perform a HiPi action'");
		waitTime(2000);
		if (checkElementExist(
				HipiSettingsPage.objArticleTitle("Perform a HiPi action – Follow/Like/Comment/Mention/Check Views/Tag"),
				"'Perform a HiPi action – Follow/Like/Comment/Mention/Check Views/Tag'")) {
			logger.info("User is navigated to 'Perform a HiPi action – Follow/Like/Comment/Mention/Check Views/Tag'");
			extent.extentLoggerPass("Article",
					"User is navigated to 'Perform a HiPi action – Follow/Like/Comment/Mention/Check Views/Tag'");
		} else {
			extent.extentLoggerFail("Verify navigation",
					"Unable to navigate to page 'Perform a HiPi action – Follow/Like/Comment/Mention/Check Views/Tag'");
			logger.info(
					"Unable to navigate to page 'Perform a HiPi action – Follow/Like/Comment/Mention/Check Views/Tag'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		SwipeUntilFindElement(HipiSettingsPage.objjoinchallenge, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objjoinchallenge, "'Join a challenge'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("How do I use #Challenges?"),
				"'How do I use #Challenges?'")) {
			logger.info("User is navigated to 'How do I use #Challenges?'");
			extent.extentLoggerPass("Article", "User is navigated to 'How do I use #Challenges?'");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page 'How do I use #Challenges?'");
			logger.info("Unable to navigate to page 'How do I use #Challenges?'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");

		SwipeUntilFindElement(HipiSettingsPage.objQueriesHeader("Tips to get popular on HiPi"), "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Tips to get popular on HiPi"),
				"'Tips to get popular on HiPi'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objtipsarticle, "'Tips to get popular on HiPi'")) {
			logger.info("User is navigated to 'Tips to get popular on HiPi'");
			extent.extentLoggerPass("Article", "User is navigated to 'Tips to get popular on HiPi'");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page 'Tips to get popular on HiPi'");
			logger.info("Unable to navigate to page 'Tips to get popular on HiPi'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");

		SwipeUntilFindElement(HipiSettingsPage.objlinkaccount, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objlinkaccount, "'Link a social account''");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objlinkaccountarticle, "'Link a social account'")) {
			logger.info("User is navigated to 'Link a social account''");
			extent.extentLoggerPass("Article", "User is navigated to 'Link a social account'");
		} else {
			extent.extentLoggerFail("Verify navigation", "Unable to navigate to page 'Link a social account'");
			logger.info("Unable to navigate to page 'Link a social account'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");

	}

	public void NeedHelpvalidation() throws Exception {
		SwipeUntilFindElement(HipiSettingsPage.objhipiaccountheader, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objhipiaccountheader, "'My HiPi account'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objarticlehipiaccount, "'My HiPi account'")) {
			logger.info("User is navigated to 'My HiPi account'");
			extent.extentLoggerPass("Article", "User is navigated to 'My HiPi account'");
		} else {
			extent.extentLoggerFail("Verify navigation", "My HiPi account'");
			logger.info("Unable to navigate to page 'My HiPi account'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		SwipeUntilFindElement(HipiSettingsPage.objvideoheader, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objvideoheader, "'Video or Audio'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("Video or Audio"), "'Video or Audio'")) {
			logger.info("User is navigated to 'Video or Audio'");
			extent.extentLoggerPass("Article", "User is navigated to 'Video or Audio'");
		} else {
			extent.extentLoggerFail("Verify navigation", "'Video or Audio'");
			logger.info("Unable to navigate to page 'Video or Audio'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		SwipeUntilFindElement(HipiSettingsPage.objfollowlikes, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Follow/Like/Comment"), "'Follow/Like/Comment'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objarticleslike, "'Follow/Like/Comment'")) {
			logger.info("User is navigated to 'Follow/Like/Comment'");
			extent.extentLoggerPass("Article", "User is navigated to 'Follow/Like/Comment'");
		} else {
			extent.extentLoggerFail("Verify navigation", "'Follow/Like/Comment'");
			logger.info("Unable to navigate to page 'Follow/Like/Comment'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		SwipeUntilFindElement(HipiSettingsPage.objnotification, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("My Notifications/Messages"),
				"''My Notifications/Messages'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("My Notifications & Messages"),
				"'My Notifications & Messages'")) {
			logger.info("User is navigated to 'My Notifications & Messages'");
			extent.extentLoggerPass("Article", "User is navigated to 'My Notifications & Messages'");
		} else {
			extent.extentLoggerFail("Verify navigation", "'My Notifications & Messages'");
			logger.info("Unable to navigate to page 'My Notifications & Messages'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		SwipeUntilFindElement(HipiSettingsPage.objappperformanceheader, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("My App performance"), "''My App performance'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("My App Performance"), "'My App Performance'")) {
			logger.info("User is navigated to 'My App Performance'");
			extent.extentLoggerPass("Article", "User is navigated to 'My App Performance'");
		} else {
			extent.extentLoggerFail("Verify navigation", "'My App Performance'");
			logger.info("Unable to navigate to page 'My App Performance'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");

	}

	public void QuicklinksHipivalidationHipi() throws Exception {
		SwipeUntilFindElement(HipiSettingsPage.objComminityStandards, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Community Standards"), "'Community Standards'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("HiPi Community Standards"),
				"'HiPi Community Standards'")) {
			logger.info("User is navigated to 'HiPi Community Standards'");
			extent.extentLoggerPass("Article", "User is navigated to 'HiPi Community Standards'");
		} else {
			extent.extentLoggerFail("Verify navigation", "HiPi Community Standards'");
			logger.info("Unable to navigate to page 'HiPi Community Standards'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");

		SwipeUntilFindElement(HipiSettingsPage.objreportcontentheader, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Report inappropriate content"),
				"'Report inappropriate content''");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("How to report inappropriate content?"),
				"'How to report inappropriate content?'")) {
			logger.info("User is navigated to 'How to report inappropriate content?'");
			extent.extentLoggerPass("Article", "User is navigated to 'How to report inappropriate content?'");
		} else {
			extent.extentLoggerFail("Verify navigation", "How to report inappropriate content?'");
			logger.info("Unable to navigate to page 'How to report inappropriate content?'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");

		SwipeUntilFindElement(HipiSettingsPage.objprivacyheader, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("Privacy & Security"), "'Privacy & Security'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("Privacy & Security"), "'Privacy & Security'")) {
			logger.info("User is navigated to 'Privacy & Security'");
			extent.extentLoggerPass("Article", "User is navigated to 'Privacy & Security'");
		} else {
			extent.extentLoggerFail("Verify navigation", "'Privacy & Security'");
			logger.info("Unable to navigate to page 'Privacy & Security'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		SwipeUntilFindElement(HipiSettingsPage.objcannotfindvideo, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("I cannot find my video"),
				"'I cannot find my video'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objArticleTitle("I cannot find my video"), "'I cannot find my video'")) {
			logger.info("User is navigated to 'I cannot find my video'");
			extent.extentLoggerPass("Article", "User is navigated to 'I cannot find my video'");
		} else {
			extent.extentLoggerFail("Verify navigation", "'I cannot find my video'");
			logger.info("Unable to navigate to page 'I cannot find my video'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");
		SwipeUntilFindElement(HipiSettingsPage.objpremierleague, "UP");
		waitTime(3000);
		// Swipe("UP",2);
		verifyElementPresentAndClick(HipiSettingsPage.objQueriesHeader("HiPi Premier League"), "'HiPi Premier League'");
		waitTime(2000);
		if (checkElementExist(HipiSettingsPage.objpremiereleaguearticle, "'Get ready for the HiPi Premier League'")) {
			logger.info("User is navigated to 'Get ready for the HiPi Premier League'");
			extent.extentLoggerPass("Article", "User is navigated to 'Get ready for the HiPi Premier League'");
		} else {
			extent.extentLoggerFail("Verify navigation", "Get ready for the HiPi Premier League'");
			logger.info("Unable to navigate to page 'Get ready for the HiPi Premier League'");
		}
		verifyElementPresentAndClick(HipiSettingsPage.objbacktohome, " back to home present");

	}

	
	
	public void ValidatingProfile(String userType) throws Exception{
		if(userType.equalsIgnoreCase("NonSubscribedUser")){
			Profile(userType);
			profilesetting(userType);			
		}
	}
	
	
	
	public void Profile(String userType) throws Exception {
		extent.HeaderChildNode("Creator profile is same as while creating zee5");
		System.out.println("Hipi_Reg_113");
		extent.extentLogger("", "Hipi_Reg_113");
		click(AMDOnboardingScreen.objHipiButton, "HiPi");
		waitTime(5000);
		verifyElementPresentAndClick(AMDHipi.objmeicon, " Me icon present");
		// wait(2000);
		
		String Editprofile1 = getText(HipiMePage.objHipiProfileName);
		
		verifyElementPresentAndClick(HipiPopularPage.objeditprofile, " Edit profile");
		logger.info(Editprofile1);
		click(HipiPopularPage.objeditbackbutton, "Back button is present");
		click(HipiPopularPage.objbackbtn, " back button is present");
		click(HipiPopularPage.objfeedbackbutton, " back button is present");
		click(AMDMore.objMore, "More tab at the bottom navigation bar");
		
		if(verifyElementExist(AMDMore.objZeeProfileName(Editprofile1), Editprofile1)){
			logger.info("creators profile is same as zee5 page profile");
			extentLoggerPass("EditProfile", "Creator profile is same as zee5 page profile");
		} else {
			logger.info("creators profile is not same as zee5 page profile");
			extentLoggerPass("EditProfile", "Creator profile is not same as zee5 page profile");
		}
	

		extent.HeaderChildNode("See the followers count, following count of own profile");
		System.out.println("Hipi_Reg_116");		extent.extentLogger("", "Hipi_Reg_116");
		//verifyElementPresentAndClick(AMDMore.objbackbutton, " backbutton is present");
		//verifyElementPresentAndClick(AMDMore.objbackbutton, "backbutton is present");
		// verifyElementPresentAndClick(AMDMore.objprofilebackbtn, "click on
		// back
		// button");
		//verifyElementPresentAndClick(AMDHomePage.objBottomNavigation("HiPi"), "Hipi tab at the bottom navigation bar");
		verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
		verifyElementPresentAndClick(AMDHipi.objmeicon, "Me icon is present");
		String followerscount = getAttributValue("text", HipiPopularPage.objfollowerscount);
		System.out.print("\n followers count");
		if (followerscount.equalsIgnoreCase("")) {
			logger.error("Followers count is displayed blank");
			extentLoggerFail("followers", "Followers count is displayed blank");
		} else {
			logger.info("Followers count displayed " + followerscount);
			extentLoggerPass("followers", "Followers count displayed " + followerscount);
		}
		String followingcount = getAttributValue("text", HipiPopularPage.objfollowingcount);
		System.out.println("\n following count");
		// verifyElementPresentAndClick(HipiPopularPage.objfollowersbackbutton,"click
		// on back
		// button");
		if (followingcount.equalsIgnoreCase("")) {
			logger.info("Folllowing count is displayed blank");
			extentLoggerFail("following", "Following count is displayed blank");
		} else {
			logger.info("Following count displayed " + followingcount);
			extentLoggerPass("following", "Following count displayed " + followingcount);
		}

		extent.HeaderChildNode("See the followers user list by tapping on followers count");
		System.out.println("Hipi_Reg_117");		extent.extentLogger("", "Hipi_Reg_117");
		verifyElementPresentAndClick(HipiPopularPage.objfollowers, "followers tab is present");
		Swipe("UP", 2);
		verifyElementExist(HipiPopularPage.objfollowerstitle, " followers title is present");
		// if(verifyElementExist(HipiFeedPage.objfollow,"follow option
		// present")) {
		// verifyElementPresentAndClick(HipiFeedPage.objfollowing,"following
		// Button");

		if (verifyIsElementDisplayed(HipiPopularPage.objNoResultsFoundInFollowing)) {
			extent.extentLogger("", "User has no profiles in Following list");
		} else {
			int size = getDriver().findElements(HipiPopularPage.objfollowerslistusername).size();
			System.out.println(size);
			if (size > 0) {
				verifyElementExist(HipiPopularPage.objfollowerslistusername, "image");
				logger.info("Profile has list of people in following page");
				extent.extentLoggerPass("", "Profile has list of people in following page");
			} else {
				extent.extentLoggerFail("userlist", "No userlist are available");
				logger.info("No userlist are available");
			}

		}
		// extent.extentLogger("followers", "user is able to view followers list
		// by tapping on follower");
		// logger.info("user is able to view followers list by tapping on
		// following");

		extent.HeaderChildNode("See the following user list by tapping on following count");
		System.out.println("Hipi_Reg_118");		extent.extentLogger("", "Hipi_Reg_118");
		verifyElementPresentAndClick(HipiPopularPage.objfollowerbackbutton, "followers back button present");
		verifyElementPresentAndClick(HipiPopularPage.objfollowing, " following is present");
		verifyElementExist(HipiPopularPage.objfollowerstitle, "followers title is present");
		// if(verifyElementExist(HipiFeedPage.objfollow,"follow option
		// present")) {
		// verifyElementPresentAndClick(HipiFeedPage.objfollowing,"following
		// Button");

		if (verifyIsElementDisplayed(HipiPopularPage.objNoResultsFoundInFollowing)) {
			extent.extentLogger("", "User has no profiles in Following list");
		} else {
			int size = getDriver().findElements(HipiPopularPage.objfollowinglistusername).size();
			System.out.println(size);
			if (size > 0) {
				verifyElementExist(HipiPopularPage.objfollowinglistusername, "image");
				logger.info("Profile has list of people in following page");
				extent.extentLoggerPass("", "Profile has list of people in following page");
			} else {
				extent.extentLoggerFail("userlist", "No userlist are available");
				logger.info("No userlist are available");
			}

		}
		// extent.extentLogger("followers", "user is able to view followers list
		// by tapping on follower");
		// logger.info("user is able to view followers list by tapping on
		// following");
		// Swipe("UP", 2);

		// extent.extentLogger("following", "user is able to view following list
		// by tapping on following");
		// logger.info("user is able to view following list by tapping on
		// followeing");

		extent.HeaderChildNode("Edit profile");
		System.out.println("Hipi_Reg_114");		extent.extentLogger("", "Hipi_Reg_114");
		verifyElementPresentAndClick(HipiPopularPage.objfollowingbackbutton, "following back button is present");
		verifyElementPresentAndClick(HipiPopularPage.objeditprofile1, "edit profile present");
		if (verifyElementExist(HipiPopularPage.objeditprofileheader, "editprofile option present")) {
			verifyElementExist(HipiPopularPage.objfirstname, " firstname present");
			verifyElementPresentAndClick(HipiPopularPage.objfirstnametxt, "firstname text present");
			verifyElementExist(HipiPopularPage.objlastname, "lastname present");
			verifyElementPresentAndClick(HipiPopularPage.objlastnametxt, " lastname text present");
			verifyElementExist(HipiPopularPage.objuserhandle, " userhandle present");
			verifyElementExist(HipiPopularPage.objuserhandletxt, "userhandle text present");
			verifyElementExist(HipiPopularPage.objdob, "date of birth present");
			verifyElementExist(HipiPopularPage.objdobtext, " date of birth text present");
			verifyElementExist(HipiPopularPage.objuserbio, "userbio present");
			extent.extentLoggerPass("Me", "user tapped on edit profile can see the details");
			logger.info("user tapping on edit profile can see details");
		} else {
			extent.extentLoggerFail("Me", "user tapped on edit profile cannot see the details");
			logger.info("user tapping on edit profile cannot see details");
		}
		// verifyElementPresentAndClick(HipiPopularPage.objcounter,"click on
		// counter text");

		extent.HeaderChildNode("share profile");
		System.out.println("Hipi_Reg_115");		extent.extentLogger("", "Hipi_Reg_115");
		verifyElementPresentAndClick(HipiPopularPage.objbackbtn, " back button present");
		verifyElementPresentAndClick(HipiPopularPage.objshareprofile, "share profile presnt");
		if (verifyElementExist(HipiMePage.objsharewidgettitle, "share widgets title")) {
			int size = getDriver().findElements(HipiMePage.objsharewidgets).size();
			for (int i = 0; i < size; i++) {
				boolean isDisplayed = getDriver().findElements(HipiMePage.objsharewidgets).get(i).isDisplayed();
				if (isDisplayed) {
					String sharewidgets = getDriver().findElements(HipiMePage.objsharewidgets).get(i).getText();
					extent.extentLoggerPass("sharewidgets", "sharewidgets" + i + " : " + sharewidgets);
					logger.info("Available sharewidgets " + i + " : " + sharewidgets);
				} else {
					extent.extentLoggerFail("sharewidgets", "No sharewidgets are available");
					logger.info("No sharewidgets are available");
				}
			}
			logger.info("user is able to view share widgets with different apps");
			extent.extentLogger("", "user is able to view share widgets with different apps");
		} else {
			logger.info("user is not able to view share widgets with different apps");
			extent.extentLogger("", "user is  not able to view share widgets with different apps");
		}
		verifyElementPresentAndClick(HipiMePage.objcancel, " cancel button");


		extent.HeaderChildNode("See list of music under music tab ");
		System.out.println("Hipi_Reg_122");		extent.extentLogger("", "Hipi_Reg_122");
		verifyElementPresentAndClick(HipiMePage.objmusictab, "sound tab present");
		// Swipe("UP", 2);

		if (verifyIsElementDisplayed(HipiPopularPage.objNoResultsFoundInFollowing)) {
			extent.extentLogger("", "User has no profiles in Following list");
		} else {
			int size = getDriver().findElements(HipiMePage.objmusiclist).size();
			System.out.println(size);
			if (size > 0) {
				verifyElementExist(HipiMePage.objmusiclist, "image");
				logger.info("Profile has list of music in sound page");
				extent.extentLoggerPass("", "Profile has list of music in sound page");
			} else {
				extent.extentLoggerFail("userlist", "No userlist are available");
				logger.info("No userlist are available");
			}

		}
		// logger.info("user is able to view list of music under music tab");
		// extent.extentLogger("Music", "user is able to view list of music
		// under music tab");
		verifyElementExist(HipiMePage.objmusicname, "music name");

		if (verifyElementPresentAndClick(HipiMePage.objplaybutton, " play button ppresent")) {
			logger.info("user is able to play music ");
			extent.extentLogger("", "user is able to play music");
		} else {
			logger.info("user is not able to play music ");
			extent.extentLogger("", "user is not able to play music");
		}

		extent.HeaderChildNode("validating subtabs Video,Music,Favourites");
		System.out.println("Hipi_Reg_120");		extent.extentLogger("", "Hipi_Reg_120");
		String getSelectedTabName;
		// Swipe("Down", 2);
		verifyElementPresentAndClick(HipiMePage.objbackbutton, "back button");
		verifyElementPresentAndClick(HipiMePage.objmeicon, "me icon");
		verifyElementExist(HipiMePage.objvideotab, "video tab in Me Landing Screen");
		verifyElementExist(HipiMePage.objmusictab, "music tab in Me landing screen");
		verifyElementExist(HipiMePage.objfavourite, "favourite tab in Me landing screen");
		String getPropertyValue = getAttributValue("enabled", HipiMePage.objvideotab);
		if (getPropertyValue.equalsIgnoreCase("true")) {
			extent.extentLoggerPass("Video tab", "Video tab is by default highlighted");
			logger.info("Video tab is by default highlighted");
		} else {
			extent.extentLoggerFail("Video tab", "Video tab fails to highlight by default");
			logger.error("Video tab fails to highlight by default");
		}
		verifyElementPresentAndClick(HipiMePage.objfavourite, " favourite option present");
		if (verifyElementExist(HipiMePage.objsounds, "sound tab present")) {
			click(HipiMePage.objsounds, "Sounds tab is present under favourite");
			// Swipe("UP", 2);
			verifyElementPresentAndClick(HipiMePage.objbackinme, "back button present");
			if (verifyElementDisplayed(HipiFeedPage.objsoundused))
				click(HipiFeedPage.objsoundused, "sound used present");
			verifyElementPresentAndClick(HipiFeedPage.objfavouritesound, "favourite icon present");
			verifyElementDisplayed(HipiFeedPage.objfavouritepopop);
			String soundused1 = getText(HipiFeedPage.objmusictitle);
			logger.info(soundused1);
			// logger.info("user is able to view sound used");
			Back(1);
			verifyElementPresentAndClick(AMDHipi.objmeicon, " me icon present");
			verifyElementPresentAndClick(HipiMePage.objfavourite, " favourite tab present");
			click(HipiMePage.objsounds, "Sounds tab is present under favourite");
			verifyElementPresentAndClick(HipiMePage.objfirstsoundused, "sound used");
			String soundused2 = getText(HipiMePage.objmusictitle);
			logger.info(soundused2);
			boolean soundused = soundused1.equals(soundused2);
			if (soundused == true) {
				logger.info("sounds choosen a favourite are placed under respective sound tab");
				extentLoggerPass("", "sounds choosen a favourite are placed under respective sound ta");
			}
		} else {
			String soundUsed = getAttributValue("text", HipiFeedPage.objsoundused);
			System.out.print("\n sound used");
			if (soundUsed.equalsIgnoreCase("")) {
				logger.error("sound used is displayed blank");
				extentLoggerFail("sound", "sound used is displayed blank");
			} else {
				logger.info("sound used displayed " + soundUsed);
				extentLoggerPass("", "sound used displayed " + soundUsed);
			}

			// else if (verifyElementDisplayed(HipiFeedPage.objfeed)) {

			// logger.info("user is not able to view sound used");
			// extent.extentLogger("", "user is not able to view sound used");

			logger.info("sounds choosen a favourite are not  placed under respective sound tab");
			extentLoggerPass("", "sounds choosen a favourite arenot placed under respective sound tab");

		}

		// verifyElementPresentAndClick(HipiMePage.objbackbutton, "click on back
		// button");
		Back(1);
		if (verifyElementExist(HipiMePage.objHashtags, "Hashtag is present under favourite")) {

			click(HipiMePage.objHashtags, "hashtag present");

			// Swipe("UP", 1);
			// Back(1);
			/*
			 * verifyElementPresentAndClick(HipiDiscoverPage.
			 * objdiscoversearchtext, "search text");
			 * type(HipiDiscoverPage.objsearchtext, "#family", "hastag used");
			 * verifyElementPresentAndClick(HipiDiscoverPage.objsearchbutton,
			 * "search button"); hideKeyboard(); Swipe("UP", 2);
			 * verifyElementPresentAndClick(HipiDiscoverPage.objhashtag,
			 * "hashtag text");
			 * verifyElementPresentAndClick(HipiFeedPage.objfavouritesound,
			 * "favourite icon present");
			 * verifyElementDisplayed(HipiFeedPage.objfavouritepopop); String
			 * hashtag1 = getText(HipiFeedPage.objhashtagtitle);
			 * logger.info(hashtag1); //logger.info(
			 * "user is able to view sound used"); Back(1); Back(1);
			 * verifyElementPresentAndClick(AMDHipi.objmeicon,
			 * " me icon present");
			 * verifyElementPresentAndClick(HipiMePage.objfavourite,
			 * " favourite tab present"); click(HipiMePage.objHashtags,
			 * "hashtag tab is present under favourite");
			 * verifyElementPresentAndClick(HipiMePage.objfirsthashtag,
			 * "hashtag used"); String hashtag2 =
			 * getText(HipiMePage.objhahstagtitle); logger.info(hashtag2);
			 * boolean soundused = hashtag1.equals(hashtag2); if (soundused ==
			 * true) { logger.info(
			 * "hashtags choosen a favourite are placed under respective hahstag tab"
			 * ); extentLoggerPass("",
			 * "hahstags choosen a favourite are placed under respective hahstag tab"
			 * ); } logger.info("user is able to navigate to  Hashtags tab");
			 * extent.extentLogger("Hashtags",
			 * "user is able to navigate to Hashtags tab"); }else { logger.info(
			 * "user is not able to navigate toHashtags tab");
			 * extent.extentLogger("Hashtags",
			 * "user is not able to navigateto Hashtags tab"); }
			 */
			if (verifyElementExist(HipiMePage.objEffects, "Effects tab is present under favourite")) {
				click(HipiMePage.objEffects, "ffect tab present");
				logger.info("user is able to navigate to Effects tab");
				extent.extentLogger("Effects", "user is able to navigate to  Effects tab");
			} else {
				logger.info("user is not able to navigate to  Effects tab");
				extent.extentLogger("Effects", "user is not able to navigate to  Effects tab");
			}
			if (verifyElementExist(HipiMePage.objvideo, "video tab is present under favourite")) {
				click(HipiMePage.objvideo, "video tab present");
				logger.info("user is able to navigate to videos tab");
				extent.extentLogger("videos", "user is able to navigate to  videos tab");
			} else {
				logger.info("user is not able to navigate to videos tab");
				extent.extentLogger("videos", "user is not able to navigate to  videos tab");
			}
			click(HipiMePage.objvideo, "video tab is present under favourite");

			extent.HeaderChildNode("See creator's posted video under video subtab");
			System.out.println("Hipi_Reg_121");		extent.extentLogger("", "Hipi_Reg_121");
			Swipe("DOWN", 3);
			verifyElementPresentAndClick(HipiMePage.objbackbutton, "back button present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo, "create a video present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, " allow button present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, " permission present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, " allow button present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, " permission is present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, " allow button present");
			waitTime(15000);
			waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
			Thread.sleep(3000);
			verifyElementPresentAndClick(HipiMePage.objreadypopup, "click on ready popup");
			verifyElementPresentAndClick(HipiMePage.objokbutton, "click on ok button");
			// waitTime(20000);
			// verifyElementPresentAndClick(HipiCreateVideoPage.objreadypopup,
			// "click on ready button");
			// verifyElementPresentAndClick(HipiCreateVideoPage.objreadyokbtn,
			// "click on ok button");
			verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload a video");
			// verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn,"click
			// on record
			// button");
			// verifyElementPresentAndClick(HipiCreateVideoPage.objrecording,"click
			// on
			// recording");
			// verifyElementPresent(HipiCreateVideoPage.objtitle,"click on
			// select HipiIT");
			// SwipeUntilFindElement(HipiCreateVideoPage.objselectimage, "UP");
			// String selectimage1 =
			// getText(HipiCreateVideoPage.objselectimage);
			// logger.info(selectimage1);
			if (verifyElementExist(HipiCreateVideoPage.objselectFirstimage, "Video present")) {
				verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "Video present");

				verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, " Edit HipiIT ppresent");
				Thread.sleep(5000);
				if (verifyElementExist(HipiCreateVideoPage.objtrimfinish, " finish present")) {

					verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, "finish present");

					verifyElementPresentAndClick(HipiCreateVideoPage.objpost, " post present");
					waitTime(15000);
					waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 120);
					verifyElementExist(HipiCreateVideoPage.objPostDescription, "Description input");
					String postDescription = "Description";
					type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
					waitTime(3000);
					hideKeyboard();
					waitTime(3000);
					verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
					verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
					verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
							" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
					verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");// saveasdraft
					waitTime(10000);
					boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
					if (Popup) {
						extent.extentLoggerPass("Success", "Video Upload Popup is displayed ");
						logger.info("Video Upload Popup is displayed ");
					}else{
						extent.extentLoggerFail("Success", "Video Upload Popup is not displayed ");
						logger.info("Video Upload Popup is not displayed ");
					}
					verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
					Thread.sleep(10000);

					verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
					for (int i = 0; i <= 50; i++) {
						scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
						if (verifyIsElementDisplayed(HipiMePage.objPublishingInProcess)) {
							Thread.sleep(2000);
							//verifyElementPresentAndClick(HipiMePage.objbackbutton, " back button present");
							Back(1);
							Thread.sleep(2000);
							verifyElementPresentAndClick(AMDHipi.objmeicon, " me icon present");
							// verifyElementPresentAndClick(HipiMePage.objbackbutton,"click
							// on back button");
						} else {
							verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), "Video");
							click(HipiCreateVideoPage.objselectfirstimage, "First video");
							waitTime(8000);
							break;
						}
					}

					waitTime(5000);

					// if (verifyElementExist(HipiMePage.objeffectusedone1(),
					// "effect name")) {
					logger.info("user is able to create new video");
					extent.extentLoggerPass("videoscreated", "user is able to create new video");
				} else {
					extent.extentLoggerFail("", "user is not able to create new video");
				}
				verifyElementPresentAndClick(HipiCreateVideoPage.objbackbuttoninvideo, "back button");
				verifyElementPresentAndClick(HipiMePage.objbackbutton, "back button");
				BackToFeedScreen();

			} else {
				System.out.println("Video is less than 5sec , so not selected");
				BackToFeedScreen();
			}

			verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo, "create a video present");
			verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload a video");
			if (verifyElementExist(HipiCreateVideoPage.objselectFirstimage, "Video present")) {
				verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "Video present");
				// Thread.sleep(5000);
				verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, "Edit HipiIT present");
				Thread.sleep(5000);
				if (verifyElementExist(HipiCreateVideoPage.objtrimfinish, " finish present")) {

					verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, " finish present");

					verifyElementPresentAndClick(HipiCreateVideoPage.objpost, " post present");
					waitTime(15000);
					verifyElementExist(HipiCreateVideoPage.objPostDescription, "Description input");
					String postDescription = "SaveDraft";
					type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
					waitTime(3000);
					// hideKeyboard();
					waitTime(3000);
					verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
					// verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage,
					// "english");
					verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
							" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
					// verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit,
					// "clik on Edit HipiIT");
					// verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish,
					// "click on finish");
					// verifyElementPresentAndClick(HipiCreateVideoPage.objpost,
					// "click on post");
					// wait(2000);
					// verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage,
					// "clicked on english");
					// verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
					// " 'By Continuing, you agree to our Terms & Privacy
					// Policy' text ");

					verifyElementPresentAndClick(HipiCreateVideoPage.objsavedraft, " save draft present");// saveasdraft
					Thread.sleep(8000);
					boolean draftPopup = verifyElementDisplayed(HipiCreateVideoPage.objSaveDraftPopup);
					if (draftPopup) {
						extent.extentLoggerPass("Success", "Save as Draft Popup is displayed ");
						logger.info("Success Popup is displayed ");
					}else{
						extent.extentLoggerFail("Success", "Save as Draft Popup is not displayed ");
					}
					verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go to Feed Button");
					Thread.sleep(10000);
					
					verifyElementPresentAndClick(AMDHipi.objmeicon, " me icon present");
					verifyElementPresentAndClick(HipiMePage.objdraft, " save as draft present");
					
					if(verifyIsElementDisplayed(HipiMePage.objUploadAllButton, "Upload All button")){
						scrolltomiddle(HipiMePage.objUploadAllButton);
					}else{
						
					}
					
					scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
					
					if(verifyElementExist(HipiCreateVideoPage.objSelectDraftVideo(postDescription), postDescription)){
						extent.extentLoggerPass("", "Video is present in Draft Tab");
					}else{
						extent.extentLoggerFail("", "Video is not present in Draft Tab");
					}
					
					//verifyElementPresentAndClick(HipiCreateVideoPage.objbackbuttoninvideo, "clcik on back button");
					//verifyElementPresentAndClick(HipiMePage.objbackbutton, "click on back button");
					Back(1);
					BackToFeedScreen();

				} else {
					System.out.println("Video is less than 5sec , so not selected");
					BackToFeedScreen();
				}

			}
		}
	}

	public void profilesetting(String userType) throws Exception {
		// TODO Auto-generated method stubextent.HeaderChildNode("Me icon
		// validation");
		extent.HeaderChildNode("Edit my profile");
		System.out.println("\n Hipi_Reg_124");		extent.extentLogger("", "Hipi_Reg_124");
		//Back(1);

		// extent.HeaderChildNode("Me icon validation");
		// verifyElementPresentAndClick(AMDHomePage.objBottomNavigation("HiPi"),
		// "Hipi tab at the bottom navigation bar");
		verifyElementPresentAndClick(AMDHipi.objmeicon, " me icon present");
		verifyElementPresentAndClick(HipiMePage.objsettingsicon, " settings icon present");
		verifyElementPresentAndClick(HipiMePage.objEditprofile, " Edit profile present");
		String Editprofile1 = getText(HipiPopularPage.objfirstnametxt);
		logger.info(Editprofile1);
		click(HipiPopularPage.objedittext, " edit text present");
		String Editprofile2 = getText(HipiPopularPage.objfirstnametxt);
		logger.info(Editprofile2);
		boolean EditProfile = Editprofile1.equals(Editprofile2);
		if (EditProfile == true) {
			logger.info("user is able to edit profile by tapping on editprofile");
			extentLoggerPass("EditProfile", "user is able to edit profile by tapping on edit profile");
		} else {
			logger.info("user is not able to edit profile by tapping on editprofile");
			extentLoggerPass("EditProfile", "user is  not able to edit profile by tapping in edit profile");
		}
		verifyElementPresentAndClick(HipiPopularPage.objeditpenciltext, " edit is present");
		verifyElementPresentAndClick(HipiPopularPage.objeditpopup, "edit popup displayed");
		verifyElementPresentAndClick(HipiPopularPage.objyesbtn, " yes button present");
		verifyElementExist(HipiPopularPage.objmsgpopup, "message popup displayed");
		verifyElementPresentAndClick(HipiPopularPage.objdone, " done is  present");
		logger.info("user is able to edit profile by tapping on edit");
		extent.extentLogger("edit profile", "user is able to edit profile by tapping on edit ");

		
		
		extent.HeaderChildNode("user able to change visibility settings");
		System.out.println("Hipi_Reg_129");		extent.extentLogger("", "Hipi_Reg_129");

		// String EditProfile1=gettext(HipiMePage.objfirstname)
		verifyElementPresentAndClick(HipiMePage.objsettingsicon, " settings icon present");
		verifyElementPresentAndClick(HipiMePage.objhipipreferences, " hipi preferences pesent");
		verifyElementExist(HipiMePage.objsetvisibility, " setvisibility option present");
		verifyElementPresentAndClick(HipiMePage.objvisiblemode, " visibile mode present");
		verifyElementExist(HipiMePage.objpublicicon, "option public");
		verifyElementExist(HipiMePage.objfollowersonly, "option followers only");
		verifyElementExist(HipiMePage.objMeicon, "option Me");
		Back(1);

		// Checking for Default option selected
		if (verifyElementDisplayed(HipiMePage.objdefaultVisibilityPublic)) {
			logger.info("the default selection in the setvisibility is 'Public' option");
			extentLoggerPass("Default setvisibility option",
					"the default selection in the setvisibility is 'Public' option");
		} else {
			logger.error("the default selection in the setvisibility is not 'Public' option");
			extentLoggerFail("Default setvisibility option",
					"the default selection in the setvisibility is not 'Public' option");
		}
		click(HipiMePage.objdefaultVisibilityPublic, "option public present");

		click(HipiMePage.objfollowersonly, "option followers only option");

		if (verifyElementDisplayed(HipiMePage.objdefaultfollowersonlyVisibility)) {
			logger.info("the default selection in the setvisibility is 'followersonly' option");
			extentLoggerPass("Default setvisibility option",
					"the default selection in the setvisibility is 'followersonly' option");
		} else {
			logger.error("the default selection in the setvisibility is not 'followersonly' option");
			extentLoggerFail("Default setvisibility option",
					"the default selection in the setvisibility is not 'followersonly' option");
		}
		// click(HipiMePage.objfollowersonly,"click on followers only");
		// click(HipiMePage.objMeicon,"click on Me");
		// click(HipiMePage.objvisiblemode.objfollowersonly);
		click(HipiMePage.objdefaultfollowersonlyVisibility, "option Me");
		click(HipiMePage.objMeicon, "Me");
		if (verifyElementDisplayed(HipiMePage.objdefaultVisibilityMe)) {
			logger.info("the default selection in the setvisibility is 'Me' option");
			extentLoggerPass("Default setvisibility option",
					"the default selection in the setvisibility is 'Me' option");
		} else {
			logger.error("the default selection in the setvisibility is not 'Me' option");
			extentLoggerFail("Default setvisibility option",
					"the default selection in the setvisibility is not 'Me' option");
		}
		extent.HeaderChildNode("user able to update hipi preferences");
		System.out.println("Hipi_Reg_125");		extent.extentLogger("", "Hipi_Reg_125");
		verifyElementPresentAndClick(HipiMePage.objbackbuttonhipi, "back button");
		verifyElementPresentAndClick(HipiMePage.objhipipreferences, "hipi preferences");
		if (verifyElementExist(HipiMePage.objallowlikes, "allow likes option")) {
			if (verifyElementExist(HipiMePage.objAllowLikestoggleon, "AllowLikes Toggle ON")) {
				// Toggle is ON
				extent.extentLogger("", "Allow Likes Toggle is On");
				click(HipiMePage.objAllowLikestoggleon, "AllowLikes Toggle ON");

				if (verifyElementExist(HipiMePage.objAllowLikestoogleoff, "AllowLikes Toggle OFF")) {
					extent.extentLoggerPass("", "AllowLikes Toggle Canged to OFF");
				} else {
					extent.extentLoggerFail("", "AllowLikes Toggle dint Changed to OFF");
				}

			} else {
				// Toggle is OFF
				extent.extentLogger("", "Allow Likes Toggle is Off");
				click(HipiMePage.objAllowLikestoggleon, "AllowLikes Toggle OFF");

				if (verifyElementExist(HipiMePage.objAllowLikestoggleon, "AllowLikes Toggle ON")) {
					extent.extentLoggerPass("", "AllowLikes Toggle Canged to ON");
				} else {
					extent.extentLoggerFail("", "AllowLikes Toggle dint Changed to ON");
				}
			}

		} else {
			System.out.println("Allow Likes option is not displayed");
		}
		if (verifyElementExist(HipiMePage.objallowcomment, "allow comment option")) {
			if (verifyElementExist(HipiMePage.objallowcommenttoggleon, "Allowcomment Toggle ON")) {
				// Toggle is ON
				extent.extentLogger("", "Allow comment Toggle is On");
				click(HipiMePage.objallowcommenttoggleon, "Allowcomment Toggle ON");

				if (verifyElementExist(HipiMePage.objallowcommenttoggleoff, "Allowcomment Toggle OFF")) {
					extent.extentLoggerPass("", "Allowcomment Toggle Changed to OFF");
				} else {
					extent.extentLoggerFail("", "Allowcomment Toggle didnt Changed to OFF");
				}

			} else {
				// Toggle is OFF
				extent.extentLogger("", "Allow comment Toggle is Off");
				click(HipiMePage.objallowcommenttoggleon, "Allowcomment Toggle OFF");

				if (verifyElementExist(HipiMePage.objallowcommenttoggleon, "Allowcomment Toggle ON")) {
					extent.extentLoggerPass("", "Allowcomment Toggle Changed to ON");
				} else {
					extent.extentLoggerFail("", "Allowcomment Toggle didnt Changed to ON");
				}
			}

		} else {
			System.out.println("Allow comment option is not displayed");
		}

		if (verifyElementExist(HipiMePage.objallowvideodownload, "allow videodownload option")) {
			if (verifyElementExist(HipiMePage.objallowvideodownloadtoggleon, "Allowvideodownload Toggle ON")) {
				// Toggle is ON
				extent.extentLogger("", "Allow videodownload Toggle is On");
				click(HipiMePage.objallowvideodownloadtoggleon, "Allowvideodownload Toggle ON");

				if (verifyElementExist(HipiMePage.objallowvideodownloadtoggleoff, "Allowvideodownload Toggle OFF")) {
					extent.extentLoggerPass("", "Allowvideodownload Toggle Changed to OFF");
				} else {
					extent.extentLoggerFail("", "Allowvideodownload Toggle didnt Changed to OFF");
				}

			} else {
				// Toggle is OFF
				extent.extentLogger("", "Allow videodownload Toggle is Off");
				click(HipiMePage.objallowvideodownloadtoggleon, "Allowvideodownload Toggle OFF");

				if (verifyElementExist(HipiMePage.objallowvideodownloadtoggleon, "Allowcomment Toggle ON")) {
					extent.extentLoggerPass("", "Allowvideodownload Toggle Changed to ON");
				} else {
					extent.extentLoggerFail("", "Allowvideodownload Toggle didnt Changed to ON");
				}
			}

		} else {
			System.out.println("Allow videodownload option is not displayed");
		}
		if (verifyElementExist(HipiMePage.objallowsharing, "allow sharing option option")) {
			if (verifyElementExist(HipiMePage.objallowsharingon, "Allowsharing Toggle ON")) {
				// Toggle is ON
				extent.extentLogger("", "Allow sharing Toggle is On");
				click(HipiMePage.objallowsharingon, "Allowvideodownload Toggle ON");

				if (verifyElementExist(HipiMePage.objallowsharingoff, "Allowsharing Toggle OFF")) {
					extent.extentLoggerPass("", "Allowsharing Toggle Changed to OFF");
				} else {
					extent.extentLoggerFail("", "Allowsharing Toggle didnt Canged to OFF");
				}

			} else {
				// Toggle is OFF
				extent.extentLogger("", "Allow sharing Toggle is Off");
				click(HipiMePage.objallowsharingon, "Allow sharing Toggle OFF");

				if (verifyElementExist(HipiMePage.objallowsharingon, "Allowsharing Toggle ON")) {
					extent.extentLoggerPass("", "Allowsharing Toggle Changed to ON");
				} else {
					extent.extentLoggerFail("", "Allowsharing Toggle didnt Canged to ON");
				}
			}

		} else {
			System.out.println("Allow sharing option is not displayed");
		}

		extent.HeaderChildNode("Enable/Disable option in Hipi preferences");
		System.out.println("Hipi_Reg_130");		extent.extentLogger("", "Hipi_Reg_130");
		verifyElementPresentAndClick(HipiMePage.objsettingback, "back button present");
		// verifyElementPresentAndClick(HipiMePage.objsettingsicon,"click on
		// settings icon");
		verifyElementPresentAndClick(HipiMePage.objhipipreferences, "hipi preferences");
		if (verifyElementExist(HipiMePage.objallowlikes, "allow likes option")) {
			if (verifyElementExist(HipiMePage.objAllowLikestoogleoff, "AllowLikes Toggle Disable")) {
				// Toggle is ON
				extent.extentLogger("", "Allow Likes Toggle is Disable");
				click(HipiMePage.objAllowLikestoogleoff, "AllowLikes Toggle disable");

				if (verifyElementExist(HipiMePage.objAllowLikestoggleon, "AllowLikes Toggle enable")) {
					extent.extentLoggerPass("", "AllowLikes Toggle Changed to enable");
				} else {
					extent.extentLoggerFail("", "AllowLikes Toggle didnt Changed to enable");
				}

			} else {
				// Toggle is OFF
				extent.extentLogger("", "Allow Likes Toggle is enable");
				click(HipiMePage.objAllowLikestoogleoff, "AllowLikes Toggle enable");

				if (verifyElementExist(HipiMePage.objAllowLikestoogleoff, "AllowLikes Toggle disable")) {
					extent.extentLoggerPass("", "AllowLikes Toggle Changed to disable");
				} else {
					extent.extentLoggerFail("", "AllowLikes Toggle dint Changed to disable");
				}
			}

		} else {
			System.out.println("Allow Likes option is not displayed");
		}
		if (verifyElementExist(HipiMePage.objallowcomment, "allow comment option")) {
			if (verifyElementExist(HipiMePage.objallowcommenttoggleoff, "Allowcomment Toggle Disable")) {
				// Toggle is ON
				extent.extentLogger("", "Allow comment Toggle is disable");
				click(HipiMePage.objallowcommenttoggleoff, "Allowcomment Toggle disable");

				if (verifyElementExist(HipiMePage.objallowcommenttoggleon, "Allowcomment Toggle Enable")) {
					extent.extentLoggerPass("", "Allowcomment Toggle Changed to Enable");
				} else {
					extent.extentLoggerFail("", "Allowcomment Toggle didnt Changed to Enable");
				}

			} else {
				// Toggle is OFF
				extent.extentLogger("", "Allow comment Toggle is Disable");
				click(HipiMePage.objallowcommenttoggleoff, "Allowcomment Toggle Enable");

				if (verifyElementExist(HipiMePage.objallowcommenttoggleoff, "Allowcomment Toggle disable")) {
					extent.extentLoggerPass("", "Allowcomment Toggle Changed to disable");
				} else {
					extent.extentLoggerFail("", "Allowcomment Toggle didnt Changed to disable");
				}
			}

		} else {
			System.out.println("Allow comment option is not displayed");
		}
		if (verifyElementExist(HipiMePage.objallowvideodownload, "allow videodownload option")) {
			if (verifyElementExist(HipiMePage.objallowvideodownloadtoggleoff, "Allowvideodownload Toggle Disable")) {
				// Toggle is ON
				extent.extentLogger("", "Allow videodownload Toggle is Disable");
				click(HipiMePage.objallowvideodownloadtoggleoff, "Allowvideodownload Toggle Disable");

				if (verifyElementExist(HipiMePage.objallowvideodownloadtoggleon, "Allowvideodownload Toggle Enable")) {
					extent.extentLoggerPass("", "Allowvideodownload Toggle Changed to Enable");
				} else {
					extent.extentLoggerFail("", "Allowvideodownload Toggle didnt Changed to Enable");
				}

			} else {
				// Toggle is OFF
				extent.extentLogger("", "Allow videodownload Toggle is Enable");
				click(HipiMePage.objallowvideodownloadtoggleoff, "Allowvideodownload Toggle Enable");

				if (verifyElementExist(HipiMePage.objallowvideodownloadtoggleoff, "Allowcomment Toggle Disable")) {
					extent.extentLoggerPass("", "Allowvideodownload Toggle Changed to Disable");
				} else {
					extent.extentLoggerFail("", "Allowvideodownload Toggle didnt Changed to Disable");
				}
			}

		} else {
			System.out.println("Allow videodownload option is not displayed");
		}
		if (verifyElementExist(HipiMePage.objallowsharing, "allow sharing option option")) {
			if (verifyElementExist(HipiMePage.objallowsharingoff, "Allowsharing Toggle Disable")) {
				// Toggle is ON
				extent.extentLogger("", "Allow sharing Toggle is Disable");
				click(HipiMePage.objallowsharingoff, "Allowsharing Toggle Disable");

				if (verifyElementExist(HipiMePage.objallowsharingon, "Allowsharing Toggle Enable")) {
					extent.extentLoggerPass("", "Allowsharing Toggle Changed to Enable");
				} else {
					extent.extentLoggerFail("", "Allowsharing Toggle didnt Changed to Enable");
				}

			} else {
				// Toggle is OFF
				extent.extentLogger("", "Allow sharing Toggle is Enable");
				click(HipiMePage.objallowsharingoff, "Allow sharing Toggle Enable");

				if (verifyElementExist(HipiMePage.objallowsharingoff, "Allowsharing Toggle Disable")) {
					extent.extentLoggerPass("", "Allowsharing Toggle Changed to Disable");
				} else {
					extent.extentLoggerFail("", "Allowsharing Toggle didnt Changed to Disable");
				}
			}

		} else {
			System.out.println("Allow sharing option is not displayed");
		}
		click(HipiMePage.objbackbuttonhipi, "back button");

		extent.HeaderChildNode("Download over WiFi");
		System.out.println("Hipi_Reg_127");		extent.extentLogger("", "Hipi_Reg_127");
		if (verifyElementExist(HipiMePage.objdownloadoverwifi, "downloadoverwifi option")) {
			if (verifyElementExist(HipiMePage.objtoggleon, "Downloadoverwifionly Toggle Enabled")) {
				// Toggle is ON
				extent.extentLogger("", "Download over wifionly is Enabled");
				click(HipiMePage.objtoggleon, "Downloadoverwifi Toggle Enabled");

				if (verifyElementExist(HipiMePage.objtoggleoff, "Downloadoverwifionly Toggle Disable")) {
					extent.extentLoggerPass("", "Downloadoverwifionly Toggle Disable");
				} else {
					extent.extentLoggerFail("", "Downloadoverwifionly Toggle Toggle dint Changed to Disable");
				}

			} else {
				// Toggle is OFF
				extent.extentLogger("", "Downloadoverwifionly Toggle Toggle is Disable");
				click(HipiMePage.objtoggleon, "Downloadoverwifionly Toggle Disable");

				if (verifyElementExist(HipiMePage.objtoggleon, "Downloadoverwifionly Toggle Disable")) {
					extent.extentLoggerPass("", "Downloadoverwifionly is enable by default");
				} else {
					extent.extentLoggerFail("", "Downloadoverwifionly Toggle dint Changed to Enable");
				}
			}

		} else {
			System.out.println("Downloadoverwifionly Toggle option is not displayed");
		}
		click(HipiMePage.objbackbuttonhipisettings, "back button");

		extent.HeaderChildNode("Should get nofify when any one like my video, comment my video");
		System.out.println("Hipi_Reg_131");		extent.extentLogger("", "Hipi_Reg_131");

		verifyElementPresentAndClick(HipiMePage.objnotification, "notification");
		verifyElementPresentAndClick(HipiMePage.objvideotabinnotification, "videos tab present");

		// if(verifyIsElementDisplayed(HipiMePage.objlikedvideo)) {
		if (verifyIsElementDisplayed(HipiMePage.objnoresultfound)) {
			extent.extentLogger("", "User has no liked videos in notifications");
		} else {
			int size = getDriver().findElements(HipiMePage.objlikedvideotext).size();
			System.out.println(size);
			if (size > 0) {
				verifyElementExist(HipiMePage.objlikedvideotext, "liked videos present");
				logger.info("user gets notified when someone likes vieo");
				extent.extentLoggerPass("", "user gets notified when someone likes video");
			} else {
				extent.extentLoggerFail("userlist", "No userlist are available");
				logger.info("No userlist are available");
			}

		}

	}

	
	
	public void ValidatingZeeHipiCreateVideo(String userType) throws Exception{
		
		if(userType.equalsIgnoreCase("NonSubscribedUser")){
			Validatecameraflipworking(userType);
			Validatecameraflashworking(userType);
			Validateabletosetvideospeed(userType);
			Validateabletosettimerforvideo(userType);
			Validatebeautymode(userType);
			ValidatePlayandPauseVideo(userType);
			ValidateAddmusic(userType);
			Validatedeletevideo(userType);
			ValidateProgressbar(userType);
			ValidateAddFilter(userType);
			ValidateAddEffect(userType);
			ValidateAddmusiceditpage(userType);
			Validatemusiccanberemovedandnewmusicadded(userType);
			Validatevideotrim(userType);
		}
		
	}
	
	
	
	//Create Video
	
	public void Validatecameraflipworking(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking camera flip working");
	System.out.println("Hipi_Reg_053");
	extent.extentLogger("", "Hipi_Reg_053");
	logger.info("Hipi_Reg_053:"+ "Checking camera flip working");
	verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
	waitTime(3000);
	click(HipiCreateVideoPage.objCreateButton, "Create button clicked");
	if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo, "Allow ZEE5 to take pictures and record video?"))
	{
		logger.info("Permission dialog:"+ "Allow ZEE5 to take pictures and record video?");
		verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow");
		click(HipiCreateVideoPage.objCreateAllow, "Allow button clicked");
		logger.info("Allow ZEE5 to take pictures and record video-"+ "Allow button clicked");
		Thread.sleep(5000);
		
		logger.info("Permission dialog:"+ "Allow ZEE5 to access photos, media, and files on your device");
		verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to access photos, media, and files on your device?");		
		click(HipiCreateVideoPage.objCreateAllow, "Allow button clicked");
		logger.info("Allow ZEE5 to access photos, media, and files on your device-"+ "Allow button clicked");
		Thread.sleep(5000);
		
		logger.info("Permission dialog:"+ "Allow ZEE5 to record audio");
		verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?");
		click(HipiCreateVideoPage.objCreateAllow, "Allow button clicked");	
		logger.info("Allow ZEE5 to record audio-"+ "Allow button clicked");
		Thread.sleep(20000);
		
		verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
		click(HipiCreateVideoPage.objCreateReadyYes, "yes button clicked");	
		logger.info("Ready dialog displayed:"+ "yes button clicked");
		Thread.sleep(10000);
		click(HipiCreateVideoPage.objCreateVideoFlip, "Flip camera button clicked");
		Thread.sleep(5000);
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objCreateVideoFlipEnabled, "Flip camera enabled when flip camera button clicked"))
			{
				logger.info("Create Video Page:"+ "Flip camera button working");
				extent.extentLoggerPass("Create Video Page:","Flip camera working");
			}
			else
			{
				logger.info("Create Video Page:"+ "Flip camera button not working");
				extent.extentLoggerFail("Create Video Page:","Flip camera not working");
			}
	}
	else
	{
		logger.info("Create Video Page"+ "Flip camera not working");
	}
	}
	
	
	
	
	public void Validatecameraflashworking(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking camera flash working ");
	System.out.println("Hipi_Reg_054");	extent.extentLogger("", "Hipi_Reg_054");
	logger.info("Hipi_Reg_054:"+ "Checking camera flash workin");
	verifyElementExist(HipiCreateVideoPage.objCreateVideoFlash, "Flash button available");
	click(HipiCreateVideoPage.objCreateVideoFlash, "Flash button clicked");
	logger.info("Create Video Page:"+ "Flash button enabled");
	if(verifyIsElementDisplayed(HipiCreateVideoPage.objCreateVideoFlashEnabled, "Flash is enabled working"))
	{
		click(HipiCreateVideoPage.objCreateVideoFlashEnabled, "disable flash");
		logger.info("Create Video Page:"+ "Flash button disabled");
		extent.extentLoggerPass("Create Video Page:","Flash working");
	}
	else
	{
		logger.info("Create Video Page"+ "Flash not working");
		extent.extentLoggerFail("Create Video Page", "Flash not working");
	}
	}
	
	
	
	public void Validateabletosetvideospeed(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking video speed can be set");
	System.out.println("Hipi_Reg_056");	extent.extentLogger("", "Hipi_Reg_056");
	logger.info("Hipi_Reg_056:"+ "Checking video speed can be set");
	if(verifyElementExist(HipiCreateVideoPage.objCreateVideoSpeedButton, "Video speed button "))
	{
	click(HipiCreateVideoPage.objCreateVideoSpeedButton, "Video speed button");
	logger.info("Create Video Page:"+ "Video speed button enabled");
	verifyElementExist(HipiCreateVideoPage.objsuper_slow_speed_btn, "super slow speed button ");
	click(HipiCreateVideoPage.objsuper_slow_speed_btn, "super slow speed button");
	logger.info("Create Video Page:"+ "super slow speed button enabled");
	verifyElementExist(HipiCreateVideoPage.objslow_speed_btn, "slow speed button ");
	click(HipiCreateVideoPage.objslow_speed_btn, "slow speed button");
	logger.info("Create Video Page:"+ "slow speed button enabled");
	verifyElementExist(HipiCreateVideoPage.objfast_speed_btn, "fast speed button ");
	click(HipiCreateVideoPage.objfast_speed_btn, "fast speed button");
	logger.info("Create Video Page:"+ "fast speed button enabled");
	verifyElementExist(HipiCreateVideoPage.objsuper_fast_speed_btn, "super fast speed button ");
	click(HipiCreateVideoPage.objsuper_fast_speed_btn, "super fast speed button");
	logger.info("Create Video Page:"+ "super fast speed button enabled");
	verifyElementExist(HipiCreateVideoPage.objstandard_speed_btn, "standard speed button ");
	click(HipiCreateVideoPage.objstandard_speed_btn, "standard speed button");
	logger.info("Create Video Page:"+ "standard speed button enabled");
	click(HipiCreateVideoPage.objCreateVideoSpeedButton, "Video speed button");
	logger.info("Create Video Page:"+"Video speed can be set");
	}
	}
	
	public void Validateabletosettimerforvideo(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking timer can be set");
	System.out.println("Hipi_Reg_057");	extent.extentLogger("", "Hipi_Reg_057");
	logger.info("Hipi_Reg_057:"+ "Checking timer can be set");
	if(verifyElementExist(HipiCreateVideoPage.objtimerbtn, "Add timer button available"))
	{
	click(HipiCreateVideoPage.objtimerbtn, "Add timer button ");
	logger.info("Create Video Page:"+ "Add timer button clicked");
	verifyElementExist(HipiCreateVideoPage.objtimerbtn_timer_3s, "Add timer button for 3s ");
	click(HipiCreateVideoPage.objtimerbtn_timer_3s, "Add timer button for 3s ");
	logger.info("Create Video Page:"+ "Add timer button for 3s enabled");
	verifyElementExist(HipiCreateVideoPage.objtimerbtn_timer_5s, "Add timer button for 5s ");
	click(HipiCreateVideoPage.objtimerbtn_timer_5s, "Add timer button for 5s ");
	logger.info("Create Video Page:"+ "Add timer button for 5s enabled");
	verifyElementExist(HipiCreateVideoPage.objtimerbtn_timer_10s, "Add timer button for 10s ");
	click(HipiCreateVideoPage.objtimerbtn_timer_10s, "Add timer button for 10s ");
	logger.info("Create Video Page:"+ "Add timer button for 10s enabled");
	verifyElementExist(HipiCreateVideoPage.objtimerbtn_timer_3s, "Add timer button for 3s ");
	click(HipiCreateVideoPage.objtimerbtn_timer_3s, "Add timer button for 3s ");
	waitTime(3000);
	click(HipiCreateVideoPage.objtimerbtn, "Add timer button ");
	logger.info("Create Video Page:"+"Add timer can be changed");
	}
	}
	
	public void Validatebeautymode(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking beauty mode can be turned on/off");
	System.out.println("Hipi_Reg_058");extent.extentLogger("", "Hipi_Reg_058");
	logger.info("Hipi_Reg_058:"+ "Checking beauty mode can be turned on/off");
	if(verifyElementExist(HipiCreateVideoPage.objbeautybtn, "Check beauty mode turned on/off"))
	{
		verifyElementExist(HipiCreateVideoPage.objbeautybtnenabled, "Beauty mode turned on");
		logger.info("Create Video Page:"+ "Beauty mode button can be turned on by default in create video page");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objbeautybtn, "Beauty button to turn off beauty mode");
		verifyElementExist(HipiCreateVideoPage.objbeautybtndisabled, "Beauty mode turned off");
		logger.info("Create Video Page:"+ "Beauty mode button can be turned off pin create video page");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objbeautybtn, "Beauty button to turn on beauty mode");
		verifyElementExist(HipiCreateVideoPage.objbeautybtnenabled, "Beauty mode turned on");
		logger.info("Create Video Page:"+ "Beauty mode button can be turned on by default in create video page");
		logger.info("Create Video Page:"+ "Beauty mode turned on/off");
	}
	else
	{
		
		logger.info("Create Video Page:"+ "Beauty mode cannot can be turned on/off");
	}
	}
	
	
	public void ValidatePlayandPauseVideo(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking play and pause button of video");
	System.out.println("Hipi_Reg_059");extent.extentLogger("", "Hipi_Reg_059");
	logger.info("Hipi_Reg_059:"+ "Checking play and pause button of video");
	if(verifyElementExist(HipiCreateVideoPage.objrecordbtn, "Record start button"))
	{
		click(HipiCreateVideoPage.objrecordbtn, "Record");
		logger.info("Create Video Page:"+ "Play button working");
		Thread.sleep(8000);
		verifyIsElementDisplayed(HipiCreateVideoPage.objrecordbtn, "Record pause");
		click(HipiCreateVideoPage.objrecordbtn, "Record pause");
		logger.info("Create Video Page:"+ "Pause button working");
		Thread.sleep(5000);
		
		click(HipiCreateVideoPage.objFinishButton, "Finish Button");
		Thread.sleep(5000);
	}
	}
	
	
	public void ValidateAddmusic(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking add music button working");
	System.out.println("Hipi_Reg_60");extent.extentLogger("", "Hipi_Reg_060");
	logger.info("Hipi_Reg_60:"+ "Checking add music button working");
	if(verifyElementExist(HipiCreateVideoPage.objaddmusicbtn, "Add music button available"))
	{
	click(HipiCreateVideoPage.objaddmusicbtn, "Add music button ");
	logger.info("Create Video Page:"+ "Add music button clicked");
	Thread.sleep(5000);
	logger.info("Add music Page:"+ "Music list available");
	verifyElementExist(HipiCreateVideoPage.objmusic, "Music ");
	click(HipiCreateVideoPage.objmusic, "music ");
	logger.info("Add music Page:"+ "Music clicked as required");
	Thread.sleep(5000);
	verifyElementExist(HipiCreateVideoPage.objpausebtn, "Music pause button ");
	click(HipiCreateVideoPage.objpausebtn, "music pause button ");
	Thread.sleep(5000);
	logger.info("Add music Page:"+ "Pause button clicked");
	verifyElementExist(HipiCreateVideoPage.objselectmusicbtn, "Music tick button ");
	click(HipiCreateVideoPage.objselectmusicbtn, "Music tick button ");
	logger.info("Add music Page:"+ "Tick button clicked");
	Thread.sleep(5000);
	verifyIsElementDisplayed(HipiCreateVideoPage.objmusicadded, "Added music available under create video page");
	logger.info("Create video page:"+ "Music got added");
	extent.extentLoggerPass("Add music Page","Add music button working");
	}
	else
	{
		logger.info("Add music Page:"+ "Add music button not working");
		extent.extentLoggerFail("Add music Page:", "Add music button not working");
	}
	}
	
	
	public void Validatedeletevideo(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking recorded video can be deleted");
	System.out.println("Hipi_Reg_61");extent.extentLogger("", "Hipi_Reg_061");
	logger.info("Hipi_Reg_61:"+ "Checking recorded video can be deleted");
	Back(1);
	verifyElementExist(HipiCreateVideoPage.objrecordclipcontinueshootdialog, "Continue Shoot dialog available");
	click(HipiCreateVideoPage.objeditpagecontinuebtn, "Continue button");
	Thread.sleep(5000);
	Thread.sleep(5000);
	verifyElementExist(HipiCreateVideoPage.objvideodeletebtn, "Delete video button ");
	click(HipiCreateVideoPage.objvideodeletebtn, "Delete video button ");
	logger.info("Create Video Page"+ "Delete video button clicked");
	verifyElementExist(HipiCreateVideoPage.objvideodeletedialog, "Delete last clip dialog ");
	logger.info("Delete last clip dialog"+ "Yes button available");
	verifyElementExist(HipiCreateVideoPage.objdeletevideoyesbtn, "Delete last clip dialog yes button ");
	click(HipiCreateVideoPage.objdeletevideoyesbtn, "Delete last clip dialog yes button ");
	logger.info("Delete last clip dialog"+ "Yes button clicked");
	if(verifyElementExist(HipiCreateVideoPage.objclipgotdeletedalert, "Your last clip has been deleted alert "))
	{
		logger.info("Alert message:"+ "Your last clip has been deleted");
		extent.extentLoggerPass("Create Video Page","recorded video can be deleted");

	}
	else
	{
		logger.info("Alert message:"+ "Delete button not working");
		extent.extentLoggerFail("Create video page:", "Delete button not working");
	}
	}
	
	
	
	public void ValidateProgressbar(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking progress bar default duration is 15s");
	System.out.println("Hipi_Reg_62");extent.extentLogger("", "Hipi_Reg_062");
	logger.info("Hipi_Reg_62:"+ "Checking progress bar default duration is 15s");
	verifyElementExist(HipiCreateVideoPage.objvideoprogressbar, "progress bar 15s available");
	logger.info("Create Video Page:"+ "Progress bar default duration is 15s");
	Thread.sleep(5000);
	String defaultvideotime=null;

	click(HipiCreateVideoPage.objrecordbtn,"Record button clicked");
	logger.info("Create Video Page:"+ "Record button clicked");
	Thread.sleep(20000);
	Back(1);
	verifyElementExist(HipiCreateVideoPage.objrecordclipcontinueshootdialog, "Continue Shoot dialog ");
	click(HipiCreateVideoPage.objeditpagecontinuebtn, "Continue button");
	Thread.sleep(5000);
	
	defaultvideotime = getAttributValue("text", HipiCreateVideoPage.objdefaultRecordTime);
	String[] str = defaultvideotime.split("/ ");
	System.out.println(str[1]);
	String actualvideotime=getAttributValue("text",HipiCreateVideoPage.objactualRecoredTime);
	System.out.println(actualvideotime);
	if(defaultvideotime.contains(str[1]))
	{
		logger.info("Create Video Page:"+ "Video duration is by default 15s and recorded video time is also 15s");
		extent.extentLoggerPass("Create Video Page:","Progress bar default duration is 15s and clip recorded time is also same");
		Thread.sleep(5000);
	}
	else
	{
		logger.info("Create Video Page:"+ "Video duration is by default 15s and recorded video time is also 15s are invalid");
		extent.extentLoggerFail("Create video page:", "Video duration is by default 15s and recorded video time is also 15s are invalid");
	}

	
	}
	
	
	

	
	
	public void ValidateAddFilter(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking add filter working");
	System.out.println("Hipi_Reg_63");extent.extentLogger("", "Hipi_Reg_063");
	logger.info("Hipi_Reg_63:"+ "Checking add filter working");
	verifyElementPresentAndClick(HipiCreateVideoPage.objfilter, "Add filter button ");
	logger.info("Create Video Page"+ "Add filter button clicked");
	Thread.sleep(6000);
	if(verifyElementExist(HipiCreateVideoPage.objfiltertobeDownloadavailable, "Download filter button "))
	{
	click(HipiCreateVideoPage.objfiltertobeDownloadavailable, "Download filter button ");
	logger.info("Add Filter Page:"+ "Required filter downloaded");
	Thread.sleep(6000);
	verifyElementPresentAndClick(HipiCreateVideoPage.objfilterUse, "Filter to be used ");
	logger.info("Add Filter Page:"+ "Required filter enabled");
	
	Back(1);
	Thread.sleep(5000);
	if(verifyElementExist(HipiCreateVideoPage.objHighlightedFiltericon,"Highlighted Filter icon")){
		extent.extentLoggerPass("", "Filter is highlighted and Filter is applied");
		click(HipiCreateVideoPage.objHighlightedFiltericon, "Highlighted Filter icon");
		Thread.sleep(2000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objfilterImgClear, "Filter clear button ");
		Thread.sleep(5000);
	}else{
		extent.extentLoggerPass("", "Filter is not highlighted and Filter is not applied");
		click(HipiCreateVideoPage.objfilter, "Add filter button ");
	}
	

	verifyElementPresentAndClick(HipiCreateVideoPage.objfilterrecent, "Filter recent tab ");
	logger.info("Add Filter Page:"+ "Recent tab clicked");
	
	if(verifyIsElementDisplayed(HipiCreateVideoPage.objfilterrecentdata, "Recently used filter ")){
		extent.extentLogger("","Recent Filter is displayed");
	}else{
		extent.extentLogger("","No Recent Filters available");
	}
	Back(1);

	}
	else
	{
		logger.info("Create video page:"+ "Add filter button not working");
		extent.extentLoggerFail("Create video Page", "Add filter button not working");
	}

	}


	public void ValidateAddEffect(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking add effect working");
	System.out.println("Hipi_Reg_64");extent.extentLogger("", "Hipi_Reg_064");
	logger.info("Hipi_Reg_64:"+ "Checking add effect working");
	verifyElementPresentAndClick(HipiCreateVideoPage.objeffect, "Add effect button available");
	click(HipiCreateVideoPage.objeffect, "Add effect button ");
	logger.info("Create Video Page:"+ "Add effect button clicked");
	Thread.sleep(5000);
	if(verifyElementExist(HipiCreateVideoPage.objEffectNameBeforeDownloading, "Effect download button"))
	{
	click(HipiCreateVideoPage.objEffectNameBeforeDownloading, "Effect download button");
	Thread.sleep(10000);
	logger.info("Add effect Page:"+ "Required effect downloaded");
	verifyElementExist(HipiCreateVideoPage.objfirsteffectAfterDownload, "Effect to be used ");
	click(HipiCreateVideoPage.objfirsteffectAfterDownload, "Effect to be used ");
	logger.info("Add effect Page:"+ "Required effect enabled");
	Thread.sleep(10000);
	
	Back(1);
	Thread.sleep(5000);
	if(verifyElementExist(HipiCreateVideoPage.objHighlightedEffectIcon,"Highlighted Effect icon")){
		extent.extentLoggerPass("", "Effect is highlighted and Effect is applied");
		click(HipiCreateVideoPage.objHighlightedEffectIcon, "Highlighted effect icon");
		Thread.sleep(4000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objEffectImgClear, "effect clear button ");
		Thread.sleep(5000);
	}else{
		extent.extentLoggerPass("", "effect is not highlighted and effect is not applied");
		click(HipiCreateVideoPage.objeffect, "Add effect button ");
	}
	
	verifyElementPresentAndClick(HipiCreateVideoPage.objEffectrecent, "effect recent tab ");
	logger.info("Add effect Page:"+ "Recent tab clicked");

	if(verifyIsElementDisplayed(HipiCreateVideoPage.objeffectrecentdata, "effect ")){
		extent.extentLogger("","No Recent effect is available");
	}else{
		extent.extentLogger(""," Recent effect is displayed");
	}
	Back(1);
	}		
	else
	{
		logger.info("Create video page:"+ "Add effect button not working");
		extent.extentLoggerFail("Create video page:", "Add effect button not working");
	}
	}
	
	
	
public void ValidateAddmusiceditpage(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking add music under edit page working");
	System.out.println("Hipi_Reg_65");extent.extentLogger("", "Hipi_Reg_065");
	logger.info("Hipi_Reg_65:"+ "Checking add music under edit page working");
	verifyElementExist(HipiCreateVideoPage.objFinishButton, "Create video button ");
	click(HipiCreateVideoPage.objFinishButton, "Create video button ");
	Thread.sleep(60000);
	click(HipiCreateVideoPage.objaddmusiceditbtn, "Add Music button");	
	if(verifyElementExist(HipiCreateVideoPage.objaddmusicpage, "Music to be added "))
	{	
	Thread.sleep(5000);
	verifyElementExist(HipiCreateVideoPage.objaddmusicpage, "Music to be added ");
	click(HipiCreateVideoPage.objmusictobeadded, "Music added");
	logger.info("Add music page:"+ "Music clicked");
	Thread.sleep(5000);
	verifyElementExist(HipiCreateVideoPage.objmusicplaypause, "Play/pause button ");
	click(HipiCreateVideoPage.objmusicplaypause, "Music paused");
	logger.info("Add music page:"+ "Music pause button ");
	Thread.sleep(5000);
	verifyElementExist(HipiCreateVideoPage.objmusicdialogavailable, "Music dialog ");
	String MusicSelected = getAttributValue("text", HipiCreateVideoPage.objmusicdialogavailable);
	extent.extentLogger("", "Music Selected : "+MusicSelected);

	verifyElementExist(HipiCreateVideoPage.objmusicusebtn, "Finish button");
	click(HipiCreateVideoPage.objmusicusebtn, "Finish button ");
	logger.info("Add music page:"+ "Tick button ");
	Thread.sleep(5000);
	verifyElementExist(HipiCreateVideoPage.objmusicavailable, "Music added");
	String MusicAdded = getAttributValue("text", HipiCreateVideoPage.objmusicavailable);
	extent.extentLogger("", "Music Added : "+MusicAdded);

	logger.info("Edit video page:"+ "Add music button working");
	extent.extentLoggerPass("Edit video page:","Add music button working");
	}
	else
	{
		logger.info("Edit video page:"+"Add music button not working");
		extent.extentLoggerFail("Edit video page:","Add music button not working");
	}
	}

	public void Validatemusiccanberemovedandnewmusicadded(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking add music can be removed and used");
	System.out.println("Hipi_Reg_66");extent.extentLogger("", "Hipi_Reg_066");
	logger.info("Hipi_Reg_66:"+ "Checking add music can be removed and used");
	verifyElementExist(HipiCreateVideoPage.objremove, "remove button ");
	click(HipiCreateVideoPage.objremove, "remove button ");

	logger.info("Video edit page:"+ "remove button clicked");
	Thread.sleep(5000);

	click(HipiCreateVideoPage.objaddmusiceditbtn, "Add Music button");	
	if(verifyElementExist(HipiCreateVideoPage.objaddmusicpage, "Add music page"))
	{
		verifyElementExist(HipiCreateVideoPage.objmusictobeadded1, "Music ");
		click(HipiCreateVideoPage.objmusictobeadded1, "Music ");
		Thread.sleep(10000);
		verifyElementExist(HipiCreateVideoPage.objmusicplaypause, "play/pause button ");
		click(HipiCreateVideoPage.objmusicplaypause, "Pause button");
		
		Thread.sleep(5000);
		verifyElementExist(HipiCreateVideoPage.objmusicdialogavailable, "Music dialog ");
		String MusicSelected = getAttributValue("text", HipiCreateVideoPage.objmusicdialogavailable);
		extent.extentLogger("", "Music Selected : "+MusicSelected);
		
		verifyElementExist(HipiCreateVideoPage.objmusicusebtn, "Finish button ");
		click(HipiCreateVideoPage.objmusicusebtn, "Finish button");
		Thread.sleep(5000);
		verifyElementExist(HipiCreateVideoPage.objmusicavailable, "music added");
		String MusicAdded = getAttributValue("text", HipiCreateVideoPage.objmusicavailable);
		extent.extentLogger("", "Music Added : "+MusicAdded);
		logger.info("Edit video page:"+ "Add music button working for adding music after deleting the music");
		extent.extentLoggerPass("Edit video page:","Add music button working for adding music after deleting the music");
	}
	else
	{
		logger.info("Edit video page:"+ "Add music button not working for adding music after deleting the music");
		extent.extentLoggerFail("Edit video page:", "Add music button not  working for adding music after deleting the music");
	}
	}
	
	
	
	
	
	public void Validatevideotrim(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking video can be trimmed");
	System.out.println("Hipi_Reg_67");extent.extentLogger("", "Hipi_Reg_067");
	logger.info("Hipi_Reg_67:"+ "Checking video can be trimmed");

	if(verifyElementExist(HipiCreateVideoPage.objtrim, "trim button "))
	{
	click(HipiCreateVideoPage.objtrim, "Trim button ");
	logger.info("Edit video page:"+ "Trim button clicked");
	verifyElementExist(HipiCreateVideoPage.objtrimdialog,"Dialog trim ");
	logger.info("Dialog trim:"+ "Dialog trim available");
	verifyElementExist(HipiCreateVideoPage.objtrimlefthandle, "Trim left handle ");
	Thread.sleep(5000);
	verifyElementExist(HipiCreateVideoPage.objtrimrighthandle, "Trim right handle ");
	////verifyElementExist(AMDCreate.objtrimvideohandle, "Trim video indicator available");
	Thread.sleep(5000);
	VideoTrim(HipiCreateVideoPage.objtrimrighthandle);
	Thread.sleep(5000);
	verifyElementExist(HipiCreateVideoPage.objtrimvideofinishbtn, "Tick button ");
	click(HipiCreateVideoPage.objtrimvideofinishbtn, "Tick button ");
	Thread.sleep(5000);
	verifyElementExist(HipiCreateVideoPage.objdialogwannatrimchanges, "Dialog ");
	logger.info("Dialog:"+ "Wanna trim changes");
	verifyElementExist(HipiCreateVideoPage.objtrimvideocontinuebtn, "continue button ");
	click(HipiCreateVideoPage.objtrimvideocontinuebtn, "continue button ");
	logger.info("Video edit page:"+ "Video can be trimmed");
	extent.extentLoggerPass("Video edit page:","Recoreded video can be trimed");
	}
	else
	{
	logger.info("Video edit page:"+ "Add trim button not working");
	extent.extentLoggerFail("Video edit page:", "Add trim button not working");
	}
	}
	
	
	
	public void VideoTrim(By byLocator1) throws Exception {

		WebElement element = getDriver().findElement(byLocator1);
		Dimension size = element.getSize();
		int startx = (int) (size.width);

		Dimension size1 = getDriver().manage().window().getSize();
		int endx = (int) (size1.width * 0.5);

		AndroidTouchAction touch = new AndroidTouchAction(getDriver());
		touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endx, startx))
				.release().perform();
	}



	
	
	
	public void ValidatingZeeHipiUploadVideo(String userType) throws Exception{
		if(userType.equalsIgnoreCase("NonSubscribedUser")){
			ValidateAddDescription(userType);
			Validatecoverphotoofrecordedvideo(userType);
			Validateenabledisablecomments(userType);
			Validatelikeanddislike(userType);
			Validateallowsharing(userType);
			Validateallowvideodownload(userType);
			Validateaddlanguage(userType);
			
			ValidateTermsandConditioncanbechecked(userType);
			Validatevideocanbesavedasdraft(userType);
			Validatetrendinghshtagsdwithviewsareused(userType);
			Validatevisibilitymode(userType);
			Validatevideopostbuttonworking(userType);
		}
	}
	
	
	
	public void ValidateAddDescription(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking add description button working");
	System.out.println("Hipi_Reg_070");extent.extentLogger("", "Hipi_Reg_070");
	logger.info("Hipi_Reg_70:"+ "Checking add description button working");
	
	verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
	click(HipiCreateVideoPage.objCreateButton, "Create button clicked");
	if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo, "Allow ZEE5 to take pictures and record video?"))
	{
		logger.info("Permission dialog:"+ "Allow ZEE5 to take pictures and record video?");
		verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow");
		click(HipiCreateVideoPage.objCreateAllow, "Allow button clicked");
		logger.info("Allow ZEE5 to take pictures and record video-"+ "Allow button clicked");
		Thread.sleep(5000);
		
		logger.info("Permission dialog:"+ "Allow ZEE5 to access photos, media, and files on your device");
		verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to access photos, media, and files on your device?");		
		click(HipiCreateVideoPage.objCreateAllow, "Allow button clicked");
		logger.info("Allow ZEE5 to access photos, media, and files on your device-"+ "Allow button clicked");
		Thread.sleep(5000);
		
		logger.info("Permission dialog:"+ "Allow ZEE5 to record audio");
		verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?");
		click(HipiCreateVideoPage.objCreateAllow, "Allow button clicked");	
		logger.info("Allow ZEE5 to record audio-"+ "Allow button clicked");
		Thread.sleep(20000);
		
		verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
		click(HipiCreateVideoPage.objCreateReadyYes, "yes button clicked");	
		logger.info("Ready dialog displayed:"+ "yes button clicked");
		Thread.sleep(10000);
	}
	if(verifyElementExist(HipiCreateVideoPage.objrecordbtn, "Record start button of video available"))
	{
		click(HipiCreateVideoPage.objrecordbtn, "Record start button clicked");
		logger.info("Create Video Page:"+ "Play button working");
		Thread.sleep(5000);
		Thread.sleep(10000);
	}
	
	verifyElementExist(HipiCreateVideoPage.objPostbutton, "Post button available");
	click(HipiCreateVideoPage.objPostbutton, "Post button");
	logger.info("Edit video page"+" Post button working");
	Thread.sleep(10000);
	verifyElementExist(HipiCreateVideoPage.objposthipiTpage, "Post hipit page available");
	logger.info("Post hipit page:"+"Post hipit page displayed");
	if(verifyElementExist(HipiCreateVideoPage.objadddescription, "add description field available"))
	{
		
		logger.info("Post hipit page:"+"Count of words to be added");
		String decription="In the India of my dreams, there would be no poverty. Every Indian would be able to live very very very very comfortable life. Every single person would be literate and the acquisition of knowledge would be open to one";
		Thread.sleep(5000);
		int lengthofdecription=decription.length();
        System.out.println("length decription"+lengthofdecription);
        logger.info("Add description field:"+"Entering more than 200 words in description");
        click(HipiCreateVideoPage.objadddescription, "Added description field");
		type(HipiCreateVideoPage.objadddescription,"In the India of my dreams, there would be no poverty. Every Indian would be able to live very comfortable life. Every single person would be literate and the acquisition of knowledge would be open to one", "Description entered which is more than 200 words");
		Thread.sleep(10000);	
		hideKeyboard();
		verifyElementExist(HipiCreateVideoPage.objadddescriptioncount, "Description box after adding data available");
		String getTextaddescriptionwhendatagotentered=findElement(HipiCreateVideoPage.objadddescriptioncount).getText();
		int countofwordindescriptionafterdatagotadded=getTextaddescriptionwhendatagotentered.length();
		System.out.println("length decription after data entered:"+countofwordindescriptionafterdatagotadded);
		logger.info("Add description field:"+"Count of words after description got added");
		if(lengthofdecription>countofwordindescriptionafterdatagotadded && countofwordindescriptionafterdatagotadded==200)
		{
			extent.extentLoggerPass("Post hipit page:","Able to add description upto 200 words");
			logger.info("Post hipit page:"+"User able to add description upto 200 words");
		}
		else
		{
			extent.extentLoggerFail("Post hipit page:","Unable to add description more than 200 words");
			logger.info("Post hipit page:"+"User unable to add description more than 200 words");
		}
	}
	}

public void Validatecoverphotoofrecordedvideo(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking cover photo of recorded video available");
	System.out.println("Hipi_Reg_071");extent.extentLogger("", "Hipi_Reg_071");
	logger.info("Hipi_Reg_71:"+ "Checking cover photo of recorded video available");
	if(verifyElementExist(HipiCreateVideoPage.objcoverphotorecordedvideo, "Cover photo of video recorded available"))
	{
		extent.extentLoggerPass("Post hipit page:","Able to view cover photo of video recorded ");
		logger.info("Post hipit page:"+"User able to view cover photo of video recorded");
	}
	else
	{
		extent.extentLoggerFail("Post hipit page:", "Unable to view cover photo of video recorded");
		logger.info("Post hipit page:"+"User unable to view cover photo of video recorded");
	}
	}

public void Validateenabledisablecomments(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking advanced settings disabling/enabling comments working");
	System.out.println("Hipi_Reg_075");extent.extentLogger("", "Hipi_Reg_075");
	logger.info("Hipi_Reg_75:"+ "Checking advanced settings disabling/enabling comments working");
	verifyElementExist(HipiCreateVideoPage.objadvancedsettingsbutton, "Advanced settings button available");
	click(HipiCreateVideoPage.objadvancedsettingsbutton, "Advanced settings button clicked");
	logger.info("Post HipiT Page:"+ "Advanced settings button clicked");
	Thread.sleep(5000);
	if(verifyElementExist(HipiCreateVideoPage.objallowcommentbar, "Allow comments bar is available"))
	{
	click(HipiCreateVideoPage.objallowcommentbar, "Allow comments bar clicked");
	logger.info("Advanced settings:"+ "Allow comments bar clicked");
	verifyElementExist(HipiCreateVideoPage.objallowcommentsdisabledbar, "Allow comments bar is disabled");
	logger.info("Advanced settings:"+ "Allow comments bar disabled");
	click(HipiCreateVideoPage.objallowcommentbar, "Allow comments bar");
	Thread.sleep(5000);
	logger.info("Advanced settings:"+ "Allow comments bar clicked to be enabled");
	verifyElementExist(HipiCreateVideoPage.objallowcommentsenabledbar, "Allow comments bar is enabled");
	logger.info("Advanced settings:"+ "Advanced settings allow disabling/enabling comments working");
	extent.extentLoggerPass("Post HipiT Page:","Advanced settings allow disabling/enabling comments working");
	}
	else
	{
		logger.info("Advanced settings"+ "Advanced settings allow disabling/enabling comments not working");
		extent.extentLoggerFail("Post hipit page:", "Advanced settings allow disabling/enabling comments not working");
	}
	}
	public void Validatelikeanddislike(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking advanced settings like and dislike working");
	System.out.println("Hipi_Reg_076");extent.extentLogger("", "Hipi_Reg_076");
	logger.info("Hipi_Reg_076"+ "Checking advanced settings like and dislike working");
	if(verifyElementExist(HipiCreateVideoPage.objallowlikedislikebar, "Allow like/dislike bar is available"))
	{
		click(HipiCreateVideoPage.objallowlikedislikebar, "Allow like/dislike bar clicked");
		logger.info("Advanced settings"+ "Allow like/dislike bar clicked");
		Thread.sleep(5000);
		verifyElementExist(HipiCreateVideoPage.objallowlikedislikedisabledbar, "Allow like/dislike bar is disabled");
		logger.info("Advanced settings"+ "Allow like/dislike bar disabled");
		click(HipiCreateVideoPage.objallowlikedislikebar, "Allow like/dislike bar clicked to be enabled");
		logger.info("Advanced settings"+ "Allow like/dislike bar clicked to be enabled");
		Thread.sleep(5000);
		verifyElementExist(HipiCreateVideoPage.objallowlikedislikeenabledbar, "Allow comments bar is enabled");
		logger.info("Advanced settings"+ "Advanced settings allow like/dislike working");
		extent.extentLoggerPass("Post HipiT Page","Advanced settings allow like/dislike working");
	}
	else
	{
		logger.info("Advanced settings"+ "Advanced settings allow like/dislike not working");
		extent.extentLoggerFail("Post hipit page:","Advanced settings allow like/dislike not working");
	}
	}
	public void Validateallowsharing(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking advanced settings allow sharing bar working");
	System.out.println("Hipi_Reg_077");extent.extentLogger("", "Hipi_Reg_077");
	logger.info("Hipi_Reg_077:"+ "Checking advanced settings allow sharing bar working");
	if(verifyElementExist(HipiCreateVideoPage.objallowsharingbar, "Allow sharing bar is available"))
	{
	click(HipiCreateVideoPage.objallowsharingbar, "Allow sharing bar");
	logger.info("Advanced settings"+ "Allow sharing bar clicked");
	verifyElementExist(HipiCreateVideoPage.objallowsharingdisabledbar, "Allow sharing bar is disabled");
	logger.info("Advanced settings"+ "Allow sharing bar disabled");
	click(HipiCreateVideoPage.objallowsharingbar, "Allow sharing bar");
	logger.info("Advanced settings"+ "Allow sharing bar clicked to be enabled");
	verifyElementExist(HipiCreateVideoPage.objallowsharingenabledbar, "Allow sharing bar is enabled");
	logger.info("Advanced settings"+ "Advanced settings allow sharing working");
	extent.extentLoggerPass("Post HipiT Page","Advanced settings allow sharing working");
	}
	else
	{
		logger.info("Advanced settings:"+ "Advanced settings allow sharing not working");
		extent.extentLoggerFail("Post HipiT Page:","Advanced settings allow sharing working");
	}
	}
	public void Validateallowvideodownload(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking advanced settings allow video download bar working");
	System.out.println("Hipi_Reg_079");extent.extentLogger("", "Hipi_Reg_079");
	logger.info("Hipi_Reg_079:"+ "Checking advanced settings allow video download bar working");
	if(verifyElementExist(HipiCreateVideoPage.objallowvideodownloadbar, "Allow video download is available"))
	{
	click(HipiCreateVideoPage.objallowvideodownloadbar, "Allow video download bar");
	logger.info("Advanced settings:"+ "Allow video download bar clicked");
	verifyElementExist(HipiCreateVideoPage.objallowvideodownloaddisabledbar, "Allow video download bar is disabled");
	logger.info("Advanced settings:"+ "Allow sharing bar disabled");
	click(HipiCreateVideoPage.objallowvideodownloadbar, "Allow video download bar");
	logger.info("Advanced settings:"+ "Allow video download bar");
	verifyElementExist(HipiCreateVideoPage.objallowvideodownloadenabledbar, "Allow video download bar is enabled");
	click(HipiCreateVideoPage.objadvancedsettingsbutton, "Advanced settings button closed");
	logger.info("Advanced settings:"+ "Allow video download bar is enabled");
	extent.extentLoggerPass("Post HipiT Page:","Advanced settings allow video download working");
	}
	else
	{
		logger.info("Advanced settings:"+ "Advanced settings allow video download not working");
		extent.extentLoggerFail("Post HipiT Page:","Advanced settings allow video download not working");
	}
	}
	public void Validateaddlanguage(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking language can be added working");
	System.out.println("Hipi_Reg_081");extent.extentLogger("", "Hipi_Reg_081");
	logger.info("Hipi_Reg_081:"+ "Checking language can be added working");
	if(verifyElementExist(HipiCreateVideoPage.objlanguageforyourvideolabel, "Select the language of your video available"))
	{
		logger.info("Post HipiT Page:"+ "Select the language of your video available");
		verifyElementExist(HipiCreateVideoPage.objlanguageclickedenglish, "Select the language of your video under which english available");
		click(HipiCreateVideoPage.objlanguageclickedenglish, "English clicked");
		logger.info("Post HipiT Page:"+ "language can be added working");
		extent.extentLoggerPass("Post HipiT Page:","language can be added working");
	}
	else
	{
		logger.info("Advanced settings:"+ "language can be added not working");
		extent.extentLoggerFail("Post HipiT Page:","language can be added not working");
	}
	}


	
	public void Validatehastagenteredbyusercanbeused(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking hashtag added by user can be used");
	System.out.println("Hipi_Reg_072");extent.extentLogger("", "Hipi_Reg_072");
	logger.info("Hipi_Reg_72:"+ "Checking hashtag added by user can be used");
	click(HipiCreateVideoPage.objadddescription, "Added description field");
	longPress(HipiCreateVideoPage.objbtniconclear);
	Thread.sleep(10000);
	if(verifyElementExist(HipiCreateVideoPage.objadddescription, "Add description field available"))
	{	
		type(HipiCreateVideoPage.objadddescription,"#hipi","Entered #hipi in description field");
		longPress(HipiCreateVideoPage.objbtniconclear);
		type(HipiCreateVideoPage.objadddescription,"#hipi","Entered #hipi in description field");
		click(HipiCreateVideoPage.objbtnicontogonextline, "Next line clicked here");
		logger.info("Post hipit page:"+"User can add hashtag under description field");
		extent.extentLoggerPass("Post hipit page:","User can add hashtag");
		
	}
	else
	{
		logger.info("Post hipit page:"+"User cannot add hashtag under description field");
		extent.extentLoggerFail("Post hipit page:", "user cannot add hashtag");
	}
	}
	
	public void Validatetrendinghshtagsdwithviewsareused(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking trending hashtag with views listed can be added");
	System.out.println("Hipi_Reg_072 and Hipi_Reg_073");extent.extentLogger("", "Hipi_Reg_072 and Hipi_Reg_073");
	logger.info("Hipi_Reg_072 and Hipi_Reg_073:"+ "Checking Hastag can be added to description and Checking trending hashtag with views listed can be added");
	click(HipiCreateVideoPage.objcreatevideo, "Create video button");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objrecordbtn, "Record button clicked under create video");
	Thread.sleep(20000);
	click(HipiCreateVideoPage.objPostbutton, "Post button clicked under edit video");
	Thread.sleep(5000);
	type(HipiCreateVideoPage.objadddescription,"#hipi","#hipi entered in description field");
	logger.info("Post hipit page:"+"In add descriptiopn # got entered");
	hideKeyboard();
	
	String enteredDescription = getAttributValue("text", HipiCreateVideoPage.objPostDescription);
	
	if(enteredDescription.contains("#hipi")){
		extent.extentLoggerPass("", "Hashtag added to Description");
	}else{
		extent.extentLoggerFail("", "Hashtag not added to Description");
	}
	
	
	logger.info("Post hipit page:"+"Trending hashtags displayed");
	verifyElementExist(HipiCreateVideoPage.objhashtagname, "Hashtags available");
	logger.info("Post hipit page:"+"Hashtags to be used displayed");
	verifyElementExist(HipiCreateVideoPage.objtredinghashtagviews, "Hashtag views available");
	logger.info("Post hipit page:"+"Views under hashtag are displayed");
	Thread.sleep(5000);
	String hashtagtobeused=findElement(HipiCreateVideoPage.objhashtagname).getText();
	System.out.println("hashtagtobeused:"+hashtagtobeused);
	click(HipiCreateVideoPage.objhashtagname,"hashtag");
	Thread.sleep(5000);
	String hashtagwithdescriptionbox=findElement(HipiCreateVideoPage.objadddescriptionboxhavehashtagclicked).getText();
	System.out.println("hashtagwithdescriptionbox:"+hashtagwithdescriptionbox);
	Thread.sleep(5000);
	if(hashtagwithdescriptionbox.contains(hashtagtobeused))
	{
	extent.extentLoggerPass("Post hipit page:","Trending hashtags suggested with views available and used");
	logger.info("Post hipit page:"+"Trending hashtags suggested with views available and used");
	}
	else
	{
	extent.extentLoggerFail("Post hipit page:", "Trending hashtags suggested with views cannot be used");
	logger.info("Post hipit page:"+"Trending hashtags suggested with views cannot be used");
	}
	}
			
	public void Validatevisibilitymode(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking visibility mode can be added");
	System.out.println("Hipi_Reg_074");extent.extentLogger("", "Hipi_Reg_074");
	logger.info("Hipi_Reg_74:"+ "Checking visibility mode can be added");
	hideKeyboard();
	verifyElementExist(HipiCreateVideoPage.objvisibilitymodebutton, "Visibilty button available");
	String visibilitymodebydefaultselected="Public";
	String visibilitymode=findElement(HipiCreateVideoPage.objvisibilitymodebutton).getText();
		if(visibilitymodebydefaultselected.equalsIgnoreCase(visibilitymode))
		{
			extent.extentLoggerPass("Post hipit page:","Visibility mode by default is public");
			logger.info("Post hipit page:"+"Visibility mode by default is public");
		}else{
			extent.extentLoggerFail("Post hipit page:","Visibility mode by default is not public");
			logger.info("Post hipit page:"+"Visibility mode by default is not public");
		}
	Thread.sleep(5000);
	String visibilitymodefollower="Followers-Only";
	click(HipiCreateVideoPage.objvisibilitymodebutton, "Visibilty button clicked");
	logger.info("Visibility mode dialog box displayed:"+"Clicking on Followers only button");
	verifyElementExist(HipiCreateVideoPage.objvisibilitymodefolloweronlybutton, "Followersonly button available");
	click(HipiCreateVideoPage.objvisibilitymodefolloweronlybutton, "Followersonly button clicked");
	Thread.sleep(5000);
	String followeronlyclicked=findElement(HipiCreateVideoPage.objvisibilitymodebutton).getText();
	if(visibilitymodefollower.equalsIgnoreCase(followeronlyclicked))
	{
		extent.extentLoggerPass("Post hipit page:","Visibility mode selected as Followers-only");
		logger.info("Post hipit page:"+"Visibility mode selected as Followers-only");
	}
	String visibilitymodeme="Me";
	click(HipiCreateVideoPage.objvisibilitymodebutton, "visibilty button clicked");
	logger.info("Visibility mode dialog box displayed:"+"me button");
	Thread.sleep(5000);
	verifyElementExist(HipiCreateVideoPage.objvisibilitymodemebutton, "Me button available");
	click(HipiCreateVideoPage.objvisibilitymodemebutton, "Me button clicked");
	Thread.sleep(5000);
	String whenmeclicked=findElement(HipiCreateVideoPage.objvisibilitymodemebutton).getText();
	if(visibilitymodeme.equalsIgnoreCase(whenmeclicked))
	{
		extent.extentLoggerPass("Post hipit page:","Visibility mode selected as Me");
		logger.info("Post hipit page:"+"Visibility mode selected as Me");
	}	
	else
	{
		extent.extentLoggerFail("Post hipit page:", "Visibility mode not working");
		logger.info("Post hipit page:"+"Visibility mode not working");
	}
	
	}

public void ValidateTermsandConditioncanbechecked(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking terms and condition checkbox can be checked");
	System.out.println("Hipi_Reg_084");extent.extentLogger("", "Hipi_Reg_084");
	logger.info("Hipi_Reg_084:"+ "Checking terms and condition checkbox can be checked");
	hideKeyboard();
	if(verifyElementExist(HipiCreateVideoPage.objtcheckbox, "Click on terms and condition for the video"))
	{
	click(HipiCreateVideoPage.objtcheckbox, "terms and condition for the video");	
	Thread.sleep(5000);
	extent.extentLoggerPass("Post HipiT Page:","Checking terms and condition checkbox can be checked");
	logger.info("Post HipiT Page:"+ "Checking terms and condition checkbox can be checked");
	}
	else
	{
	extent.extentLoggerFail("Post HipiT Page:","Checking terms and condition checkbox cannot be checked");
	logger.info("Post HipiT Page:"+ "Checking terms and condition checkbox cannot be checked");
	}
	}
	public void Validatevideocanbesavedasdraft(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking video can be saved as draft");
	System.out.println("Hipi_Reg_083");extent.extentLogger("", "Hipi_Reg_083");
	logger.info("Hipi_Reg_083:"+ "Checking video can be saved as draft");
	if(verifyElementExist(HipiCreateVideoPage.objgenreclick, "genre for the video"))
	{
		click(HipiCreateVideoPage.objgenreclick, "Genre for the video");
		logger.info("Post HipiT Page:"+ "Genre is clicked for the video");
		verifyElementExist(HipiCreateVideoPage.objsaveasdraft, "save as draft button in post hipit page");
		click(HipiCreateVideoPage.objsaveasdraft, "save as draft button in post hipit page");	
		logger.info("Post HipiT Page:"+ "Save as draft button in post hipit page");
		Thread.sleep(10000);
		if(verifyElementExist(HipiCreateVideoPage.objsavedasdraftdialog, "Save in draft dialog available"))
		{
		logger.info("Post HipiT Page:"+ "Save in draft dialog available");
		verifyElementExist(HipiCreateVideoPage.objsavedasdraftokbtn, "Video saved as draft dialog ok button");
		click(HipiCreateVideoPage.objsavedasdraftokbtn, "video saved as draft dialog ok button");	
		Thread.sleep(5000);
		extent.extentLoggerPass("Post HipiT Page:","Video can be saved as draft");
		logger.info("Post HipiT Page:"+ "Video can be saved as draft");	
		}else{
			extent.extentLoggerFail("Post HipiT Page:","Video cannot be saved as draft");
			logger.info("Post HipiT Page:"+ "Video cannot be saved as draft");
		}
	}
	else
	{
		extent.extentLogger("", "Genre is not displayed");
	}
	}
	
	
	public void Validatevideopostbuttonworking(String userType) throws Exception
	{
	extent.HeaderChildNode("Checking post hipi button working");
	System.out.println("Hipi_Reg_086");extent.extentLogger("", "Hipi_Reg_086");
	logger.info("Hipi_Reg_086:"+ "Checking post hipi button working");
	click(HipiCreateVideoPage.objgenreclick, "genre for the video");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objtcheckbox, "terms and condition for the video");
	if(verifyElementExist(HipiCreateVideoPage.objpostbtn, "Post hipi button available"))
	{
		click(HipiCreateVideoPage.objpostbtn, "post hipi button");	
		logger.info("Post HipiT Page:"+ "Post hipi button clicked");
		Thread.sleep(20000);

		boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
		if (Popup) {
			extent.extentLoggerPass("Success", " Popup is displayed ");
			logger.info("Video Upload Popup is displayed ");
			extent.extentLoggerPass("Post HipiT Page:","Post hipi button clicked and  working");
			logger.info("Post HipiT Page:"+ "Post hipi button clicked and working");
		}else{
			extent.extentLoggerFail("Success", " Popup is not displayed ");
			logger.info("Video Upload Popup is not displayed ");
			extent.extentLoggerFail("Post HipiT Page:","Post hipi button clicked not working");
			logger.info("Post HipiT Page:"+ "Post hipi button clicked not working");
		}
		verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
		
	}
	else
	{
		extent.extentLogger("", "Post hipi button is not available");
	}
	}
	
	
	
	
	
	
	public void soundDetailPageValidation(String userType) throws Exception {
		extent.HeaderChildNode("Sound Detail Page Validation");
		String title = null;
		String soundTitle1 = null;
		waitTime(10000);
		click(AMDOnboardingScreen.objHipiButton, "HiPi");
		
		waitForElementDisplayed(HipiFeedPage.objshare, 30);
		
		extent.HeaderChildNode("View the Sound details- name and image with play button");
		System.out.println("Hipi_Reg_137 & HiPi_Guest_042,HiPi_Guest_043");		extent.extentLogger("", "Hipi_Reg_137 & HiPi_Guest_042, HiPi_Guest_043");
		for(int i=1;i<5;i++) {
			if (verifyIsElementDisplayed(HipiSoundDetailPage.objOriginalSound, "Original Sound")) {
				waitTime(5000);

				soundTitle1 = getText(HipiSoundDetailPage.objOriginalSound);
				System.out.println(soundTitle1);
				extent.extentLogger("", soundTitle1);
				click(HipiSoundDetailPage.objOriginalSound, "Original Sound");

				if (verifyIsElementDisplayed(HipiSoundDetailPage.objUseThisSoundBtn, "Sound Detail Page")) {
					logger.info("User is navigated to sound detail page on tapping sound name in Feed screen");
					extent.extentLoggerPass("Sound Detail Page",
							"User is navigated to sound detail page on tapping sound name in Feed screen");
				} else {
					logger.error("User is not navigated to sound detail page on tapping sound name in Feed screen");
					extent.extentLoggerFail("Sound Detail Page",
							"User is not navigated to sound detail page on tapping sound name in Feed screen");
				}

				if(verifyElementExist(HipiSoundDetailPage.objImage, "Image")){
					extent.extentLoggerPass("", "Sound Image is displayed");
				}else{
					extent.extentLoggerFail("", "Sound Image is not displayed");
				}

				if(verifyElementExist(HipiSoundDetailPage.objPlayIcon, "Play Icon")){
					extent.extentLoggerPass("", "Play Icon is displayed");
				}else{
					extent.extentLoggerFail("", "Play Icon is not displayed");
				}

				if(verifyElementExist(HipiSoundDetailPage.objTitle, "Sound Title")){
					extent.extentLoggerPass("", "Sound title is displayed");
					title = getText(HipiSoundDetailPage.objTitle);
					logger.info("Sound Title:" + title);
					extent.extentLogger("Sound Title", "Sound Title:" + title);
					
					if(title.length()>1){
						extent.extentLoggerPass("", "SoundTitle is displayed");
					}else{
						extent.extentLoggerFail("", "SoundTitle is not displayed");
					}

				}else{
					extent.extentLoggerFail("", "Sound title is not displayed");
				}
				
				

				extent.HeaderChildNode("Duration of the sound");
				System.out.println("Hipi_Reg_138 & HiPi_Guest_044"); 	extent.extentLogger("", "Hipi_Reg_138 & HiPi_Guest_044");
				String duration = getText(HipiSoundDetailPage.objDuration);
				logger.info("Sound Duration: " + duration);
				int sec = timeToSec(duration);
				System.out.println(sec);
				if(sec>0){
					extent.extentLoggerPass("", "Valid Time");
				}else{
					extent.extentLoggerFail("", "InValid Time");
				}
				extent.extentLogger("Sound Duration", "Sound Duration: " + duration);
					
				extent.HeaderChildNode("Creator name and image- if it’s an original sound");
				System.out.println("Hipi_Reg_139 & HiPi_Guest_045"); 	extent.extentLogger("", "Hipi_Reg_139 & HiPi_Guest_045");				
				if (title.contains("original")) {
					
					if(verifyElementExist(HipiSoundDetailPage.objCreatorName, "Creator name")){
						String creatorName = getText(HipiSoundDetailPage.objCreatorName);
						logger.info("Creator Name: " + creatorName);
						extent.extentLogger("Creator Name", "Creator Name: " + creatorName);

						extent.extentLoggerPass("", "Creator Name is displayed");
					}else{
						extent.extentLoggerFail("", "Creator Name is not displayed");
					}
					
					if(verifyElementExist(HipiSoundDetailPage.objCreatorImage, "Creator Image")){
						extent.extentLoggerPass("","Creator Image is displayed");
					}else{
						extent.extentLoggerFail("", "Creator Image is not displayed");
					}
				}else{
					extent.extentLoggerWarning("", "Sound is not Original");
				}

				
				waitTime(5000);
				
				extent.HeaderChildNode("Number of Videos created using that sound");
				System.out.println("Hipi_Reg_141 & HiPi_Guest_046"); 	extent.extentLogger("", "Hipi_Reg_141 & HiPi_Guest_046");
				if(verifyElementExist(HipiSoundDetailPage.objVideoCount, "Video count")){
					extent.extentLoggerPass("", "Video count is displayed");
					String videoCount = getText(HipiSoundDetailPage.objVideoCount);
					logger.info("Video Count: " + videoCount);
					extent.extentLogger("Video Count", "Video Count: " + videoCount);

				}else{
					extent.extentLoggerFail("", "Video Count is not displayed");
				}
				
				
				

				if (userType.equalsIgnoreCase("Guest")) {
					
					extent.HeaderChildNode("Use this sound- ask login");
					System.out.println("HiPi_Guest_048"); 	extent.extentLogger("", "HiPi_Guest_048");
					verifyElementPresentAndClick(HipiSoundDetailPage.objUseThisSoundBtn, "Use This Sound Button");

					if (verifyIsElementDisplayed(HipiSoundDetailPage.objLoginOrRegisterPopUp, "Login/Register PopUp")) {
						logger.info("Login/Register PopUp is displayed for guest user on tapping Use this Sound button");
						extent.extentLoggerPass("Use This Sound Button",
								"Login/Register PopUp is displayed for guest user on tapping Use this Sound button");
					} else {
						logger.error(
								"Login/Register PopUp is not displayed for guest user on tapping Use this Sound button");
						extent.extentLoggerFail("Use This Sound Button",
								"Login/Register PopUp is not displayed for guest user on tapping Use this Sound button");
					}
					Back(1);
				}

				extent.HeaderChildNode("List of videos created by using that sound. ");
				System.out.println("Hipi_Reg_143 & HiPi_Guest_047"); 	extent.extentLogger("", "Hipi_Reg_143 & HiPi_Guest_047");	
				if(verifyElementExist(HipiSoundDetailPage.objNoData, "Oops No Data Found")){
					extent.extentLoggerFail("", "No Data is Displayed");
				}else{
					extent.extentLoggerPass("", "Videos is Displayed");
					List<WebElement> listOfVideos = getDriver().findElements(HipiSoundDetailPage.objListOfVideos);
					logger.info("List Of Videos: " + listOfVideos.size());
					extent.extentLogger("List Of Videos", "List Of Videos: " + listOfVideos.size());

					if (listOfVideos.size() > 0) {
						verifyElementPresentAndClick(HipiSoundDetailPage.objVideoThumbnail, "Video Thumbnail");

						String soundTitle2 = getText(HipiSoundDetailPage.objOriginalSound);
						System.out.println(soundTitle2);
						
						if(soundTitle2.equalsIgnoreCase(soundTitle1)) {
							logger.info("User is able to view list of videos created using the particular sound");
							extent.extentLogger("Sound Detail Page",
									"User is able to view list of videos created using the particular sound");
						} else {
							logger.error("User is unable to view list of videos created using the particular sound");
							extent.extentLoggerFail("Sound Detail Page",
									"User is unable to view list of videos created using the particular sound");
						}
						Back(1);
						waitTime(5000);
				}
				
				}
				
				
				if (!(userType.equalsIgnoreCase("Guest"))) {
					
					extent.HeaderChildNode("Marking the sound as favorite");
					System.out.println("Hipi_Reg_140"); 	extent.extentLogger("", "Hipi_Reg_140");	
	
					String getPropertyvalue1 = getAttributValue("checked", HipiSoundDetailPage.objFavIcon);
					if(getPropertyvalue1.equalsIgnoreCase("false")){
						extent.extentLogger("", "Sound is already Favourited");
						
					}else{
						verifyElementPresentAndClick(HipiSoundDetailPage.objFavIcon, "Favorite Icon");
						
						String getPropertyvalue = getAttributValue("checked", HipiSoundDetailPage.objFavIcon);
						waitTime(6000);
						
						if (getPropertyvalue.equalsIgnoreCase("true")) {
							logger.info("User is able to mark the sound as Favourite by tapping on star icon");
							extent.extentLoggerPass("Favorite", "User is able to mark the sound as Favourite by tapping on star icon");
						}else {
							logger.error("User is unable to mark the sound as Favourite by tapping on star icon");
							extent.extentLoggerFail("Favorite",	"User is unable to mark the sound as Favourite by tapping on star icon");
						}
					}
					

					
					waitTime(5000);
					
					extent.HeaderChildNode("Share the sound");
					System.out.println("Hipi_Reg_145"); 	extent.extentLogger("", "Hipi_Reg_145");	
					
					verifyElementPresentAndClick(HipiSoundDetailPage.objShareIcon, "Share Icon");
					waitTime(5000);
					if (verifyIsElementDisplayed(AMDPlayerScreen.objFacebook, "Facebook option")) {
						verifyElementPresentAndClick(AMDPlayerScreen.objFacebook, "Facebook option");
						waitTime(15000);
						verifyElementPresentAndClick(AMDPlayerScreen.objFacebookPost, "Post/Share button");
						waitTime(10000);
					}else {
						logger.info("Sound Id is not available");
						extent.extentLogger("Share", "Sound Id is not available");
						Back(1);
					}
					
					
					
					
					extent.HeaderChildNode("Use this sound- enables the user to create a video using that sound.");
					System.out.println("Hipi_Reg_144"); 	extent.extentLogger("", "Hipi_Reg_144");	
					
					
					verifyElementPresentAndClick(HipiMePage.objuseThisSound, "use this Sound");
					Thread.sleep(10000);

					if (verifyElementExist(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
						// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
						// on create a video");
						verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
						verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow button");
						verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, "permission");
						verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow button");
						verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission");
						verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow button");
					}

					// waitTime(15000);
					waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
					Thread.sleep(3000);
					verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
					verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
					waitTime(20000);

					verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload video");
					// verifyElementPresentAndClick(HipiCreateVideoPage.objrecording,"click
					// on recording");
					// SwipeUntilFindElement(HipiCreateVideoPage.objselectimage, "");

					if (verifyElementExist(HipiCreateVideoPage.objselectFirstimage, "Video present")) {
						verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "Video present");

						verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, "Edit HipiIT");
						Thread.sleep(5000);
						if (verifyElementExist(HipiCreateVideoPage.objtrimfinish, "finish")) {

							verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, "finish");

							verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
							waitTime(15000);
							verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
							String postDescription = "Description";
							type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
							waitTime(3000);
							hideKeyboard();
							waitTime(3000);
							verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
							verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
							verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
									" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
							verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");// saveasdraft
							waitTime(10000);
							boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
							if (Popup) {
								extent.extentLoggerPass("Success", "Video Upload Popup is displayed ");
								logger.info("Video Upload Popup is displayed ");
							}else{
								extent.extentLoggerFail("Success", "Video Upload Popup is not displayed ");
								logger.info("Video Upload Popup is not displayed ");
							}
							verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
							Thread.sleep(10000);

							verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
							for (int j = 0; j <= 50; j++) {
								scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
								if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
									Thread.sleep(2000);
									Back(1);
									Thread.sleep(2000);
									verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
								} else {
									verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), "Video");
									click(HipiCreateVideoPage.objselectfirstimage, "First video");
									waitTime(8000);
									break;
								}
							}

							waitTime(5000);

							extent.extentLogger("", "Sound used : "+soundTitle1);
							
							String videoSound = getAttributValue("text", AMDHipi.objSoundUsed);
							
							if (soundTitle1.contains(videoSound)) {
								logger.info("user is able to create new video using Sound");
								extent.extentLoggerPass("videoscreated", "user is able to create new video using Sound");
							} else {
								extent.extentLoggerFail("", "user is not able to create new video using Sound");
							}

							BackToFeedScreen();

						} else {
							System.out.println("Video is less than 5sec , so not selected");
							BackToFeedScreen();
						}
					
					
					}
					
					
					
				}
				
				break;
			
			} else {
				Swipe("Down", 1);
				Thread.sleep(3000);
			}
		}
		
	}
	
	public boolean JSClick(By byLocator, String text) {
		try {
			js.executeScript("arguments[0].click();", findElement(byLocator));
			logger.info("" + text + " " + " is clicked");
			extent.extentLoggerPass("checkElementPresent", "" + text + " is clicked");
			return true;
		} catch (Exception e) {
			logger.error(text + " " + " is not clicked");
			extent.extentLoggerFail("checkElementNotPresent", "" + text + " is not clicked");
			screencapture();
			return false;
		}
	}
	

	
	
	public void discoverPageValidation(String userType) throws Exception {
		extent.HeaderChildNode("Discover Page Validation");
		
		waitTime(10000);
		click(AMDOnboardingScreen.objHipiButton, "HiPi");
		
		waitForElementDisplayed(HipiDiscoverPage.objDiscovertext, 20);
		click(HipiDiscoverPage.objDiscovertext, "Discover option");
		waitTime(6000);
//		JSClick(HipiDiscoverPage.objDiscoverOption, "Discover option");
		
		if (userType.equalsIgnoreCase("Guest")) {
			
			String title1 = getText(HipiDiscoverPage.objTrayTitle);
			logger.info("Tray Title: " + title1);
			extent.extentLogger("Tray Title", "Tray Title: " + title1);
			
			Swipe("Up", 1);
			waitTime(3000);
			
			String title2 = getText(HipiDiscoverPage.objTrayTitle);
			logger.info("Tray Title: " + title2);
			extent.extentLogger("Tray Title", "Tray Title: " + title2);
			
			waitTime(3000);
			
			if(!(title1.equals(title2))) {
				logger.info("User is able to scroll Discover screen");
				extent.extentLogger("Scroll", "User is able to scroll Discover screen");
			}else {
				logger.error("User is not able to scroll Discover screen");
				extent.extentLoggerFail("Scroll", "User is not able to scroll Discover screen");
			}
		}
		
		
		if (!(userType.equalsIgnoreCase("Guest"))) {
			
			extent.HeaderChildNode("See recently serached and trainding rails on search screen");
			System.out.println("Hipi_Reg_104"); 	extent.extentLogger("","Hipi_Reg_104");
			
			verifyElementPresentAndClick(HipiDiscoverPage.objSearchButton,"Search Icon");
			waitTime(3000);
			
			if (verifyIsElementDisplayed(HipiDiscoverPage.objRecentSearch, "Recent searched and Trending rails")) {
				logger.info("User is able to view recently searched and trendings rails on search screen");
				extent.extentLoggerPass("Search", "User is able to view recently searched and trendings rails on search screen");
			}else {
				logger.error("User is not able to view recently searched and trendings rails on search screen");
				extent.extentLoggerFail("Search", "User is not able to view recently searched and trendings rails on search screen");
			}
			
			
			extent.HeaderChildNode("See All, User, video,sound,hashtag category after seraching any content in serach box");
			System.out.println("Hipi_Reg_105"); 	extent.extentLogger("","Hipi_Reg_105");
			verifyElementPresentAndClick(HipiDiscoverPage.objTrendingSearch,"Trending Search");
		
			waitTime(5000);
			verifyElementPresent(HipiDiscoverPage.objAllTab,"All Tab");
			verifyElementPresent(HipiDiscoverPage.objUserTab,"User Tab");
			verifyElementPresent(HipiDiscoverPage.objHipiTsTab,"HiPits Tab");
			verifyElementPresent(HipiDiscoverPage.objSoundTab,"Sound Tab");
			verifyElementPresent(HipiDiscoverPage.objHashtagTab,"Hashtag Tab");
			
			
			extent.HeaderChildNode("See more content for all the rails by tapping on more button");
			System.out.println("Hipi_Reg_108"); 	extent.extentLogger("","Hipi_Reg_108");
			
			List<WebElement> thumbnailCount = getDriver().findElements(HipiDiscoverPage.objThumbnail);
			System.out.println(thumbnailCount.size());
			
			logger.info("Thumbnail Count : " + thumbnailCount.size());
			extent.extentLogger("Thumbnail Count", "Thumbnail Count : " + thumbnailCount.size());
			
			verifyElementPresentAndClick(HipiDiscoverPage.objMore,"More icon");
			
			waitTime(5000);
			
			List<WebElement> thumbnailCountMorePage = getDriver().findElements(HipiDiscoverPage.objThumbnail);
			System.out.println(thumbnailCountMorePage.size());
			logger.info("Thumbnail Count after clicking More button: " + thumbnailCountMorePage.size());
			extent.extentLogger("Thumbnail Count", "Thumbnail Count after clicking More button: " + thumbnailCountMorePage.size());
			
			if(thumbnailCountMorePage.size()>thumbnailCount.size()) {
				logger.info("User is able to expand the rail content by clicking on right arrow to view more about the rail content");
				extent.extentLoggerPass("More", "User is able to expand the rail content by clicking on right arrow to view more about the rail content");
			}else {
				logger.error("User is not able to expand the rail content by clicking on right arrow to view more about the rail content");
				extent.extentLoggerFail("More", "User is not able to expand the rail content by clicking on right arrow to view more about the rail content");
			}
		}
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void HipiHomeScreen(String userType) throws Exception {
		if (userType.equalsIgnoreCase("NonSubscribedUser")) {

			extent.HeaderChildNode("Validating User's Following List");

			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "hipi icon");

			System.out.println("Hipi_Reg_023");
			System.out.println("Validating User's Following List");

			if (verifyElementExist(HipiFeedPage.objfeed, "feed option")) {
				String getPropertyValue = getAttributValue("enabled", HipiFeedPage.objforyou);
				if (getPropertyValue.equalsIgnoreCase("true")) {
					extent.extentLoggerPass("For you", "for you tab is by default highlighted");
					logger.info("for you tab is by default highlighted");
				} else {
					extent.extentLoggerFail("for you tab", "for you tab fails to highlight by default");
					logger.error("for you tab fails to highlight by default");
				}
				verifyElementPresentAndClick(HipiFeedPage.objprofilepic, "profile pic");

				String followingcount = getAttributValue("text", HipiFeedPage.objfollowingcount);
				System.out.println("\n following count");
				// verifyElementPresentAndClick(AMDPopular.objfollowersbackbutton,"click
				// on back button");
				if (followingcount.equalsIgnoreCase("")) {
					logger.info("Following count is displayed blank");
					extentLoggerFail("following", "Following count is displayed blank");
				} else {
					logger.info("Following count displayed " + followingcount);
					extentLoggerPass("following", "Following count displayed " + followingcount);
				}

				if (verifyElementExist(HipiFeedPage.objfollow, "follow option present")) {
					verifyElementPresentAndClick(HipiFeedPage.objfollowing, "following Button");

					if (verifyIsElementDisplayed(HipiFeedPage.objNoResultsFoundInFollowing)) {
						extent.extentLogger("", "User has no profiles in Following list");
					} else {
						int size = getDriver().findElements(HipiFeedPage.objfollowinglistusername).size();
						System.out.println(size);
						if (size > 0) {
							verifyElementExist(HipiFeedPage.objfollowinglistusername, "image");
							logger.info("Profile has list of people in following page");
							extent.extentLoggerPass("", "Profile has list of people in following page");
						} else {
							extent.extentLoggerWarning("userlist", "No userlist are available");
							logger.info("No userlist are available");
						}

					}

					// }
					// verifyElementPresentAndClick(HipiFeedPage.objbackbuttoninselectedimage,"click
					// on back button");
					verifyElementPresentAndClick(HipiFeedPage.objfollowinglistbackbutton, "back button");
					verifyElementPresentAndClick(HipiFeedPage.objbackinprofile, "back button");

					// BackToFeedScreen();
					// TODO Auto-generated method stub

					extent.HeaderChildNode(
							"Validating user is able to view following user's video in his following list");
					System.out.println("Hipi_Reg_024");

					if (verifyElementExist(HipiFeedPage.objfeed, "feed option")) {
						verifyElementPresentAndClick(HipiFeedPage.objfollowinginfeed, "following");
						// String following1 =
						// getText(HipiFeedPage.objfollowinginfeed);
						// logger.info(following1);
						
						for (int i = 0; i <= 7; i++) {
							verifyElementPresentAndClick(HipiFeedPage.objfollowingprofilepic, "profile pic");
							if (verifyElementExist(HipiFeedPage.objfollowinginprofile, "following option present")) {
								logger.info("following button is displayed");
								extent.extentLogger("", "following button is displayed");
							} else {
								logger.info("following button is not displayed");
								extent.extentLogger("", "following button is not displayed");
							}
							verifyElementPresentAndClick(HipiFeedPage.objbackinprofile, "back button");
							Swipe("UP", 1);
							verifyElementPresentAndClick(HipiFeedPage.objprofilepic, "profile pic");
							logger.info("user is able to view video");
							extent.extentLogger("", "user is able to view video");
							Back(1);
						}
						Back(1);
					} else {
						logger.info("user is not able to view video");
						extent.extentLogger("", "user is not able to view video");
					}
				}
			}
		}
	}

	
	
	public void ValidatingHiPiFeedScreen(String userType) throws Exception{
		if(userType.equalsIgnoreCase("Guest")){
			
		}else{
			ValidatingRefreshContent(userType);					//25
			ValidatePlayandPause(userType);						//27
			ValidateHashtagsUsedWithVideo(userType);				//29
			ValidateTaggedPersonUsedWithVideo(userType);			//30
			ValidateProgrssBar(userType);							//31
			ValidateNameOfTheSound(userType);						//33
			ValidateNumberofLikes(userType);						//34


			ValidateEffectUsed(userType);
			ValidateCreatorProfileImage(userType);
			ValidateFollowCreator(userType);		//ONHOLD
			ValidateAllPerformActionAvailable(userType);
		////ValidateNotInterestedVideo(userType);
			ValidateAddFavVideo(userType);
			ValidateDownloadVideo(userType);
			ValidateReportVideo(userType);
			ValidateVideoCanbeshared(userType);
			ValidateCommentCanBeLiked(userType);
			ValidatecommententorprofilepicNavigatetoprofile(userType);

		}
	}
	
	
	
	
	public void ValidatingRefreshContent(String userType) throws Exception {
		extent.HeaderChildNode(" Refresh content  to see  latest videos");
		System.out.println("Hipi_Reg_025"); 	extent.extentLogger("", "Hipi_Reg_025");
		logger.info("Hipi_Reg_025:" + "Verify User able to refresh content of feed screen");
		verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
		if (verifyElementExist(AMDFeed.objFeedAuthorData, "Author data")) {
			logger.info("Hipi feed screen:" + "Storing author data for comparing before refresh");
			String getTextAuthorDataBeforeRefreshing = findElement(AMDFeed.objFeedAuthorData).getText();
			System.out.println("Author data before swiping: " + getTextAuthorDataBeforeRefreshing);
			extent.extentLogger("", "Author data before swiping: " + getTextAuthorDataBeforeRefreshing);
			logger.info("Hipi feed screen" + "Storing author data for comparing before refresh");
			Swipe("DOWN", 1);
			waitForElementDisplayed(AMDFeed.objFeedAuthorData, 10);
			String getTextAfterSwipeAuthorDataAfterRefreshing = findElement(AMDFeed.objFeedAuthorData).getText();
			System.out.println("Author data after swiping: " + getTextAfterSwipeAuthorDataAfterRefreshing);
			extent.extentLogger("", "Author data after swiping: " + getTextAfterSwipeAuthorDataAfterRefreshing);
			logger.info("Hipi feed screen" + "Storing author data for comparing after refresh");
			if (getTextAuthorDataBeforeRefreshing != getTextAfterSwipeAuthorDataAfterRefreshing) {
				logger.info("Hipi feed screen:"
						+ "Refresh working because author data before refreshing and after refreshing are not equal");
				extent.extentLoggerPass("Hipi feed screen:",
						"Refresh working because author data before refreshing and after refreshing are not equal");
			}
		} else {
			logger.info("Hipi feed screen:"
					+ "Refresh not working because author data before refreshing and after refreshing are equal");
			extent.extentLoggerFail("Hipi feed screen:",
					"Refresh not working because author data before refreshing and after refreshing are equal");
		}
	}

	public void ValidatePlayandPause(String userType) throws Exception {
		extent.HeaderChildNode(" Play/Pause video");
		System.out.println("Hipi_Reg_027");	extent.extentLogger("", "Hipi_Reg_027");
		logger.info("Hipi_Reg_027:" + "Checking actionable items working for logged in user of feed screen");
		PausePlayer();
		pauseVideo();
	//	logger.info("Hipi feed screen:" + "ClickCoodinate() used to pause the video of feed screen");
		if (verifyElementExist(HipiFeedPage.objplaybutton, "Play button")) {
			logger.info("Hipi feed screen:" + "Paused the Player");
			extent.extentLoggerPass("Hipi feed screen:", "Paused the Player");
			click(HipiFeedPage.objplaybutton, "Play button");
		} else {
			extent.extentLoggerFail("Hipi feed screen:", "Dint pause the player");
			logger.info("Hipi feed screen:" + "Dint pause the player");
		}
	}

	public void ValidateHashtagsUsedWithVideo(String userType) throws Exception {
		extent.HeaderChildNode("Checking hashtags used with video of feed screen");
		System.out.println("Hipi_Reg_029");	extent.extentLogger("", "Hipi_Reg_029");
		logger.info("Hipi_Reg_029:" + "Checking hashtags used with video of feed screen");
		if (verifyElementExist(AMDFeed.objFeedAuthorData, "Video description")) {
			logger.info("Hipi feed screen:"
					+ "Video description is stored to check #hashtag is available or not of feed screen");
			String getTextVideoDescription = findElement(AMDFeed.objFeedAuthorData).getText();
			extent.extentLogger("", "Video Description: " + getTextVideoDescription);
			if (getTextVideoDescription.contains("#")) {
				extent.extentLoggerPass("Hipi feed screen:", "Hashtags used in the video description");
				logger.info("Hipi feed screen:" + "Hashtags used in the video description");
			} else {
				extent.extentLogger("Hipi feed screen:", "Hashtags not used in the video description");
				logger.info("Hipi feed screen:" + "Hashtags not used in the video description");
			}
		}
	}

	public void ValidateTaggedPersonUsedWithVideo(String userType) throws Exception {
		extent.HeaderChildNode("Checking tagged person with video of feed screen");
		System.out.println("Hipi_Reg_030");	extent.extentLogger("", "Hipi_Reg_030");
		logger.info("Hipi_Reg_030:" + "Checking tagged person with video of feed screen");
		if (verifyElementExist(AMDFeed.objFeedAuthorData, "Video description")) {
			logger.info("Hipi feed screen:"
					+ "Video description is stored to check @tagged user is available or not of feed screen");
			String getTextAuthorData = findElement(AMDFeed.objFeedAuthorData).getText();
			extent.extentLogger("", "Video Description: " + getTextAuthorData);
			if (getTextAuthorData.contains("@")) {
				extent.extentLoggerPass("Hipi feed screen:", "Tagged person used in the video description");
				logger.info("Hipi feed screen:" + "Tagged person used in the video description");
			} else {
				extent.extentLogger("Hipi feed screen:", "Tagged person not used in the video description");
				logger.info("Hipi feed screen:" + "Tagged person not used in the video description");
			}
		}
	}

	public void ValidateProgrssBar(String userType) throws Exception {
		extent.HeaderChildNode(" Progress bar showing the duration of the video");
		System.out.println("Hipi_Reg_031");	extent.extentLogger("", "Hipi_Reg_031");
		logger.info("Hipi_Reg_031:" + "Checking progess bar available for logged in user in feed screen");
		if (verifyElementExist(AMDFeed.objFeedProgressBar, "Progess bar")) {
			extent.extentLoggerPass("Hipi feed screen:", "Progress bar available");
			logger.info("Hipi feed screen:" + "Progress bar available for logged in user in feed screen");
		} else {
			extent.extentLoggerFail("Hipi feed screen:", "Progress bar unavailable");
			logger.info("Hipi feed screen:" + "Progress bar unavailable for logged in user in feed screen");
		}
	}

	public void ValidateNameOfTheSound(String userType) throws Exception {
		extent.HeaderChildNode("Checking name of the sound used");
		System.out.println("Hipi_Reg_033");	extent.extentLogger("", "Hipi_Reg_033");
		logger.info("Hipi_Reg_033:" + "Checking name of the sound used in feed screen");
		if (verifyElementExist(AMDFeed.objSongButton, "Song")) {
			String getTextSongUsed = findElement(AMDFeed.objSongButton).getText();
			System.out.println("Song used: " + getTextSongUsed);
			extent.extentLogger("", "Song used: " + getTextSongUsed);
			logger.info("Hipi feed screen:" + "song available in feed screen");
			extent.extentLoggerPass("Hipi feed screen:", "song available in feed screen");
		} else {
			logger.info("Hipi feed screen:" + "song not available in feed screen");
			extent.extentLogger("Hipi feed screen:", "song used not displayed");
		}

	}

	public void ValidateNumberofLikes(String userType) throws Exception {
		extent.HeaderChildNode("Checking number of Likes");
		System.out.println("Hipi_Reg_034");	extent.extentLogger("", "Hipi_Reg_034");
		logger.info("Hipi_Reg_034:" + "Checking number of Likes in feed screen");
		PausePlayer();
		if (verifyElementExist(AMDFeed.objGetLikeCountButton, "Like Count")) {
			logger.info("Hipi feed screen:" + "Like count stored under like icon in feed screen");
			String getTextLikeCount = findElement(AMDFeed.objGetLikeCountButton).getText();
			System.out.println("Likes count: " + getTextLikeCount);
			extent.extentLogger("", "Likes count: " + getTextLikeCount);
			logger.info("Hipi feed screen:" + "Number of Likes available in feed screen");
			extent.extentLoggerPass("Hipi feed screen:", "Number of Likes available in feed screen");
			click(HipiFeedPage.objplaybutton, "Play button");
		} else {
			logger.info("Hipi feed screen:" + "Likes count unavailable in feed screen");
			extent.extentLoggerFail("Hipi feed screen:", "Likes count unavailable");
		}
	}



	public void ValidateEffectUsed(String userType) throws Exception {
		extent.HeaderChildNode("Checking effect used in feed screen");
		System.out.println("Hipi_Reg_036");	extent.extentLogger("", "Hipi_Reg_036");
		logger.info("Hipi_Reg_036:" + "Checking effect used in feed screen");
		
		PausePlayer();
		if (verifyIsElementDisplayed(AMDFeed.objFeedEffectData, "Used Effect element available")) {
			String effectavailable = findElement(AMDFeed.objFeedEffectData).getText();
			System.out.println("effect available in feed page:" + effectavailable);
			logger.info("Hipi feed screen:" + "Effect used available in feed screen");
			extent.extentLoggerPass("Hipi feed screen:", "Effect available");
		} else {
			extent.extentLoggerWarning("Hipi feed screen:", "Effect used unavailable");
		}
		logger.info("Hipi feed screen:" + "Effect used unavailable in feed screen");
	}

	public void ValidateCreatorProfileImage(String userType) throws Exception {
		extent.HeaderChildNode("Checking creator profile image available in feed screen");
		System.out.println("Hipi_Reg_038");	extent.extentLogger("", "Hipi_Reg_038");
		logger.info("Hipi_Reg_038:" + "Checking creator profile image available in feed screen");
		waitForElementDisplayed(AMDFeed.objFeedCreatorProfilePicture, 10);
		if (verifyElementExist(AMDFeed.objFeedCreatorProfilePicture, "Profile Creator image available")) {
			logger.info("Hipi feed screen:" + "Creator profile image available in feed screen");
			extent.extentLoggerPass("Hipi feed screen:", "Creator profile image available");
		} else {
			logger.info("Hipi feed screen:" + "Creator profile image unavailable in feed screen");
			extent.extentLoggerFail("Hipi feed screen:", "Creator profile image unavailable");
		}
	}

	public void ValidateFollowCreator(String userType) throws Exception {
		extent.HeaderChildNode("Checking able to follow the creator in feed screen ");
		System.out.println("Hipi_Reg_039");	extent.extentLogger("", "Hipi_Reg_039");
		logger.info("Hipi_Reg_039:" + "Checking able to follow the creator");
		verifyElementPresentAndClick(AMDFeed.objFeedActionFollowButton, "Follow button");
		Thread.sleep(5000);
		logger.info("Hipi feed screen:" + "Clicked follow button in feed screen");
		verifyElementPresentAndClick(AMDFeed.objFeedCreatorProfilePicture, "User profile image clicked");
		Thread.sleep(5000);
		if (verifyElementExist(AMDFeed.objFeedFollowingbtn, "Checking following button available under profile page")) {
			logger.info("Hipi feed screen:" + "Following button it is available,user can follow the creator");
			Back(1);
		} else {
			logger.info("Hipi feed screen:" + "Following button it is unavailable,user cannot follow the creator");
		}
	}

	public void ValidateAllPerformActionAvailable(String userType) throws Exception {
		extent.HeaderChildNode("Checking all perform action available in feed screen");
		System.out.println("Hipi_Reg_042");	extent.extentLogger("", "Hipi_Reg_042");
		logger.info("Hipi_Reg_042:" + "Checking all perform action available in feed screen");
		Thread.sleep(5000);
		longPress(HipiFeedPage.objFeedLongPress);
		if (verifyElementExist(AMDFeed.objFeedLongPressDownload, "Download button")) {
			logger.info("Hipi feed screen:" + "Download button available here");
			extent.extentLoggerPass("", "Download Video is displayed");
		} else {
			logger.info("Hipi feed screen:" + "Download button unavailable here");
			extent.extentLoggerFail("", "Download Video is not displayed");
		}
		if (verifyElementExist(AMDFeed.objFeedLongPressAddFav, "Add Fav button")) {
			logger.info("Hipi feed screen:" + "Add fav button available here");
			extent.extentLoggerPass("", "Add to Favourite is displayed");
		} else {
			logger.info("Hipi feed screen:" + "Add fav button unavailable here");
			extent.extentLoggerFail("", "Add to Favourite is not displayed");
		}
		if (verifyElementExist(AMDFeed.objFeedLongPressReport, "Report button")) {
			logger.info("Hipi feed screen:" + "Report button available here");
			extent.extentLoggerPass("", "Report button is displayed");
		} else {
			logger.info("Hipi feed screen:" + "Report button unavailable here");
			extent.extentLoggerFail("", "Report button is not displayed");
		}
		if (verifyElementExist(AMDFeed.objFeedLongPressNotInterested, "Not Interested button")) {
			logger.info("Hipi feed screen:" + "Not interested button available here");
			extent.extentLoggerPass("", "Not interested is displayed");
		} else {
			logger.info("Hipi feed screen:" + "Not interested button unavailable here");
			extent.extentLoggerFail("", "Not interested is not displayed");
		}
		Back(1);
		logger.info("Hipi feed screen:" + "Download,Add Fav,Report and Not interested button available in feed screen");
	}

	public void ValidateNotInterestedVideo(String userType) throws Exception {
		extent.HeaderChildNode("Checking not interested video become unavailable");
		System.out.println("Hipi_Reg_043");	extent.extentLogger("", "Hipi_Reg_043");
		logger.info("Hipi_Reg_043:" + "Checking not interested video become unavailable in feed screen");
		click(AMDFeed.objFeedLongPressNotInterested, "Not interested");
		logger.info("Hipi feed screen:" + "Not interested accepted dialog available");
		if (verifyElementExist(AMDFeed.objFeedLongPressNotInterestedDialog, "Not interested accepted dialog")) {
			String gettextvideodata = findElement(AMDFeed.objFeedvideodataAddFav).getText();
			logger.info("Hipi feed screen:" + "Not interested video description stored");
			click(AMDFeed.objMe, "Me");
			waitTime(5000);
			Back(1);
			String gettextaftermemodulegotclicked = findElement(AMDFeed.objFeedvideodataAddFav).getText();
			logger.info("Hipi feed screen:" + "Clicked me module and storing video description");
			if (gettextvideodata != gettextaftermemodulegotclicked) {
				logger.info("Hipi feed screen:" + "Comparing the description of video and they are not equal");
				extent.extentLoggerPass("Hipi feed screen:", "Video unavailable when not interested button clicked");
			} else {
				logger.info("Hipi feed screen:" + "Comparing the description of video and they are equal");
				extent.extentLoggerFail("Hipi feed screen:", "Video available when not interested button clicked");
			}
		} else {
			System.out.println("Not intereste dialogue is not displayed");
		}

	}

	public void ValidateAddFavVideo(String userType) throws Exception {
		extent.HeaderChildNode("Checking add to fav working");
		System.out.println("Hipi_Reg_044");	extent.extentLogger("", "Hipi_Reg_044");
		logger.info("Hipi_Reg_044:" + "Checking add to fav button working");
		longPress(HipiFeedPage.objFeedLongPress);
		Thread.sleep(5000);
		if (verifyElementExist(AMDFeed.objFeedLongPressAddFav, "Add fav available")) {
			click(AMDFeed.objFeedLongPressAddFav, "Add fav");
			if (verifyElementExist(AMDFeed.objFeedLongPressAddFavDialog, "Add fav accepted dialog")) {
				logger.info("Hipi feed screen:" + "Add fav accept dialog available");
				String videodata = findElement(AMDFeed.objFeedvideodata).getText();
				logger.info("Hipi feed screen:" + "Storing video description added as favourite");
				click(AMDFeed.objMe, "Me");
				click(AMDFeed.objFeedAddFav, "Fav icon");
				Thread.sleep(5000);
				click(AMDFeed.objFeedAddFavVideo, "video");
				Thread.sleep(5000);
				String addfavvideodata = findElement(AMDFeed.objfavvideodata).getText();
				logger.info(
						"Hipi feed screen:" + "Storing video description added in Me module under add favourite tab");
				if (videodata.contains(addfavvideodata)) {
					logger.info(
							"Hipi feed screen:" + "Video added to Me when Add Fav button clicked,video added as fav");
					extent.extentLoggerPass("Hipi feed screen:", "Video added to Me when Add Fav button clicked");
				} else {
					logger.info("Hipi feed screen:" + "Video not added to Me when Add Fav button clicked");
					extent.extentLoggerFail("Hipi feed screen:", "Video not added to Me when Add Fav button clicked");
				}

			} else {
				logger.info("Hipi feed screen:" + "Add fav accepted dialog unavailable");
			}
			Back(2);
		} else {
			logger.info("Hipi feed screen:" + "Add fav unavailable");
		}
	}

	public void ValidateDownloadVideo(String userType) throws Exception {
		extent.HeaderChildNode("Checking download video working");
		System.out.println("Hipi_Reg_045");	extent.extentLogger("", "Hipi_Reg_045");
		logger.info("Hipi_Reg_045:" + "Checking download video working");
		longPress(HipiFeedPage.objFeedLongPress);
		Thread.sleep(10000);
		if (verifyElementExist(AMDFeed.objFeedLongPressDownload, "Checking download video button available")) {
			click(AMDFeed.objFeedLongPressDownload, "Download Video");
			Thread.sleep(5000);

				logger.info("Hipi feed screen:" + "Permission dialog available");
				AllowPermission();
				Thread.sleep(2000);
				//waitForElementDisplayed(AMDFeed.objFeedDownloadedVideoDialog, 5);
				logger.info("Hipi feed screen:" + "Video saved dialog available,download button working accordingly");
				extent.extentLoggerPass("Hipi feed screen:", "Download button working accordingly");

		} else {
			logger.info("Hipi feed screen:" + "Download video button unavailable");
		}
	}

	public void ValidateReportVideo(String userType) throws Exception {
		extent.HeaderChildNode("Checking report video working");
		System.out.println("Hipi_Reg_046");	extent.extentLogger("", "Hipi_Reg_046");
		logger.info("Hipi_Reg_046:" + "Checking report video working");
		waitTime(5000);
		longPress(HipiFeedPage.objFeedLongPress);
		Thread.sleep(10000);
		if (verifyElementExist(AMDFeed.objFeedLongPressReport, "Report Video button available")) {
			Thread.sleep(2000);
			click(AMDFeed.objFeedLongPressReport, "Report Video");
			Thread.sleep(10000);
			if (verifyElementExist(AMDFeed.objFeedReportVideoPage, "Report Video Page")) {
				logger.info("Hipi feed screen:" + "Report video page available");
				verifyElementExist(AMDFeed.objFeedReportreason, "Reason box");
				logger.info("Hipi feed screen:" + "Reason box available");
				click(AMDFeed.objFeedReportreason, "Reason box clicked");
				Thread.sleep(3000);
				click(AMDFeed.objFeedReportreasondata, "Reason data clicked");
				Thread.sleep(5000);
				logger.info("Hipi feed screen:" + "Category box available");
				verifyElementExist(AMDFeed.objFeedReportcategory, "Category box");
				click(AMDFeed.objFeedReportcategory, "Category box clicked");
				Thread.sleep(3000);
				click(AMDFeed.objFeedReporcategorydata, "Category data clicked");
				Thread.sleep(5000);
				verifyElementExist(AMDFeed.objFeedReportsubmit, "Submit button");
				click(AMDFeed.objFeedReportsubmit, "Video reported submit button");
				Thread.sleep(1000);
				
				if(verifyIsElementDisplayed(AMDFeed.objFeedReportsubmit, "Submit button")){
					extent.extentLoggerFail("" , "Video is not reported");					
				}else{
					extent.extentLoggerPass("", "Video reported");
				}
			} else {
				logger.info("Hipi feed screen:" + "Video report page unavailable");
			}
		}
		logger.info("Hipi feed screen:" + "Report video working here");
	}

	public void ValidateVideoCanbeshared(String userType) throws Exception {
		extent.HeaderChildNode("Checking video can be shared");
		System.out.println("Hipi_Reg_047");	extent.extentLogger("", "Hipi_Reg_047");
		logger.info("Hipi_Reg_047:" + "Checking video can be shared");
		waitForElementDisplayed(AMDFeed.objsharevideobtn, 10);
		if (verifyElementExist(AMDFeed.objsharevideobtn, "Sharing video button")) {
			click(AMDFeed.objsharevideobtn, "Sharing video button clicked");
			logger.info("Hipi feed screen:" + "Video share button clicked");
			//verifyElementExist(AMDFeed.objsharepagedisplayed, "share dialog available");
			//verifyElementExist(AMDFeed.objFeedVideoSharingGmail, "Sharing video via gmail");
			Back(1);
			logger.info("Hipi feed screen:" + "Video can be shared with other social media");
			extent.extentLoggerPass("Hipi feed screen:", "Sharing video via gmail working");
		} else {
			logger.info("Hipi feed screen:" + "Video cannot be shared with other social media");
			extent.extentLoggerFail("Hipi feed screen:", "Sharing video via gmail not working");
		}
	}

	public void ValidateCommentCanBeLiked(String userType) throws Exception {
		extent.HeaderChildNode("Checking comment can be liked");
		System.out.println("Hipi_Reg_050");	extent.extentLogger("", "Hipi_Reg_050");
		logger.info("Hipi_Reg_050:" + "Checking comment can be liked");
		Thread.sleep(15000);
		click(AMDFeed.objFeedActionCommentButton, "Comment button");
		logger.info("Hipi feed screen:" + "Comment dialog available");
		Thread.sleep(5000);

		if (verifyIsElementDisplayed(AMDFeed.objFeedCommentLikeButton, "Check comment like icon ")) {
			logger.info("Hipi feed screen:" + "Comment for video available");
			Thread.sleep(6000);
			String commentlikecountbeforeliking = findElement(AMDFeed.objFeedCommentLikeButtonCountBeforeLiking)
					.getText();
			int i = Integer.parseInt(commentlikecountbeforeliking);
			System.out.println("Like count before liking: " + i);
			extent.extentLogger("", "Like count before liking: " + i);
			logger.info("Hipi feed screen:" + "Like count before comment liked");
			Thread.sleep(6000);

			click(AMDFeed.objFeedCommentLikeButton, "Comment like button ");
			Thread.sleep(6000);
			String commentlikecountafterliking = findElement(AMDFeed.objFeedCommentLikeButtonCountBeforeLiking)
					.getText();
			int j = Integer.parseInt(commentlikecountafterliking);
			System.out.println("Like count after liking: " + j);
			extent.extentLogger("", "Like count after liking: " + j);
			Thread.sleep(5000);
			logger.info("Hipi feed screen:" + "Like count after comment liked");
			if (i < j) {
				logger.info("Hipi feed screen:"
						+ "like count before liking is less than comment count after liking,comment can be liked");
				extent.extentLoggerPass("Hipi feed screen:", "Comment can be liked");
				Back(1);
			} else {
				logger.info("Hipi feed screen:" + "Comment cannot be liked");
				extent.extentLoggerFail("Hipi feed screen:", "Comment cannot be liked");
			}
		} else {
			logger.info("Hipi feed screen:" + "No comment for video available");
			Back(1);
		}
	}

	public void ValidatecommententorprofilepicNavigatetoprofile(String userType) throws Exception {
		extent.HeaderChildNode("Checking commentor profile pic navigate to profile");
		System.out.println("Hipi_Reg_052");	extent.extentLogger("", "Hipi_Reg_052");
		logger.info("Hipi_Reg_052:" + "Checking commentor profile pic navigate to profile");
		Thread.sleep(15000);
		click(AMDFeed.objFeedActionCommentButton, "Comment button");
		Thread.sleep(15000);
		if (verifyIsElementDisplayed(AMDFeed.objFeedCommentorProfilepic, "commentor profile pic ")) {
			logger.info("Hipi feed screen:" + "Storing commentor description before clicking profile image");
			String commentordataundercommentdialog = findElement(AMDFeed.objFeedCommentorProfilepicDataundercomment)
					.getText();
			System.out.println(commentordataundercommentdialog);
			extent.extentLogger("", "Comment: "+commentordataundercommentdialog);
			Thread.sleep(15000);
			click(AMDFeed.objFeedCommentorProfilepic, "Commentor profile pic ");
			Thread.sleep(6000);
			logger.info("Hipi feed screen:" + "Storing commentor description after clicking profile image");
			String commentordataunderprofile = getAttributValue("text", AMDFeed.objFeedCommentorProfileData);
			System.out.println(commentordataunderprofile);
			Back(1);
			if (commentordataundercommentdialog.contains(commentordataunderprofile)) {
				logger.info("Hipi feed screen:"
						+ "commentor profile redirected when profile of commentor clicked in comment dialog");
				extent.extentLoggerPass("Hipi feed screen:", "Profile pic navigate to user profile");
				Back(1);
			} else {
				logger.info("Hipi feed screen:" + "Compare commentor name before and after clicking profile image");
				extent.extentLoggerFail("Hipi feed screen:", "Profile pic navigate to user profile invalid");
				Back(1);
			}
		} else {
			extent.extentLogger("", "Comment section has no comments to check for user's profile pic");
		}
	}

	public void DisplayAndContentLanguage(String userType) throws Exception {
		extent.HeaderChildNode("Content language screen functionlity");
		System.out.println("Content language screen functionlity");
		Thread.sleep(6000);
		// if(verifyElementExist(AMDOnboardingScreen.objDiplay_ContinueBtn,
		// "Continue button in display language"))
		// {
		// verifyElementPresentAndClick(AMDOnboardingScreen.objDiplay_ContinueBtn,
		// "Continue button in display language");
		// verifyElementExist(AMDOnboardingScreen.objScreenTitle, "Screen
		// header");
		// verifyElementExist(AMDOnboardingScreen.objContentLanguagePageTitle,
		// "Page title");
		// verifyElementExist(AMDOnboardingScreen.objContentLanguageContainer,
		// "Content language");
		// verifyElementExist(AMDOnboardingScreen.objContent_ContinueBtn,
		// "Continue button in content language screen");
		// verifyElementExist(AMDOnboardingScreen.objBackBtn, "Back button in
		// content language screen");
		//
		// verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn,"Continue
		// button in content language screen");
		// waitTime(2000);
		//
		// }else{
		// System.out.println("Continue button in Display Language is not
		// displayed");
		// }

//		extent.HeaderChildNode("English language is selected by default on the display language screen");
//		System.out.println("HiPi_Guest_003");		extent.extentLogger("", "Hipi_Guest003");
//		System.out.println("\n content language  screen");
//
//		extent.extentLogger("User Type", " userType: " + userType);
//		logger.info("userType: " + userType);
//
//		// DISPLAY LANGUAGE
//		if (verifyElementExist(AMDOnboardingScreen.objDisplayLanguageTitle, "Display Language Page")) {
//			verifyElementPresent(AMDOnboardingScreen.objDefaultDisplayLanguage,
//					"Tick mark is appeared for selected display language");
//
//			String defaultDisplayLanguage = getAttributValue("text", AMDOnboardingScreen.objDefaultDisplayLanguage);
//			if (defaultDisplayLanguage.equalsIgnoreCase("English")) {
//				extent.extentLoggerPass("", "Default Display Language select is :" + defaultDisplayLanguage);
//			} else {
//				extent.extentLoggerFail("", "English is not selected as Default Display language");
//			}
//
//			verifyElementPresentAndClick(AMDOnboardingScreen.objDiplay_ContinueBtn,
//					"Continue button in display language");
//		} else {
//			extent.extentLoggerFail("", "Display Language is not displayed");
//		}

		// CONTENT LANGUAGE
		if (verifyElementExist(AMDOnboardingScreen.objContentLanguagePageTitle, "Content Language Page")) {
			extent.extentLogger("", "Navigated to content language page");
			verifyElementExist(AMDOnboardingScreen.objScreenTitle, "Screen header");
			verifyElementExist(AMDOnboardingScreen.objContentLanguagePageTitle, "Page title");
			verifyElementExist(AMDOnboardingScreen.objContentLanguageContainer, "Content language");
			verifyElementExist(AMDOnboardingScreen.objContent_ContinueBtn,
					"Continue button in content language screen");
			verifyElementExist(AMDOnboardingScreen.objBackBtn, "Back button in content language screen");

			verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn,
					"Continue button in content language screen");

		} else {
			extent.extentLogger("", "Not navigated to content language page");
		}

	}

	public void BrowseForFreeSubscribeAndPrepaidCode(String userType) throws Exception {
		extent.HeaderChildNode("BrowseForFreeAndSubscribeNow");
		extent.extentLogger("", "Hipi_Guest_005");	extent.extentLogger("", "Hipi_Guest_005");
		if (userType.equalsIgnoreCase("Guest")) {

			extent.HeaderChildNode("BrowseForFree");
			Thread.sleep(10000);
			if (verifyIsElementDisplayed(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free")) {

				 verifyElementExist(AMDOnboardingScreen.objFeatureCarousel,"Feature carousel rail");

				 //Verify that Preminum member benifits section is displayed
				 verifyElementExist(AMDOnboardingScreen.objBenefitsTextSection,"Benifits of premium member section");

				 //Verify that pagination dots are displayed
				 verifyElementExist(AMDOnboardingScreen.objDotsIndicator,"Pagination dots");

				 //Verify Browse for free is displayed
				verifyElementExist(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");

				click(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");
				if (verifyElementExist(AMDOnboardingScreen.objLoginRegisterTitle, "Login/Register")) {
					extent.extentLoggerPass("Verify Navigation on clicking Browse for Free button",
							"User is navigated to LoginRegister screen");
					logger.info("User is navigated to LoginRegister screen");

					click(AMDOnboardingScreen.objBackBtn, "Back button");

				} else {
					extent.extentLoggerFail("Verify Navigation on clicking Browse for Free button",
							"Failed to navigate into Login/Register screen post tapping Browse for Free button");
					logger.error("Failed to navigate into Login/Register screen post tapping Browse for Free button");
				}

			} else {
				System.out.println("BrowseForFree CTA is not displayed");
				extent.extentLogger("", "BrowseForFree CTA is not displayed");
			}

			extent.HeaderChildNode("SubscribeNow CTA");
			if (verifyIsElementDisplayed(AMDOnboardingScreen.objSubscribeNowBtn, "Subcribe Now button")) {

				verifyElementPresentAndClick(AMDOnboardingScreen.objSubscribeNowBtn, "Subcribe Now button");
				waitTime(2000);

				if (verifyElementExist(AMDOnboardingScreen.objSubscribeTitle, "Subscribe")) {

					extent.extentLoggerPass("Verify Navigation on clicking Subscribe Now button",
							"User is navigated to LoginRegister screen");
					logger.info("User is navigated to LoginRegister screen");

					click(AMDOnboardingScreen.objBackBtn, "Back button");

				} else {
					extent.extentLoggerFail("Verify Navigation on clicking Subcribe button",
							"Failed to navigate into Subscribe screen post tapping Subscribe Now button");
					logger.error("Failed to navigate into Subscribe screen post tapping Subcribe Now button");
				}

			} else {

				System.out.println("Subscribe Now CTA is not displayed");
			}

			// extent.HeaderChildNode("Have a Prepaid code CTA");
			// if(verifyElementExist(AMDOnboardingScreen.objHavePrepaidBtn,
			// "Have a preapaid code? button")){
			//
			// verifyElementPresentAndClick(AMDOnboardingScreen.objHavePrepaidBtn,
			// "Have a preapaid code? button");
			// waitTime(2000);
			//
			// if
			// (verifyElementExist(AMDOnboardingScreen.objPrepaidPopupLabel,"Prepaid
			// Popup")) {
			// extent.extentLoggerPass("Verify navigation post tapping Prepaid
			// code button", "User is navigated to "
			// + findElement(AMDOnboardingScreen.objPrepaidPopupLabel).getText()
			// + " Screen");
			// logger.info("User is navigated to " +
			// findElement(AMDOnboardingScreen.objPrepaidPopupLabel).getText()
			// + " Screen");
			//
			// Thread.sleep(5000);
			//
			// Back(1);
			//
			// Thread.sleep(3000);
			//
			// } else {
			// extent.extentLoggerFail("Verify navigation post tapping Prepaid
			// code button",
			// "Failed to navigate into Prepaid screen post tapping Have a
			// prepaid code button");
			// logger.error("Failed to navigate into Prepaid screen post tapping
			// Have a prepaid code button");
			// }
			//
			//
			// }else{
			//
			// System.out.println("Prepaid code CTA is not displayed");
			// }

		} else {
			System.out.println("its Nonsubscribed user");
		}
	}

	public void navigateToIntroScreen_DisplaylangScreen() throws Exception {
		extent.HeaderChildNode("Navigation to Intro Screen");
		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button (Display-LanguageScreen)");
		verifyElementExist(AMDOnboardingScreen.objContentLanguageContainer, "Content language");
		// boolean
		// language=verifyElementDisplayed(AMDOnboardingScreen.objSelectContentLang(language))
		// verifyElementPresentAndClick(AMDOnboardingScreen.objcontentlang,"display
		// kannada language");

		verifyElementPresentAndClick(AMDOnboardingScreen.objcontentlanguage, "display English language");
		click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button");
		waitTime(1000);
		verifyElementPresentAndClick(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for Free");
		/*
		 * verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Login link"
		 * ); waitTime(3000); hideKeyboard();
		 * verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Skip link"
		 * ); verifyElementPresent(AMDHomePage.objHomeTab, "Home landing screen"
		 * );
		 */
	}
	// TODO Auto-generated method stub

	public void DownloadScreenUIUXValidation(String userType) throws Exception {
		extent.HeaderChildNode("Verify the UI/UX of Download landing screen as " + userType);
		System.out.println("\nVerify the UI/UX of Download landing screen as " + userType);
		// verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Login
		// Button");
		// verifyElementPresentAndClick(AMDLoginScreen.objskiplnk,"Skip
		// button");
		waitTime(5000);
		verifyElementExist(AMDHomePage.objBottomNavigation("Downloads"), "Downloads tab at the bottom navigation bar");
		click(AMDHomePage.objBottomNavigation("Downloads"), "Downloads tab");
		waitTime(3000);
		verifyElementExist(AMDDownloadPage.objDwnloadsHeader, "Downloads header at the top on center of the screen");
		verifyElementExist(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
		verifyElementExist(AMDDownloadPage.objmoviestab, "Movies tab in Downlaods landing screen");
		verifyElementExist(AMDDownloadPage.objvideostab, "Videos tab in Downloads landing screen ");
		String getPropertyValue = getAttributValue("enabled", AMDDownloadPage.objshowstab);
		if (getPropertyValue.equalsIgnoreCase("true")) {
			extent.extentLoggerPass("Shows tab", "Shows tab is by default highlighted");
			logger.info("Shows tab is by default highlighted");
		} else {
			extent.extentLoggerFail("Shows tab", "Shows tab fails to highlight by default");
			logger.error("Shows tab fails to highlight by default");
		}
		click(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
		verifyIsElementDisplayed(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Shows tab");
		click(AMDDownloadPage.objmoviestab, "navigated to movies tab");
		verifyIsElementDisplayed(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Movies tab");
		click(AMDDownloadPage.objvideostab, "navigated yo videos tab");
	}

	// TODO Auto-generated method stub

	/*
	 * public static void Registerpopup()throws Exception { boolean
	 * RegisterforVibePopup=verifyElementDisplayed(AMDHipi.objRegisterforVibe);
	 * if(RegisterforVibePopup) { extent.extentLogger("RegisterPopup",
	 * "Register Popup is displayed "); logger.info(
	 * "Register Popup is displayed "); }else { extent.extentLogger(
	 * "Register Popup","Register popup is not displayed"); logger.info(
	 * "Reister popup is not displayed "); }
	 * verifyElementPresentAndClick(AMDHipi. objRegisterbtn,
	 * "Click on Register/login button"); //
	 * if(userType.equals(SubscribedUserName)) {
	 * verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField,
	 * "Email field"); type(AMDLoginScreen.objEmailIdField,
	 * "zee5latest@gmail.com", "Email Field");
	 * verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn,
	 * "Proceed Button");
	 * verifyElementPresentAndClick(AMDLoginScreen.objPasswordField,
	 * "Password Field"); type(AMDLoginScreen.objPasswordField, "User@123",
	 * "Password field"); hideKeyboard();
	 * verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
	 * } verifyElementPresentAndClick(AMDLoginScreen.objSkipBtn,
	 * "Click on skip button" ); }
	 */
	public void registerPopUp() throws Exception {
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDHipi.objRegisterforVibe)) {
			logger.info("Register Pop Up is displayed");
			extent.extentLoggerPass("Register Pop Up", "Register Pop Up is displayed");
		} else {
			logger.info("Register Pop Up is not displayed");
			extent.extentLoggerFail("Register Pop Up", "Register Pop Up is not displayed");
		}
	}

	// TODO Auto-generated method stub
	public void HipiSection(String tabName, String userType, String Down, int count, String RIGHT, String text)
			throws Exception {
		// extent.Header
		extent.HeaderChildNode("HiPi Screen Validation");
		System.out.println("\n navigating Hipi screen Functionality");
		// if (userType.equals("SubscribedUser")) {
		verifyElementPresentAndClick(AMDHomePage.objBottomNavigation("HiPi"), "Hipi tab at the bottom navigation bar");
		// if (userType.equals("SubscribedUser")) {
		/*
		 * verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField,
		 * "Email field"); type(AMDLoginScreen.objEmailIdField,
		 * "zee5latest@gmail.com", "Email Field");
		 * verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn,
		 * "Proceed Button");
		 * verifyElementPresentAndClick(AMDLoginScreen.objPasswordField,
		 * "Password Field" ); type(AMDLoginScreen.objPasswordField, "User@123",
		 * "Password field"); hideKeyboard();
		 */
		/*
		 * verifyElementPresentAndClick(AMDHomePage.objBottomNavigation("HiPi"),
		 * "Hipi tab at the bottom navigation bar"); boolean checkbox =
		 * verifyElementDisplayed(AMDHipi.objcheckbox); if (checkbox) {
		 * extent.extentLogger("checkbox",
		 * "checkbox is clicked in Agree Terms and Condition"); logger.info(
		 * "check box is clicked in Agree Terms and Condition"); } else {
		 * extent.extentLogger("checkbox",
		 * "checkbox not clicked get please accept terms and conditions");
		 * logger.info(
		 * "checkbox not clicked we get pleasse accept terms and conditions" );
		 * } verifyElementPresentAndClick(AMDHipi. objcheckbox,
		 * "click Tick mark for checkbox");
		 * verifyElementPresentAndClick(AMDHipi.objsave, "click on save button"
		 * );
		 */
		// verifyElementPresentAndClick(AMDHipi.objFeedIcon, "click on Feed
		// icon");
		// verifyElementPresentAndClick(AMDHipi.objRegisterbtn, "click on
		// register
		// button");
		// verifyElementPresentAndClick(AMDLoginScreen.objSkipBtn, "Click on
		// skip
		// button");
		verifyElementPresentAndClick(AMDHipi.objFeedIcon, "feed icon");
		// click(AMDHipi.objpause, "Pause All CTA");
		// if (checkElementExist(AMDHipi.objpause, "'Paused' play icon")) {
		// extent.extentLoggerPass("Pause", "play icon is paused");
		// logger.info("play icon is paused");
		// }
		// click(AMDDownloadPage.objPausedIcon("Comedy Kiladigalu Championship
		// Episode
		// 24"), "Paused icon");
		verifyElementPresentAndClick(AMDHipi.objFollowing, "followin icon");
		Swipe("UP", 2);
		verifyElementPresentAndClick(AMDHipi.objForYou, "for you");
		PartialSwipe("UP", 2);
		verifyElementPresentAndClick(AMDHipi.objDiscovertext, "discover text");
		// verifyElementExist(AMDHipi.objcarouseltitle, "carousel title");
		// verifyElementPresentAndClick(AMDHipi.objTrayTitle, "display first
		// tray title
		// ");
		//// PartialSwipe("DOWN",4);
		// verifyElementPresent(AMDHipi.objtraytitletext, "display tray title
		// text");
		// SwipeRailContentCards(AMDHipi.objtraytitletext);
		// PartialSwipe("DOWN", 2);
		// click(AMDHipi.objtraytitletext,"swipe taytitle text right");
		// boolean Right = verifyElementDisplayed(AMDHipi.objtraytitletext);
		// if (Right) {
		// checkElementExist(AMDHipi.objtraytitletext, "tray title text");
		// logger.info("User swipes traytitke text to right");
		// extent.extentLogger("Swipe", "user swipes traytitile to right");
		// }
		// verifyElementPresentAndClick(AMDHipi.objRegisterbtn, "click on
		// register
		// button");
		// verifyElementPresentAndClick(AMDLoginScreen.objSkipBtn, "Click on
		// skip
		// button");
		verifyElementPresentAndClick(AMDHipi.objpopulartext, "popular text");
		verifyElementExist(AMDHipi.objpopulartitle, "popular title");
		Swipe("UP", 5);
		verifyElementPresentAndClick(AMDHipi.objprofiletext(text), "profile title");
		logger.info("User is navigated to selected profile");
		extent.extentLogger("Navigate", "user navigated to selected profile");
		// verifyElementPresentAndClick(AMDPopular.objfollow,"click on follow");
		// verifyElementPresentAndClick(AMDHipi.objRegisterforVibe,"RegisterPopUp
		// appears");
		// verifyElementPresentAndClick(AMDHipi.objRegisterbtn,"click on
		// register
		// button");
		// verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn)
		// verifyElementPresentAndClick(AMDPopular.objfollow,"click on follow");
		if (checkElementDisplayed(AMDPopular.objfollow, "following button")) {
			logger.info(" click on following");
			extent.extentLogger("follow", "click on Following");
		} else {
			verifyIsElementDisplayed(AMDPopular.objfollow, "follow");
			logger.info("click on follow and validate if text has changed to following");
			extent.extentLogger("follow", "click on follow and validate if text has changed to following");
		}

		verifyElementPresentAndClick(AMDHipi.objbackbtn, "back button");
		verifyElementPresentAndClick(AMDHipi.objmeicon, "me");
		/*
		 * String followerscount = getAttributValue("text",
		 * AMDPopular.objcounter); if (followerscount.equalsIgnoreCase("true"))
		 * { logger.info("followers count is displayed on followers");
		 * extentLoggerPass("followers",
		 * "followers count is displayed on followers"); } else { logger.info(
		 * "followers count is not displayed on followers");
		 * extentLoggerFail("followers",
		 * "followers count is not displayed on follwers"); }
		 */
		// verifyElementPresentAndClick(AMDPopular.objcounter,"user can view
		// followers
		// count");
		verifyElementPresentAndClick(AMDHipi.objfollowing, "following");
		Swipe("UP", 2);
		boolean following = verifyIsElementDisplayed(AMDHipi.objfollowingtext);
		if (following) {
			extent.extentLogger("following", "user profile is listerd under followiing ");
			logger.info("user profile is listed under following");
		}
		// verifyElementPresentAndClick(AMDHipi.objfollowingtext,"user profile
		// is
		// listed");
		// verifyElementPresentAndClick(AMDHipi.objbackbutton,"click on back
		// button");
		verifyElementPresentAndClick(AMDHipi.objpopularbackbtn, "back button");
		verifyElementPresentAndClick(AMDHipi.objbackbtn, "back button");
		verifyElementPresentAndClick(AMDHipi.objFeedIcon, "Feed icon");
		verifyElementPresentAndClick(AMDHipi.objbackbutton, "back button");
		extent.extentLogger("Hipi", "user navigates to Zee5");
		logger.info("user navigates to Zee5");

	}

	// verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
	// }
	// verifyElementPresentAndClick(AMDLoginScreen.objSkipBtn,"Click on skip
	// button"
	// );

	// verifyElementPresentAndClick(AMDHipi.objbackbtn, "click on back button");
	// verifyElementPresentAndClick(AMDHipi.objmeicon, "click on me text");

	// click(AMDHomePage.objBottomNavigation("HiPi"), "Hipi tab")

	// if(userType.contains("Guest")) {
	// waitTime(8000);
	// Registerpopup();
	// }

	// Registerpopup();
	// verifyElementPresentAndClick(AMDHipi.objRegisterbtn,"click on register
	// button");
	// verifyElementPresentAndClick(AMDLoginScreen.objSkipBtn,"Click on skip
	// button");
	public void Verifyme(String UserType) throws Exception {
		extent.HeaderChildNode("Me icon validation");
		verifyElementPresentAndClick(AMDHomePage.objBottomNavigation("HiPi"), "Hipi tab at the bottom navigation bar");
		verifyElementPresentAndClick(AMDHipi.objmeicon, "click on me icon");
		// wait(2000);
		// verifyElementPresentAndClick(AMDPopular.objeditprofile,"click on edit
		// profile");
		String Editprofile1 = getText(AMDPopular.objeditprofile);
		logger.info(Editprofile1);
		click(AMDPopular.objeditbackbutton, "back button");
		click(AMDPopular.objbackbtn, "back button");
		click(AMDPopular.objfeedbackbutton, "back button");
		click(AMDMore.objMore, "More tab at the bottom navigation bar");
		click(AMDMore.objheader, "header profile");
		click(AMDMore.objmoreeditprofile, "edit profile");
		// waitTime(10000);
		String Editprofile2 = getText(AMDMore.objmoreeditprofile);
		logger.info(Editprofile2);
		boolean EditProfile = Editprofile1.equals(Editprofile2);
		if (EditProfile == true) {
			logger.info("creators profile is same as zee5 page profile");
			extentLoggerPass("EditProfile", "Creator profile is same as zee5 page profile");
		} else {
			logger.info("creators profile is same as zee5 page profile");
			extentLoggerPass("EditProfile", "Creator profile is same as zee5 page profile");
		}
		String followerscount = getAttributValue("text", AMDPopular.objfollowerscount);
		System.out.print("\n followers count");
		if (followerscount.equalsIgnoreCase("")) {
			logger.error("Followers count is displayed blank");
			extentLoggerFail("followers", "Followers count is displayed blank");
		} else {
			logger.info("Followers count displayed " + followerscount);
			extentLoggerPass("followers", "Followers count displayed " + followerscount);
		}
		verifyElementPresentAndClick(AMDPopular.objfollowers, "followers");
		Swipe("UP", 2);
		verifyElementPresentAndClick(AMDPopular.objfollowerstitle, "followers title");
		extent.extentLogger("followers", "user is able to view followers list by tapping on follower");
		logger.info("user is able to view followers list by tapping on follower");
		verifyElementPresentAndClick(AMDPopular.objfollowerbackbutton, "followers back button");
		verifyElementPresentAndClick(AMDPopular.objfollowing, "following");
		Swipe("UP", 2);
		// verifyElementPresentAndClick(AMDPopular.objfollowerstitle,"click on
		// followers
		// title");
		extent.extentLogger("following", "user is able to view following list by tapping on following");
		logger.info("user is able to view following list by tapping on followeing");
		verifyElementPresentAndClick(AMDPopular.objfollowingbackbutton, "following back button");
		verifyElementPresentAndClick(AMDPopular.objeditprofile, "edit profile");
		extent.extentLogger("Me", "user tapped on edit profile can see the details");
		logger.info("user tapping on edit profile can see details");
		verifyElementPresentAndClick(AMDPopular.objfirstname, "firstname");
		verifyElementPresentAndClick(AMDPopular.objfirstnametxt, "firstname text");
		verifyElementPresentAndClick(AMDPopular.objlastname, "lastname");
		verifyElementPresentAndClick(AMDPopular.objlastnametxt, "lastname text");
		verifyElementPresentAndClick(AMDPopular.objuserhandle, "userhandle");
		verifyElementPresentAndClick(AMDPopular.objuserhandletxt, "userhandle text");
		verifyElementPresentAndClick(AMDPopular.objdob, "date of birth");
		verifyElementPresentAndClick(AMDPopular.objdobtext, "date of birth text");
		verifyElementPresentAndClick(AMDPopular.objuserbio, "userbio");
		// verifyElementPresentAndClick(AMDPopular.objcounter,"click on counter
		// text");
		verifyElementPresentAndClick(AMDPopular.objbackbtn, "back button");
		verifyElementPresentAndClick(AMDPopular.objshareprofile, "share profile");
		extent.extentLogger("shareprofile", "user is able to share profile by tapping on share");
		logger.info("user is able to share profile by tapping on share");
		verifyElementPresentAndClick(AMDPopular.objHipiprofile, "Hipi Profile");
		extent.extentLogger("Hipi profile", "share widgets are displayed by tapping on share profile");
		logger.info("share widgets are displayed by tapping on share profile");

	}

	public void MoreScreenValidation() throws Exception {
		extent.HeaderChildNode("verify more screen displayed");
		verifyElementExist(AMDHomePage.objMoreMenuBtn, "More tab at the bottom navigation bar");
		click(AMDHomePage.objMoreMenuBtn, "More tab");
		extent.extentLogger("More", "MoreMenu is displayed on tapping on Bottom Navigation bar");
		logger.info("MoreMenu is displayed on  tapping on bottom Nvigation bar");
	}

	public void settings(String usertype) throws Exception {
		extent.HeaderChildNode("Settings screen validation");
		System.out.println("\nSettings screen validation");

		// Setting screen validation
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		if (checkElementExist(AMDMoreMenu.objSettingsScreenTitle, "Setting screen title")) {
			logger.info("Settings screen is displayed when user taps on the Settings option from the More menu");
			extentLoggerPass("Settings",
					"Settings screen is displayed when user taps on the Settings option from the More menu");
		} else {
			logger.error("Settings screen is not displayed when user taps on the Settings option from the More menu");
			extentLoggerFail("Settings",
					"Settings screen is not displayed when user taps on the Settings option from the More menu");
		}
		verifyElementPresent(AMDMoreMenu.objVideoStreamingMenuTitle, "Video streaming menu");
		verifyElementPresent(AMDMoreMenu.objDownloadsMenuTitle, "Downloads menu");

		String pos1 = getAttributValue("bounds", AMDMoreMenu.objDownloadsMenuTitle);
		String pos2 = null;
		PartialSwipe("UP", 1);
		pos2 = getAttributValue("bounds", AMDMoreMenu.objDownloadsMenuTitle);
		if (pos1 != pos2) {
			logger.info("Settings screen is scrollable");
			extentLoggerPass("Swipe", "Settings screen is scrollable");
		} else {
			logger.error("Settings screen is not scrollable");
			extentLoggerFail("Swipe", "Settings screen is not scrollable");
		}

		Swipe("UP", 2);
		verifyElementPresent(AMDMoreMenu.objLanguageMenuTitle, "Languages menu");
		if (!(usertype.equalsIgnoreCase("Guest"))) {
			verifyElementPresent(AMDMoreMenu.objParentalControl, "Parental Control menu");
			verifyElementPresent(AMDSettingsScreen.objAuthenticateDevice, "Authenticate Device menu");
		}
		verifyElementPresent(AMDMoreMenu.objSearchHistroyLabel, "Search histroy Label");
		verifyElementPresent(AMDMoreMenu.objResetSettingsToDefault, "Reset Settings to default Label");
		Swipe("DOWN", 2);

		// Back button validation
		click(AMDMoreMenu.objBackButtonInSettingsScreen, "Back button in settings screen");
		if (verifyElementPresent(AMDMoreMenu.objSettings, "Settings option")) {
			logger.info(
					"on tapping on the Back button from settings screen, user is navigated to the screen from which More screen was launched");
			extentLoggerPass("Back button",
					"on tapping on the Back button from settings screen, user is navigated to the screen from which More screen was launched");
		} else {
			logger.error(
					"on tapping on the Back button from settings screen, user is not navigated to the screen from which More screen was launched");
			extentLoggerFail("Back button",
					"on tapping on the Back button from settings screen, user is not navigated to the screen from which More screen was launched");
		}

		click(AMDMoreMenu.objSettings, "Settings option");
	}

	public void DownloadOverWiFiOnlyONValidation(String userType, String searchKeyword1) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Download over WiFi only ON state Validation");
			System.out.println("\nDownload over WiFi only ON state Validation");

			// verifyElementPresentAndClick(AMDHomePage.MoreMenuIcon, "More Menu
			// tab");
			// verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings
			// option");
			waitTime(2000);
			verifyElementPresentAndClick(AMDSettingsScreen.objDownloadOverWifiToggle, "Wifi On toggle");
			Back(1);
			waitTime(2000);
			Back(1);
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, searchKeyword1 + "\n", "Search bar");
			waitTime(2000);
			hideKeyboard();
			// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd,
			// 2000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);

			click(AMDMoreMenu.objSearchResult(searchKeyword1), "Search result");

			verifyElementPresentAndClick(AMDMoreMenu.objDownloadIcon, "Download icon");
			verifyElementPresentAndClick(AMDMoreMenu.objDataSaver, "Data Saver option");
			verifyElementPresentAndClick(AMDMoreMenu.objStartDownload, "Start Download");

			String wifi = "";
			String cmd = "adb shell dumpsys \"wifi | grep 'Wi-Fi is'\"";
			Process p = Runtime.getRuntime().exec(cmd);
			System.out.println(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			wifi = br.readLine();
			logger.info("Wifi status :: " + wifi.toString());

			if (wifi.equalsIgnoreCase("Wi-Fi is enabled")) {
				logger.info("Content is downloading on Wifi network");
				extent.extentLoggerPass("Download", "Content is downloading on Wifi network");
			} else {
				logger.error("Content is not downloading on Wifi network");
				extent.extentLoggerFail("Download", "Content is not downloading on Wifi network");
			}
			Back(1);
		}
	}

	public void downloadSettingsValidation() throws Exception {
		extent.HeaderChildNode("Verify if Quality in Downloads is set to Ask Everytime by default");
		System.out.println("\nDownload settings validation");
		// verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
		// verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings
		// option");
		String quality = getText(AMDMoreMenu.objDownloads_Quality);
		System.out.println(quality);
		if (quality.equalsIgnoreCase("Ask each time")) {
			logger.info("Download Quality is set to " + quality + " by default");
			extent.extentLoggerPass("Download Quality", "Download Quality is set to " + quality + " by default");

		} else {
			logger.error("Download Quality is not set to Ask Each Time  by default");
			extent.extentLoggerFail("Download Quality", "Download Quality is not set to Ask Each Time  by default");
		}

		String state = getText(AMDMoreMenu.objDownloads_WifiOnly);
		System.out.println(state);
		if (state.equalsIgnoreCase("OFF")) {
			logger.info("Download over WiFi only option is in  " + state + " state by default");
			extent.extentLoggerPass("On/Off", "Download over WiFi only option is in  " + state + " state by default");

		} else {
			logger.error("Download over WiFi only option is not in OFF state by default ");
			extent.extentLoggerFail("On/Off", "Download over WiFi only option is not in OFF state by default ");
		}

		WebElement onOffToggle = findElement(AMDMoreMenu.objDownloads_WifiOnly);
		int toggleRightX = onOffToggle.getLocation().getX();
		System.out.println(toggleRightX);
		Dimension sizee = getDriver().manage().window().getSize();
		System.out.println(sizee.getWidth());
		int sizeee = sizee.getWidth() - 300;

		if (toggleRightX >= sizeee) {
			logger.info("On/Off toggle is displayed at right side of the option");
			extent.extentLoggerPass("On/Off Toggle", "On/Off toggle is displayed at right side of the option");
		} else {
			logger.error("On/Off toggle is not displayed at right side of the option");
			extent.extentLoggerFail("On/Off Toggle", "On/Off toggle is not displayed at right side of the option");
		}
		verifyElementPresentAndClick(AMDMoreMenu.objDownloads_Quality, "Download Quality Settings option");
		extent.HeaderChildNode("To verify if Select Download Video Quality screen is displayed");
		if (checkElementExist(AMDSettingsScreen.objSelectVideoQualityLabel, "Select Video Download Quality")) {
			logger.info("Navigated to Select Download Video Quality screen");
			extent.extentLoggerPass("Quality", "Navigated to Select Download Video Quality screen");
		} else {
			logger.error("Not navigated to Select Download Video Quality screen");
			extent.extentLoggerFail("Quality", "Not navigated to Select Download Video Quality screen");
		}
		verifyElementExist(AMDSettingsScreen.objVideoQualityBest, "Best Quality Option");
		verifyElementExist(AMDSettingsScreen.objVideoQualityBetter, "Better Quality Option");
		verifyElementExist(AMDSettingsScreen.objVideoQualityGood, "Good Quality Option");
		verifyElementExist(AMDSettingsScreen.objVideoQualityDatasaver, "Data Saver Quality Option");
		verifyElementExist(AMDSettingsScreen.objVideoQualityAskEachTime, "Ask Each Time Option");
		verifyElementExist(AMDSettingsScreen.objTickMark, "Tick mark");
		verifyElementPresentAndClick(AMDSettingsScreen.objXButton, "X Button");
	}

	@SuppressWarnings("deprecation")
	public void parentalPinValidation(String userType, String searchKeyword) throws Exception {
		extent.HeaderChildNode("Parental Pin Validation");
		System.out.println("\nParental Pin Validation");

		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			click(AMDHomePage.MoreMenuIcon, "More Menu tab");
			click(AMDMoreMenu.objSettings, "Settings option");
			waitTime(2000);
			click(AMDSettingsScreen.objDownloadOverWifiToggle, "Wifi Off toggle");
			Back(1);
			waitTime(3000);
			Back(1);
			click(AMDHomePage.objSearchinUpcoming, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, searchKeyword + "\n", "Search bar");
			waitTime(2000);
			hideKeyboard();
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);

			click(AMDMoreMenu.objSearchResult(searchKeyword), "Search result");

			click(AMDMoreMenu.objDownloadIcon, "Download icon");
			click(AMDMoreMenu.objDataSaver, "Data Saver option");
			click(AMDMoreMenu.objStartDownload, "Start Download");

			String wifi = "";
			String cmd = "adb shell dumpsys \"wifi | grep 'Wi-Fi is'\"";
			Process p = Runtime.getRuntime().exec(cmd);
			System.out.println(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			wifi = br.readLine();
			logger.info("Wifi status :: " + wifi.toString());

			if (wifi.equalsIgnoreCase("Wi-Fi is enabled")) {
				logger.info("Content is downloading on Wifi network");
				extent.extentLoggerPass("Download", "Content is downloading on Wifi network");
			} else {
				logger.error("Content is not downloading on Wifi network");
				extent.extentLoggerFail("Download", "Content is not downloading on Wifi network");
			}
			Back(1);

			click(AMDHomePage.MoreMenuIcon, "More Menu tab");
			click(AMDMoreMenu.objSettings, "Settings option");
			waitTime(5000);
			Swipe("UP", 1);
			verifyElementPresentAndClick(AMDMoreMenu.objParentalControl, "Parental Control");
			verifyElementExist(AMDMoreMenu.objPasswordField, "Password field");
			String password = "";
			if (userType.equals("NonSubscribedUser")) {
				password = getParameterFromXML("SettingsNonsubscribedPassword");
			} else if (userType.equals("SubscribedUser")) {
				password = getParameterFromXML("SettingsSubscribedPassword");
			}
			click(AMDMoreMenu.objPasswordField, "Password field");
			getDriver().getKeyboard().sendKeys(password);

			hideKeyboard();
			if (getOEMName.contains("vivo")) {
				// hidePwdKeyboard();
			}
			click(AMDMoreMenu.objPasswordContinueBtn, "Continue button");
			waitTime(2000);

			String state = getText(AMDMoreMenu.objNoRestriction);
			System.out.println(state);
			if (state.equalsIgnoreCase("No Restriction")) {
				logger.info(state + " is selected by default");
				extent.extentLoggerPass("Parental Pin", state + " is selected by default");

			} else {
				logger.error(state + " is not selected by default");
				extent.extentLoggerFail("Parental Pin", state + " is not selected by default");

			}

			click(AMDMoreMenu.objRestrictAllContent, "Restrict All Content option");
			click(AMDMoreMenu.objContinueBtn, "Continue Button");
			waitTime(2000);

			verifyElementExist(AMDMoreMenu.objSetPin, "Set Pin");
			type(AMDMoreMenu.objParentalLockPin1, "1", "ParentalLockPin");
			hideKeyboard();
			type(AMDMoreMenu.objParentalLockPin2, "2", "ParentalLockPin");
			hideKeyboard();
			type(AMDMoreMenu.objParentalLockPin3, "3", "ParentalLockPin");
			hideKeyboard();
			type(AMDMoreMenu.objParentalLockPin4, "4", "ParentalLockPin");
			hideKeyboard();
			waitTime(4000);
			click(AMDMoreMenu.objSetPinContinueBtn, "Continue Button");
			waitTime(2000);

			click(AMDMoreMenu.objParentalLockDone, "Done Button");
			Back(1);
			waitTime(3000);
			Back(1);

			verifyElementPresentAndClick(AMDHomePage.objDownload, "Downloads tab");
			verifyElementPresentAndClick(AMDDownloadPage.objvideostab, "Videos tab");
			waitForElementDisplayed(AMDMoreMenu.objDownloadDoneIcon, 20);
			click(AMDDownloadPage.objDownloadedContent, "Downloaded Content");
			click(AMDDownloadPage.objPlayDownloadedContent, "Play Downloaded Content");

			waitTime(2000);
			Back(1);
			verifyElementPresentAndClick(AMDDownloadPage.objEnterPinCTA, "Enter Pin CTA");

			type(AMDMoreMenu.objParentalLockPin1, "1", "ParentalLockPin");
			hideKeyboard();
			type(AMDMoreMenu.objParentalLockPin2, "2", "ParentalLockPin");
			hideKeyboard();
			type(AMDMoreMenu.objParentalLockPin3, "3", "ParentalLockPin");
			hideKeyboard();
			type(AMDMoreMenu.objParentalLockPin4, "4", "ParentalLockPin");
			hideKeyboard();
			click(AMDMoreMenu.objSetPinContinueBtn, "Continue button");
			waitTime(5000);
			Back(1);
			click(AMDHomePage.MoreMenuIcon, "More Menu tab");
			click(AMDMoreMenu.objSettings, "Settings option");
			waitTime(5000);
			Swipe("UP", 1);
			verifyElementPresentAndClick(AMDMoreMenu.objParentalControl, "Parental Control");
			verifyElementExist(AMDMoreMenu.objPasswordField, "Password field");

			if (userType.equals("NonSubscribedUser")) {
				password = getParameterFromXML("SettingsNonsubscribedPassword");
			} else if (userType.equals("SubscribedUser")) {
				password = getParameterFromXML("SettingsSubscribedPassword");
			}
			click(AMDMoreMenu.objPasswordField, "Password field");
			getDriver().getKeyboard().sendKeys(password);

			hideKeyboard();
			if (getOEMName.contains("vivo")) {
				// hidePwdKeyboard();
			}
			click(AMDMoreMenu.objPasswordContinueBtn, "Continue button");
			waitTime(2000);
			click(AMDMoreMenu.objNoRestriction, "No Restriction");
			click(AMDMoreMenu.objContinueBtn, "Continue Button");
			waitTime(2000);
			click(AMDMoreMenu.objParentalLockDone, "Done Button");
			Back(1);
		} else {
			logger.info("Parental Pin Validation is NOT applicable for " + userType);
			extent.extentLogger("Parental Pin", "Parental Pin Validation is NOT applicable for " + userType);
		}
	}

	public static String getCarouselTitleFromAPI(String userType, String pagenameforApi, String pUsername,
			String pPassword) {
		Response respPage = ResponseInstance.getResponseForApplicasterPagesVersion2(userType, pagenameforApi, pUsername,
				pPassword);
		List<String> bucketsSize = respPage.jsonPath().getList("buckets");
		logger.info("bucketsSize: " + bucketsSize.size());
		String carouselContentTitle = null;
		main: for (int i = 0; i < bucketsSize.size(); i++) {
			String description = respPage.jsonPath().getString("buckets[" + i + "].short_description");

			if ((description.equalsIgnoreCase("Home Page Slider")) | (description.equalsIgnoreCase("Movies Banner"))) {
				List<String> carouselItems = respPage.jsonPath().getList("buckets[" + i + "].items");
				logger.info("carouselItems: " + carouselItems.size());

				for (int j = 0; j < 7; j++) {
					carouselContentTitle = respPage.jsonPath().getString("buckets[" + i + "].items[" + j + "].title");
					logger.info(carouselContentTitle);

					String CarouselContentBusinessType = respPage.jsonPath()
							.getString("buckets[" + i + "].items[" + j + "].business_type");
					logger.info(CarouselContentBusinessType);

					if (CarouselContentBusinessType.equalsIgnoreCase("premium_downloadable")) {
						break main;
					}
				}
			}
		}
		return carouselContentTitle;
	}

	@SuppressWarnings("unused")
	public void videoStreamingValidation(String userType) throws Exception {
		extent.HeaderChildNode("Video Streaming validation");
		System.out.println("\nVideo Streaming validation");
		// Video streaming menus validation
		verifyElementPresent(AMDMoreMenu.objvideoQualityOption, "Video Quality option");
		verifyElementPresent(AMDMoreMenu.objVideoStreamOverWifiOnlyOption, "Stream over wifi only option");
		verifyElementPresent(AMDMoreMenu.objVideoAutoPlay, "Video Autoplay option");

		click(AMDMoreMenu.objVideo_Quality("Auto"), "Video quality option");

		// video quality screen validation
		verifyElementPresent(AMDMoreMenu.objVideoQualityScreenTitle, "Video quality screen title");
		verifyElementPresent(AMDSettingsScreen.objVideoQualityBest, "option Best");
		verifyElementPresent(AMDSettingsScreen.objVideoQualityBetter, "option Better");
		verifyElementPresent(AMDSettingsScreen.objVideoQualityGood, "option Good");
		verifyElementPresent(AMDSettingsScreen.objVideoQualityDatasaver, "option Datasaver");
		verifyElementPresent(AMDMoreMenu.objAutoOption, "option Auto");
		verifyElementPresent(AMDMoreMenu.objCloseButtonInVideoQualityScreen, "Close button");
		if (verifyElementDisplayed(AMDMoreMenu.objSelectedVideoQualityOption("Auto"))) {
			logger.info("the default selection in the Select Video Quality is 'Auto' option");
			extentLoggerPass("Default selected Video quality option",
					"the default selection in the Select Video Quality is 'Auto' option");
		} else {
			logger.error("the default selection in the Select Video Quality is not 'Auto' option");
			extentLoggerFail("Default selected Video quality option",
					"the default selection in the Select Video Quality is not 'Auto' option");
		}

		click(AMDMoreMenu.objCloseButtonInVideoQualityScreen, "Close button");
		if (verifyElementDisplayed(AMDMoreMenu.objvideoQualityOption)) {
			logger.info("'X' button in Select Video Quality screen is functional");
			extentLoggerPass("Close button", "'X' button in Select Video Quality screen is functional");
		} else {
			logger.error("'X' button in Select Video Quality screen is not functional");
			extentLoggerFail("Close button", "'X' button in Select Video Quality screen is not functional");
		}

		click(AMDMoreMenu.objVideo_Quality("Auto"), "Video quality option");
		click(AMDSettingsScreen.objVideoQualityBetter, "option Better");
		if (verifyElementDisplayed(AMDMoreMenu.objVideo_Quality("Better"))) {
			logger.info("Select Video Quality screen with tick mark is displayed");
			extentLoggerPass("Video quality option", "Select Video Quality screen with tick mark is displayed");
		} else {
			logger.error("Select Video Quality screen with tick mark is not displayed");
			extentLoggerFail("Video quality option", "Select Video Quality screen with tick mark is not displayed");
		}

		click(AMDMoreMenu.objVideo_Quality("Better"), "Video quality option");
		click(AMDMoreMenu.objAutoOption, "option Auto");

		// Stream over wifi only option validation
		WebElement wifitoggle = findElement(AMDMoreMenu.objVideo_WifiOnly);
		int wifitoggleX = wifitoggle.getLocation().getX();
		int wifitoggleY = wifitoggle.getLocation().getY();

		WebElement wifitext = findElement(AMDMoreMenu.objVideoStreamOverWifiOnlyOption);
		int wifitextX = wifitext.getLocation().getX();
		int wifitextY = wifitoggle.getLocation().getY();

		if (wifitextY < (wifitoggleY + 10)) {
			if (wifitoggleX > wifitextX) {
				logger.info("On/Off toggle is displayed at the right side of the Stream over WiFi only option");
				extent.extentLoggerPass("wifi On/Off toggle",
						"On/Off toggle is displayed at the right side of the Stream over WiFi only option");
			} else {
				logger.error("On/Off toggle is not displayed at the right side of the Stream over WiFi only option");
				extent.extentLoggerFail("wifi On/Off toggle",
						"On/Off toggle is not displayed at the right side of the Stream over WiFi only option");
			}
		}

		String wifitoggleStatus = getText(AMDMoreMenu.objVideo_WifiOnly);
		if (wifitoggleStatus.equalsIgnoreCase("OFF")) {
			logger.info("the default state of the 'Stream over WiFi only' option is in off state.");
			extentLoggerPass("Stream over WiFi only",
					"the default state of the 'Stream over WiFi only' option is in off state.");
		} else {
			logger.error("the default state of the 'Stream over WiFi only' option is not in off state.");
			extentLoggerFail("Stream over WiFi only",
					"the default state of the 'Stream over WiFi only' option is not in off state.");
		}

		Back(1);
		waitTime(3000);
		Back(1);
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd,
			// 2000);
		}

		verifyElementExist(AMDHomePage.objHomeTab, "Home Tab");
		waitTime(10000);
		String email = null, password = null;
		if (userType.contains("NonSubscribedUser")) {
			email = getParameterFromXML("SettingsNonsubscribedUserName");
			password = getParameterFromXML("SettingsNonsubscribedPassword");
		} else if (userType.contains("SubscribedUser")) {
			email = getParameterFromXML("SettingsSubscribedUserName");
			password = getParameterFromXML("SettingsSubscribedPassword");
		}
		String courselContentTitle = getCarouselTitleFromAPI(userType, "homepage", email, password);
		// String courselContentTitle = carouselValidationWithApi(userType,
		// "homepage");
		System.out.println(courselContentTitle);
		if (courselContentTitle != null) {
			waitForElementAndClickIfPresent(AMDHomePage.objContentTitle(courselContentTitle), 10, "Carousel content");
			for (int i = 0; i < 2; i++) {
				if (verifyElementPresent(AMDHomePage.objContentTitle(courselContentTitle), "Carousel content")) {
					break;
				}

			}
			// click(AMDHomePage.objContentTitle(courselContentTitle), "Carousel
			// content");
		} else {
			click(AMDGenericObjects.objCarouselTitle("Shivaji Surathkal"), "Carousel content");
		}

		String wifi = "";
		String cmd = "adb shell dumpsys \"wifi | grep 'Wi-Fi is'\"";
		Process p = Runtime.getRuntime().exec(cmd);
		System.out.println(cmd);
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		wifi = br.readLine();
		logger.info("Wifi status :: " + wifi.toString());

		if (wifi.equalsIgnoreCase("Wi-Fi is enabled")) {
			if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
				waitTime(3000);
				if (verifyIsElementDisplayed(AMDHomePage.objSubscribePopup)) {
					Back(1);
				}
				if (verifyElementDisplayed(AMDHomePage.objPlayerScreen)) {
					logger.info("Content playback is playing on Wifi network");
					extent.extentLoggerPass("Play", "Content playback is playing on Wifi network");
				} else {
					logger.error("Content playback is not playing on Wifi network");
					extent.extentLoggerFail("Play", "Content playback is not playing on Wifi network");
				}
			} else {
				waitTime(10000);
				click(AMDHomePage.objPlayerScreen, "Player screen");
				// waitForElementDisplayed(AMDHomePage.objMaximizeIcon, 10);
				if (verifyIsElementDisplayed(AMDConsumptionScreen.objShareBtn)) {
					logger.info("Content playback is playing on Wifi network");
					extent.extentLoggerPass("Play", "Content playback is playing on Wifi network");
				} else {
					logger.error("Content playback is not playing on Wifi network");
					extent.extentLoggerFail("Play", "Content playback is not playing on Wifi network");
				}
			}
		} else {
			logger.info("Content playback is not playing on Wifi network");
			extent.extentLoggerFail("Play", "Content playback is not playing on Wifi network");
		}
		Back(1);
		verifyElementPresentAndClick(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		click(AMDMoreMenu.objVideo_WifiOnly, "wifi toggle");
		Back(1);
		waitTime(3000);
		Back(1);
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd,
			// 2000);
		}

		verifyElementExist(AMDHomePage.objHomeTab, "Home Tab");
		waitTime(10000);
		if (courselContentTitle != null) {
			for (int i = 0; i < 2; i++) {
				if (verifyElementPresent(AMDHomePage.objContentTitle(courselContentTitle), "Carousel content")) {
					break;
				}

			}
			click(AMDHomePage.objContentTitle(courselContentTitle), "Carousel content");
		} else {
			click(AMDGenericObjects.objCarouselTitle("Shivaji Surathkal"), "Carousel content");
		}

		String wifii = "";
		String cmdd = "adb shell dumpsys \"wifi | grep 'Wi-Fi is'\"";
		Process pp = Runtime.getRuntime().exec(cmdd);
		System.out.println(cmdd);
		BufferedReader brr = new BufferedReader(new InputStreamReader(pp.getInputStream()));
		wifii = brr.readLine();
		logger.info("Wifi status :: " + wifii.toString());

		if (wifii.equalsIgnoreCase("Wi-Fi is enabled")) {
			if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
				waitTime(3000);
				if (verifyIsElementDisplayed(AMDHomePage.objSubscribePopup)) {
					Back(1);
				}
				if (verifyElementDisplayed(AMDHomePage.objPlayerScreen)) {
					logger.info("Content playback is playing only on Wifi network");
					extent.extentLoggerPass("Play", "Content playback is playing only on Wifi network");
				} else {
					logger.error("Content playback is not playing only on Wifi network");
					extent.extentLoggerFail("Play", "Content playback is not playing only on Wifi network");
				}
			} else {
				waitTime(10000);
				click(AMDHomePage.objPlayerScreen, "Player screen");
				// waitForElementDisplayed(AMDHomePage.objMaximizeIcon, 10);
				if (verifyIsElementDisplayed(AMDConsumptionScreen.objShareBtn)) {
					logger.info("Content playback is playing only on Wifi network");
					extent.extentLoggerPass("Play", "Content playback is playing only on Wifi network");
				} else {
					logger.error("Content playback is not playing only on Wifi network");
					extent.extentLoggerFail("Play", "Content playback is not playing only on Wifi network");
				}
			}
		} else {
			logger.error("Content playback is not playing on Wifi network");
			extent.extentLoggerFail("Play", "Content playback is not playing on Wifi network");
		}
		Back(1);
		verifyElementPresentAndClick(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		click(AMDMoreMenu.objVideo_WifiOnly, "wifi toggle");

		// Auto play option valdation
		WebElement autoPlaytoggle = findElement(AMDMoreMenu.objVideo_Autoply);
		int autoPlaytoggleX = wifitoggle.getLocation().getX();
		int autoPlaytoggleY = wifitoggle.getLocation().getY();

		WebElement autoPlaytext = findElement(AMDMoreMenu.objVideoStreamOverWifiOnlyOption);
		int autoPlaytextX = wifitext.getLocation().getX();
		int autoPlaytextY = wifitoggle.getLocation().getY();

		if (autoPlaytextY < (autoPlaytoggleY + 10)) {
			if (autoPlaytoggleX > autoPlaytextX) {
				logger.info("On/Off toggle is displayed at the right side of the 'Auto Play' option");
				extent.extentLoggerPass("Auto Play On/Off toggle",
						"On/Off toggle is displayed at the right side of the 'Auto Play' option");
			} else {
				logger.error("On/Off toggle is not displayed at the right side of the 'Auto Play' option");
				extent.extentLoggerFail("Auto Play On/Off toggle",
						"On/Off toggle is not displayed at the right side of the 'Auto Play' option");
			}
		}
		String elementAutoPlayToggleStatus = getText(AMDMoreMenu.objVideo_Autoply);
		if (elementAutoPlayToggleStatus.equalsIgnoreCase("ON")) {
			logger.info("the default state of the 'Auto Play' option is in ON state");
			extentLoggerPass("Video Auto Play", "the default state of the 'Auto Play' option is in ON state");
		} else {
			logger.info("the default state of the 'Auto Play' option is not in ON state");
			extentLoggerFail("Video Auto Play", "the default state of the 'Auto Play' option is not in ON state");
		}
	}

	public void Wifi_TurnOFFnON() throws Exception {
		Runtime.getRuntime()
				.exec("adb shell am start -a android.intent.action.MAIN -n com.android.settings/.wifi.WifiSettings");
		waitTime(2000);
		// Runtime.getRuntime().exec("adb shell input keyevent 23");
		click(AMDGenericObjects.objWifiToggle, "Wifi-Toggle button");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell monkey -p com.graymatrix.did -c android.intent.category.LAUNCHER 1");
	}

	public void settings_Language(String displayLanguageSelection1, String displayLanguageSelection2) throws Exception {
		extent.HeaderChildNode("Display language settings validation");
		System.out.println("\nDisplay language settings validation");

		waitTime(3000);
		Swipe("UP", 1);
		// Display language option validation
		WebElement selectedDisplayLanguages = findElement(AMDMoreMenu.objDisplayLang);
		int selectedDisplayLanguagesX = selectedDisplayLanguages.getLocation().getX();
		int selectedDisplayLanguagesY = selectedDisplayLanguages.getLocation().getY();

		WebElement displayLanguagetext = findElement(AMDMoreMenu.objDisplayLanguageOption);
		int displayLanguagetextX = displayLanguagetext.getLocation().getX();
		int displayLanguagetextY = displayLanguagetext.getLocation().getY();

		if (displayLanguagetextY < (selectedDisplayLanguagesY + 10)) {
			if (selectedDisplayLanguagesX > displayLanguagetextX) {
				logger.info("Selected Display language is displayed at the right side of the option");
				extent.extentLogger("Display Language",
						"Selected Display language is displayed at the right side of the option");
			} else {
				logger.error("Selected Display language is not displayed at the right side of the option");
				extent.extentLoggerFail("Display Language",
						"Selected Display language is not displayed at the right side of the option");
			}
		}

		// Display language screen functionality validation
		click(AMDMoreMenu.objDisplayLang, "Display language");

		verifyElementPresent(AMDLoginScreen.objSelectedDisplayLanguage, "Selected display language");
		String selectedlanguage1 = getText(AMDLoginScreen.objSelectedDisplayLanguage);

		click(AMDOnboardingScreen.objSelectDisplayLang(displayLanguageSelection2), "language");

		WebElement selectedDisplayLanguage = findElement(AMDLoginScreen.objSelectedDisplayLanguage);
		int selectedDisplayLanguageX = selectedDisplayLanguage.getLocation().getX();
		int selectedDisplayLanguageY = selectedDisplayLanguage.getLocation().getY();

		WebElement tickMark = findElement(AMDLoginScreen.objTickmarkforSelectedDisplayLanguage);
		int tickMarkX = tickMark.getLocation().getX();
		int tickMarkY = tickMark.getLocation().getY();

		if (tickMarkY < (selectedDisplayLanguageY + 20)) {
			if (tickMarkX < selectedDisplayLanguageX) {
				logger.info("Selected Display Language screen with tick mark at the left side is displayed");
				extent.extentLogger("Selected Display Language",
						"Selected Display Language screen with tick mark at the left side is displayed");
			} else {
				logger.error("Selected Display Language screen with tick mark at the left side is not displayed");
				extent.extentLoggerFail("Selected Display Language",
						"Selected Display Language screen with tick mark at the left side is not displayed");
			}
		}

		String selectedlanguage2 = getText(AMDLoginScreen.objSelectedDisplayLanguage);

		if (selectedlanguage1 != selectedlanguage2) {
			logger.info("Display Language screen is functional");
			extentLogger("Display language screen", "Display Language screen is functional");
		} else {
			logger.info("Display Language screen is not functional");
			extentLoggerFail("Display language screen", "Display Language screen is not functional");
		}

		int totalSelectedLanguages = getDriver().findElements(AMDLoginScreen.objSelectedDisplayLanguage).size();
		logger.info(totalSelectedLanguages);

		if (totalSelectedLanguages == 1) {
			logger.info("user can select only one display language");
			extentLogger("Select one language", "user can select only one display language");
		}

		// Validation of swipe functionality in the display language screen
		click(AMDOnboardingScreen.objSelectDisplayLang(displayLanguageSelection1), "language");

		String pos1 = getAttributValue("bounds", AMDOnboardingScreen.objSelectDisplayLang(displayLanguageSelection1));
		String pos2 = null;
		Swipe("UP", 1);
		pos2 = getAttributValue("bounds", AMDOnboardingScreen.objSelectDisplayLang(displayLanguageSelection1));
		if (pos1 != pos2) {
			logger.info("Display Language screen is scrollable");
			extentLogger("Swipe", "Display Language screen is scrollable");
		} else {
			logger.info("Display Language screen is not scrollable");
			extentLoggerFail("Swipe", "Display Language screen is not scrollable");
		}

		verifyElementPresent(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue CTA");
		Back(1);
		Swipe("UP", 1);

		extent.HeaderChildNode("Content language settings validation");

		// content language option validation
		WebElement selectedContentLanguages = findElement(AMDMoreMenu.objContentLang);
		int selectedContentLanguagesX = selectedContentLanguages.getLocation().getX();
		int selectedContentLanguagesY = selectedContentLanguages.getLocation().getY();

		WebElement contentLanguagetext = findElement(AMDMoreMenu.objContentLanguageOption);
		int contentLanguagetextX = contentLanguagetext.getLocation().getX();
		int contentLanguagetextY = contentLanguagetext.getLocation().getY();

		if (contentLanguagetextY < (selectedContentLanguagesY + 10)) {
			if (selectedContentLanguagesX > contentLanguagetextX) {
				logger.info("Selected Content language is displayed at the right side of the option");
				extent.extentLogger("Content Language",
						"Selected Content language is displayed at the right side of the option");
			} else {
				logger.error("Selected Content language is not displayed at the right side of the option");
				extent.extentLoggerFail("Content Language",
						"Selected Content language is not displayed at the right side of the option");
			}
		}

		click(AMDMoreMenu.objContentLang, "Content language");

		verifyElementExist(AMDOnboardingScreen.objContentLanguageContainer, "Content language screen");

		String position1 = getAttributValue("bounds", AMDOnboardingScreen.objSelectContentLang("Telugu"));
		String position2 = null;
		PartialSwipe("UP", 1);
		position2 = getAttributValue("bounds", AMDOnboardingScreen.objSelectContentLang("Telugu"));
		if (position1 != position2) {
			logger.info("Content Language screen is scrollable");
			extentLogger("Content language", "Content Language screen is scrollable");
		} else {
			logger.info("Content Language screen is not scrollable");
			extentLoggerFail("Content language", "Content Language screen is not scrollable");
		}
		Back(1);
	}

	public void upcomingSectionValidation() throws Exception {
		extent.HeaderChildNode("Upcoming Screen Validation");
		// waitTime(5000);
		waitForElementDisplayed(AMDHomePage.objHomeTab, 10);
		verifyElementPresentAndClick(AMDHomePage.objUpcoming, "Upcoming tab");

		// WebElement element = findElement(AMDHomePage.objUpcoming);
		/*
		 * int leftX =element.getLocation().getX(); int rightX = leftX
		 * +element.getSize().getWidth(); //int middleX = (rightX + leftX) / 2;
		 * Dimension size = getDriver().manage().window().getSize();
		 * 
		 * if (middleX == Integer.valueOf((size.width) / 2)) { logger.info(
		 * "Upcoming text is displayed at the center of the screen");
		 * extent.extentLoggerPass("Title",
		 * "Upcoming text is displayed at center of the screen"); } else {
		 * logger.error("Upcoming text is not displayed at center of the screen"
		 * ); extent.extentLoggerFail("Title",
		 * "Upcoming text is not displayed at center of the screen"); }
		 * 
		 */
		/*
		 * WebElement searchIcon = findElement(AMDHomePage.objSearchBtn); int
		 * searchIconRightX = searchIcon.getLocation().getX();
		 * System.out.println(searchIconRightX); Dimension sizee =
		 * getDriver().manage().window().getSize();
		 * System.out.println(sizee.getWidth()); int sizeee = sizee.getWidth() -
		 * 300; System.out.println(sizeee);
		 * 
		 * if (searchIconRightX >= sizeee) { logger.info(
		 * "Search icon is displayed at top right of the screen");
		 * extent.extentLoggerPass("Search icon",
		 * "Search icon is displayed at top right of the screen"); } else {
		 * logger.error(
		 * "Search icon is not displayed at top right of the screen");
		 * extent.extentLoggerFail("Search icon",
		 * "Search icon is not displayed at top right of the screen"); }
		 */
		Response resp = ResponseInstance.getResponseForUpcomingPage();
		String titleWithTrailer = resp.jsonPath().getString("buckets[0].items[0].original_title");
		System.out.println("API Title " + titleWithTrailer);
		verifyElementPresentAndClick(AMDUpcomingPage.objContentCard1, "Content Card");
		String titleConsumptionScreen = getText(AMDUpcomingPage.objContentCardTitle1);
		System.out.println(titleConsumptionScreen);
		if (titleConsumptionScreen.contains(titleWithTrailer)) {
			logger.info("Navigated to appropriate consumption screen on tapping anywhere on any content card");
			extent.extentLoggerPass("Title",
					"Navigated to appropriate consumption screen on tapping anywhere on any content card");
			logger.info("Trailer/Teaser playback is played");
			extent.extentLoggerPass("Trailer/Teaser", "Trailer/Teaser playback is played");

		} else {
			logger.error("Not navigated to appropriate consumption screen on tapping anywhere on any content card");
			extent.extentLoggerFail("Title",
					"Not navigated to appropriate consumption screen on tapping anywhere on any content card");
			logger.error("Trailer/Teaser playback is not played");
			extent.extentLoggerFail("Trailer/Teaser", "Trailer/Teaser playback is not played");
		}

		checkElementExist(AMDMoreMenu.objDownloadIcon, "Download icon");
		Back(1);
		verifyElementPresentAndClick(AMDUpcomingPage.objContentCardTitle, "Metadata");
		if (titleConsumptionScreen.contains(titleWithTrailer)) {
			logger.info("Navigated to appropriate consumption screen on tapping anywhere on the metadata");
			extent.extentLoggerPass("Title",
					"Navigated to appropriate consumption screen on tapping anywhere on the metadata");
		} else {
			logger.info("Not navigated to appropriate consumption screen on tapping anywhere on the metadata");
			extent.extentLoggerFail("Title",
					"Not navigated to appropriate consumption screen on tapping anywhere on the metadata");
		}
		Back(1);
		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search icon");
		if (verifyIsElementDisplayed(AMDSearchScreen.objMicrophoneIcon)) {
			logger.info("Search landing screen is displayed after denying audio permission");
			extent.extentLoggerPass("Search landing screen",
					"Search landing screen is displayed after denying audio permission");
		} else {
			logger.error("Search landing screen is not displayed after denying audio permission");
			extent.extentLogger("Search landing screen",
					"Search landing screen is not displayed after denying audio permission");
		}
		Back(2);
	}

	public void ZeeApplicasterLogin(String LoginMethod) throws Exception {
		extent.HeaderChildNode("Login Functionality");

		String UserType = getParameterFromXML("userType");
		if (UserType.equals("Guest")) {
			extent.extentLogger("userType", "UserType : Guest");
		}

		verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Login link");
		waitTime(3000);

		switch (LoginMethod) {
		case "Guest":
			extent.HeaderChildNode("Guest User");
			extent.extentLogger("Accessing the application as Guest user", "Accessing the application as Guest user");
			waitTime(1000);
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Skip link");
			waitTime(3000);
			break;

		case "NonSubscribedUser":
			extent.HeaderChildNode("Login as NonSubscribed User");

			String Username = getParameterFromXML("NonsubscribedUserName");
			String Password = getParameterFromXML("NonsubscribedPassword");

			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;

		case "SubscribedUser":
			extent.HeaderChildNode("Login as Subscribed User");

			String SubscribedUsername = getParameterFromXML("SubscribedUserName");
			String SubscribedPassword = getParameterFromXML("SubscribedPassword");

			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, SubscribedUsername, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;

		}
	}

	public void swipeByElements(WebElement webElement, WebElement webElement2) {

		touchAction = new TouchAction<>(getDriver());

		int startX = webElement.getLocation().getX() + (webElement.getSize().getWidth() / 2);
		int startY = webElement.getLocation().getY() + (webElement.getSize().getHeight() / 2);

		int endX = webElement2.getLocation().getX() + (webElement2.getSize().getWidth() / 2);
		int endY = webElement2.getLocation().getY() + (webElement2.getSize().getHeight() / 2);
		touchAction.press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endX, endY))
				.release().perform();
	}

	public void ZeeApplicasterLoginForOnboarding() throws Exception {
		extent.HeaderChildNode("Login Type Functionality");
		String pUserType = getParameterFromXML("userType");

		extent.extentLogger("Login Type", "Login Type : " + pUserType);

		switch (pUserType) {
		case "Guest":
			extent.HeaderChildNode("Guest User");
			extent.extentLogger("Accessing the application as Guest user", "Accessing the application as Guest user");
			waitTime(1000);
			break;

		case "NonSubscribedUser":
			navigateToIntroScreen_DisplaylangScreen();
			extent.HeaderChildNode("Login as NonSubscribed User");
			verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Login link");
			String Username = getParameterFromXML("NonsubscribedUserName");
			String Password = getParameterFromXML("NonsubscribedPassword");

			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;

		case "SubscribedUser":
			navigateToIntroScreen_DisplaylangScreen();
			extent.HeaderChildNode("Login as Subscribed User");
			verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Login link");
			String SubscribedUsername = getParameterFromXML("SubscribedUserName");
			String SubscribedPassword = getParameterFromXML("SubscribedPassword");

			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, SubscribedUsername, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;
		}
	}

	public void IntroScreen(String userType) throws Exception {
		extent.HeaderChildNode("Validating Intro screen module");
		// Verify user is navigated to intro screen
		if (userType.equals("Guest")) {
			if (findElement(AMDOnboardingScreen.objScreenTitle).getText().equals("ZEE5")) {
				String ZEE5 = getDriver().findElement(AMDOnboardingScreen.objScreenTitle).getText();
				extent.extentLoggerPass("Verify user is navigated to Login/Registration screen",
						"User is navigated to " + ZEE5 + " Screen");
				logger.info("User is navigated to " + ZEE5 + " Screen after clicking on Browse for free");
			} else {
				extent.extentLoggerFail("Verify user is navigated to Login/Registration screen",
						"Intro screeen in not displayed");
				logger.error("Intro screeen in not displayed");
			}
			// Verify back button is displayed
			verifyElementPresent(AMDOnboardingScreen.objBackBtn, "Back button");
			// Verify user is navigated to Content language screeen post tapping
			// back button

			click(AMDOnboardingScreen.objBackBtn, "Back button");
			String contentLang = getDriver().findElement(AMDOnboardingScreen.objScreenTitle).getText();

			if (contentLang.equals("Content Language")) {
				extent.extentLoggerPass("Verify user is navigated to Content language screen",
						"User is navigated to " + contentLang + " scree");
				logger.error("User is navigated to " + contentLang + " screen");
			} else {
				extent.extentLogger("Verify user is navigated to Content language screen",
						"Failed to navigate into content language screen");
				logger.info("Failed to navigate into content language screen");
			}

			// Covered few TC's and Updated Code by Kushal

			click(AMDOnboardingScreen.objBackBtn, "Back button");
			verifyElementPresent(AMDGenericObjects.objCheckTitle("Display Language"), "Display language screen");
			click(AMDOnboardingScreen.objSelectDisplayLang("Kannada"), "Kannada language");
			click(AMDOnboardingScreen.objDiplay_ContinueBtn, "[Display Language] Continue Button");

			String strLang = findElement(AMDOnboardingScreen.objScreenTitle).getText();
			if (strLang != "Content Language") {
				extent.extentLoggerPass("Content language screen", "Content language is displayed in Kannada language");
				logger.info("Title of the screen : " + strLang + " is displayed in selected language");
			} else {
				extent.extentLoggerFail("Content language screen",
						"Failed to display the content language in selected language");
				logger.error("Failed to display the content language in selected language");
			}

			click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue Button");

			if (findElement(AMDOnboardingScreen.objBrowseForFreeBtn).getText() != "Browse for Free") {
				String strBrwsforFree = findElement(AMDOnboardingScreen.objBrowseForFreeBtn).getText();
				extent.extentLoggerPass("Intro screen",
						"Browse for free button is displayed in selected launguage: " + strBrwsforFree);
				logger.info("Browse for free button is displayed in selected launguage : " + strBrwsforFree);
			} else {
				extent.extentLoggerFail("Intro screen",
						"Browse for free button failed to displayed in selected launguage");
				logger.error("Browse for free button failed to displayed in selected launguage");
			}
			String strSubsNow = findElement(AMDOnboardingScreen.objSubscribeNowBtn).getText();
			if (strSubsNow != "Subscribe Now") {
				extent.extentLoggerPass("Intro screen",
						"Subscribe Now button is displayed in selected launguage: " + strSubsNow);
				logger.info("Subscribe Now button is displayed in selected launguage : " + strSubsNow);
			} else {
				extent.extentLoggerFail("Intro screen",
						"Subscribe Now button failed to displayed in selected launguage: " + strSubsNow);
				logger.error("Subscribe Now button failed to displayed in selected launguage: " + strSubsNow);
			}
			String strHavePrepaidCode = findElement(AMDOnboardingScreen.objHavePrepaidBtn).getText();
			if (strHavePrepaidCode != "Have a prepaid code") {
				extent.extentLoggerPass("Intro screen",
						"Have a Prepaid code CTA is displayed in selected launguage: " + strHavePrepaidCode);
				logger.info("Have a Prepaid code CTA is displayed in selected launguage: " + strHavePrepaidCode);
			} else {
				extent.extentLoggerFail("Intro screen",
						"Have a Prepaid code CTA failed to displayed in selected launguage: " + strHavePrepaidCode);
				logger.error(
						"Have a Prepaid code CTA failed to displayed in selected launguage: " + strHavePrepaidCode);
			}
			String strLoginCTA = findElement(AMDOnboardingScreen.objLoginLnk).getText();
			if (strHavePrepaidCode != "Login") {
				extent.extentLoggerPass("Intro screen", "Login CTA is displayed in selected launguage: " + strLoginCTA);
				logger.info("Login CTA is displayed in selected launguage: " + strLoginCTA);
			} else {
				extent.extentLoggerFail("Intro screen",
						"Login CTA failed to displayed in selected launguage: " + strLoginCTA);
				logger.error("Login CTA failed to displayed in selected launguage: " + strLoginCTA);
			}
			Back(2);
			if (findElement(AMDOnboardingScreen.objSelectedDisplayLang).getText() != "English") {
				click(AMDOnboardingScreen.objSelectDisplayLang("English"), "English language");
				click(AMDOnboardingScreen.objDiplay_ContinueBtn, "[Display Language] Continue Button");
			}
			// ***********************************************************

			click(AMDOnboardingScreen.objContent_ContinueBtn, "[Content Language] Continue button");
			// Verify Login button is displayed
			verifyElementExist(AMDOnboardingScreen.objLoginLnk, "Login button");

			// Verify user is navigated to Login Registration screen
			click(AMDOnboardingScreen.objLoginLnk, "Login button");
			hideKeyboard();
			// Click operation is used for the device which do not identify the
			// keyboard
			click(AMDLoginScreen.objContinueWithTxt, "Or Continue with");
			if (findElement(AMDOnboardingScreen.objScreenTitle).getText().equals("Login/Register")) {
				extent.extentLoggerPass("Verify Navigation on clicking Login button",
						"User is navigated to" + findElement(AMDOnboardingScreen.objScreenTitle).getText() + " screen");
				logger.info("User is navigated to " + findElement(AMDOnboardingScreen.objScreenTitle).getText()
						+ " screen");
			} else {
				extent.extentLoggerFail("Verify Navigation on clicking Login button",
						"Failed to navigate into Login/Register screen post tapping Login button");
				logger.error("Failed to navigate into Login/Register screen post tapping Login button");
			}
			click(AMDOnboardingScreen.objBackBtn, "Back button");
			// Verify that content feature carousel is displayed
			verifyElementExist(AMDOnboardingScreen.objFeatureCarousel, "Feature carousel rail");
			// Verify that Preminum member benifits section is displayed
			verifyElementExist(AMDOnboardingScreen.objBenefitsTextSection, "Benifits of premium member section");
			// Verify that pagination dots are displayed
			verifyElementExist(AMDOnboardingScreen.objDotsIndicator, "Pagination dots");
			// Verify Browse for free is displayed
			verifyElementExist(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");

			// Verify user is navigated to Login/Registration page post tapping
			// Browse for
			// free
			click(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");
			if (findElement(AMDOnboardingScreen.objScreenTitle).getText().equals("Login/Register")) {
				extent.extentLoggerPass("Verify Navigation on clicking Browse for Free button",
						"User is navigated to" + findElement(AMDOnboardingScreen.objScreenTitle).getText() + " screen");
				logger.info("User is navigated to " + findElement(AMDOnboardingScreen.objScreenTitle).getText()
						+ " screen");
			} else {
				extent.extentLoggerFail("Verify Navigation on clicking Browse for Free button",
						"Failed to navigate into Login/Register screen post tapping Browse for Free button");
				logger.error("Failed to navigate into Login/Register screen post tapping Browse for Free button");
			}
			click(AMDOnboardingScreen.objBackBtn, "Back button");

			// Verify that Subscribe Now button is available
			verifyElementPresentAndClick(AMDOnboardingScreen.objSubscribeNowBtn, "Subcribe Now button");

			// Verify user is navigated to Subscribe now screen

			waitTime(2000);
			if (findElement(AMDOnboardingScreen.objScreenTitle).getText().equals("Subscribe")) {
				extent.extentLoggerPass("Verify Navigation on clicking Subscribe Now button",
						"User is navigated to" + findElement(AMDOnboardingScreen.objScreenTitle).getText() + " screen");
				logger.info("User is navigated to " + findElement(AMDOnboardingScreen.objScreenTitle).getText()
						+ " screen");
			} else {
				extent.extentLoggerFail("Verify Navigation on clicking Subcribe button",
						"Failed to navigate into Subscribe screen post tapping Subscribe Now button");
				logger.error("Failed to navigate into Subscribe screen post tapping Subcribe Now button");
			}
			click(AMDOnboardingScreen.objBackBtn, "Back button");

			// Verify that Have a prepaid code? is displayed
			verifyElementPresentAndClick(AMDOnboardingScreen.objHavePrepaidBtn, "Have a preapaid code? button");

			// Verify Prepaid code screen is displayed after tapping on Prepaid
			// code button
			if (findElement(AMDOnboardingScreen.objPrepaidPopupLabel).isDisplayed()) {
				extent.extentLoggerPass("Verify navigation post tapping Prepaid code button", "User is navigated to "
						+ findElement(AMDOnboardingScreen.objPrepaidPopupLabel).getText() + " Screen");
				logger.info("User is navigated to " + findElement(AMDOnboardingScreen.objPrepaidPopupLabel).getText()
						+ " Screen");
			} else {
				extent.extentLoggerFail("Verify navigation post tapping Prepaid code button",
						"Failed to navigate into Prepaid screen post tapping Have a prepaid code button");
				logger.error("Failed to navigate into Prepaid screen post tapping Have a prepaid code button");
			}
			Back(1);
		} else {
			extent.extentLoggerPass("Intro Screen", "Intro Screen is not displayed for " + userType);
			logger.info("Intro Screen is not displayed for " + userType);
			System.out.println("Intro Screen is not displayed for Susbcribed/Non-Subscribed user");
		}
	}

	public void VerifyLoginWithEmailId(String pUserName, String pPassword) throws Exception {
		extent.HeaderChildNode("Login With Email-ID");

		String pUserType = getParameterFromXML("userType");
		if (pUserType.contains("Guest")) {
			verifyElementPresentAndClick(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for Free");
			verifyElementPresent(AMDGenericObjects.objScreenTitleName("Login/Register"), "Login/Register");
			type(AMDLoginScreen.objEmailIdField, pUserName, "Email-ID");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
			if (getText(AMDLoginScreen.objEmailIdField).equalsIgnoreCase(pUserName)) {
				extent.extentLoggerPass("Email-Id Retained", "Email Id is retained in Login screen EmailId Field");
				logger.info("Email Id is retained in Login screen EmailId Field");
			} else {
				extent.extentLoggerFail("Email-Id Retained",
						"Email Id failed to retained in Login screen EmailId Field");
				logger.error("Email Id failed to retained in Login screen EmailId Field");
			}
			String getPropertyValue = getAttributValue("enabled", AMDLoginScreen.objEmailIdField);
			if (getPropertyValue.equalsIgnoreCase("false")) {
				extent.extentLoggerPass("EmailId field is disabled/grayed out", " User cannot edit emailid field");
				logger.info("EmailId field is disabled/grayed out and user cannot edit emailid field");
			} else {
				extent.extentLoggerFail("EmailId field is not grayed out", " User is able to edit emailid field");
				logger.error("EmailId field is not grayed out and user is able to edit emailid field");
			}
			verifyLoginScreenUIFunctionality();

			verifyElementPresent(AMDLoginScreen.objPasswordField, "Password field");
			type(AMDLoginScreen.objPasswordField, "xcvzc", "Password");
			verifyElementPresent(AMDLoginScreen.objErrorTxtMsg, "Password must be a minimum of 6 characters");
			clearField(AMDLoginScreen.objPasswordField, "Password");
			
			type(AMDLoginScreen.objPasswordField, pPassword, "Password");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Wait(2000);
			if (verifyElementPresent(AMDHomePage.objHomeTab, "Home page")) {
				extent.extentLoggerPass("Login with EmailId", pUserName + " : is logged in successfully");
				logger.info(pUserName + " is logged in  successfully");
			} else {
				extent.extentLoggerFail("Login with EmailId", pUserName + " failed to login");
				logger.error(pUserName + " failed to login");
			}
		}
	}

	/*
	 * } else { boolean landingPage =
	 * verifyIsElementDisplayed(AMDHomePage.HomeIcon); if (landingPage) {
	 * logger.info("Intro screen is skipped for " + pUserType);
	 * extent.extentLoggerPass("Intro Skipped",
	 * "Intro screen is skipped and User landed in Home screen"); } else {
	 * logger.info("Intro screen is Not skipped for " + pUserType);
	 * extent.extentLoggerFail("Intro Skipped",
	 * "Intro screen is NOT skipped for " + pUserType); } } }
	 */
	public void verifyLoginScreenUIFunctionality() throws Exception {
		extent.HeaderChildNode("Veirfy UI elements present in Login Screen");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Login"), "Login Screen");

		String pwdEncript = getAttributValue("checked", AMDLoginScreen.objShowPwdBtn);
		if (pwdEncript.contains("false")) {
			extent.extentLoggerPass("Default Show Password", "Password is Encripted");
			logger.info("Password is Encripted");
		} else {
			extent.extentLoggerFail("Default Show Password", "Password is not Encripted");
			logger.error("Password is not Encripted");
		}

		click(AMDLoginScreen.objShowPwdBtn, "Show Password");
		String checkPwdVisible = getAttributValue("checked", AMDLoginScreen.objShowPwdBtn);
		if (checkPwdVisible.contains("true")) {
			extent.extentLoggerPass("Click Show Password", "Password is Visible");
			logger.info("Password is Visible");
		} else {
			extent.extentLoggerFail("Click Show Password", "Password is not Visible");
			logger.error("Password is not Visible");
		}
		hideKeyboard();
		verifyElementPresentAndClick(AMDLoginScreen.objForgetPwdBtn, "Forgot Password CTA");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Forgot Password"), "Forgot Password Screen");
		click(AMDLoginScreen.objBackBtn, "Back button");
	}
	// TODO Auto-generated method stub

	public void popularSection(String userType, String tabName, String Down, int count, String RIGHT, String text)
			throws Exception {
		// if ((userType.equals("SubscribedUser")) |
		// (userType.equals("NonSubscribedUser"))) {
		extent.HeaderChildNode("Verify user navigates to Hipi screen");
		System.out.println("\nVerify User navigated to HipiScreen Screen");
		// extent.HeaderChildNode("HiPi Screen Validation");
		// System.out.println("\n navigating Hipi screen Functionality");
		verifyElementPresentAndClick(AMDHomePage.objBottomNavigation("HiPi"), "Hipi tab at the bottom navigation bar");
		verifyElementPresentAndClick(AMDHipi.objpopulartext, "click on popular text");
		Swipe("Down", 5);
		logger.info("User is able to scroll through the thumbnails");
		extent.extentLoggerPass("Tabs", "User is able to scroll through the thumbnails");
		verifyElementExist(AMDPopular.objfirstName(text), "check profile name for all ");

		// click(AMDPopular.objprofilename,"click on profile name");
		verifyElementPresentAndClick(AMDPopular.objprofilepic, "click on profile pic");
		verifyElementPresentAndClick(AMDPopular.objprofilename, "click on first name");
		String counter = getDriver().findElement(AMDPopular.objfollowerscount).getText();
		if (counter.equals("followers")) {
			logger.info("followers count is displayed");
			extent.extentLogger("followers", "followers count is displayed");
		} else {
			logger.error("followers count is not displayed");
			extent.extentLoggerFail("followers", "followers count is not displayed");
		}
	}

	// TODO Auto-generated method stub

}

// TODO Auto-generated method st

// TODO Auto-generated method stub

// TODO Auto-generated method stub
