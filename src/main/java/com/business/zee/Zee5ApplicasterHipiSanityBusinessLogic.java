package com.business.zee;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.deviceDetails.DeviceDetails;
import com.driverInstance.DriverInstance;
import com.emailReport.GmailInbox;
import com.extent.ExtentReporter;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;
import com.zee5.AndroidHipiPages.HipiAddMusicPage;
import com.zee5.AndroidHipiPages.HipiCreateVideoPage;
import com.zee5.AndroidHipiPages.HipiDiscoverPage;
import com.zee5.AndroidHipiPages.HipiEffectPage;
import com.zee5.AndroidHipiPages.HipiFeedPage;
import com.zee5.AndroidHipiPages.HipiHashtagDetailPage;
import com.zee5.AndroidHipiPages.HipiMePage;
import com.zee5.AndroidHipiPages.HipiNotificationPage;
import com.zee5.AndroidHipiPages.HipiOtherProfileScreen;
import com.zee5.AndroidHipiPages.HipiPopularPage;
import com.zee5.AndroidHipiPages.HipiReportProfileScreen;
import com.zee5.AndroidHipiPages.HipiSettingsPage;
import com.zee5.AndroidHipiPages.HipiShareScreen;
import com.zee5.AndroidHipiPages.HipiSoundDetailPage;
import com.zee5.Applicaster.HIPI.AMDFeed;
import com.zee5.Applicaster.HIPI.AMDHipi;
import com.zee5.Applicaster.HIPI.AMDHomePage;
import com.zee5.Applicaster.HIPI.AMDLoginScreen;
import com.zee5.Applicaster.HIPI.AMDOnboardingScreen;
import com.zee5.Applicaster.HIPI.AMDPlayerScreen;
import com.zee5.Applicaster.HIPI.HipiHomePage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Zee5ApplicasterHipiSanityBusinessLogic extends Utilities {

	public Zee5ApplicasterHipiSanityBusinessLogic(String Application) {
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

	String profileID = null;
	String profileText = null;
	
	String ProfileFirstName = null;
	String ProfileLastName = null;
	String DefinedHandleName=null;
	
	String NotificationUsername= null;
	String NotificationPassword;
	
	String effectName =null;
	int CommentTitleCount1;
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
				Thread.sleep(10000);
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
			
			
			//*[@text='WHILE USING THE APP']

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
			// System.out.println(str1);
			// System.out.println(str2);

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
//		System.out.println("HiPi_Guest_003");
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
		if (verifyIsElementDisplayed(AMDOnboardingScreen.objContentLanguagePageTitle, "Content Language Page")) {
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
		if (userType.equalsIgnoreCase("Guest")) {

			extent.HeaderChildNode("BrowseForFree");
			Thread.sleep(10000);
			if (verifyElementExist(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free")) {

				verifyElementExist(AMDOnboardingScreen.objFeatureCarousel, "Feature carousel rail");

				// Verify that Preminum member benifits section is displayed
				verifyElementExist(AMDOnboardingScreen.objBenefitsTextSection, "Benifits of premium member section");

				// Verify that pagination dots are displayed
				verifyElementExist(AMDOnboardingScreen.objDotsIndicator, "Pagination dots");

				// Verify Browse for free is displayed
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
			if (verifyElementExist(AMDOnboardingScreen.objSubscribeNowBtn, "Subcribe Now button")) {

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
			waitTime(1000);
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

	
	public void separateLogin(String userType)throws Exception{
		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
			LoginUsingAccountCredentials(getParameterFromXML("NonsubscribedUserName1"), getParameterFromXML("NonsubscribedPassword1"));
		}else if(userType.equalsIgnoreCase("SubscribedUser")) {
			LoginUsingAccountCredentials(getParameterFromXML("SubscribedUserName1"), getParameterFromXML("SubscribedPassword1"));
		}else {
			extent.extentLogger("", "Guest User");
			System.out.println("Guest User");
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

	// ------------------------------------------------------------------------------------------------------------

	
	
	
	
	// ------------------------------------------Himadri-SaveAsDraft-----------------------------------------------


	
	public void longPress(By element) throws Exception {
		AndroidTouchAction touch = new AndroidTouchAction(getDriver());
		touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(findElement(element))))
				.release().perform();
	}
	
	
	
	
	public void ValidatingSaveAsDraft(String userType) throws Exception{
		if(userType.equalsIgnoreCase("NonSubscribedUser")){
			LayoutPostingScreen(userType);
			RedirectedtoEditVideoScreen(userType);
			UnpublishVideo(userType);
			TemsandConditionCheckboxClickedtoSaveorPostVideo(userType);
			VideoSavedasDraft(userType);
			CancelVideoUpload(userType);
			ExitVideoUpload(userType);
		}else{
			
		}
	}
	
	
	
	public void LayoutPostingScreen(String userType) throws Exception
	{
		extent.HeaderChildNode("Layout of video post page");
		System.out.println("TC_Mobile_001");
		extent.extentLogger("", "TC_Mobile_001");
		verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
		Thread.sleep(5000);
		click(HipiFeedPage.objCreateVideoIcon, "Create video button");
		Thread.sleep(5000);
		if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo, "Allow ZEE5 to take pictures and record video?"))
		{
			logger.info("Permission dialog:"+ "Allow ZEE5 to take pictures and record video?");
			verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow");
			click(HipiCreateVideoPage.objCreateAllow, "Allow button");
			logger.info("Allow ZEE5 to take pictures and record video-"+ "Allow button");
			Thread.sleep(5000);
			
			logger.info("Permission dialog:"+ "Allow ZEE5 to access photos, media, and files on your device");
			verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to access photos, media, and files on your device?");		
			click(HipiCreateVideoPage.objCreateAllow, "Allow button");
			logger.info("Allow ZEE5 to access photos, media, and files on your device-"+ "Allow button");
			Thread.sleep(5000);
			
			logger.info("Permission dialog:"+ "Allow ZEE5 to record audio");
			verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?");
			click(HipiCreateVideoPage.objCreateAllow, "Allow button");	
			logger.info("Allow ZEE5 to record audio-"+ "Allow button");
			//Thread.sleep(40000);
			waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
			verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
			click(HipiCreateVideoPage.objCreateReadyYes, "yes button");	
			logger.info("Ready dialog displayed:"+ "yes button");
			Thread.sleep(10000);
		}
		logger.info("Create video page:"+ "Create video page displayed");
		verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record start button of video available");
		Thread.sleep(30000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "Post button");
		logger.info("Create video page:"+ "Post button clicked");
		Thread.sleep(20000);
		logger.info("PostHipiT Page:"+ "Video upload page displayed");
		waitForElementDisplayed(HipiCreateVideoPage.objPostHipiTPageHeader, 20);
		verifyElementPresent(HipiCreateVideoPage.objPostHipiTPageHeader, "PostHipiT");
		verifyElementPresent(HipiCreateVideoPage.objBack, "Back button");
		verifyElementPresent(HipiCreateVideoPage.objadddescription, "Add description field");
		verifyElementPresent(HipiCreateVideoPage.objadddescriptionlimit, "Limit 200 words for add description field");
		verifyElementPresent(HipiCreateVideoPage.objcoverphotorecordedvideo, "Video Preview");
		Thread.sleep(5000);
		logger.info("PostHipiT Page:"+ "PostHipiT as page header,back button,add description field,video preview are displayed");
		verifyElementPresent(HipiCreateVideoPage.objlanguageofyourvideolabel, "Select language of video label");
		verifyElementPresent(HipiCreateVideoPage.objenglish, "English language");
		verifyElementPresent(HipiCreateVideoPage.objhindi, "Hindi language");
		verifyElementPresent(HipiCreateVideoPage.objreligional, "Religional language");
		verifyElementPresent(HipiCreateVideoPage.objmore, "More button");
		logger.info("PostHipiT Page:"+ "Language for video are displayed");
		verifyElementPresent(HipiCreateVideoPage.objadjustsettingslabel, "Adjust settings label");
		click(HipiCreateVideoPage.objvisibilitymodebutton,"Visibility button");
		logger.info("PostHipiT Page:"+ "Visibility button clicked");
		Thread.sleep(5000);
		verifyElementPresent(HipiCreateVideoPage.objvisibilitymodepublicbutton, "Public");
		verifyElementPresent(HipiCreateVideoPage.objvisibilitymodefolloweronlybutton, "Followers-Only");
		verifyElementPresent(HipiCreateVideoPage.objvisibilitymodemebutton, "Me");
		logger.info("PostHipiT Page visibility:"+ "Public,Followers-Only and Me displayed");
		Back(1);
		Thread.sleep(5000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objadvancedsettingsbutton, "Advanced settings");
		verifyElementPresent(HipiCreateVideoPage.objallowcommentsenabledbar, "Allow comments bar enabled");
		verifyElementPresent(HipiCreateVideoPage.objallowlikedislikeenabledbar, "Allow like/dislike bar enabled");
		verifyElementPresent(HipiCreateVideoPage.objallowsharingenabledbar, "Allow sharing bar enabled");
		verifyElementPresent(HipiCreateVideoPage.objallowvideodownloadenabledbar, "Allow video download bar enabled");
		logger.info("PostHipiT Page advanced settings:"+ "Comment,like/dislike,share and video download bar are enabled");
		click(HipiCreateVideoPage.objadvancedsettingsbutton, "Advanced settings clicked closed");
		Thread.sleep(5000);
		verifyElementPresent(HipiCreateVideoPage.objtermsandconditionslabel, "Terms and conditions label");
		verifyElementPresent(HipiCreateVideoPage.objtcheckbox, "Terms and conditions checkbox");
		verifyElementPresentAndClick(HipiCreateVideoPage.objtermsandconditionslink, "tems and conditions link");
		Thread.sleep(5000);
		verifyElementPresent(HipiCreateVideoPage.objtermsandconditionspage, "Terms and conditions page");
		Back(1);
		Thread.sleep(5000);
		verifyElementPresent(HipiCreateVideoPage.objsaveasdraft, "Save as draft button");
		verifyElementPresent(HipiCreateVideoPage.objpostbtn, "Post hipit button");
	}
	public void RedirectedtoEditVideoScreen(String userType) throws Exception
	{
		extent.HeaderChildNode("Redirected to edit video screen");
		System.out.println("TC_Mobile_002");		extent.extentLogger("", "TC_Mobile_002");
		click(HipiCreateVideoPage.objBack, "Back button");
		Thread.sleep(5000);
		verifyElementPresent(HipiCreateVideoPage.objcontinueshootdialog, "Continue dialog");
		Thread.sleep(5000);
		verifyElementPresent(HipiCreateVideoPage.objcancelbtn, "Cancel button");
		Thread.sleep(5000);
		verifyElementPresent(HipiCreateVideoPage.objcontinuebtn, "Continue button");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objcontinuebtn, "Continue button dialog");
		Thread.sleep(5000);
		if(verifyElementExist(HipiCreateVideoPage.objaddmusicbtneditvideopage, "add music button")) 
		{
			logger.info("Edit video screen:"+ "Edit video page displayed when back button clicked");
			extent.extentLoggerPass("Edit video screen:","Edit video page displayed when back button clicked");
		}
		else
		{
			logger.info("Hipi feed screen:"+ "Edit video page not displayed when back button clicked");
			extent.extentLoggerFail("Hipi feed screen:","Edit video page not displayed when back button clicked");
		}
	}
	public void UnpublishVideo(String userType) throws Exception
	{
		extent.HeaderChildNode("Video can be unpublished under profile screen");
		System.out.println("TC_Mobile_003");		extent.extentLogger("", "TC_Mobile_003");
		verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "Post button");
		Thread.sleep(10000);
		click(HipiCreateVideoPage.objadddescription, "Added description field");
		type(HipiCreateVideoPage.objadddescription,"Desc"+GeneratingRandomString(7),"Description added");
		Thread.sleep(5000);
		hideKeyboard();
		Thread.sleep(5000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "Genre button");
		verifyElementPresentAndClick(HipiCreateVideoPage.objlanguageclickedenglish, "English button");
		Thread.sleep(10000);
		click(HipiCreateVideoPage.objtcheckbox, "Terms and conditions checkbox");
		Thread.sleep(5000);
		if(verifyElementExist(HipiCreateVideoPage.objuploadpost, "Post hipi button")) 
		{
			click(HipiCreateVideoPage.objuploadpost, "Post hipi button");
			Thread.sleep(10000);
			verifyElementExist(HipiCreateVideoPage.objsuccess, "Video uploaded dialog");
			verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Ok button");
			Thread.sleep(30000);//added
			verifyElementPresentAndClick(HipiCreateVideoPage.objMe, "Me button");
			Thread.sleep(10000);//added
			Back(1);//added
			Thread.sleep(5000);//added
			click(HipiCreateVideoPage.objMe, "Me button");//added
			Thread.sleep(10000);//added
			verifyElementExist(HipiCreateVideoPage.objpublishprogressvideo, "Video publishing in progress dialog");
			longPress(HipiCreateVideoPage.objlongpress);
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objunpublish, "Unpublish button");
			Thread.sleep(5000);
			verifyElementExist(HipiCreateVideoPage.objunpublishdialog, "Do you want to unpublish your video ? dialog");
			verifyElementExist(HipiCreateVideoPage.objunpublishdialogyes, "yes button");
			click(HipiCreateVideoPage.objunpublishdialogyes, "yes button");
			Thread.sleep(5000);
			
			if(verifyElementExist(HipiCreateVideoPage.objunpublisheddonedialog, "Video Successfully Unpublished dialog")){
				click(HipiCreateVideoPage.objunpublishedone, "Done button");
				Thread.sleep(5000);
				logger.info("PostHipiT page:"+ "Video can be unpublished under profile screen");
				extent.extentLoggerPass("PostHipiT page:","Video can be unpublished under profile screen");				
			}else{
				logger.info("PostHipiT page:"+ "Video cannot be unpublished under profile screen");
				extent.extentLoggerFail("PostHipiT page:","Video cannot be unpublished under profile screen");
				
			}
		}
		else
		{
			extent.extentLogger("", "Post hipi button not displayed");
		}
	}
	public void TemsandConditionCheckboxClickedtoSaveorPostVideo(String userType) throws Exception
	{
		extent.HeaderChildNode("Video can be unpublished under profile screen");
		System.out.println("TC_Mobile_004");		extent.extentLogger("", "TC_Mobile_004");
		Back(1);
		Thread.sleep(5000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo, "Create start button");
		Thread.sleep(20000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record start button");
		Thread.sleep(20000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "Post button");
		logger.info("Create video page:"+ "Post button");
		Thread.sleep(10000);
		click(HipiCreateVideoPage.objadddescription, "Added description field");
		type(HipiCreateVideoPage.objadddescription,"Desc"+GeneratingRandomString(7),"Description added");
		Thread.sleep(5000);
		hideKeyboard();
		Thread.sleep(5000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "Genre button");
		Thread.sleep(5000);
		////verifyElementPresentAndClick(HipiCreateVideoPage.objlanguageclickedenglish, "English button");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objuploadpost, "Post hipi button");
		Thread.sleep(8000);
		if(verifyIsElementDisplayed(HipiCreateVideoPage.objsuccess, "Video uploaded dialog"))
		{
			logger.info("Upload video page:"+ "Video getting uploaded without checking terms and condition checkbox");
			verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Ok button");
			extent.extentLoggerFail("", "Video is uploaded without selecting Terms and Conditions");
		}
		else
		{
			logger.info("Upload video page:"+ "Video not getting uploaded without checking terms and condition checkbox");
			extent.extentLoggerPass("", "Video is not getting uploaded without selecting Terms and Conditions");
		}
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objsaveasdraft, "Save as draft button");
		Thread.sleep(8000);
		if(verifyIsElementDisplayed(HipiCreateVideoPage.objsavedasdraftdialog, "Video saved as draft dialog"))
		{
			logger.info("Upload video page:"+ "Video getting saved as draft without checking terms and condition checkbox");
			extent.extentLoggerFail("", "Video getting saved as draft without checking terms and condition checkbox");
		}
		else
		{
			logger.info("Upload video page:"+ "Video not getting saved as draft without checking terms and condition checkbox");
			extent.extentLoggerPass("", "Video not getting saved as draft without checking terms and condition checkbox");
		}
	}
	
	
	public void VideoSavedasDraft(String userType) throws Exception
	{
		extent.HeaderChildNode("Video saved as draft under profile screen");
		System.out.println("TC_Mobile_005");		extent.extentLogger("", "TC_Mobile_005");
		////Thread.sleep(5000);
		Thread.sleep(10000);
		String addeddata=findElement(HipiCreateVideoPage.objadddescription).getText();
		System.out.println("Added Data:"+addeddata);
		Thread.sleep(5000);
		/*verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "Post button");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objadddescription, "Added description field");
		type(HipiCreateVideoPage.objadddescription,"Abcde","Description added");
		Thread.sleep(5000);
		hideKeyboard();
		Thread.sleep(5000);
		String addeddata=findElement(HipiCreateVideoPage.objadddescription).getText();
		System.out.println("Added Data:"+addeddata);
		Thread.sleep(5000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "Genre button");
		verifyElementPresentAndClick(HipiCreateVideoPage.objlanguageclickedenglish, "English button");
		Thread.sleep(5000);*/
		verifyElementPresentAndClick(HipiCreateVideoPage.objtcheckbox, "Terms and conditions checkbox");
		if(verifyElementExist(HipiCreateVideoPage.objsaveasdraft, "Save as draft button")) 
		{
			click(HipiCreateVideoPage.objsaveasdraft, "Save as draft button");
			Thread.sleep(20000);
			verifyElementExist(HipiCreateVideoPage.objsavedasdraftdialog, "Video saved as draft dialog");
			verifyElementPresentAndClick(HipiCreateVideoPage.objsavedasdraftokbtn, "Ok button");
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objMe, "Me button");
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objDraft, "Draft button");
			Thread.sleep(5000);
			
			if(verifyIsElementDisplayed(HipiMePage.objUploadAllButton, "Upload All button")){
				scrolltomiddle(HipiMePage.objUploadAllButton);
			}else{
				
			}
			
			scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
			Thread.sleep(5000);
			if(verifyElementExist(HipiCreateVideoPage.objSelectDraftVideo(addeddata), addeddata)){
				String dataofvideosavedasdraft=findElement(HipiCreateVideoPage.objvideosavedasdraft).getText();
				System.out.println("Data of video saved as draft:"+dataofvideosavedasdraft);
				Thread.sleep(5000);
				logger.info("PostHipiT page:"+ "Video saved as draft under profile screen");
				extent.extentLoggerPass("PostHipiT page:","Video saved as draft under profile screen");				
			}else{
				logger.info("PostHipiT page:"+ "Video not saved as draft under profile screen");
				extent.extentLoggerFail("PostHipiT page:","Video not saved as draft under profile screen");		
			}
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(5000);//changed
		}
		else
		{
		extent.extentLogger("","Save as draft button not displayed");
		}
	}
	public void CancelVideoUpload(String userType) throws Exception{
		extent.HeaderChildNode("Able to cancel video upload");
		System.out.println("TC_Mobile_006");		extent.extentLogger("", "TC_Mobile_006");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objcreatevideo, "Create start button");
		Thread.sleep(10000);//changed
		verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record start button");
		Thread.sleep(30000);//changed
		verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "Post button");
		logger.info("Create video page:"+ "Post button clicked");
		Thread.sleep(10000);
		logger.info("PostHipiT Page:"+ "Video upload page displayed");
		verifyElementPresentAndClick(HipiCreateVideoPage.objBack, "Back button");
		Thread.sleep(5000);
		if(verifyElementExist(HipiCreateVideoPage.objcontinuedialog, "Continue dialog"))
		{
			logger.info("Edit video screen:"+ "Continue dialog for canceling video recording available");
			extent.extentLoggerPass("Edit video screen:","Continue dialog for canceling video recording available");
		}
		else
		{
			logger.info("Hipi feed screen:"+ "Continue dialog for canceling video recording unavailable");
			extent.extentLoggerFail("Hipi feed screen:","Continue dialog for canceling video recording unavailable");
		}
		click(HipiCreateVideoPage.objcontinuedialogcontinuebtn, "Continue button");
		Thread.sleep(5000);
		logger.info("Edit video screen:"+ "Check back button clicked edit video page displayed to cancel video recording");
		if(verifyElementExist(HipiCreateVideoPage.objaddmusicbtneditvideopage, "Add music button")) 
		{
			logger.info("Edit video screen:"+ "Able to cancel video upload when back button clicked");
			extent.extentLoggerPass("Edit video screen:","Able to cancel video upload when back button clicked");
		}
		else
		{
			logger.info("Hipi feed screen:"+ "Unable to cancel video upload when back button clicked");
			extent.extentLoggerFail("Hipi feed screen:","Unable to cancel video upload when back button clicked");
		}
		
	}
	public void ExitVideoUpload(String userType) throws Exception{
		extent.HeaderChildNode("Able to exit video upload");
		System.out.println("TC_Mobile_007");		extent.extentLogger("", "TC_Mobile_007");
		Back(1);
		if(verifyElementExist(HipiCreateVideoPage.objcontinuedialogvideoeditpage, "Continue dialog")) 
		{
			click(HipiCreateVideoPage.objcontinuedialogcontinuebtnvideoeditpage, "Continue dialog");
			Back(1);
			if(verifyElementExist(HipiCreateVideoPage.objdiscarddialog, "Discard dialog"))
			{
				logger.info("Edit video screen:"+ "Discard dialog available");
				extent.extentLoggerPass("Edit video screen:","Discard dialog available");
			}
			else
			{
				logger.info("Hipi feed screen:"+ "Discard dialog unavailable");
				extent.extentLoggerFail("Hipi feed screen:","Discard dialog unavailable");
			}
			verifyElementPresentAndClick(HipiCreateVideoPage.objdiscarddialogokbtn, "yes button");
			Thread.sleep(5000);
			verifyElementExist(HipiCreateVideoPage.objcreatevideo, "Hipi page displayed");
			logger.info("Edit video screen:"+ "Able to exit video upload");
			extent.extentLoggerPass("Edit video screen:","Able to exit video upload");
		}
		else
		{
			logger.info("Hipi feed screen:"+ "Unable to exit video upload");
			extent.extentLoggerFail("Hipi feed screen:","Unable to exit video upload");
		}
		}
		


	
	
	
	
	
	
	
	
	
	//---------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	//-------------------------------------Himadri : Scheduling-----------------------------------------------------	
	
	
	
	
	public void ValidatingScheduling(String userType) throws Exception{
		if(userType.equalsIgnoreCase("NonSubscribedUser")){
			AddTimerDialogAvailable(userType);
			AddTimerTimeElapsed(userType);
			AddTimerMusicEffectAddedBeforeRecording(userType);
			PreSelectedMusicFilterAndEffectAreAvaiable(userType);
		}else{
			
		}
	}
	
	
	
	public void AddTimerDialogAvailable(String userType) throws Exception
	{
		extent.HeaderChildNode("Checking timer can be set");
		System.out.println("TC_Mobile_002");
		Thread.sleep(10000);
		verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
		Thread.sleep(10000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo, "Create start button of video available");
		Thread.sleep(5000);
		if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo, "Allow ZEE5 to take pictures and record video?"))
		{
			logger.info("Permission dialog:"+ "Allow ZEE5 to take pictures and record video?");
			verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow");
			click(HipiCreateVideoPage.objCreateAllow, "Allow button");
			logger.info("Allow ZEE5 to take pictures and record video-"+ "Allow button");
			Thread.sleep(5000);
			
			logger.info("Permission dialog:"+ "Allow ZEE5 to access photos, media, and files on your device");
			verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to access photos, media, and files on your device?");		
			click(HipiCreateVideoPage.objCreateAllow, "Allow button");
			logger.info("Allow ZEE5 to access photos, media, and files on your device-"+ "Allow button");
			Thread.sleep(5000);
			
			logger.info("Permission dialog:"+ "Allow ZEE5 to record audio");
			verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?");
			click(HipiCreateVideoPage.objCreateAllow, "Allow button");	
			logger.info("Allow ZEE5 to record audio-"+ "Allow button");
			//Thread.sleep(50000);//added
			waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
			verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
			click(HipiCreateVideoPage.objCreateReadyYes, "yes button");	
			logger.info("Ready dialog displayed:"+ "yes button");
			Thread.sleep(5000);
		}
		else
		{
			logger.info("Permission dialog:"+ "Permission dialog unavailable");
		}
		Thread.sleep(10000);
		click(HipiCreateVideoPage.objtimerbtn, "Add timer button");
		Thread.sleep(5000);
		if(verifyElementExist(HipiCreateVideoPage.objtimerdialogbtn, "Add timer dialog"))
		{
		Thread.sleep(10000);
						if(verifyElementExist(HipiCreateVideoPage.objtimerbtn_timer_3s, "Add timer button for 3s"))
						{
							extent.extentLoggerPass("Create Video Page:","Add timer button for 3s available");
							logger.info("Create Video Page:"+ "Add timer button for 3s available");
						}
						else
						{
							logger.info("Create Video Page:"+ "Add timer button for 3s unavailable");
							extent.extentLoggerFail("Create Video Page:","Add timer button for 3s unavailable");
						}
		Thread.sleep(5000);
						if(verifyElementExist(HipiCreateVideoPage.objtimerbtn_timer_5s, "Add timer button for 5s"))
						{
							extent.extentLoggerPass("Create Video Page:","Add timer button for 5s available");
							logger.info("Create Video Page:"+ "Add timer button for 5s available");
						}
						else
						{
							logger.info("Create Video Page:"+ "Add timer button for 5s unavailable");
							extent.extentLoggerFail("Create Video Page:","Add timer button for 5s unavailable");
						}
		Thread.sleep(5000);
						if(verifyElementExist(HipiCreateVideoPage.objtimerbtn_timer_10s, "Add timer button for 10s"))
						{
							logger.info("Create Video Page:"+ "Add timer button for 10s available");
							extent.extentLoggerPass("Create Video Page:","Add timer button for 10s available");
						}
						else
						{
							logger.info("Create Video Page:"+ "Add timer button for 10s unavailable");
							extent.extentLoggerFail("Create Video Page:","Add timer button for 10s unavailable");
						}
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objtimerbtn, "Add timer button");
		Thread.sleep(5000);
		logger.info("Create Video Page:"+ "Add timer dialog with options 3s,5s,10s available");
		extent.extentLoggerPass("Create Video Page:", "Add timer dialog with options 3s,5s,10s available");
		}
		else
		{
			logger.info("Create Video Page:"+ "Add timer dialog with options 3s,5s,10s unavailable");
			extent.extentLoggerFail("Create Video Page:", "Add timer dialog with options 3s,5s,10s unavailable");
			
		}
	}

	
	public void AddTimerTimeElapsed(String userType) throws Exception
	{
		extent.HeaderChildNode("Checking add timer time lapsed count from 10 available and then video recording working");
		System.out.println("TC_Mobile_003");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objtimerbtn, "Add timer button");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objtimerbtn_timer_10s, "Add timer 10s");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objtimerbtn, "Add timer button");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objrecordbtn, "Record button");
		if(verifyIsElementDisplayed(HipiCreateVideoPage.objtimertimelapsed1, "Add timer time lapsed count from 10"))
		{
			click(HipiCreateVideoPage.objcancel, "Cancel");
			logger.info("Create Video Page:"+ "Add timer time lapsed count from 10 available and then video recording working");
			extent.extentLoggerPass("Create Video Page:", "Add timer time lapsed count from 10 available and then video recording working");
		}
		else
		{
			logger.info("Create Video Page:"+ "Add timer time lapsed count from 10 unavailable");
			extent.extentLoggerFail("Create Video Page:", "Add timer time lapsed count from 10 unavailable");
		}
	}
	
	
	
	public void AddTimerMusicEffectAddedBeforeRecording(String userType) throws Exception
	{
		extent.HeaderChildNode("Checking timer,music,effect can be added before recording");
		System.out.println("TC_Mobile_007");
		click(HipiCreateVideoPage.objtimerbtn, "Add timer button");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objtimerbtn_timer_10s, "Add timer button for 10s");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objtimerbtn, "Add timer button");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objAddMusicButton, "Add music button");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objaddmusicsearch, "Search music field available");
		Thread.sleep(5000);
		type(HipiCreateVideoPage.objaddmusicsearcheddata,"jothe", "Search Field");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objaddmusicdataclicked, "Music");
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objaddmusic, "Music");
		Thread.sleep(10000);
		click(HipiCreateVideoPage.objmusicplaypause, "Play/pause button");
		click(HipiCreateVideoPage.objmusicusebtn, "Tick button");
		Thread.sleep(5000);
		if(verifyElementExist(HipiCreateVideoPage.objmusicavailable, "Music added"))
		{ 
			logger.info("Create Video Page:"+ "Music added");
			extent.extentLoggerPass("Create Video Page:", "Music added");
		}
		else
		{
			logger.info("Create Video Page:"+ "Music did not get added");
			extent.extentLoggerFail("Create Video Page:", "Music did not get added");
		}
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objfilter, "Add filter button");
		Thread.sleep(5000);
		if(verifyElementExist(HipiCreateVideoPage.objaddfilterdialog, "Add filter dialog"))
		{
			logger.info("Create Video Page:"+ "Add filter dialog available");
			extent.extentLoggerPass("Create Video Page:", "Add filter dialog available");
		}
		else
		{
			logger.info("Create Video Page:"+ "Add filter dialog unavailable");
			extent.extentLoggerFail("Create Video Page:", "Add filter dialog unavailable");
		}
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objfirstfilterbeforedownlload, "Required filter download button");
		Thread.sleep(25000);
		click(HipiCreateVideoPage.objfirstfilterafterdownloadfinish, "Required filter button");
		Thread.sleep(5000);
		Back(1);
		Thread.sleep(5000);
		if(verifyElementExist(HipiCreateVideoPage.objHighlightedFiltericon, "Add filter enabled button"))
		{
			logger.info("Create Video Page:"+ "Add filter button enabled");
			extent.extentLoggerPass("Create Video Page:", "Add filter button enabled");
		}
		else
		{
			logger.info("Create Video Page:"+ "Add filter button disabled");
			extent.extentLoggerFail("Create Video Page:", "Add filter button disabled");
		}
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objeffect, "Add effect button");
		Thread.sleep(5000);
		if(verifyElementExist(HipiCreateVideoPage.objaddeffectdialog, "Add effect dialog available"))
		{
			logger.info("Create Video Page:"+ "Add effect dialog available");
			extent.extentLoggerPass("Create Video Page:", "Add effect dialog available");
		}
		else
		{
			logger.info("Create Video Page:"+ "Add effect dialog unavailable");
			extent.extentLoggerFail("Create Video Page:", "Add effect dialog unavailable");
		}
		click(HipiCreateVideoPage.objfirsteffectbeforedownlload, "Required effect download button");
		Thread.sleep(25000);
		click(HipiCreateVideoPage.objfirsteffectafterdownloadfinish, "Required effect button");
		Thread.sleep(5000);
		Back(1);
		Thread.sleep(5000);
		if(verifyElementExist(HipiCreateVideoPage.objHighlightedEffectIcon, "Add effect enabled button"))
		{
			logger.info("Create Video Page:"+ "Add effect button enabled");
			extent.extentLoggerPass("Create Video Page:", "Add effect button enabled");
		}
		else
		{
			logger.info("Create Video Page:"+ "Add effect button disabled");
			extent.extentLoggerFail("Create Video Page:", "Add effect button disabled");
		}
		Thread.sleep(5000);
		click(HipiCreateVideoPage.objrecordbtn, "Record button");
		if(verifyElementExist(HipiCreateVideoPage.objtimertimelapsed1, "Record video timer enabled"))
		{
			logger.info("Create Video Page:"+ "Record video timer enabled");
			extent.extentLoggerPass("Create Video Page:", "Record video timer enabled");
		}
		else
		{
			logger.info("Create Video Page:"+ "Record video timer unavailable");
			extent.extentLoggerFail("Create Video Page:", "Record video timer unavailable");
		}
//		Thread.sleep(10000);
//		click(HipiCreateVideoPage.objrecordbtn, "Record button");removed
		click(HipiCreateVideoPage.objcancel, "Cancel");//added
		Thread.sleep(5000);//added
		logger.info("Create Video Page:"+"Before recording timer,filter,effect can be set with valid timer count enabled");
	}
	
	
	
	
	public void PreSelectedMusicFilterAndEffectAreAvaiable(String userType) throws Exception
	{
		extent.HeaderChildNode("Checking navigate to create page and timer reset");
		System.out.println("TC_Mobile_011");
		Thread.sleep(5000);
				if(verifyElementExist(HipiCreateVideoPage.objAddFilterButtonHiglighted, "Pre selected filter enabled"))
				{
					logger.info("Create Video Page:"+"Pre selected filter enabled");
					extent.extentLoggerPass("Create Video Page:","Pre selected filter enabled");
				}
				else
				{
					logger.info("Create Video Page:"+"Pre selected filter unavailable");
					extent.extentLoggerFail("Create Video Page:","Pre selected filter unavailable");
				}
				Thread.sleep(5000);
				if(verifyElementExist(HipiCreateVideoPage.objAddEffectButtonHiglighted, "Pre selected effect"))
				{
					logger.info("Create Video Page:"+"Pre selected effect enabled");
					extent.extentLoggerPass("Create Video Page:","Pre selected effect enabled");
				}
				else
				{
					logger.info("Create Video Page:"+"Pre selected effect unavailable");
					extent.extentLoggerFail("Create Video Page:","Pre selected effect unavailable");
				}
				Thread.sleep(5000);
				if(verifyElementExist(HipiCreateVideoPage.objmusicavailable, "Pre selected music"))
				{
					logger.info("Create Video Page:"+"Pre selected music available");
					extent.extentLoggerPass("Create Video Page:","Pre selected music available");
				}
				else
				{
					logger.info("Create Video Page:"+"Pre selected music unavailable");
					extent.extentLoggerFail("Create Video Page:","Pre selected music unavailable");
				}
		}
	

		

	
	
	
	
	//----------------------------------------------------------------------------------------------------------------
	
	
	
	//-----------------------------------UploadFromGallery--------------------------------------------
	
	public void UploadFromGalleryValidation(String userType) throws Exception {
		extent.HeaderChildNode("UploadFromGalleryValidation");
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Before shooting Check if on tapping Upload Icon user is navigated to Select video screen");
			extent.extentLogger("", "TC_Mobile_001");System.out.println("TC_Mobile_001");
			verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(5000);
			
			click(HipiCreateVideoPage.objcreatevideo, "Plus/+ Icon");
			waitTime(5000);
			
			verifyElementPresent(HipiCreateVideoPage.objaccesspictures, "Permission to access pictures and record audio");
			verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "Allow Button");

			verifyElementPresent(HipiCreateVideoPage.objpermission, "Permission to access photos/media/files");
			verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "Allow Button");

			verifyElementPresent(HipiCreateVideoPage.objrecordpermission, "Permission to record audio");
			verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "Allow Button");

			waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
			Thread.sleep(3000);
			verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
			verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
			waitTime(20000);

			verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "Upload Video");

			if(verifyIsElementDisplayed(HipiCreateVideoPage.objSelectHiPiTitle, "SelectHipi Title")){
				extent.extentLoggerPass("", "User is navigated to Select video screen");
			}else{
				extent.extentLoggerFail("", "User is not navigated to Select video screen");				
			}
			
			
			if (verifyIsElementDisplayed(HipiCreateVideoPage.objselectFirstimage, "Video in gallery")) {
				logger.info("User is navigated to Select video screen");
				extent.extentLogger("Video",
						"User is navigated to Select video screen");
				verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "First video in gallery");
				verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, "Edit HipiIT");
				Thread.sleep(5000);
				verifyElementPresent(HipiCreateVideoPage.objtrimlefthandle, "Trim video slider");
				verifyElementPresent(HipiCreateVideoPage.objRotatingIcon, "Rotating Icon");
				verifyElementPresent(HipiCreateVideoPage.objbackbutton, "Back Icon");
				
				
				verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, "Tick Mark");

				extent.HeaderChildNode("Before shooting Check if user is unable to create a video after selecting video from gallery");
				extent.extentLogger("", "TC_Mobile_004");	System.out.println("TC_Mobile_004");		
				if(verifyIsElementDisplayed(HipiCreateVideoPage.objcreatevideo, "Create Video")){
					extent.extentLoggerFail("", "Create Video butoon is available after uploading the video");
				}else{
					extent.extentLoggerPass("", "Create Video butoon is not available after uploading the video");
				}

				verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "Post");
				waitTime(15000);
				waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
				verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
				String postDescription = "Desc"+GeneratingRandomString(7);
				type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
				waitTime(3000);
				hideKeyboard();
				waitTime(3000);
				verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "Genre video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "English");
				verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox," 'By Continuing, you agree to our Terms & Privacy Policy' text ");

				extent.HeaderChildNode("Before shooting Check if user is able to upload video from gallery");
				extent.extentLogger("", "TC_Mobile_002");	System.out.println("TC_Mobile_002");	
				verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "Post to hipi");// saveasdraft
				waitTime(10000);
				boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
				if (Popup) {
					extent.extentLoggerPass("Success", "User should be able to upload video from gallery.");
					logger.info("Success Popup is displayed ");
				}
				else {
					extent.extentLoggerFail("", "User in not able to upload video from gallery.");
					logger.info("Success Popup is not displayed ");
				}
				verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Ok button");
				Thread.sleep(10000);

				verifyElementPresentAndClick(AMDHipi.objmeicon, "Me icon");
				extent.HeaderChildNode("Post Shooting Verify the uploaded video is available in user profile");
				extent.extentLogger("", "TC_Mobile_006");		System.out.println("TC_Mobile_006");	

				for (int i = 0; i <= 50; i++) {
					scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
					if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
						Thread.sleep(2000);
						Back(1);
						Thread.sleep(2000);
						verifyElementPresentAndClick(AMDHipi.objmeicon, "Me icon");
					} else {
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objSelectVideo(postDescription), "Uploaded video")){
							extent.extentLoggerPass("", "Uploaded video is visible on Profile");
						}else{
							extent.extentLoggerFail("", "Uploaded video is not visible on Profile");
						}
	
						
						break;
					}
				}
				

				waitTime(5000);
				
			}else {
				logger.info("Video unavailable in gallery");
				extent.extentLogger("Video","Video unavailable in gallery");
				Back(1);
			}

			
			
			extent.HeaderChildNode("Before shooting Check if user is able to select other video speed options");
			extent.extentLogger("", "TC_Mobile_007");		System.out.println("TC_Mobile_007");	
			Back(1);
			
			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			waitTime(5000);

			if (verifyIsElementDisplayed(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
				// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
				// on create a video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow / WHILE USING THE APP button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow / WHILE USING THE APP button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow / WHILE USING THE APP button");
			}

			// waitTime(15000);
			if(verifyIsElementDisplayed(HipiMePage.objreadypopup, "Ready Popup")){
				waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
				Thread.sleep(3000);
				verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
				verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
				waitTime(20000);
				extent.extentLoggerPass("", "Navigated to Create Video page");				
			}

			if (verifyIsElementDisplayed(HipiCreateVideoPage.objrecordbtn, "Record Button")) {
				click(HipiCreateVideoPage.objrecordbtn, "Record Button");
				Thread.sleep(5000);
				click(HipiCreateVideoPage.objrecordbtn, "Record Button");
				
				if(verifyIsElementDisplayed(HipiCreateVideoPage.objCreateVideoSpeedButton,"Video Speed")){
					click(HipiCreateVideoPage.objCreateVideoSpeedButton,"Video Speed");
					
					if(verifyIsElementDisplayed(HipiCreateVideoPage.objsuper_slow_speed_btn, "Slow Speed")){
						click(HipiCreateVideoPage.objsuper_slow_speed_btn, "Slow Speed");
						click(HipiCreateVideoPage.objCreateVideoSpeedButton,"Video Speed");
						
						click(HipiCreateVideoPage.objrecordbtn, "Record Button");
						
						waitForElementDisplayed(HipiCreateVideoPage.objpost, 15);
						
						if(verifyElementExist(HipiCreateVideoPage.objpost, "Post button")){
							extent.extentLoggerPass("", "Recording is resumed");
						}else{
							extent.extentLoggerFail("", "Recording is not resumed");
						}
					}
					
				}
				
			}
			
		}
	}
	

		
	
	
	
	
	
	
	
	//-----------------------------------Camera Tools PreShoot--------------------------------------------
	
	
	public void CameraToolsPreShootValidation(String userType) throws Exception{
		extent.HeaderChildNode("CameraToolsPreShoot");
		if(userType.equalsIgnoreCase("Guest")){
			//Guest
			extent.HeaderChildNode("Before Shooting Check if user is unable to create video without logged in user");
			extent.extentLogger("", "TC_Mobile_005");System.out.println("TC_Mobile_005");
			
			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "hipi icon");

			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			
			if (verifyElementDisplayed(AMDHipi.objRegisterPop)) {
				extent.extentLoggerPass("", "User is not able to Create video as guest");
			} else {
				extent.extentLoggerFail("", "User is able to Create video as guest");
			}
			
		}else{
			//NonSubscribedUser
			
			extent.HeaderChildNode("Before Shooting Check if user is able to create video with logged in user");
			extent.extentLogger("", "TC_Mobile_006");System.out.println("TC_Mobile_006");
			
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
			
			
			if (verifyElementExist(HipiCreateVideoPage.objrecordbtn, "Record Button")) {
				extent.extentLoggerPass("", "Video recording screen is displayed");
			}else{
				extent.extentLoggerFail("", "Video recording screen is not displayed");
			}
			
			
			extent.HeaderChildNode("Before shooting Check if on tapping back Icon user is navigated to HiPi home screen");
			extent.extentLogger("", "TC_Mobile_020");System.out.println("TC_Mobile_020");
			
			Back(1);
			if(verifyElementExist(HipiCreateVideoPage.objcreatevideo, "Create Video"))
			{
				extent.extentLoggerPass("", "User redirected to Hipi Home screen");
				waitTime(5000);
				verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
				waitTime(5000);
				
			}else{
				extent.extentLoggerFail("", "User is not redirected to Hipi Home screen");
			}
			
			
			extent.HeaderChildNode("Before shooting Check Video Creation Screen options are present on TOP section");
			extent.extentLogger("", "TC_Mobile_001");System.out.println("TC_Mobile_001");
			
			checkElementPosition(HipiCreateVideoPage.objBack, "Top", "Back icon");
			checkElementPosition(HipiCreateVideoPage.objCreateVideoFlash, "Top", "Flash icon");
			checkElementPosition(HipiCreateVideoPage.objCreateVideoFlip, "Top", "Flip Icon");
			
			extent.HeaderChildNode("Before shooting Check Video Creation Screen options are present on BOTTOM section Layer1");
			extent.extentLogger("", "TC_Mobile_002");System.out.println("TC_Mobile_002");
			
			checkElementPosition(HipiCreateVideoPage.objtimerbtn, "Down", "Add Timer icon");
			checkElementPosition(HipiCreateVideoPage.objMusicBtn, "Down", "Add Music icon");
			checkElementPosition(HipiCreateVideoPage.objCreateVideoSpeedButton, "Down", "Add Video Speed Icon");
			checkElementPosition(HipiCreateVideoPage.objfilter, "Down", "Add Filter icon");
			checkElementPosition(HipiCreateVideoPage.objeffect, "Down", "Add Effect icon");
			
			
			extent.HeaderChildNode("Before shooting Check Video Creation Screen options are present on BOTTOM section Layer2");
			extent.extentLogger("", "TC_Mobile_003");System.out.println("TC_Mobile_003");
			
			checkElementPosition(HipiCreateVideoPage.objbeautybtn, "Down", "BeautyMode icon");
			checkElementPosition(HipiCreateVideoPage.objrecordbtn, "Down", "Record icon");
			checkElementPosition(HipiCreateVideoPage.objuploadvideo, "Down", "UploadVideo Speed Icon");
	
			
			extent.HeaderChildNode("Before shooting Check Video Creation Screen options are present on BOTTOM section Layer3");
			extent.extentLogger("", "TC_Mobile_004");System.out.println("TC_Mobile_004");
			
			checkElementPosition(HipiCreateVideoPage.obj15sec, "Down", "15s icon");
			checkElementPosition(HipiCreateVideoPage.obj30sec, "Down", "30s icon");
			checkElementPosition(HipiCreateVideoPage.obj45sec, "Down", "45s icon");
			checkElementPosition(HipiCreateVideoPage.obj60sec, "Down", "60s icon");
			checkElementPosition(HipiCreateVideoPage.obj90sec, "Down", "90s icon");
			
			extent.HeaderChildNode("Before shooting in Front camera Check if user is able to ON flash on device supporting front camera");
			extent.extentLogger("", "TC_Mobile_007");System.out.println("TC_Mobile_007");
			
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objFlashLight, "Flash light")){
				
				if(verifyIsElementDisplayed(HipiCreateVideoPage.objCameraFlip, "Flip Icon")){
					extent.extentLoggerPass("", "Defaulty camera is on Front mode");
				}else{
					extent.extentLoggerFail("", "Defaulty camera is not on Front mode");
				}
				
				extent.extentLoggerPass("", "Flash light is off");
				extent.extentLogger("", "Flash light is Present");
				click(HipiCreateVideoPage.objFlashLight, "Flash light");
				waitTime(2000);
				
				if(verifyIsElementDisplayed(HipiCreateVideoPage.objFlashLightEnabled, "Flash Light Enabled")){
					extent.extentLoggerPass("", "Flash Light is ON");
					
					extent.HeaderChildNode("Before shooting in Front camera Check if user is able to Off flash on device supporting front camera");
					extent.extentLogger("", "TC_Mobile_008");System.out.println("TC_Mobile_008");
					
					click(HipiCreateVideoPage.objFlashLightEnabled, "Flash light On");
				
					if(verifyIsElementDisplayed(HipiCreateVideoPage.objFlashLight, "Flash light")){
						extent.extentLoggerPass("", "Flash Light turned off after turning on");
					}else{
						extent.extentLoggerFail("", "Flash Light not turned off after turning on");
					}
				
				}else{
					extent.extentLoggerWarning("", "Flash Light is not ON OR Device Wont support Front Flash");
				}
				
			}else{
				extent.extentLogger("", "Flash light is not Present");
			}
			
			extent.HeaderChildNode("Before shooting Check on tapping Video Speed Icon system displays Video Speed bar with options 0.3x,0.5x,1x,2x,3x");
			extent.extentLogger("", "TC_Mobile_012");System.out.println("TC_Mobile_012");
			
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objCreateVideoSpeedButton, "VideoSpeed")){
				extent.extentLoggerPass("", "Video Speed is displayed");
				click(HipiCreateVideoPage.objCreateVideoSpeedButton, "Video Speed");
				verifyElementPresent(HipiCreateVideoPage.objsuper_slow_speed_btn, "0.3x");
				verifyElementPresent(HipiCreateVideoPage.objslow_speed_btn, "0.5x");
				verifyElementPresent(HipiCreateVideoPage.objstandard_speed_btn, "1x");
				verifyElementPresent(HipiCreateVideoPage.objfast_speed_btn, "2x");
				verifyElementPresent(HipiCreateVideoPage.objsuper_fast_speed_btn, "3x");
				
				click(HipiCreateVideoPage.objCreateVideoSpeedButton, "Video Speed");				
			}else{
				extent.extentLoggerFail("", "Video Speed is not displayed");				
			}
			
			
			extent.HeaderChildNode("Before shooting Check by default beauty mode is set to ON");
			extent.extentLogger("", "TC_Mobile_014");System.out.println("TC_Mobile_014");
			
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objbeautybtn, "Beauty Mode")){
				if(verifyElementPresent(HipiCreateVideoPage.objbeautybtnenabled, "Beauty Mode is defaultly ON"))
				{
					extent.extentLoggerPass("", "Beauty Mode is defaultly ON");					
				}else{
					extent.extentLoggerFail("", "Beauty Mode is not defaultly ON");					
				}
			}else{
				extent.extentLoggerFail("", "Beauty Mode is not present");
			}

			
			extent.HeaderChildNode("Before shooting Check by tapping on beauty mode,user is able to set beauty mode to OFF and overlay disappear");
			extent.extentLogger("", "TC_Mobile_016");System.out.println("TC_Mobile_016");
			
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objbeautybtn, "Beauty Mode")){
				if(verifyElementPresent(HipiCreateVideoPage.objbeautybtnenabled, "Beauty Mode is defaultly ON"))
				{
					extent.extentLoggerPass("", "Beauty Mode is defaultly ON");		
					
					click(HipiCreateVideoPage.objbeautybtnenabled, "BeautyMode");
					Thread.sleep(3000);
					
					if(verifyIsElementDisplayed(HipiCreateVideoPage.objbeautybtndisabled, "BeautyMode Disabled Icon")){
						extent.extentLoggerPass("","Beauty Mode is Turned Off");
						click(HipiCreateVideoPage.objbeautybtndisabled, "BeautyMode Turned OFF");
					}else{
						extent.extentLoggerFail("","Beauty Mode is not Turned Off");
					}
					
				}else{
					extent.extentLoggerFail("", "Beauty Mode is not defaultly ON");					
				}
			}else{
				extent.extentLoggerFail("", "Beauty Mode is not present");
			}
			
			
			
			extent.HeaderChildNode("BeforeShooting Check defaulted video creation time is set to 15s and highlighted with pink underscore");
			extent.extentLogger("", "TC_Mobile_021");System.out.println("TC_Mobile_021");
			
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objDefaultSelectedTime, "Selected Time")){
				extentLoggerPass("", "Selected time is displayed");
				String timeSelected = getAttributValue("text", HipiCreateVideoPage.objDefaultSelectedTime);
				if(timeSelected.contains("15")){
					extent.extentLoggerPass("", "Default selected time is 15");
				}else{
					extent.extentLoggerFail("", "Default selected time is not 15");
				}
			}else{
				extentLoggerFail("", "Selected time is not displayed");
			}
			
			
			extent.HeaderChildNode("During shooting Check if the user is able to pause video");
			extent.extentLogger("", "TC_Mobile_017");System.out.println("TC_Mobile_017");
			
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objrecordbtn, "Record Button")){
				click(HipiCreateVideoPage.objrecordbtn, "Record Button");
				Thread.sleep(2000);
				click(HipiCreateVideoPage.objrecordbtn, "Record Button");
				
				if(verifyIsElementDisplayed(HipiCreateVideoPage.objdeleteclip, "Delete Clip")){
					extent.extentLoggerPass("", "Recording Paused");
				}else{
					extent.extentLoggerFail("", "Recording not Paused");
				}
			}
			

			extent.HeaderChildNode("During shooting Check if the user is able to resume a paused video");
			extent.extentLogger("", "TC_Mobile_018");System.out.println("TC_Mobile_018");
			
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objdeleteclip, "Delete Clip")){
				click(HipiCreateVideoPage.objrecordbtn, "Record Button");
				
				if(verifyIsElementDisplayed(HipiCreateVideoPage.objdeleteclip, "Delete Clip")){
					extent.extentLoggerFail("", "Recording Paused");
				}else{
					extent.extentLoggerPass("", "Recording is Resumed");
					
								}
			}
			
			
			extent.HeaderChildNode("During shooting Check if user is able to end a video and verify the user is navigated to Video Edit Screen");
			extent.extentLogger("", "TC_Mobile_019");System.out.println("TC_Mobile_019");
			
			waitForElementAndClickIfPresent(HipiCreateVideoPage.objFinishButton, 6, "Finish Button");
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objPostbutton, "Post button")){
				extent.extentLoggerPass("", "Navigated to Video Edit screen");

			}else{
				extent.extentLoggerFail("", "Not Navigated to Video Edit screen");
			}

			
			extent.HeaderChildNode("During shooting Check is user is navigated to Video edit screen once the sheduled video creation time is lapsed");
			extent.extentLogger("", "TC_Mobile_022");System.out.println("TC_Mobile_022");

			Back(1);			
			Thread.sleep(5000);
			if(verifyElementExist(HipiCreateVideoPage.objrecordclipcontinueshootdialog, "Continue Shoot dialog available")){
				extent.extentLogger("", "Continue Shoot dialogue is displayed");
				click(HipiCreateVideoPage.objeditpagecontinuebtn, "Continue button");	
				Thread.sleep(5000);
				
				Back(1);
				if (verifyElementExist(HipiAddMusicPage.objDiscardShootPopup,"Discardshoot popup")) {
					extent.extentLogger("", "Discard Shoot dialogue is displayed");
					click(HipiAddMusicPage.objDiscardShootPopupContinueButton,"Continue Btton");
					
					click(HipiCreateVideoPage.objCreateButton, "Plus icon");
					
					String defaultTimer = getAttributValue("text", HipiCreateVideoPage.objDefaultSelectedTime);
					String[] str = defaultTimer.split("s");
					int sec = Integer.parseInt(str[0]);
					
					click(HipiCreateVideoPage.objrecordbtn, "Record Button");
					waitForElementDisplayed(HipiCreateVideoPage.objPostbutton, 20);
					if(verifyIsElementDisplayed(HipiCreateVideoPage.objPostbutton, "Post button")){
						extent.extentLoggerPass("", "User navigated to video edit screen after wait of "+sec+" sec");
						
						
						extent.HeaderChildNode("During Shooting Check if user is able to select Add timer in multiple clip segment");
						extent.extentLogger("", "TC_Mobile_025");System.out.println("TC_Mobile_025");
						
						Back(1);			
						Thread.sleep(5000);
						if(verifyElementExist(HipiCreateVideoPage.objrecordclipcontinueshootdialog, "Continue Shoot dialog available")){
							extent.extentLogger("", "Continue Shoot dialogue is displayed");
							click(HipiCreateVideoPage.objeditpagecontinuebtn, "Continue button");	
							Thread.sleep(5000);
							
							Back(1);
							if (verifyElementExist(HipiAddMusicPage.objDiscardShootPopup,"Discardshoot popup")) {
								extent.extentLogger("", "Discard Shoot dialogue is displayed");
								click(HipiAddMusicPage.objDiscardShootPopupContinueButton,"Continue Btton");
								
								click(HipiCreateVideoPage.objCreateButton, "Plus icon");
								Thread.sleep(2000);
								if(verifyIsElementDisplayed(HipiCreateVideoPage.objrecordbtn, "Record Button")){
									click(HipiCreateVideoPage.objrecordbtn, "Record Button");
									Thread.sleep(2000);
									click(HipiCreateVideoPage.objrecordbtn, "Record Button");
									
									if(verifyIsElementDisplayed(HipiCreateVideoPage.objdeleteclip, "Delete Clip")){
										extent.extentLoggerPass("", "Recording Paused");
										
										
										if(verifyIsElementDisplayed(HipiCreateVideoPage.objtimerbtn, "Timer button")){
											click(HipiCreateVideoPage.objddtimerdisabled, "Timer button");
											verifyElementPresentAndClick(HipiCreateVideoPage.objtimerbtn_timer_10s, "10s timer");
									
											click(HipiCreateVideoPage.objddtimerdisabled, "Timer button");
											
											click(HipiCreateVideoPage.objrecordbtn, "Record Button");
											
											if(verifyIsElementDisplayed(HipiCreateVideoPage.objtimertimelapsed1, "Add timer time lapsed count from 10"))
											{
												click(HipiCreateVideoPage.objcancel, "Cancel");
												extent.extentLoggerPass("", "User is able to add timer in multiple clip segment");
											}
											else
											{
												extent.extentLoggerFail("", "User is not able to add timer in multiple clip segment");
											}
											
											
											
										
										}
										
										
									}else{
										extent.extentLoggerFail("", "Recording not Paused");
									}
								}
								
								
								
								
							}else{
								extent.extentLogger("", "Discard Shoot dialogue is not displayed");
							}

							
							
						}else{
							extent.extentLogger("", "Continue Shoot dialogue is not displayed");
						}
						
						
						
					}else{
						extent.extentLoggerFail("", "User not navigated to video edit screen");
					}
					
					
				}else{
					extent.extentLogger("", "Discard Shoot dialogue is not displayed");
				}

				
				
			}else{
				extent.extentLogger("", "Continue Shoot dialogue is not displayed");
			}
			
			

			
			
		}
		
	}
	
	
	
	//---------------------------------------------------------------------------------------------------------------
	
	
	
	
	public void UploadPostingScreenValidation(String userType) throws Exception{
		extent.HeaderChildNode("UploadPostingScreen");
		
		String PublicVideoDescription = null;
		String FollowersOnlyVideoDescription = null;
		String PrivateVideoDescription = null;		
		if(userType.equalsIgnoreCase("Guest")){
			
		}else{
		
			extent.HeaderChildNode("Upload video");
			
			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "hipi icon");

			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			waitTime(5000);

			if (verifyIsElementDisplayed(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
				// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
				// on create a video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow button");
				
				// waitTime(15000);
				waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
				Thread.sleep(3000);
				verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
				verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
				waitTime(20000);
				
			}


			
			
			if (verifyElementExist(HipiCreateVideoPage.objrecordbtn, "Record Button")) {
				extent.extentLoggerPass("", "Video recording screen is displayed");
				
				verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload video");
				
				if (verifyElementExist(HipiCreateVideoPage.objselectFirstimage, "Video present")) {
					verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "Video present");

					verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, "Edit HipiIT");
					Thread.sleep(5000);
					if (verifyElementExist(HipiCreateVideoPage.objtrimfinish, "finish")) {

						verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, "finish");

						verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
						waitTime(15000);
						waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
						
						extent.HeaderChildNode("Post Shooting Check if user is able to view the Cover photo of video created");
						System.out.println("TC_Mobile_039");		extent.extentLogger("", "TC_Mobile_039");
						
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objImageView, "Image View")){
							extent.extentLoggerPass("", "Cover photo is displayed");
						}else{
							extent.extentLoggerFail("", "Cover photo is not displayed");
						}
						
						verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
						String postDescription = "Desc"+GeneratingRandomString(7);
						PublicVideoDescription = postDescription;
						extent.extentLogger("", "PublicVideoDescription : "+PublicVideoDescription);
						type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
						waitTime(3000);
						hideKeyboard();
						waitTime(3000);
						
						verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
						verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
						
						
						
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objadvancedsettingsbutton, "Advanced Settings")){
							extent.extentLoggerPass("", "Advanced Settings is Displayed");
							
							click(HipiCreateVideoPage.objadvancedsettingsbutton, "Advanced Settings Link");
							
							extent.HeaderChildNode("Post Shooting Check if user is able to set privacy setting to allow[enable] comments");
							System.out.println("TC_Mobile_013");		extent.extentLogger("", "TC_Mobile_013");
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objallowcommentsenabledbar, "Allow Comment Enabled")){
								extent.extentLoggerPass("", "Allow Comment is Enabled");
							}else{
								extent.extentLoggerFail("", "Allow Comment is not Enabled");	
							}
							
							extent.HeaderChildNode("Post Shooting Check if user is able to set privacy setting to allow[enable] Like");
							System.out.println("TC_Mobile_017");		extent.extentLogger("", "TC_Mobile_017");
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objallowlikedislikeenabledbar, "Allow Like Enabled")){
								extent.extentLoggerPass("", "Allow Like is Enabled");
							}else{
								extent.extentLoggerFail("", "Allow Like is not Enabled");	
							}
							
							
							extent.HeaderChildNode("Post Shooting Check if user is able to set privacy setting to allow[enable] Share");
							System.out.println("TC_Mobile_021");		extent.extentLogger("", "TC_Mobile_021");
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objallowsharingenabledbar, "Allow Share Enabled")){
								extent.extentLoggerPass("", "Allow Share is Enabled");
							}else{
								extent.extentLoggerFail("", "Allow Share is not Enabled");	
							}
							
							
							extent.HeaderChildNode("Post Shooting Check if user is able to set privacy setting to allow[enable] Download");
							System.out.println("TC_Mobile_025");		extent.extentLogger("", "TC_Mobile_025");
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objallowvideodownloadenabledbar, "Allow Download Enabled")){
								extent.extentLoggerPass("", "Allow Download is Enabled");
							}else{
								extent.extentLoggerFail("", "Allow Download is not Enabled");	
							}

							click(HipiCreateVideoPage.objadvancedsettingsbutton, "Advanced Settings Link");
							
						}else{
							extent.extentLoggerFail("", "Advanced Settings is not Displayed");
						}
						
						//Scenario 07
						extent.HeaderChildNode("Post Shooting Check if user is able to set visibilty mode to public");
						System.out.println("TC_Mobile_007");		extent.extentLogger("", "TC_Mobile_007");
			
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objvisibilitymodebutton, "Set Visibility")){
							verifyElementPresentAndClick(HipiCreateVideoPage.objvisibilitymodebutton, "Set visibility");
							click(HipiCreateVideoPage.objvisibilitymodepublicbutton, "Public button");
							String visibilityMode = getAttributValue("text", HipiCreateVideoPage.objvisibilitymodebutton);
							if(visibilityMode.contains("Public")){
								extent.extentLoggerPass("", "Visibility is selected as Public");
							}else{
								extent.extentLoggerFail("", "Visibility is not selected as Public");
							}
							
						}else{
							
						}
			
			
						extent.HeaderChildNode("Post Shooting Check if user is unable to post video when user do not agrees to terms and condition");
						System.out.println("TC_Mobile_038");		extent.extentLogger("", "TC_Mobile_038");
						
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objcheckbox, "Terms and Conditions Checkbox")){
							
							verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");
							Thread.sleep(5000);
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objpopup, "Video Upload Popup")){
								extent.extentLoggerFail("", "Video uploaded without selected Terms and conditions CheckBox");
							}else{
								extent.extentLoggerPass("", "Video is not uploaded without selected Terms and conditions CheckBox");
							}
							
						}else{
							extent.extentLoggerWarning("", "Terms and Conditions Checkbox is not displayed");
						}
						
						
						extent.HeaderChildNode("Post Shooting Check if user is able to post video when user agrees to terms and condition");
						System.out.println("TC_Mobile_037");		extent.extentLogger("", "TC_Mobile_037");
						
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objcheckbox, "Terms and Conditions Checkbox")){
						
							verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox," 'By Continuing, you agree to our Terms & Privacy Policy' text ");
							
							verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");
							Thread.sleep(5000);
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objpopup, "Video Upload Popup")){
								extent.extentLoggerPass("", "Video uploaded without selected Terms and conditions CheckBox");
							}else{
								extent.extentLoggerFail("", "Video is not uploaded without selected Terms and conditions CheckBox");
							}
							
						}else{
							extent.extentLoggerWarning("", "Terms and Conditions Checkbox is not displayed");
						}
						
						
						
						
						
//						verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");// saveasdraft
//						waitTime(10000);
//
//						boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
//						if (Popup) {
//							extent.extentLoggerPass("Success", "Video Upload Popup is displayed ");
//							logger.info("Video Upload Popup is displayed ");
//						}else{
//							extent.extentLoggerFail("Success", "Video Upload Popup is not displayed ");
//							logger.info("Video Upload Popup is not displayed ");
//						}
						verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
						Thread.sleep(10000);

						verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
						for (int i = 0; i <= 50; i++) {
							scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
							if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
								Thread.sleep(2000);
								Back(1);
								Thread.sleep(2000);
								verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
							} else {
								verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), postDescription);
								click(HipiCreateVideoPage.objselectfirstimage, "First video");
								waitTime(8000);
								
								if(verifyIsElementDisplayed(HipiCreateVideoPage.objselectfirstimage, "Video")){
									click(HipiCreateVideoPage.objselectfirstimage, "First video");
									waitTime(8000);
								}else{
									
								}
								
								break;
							}
						}

						waitTime(10000);

						extent.extentLogger("", "Description Used : "+postDescription);
						if (verifyElementExist(HipiMePage.objVideoDescription, "Description")) {
							logger.info("user is able to create new video using Description");
							extent.extentLoggerPass("videoscreated", "user is able to create new video using Description");

							extent.HeaderChildNode("Post Shooting Check if user is able to upload video with description");
							System.out.println("TC_Mobile_001");		extent.extentLogger("", "TC_Mobile_001");
							
							String desc = getAttributValue("text", HipiMePage.objVideoDescription);
							extent.extentLogger("", "Video Desc : "+desc);
							extent.extentLogger("", "Desc sent: "+postDescription);
							if(desc.contains(postDescription)){
								extent.extentLoggerPass("", "Video contains the Description");
							}else{
								extent.extentLoggerFail("", "Video not contains the Description");
							}				
							
							
							extent.HeaderChildNode("Post Shooting Check if user is able to upload video without HashTag [Since Hashtag is optional field]");
							System.out.println("TC_Mobile_004");		extent.extentLogger("", "TC_Mobile_004");
							
							String desc1 = getAttributValue("text", HipiMePage.objVideoDescription);
							if(desc1.contains("#")){
								extent.extentLoggerFail("", "Video is created with Hashtag");
							}else{
								extent.extentLoggerPass("", "Video is created without Hashtag");
							}
							
							
							
							
						} else {
							extent.extentLoggerFail("", "user is not able to create new video using Description");
						}

					//	BackToFeedScreen();

					} else {
						System.out.println("Video is less than 5sec , so not selected");
					//	BackToFeedScreen();
					}

				}
				
				
			}else{
				extent.extentLoggerFail("", "Video recording screen is not displayed");
			}
			
			
			BackToFeedScreen();

			Back(1);
			
			waitTime(5000);
			logout();
			waitTime(5000);
			click(AMDHomePage.objMoreMenu, "More Menu");
			
			waitTime(2000);
			click(AMDOnboardingScreen.objLoginLink, "Login Link");
			String Username = getParameterFromXML("NewNonsubscribedUserNameDontUse");
			String Password = getParameterFromXML("NewNonsubscribedPasswordDontUse");

			Thread.sleep(5000);
			hideKeyboard();
			Thread.sleep(5000);
			click(AMDLoginScreen.objEmailIdField, "Email field");
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(9000);

			verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(5000);

			click(HipiFeedPage.objfollowinginfeed, "Following Option");
			
			verifyElementPresentAndClick(HipiCreateVideoPage.objMe, "Me icon");
			
			verifyElementPresentAndClick(HipiMePage.objfollowing, "following");
			
			verifyElementPresentAndClick(HipiMePage.objfollowingUser, "Following User");
			
			verifyElementPresentAndClick(HipiCreateVideoPage.objselectfirstimage, "First video");
			
						
						Thread.sleep(10000);
						
						
						
						extent.HeaderChildNode("Post Shooting Verify if the posted video is visible to any logged in user");
						System.out.println("TC_Mobile_008");		extent.extentLogger("", "TC_Mobile_008");
						
						String desc1 = getAttributValue("text", HipiMePage.objVideoDescription);
						if(desc1.contains(PublicVideoDescription)){
							extent.extentLoggerPass("", "Video contains the Description");
						}else{
							extent.extentLoggerFail("", "Video not contains the Description");
						}
						
						
		
						
						
						
			extent.HeaderChildNode("Post Shooting Verify if another user is able to Download video");
			System.out.println("TC_Mobile_026");		extent.extentLogger("", "TC_Mobile_026");
			
			Thread.sleep(5000);
			longPress(HipiFeedPage.objFeedLongPress);
			
			if (verifyElementExist(HipiFeedPage.objdownloadvideo,"Download Video")) {
				logger.info("user is able to view download video ");
				extent.extentLoggerPass("", "user is able to view download video");
				verifyElementPresentAndClick(HipiFeedPage.objdownloadvideo,"Download Video");
				
//				WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//				wait.until(ExpectedConditions.visibilityOfElementLocated(HipiFeedPage.objVideoSavedPopup));
				verifyElementExist(HipiFeedPage.objVideoSavedPopup, "Video Saved");
				
			} else {
				logger.info("user is not able to view download video ");
				extent.extentLoggerFail("", "user is not able to view download video");
			}
			
			
			extent.HeaderChildNode("Post Shooting Verify if another user is able to Share video");
			System.out.println("TC_Mobile_022");		extent.extentLogger("", "TC_Mobile_022");
			waitTime(6000);
			if(verifyIsElementDisplayed(HipiMePage.objEnabledShareIcon, "Share button")){
				extent.extentLoggerPass("", "Share button is displayed");
				
				click(HipiMePage.objEnabledShareIcon, "Share button");
				
				if(verifyIsElementDisplayed(HipiMePage.objShareHipiVideoPopup, "HipiVideo")){
					verifyElementPresentAndClick(AMDPlayerScreen.objFacebook, "Facebook option");
					waitTime(15000);
					verifyElementPresentAndClick(AMDPlayerScreen.objFacebookPost, "Post/Share button");
					waitTime(10000);
				}else{
					extent.extentLogger("", "SharePopup not displayed");
					Back(1);
				}
				
			}else{
				extent.extentLoggerFail("", "Share button is not displayed");
			}
			
			BackToFeedScreen();

			Back(1);
			
			logout();
			waitTime(5000);
			click(AMDHomePage.objMoreMenu, "More Menu");
			
			waitTime(2000);
			click(AMDOnboardingScreen.objLoginLink, "Login Link");
			String Username1 = getParameterFromXML("NonsubscribedUserName");
			String Password1 = getParameterFromXML("NonsubscribedPassword");

			Thread.sleep(5000);
			hideKeyboard();
			Thread.sleep(5000);
			click(AMDLoginScreen.objEmailIdField, "Email field");
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, Username1, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password1, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(9000);

			verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(5000);
			
			
			
			
			//DISABLE ADVANCEDSETTINGS
			
			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			waitTime(5000);

			if (verifyIsElementDisplayed(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
				// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
				// on create a video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow button");
				
				// waitTime(15000);
				waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
				Thread.sleep(3000);
				verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
				verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
				waitTime(20000);
				
			}


			
			
			if (verifyElementExist(HipiCreateVideoPage.objrecordbtn, "Record Button")) {
				extent.extentLoggerPass("", "Video recording screen is displayed");
				
				verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload video");
				
				if (verifyElementExist(HipiCreateVideoPage.objselectFirstimage, "Video present")) {
					verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "Video present");

					verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, "Edit HipiIT");
					Thread.sleep(5000);
					if (verifyElementExist(HipiCreateVideoPage.objtrimfinish, "finish")) {

						verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, "finish");

						verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
						waitTime(15000);
						waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
						
						extent.HeaderChildNode("Post Shooting Check if user is able to view existing/new hashtag along with suggestion and its view");
						System.out.println("TC_Mobile_005");		extent.extentLogger("", "TC_Mobile_005");
						
						
						verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
						String randomHashtag = "#"+GeneratingRandomString(7);
						type(HipiCreateVideoPage.objPostDescription, randomHashtag, "Random Hashtag");
						waitTime(3000);
						hideKeyboard();
						waitTime(3000);
						
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objTrendingHashtag(randomHashtag), randomHashtag)){
							extent.extentLoggerWarning("", "Trending Hashtag contain new hashtag suggestion");
						}else{
							extent.extentLoggerPass("", "Trending Hashtag is not having new Hashtag as suggestion");
						}
						
						
						verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
						clearField(HipiCreateVideoPage.objPostDescription, "Description");
						
						verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
						
						String Hashtag = "#hipi";
						
						type(HipiCreateVideoPage.objPostDescription, Hashtag, "Hashtag");
						waitTime(3000);
						hideKeyboard();
						waitTime(3000);
						
						String trendingHashtag = getAttributValue("text", HipiCreateVideoPage.objTrendingHashtagFromList);
						FollowersOnlyVideoDescription = trendingHashtag;
						for(int i=1; i<=20; i++){
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objTrendingHashtag(trendingHashtag), trendingHashtag)){
								extent.extentLoggerPass("", "Trending Hashtag is having Hashtag as suggestion");
								click(HipiCreateVideoPage.objTrendingHashtag(trendingHashtag), trendingHashtag);
								break;
							}else{
								PartialSwipe("UP", 1);
							}
							
							if(i==20){
								extent.extentLoggerFail("", "Trending Hashtag is not having Hashtag as suggestion");
							}
							
						}
						
					
						verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
						verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
						
						
						
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objadvancedsettingsbutton, "Advanced Settings")){
							extent.extentLoggerPass("", "Advanced Settings is Displayed");
							
							click(HipiCreateVideoPage.objadvancedsettingsbutton, "Advanced Settings Link");
							
							extent.HeaderChildNode("Post Shooting Check if user is able to set privacy setting to allow/[disable] comments");
							System.out.println("TC_Mobile_015");		extent.extentLogger("", "TC_Mobile_015");
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objallowcommentsenabledbar, "Allow Comment Enabled")){
								extent.extentLoggerPass("", "Allow Comment is Enabled");
								verifyElementPresentAndClick(HipiCreateVideoPage.objallowcommentsenabledbar, "Allow Comment Enabled");
							}else{
								extent.extentLoggerFail("", "Allow Comment is not Enabled");	
							}
							
							extent.HeaderChildNode("Post Shooting Check if user is able to set privacy setting to allow[disable] Like");
							System.out.println("TC_Mobile_019");		extent.extentLogger("", "TC_Mobile_019");
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objallowlikedislikeenabledbar, "Allow Like Enabled")){
								extent.extentLoggerPass("", "Allow Like is Enabled");
								verifyElementPresentAndClick(HipiCreateVideoPage.objallowlikedislikeenabledbar, "Allow Like Enabled");
							}else{
								extent.extentLoggerFail("", "Allow Like is not Enabled");	
							}
							
							
							extent.HeaderChildNode("Post Shooting Check if user is able to set privacy setting to allow[disable] Share");
							System.out.println("TC_Mobile_023");		extent.extentLogger("", "TC_Mobile_023");
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objallowsharingenabledbar, "Allow Share Enabled")){
								extent.extentLoggerPass("", "Allow Share is Enabled");
								verifyElementPresentAndClick(HipiCreateVideoPage.objallowsharingenabledbar, "Allow Share Enabled");
							}else{
								extent.extentLoggerFail("", "Allow Share is not Enabled");	
							}
							
							
							extent.HeaderChildNode("Post Shooting Check if user is able to set privacy setting to allow[disable] Download");
							System.out.println("TC_Mobile_027");		extent.extentLogger("", "TC_Mobile_027");
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objallowvideodownloadenabledbar, "Allow Download Enabled")){
								extent.extentLoggerPass("", "Allow Download is Enabled");
								verifyElementPresentAndClick(HipiCreateVideoPage.objallowvideodownloadenabledbar, "Allow Download Enabled");
							}else{
								extent.extentLoggerFail("", "Allow Download is not Enabled");	
							}

							click(HipiCreateVideoPage.objadvancedsettingsbutton, "Advanced Settings Link");
							
						}else{
							extent.extentLoggerFail("", "Advanced Settings is not Displayed");
						}
						
						
						
						//Scenario 09
						extent.HeaderChildNode("Post Shooting Check if user is able to set visibilty mode to followers only");
						System.out.println("TC_Mobile_009");		extent.extentLogger("", "TC_Mobile_009");
			
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objvisibilitymodebutton, "Set Visibility")){
							verifyElementPresentAndClick(HipiCreateVideoPage.objvisibilitymodebutton, "Set visibility");
							click(HipiCreateVideoPage.objvisibilitymodefolloweronlybutton, "FollowersOnly button");
							String visibilityMode = getAttributValue("text", HipiCreateVideoPage.objvisibilitymodebutton);
							if(visibilityMode.contains("Followers-Only")){
								extent.extentLoggerPass("", "Visibility is selected as Followers-Only");
							}else{
								extent.extentLoggerFail("", "Visibility is not selected as Followers-Only");
							}
							
						}else{
							
						}
						
						
						
						
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objcheckbox, "Terms and Conditions Checkbox")){
						
							verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox," 'By Continuing, you agree to our Terms & Privacy Policy' text ");
							
							verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");
							Thread.sleep(5000);
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objpopup, "Video Upload Popup")){
								extent.extentLoggerPass("", "Video uploaded without selected Terms and conditions CheckBox");
							}else{
								extent.extentLoggerFail("", "Video is not uploaded without selected Terms and conditions CheckBox");
							}
							
						}else{
							extent.extentLoggerWarning("", "Terms and Conditions Checkbox is not displayed");
						}
						
						
						
						
						
//						verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");// saveasdraft
//						waitTime(10000);
//
//						boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
//						if (Popup) {
//							extent.extentLoggerPass("Success", "Video Upload Popup is displayed ");
//							logger.info("Video Upload Popup is displayed ");
//						}else{
//							extent.extentLoggerFail("Success", "Video Upload Popup is not displayed ");
//							logger.info("Video Upload Popup is not displayed ");
//						}
						verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
						Thread.sleep(10000);

						verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
						for (int i = 0; i <= 50; i++) {
							scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
							if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
								Thread.sleep(2000);
								Back(1);
								Thread.sleep(2000);
								verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
							} else {
								verifyElementExist(HipiCreateVideoPage.objSelectVideo(trendingHashtag), "Video");
								click(HipiCreateVideoPage.objselectfirstimage, "First video");
								waitTime(8000);
								
								if(verifyIsElementDisplayed(HipiCreateVideoPage.objselectfirstimage, "Video")){
									click(HipiCreateVideoPage.objselectfirstimage, "First video");
									waitTime(8000);
								}else{
									
								}
								
								break;
							}
						}

						waitTime(8000);

						extent.extentLogger("", "Hashtag Used : "+trendingHashtag);
						if (verifyIsElementDisplayed(HipiMePage.objVideoDescription, "Description")) {
							logger.info("user is able to create new video using Description");
							extent.extentLoggerPass("videoscreated", "user is able to create new video using Description");

							extent.HeaderChildNode("Post Shooting Check if user is able to upload video with HashTag");
							System.out.println("TC_Mobile_003");		extent.extentLogger("", "TC_Mobile_003");
							
							String desc = getAttributValue("text", HipiMePage.objVideoDescription);
							if(desc.contains(trendingHashtag)){
								extent.extentLoggerPass("", "Video contains the Hashtag");
							}else{
								extent.extentLoggerFail("", "Video not contains the Hashtag");
							}
							
							
							String desc2 = getAttributValue("text", HipiMePage.objVideoDescription);
							if(desc2.contains("#")){
								extent.extentLoggerPass("", "Video is created with Hashtag");
							}else{
								extent.extentLoggerFail("", "Video is created without Hashtag");
							}
							
							
							
							
						} else {
							extent.extentLoggerFail("", "user is not able to create new video using Description");
						}

					//	BackToFeedScreen();

					} else {
						System.out.println("Video is less than 5sec , so not selected");
					//	BackToFeedScreen();
					}

				}
				
				
			}else{
				extent.extentLoggerFail("", "Video recording screen is not displayed");
			}
			
			
			BackToFeedScreen();

			Back(1);
			
			waitTime(5000);
			logout();
			waitTime(5000);
			click(AMDHomePage.objMoreMenu, "More Menu");
			
			waitTime(2000);
			click(AMDOnboardingScreen.objLoginLink, "Login Link");
			String Username2 = getParameterFromXML("NewNonsubscribedUserNameDontUse");
			String Password2 = getParameterFromXML("NewNonsubscribedPasswordDontUse");

			Thread.sleep(5000);
			hideKeyboard();
			Thread.sleep(5000);
			click(AMDLoginScreen.objEmailIdField, "Email field");
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, Username2, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password2, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(9000);

			verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(5000);

			click(HipiFeedPage.objfollowinginfeed, "Following Option");
			
			verifyElementPresentAndClick(HipiCreateVideoPage.objMe, "Me icon");
			
			verifyElementPresentAndClick(HipiMePage.objfollowing, "following");
			
			verifyElementPresentAndClick(HipiMePage.objfollowingUser, "Following User");
			
			extent.HeaderChildNode("Post Shooting Verify if the post is visible to only follower user , but not to others");
			System.out.println("TC_Mobile_010");		extent.extentLogger("", "TC_Mobile_010");
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objVideo(FollowersOnlyVideoDescription), FollowersOnlyVideoDescription)){
				extent.extentLoggerPass("", "Following user is able to see the video published as only followers-Only");
			}else{
				extent.extentLoggerFail("", "Following user is not able to see the video published as only followers-Only");			
			}
			
			verifyElementPresentAndClick(HipiCreateVideoPage.objselectfirstimage, "First video");
			
			extent.HeaderChildNode("Post Shooting Verify if another user is unable to comment on video");
			System.out.println("TC_Mobile_016");		extent.extentLogger("", "TC_Mobile_016");
			
			if(verifyIsElementDisplayed(HipiMePage.objDisabledCommentIcon, "Disabled Comment Button")){
				extent.extentLoggerPass("", "Comment button is Disabled");
			}else{
				extent.extentLoggerFail("", "Comment button is not Disabled");				
			}
			
			
			extent.HeaderChildNode("Post Shooting Verify if another user is unable to Like video");
			System.out.println("TC_Mobile_020");		extent.extentLogger("", "TC_Mobile_020");
			
			if(verifyIsElementDisplayed(HipiMePage.objDisabledLikeIcon, "Disabled Like Button")){
				extent.extentLoggerPass("", "Like button is Disabled");
			}else{
				extent.extentLoggerFail("", "Like button is not Disabled");				
			}

			
			extent.HeaderChildNode("Post Shooting Verify if another user is unable to Share video");
			System.out.println("TC_Mobile_024");		extent.extentLogger("", "TC_Mobile_024");
			
			if(verifyIsElementDisplayed(HipiMePage.objDisabledShareIcon, "Disabled Share Button")){
				extent.extentLoggerPass("", "Share button is Disabled");
			}else{
				extent.extentLoggerFail("", "Share button is not Disabled");				
			}

			
			extent.HeaderChildNode("Post Shooting Verify if another user is unable to Download video");
			System.out.println("TC_Mobile_028");		extent.extentLogger("", "TC_Mobile_028");
			
			Thread.sleep(5000);
			longPress(HipiFeedPage.objFeedLongPress);
			
			if (verifyIsElementDisplayed(HipiFeedPage.objdownloadvideo,"Download Video")) {
				
				extent.extentLoggerFail("", "Download Video is present");				
			} else {
				extent.extentLoggerPass("", "Download Video is not present");
			}
			
			
			BackToFeedScreen();

			Back(1);
			
			logout();
			waitTime(5000);
			click(AMDHomePage.objMoreMenu, "More Menu");
			
			waitTime(2000);
			click(AMDOnboardingScreen.objLoginLink, "Login Link");
			String Username3 = getParameterFromXML("NonsubscribedUserName");
			String Password3 = getParameterFromXML("NonsubscribedPassword");

			Thread.sleep(5000);
			hideKeyboard();
			Thread.sleep(5000);
			click(AMDLoginScreen.objEmailIdField, "Email field");
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, Username3, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password3, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(9000);

			verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(5000);
			
			
			
			
			//Private Mode
			
			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			waitTime(5000);

			if (verifyIsElementDisplayed(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
				// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
				// on create a video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow button");
				
				// waitTime(15000);
				waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
				Thread.sleep(3000);
				verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
				verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
				waitTime(20000);
				
			}


			
			
			if (verifyElementExist(HipiCreateVideoPage.objrecordbtn, "Record Button")) {
				extent.extentLoggerPass("", "Video recording screen is displayed");
				
				verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload video");
				
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
						String postDescription = "Desc"+GeneratingRandomString(7);
						PrivateVideoDescription = postDescription;
						type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
						waitTime(3000);
						hideKeyboard();
						waitTime(3000);
						
						verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
						verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");				
						
						//Scenario 011
						extent.HeaderChildNode("Post Shooting Check if user is able to set visibilty mode to private");
						System.out.println("TC_Mobile_011");		extent.extentLogger("", "TC_Mobile_011");
			
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objvisibilitymodebutton, "Set Visibility")){
							verifyElementPresentAndClick(HipiCreateVideoPage.objvisibilitymodebutton, "Set visibility");
							click(HipiCreateVideoPage.objvisibilitymodemebutton, "Me button");
							String visibilityMode = getAttributValue("text", HipiCreateVideoPage.objvisibilitymodebutton);
							if(visibilityMode.contains("Me")){
								extent.extentLoggerPass("", "Visibility is selected as Private");
							}else{
								extent.extentLoggerFail("", "Visibility is not selected as Private");
							}
							
						}else{
							
						}
			

						if(verifyIsElementDisplayed(HipiCreateVideoPage.objcheckbox, "Terms and Conditions Checkbox")){
						
							verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox," 'By Continuing, you agree to our Terms & Privacy Policy' text ");
							
							verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");
							Thread.sleep(5000);
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objpopup, "Video Upload Popup")){
								extent.extentLoggerPass("", "Video uploaded without selected Terms and conditions CheckBox");
							}else{
								extent.extentLoggerFail("", "Video is not uploaded without selected Terms and conditions CheckBox");
							}
							
						}else{
							extent.extentLoggerWarning("", "Terms and Conditions Checkbox is not displayed");
						}
						
						
						verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
						Thread.sleep(10000);

						verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
						profileID = getAttributValue("text", HipiMePage.objHipiProfileId);
						profileText = getAttributValue("text", HipiMePage.objHipiProfileName);
						for (int i = 0; i <= 50; i++) {
							scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
							if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
								Thread.sleep(2000);
								Back(1);
								Thread.sleep(2000);
								verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
							} else {
								verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), postDescription);
								click(HipiCreateVideoPage.objselectfirstimage, "First video");
								waitTime(8000);
								
								if(verifyIsElementDisplayed(HipiCreateVideoPage.objselectfirstimage, "Video")){
									click(HipiCreateVideoPage.objselectfirstimage, "First video");
									waitTime(8000);
								}else{
									
								}
								
								break;
							}
						}

						waitTime(5000);

						extent.extentLogger("", "Description Used : "+postDescription);
						if (verifyElementExist(HipiMePage.objVideoDescription, "Description")) {
							logger.info("user is able to create new video using Description");
							extent.extentLoggerPass("videoscreated", "user is able to create new video using Description");

						} else {
							extent.extentLoggerFail("", "user is not able to create new video using Description");
						}

					//	BackToFeedScreen();

					} else {
						System.out.println("Video is less than 5sec , so not selected");
					//	BackToFeedScreen();
					}

				}
				
				
			}else{
				extent.extentLoggerFail("", "Video recording screen is not displayed");
			}
			
			
			BackToFeedScreen();

			Back(1);
			
			waitTime(5000);
			logout();
			waitTime(5000);
			click(AMDHomePage.objMoreMenu, "More Menu");
			
			waitTime(2000);
			click(AMDOnboardingScreen.objLoginLink, "Login Link");
			String Username4 = getParameterFromXML("NewNonsubscribedUserName");
			String Password4 = getParameterFromXML("NewNonsubscribedPassword");

			Thread.sleep(5000);
			hideKeyboard();
			Thread.sleep(5000);
			click(AMDLoginScreen.objEmailIdField, "Email field");
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, Username4, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password4, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(9000);

			verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(5000);
			
			verifyElementPresentAndClick(HipiDiscoverPage.objDiscoverOption, "Discover button");
			
			verifyElementPresentAndClick(HipiDiscoverPage.objSearchButton,"Search Icon");
			
			type(HipiDiscoverPage.objSearchButton, profileText, "SearchText");
			hideKeyboard();
			Thread.sleep(5000);
			if(verifyIsElementDisplayed(HipiMePage.objSearchedUser(profileText))){
				extent.extentLogger("", "Searched user is displayed");
				
				click(HipiMePage.objSearchedUser(profileText),profileText);
				
				scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
				
				//Scenario 011
				extent.HeaderChildNode("Post Shooting Verify if the posted video is visible to creator only , but not to others");
				System.out.println("TC_Mobile_012");		extent.extentLogger("", "TC_Mobile_012");
				
				if(verifyIsElementDisplayed(HipiCreateVideoPage.objSelectVideo(PrivateVideoDescription), PrivateVideoDescription)){
					extent.extentLoggerFail("", "Private mode video is visible for unfollwed user");
				}else{
					extent.extentLoggerPass("", "Private mode video is not visible for unfollwed user");
				}
				
			}else{
				extent.extentLogger("", "Searched user not displayed");
			}
			
			
			BackToFeedScreen();

			Back(1);
			
			logout();
			waitTime(5000);
			click(AMDHomePage.objMoreMenu, "More Menu");
			
			waitTime(2000);
			click(AMDOnboardingScreen.objLoginLink, "Login Link");
			String Username5 = getParameterFromXML("NonsubscribedUserName");
			String Password5 = getParameterFromXML("NonsubscribedPassword");

			Thread.sleep(5000);
			hideKeyboard();
			Thread.sleep(5000);
			click(AMDLoginScreen.objEmailIdField, "Email field");
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, Username5, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password5, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(9000);

			verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(5000);
			
			
			//Without Description
			extent.HeaderChildNode("Post Shooting Check if user is able to upload video without description [Since description is optional field]");
			System.out.println("TC_Mobile_002");		extent.extentLogger("", "TC_Mobile_002");
			
			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			waitTime(5000);

			if (verifyIsElementDisplayed(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
				// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
				// on create a video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow button");
				
				// waitTime(15000);
				waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
				Thread.sleep(3000);
				verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
				verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
				waitTime(20000);
				
			}

			if (verifyElementExist(HipiCreateVideoPage.objrecordbtn, "Record Button")) {
				extent.extentLoggerPass("", "Video recording screen is displayed");
				
				verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload video");
				
				if (verifyElementExist(HipiCreateVideoPage.objselectFirstimage, "Video present")) {
					verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "Video present");

					verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, "Edit HipiIT");
					Thread.sleep(5000);
					if (verifyElementExist(HipiCreateVideoPage.objtrimfinish, "finish")) {

						verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, "finish");

						verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
						waitTime(15000);
						waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
						
						waitTime(3000);
						hideKeyboard();
						waitTime(3000);
						
						verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
						verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");				

						if(verifyIsElementDisplayed(HipiCreateVideoPage.objcheckbox, "Terms and Conditions Checkbox")){
						
							verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox," 'By Continuing, you agree to our Terms & Privacy Policy' text ");
							
							verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");
							Thread.sleep(5000);
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objpopup, "Video Upload Popup")){
								extent.extentLoggerPass("", "Video uploaded without selected Terms and conditions CheckBox");
							}else{
								extent.extentLoggerFail("", "Video is not uploaded without selected Terms and conditions CheckBox");
							}
							
						}else{
							extent.extentLoggerWarning("", "Terms and Conditions Checkbox is not displayed");
						}
						
						
						verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
						Thread.sleep(10000);

						verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
						for (int i = 0; i <= 50; i++) {
							scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
							if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
								Thread.sleep(2000);
								Back(1);
								Thread.sleep(2000);
								verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
							} else {
								
								if(verifyElementExist(HipiCreateVideoPage.objPublishedVideo, "Video without Description")){
								
									String descriptionText = getText(HipiCreateVideoPage.objPublishedVideo);
									if(descriptionText.length()>0){
										extent.extentLoggerFail("", "Video is not created without description");										
									}else{
										extent.extentLoggerPass("", "Video is created without description");
									}

								} else {

								}
								waitTime(8000);
								break;
							}
						}

						waitTime(5000);

			
					}
				}
			}
			
			BackToFeedScreen();
			
			
			//SaveASDraft
			extent.HeaderChildNode("Post Shooting Check if user is able to save video as draft for upload");
			System.out.println("TC_Mobile_029");		extent.extentLogger("", "TC_Mobile_029");
			
			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			waitTime(5000);

			if (verifyIsElementDisplayed(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
				// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
				// on create a video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow button");
				
				// waitTime(15000);
				waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
				Thread.sleep(3000);
				verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
				verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
				waitTime(20000);
				
			}

			if (verifyElementExist(HipiCreateVideoPage.objrecordbtn, "Record Button")) {
				extent.extentLoggerPass("", "Video recording screen is displayed");
				
				verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload video");
				
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
						String draftPostDescription = "Desc"+GeneratingRandomString(7);
						PrivateVideoDescription = draftPostDescription;
						type(HipiCreateVideoPage.objPostDescription, draftPostDescription, "Description");
						
						waitTime(3000);
						hideKeyboard();
						waitTime(3000);
						
						verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
						//verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");				

						if(verifyIsElementDisplayed(HipiCreateVideoPage.objcheckbox, "Terms and Conditions Checkbox")){
						
							verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox," 'By Continuing, you agree to our Terms & Privacy Policy' text ");
							Thread.sleep(5000);
							verifyElementPresentAndClick(HipiCreateVideoPage.objsaveasdraft, "SaveAsDraft");
							Thread.sleep(5000);
							
												
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objpopup, "Save In Draft Popup")){
								extent.extentLoggerPass("", "Save As Draft PopUp Displayed");
							}else{
								extent.extentLoggerFail("", "Save As Draft PopUp not Displayed");
							}
							
						}else{
							extent.extentLoggerWarning("", "Terms and Conditions Checkbox is not displayed");
						}
						
						
						verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
						Thread.sleep(10000);
						
						verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");

						verifyElementPresentAndClick(HipiCreateVideoPage.objDraftTab, "Draft Tab");
						
						//scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
						
						extent.HeaderChildNode("Post Shooting Verify the video saved as draft is displayed in profile/account detail screen");
						System.out.println("TC_Mobile_030");		extent.extentLogger("", "TC_Mobile_030");
						
						if(verifyIsElementDisplayed(HipiMePage.objUploadAllButton, "Upload All button")){
							scrolltomiddle(HipiMePage.objUploadAllButton);
						}else{
							
						}
						
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objselectfirstimage, "First video")){
							scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
						}else{
							
						}
						
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objSelectDraftVideo(draftPostDescription), draftPostDescription)){
							extent.extentLoggerPass("", "Video is saved in Draft section");
							
							extent.HeaderChildNode("Post Shooting Check if user is drafted video is not deleted when tapped on No");
							System.out.println("TC_Mobile_035");		extent.extentLogger("", "TC_Mobile_035");
							
							verifyElementPresentAndClick(HipiMePage.objdraftvideopostpagemoreoptionbtn, "More option button");
							verifyElementPresentAndClick(HipiMePage.objdraftvideopostpageremovebtn, "Remove Button");
							
							if(verifyIsElementDisplayed(HipiMePage.objdraftvideopostpagedeletedialog, "Remove Popup")){
								extent.extentLoggerPass("", "Remove Popup is displayed");
								click(HipiMePage.objdraftvideopostpagecancelbtn, "Cancel Button");
							}else{
								extent.extentLoggerFail("", "Remove Popup is not displayed");
							}
							
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objSelectDraftVideo(draftPostDescription),draftPostDescription)){
								extent.extentLoggerPass("", "Video is not deleted");
							}else{
								extent.extentLoggerFail("", "Video is deleted");
							}
							
							
							extent.HeaderChildNode("Post Shooting Check if user is redirected to Account detail screen when tapped on back");
							System.out.println("TC_Mobile_036");		extent.extentLogger("", "TC_Mobile_036");
							
							verifyElementPresentAndClick(HipiCreateVideoPage.objSelectDraftVideo(draftPostDescription),"Draft video");
							
							if(verifyElementExist(HipiCreateVideoPage.objPostHipiTPageHeader, "PostHipi Title")){
								extent.extentLoggerPass("", "Navigated to Video Edit Screen");
								Back(1);
								
								if(verifyElementExist(HipiCreateVideoPage.objSelectDraftVideo(draftPostDescription), "Draft video")){
									extent.extentLoggerPass("", "Navigated to Account Page");
								}else{
									extent.extentLoggerFail("", "Not Navigated to Account Page");									
								}
								
							}else{
								extent.extentLoggerFail("", "Not Navigated to Video Edit Screen");								
							}
							
							
							extent.HeaderChildNode("Post Shooting Check if user is able to delete a selected video saved in draft");
							System.out.println("TC_Mobile_034");		extent.extentLogger("", "TC_Mobile_034");

							verifyElementPresentAndClick(HipiMePage.objdraftvideopostpagemoreoptionbtn, "More option button");
							verifyElementPresentAndClick(HipiMePage.objdraftvideopostpageremovebtn, "Remove Button");
							
							if(verifyIsElementDisplayed(HipiMePage.objdraftvideopostpagedeletedialog, "Remove Popup")){
								extent.extentLoggerPass("", "Remove Popup is displayed");
								click(HipiMePage.objdraftvideopostpageokbtn, "Ok Button");
							}else{
								extent.extentLoggerFail("", "Remove Popup is not displayed");
							}
							Thread.sleep(10000);
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objSelectDraftVideo(draftPostDescription),draftPostDescription)){
								extent.extentLoggerFail("", "Video is not deleted");
							}else{
								extent.extentLoggerPass("", "Video is deleted");
							}
							
							
							extent.HeaderChildNode("Post Shooting Check if user is able to resume video from draft list of logged in user for upload");
							System.out.println("TC_Mobile_031");		extent.extentLogger("", "TC_Mobile_031");
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objselectfirstimage, "First Image")){
								click(HipiCreateVideoPage.objselectfirstimage, "First Image");
								waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
								verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
								clearField(HipiCreateVideoPage.objPostDescription, "Description");
								
								verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
								
								String DraftDescription = "Desc"+GeneratingRandomString(7);
								type(HipiCreateVideoPage.objPostDescription, DraftDescription, "Description");
								hideKeyboard();
								
								verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "postHiPi");
								Thread.sleep(5000);
								
								if(verifyIsElementDisplayed(HipiCreateVideoPage.objpopup, "Video Upload Popup")){
									extent.extentLoggerPass("", "Video is uploaded");
								}else{
									extent.extentLoggerFail("", "Video is not uploaded");
								}
								
								
								verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Go To Feed button");
								Thread.sleep(10000);

								verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
								for (int i = 0; i <= 50; i++) {
									scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
									if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
										Thread.sleep(2000);
										Back(1);
										Thread.sleep(2000);
										verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
									} else {
										
										if(verifyElementExist(HipiCreateVideoPage.objPublishedVideo, "video")){
										
											String descriptionText = getText(HipiCreateVideoPage.objPublishedVideo);
											extent.extentLogger("", "DraftDescription : "+DraftDescription);
											extent.extentLogger("", "Draft video uploded Description : "+descriptionText);
											if(descriptionText.equalsIgnoreCase(DraftDescription)){
												extent.extentLoggerPass("", "Draft video is published");										
											}else{
												extent.extentLoggerFail("", "Draft video is not published");
											}

										} else {

										}
										waitTime(8000);
										break;
									}
								}
								
								
							}else{
								
							}

						}else{
							extent.extentLoggerFail("", "Video is not saved in Draft section");							
						}
					}
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
	
	
	
	
	
	
	
	public void checkElementPosition(By byLocator,String position,String objectName) throws Exception{

		String elePositionOnScreen;
		Dimension windowsSize = getDriver().manage().window().getSize();
		int ScreenCenter = windowsSize.height / 2;
		//System.out.println("Screen Center : "+ScreenCenter);
		
		WebElement ele = findElement(byLocator);
		int elePosition = ele.getLocation().getY();
		//System.out.println("ElementPosition: "+elePosition);
		
		if (elePosition < ScreenCenter){
			elePositionOnScreen = "Top";
		}else{
			elePositionOnScreen = "Down";
		}
		
		if(elePositionOnScreen.equalsIgnoreCase(position)){
			logger.info(objectName +" is at "+ position +" Position");
			extent.extentLoggerPass("", objectName +" is at "+ position +" Position");
		}else{
			logger.info(objectName +" is not at "+ position +" Position");
			extent.extentLoggerFail("", objectName +" is not at "+ position +" Position");
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-------------------------------------Hipi HomeScreen--------------------------------------------
	

	public void hipiHomeScreenValidation(String userType) throws Exception {
		extent.HeaderChildNode("Home Screen Validation");
		
		verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
		waitTime(5000);
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Home Screen Check if user is able view HiPi Landing screen [without logged in user]");
			
			logger.info("TC_Mobile_01"); 		
			extent.extentLogger("", "TC_Mobile_01");
			
			if (verifyIsElementDisplayed(HipiFeedPage.objfeed, "HiPi Feed")) {
				logger.info("User is able to view HiPi Landing screen without logging in");
				extent.extentLogger("HiPi Landing screen",
						"User is able to view HiPi Landing screen without logging in");
			} else {
				logger.error("User is not able to view HiPi Landing screen without logging in");
				extent.extentLoggerFail("HiPi Landing screen",
						"User is not able to view HiPi Landing screen without logging in");
			}
		}
		
		if (!(userType.equalsIgnoreCase("Guest"))) {
			logger.info("TC_Mobile_02"); 		
			extent.extentLogger("", "TC_Mobile_02");
			extent.HeaderChildNode("Home Screen Check if user is able view HiPi Landing screen [with logged in user]");

			if (verifyIsElementDisplayed(HipiFeedPage.objfeed, "HiPi Feed")) {
				logger.info("User is able to view HiPi Landing screen with logged in user");
				extent.extentLogger("HiPi Landing screen",
						"User is able to view HiPi Landing screen with logged in user");
			} else {
				logger.error("User is not able to view HiPi Landing screen with logged in user");
				extent.extentLoggerFail("HiPi Landing screen",
						"User is not able to view HiPi Landing screen with logged in user");
			}
		}
		
		extent.HeaderChildNode("Home Screen Check if user is able view HiPi Landing screen [with logged in user] and [without logged in user]");

		logger.info("TC_Mobile_03 and TC_Mobile_04"); 		
		extent.extentLogger("", "TC_Mobile_03 and TC_Mobile_04");
		verifyElementPresent(HipiFeedPage.objbackviewinfeed, "Back Icon");

		extent.HeaderChildNode("Home Screen Verify user must redirect to same old Zee5 screen from which user was entered into Hipi");
		logger.info("TC_Mobile_07"); 		
		extent.extentLogger("", "TC_Mobile_07");
		

		click(HipiFeedPage.objbackviewinfeed, "Back Icon");
		Thread.sleep(3000);
		
		if (verifyIsElementDisplayed(AMDHipi.objHipiIcon, "Hipi icon")) {
			logger.info("User is redirected to the same page on Zee5 when tapped on Navigation key of Feed screen");
			extent.extentLoggerPass("Back",
					"User is redirected to the same page on Zee5 when tapped on Navigation key of Feed screen");
		} else {
			logger.error("User is not redirected to the same page on Zee5 when tapped on Navigation key of Feed screen");
			extent.extentLoggerFail("Back",
					"User is not redirected to the same page on Zee5 when tapped on Navigation key of Feed screen");
		}
		
		waitTime(3000);
		click(AMDOnboardingScreen.objHipiButton, "HiPi");
		waitTime(3000);
		verifyElementPresent(HipiFeedPage.objfollowinginfeed, "Following Option");
		verifyElementPresent(HipiFeedPage.objforyou, "For You Option");
		
		extent.HeaderChildNode("Home Screen Verify HiPi default home screen and the options present in bottom [with logged in user] and [without logged in user]");

		logger.info("TC_Mobile_05 and TC_Mobile_06"); 		
		extent.extentLogger("", "TC_Mobile_05 and TC_Mobile_06");
		
		
		verifyElementPresent(HipiDiscoverPage.objDiscoverOption, "Discover/Search Icon");
		verifyElementPresent(HipiFeedPage.objfeed, "Feed/Player Icon");
		verifyElementPresent(HipiFeedPage.objPopularImage, "Popular/Star Icon");
		verifyElementPresent(HipiFeedPage.objMeImage, "Me/Person Icon");
		verifyElementPresent(HipiCreateVideoPage.objcreatevideo, "Plus/+ Icon");
		
		extent.HeaderChildNode("Home Screen Check if user is able to see the list of actionable items on a video[with logged in user] and [without logged in user]");

		logger.info("TC_Mobile_18 and TC_Mobile_19"); 		
		extent.extentLogger("", "TC_Mobile_18 and TC_Mobile_19");
	
		verifyElementPresent(HipiFeedPage.objprofilepic, "Profile Picture");
		verifyElementPresent(HipiFeedPage.objdescription, "User Handle Text Link");
		verifyElementPresent(HipiFeedPage.objshare, "Share Icon");
		verifyElementPresent(HipiFeedPage.objLikeIcon, "Like/Heart Icon");
		verifyElementPresent(HipiFeedPage.objlikecount, "Like Count");
		verifyElementPresent(HipiFeedPage.objcommenticon, "Comment/Chat Icon");
		verifyElementPresent(HipiFeedPage.objCommentCount, "Comment Count");
		verifyElementPresent(HipiFeedPage.objPlusIconOnProfileImage, "Profile Image with + on right tip");
		
		extent.HeaderChildNode("Home Screen Verify user is able to refresh the list of contents in For You section of feed screen on HiPi [with logged in user] and [without logged in user]");

		logger.info("TC_Mobile_12 and TC_Mobile_14"); 		
		extent.extentLogger("", "TC_Mobile_012 and TC_Mobile_04");
		
		for(int i=1;i<5;i++) {
			waitTime(5000);
		
			String name1 = fetchUserNameFromVideoDescription();
			logger.info("UserName Before Scrolling: " +name1);
			extent.extentLogger("UserName",
					"UserName : " +name1);
			
			Swipe("DOWN", 1);

			waitTime(5000);
			String name2 = fetchUserNameFromVideoDescription();
			logger.info("UserName After Scrolling : " +name2);
			extent.extentLogger("UserName",
					"UserName After Scrolling  : " +name2);
			

			if (name1.equalsIgnoreCase(name2)) {
				logger.error("User is not able to refresh the list on contents in For You section of HiPi Feed");
				extentLoggerFail("", "User is not able to refresh the list on contents in For You section of HiPi Feed");
			} else {
				logger.info("User is able to refresh the list on contents in For You section of HiPi Feed");
				extentLoggerPass("", "User is able to refresh the list on contents in For You section of HiPi Feed");
			}
		}
		
		extent.HeaderChildNode("Home Screen Discover check if user is able to view Discover detail screen [with logged in user] and [without logged in user]");
		logger.info("TC_Mobile_26 and TC_Mobile_27"); 		
		extent.extentLogger("", "TC_Mobile_26 and TC_Mobile_27");
		
		click(HipiDiscoverPage.objDiscoverOption, "Discover/Search Icon");
		
		if (verifyIsElementDisplayed(HipiDiscoverPage.objDiscoverTitle, "Discover Title")) {
				logger.info("User is navigated to Discover Detail Screen");
				extent.extentLogger("Popular",
						"User is navigated to Discover Detail Screen");
				Back(1);
			} else {
				logger.error("User is not navigated to Discover Detail Screen");
				extent.extentLoggerFail("Popular",
						"User is not navigated to Discover Detail Screen");
			}
		extent.HeaderChildNode("Home Screen Verify on tapping any key section, user is navigated to respective screen [with logged in user] and [without logged in user]");
		
		logger.info("TC_Mobile_08 TC_Mobile_09"); 		
		extent.extentLogger("", "TC_Mobile_08 and TC_Mobile_09");
		
		
		click(HipiFeedPage.objPopularImage, "Popular/Star Icon");
		
		if (verifyIsElementDisplayed(HipiPopularPage.objpopulartitle, "Popular Title")) {
			logger.info("User is navigated to Popular section");
			extent.extentLogger("Popular",
					"User is navigated to Popular section");
		} else {
			logger.error("User is not navigated to Popular section");
			extent.extentLoggerFail("Popular",
					"User is not navigated to Popular section");
		}
		
		Back(1);
		
		click(HipiFeedPage.objMeImage, "Me/Person Icon");
		waitTime(3000);
		if (userType.equalsIgnoreCase("Guest")) {
			
			if (verifyIsElementDisplayed(HipiSoundDetailPage.objLoginOrRegisterPopUp, "Login/Register PopUp")) {
				logger.info("Login/Register PopUp is displayed");
				extent.extentLogger("PopUp",
						"Login/Register PopUp is displayed");
			} else {
				logger.error(
						"Login/Register PopUp is not displayed");
				extent.extentLoggerFail("PopUp",
						"Login/Register PopUp is not displayed");
			}
			Back(1);
			waitTime(3000);
			
		}
		
		if (!(userType.equalsIgnoreCase("Guest"))) {
			
			if (verifyIsElementDisplayed(HipiPopularPage.objpopulartitle, "Profile Title")) {
				logger.info("User is navigated to Me/Profile section");
				extent.extentLogger("Me/Profile",
						"User is navigated to Me/Profile section");
			} else {
				logger.error("User is not navigated to Me/Profile section");
				extent.extentLoggerFail("Me/Profile",
						"User is not navigated to Me/Profile section");
			}
			Back(1);
		}
		
		waitTime(3000);
		
		extent.HeaderChildNode("Home Screen Verify user is unable to refresh the list of contents in Following section of "
				+ "feed screen on HiPi [without logged in user] and Home Screen Check vertical scrolling of For you Tab section is infinte [without logged in user]");

		logger.info("TC_Mobile_13 and TC_Mobile_15"); 		
		extent.extentLogger("", "TC_Mobile_13 and TC_Mobile_15");
		
		click(HipiFeedPage.objfollowinginfeed, "Following Option");
		
		if (userType.equalsIgnoreCase("Guest")) {
			if (verifyIsElementDisplayed(HipiSoundDetailPage.objLoginOrRegisterPopUp, "Login/Register PopUp")) {
				logger.info("Login/Register PopUp is displayed");
				extent.extentLogger("PopUp",
						"Login/Register PopUp is displayed");
				Back(1);
				waitTime(3000);
				
				
			} else {
				logger.error(
						"Login/Register PopUp is not displayed");
				extent.extentLoggerFail("PopUp",
						"Login/Register PopUp is not displayed");
			}
		}
		extent.HeaderChildNode("Home Screen Verify user is unable to refresh the list of contents "
				+ "in Following section of feed screen on HiPi and Home Screen Check vertical scrolling of For you Tab section is infinte [with logged in user]");

		logger.info("TC_Mobile_14 and TC_Mobile_17"); 		
		extent.extentLogger("", "TC_Mobile_14 and TC_Mobile_17");
	
		
		if (!(userType.equalsIgnoreCase("Guest"))) {
			
			for(int i=1;i<5;i++) {
				waitTime(5000);
				
				String soundTitle1 = getText(HipiSoundDetailPage.objOriginalSound);
				System.out.println(soundTitle1);
				logger.info("Sound Title Before Scrolling: " +soundTitle1);
				extent.extentLogger("Sound Title",
						"Sound Title : " +soundTitle1);

				Swipe("DOWN", 1);
				waitTime(5000);
				String soundTitle2 = getText(HipiSoundDetailPage.objOriginalSound);
				System.out.println(soundTitle2);
				logger.info("Sound Title After Scrolling: " +soundTitle1);
				extent.extentLogger("Sound Title",
						"Sound Title : " +soundTitle1);

				if(!(soundTitle2.equalsIgnoreCase(soundTitle1))) {
					logger.info("User is able to refresh the list of contents in Following section of HiPi ");
					extent.extentLogger("Sound Detail Page",
							"User is able to refresh the list of contents in Following section of HiPi ");
				} else {
					logger.error("User is not able to refresh the list of contents in Following section of HiPi ");
					extent.extentLoggerFail("Sound Detail Page",
							"User is not able to refresh the list of contents in Following section of HiPi ");
				}
				
			}
			
			
		}
		
		click(HipiCreateVideoPage.objcreatevideo, "Plus/+ Icon");
		waitTime(5000);
		
		if (userType.equalsIgnoreCase("Guest")) {
			if (verifyIsElementDisplayed(HipiSoundDetailPage.objLoginOrRegisterPopUp, "Login/Register PopUp")) {
				logger.info("Login/Register PopUp is displayed");
				extent.extentLogger("PopUp",
						"Login/Register PopUp is displayed");
				Back(1);
				waitTime(3000);
				
				
			} else {
				logger.error(
						"Login/Register PopUp is not displayed");
				extent.extentLoggerFail("PopUp",
						"Login/Register PopUp is not displayed");
			}
		}
		
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Home Screen Check if user is not prompted with alert when user accepts to grant permission to use device hardware microphone, Camera and storage");

			logger.info("TC_Mobile_21 and TC_Mobile_22"); 		
			extent.extentLogger("", "TC_Mobile_21 and TC_Mobile_22");
		
			
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objaccesspictures, "Permission to access pictures and record audio")) {
				logger.info("Permission setting popup is displayed");
				extent.extentLogger("Permission popup",
						"Permission setting popup is displayed");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "Allow Button");
				verifyElementPresent(HipiCreateVideoPage.objpermission, "Permission to access photos/media/files");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "Allow Button");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "Permission to record audio");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "Allow Button");

				
				// waitTime(15000);
				waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
				Thread.sleep(3000);
				verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
				verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
				waitTime(20000);

				waitForElementDisplayed(HipiCreateVideoPage.objRecordVideo, 60);
				
				if(verifyIsElementDisplayed(HipiCreateVideoPage.objRecordVideo, "Record Button")) {
					logger.info("Navigated to Video Creator Module");
					extent.extentLogger("Video",
							"Navigated to Video Creator Module");
				}else {
					logger.error("Not navigated to Video Creator Module");
					extent.extentLoggerFail("Video",
							"Not navigated to Video Creator Module");
				}
				
				Back(1);
				waitTime(3000);
				
				extent.HeaderChildNode("Home Screen Check if user is not prompted to provide permission for a existing logged in user");

				logger.info("TC_Mobile_20"); 		
				extent.extentLogger("", "TC_Mobile_20");
			
				
				click(HipiCreateVideoPage.objcreatevideo, "Plus/+ Icon");
				waitTime(5000);
				if(!(verifyIsElementDisplayed(HipiCreateVideoPage.objaccesspictures, "Permission to access pictures and record audio"))) {
					logger.info("User is not prompted with permission popup for a existing logged in user");
					extent.extentLoggerPass("Permission popup",
							"User is not prompted with permission popup for a existing logged in user");
				}else {
					logger.error("User is prompted with permission popup for a existing logged in user");
					extent.extentLoggerFail("Permission popup",
							"User is prompted with permission popup for a existing logged in user");
				}
				
				Back(1);
				Back(1);
				
			} else {
				logger.error("Permission setting popup is not displayed");
				extent.extentLoggerFail("Permission popup",
						"Permission setting popup is not displayed");
			}
		}
	}
	
	
	public void denyPermissionValidation(String userType) throws Exception {
		
		extent.HeaderChildNode("Deny Permission To Create Video Validaton");

		logger.info("TC_Mobile_23,24 and TC_Mobile_25"); 		
		extent.extentLogger("", "TC_Mobile_23,24 and TC_Mobile_25");
	
		if (!(userType.equalsIgnoreCase("Guest"))) {
			
			if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
				click(AMDOnboardingScreen.objHipiButton, "HiPi");
				Thread.sleep(6000);

			} else {

			}
			waitTime(5000);
			
			click(HipiCreateVideoPage.objcreatevideo, "Plus/+ Icon");
			waitTime(5000);
			
			verifyElementPresentAndClick(HipiCreateVideoPage.objdenybutton, "Deny Button");
			verifyElementPresent(HipiCreateVideoPage.objpermission, "Permission to access photos/media/files");
			verifyElementPresentAndClick(HipiCreateVideoPage.objdenybutton, "Deny Button");		
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordpermission, "Permission to record audio");
			verifyElementPresentAndClick(HipiCreateVideoPage.objdenybutton, "Deny Button");			
			waitTime(5000);
		
			verifyElementPresent(HipiCreateVideoPage.objAlertAfterDenying, "Alert after denying permission");
			verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "Deny Button");			
			waitTime(2000);
			Back(1);
			waitTime(2000);
			click(HipiCreateVideoPage.objcreatevideo, "Plus/+ Icon");
			waitTime(5000);
			
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objdenybutton, "Deny Permission")) {
				logger.info("User is unable to create or save video without permission");
				extent.extentLogger("Video",
						"User is unable to create or save video without permission");
			}else {
				logger.error("User is able to create or save video without permission");
				extent.extentLoggerFail("Video",
						"User is able to create or save video without permission");
			}
			
		}
		
	}

public void popularCardsValidation(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			
			extent.HeaderChildNode(
					"Verifying if user views Popular creator cards in Following screen if user has not followed any profile");

			logger.info("TC_Mobile_32"); 		
			extent.extentLogger("", "TC_Mobile_32");
			
			
			waitTime(5000);
			logout();
			waitTime(5000);
			click(AMDHomePage.objMoreMenu, "More Menu");
			
			waitTime(2000);
			click(AMDOnboardingScreen.objLoginLink, "Login Link");
			String Username = getParameterFromXML("NewNonsubscribedUserName");
			String Password = getParameterFromXML("NewNonsubscribedPassword");

			Thread.sleep(5000);
			hideKeyboard();
			Thread.sleep(5000);
			click(AMDLoginScreen.objEmailIdField, "Email field");
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(9000);

			verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(5000);

			click(HipiFeedPage.objfollowinginfeed, "Following Option");
			waitTime(3000);
			if (verifyIsElementDisplayed(HipiFeedPage.objPopularCreators, "Popular Creator Cards")) {
				logger.info("User is able to view Popular Creator Cards");
				extent.extentLogger("Popular Creator Cards", "User is able to view Popular Creator Cards");
				
				
				extent.HeaderChildNode(
						"Home screen Check if user is able to follow popular icons by swiping Popular creator cards right under following screen");

				logger.info("TC_Mobile_33"); 		
				extent.extentLogger("", "TC_Mobile_33");
				
				
				List<WebElement> cards = getDriver().findElements(HipiFeedPage.objPopularCreatorCards);
				int size = cards.size();
				System.out.println(size);
				
				String name = getText(HipiFeedPage.objCreatorName(size));
				System.out.println(name);
				
				Swipe("Right", 1);
				waitTime(2000);

				click(HipiFeedPage.objMeImage, "Me Icon");
				waitTime(2000);
				click(HipiMePage.objfollowing, "Following");
				waitTime(5000);
				
				String name2 = getText(HipiPopularPage.objUserHandle);
				System.out.println(name2);
				
				if (verifyIsElementDisplayed(HipiPopularPage.objSpecificUserHandle("@"+name), "Followed Popular Creator")) {
		//		if(name2.contains(name)) {
					logger.info("User is able to follow the Popular creator and the followed user is present in Following list screen");
					extent.extentLogger("Popular Creator",
							"User is able to follow the Popular creator and the followed user is present in Following list screen");
				} else {
					logger.error("User is not able to follow the Popular creator and the followed user is not present in Following list screen");
					extent.extentLoggerFail("Popular Creator",
							"User is not able to follow the Popular creator and the followed user is not present in Following list screen");
				}
				
				click(HipiMePage.objmusiclist, "Followed Popular Creator");
				click(HipiMePage.objUnfollow, "Following");
				
				Back(3);
				
				click(HipiFeedPage.objforyou, "For You Option");
				waitTime(3000);
				
				extent.HeaderChildNode(
						"Home screen Check if user is unable to follow popular icons by swiping Popular creator cards left under following screen");

				logger.info("TC_Mobile_34"); 		
				extent.extentLogger("", "TC_Mobile_34");
				
				click(HipiFeedPage.objfollowinginfeed, "Following Option");
				waitTime(3000);
				
				String name1 = getText(HipiFeedPage.objCreatorName(size));
				System.out.println(name1);
				
				Swipe("LEFT", 1);
				waitTime(2000);
				
				click(HipiFeedPage.objMeImage, "Me Icon");
				waitTime(2000);
				click(HipiMePage.objfollowing, "Following");
				waitTime(5000);
				
				if (verifyIsElementDisplayed(HipiPopularPage.objSpecificUserHandle("@"+name1), "Followed Popular Creator")) {
					logger.info("User is unable to follow the Popular creator and user is not listed in Following screen after swiping the card to left ");
					extent.extentLogger("Popular Creator",
							"User is unable to follow the Popular creator and user is not listed in Following screen after swiping the card to left ");
				} else {
					logger.error("User is able to follow the Popular creator and user is not listed in Following screen after swiping the card to left ");
					extent.extentLoggerFail("Popular Creator",
							"User is able to follow the Popular creator and user is not listed in Following screen after swiping the card to left ");
				}
				
				click(HipiFeedPage.objMeImage, "Me Icon");
				waitTime(2000);
				click(HipiMePage.objfollowing, "Following");
				waitTime(3000);
				
				
			} else {
				logger.info("Popular Creator Cards are not available");
				extent.extentLogger("Popular Creator Cards", "Popular Creator Cards are not available");
			}

			
		}
	}


public void logout() throws Exception {
		verifyElementExist(AMDHomePage.objHomeTab, "Home tab");
		verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
		waitTime(2000);
		PartialSwipe("UP", 2);
		verifyElementPresentAndClick(AMDHomePage.objLogout, "Logout");
		verifyElementPresentAndClick(AMDHomePage.objLogoutPopUpLogoutButton, "Logout popup logout button");
		verifyElementPresentAndClick(AMDHomePage.HomeIcon, "Home Icon");
	}
	
	public String fetchUserNameFromVideoDescription() throws Exception {

		String description = getText(HipiFeedPage.objdescription);
		System.out.println("description");
		String name = description.split(" ")[0];

		return name;

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
	
	
	public int getFollowingCount(String str){
		String reg = "[!_.',@?() ]";
		String[] name = str.split(reg);		
		System.out.println(name[1]);
		
		String value = name[1]; 
		int valuenum=Integer.parseInt(value);
		return valuenum;		
	}
	
	
	
	

	
	
	
	
	//--------------------------------------------GAUTHAMI : PlayerView--------------------------------------------
	
	
	public void Taggeduserprofile(String userType) throws Exception{
		if(userType.equalsIgnoreCase("NonSubscribedUser"))
		{
		
	  extent.HeaderChildNode("Player Preview Check if user is able to view tagged user with prefix in description on played/paused video");
	  System.out.println("TC_Mobile_01,TC_Mobile_81");
	  extent.extentLogger("", "TC_Mobile_01,TC_Mobile_81");
		
	
	  if (verifyElementExist(HipiFeedPage.objHipiIcon, "HiPi")) {
			click(AMDOnboardingScreen.objHipiButton, "HiPi");
			Thread.sleep(6000);

		} else {

		}
	  if (verifyElementExist(AMDFeed.objFeedAuthorData, "Video description")) {
		 
			logger.info("Hipi feed screen:"
					+ "Video description is stored to check #hashtag is available or not of feed screen");
			String getTextVideoDescription = findElement(AMDFeed.objFeedAuthorData).getText();
			extent.extentLogger("", "Video Description: " + getTextVideoDescription);
			if (getTextVideoDescription.contains("#")) {
				extent.extentLoggerPass("Hipi feed screen:", "Hashtags used in the video description");
				logger.info("Hipi feed screen:" + "Hashtags used in the video description");
			} else {
				extent.extentLoggerWarning("Hipi feed screen:", "Hashtags not used in the video description");
				logger.info("Hipi feed screen:" + "Hashtags not used in the video description");
			}
	}
	  if (verifyElementExist(AMDFeed.objFeedAuthorData, "Video description")) {
			logger.info("Hipi feed screen:"
					+ "Video description is stored to check @tagged user is available or not of feed screen");
			String getTextAuthorData = findElement(AMDFeed.objFeedAuthorData).getText();
			extent.extentLogger("", "Video Description: " + getTextAuthorData);
			if (getTextAuthorData.contains("@")) {
				extent.extentLoggerPass("Hipi feed screen:", "Tagged person used in the video description");
				logger.info("Hipi feed screen:" + "Tagged person used in the video description");
			} else {
				extent.extentLoggerWarning("Hipi feed screen:", "Tagged person not used in the video description");
				logger.info("Hipi feed screen:" + "Tagged person not used in the video description");
			}
		}
	  if (verifyElementExist(AMDFeed.objFeedAuthorData, "Video description")) {
			logger.info("Hipi feed screen:"
					+ "Video description is stored to check MORE user is available or not of feed screen");
			String getTextAuthorData = findElement(AMDFeed.objFeedAuthorData).getText();
			extent.extentLogger("", "Video Description: " + getTextAuthorData);
			if (getTextAuthorData.contains("MORE")) {
				extent.extentLoggerPass("Hipi feed screen:", "MORE person used in the video description");
				logger.info("Hipi feed screen:" + "MORE person used in the video description");
			} else {
				extent.extentLoggerWarning("Hipi feed screen:", "MORE person not used in the video description");
				logger.info("Hipi feed screen:" + "MORE person not used in the video description");
			}
		}
	  
	  
		}
	  
	  
	}

	public void Soundusedvalidation(String userType)throws Exception {
		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("Player Preview Check if user is able to view sound on played/paused video");
			System.out.println("TC_Mobile_02");
			extent.extentLogger("", "TC_Mobile_02");
		
		if (verifyElementExist(AMDFeed.objSongButton, "Song")) {
			String getTextSongUsed = findElement(AMDFeed.objSongButton).getText();
			System.out.println("Song used: " + getTextSongUsed);
			extent.extentLogger("", "Song used: " + getTextSongUsed);
			logger.info("Hipi feed screen:" + "song available in feed screen");
			extent.extentLoggerPass("Hipi feed screen:", "song available in feed screen");
		} else {
			logger.info("Hipi feed screen:" + "song not available in feed screen");
			extent.extentLoggerWarning("Hipi feed screen:", "the video has no song");
		}
		}
	}

	public void Effectvalidation(String userType) throws Exception{
		
		if(userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Player Preview Check for counts if user is able to view effects on existing/new paused video without logged in user");
			System.out.println("TC_Mobile_88");
			extent.extentLogger("","TC_Mobile_88");
			//verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon present");
			// Thread.sleep(1000);
			verifyElementPresentAndClick(AMDHipi.objDiscovertext, "discover text present");
			verifyElementPresentAndClick(AMDHipi.objdiscoversearchtext, " search text present");
			type(AMDHipi.objsearchtext, "cool Glasses", "effect used");
			hideKeyboard();
			// String Effectused1 = getText(AMDHipi.objsearchtext);
			// logger.info(Effectused1);
			verifyElementPresentAndClick(AMDHipi.objframelayout, " frame layout present");
			PausePlayer();
			verifyElementExist(AMDHipi.objeffectused, " effect used");
			if(verifyElementExist(AMDHipi.objeffectused, " effect used")) {
				logger.info("user is able to view effects on existing/new paused video");
				extent.extentLoggerPass("", "user is able to view effects on existing/new paused video");
			}
			else {
				logger.info("user is not able to view effects on existing/new paused video");
				extent.extentLoggerWarning("", "user is not able to view effects on existing/new paused video");
			}

			BackToFeedScreen();
		//	Back(1);
		}else{	
			extent.HeaderChildNode("Player Preview Check if user is able to view effects on existing/new paused video with logged in user");
			System.out.println("TC_Mobile_85");
			extent.extentLogger("", "TC_Mobile_85");

			String effectName = null;
			verifyElementPresentAndClick(AMDHipi.objDiscovertext, "discover text present");
			verifyElementPresentAndClick(AMDHipi.objdiscoversearchtext, " search text present");
			type(AMDHipi.objsearchtext, "cool Glasses", "effect used");
			hideKeyboard();
			// String Effectused1 = getText(AMDHipi.objsearchtext);
			// logger.info(Effectused1);
			verifyElementPresentAndClick(AMDHipi.objframelayout, " frame layout present");
			pauseVideo();
			verifyElementPresentAndClick(AMDHipi.objeffectused, " effect used");
			verifyElementPresentAndClick(AMDHipi.objuseeffect, "click on use this effect");
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
			verifyElementPresentAndClick(HipiMePage.objreadypopup, " ready popup");
			verifyElementPresentAndClick(HipiMePage.objokbutton, " ok button");
			String getPropertyValue = getAttributValue("enabled", HipiCreateVideoPage.obj15sec);
			if (getPropertyValue.equalsIgnoreCase("true")) {
				extent.extentLoggerPass(" ", "15 sec is by default highlighted");
				logger.info("15 sec is by default highlighted");
			} else {
				extent.extentLoggerFail("", "15 sec fails to highlight by default");
				logger.error("15 sec tab fails to highlight by default");
			}
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
				verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "click on posthipi");// saveasdraft
				waitTime(10000);
				boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
				if (Popup) {
					extent.extentLoggerPass(" ", "video Popup is displayed ");
					logger.info("video Popup is displayed ");
				}else{
					extent.extentLoggerFail(" ", "video Popup is not displayed ");
					logger.info("video Popup is not displayed ");
				}
				verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "click on gotofeed button");
				//Thread.sleep(10000);
	             //verifyElementExist(HipiCreateVideoPage.objcompletedstatus,"completed status");
				
				Thread.sleep(10000);

				verifyElementPresentAndClick(AMDHipi.objmeicon, "click on me icon");
				for (int i = 0; i <= 50; i++) {
					scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
					if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
						Thread.sleep(2000);
						Back(1);
						Thread.sleep(2000);
						verifyElementPresentAndClick(AMDHipi.objmeicon, "click on me icon");
						// verifyElementPresentAndClick(HipiMePage.objbackbutton,"click
						// on back button");
					} else {
						verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), "Video");
						click(HipiCreateVideoPage.objselectfirstimage, "First video");
						waitTime(5000);
						break;
					}
				}
				//waitTime(5000);

				if (verifyElementExist(HipiCreateVideoPage.objeffectused, "effect name")) {
					pauseVideo();
					logger.info("user is able to view effects on existing/new paused video");
					extent.extentLoggerPass("videoscreated", "user is able to view effects on existing/new paused video");
				} else {
					extent.extentLoggerFail("", "user is not able to view effects on existing/new paused video");
				}

				BackToFeedScreen();

			} else {
				System.out.println("Video is less than 5sec , so not selected");
				BackToFeedScreen();
			}
			
			extent.HeaderChildNode("Player Preview Check if user is able to view effects on existing/new played video");
			System.out.println("TC_Mobile_09");
			extent.extentLogger("", "TC_Mobile_09");
			verifyElementPresentAndClick(AMDHipi.objDiscovertext, "discover text present");
			verifyElementPresentAndClick(AMDHipi.objdiscoversearchtext, " search text present");
			type(AMDHipi.objsearchtext, "cool Glasses", "effect used");
			hideKeyboard();
			// String Effectused1 = getText(AMDHipi.objsearchtext);
			// logger.info(Effectused1);
			verifyElementPresentAndClick(AMDHipi.objframelayout, " frame layout present");
			pauseVideo();
			Thread.sleep(3000);
			verifyElementPresentAndClick(HipiFeedPage.objplaybutton, "playbutton");
			verifyElementExist(AMDHipi.objeffectused, " effect used");
			if(verifyElementExist(AMDHipi.objeffectused, " effect used")) {
				logger.info("user is able to view effects on existing/new played video");
				extent.extentLogger("", "user is able to view effects on existing/new played video");
			}
			else {
				logger.info("user is not able to view effects on existing/new played video");
				extent.extentLogger("", "user is not able to view effects on existing/new played video");
			}
			Back(1);
			BackToFeedScreen();
			
		}
		
	}
	
	public void Favouritesorlikesvalidation(String userType)throws Exception {
		// TODO Auto-generated method stub
		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
		extent.HeaderChildNode("Player Preview Check if user is able to view number of likes on played/paused video");
		System.out.println("TC_Mobile_03");
		extent.extentLogger("", "TC_Mobile_03");
		String likescount = getAttributValue("text", HipiFeedPage.objlikecount);
		System.out.print("likes count");
		if (likescount.equalsIgnoreCase("")) {
			logger.error("likes count is displayed blank");
			extentLoggerFail("likes", "likes count is displayed blank");
		} else {
			logger.info("Likes count displayed " + likescount);
			extentLoggerPass("Likes", "likes count displayed " + likescount);
		}
	}
		
		if(userType.equalsIgnoreCase("Guest")) {
			
			extent.HeaderChildNode("Player Preview Check if user is unable to like/dislike a video on played/paused video");
			System.out.println("TC_Mobile_04");
			extent.extentLogger("", "TC_Mobile_04");
			if (verifyElementExist(HipiFeedPage.objHipiIcon, "HiPi")) {
				click(AMDOnboardingScreen.objHipiButton, "HiPi");
				Thread.sleep(6000);

			} else {

			}
			verifyElementDisplayed(HipiFeedPage.objFeedButton);
			verifyElementPresentAndClick(HipiFeedPage.objlikecount,"like count present");
			 registerPopUp();
		        if (verifyIsElementDisplayed(AMDHipi.objRegisterforVibe)) {
		    		logger.info("Register Pop Up is displayed");
		    		extent.extentLoggerPass("Register Pop Up", "Register Pop Up is displayed");
		    	} else {
		    		logger.info("Register Pop Up is not displayed");
		    		extent.extentLoggerFail("Register Pop Up", "Register Pop Up is not displayed");
		    	}
	Back(1);
		}
	}

	public void NotInterestedvalidation(String userType)throws Exception {
		// TODO Auto-generated method stub
		if(userType.equalsIgnoreCase("Guest")) {
			
			extent.HeaderChildNode("Player Preview Check if user is unable to perform Not Interested action by tapping on it");
			System.out.println("TC_Mobile_10");
			extent.extentLogger("", "TC_Mobile_10");
			longPress(HipiFeedPage.objFeedLongPress);
			if (verifyElementExist(HipiFeedPage.objnotinterested,"not interested")) {
				click(HipiFeedPage.objnotinterested,"not interested");
				 registerPopUp();
			        if (verifyIsElementDisplayed(AMDHipi.objRegisterforVibe)) {
			    		logger.info("Register Pop Up is displayed");
			    		extent.extentLoggerPass("Register Pop Up", "Register Pop Up is displayed");
			    	} else {
			    		logger.info("Register Pop Up is not displayed");
			    		extent.extentLoggerFail("Register Pop Up", "Register Pop Up is not displayed");
			    	}
			        Back(1);
			}else{
				extent.extentLoggerFail("", "not interested is not present");
			}
		
		
	}
		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("Player Preview Check is user is unable to view videos which is marked as Not interested");
			System.out.println("TC_Mobile_13");
			extent.extentLogger("", "TC_Mobile_13");
			longPress(HipiFeedPage.objFeedLongPress);
			if (verifyElementExist(HipiFeedPage.objnotinterested,"not interested")) {
				click(HipiFeedPage.objnotinterested,"not interested");
				if(verifyElementExist(HipiFeedPage.objNotInterestedPopup,"popup")){
					logger.info("user is unable to view video marked as notinterested");
					extent.extentLogger("", "user is unable to view video marked as notinterested");
				}
			}
			else
			{
				logger.info("user is able to view video marked as notinterested");
				extent.extentLoggerFail("", "user is able to view video marked as notinterested");
				Back(1);
			}
		}
	}
	public  void Addtomyfavouritesvalidation(String userType)throws Exception {
		
		if(userType.equalsIgnoreCase("Guest")) {
			
			extent.HeaderChildNode("Player Preview Check if user is unable to perform Add to Favourites action by tapping on it without logged in user");
			System.out.println("TC_Mobile_18");
			extent.extentLogger("", "TC_Mobile_18");
//			PausePlayer();
//			Thread.sleep(3000);
//			verifyElementPresentAndClick(HipiFeedPage.objplaybutton, "playbutton");
//			Thread.sleep(3000);
//			PausePlayer();
//			Thread.sleep(3000);
//			if (verifyElementDisplayed(HipiFeedPage.objplaybutton)) {
//				logger.info("user is able to view play button");
//				extent.extentLoggerPass("", "user is able to view play button");
//			} else {
//				logger.info("user is not able to view play buttton");
//				extent.extentLoggerFail("", "user is not able to view play button");
//			}
			
			longPress(HipiFeedPage.objFeedLongPress);
			if (verifyElementDisplayed(HipiFeedPage.objfavourites)) {
				logger.info("user is able to view favourites video ");
				extent.extentLoggerPass("", "user is able to view favourites video");
			
			click(HipiFeedPage.objnotinterested,"not interested");
			 registerPopUp();
		        if (verifyIsElementDisplayed(AMDHipi.objRegisterforVibe)) {
		    		logger.info("Register Pop Up is displayed");
		    		extent.extentLoggerPass("Register Pop Up", "Register Pop Up is displayed");
		    	} else {
		    		logger.info("Register Pop Up is not displayed");
		    		extent.extentLoggerFail("Register Pop Up", "Register Pop Up is not displayed");
		    	}
		        Back(1);
		}
		        else {
					logger.info("user is not able to view favourites video");
					extent.extentLoggerFail("", "user is not able to view favourites video");
				}
		}
		
		// TODO Auto-generated method stub
		 if(userType.equalsIgnoreCase("NonSubscribedUser")) {
			 
			 extent.HeaderChildNode("Player Preview Check if user is able to perform Add to Favourites action by tapping on it with logged in user");
				System.out.println("TC_Mobile_19");
				extent.extentLogger("", "TC_Mobile_19");
			 
			// Thread.sleep(3000);
			 verifyElementPresentAndClick(HipiFeedPage.objFeedButton, " feed present");
//			 PausePlayer();
//			// pauseVideo();
//				Thread.sleep(3000);
//				verifyElementPresentAndClick(HipiFeedPage.objplaybutton, "playbutton");
//				Thread.sleep(3000);
//				 PausePlayer();
//			//	pauseVideo();
//				Thread.sleep(3000);
//				if (verifyElementDisplayed(HipiFeedPage.objplaybutton)) {
//					logger.info("user is able to view play button");
//					extent.extentLoggerPass("", "user is able to view play button");
//				} else {
//					logger.info("user is not able to view play buttton");
//					extent.extentLoggerFail("", "user is not able to view play button");
//				}
//				verifyElementPresentAndClick(HipiFeedPage.objplaybutton, "playbutton");
			 
				String beforeFavouriting = fetchUserNameFromVideoDescription();
				
				longPress(HipiFeedPage.objFeedLongPress);
				if (verifyElementDisplayed(HipiFeedPage.objfavourites)) {
					click(HipiFeedPage.objfavourites,"favourites tab present");
					waitTime(6000);
					//verifyElementPresentAndClick(HipiFeedPage.objaddtofavouritepopup,"favourite popup present");
					click(HipiFeedPage.objMeImage, "Me Icon");
					click(HipiMePage.objfavouritetab, "Favourite tab");
					
					scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
					click(HipiCreateVideoPage.objselectfirstimage, "First video");
					waitTime(8000);
					String afterFavouriting = fetchUserNameFromVideoDescription();
					
					if(afterFavouriting.contains(beforeFavouriting)){
						extent.extentLoggerPass("", "Video is favourited");
					}else{
						extent.extentLoggerPass("", "Video is not favourited");						
					}
					Back(2);
				} 
				else{
					logger.info("user is not able to add to favourites video ");
					extent.extentLoggerPass("", "user is not able to add to favourites video");
				}
		 }
	}

	public void Savevideovalidation(String userType)throws Exception {
		
		if(userType.equalsIgnoreCase("Guest")) {
			
			extent.HeaderChildNode("Player Preview Check if user is unable to perform Download Video action by tapping on it without logged in user");
			System.out.println("TC_Mobile_20");
			extent.extentLogger("", "TC_Mobile_20");
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
			
			longPress(HipiFeedPage.objFeedLongPress);
			if (verifyElementDisplayed(HipiFeedPage.objdownloadvideo)) {
				click(HipiFeedPage.objdownloadvideo,"download video present");
				registerPopUp();
		        if (verifyIsElementDisplayed(AMDHipi.objRegisterforVibe)) {
		    		logger.info("Register Pop Up is displayed");
		    		extent.extentLoggerPass("Register Pop Up", "Register Pop Up is displayed");
		    	} else {
		    		logger.info("Register Pop Up is not displayed");
		    		extent.extentLoggerFail("Register Pop Up", "Register Pop Up is not displayed");
		    	}
		        Back(1);
		}
				
			 else {
				logger.info("user is not able to view download video ");
				extent.extentLoggerFail("", "user is not able to view download video");
			}
		}


		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("Player Preview Check if user is able to perform Download Video action by tapping on it");
			System.out.println("TC_Mobile_21");
			extent.extentLogger("", "TC_Mobile_21");
			verifyElementPresentAndClick(HipiFeedPage.objFeedButton, " feed ");
			longPress(HipiFeedPage.objFeedLongPress);
			if (verifyElementDisplayed(HipiFeedPage.objdownloadvideo)) {
				click(HipiFeedPage.objdownloadvideo,"download video");
//				if(verifyIsElementDisplayed(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission"))
//				{
//					verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission");
//					verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, " allow button");
//				}
			if(verifyElementExist(HipiFeedPage.objvideosavedpopup,"video popup ")) {
				logger.info("video is download");
				extent.extentLoggerPass("", "video is download ");	
			}else{
				logger.info("video is not downloaded");
				extent.extentLoggerWarning("", "Video download popup disappeared before validation ");	
			}
				
		}
			else {
				logger.info("video is not download");
				extent.extentLoggerWarning("", "No option to download");
			}
			
//			extent.HeaderChildNode("Player Preview Check if user is unable to perform Download Video action when using mobile data");
//			System.out.println("TC_Mobile_23");
//			extent.extentLogger("", "TC_Mobile_23");
//			Swipe("DOWN", 1);
//			Thread.sleep(5000);
//			longPress(HipiFeedPage.objFeedLongPress);
//			if (verifyIsElementDisplayed(HipiFeedPage.objdownloadvideo,"Download Option")) {
//				
//				TurnOFFWifi();
//				Thread.sleep(5000);
//				click(HipiFeedPage.objdownloadvideo,"download video");
//				//Thread.sleep(1000);
//				if(verifyElementExist(HipiFeedPage.objmobiledatapopup,"popup")) {
//					TurnONWifi();
//					Thread.sleep(5000);
//					click(HipiFeedPage.objokbutton,"ok button present");
//					waitTime(1000);
//					if(verifyElementExist(HipiFeedPage.objvideosavedpopup,"video popup")){
//						extent.extentLoggerPass("", "You want to download videos on mobile data is displayed");
//					}else{
//						extent.extentLoggerFail("", "You want to download videos on mobile data is not displayed");
//					}
//				}
//			}
//				else {
//					extent.extentLoggerFail("", "Download option is not displayed");
//					
//				}
			Back(1);
		}
	}
		




		// TODO Auto-generated method stub
		


	public void switchNetworkWifiToData() throws Exception {
		//extent.HeaderChildNode("Validating Downloading resumes after switching network");
		System.out.println("\nValidating Downloading resumes after switching network");

		// Switching Network from Wifi -> Data
		Runtime.getRuntime().exec("adb shell svc wifi disable");
		Runtime.getRuntime().exec("adb shell svc data enable");
		if (checkElementExist(HipiFeedPage.objdownloadvideo, "Downloading Icon")) {
			extent.extentLogger("Downloading", "User is able to continue the download on shuffling wifi to data");
			logger.info("User is able to continue the download on shuffling wifi to data");
		}
		waitTime(2000);
		// Switching Network from Data -> Wifi
//		Runtime.getRuntime().exec("adb shell svc data disable");
//		Runtime.getRuntime().exec("adb shell svc wifi enable");
//		if (checkElementExist(HipiFeedPage.objdownloadvideo, "Downloading Icon")) {
//			extent.extentLogger("Downloading", "User is able to continue the download on shuffling data to wifi");
//			logger.info("User is able to continue the download on shuffling wifi to data");
//		}
	}

	public void TurnONWifi() throws IOException {
		String Deviceversion = getTheOSVersion();
		System.out.println("Turn on wifi");
		if (Deviceversion.contains("6")) {
			Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.wifi --es setstatus enable");
			logger.info("Turning ON wifi");
			extent.extentLoggerPass("Turning ON wifi", "Turning ON wifi");
		} else {
			Runtime.getRuntime().exec("adb shell svc wifi enable");
			logger.info("Turning ON wifi");
			extent.extentLoggerPass("Turning ON wifi", "Turning ON wifi");
		}
	}

	public void followuser(String userType) throws Exception {
		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
		extent.HeaderChildNode("Number of follower count is increased in Account Detail Screen");
		System.out.println("TC_Mobile_93");
		extent.extentLogger("", "TC_Mobile_93");
		verifyElementExist(HipiFeedPage.objfeed,"feed present");
		verifyElementPresentAndClick(HipiFeedPage.objprofilepic,"profile picture present");
		if(verifyElementExist(HipiFeedPage.objfollowicon,"follow option present")) {
			String followerscount = findElement(HipiFeedPage.objfollowerscount).getText();
			click(HipiFeedPage.objfollowicon,"follow option present");
			String followerscount1 = findElement(HipiFeedPage.objfollowerscount).getText();
			System.out.println("likescount: " + followerscount1);
			extent.extentLogger("", "likescount: " + followerscount1);
			logger.info("Hipi feed screen:" + "likescount available in feed screen");
			extent.extentLoggerPass("Hipi feed screen:", " available in feed screen");
		} else {
			logger.info("Hipi feed screen:" + "likescount not available in feed screen");
			extent.extentLogger("Hipi feed screen:", "likescount not displayed");
		}
		
		click(HipiFeedPage.objfollowingicon,"follow option present");
		
		if(verifyElementExist(HipiFeedPage.objfollowicon,"follow option present")) {
			String followerscount = findElement(HipiFeedPage.objfollowerscount).getText();
			click(HipiFeedPage.objfollowicon,"follow option present");
			String followerscount1 = findElement(HipiFeedPage.objfollowerscount).getText();
			System.out.println("likescount: " + followerscount1);
			extent.extentLogger("", "likescount: " + followerscount1);
			logger.info("Hipi feed screen:" + "likescount available in feed screen");
			extent.extentLoggerPass("Hipi feed screen:", " available in feed screen");
		} else {
			logger.info("Hipi feed screen:" + "likescount not available in feed screen");
			extent.extentLogger("Hipi feed screen:", "likescount not displayed");
		}
			
		BackToFeedScreen();
			
		}
	}
		
		
			
		
public void PlayerviewValidation(String userType) throws Exception{
	if(userType.equalsIgnoreCase("NonSubscribedUser")) {
		
		extent.HeaderChildNode("Player Preview Check if user is able to pause the played by default video by tapping on it");
		System.out.println("TC_Mobile_25");
		extent.extentLogger("","TC_Mobile_25");
		if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
	  		click(AMDOnboardingScreen.objHipiButton, "HiPi");
	  		Thread.sleep(6000);
	  	} else {
	  	}
		Thread.sleep(3000);
		Swipe("UP",1);
		pauseVideo();
		Thread.sleep(3000);
		verifyElementPresentAndClick(HipiFeedPage.objplaybutton, "playbutton");
		Thread.sleep(3000);
		pauseVideo();
		Thread.sleep(3000);
		if (verifyElementDisplayed(HipiFeedPage.objplaybutton)) {
			logger.info("user is able paused video");
			extent.extentLoggerPass("", "user is able paused video");
		} else {
			logger.info("user is not able to paused video");
			extent.extentLoggerFail("", "user is not able to paused video");
		}
		
		extent.HeaderChildNode("Player Preview Check if user is able to resume a paused video by tapping on it");
		System.out.println("TC_Mobile_26");
		extent.extentLogger("", "TC_Mobile_26");
		Thread.sleep(3000);
		Swipe("UP", 2);
		pauseVideo();
	//	Thread.sleep(3000);
		//PausePlayer();
		verifyElementPresentAndClick(HipiFeedPage.objplaybutton, "playbutton");
		//pauseVideo();
		//Thread.sleep(3000);
		//verifyElementPresentAndClick(HipiFeedPage.objplaybutton, "playbutton");
		Thread.sleep(3000);
		if (verifyElementDisplayed(HipiFeedPage.objplaybutton)) {
			extent.extentLoggerFail("", "Video playback not started");
		} else {
			extent.extentLogger("", "Video playback started after clicking on Play icon");
		}
		Back(1);
		
		extent.HeaderChildNode("Player Preview Check the details displayed on a played/paused newly created video");
		System.out.println("TC_Mobile_28,TC_Mobile_27");
		extent.extentLogger("", "TC_Mobile_28,TC_Mobile_27");
		verifyElementPresentAndClick(HipiFeedPage.objHipiIcon, " Hipi Icon");
		if (verifyElementExist(HipiFeedPage.objFeedButton, "FeedButton")) {
			logger.info("user is able to view Homescreen");
			extent.extentLoggerPass("", "user is able to view  Homescreen");
		}
		else
		{
			logger.info("user is not  able to view Homescreen");
			extent.extentLoggerFail("", "user is not  able to view  Homescreen");
		}
		
			String name1 = fetchUserNameFromVideoDescription();
			System.out.println("UserName1 : " + name1);
			logger.info("UserName1 : " + name1);

		if (verifyElementExist(AMDFeed.objFeedAuthorData, "Video description")) {
			logger.info("Hipi feed screen:"+ "Video description is stored to check #hashtag is available or not of feed screen");
			String getTextVideoDescription = findElement(AMDFeed.objFeedAuthorData).getText();
			extent.extentLogger("", "Video Description: " + getTextVideoDescription);
			if (getTextVideoDescription.contains("#")) {
				extent.extentLoggerPass("Hipi feed screen:", "Hashtags used in the video description");
				logger.info("Hipi feed screen:" + "Hashtags used in the video description");
			} else {
				extent.extentLoggerWarning("Hipi feed screen:", "Hashtags not used in the video description");
				logger.info("Hipi feed screen:" + "Hashtags not used in the video description");
			}
		}
		if (verifyElementExist(AMDFeed.objFeedAuthorData, "Video description")) {
			logger.info("Hipi feed screen:"
					+ "Video description is stored to check MORE is available or not of feed screen");
			String getTextVideoDescription = findElement(AMDFeed.objFeedAuthorData).getText();
			extent.extentLogger("", "Video Description: " + getTextVideoDescription);
			if (getTextVideoDescription.contains("MORE")) {
				extent.extentLoggerPass("Hipi feed screen:", "MORE used in the video description");
				logger.info("Hipi feed screen:" + "MORE used in the video description");
			} else {
				extent.extentLoggerWarning("Hipi feed screen:", "MORE not used in the video description");
				logger.info("Hipi feed screen:" + "MORE not used in the video description");
			}
		}

		//public void ValidateEffectUsed(String userType) throws Exception {
			//extent.HeaderChildNode("Checking effect used in feed screen");+
			//System.out.println("Hipi_Reg_036");
			//logger.info("Hipi_Reg_036:" + "Checking effect used in feed screen");
			
		//	PausePlayer();
			if (verifyIsElementDisplayed(AMDFeed.objFeedEffectData, "Used Effect element available")) {
				String effectavailable = findElement(AMDFeed.objFeedEffectData).getText();
				System.out.println("effect available in feed page:" + effectavailable);
				logger.info("Hipi feed screen:" + "Effect used available in feed screen");
				extent.extentLoggerPass("Hipi feed screen:", "Effect available");
			} else {
				logger.info("Hipi feed screen:" + "Effect used unavailable in feed screen");
				extent.extentLoggerWarning("Hipi feed screen:", "Effect used unavailable");
			}
			if (verifyElementDisplayed(HipiFeedPage.objsoundused)) {
				logger.info("user is able to view sound used");
				extent.extentLogger("", "user is able to view sound used");
				//pauseVideo();
				String soundused = getAttributValue("text", HipiFeedPage.objsoundused);
				System.out.print("sound used");
				if (soundused.equalsIgnoreCase("")) {
					logger.error("sound used is displayed blank");
					extent.extentLoggerFail("sound", "sound used is displayed blank");
				} else {
					logger.info("sound used displayed " + soundused);
					extent.extentLoggerPass("", "sound used displayed " + soundused);
				}
			} else {
				logger.info("Video has no sound used");
				extent.extentLoggerWarning("", "Video has no sound used");
			}
			
			if(verifyElementExist(HipiFeedPage.objprofilepic,"profile")) {
				click(HipiFeedPage.objprofilepic,"profile");
				logger.info("user naviagtes to profilescreen");
				extent.extentLoggerPass("","user navigates to profile screen");
			}
			else {
				logger.info("user not naviagtes to profilescreen");
				extent.extentLoggerWarning("","user not navigates to profile screen");
			}
			Back(1);
			
			extent.HeaderChildNode("Player Preview Check the list of actions present on long press popup of a video");
			System.out.println("TC_Mobile_30");
			extent.extentLogger("", "TC_Mobile_30");
			verifyElementPresentAndClick(HipiFeedPage.objFeedButton, " feed icon present");

			longPress(HipiFeedPage.objFeedLongPress);
			if (verifyElementDisplayed(HipiFeedPage.objdownloadvideo)) {
				logger.info("user is able to view download video ");
				extent.extentLoggerPass("", "user is able to view download video");
			} else {
				logger.info("user is not able to view download video ");
				extent.extentLoggerFail("", "user is not able to view download video");
			}

			if (verifyElementDisplayed(HipiFeedPage.objfavourites)) {
				logger.info("user is able to view favourites video ");
				extent.extentLoggerPass("", "user is able to view favourites video");
			} else {
				logger.info("user is not able to view favourites video");
				extent.extentLoggerFail("", "user is not able to view favourites video");
			}

			if (verifyElementDisplayed(HipiFeedPage.objnotinterested)) {
				logger.info("user is able to view notinterested video ");
				extent.extentLoggerPass("", "user is able to view notinterested video");
			} else {
				logger.info("user is not able to view notinterested video");
				extent.extentLoggerFail("", "user is not able to view notinterested video");
			}

			if (verifyElementDisplayed(HipiFeedPage.objreportvideo)) {
				logger.info("user is able to view report video ");
				extent.extentLoggerPass("", "user is able to view report video");
			} else {
				logger.info("user is not able to view report video");
				extent.extentLoggerFail("", "user is not able to view report video");
			}
			Back(1);
			//Back(1);
			
			
			extent.HeaderChildNode("Player Preview Check if 'Profile details' screen is displayed when tapped on Profile picture of a video");
			System.out.println("TC_Mobile_31");
			extent.extentLogger("", "TC_Mobile_31");
			//verifyElementPresentAndClick(HipiFeedPage.objHipiIcon, "click on Hipi Icon");
			if (verifyElementExist(HipiFeedPage.objFeedButton, "FeedButton")) {
				logger.info("user is able to view Homescreen");
				extent.extentLogger("", "user is able to view  Homescreen");
			}
			else
			{
				logger.info("user is not  able to view Homescreen");
				extent.extentLogger("", "user is not  able to view  Homescreen");
			}
			if(verifyElementExist(HipiFeedPage.objprofilepic,"profile is visible")) {
				
				String profileUsername = fetchUserNameFromVideoDescription();
				
				click(HipiFeedPage.objprofilepic,"profile pic visile");
				waitTime(3000);
				String NavigatedProfile = getAttributValue("text", HipiMePage.objHipiProfileId);
				
				if(NavigatedProfile.contains(profileUsername)){
					logger.info("user naviagtes to profile detail screen");
					extent.extentLoggerPass("","user navigates to profile detail screen");
				}
				else {
					logger.info("user  not naviagtes to profile detail screen");
					extent.extentLoggerFail("","user  not navigates to profile detail screen");
				}
			
			}
			Back(1);
			extent.HeaderChildNode("Player Preview Check if 'Comment' screen is displayed when tapped on Comment Chat Icon");
			System.out.println("TC_Mobile_32");
			extent.extentLogger("", "TC_Mobile_32");
			
				if (verifyElementDisplayed(HipiFeedPage.objcommenticon)) {
				verifyElementPresentAndClick(HipiFeedPage.objcommenticon,"comment icon present");
				
				if(verifyIsElementDisplayed(HipiFeedPage.objCommentsCommentCount, "Comments Screen")){
					logger.info("comment screen is displayed");
					extent.extentLoggerPass("", "comment screen is displayed");
				}else {
					logger.info("comment screen is not  displayed");
					extent.extentLoggerFail("", "comment screen is not displayed");
				}
				Back(1);
				}else{
					
				}
				
				
				extent.HeaderChildNode("Player Preview Check if user is able to view number of comments on played/paused video");
				System.out.println("TC_Mobile_34");
				extent.extentLogger("", "TC_Mobile_34");
				if (verifyElementDisplayed(HipiFeedPage.objcommenticon)) {
				WebElement commenticon = findElement(HipiFeedPage.objcommenticon);
				int commentuppericonY = commenticon.getLocation().getY();

				int commentlowericonY = commentuppericonY + commenticon.getSize().getHeight();

				int commentmiddleiconY = (commentuppericonY + commentlowericonY) / 2;

				Dimension windowsSize = getDriver().manage().window().getSize();

				if (commentmiddleiconY >= ((windowsSize.getHeight() / 2) + 100)) {
					logger.info("comment icon appears on the bottom right of the screen");
					extent.extentLoggerPass("", " comment icon appears on the bottom right of the screen");
				 }else {
					logger.error("comment icon not appears on the bottom right of the screen");
					extent.extentLoggerFail("", "comment icon not appears on the bottom right of the screen");
				}
				}

				if (verifyElementDisplayed(HipiFeedPage.objcommentcount)) {
				String commentcount = getAttributValue("text", HipiFeedPage.objcommentcount);
				System.out.print("comment count");
					if (commentcount.equalsIgnoreCase("")) {
						logger.error("comment count is displayed blank");
						extent.extentLoggerFail("", "comment count is displayed blank");
					} 
					else {
						logger.info("comment count displayed " + commentcount);
						extent.extentLoggerPass("", "comment count displayed " + commentcount);
					}
				}else {
					logger.info("Video has no comment used");
					extent.extentLoggerWarning("", "Video has no comment used");
			}
				
				
			
				
					//if (verifyElementDisplayed(HipiFeedPage.objcommenticon)) {
						
				
				extent.HeaderChildNode("Player Preview Check if user is able to view number of Likes on played/paused video");
				System.out.println("TC_Mobile_35");
				extent.extentLogger("", "TC_Mobile_35");
				if (verifyElementDisplayed(HipiFeedPage.objlikecount)) {
					logger.info("like icon is displayed at bottom right of the screen");
					extent.extentLoggerPass("", "like icon is displayed at bottom right of the screen");
				} else {
					logger.error("like icon is not displayed at bottom right of the screen");
					extent.extentLoggerFail("", "like icon is not displayed at bottom right of the screen");
				}
				String likescount = getAttributValue("text", HipiFeedPage.objlikecount);
				System.out.print("likes count");
				if (likescount.equalsIgnoreCase("")) {
					logger.error("likes count is displayed blank");
					extent.extentLoggerFail("likes", "likes count is displayed blank");
				} else {
					logger.info("Likes count displayed " + likescount);
					extent.extentLoggerPass("Likes", "likes count displayed : " + likescount);
				}
				
				
				extent.HeaderChildNode("Player Preview Check if user is able to view total number of Views on played/paused video");
				System.out.println("TC_Mobile_36");
				extent.extentLogger("", "TC_Mobile_36");
				//System.out.println("HiPi_Guest_031");
				String videoscount = getAttributValue("text", HipiFeedPage.objeyeicon);
				System.out.print("video count");
				if (videoscount.equalsIgnoreCase("")) {
					logger.error("videos count is displayed blank");
					extent.extentLoggerFail(" ", "videos count is displayed blank");
				} else {
					logger.info("videos count displayed " + videoscount);
					extent.extentLoggerPass("", "videos count displayed " + videoscount);
				}
				extent.HeaderChildNode("Player Preview Check on tapping anywhere on actions screen of a video , user is redirected to HiPi home screen");
				System.out.println("TC_Mobile_37");
				extent.extentLogger("", "TC_Mobile_37");
				waitTime(3000);
				longPress(HipiFeedPage.objFeedLongPress);
				if (verifyIsElementDisplayed(HipiFeedPage.objdownloadvideo,"Download Video")) {
					logger.info("user is able to view download video ");
					extent.extentLoggerPass("", "user is able to view download video");
					Back(1);
				} else {
					logger.info("user is not able to view download video ");
					extent.extentLoggerFail("", "user is not able to view download video");
				}
				waitTime(3000);
				longPress(HipiFeedPage.objFeedLongPress);
				if (verifyIsElementDisplayed(HipiFeedPage.objfavourites,"Add to favourites")) {
					click(HipiFeedPage.objfavourites,"favourites present");
					verifyElementExist(HipiFeedPage.objaddtofavouritepopup,"favourite popup present");
					
				} else {
					extent.extentLoggerWarning("", "Add to Favourites is not displayed");
				}
				waitTime(3000);
				longPress(HipiFeedPage.objFeedLongPress);
				if (verifyIsElementDisplayed(HipiFeedPage.objnotinterested,"Not interested")) {
					logger.info("user is able to view notinterested video ");
					extent.extentLoggerPass("", "user is able to view notinterested video");
					Back(1);
				} else {
					logger.info("user is not able to view notinterested video");
					extent.extentLoggerFail("", "user is not able to view notinterested video");
				}
				waitTime(3000);
				longPress(HipiFeedPage.objFeedLongPress);
				if (verifyIsElementDisplayed(HipiFeedPage.objreportvideo,"Report video")) {
					logger.info("user is able to view report video ");
					extent.extentLoggerPass("", "user is able to view report video");
					Back(1);
				} else {
					logger.info("user is not able to view report video");
					extent.extentLoggerFail("", "user is not able to view report video");
				}
			//	Back(1);
			//	Back(1);

			}
		}


public void touchOnCommentArrow(){
	 TouchAction action = new TouchAction(getDriver());
	 waitTime(5000);

	 Dimension size = getDriver().findElement(HipiFeedPage.objEmptyCommentBox).getSize();
	 
	 WebElement ele = getDriver().findElement(HipiFeedPage.objEmptyCommentBox);
	 Point point = ele.getLocation();
	 
	 System.out.println(point.getX());
	 System.out.println(point.getY());
	 System.out.println(size.height);
	 System.out.println(size.width);
	 
	 int X = point.getX();
	 int Y = point.getY();    			 
	 int height = size.height;
	 int width = size.width;   
	 
	 float height1 = height / 2;
	 
	 float width1 = width / 10;
	 
	 float pointY = Y+height1;
	 float pointX = width+width1;
	 
	 int pY = (int)pointY;
	 System.out.println(pY);
	 int pX = (int)pointX;
	 System.out.println(pX);
	 
	 action.press(PointOption.point(pX, pY)).release().perform();

}


public void CommentsectionValidation(String userType) throws Exception{
	
	if(userType.equalsIgnoreCase("Guest")) {
	extent.HeaderChildNode("user should see login/register pop up display when not registered or loogin to Zee5/HiPi");
	System.out.println("TC_Mobile_39");
	extent.extentLogger("", "TC_Mobile_39");
//	if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
//		click(AMDOnboardingScreen.objHipiButton, "HiPi");
//		Thread.sleep(6000);
//
//	} else {
//
//	}
	// TODO Auto-generated method stub
	
        verifyElementPresentAndClick(HipiFeedPage.objcommenticon,"comment icon present");
		//click(HipiFeedPage.objcommenticon,"comment icon present");
        registerPopUp();
        if (verifyIsElementDisplayed(AMDHipi.objRegisterforVibe)) {
    		logger.info("Register Pop Up is displayed");
    		extent.extentLoggerPass("Register Pop Up", "Register Pop Up is displayed");
    	} else {
    		logger.info("Register Pop Up is not displayed");
    		extent.extentLoggerFail("Register Pop Up", "Register Pop Up is not displayed");
    	}
        Back(1);
        
        extent.HeaderChildNode("User is unable to view 'comment screen' unless user enter valid login details");
   	 System.out.println("TC_Mobile_41,TC_Mobile_80");
   	 extent.extentLogger("", "TC_Mobile_41,TC_Mobile_80");
   //	verifyElementPresentAndClick(HipiFeedPage.objcommenticon,"comment icon present");
	//click(HipiFeedPage.objcommenticon,"comment icon present");
   // registerPopUp();
   	pauseVideo();
	Thread.sleep(3000);
	verifyElementPresentAndClick(HipiFeedPage.objplaybutton, "playbutton");
	Thread.sleep(3000);
	pauseVideo();
	Thread.sleep(3000);
	if (verifyElementDisplayed(HipiFeedPage.objplaybutton)) {
		logger.info("user is able to view played video is paused with paused icon");
		extent.extentLoggerPass("", "user is able to view played video is paused with paused video");
	} else {
		logger.info("user is not able to view played video is paused with paused icon");
		extent.extentLoggerFail("", "user is not able to view played video is paused with paused icon");
	}
	
	verifyElementPresentAndClick(HipiFeedPage.objcommenticon,"comment icon present");
	
    if(verifyElementExist(HipiFeedPage.objloginregister,"login button present")) {
    	click(HipiFeedPage.objloginregister,"login present");
    	logger.info("user is directed to login screen");
    	extent.extentLogger("", "user is directed to login screen");
    
    }else {
    	logger.info("user is not directed to login screen");
    	extent.extentLoggerFail("", "user is not directed to login screen");
    
    }
    String Username = getParameterFromXML("NonsubscribedUserName");
	String Password = getParameterFromXML("NonsubscribedPassword");

   // click(AMDLoginScreen.objEmailIdField, "Email field");
	//hideKeyboard();
	type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
	hideKeyboard();
	verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
	verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
	type(AMDLoginScreen.objPasswordField, Password, "Password field");
	hideKeyboard();
	verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
	waitTime(9000);
	verifyElementPresentAndClick(HipiFeedPage.objcommenticon,"comment icon present");
	if(verifyElementExist(HipiFeedPage.objEmptyCommentBox,"comment icon present")) {
		logger.info("user is able to view comment screen after logging with login credentials");
		extent.extentLogger("", "user is able to view comment screen after logging with login credentials");
	}else {
		logger.info("user is not able to view comment screen after logging with login credentials");
		extent.extentLogger("", "user is not able to view comment screen after logging with login credentials");
	}
	
	BackToFeedScreen();
	click(HipiFeedPage.objFeedScreenBackButton, "Back Button in Feed Screen");
	logout();
	
	 if (verifyElementExist(HipiFeedPage.objHipiIcon, "HiPi")) {
			click(AMDOnboardingScreen.objHipiButton, "HiPi");
			Thread.sleep(6000);

		} else {

		}
	
	}
 
	if(userType.equalsIgnoreCase("NonSubscribedUser")) 
    {
        	extent.HeaderChildNode("user should see the listed items in comment section as mentioned in Steps");
        	System.out.println("TC_Mobile_40");
        	extent.extentLogger("", "TC_Mobile_40");
        	BackToFeedScreen();
        	
  
        	for(int i=1; i<=20; i++)
        	{
        		String feedCommentCount = getAttributValue("text", HipiFeedPage.objCommentCount);
        		int feedCommentCountnumber = Integer.parseInt(feedCommentCount);
        		if(feedCommentCountnumber==0)
        		{
        			extent.extentLogger("", "0 Comments to the video");
               	 	verifyElementPresentAndClick(HipiFeedPage.objcommenticon,"comment icon present");        			
               	 	break;
        		}else{
        			Swipe("UP", 1);
        		}	
        	}

        	 if(verifyElementExist(HipiFeedPage.objcommenttitle,"comment title present")) {
        		 String commenttitlecount = getAttributValue("text",HipiFeedPage.objcommenttitle);
        		 
        			 if(commenttitlecount.contains("Comments (0)")) { 
        				 logger.info("Comments count is 0 in title");
        				 extent.extentLoggerPass("", "Comments count is 0 in title");
        			 }else {
        				 extent.extentLoggerFail("", "Comments count is not 0 in title");
        			 }
        	 }else {
        		 
        		 extent.extentLoggerFail("", "Commenttitle is not available");
        	 }
        	 
        	 
        	 if(verifyIsElementDisplayed(HipiFeedPage.objcommentpopup, "Be First to comment")){
        		 extent.extentLoggerPass("", "Be the first one to comment is displayed");
        	 }else{
        		 extent.extentLoggerFail("", "Be the first one to comment is not displayed");        		 
        	 }
        	 

        	 if(verifyElementExist(HipiFeedPage.objprofilepiccomment,"profile picture present")) {
        		 logger.info("user is able to view empty profile picture icon");
        		 extent.extentLoggerPass("","user is able to view empty profile picture icon");
        	 }else {
        		 logger.info("user is not  able to view empty profile picture icon");
        		 extent.extentLoggerFail("","user is not able to view empty profile picture icon");
        	 }
        	 
        	 
        	 Back(1);
        	 
        	extent.HeaderChildNode("As maximum limit of add comments ,user not allowed to add text");
        	System.out.println("TC_Mobile_44");
        	extent.extentLogger("", "TC_Mobile_44");
        	
        	for(int i=1; i<=10; i++){
        		String feedCommentCount = getAttributValue("text", HipiFeedPage.objCommentCount);
        		int feedCommentCountnumber = Integer.parseInt(feedCommentCount);
        		if(feedCommentCountnumber>=1){
               	 verifyElementPresent(HipiFeedPage.objcommenticon,"comment icon present");        			
               	 break;
        		}else{
        			Swipe("UP", 1);
        		}	
        	}
        	
        	if (verifyElementDisplayed(HipiFeedPage.objcommenticon)) {
        		
        		String commentCountText = getAttributValue("text", HipiFeedPage.objCommentCount);
        		int commentCount = Integer.parseInt(commentCountText);
        		
        		click(HipiFeedPage.objcommenticon,"comment icon present");

        		String CommentTitleCount = getAttributValue("text", HipiFeedPage.objCommentsCommentCount);
        		
        		if(CommentTitleCount.contains(commentCountText)){
        			extent.extentLoggerPass("", "Comments count matched after navigating to commnents section");
        		}else{
        			extent.extentLoggerFail("", "Comments count not matched after navigating to commnents section");
        		}
        		
        		 if(verifyElementExist(HipiFeedPage.objFeedCommentorProfilepicDataundercomment,"comment  present")) {
    				 logger.info(" user is able to view comments  available");
    				 extent.extentLoggerPass("", "user is able to view comments available");
    			 }else {
    				 
    				 extent.extentLoggerWarning("", "There are no comments available");
    			 }
        		
        		 if(commentCount >= 8){

        			 String usernameOfComment1 = fetchUsernameFromcomment();
        			 System.out.println(usernameOfComment1);
        			 PartialCommentsSwipe("UP", 2);
        			 
        			 String usernameOfComment2 = fetchUsernameFromcomment();
        			 System.out.println(usernameOfComment2);
        			 if(usernameOfComment1.contains(usernameOfComment2)){
        				 extent.extentLoggerFail("", "not able to scroll the comments");
        			 }else{
        				 extent.extentLoggerPass("", "able to scroll the comments");
        			 }
        		 }
        		 
        		 if(verifyIsElementDisplayed(HipiFeedPage.objEmptyCommentBox, "Comment Box")){
        			 
        			 String commentValue = getAttributValue("text", HipiFeedPage.objEmptyCommentBox);
        			 
        			 if(commentValue.contains("Add a comment")){
        				 extent.extentLoggerPass("", "Add a comment is displayed");
        			 }else{
        				 extent.extentLoggerFail("", "Add a comment is not displayed");
        			 }
        			 
        			 click(HipiFeedPage.objEmptyCommentBox, "Comment Box");
        			 
        			 String commentInputValue = fetchcommentInputCountof200();
        			 int initialValue = Integer.parseInt(commentInputValue);
        			 System.out.println(initialValue);
        			 type(HipiFeedPage.objEmptyCommentBox, "a", "Comment box");
        			 
        			 String commentInputValue1 = fetchcommentInputCountof200();
        			 int initialValue1 = Integer.parseInt(commentInputValue1);
        			 System.out.println(initialValue1);
        			 
        			 if(initialValue<initialValue1){
        				 extent.extentLoggerPass("", "Count increased");
        			 }else{
        				 extent.extentLoggerFail("", "Count not increased");        				 
        			 }
        			 
        			 
        			type(HipiFeedPage.objcommentbox, RandomStringGenerator(202), "text");
        			String commentInputValue2 = fetchcommentInputCountof200();
        			int initialValue2 = Integer.parseInt(commentInputValue2);
        			System.out.println(initialValue2);
        			hideKeyboard();
        			if(initialValue2==200){
        				extent.extentLoggerPass("", "User is able to enter only 200 characters");
        			}else{
        				extent.extentLoggerFail("", "User is able to enter more than 200 characters");        				
        			}
        			
        			BackToFeedScreen();
        		 }else{
        			 
        		 }
        		 

        		 
//        		String comment1 = fetchcommentFromVideoDescription();
//				System.out.println("UserName1 : " + comment1);
//				logger.info("UserName1 : " + comment1);
//				type(HipiFeedPage.objcommentbox, "super", "text used");
//				String comment2 = fetchcommentFromVideoDescription();
//				System.out.println("UserName1 : " + comment2);
//				logger.info("UserName1 : " + comment2);
//				//type(HipiFeedPage.objcommentbox, "superr", "text used");
//				Swipe("UP",2);
//        	if(!(comment1.equals(comment2))) {
//				logger.info("number of charecters has been increased and able to scroll");
//        	extent.extentLogger("","number of characters has been increased and able to scroll");
//				
//        	 
//        	}
        }
        else {
        	
        } 
        	
        	extent.HeaderChildNode("Creator tag should be displayed in front of comment added by creator");
        	System.out.println("TC_Mobile_50");
        	extent.extentLogger("", "TC_Mobile_50");
        	
        	for(int i=1; i<=10; i++){
        		String feedCommentCount = getAttributValue("text", HipiFeedPage.objCommentCount);
        		int feedCommentCountnumber = Integer.parseInt(feedCommentCount);
        		if(feedCommentCountnumber>=1){
               	 verifyElementPresentAndClick(HipiFeedPage.objcommenticon,"comment icon present");        			
               	 break;
        		}else{
        			Swipe("UP", 1);
        		}	
        	}
        	
        	if (verifyElementDisplayed(HipiFeedPage.objcommenticon)) {
        		String usernameOfComment = fetchUsernameFromcomment();
        		
        		if(usernameOfComment.contains("@")){
        			extent.extentLoggerPass("", "Creator tag is displayed in front of the comment");
        		}else{
        			extent.extentLoggerFail("", "Creator tag is not displayed in front of the comment");
        		}	
        	}

        	BackToFeedScreen();
        	
        	
        	
           	extent.HeaderChildNode("Count of comments should match in both HiPi home screen & comments screen");
        	System.out.println("TC_Mobile_62");
        	extent.extentLogger("", "TC_Mobile_62");

        	for(int i=1; i<=10; i++){
        		String feedCommentCount = getAttributValue("text", HipiFeedPage.objCommentCount);
        		int feedCommentCountnumber = Integer.parseInt(feedCommentCount);
        		if(feedCommentCountnumber>=1){
               	 verifyElementPresent(HipiFeedPage.objcommenticon,"comment icon present");        			
               	 break;
        		}else{
        			Swipe("UP", 1);
        		}	
        	}


if (verifyElementDisplayed(HipiFeedPage.objcommenticon)) {
        		
        		String commentCountText = getAttributValue("text", HipiFeedPage.objCommentCount);
        		int commentCount = Integer.parseInt(commentCountText);
        		
        		click(HipiFeedPage.objcommenticon,"comment icon present");

        		String CommentTitleCount = getAttributValue("text", HipiFeedPage.objCommentsCommentCount);
        		
        		if(CommentTitleCount.contains(commentCountText)){
        			extent.extentLoggerPass("", "Comments count matched after navigating to commnents section");
        		}else{
        			extent.extentLoggerFail("", "Comments count not matched after navigating to commnents section");
        		}
}

        	
          	 
          	 extent.HeaderChildNode("Profile picture should be displayed in front of the comment added by creator");
          	 System.out.println("TC_Mobile_52");
          	 extent.extentLogger("", "TC_Mobile_52");
          	 if(verifyElementExist(HipiFeedPage.objProfilePicWithComment,"comment profilePic")) { 
        			 logger.info("profile picture displayed infront of comment");
        			 extent.extentLoggerPass("", "profile picture displayed infront of comment");
        	 }else
        	 {
        			 extent.extentLoggerFail("", "user is not able to view profile picture displayed infront of comment");
        	 }
        	 

	 
          	extent.HeaderChildNode("User should be able to view profile picture of another viewer, who has commented on the video"); 
          	System.out.println("TC_Mobile_53");
          	extent.extentLogger("", "TC_Mobile_53");
          	
          	String commentorProfilePicName = fetchUsernameFromcomment();
          	extent.extentLogger("", commentorProfilePicName);
          	click(AMDFeed.objFeedCommentorProfilepic, "Commentor profile pic clicked");
          	waitTime(5000);
          	String navigatedProfileName = getAttributValue("text", HipiMePage.objHipiProfileId);
          	extent.extentLogger("", navigatedProfileName);
          	if(navigatedProfileName.contains(commentorProfilePicName)){
          		logger.info("Hipi feed screen:"
						+ "commentor profile redirected when profile of commentor clicked in comment dialog");
				extent.extentLoggerPass("Hipi feed screen:", "Profile pic navigate to user profile");
				Back(1);
			} else {
				logger.info("Hipi feed screen:" + "Compare commentor name before and after clicking profile image");
				extent.extentLoggerFail("Hipi feed screen:", "Profile pic navigate to user profile invalid");
				Back(1);
          	}
    		
    		//Back(1);
    		
    		extent.HeaderChildNode("User should be able to view time of comment of another viewer");
    		System.out.println("TC_Mobile_54");
    		extent.extentLogger("", "TC_Mobile_54");
    		String timeofcomment = getAttributValue("text", HipiFeedPage.objtimeofcomment);
			System.out.print("\n time of comment");
			if (timeofcomment.equalsIgnoreCase("")) {
				logger.error("user is able to see time of comment");
				extentLoggerFail("", "user is able not to see time off comment");
			} else {
				logger.info("time of comment displayed " + timeofcomment);
				extentLoggerPass("", "time of comment dispalyed " + timeofcomment);
			}

	
        	BackToFeedScreen();
        	
	 }
        	 
 
}
    		
    		
	






    	
          	 
       	


		
		
		
	
public String fetchUsernameFromcomment() throws Exception {

	String description = getText(HipiFeedPage.objFirstCommentFromCommentScreen);
	String comment = description.split(" ")[0];
	return comment;
}
	
public String fetchcommentInputCountof200() throws Exception {

	String description = getText(HipiFeedPage.objcommentdescription);
	String value = description.split("/")[0];

	return value;
}

	

	
	public String fetchcommentFromVideoDescription() throws Exception {

		String description = getText(HipiFeedPage.objcommentdescription);
		System.out.println("description");
		String comment = description.split(" ")[0];

		return comment;
	}
		public String fetchcommentprofileFromVideoDescription() throws Exception {

			String description = getText(HipiFeedPage.objFeedCommentorProfilepicDataundercomment);
			System.out.println("description");
			String profile = description.split(" ")[0];

			return profile;

		}
		public String fetchcommentcountFromVideoDescription() throws Exception {

			String description = getText(HipiFeedPage.objcommentcountundercomment);
			System.out.println("description");
			String [] words=description.split(" ");
			String lastword=words[words.length-1];
			return lastword;
			
		}
	
	


public void pauseVideo() throws Exception {
for (int i = 1; i <= 10; i++) {
	try {
		if (verifyIsElementDisplayed(HipiFeedPage.objplaybutton)) {
			System.out.println("Video is already paused");
			break;
		} else {
			AndroidTouchAction touch = new AndroidTouchAction(getDriver());
			int heightOfScreen = getDriver().manage().window().getSize().getHeight();
			int widthOfScreen = getDriver().manage().window().getSize().getWidth();
			int x = widthOfScreen / 2;
			int y = heightOfScreen / 2;
			touch.tap(PointOption.point(x, y)).perform();

			if (verifyElementExist(HipiFeedPage.objplaybutton, "playbutton")) {
				System.out.println("Video Paused");
				extent.extentLogger("", "Video Paused");
				break;
			}
		}
	} catch (Exception e) {
		if (verifyIsElementDisplayed(HipiFeedPage.objplaybutton)) {
			System.out.println("Video is already paused");
			break;
		} else {
			AndroidTouchAction touch = new AndroidTouchAction(getDriver());
			int heightOfScreen = getDriver().manage().window().getSize().getHeight();
			int widthOfScreen = getDriver().manage().window().getSize().getWidth();
			int x = widthOfScreen / 2;
			int y = heightOfScreen / 2;
			touch.tap(PointOption.point(x, y)).perform();

			if (verifyElementExist(HipiFeedPage.objplaybutton, "playbutton")) {
				System.out.println("Video Paused");
				extent.extentLogger("", "Video Paused");
				break;
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

public void ReportVideo(String userType) throws Exception {
// TODO Auto-generated method stub
if(userType.equalsIgnoreCase("Guest")) {
	extent.HeaderChildNode("User should not be allowed to report a video");
	System.out.println("TC_Mobile_64");
	extent.extentLogger("", "TC_Mobile_64");
	longPress(HipiFeedPage.objFeedLongPress);
	if (verifyElementDisplayed(HipiFeedPage.objreportvideo)) {
		click(HipiFeedPage.objreportvideo,"report video present");
		registerPopUp();
		logger.info("user is not able to allow  to report a video ");
		extent.extentLoggerPass("", "Guest user is not able to allow to report video");
	} else {
		logger.info("user is not able to view report video");
		extent.extentLoggerFail("", "user is  not able to view report video");
	}
	Back(1);
	
}
if(userType.equalsIgnoreCase("NonSubscribedUser")) {
	extent.HeaderChildNode("User should be able to report a video ");
	System.out.println("TC_Mobile_65");
	extent.extentLogger("", "TC_Mobile_65");
	verifyElementExist(HipiFeedPage.objFeedButton, "FeedButton");
	longPress(HipiFeedPage.objFeedLongPress);
	if (verifyElementDisplayed(HipiFeedPage.objreportvideo)) {
		click(HipiFeedPage.objreportvideo,"report video present");
		//registerPopUp();
		logger.info("user is able to view report a video ");
		extent.extentLoggerPass("", "user is able to view report video");
	} else {
		logger.info("user is not able to view report video");
		extent.extentLoggerFail("", "user is  not able to view report video");
	}
	if(verifyElementExist(HipiFeedPage.objselectreason,"reason present")) {
		click(HipiFeedPage.objselectreason,"reason present");
		verifyElementPresentAndClick(HipiFeedPage.objreasontype,"reason present");
	}else {
		
	}
	if(verifyElementExist(HipiFeedPage.objselectcategory,"category  present")) {
		click(HipiFeedPage.objselectcategory,"category present");
		verifyElementPresentAndClick(HipiFeedPage.objcategorytype,"category present");
	}else {
		
	}
	if(verifyElementExist(HipiFeedPage.objdescriptionlayer,"description layer present")) {
	type(HipiFeedPage.objdescriptiontext, "abcd", "text used");
//	verifyElementPresentAndClick(HipiFeedPage.objattachbutton,"attach button present");
//	if (verifyElementExist(HipiCreateVideoPage.objaccesspictures, "click on zee5 picture permission")) {
//		// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
//		// on create a video");
//		verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "click on zee5 picture permission");
//		verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "click on allow button");
//	}
//	verifyElementPresentAndClick(HipiFeedPage.objattachthumbnailone,"thumbnail present");
	verifyElementPresentAndClick(HipiFeedPage.objsubmitbutton,"submit button present");
	//Thread.sleep(1000);
	verifyIsElementDisplayed(HipiFeedPage.objreportvideopopup,"popup present");
	Thread.sleep(1000);
	logger.info("user is able to report video");
	extent.extentLogger("", "user is able to report video");
}else {
	logger.info("user is not able to report video");
	extent.extentLogger("", "user is not able to report video");
}


extent.HeaderChildNode("User should be able to redirect to Hipi Homescreen on tapping navigation key");
System.out.println("TC_Mobile_66");
extent.extentLogger("", "TC_Mobile_66");
longPress(HipiFeedPage.objFeedLongPress);
if (verifyElementDisplayed(HipiFeedPage.objreportvideo)) {
	click(HipiFeedPage.objreportvideo,"report video present");
	//registerPopUp();
	verifyElementPresentAndClick(HipiFeedPage.objbackbuttonreportvideo,"report video present");
	logger.info("user is  able to redirect to HipiHomescreen tapping navigation key ");
	extent.extentLoggerPass("", "user is  able to redirect to HipiHomescreen tapping navigation key");
} else {
	logger.info("user is  not able to redirect to HipiHomescreen tapping navigation key");
	extent.extentLoggerFail("", "user is not  able to redirect to HipiHomescreen tapping navigation key");
}

extent.HeaderChildNode("User should be able to verify the contents of Report video screen");
System.out.println("TC_Mobile_67");
extent.extentLogger("", "TC_Mobile_67");
longPress(HipiFeedPage.objFeedLongPress);
if (verifyElementDisplayed(HipiFeedPage.objreportvideo)) {
	click(HipiFeedPage.objreportvideo,"report video present");
	//registerPopUp();
	logger.info("user is  able to view report a video ");
	extent.extentLoggerPass("", "user is  able to view report video");
} else {
	logger.info("user is not able to view report video");
	extent.extentLoggerFail("", "user is  not able to view report video");
}
Back(1);
longPress(HipiFeedPage.objFeedLongPress);
if (verifyElementDisplayed(HipiFeedPage.objreportvideo)) {
	click(HipiFeedPage.objreportvideo,"report video present");
	//registerPopUp();
	verifyElementPresentAndClick(HipiFeedPage.objbackbuttonreportvideo,"report video present");
	logger.info("user is  able to redirect to HipiHomescreen tapping navigation key ");
	extent.extentLoggerPass("", "user is  able to redirect to HipiHomescreen tapping navigation key");
} else {
	logger.info("user is  not able to redirect to HipiHomescreen tapping navigation key");
	extent.extentLoggerFail("", "user is not  able to redirect to HipiHomescreen tapping navigation key");
}

longPress(HipiFeedPage.objFeedLongPress);
verifyElementPresentAndClick(HipiFeedPage.objreportvideo,"report video present");
if(verifyElementExist(HipiFeedPage.objselectreason,"reason present")) {
	click(HipiFeedPage.objselectreason,"reason present");
	verifyElementPresentAndClick(HipiFeedPage.objreasontype,"reason present");
}else {
	
}
if(verifyElementExist(HipiFeedPage.objselectcategory,"category  present")) {
	click(HipiFeedPage.objselectcategory,"category present");
	verifyElementPresentAndClick(HipiFeedPage.objcategorytype,"category present");
}else {
	
}
if(verifyElementExist(HipiFeedPage.objdescriptionlayer,"description layer present")) {
type(HipiFeedPage.objdescriptiontext, "abcd", "text used");

verifyElementPresentAndClick(HipiFeedPage.objsubmitbutton,"submit button present");
//Thread.sleep(1000);
if(verifyIsElementDisplayed(HipiReportProfileScreen.objSubmitButton, "Submit Button")) {

	logger.info("Reported Profile:" + "user is not able to perform Report Video action");
	extent.extentLoggerFail("Reported Profile:","user is not able to perform Report Video action");
	
} else {
	logger.info("Reported Profile:" + "user is able to perform Report Video action");
	extent.extentLoggerPass("Reported Profile:","user is able to perform Report Video action");
}	
Thread.sleep(1000);
logger.info("user is able to report video");
extent.extentLogger("", "user is able to report video");
}else {
logger.info("user is not able to report video");
extent.extentLogger("", "user is not able to report video");
}



extent.HeaderChildNode("User should be allowed to enter 150 characters in the description");
System.out.println("TC_Mobile_69");
extent.extentLogger("", "TC_Mobile_69");
longPress(HipiFeedPage.objFeedLongPress);
verifyElementPresentAndClick(HipiFeedPage.objreportvideo,"report video present");
if(verifyElementExist(HipiFeedPage.objselectreason,"reason present")) {
	click(HipiFeedPage.objselectreason,"reason present");
	verifyElementPresentAndClick(HipiFeedPage.objreasontype,"reason present");
}else {
	
}
if(verifyElementExist(HipiFeedPage.objselectcategory,"category  present")) {
	click(HipiFeedPage.objselectcategory,"category present");
	verifyElementPresentAndClick(HipiFeedPage.objcategorytype,"category present");
}else {
	
}
if(verifyElementExist(HipiFeedPage.objdescriptionlayer,"description layer present")) {
	//click(HipiFeedPage.,"comment icon present");
	String report1 =fetchFromReportvideoDescriptioncountof150();
	System.out.println("Report count : " +report1);
	logger.info("Report count  : " + report1);

	click(HipiFeedPage.objdescriptiontext, "Report Description");
	type(HipiFeedPage.objdescriptiontext, RandomStringGenerator(155), "text");
	hideKeyboard();
	String report2 =fetchFromReportvideoDescriptioncountof150();
	int reportCountAfterInput = Integer.parseInt(report2);
	System.out.println("Report count 1 : " + report2);
	logger.info("Report count 1 : " + report2);
	
//verifyElementPresentAndClick(HipiFeedPage.objattachbutton,"attach button present");
//if (verifyElementExist(HipiCreateVideoPage.objaccesspictures, "click on zee5 picture permission")) {
	// verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click
	// on create a video");
	//verifyElementPresentAndClick(HipiCreateVideoPage.objaccesspictures, "click on zee5 picture permission");
	//verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "click on allow button");
//}
//verifyElementPresentAndClick(HipiFeedPage.objattachthumbnailone,"thumbnail present");
verifyElementPresentAndClick(HipiFeedPage.objsubmitbutton,"submit button present");
//Thread.sleep(1000);
verifyElementExist(HipiFeedPage.objreportvideopopup,"popup present");
Thread.sleep(1000);

if(reportCountAfterInput==150){
	logger.info("user is able to allow 150 characters in description");
	extent.extentLogger("", "user is able to allow 150 characters in description");
	}else {
	logger.info("user is not able to allow 150 characters in description");
	extent.extentLogger("", "user is not able to allow 150 characters in description");
	}
}

extent.HeaderChildNode("Report Check the contents of selection category and reason");
System.out.println("TC_Mobile_68");
extent.extentLogger("","TC_Mobile_68");
longPress(HipiFeedPage.objFeedLongPress);
Thread.sleep(10000);
if (verifyElementExist(AMDFeed.objFeedLongPressReport, "Report Video button available")) {
	Thread.sleep(2000);
	click(AMDFeed.objFeedLongPressReport, "Report Video");
	Thread.sleep(10000);
	if (verifyElementExist(AMDFeed.objFeedReportVideoPage, "Report Video Page")) {
		logger.info("Hipi feed screen:" + "Report video page available");
		verifyElementPresent(AMDFeed.objFeedReportreason, "Reason box");
		logger.info("Hipi feed screen:" + "Reason box available");
		click(AMDFeed.objFeedReportreason, "Reason box clicked");
		Thread.sleep(3000);
		click(AMDFeed.objFeedReportreasondata, "Reason data clicked");
		Thread.sleep(5000);
		logger.info("Hipi feed screen:" + "Category box available");
		verifyElementPresent(AMDFeed.objFeedReportcategory, "Category box");
		click(AMDFeed.objFeedReportcategory, "Category box clicked");
		Thread.sleep(3000);
		click(AMDFeed.objFeedReporcategorydata, "Category data clicked");
		Thread.sleep(5000);
		verifyElementPresent(AMDFeed.objFeedReportsubmit, "Submit button");
		click(AMDFeed.objFeedReportsubmit, "Video reported submit button");
		if(verifyIsElementDisplayed(HipiReportProfileScreen.objSubmitButton, "Submit Button")) {

			logger.info("Reported Profile:" + "user is not able to perform Report Video action");
			extent.extentLoggerFail("Reported Profile:","user is not able to perform Report Video action");
			
		} else {
			logger.info("Reported Profile:" + "user is able to perform Report Video action");
			extent.extentLoggerPass("Reported Profile:","user is able to perform Report Video action");
		}	
	} else {
		logger.info("Hipi feed screen:" + "Video report page unavailable");
	}
}
}

}





public void likeandunlikevalidation(String userType)throws Exception{
	if(userType.equalsIgnoreCase("NonSubscribedUser")) {
		
	extent.HeaderChildNode("User should be able to see like count of a comment");
	System.out.println("TC_Mobile_76");
	extent.extentLogger("", "TC_Mobile_76");
	verifyElementExist(HipiFeedPage.objFeedButton, "FeedButton");
	
	for(int i=1; i<=10; i++){
		String feedCommentCount = getAttributValue("text", HipiFeedPage.objCommentCount);
		int feedCommentCountnumber = Integer.parseInt(feedCommentCount);
		if(feedCommentCountnumber>=1){
       	 verifyElementPresent(HipiFeedPage.objcommenticon,"comment icon present");        			
       	 break;
		}else{
			Swipe("UP", 1);
		}	
	}
	
	if (verifyElementDisplayed(HipiFeedPage.objcommenticon)) {
		
		String commentCountText = getAttributValue("text", HipiFeedPage.objCommentCount);
		int commentCount = Integer.parseInt(commentCountText);
		extent.extentLogger("", "Comment count : "+commentCountText);
		
		click(HipiFeedPage.objcommenticon,"comment icon present");

		String CommentTitleCount = getAttributValue("text", HipiFeedPage.objCommentsCommentCount);
		extent.extentLogger("", "Comment title count : "+CommentTitleCount);
		if(CommentTitleCount.contains(commentCountText)){
			extent.extentLoggerPass("", "Comments count matched after navigating to commnents section");
		}else{
			extent.extentLoggerFail("", "Comments count not matched after navigating to commnents section");
		}
		
		if(verifyElementExist(HipiFeedPage.objFeedCommentorProfilepicDataundercomment,"comment")) { 
			String likescount = getAttributValue("text", HipiFeedPage.objcommentlikecount);
			System.out.print("likes count");
			if (likescount.equalsIgnoreCase("")) {
				logger.error("likes count is displayed blank");
				extentLoggerFail("likes", "likes count is displayed blank");
			} else {
				logger.info("Likes count displayed " + likescount);
				extentLoggerPass("Likes", "likes count displayed " + likescount);
				logger.info("user is able to see likes count of a comment");
				extent.extentLogger("", "user is able to see like count of comment");
			}
			BackToFeedScreen();
		 }	
	}else{
		extent.extentLogger("", "Comment is not displayed");
	}
}
}


//extent.HeaderChildNode("User should be able to redirect to Hipi Homescreen on tapping navigation key");
//System.out.println("TC_Mobile_66");


public String fetchFromReportvideoDescriptioncountof150() throws Exception {
String description = getText(HipiFeedPage.objreportvideodescriptioncounter);
String value = description.split("/")[0];
return value;
}




public void VideoLikeDislikeFunctionality(String userType) throws Exception{
	if(userType.equalsIgnoreCase("NonSubscribedUser")) {
	extent.HeaderChildNode("Player Preview Check if user is able to like a video on played/paused video");
	System.out.println("TC_Mobile_05 & TC_Mobile_49");		
	extent.extentLogger("", "TC_Mobile_05 & TC_Mobile_49");

	validatingScreenDisplayed(HipiFeedPage.objFeedButton, "Hipi Home", HipiFeedPage.objBottomMenuHighlighted, "Hipi Home screen" );
	Wait(2);
	//verify tab is highlighted
	verifyElementDisplayed(HipiFeedPage.objBottomMenuHighlighted1(HipiFeedPage.FeedScreen));
	if(verifyIsElementDisplayed(HipiFeedPage.objHeartIcon)) {
		logger.info("Heart icon is displayed on player screen ");
		extent.extentLoggerPass("Heart icon is displayed on player screen ","");
	} else {
		logger.error("Heart icon is not displayed on player screen ");
		extent.extentLoggerFail("Heart icon is not displayed on player screen ","");
	}
	verifyCountIncrease();
	
	extent.HeaderChildNode("Player Preview Check if user is able to Dislike a video on played/paused video");
	System.out.println("TC_Mobile_06");		
	extent.extentLogger("", "TC_Mobile_06");
	verifyCountDecrease();
	
	extent.HeaderChildNode("Player Preview Check if user is able to Like/Dislike a multiple video");
	System.out.println("TC_Mobile_07");		
	extent.extentLogger("", "TC_Mobile_07");
	
	Swipe("UP",1);
	verifyCountIncrease();
	verifyCountDecrease();
	
	extent.HeaderChildNode("Comment Check if user is able to like/dislike mutiple comments");
	System.out.println("TC_Mobile_77");		
	extent.extentLogger("", "TC_Mobile_77");
	if (verifyElementDisplayed(HipiFeedPage.objcommentcount)) {
		String commentcount = getAttributValue("text", HipiFeedPage.objcommentcount);
		System.out.print("comment count");
		if (commentcount.equalsIgnoreCase("")) {
			logger.error("comment count is displayed blank");
			extentLoggerFail("", "comment count is displayed blank");
		}else
		{
			logger.info("comment count displayed " + commentcount);
			extentLoggerPass("", "comment count displayed : " + commentcount);
		}
	}else {
		logger.info("Video has no comment used");
		extent.extentLogger("", "Video has no comment used");
		
	}
	

	//Verify comment icon is displayed
	
	
	waitTime(5000);
	verifyElementPresent(HipiFeedPage.objcommenticon, "Comment icon");
	
	for(int i=1; i<=20; i++) {
		waitTime(5000);
		verifyElementPresent(HipiFeedPage.objcommentcount, "Comment count");
		String commentCount = getText(HipiFeedPage.objcommentcount);
		int count = Integer.parseInt(commentCount); 
		System.out.println(count);
	if(count>=2)
	{
		verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "Comment icon");
		break;
	}
	else
	{	
		Swipe("UP",1);	
		waitTime(1000);
	
		}
	}
	
	waitTime(5000);
	//verify comment count increase
	
	verifycommentCountIncrease(HipiFeedPage.objCommentHeartIconGrey,HipiFeedPage.objcommentlikecount);
	verifycommentCountIncrease(HipiFeedPage.objCommentHeartIconGrey1,HipiFeedPage.objcommentlikecount1);
	waitTime(5000);
	//verify comment count decrease
	verifycommentCountDecrease(HipiFeedPage.objCommentHeartIconRed,HipiFeedPage.objcommentlikecount);
	verifycommentCountDecrease(HipiFeedPage.objCommentHeartIconRed1,HipiFeedPage.objcommentlikecount1);

	}
}

public void verifycommentCountDecrease(By loc1, By loc2) throws Exception{
	if(verifyIsElementDisplayed(loc1)) {
		extent.extentLoggerPass("comment is liked by user earlier","comment is liked by user earlier");
		waitTime(5000);
		String LikeCount = getText(loc2);
		int i=Integer.parseInt(LikeCount);  
		extent.extentLogger("","Comment like count is : "+ i);
		extent.extentLoggerPass("Comment like count is displayed","Comment like count is displayed");
		verifyElementPresentAndClick(loc1, "Heart icon");//unlike video
		waitTime(5000);
		String LikeCommentCountPostLike_Unlike = getText(loc2);
		int i1=Integer.parseInt(LikeCommentCountPostLike_Unlike);
		extent.extentLogger("","Comment like count after unliking is : "+ i1);
		if(i!=i1)
		{
			logger.info("Red/liked comment is unliked");
		extent.extentLoggerPass("Red/liked comment is unliked","Red/liked comment is unliked");
		logger.info("comments like count is decreased");
		extent.extentLoggerPass("comments like count is decreased","comments like count is decreased");
		System.out.println("comments like count is decreased");
		}
		else
		{
			logger.error("Like count is not updated");
		extent.extentLoggerFail("Like count is not updated","Like count is not updated");
		System.out.println("Like count is not updated");
		}
			
		
	} else {
		logger.info("Played video is not liked");
		extent.extentLoggerPass("Played video is not liked","Played video is not liked");
	}

		
			
	

	
}


	public void verifycommentCountIncrease(By loc1, By loc2) throws Exception{
		if(verifyIsElementDisplayed(loc1)) {
			//extent.extentLoggerPass("comment is not liked by user earlier","comment is not liked by user earlier");
			waitTime(5000);
			String LikeCount = getText(loc2);
			int i=Integer.parseInt(LikeCount);  
			extent.extentLogger("","Comment like count is : "+ i);
			extent.extentLoggerPass("","Comment like count is displayed");
			verifyElementPresentAndClick(loc1, "Heart icon");//like video
			waitTime(5000);
			String LikeCommentCountPostLike_Unlike = getText(loc2);
			int i1=Integer.parseInt(LikeCommentCountPostLike_Unlike);
			extent.extentLogger("","Comment like count after liking : "+ i1);
			if(i1!=i)
			{
				logger.info("Grey/Unliked comment is liked");
				extent.extentLoggerPass("Grey/Unliked comment is liked","Grey/Unliked comment is liked");
				logger.info("comments like count is Increased");
				extent.extentLoggerPass("comments like count is Increased","comments like count is Increased");
				System.out.println("comments like count is Increased");
			}
			else
			{
				logger.error("Like count is not updated");
				extent.extentLoggerFail("Like count is not updated","Like count is not updated");
				System.out.println("Like count is not updated");
			}
				
			
		} else {
			logger.info("comment is liked by user earlier");
			extent.extentLoggerPass("comment is liked by user earlier","comment is liked by user earlier");
		}
	}

		
public void verifyCountDecrease() throws Exception{
	
	

	if(verifyIsElementDisplayed(HipiFeedPage.objHeartIconRed,"Red Heart icon")) {
		//verifyVideoisLiked(HipiFeedPage.objHeartIconRed);
		logger.info("Played video is liked");
		waitTime(5000);
		String LikeCount = getText(HipiFeedPage.objlikecount);
		int i=Integer.parseInt(LikeCount);  
		extent.extentLogger("", "Like count is "+ i);
		extent.extentLoggerPass("Like count is displayed","Like count is displayed");
		verifyElementPresentAndClick(HipiFeedPage.objHeartIconRed, "Heart icon");//unlike video
		
		waitTime(20000);

		String LikeCountPostLikeUnlike = getText(HipiFeedPage.objlikecount);
		int i1=Integer.parseInt(LikeCountPostLikeUnlike);
		extent.extentLogger("", "UnLike count is "+ i1);
		
		if(i!=i1)
		{
			logger.info("Red/liked Video is unliked");
		extent.extentLoggerPass("Red/liked Video is unliked","Red/liked Video is unliked");
		logger.info("Like count is decreased");
		extent.extentLoggerPass("Like count is decreased","Like count is decreased");
		System.out.println("Like count is decreased");
		}
		else
		{
			logger.error("Like count is not decreased");
		extent.extentLoggerFail("Like count is not updated","Like count is not decreased");
		System.out.println("Like count is not decreased");
		}
			
		
	} else {
		logger.info("Played video is not liked");
		extent.extentLoggerPass("Played video is not liked","Played video is not liked");
		//verifyElementPresentAndClick(HipiFeedPage.objHeartIcon, "Heart icon");//unlike
	}
	

}
public void verifyCountIncrease() throws Exception{

	if(verifyIsElementDisplayed(HipiFeedPage.objHeartIconGrey)) {
		//verifyVideoisLiked(HipiFeedPage.objHeartIconGrey);
		logger.info("Played video is not liked");
		waitTime(5000);
		
		String LikeCount = getText(HipiFeedPage.objlikecount);
		int i=Integer.parseInt(LikeCount);  
		logger.info("Like count is "+ i);
		extent.extentLogger("", "Like count is "+ i);
		extent.extentLoggerPass("Like count is displayed","Like count is displayed");
		verifyElementPresentAndClick(HipiFeedPage.objHeartIconGrey, "Heart icon");//like video
		waitTime(15000);
		String LikeCountPostLikeUnlike = getText(HipiFeedPage.objlikecount);
		int i1=Integer.parseInt(LikeCountPostLikeUnlike);
		extent.extentLogger("", "Like count is "+ i1);
		if(i!=i1)
		{logger.info("Grey/unliked Video is liked");
		extent.extentLoggerPass("","Grey/unliked Video is liked");
		logger.info("Like count is increased");
		extent.extentLoggerPass("","Like count is increased");
		System.out.println("Like count is increased");}
		else
		{logger.error("Like count is not increased");
		extent.extentLoggerFail("","Like count is not increased");
		System.out.println("Like count is not increased");}
		
		
		
	} else {
		logger.info("Played video is liked");
		extent.extentLoggerPass("","Played video is liked");
		//verifyElementPresentAndClick(HipiFeedPage.objHeartIcon, "Heart icon");//unlike
	}
	

}



public void CommentsFunctionality(String userType) throws Exception {
	// TODO Auto-generated method stub
		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
				extent.HeaderChildNode("Comment Check if user is able to add and post comment by entering description in text field");
	System.out.println("TC_Mobile_42");
	extent.extentLogger("", "TC_Mobile_42");
    Back(1);
    Swipe("UP", 1);
	if(verifyElementPresent(HipiFeedPage.objcommenticon,"comment icon present"))//check if comment icon is displayed
    {logger.info("Comment icon is displayed");
	extent.extentLoggerPass("","Comment icon is displayed");
	//click(HipiFeedPage.objcommenticon, "Comment icon");
    }
    else
    {logger.info("Comment icon is not displayed");
	extent.extentLoggerFail("","Comment icon is not displayed");}
    
    verifyElementPresent(HipiFeedPage.objcommentcount, "Comment count");//make note of comment count
	String commentCount = getText(HipiFeedPage.objcommentcount);
	int count = Integer.parseInt(commentCount);
	extent.extentLoggerPass("", "Comment count displayed is "+count); 
	System.out.println(count);
	verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "Comment icon");
	AddCommentVerify();
	addComment("abc");
	touchOnCommentArrow();
	if(verifyElementPresent(HipiFeedPage.objTextFewSecondsAgo, "few seconds ago"))
	{logger.info("Comment is added few seconds ago is displayed");
	extent.extentLoggerPass("","Comment is added few seconds ago is displayed");}
	else
	{logger.info("Comment is added, few seconds ago fails to displayed");
	extent.extentLoggerFail("","Comment is added, few seconds ago fails to displayed");}

	
	
	extent.HeaderChildNode("Comment Check if user is able to delete a comment added by logged user");
	System.out.println("TC_Mobile_61");
	extent.extentLogger("", "TC_Mobile_61");
	
	//Delete option and delete a comment
	if(verifyElementPresentAndClick(HipiFeedPage.objDeleteComment, "Delete option"))
	{extent.extentLoggerPass("","Delete option is displayed And a comment is deleted");}
	else
	{extent.extentLoggerFail("","Delete option is not displayed");}
	waitTime(5000);
	//verify element deleted
	if(verifyElementIsNotDisplayed(HipiFeedPage.objDeleteComment))
	{extent.extentLoggerPass("","Comment is deleted");
	extent.extentLogger("", "Comment is deleted");
	}
	else
	{extent.extentLoggerFail("","Comment is not deleted");}

	
	
	
	
	extent.HeaderChildNode("Comment Check if user is able to add multiple comments");
	System.out.println("TC_Mobile_45");
	extent.extentLogger("", "TC_Mobile_45");
	//scrollToBottomOfPage();
	//add multiple comment and delete it verify last comment is displayed
	
	AddCommentVerify();
	addComment("abc");
	touchOnCommentArrow();
	if(verifyElementPresent(HipiFeedPage.objTextFewSecondsAgo, "few seconds ago"))
	{logger.info("Comment is added few seconds ago is displayed");
	extent.extentLoggerPass("","Comment is added few seconds ago is displayed");}
	else
	{logger.info("Comment is added, few seconds ago fails to displayed");
	extent.extentLoggerFail("","Comment is added, few seconds ago fails to displayed");}

	
	
	
	//Delete option and delete a comment
			AddCommentVerify();
			addComment("abc");
			touchOnCommentArrow();
			if(verifyElementPresentAndClick(HipiFeedPage.objDeleteComment, "Delete option"))
			{extent.extentLoggerPass("Delete option is displayed","And first comment is deleted");}
			else
			{extent.extentLoggerFail("","Delete option is not displayed");}
			if(verifyElementPresentAndClick(HipiFeedPage.objDeleteComment, "Delete option"))
			{extent.extentLoggerPass("","Delete option is displayed And second comment is deleted");}
			else
			{extent.extentLoggerFail("","Delete option is not displayed");}
	Back(1);
	
	
	//navigate back to comment section and verify comment is deleted
	verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "Comment icon");
	if(verifyElementIsNotDisplayed(HipiFeedPage.objDeleteComment))
	{extent.extentLoggerPass("","Comment is deleted");}
	else
	{extent.extentLoggerFail("","Comment is not deleted");}
	
	
		
		
		extent.HeaderChildNode("Comment check if user can comment on multiple videos");
		System.out.println("TC_Mobile_48");
		extent.extentLogger("", "TC_Mobile_48");
		//delete comment
		BackToFeedScreen();
		//Swipe("UP", 1);
		if(verifyElementPresent(HipiFeedPage.objcommenticon,"comment icon present")){
		click(HipiFeedPage.objcommenticon,"comment icon present");
		AddCommentVerify();
		addComment("Happy Holi 2021");
		hideKeyboard();
		touchOnCommentArrow();
		extent.extentLoggerPass("", "User is able to add multiple comments");}
		else
		{extent.extentLoggerFail("", "Comment icon is not present");}
		

		
		
		
		extent.HeaderChildNode("Comment Check ' tag' is displayed in front of comment added by viewer");
		System.out.println("TC_Mobile_51");
		extent.extentLogger("", "TC_Mobile_51");
		waitTime(5000);
		//verify creator handle
		
		BackToFeedScreen();
		verifyElementPresentAndClick(HipiMePage.objMeicon, "Me icon");
		String userProfileID = getText(HipiMePage.objHipiProfileId);
		verifyElementPresentAndClick(HipiMePage.objbackbutton, "Back button");
		verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "Comment icon");
		AddCommentVerify(); //verify add comment is displayed
		addComment("abc");
		touchOnCommentArrow();
		String text1 = getText(HipiFeedPage.objComment);
		String[] text = text1.split("\\ ");
		   String userProfileId = text[0];
		if(userProfileId.contains(userProfileID))
		{extent.extentLoggerPass("", "Creator tag is displayed in front of comment added by viewer");}
		else
		{extent.extentLoggerFail("", "Creator tag is not displayed in front of comment added by viewer");}


		

		

		extent.HeaderChildNode("Comment Check display of latest comment appears on top and time is changed after few min");
		System.out.println("TC_Mobile_55");
		extent.extentLogger("", "TC_Mobile_55");
		
		//typed comment is displayed
		waitTime(5000);
		 String txtComment = getText(HipiFeedPage.objComment);
		   String[] textid = txtComment.split("\\ ");
		   String Text1 = textid[1];
		   if(Text1.contentEquals("abc"))
		   {extent.extentLoggerPass("", "Comment is added with the typed description on the top ");}
			else
			{extent.extentLoggerFail("", "Comment is not added with the typed description on the top ");}
		

		//typed comments seconds ago is displayed wait for a min after comment line is changed
		 try{
		   	AddCommentVerify();
			addComment("abc");
			touchOnCommentArrow();
			if(verifyElementPresent(HipiFeedPage.objTextFewSecondsAgo, "few seconds ago"))
			{logger.info("Comment is added few seconds ago is displayed");
			extent.extentLoggerPass("","Comment is added few seconds ago is displayed");}
			else
			{logger.info("Comment is added, few seconds ago fails to displayed");
			extent.extentLoggerFail("","Comment is added, few seconds ago fails to displayed");}
			
			for(int i=1; i<=10; i++){
				waitTime(5000);
        		String textCommentTime = getText(HipiFeedPage.objTextFewSecondsAgo);
        		System.out.println(textCommentTime);
        		//int feedCommentCountnumber = Integer.parseInt(feedCommentCount);
        		if(textCommentTime.contains("1 minute ago")){
        			waitTime(3000);
        			System.out.println("Comment time is changed from 'just now' to <number of min> minutes ago");
        			extent.extentLoggerPass("","Comment time is changed");
        			break;
        			
        			
        		}else{
        			Back(1);
        			verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "comment icon");
        		}	
        	}
        	}
        	catch(Exception e)
        	{extent.extentLoggerPass("","Comments time could not be validated");}
		
		
		
		
		
		
		
		extent.HeaderChildNode("Comment Check if user is able to add URL and URL is visible as plain text no hyperlink");
		System.out.println("TC_Mobile_63");
		extent.extentLogger("", "TC_Mobile_63");
		
		AddCommentVerify();//verify add comment is displayed
		addComment("www.zomato.com");
		touchOnCommentArrow();
		
		String txtCommentURL = getText(HipiFeedPage.objComment);
		   String[] textURL = txtCommentURL.split("\\ ");
		   String TextURL1 = textURL[1];
		   if(TextURL1.contentEquals("www.zomato.com"))
		   {extent.extentLoggerPass("", "User is allowed to enter URL and it is displayed as a plain text");}
			else
			{extent.extentLoggerFail("", "User is not allowed to enter URL and it is not displayed as a plain text");}

		
		   
		   extent.HeaderChildNode("Comment Check if viewer/ is able to like a existing/new comment by tapping heart Icon next to comment description");
			System.out.println("TC_Mobile_74");
			extent.extentLogger("", "TC_Mobile_74");
			
			//check if user is able to view and like existing and new comments ensure comment is not like before
			waitTime(5000);
			//verifyElementPresent(HipiFeedPage.objcommenticon, "Comment icon");
			Back(1);
			Swipe("UP", 1);
			verifyExistingComment();
			verifyElementPresent(HipiFeedPage.objComments, "Existing comments");
			String TitleCount = getAttributValue("text", HipiFeedPage.objcommentlikecount);
			int CommentTitleCount = Integer.parseInt(TitleCount);

			if(verifyElementPresent(HipiFeedPage.objCommentHeartIconGrey, "Comment like button")) 
			{
				extent.extentLoggerPass("", "Comment is not liked by logged in user earlier");
			click(HipiFeedPage.objCommentHeartIconGrey, "Like comment");
			extent.extentLoggerPass("", "User is able to like a existing comment by tapping heart Icon next to comment description");
			}
			else
			{
				extent.extentLogger("", "Comment is liked by logged in user earlier");
			}
			AddCommentVerify();
			addComment("hello world");
			touchOnCommentArrow();
			waitTime(10000);
			
			if(verifyElementPresent(HipiFeedPage.objCommentHeartIconGrey, "Comment like button")) 
			{
				extent.extentLoggerPass("", "Comment is not liked by logged in user earlier");
			String TitleCount1 = getAttributValue("text", HipiFeedPage.objcommentlikecount);
			CommentTitleCount1 = Integer.parseInt(TitleCount1);
			
			click(HipiFeedPage.objCommentHeartIconGrey, "Like comment");
			Thread.sleep(10000);
			extent.extentLoggerPass("", "User is able to like a new comment by tapping heart Icon next to comment description");
			}
			else
			{
				extent.extentLogger("", "Comment is liked by logged in user earlier");
			}
			
			
			extent.HeaderChildNode("Comment Check if viewer/ is able to dislike a existing/new comment by tapping heart Icon next to comment description");
			System.out.println("TC_Mobile_75");
			extent.extentLogger("", "TC_Mobile_75");
			//check if user is able to view and unlike existing and new comments ensure comment is like before
			waitTime(5000);
			try{
			if(verifyElementPresent(HipiFeedPage.objlikecomment2, "comment like button")) 
			{
				String CommentsTitleCount1 = getAttributValue("text", HipiFeedPage.objcommentlikecount1);
				int existingCommentsTitleCount1 = Integer.parseInt(CommentsTitleCount1);
				extent.extentLogger("", "existingCommentsTitleCount : "+existingCommentsTitleCount1);
				System.out.println(existingCommentsTitleCount1);
//				if(CommentTitleCount==existingCommentsTitleCount1)
//				{	
//					System.out.println("Existing comment is liked by logged in user earlier");
//					extent.extentLoggerPass("", "Existing comment is liked by logged in user earlier");
//				}else
//				{					
//					extent.extentLoggerFail("", "Existing comment is not liked by logged in user earlier");
//				}

				click(HipiFeedPage.objlikecomment2, "unlike comment");
				
				Thread.sleep(10000);
				
				String CommentsTitleCount2 = getAttributValue("text", HipiFeedPage.objcommentlikecount1);
				int existingCommentsTitleCount2 = Integer.parseInt(CommentsTitleCount2);
				extent.extentLogger("", "existingCommentsTitleCount : "+existingCommentsTitleCount2);
				System.out.println(existingCommentsTitleCount2);
				
				
				if(existingCommentsTitleCount1!=existingCommentsTitleCount2)
					{	
						extent.extentLoggerPass("", "Existing comment is unliked");
					}else
					{					
						extent.extentLoggerFail("", "Existing comment is not unliked");
					}
			}
			else
			{
				extent.extentLogger("", "Comment is unliked by logged in user earlier");
			}
			
			
			if(verifyElementPresent(HipiFeedPage.objlikecomment, "comment like button")) 
			{
				String CommentsTitleCount = getAttributValue("text", HipiFeedPage.objcommentlikecount);
				int newVideoCommentCountnumber = Integer.parseInt(CommentsTitleCount);
				extent.extentLogger("", "newVideoCommentCount : "+newVideoCommentCountnumber);

				click(HipiFeedPage.objlikecomment, "Unlike comment");
				
				Thread.sleep(10000);
				
				String CommentsTitleCount2 = getAttributValue("text", HipiFeedPage.objcommentlikecount);
				int newVideoCommentCountnumber2 = Integer.parseInt(CommentsTitleCount2);
				extent.extentLogger("", "newVideoCommentCount after click on heart : "+newVideoCommentCountnumber2);
				
				if(newVideoCommentCountnumber!=newVideoCommentCountnumber2)
				{
					extent.extentLoggerPass("", "New comment is unliked");
				}else
				{
					extent.extentLoggerFail("", "New comment is not unliked");
				}
				
				extent.extentLoggerPass("", "New comment is unliked");
				extent.extentLoggerPass("", "User is able to unlike a new comment by tapping heart Icon next to comment description");
			}
			else
			{
				extent.extentLogger("", "Comment is unliked by logged in user earlier");
			}
			}
			catch(Exception e)
			{
			System.out.println("Unlike comment could not be validated");
			extent.extentLoggerFail("", "Unlike comment could not be validated");
			}
			
			
			
			extent.HeaderChildNode("Comment Check ' tag' is not displayed in front of comment added with logged user as viewer");
			System.out.println("TC_Mobile_82");
			extent.extentLogger("", "TC_Mobile_82");
			
			String userProfileid = getText(HipiFeedPage.objComment);
			   String[] textID = userProfileid.split("\\ ");
			   String TextId = textID[0];
			   
			   extent.extentLogger("", "Viewer Adding the comment : "+userProfileID);
			if(userProfileID.contains(TextId))
			{extent.extentLoggerPass("", "Creator tag is not displayed in front of comment added by viewer");}
			else
			{extent.extentLoggerFail("", "Creator tag is displayed in front of comment added by viewer");}
			Back(1);

			
			
			extent.HeaderChildNode("Like/comment Check for counts if user is able to Like and comment on same video in pause/play mode");
			System.out.println("TC_Mobile_89");
			extent.extentLogger("", "TC_Mobile_89");
			// like a video and tap on comment, add a commemt and verify counts

			verifyElementPresentAndClick(HipiFeedPage.objPause, "pause video");
			
			Swipe("UP",1);
			verifyCountIncrease();
			verifyElementPresent(HipiFeedPage.objcommentcount, "Comment count");
			String commentCountPre = getText(HipiFeedPage.objcommentcount);
			int i=Integer.parseInt(commentCountPre);
			extent.extentLogger("", "Comment Count : "+i);
			verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "Comment icon");
			AddCommentVerify();
			addComment("hello");
			touchOnCommentArrow();
			Back(1);
			Wait(10000);
			verifyElementPresent(HipiFeedPage.objcommentcount, "Comment count");
			String commentCountPost = getText(HipiFeedPage.objcommentcount);
			int i1=Integer.parseInt(commentCountPost);
			extent.extentLogger("", "Comment Count after adding count : "+i1);
			if(i<i1)
			{extent.extentLoggerPass(""," Comments count is Increased and updated");
			System.out.println("Comments count is Increased");
			}
			else
			{logger.error("Comment count is not updated");
			extent.extentLoggerFail("","Comment count is not updated");
			System.out.println("Comment count is not updated");
			}
			//Back(1);
			
			extent.HeaderChildNode("DisLike/delete comment Check if user is able to dislike and delete comment on same video in pause/play mode");
			System.out.println("TC_Mobile_90");
			extent.extentLogger("", "TC_Mobile_90");
		    // tap on video to pause or play
			//verifyElementPresentAndClick(HipiFeedPage.objplaybutton, "play video");

			if(verifyIsElementDisplayed(HipiFeedPage.objHeartIcon)) {
				//verifyVideoisLiked(HipiFeedPage.objHeartIconRed);
				
				
				
//				if(verifyIsElementDisplayed(HipiFeedPage.objHeartIconGrey, "Heart Grey")){
//					click(HipiFeedPage.objHeartIconGrey, "Heart Grey");
//					extent.extentLogger("", "Video Liked");
//				}else{
//					extent.extentLogger("", "Video is already Liked");
//				}
				
				
				waitTime(5000);
				String LikeCount = getText(HipiFeedPage.objlikecount);
				int count1=Integer.parseInt(LikeCount);  
				logger.info("Like count is "+ count1);
				extent.extentLogger("","Like count is "+ count1);
				extent.extentLoggerPass("","Like count is displayed");
				
				verifyElementPresentAndClick(HipiFeedPage.objHeartIcon, "Heart icon");//unlike video
				waitTime(10000);
				waitTime(10000);
				String LikeCountPostLikeUnlike = getText(HipiFeedPage.objlikecount);
				int count2=Integer.parseInt(LikeCountPostLikeUnlike);
				extent.extentLogger("","Dislike count is "+ count2);
				if(count1!=count2)
				{
					logger.info("Played video is liked by user earlier");
				extent.extentLoggerPass("","Like count is decreased");
				System.out.println("Like count is decreased");
				}
				else
				{
					extent.extentLoggerFail("","Like count is not updated");
				System.out.println("Like count is not updated");
				}
					
				
			} else {
				logger.info("Played video is not liked");
				extent.extentLoggerFail("","video decrease count could not be validated");
				//verifyElementPresentAndClick(HipiFeedPage.objHeartIcon, "Heart icon");//unlike
			}
			
			//dislike a video and tap on comment, delete a commemt and verify counts
			verifyElementPresent(HipiFeedPage.objcommentcount, "Comment count");
			String commentCount1 = getText(HipiFeedPage.objcommentcount);
			int countPre=Integer.parseInt(commentCount1);
			extent.extentLogger("","count Pre : "+ countPre);
			verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "Comment icon");
		
			if(verifyElementPresent(HipiFeedPage.objDeleteComment, "Delete option"))
			{
				extent.extentLoggerPass("","Delete option is displayed");
			click(HipiFeedPage.objDeleteComment, "Delete option");
			}
			else
			{
				extent.extentLoggerFail("","Delete option is not displayed");
			}
			Back(1);
			Wait(15000);
			verifyElementPresent(HipiFeedPage.objcommentcount, "Comment count");
			String commentCountPost1 = getText(HipiFeedPage.objcommentcount);
			int countPost=Integer.parseInt(commentCountPost1);
			extent.extentLogger("","count Post : "+ countPost);
			if(countPost!=countPre)
			{
				extent.extentLoggerPass("","Comments count is decreased and updated");
			System.out.println("Comments count is decreased");
			}
			else
			{
				logger.error("Comment count is not updated");
			extent.extentLoggerFail("","Comment count is not updated");
			System.out.println("Comment count is not updated");
			}
}
}

public void AddCommentVerify() throws Exception{
if(verifyIsElementDisplayed(HipiFeedPage.objEmptyCommentBox, "Comment Box")){
	 
	 String commentValue = getAttributValue("text", HipiFeedPage.objEmptyCommentBox);
	 
	 if(commentValue.contains("Add a comment")){
		 extent.extentLoggerPass("", "Add a comment is displayed");
	 }else{
		 extent.extentLoggerFail("", "Add a comment is not displayed");
	 }
	 
	
}
}


public void addComment(String st1) throws Exception{

click(HipiFeedPage.objEmptyCommentBox, "Comment Box");
hideKeyboard();

String commentInputValue = fetchcommentInputCountof200();
int initialValue = Integer.parseInt(commentInputValue);
System.out.println(initialValue);
type(HipiFeedPage.objEmptyCommentBox, st1, "Comment box");

String commentInputValue1 = fetchcommentInputCountof200();
int initialValue1 = Integer.parseInt(commentInputValue1);
System.out.println(initialValue1);

if(initialValue<initialValue1){
	 extent.extentLoggerPass("", "Count increased");
}else{
	
	extent.extentLoggerFail("", "Count not increased");        				 
}

}


public void verifyExistingComment() throws Exception{
for(int i=1; i<=20; i++) {
	waitTime(5000);
	verifyElementPresent(HipiFeedPage.objcommentcount, "Comment count");
	String commentCount = getText(HipiFeedPage.objcommentcount);
	int count = Integer.parseInt(commentCount); 
	System.out.println(count);
if(count>=2)
{
	verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "Comment icon");
	break;
}
else
{	
	Swipe("UP",1);	
	waitTime(1000);

	}
}

}






















//----------------------------------------------------viewerprofile------------------------------------------------------------------



public void ValidatingViewerProfile(String userType) throws Exception{
	
	if(userType.equalsIgnoreCase("NonSubscribedUser")){
		ProfileImageandUpload(userType);
		ProfileNameAvailable(userType);
		ValidateFollowerAndFollowingIconWithCount(userType);
		ValidateNavigateToFollowerPage(userType);
		ValidateFollowerPageLayout(userType);
		ValidateFollowerPageBackButtonNavigateToProfilePage(userType);
		ValidateFollowerPageRecordSearch(userType);
		ValidateFollowerSearchBackButton(userType);
		ValidateFollowerSearchCloseButton(userType);
		ValidateFollowerClickedUserPageRedirected(userType);
		
		ValidateNaviagteToFollowingPage(userType);
		ValidateFollowingPageLayout(userType);
		ValidateFollowingPageBackNavigateToProfilePage(userType);
		ValidateSearchFieldWithBackAndClose(userType);
		ValidateSearchFieldBackButtonNavigateToProfilePage(userType);
		ValidateSearchFieldCloseButtonNavigateToFollowingPage(userType);
		ValidateFollowingAccountClickedRediredirectedToUserProfilePage(userType);
		ValidateFollowingAcoountHaveTickAndUserData(userType);
		ValidateFollowCountEqual(userType);
		ValidateFollowingCountEqual(userType);
		
		ValidateNavigateToEditProfilePage(userType);
		ValidateEditProfilePageLayout(userType);
		ValidateEditProfilePageBack(userType);
		ValidateEditProfilePageNameUpdated(userType);
		ValidateEditProfilePageNameUpdatedUnderProfilePage(userType);
		ValidateEditProfilePageCannotBeSavedWithoutNameAndHandle(userType);
		ValidateUserHandleAlreadyCreated(userType);
		ValidateDuplicateHandleNameCannotBeUsed(userType);
		
		ValidateEditProfilePageUniqueHandleNameCanBeUsed(userType);
		ValidateEditProfilePageHandleUpdated(userType);
		ValidateEditProfilePageUserAndHandleNameCannotBeSame(userType);
		ValidateEditProfilePageDobCanBeEdited(userType);
		ValidateEditProfilePageDobUpdatedDisplayed(userType);
		ValidateEditProfilePageBioAccept200words(userType);
		ValidateEditProfilePageBioAcceptlessthanorequal200words(userType);
		ValidateEditProfilePageShareDialog(userType);
		Thread.sleep(10000);
		ValidateEditProfilePageDefaultVideoTab(userType);
		ValidateEditProfilePageVideoPreviewPage(userType);
		ValidateEditProfileVideoPreviewPageBackButtonNavigateToVideoTab(userType);
		ValidateEditProfileVideoPublishingLabel(userType);
		ValidateEditProfileVideoPublishedVideoDeleteButtonAvailable(userType);
		ValidateEditProfileDraft(userType);	
		ValidateEditProfileDraftVideoNavigateToPostPage(userType);
		ValidatePostPageBackNavigateToDraftPage(userType);
		ValidateDraftVideoDeleted(userType);
		ValidateDraftVideoNotDeleted(userType);
		ValidateUnpublishedVideoUnderDraft(userType);
		ValidateHipiNotoficationPage(userType);
		ValidateProfileVideoDelete(userType);
		ValidateValidDataCanShared(userType);
		Thread.sleep(10000);
		ValidateBioUpdated(userType);
		ValidateFollowlist(userType);
		ValidateFollowinglist(userType);
		
		}
		else{
		ValidateMeLoginRegisterpopupGuest(userType);//guest
		}
	
}









public void ProfileImageandUpload(String userType) throws Exception
{
extent.HeaderChildNode("OwnProfile Check if user is able to view profile picture and on tapping profile image upload popup option are visible");
System.out.println("TC_Mobile_01");
extent.extentLogger("", "TC_Mobile_01");
verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
click(HipiMePage.objMe, "Me button");
Thread.sleep(5000);
click(HipiMePage.objprofileimage,"Profile image");
Thread.sleep(5000);
if(verifyElementExist(HipiMePage.objpicturesandrecordvideodialog, "Allow ZEE5 to take pictures and record video?"))
{
	click(HipiMePage.objallowbtn, "Allow button");
	Thread.sleep(5000);
	logger.info("Allow ZEE5 to take pictures and record video? is available");
	extent.extentLoggerPass("Profile page:", "Allow ZEE5 to take pictures and record video? is available");
}
else 
{
	logger.info("Allow ZEE5 to take pictures and record video? is unavailable");
	extent.extentLoggerFail("Profile page:", "Allow ZEE5 to take pictures and record video? is unavailable");
}
Thread.sleep(5000);
if(verifyElementExist(HipiMePage.objphotomediadialog, "Allow ZEE5 to access photos, media, and files on your device?"))
	{
	click(HipiMePage.objallowbtn, "Allow button");
	logger.info("Allow ZEE5 to access photos, media, and files on your device? is available");
	extent.extentLoggerPass("Profile page:", "Allow ZEE5 to access photos, media, and files on your device? is available");
	}
	else
	{
		logger.info("Allow ZEE5 to access photos, media, and files on your device? is unavailable");
		extent.extentLoggerFail("Profile page:", "Allow ZEE5 to access photos, media, and files on your device? is unavailable");
	}
Thread.sleep(5000);
if(verifyElementExist(HipiMePage.objuploadusingcamera, "Upload using camera button"))
{
	click(HipiMePage.objuploadusingcamera, "Upload using camera button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objcameraappopened, "Camera app"))
	{
		logger.info("Camera app opened");
		extent.extentLoggerPass("Profile page:", "Camera app opened");
	}
	else
	{
		logger.info("Camera app unavailable");
		extent.extentLoggerPass("Profile page:", "Camera app unavailable");
	}
	logger.info("Upload using camera button available");
	extent.extentLoggerPass("Profile page:", "Upload using camera button available");
}
else
{
	logger.info("Camera app unavailable");
	extent.extentLoggerFail("Profile page:", "Camera app unavailable");
}
Back(1);
Thread.sleep(5000);
click(HipiMePage.objprofileimage,"Profile image");
if(verifyElementExist(HipiMePage.objuploadusinggallery, "Upload using gallery button"))
{
	click(HipiMePage.objuploadusinggallery, "Upload using gallery button");
	logger.info("Upload using gallery button app available");
	extent.extentLoggerPass("Profile page:", "Upload using gallery button app available");
	Thread.sleep(5000);
}
else
{
	logger.info("Upload using gallery button app unavailable");
	extent.extentLoggerFail("Profile page:", "Upload using gallery button app unavailable");
}
if(verifyElementIsNotDisplayed(HipiMePage.objprofileimage))
{
logger.info("Gallery app opened");
extent.extentLoggerPass("Upload using gallery button:","Gallery app opened");
}
else
{
logger.info("Gallery app unavailable");
extent.extentLoggerFail("Upload using gallery button:","Gallery app unavailable");
}
Back(1);
Thread.sleep(5000);
click(HipiMePage.objprofileimage,"Profile image");
if(verifyElementExist(HipiMePage.objcancelbtn, "Cancel button"))
{
	click(HipiMePage.objcancelbtn, "Cancel button");
	Thread.sleep(5000);
	logger.info("Cancel button available");
	extent.extentLoggerPass("Upload using gallery button:","Cancel button available");
}
else
{
	logger.info("Cancel button unavailable");
	extent.extentLoggerFail("Upload using gallery button:","Cancel button unavailable");
}
	if(verifyElementExist(HipiMePage.objprofileimage,"Profile image"))
	{
	Back(1);
	Thread.sleep(5000);
	logger.info("Pop up closed");
	extent.extentLoggerPass("Cancel button:","Pop up closed");
	}
	else
	{
	logger.info("Pop up did not closed");
	extent.extentLoggerFail("Cancel button:","Pop up did not closed");
	}
logger.info("Profile image uploaded choices working");
extent.extentLoggerPass("Profile page:","Profile image uploaded choices working");
}





public void ProfileNameAvailable(String userType) throws Exception
{
extent.HeaderChildNode("OwnProfile Check if user is able to view User Name First name and Last name");
System.out.println("TC_Mobile_05");
extent.extentLogger("", "TC_Mobile_05");
Thread.sleep(5000);
click(HipiMePage.objMe, "Me button");
waitTime(10000);//added
////Thread.sleep(5000);
if(verifyElementExist(HipiMePage.objprofilenameavailable,"Profile name"))
{
	String profilename=findElement(HipiMePage.objprofilenameavailable).getText();
	//System.out.println("Profile name:"+profilename);
	extent.extentLogger("Profile name:", profilename);
	Thread.sleep(5000);
	Back(1);
	logger.info("Profile name available");
	extent.extentLoggerPass("Profile page:","Profile name available");
}
else
{
	logger.info("Profile name unavailable");
	extent.extentLoggerFail("Profile page:","Profile name unavailable");
}
}



public void ValidateFollowerAndFollowingIconWithCount(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Check the middle options in profile screen has social statistics Following,Followers count along with Labels");
	System.out.println("TC_Mobile_09");
	extent.extentLogger("", "TC_Mobile_09");
	click(AMDOnboardingScreen.objForMeButton, "Me");
	waitTime(10000);//added
	////Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objfollowicon,"Follower icon"))
	{
		logger.info("Follower icon available");
		extent.extentLoggerPass("Profile page:","Follower icon available");
	}
	else
	{
		logger.info("Follower icon unavailable");
		extent.extentLoggerFail("Profile page:","Follower icon unavailable");
	}
		if(verifyElementExist(HipiMePage.objfollowvalue,"Follower count"))
		{
			String followercount=findElement(HipiMePage.objfollowvalue).getText();
			//System.out.println("Follower count:"+followercount);
			extent.extentLogger("Follower count:", followercount);
			logger.info("Follower count available");
			extent.extentLoggerPass("Profile page:","Follower count available");
		}
		else
		{
			logger.info("Follower count unavailable");
			extent.extentLoggerFail("Profile page:","Follower count unavailable");
		}
		
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowingicon,"Following icon"))
		{
			logger.info("Following icon available");
			extent.extentLoggerPass("Profile page:","Following icon available");
		}
		else
		{
			logger.info("Following icon unavailable");
			extent.extentLoggerFail("Profile page:","Following icon unavailable");
		}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowingvalue,"Following count"))
		{
		String followingcount=findElement(HipiMePage.objfollowingvalue).getText();
		//System.out.println("Following count:"+followingcount);
		extent.extentLogger("Following count:", followingcount);
		logger.info("Following count available");
		extent.extentLoggerPass("Profile page:","Following count available");
		}
		else
		{
			logger.info("Following count unavailable");
			extent.extentLoggerFail("Profile page:","Following count unavailable");
		}
		Thread.sleep(5000);
		Back(1);
		logger.info("Follower icon with count and following icon with count available");
		extent.extentLoggerPass("Profile page:","Follower icon with count and following icon with count available");
	}



public void ValidateNavigateToFollowerPage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Followers List Screen Verify on tapping Followers user is navigated to followers list screen");
	System.out.println("TC_Mobile_010");
	extent.extentLogger("", "TC_Mobile_10");
	click(AMDOnboardingScreen.objForMeButton, "Me");
	waitTime(10000);
////Thread.sleep(5000);
	click(HipiMePage.objfollowicon,"Follower icon");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objfollowpage,"Follower page"))
	{
		logger.info("Follower page navigated when follower icon clicked");
		extent.extentLoggerPass("Follower page:","Follwer page navigated when follower icon clicked");
	}
	else
	{
		logger.info("Follower page didnot get navigated when follower icon clicked");
		extent.extentLoggerFail("Follower page:","Follwer page didnot get navigated when follower icon clicked");
	}
	
}

public void ValidateFollowerPageLayout(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Followers List Screen Check layout of Followers list screen");
	System.out.println("TC_Mobile_011");
	extent.extentLogger("", "TC_Mobile_011");
	if(verifyElementExist(HipiMePage.objfollowerpagebackbtn,"Back button"))
	{
		logger.info("Back button available");
		extent.extentLoggerPass("Follower page:","Back button available");
	}
	else
	{
		logger.info("Back button unavailable");
		extent.extentLoggerFail("Follower page:","Back button unavailable");
	}
	String followertitlewithcount=findElement(HipiMePage.objfollowpage).getText();
	//System.out.println("Follower count:"+followertitlewithcount);
	extent.extentLogger("Follower count:", followertitlewithcount);
	Thread.sleep(5000);
	logger.info("Follwer page title with follower count available");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objsearchicon,"Search icon"))
	{
		logger.info("Search icon available");
		extent.extentLoggerPass("Follower page:","Search icon available");
	}
	else
	{
		logger.info("Search icon unavailable");
		extent.extentLoggerFail("Follower page:","Search icon unavailable");
	}
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objsearchfolllowerlabel,"Search follower label"))
	{
		logger.info("Search follower label available");
		extent.extentLoggerPass("Follower page:","Search follower label available");
	}
	else
	{
		logger.info("Search follower label unavailable");
		extent.extentLoggerFail("Follower page:","Search follower label unavailable");
	}
		Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objfollowerimage,"Follower image"))
	{
		if(verifyElementExist(HipiMePage.objfollowerimage,"Follower image"))
		{
			logger.info("Follower image available");
			extent.extentLoggerPass("Follower page:","Follower image available");
		}
		else
		{
			logger.info("Follower image unavailable");
			extent.extentLoggerFail("Follower page:","Follower image unavailable");
		}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objprofilename,"Follower name"))
		{
			logger.info("Follower name available");
			extent.extentLoggerPass("Follower page:","Follower name available");
		}
		else
		{
			logger.info("Follower name unavailable");
			extent.extentLoggerFail("Follower page:","Follower name unavailable");
		}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowercount,"Follower count"))
		{
			logger.info("Follower count available");
			extent.extentLoggerPass("Follower page:","Follower count available");
		}
		else
		{
			logger.info("Follower count unavailable");
			extent.extentLoggerFail("Follower page:"," Follower count unavailable");
		}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowbtn,"Follow button"))
		{
			logger.info("Plus button available");
			extent.extentLoggerPass("Follower page:","Plus button available");
		}
		else
		{
			logger.info("Tick button available");
			extent.extentLoggerFail("Follower page:","Plus button unavailable");
		}
	}
	else
	{
		logger.info("Follower unavailable");
	}
	}

public void ValidateFollowerPageBackButtonNavigateToProfilePage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Followers List Screen Check if on tapping back button user is redirected back to Profile Screen");
	System.out.println("TC_Mobile_012");
	extent.extentLogger("", "TC_Mobile_12");
	click(HipiMePage.objfollowerpagebackbtn,"Back button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objeditprofile,"Profile page"))
	{
		logger.info("Follower page back button navigate to profile page");
		extent.extentLoggerPass("Profile page:","Follower page back button navigate to profile page");
	}
	else
	{
		logger.info("Follower page back button didnot navigate to profile page");
		extent.extentLoggerFail("Follower page:","Follower page back button didnot navigate to profile page");
	}
	}


public void ValidateFollowerPageRecordSearch(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Followers List Screen Check if user is able to search and verify the options displayed on entering text in search text field");
	System.out.println("TC_Mobile_013");
	extent.extentLogger("", "TC_Mobile_013");
	Thread.sleep(20000);
	click(HipiMePage.objfollowicon,"Follower");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objsearchfield,"Search field"))
	{
		click(HipiMePage.objsearchfield,"Search field");
		Thread.sleep(5000);
		click(HipiMePage.objsearchfield,"Search field");
		Thread.sleep(5000);
		hideKeyboard();
		Thread.sleep(5000);
		logger.info("Search field available");
		extent.extentLoggerPass("Profile page:","Search field available");
	}
	else
	{
		logger.info("Search field unavailable");
		extent.extentLoggerFail("Follower page:","Search field unavailable");
	}
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objsearchfieldbackbtn,"Back button"))
	{
		logger.info("Back button available");
		extent.extentLoggerPass("Profile page:","Back button available");
	}
	else
	{
		logger.info("Back button unavailable");
		extent.extentLoggerFail("Follower page:","Back button unavailable");
	}
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objsearchfieldclosebtn,"Close button"))
	{
		logger.info("Back button available");
		extent.extentLoggerPass("Profile page:","Back button available");
	}
	else
	{
		logger.info("Back button unavailable");
		extent.extentLoggerFail("Follower page:","Back button unavailable");
	}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objprofilename,"User name"))
		{
			String accountname=findElement(HipiMePage.objsearchaccountdata).getText();//changed
			//System.out.println("Follower data:"+accountname);
			extent.extentLogger("Follower data:", accountname);
			String searchingdata=accountname.substring(0, 3);//added
			type(HipiMePage.objsearchfield,searchingdata,"Follower data");
			Thread.sleep(5000);
			if(verifyElementExist(HipiMePage.objprofilehandle,"Handle data"))
			{
				logger.info("Handle data available");
				extent.extentLoggerPass("Profile page:","Handle data available");
			}
			else
			{
				logger.info("Handle data unavailable");
				extent.extentLoggerFail("Follower page:","Handle data unavailable");
			}
		}
		else
		{
			type(HipiMePage.objsearchfield,"nozee","Follower data");
			Thread.sleep(5000);
			if(verifyElementExist(HipiMePage.objprofilepagefollowerpagedialog,"Dialog"))
			{
				logger.info("No result found dialog");
				extent.extentLoggerPass("Profile page:","No result found dialog");
			}
			else
			{
				logger.info("No result found dialog unavailable");
				extent.extentLoggerFail("Follower page:","No result found dialog unavailable");
			}
		}
	}



public void ValidateFollowerSearchBackButton(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Followers List Screen Check if on tapping back button on search text field, user is redirected back to followers list screen");
	System.out.println("TC_Mobile_014");
	extent.extentLogger("", "TC_Mobile_014");
	Thread.sleep(5000);
	click(HipiMePage.objsearchfieldbackbtn,"Back button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objeditprofile,"Profile page"))
	{
		logger.info("Follower page search back button navigate to profile page");
		extent.extentLoggerPass("Follower page:","Follower page back button navigate to profile page");
	}
	else
	{
		logger.info("Follower page search back button did not navigate to profile page");
		extent.extentLoggerFail("Follower page:","Follower page search back button did not navigate to profile page");
	}
}

public void ValidateFollowerSearchCloseButton(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Followers List Screen Check if on tapping cross icon in search text field entered text is removed and user is redirected back to followers list screen");
	System.out.println("TC_Mobile_015");
	extent.extentLogger("", "TC_Mobile_015");
	click(HipiMePage.objfollowicon,"Follow button");
	Thread.sleep(5000);
	click(HipiMePage.objsearchfield,"Search field");
	Thread.sleep(5000);
	click(HipiMePage.objsearchfield,"Search field");
	Thread.sleep(5000);
	type(HipiMePage.objsearchfield,"chandu","Follower data");
	Thread.sleep(5000);
	click(HipiMePage.objsearchfieldclosebtn,"Close button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objfollowpage,"Follow page"))
	{
		logger.info("Follower page search close button navigate to follower list page");
		extent.extentLoggerPass("Follower page:","Follower page close button navigate to follower list page");
	}
	else
	{
		logger.info("Follower page close button did not navigate to follower list page");
		extent.extentLoggerFail("Follower page:","Follower page close button did not navigate to follower list page");
	}
}



public void ValidateFollowerClickedUserPageRedirected(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Followers List Screen Check if on tapping user from followers list, user is redirected to selected user profile detail screen");
	System.out.println("TC_Mobile_016");
	extent.extentLogger("", "TC_Mobile_016");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objaccountname,"Account data"))
	{
		String accountname=findElement(HipiMePage.objaccountname).getText();
		System.out.println("Follower data:"+accountname);
		click(HipiMePage.objprofilename,"Follower data");
		Thread.sleep(5000);
		String followeraccount=findElement(HipiMePage.objfolloweraccountdata).getText();
		//System.out.println("Follower account:"+followeraccount);
		extent.extentLogger("Follower account:", followeraccount);
		Thread.sleep(5000);
		if(accountname.equals(followeraccount))
		{
		logger.info("Follower profile clicked navigate to follower profile page");
		extent.extentLoggerPass("Follower page:","Follower profile clicked navigate to follower profile page");
		}
		else
		{
			logger.info("Follower profile clicked did not navigate to follower profile page");
			extent.extentLoggerFail("Follower page:","Follower profile clicked did not navigate to follower profile page");
		}
	}
	else
	{
		logger.info("No result found dialog");
	}
	Back(1);
	Thread.sleep(5000);
	Back(1);
	Thread.sleep(5000);
}


public void ValidateNaviagteToFollowingPage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Following List Screen Verify on tapping Following user is navigated to Following list screen");
	System.out.println("TC_Mobile_019");
	extent.extentLogger("", "TC_Mobile_019");
	Thread.sleep(5000);
	click(HipiMePage.objfollowingicon,"Following");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objfollowingpage,"Following page"))
	{
		logger.info("Following button navigated to following page");
		extent.extentLoggerPass("Following page:","Following button navigated to following page");
	}
	else
	{
		logger.info("Following button did not navigated to following page");
		extent.extentLoggerFail("Following page:","Following button did not navigated to following page");
	}
}
public void ValidateFollowingPageLayout(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Following List Screen Check layout of Following list screen");
	System.out.println("TC_Mobile_020");
	extent.extentLogger("", "TC_Mobile_20");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objfollowingpage,"Following page"))
	{
			logger.info("Following page available");
			extent.extentLoggerPass("Following page:","Following page available");
	}
	else
	{
			logger.info("Following page unavailable");
			extent.extentLoggerFail("Following page:","Following page unavailable");
	}
	Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowingpagebackbtn,"Back button"))
		{
			logger.info("Back button available");
			extent.extentLoggerPass("Following page:","Back button available");
		}
		else
		{
			logger.info("Back button unavailable");
			extent.extentLoggerFail("Following page:","Back button unavailable");
		}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowingpagesearch,"Search icon"))
		{
			logger.info("Search icon available");
			extent.extentLoggerPass("Following page:","Search icon available");
		}
		else
		{
			logger.info("Search icon unavailable");
			extent.extentLoggerFail("Following page:","Search icon unavailable");
		}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowingpagesearchfollowinglabel,"Search following"))
		{
			logger.info("Search following available");
			extent.extentLoggerPass("Following page:","Search following available");
		}
		else
		{
			logger.info("Search following unavailable");
			extent.extentLoggerFail("Following page:","Search following unavailable");
		}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowingpageimage,"Image"))
		{
			logger.info("Image available");
			extent.extentLoggerPass("Following page:","Image available");
		}
		else
		{
			logger.info("Image unavailable");
			extent.extentLoggerFail("Following page:","Image unavailable");
		}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowingpagename,"Name"))
		{
			logger.info("Name available");
			extent.extentLoggerPass("Following page:","Name available");
		}
		else
		{
			logger.info("Name unavailable");
			extent.extentLoggerFail("Following page:","Name unavailable");
		}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowingpagefollowercount,"Follower count"))
		{
			logger.info("Follower count available");
			extent.extentLoggerPass("Following page:","Follower count available");
		}
		else
		{
			logger.info("Follower count unavailable");
			extent.extentLoggerFail("Following page:","Follower count unavailable");
		}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowingpagehandle,"Handle"))
		{
			logger.info("Handle available");
			extent.extentLoggerPass("Following page:","Handle available");
		}
		else
		{
			logger.info("Handle unavailable");
			extent.extentLoggerFail("Following page:","Handle unavailable");
		}
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfollowingpagetickbtn,"Tick"))
		{
			logger.info("Tick available");
			extent.extentLoggerPass("Following page:","Tick available");
		}
		else
		{
			logger.info("Tick unavailable");
			extent.extentLoggerFail("Following page:","Tick unavailable");
		}
		Thread.sleep(5000);
		logger.info("Following page having valid layout");
		extent.extentLoggerPass("Following page:","Following page having valid layout");
	}
	
public void ValidateFollowingPageBackNavigateToProfilePage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Following List Screen Check if on tapping back button user is redirected back to Profile Screen");
	System.out.println("TC_Mobile_021");
	extent.extentLogger("", "TC_Mobile_021");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objfollowingpagebackbtn,"Back button"))
	{
		click(HipiMePage.objfollowingpagebackbtn,"Back button");
		Thread.sleep(5000);
		verifyElementExist(HipiMePage.objeditprofile,"Profile page");
		logger.info("Following page back button navigate to profile page");
		extent.extentLoggerPass("Following page:","Following page back button navigate to profile page");
	}
	else
	{
		logger.info("Following page back button did not navigate to profile page");
		extent.extentLoggerFail("Following page:","Following page back button did not navigate to profile page");
	}
}	
public void ValidateSearchFieldWithBackAndClose(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Following List Screen Check if user is able to search and verify the options displayed on entering text in search text field");
	System.out.println("TC_Mobile_022");
	extent.extentLogger("", "TC_Mobile_022");
	Thread.sleep(5000);
	click(HipiMePage.objfollowingicon,"Following button");
	Thread.sleep(5000);
	click(HipiMePage.objfollowingpagesearchfollowinglabel,"Search following");
	Thread.sleep(5000);
	click(HipiMePage.objfollowingpagesearchfollowinglabel,"Search following");
	Thread.sleep(5000);
	type(HipiMePage.objfollowingpagesearchfollowinglabel,"swee","Search");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objfollowingpagebacklabelbtn,"Back button"))
	{
		verifyElementExist(HipiMePage.objfollowingpageclosebtn,"Close button");
		Thread.sleep(5000);
		logger.info("Search field with back and close button available");
		extent.extentLoggerPass("Following page:","Search field with back and close button available");
	}
	else
	{
		logger.info("Following page back button did not navigate to profile page");
		extent.extentLoggerFail("Following page:","Following page back button did not navigate to profile page");
	}
}

public void ValidateSearchFieldBackButtonNavigateToProfilePage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Following List Screen Check if on tapping back button on search text field, user is redirected back to Following list screen");
	System.out.println("TC_Mobile_023");
	extent.extentLogger("", "TC_Mobile_023");
	Thread.sleep(5000);
	click(HipiMePage.objfollowingpagebacklabelbtn,"Back button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objeditprofile,"Profile page"))
	{
		logger.info("Search field back button navigate to profile page");
		extent.extentLoggerPass("Following page:","Search field back button navigate to profile page");
	}
	else
	{
		logger.info("Search field back button did not navigate to profile page");
		extent.extentLoggerFail("Following page:","Search field back button did not navigate to profile page");
	}
}
public void ValidateSearchFieldCloseButtonNavigateToFollowingPage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Following List Screen Check if on tapping cross icon in search text field entered text is removed and user is redirected back to following list screen");
	System.out.println("TC_Mobile_024");
	extent.extentLogger("", "TC_Mobile_024");
	Thread.sleep(5000);
	click(HipiMePage.objfollowingicon,"Following button");
	Thread.sleep(5000);
	click(HipiMePage.objfollowingpagesearchfollowinglabel,"Search following");
	Thread.sleep(5000);
	click(HipiMePage.objfollowingpagesearchfollowinglabel,"Search following");
	Thread.sleep(5000);
	type(HipiMePage.objfollowingpagesearchfollowinglabel,"swee","Search");
	Thread.sleep(5000);
	click(HipiMePage.objfollowingpageclosebtn,"Close button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objfollowingpage,"Following page"))
	{
		logger.info("Search field close button navigate to following page");
		extent.extentLoggerPass("Following page:","Search field close button navigate to following page");
	}
	else
	{
		logger.info("Search field close button did not navigate to following page");
		extent.extentLoggerFail("Following page:","Search field close button did not navigate to following page");
	}
	hideKeyboard();
	Thread.sleep(5000);
	Back(1);
	Thread.sleep(5000);
}


public void ValidateFollowingAccountClickedRediredirectedToUserProfilePage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Following List Screen Check if on tapping user from Following list, user is redirected to selected user profile detail screen");
	System.out.println("TC_Mobile_025");
	extent.extentLogger("", "TC_Mobile_025");
	Thread.sleep(5000);
	click(HipiMePage.objfollowingicon,"Following");
	Thread.sleep(5000);
	String profilename=findElement(HipiMePage.objfollowingpagename).getText();
	//System.out.println("Following profile:"+profilename);
	Thread.sleep(10000);
	click(HipiMePage.objfollowingpagename,"Following account");
	Thread.sleep(5000);
	String profilenameclicked=findElement(HipiMePage.objfollowingaccountclicked).getText();
	//System.out.println("Following profile clicked:"+profilenameclicked);
	Thread.sleep(10000);
	if(profilename.equals(profilenameclicked))
	{
		Thread.sleep(5000);
		logger.info("Following account clicked redirected to user profile page");
		extent.extentLoggerPass("Following page:","Following account clicked redirected to user profile page");
	}
	else
	{
		logger.info("Following account clicked did not redirected to user profile page");
		extent.extentLoggerFail("Following page:","Following account clicked did not redirected to user profile page");
	}
	Back(1);
	Thread.sleep(5000);
}
public void ValidateFollowingAcoountHaveTickAndUserData(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Following List Screen Check if all followed users will have a tick button along with the user details on the list items");
	System.out.println("TC_Mobile_026");
	extent.extentLogger("", "TC_Mobile_026");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objfollowingpagetickbtn,"Tick"))
	{
		verifyElementExist(HipiMePage.objfollowingpagename,"Profile name");
		Thread.sleep(5000);
		verifyElementExist(HipiMePage.objfollowingpagefollowercount,"Follower count");
		Thread.sleep(5000);
		verifyElementExist(HipiMePage.objfollowingpagehandle,"Handle data");
		Thread.sleep(5000);
		logger.info("Following account have tick and user data");
		extent.extentLoggerPass("Following page:","Following account have tick and user data");
	}
	else
	{
		logger.info("Following account did not have tick and user data");
		extent.extentLoggerFail("Following page:","Following account did not have tick and user data");
	}
	Back(1);
	Thread.sleep(5000);
}
public void ValidateFollowingCountEqual(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Following List Screen Check if Following count match in both Profile and Following list screen");
	System.out.println("TC_Mobile_028");
	extent.extentLogger("", "TC_Mobile_028");
	String followcountprofilepage=findElement(HipiMePage.objfollowvalueprofile).getText();
	System.out.println("Follow count list page:"+followcountprofilepage);
	Thread.sleep(10000);
	click(HipiMePage.objfollowvalueprofile,"Follow");
	Thread.sleep(10000);
	String followcountfollowlistpage=findElement(HipiMePage.objfollowvaluefollowlistpage).getText();
	//System.out.println("Follow count profile page:"+followcountfollowlistpage);
	Thread.sleep(10000);
	if(followcountfollowlistpage.contains(followcountprofilepage))
	{
		Thread.sleep(5000);
		logger.info("Follow count under user page and list page equal");
		extent.extentLoggerPass("Follow page:","Follow count under user page and list page equal");
	}
	else
	{
		logger.info("Follow count under user page and list page not equal");
		extent.extentLoggerFail("Follow page:","Follow count under user page and list page not equal");
	}
	Back(1);
	Thread.sleep(5000);
}
public void ValidateFollowCountEqual(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Followers List Screen Check if followers count match in both Profile and followers list screen");
	System.out.println("TC_Mobile_029");
	extent.extentLogger("", "TC_Mobile_029");
	waitTime(5000);//added
	String followingcountprofilepage=findElement(HipiMePage.objfollowingvalueprofile).getText();
	//System.out.println("Following count list page:"+followingcountprofilepage);
	Thread.sleep(10000);
	click(HipiMePage.objfollowingvalueprofile,"Following");
	Thread.sleep(10000);
	String followingcountfollowinglistpage=findElement(HipiMePage.objfollowingvaluefollowinglistpage).getText();
	//System.out.println("Follow count profile page:"+followingcountfollowinglistpage);
	Thread.sleep(10000);
	if(followingcountfollowinglistpage.contains(followingcountprofilepage))
	{
		Thread.sleep(5000);
		logger.info("Following count under user page and list page equal");
		extent.extentLoggerPass("Following page:","Following count under user page and list page equal");
	}
	else
	{
		logger.info("Following count under user page and list page not equal");
		extent.extentLoggerFail("Following page:","Following count under user page and list page not equal");
	}
	Back(1);
	Thread.sleep(5000);
}



public void ValidateNavigateToEditProfilePage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if on tapping Edit Profile user is directed to Edit Profile Screen");
	System.out.println("TC_Mobile_032");
	extent.extentLogger("", "TC_Mobile_032");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objeditprofilepage,"Edit profile page"))
	{
		logger.info("Navigate to edit profile page");
		extent.extentLoggerPass("Edit profile page:","Navigate to edit profile page");
	}
	else
	{
		logger.info("Did not navigate to edit profile page");
		extent.extentLoggerFail("Edit profile page:","Did not navigate to edit profile page");
	}
}
public void ValidateEditProfilePageLayout(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check layout of Edit Profile Screen");
	System.out.println("TC_Mobile_033");
	extent.extentLogger("", "TC_Mobile_033");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objeditprofilepage,"Edit profile page"))
	{
		verifyElementExist(HipiMePage.objeditprofilepagebackbtn,"Back");
		verifyElementExist(HipiMePage.objeditprofilepageimage,"Image");
		verifyElementExist(HipiMePage.objeditprofilepagefirstname,"First name");
		verifyElementExist(HipiMePage.objeditprofilepagelastname,"Last name");
		verifyElementExist(HipiMePage.objeditprofilepagehandle,"Handle");
		verifyElementExist(HipiMePage.objeditprofilepagedob,"Dob");
		verifyElementExist(HipiMePage.objeditprofilepagebio,"Bio");
		verifyElementExist(HipiMePage.objeditprofilepageeditbtn,"Edit");
		logger.info("Edit profile page layout valid");
		extent.extentLoggerPass("Edit profile page:","Edit profile page layout valid");
	}
	else
	{
		logger.info("Edit profile page layout invalid");
		extent.extentLoggerFail("Edit profile page:","Edit profile page layout invalid");
	}
}
public void ValidateEditProfilePageBack(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if on tapping back button user is redirected back to Profile Screen");
	System.out.println("TC_Mobile_034");
	extent.extentLogger("", "TC_Mobile_034");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagebackbtn,"Back button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objeditprofile,"Profile page"))
	{
		logger.info("Edit profile page back button redirecting profile page");
		extent.extentLoggerPass("Edit profile page:","Edit profile page back button redirecting profile page");
	}
	else
	{
		logger.info("Edit profile page back button not redirecting profile page");
		extent.extentLoggerFail("Edit profile page:","Edit profile page back button not redirecting profile page");
	}
}

public void ValidateEditProfilePageNameUpdated(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if user is able to update first name and last name");
	System.out.println("TC_Mobile_038");
	extent.extentLogger("", "TC_Mobile_038");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	
	ProfileFirstName=getAttributValue("text",HipiMePage.objeditprofilepagefirstname);
	extent.extentLogger("ProfileFirstName:",ProfileFirstName);
	ProfileLastName=getAttributValue("text",HipiMePage.objeditprofilepagelastname);
	extent.extentLogger("ProfileLastName:",ProfileLastName);
	
	clearField(HipiMePage.objeditprofilepagefirstname, "First name");
	type(HipiMePage.objeditprofilepagefirstname,"vvvv","First name data updated");
	Thread.sleep(5000);
	clearField(HipiMePage.objeditprofilepagelastname, "Last name");
	type(HipiMePage.objeditprofilepagelastname,"vvvv","Last name data updated");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbuttonavailable,"Edit button");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagedone,"Yes button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objeditprofilepageyourprofilehasbeenupdatedsuccessfullydialog, "Your profile has been updated successfully dialog"))
	{
		click(HipiMePage.objeditprofilepagedone,"Yes button");
		Thread.sleep(5000);
		logger.info("Edit profile page name updated");
		extent.extentLoggerPass("Edit profile page:","Edit profile page name updated");
	}
	else
	{
		logger.info("Edit profile page name not updated");
		extent.extentLoggerFail("Edit profile page:","Edit profile page name not updated");
	}
}
public void ValidateEditProfilePageNameUpdatedUnderProfilePage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if user is able to view updated first name and last name in profile screen and edit profile screen");
	System.out.println("TC_Mobile_039");
	extent.extentLogger("", "TC_Mobile_039");
	Thread.sleep(5000);
	String profilename=findElement(HipiMePage.objprofilenameavailable).getText();
	//System.out.println("Profile name:"+profilename);
	Thread.sleep(5000);
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	clearField(HipiMePage.objeditprofilepagefirstname, "First name");
	type(HipiMePage.objeditprofilepagefirstname,ProfileFirstName,"First name data updated");
	Thread.sleep(5000);
	clearField(HipiMePage.objeditprofilepagelastname, "Last name");
	type(HipiMePage.objeditprofilepagelastname,ProfileLastName,"Last name data updated");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbuttonavailable,"Edit button");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagedone,"Yes button");
	Thread.sleep(10000);
	click(HipiMePage.objeditprofilepagedone,"Yes button");
	Thread.sleep(10000);
	String profilenameupdated=findElement(HipiMePage.objprofilenameavailable).getText();
	System.out.println("Profile name updated:"+profilenameupdated);
	Thread.sleep(5000);
	if(profilename!=profilenameupdated)
	{
		logger.info("Edit profile page name updated under profile page");
		extent.extentLoggerPass("Edit profile page:","Edit profile page name updated under profile page");
	}
	else
	{
		logger.info("Edit profile page name not updated under profile page");
		extent.extentLoggerFail("Edit profile page:","Edit profile page name not updated under profile page");
	}
}
public void ValidateEditProfilePageCannotBeSavedWithoutNameAndHandle(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if First name, last name, User handle are mandatory fields");
	System.out.println("TC_Mobile_040");
	extent.extentLogger("", "TC_Mobile_040");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	clearField(HipiMePage.objeditprofilepagefirstname, "First name");
	Thread.sleep(5000);
	clearField(HipiMePage.objeditprofilepagelastname, "Last name");
	Thread.sleep(5000);
	clearField(HipiMePage.objeditprofilepagehandle, "Handle name");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbuttonavailable,"Edit button");
	Thread.sleep(5000);
	if(verifyElementIsNotDisplayed(HipiMePage.objeditprofilepagesavechangesdialog))
	{
		logger.info("Edit profile page cannot be saved without name and handle");
		extent.extentLoggerPass("Edit profile page:","Edit profile page cannot be saved without name and handle");
	}
	else
	{
		logger.info("Edit profile page can be saved without name and handle");
		extent.extentLoggerFail("Edit profile page:","can be saved without name and handle");
	}
	Back(1);
	Thread.sleep(5000);
}


public void ValidateUserHandleAlreadyCreated(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if a default user handle is displayed");
	System.out.println("TC_Mobile_041");
	extent.extentLogger("", "TC_Mobile_041");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objeditprofilepagehandle,"Predefined handle name available"))
	{
		String handle=findElement(HipiMePage.objeditprofilepagehandle).getText();
		System.out.println("Defined Handle:"+handle);
		logger.info("Edit profile page predefined handle name available");
		extent.extentLoggerPass("Edit profile page:","Edit profile page predefined handle name available");
	}
	else
	{
		logger.info("Edit profile page predefined handle name unavailable");
		extent.extentLoggerFail("Edit profile page:","Edit profile page predefined handle name unavailable");
	}
}
public void ValidateDuplicateHandleNameCannotBeUsed(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check while editing user handle, an error is displayed if the user handle already exists");
	System.out.println("TC_Mobile_042");
	extent.extentLogger("", "TC_Mobile_042");
	Thread.sleep(5000);
	Back(1);
	Thread.sleep(5000);
	Back(1);
	Thread.sleep(5000);
	click(HipiMePage.objauthorimageview,"Author");
	Thread.sleep(5000);
	
	String duplicatedata=getAttributValue("text",HipiMePage.objduplicatehandledata);
	//System.out.println("duplicatedata"+duplicatedata);
	extent.extentLogger("duplicatedata:",duplicatedata);
	Thread.sleep(5000);
	
	Back(1);
	Thread.sleep(5000);
	click(AMDOnboardingScreen.objForMeButton, "Me");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	
	clearField(HipiMePage.objeditprofilepagehandle, "Handle name");
	Thread.sleep(5000);
	type(HipiMePage.objeditprofilepagehandle,duplicatedata,"Duplicate handle used");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objeditprofilepageduplicatehandledialog,"Duplicate handle name dialog"))
	{
		click(HipiMePage.objeditprofilepagedone,"Yes button");
		Thread.sleep(5000);
		hideKeyboard();
		Thread.sleep(5000);
		Back(1);
		Thread.sleep(5000);
		logger.info("Edit profile page duplicate handle name cannot be used");
		extent.extentLoggerPass("Edit profile page:","Edit profile page duplicate handle name cannot be used");
	}
	else
	{
		logger.info("Edit profile page duplicate handle name can be used");
		extent.extentLoggerFail("Edit profile page:","Edit profile page duplicate handle name can be used");
	}
}



public void ValidateEditProfilePageUniqueHandleNameCanBeUsed(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if on editing user handle, no error is displayed if the user handle added does not exist");
	System.out.println("TC_Mobile_043");
	extent.extentLogger("", "TC_Mobile_043");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	DefinedHandleName=getAttributValue("text",HipiMePage.objeditprofilepagehandle);
	Thread.sleep(5000);
	
	clearField(HipiMePage.objeditprofilepagehandle, "Handle name");
	Thread.sleep(5000);
	type(HipiMePage.objeditprofilepagehandle,"desc"+GeneratingRandomString(7),"Unique Handle used");
	Thread.sleep(5000);
	if(verifyElementIsNotDisplayed(HipiMePage.objeditprofilepageduplicatehandledialog))
	{
		click(HipiMePage.objeditprofilepageeditbuttonavailable,"Edit button");
		Thread.sleep(5000);
		click(HipiMePage.objeditprofilepagedone,"Yes button");
		Thread.sleep(5000);
		click(HipiMePage.objeditprofilepagedone,"Yes button");
		Thread.sleep(5000);
		logger.info("Edit profile page unique handle name can be used");
		extent.extentLoggerPass("Edit profile page:","Edit profile page unique handle name can be used");
	}
	else
	{
		logger.info("Edit profile page unique handle name cannot be used");
		extent.extentLoggerFail("Edit profile page:","Edit profile page unique handle name cannot be used");
	}
}
public void ValidateEditProfilePageHandleUpdated(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if on updating user handle, the same should be displayed in all respective fields Ex user profile, comment section, Feed section, Following, Followers, For you section");
	System.out.println("TC_Mobile_044");
	extent.extentLogger("", "TC_Mobile_044");
	Thread.sleep(5000);
	String handlenamebeforeupdating=findElement(HipiMePage.objprofilehandledata).getText();
	System.out.println("Handle name before updating:"+handlenamebeforeupdating);
	extent.extentLogger("Handle name before updating:",handlenamebeforeupdating);
	Thread.sleep(5000);
	
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	clearField(HipiMePage.objeditprofilepagehandle, "Handle name");
	Thread.sleep(5000);
	type(HipiMePage.objeditprofilepagehandle,DefinedHandleName,"Unique handle used");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbuttonavailable,"Edit button");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagedone,"Yes button");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagedone,"Yes button");
	Thread.sleep(5000);
	String handlenameafterupdating=findElement(HipiMePage.objprofilehandledata).getText();
	System.out.println("Handle name after updating:"+handlenameafterupdating);
	Thread.sleep(5000);
	if(handlenamebeforeupdating!=handlenameafterupdating)
	{
		logger.info("Edit profile page unique handle name updated");
		extent.extentLoggerPass("Edit profile page:","Edit profile page unique handle name updated");
	}
	else
	{
		logger.info("Edit profile page unique handle name did not update");
		extent.extentLoggerFail("Edit profile page:","Edit profile page unique handle name did not update");
	}
}
public void ValidateEditProfilePageUserAndHandleNameCannotBeSame(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if user is unable to enter same texts in First name and User handle section");
	System.out.println("TC_Mobile_045");
	extent.extentLogger("", "TC_Mobile_045");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	clearField(HipiMePage.objeditprofilepagehandle, "Handle name");
	Thread.sleep(5000);
	type(HipiMePage.objeditprofilepagehandle,"abc","Handle name");
	Thread.sleep(5000);
	logger.info("Handle name and user name entered are equal and checking error dialog available");
	if(verifyElementExist(HipiMePage.objeditprofilepageduplicatehandledialog,"Looks like this handle is taken. Try something fun & new dialog"))
	{
		click(HipiMePage.objeditprofilepagedone,"Yes button");
		Thread.sleep(5000);
		Back(1);
		Thread.sleep(5000);
		logger.info("Edit profile page user and handle name cannot be same");
		extent.extentLoggerPass("Edit profile page:","Edit profile page user and handle name cannot be same");
	}
	else
	{
		logger.info("Edit profile page user and handle name can be same");
		extent.extentLoggerFail("Edit profile page:","Edit profile page user and handle name can be same");
	}
}
public void ValidateEditProfilePageDobCanBeEdited(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if user can edit the DOB of the logged in user  if DOB entered while creation");
	System.out.println("TC_Mobile_046");
	extent.extentLogger("", "TC_Mobile_046");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objeditprofilepagedobcreated,"Dob available for logged user"))
	{
		click(HipiMePage.objeditprofilepagedob,"Dob");
		Thread.sleep(5000);
		click(HipiMePage.objeditprofilepagecalendardata,"Date");
		Thread.sleep(5000);
		click(HipiMePage.objeditprofilepagecalendarok,"ok");
		Thread.sleep(5000);
		click(HipiMePage.objeditprofilepageeditbuttonavailable,"Edit button");
		Thread.sleep(5000);
		click(HipiMePage.objeditprofilepagedone,"Yes button");
		Thread.sleep(5000);
		click(HipiMePage.objeditprofilepagedone,"Yes button");
		Thread.sleep(5000);
		logger.info("Edit profile page dob available and can be edited");
		extent.extentLoggerPass("Edit profile page:","Edit profile page dob available and can be edited");
	}
	else
	{
		logger.info("Edit profile page dob blank and cannot be edited");
		extent.extentLoggerFail("Edit profile page:","Edit profile page dob blank and cannot be edited");
	}
}
public void ValidateEditProfilePageDobUpdatedDisplayed(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if user can verify the latest updated DOB in edit profile screen");
	System.out.println("TC_Mobile_049");
	extent.extentLogger("", "TC_Mobile_049");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	String dobbeforeupdating=findElement(HipiMePage.objeditprofilepagedob).getText();
	//System.out.println("Handle name before updating:"+dobbeforeupdating);
	click(HipiMePage.objeditprofilepagedob,"Dob");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagecalendardata6,"Date");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagecalendarok,"ok");
	Thread.sleep(5000);
	String dobafterupdating=findElement(HipiMePage.objeditprofilepagedob).getText();
	//System.out.println("Handle name before updating:"+dobafterupdating);
	Thread.sleep(5000);
	if(dobbeforeupdating!=dobafterupdating)
	{
		logger.info("Edit profile page dob updated");
		extent.extentLoggerPass("Edit profile page:","Edit profile page dob updated");
	}
	else
	{
		logger.info("Edit profile page dob did not update");
		extent.extentLoggerFail("Edit profile page:","Edit profile page dob did not update");
	}
}
public void ValidateEditProfilePageBioAccept200words(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if user cannot enter more than 200 characters in User Bio field and verify the character limit changes as user types");
	System.out.println("TC_Mobile_050");
	extent.extentLogger("", "TC_Mobile_050");
	Thread.sleep(5000);
	clearField(HipiMePage.objeditprofilepagebio, "Bio field");
	Thread.sleep(5000);
	
	click(HipiMePage.objeditprofilepagebio,"Bio field");
	Thread.sleep(5000);
	hideKeyboard();
	Swipe("UP",1);
	Thread.sleep(5000);
	
	String decription="In the India of my dreams, there would be no poverty. Every Indian would be able to live very very very very comfortable life. Every single person would be literate and the acquisition of knowledge would be open to one";
	Thread.sleep(5000);
	int lengthofdecription=decription.length();
  System.out.println("length decription"+lengthofdecription);
  logger.info("Entering more than 200 words in bio");
  click(HipiMePage.objeditprofilepagebio, "User Bio field");
	type(HipiMePage.objeditprofilepagebio,"In the India of my dreams, there would be no poverty. Every Indian would be able to live very comfortable life. Every single person would be literate and the acquisition of knowledge would be open to one", "Description entered which is more than 200 words");
	Thread.sleep(10000);	
	hideKeyboard();
	
	String getTextaddebiowhendatagotentered=findElement(HipiMePage.objeditprofilepagebio).getText();
	int countofwordinbioafterdatagotadded=getTextaddebiowhendatagotentered.length();
	//System.out.println("length decription after data entered:"+countofwordinbioafterdatagotadded);
	logger.info("Count of words after description got added");
	if(countofwordinbioafterdatagotadded==200)
	{
		extent.extentLoggerPass("Edit profile page:","Able to add bio upto 200 words");
		logger.info("User able to add bio upto 200 words");
	}
	else
	{
		extent.extentLoggerFail("Edit profile page:","Unable to add bio upto 200 words");
		logger.info("User unable to add bio upto 200 words");
	}
		Thread.sleep(5000);	
		String countervaluewithdata=findElement(HipiMePage.objeditprofilepagebiocountervalue).getText();
		//System.out.println("Counter value:"+countervaluewithdata);
		Thread.sleep(5000);	
		clearField(HipiMePage.objeditprofilepagebio, "User bio");
		Thread.sleep(5000);	
		String countervaluedatacleared=findElement(HipiMePage.objeditprofilepagebiocountervalue).getText();
		//System.out.println("Counter value:"+countervaluedatacleared);
		Thread.sleep(5000);	
	if(countervaluewithdata!=countervaluedatacleared)
	{
		extent.extentLoggerPass("Edit profile page:","Bio counter working");
		logger.info("Bio counter working");
	}
	else
	{
		extent.extentLoggerFail("Edit profile page:","Bio counter not working");
		logger.info("Bio counter not working");
	}
}



public void ValidateEditProfilePageBioAcceptlessthanorequal200words(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if user can enter less than or equal to 200 characters in User Bio field");
	System.out.println("TC_Mobile_051");
	extent.extentLogger("", "TC_Mobile_051");
	Thread.sleep(5000);
	String decription="In the India of my dreams, there would be no poverty. Every Indian would be able to live very very very very comfortable life. Every single person would be literate and the acquisition of knowledge would be open to one";
	Thread.sleep(5000);
	int lengthofdecription=decription.length();
	//System.out.println("length decription"+lengthofdecription);
	logger.info("Entering more than 200 words in bio");
	click(HipiMePage.objeditprofilepagebio, "User Bio field");
	type(HipiMePage.objeditprofilepagebio,"In the India of my dreams, there would be no poverty. Every Indian would be able to live very comfortable life. Every single person would be literate and the acquisition of knowledge would be open to one", "Description entered which is more than 200 words");
	Thread.sleep(10000);	
	hideKeyboard();

String getTextaddebiowhendatagotentered=findElement(HipiMePage.objeditprofilepagebio).getText();
int countofwordinbioafterdatagotadded=getTextaddebiowhendatagotentered.length();
//System.out.println("length decription after data entered:"+countofwordinbioafterdatagotadded);
logger.info("Count of words after description got added");
if(lengthofdecription>countofwordinbioafterdatagotadded && countofwordinbioafterdatagotadded==200)
{
	extent.extentLoggerPass("Edit profile page:","Able to add bio less than or equal to 200 words");
	logger.info("User able to add bio less than or equal to 200 words");
}
else
{
	extent.extentLoggerFail("Edit profile page:","Unable to add bio less than or equal to 200 words");
	logger.info("User unable add bio less than or equal to 200 words");
}
Back(1);
Thread.sleep(5000);
}

public void ValidateEditProfilePageShareDialog(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Share Check if on tapping share default sharing widget is displayed");
	System.out.println("TC_Mobile_054");
	extent.extentLogger("", "TC_Mobile_054");
	Thread.sleep(5000);
	click(HipiMePage.objprofilepagesharebtn,"Share button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objprofilepagesharewidget,"Widget"))
	{
		Back(1);
		Thread.sleep(5000);
		logger.info("Share widget available");
		extent.extentLoggerPass("Profile page:","Share widget available");
	}
	else
	{
		logger.info("Share widget unavailable");
		extent.extentLoggerFail("Profile page:","Share widget unavailable");
	}
}




public void ValidateEditProfilePageDefaultVideoTab(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab All Verify if user is able to view all created and published videos");
	System.out.println("TC_Mobile_062");
	extent.extentLogger("", "TC_Mobile_062");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objprofilepagevideopublishedavailable,"Video published"))//added
	{
		if(verifyElementExist(HipiMePage.objprofilepagedefaulttab,"Default tab"))
		{
			logger.info("Default tab is video tab");
			extent.extentLoggerPass("Profile page:","Default tab is video tab");
		}
		else
		{
			logger.info("Default tab is not video tab");
			extent.extentLoggerFail("Profile page:","Default tab is not video tab");
		}
		if(verifyElementExist(HipiMePage.objprofilepagevideopublishedavailable,"Video published"))
		{
			logger.info("Video published under video tab available");
			extent.extentLoggerPass("Profile page:","Video published under video tab available");
		}
		else
		{
			logger.info("No video published yet");
			extent.extentLoggerFail("Profile page:","No video published yet");
		}
	}
	else
	{
		extent.extentLogger("", "No video published yet");
	}
	
}
public void ValidateEditProfilePageVideoPreviewPage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab All Check if on tapping published video will directed the user to the fullscreen Player view");
	System.out.println("TC_Mobile_063");
	extent.extentLogger("", "TC_Mobile_063");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objprofilepagevideopublishedavailable,"Video published"))
	{
	logger.info("Video published under video tab available");
	Thread.sleep(5000);
	click(HipiMePage.objprofilepagevideopublishedavailable,"Video available");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objprofilepagevideopublishedpreviewdata,"Preview video page"))
	{
	Back(1);
	Thread.sleep(5000);
	logger.info("Preview video page available");
	extent.extentLoggerPass("Profile page:","Preview video page available");
	}
	else
	{
	logger.info("Preview video page unavailable");
	extent.extentLoggerFail("Profile page:","Preview video page unavailable");
	}
	}
	else
	{
	logger.info("No video published yet");
	extent.extentLogger("", "No video published yet");//added
	}
		
}
public void ValidateEditProfileVideoPreviewPageBackButtonNavigateToVideoTab(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab All Check if on tapping back user will navigate the user to ALL Videos Listing");
	System.out.println("TC_Mobile_064");
	extent.extentLogger("", "TC_Mobile_064");
	Thread.sleep(5000);
//	Back(1);removed
//	Thread.sleep(5000);removed
	Swipe("DOWN", 1);
	waitTime(5000);
	scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
	waitTime(5000);
	if(verifyElementExist(HipiMePage.objprofilepagedefaulttab,"Video tab page"))
	{
	logger.info("Video tab page available");
	extent.extentLoggerPass("Profile page:","Video tab page available");
	}
				
	else
				
	{
					
	logger.info("Video tab page unavailable");
					
	extent.extentLoggerFail("Profile page:","Video tab page unavailable");
	}
}
public void ValidateEditProfileVideoPublishingLabel(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab All Check if video in publishing mode displays Publishing in process label along with the video thumbnail");
	System.out.println("TC_Mobile_065");
	extent.extentLogger("", "TC_Mobile_065");
	Thread.sleep(5000);
	if(verifyElementExist(HipiCreateVideoPage.objpublishprogressvideo,"Video publishing label"))
	{
	click(HipiMePage.objpublishingvideo,"Video");
	if(verifyElementIsNotDisplayed(HipiMePage.objprofilepagevideopublishedpreviewdata))
	{
	logger.info("When publishing video clicked no preview available");
	extent.extentLoggerPass("Profile page:","When publishing video clicked no preview available");
	}
	else
	{
	logger.info("When publishing video clicked preview available");
	extent.extentLoggerFail("Profile page:","When publishing video clicked preview available");
	}
	}
	else
	{
	logger.info("Video tab page video under publishing label unavailable");
	extent.extentLoggerWarning("Profile page:","Video tab page video under publishing in progress label unavailable");
	}
}
public void ValidateEditProfileVideoPublishedVideoDeleteButtonAvailable(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab All Check if there is an option to delete created and published videos");
	System.out.println("TC_Mobile_066");
	extent.extentLogger("", "TC_Mobile_066");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objpublishedvideo,"Video published"))
	{
	logger.info("Video published available");
	Thread.sleep(10000);
	longPress(HipiMePage.objpublishedvideo);
	Thread.sleep(10000);
	logger.info("Long press choices available");
	if(verifyElementExist(HipiMePage.objpublishedvideodelete,"Delete video"))
	{
	Back(1);
	Thread.sleep(5000);
	logger.info("When published video longpressed delete video choice available");
	extent.extentLoggerPass("Profile page:","When published video longpressed delete video choice available");
	}
	else
	{
	logger.info("When published video longpressed delete video choice unavailable");
	extent.extentLoggerFail("Profile page:","When published video longpressed delete video choice unavailable");
	}
	}
	else
	{
	logger.info("Published video unavailable");
	extent.extentLogger("Profile page:","Published video unavailable");
	}
}
public void ValidateEditProfileDraft(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab Draft Verify if user is able to view all his Draft videos");
	System.out.println("TC_Mobile_068");
	extent.extentLogger("", "TC_Mobile_068");
	Thread.sleep(5000);
	click(HipiMePage.objprofiledraft,"Draft tab");
	Thread.sleep(5000);
	PartialSwipe("UP",1);
	Thread.sleep(5000);	
	if(verifyElementExist(HipiMePage.objprofiledraftvideo,"Draft video"))
	{
	logger.info("Draft tab have list of draft video available");
	extent.extentLoggerPass("Profile page:","Draft tab have list of draft video available");
	}
	else
	{
	logger.info("Draft tab have list of draft video unavailable");
	extent.extentLogger("Profile page:","Draft tab have list of draft video unavailable");
	}
}
public void ValidateEditProfileDraftVideoNavigateToPostPage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab Draft Check if on tapping video will directed the user to video uploading screen post screen");
	System.out.println("TC_Mobile_069");
	extent.extentLogger("", "TC_Mobile_069");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objprofiledraftvideo,"Draft video"))
	{
	click(HipiMePage.objprofiledraftvideo,"Draft video");
	Thread.sleep(10000);	
	if(verifyElementExist(HipiMePage.objdraftvideopostpage,"Post page"))
	{
	logger.info("Draft video naviagte to post page");
	extent.extentLoggerPass("Profile page:","Draft video naviagte to post page");
	}
	else
	{
	logger.info("Draft video do not naviagte to post page");
	extent.extentLoggerFail("Profile page:","Draft video do not naviagte to post page");
	}
	}
	else
	{
	logger.info("Profile page:"+ "Draft tab have list of draft video unavailable");
	extent.extentLogger("Profile page:","Draft tab have list of draft video unavailable");
	}
}
public void ValidatePostPageBackNavigateToDraftPage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab Draft Check if on tapping back button user is redirected to Draft Listing tab");
	System.out.println("TC_Mobile_070");
	extent.extentLogger("", "TC_Mobile_070");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objdraftvideopostpage,"Post page"))
	{
	click(HipiMePage.objdraftvideopostpagebackbtn,"Back button");
	Thread.sleep(5000);	
	if(verifyElementExist(HipiMePage.objprofiledraft,"Draft page"))
	{
			logger.info("Post page back button naviagte to draft page");
			extent.extentLoggerPass("Profile page:","Post page back button naviagte to draft page");
	}
	else
	{
			logger.info("Post page back button do not naviagte to draft page");
			extent.extentLoggerFail("Profile page:","Post page back button do not naviagte to draft page");
	}
	}
	else
	{
		logger.info("Profile page:"+ "Back button unavailable");
	}
}
public void ValidateCreateHipiRedirectCreatorPage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab Check if on tapping Create Hipi button, user is redirected to creator module");
	System.out.println("TC_Mobile_072");
	extent.extentLogger("", "TC_Mobile_072");
	Thread.sleep(5000);
	click(HipiMePage.objprofilepagedefaulttab,"Default tab");
	Thread.sleep(5000);
	Swipe("UP",1);
	if(verifyElementExist(HipiMePage.objnovideocreateddialog,"No video created dialog"))
	{
		click(HipiMePage.objnovideocreatehipibtn,"Create hipi button");
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objcreatehipipermissionpicturesrecordvideodialog,"Allow ZEE5 to take pictures and record video? dialog"))
		{
			click(HipiMePage.objcreatehipiallowbtn,"Allow button");
		}
		else
		{
			logger.info("Profile page:"+ "Allow ZEE5 to take pictures and record video? dialog unavailable");
		}
		if(verifyElementExist(HipiMePage.objcreatehipipermissiondevicedialog,"Allow ZEE5 to access photos, media, and files on your device? dialog"))
		{
			click(HipiMePage.objcreatehipiallowbtn,"Allow button");
		}
		else
		{
			logger.info("Profile page:"+ "Allow ZEE5 to access photos, media, and files on your device? dialog unavailable");
		}
		if(verifyElementExist(HipiMePage.objcreatehipipermissionrecordaudiodialog,"Allow ZEE5 to record audio? dialog"))
		{
			click(HipiMePage.objcreatehipiallowbtn,"Allow button");
		}
		else
		{
			logger.info("Profile page:"+ "Allow ZEE5 to record audio? dialog unavailable");
		}
		waitForElementDisplayed(HipiMePage.objcreatehipipermissionreadydialogokbtn,90);//added
		click(HipiMePage.objcreatehipipermissionreadydialogokbtn,"Yes button");
		Thread.sleep(10000);
		if(verifyElementExist(HipiMePage.objcreatehipipermissionrecordbtn,"Record button"))
		{
			Back(1);
			Thread.sleep(5000);
			logger.info("Create hipi button naviagte to creator page");
			extent.extentLoggerPass("Profile page:","Create hipi button naviagte to creator page");
		}
		else
		{
			logger.info("Create hipi button do not naviagte to creator page");
			extent.extentLoggerFail("Profile page:","Create hipi button do not naviagte to creator page");
		}
	}
	else
	{
		logger.info("Create hipi button unavailable");
		extent.extentLoggerPass("Profile page:","Create hipi button unavailable");
	}
}



public void ValidateDraftVideoDeleted(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab Draft Check if drafted video is deleted when user taps on Yes on the delete popup");
	System.out.println("TC_Mobile_073");
	extent.extentLogger("", "TC_Mobile_073");
	Thread.sleep(5000);
	Back(1);
	Thread.sleep(5000);
	click(HipiFeedPage.objCreateVideoIcon, "Create video button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo, "Allow ZEE5 to take pictures and record video?"))
	{
		logger.info("Allow ZEE5 to take pictures and record video?");
		click(HipiCreateVideoPage.objCreateAllow, "Allow button");
		logger.info("Allow button");
		Thread.sleep(5000);
	}
	else
	{
		logger.info("Allow ZEE5 to take pictures and record video? unavailable");
	}
	
	if(verifyElementExist(HipiCreateVideoPage.objCreatePermissiondevice, "Allow ZEE5 to access photos, media, and files on your device?"))
	{
		logger.info("Allow ZEE5 to access photos, media, and files on your device");	
		click(HipiCreateVideoPage.objCreateAllow, "Allow button");
		logger.info("Allow button");
		Thread.sleep(5000);
	}
	else
	{
		logger.info("Allow ZEE5 to access photos, media, and files on your device? unavailable");
	}
	
	if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionRecordAudio, "Allow ZEE5 to record audio?"))
	{
		logger.info("Allow ZEE5 to record audio");
		click(HipiCreateVideoPage.objCreateAllow, "Allow button");	
		logger.info("Allow button");
		//waitTime(120000);//changed//Thread.sleep(40000);
		waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
		verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
		click(HipiCreateVideoPage.objCreateReadyYes, "yes button");	
		logger.info("yes button");
		Thread.sleep(10000);
	}
	else
	{
		logger.info("Allow ZEE5 to record audio unavailable");
	}
	
	verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record start button");
	Thread.sleep(30000);
	verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "Post button");
	Thread.sleep(20000);

	type(HipiCreateVideoPage.objadddescription,"Desc"+GeneratingRandomString(7),"Description");
	Thread.sleep(5000);
	hideKeyboard();
	Thread.sleep(5000);
	
	click(HipiCreateVideoPage.objgenrevideo, "Genre button");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objlanguageclickedhindi, "Hindi button");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objcheckbox, "Checkbox");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objsaveasdraft, "Save as draft button");
	Thread.sleep(5000);
	
	click(HipiMePage.objdraftvideopostpagegotofeed, "Go to feed button");
	Thread.sleep(5000);
	click(HipiMePage.objMeicon, "Me icon");
	Thread.sleep(5000);
	click(HipiMePage.objdraft, "Draft tab");
	Thread.sleep(5000);
	//Swipe("UP",1)
	
	if(verifyIsElementDisplayed(HipiMePage.objUploadAllButton, "Upload All button")){
		scrolltomiddle(HipiMePage.objUploadAllButton);
	}else{
		
	}
	
	if(verifyIsElementDisplayed(HipiCreateVideoPage.objselectfirstimage, "First video")){
		scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
		Thread.sleep(5000);
		String videodraftdattatobedeleted=findElement(HipiMePage.objdraftvideopostpagevideodataavailabletobedeleted).getText();
		System.out.println("Added Data:"+videodraftdattatobedeleted);
		Thread.sleep(5000);
		click(HipiMePage.objdraftvideopostpagemoreoptionbtn,"More button");
		Thread.sleep(5000);	
		click(HipiMePage.objdraftvideopostpageremovebtn,"Remove button");
		Thread.sleep(5000);	
		if(verifyElementExist(HipiMePage.objdraftvideopostpagedeletedialog,"Delete dialog"))
		{
				click(HipiMePage.objdraftvideopostpageokbtn,"Yes button");
				logger.info("Delete dialog available and ok button clicked");
				extent.extentLoggerPass("Profile page:","Delete dialog available and ok button clicked");
		}
		else
		{
				logger.info("Delete dialog unavailable");
				extent.extentLoggerFail("Profile page:","Delete dialog unavailable");
		}
		Thread.sleep(5000);	
		String videodraftdata=findElement(HipiMePage.objdraftvideopostpagevideodataavailabletobedeleted).getText();
		//System.out.println("Added Data:"+videodraftdata);
		Thread.sleep(5000);
		if(videodraftdattatobedeleted!=videodraftdata)
		{
			logger.info("Deleted video unavailable under draft page");
			extent.extentLoggerPass("Profile page:","Deleted video unavailable under draft page");
		}
		else
		{
			logger.info("Deleted video available under draft page");
			extent.extentLoggerFail("Profile page:","Deleted video available under draft page");
		}
		
	}else{
		extent.extentLoggerWarning("", "Draft video is not present");
	}
	
}

public void ValidateDraftVideoNotDeleted(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab Draft Check if drafted video is not deleted when cancel the delete popup");
	System.out.println("TC_Mobile_074");
	extent.extentLogger("", "TC_Mobile_074");
	Thread.sleep(5000);
	Back(1);
	Thread.sleep(5000);
	verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo, "Create video button");
	Thread.sleep(5000);
	verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record start button");//added
	Thread.sleep(30000);
	verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "Post button");//added
	Thread.sleep(20000);

	type(HipiCreateVideoPage.objadddescription,"Desc"+GeneratingRandomString(7),"Description");
	Thread.sleep(5000);
	hideKeyboard();
	Thread.sleep(5000);
	
	click(HipiCreateVideoPage.objgenrevideo, "Genre button");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objlanguageclickedenglish, "English button");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objcheckbox, "Checkbox");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objsaveasdraft, "Save as draft button");
	Thread.sleep(5000);
	
	click(HipiMePage.objdraftvideopostpagegotofeed, "Go to feed button");
	Thread.sleep(5000);
	click(HipiMePage.objMeicon, "Me icon");
	Thread.sleep(5000);
	click(HipiMePage.objdraft, "Draft tab");
	Thread.sleep(5000);
	//Swipe("UP",1)
	
	if(verifyIsElementDisplayed(HipiMePage.objUploadAllButton, "Upload All button")){
		scrolltomiddle(HipiMePage.objUploadAllButton);
	}else{
		
	}
	
	
	if(verifyIsElementDisplayed(HipiCreateVideoPage.objselectfirstimage, "First video")){
		scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
		Thread.sleep(5000);
		
		String videodraftdatanottodeleted=findElement(HipiMePage.objdraftvideopostpagevideonottobedeleted).getText();
		//System.out.println("Added Data:"+videodraftdatanottodeleted);
		Thread.sleep(5000);
		click(HipiMePage.objdraftvideopostpagemoreoptionbtn,"More button");
		Thread.sleep(5000);	
		click(HipiMePage.objdraftvideopostpageremovebtn,"Remove button");
		Thread.sleep(5000);
		click(HipiMePage.objdraftvideopostpagecancelbtn,"Cancel button");
		Thread.sleep(10000);		
		
		
		String videodraftdata=findElement(HipiMePage.objdraftvideopostpagevideonottobedeleted).getText();
		//System.out.println("Added Data:"+videodraftdata);
		Thread.sleep(5000);
		if(videodraftdatanottodeleted.equals(videodraftdata))
		{
			logger.info("Video to be deleted available under draft page");
			extent.extentLoggerPass("Profile page:","Video to be deleted available under draft page");
		}
		else
		{
			logger.info("Video to be deleted unavailable under draft page");
			extent.extentLoggerFail("Profile page:","Video to be deleted unavailable under draft page");
		}
	}else{
		extent.extentLoggerWarning("", "Draft video is not present");
	}
	

}


public void ValidateUnpublishedVideoUnderDraft(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab Check if user can unpublish multiple videos in profile screen");
	System.out.println("TC_Mobile_076");
	extent.extentLogger("", "TC_Mobile_076");
	Thread.sleep(5000);
	Swipe("DOWN",1);
	Thread.sleep(5000);
	
	click(HipiMePage.objprofilepagevideotab, "Video tab");
	Thread.sleep(5000);
	if(verifyIsElementDisplayed(HipiCreateVideoPage.objselectfirstimage))
	{//Swipe("UP",1)
	if(verifyIsElementDisplayed(HipiMePage.objUploadAllButton, "Upload All button")){
		scrolltomiddle(HipiMePage.objUploadAllButton);
	}else{
		
	}
	scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
	Thread.sleep(5000);
	
	String videodatawhichwillbeunpublishedatfirstindex=findElement(HipiMePage.objdraftvideodesc).getText();
	//System.out.println("Video Data:"+videodatawhichwillbeunpublishedatfirstindex);
	Thread.sleep(5000);
	longPress(HipiMePage.objdraftvideodesc);
	Thread.sleep(5000);
	click(HipiMePage.objdraftunpublishvideobtn, "Unpublish video button");
	Thread.sleep(5000);
	click(HipiMePage.objdraftunpublishvideodialogokbtn, "Yes button");
	Thread.sleep(5000);
	click(HipiMePage.objvideounpublisheddialogdonebtn, "Done button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objdraftunpublishedvideodesc,"Video unpublished"))
	{
	String videodataavailabledatfirstindex=findElement(HipiMePage.objdraftunpublishedvideodesc).getText();
	//System.out.println("Video Data:"+videodataavailabledatfirstindex);
	Thread.sleep(5000);
	if(videodatawhichwillbeunpublishedatfirstindex!=videodataavailabledatfirstindex)
	{
		Thread.sleep(5000);
		logger.info("Video unpublished and unavailable under video page");
		extent.extentLoggerPass("Profile page:","Video unpublished and unavailable under video page");
	}
	else
	{
		logger.info("Video unpublished and available under video page");
		extent.extentLoggerFail("Profile page:","Video unpublished and available under video page");
	}
	}
	else
	{
		extent.extentLogger("Video:", "Video deleted");
		logger.info("Video unpublished and unavailable under video page");
	}
	}
	else
	{
		extent.extentLogger("","Video unavailable under video");
		logger.info("Video unavailable under video");//added
	}
}



public void ValidateHipiNotoficationPage(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Notification Check if user can view user related notification wrt All, video and comment section");
	System.out.println("TC_Mobile_078");
	extent.extentLogger("", "TC_Mobile_078");
	Thread.sleep(5000);
	Swipe("DOWN",1);
	Thread.sleep(5000);
	Swipe("DOWN",1);
	Swipe("DOWN",1);
	Thread.sleep(5000);
	click(HipiMePage.objhipinotificationbutton, "Notification button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objhipinotificationnoticationavailable, "Notification"))
	{
		logger.info("Notification available under all tab");
		extent.extentLoggerPass("Notification page:","Notification available under all tab");
	}
	else
	{
		logger.info("Notification unavailable under all tab");
		extent.extentLoggerPass("Notification page:","Notification unavailable under all tab");
	}
	click(HipiMePage.objhipinotificationvideotab, "Video tab");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objhipinotificationvideotabdialog, "You're all caught up dialog"))
	{
		logger.info("You're all caught up dialog available under video tab");
		extent.extentLoggerPass("Profile page:","You're all caught up dialog available under video tab");
	}
	else
	{
		logger.info("Notification available under video tab");
		extent.extentLoggerPass("Profile page:","Notification available under video tab");
	}
	click(HipiMePage.objhipinotificationcommenttab, "Comment tab");
	Thread.sleep(5000);
	if(verifyElementExist(HipiMePage.objhipinotificationcommenttabdialog, "You're all caught up dialog"))
	{
		logger.info("You're all caught up dialog available under comment tab");
		extent.extentLoggerPass("Profile page:","You're all caught up dialog available under comment tab");
	}
	else
	{
		logger.info("Comment available under video tab");
		extent.extentLoggerPass("Profile page:","Comment available under video tab");
	}
	Thread.sleep(5000);
	Back(1);
	Thread.sleep(5000);
	click(HipiMePage.objprofilepagedefaulttab, "Default profile tab");
	Thread.sleep(5000);
}
public void ValidateProfileVideoDelete(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab Check if user can delete multiple videos in Video section");
	System.out.println("TC_Mobile_079");
	extent.extentLogger("", "TC_Mobile_079");
	Thread.sleep(5000);
	
	//Swipe("UP",1)
	if(verifyElementExist(HipiCreateVideoPage.objselectfirstimage, "Video"))//added
	{
		scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
		Thread.sleep(5000);
		
		String videodatabeforedeleting=getAttributValue("text", HipiMePage.objvideotobedeleteddescriptiondata);
		System.out.println("Video Data:"+videodatabeforedeleting);
		Thread.sleep(5000);
		
		
		longPress(HipiMePage.objvideotobedeleted);
		Thread.sleep(5000);
		click(HipiMePage.objpublishedvideodelete, "Delete button");
		Thread.sleep(5000);
		click(HipiMePage.objdoyouwanttodeletevideoyesbtn, "Yes button");
		Thread.sleep(5000);
		click(HipiMePage.objvideodeleteddialogdonebtn, "Done button");
		Thread.sleep(5000);
		
		click(HipiMePage.objdraft, "Draft tab");
		//PartialSwipe("UP",1);
		scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
		Thread.sleep(5000);
		String videodataavailabledatfirstindex=getAttributValue("text", HipiMePage.objdraftvideodesc);
		System.out.println("Video Data:"+videodataavailabledatfirstindex);
		Thread.sleep(5000);
		if(videodatabeforedeleting!=videodataavailabledatfirstindex)
		{
			Thread.sleep(5000);
			logger.info("Video deleted and unavailable under video page");
			extent.extentLoggerPass("Profile page:","Video deleted and unavailable under video page");
		}
		else
		{
			logger.info("Video deleted and available under video page");
			extent.extentLoggerFail("Profile page:","Video deleted and available under video page");
		}
	}
	else//added
	{
		logger.info("Video unavailable under all");//added
		extent.extentLogger("", "Video unavailable under all");
	}
	
	
	
}




//public void ValidateInValidDataCannotShared(String userType) throws Exception
//{
//	extent.HeaderChildNode("OwnProfile Share Check if user is unable to share profile onFB by tapping share>FB  Invalid credentials");
//	System.out.println("TC_Mobile_056");
//	extent.extentLogger("", "TC_Mobile_056");
//	Thread.sleep(5000);
//	Back(1);
//
//	Thread.sleep(5000);
//	click(AMDOnboardingScreen.objForMeButton, "Me");
//	Thread.sleep(5000);
////	click(AMDHipi.objHipiIcon, "Hipi icon");
////	Thread.sleep(5000);
////	click(AMDOnboardingScreen.objForMeButton, "Me");
////	Thread.sleep(5000);
//	click(HipiMePage.objprofilepagesharebtn,"Share button");
//	Thread.sleep(5000);
//	clearFacebookData();
//	Thread.sleep(5000);
//	click(HipiMePage.objfacebookbtn,"Facebook button");
//	Thread.sleep(20000);
//	waitForElementDisplayed(HipiMePage.objemail, 30);
////	String Invalidemail = getParameterFromXML("Invalidemail");
////	String Invalidpassword = getParameterFromXML("Invalidpassword");
//	click(HipiMePage.objemail, "Facebook Email");
//	type(HipiMePage.objemail, "abcd", "Email Field");
//	hideKeyboard();
//	click(HipiMePage.objpassword, "Facebook Password");
//	type(HipiMePage.objpassword,"xyz", "Password Field");
//	hideKeyboard();
//	click(HipiMePage.objlogin,"Log button");
//	Thread.sleep(10000);
//	Thread.sleep(10000);
//	Thread.sleep(10000);
//	if(verifyElementExist(HipiMePage.objaccountdialog, "account dialog"))
//	{
//		logger.info("Invalid credential cannot share profile");
//		extent.extentLoggerPass("Profile page:","Invalid credential cannot share profile");
//
//	}
//	else
//	{
//		logger.info("Invalid credential can share profile");
//		extent.extentLoggerFail("Profile page:","Invalid credential can share profile");
//	}
//	
//}
public void ValidateValidDataCanShared(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Share Check if user is unable to share profile onFB by tapping share>FB  valid credentials");
	System.out.println("TC_Mobile_055");
	extent.extentLogger("", "TC_Mobile_055");
	Thread.sleep(5000);
//	click(HipiMePage.objaccountdialog, "Ok button");
//	Thread.sleep(5000);
//	clearField(HipiMePage.objemailfield, "Email Field");
//	Thread.sleep(5000);
//	clearField(HipiMePage.objpassword, "Password Field");
//	Thread.sleep(5000);
//	String Validemail = getParameterFromXML("Validfacebookemail");
//	String Validpassword = getParameterFromXML("Validfacebookpassword");
//	type(HipiMePage.objemail, Validemail, "Email Field");
//	type(HipiMePage.objpassword,Validpassword, "Password Field");
//	click(HipiMePage.objlogin,"Log button");
//	Thread.sleep(30000);
//	if(verifyElementExist(HipiMePage.objnotnow, "Not now button"))
//	{
//		click(HipiMePage.objnotnow,"Not now button");
//	}
//	else
//	{
//		extent.extentLogger("Profile page:", "Not now button unavailable");
//	}
	
	Back(1);

	Thread.sleep(5000);
	click(AMDOnboardingScreen.objForMeButton, "Me");
	Thread.sleep(5000);
//	click(AMDHipi.objHipiIcon, "Hipi icon");
//	Thread.sleep(5000);
//	click(AMDOnboardingScreen.objForMeButton, "Me");
//	Thread.sleep(5000);
	click(HipiMePage.objprofilepagesharebtn,"Share button");
	Thread.sleep(5000);
Swipe("UP",1);//added
Thread.sleep(5000);//added
	Thread.sleep(5000);
	click(HipiMePage.objfacebookbtn,"Facebook button");
	
	if(verifyElementExist(HipiMePage.objpost, "Post button"))
	{
		click(HipiMePage.objpost, "Post button");
		logger.info("Valid credential can share profile");
		extent.extentLoggerPass("Profile page:","Valid credential can share profile");
	}
	else
	{
		logger.info("Valid credential cannot share profile");
		extent.extentLoggerFail("Profile page:","Valid credential cannot share profile");
	}
}


public static void clearFacebookData() 
{
		String cmd1 = "adb shell pm clear com.facebook.katana";
		try {
			Runtime.getRuntime().exec(cmd1);
		} catch (IOException e) {
			e.printStackTrace();
		}
}




public void ValidateMeLoginRegisterpopupGuest(String userType) throws Exception {
	extent.HeaderChildNode("OwnProfile Check if user is not logged in, on tapping Me icon should redirect to default Zee5 login page");
	System.out.println("TC_Mobile_02");
	extent.extentLogger("", "TC_Mobile_02");
	verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
	Thread.sleep(5000);
	if (verifyElementExist(AMDOnboardingScreen.objForMeButton, "Me")) {
	click(AMDOnboardingScreen.objForMeButton, "Me");
	if (verifyElementExist(AMDOnboardingScreen.objLoginDialog, "Register to start using HiPi"))
	{
					logger.info("Login/Register Popup is displayed");
					extent.extentLoggerPass("Hipi page:", "Login/Register Popup is displayed");
					Back(1);
				} else
				{
					logger.info("Login/Register Popup is undisplayed");
					extent.extentLoggerFail("Hipi page:", "Login/Register Popup is not displayed");
				}
	}
			}






public void ValidateBioUpdated(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Edit Check if user is able to view updated Bio in edit profile screen");
	System.out.println("TC_Mobile_052");
	extent.extentLogger("", "TC_Mobile_052");
	Thread.sleep(5000);
	if(verifyElementExist(AMDOnboardingScreen.objForMeButton, "Me"))//added
	{
		click(AMDOnboardingScreen.objForMeButton, "Me button");
		Thread.sleep(5000);
	}
	else
	{
		extent.extentLogger("", "Profile page available");
	}
	
	
	
	String BioBeforeUpdatingProfilePage = getAttributValue("text", HipiMePage.objprofilepagebio);
	extent.extentLogger("", BioBeforeUpdatingProfilePage);
	Thread.sleep(5000);
	
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagebio,"Bio");
	Thread.sleep(5000);
	
	String BioBeforeUpdatingEditProfilePage = getAttributValue("text", HipiMePage.objeditprofilepagebio);
	extent.extentLogger("", BioBeforeUpdatingEditProfilePage);
	Thread.sleep(5000);
	
	type(HipiMePage.objeditprofilepagebio,"Bio"+GeneratingRandomString(7),"Bio added");
	Thread.sleep(5000);
	
	click(HipiMePage.objeditprofilepageeditbuttonavailable,"Edit button");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagedone,"Yes button");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagedone,"Yes button");
	Thread.sleep(5000);
	
	String BioAfterUpdatingProfilePage = getAttributValue("text", HipiMePage.objprofilepagebio);
	extent.extentLogger("", BioAfterUpdatingProfilePage);
	Thread.sleep(5000);
	
	if(BioAfterUpdatingProfilePage!=BioBeforeUpdatingProfilePage)
	{
		logger.info("User is able to view updated Bio in  profile screen");
		extent.extentLoggerPass("Profile page:","User is able to view updated Bio in  profile screen");
	}
	else
	{
		logger.info("User is not able to view updated Bio in  profile screen");
		extent.extentLoggerFail("Profile page:","User is not able to view updated Bio in  profile screen");
	}
	click(HipiMePage.objeditprofile,"Edit profile");
	Thread.sleep(5000);
	String BioAfterUpdatingEditProfilePage = getAttributValue("text", HipiMePage.objeditprofilepagebio);
	extent.extentLogger("", BioAfterUpdatingEditProfilePage);
	Thread.sleep(5000);
	if(BioAfterUpdatingEditProfilePage!=BioBeforeUpdatingEditProfilePage)
	{
		logger.info("User is able to view updated Bio in edit profile screen");
		extent.extentLoggerPass("Profile page:","User is able to view updated Bio in edit profile screen");
	}
	else
	{
		logger.info("User is not able to view updated Bio in edit profile screen");
		extent.extentLoggerFail("Profile page:","User is not able to view updated Bio in edit profile screen");
	}
	click(HipiMePage.objeditprofilepageeditbtn,"Edit button");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagebio,"Bio");
	Thread.sleep(5000);
	type(HipiMePage.objeditprofilepagebio,"Bio","Bio added");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepageeditbuttonavailable,"Edit button");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagedone,"Yes button");
	Thread.sleep(5000);
	click(HipiMePage.objeditprofilepagedone,"Yes button");
	Thread.sleep(5000);
}

public void ValidateFollowlist(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Followers List Screen Check the followers user list has no duplicate users by refreshing the content");
	System.out.println("TC_Mobile_031");
	extent.extentLogger("", "TC_Mobile_031");
	Thread.sleep(5000);
//	Back(1);
//	Thread.sleep(5000);
	click(HipiMePage.objfollowvalueprofile,"Follow");
	Thread.sleep(5000);
	Swipe("DOWN",1);
	Thread.sleep(5000);
	
	List<WebElement> list = getDriver().findElements(HipiMePage.objfollowlistuser);
	System.out.println(list.size());
	
	ArrayList<String> array = new ArrayList<String>();
	for(int i = 1; i < list.size(); i++)
	{  
	   String value = getAttributValue("text",HipiMePage.objfollowlistuserText(i));
	   array.add(value);
     System.out.println(value);
	} 
	 System.out.println(array);
	
	 for(int i = 0; i < array.size(); i++)
	 {  
   for(int j = i + 1; j < array.size(); j++)
   {  
  	 
  	 System.out.println(array.get(i)); 
  	 System.out.println(array.get(j));  
  	 if(array.get(i).equals(array.get(j)))
   {
  	 System.out.println(array.get(i));  
  	 logger.info("Follow page:"+ "Follow list page have duplicate profile");
  	 extent.extentLoggerFail("Follow page:","Follow list page have duplicate profile");
   }
   else
   {
  	 logger.info("Follow page:"+ "Follow list page do not have duplicate profile");
  	 extent.extentLoggerPass("Follow page:","Follow list page do not have duplicate profile");
   }
   }
	 }
	 Back(1);
	 Thread.sleep(5000);
	}

public void ValidateFollowinglist(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Following List Screen Check the following user list has no duplicate users by refreshing the content");
	System.out.println("TC_Mobile_030");
	extent.extentLogger("", "TC_Mobile_030");
	Thread.sleep(5000);
	click(HipiMePage.objfollowingvalueprofile,"Following");
	Thread.sleep(5000);
	Swipe("DOWN",1);
	Thread.sleep(5000);
	
	List<WebElement> list = getDriver().findElements(HipiMePage.objfollowinglistuser);
	System.out.println(list.size());
	
	ArrayList<String> array = new ArrayList<String>();
	for(int i = 1; i < list.size(); i++)
	{  
	   String value = getAttributValue("text",HipiMePage.objfollowinglistuserText(i));
	   array.add(value);
     System.out.println(value);
	} 
	 System.out.println(array);
	
	 for(int i = 0; i < array.size(); i++)
	 {  
   for(int j = i + 1; j < array.size(); j++)
   {  
  	 
  	 System.out.println(array.get(i)); 
  	 System.out.println(array.get(j));  
  	 if(array.get(i).equals(array.get(j)))
   {
  	 System.out.println(array.get(i));  
  	 logger.info("Following page:"+ "Following list page have duplicate profile");
  	 extent.extentLoggerFail("Following page:","Following list page have duplicate profile");
   }
   else
   {
  	 logger.info("Following page:"+ "Following list page do not have duplicate profile");
  	 extent.extentLoggerPass("Following page:","Following list page do not have duplicate profile");
   }
   }
	 }
}
































public void ValidatingDraftVideoUnavailable(String userType) throws Exception{
	
	if(userType.equalsIgnoreCase("NonSubscribedUser")){
		ValidatingDraftVideoUnavailablebyOthers(userType);
	}
	else
	{
	}
	}

public void ValidatingDraftVideoUnavailablebyOthers(String userType) throws Exception
{
	extent.HeaderChildNode("OwnProfile Video LTab Draft Check if Draft videos of logged in user are not visible for Normal User");
	System.out.println("TC_Mobile_71");
	extent.extentLogger("", "TC_Mobile_71");
	verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
	click(HipiFeedPage.objCreateVideoIcon, "Create video button");
	Thread.sleep(5000);
	if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo, "Allow ZEE5 to take pictures and record video?"))
	{
		logger.info("Allow ZEE5 to take pictures and record video?");
		click(HipiCreateVideoPage.objCreateAllow, "Allow button");
		logger.info("Allow button");
		Thread.sleep(5000);
	}
	else
	{
		logger.info("Allow ZEE5 to take pictures and record video? unavailable");
	}
	
	if(verifyElementExist(HipiCreateVideoPage.objCreatePermissiondevice, "Allow ZEE5 to access photos, media, and files on your device?"))
	{
		logger.info("Allow ZEE5 to access photos, media, and files on your device");	
		click(HipiCreateVideoPage.objCreateAllow, "Allow button");
		logger.info("Allow button");
		Thread.sleep(5000);
	}
	else
	{
		logger.info("Allow ZEE5 to access photos, media, and files on your device? unavailable");
	}
	
	if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionRecordAudio, "Allow ZEE5 to record audio?"))
	{
		logger.info("Allow ZEE5 to record audio");
		click(HipiCreateVideoPage.objCreateAllow, "Allow button");	
		logger.info("Allow button");
		waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
		verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
		click(HipiCreateVideoPage.objCreateReadyYes, "yes button");
		logger.info("yes button");
		Thread.sleep(10000);
	}
	else
	{
		logger.info("Allow ZEE5 to record audio unavailable");
	}
	
	verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record start button");
	Thread.sleep(30000);
	verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "Post button");
	Thread.sleep(20000);

	type(HipiCreateVideoPage.objadddescription,"Draft"+GeneratingRandomString(7),"Description");
	Thread.sleep(5000);
	hideKeyboard();
	Thread.sleep(5000);
	
	click(HipiCreateVideoPage.objgenrevideo, "Genre button");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objlanguageclickedhindi, "Hindi button");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objcheckbox, "Checkbox");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objsaveasdraft, "Save as draft button");
	Thread.sleep(5000);
	
	click(HipiMePage.objdraftvideopostpagegotofeed, "Go to feed button");
	Thread.sleep(5000);
	click(HipiMePage.objMeicon, "Me icon");
	Thread.sleep(5000);	
	String profiledata=findElement(HipiMePage.objprofiledata).getText();
	System.out.println("Added Data:"+profiledata);
	Thread.sleep(5000);
	Back(1);
	Thread.sleep(5000);
	Back(1);
	Thread.sleep(5000);
	click(HipiMePage.objmorebutton, "More button");
	Thread.sleep(5000);
	Swipe("UP",1);
	Thread.sleep(5000);
	click(HipiMePage.objlogoutbutton, "Logout button");
	Thread.sleep(5000);
	click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
	Thread.sleep(5000);
	Back(1);
	Thread.sleep(5000);
	click(AMDHipi.objHipiIcon, "Hipi icon");
	Thread.sleep(5000);
	click(HipiCreateVideoPage.objcreatevideo, "Create video button");
	Thread.sleep(5000);
	click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
	Thread.sleep(5000);
	
	String NonSubUsername1 = getParameterFromXML("NotificationNonSubUsername1");
	String NonSubPassword1 = getParameterFromXML("NotificationNonSubPassword1");
	Thread.sleep(5000);
	
	type(AMDLoginScreen.objEmailIdField, NonSubUsername1, "Email Field");
	verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
	type(AMDLoginScreen.objPasswordField, NonSubPassword1, "Password field");
	hideKeyboard();
	
	verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
	Thread.sleep(10000);
	click(HipiMePage.objdiscovertext, "Discover button");
	Thread.sleep(5000);
	click(HipiMePage.objsearchfield, "Search button");
	Thread.sleep(5000);
	type(HipiMePage.objsearchfield, profiledata, "Search field");
	Thread.sleep(10000);
	waitForElementAndClickIfPresent(HipiMePage.objdraftvideodata, 10, "Account where video drafted");
	Thread.sleep(5000);
	if(verifyElementIsNotDisplayed(HipiMePage.objdraft))
	{
		logger.info("Draft videos of logged in user are not visible for Normal User");
		extent.extentLoggerPass("Profile page:", "Draft videos of logged in user are not visible for Normal User");
	}
	else
	{
		logger.info("Draft videos of logged in user are visible for Normal User");
		extent.extentLoggerFail("Profile page:", "Draft videos of logged in user are  visible for Normal User");
	}
}

























//-----------------------------------------------------clipSegmentation--------------------------------------------------------------------




public void clipSegmentationModule(String userType) throws Exception {
	if (!userType.equals("Guest")) {
		
		NavigateToCreateScreen(userType);
		singleClipSegmentOnTheRecordingScreen(userType);
		multipleClipsegmentIsNotDeletedWhenClickedOnNo(userType);
		multipleClipSegmentDeletedWhenClickedOnYes(userType);
		noRecordingCompleted(userType);
		deleteYesRecordingCompleted(userType);
		deleteNoRecordingNotCompleted(userType);
		deleteYesRecordingNotCompleted(userType);
	}else {
		
	}
	
	
}
	

	
public void NavigateToCreateScreen(String userType) throws Exception {

	extent.HeaderChildNode(" Navigate  Create Screen");

	verifyElementPresentAndClick(AMDHipi.objHipiIcon, "Hipi icon");
	
	click(HipiCreateVideoPage.objcreatevideo, "Creater Icon");

	if (verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo,
			"Allow ZEE5 to take pictures and record video?")) {
		logger.info("Permission dialog:" + "Allow ZEE5 to take pictures and record video?");
		verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow");
		click(HipiCreateVideoPage.objCreateAllow, "Allow button");
		logger.info("Allow ZEE5 to take pictures and record video-" + "Allow button");
		Thread.sleep(5000);

		logger.info("Permission dialog:" + "Allow ZEE5 to access photos, media, and files on your device");
		verifyElementExist(HipiCreateVideoPage.objCreateAllow,
				"Allow ZEE5 to access photos, media, and files on your device?");
		click(HipiCreateVideoPage.objCreateAllow, "Allow button");
		logger.info("Allow ZEE5 to access photos, media, and files on your device-" + "Allow button");
		Thread.sleep(5000);

		logger.info("Permission dialog:" + "Allow ZEE5 to record audio");
		verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?");
		click(HipiCreateVideoPage.objCreateAllow, "Allow button");
		logger.info("Allow ZEE5 to record audio-" + "Allow button");
		//Thread.sleep(40000);
		waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
		verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
		click(HipiCreateVideoPage.objCreateReadyYes, "yes button");
		logger.info("Ready dialog displayed:" + "yes button");
		Thread.sleep(10000);
	}
	logger.info("Create video page:" + "Create video page displayed");

}

public void singleClipSegmentOnTheRecordingScreen(String userType) throws Exception {
	extent.HeaderChildNode("Check if user is able to view the single clip segment on the recording screen");
	System.out.println("TC_Mobile_001");
	extent.extentLogger("", "TC_Mobile_001");

	verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Video Record Icon");
	waitTime(1000);
//	if (verifyElementExist(HipiCreateVideoPage.objrecordprogress, "Recording Progres Bar")) {
//		logger.info("Recording Progres Bar:" + "Recording Progres Bar is Displayed When ever Video Recording");
//		extent.extentLoggerPass("Recording Progres Bar:",
//				"Recording Progres Bar is Displayed When ever Video Recording");
//
//	} else {
//		logger.info("Recording Progres Bar:" + "Recording Progres Bar is not Displayed When ever Video Recording");
//		extent.extentLoggerFail("Recording Progres Bar:",
//				"Recording Progres Bar is not Displayed When ever Video Recording");
//	}
}
//	 public void multiple_clip_segments_on_the_recording_screen(String userType) throws Exception {
//	extent.HeaderChildNode("Checking  multiple clip segments on the recording screen");
//	System.out.println("TC_Mobile_002");
//	click(AMDClipSegment.objTaponRecordingIcon, "Recording Icon");
//	
//	if(verifyElementExist(AMDClipSegment.objVideoCreationScreen, "Video Creation Screen")) {
//		
//		logger.info("Video Creation Screen:"+ "When ever user click on Pause button Video Creation Screen is displayed");
//		extent.extentLoggerPass("Video Creation Screen:", "When ever user click on Pause button Video Creation Screen is displayed");
//	}else {
//		logger.info("Video Creation Screen:"+ "When ever user click on Pause button Video Creation Screen is not displayed");
//		extent.extentLoggerPass("Video Creation Screen:", "When ever user click on Pause button Video Creation Screen is not displayed");
//	}
//	click(AMDClipSegment.objTaponRecordingIcon, "Recording Icon");
//	
//	 }

public void multipleClipsegmentIsNotDeletedWhenClickedOnNo(String userType) throws Exception {

	extent.HeaderChildNode("Check if last recorded clip in a multiple clip segment is not deleted when clicked on No");
	System.out.println("TC_Mobile_003");
	extent.extentLogger("", "TC_Mobile_003");
	click(HipiCreateVideoPage.objrecordbtn, "Recording pause");
//	waitTime(3000);
//	if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Video Creation screen")) {
//		logger.info("Video Creation Screen:"
//				+ "When ever user click on Pause button Video Creation Screen is displayed");
//		extent.extentLoggerPass("Video Creation Screen:",
//				"When ever user click on Pause button Video Creation Screen is displayed");
//	} else {
//		logger.info("Video Creation Screen:"
//				+ "When ever user click on Pause button Video Creation Screen is not displayed");
//		extent.extentLoggerFail("Video Creation Screen:",
//				"When ever user click on Pause button Video Creation Screen is not displayed");
//	}

	click(HipiCreateVideoPage.objrecordbtn, "Recording Button Resume");

//	if (verifyElementExist(HipiCreateVideoPage.objrecordingScreen, "Recording Screen")) {
//
//		logger.info("Recording Screen:" + "When ever recording button is resume Recording Screen is displayed");
//		extent.extentLoggerPass("Recording Screen:",
//				"When ever recording button is resume Recording Screen is displayed");
//	} else {
//		logger.info("Recording Screen:" + "When ever recording button is resume Recording Screen is not displayed");
//		extent.extentLoggerFail("Recording Screen:",
//				"When ever recording button is resume Recording Screen is not displayed");
//	}
	Thread.sleep(2000);
	click(HipiCreateVideoPage.objrecordbtn, "Record Button pause");

	if (verifyElementExist(HipiCreateVideoPage.objdeleteclip, "Delete Clip")) {
		logger.info("Delete Clip:" + " Delete Option is displayed on right side of Recording Clip");
		extent.extentLoggerPass("Delete Clip:", " Delete Option is displayed on right side of Recording Clip");
	} else {
		logger.info("Delete Clip:" + " Delete Option is not displayed on right side of Recording Clip");
		extent.extentLoggerFail("Delete Clip:", " Delete Option is not displayed on right side of Recording Clip");
	}
	click(HipiCreateVideoPage.objdeleteclip, "Delete Clip");

	waitTime(3000);
	if (verifyElementExist(HipiCreateVideoPage.objdeletepopup, "Delete Last Clip PopUp")) {
		logger.info("Delete LastClip PopUp "
				+ " When ever user click on Delete clip Delete last clip popup is displayed");
		extent.extentLoggerPass("Delete LastClip PopUp",
				" When ever user click on Delete clip Delete last clip popup is displayed");
		click(HipiCreateVideoPage.objdeleteNo, "No Button");
	} else {
		logger.info("Delete LastClip PopUp "
				+ " When ever user click on Delete clip Delete last clip popup is not displayed");
		extent.extentLoggerFail("Delete LastClip PopUp",
				"When ever user click on Delete clip Delete last clip popup is not displayed");
	}
	waitTime(3000);
	if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Video Record Screen")) {

		logger.info("Video Creation Screen: "
				+ " When ever user click on NO Button Previous Video Creation Screen is displayed");
		extent.extentLoggerPass("Video Creation Screen: ",
				" When ever user click on NO Button Previous Video Creation Screen is displayed");
		waitTime(3000);
	} else {
		logger.info("Video Creation Screen: "
				+ " When ever user click on NO Button Previous Video Creation Screen is not displayed");
		extent.extentLoggerFail("Video Creation Screen: ",
				" When ever user click on NO Button Previous Video Creation Screen is not displayed");
	}
}

public void multipleClipSegmentDeletedWhenClickedOnYes(String userType) throws Exception {

	extent.HeaderChildNode("Check if last recorded clip in a multiple clip segment is deleted when clicked on Yes");
	System.out.println("TC_Mobile_004");
	extent.extentLogger("", "TC_Mobile_004");
	click(HipiCreateVideoPage.objdeleteclip, "Delete Clip");
	waitTime(3000);
	click(HipiCreateVideoPage.objdeleteyes, "Yes Button");
//    waitTime(3000);

	if (verifyElementExist(HipiCreateVideoPage.objLastClipdeleted, "Delete title popup")) {
		logger.info("Delete title popup:" + "When ever click on yes button Delete title popup is delete");
		extent.extentLoggerPass("Delete title popup:",
				"When ever click on yes button Delete title popup is delete");

	} else {
		logger.info("Delete title popup:" + "When ever click on yes button Delete title popup is delete");
		extent.extentLoggerFail("Delete title popup:",
				"When ever click on yes button Delete title popup is delete");
	}
//	click(HipiCreateVideoPage.objdeleteclip, "Delete Clip");
//    waitTime(3000);
//    click(HipiCreateVideoPage.objdeleteyes, "Yes Button");        
//    waitTime(3000);

}

public void noRecordingCompleted(String userType) throws Exception {

	extent.HeaderChildNode("Check if recorded clip is not deleted when clicked on No Recording completed");
	System.out.println("TC_Mobile_005");
	extent.extentLogger("", "TC_Mobile_005");
	verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Video Record Icon");
	logger.info("Wait for the video 'creation time' to lapse");
	waitTime(15000);
//	if(verifyElementExist(HipiCreateVideoPage.objrecord_progress,"Recording Progres Bar")) {
//		logger.info("Recording Progres Bar:"+ "Recording Progres Bar is Displayed When ever Video Recording");
//		extent.extentLoggerPass("Recording Progres Bar:", "Recording Progres Bar is Displayed When ever Video Recording");
//		waitTime(3000);
//	}else {
//		logger.info("Recording Progres Bar:"+ "Recording Progres Bar is not Displayed When ever Video Recording");
//		extent.extentLoggerFail("Recording Progres Bar:", "Recording Progres Bar is not Displayed When ever Video Recording");
//	}
//	waitTime(20000);
	if (verifyElementExist(HipiCreateVideoPage.objVideoEditScreen, "Video Edit Screen")) {

		logger.info("VideoEdit Screen: " + " When ever recording complet video edit screen is displayed ");
		extent.extentLoggerPass("VideoEdit Screen:", "When ever recording complet video edit screen is displayed ");
		click(HipiCreateVideoPage.objeditvideobackbtn, "Back Icon");
	} else {
		logger.info("VideoEdit Screen: " + " When ever recording complet video edit screen is not displayed ");
		extent.extentLoggerFail("VideoEdit Screen:",
				"When ever recording complet video edit screen is not displayed ");
	}

	if (verifyElementExist(HipiCreateVideoPage.objcontinueshootdialog, "Continue Shoot Popup")) {
		logger.info("Continue Shoot Popup: "
				+ " When evre click on back button user eable to see continue shoot popup");
		extent.extentLoggerPass("Continue Shoot Popup:",
				"When evre click on back button user eable to see continue shoot popup");
		click(HipiCreateVideoPage.objcontinuebtn, "Continue");
	} else {
		logger.info("Continue Shoot Popup: "
				+ " When evre click on back button user is not eable to see continue shoot popup");
		extent.extentLoggerFail("Continue Shoot Popup:",
				"When evre click on back button user is not eable to see continue shoot popup");
	}

	if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Video Record Screen")) {
		logger.info("Video Record Screen "
				+ " When ever user click on Continue Shoot  video recording screen is displayed");
		extent.extentLoggerPass("Video Record Screen ",
				" When ever user click on Continue Shoot  video recording screen is displayed");
	} else {
		logger.info("Video Record Screen "
				+ " When ever user click on Continue Shoot  video recording screen is not displayed");
		extent.extentLoggerFail("Video Record Screen ",
				" When ever user click on Continue Shoot  video recording screen is not displayed");
	}

	if (verifyElementExist(HipiCreateVideoPage.objdeleteclip, "Delete Clip")) {
		logger.info("Delete Clip:" + " Delete Option is displayed on right side of Recording Clip");
		extent.extentLoggerPass("Delete Clip:", " Delete Option is displayed on right side of Recording Clip");
	} else {
		logger.info("Delete Clip:" + " Delete Option is not displayed on right side of Recording Clip");
		extent.extentLoggerFail("Delete Clip:", " Delete Option is not displayed on right side of Recording Clip");
	}

	click(HipiCreateVideoPage.objdeleteclip, "Delete Clip");
	waitTime(3000);
	if (verifyElementExist(HipiCreateVideoPage.objdeletepopup, "Delete LastClip PopUp")) {
		logger.info("Delete LastClip PopUp "
				+ " When ever user click on Delete clip Delete last clip popup is displayed");
		extent.extentLoggerPass("Delete LastClip PopUp",
				" When ever user click on Delete clip Delete last clip popup is displayed");
		click(HipiCreateVideoPage.objdeleteNo, "No Button");
	} else {
		logger.info("Delete LastClip PopUp "
				+ " When ever user click on Delete clip Delete last clip popup is not displayed");
		extent.extentLoggerFail("Delete LastClip PopUp",
				"When ever user click on Delete clip Delete last clip popup is not displayed");
	}

	waitTime(3000);
	if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Video Record Screen")) {

		logger.info("Video Creation Screen: "
				+ " When ever user click on NO Button Previous Video Creation Screen is displayed");
		extent.extentLoggerPass("Video Creation Screen: ",
				" When ever user click on NO Button Previous Video Creation Screen is displayed");
		waitTime(3000);
	} else {
		logger.info("Video Creation Screen: "
				+ " When ever user click on NO Button Previous Video Creation Screen is not displayed");
		extent.extentLoggerFail("Video Creation Screen: ",
				" When ever user click on NO Button Previous Video Creation Screen is not displayed");
	}
}

public void deleteYesRecordingCompleted(String userType) throws Exception {

	extent.HeaderChildNode("Check if recorded clip is deleted when clicked on Yes Recording completed");
	System.out.println("TC_Mobile_006");
	extent.extentLogger("", "TC_Mobile_006");
	click(HipiCreateVideoPage.objdeleteclip, "Delete Clip");
	waitTime(3000);
	click(HipiCreateVideoPage.objdeleteyes, "Yes Button");
//        waitTime(3000);
	if (verifyElementExist(HipiCreateVideoPage.objalertdeletetitle, "Hipi Delete Popup")) {

		logger.info("Hipi Delete Popup: " + " When Ever user click on YES Button HIPI Delete Popup is displayed");
		extent.extentLoggerPass("Hipi Delete Popup:",
				"When Ever user click on YES Button HIPI Delete Popup is displayed");
		waitTime(3000);
	} else {
		logger.info(
				"Hipi Delete Popup: " + " When Ever user click on YES Button HIPI Delete Popup is not displayed");
		extent.extentLoggerFail("Hipi Delete Popup:",
				"When Ever user click on YES Button HIPI Delete Popup is not displayed");
	}
//        click(AMDClipSegment.objDeleteOption, "Delete Option");
//        waitTime(3000);
//        click(AMDClipSegment.objYesButton, "Yes Button");
//        

	waitTime(3000);

}

public void deleteNoRecordingNotCompleted(String userType) throws Exception {

	extent.HeaderChildNode("Check if recording clip is not deleted when clicked on No Recording not completed");
	System.out.println("TC_Mobile_007");
	extent.extentLogger("", "TC_Mobile_007");
	verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Video record Button");
	waitTime(2000);
//		if(verifyElementExist(HipiCreateVideoPage.objrecord_progress,"Recording Progres Bar")) {
//			logger.info("Recording Progres Bar:"+ "Recording Progres Bar is Displayed When ever Video Recording");
//			extent.extentLoggerPass("Recording Progres Bar:", "Recording Progres Bar is Displayed When ever Video Recording");
//			waitTime(3000);
//		}else {
//			logger.info("Recording Progres Bar:"+ "Recording Progres Bar is not Displayed When ever Video Recording");
//			extent.extentLoggerFail("Recording Progres Bar:", "Recording Progres Bar is not Displayed When ever Video Recording");
//		}

	click(HipiCreateVideoPage.objrecordbtn, "Recording Icon");
	waitTime(3000);

	if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Video Record Screen")) {

		logger.info("Video Creation Screen: "
				+ " When ever user click on NO Button Previous Video Creation Screen is displayed");
		extent.extentLoggerPass("Video Creation Screen: ",
				" When ever user click on NO Button Previous Video Creation Screen is displayed");
		waitTime(3000);
	} else {
		logger.info("Video Creation Screen: "
				+ " When ever user click on NO Button Previous Video Creation Screen is not displayed");
		extent.extentLoggerFail("Video Creation Screen: ",
				" When ever user click on NO Button Previous Video Creation Screen is not displayed");
	}

	if (verifyElementExist(HipiCreateVideoPage.objdeleteclip, "Delete Clip")) {
		logger.info("Delete Clip:" + " Delete Option is displayed on right side of Recording Clip");
		extent.extentLoggerPass("Delete Clip:", " Delete Option is displayed on right side of Recording Clip");
		click(HipiCreateVideoPage.objdeleteclip, "Delete Clip");
	} else {
		logger.info("Delete Clip:" + " Delete Option is not displayed on right side of Recording Clip");
		extent.extentLoggerFail("Delete Clip:", " Delete Option is not displayed on right side of Recording Clip");
	}

	waitTime(3000);
	if (verifyElementExist(HipiCreateVideoPage.objdeletepopup, "Delete LastClip PopUp")) {
		logger.info("Delete LastClip PopUp "
				+ " When ever user click on Delete clip Delete last clip popup is displayed");
		extent.extentLoggerPass("Delete LastClip PopUp",
				" When ever user click on Delete clip Delete last clip popup is displayed");
		click(HipiCreateVideoPage.objdeleteNo, "No Button");
	} else {
		logger.info("Delete LastClip PopUp "
				+ " When ever user click on Delete clip Delete last clip popup is not displayed");
		extent.extentLoggerFail("Delete LastClip PopUp",
				"When ever user click on Delete clip Delete last clip popup is not displayed");
	}

	waitTime(3000);
	if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Video Record Screen")) {

		logger.info("Video Creation Screen: "
				+ " When ever user click on NO Button Previous Video Creation Screen is displayed");
		extent.extentLoggerPass("Video Creation Screen: ",
				" When ever user click on NO Button Previous Video Creation Screen is displayed");
		waitTime(3000);
	} else {
		logger.info("Video Creation Screen: "
				+ " When ever user click on NO Button Previous Video Creation Screen is not displayed");
		extent.extentLoggerFail("Video Creation Screen: ",
				" When ever user click on NO Button Previous Video Creation Screen is not displayed");
	}
}

public void deleteYesRecordingNotCompleted(String userType) throws Exception {
	extent.HeaderChildNode("Check if recording clip is deleted when clicked on Yes Recording not completed");

	System.out.println("TC_Mobile_008");
	extent.extentLogger("", "TC_Mobile_008");
	click(HipiCreateVideoPage.objdeleteclip, "Delete Clip");
	waitTime(3000);
	
	
	
	click(HipiCreateVideoPage.objdeleteyes, "Yes Button");
//        waitTime(3000);
	if (verifyElementExist(HipiCreateVideoPage.objalertdeletetitle, "Hipi Delete Popup")) {

		logger.info("Hipi Delete Popup: " + " When Ever user click on YES Button HIPI Delete Popup is displayed");
		extent.extentLoggerPass("Hipi Delete Popup:",
				"When Ever user click on YES Button HIPI Delete Popup is displayed");
		waitTime(3000);
	} else {
		logger.info(
				"Hipi Delete Popup: " + " When Ever user click on YES Button HIPI Delete Popup is not displayed");
		extent.extentLoggerFail("Hipi Delete Popup:",
				"When Ever user click on YES Button HIPI Delete Popup is not displayed");
	}

}
	
	
	
	//-----------------------------------------------------------------------------------------------------------------
	
	
	
	
public void viewHipiStarIconAnotherUserProfiles(String userType) throws Exception {
	if (!userType.equals("Guest")) {
		
	
	extent.HeaderChildNode("Checking Others Profile able to view the hipi star icon ");
	System.out.println("TC_Mobile_005");
	extent.extentLogger("", "TC_Mobile_005");
	
	verifyElementPresentAndClick(AMDHipi.objHipiIcon, "hipi icon");

	click(HipiPopularPage.objpopulartext, "Popular");
	waitTime(4000);
	if (verifyElementExist(HipiPopularPage.objpopulartitle, "Popular Title")) {

		logger.info("Popular Title:" + "When ever click on popular icon Popular title page is displayed");
		extent.extentLoggerPass("Popular Title:",
				"When ever click on popular icon Popular title page is displayed");
		
	} else {
		logger.info("Popular Title:" + "When ever click on popular icon Popular title page is not displayed");
		extent.extentLoggerFail("Popular Title:",
				"When ever click on popular icon Popular title page is not displayed");
	}
	waitTime(4000);
		click(HipiPopularPage.objprofiletext, "Profile Text");
		waitTime(5000);
		
		if (verifyElementExist(HipiPopularPage.objstaricon, "Star Icon")) {

			logger.info("Star Icon:" + "When ever user navigates to their profile screen Star Icon is displayed");
			extent.extentLoggerPass("Star Icon:",
					"When ever user navigates to their profile screen Star Icon is displayed");

		} else {
			logger.info(
					"Star Icon:" + "When ever user navigates to their profile screen Star Icon is not displayed");
			extent.extentLoggerFail("Star Icon:",
					"When ever user navigates to their profile screen Star Icon is not displayed");
		}
	}else {
	
		
	}
	
}





public void checkStarIconIsDisplayedOnUserProfile(String userType) throws Exception {
	if (!userType.equals("Guest")) {
		
	
	extent.HeaderChildNode("Checking StarIcon Is Displayed On User Profile ");
	System.out.println("TC_Mobile_014");
	extent.extentLogger("", "TC_Mobile_014");

	Back(2);
	click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
	waitTime(4000);
	if(verifyElementExist(HipiDiscoverPage.objDiscoverScreen, "Discover Screen")){
		

		logger.info("Discover Screen:" + "When ever user click on Discover,Discover Page is displayed");
		extent.extentLoggerPass("Discover Screen:","When ever user click on Discover,Discover Page is displayed");

	} else {
		logger.info(
				"Discover Screen:" + "When ever user click on Discover,Discover Page is not displayed");
		extent.extentLoggerFail("Discover Screen:","When ever user click on Discover,Discover Page is not displayed");
	}
	
//	click(HipiDiscoverPage.objSearchButton, "Search Button");
	
	waitTime(5000);
	click(HipiDiscoverPage.objTrendingVideos, "Trending Videos");
	
	if (verifyElementExist(HipiDiscoverPage.objStarIconInImage, "Star Icon")) {

		logger.info("Star Icon:" + "Star Icon is displayed on image");
		extent.extentLoggerPass("Star Icon:","Star Icon is displayed on image");

	} else {
		logger.info("Star Icon:" + "Star Icon is not displayed on image");
		extent.extentLoggerFail("Star Icon:","Star Icon is not displayed on image");
	}
	}else {
		
	}
}



public void guestUserViewHipiStarIconAnotherUserProfiles(String userType) throws Exception {

if (!userType.equalsIgnoreCase("NonSubscribedUser")) {
	
	extent.HeaderChildNode("Checking Guest User Others Profile able to view the hipi star icon ");
	System.out.println("TC_Mobile_007");
	extent.extentLogger("", "TC_Mobile_007");

	verifyElementPresentAndClick(HipiFeedPage.objHipiIcon, "Hipi icon");
	
	if (verifyElementExist(HipiPopularPage.objpopulartext, "Popular Title")) {

		logger.info("Popular Title:" + "When ever click on popular icon Popular title page is displayed");
		extent.extentLoggerPass("Popular Title:",
				"When ever click on popular icon Popular title page is displayed");
	} else {
		logger.info("Popular Title:" + "When ever click on popular icon Popular title page is not displayed");
		extent.extentLoggerFail("Popular Title:",
				"When ever click on popular icon Popular title page is not displayed");
	}
		
		click(HipiPopularPage.objpopulartext, "Popular Text");
		waitTime(4000);
		click(HipiPopularPage.objprofiletext, "Profile Text");
		waitTime(3000);
		if (verifyElementExist(HipiPopularPage.objstaricon, "Star Icon")) {

			logger.info("Star Icon:" + "When ever user navigates to their profile screen Star Icon is displayed");
			extent.extentLoggerPass("Star Icon:",
					"When ever user navigates to their profile screen Star Icon is displayed");

		} else {
			logger.info(
					"Star Icon:" + "When ever user navigates to their profile screen Star Icon is not displayed");
			extent.extentLoggerFail("Star Icon:",
					"When ever user navigates to their profile screen Star Icon is not displayed");
		}
}else {
	
}

}

	
	
	


//-----------------------------------------------AddsoundPreshootValidation--------------------------------------------------------------------




	public void BeforeShootingMethod1(String userType) throws Exception {
		if (!userType.equals("Guest")) {
			
		
		
		extent.HeaderChildNode("AddSoundPreShoot1");

		// TC_Mobile_001
		extent.HeaderChildNode(
				"Check if logged in user without permission is unable to add sound to video ie on tapping add sound icon  alert will be prompted");
		extent.extentLogger("", "TC_Mobile_001");
		System.out.println("TC_Mobile_001");
		verifyElementPresentAndClick(AMDHipi.objHipiIcon, "hipi icon");
		Thread.sleep(5000);
		verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
		checkElementExist(HipiCreateVideoPage.objpermission, "Permission popup");
		verifyElementPresentAndClick(HipiCreateVideoPage.objdenybutton, "Deny button");
		click(HipiCreateVideoPage.objdenybutton, "Deny button");
		click(HipiCreateVideoPage.objdenybutton, "Deny button");
		Boolean value = checkElementExist(HipiAddMusicPage.objAddSoundAlertPermissionPopup,
				"Add sound Alert Permission popup");
		if (value == true) {
			logger.info("User is unable to add sound without permissions");
			extent.extentLoggerPass("AddSoundPreShoot", "User is unable to add sound without permissions");
		} else {
			logger.error("User is able to add sound without permissions");
			extent.extentLoggerFail("AddSoundPreShoot", "User is able to add sound without permissions");
		}
		waitTime(2000);
		click(HipiAddMusicPage.objOkBtnInAddsoundPermissionPopup, "Ok button");
		waitTime(2000);
		Back(1);
		waitTime(3000);
		verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
		click(HipiAddMusicPage.objAllowToAddMusic, "Allow button");
		click(HipiAddMusicPage.objAllowToAddMusic, "Allow button");
		click(HipiAddMusicPage.objAllowToAddMusic, "Allow button");
		waitTime(6000);
		click(HipiAddMusicPage.objOkBtnInAddsoundPermissionPopup, "Ok button");
		waitTime(6000);

		// TC_Mobile_002
		extent.HeaderChildNode("Check if on tapping Add Music Icon user is navigated to Add Music screen");
		extent.extentLogger("", "TC_Mobile_002");
		System.out.println("TC_Mobile_002");
		verifyElementPresentAndClick(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
		Boolean value1 = checkElementExist(HipiAddMusicPage.objAddMusicTitle, "Add Music Title");
		if (value1 == true) {
			logger.info("User is navigated to Add Music screen");
			extent.extentLoggerPass("AddSoundPreShoot", "User is navigated to Add Music screen");
		} else {
			logger.error("User is unable to navigate to Add Music screen");
			extent.extentLoggerFail("AddSoundPreShoot", "User is unable to navigate to Add Music screen");
		}

		// TC_Mobile_004
		extent.HeaderChildNode("Check Layout of Music screen");
		extent.extentLogger("", "TC_Mobile_004");
		System.out.println("TC_Mobile_004");
		verifyElementExist(HipiAddMusicPage.objAddMusicTitle, "Add Music Title Header");
		verifyElementExist(HipiAddMusicPage.objBackBtnInAddMusic, "Back Icon in Add Music Screen");
		verifyElementExist(HipiAddMusicPage.objEditsearch, "Search bar in Add Music Screen");
		verifyElementPresentAndClick(HipiAddMusicPage.objEditsearch, "Edit Search bar");
		hideKeyboard();
		verifyElementExist(HipiAddMusicPage.objTrendingRailInSearchScreen, "Trending rail in Search screen");
		type(HipiAddMusicPage.objEditsearch, "Gattimela", "Search Field");
		verifyElementExist(HipiAddMusicPage.objSuggestedSearchResults, "Suggested search results");
		verifyElementExist(HipiAddMusicPage.objClearSearch, "Cross icon (*) for searching records");

		// TC_Mobile_011
		extent.HeaderChildNode(
				"Check if user tapping on search text field to enter record other options are displayed");
		extent.extentLogger("", "TC_Mobile_011");
		System.out.println("TC_Mobile_011");
		verifyElementExist(HipiAddMusicPage.objSuggestedSearchResults, "Suggested search results");
		verifyElementExist(HipiAddMusicPage.objBackBtnInSearchScreen, "Back Icon in Search Screen");
		if (verifyElementExist(HipiAddMusicPage.objSuggestedSearchResults, "Suggested search results")) {
			logger.info("User on tapping on search text field to enter record other options are displayed");
			extent.extentLoggerPass("AddSoundPreShoot",
					"User on tapping on search text field to enter record other options are displayed");
		} else {
			logger.error("User on tapping on search text field to enter record other options are NOT displayed");
			extent.extentLoggerFail("AddSoundPreShoot",
					"User on tapping on search text field to enter record other options are NOT displayed");
		}

		// TC_Mobile_003
		extent.HeaderChildNode("Check if user is able to search and add music and then verify music is displayed");
		extent.extentLogger("", "TC_Mobile_003");
		System.out.println("TC_Mobile_003");
		verifyElementPresentAndClick(HipiAddMusicPage.objFirstSearchResult, "First search result");
		String string = findElement(HipiAddMusicPage.objMusicName).getText();
		System.out.println(string);
		click(HipiAddMusicPage.objMusicName, "Music Name");
		verifyElementPresentAndClick(HipiAddMusicPage.objSelectMusicBtn, "Music Select Icon (Tick mark)");
		waitTime(2000);
		verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Selected Music in Recording Screen");
		String string2 = findElement(HipiAddMusicPage.objSelectedMusicInRecordingScreen).getText();
		System.out.println(string2);
		if (string.equalsIgnoreCase(string2)) {
			logger.info("User is able to search specific music and able to select it");
			extent.extentLoggerPass("AddSoundPreShoot", "User is able to search specific music and able to select it");
		} else {
			logger.error("User is Unable to search specific music and Unable to select it");
			extent.extentLoggerFail("AddSoundPreShoot",
					"User is Unable to search specific music and Unable to select it");
		}

		// TC_Mobile_006
		extent.HeaderChildNode("Check user is able to add a music");
		extent.extentLogger("", "TC_Mobile_006");
		System.out.println("TC_Mobile_006");
		verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Selected Music in Recording Screen");
		String string3 = findElement(HipiAddMusicPage.objSelectedMusicInRecordingScreen).getText();
		System.out.println(string3);
		if (string.equalsIgnoreCase(string3)) {
			logger.info("User is able to add a music");
			extent.extentLoggerPass("AddSoundPreShoot", "User is able to add a music");
		} else {
			logger.error("User is Unable to add a music");
			extent.extentLoggerFail("AddSoundPreShoot", "User is Unable to add a music");
		}
		Back(2);
		waitTime(2000);

		// TC_Mobile_005
		extent.HeaderChildNode("Check user is able to preview a music and then pause");
		extent.extentLogger("", "TC_Mobile_005");
		System.out.println("TC_Mobile_005");
		verifyElementPresentAndClick(AMDHipi.objHipiIcon, "hipi icon");
		verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
		verifyElementPresentAndClick(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
		verifyElementPresentAndClick(HipiAddMusicPage.objEditsearch, "Edit Search bar");
		hideKeyboard();
		type(HipiAddMusicPage.objEditsearch, "Gattimela", "Search Field");
		verifyElementPresentAndClick(HipiAddMusicPage.objFirstSearchResult, "First search result");
		click(HipiAddMusicPage.objMusicName, "Music Name");
		Boolean value4 = verifyElementExist(HipiAddMusicPage.objPreviewMusic, "Preview Music");
		if (value4 == true) {
			logger.info("User is able to Preview a music");
			extent.extentLoggerPass("AddSoundPreShoot", "User is able to Preview a music");
		} else {
			logger.error("User is Unable to Preview a music");
			extent.extentLoggerFail("AddSoundPreShoot", "User is Unable to Preview a music");
		}
		verifyElementPresentAndClick(HipiAddMusicPage.objSelectMusicPauseButton, "Pause button");
		Boolean value5 = verifyElementExist(HipiAddMusicPage.objSelectMusicPauseButton, "Pause button");
		if (value5 == true) {
			logger.info("User is able to Pause a music");
			extent.extentLoggerPass("AddSoundPreShoot", "User is able to Pause a music");
		} else {
			logger.error("User is Unable to Pause a music");
			extent.extentLoggerFail("AddSoundPreShoot", "User is Unable to Pause a music");
		}

		// TC_Mobile_007
		extent.HeaderChildNode("Check if user selected sound is played while recording");
		extent.extentLogger("", "TC_Mobile_007");
		System.out.println("TC_Mobile_007");
		click(HipiAddMusicPage.objSelectMusicPauseButton, "Pause button");
		Boolean value6 = verifyElementExist(HipiAddMusicPage.objSelectMusicPauseButton, "Pause button");
		if (value6 == true) {
			logger.info("User is able to Play the selected music");
			extent.extentLoggerPass("AddSoundPreShoot", "User is able to Play the selected music");
		} else {
			logger.error("User is Unable to Play the selected music");
			extent.extentLoggerFail("AddSoundPreShoot", "User is Unable to Play the selected music");
		}

		// TC_Mobile_008
		extent.HeaderChildNode("Check if user selected sound can be remove till the time he has not recorded anything");
		extent.extentLogger("", "TC_Mobile_008");
		System.out.println("TC_Mobile_008");
		click(HipiAddMusicPage.objSelectMusicBtn, "Music Select Icon (Tick mark)");
		verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Selected Music in Recording Screen");
		verifyElementPresentAndClick(HipiAddMusicPage.objMusicremoveIconInrecordingScreen, "Music Remove (Cross) Icon");
		if (!verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen,
				"Selected Music in Recording Screen")) {
			logger.info("User is able to Remove the selected music till the time user has not recorded anything");
			extent.extentLoggerPass("AddSoundPreShoot",
					"User is able to Remove the selected music till the time user has not recorded anything");
		} else {
			logger.error("User is Unable to Remove the selected music till the time user has not recorded anything");
			extent.extentLoggerFail("AddSoundPreShoot",
					"User is Unable to Remove the selected music till the time user has not recorded anything");
		}

		// TC_Mobile_009
		extent.HeaderChildNode("Check if user is prompted with message when user replace already existing music");
		extent.extentLogger("", "TC_Mobile_009");
		System.out.println("TC_Mobile_009");
		click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
		click(HipiAddMusicPage.objEditsearch, "Edit Search bar");
		hideKeyboard();
		type(HipiAddMusicPage.objEditsearch, "Gattimela", "Search Field");
		click(HipiAddMusicPage.objFirstSearchResult, "First search result");
		click(HipiAddMusicPage.objMusicName, "Music Name");
		click(HipiAddMusicPage.objSelectMusicBtn, "Music Select Icon (Tick mark)");
		waitTime(2000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record video button");
		waitTime(15000);
		verifyElementPresentAndClick(HipiCreateVideoPage.objAddMusicPostRecording, "Add Music in video edit screen");
		waitTime(4000);
		click(HipiAddMusicPage.objMusicListsinAddMusicScreen, "Music list");
		click(HipiAddMusicPage.objSelectMusicBtn, "Music Select Icon (Tick mark)");
		Boolean value7 = verifyElementExist(HipiAddMusicPage.objReplaceMusicPromptMsg, "Replace Music popup");
		if (value7 == true) {
			logger.info("User is prompted with message when user replace already existing music");
			extent.extentLoggerPass("AddSoundPreShoot",
					"User is prompted with message when user replace already existing music");
		} else {
			logger.error("User is NOT prompted with message when user replace already existing music");
			extent.extentLoggerFail("AddSoundPreShoot",
					"User is NOT prompted with message when user replace already existing music");
		}
		click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup, "Yes button");

		// TC_Mobile_010
		extent.HeaderChildNode("User is able to remove sound successfully from video, from edit screen");
		extent.extentLogger("", "TC_Mobile_010");
		System.out.println("TC_Mobile_010");
		verifyElementPresentAndClick(HipiAddMusicPage.objMusicremoveIconInrecordingScreen,
				"Music Remove (Cross) Icon in Video edit Screen");
		if (!verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen,
				"Selected Music in Video edit Screen")) {
			logger.info("User is able to Remove sound successfully from video edit screen");
			extent.extentLoggerPass("AddSoundPreShoot",
					"User is able to Remove sound successfully from video edit screen");
		} else {
			logger.error("User is not able to Remove sound successfully from video edit screen");
			extent.extentLoggerFail("AddSoundPreShoot",
					"User is not able to Remove sound successfully from video edit screen");
		}
		}
	}


	
	
	public void BeforeShootingMethod2(String userType) throws Exception {
		if (!userType.equals("Guest")) {
		  extent.HeaderChildNode("AddSoundPreShoot2");
		  
			//TC_Mobile_013
			extent.HeaderChildNode("Check for searched record, user is able to see Carousel just below the search bar");
			extent.extentLogger("", "TC_Mobile_013");System.out.println("TC_Mobile_013");
			verifyElementPresentAndClick(AMDHipi.objHipiIcon, "hipi icon");
			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
			
			click(HipiAddMusicPage.objAllowToAddMusic,"Allow button");
			click(HipiAddMusicPage.objAllowToAddMusic,"Allow button");
			click(HipiAddMusicPage.objAllowToAddMusic,"Allow button");
			waitTime(6000);
			click(HipiAddMusicPage.objOkBtnInAddsoundPermissionPopup,"Ok button");
			waitTime(6000);
			
			
			verifyElementPresentAndClick(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
			List<WebElement> cards = getDriver().findElements(HipiAddMusicPage.objMusicnamelistsInAddMusic);
			for (int i = 1; i <=3; i++) {
				String list = null;
				System.out.println("i : " + i);
				WebElement ele = findElement(
						By.xpath("(//*[@id='title'])[" + i + "]"));
				list = findElement(
						By.xpath("(//*[@id='title'])[" + i + "]"))
								.getText();
				System.out.println(list);
				logger.info(list);		
						}
			logger.info("User is able to see Carousel just below the search bar ");
			extent.extentLoggerPass("AddSoundPreShoot", "User is able to see Carousel just below the search bar");
			Back(2);
			
			
			//TC_Mobile_022
			extent.HeaderChildNode("Check if user is able to add a music");
			extent.extentLogger("", "TC_Mobile_022");System.out.println("TC_Mobile_022");
			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			verifyElementPresentAndClick(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
			verifyElementPresent(HipiAddMusicPage.objTrendingRailInAddMusic,"Trending rail in Add Music screen");
			verifyElementPresentAndClick(HipiAddMusicPage.objFirstMusicFromAddMusicPage,"Music in Add music screen");
			verifyElementExist(HipiAddMusicPage.objMusicTrimPopup, "Music Trim pop up");
			click(HipiAddMusicPage.objSelectMusicBtn,"Select music button(Tick icon)");
			Boolean value12 = verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Recording Screen with selected Music on Top");
			if(value12 == true) {
				logger.info("User is able to add a music");
				extent.extentLoggerPass("AddSoundPreShoot", "User is able to add a music");
			}else {
				logger.error("User is Unable to add a music");
				extent.extentLoggerFail("AddSoundPreShoot", "User is Unable to add a music");
			}
			//TC_Mobile_023
			extent.HeaderChildNode("Check if only single audio can be selected while adding a music");
			extent.extentLogger("", "TC_Mobile_023");System.out.println("TC_Mobile_023");
			//verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Recording Screen with selected Music on Top");
			if(verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Recording Screen with selected Music on Top")) {
				logger.info("Only single audio is selected while adding a music");
				extent.extentLoggerPass("AddSoundPreShoot", "Only single audio is selected while adding a music");
			}else {
				logger.error("single audio is not selected while adding a music");
				extent.extentLoggerFail("AddSoundPreShoot", "single audio is not selected while adding a music");
			}
			Back(1);
			
			
			//TC_Mobile_026
			extent.HeaderChildNode("Check if user is able to view rails and segments");
			extent.extentLogger("", "TC_Mobile_026");System.out.println("TC_Mobile_026");
			waitTime(6000);
			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			verifyElementPresentAndClick(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
			verifyElementPresent(HipiAddMusicPage.objTrendingRailInAddMusic,"Trending rail in Add Music screen");
			List<WebElement> rails = getDriver().findElements(HipiAddMusicPage.objMusicRailsTitle);
			System.out.println(rails.size());			
			for (int i = 1; i <= rails.size(); i++) {
				String railName = null;
				System.out.println("i : " + i);
				WebElement ele = findElement(
						By.xpath("(//*[@id='title'])[" + i + "]"));
				railName = findElement(
						By.xpath("(//*[@id='title'])[" + i + "]"))
								.getText();
				System.out.println(railName);
				logger.info(railName);
			}
			Swipe("UP", 2);
			
			List<WebElement> rail = getDriver().findElements(HipiAddMusicPage.objMusicRailsTitle);
			System.out.println(rail.size());			
			for (int i = 1; i <= rail.size(); i++) {
				String railname = null;
				System.out.println("i : " + i);
				WebElement elem = findElement(
						By.xpath("(//*[@id='title'])[" + i + "]"));
				railname = findElement(
						By.xpath("(//*[@id='title'])[" + i + "]"))
								.getText();
				System.out.println(railname);
				logger.info(railname);
			}
					
			logger.info("User is able to view rails and segments");
			extent.extentLoggerPass("AddSoundPreShoot", "User is able to view rails and segments");
			
			Back(3);
			
		//TC_Mobile_28
			extent.HeaderChildNode("Check if sound duration is greater than the selected Video duration, the user will be redirected to the Trimming Screen and trim icon is enabled");
			extent.extentLogger("", "TC_Mobile_028");System.out.println("TC_Mobile_028");
			click(AMDHipi.objHipiIcon, "hipi icon");
			click(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
		    click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
		    click(HipiAddMusicPage.objEditsearch, "Edit Search bar");
			hideKeyboard();
			type(HipiAddMusicPage.objEditsearch, "Naino Tale", "Search Field");
			click(HipiAddMusicPage.objFirstSearchResult,"First search result");
			verifyElementExist(HipiAddMusicPage.ObjMusicTime ,"Music Time Duration");
			
		   String time = findElement(HipiAddMusicPage.ObjMusicTime).getText();
		   System.out.println("Music Time Duration " + time);
		   logger.info("Music Time Duration " + time);
		
			click(HipiAddMusicPage.objMusicName,"Music Name");
			verifyElementExist(HipiAddMusicPage.objMusicTrimPopup, "Music Trim pop up");
			click(HipiAddMusicPage.objSelectMusicBtn,"Select music button(Tick icon)");
					
			String VideoDuration = findElement(HipiAddMusicPage.obj15sVideoDuration).getText();
			System.out.println("Video time Duration " + VideoDuration);
			logger.info("Video Time Duration " + VideoDuration);
			
			click(HipiCreateVideoPage.objrecordbtn, "Video create Icon");
			waitTime(15000);
			verifyElementExist(HipiAddMusicPage.objTrimIconInVideoEditScreen, "Trim toggle in video edit screen");
			boolean propertyvalue= getDriver().findElement(HipiAddMusicPage.objTrimIconInVideoEditScreen).isEnabled();
			System.out.println(propertyvalue);
			if(propertyvalue == true) {
				logger.info("Trim icon is enabled when Sound duration is greater than the selected Video duration");
				extent.extentLoggerPass("AddSoundPreShoot", "Trim icon is enabled when Sound duration is greater than the selected Video duration");
			}else {
				logger.error("Trim icon is NOT enabled when Sound duration is greater than the selected Video duration");
				extent.extentLoggerFail("AddSoundPreShoot", "Trim icon is NOT enabled when Sound duration is greater than the selected Video duration");
			}
			
			click(HipiAddMusicPage.objTrimIconInVideoEditScreen, "Trim button in video edit screen");
			
			boolean value17 = verifyElementExist(HipiAddMusicPage.objTrimPopupTitle, "Music Trim pop up");
			if(value17 == true) {
				logger.info("User is redirected to the Trimming Screen when Sound duration is greater than the selected Video duration ");
				extent.extentLoggerPass("AddSoundPreShoot", "User is redirected to the Trimming Screen when Sound duration is greater than the selected Video duration");
			}else {
				logger.error("User fails to navigate to the Trimming Screen when Sound duration is greater than the selected Video duration");
				extent.extentLoggerFail("AddSoundPreShoot", "User is fails to navigate to the Trimming Screen when Sound duration is greater than the selected Video duration");
			}
		click(HipiAddMusicPage.objTrimclosebtn,"Trim close button");
		click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
		Back(1);
		click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
		Back(1);
		click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
	
		
		//TC_Mobile_29
		extent.HeaderChildNode("Check if user is able to trim sound from trimming screen and able to apply it on a video");
		extent.extentLogger("", "TC_Mobile_029");System.out.println("TC_Mobile_029");
		click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
	    click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
	    click(HipiAddMusicPage.objFirstMusicFromAddMusicPage,"Music");
	    verifyElementExist(HipiAddMusicPage.objMusicTrimPopup, "Trim pop up");
	    WebElement element = getDriver().findElement(HipiAddMusicPage.objMusicTrimRightHandle);
	    String xDuration = getAttributValue("x", HipiAddMusicPage.objMusicTrimRightHandle);
	    System.out.println(xDuration);
	    int endX = Integer.parseInt(xDuration) - 50;
	    SwipeAnElement(element, endX, 0);
	    Dimension size1= getDriver().findElement(HipiAddMusicPage.objMusicTrimRightHandle).getSize();
	    System.out.println(size1);
	    String xDuration2 = getAttributValue("x", HipiAddMusicPage.objMusicTrimRightHandle);
	    System.out.println(xDuration2);
	    if(xDuration.equals(xDuration2) == false){
	    	logger.info("User is able to trim sound from trimming screen");
			extent.extentLoggerPass("AddSoundPreShoot", "User is able to trim sound from trimming screen");
	    }else {
	    	logger.error("User is NOT able to trim sound from trimming screen");
			extent.extentLoggerFail("AddSoundPreShoot", "User is NOT able to trim sound from trimming screen");
	    }
	     click(HipiAddMusicPage.objSelectMusicBtn,"Select music icon");
	     Boolean value16 = verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Recording Screen with selected Music on Top");
			if(value16 == true) {
				logger.info("User is be able to trim sound from trimming screen and able to apply it on video");
				extent.extentLoggerPass("AddSoundPreShoot", "User is be able to trim sound from trimming screen and able to apply it on video");
			}else {
				logger.error("User is be unable to trim sound from trimming screen and unable to apply it on video");
				extent.extentLoggerFail("AddSoundPreShoot", "User is be unable to trim sound from trimming screen and unable to apply it on video");
			}
	    
			Back(1);
			
			//TC_Mobile_30
			extent.HeaderChildNode("Check if user is able to trim various sound");
			extent.extentLogger("", "TC_Mobile_030");System.out.println("TC_Mobile_030");
			click(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
		    click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
		    click(HipiAddMusicPage.objfifthmusicinAddmusic,"Music");
		    verifyElementExist(HipiAddMusicPage.objMusicTrimPopup, "Trim pop up");
		    
		    String EndTime = getDriver().findElement(HipiAddMusicPage.objMusicEndTime).getText();
		    System.out.println(EndTime);
		    
		    WebElement element1 = getDriver().findElement(HipiAddMusicPage.objMusicTrimRightHandle);
		    String x = getAttributValue("x", HipiAddMusicPage.objMusicTrimRightHandle);
		    int EndX = Integer.parseInt(x) - 30;
		    SwipeAnElement(element1, EndX, 0);
		   		    
		    String EndTimeAfterTrim = getDriver().findElement(HipiAddMusicPage.objMusicEndTime).getText();
		    System.out.println(EndTimeAfterTrim);
		   
		    if(EndTime.equals(EndTimeAfterTrim) == false){
		    	logger.info("User is able to trim various sound");
				extent.extentLoggerPass("AddSoundPreShoot", "User is able to trim various sound");
		    }else {
		    	logger.error("User is Unable to trim various sound");
				extent.extentLoggerFail("AddSoundPreShoot", "User is Unable to trim various sound");
		    }
		    Back(1);
		    
		  //TC_Mobile_33
			extent.HeaderChildNode("Check if user is able to place the sound by tapping the audio clip over the video");
			extent.extentLogger("", "TC_Mobile_033");System.out.println("TC_Mobile_033");
			click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
			 click(HipiAddMusicPage.objEditsearch, "Edit Search bar");
				hideKeyboard();
				type(HipiAddMusicPage.objEditsearch, "Udtha Punjab", "Search Field");
				click(HipiAddMusicPage.objFirstSearchResult,"First search result");
				String music1 = getDriver().findElement(HipiAddMusicPage.objMusicName).getText();
				System.out.println(music1);
				click(HipiAddMusicPage.objMusicName,"Music Name");
				verifyElementExist(HipiAddMusicPage.objMusicTrimPopup, "Music Trim pop up");
				click(HipiAddMusicPage.objSelectMusicBtn,"Select music button(Tick icon)");
				click(HipiCreateVideoPage.objrecordbtn, "Video create Icon");
				waitTime(15000);				
				verifyElementPresentAndClick(HipiAddMusicPage.objSelectedMusicInRecordingScreen,"Added Music in video edit screen");
				waitTime(4000);
				click(HipiAddMusicPage.objMusicListsinAddMusicScreen,"Music list");
				click(HipiAddMusicPage.objSelectMusicBtn,"Music Select Icon (Tick mark)");
				verifyElementExist(HipiAddMusicPage.objReplaceMusicPromptMsg,"Replace Music popup");
				click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Yes button");
				String music2 = getDriver().findElement(HipiAddMusicPage.objSelectedMusicInRecordingScreen).getText();
				System.out.println(music2);
				if(music1.equals(music2) == false) {
					logger.info("User is able to place the sound by tapping the audio clip over the video");
					extent.extentLoggerPass("AddSoundPreShoot", "User is able to place the sound by tapping the audio clip over the video");
				}else {
					logger.error("User is unable to place the sound by tapping the audio clip over the video");
					extent.extentLoggerFail("AddSoundPreShoot", "User is unable to place the sound by tapping the audio clip over the video");
				}
				click(HipiAddMusicPage.objBackButtonInVideoEditScreen,"Close button");
				click(HipiAddMusicPage.objOkBtnInAddsoundPermissionPopup,"Continue button");
				Back(1);
				click(HipiAddMusicPage.objOkBtnInAddsoundPermissionPopup,"Yes button");
				
			 //TC_Mobile_34
				extent.HeaderChildNode("Check if user is able create a video with existing selected music");
				extent.extentLogger("", "TC_Mobile_034");System.out.println("TC_Mobile_034");
				verifyElementExist(HipiFeedPage.objsoundused, "Music used in a video");
				String musicused = findElement(HipiFeedPage.objsoundused).getText();
				System.out.println("Music used : " + musicused);
				logger.info("Music used : " + musicused);
				click(HipiFeedPage.objsoundused, "Music used in a video");
				verifyElementExist(HipiFeedPage.objmusictitle,"Music title in Sound detail screen");
				verifyElementPresentAndClick(HipiFeedPage.objUseThisSoundCTA,"Use this Sound CTA"); 
				click(HipiAddMusicPage.objOkBtnInAddsoundPermissionPopup,"Ok button");
				if(verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "selected Music from existing video")) {
					logger.info("User is directed to video creation screen with the sound selected");
					extent.extentLogger("AddSoundPreShoot", "User is directed to video creation screen with the sound selected");
				}else {
					logger.info("User is not directed to video creation screen with the sound selected");
					extent.extentLogger("AddSoundPreShoot", "User is not directed to video creation screen with the sound selected");
				}
				click(HipiCreateVideoPage.objrecordbtn, "Video create Icon");
				waitTime(19000);
				verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Music used ");
				String existingmusicused = findElement(HipiAddMusicPage.objSelectedMusicInRecordingScreen).getText();
				System.out.println("Music  : " + existingmusicused);
				extent.extentLogger("", "Music  : " + existingmusicused);
				logger.info("Music  : " + existingmusicused);
				if(musicused.contains(existingmusicused)) {
					logger.info("User is able to  create a video with existing selected music");
					extent.extentLoggerPass("AddSoundPreShoot", "User is able to  create a video with existing selected music");
				}else {
					logger.error("User is not able to  create a video with existing selected music");
					extent.extentLoggerFail("AddSoundPreShoot", "User is not able to  create a video with existing selected music");
				}
				
			//TC_Mobile_35
				extent.HeaderChildNode("Check if user is able to view video newly created by music");
				extent.extentLogger("", "TC_Mobile_035");System.out.println("TC_Mobile_035");
				verifyElementExist(HipiCreateVideoPage.objpost,"Finsih video icon");
				click(HipiCreateVideoPage.objpost,"Finsih video icon");
				waitTime(5000);
				hideKeyboard();
				
				waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
				type(HipiCreateVideoPage.objadddescription,"Desc"+GeneratingRandomString(7),"Description added");
				Thread.sleep(5000);
				hideKeyboard();
				waitTime(3000);
				verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
				verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
				verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
						" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
				verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "posthipi");// saveasdraft
				waitTime(4000);
				verifyIsElementDisplayed(HipiCreateVideoPage.objVideoUploadPopup, "Video Upload Popup");
				click(HipiCreateVideoPage.objGoToFeedButton, "Go To Feed Button");
				waitTime(15000);
				
				waitTime(10000);
				verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
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
						waitTime(8000);
						break;
					}
				}
				
				extent.extentLogger("", "Music  : " + existingmusicused);
				if(verifyIsElementDisplayed(HipiCreateVideoPage.objMusicUsedInVideo(existingmusicused), "Music used in video")) {
					logger.info("User is be able to view video newly created by music");
					extent.extentLoggerPass("AddSoundPreShoot", "User is be able to view video newly created by music");
				}else {
					logger.error("User is be not able to view video newly created by music");
					extent.extentLoggerFail("AddSoundPreShoot", "User is be not able to view video newly created by music");
						}
				BackToFeedScreen();
				
				//TC_Mobile_20
				extent.HeaderChildNode("Check user is able to view existing list of favourites");
				extent.extentLogger("", "TC_Mobile_020");System.out.println("TC_Mobile_020");
				click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
				click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
				String sound = findElement(HipiAddMusicPage.objFirstMusicInAddMusicScreen).getText();
				
				String soundFavourited = getAttributValue("checked", HipiCreateVideoPage.objSoundFavouritedOrNot(sound));
				
				if(soundFavourited.contains("true")){
					extent.extentLogger("", "Sound is already favourited");
				}else{
					verifyElementPresentAndClick(HipiCreateVideoPage.objAddToFvrts,"Add music to favourite icon");
					verifyElementExist(HipiCreateVideoPage.objAddedTofvrtPopup, "Added to favorites pop up");
				}
				
				
				Back(2);
				waitTime(6000);
				verifyElementPresentAndClick(HipiCreateVideoPage.objMeIcon, "User profile");
				verifyElementPresentAndClick(HipiMePage.objfavouritetab,"Favorites tab");
				verifyElementPresentAndClick(HipiMePage.objsounds,"Sounds tab");
				waitTime(5000);
				if(verifyElementExist(HipiMePage.objFavouritedSound(sound),"Added Favourite music")) {
					logger.info("User is able to view existing list of favourites");
					extent.extentLoggerPass("AddSoundPreShoot", "User is able to view existing list of favourites");
				}else {
					logger.error("User is not able to view existing list of favourites");
					extent.extentLoggerFail("AddSoundPreShoot", "User is not able to view existing list of favourites");
						}	
				
				Back(1);	
				
				
				//TC_Mobile_21
				extent.HeaderChildNode("Check if user is able to preview a music and then pause");
				extent.extentLogger("", "TC_Mobile_021");System.out.println("TC_Mobile_021");
				click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
				click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
				verifyElementExist(HipiAddMusicPage.objPlayIconOnMusic,"Play Icon");
				click(HipiAddMusicPage.objPlayIconOnMusic,"Play Icon");
				verifyElementExist(HipiAddMusicPage.objPlayIconOnMusic,"Pause Icon");
				click(HipiAddMusicPage.objPlayIconOnMusic,"Pause Icon");
				Boolean b = verifyElementExist(HipiAddMusicPage.objPlayIconOnMusic,"Play Icon");
				if(b) {
					logger.info("User is able to preview a music and then pause");
					extent.extentLoggerPass("AddSoundPreShoot", "User is able to preview a music and then pause");
				}else {
					logger.error("User is Unable to preview a music and then pause");
					extent.extentLoggerFail("AddSoundPreShoot", "User is Unable to preview a music and then pause");
				}
				
				Back(2);
		}	
		}				
	
	
	
	
	//---------------------------------------------------------------------------------------------------------------------
	
	//--------------------------------------------------HiPiViewerProfile-------------------------------------------------------------------
	
	
	
	public void ValidatingHiPiViewerProfile(String userType) throws Exception{
      	if(userType.equalsIgnoreCase("NonSubscribedUser")){
      		ValidateHipiPreferenceDefaultData(userType);
      		ValidateProfileAsPublicAvailableInSearchRecord(userType);
      		ValidateVisibiltyToFolloweronly(userType);
      		ValidateVisibiltyChangedToPublicFromFolloweronly(userType);
      	}else{
      		
      	}

	}
	
	

	public void ValidateHipiPreferenceDefaultData(String userType) throws Exception
	{
		extent.HeaderChildNode("Check if by default Visibilty is set to public");
		System.out.println("TC_Mobile_001");
		extent.extentLogger("", "TC_Mobile_001");
		Thread.sleep(5000);
		click(AMDHipi.objHipiIcon, "Hipi icon");
		Thread.sleep(5000);
		click(AMDOnboardingScreen.objForMeButton, "Me");
		Thread.sleep(5000);
		click(HipiMePage.objsettingsbutton, "Settings button");
		Thread.sleep(5000);
		click(HipiMePage.objpreferences, "Preferences button");
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objpublicenabled, "Public visibility"))
		{
			logger.info("Default visibility is public");
			extent.extentLoggerPass("Profile page:","Default visibility is public");
		}
		else
		{
			logger.info("Default visibility is not public");
			extent.extentLoggerFail("Profile page:","Default visibility is not public");
		}
	}
	public void ValidateProfileAsPublicAvailableInSearchRecord(String userType) throws Exception
	{
		extent.HeaderChildNode("Verify if any user is able to view the profile Set Visibity is set to public");
		System.out.println("TC_Mobile_002");
		extent.extentLogger("", "TC_Mobile_002");
		Thread.sleep(5000);
		Back(1);
		Thread.sleep(5000);
		Back(1);
		Thread.sleep(5000);
		String Profilewhichispublic=findElement(HipiMePage.objprofilewhichispublic).getText();
		//System.out.println("Profile:"+Profilewhichispublic);
		extent.extentLogger("Profile:",Profilewhichispublic);
		Thread.sleep(5000);
		Back(1);
		Thread.sleep(5000);
		click(HipiMePage.objdiscover, "Discover button");
		Thread.sleep(5000);
		click(HipiMePage.objsearchbtn, "Search button");
		Thread.sleep(5000);
		type(HipiMePage.objsearch,Profilewhichispublic,"Profile");
		String Profileavailable=findElement(HipiMePage.objprofilesetaspublicrecord).getText();
		//System.out.println("Profile:"+Profileavailable);
		Thread.sleep(5000);
		hideKeyboard();
		if(Profilewhichispublic.equals(Profileavailable))
		{
			logger.info("Able to view the profile Set Visibity is set to public");
			extent.extentLoggerPass("Profile page:","Able to view the profile Set Visibity is set to public");
		}
		else
		{
			logger.info("Unable to view the profile Set Visibity is set to public");
			extent.extentLoggerFail("Profile page:","Unable to view the profile Set Visibity is set to public");
		}
	}
	public void ValidateVisibiltyToFolloweronly(String userType) throws Exception
	{
		extent.HeaderChildNode("Check if user is able to Set Visibility of his profile to privateFollowers Only");
		System.out.println("TC_Mobile_003");
		extent.extentLogger("", "TC_Mobile_003");
		Thread.sleep(5000);
		Back(1);
		Thread.sleep(5000);
		Back(1);
		Thread.sleep(5000);
		click(AMDOnboardingScreen.objForMeButton, "Me");
		Thread.sleep(5000);
		click(HipiMePage.objsettingsbutton, "Settings button");
		Thread.sleep(5000);
		click(HipiMePage.objpreferences, "Preferences button");
		Thread.sleep(5000);
		click(HipiMePage.objvisibilitymode, "Visibility button");
		Thread.sleep(5000);
		click(HipiMePage.objfolloweronlybtn, "Followeronly button");
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objfolloweronlyenabled, "Followeronly visibility"))
		{
			logger.info("Followeronly visibility enabled");
			extent.extentLoggerPass("Profile page:","Followeronly visibility enabled");
		}
		else
		{
			logger.info("Followeronly visibility unavailable");
			extent.extentLoggerFail("Profile page:","Followeronly visibility unavailable");
		}
	}
	public void ValidateVisibiltyChangedToPublicFromFolloweronly(String userType) throws Exception
	{
		extent.HeaderChildNode("Check if user is able to set back profile to public from Followers Only");
		System.out.println("TC_Mobile_004");
		extent.extentLogger("", "TC_Mobile_004");
		Thread.sleep(5000);
		click(HipiMePage.objvisibilitymode, "Visibility button");
		Thread.sleep(5000);
		click(HipiMePage.objpublicbtn, "Public button");
		Thread.sleep(5000);
		if(verifyElementExist(HipiMePage.objpublicenabled, "Public visibility"))
		{
			logger.info("Public visibility enabled");
			extent.extentLoggerPass("Profile page:","Public visibility enabled");
		}
		else
		{
			logger.info("Public visibility unavailable");
			extent.extentLoggerFail("Profile page:","Public visibility unavailable");
		}
	}
	
	

	
	
	
	
	



	//------------------------------------------------------------------------------------------------------------------
	
	
	
	//-------------------------Player View -More (Guest User)--------------------------------------
	
	
	public void playerViewMoreGuest(String userType) throws InterruptedException, Exception {
		
		
		if(userType.equalsIgnoreCase("Guest")){
			shareVideoIconWithoutLoggedInUser(userType);
			reportVideoActionByTappingOnItWithoutLoggedInUser(userType);
		}else {
			
		}
	}
	
		public void shareVideoIconWithoutLoggedInUser(String userType) throws InterruptedException, Exception {
			
			extent.HeaderChildNode("Player Preview Check if Share screen is displayed when tapped on Share video Icon without logged in user");
	        System.out.println("TC_Mobile_001");
	        extent.extentLogger("", "TC_Mobile_001");
			
	        if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
	    		click(AMDOnboardingScreen.objHipiButton, "HiPi");
	    		Thread.sleep(6000);
	
	    	} else {
	
	    	}
	        verifyElementPresentAndClick(HipiHomePage.objShareIcon, "Share Icon");
	        waitTime(3000);
	        if (verifyElementExist(AMDHipi.objRegisterforVibe, "Register PopUP")) {
				logger.info("Register PopUP:" + "RegisterPop is displayed when user clicks on Share Button");
				extent.extentLoggerPass("Register PopUP:", "RegisterPop is displayed when user clicks on Share Button");
				
			}else {
				logger.info("Register PopUP:" + "RegisterPop is not displayed when user clicks on Share Button");
				extent.extentLoggerFail("Register PopUP:", "RegisterPop is not displayed when user clicks on Share Button");
					
			}
			if (verifyElementExist(AMDHipi.objRegisterbtn, "Register Button")) {
				logger.info("Register Button:" + "Register Button is displayed when user clicks on Share Button");
				extent.extentLoggerPass("Register Button:", "Register Button is displayed when user clicks on Share Button");
				
			}else {
				logger.info("Register Button:" + "Register Button is not displayed when user clicks on Share button");
				extent.extentLoggerFail("Register Button:", "Register Button is not displayed when user clicks on Share button");
					
			}
			if (verifyElementExist(AMDHipi.objLoginbtn, "Login Button")) {
				logger.info("Login Button:" + "Login Button is displayed when user clicks on Share Button");
				extent.extentLoggerPass("Login Button:", "Login Button is displayed when user clicks on Share Button");
				
			}else {
				logger.info("Login Button:" + "LoginButton is not displayed when user clicks on Share button");
				extent.extentLoggerFail("Login Button:", "LoginButton is not displayed when user clicks on Share button");
					
			}
			
			
		}
		public void reportVideoActionByTappingOnItWithoutLoggedInUser(String userType) throws Exception {
			
			extent.HeaderChildNode("Player Preview Check is user is able to perform Report Video action by tapping on it without logged in user");
	        System.out.println("TC_Mobile_003");
	        extent.extentLogger("", "TC_Mobile_003");
			Back(1);
			longPress(HipiHomePage.objPlayerScreen);
			waitTime(6000);
			click(HipiHomePage.objReportVideo, "Report Video");
			waitTime(3000);
			 if (verifyElementExist(AMDHipi.objRegisterforVibe, "Register PopUP")) {
					logger.info("Register PopUP:" + "RegisterPop is displayed when user clicks on Repore Video Button");
					extent.extentLoggerPass("Register PopUP:", "RegisterPop is displayed when user clicks on Repore Video Button");
					
				}else {
					logger.info("Register PopUP:" + "RegisterPop is not displayed when user clicks on Repore Video Button");
					extent.extentLoggerFail("Register PopUP:", "RegisterPop is not displayed when user clicks on Repore Video Button");
						
				}
				if (verifyElementExist(AMDHipi.objRegisterbtn, "Register Button")) {
					logger.info("Register Button:" + "Register Button is displayed when user clicks on Repore Video Button");
					extent.extentLoggerPass("Register Button:", "Register Button is displayed when user clicks on Repore Video Button");
					
				}else {
					logger.info("Register Button:" + "Register Button is not displayed when user clicks on Repore Video button");
					extent.extentLoggerFail("Register Button:", "Register Button is not displayed when user clicks on Repore Video button");
						
				}
				if (verifyElementExist(AMDHipi.objLoginbtn, "Login Button")) {
					logger.info("Login Button:" + "Login Button is displayed when user clicks on Repore Video Button");
					extent.extentLoggerPass("Login Button:", "Login Button is displayed when user clicks on Repore Video Button");
					
				}else {
					logger.info("Login Button:" + "LoginButton is not displayed when user clicks on Repore Video button");
					extent.extentLoggerFail("Login Button:", "LoginButton is not displayed when user clicks on Repore Video button");
						
				}
				
		}
		
		

	//--------------------------	Player View -More (Non Subscribed User)-----------------
	
		public void playerViewMoreNonSubscribedUser(String userType) throws Exception {
			
			if (userType.equalsIgnoreCase("NonSubscribedUser")) {
				shareVideoIconWithLoggedInUser(userType);
				reportVideoActionByTappingOnItWithLoggedInUser(userType);
			}else {
				
			}

		}
		
		
		public void shareVideoIconWithLoggedInUser(String userType) throws Exception {
			
			extent.HeaderChildNode("Player Preview Check if Share screen is displayed when tapped on Share video Icon with logged in user");
	        System.out.println("TC_Mobile_002");
	        extent.extentLogger("", "TC_Mobile_002");

	      if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
	  		click(AMDOnboardingScreen.objHipiButton, "HiPi");
	  		Thread.sleep(6000);

	  	} else {

	  	}
	        
	        verifyElementPresentAndClick(HipiHomePage.objShareIcon, "Share Icon");

			waitTime(5000);
			 if (verifyElementExist(HipiShareScreen.objShareDeailsScreen, "Share Deails Screen")) {

					logger.info("Share Deails Screen:" + "When ever click on share button share deails screen is displayed");
					extent.extentLoggerPass("Share Deails Screen:",
							"When ever click on share button share deails screen is displayed");

				} else {
					logger.info(
							"Share Deails Screen:" + "When ever click on share button share deails screen is not displayed");
					extent.extentLoggerFail("Share Deails Screen:",
							"When ever click on share button share deails screen is not displayed");
				}
			
		     waitTime(10000);
				if (verifyElementExist(HipiShareScreen.objFBOption, "FB Option")) {

					logger.info("FB Option: " + "When evre click on share button FB Option is displayed");
					extent.extentLoggerPass("FB Option: ", "When evre click on share button FB Option is displayed");
					waitTime(3000);
				} else {
					logger.info("FB Option: " + "When evre click on share button FB Option is not displayed");
					extent.extentLoggerFail("FB Option: ", "When evre click on share button FB Option is not  displayed");
				}
		}
		
		public void reportVideoActionByTappingOnItWithLoggedInUser(String userType) throws Exception {
			
			extent.HeaderChildNode("Player Preview Check is user is able to perform Report Video action by tapping on it with logged in user");
	        System.out.println("TC_Mobile_006");
	        extent.extentLogger("", "TC_Mobile_006");
	        Back(1);
	        waitTime(3000);
	        longPress(HipiHomePage.objPlayerScreen);
			waitTime(6000);
			click(HipiHomePage.objReportVideo, "Report Video");
			waitTime(3000);
		if(verifyIsElementDisplayed(HipiReportProfileScreen.objVerifylayoutofreportcontentscreen, "Report Profile Screen")){
				
				logger.info("Report Profile Screen:" + "Report Content Screen is displayed");
				extent.extentLoggerPass("Report Profile Screen:","Report Content Screen is displayed");
		}else {
			logger.info("Report Profile Screen:" + "Report Content Screen is not displayed");
			extent.extentLoggerFail("Report Profile Screen:","Report Content Screen is not displayed");
		}
		
		if(verifyIsElementDisplayed(HipiReportProfileScreen.objReportProfile, "Report Profile Screen")){
			
			logger.info("Report Profile Screen:" + "Report Content Screen is displayed");
			extent.extentLoggerPass("Report Profile Screen:","Report Content Screen is displayed");
			click(HipiReportProfileScreen.objSelectReason, "Select Reason Drpo Down");
			waitTime(3000);
//			click(HipiReportProfileScreen.objAntiSocial, "Anti Social");
//			waitTime(3000);
//			verifyIsElementDisplayed(HipiReportProfileScreen.objAntiSocial);
			click(HipiReportProfileScreen.objNudityAndSexualContent, "Nudity And Sexual Content");
			waitTime(3000);
			
			click(HipiReportProfileScreen.objSelectCategory, "Select Category Drpo Down");
			waitTime(3000);
//			click(HipiReportProfileScreen.objitscopiedcontent, "it's copied content");
//			waitTime(3000);
			click(HipiReportProfileScreen.objVideoIsSexualInNature, "Video Is Sexual In Nature");
			waitTime(3000);
			String reportprofiledescription = "Report Description";
			click(HipiReportProfileScreen.objDescription, "Description Text field");
			waitTime(3000);
			type(HipiReportProfileScreen.objDescription, reportprofiledescription, "Description Field");
			waitTime(3000);
			verifyElementPresentAndClick(HipiReportProfileScreen.objSubmitButton, "Submit Button");
			waitTime(5000);
			
			if(verifyIsElementDisplayed(HipiReportProfileScreen.objSubmitButton, "Submit Button")) {

				logger.info("Reported Profile:" + "user is not able to perform Report Video action");
				extent.extentLoggerFail("Reported Profile:","user is not able to perform Report Video action");
				
			} else {
				logger.info("Reported Profile:" + "user is able to perform Report Video action");
				extent.extentLoggerPass("Reported Profile:","user is able to perform Report Video action");
			}	

			
		} else {
			logger.info("Report Profile Screen:" + "Report Content Screen is not displayed");
			extent.extentLoggerFail("Report Profile Screen:","Report Content Screen is not displayed");
		}
//		String thankForYourReport = getText(HipiReportProfileScreen.objThankForYourReport);
//		if(verifyElementExist(HipiReportProfileScreen.objThankForYourReport, "Thank For Your Report")){
//			logger.info("Thank For Your Report" + thankForYourReport);
//			extent.extentLoggerPass("Thank For Your Report","Thank for your report. We will review it and get back to you. Message is displayed");
//		}else {
//			logger.info("Thank For Your Report" + "Thank for your report. We will review it and get back to you. Message is not displayed");
//			extent.extentLoggerPass("Thank For Your Report","Thank for your report. We will review it and get back to you. Message is not displayed");	
//			}
		}
		
		
		
		
	//------------------------------------------------------------------------------------------------------------------
		
		
		//-----------------------------------Player - Vertical Preview(Guest User)------------------------------
		
		public void hastagInTheDescriptionOnPlayedPausedVideoWithoutLoggedInUser(String userType) throws Exception {
			
			extent.HeaderChildNode("Player Preview Check if user is able to view hastag in the description on played/paused video without logged in user");
	        System.out.println("TC_Mobile_001");
	        extent.extentLogger("", "TC_Mobile_001");
	        Back(1);
		          click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
		          waitTime(5000);
		          click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
		          waitTime(5000);
	 	          String fun = "#fun";
	 	          waitTime(3000);
	 	          type(HipiDiscoverPage.objSearchButton, fun, "#Fun");
	 	        	waitTime(3000);
	 	           hideKeyboard();
	 	           waitTime(5000);
	 	        
	 	           Swipe("Up", 1);

	 	           waitTime(3000);

	 	           for(int i=1;i<=10;i++)
	 	           {
	 	        
	 	           if(verifyIsElementDisplayed(HipiDiscoverPage.objSpecificHashtagText(fun), fun)){
	 	          	 click(HipiDiscoverPage.objSpecificHashtagText(fun), fun);
	 	          	 break;
	 	           }else{
	 	          	 SwipeHashtagRail(HipiDiscoverPage.objHashtagSecondTumbnail);
	 	          	 waitTime(3000);
	 	           }
	 	           }
	 	          	
	 	          waitTime(5000);
	 	         click(HipiHashtagDetailPage.objOneofvideo, "One Of Video");
	        waitTime(5000);
	        
	        verifyIsElementDisplayed(HipiHomePage.objHashtagDescription, "Description");
	        
	        
	        boolean hashtags = getDriver().findElement(HipiHomePage.objHashtagDescription).isDisplayed();
	  	  
	  	  if (hashtags ) {
	  	  logger.info("hastag displayed "  +  hashtags );
	  	  extent.extentLogger("Hashtag", "Hashtags is displayed");
	  	  }else {
	      logger.info("hastag not displayed ");	  
	  	  extent.extentLogger("Hashtag", "Hashtags is not displayed");

	  	     }
			
		}
		
		public void  viewSoundNameBelowTheDescription(String userType) throws Exception {
			
			extent.HeaderChildNode("Player Preview Check if user is able to view Sound name below the description on played/paused video without logged in user");
	        System.out.println("TC_Mobile_003");
	        extent.extentLogger("", "TC_Mobile_003");
			
	        if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
	    		click(AMDOnboardingScreen.objHipiButton, "HiPi");
	    		Thread.sleep(6000);
	
	    	} else {
	
	    	}
	        
			String soundName = getText(HipiHomePage.objSoundName);
			if(verifyIsElementDisplayed(HipiHomePage.objSoundName, "Sound Name")){
				logger.info("Sound Name:" + soundName);
				extent.extentLoggerPass("Sound Name:","Sound Name is displayed when ever user land on hipi home screen");
			} else {
				logger.info("Sound Name:" + "Sound Name is not displayed when ever user land on hipi home screen");
				extent.extentLoggerFail("Sound Name:","Sound Name is not displayed when ever user land on hipi home screen");
			}	
			
		}
		public void viewSoundDetailScreenByTappingSound(String userType) throws Exception {
			
			extent.HeaderChildNode("Player Preview Check if user is able to view Sound detail screen by tapping sound of a video in Feed without logged in user");
	        System.out.println("TC_Mobile_005");
	        extent.extentLogger("", "TC_Mobile_005");
	        if(verifyIsElementDisplayed(HipiHomePage.objSoundName, "Sound")){
				click(HipiHomePage.objSoundName, "Sound Name");
				waitTime(4000);
				if(verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDetailScreen, "Sound Detail Screen")){
				
					logger.info("Sound Detail Screen:" + "Sound Detail Screen is displayed when ever click on Sound Name");
					extent.extentLoggerPass("Sound Detail Screen:","Sound Detail Screen is displayed when ever click on Sound Name");
				} else {
					logger.info("Sound Detail Screen:" + "Sound Detail Screen is not displayed when ever click on Sound Name");
					extent.extentLoggerFail("Sound Detail Screen:","Sound Detail Screen is not displayed when ever click on Sound Name");
				}	
	        	
	        }else{
	        	extent.extentLoggerWarning("", "Sound is not present");
	        }
			
			
			
			
		}
		
	//---------------------------Player - Vertical Preview(Non Subscribed User)--------------------
		public void hastagInTheDescriptionOnPlayedPausedVideoLoggedInUser(String userType) throws Exception {
			
		extent.HeaderChildNode("Player Preview Check if user is able to view hastag in the description on played/paused video without logged in user");
	    System.out.println("TC_Mobile_001");
	    extent.extentLogger("", "TC_Mobile_001");
	    Back(1);
	          click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
	          waitTime(5000);
	          click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
	          waitTime(5000);
		          String fun = "#fun";
		          waitTime(3000);
		          type(HipiDiscoverPage.objSearchButton, fun, "#Fun");
		         	waitTime(3000);
		            hideKeyboard();
		            waitTime(5000);
		         
		            Swipe("Up", 1);

		            waitTime(3000);

		            for(int i=1;i<=10;i++)
		            {
		         
		            if(verifyIsElementDisplayed(HipiDiscoverPage.objSpecificHashtagText(fun), fun)){
		           	 click(HipiDiscoverPage.objSpecificHashtagText(fun), fun);
		           	 break;
		            }else{
		           	 SwipeHashtagRail(HipiDiscoverPage.objHashtagSecondTumbnail);
		           	 waitTime(3000);
		            }
		            }
		           	
		          waitTime(5000);
		         click(HipiHashtagDetailPage.objOneofvideo, "One Of Video");
	    waitTime(5000);
	    verifyIsElementDisplayed(HipiHomePage.objHashtagDescription, "Description");

	    boolean hashtags = getDriver().findElement(HipiHomePage.objHashtagDescription).isDisplayed();
		  
		  if (hashtags) {
		  logger.info("hastag displayed "  +  hashtags );
		  extent.extentLogger("Hashtag", "Hashtags is displayed");
		  }else {
	  logger.info("hastag not displayed ");	  
		  extent.extentLogger("Hashtag", "Hashtags is not displayed");

		     }
		
	}
		public void viewSoundNameBelowTheDescriptionNonSub(String userType) throws Exception {
			
			extent.HeaderChildNode("Player Preview Check if user is able to view Sound name below the description on played/paused video with logged in user");
	        System.out.println("TC_Mobile_004");
	        extent.extentLogger("", "TC_Mobile_004");
			

	        if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
	    		click(AMDOnboardingScreen.objHipiButton, "HiPi");
	    		Thread.sleep(6000);

	    	} else {

	    	}
	        
	        String soundName = getText(HipiHomePage.objSoundName);
			if(verifyIsElementDisplayed(HipiHomePage.objSoundName, "Sound Name")){
				logger.info("Sound Name:" + soundName);
				extent.extentLoggerPass("Sound Name:","Sound Name is displayed when ever user land on hipi home screen");
			} else {
				logger.info("Sound Name:" + "Sound Name is not displayed when ever user land on hipi home screen");
				extent.extentLoggerFail("Sound Name:","Sound Name is not displayed when ever user land on hipi home screen");
			}	
		}
		
		
		
	public void viewSoundDetailScreenByTappingSoundNonSub(String userType) throws Exception {
			
			extent.HeaderChildNode("Player Preview Check if user is able to view Sound detail screen by tapping sound of a video in Feed without logged in user");
	        System.out.println("TC_Mobile_006");
	        extent.extentLogger("", "TC_Mobile_006");
			click(HipiHomePage.objSoundName, "Sound Name");
			waitTime(4000);
			if(verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDetailScreen, "Sound Detail Screen")){
			
				logger.info("Sound Detail Screen:" + "Sound Detail Screen is displayed when ever click on Sound Name");
				extent.extentLoggerPass("Sound Detail Screen:","Sound Detail Screen is displayed when ever click on Sound Name");
			} else {
				logger.info("Sound Detail Screen:" + "Sound Detail Screen is not displayed when ever click on Sound Name");
				extent.extentLoggerFail("Sound Detail Screen:","Sound Detail Screen is not displayed when ever click on Sound Name");
			}	
	}
		
		
		public void playerVerticalPreviewGuest(String userType) throws Exception {
			
			if(userType.equalsIgnoreCase("Guest")){
				viewSoundNameBelowTheDescription(userType);
				viewSoundDetailScreenByTappingSound(userType);
				hastagInTheDescriptionOnPlayedPausedVideoWithoutLoggedInUser(userType);
			}else {
				
			}

		}
		public void playerVerticalPreviewNonSub(String userType) throws Exception {
			if (userType.equalsIgnoreCase("NonSubscribedUser")) {
				
				viewSoundNameBelowTheDescriptionNonSub(userType);
				viewSoundDetailScreenByTappingSoundNonSub(userType);
				hastagInTheDescriptionOnPlayedPausedVideoLoggedInUser(userType);
			}

		}






//--------------------------------------------------------------------------------------------------------------------------
		
		
		
		
		//---------------------------------------HIPI MY PROFILE--------------------------------------------

		public void guestHipiMyProfile(String userType) throws Exception {
			
			if (!userType.equalsIgnoreCase("NonSubscribedUser")) {
				loginRegisterSectionAppearsAtTheBottom(userType);
				usernameFromDiscoverAndOnTapUserZee5LoginSignUpShouldBeVisible(userType);
			}else {
				
			}	
		}
		
		
		public void loginRegisterSectionAppearsAtTheBottom(String userType) throws Exception {
			
			extent.HeaderChildNode("Guest User Check if guest user on tapping Profile Icon should redirected to Zee5 SignUp/Login Screen");
			System.out.println("TC_Mobile_001");
			extent.extentLogger("", "TC_Mobile_001");
			if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
				click(AMDOnboardingScreen.objHipiButton, "HiPi");
				Thread.sleep(6000);

			} else {

			}
			click(HipiMePage.objMeicon, "Me Icon");
			waitTime(3000);
			if (verifyElementExist(AMDHipi.objRegisterforVibe, "Register PopUP")) {
				logger.info("Register PopUP:" + "RegisterPop is displayed when user clicks on ME Button");
				extent.extentLogger("Register PopUP:", "RegisterPop is displayed when user clicks on ME Button");
				
			}else {
				logger.info("Register PopUP:" + "RegisterPop is not displayed when user clicks on ME Button");
				extent.extentLoggerFail("Register PopUP:", "RegisterPop is not displayed when user clicks on ME Button");
					
			}
			if (verifyElementExist(AMDHipi.objRegisterbtn, "Register Button")) {
				logger.info("Register Button:" + "Register Button is displayed when user clicks on ME Button");
				extent.extentLogger("Register Button:", "Register Button is displayed when user clicks on ME Button");
				
			}else {
				logger.info("Register Button:" + "Register Button is not displayed when user clicks on ME button");
				extent.extentLoggerFail("Register Button:", "Register Button is not displayed when user clicks on ME button");
					
			}
			if (verifyElementExist(AMDHipi.objLoginbtn, "Login Button")) {
				logger.info("Login Button:" + "Login Button is displayed when user clicks on ME Button");
				extent.extentLogger("Login Button:", "Login Button is displayed when user clicks on ME Button");
				
			}else {
				logger.info("Login Button:" + "LoginButton is not displayed when user clicks on ME button");
				extent.extentLoggerFail("Login Button:", "LoginButton is not displayed when user clicks on ME button");
					
			}
			
			
		}
		
		public void usernameFromDiscoverAndOnTapUserZee5LoginSignUpShouldBeVisible(String userType) throws Exception {
			extent.HeaderChildNode("As a Guest user, Check if user is able to view users by searching with username from Discover");
			System.out.println("TC_Mobile_027");
			extent.extentLogger("", "TC_Mobile_027");
			Back(1);
			click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
			waitTime(4000);
			if(verifyElementExist(HipiDiscoverPage.objDiscoverScreen, "Discover Screen")){
				

				logger.info("Discover Screen:" + "When ever user click on Discover,Discover Page is displayed");
				extent.extentLoggerPass("Discover Screen:","When ever user click on Discover,Discover Page is displayed");

			} else {
				logger.info(
						"Discover Screen:" + "When ever user click on Discover,Discover Page is not displayed");
				extent.extentLoggerFail("Discover Screen:","When ever user click on Discover,Discover Page is not displayed");
			}
			click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
			waitTime(5000);
			String kundaliBhagya = getParameterFromXML("keyword");
			waitTime(5000);
			type(HipiDiscoverPage.objSearchButton, kundaliBhagya, "Kundali Bhagya");
			waitTime(3000);
			hideKeyboard();
			waitTime(4000);
			click(HipiOtherProfileScreen.objKundaliBhagya, "Kundali Bhagya");
			waitTime(4000);
			if(verifyElementExist(HipiOtherProfileScreen.objProfileDetails, "Profile Details")) {

				logger.info("Profile Details:" + "Kundali Bhagya Profile Details is Visible");
				extent.extentLoggerPass("Profile Details:","Kundali Bhagya Profile Details is Visible");
				verifyElementExist(HipiOtherProfileScreen.objUserNameText, " User Name");
			
			} else {
				logger.info("Profile Details:" + "Kundali Bhagya Profile Details is not Visible");
				extent.extentLoggerFail("Profile Details:","Kundali Bhagya Profile Details is not Visible");
			}
			click(HipiOtherProfileScreen.objProfilePic, "Profile Pic");
			waitTime(3000);
			if (verifyElementExist(AMDHipi.objRegisterforVibe, "Register PopUP")) {
				logger.info("Register PopUP:" + "RegisterPop is displayed when user clicks on ME Button");
				extent.extentLogger("Register PopUP:", "RegisterPop is displayed when user clicks on ME Button");
				
			}else {
				logger.info("Register PopUP:" + "RegisterPop is not displayed when user clicks on ME Button");
				extent.extentLoggerFail("Register PopUP:", "RegisterPop is not displayed when user clicks on ME Button");
					
			}
			if (verifyElementExist(AMDHipi.objRegisterbtn, "Register Button")) {
				logger.info("Register Button:" + "Register Button is displayed when user clicks on ME Button");
				extent.extentLogger("Register Button:", "Register Button is displayed when user clicks on ME Button");
				
			}else {
				logger.info("Register Button:" + "Register Button is not displayed when user clicks on ME button");
				extent.extentLoggerFail("Register Button:", "Register Button is not displayed when user clicks on ME button");
					
			}
			if (verifyElementExist(AMDHipi.objLoginbtn, "Login Button")) {
				logger.info("Login Button:" + "Login Button is displayed when user clicks on ME Button");
				extent.extentLogger("Login Button:", "Login Button is displayed when user clicks on ME Button");
				
			}else {
				logger.info("Login Button:" + "LoginButton is not displayed when user clicks on ME button");
				extent.extentLoggerFail("Login Button:", "LoginButton is not displayed when user clicks on ME button");
					
			}
		}
		
		

		public void viewProfileDetailsByTappingOnProfileIcon(String userType) throws Exception {
			extent.HeaderChildNode("OwnProfile EntryPoint Check if user is able to view profile details by tapping on profile icon ME");
			System.out.println("TC_Mobile_002");
			extent.extentLogger("", "TC_Mobile_002");
			
			if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
				click(AMDOnboardingScreen.objHipiButton, "HiPi");
				Thread.sleep(6000);

			} else {

			}
			
			
			click(HipiMePage.objMeicon, "Me Icon");
			waitTime(5000);
			if(verifyIsElementDisplayed(HipiMePage.objHipiProfileScreen, "Profile Screen")){
			logger.info("Profile Screen:" + "Profile Screen is displayed when ever user click on ME icon");
			extent.extentLogger("Profile Screen:", "Profile Screen is displayed when ever user click on ME icon");
			verifyIsElementDisplayed(HipiMePage.objHipiProfile);
			waitTime(3000);
		}else {
			logger.info("Profile Screen:" + "Profile Screen is displayed when ever user click on ME icon");
			extent.extentLoggerFail("Profile Screen:", "Profile Screen is displayed when ever user click on ME icon");
				
		}
		 	}
			
		public void viewProfileDetailsOfNormalUserByTappingOnProfilePicture(String userType) throws Exception {
			extent.HeaderChildNode("Normal User EntryPoint Check if user is able to view profile details of Normal User by tapping on profile picture icon in video");
			System.out.println("TC_Mobile_003");
			extent.extentLogger("", "TC_Mobile_003");

			Back(1);
			waitTime(3000);
			
			click(HipiFeedPage.objprofilepic, "profile pic");
			waitTime(5000);
			
			if(verifyElementExist(HipiOtherProfileScreen.objProfileDetails, "Profile Details")) {

				logger.info("Profile Details:" + " Profile Details is Visible");
				extent.extentLoggerPass("Profile Details:"," Profile Details is Visible");
				verifyElementExist(HipiOtherProfileScreen.objUserNameText, " User Name");
			
			} else {
				logger.info("Profile Details:" + "Kundali Bhagya Profile Details is not Visible");
				extent.extentLoggerFail("Profile Details:","Kundali Bhagya Profile Details is not Visible");
			}
			
		}
		public void UserAbleToViewProfileDetailsOfNormalUserProfileName(String userType) throws Exception {
			
			extent.HeaderChildNode("Normal User EntryPoint Check if user is able to view profile details of Normal User by tapping on profile name user handle in video description");
			System.out.println("TC_Mobile_004");
			extent.extentLogger("", "TC_Mobile_004");

			Back(1);
			waitTime(5000);
			click(HipiFeedPage.objdescription, "description");
			waitTime(5000);
			
			String userName = getText(HipiOtherProfileScreen.objUserNameText);
			if(verifyIsElementDisplayed(HipiOtherProfileScreen.objUserNameText, "User Name")) {

				logger.info("User Name:" + userName);
				extent.extentLoggerPass("User Name:","User name is displayed when ever click on description");
			
			} else {
				logger.info("User Name:" + "User name is not displayed when ever click on description");
				extent.extentLoggerFail("User Name:","User name is not displayed when ever click on description");
			}	
			
		} 
		
		public void searchingProfileOfValidNormalUserFromDiscover(String userType) throws Exception {
			

			extent.HeaderChildNode("Normal User EntryPoint Check if user is able to view profile details by searching profile of a valid normal user from Discover");
			System.out.println("TC_Mobile_006");
			extent.extentLogger("", "TC_Mobile_006");

			Back(1);
			waitTime(3000);
			click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
			waitTime(4000);
			if(verifyElementExist(HipiDiscoverPage.objDiscoverScreen, "Discover Screen")){
				

				logger.info("Discover Screen:" + "When ever user click on Discover,Discover Page is displayed");
				extent.extentLoggerPass("Discover Screen:","When ever user click on Discover,Discover Page is displayed");

			} else {
				logger.info(
						"Discover Screen:" + "When ever user click on Discover,Discover Page is not displayed");
				extent.extentLoggerFail("Discover Screen:","When ever user click on Discover,Discover Page is not displayed");
			}
			click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
			waitTime(5000);
			String kundaliBhagya = getParameterFromXML("keyword");
			waitTime(5000);
			type(HipiDiscoverPage.objSearchButton, kundaliBhagya, "Kundali Bhagya");
			waitTime(3000);
			hideKeyboard();
			waitTime(4000);
			verifyIsElementDisplayed(HipiOtherProfileScreen.objKundaliBhagya);
			waitTime(4000);
			click(HipiOtherProfileScreen.objKundaliBhagya, "Kundali Bhagya");
			waitTime(4000);
			if(verifyElementExist(HipiOtherProfileScreen.objProfileDetails, "Profile Details")) {

				logger.info("Profile Details:" + " Profile Details is Visible");
				extent.extentLoggerPass("Profile Details:"," Profile Details is Visible");
				verifyElementExist(HipiOtherProfileScreen.objUserNameText, " User Name");
			
			} else {
				logger.info("Profile Details:" + "Kundali Bhagya Profile Details is not Visible");
				extent.extentLoggerFail("Profile Details:","Kundali Bhagya Profile Details is not Visible");
			}
			
		
		}
		
		public void UserShouldRedirectBackToHipiHomeScreen(String userType) throws Exception {
			

			extent.HeaderChildNode("OwnProfile Check if on tapping back button user is redirected back to HiPi home screen");
			System.out.println("TC_Mobile_009");
			extent.extentLogger("", "TC_Mobile_009");

			
			waitTime(3000);
			click(HipiMePage.objbackbutton, "Back Button");
			waitTime(9000);
			if(verifyIsElementDisplayed(HipiHomePage.objPlayerScreen, "Player Screen")){

				logger.info("Player Screen:" + "Hipi home screen is displayed");
				extent.extentLoggerPass("Player Screen:","Hipi home screen is displayed");
			
			} else {
				logger.info("Player Screen:" + "Hipi home screen is not displayed");
				extent.extentLoggerFail("Player Screen:","Hipi home screen is not displayed");
			}
			
		}
		public void UserShouldRedirectToNotificationScreen(String userType) throws Exception {
			
			extent.HeaderChildNode("OwnProfile Check if on tapping Notification bell icon user is directed back to Notification Screen");
			System.out.println("TC_Mobile_010");
			extent.extentLogger("", "TC_Mobile_010");

			click(HipiMePage.objMeicon, "Me Icon");
			
			waitTime(4000);
			
			click(HipiMePage.objnotification, "notification");
			waitTime(6000);
			if(verifyIsElementDisplayed(HipiNotificationPage.objNotificationscreen, "Notification Screen")){
				
				logger.info("Notification Screen:" + "Notification Screen is displayed when ever click on Notification");
				extent.extentLoggerPass("Notification Screen:","Notification Screen is displayed when ever click on Notification");
			
			} else {
				logger.info("Notification Screen:" + "Notification Screen is not displayed when ever click on Notification");
				extent.extentLoggerFail("Notification Screen:","Notification Screen is not displayed when ever click on Notification");
			}
			
			
		}
		
		public void UserShouldRedirectedToHiPiSettingsScreen(String userType) throws Exception {
			extent.HeaderChildNode("OwnProfile Check if on tapping Settings icon user is redirected to HiPi Setting Screen");
			System.out.println("TC_Mobile_011");
			extent.extentLogger("", "TC_Mobile_011");

			Back(1);
			click(HipiMePage.objsettingsicon, "settings icon");
			waitTime(6000);
			if(verifyIsElementDisplayed(HipiSettingsPage.obSettingScreen, "Setting Screen")){

				logger.info("Setting Screen:" + "Setting Screen is displayed when ever click on Settings");
				extent.extentLoggerPass("Setting Screen:","Setting Screen is displayed when ever click on Settings");
			
			} else {
				logger.info("Setting Screen:" + "Setting Screen is not displayed when ever click on Settings");
				extent.extentLoggerFail("Setting Screen:","Setting Screen is not displayed when ever click on Settings");
			}
			
			
		}
		
		
		public void  viewAllHisPrivateVideos(String userType) throws Exception {
			extent.HeaderChildNode("OwnProfile Video LTab Private Verify if user is able to view all his private videos");
			System.out.println("TC_Mobile_015");
			extent.extentLogger("", "TC_Mobile_015");
//			click(HipiMePage.objMeicon, "Me Icon");
//			waitTime(5000);
			
			if(verifyIsElementDisplayed(HipiMePage.objVideoTabIsSelectedByBeafult, "Video Tab Is Selected By Beafult")){
				logger.info("Video Tab Is Selected By Beafult:" + "Video Tab Is Selected By Beafult when ever click on ME");
				extent.extentLoggerPass("Video Tab Is Selected By Beafult:","Video Tab Is Selected By Beafult when ever click on ME");
			
			} else {
				logger.info("Video Tab Is Selected By Beafult:" + "Video Tab Is not Selected By Beafult when ever click on ME");
				extent.extentLoggerFail("Video Tab Is Selected By Beafult:","Video Tab Is not Selected By Beafult when ever click on ME");
			}
			
			click(HipiMePage.objprivateTab, "Private Tab");
			waitTime(5000);
			if(verifyIsElementDisplayed(HipiMePage.objprivateVideosScreen, "private Videos Screen")){
				logger.info("private Videos Screen:" + "private Videos Screen is displayed when ever click on private");
				extent.extentLoggerPass("private Videos Screen:","private Videos Screen is displayed when ever click on private");
			} else {
				logger.info("private Videos Screen:" + "private Videos Screen is displayed when ever click on private");
				extent.extentLoggerFail("private Videos Screen:","private Videos Screen is displayed when ever click on private");
			}
		} 
		

		public void  fullscreenPlayerView(String userType) throws Exception {
			
			
			extent.HeaderChildNode("OwnProfile Video LTab Private Check if on tapping video will directed the user to the fullscreen Player view");
			System.out.println("TC_Mobile_016");
			extent.extentLogger("", "TC_Mobile_016");
		
			
			click(HipiMePage.obOneOfVideo, "One Of Video");
			waitTime(4000);
			if(verifyIsElementDisplayed(HipiHomePage.objPlayerScreen, "Full Screen player view")){
				logger.info("Full Screen player view:" + "User is redirect to the full-screen Player view");
				extent.extentLoggerPass("Full Screen player view:","User is redirect to the full-screen Player view");
			} else {
				logger.info("Full Screen player view:" + "User is not redirect to the full-screen Player view");
				extent.extentLoggerFail("Full Screen player view:","User is not redirect to the full-screen Player view");
			}
					
		}
		
		public void  backButtonUserIsRedirectedToPrivateListingTab(String userType) throws Exception {
			extent.HeaderChildNode("OwnProfile Video LTab Private Check if on tapping back button user is redirected to Private Listing tab");
			System.out.println("TC_Mobile_017");
			extent.extentLogger("", "TC_Mobile_017");
			if(verifyIsElementDisplayed(HipiHomePage.objBackButton, "Back Button")){
				logger.info("Back Button:" + "Back Button is displayed player viwe");
				extent.extentLoggerPass("Back Button:","Back Button is displayed player viwe");
				click(HipiHomePage.objBackButton, "Back Button");
				waitTime(4000);
			} else {
				logger.info("Back Button:" + "Back Button is not displayed player viwe");
				extent.extentLoggerFail("Back Button:","Back Button is not displayed player viwe");
			}
			if(verifyIsElementDisplayed(HipiMePage.objprivateVideosScreen, "private Videos Screen")){
				logger.info("private Videos Screen:" + "private Videos Screen is displayed when ever click on private");
				extent.extentLoggerPass("private Videos Screen:","private Videos Screen is displayed when ever click on private");
			} else {
				logger.info("private Videos Screen:" + "private Videos Screen is displayed when ever click on private");
				extent.extentLoggerFail("private Videos Screen:","private Videos Screen is displayed when ever click on private");
			}

		}
		
		
		public void originalSoundsCreatedByTheProfileOwner(String userType) throws Exception {
			
			extent.HeaderChildNode("OwnProfile Original Sound LTab Check if user is able to view all the list of original sounds created by the profile owner");
			System.out.println("TC_Mobile_020");
			extent.extentLogger("", "TC_Mobile_020");
			click(HipiMePage.objOriginalsoundTab, "Original sound Tab");
			if (verifyIsElementDisplayed(HipiMePage.objListOfSounds, "List Of Sounds")) {
				logger.info("List Of Sounds:" + "List Of Sounds is displayed when ever click on Original sound Tab");
				extent.extentLoggerPass("List Of Sounds:","List Of Sounds is displayed when ever click on Original sound Tab");
			} else {
				logger.info("List Of Sounds:" + "List Of Sounds is not displayed when ever click on Original sound Tab");
				extent.extentLoggerFail("List Of Sounds:","List Of Sounds is not displayed when ever click on Original sound Tab");
			}
			
		}
		

		public void redirectedToCreatorModuleWithTheSelectedSound(String userType) throws Exception {
			extent.HeaderChildNode("OwnProfile Original Sound LTab Check if on tapping Use sound user is redirected to creator module with the selected sound");
			System.out.println("TC_Mobile_029");
			extent.extentLogger("", "TC_Mobile_029");
			
			click(HipiMePage.objOriginalsoundTab, "Original sound Tab");
			waitTime(3000);
			if(verifyIsElementDisplayed(HipiMePage.objUseSoundButton, "Sound Button")){
				logger.info("Sound Button:" + "Sound Button is displayed when user click on Original sound Tab");
				extent.extentLoggerPass("Sound Button:","Sound Button is displayed when user click on Original sound Tab");
				click(HipiMePage.objUseSoundButton, "SoundButton");
			} else {
				logger.info("Sound Button:" + "Sound Button is not displayed when user click on Original sound Tab");
				extent.extentLoggerFail("Sound Button:","Sound Button is not displayed when user click on Original sound Tab");
			}
			if (verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo,
					"Allow ZEE5 to take pictures and record video?")) {
				logger.info("Permission dialog:" + "Allow ZEE5 to take pictures and record video?");
				verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow");
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				logger.info("Allow ZEE5 to take pictures and record video-" + "Allow button");
				Thread.sleep(5000);

				logger.info("Permission dialog:" + "Allow ZEE5 to access photos, media, and files on your device");
				verifyElementExist(HipiCreateVideoPage.objCreateAllow,
						"Allow ZEE5 to access photos, media, and files on your device?");
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				logger.info("Allow ZEE5 to access photos, media, and files on your device-" + "Allow button");
				Thread.sleep(5000);

				logger.info("Permission dialog:" + "Allow ZEE5 to record audio");
				verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?");
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				logger.info("Allow ZEE5 to record audio-" + "Allow button");
				//Thread.sleep(40000);
				waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
				verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
				click(HipiCreateVideoPage.objCreateReadyYes, "yes button");
				logger.info("Ready dialog displayed:" + "yes button");
				Thread.sleep(10000);
			}
			logger.info("Create video page:" + "Create video page displayed");
			
			if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Video Creation screen")) {
				logger.info("Video Creation Screen:" + "User is redirect to Video Creation Screen");
				extent.extentLoggerPass("Video Creation Screen:","User is redirect to Video Creation Screen");
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objSoundName,"Sound Name")){
				logger.info("Sound Name:" + "Video Creation Screen and Sound Name is displayed");
				extent.extentLoggerPass("Sound Name:","Video Creation Screen and Sound Name is displayed");
			} else {
				logger.info("Sound Name:"+ "Video Creation Screen and Sound Name is not displayed");
				extent.extentLoggerFail("Sound Name:","Video Creation Screen and Sound Name is not displayed");
			}
			} else {
				logger.info("Video Creation Screen:"+ "User is not redirect to Video Creation Screen");
				extent.extentLoggerFail("Video Creation Screen:","User is not redirect to Video Creation Screen");
			}
		}
		
		public void profileIconInCommentsPage(String userType) throws Exception {

			extent.extentLogger("", "TC_Mobile_028");
			
			Back(2);
			
			click(HipiHomePage.objCommentIcon, "Comment Icon");
			waitTime(4000);
			if(verifyIsElementDisplayed(HipiHomePage.objCommentScreen, "Comment Screen")){
				logger.info("Comment Screen:" + "Comment Screen is displayed when ever click on Comment Icon");
				extent.extentLoggerPass("Comment Screen:","Comment Screen is displayed when ever click on Comment Icon");
				//click(HipiHomePage.objOneofComment, "One of Comment ");
				
				if(verifyIsElementDisplayed(HipiHomePage.objOneofComment, "Comment")) {
					logger.info("Comment:" + "Comment Icon is displayes when ever click on Comment");
					extent.extentLoggerPass("Comment:","Comment Icon is displayes when ever click on Comment");
				click(HipiHomePage.objClickOnProfileInCommentScreen, "One of Comment");
				waitTime(4000);
				if(verifyElementExist(HipiOtherProfileScreen.objProfileDetails, "Profile Details")) {

					logger.info("Profile Details:" + " Profile Details is Visible");
					extent.extentLoggerPass("Profile Details:"," Profile Details is Visible");
					verifyElementExist(HipiOtherProfileScreen.objUserNameText, " User Name");
				
				} else {
					logger.info("Profile Details:" + "Profile Details is not Visible");
					extent.extentLoggerFail("Profile Details:"," Profile Details is not Visible");
				}
				} else {
					logger.info("Comment:" + "Comment Icon is not  displayes when ever click on Comment");
					extent.extentLoggerWarning("Comment:","Comment Icon is not displayes when ever click on Comment");
				}
				
				waitTime(4000);
			} else {
				logger.info("Comment Screen:"+ "Comment Screen is not displayed when ever click on Comment Icon");
				extent.extentLoggerFail("Comment Screen:","Comment Screen is not displayed when ever click on Comment Icon");
			}
			
		}
		
		
		public void  soundDetailScreen(String userType) throws Exception {
			extent.HeaderChildNode("OwnProfile Original Sound LTab Check if on tapping on sound user will be redirected to Sound detail screen");
			System.out.println("TC_Mobile_021");
			extent.extentLogger("", "TC_Mobile_021");
			click(HipiMePage.objTaponthesound, "Tap on the sound");
			if (verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDetailScreen, "Sound Detail Screen")) {
				logger.info("Sound Detail Screen:" + "Sound Detail Screen is displayed when ever click on sound");
				extent.extentLoggerPass("Sound Detail Screen:","Sound Detail Screen is displayed when ever click on sound");
			} else {
				logger.info("Sound Detail Screen:" + "Sound Detail Screen is not displayed when ever click on sound");
				extent.extentLoggerFail("Sound Detail Screen:","Sound Detail Screen is not displayed when ever click on sound");
			}
		}
		public void originalSoundInThEOriginalSoundList(String userType) throws Exception {
			extent.HeaderChildNode("OwnProfile Original Sound LTab Check if user is view all the related items for a original sound in the original sound list");
			System.out.println("TC_Mobile_022");
			extent.extentLogger("", "TC_Mobile_022");
			
//			click(HipiMePage.objTaponthesound, "Tap on the sound");
			if(verifyIsElementDisplayed(HipiMePage.objThumbnailofthesound, "Thumbnail sound")){
				
				logger.info("Thumbnail of the sound:" + "When evre tap on Thumbnail of the sound is displayed ");
				extent.extentLoggerPass("Thumbnail of the sound:","When evre tap on Thumbnail of the sound is displayed ");

			} else {
				logger.info("Thumbnail of the sound:" + "When evre tap on Thumbnail of the sound is not displayed ");
				extent.extentLoggerFail("Thumbnail of the sound:","When evre tap on Thumbnail of the sound is not displayed ");
			}
//			click(HipiMePage.objAddedfavouritepopup, "Favourite icon");
//			if(verifyElementExist(HipiMePage.objAddedfavouritepopup, "Added favourite")){
//				
//				logger.info("Added favourite popup:" + "Added favourite popup is displayed");
//				extent.extentLoggerPass("Added favourite popup:","Added favourite popup is displayed");

//			} else {
//				logger.info("Added favourite popup:" + "Added favourite popup is not displayed");
//				extent.extentLoggerFail("Added favourite popup:","Added favourite popup is not displayed");
//			}
//			click(HipiMePage.objFavouriteicon, "Favourite icon");
			if (verifyIsElementDisplayed(HipiMePage.objRemovieFavourite, "Removie Favourite")) {
				logger.info("Removie favourite popup:" + "Removie favourite popup is displayed");
				extent.extentLoggerPass("Removie favourite popup:","Removie favourite popup is displayed");
			
			} else {
				logger.info("Removie favourite popup:" + "Removie favourite popup is not displayed");
				extent.extentLoggerFail("Removie favourite popup:","Removie favourite popup is not displayed");
			}
			click(HipiMePage.objThumbnailofthesound, "Thumbnail of the sound");
			String soundName = getText(HipiMePage.objSoundName);
			if(verifyIsElementDisplayed(HipiMePage.objSoundName, "Sound Name")){
				logger.info("Sound Name:" + soundName);
				extent.extentLoggerPass("Sound Name:","Sound Name is displayed");

			} else {
				logger.info("Sound Name:" + "Sound Name is not displayed");
				extent.extentLoggerFail("Sound Name:","Sound Name is not displayed");
			}
			String soundDuration = getText(HipiMePage.objsoundDuration);
				if(verifyIsElementDisplayed(HipiMePage.objsoundDuration, "Sound Duration")){
					
					logger.info("Sound Duration:" + soundDuration );
					extent.extentLoggerPass("Sound Duration:","Sound Duration is displayed");

				} else {
					logger.info("Sound Duration:" + "Sound Duration is not displayed");
					extent.extentLoggerFail("Sound Duration:","Sound Duration is not displayed");
				}
				if(verifyIsElementDisplayed(HipiMePage.objUsethisSoundIcon, "Use Sound Icon")){
					logger.info("Use Sound Icon:" + "Use Sound Icon is displayed bottom of the screen" );
					extent.extentLoggerPass("Use Sound Icon:","Use Sound Icon is displayed bottom of the screen");

				} else {
					logger.info("Use Sound Icon:" + "Use Sound Icon is not displayed bottom of the screen");
					extent.extentLoggerFail("Use Sound Icon:","Use Sound Icon is not displayed bottom of the screen");
				}
				
			
		}
		public void favouriteTab(String userType) throws Exception {
			extent.HeaderChildNode("OwnProfile Favorites LTab Check the list of sub tabs available in favourite tab");
			System.out.println("TC_Mobile_023");
			extent.extentLogger("", "TC_Mobile_023");
			Back(1);
			click(HipiMePage.objfavourite, "Favourite Tab");
			waitTime(3000);
			verifyIsElementDisplayed(HipiMePage.objvideo, "Videos");
			verifyIsElementDisplayed(HipiMePage.objHashtags, "Hashtags");
			verifyIsElementDisplayed(HipiMePage.objsounds, "Sounds");
			verifyIsElementDisplayed(HipiMePage.objEffects, "Effects");
		}
		
		public void visibleUnderFavouriteVideosSubTab(String userType) throws IOException {
			extent.HeaderChildNode("Favourite Videos Verify the selected video which are added to favourite by user is displayed in Profile favourite list");
			System.out.println("TC_Mobile_025");
			extent.extentLogger("", "TC_Mobile_025");
			if(verifyIsElementDisplayed(HipiMePage.objvideosUnderFavorites, "videos")){
				logger.info("videos:" + "videos is displaye when ever click on Favourite icon");
				extent.extentLoggerPass("videos:","videos is displaye when ever click on Favourite icon");
			} else {
				logger.info("videos:" + "videos is not displaye when ever click on Favourite icon");
				extent.extentLoggerFail("videos:","videos is not displaye when ever click on Favourite icon");
			}
			
		}
		
		
		public void  optionsPresentInNavigationBarIcon(String userType) throws IOException {
			
			extent.HeaderChildNode("OwnProfile Check the top options present in navigation bar icon");
			System.out.println("TC_Mobile_008");
			extent.extentLogger("", "TC_Mobile_008");
			if(verifyIsElementDisplayed(HipiMePage.objbackbutton, "Back Button")){
				logger.info("Back Button:" + "Back button is displayed when ever click on ME Button");
				extent.extentLoggerPass("Back Button:","Back button is displayed when ever click on ME Button");
			} else {
				logger.info("Back Button:" + "Back button is not displayed when ever click on ME Button");
				extent.extentLoggerFail("Back Button:","Back button is not  displayed when ever click on ME Button");
			}
			if (verifyIsElementDisplayed(HipiMePage.objuserName, "@User Name")) {
				logger.info("@User Name:" + "User name is displayed when ever click on ME button");
				extent.extentLoggerPass("@User Name:","User name is displayed when ever click on ME button");
			} else {
				logger.info("@User Name:" + "User name is not displayed when ever click on ME button");
				extent.extentLoggerFail("@User Name:","User name is not displayed when ever click on ME button");
			}
			if (verifyIsElementDisplayed(HipiMePage.objnotification, "Notification Icon")) {
				logger.info("Notification Icon:" + "Notification Icon is displayed when ever click on ME button");
				extent.extentLoggerPass("Notification Icon:","Notification Icon is displayed when ever click on ME button");
			} else {
				logger.info("Notification Icon:" + "Notification Icon is not displayed when ever click on ME button");
				extent.extentLoggerFail("Notification Icon:","Notification Icon is not displayed when ever click on ME button");
			}
			if (verifyIsElementDisplayed(HipiMePage.objsettingsicon, "Settings Icon" )) {
				logger.info("Settings Icon:" + "Settings Icon is displayed when ever click on ME button");
				extent.extentLoggerPass("Settings Icon:","Settings Icon is displayed when ever click on ME button");
			} else {
				logger.info("Settings Icon:" + "Settings Icon is not displayed when ever click on ME button");
				extent.extentLoggerFail("Settings Icon:","Settings Icon is not displayed when ever click on ME button");
			}
		}
		
		
		public void  LongpressCheckaddvVideoToHisFavorites(String userType) throws Exception {
			
			extent.HeaderChildNode("OwnProfile Video Ltab Longpress Check if user is able to add video to his favorites from video ALL tab and also verify deleted favourite videos are no longer seen");
			System.out.println("TC_Mobile_012");
			extent.extentLogger("", "TC_Mobile_012");
//			click(HipiMePage.objMeicon, "Me Icon");
//			waitTime(5000);
			Back(1);
			String nameOfVideo = getText(HipiMePage.objVideoText);
			if(verifyIsElementDisplayed(HipiMePage.objVideoText, "Video Name")){
				logger.info("Video Name:" + nameOfVideo);
				extent.extentLoggerPass("Video Name:","Video Name is displayed when ever click on Me Icon");
			} else {
				logger.info("Video Name:" + "Video Name is not displayed when ever click on Me Icon");
				extent.extentLoggerFail("Video Name:","Video Name is not displayed when ever click on Me Icon");
			}
			scrolltomiddle(HipiMePage.obOneOfVideo);
			waitTime(5000);
			longPress(HipiMePage.obOneOfVideo);
			waitTime(7000);
			click(HipiMePage.obAddtoFavorites, "Add to Favorites");
			waitTime(4000);
			click(HipiMePage.objfavourite, "Favourite");
			waitTime(4000);
			String sameNameOfVideo = getText(HipiMePage.objVideoText);
			if(verifyIsElementDisplayed(HipiMePage.objVideoText, "Video Name")){
				logger.info("Video Name:" + nameOfVideo);
				extent.extentLoggerPass("Video Name:","Video Name is displayed when ever click on Favorites");
			} else {
				logger.info("Video Name:" + "Video Name is not displayed when ever click on Favorites");
				extent.extentLoggerFail("Video Name:","Video Name is not displayed when ever click on Favorites");
			}

			click(HipiMePage.objVideoFavouriteIcon, "Video Favourite icon");
			waitTime(1000);
			if(verifyElementExist(HipiMePage.objRemovedPopup, "Removed Popup")){
				logger.info("Removed Popup:" + "Removed Popup is displayed when ever click on Favourite icon");
				extent.extentLoggerPass("Removed Popup:","Removed Popup is displayed when ever click on Favourite icon");
			} else {
				logger.info("Removed Popup:" + "Removed Popup is not displayed when ever click on Favourite icon");
				extent.extentLoggerFail("Removed Popup:","Removed Popup is not displayed when ever click on Favourite icon");
			}
			Swipe("DOWN", 1);
		}
		
		public void tapVideoIsMovedToDraft(String userType) throws Exception {
			extent.HeaderChildNode("OwnProfile Video Ltab Longpress Check if user is able to view Unpublish Video option and OnTap video is moved to Draft");
			System.out.println("TC_Mobile_014");
			extent.extentLogger("", "TC_Mobile_014");

			String nameOfVideo = getText(HipiMePage.objVideoText);
			if(verifyIsElementDisplayed(HipiMePage.objVideoText, "Video Name")){
				logger.info("Video Name:" + nameOfVideo);
				extent.extentLoggerPass("Video Name:","Video Name is displayed when ever click on Me Icon");
			} else {
				logger.info("Video Name:" + "Video Name is not displayed when ever click on Me Icon");
				extent.extentLoggerFail("Video Name:","Video Name is not displayed when ever click on Me Icon");
			}
			scrolltomiddle(HipiMePage.obOneOfVideo);
			waitTime(3000);
			longPress(HipiMePage.obOneOfVideo);
			waitTime(3000);
			click(HipiMePage.objUnpublishVideo, "Unpublish Video");
			waitTime(3000);
			if(verifyIsElementDisplayed(HipiMePage.objUnpublishVideoPopUP, "Unpublish Video PopUP")){
				logger.info("Unpublish Video PopUP:" + "Unpublish Video PopUP is displayed when ever click on Unpublish Video");
				extent.extentLoggerPass("Unpublish Video PopUP:","Unpublish Video PopUP is displayed when ever click on Unpublish Video");
			click(HipiMePage.objYesButton, "Yes Button");
			} else {
				logger.info("Unpublish Video PopUP:" + "Unpublish Video PopUP is not displayed when ever click on Unpublish Video");
				extent.extentLoggerFail("Unpublish Video PopUP:","Unpublish Video PopUP is not displayed when ever click on Unpublish Video");
			}
			
			if(verifyIsElementDisplayed(HipiMePage.objSuccessfullyUnpublishPopUp, "Successfully Unpublish PopUp")){
				logger.info("Successfully Unpublish PopUp:" + "Successfully Unpublish PopUp is displayed when ever click on Yes Button");
				extent.extentLoggerPass("Successfully Unpublish PopUp:","Successfully Unpublish PopUp is displayed when ever click on Yes Button");
				click(HipiMePage.objokbutton, "Done Button");
			} else {
				logger.info("Successfully Unpublish PopUp:" + "Successfully Unpublish PopUp is not displayed when ever click on Yes Button");
				extent.extentLoggerFail("Successfully Unpublish PopUp:","Successfully Unpublish PopUp is not displayed when ever click on Yes Button");
			}
			click(HipiMePage.objdraft, "Draft Icon");
			
			waitTime(3000);
			if(verifyIsElementDisplayed(HipiMePage.objUploadAllButton, "Upload All button")){
				scrolltomiddle(HipiMePage.objUploadAllButton);
			}else{
				
			}
			scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);

			String sameNameOfVideo = getText(HipiMePage.objVideoText);
			if(verifyIsElementDisplayed(HipiMePage.objVideoText, "Video Name")){
				logger.info("Video Name:" + nameOfVideo);
				extent.extentLoggerPass("Video Name:","Video Name is displayed when ever click on Draft");
			} else {
				logger.info("Video Name:" + "Video Name is not displayed when ever click on Draft");
				extent.extentLoggerFail("Video Name:","Video Name is not displayed when ever click on Draft");
			}
			Swipe("DOWN", 1);
		}
		
		public void deletePublishedVideoAndConfirmationPopupIsDisplayed(String userType) throws Exception {
			
			extent.HeaderChildNode("OwnProfile Video Ltab Longpress Check if user is able to delete published Video and a confirmation popup is displayed");
			System.out.println("TC_Mobile_013");
			extent.extentLogger("", "TC_Mobile_013");
			click(HipiMePage.objVideoTabIsSelectedByBeafult, "video tab");
			
			if(verifyIsElementDisplayed(HipiMePage.objUploadAllButton, "Upload All button")){
				scrolltomiddle(HipiMePage.objUploadAllButton);
			}else{
				
			}
			
			waitTime(3000);
			scrolltomiddle(HipiMePage.obOneOfVideo);
			waitTime(3000);
			longPress(HipiMePage.obOneOfVideo);
			waitTime(5000);
			click(HipiMePage.objDeleteVideo, "Delete Video");
			waitTime(1000);
			if (verifyIsElementDisplayed(HipiMePage.objDeleteVideoPopUp, "Delete Video PopUp")) {
				logger.info("Delete Video PopUp:" + "Delete Video PopUp is displayed when ever click on Delete video");
				extent.extentLoggerPass("Delete Video PopUp:","Delete Video PopUp is displayed when ever click on Delete video");
				click(HipiMePage.objYesButton, "Yes button");
			} else {
				logger.info("Delete Video PopUp:" + "Delete Video PopUp is not displayed when ever click on Delete video");
				extent.extentLoggerFail("Delete Video PopUp:","Delete Video PopUp is not displayed when ever click on Delete video");
			}
			if (verifyIsElementDisplayed(HipiMePage.objVideoSuccessfullyDeletePopUp, "delete confirmation pop-up")) {
				logger.info("delete confirmation pop-up:" + "delete confirmation pop-up is displayed when ever click on Yes Button");
				extent.extentLoggerPass("delete confirmation pop-up:","delete confirmation pop-up is displayed when ever click on Yes Button");
				click(HipiMePage.objYesButton, "Yes button");
			} else {
				logger.info("delete confirmation pop-up:" + "delete confirmation pop-up is not displayed when ever click on Yes Button");
				extent.extentLoggerFail("delete confirmation pop-up:","delete confirmation pop-up is not displayed when ever click on Yes Button");
			}
			
		}

		public void  layoutOfProfileScreen(String userType) throws Exception {

			extent.HeaderChildNode("OwnProfile Check layout of profile screen");
			System.out.println("TC_Mobile_007");
			extent.extentLogger("", "TC_Mobile_007");
			
			Back(3);
			waitTime(9000);
	//
//			if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
//				click(AMDOnboardingScreen.objHipiButton, "HiPi");
//				Thread.sleep(6000);
	//
//			} else {
	//
//			}		
			click(HipiMePage.objMeicon, "Me Icon");
			waitTime(5000);
			if(verifyIsElementDisplayed(HipiMePage.objNavigation, "Navigation")){
				logger.info("Navigation:" + "Navigation bar is displayed when ever click on Me Button");
				extent.extentLoggerPass("Settings Icon:","Navigation bar is displayed when ever click on Me Button");
			} else {
				logger.info("Navigation:" + "Navigation bar is not displayed when ever click on Me Button");
				extent.extentLoggerFail("Navigation:","Navigation bar is not displayed when ever click on Me Button");
			}
			verifyIsElementDisplayed(HipiMePage.objHipiProfile, "Profile pic");
			String userName = getText(HipiMePage.objProfileName);
			if(verifyIsElementDisplayed(HipiMePage.objProfileName,"Profile Name")) {

				logger.info("Profile Name:" + userName);
				extent.extentLoggerPass("Profile Name:","Profile Name is displayed when ever click on Me icon");
			
			} else {
				logger.info("Profile Name:" + "Profile Name is not displayed when ever click on Me icon");
				extent.extentLoggerFail("Profile Name:","Profile Name is not displayed when ever click on Me icon");
			}	
			verifyIsElementDisplayed(HipiMePage.objBioDescription, "Bio Description");
			
	        String followerCount = getText(HipiMePage.objFollowersCount);
			
			String followingCount = getText(HipiMePage.objFollowingCount);
			
			if(verifyElementExist(HipiMePage.objFollowersCount, "Followers Button")){
				logger.info("Followers Count:" +  followerCount);
				extent.extentLoggerPass("Followers Count:","Followers Count is displayed");

			} else {
				logger.info("Followers Count:" + "Followers Count is not displayed");
				extent.extentLoggerFail("Followers Count:","Followers Count is not displayed");
			}
			
			if(verifyElementExist(HipiMePage.objFollowingCount, "Following")){
				
				logger.info("Following Count:" +  followingCount);
				extent.extentLoggerPass("Following Count:","Following Count is displayed");

			} else {
				logger.info("Following Count:" + "Following Count is not displayed");
				extent.extentLoggerFail("Following Count:","Following Count is not displayed");
			}
			verifyIsElementDisplayed(HipiMePage.objeditprofile, "Edit profile");
			verifyIsElementDisplayed(HipiMePage.objVideoTab, "Video Tab");
			verifyIsElementDisplayed(HipiMePage.objOriginalsoundTab, "Original sound Tab");
			verifyIsElementDisplayed(HipiMePage.objfavourite, "Favourite");
			verifyIsElementDisplayed(HipiMePage.objall, "All Tab");
			verifyIsElementDisplayed(HipiMePage.objprivateTab, "Private Tab");
			verifyIsElementDisplayed(HipiMePage.objdraft, "Draft Tab");
			verifyIsElementDisplayed(HipiMePage.objVideoScreenUnderProfile, "Video Screen Under Profile");
			click(HipiMePage.objprivateTab, "Private Tab");
			waitTime(4000);
			verifyIsElementDisplayed(HipiMePage.objVideoScreenUnderPrivat, "Video Screen Under Privat");
			click(HipiMePage.objdraft, "Draft Tab");
			waitTime(4000);
			verifyIsElementDisplayed(HipiMePage.objVideoScreenUnderDraft, "Video Screen Under Draft");
			click(HipiMePage.objOriginalsoundTab, "Original sound Tab");
			waitTime(3000);
			verifyIsElementDisplayed(HipiMePage.objListOfSounds, "List Of Sounds");
			click(HipiMePage.objTaponthesound, "Tap on the sound");
			waitTime(4000);
			verifyIsElementDisplayed(HipiMePage.objMusicDetailScreen, "Music Detail Screen");
			Back(1);
			waitTime(4000);
			click(HipiMePage.objfavourite, "Favourite");
			waitTime(4000);
			verifyIsElementDisplayed(HipiMePage.objvideosUnderFavorites, "videos Under Favorites");
			
			
		}
		
		
		public void blankAndNoFavourite(String userType) throws Exception {

			extent.HeaderChildNode("OwnProfile Favorites LTab Check if user has not added any favourite, then the listed under sub tab is blank and No Favourite");
			System.out.println("TC_Mobile_024");
			extent.extentLogger("", "TC_Mobile_024");
			BackToFeedScreen();

			Back(1);
//			
//			waitTime(5000);
//			logout();
//			waitTime(5000);
//			click(AMDHomePage.objMoreMenu, "More Menu");
//			
			waitTime(2000);
			click(AMDOnboardingScreen.objLoginLink, "Login Link");
			String Username = getParameterFromXML("NewNonsubscribedUserNameDontUse");
			String Password = getParameterFromXML("NewNonsubscribedPasswordDontUse");

			Thread.sleep(5000);
			hideKeyboard();
			Thread.sleep(5000);
			click(AMDLoginScreen.objEmailIdField, "Email field");
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(9000);

			verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(5000);
			
			click(HipiMePage.objfavourite, "Favourite");
			waitTime(3000);
			if(verifyIsElementDisplayed(HipiMePage.objNoFavorites, "No Favorites")){
				logger.info("No Favorites:" + "No Favorites is displayed when ever click on Favourite");
				extent.extentLoggerPass("No Favorites:","No Favorites is displayed when ever click on Favourite");
			} else {
				logger.info("No Favorites:" + "No Favorites is displayed when ever click on Favourite");
				extent.extentLoggerFail("No Favorites:","No Favorites is displayed when ever click on Favourite");
			}
			
		}
		
		public void blankAndNoFavouriteVideos(String userType) throws Exception {
			extent.HeaderChildNode("OwnProfile Favorites LTab Check if user has not added any favourite, then the listed under sub tab is blank and No Favourite");
			System.out.println("TC_Mobile_024");
			extent.extentLogger("", "TC_Mobile_024");
			click(HipiMePage.objfavourite, "Favourite");
			waitTime(3000);
			if (verifyIsElementDisplayed(HipiMePage.objvideosUnderFavorites, "videos Under Favorites")) {
				logger.info("videos Under Favorites:" + "Videos is displayed when ever click on Favorites");
				extent.extentLoggerPass("videos Under Favorites:","Videos is displayed when ever click on Favorites");
			} else {
				logger.info("videos Under Favorites:" + "Videos is not displayed when ever click on Favorites");
				extent.extentLoggerFail("videos Under Favorites:","Videos is not displayed when ever click on Favorites");
			}
		}
		
		public void videoIsNoVisibleInFavouriteTab(String userType) throws Exception {
			extent.HeaderChildNode("Favourite Videos Check if user is able to remove video from Profile favourite list by tapping on favourite icon and verify the video is no visible in favourite tab");
			System.out.println("TC_Mobile_026");
			extent.extentLogger("", "TC_Mobile_026");
			
			scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
			click(HipiMePage.objVideoFavouriteIcon, "Video Favourite icon");
			if(verifyElementExist(HipiMePage.objRemovedPopup, "Removed Popup")){
				logger.info("Removed Popup:" + "Removed Popup is displayed when ever click on Favourite icon");
				extent.extentLoggerPass("Removed Popup:","Removed Popup is displayed when ever click on Favourite icon");
				click(HipiMePage.objUndoOption, "Undo Option");
			} else {
				logger.info("Removed Popup:" + "Removed Popup is not displayed when ever click on Favourite icon");
				extent.extentLoggerFail("Removed Popup:","Removed Popup is not displayed when ever click on Favourite icon");
			}
			if(verifyElementExist(HipiMePage.objAddToYourFavourite, "Add To Your Favourite")){
				logger.info("Add To Your Favourite:" + "Add To Your Favourite is displayed when ever click on Undo Option");
				extent.extentLoggerPass("Add To Your Favourite:","Add To Your Favourite is displayed when ever click on Undo Option");
			} else {
				logger.info("Add To Your Favourite:" + "Add To Your Favourite is not displayed when ever click on Undo Option");
				extent.extentLoggerFail("Add To Your Favourite:","Add To Your Favourite is not displayed when ever click on Undo Option");
			}
			waitTime(3000);
			click(HipiMePage.objVideoFavouriteIcon, "Video Favourite icon");
			waitTime(1000);
			click(HipiMePage.objUndoOption, "Undo Option");
			if(verifyElementExist(HipiMePage.objAddToYourFavourite, "Add To Your Favourite")){
				logger.info("Add To Your Favourite:" + "Add To Your Favourite is displayed when ever click on Undo Option");
				extent.extentLoggerPass("Add To Your Favourite:","Add To Your Favourite is displayed when ever click on Undo Option");
			} else {
				logger.info("Add To Your Favourite:" + "Add To Your Favourite is not displayed when ever click on Undo Option");
				extent.extentLoggerFail("Add To Your Favourite:","Add To Your Favourite is not displayed when ever click on Undo Option");
			}
			waitTime(3000);
			click(HipiMePage.objVideoFavouriteIcon, "Video Favourite icon");
			waitTime(1000);
			click(HipiMePage.objUndoOption, "Undo Option");
			if(verifyElementExist(HipiMePage.objAddToYourFavourite, "Add To Your Favourite")){
				logger.info("Add To Your Favourite:" + "Add To Your Favourite is displayed when ever click on Undo Option");
				extent.extentLoggerPass("Add To Your Favourite:","Add To Your Favourite is displayed when ever click on Undo Option");
			} else {
				logger.info("Add To Your Favourite:" + "Add To Your Favourite is not displayed when ever click on Undo Option");
				extent.extentLoggerFail("Add To Your Favourite:","Add To Your Favourite is not displayed when ever click on Undo Option");
			}
		}

		public void hipiMyProfile(String userType) throws Exception {
			if (userType.equalsIgnoreCase("NonSubscribedUser")) {
				viewProfileDetailsByTappingOnProfileIcon(userType);
				viewProfileDetailsOfNormalUserByTappingOnProfilePicture(userType);
				searchingProfileOfValidNormalUserFromDiscover(userType);
				layoutOfProfileScreen(userType);
				optionsPresentInNavigationBarIcon(userType);
				UserShouldRedirectBackToHipiHomeScreen(userType);
				UserShouldRedirectToNotificationScreen(userType);
				UserShouldRedirectedToHiPiSettingsScreen(userType);
				LongpressCheckaddvVideoToHisFavorites(userType);
				deletePublishedVideoAndConfirmationPopupIsDisplayed(userType);
				tapVideoIsMovedToDraft(userType);
				viewAllHisPrivateVideos(userType);
				fullscreenPlayerView(userType);
				backButtonUserIsRedirectedToPrivateListingTab(userType);
				originalSoundsCreatedByTheProfileOwner(userType);
				soundDetailScreen(userType);
				originalSoundInThEOriginalSoundList(userType);
				favouriteTab(userType);
				blankAndNoFavouriteVideos(userType);
				visibleUnderFavouriteVideosSubTab(userType);
				videoIsNoVisibleInFavouriteTab(userType);
				redirectedToCreatorModuleWithTheSelectedSound(userType);
				
				profileIconInCommentsPage(userType);
		}else {
			
		 }
	}	








//------------------------------------------------------------------------------------------------------------------------
		
		
		
		
		
		
		//--------------------------------------Creator Profile-------------------------------------------
		
		
		public void creatorProfile(String userType) throws Exception {
			if(userType.equalsIgnoreCase("NonSubscribedUser")){
				byDefaultNormalUserIsCreatedAsPublic(userType);
				profilePic(userType);
				userName(userType);
				verifyFollowButton(userType);
				
				followerCountAndFollowingCounts(userType);
				viewTheListOfFollowersOfOtherUsers(userType);
				followingOfOtherUsers(userType);
				
				verifyVideosCreatedByOtherUsers(userType);
				userCanViewTheLikedVideo(userType);
				userCanReportPublicAccount(userType);
				CheckLayoutofReportScreen(userType);
				removeTheImage(userType);	
				userCanBlockPublicAccount(userType);
				middleOptionsInProfileScreenSocialStatistics(userType);
				userAbleToSeeVideosOriginalsoundTabs(userType);
				verifyCreatedAndPublishedVideos(userType);
				

				tappingPublishedVideoFullscreenPlayerView(userType);
				tappingBackUserWillNavigateTheUserToVideoListingTab(userType);
				viewAllTheListingOfSoundsCreatedByTheProfile(userType);
				redirectToSoundDetailScreen(userType);
				containedIntheOriginalSoundList(userType);
				redirectToCreatorModuleWithTheSelectedSoundPreSelected(userType);
				
				//invalidInstagramCredentials(userType);
				//invalidFBCredentials(userType);
				//userIsAbleToShareProfileOnInstagram(userType);
				userIsAbleToShareProfileOnFbByTappingShareFBValidCredentials(userType);
				
			}else{
				
			}
		}
		
		
		
		public void byDefaultNormalUserIsCreatedAsPublic(String userType) throws Exception {
		
		extent.HeaderChildNode("Checking by default a normal user is created as public");
		System.out.println("TC_Mobile_001");
		extent.extentLogger("", "TC_Mobile_001");

		if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
			click(AMDOnboardingScreen.objHipiButton, "HiPi");
			Thread.sleep(6000);

		} else {

		}
		
		
		click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
		waitTime(4000);
		if(verifyElementExist(HipiDiscoverPage.objDiscoverScreen, "Discover Screen")){
			

			logger.info("Discover Screen:" + "When ever user click on Discover,Discover Page is displayed");
			extent.extentLoggerPass("Discover Screen:","When ever user click on Discover,Discover Page is displayed");

		} else {
			logger.info(
					"Discover Screen:" + "When ever user click on Discover,Discover Page is not displayed");
			extent.extentLoggerFail("Discover Screen:","When ever user click on Discover,Discover Page is not displayed");
		}
		click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
		waitTime(5000);
		String kundaliBhagya = getParameterFromXML("keyword");
		waitTime(5000);
		type(HipiDiscoverPage.objSearchButton, kundaliBhagya, "Kundali Bhagya");
		waitTime(3000);
		hideKeyboard();
		waitTime(4000);
		click(HipiOtherProfileScreen.objKundaliBhagya, "Kundali Bhagya");
		waitTime(4000);
		if(verifyElementExist(HipiOtherProfileScreen.objProfileDetails, "Profile Details")) {

			logger.info("Profile Details:" + " Profile Details is Visible");
			extent.extentLoggerPass("Profile Details:"," Profile Details is Visible");
			verifyElementExist(HipiOtherProfileScreen.objUserNameText, " User Name");
		
		} else {
			logger.info("Profile Details:" + "Profile Details is not Visible");
			extent.extentLoggerFail("Profile Details:"," Profile Details is not Visible");
		}
		}
		
		public void  profilePic(String userType) throws Exception {
			extent.HeaderChildNode("Checking user is able to view profile pic");
			System.out.println("TC_Mobile_002");
			extent.extentLogger("", "TC_Mobile_002");

			if(verifyElementExist(HipiOtherProfileScreen.objProfilePic, "Profile Pic")){
				logger.info("Profile Pic:" + "User Profile Pic is Visible");
				extent.extentLoggerPass("Profile Pic:","User Profile Pic is Visible");

			} else {
				logger.info("Profile Pic:" + "User Profile Pic is not Visible");
				extent.extentLoggerFail("Profile Pic:","User Profile Pic is not Visible");
			}
		}

		public void userName(String userType) throws Exception {
			extent.HeaderChildNode("Checking  user is able to view Name");
			System.out.println("TC_Mobile_003");
			extent.extentLogger("", "TC_Mobile_003");

			waitTime(4000);
			String userName = getText(HipiOtherProfileScreen.objUserNameText);
			
			if(verifyElementExist(HipiOtherProfileScreen.objUserNameText, "User Name")) {
			
				logger.info("User Name:" + userName);
				extent.extentLoggerPass("User Name:","User Name is Visible");

			} else {
				logger.info("User Name:" + "User Name is not Visible");
				extent.extentLoggerFail("User Name:","User Name is not Visible");
			}
		}
		
		public void verifyFollowButton(String userType) throws Exception {
			
			extent.HeaderChildNode("Checking user is able to view Follow Button");
			System.out.println("TC_Mobile_004");
			waitTime(4000);
			if(verifyElementExist(HipiOtherProfileScreen.objKundaliBhagyaFollow, "Follow Button")){
			
				logger.info("Follow Button:" + "User is able to view Follow Button");
				extent.extentLoggerPass("Follow Button:","User is able to view Follow Button");

			} else {
				logger.info("Follow Button:" + "User is not able to view Follow Button");
				extent.extentLoggerFail("Follow Button:","User is not able to view Follow Button");
			}
		}
		
		

		public void followerCountAndFollowingCounts(String userType) throws Exception {

			extent.HeaderChildNode("Checking Follower Count And Following Counts");
			System.out.println("TC_Mobile_005");
			extent.extentLogger("", "TC_Mobile_004");

			String followerCount = getText(HipiOtherProfileScreen.objFollowersCount);
			
			String followingCount = getText(HipiOtherProfileScreen.objFollowingCount);
			
			if(verifyElementExist(HipiOtherProfileScreen.objKundaliBhagyaFollowers, "Followers Button")){
				logger.info("Followers Count:" +  followerCount);
				extent.extentLoggerPass("Followers Count:","Followers Count is displayed");

			} else {
				logger.info("Followers Count:" + "Followers Count is not displayed");
				extent.extentLoggerFail("Followers Count:","Followers Count is not displayed");
			}
			
			if(verifyElementExist(HipiOtherProfileScreen.objKundaliBhagyaFollowing, "Following")){
				
				logger.info("Following Count:" +  followingCount);
				extent.extentLoggerPass("Following Count:","Following Count is displayed");

			} else {
				logger.info("Following Count:" + "Following Count is not displayed");
				extent.extentLoggerFail("Following Count:","Following Count is not displayed");
			}
		}
		
		public void viewTheListOfFollowersOfOtherUsers(String userType) throws Exception {

			extent.HeaderChildNode("Checking View The List Of Followers Of Other Users");
			System.out.println("TC_Mobile_006");
			extent.extentLogger("", "TC_Mobile_006");

			
			verifyElementPresentAndClick(HipiOtherProfileScreen.objKundaliBhagyaFollowers, "Followers");
			waitTime(4000);
			if(verifyElementExist(HipiOtherProfileScreen.objFollowersList, "Followers List")){
				
				logger.info("Followers List:" +  "When ever click on followers Followers List page is displayed");
				extent.extentLoggerPass("Followers List:","When ever click on followers Followers List page is displayed");
				waitTime(3000);
				click(HipiOtherProfileScreen.objAnyOneOfFollower, "Followers Of One Other Users");
				waitTime(3000);
				if(verifyElementExist(HipiOtherProfileScreen.objProfilePic, "Profile Pic")){
					logger.info("Profile Pic:" + "User Profile Pic is Visible");
					extent.extentLoggerPass("Profile Pic:","User Profile Pic is Visible");
					waitTime(3000);
					click(HipiOtherProfileScreen.objTapOnBackButton, "Back Button");
					waitTime(3000);
					if(verifyElementExist(HipiOtherProfileScreen.objFollowersList, "Followers List")){
						
						logger.info("Followers List:" +  "User Re-directed to  Followers List page ");
						extent.extentLoggerPass("Followers List:","User Re-directed to  Followers List page ");
						waitTime(3000);
						click(HipiOtherProfileScreen.objAgainTapOnBackButton, "Back Button");
						waitTime(3000);
						if(verifyElementExist(HipiOtherProfileScreen.objProfileDetails, "Profile Details")) {

							logger.info("Profile Details:" + "User is re-directed to profile page");
							extent.extentLoggerPass("Profile Details:","User is re-directed to profile page");
							
						} else {
							logger.info("Profile Details:" + "User is not re-directed to profile page");
							extent.extentLoggerFail("Profile Details:","User is not re-directed to profile page");
						}
					} else {
						logger.info("Followers List:" + "User is not Re-directed to  Followers List page ");
						extent.extentLoggerFail("Followers List:","User is not Re-directed to  Followers List page ");
					}
				} else {
					logger.info("Profile Pic:" + "User Profile Pic is not Visible");
					extent.extentLoggerFail("Profile Pic:","User Profile Pic is not Visible");
				}
			} else {
				logger.info("Followers List:" + "When ever click on followers Followers List page is not displayed");
				extent.extentLoggerFail("Followers List:","When ever click on followers Followers List page is not displayed");
			}
		}
		public void followingOfOtherUsers(String userType) throws Exception {
			extent.HeaderChildNode("Checking  following Of Other Users");
			System.out.println("TC_Mobile_007");
			extent.extentLogger("", "TC_Mobile_007");

			click(HipiOtherProfileScreen.objKundaliBhagyaFollowing, "Following Button");
			if(verifyIsElementDisplayed(HipiOtherProfileScreen.objFollowingPage, "Following Page")){
				logger.info("Following Page:" + "When ever click on following,following page is displayed");
				extent.extentLoggerPass("Following Page:","When ever click on following,following page is displayed");

			} else {
				logger.info("Following Page:" + "When ever click on following,following page is not displayed");
				extent.extentLoggerFail("Following Page:","When ever click on following,following page is not displayed");
			}
			click(HipiOtherProfileScreen.objoneoffollowingpersion, "one of following persion");
			if(verifyElementExist(HipiOtherProfileScreen.objProfilePic, "Profile Pic")){
				logger.info("Profile Pic:" + "User Profile Pic is Visible");
				extent.extentLoggerPass("Profile Pic:","User Profile Pic is Visible");
				waitTime(3000);
				click(HipiOtherProfileScreen.objTapOnBackButton, "Back Button");
				waitTime(3000);
				if(verifyElementExist(HipiOtherProfileScreen.objFollowersList, "Followers List")){
					
					logger.info("Followers List:" +  "User Re-directed to  Following List page ");
					extent.extentLoggerPass("Followers List:","User Re-directed to  Following List page ");
					waitTime(3000);
					click(HipiOtherProfileScreen.objAgainTapOnBackButton, "Back Button");
					waitTime(3000);
					if(verifyElementExist(HipiOtherProfileScreen.objProfileDetails, "Profile Details")) {

						logger.info("Profile Details:" + "User is re-directed to profile page");
						extent.extentLoggerPass("Profile Details:","User is re-directed to profile page");
						click(HipiOtherProfileScreen.objTapOnBackButton, "Back Button");
						Back(1);
						if(verifyElementExist(HipiDiscoverPage.objDiscoverScreen, "Discover Screen")){
							

							logger.info("Discover Screen:" + "When ever user click on Back Button,Discover Page is displayed");
							extent.extentLoggerPass("Discover Screen:","When ever user click on Back Button,Discover Page is displayed");

						} else {
							logger.info(
									"Discover Screen:" + "When ever user click on Back Button,Discover Page is not displayed");
							extent.extentLoggerFail("Discover Screen:","When ever user click on Back Button,Discover Page is not displayed");
						}
					} else {
						logger.info("Profile Details:" + "User is not re-directed to profile page");
						extent.extentLoggerFail("Profile Details:","User is not re-directed to profile page");
					}
				} else {
					logger.info("Followers List:" + "User is not Re-directed to  Following List page ");
					extent.extentLoggerFail("Followers List:","User is not Re-directed to  Following List page ");
				}
			} else {
				logger.info("Profile Pic:" + "User Profile Pic is not Visible");
				extent.extentLoggerFail("Profile Pic:","User Profile Pic is not Visible");
			}
		}
		
		public void verifyVideosCreatedByOtherUsers(String userType) throws Exception {
			
			extent.HeaderChildNode("Checking  user can view the list of videos created by other users");
			System.out.println("TC_Mobile_008");
			extent.extentLogger("", "TC_Mobile_008");

			click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
			waitTime(5000);
			String kundaliBhagya = getParameterFromXML("keyword");
			waitTime(5000);
			type(HipiDiscoverPage.objSearchButton, kundaliBhagya, "Kundali Bhagya");
			waitTime(3000);
			hideKeyboard();
			waitTime(4000);
			click(HipiOtherProfileScreen.objKundaliBhagya, "Kundali Bhagya");
			waitTime(5000);
			if(verifyElementExist(HipiOtherProfileScreen.objKundaliBhagyaVideoTab, "Video Tab")){
				logger.info("Video Tab:" + "Video tab is selected by deafult on the lower half of the screen.");
				extent.extentLoggerPass("Video Tab:","Video tab is selected by deafult on the lower half of the screen.");

			} else {
				logger.info("Video Tab:" + "Video tab is not selected by deafult on the lower half of the screen.");
				extent.extentLoggerFail("Video Tab:","Video tab is not selected by deafult on the lower half of the screen.");
			}
			if(verifyElementExist(HipiOtherProfileScreen.objUserCreatedVideos, "Created Videos")){
				
				logger.info("Created Videos:" + "Normal user is able to view video of other users");
				extent.extentLoggerPass("Created Videos:","Normal user is able to view video of other users");

			} else {
				logger.info("Created Videos:" + "Normal user is able to view video of other users");
				extent.extentLoggerFail("Created Videos:","Normal user is able to view video of other users");
			}
		}
		
		public void  userCanViewTheLikedVideo(String userType) throws Exception {
			
			extent.HeaderChildNode("Checking   user can view the liked video");
			System.out.println("TC_Mobile_009");
			extent.extentLogger("", "TC_Mobile_009");

			click(HipiOtherProfileScreen.objClickOnVideo, "One of video");
			waitTime(4000);
			String likeCount = getText(HipiOtherProfileScreen.objLikeCount);
			
			if(verifyElementExist(HipiOtherProfileScreen.objLikeCount, "Liked Icon")){
				logger.info("Liked Icon:" + likeCount);
				extent.extentLoggerPass("Liked Icon:","Like count is displayed");
			} else {
				logger.info("Liked Icon:" + "Like count is not displayed");
				extent.extentLoggerFail("Liked Icon:","Like count is not displayed");
			}
				
			
		}
		
		public void userCanReportPublicAccount(String userType) throws Exception {
			extent.HeaderChildNode("Checking  user Can Report Public Account");
			System.out.println("TC_Mobile_010");
			extent.extentLogger("", "TC_Mobile_010");

			Back(1);
			click(HipiOtherProfileScreen.obj3dotsIcon, "3 dots Icon");
			if(verifyIsElementDisplayed(HipiOtherProfileScreen.objReportProfileBttton, "Report Profile Button")){
				logger.info("Report Profile:" + "When ever click on 3 dots icon Report Profile is displayed");
				extent.extentLoggerPass("Report Profile:","When ever click on 3 dots icon Report Profile is displayed");
			click(HipiOtherProfileScreen.objReportProfileBttton, "Report Profile Button");
			
			waitTime(4000);
			} else {
				logger.info("Report Profile:" + "When ever click on 3 dots icon Report Profile is not displayed");
				extent.extentLoggerFail("Report Profile:","When ever click on 3 dots icon Report Profile is not displayed");
			}
			if(verifyIsElementDisplayed(HipiReportProfileScreen.objReportProfile, "Report Profile Screen")){
				
				logger.info("Report Profile Screen:" + "Report Content Screen is displayed");
				extent.extentLoggerPass("Report Profile Screen:","Report Content Screen is displayed");
				click(HipiReportProfileScreen.objSelectReason, "Select Reason Drpo Down");
				waitTime(3000);
				click(HipiReportProfileScreen.objAntiSocial, "Anti Social");
				waitTime(3000);
				verifyIsElementDisplayed(HipiReportProfileScreen.objAntiSocial);
				waitTime(3000);
				click(HipiReportProfileScreen.objSelectCategory, "Select Category Drpo Down");
				waitTime(3000);
				click(HipiReportProfileScreen.objitscopiedcontent, "it's copied content");
				waitTime(3000);
				String reportprofiledescription = getParameterFromXML("reportProfileDescription");
				click(HipiReportProfileScreen.objDescription, "Description Text field");
				waitTime(3000);
				type(HipiReportProfileScreen.objDescription, reportprofiledescription, "Description Field");
				waitTime(3000);
				click(HipiReportProfileScreen.objSubmitButton, "Submit Button");
				waitTime(5000);
				if(verifyIsElementDisplayed(HipiReportProfileScreen.objSubmitButton, "Submit Button")) {

					logger.info("Reported Profile:" + "user is not able to perform Report Video action");
					extent.extentLoggerFail("Reported Profile:","user is not able to perform Report Video action");
					
				} else {
					logger.info("Reported Profile:" + "user is able to perform Report Video action");
					extent.extentLoggerPass("Reported Profile:","user is able to perform Report Video action");
				}	
				
				
			} else {
				logger.info("Report Profile Screen:" + "Report Content Screen is not displayed");
				extent.extentLoggerFail("Report Profile Screen:","Report Content Screen is not displayed");
			}
		}
		
		public void CheckLayoutofReportScreen(String userType) throws Exception {
			extent.HeaderChildNode("Checking Layout of Report Screen ");
			System.out.println("TC_Mobile_029");
			extent.extentLogger("", "TC_Mobile_029");

			click(HipiOtherProfileScreen.obj3dotsIcon, "3 dots Icon");
			if(verifyIsElementDisplayed(HipiOtherProfileScreen.objReportProfileBttton, "Report Profile Button")){
				logger.info("Report Profile:" + "When ever click on 3 dots icon Report Profile is displayed");
				extent.extentLoggerPass("Report Profile:","When ever click on 3 dots icon Report Profile is displayed");
			click(HipiOtherProfileScreen.objReportProfileBttton, "Report Profile Button");
			
			waitTime(5000);
			} else {
				logger.info("Report Profile:" + "When ever click on 3 dots icon Report Profile is not displayed");
				extent.extentLoggerFail("Report Profile:","When ever click on 3 dots icon Report Profile is not displayed");
			}
			String reportprofiledescription = getParameterFromXML("reportProfileDescription");
			String Maximumcharacters = getText(HipiReportProfileScreen.objMaximumcharactersentered);
			if(verifyIsElementDisplayed(HipiReportProfileScreen.objVerifylayoutofreportcontentscreen, "Report Profile Screen")){
				
				logger.info("Report Profile Screen:" + "Report Content Screen is displayed");
				extent.extentLoggerPass("Report Profile Screen:","Report Content Screen is displayed");
				verifyIsElementDisplayed(HipiReportProfileScreen.objBackVideoListingTab);
				verifyIsElementDisplayed(HipiReportProfileScreen.objReportProfile);
				verifyIsElementDisplayed(HipiReportProfileScreen.objspamArrow);
				verifyIsElementDisplayed(HipiReportProfileScreen.objInappropriateArrow);
				verifyIsElementDisplayed(HipiReportProfileScreen.objDescription);
				verifyIsElementDisplayed(HipiReportProfileScreen.objAttachmenticon);
				type(HipiReportProfileScreen.objDescription, reportprofiledescription, "Description Field");
				verifyIsElementDisplayed(HipiReportProfileScreen.objMaximumcharactersentered);
				logger.info("Maximum characters:" + Maximumcharacters);
				click(HipiReportProfileScreen.objAttachmenticon, "Attachment icon");
				waitTime(5000);
				logger.info("Permission dialog:" + "Allow ZEE5 to access photos, media, and files on your device");
				verifyElementExist(HipiCreateVideoPage.objCreateAllow,
						"Allow ZEE5 to access photos, media, and files on your device?");
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				logger.info("Allow ZEE5 to access photos, media, and files on your device-" + "Allow button");
				Thread.sleep(9000);
				click(HipiReportProfileScreen.objSelectimage, "Select Image");
				waitTime(9000);
				if(verifyIsElementDisplayed(HipiReportProfileScreen.objSelectAttachment,"Select Attachment")) {
					logger.info("Attachment Image:" + "Attachment Image is displayed");
					extent.extentLoggerPass("Attachment Image:","Attachment Image is displayed");
					verifyIsElementDisplayed(HipiReportProfileScreen.objremovedattachment);
				} else {
					logger.info("Attachment Image:" + "Attachment Image is not displayed");
					extent.extentLoggerFail("Attachment Image:","Attachment Image is not displayed");
				}
				
			} else {
				logger.info("Report Profile Screen:" + "Report Content Screen is not displayed");
				extent.extentLoggerFail("Report Profile Screen:","Report Content Screen is not displayed");
			}
		}
		public void  removeTheImage(String userType) throws Exception {
			extent.HeaderChildNode("Checking  remove The Image");
			System.out.println("TC_Mobile_030");
			extent.extentLogger("", "TC_Mobile_030");

			if(verifyIsElementDisplayed(HipiReportProfileScreen.objSelectAttachment,"Select Attachment")) {
				logger.info("Attachment Image:" + "Attachment Image is displayed");
				extent.extentLoggerPass("Attachment Image:","Attachment Image is displayed");
				
			} else {
				logger.info("Attachment Image:" + "Attachment Image is not displayed");
				extent.extentLoggerFail("Attachment Image:","Attachment Image is not displayed");
			}
			click(HipiReportProfileScreen.objremovedattachment, "cross button  on image attached");
			waitTime(3000);
			verifyIsElementDisplayed(HipiReportProfileScreen.objAttachmenticon);
			Back(1);
			waitTime(5000);
		}
		
		
		public void userCanBlockPublicAccount(String userType) throws Exception {
			extent.HeaderChildNode("Checking  user Can Block Public Account");
			System.out.println("TC_Mobile_011");
			extent.extentLogger("", "TC_Mobile_011");

			click(HipiOtherProfileScreen.obj3dotsIcon, "3 dots Icon");
			if(verifyIsElementDisplayed(HipiOtherProfileScreen.objBlockProfile, "Block Profile")){
				logger.info("Block Profile:" + "When ever click on 3 dots icon Block Profile is displayed");
				extent.extentLoggerPass("Block Profile:","When ever click on 3 dots icon Block Profile is displayed");
				click(HipiOtherProfileScreen.objBlockProfile, "Block Profile");
				waitTime(4000);
				verifyIsElementDisplayed(HipiOtherProfileScreen.objBlockPopUP,"Block? This will prevent them from seeing your information on HiPi POP UP");
				waitTime(2000);
				click(HipiOtherProfileScreen.objBlockYesButton, "Yes Button");
				waitTime(6000);
				verifyIsElementDisplayed(HipiOtherProfileScreen.objhaveBlockedTheUser);
				
				click(HipiOtherProfileScreen.objclickdone, "Done Button");
				
			} else {
				logger.info("Block Profile:" + "When ever click on 3 dots icon Block Profile is not displayed");
				extent.extentLoggerFail("Block Profile:","When ever click on 3 dots icon Block Profile is not displayed");
			}
		}
		
		
		public void userIsAbleToShareProfileOnFbByTappingShareFBValidCredentials(String userType) throws Exception {
			
			extent.HeaderChildNode("Checking user Is Able To Share Profile On Fb By Tapping Share FB Valid Credentials ");
			System.out.println("TC_Mobile_012");
			extent.extentLogger("", "TC_Mobile_012");
			
			waitTime(4000);
			//clearFacebookData();
			waitTime(3000);
			Back(3);
			
			click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
			waitTime(5000);
			String kundaliBhagya = getParameterFromXML("keyword");
			waitTime(5000);
			type(HipiDiscoverPage.objSearchButton, kundaliBhagya, "Kundali Bhagya");
			waitTime(3000);
			hideKeyboard();
			waitTime(4000);
			click(HipiOtherProfileScreen.objKundaliBhagya, "Kundali Bhagya");
			waitTime(5000);
			waitTime(5000);
			click(HipiOtherProfileScreen.objKundaliBhagyaShare, "Share icon");	
			waitTime(10000);
			if (verifyElementExist(HipiShareScreen.objFBOption, "FB Option")) {

				logger.info("FB Option: " + "When evre click on share button FB Option is displayed");
				extent.extentLoggerPass("FB Option: ", "When evre click on share button FB Option is displayed");
				waitTime(3000);
			} else {
				logger.info("FB Option: " + "When evre click on share button FB Option is not displayed");
				extent.extentLoggerFail("FB Option: ", "When evre click on share button FB Option is not  displayed");
			}
			waitTime(5000);

			click(HipiShareScreen.objFBOption, "Facebook Option");
			waitTime(10000);
		
			if(verifyIsElementDisplayed(HipiShareScreen.objFBPostbutton, "Post button")){
				click(HipiShareScreen.objFBPostbutton, "Post Button");
				waitTime(30000);
			}else{
//				waitTime(5000);
				click(HipiShareScreen.objLogintoAnotherAccount, "Loginto Another Account");
				waitTime(5000);
				waitTime(3000);

				String FBusername = getParameterFromXML("fbusername");
				waitTime(5000);
				click(HipiShareScreen.objEmailTextfield, "Phone Number Field");
				waitTime(3000);
				Actions a = new Actions(getDriver());
				a.sendKeys(FBusername);
				a.perform();
				waitTime(3000);
				hideKeyboard();
				waitTime(3000);

				String FBpassword = getParameterFromXML("fbPassword");
				waitTime(5000);
				click(HipiShareScreen.objPassWordfield, "PassWord Field");
				waitTime(3000);
				Actions ab = new Actions(getDriver());
				ab.sendKeys(FBpassword);
				ab.perform();
				hideKeyboard();
				waitTime(4000);
				click(HipiShareScreen.objFBLoginButton, "Log In");

//				if(checkElementExist(HipiShareScreen.objSaveButton, "Save Button")){
//					
		//
//					 logger.info("Save Button:" + "When ever click on login button save popup is displayed");
//						extent.extentLoggerPass("Save Button:", "When ever click on login button save popup is displayed");
//						click(HipiShareScreen.objSaveButton, "Save Button");
//					}else {
//						logger.info("Save Button:" + "When ever click on login button save popup is not displayed");
//						extent.extentLoggerFail("Save Button:", "When ever click on login button save popup is not displayed");
//					}
//				
//				click(HipiShareScreen.objContinueButton, "Continue Button");
				
				waitTime(40000);
		//
				click(HipiShareScreen.objFBPostbutton, "Post Button");
				waitTime(15000);
//				waitTime(15000);
//				getDriver().closeApp();
//				waitTime(5000);
//				getDriver().launchApp();
//				waitTime(20000);
//				click(AMDOnboardingScreen.objHipiButton, "HiPi");
//				waitTime(4000);
//				click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
				waitTime(4000);
			}
			

			
		}
		public void  userIsAbleToShareProfileOnInstagram(String userType) throws Exception {
			extent.HeaderChildNode("Checking  user is able to share profile on Instagram by tapping share Instagram Valid credentials");
			System.out.println("TC_Mobile_016");
			extent.extentLogger("", "TC_Mobile_016");
			clearInstagramData();
			
			waitTime(5000);
			click(HipiOtherProfileScreen.objShareButton, "Share icon");
			waitTime(10000);
			click(HipiShareScreen.objInstagramIcon, "Instagram Icon");
			waitTime(5000);
			click(HipiShareScreen.objInstagramSignUpButtin, "Sign UP Button");
			waitTime(5000);
			click(HipiShareScreen.objNoneOfTheAboveButton, "None Of The Above Button");
			waitTime(5000);
			click(HipiShareScreen.objInstagramLoginButtin, "Log IN Button");
			waitTime(5000);

//			 click(HipiCoolGlassesEffect.objInstagramUserName, "UserName Field");

			String instagramUserName = getParameterFromXML("InstagramUserName");
			waitTime(5000);
			click(HipiShareScreen.objInstagramUserName, "User Name Field");
			waitTime(3000);
			Actions a = new Actions(getDriver());
			a.sendKeys(instagramUserName);
			a.perform();

			waitTime(3000);
			hideKeyboard();
			waitTime(3000);

			String instagramPassWord = getParameterFromXML("InstagramPassword");
			waitTime(5000);
			click(HipiShareScreen.objInstagramPassword, "Instagram PassWord Field");
			waitTime(3000);
			Actions ab = new Actions(getDriver());
			ab.sendKeys(instagramPassWord);
			ab.perform();
			hideKeyboard();
			waitTime(4000);

			click(HipiShareScreen.objInstagramClickonLogin, "Log IN Button");
			waitTime(15000);
			getDriver().closeApp();
			waitTime(5000);
			getDriver().launchApp();
			waitTime(20000);
			click(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(4000);
			click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
			waitTime(4000);
			if(verifyElementExist(HipiDiscoverPage.objDiscoverScreen, "Discover Screen")){
				

				logger.info("Discover Screen:" + "When ever user click on Discover,Discover Page is displayed");
				extent.extentLoggerPass("Discover Screen:","When ever user click on Discover,Discover Page is displayed");

			} else {
				logger.info(
						"Discover Screen:" + "When ever user click on Discover,Discover Page is not displayed");
				extent.extentLoggerFail("Discover Screen:","When ever user click on Discover,Discover Page is not displayed");
			}
			click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
			waitTime(5000);
			String kundaliBhagya = getParameterFromXML("keyword");
			waitTime(5000);
			type(HipiDiscoverPage.objSearchButton, kundaliBhagya, "Kundali Bhagya");
			waitTime(3000);
			hideKeyboard();
			waitTime(4000);
			click(HipiOtherProfileScreen.objKundaliBhagya, "Kundali Bhagya");
			waitTime(4000);
		}
		
		public void  bioDescriptionInApopupBioDescriptionExceed4lines(String userTyepe) throws Exception {
			extent.HeaderChildNode("Checking tapping More user is able to view Biodescription in a popup bio description exceed 4 lines");
			System.out.println("TC_Mobile_018");
			extent.extentLogger("", "TC_Mobile_018");

			click(HipiMePage.objMeicon, "Me icon");
			waitTime(3000);
			
			
		}

		
		public void  middleOptionsInProfileScreenSocialStatistics(String userType) throws Exception {
			extent.HeaderChildNode("Checking  middle options in profile screen social statistics");
			System.out.println("TC_Mobile_020");
			extent.extentLogger("", "TC_Mobile_020");

	        String followerCount = getText(HipiOtherProfileScreen.objFollowersCount);
			
			String followingCount = getText(HipiOtherProfileScreen.objFollowingCount);
			
			if(verifyIsElementDisplayed(HipiOtherProfileScreen.objmiddleoptionsprofilescreen, "Middle Options")){
				
				 logger.info("Middle Options:" + "middle options in profile screen social statistics Is displayed");
					extent.extentLoggerPass("Middle Options:", "middle options in profile screen social statistics Is displayed");
					verifyElementExist(HipiOtherProfileScreen.objKundaliBhagyaFollowers, "Followers Button");
					waitTime(3000);
					logger.info("Followers Count:" +  followerCount);
					verifyElementExist(HipiOtherProfileScreen.objKundaliBhagyaFollowing, "Following Button");
					waitTime(3000);
					logger.info("Following Count:" +  followingCount);
//					verifyElementExist(HipiDiscoverPage.objKundaliBhagyaViews, "Views Button");
				}else {
					logger.info("Middle Options:" + "middle options in profile screen social statistics Is not displayed");
					extent.extentLoggerFail("Middle Options:", "middle options in profile screen social statistics Is not displayed");
				}
		} 
		
		public void userAbleToSeeVideosOriginalsoundTabs(String userType) throws Exception {
			
			extent.HeaderChildNode("Checking user Able To See Videos Original sound Tabs ");
			System.out.println("TC_Mobile_021");
			extent.extentLogger("", "TC_Mobile_021");

			if(verifyElementExist(HipiOtherProfileScreen.objKundaliBhagyaVideoTab, "Video Tab")){
				logger.info("Video Tab:" + "Video tab is selected by deafult on the lower half of the screen.");
				extent.extentLoggerPass("Video Tab:","Video tab is selected by deafult on the lower half of the screen.");

			} else {
				logger.info("Video Tab:" + "Video tab is not selected by deafult on the lower half of the screen.");
				extent.extentLoggerFail("Video Tab:","Video tab is not selected by deafult on the lower half of the screen.");
			}
			
			if(verifyIsElementDisplayed(HipiOtherProfileScreen.objOriginalsoundTab, "Original sound")){
				logger.info("Original sound:" + "Original sound tab is displayed");
				extent.extentLoggerPass("Original sound:","Original sound tab is displayed");

			} else {
				logger.info("Original sound:" + "Original sound tab is not displayed");
				extent.extentLoggerFail("Original sound:","Original sound tab is not displayed");
			}
				
		}

		public void verifyCreatedAndPublishedVideos(String userType) throws Exception {
			extent.HeaderChildNode("Checking  user is able to view all created and published videos ");
			System.out.println("TC_Mobile_022");
			extent.extentLogger("", "TC_Mobile_022");

			
	        if(verifyElementExist(HipiOtherProfileScreen.objUserCreatedVideos, "Created Videos")){
				
				logger.info("Created Videos:" + "user is able to view all created and published videos");
				extent.extentLoggerPass("Created Videos:","user is able to view all created and published videos");
				
			} else {
				logger.info("Created Videos:" + "user is not able to view all created and published videos");
				extent.extentLoggerFail("Created Videos:","user is not able to view all created and published videos");
			}
		}
		public void tappingPublishedVideoFullscreenPlayerView(String userType) throws Exception {
			extent.HeaderChildNode("Checking  tapping published video will directed the user to the fullscreen Player view");
			System.out.println("TC_Mobile_023");
			extent.extentLogger("", "TC_Mobile_023");
			Back(2);
			click(HipiMePage.objMeicon, "Me Icon");
			waitTime(15000);
			if(verifyIsElementDisplayed(HipiMePage.objvideotab,"Video Tab")){
				logger.info("Video Tab:" + "Video tab is selected by default on the lower half of the screen");
				extent.extentLoggerPass("Video Tab:","Video tab is selected by default on the lower half of the screen");

			} else {
				logger.info("Video Tab:" + "Video tab is not selected by default on the lower half of the screen");
				extent.extentLoggerFail("Video Tab:","Video tab is not selected by default on the lower half of the screen");
			}	
			waitTime(4000);
			click(HipiMePage.objClickOnVideo, "Video");
			waitTime(10000);
			if(verifyIsElementDisplayed(HipiMePage.objfullscreenPlayer, "Fullscreen Player")){
				logger.info("Fullscreen Player:" + "User is redirect to full-screen player preview.");
				extent.extentLoggerPass("Fullscreen Player:","User is redirect to full-screen player preview.");

			} else {
				logger.info("Fullscreen Player:" + "User is not redirect to full-screen player preview.");
				extent.extentLoggerFail("Fullscreen Player:","User is not redirect to full-screen player preview.");
			}	
				
		}
		public void tappingBackUserWillNavigateTheUserToVideoListingTab(String userType) throws Exception {
			extent.HeaderChildNode("Checking tapping on Back User Will Navigate  To Video ListingTab ");
			System.out.println("TC_Mobile_024");
			extent.extentLogger("", "TC_Mobile_024");

			Swipe("UP", 1);
			waitTime(5000);
			Swipe("DOWN", 1);
			waitTime(5000);
			click(HipiMePage.objBackVideoListingTab, "Back Button");
			if(verifyElementExist(HipiMePage.objVideoTab, "Video Tab")){
				logger.info("Video Tab:" + "User is redirect to 'Video Listing Tab'");
				extent.extentLoggerPass("Video Tab:","User is redirect to 'Video Listing Tab'");

			} else {
				logger.info("Video Tab:" + "User is not redirect to 'Video Listing Tab'");
				extent.extentLoggerFail("Video Tab:","User is not redirect to 'Video Listing Tab'");
			}
			
		}
		
		public void  viewAllTheListingOfSoundsCreatedByTheProfile(String userType) throws Exception {
			extent.HeaderChildNode("Checking user is able to view all the listing of sounds created by the profile owner");
			System.out.println("TC_Mobile_025");
			extent.extentLogger("", "TC_Mobile_025");
			Thread.sleep(5000);
			click(HipiMePage.objOriginalsoundTab, "Original sound");
			if(verifyIsElementDisplayed(HipiMePage.objUserSound, "List Of Sound")){
				
			String profileId =	getAttributValue("text", HipiMePage.objHipiProfileId);
			String userid =	getAttributValue("text", HipiMePage.objUserSound);
				
			String[] str = profileId.split("@");
			String profileid1 = str[1];
			
			if(userid.contains(profileid1)){
				logger.info("List Of Sounds:" + "User is able to view list of sounds in original sound tab");
				extent.extentLoggerPass("List Of Sounds:","User is able to view list of sounds in original sound tab");

			} else {
				logger.info("List Of Sounds:" + "User is not able to view list of sounds in original sound tab");
				extent.extentLoggerFail("List Of Sounds:","User is not able to view list of sounds in original sound tab");
			}
			}
		}
		
		public void redirectToSoundDetailScreen(String userType) throws Exception {
			extent.HeaderChildNode("Checking user redirect To Sound Detail Screen");
			System.out.println("TC_Mobile_026");
			extent.extentLogger("", "TC_Mobile_026");
			click(HipiMePage.objTaponthesound, "Tap on the sound");
			if(verifyIsElementDisplayed(HipiMePage.objThumbnailofthesound, "Thumbnail sound")){
				extent.extentLoggerPass("","user redirect To Sound Detail Screen");
			} else {
				extent.extentLoggerFail("","user not redirect To Sound Detail Screen");
			}
			
		}
		
		public void  containedIntheOriginalSoundList(String userType) throws Exception {
			extent.HeaderChildNode("Checking contained In the Original Sound List");
			System.out.println("TC_Mobile_027");
			extent.extentLogger("", "TC_Mobile_027");

			
			if(verifyIsElementDisplayed(HipiMePage.objThumbnailofthesound, "Thumbnail sound")){
				
				logger.info("Thumbnail of the sound:" + "When evre tap on Thumbnail of the sound is displayed ");
				extent.extentLoggerPass("Thumbnail of the sound:","When evre tap on Thumbnail of the sound is displayed ");

			} else {
				logger.info("Thumbnail of the sound:" + "When evre tap on Thumbnail of the sound is not displayed ");
				extent.extentLoggerFail("Thumbnail of the sound:","When evre tap on Thumbnail of the sound is not displayed ");
			}
//			click(HipiMePage.objAddedfavouritepopup, "Favourite icon");
//			if(verifyElementExist(HipiMePage.objAddedfavouritepopup, "Added favourite")){
				
//				logger.info("Added favourite popup:" + "Added favourite popup is displayed");
//				extent.extentLoggerPass("Added favourite popup:","Added favourite popup is displayed");

//			} else {
//				logger.info("Added favourite popup:" + "Added favourite popup is not displayed");
//				extent.extentLoggerFail("Added favourite popup:","Added favourite popup is not displayed");
//			}
//			click(HipiMePage.objFavouriteicon, "Favourite icon");
			if (verifyIsElementDisplayed(HipiMePage.objRemovieFavourite, "Removie Favourite")) {
				logger.info("Removie favourite popup:" + "Removie favourite popup is displayed");
				extent.extentLoggerPass("Removie favourite popup:","Removie favourite popup is displayed");

			} else {
				logger.info("Removie favourite popup:" + "Removie favourite popup is not displayed");
				extent.extentLoggerWarning("Removie favourite popup:","Removie favourite popup is not displayed");
			}
			click(HipiMePage.objThumbnailofthesound, "Thumbnail of the sound");
			String soundName = getText(HipiMePage.objSoundName);
			if(verifyIsElementDisplayed(HipiMePage.objSoundName, "Sound Name")){
				logger.info("Sound Name:" + soundName);
				extent.extentLoggerPass("Sound Name:","Sound Name is displayed");

			} else {
				logger.info("Sound Name:" + "Sound Name is not displayed");
				extent.extentLoggerFail("Sound Name:","Sound Name is not displayed");
			}
			String soundDuration = getText(HipiMePage.objsoundDuration);
				if(verifyIsElementDisplayed(HipiMePage.objsoundDuration, "Sound Duration")){
					
					logger.info("Sound Duration:" + soundDuration );
					extent.extentLoggerPass("Sound Duration:","Sound Duration is displayed");

				} else {
					logger.info("Sound Duration:" + "Sound Duration is not displayed");
					extent.extentLoggerFail("Sound Duration:","Sound Duration is not displayed");
				}
				if(verifyIsElementDisplayed(HipiMePage.objUsethisSoundIcon, "Use Sound Icon")){
					logger.info("Use Sound Icon:" + "Use Sound Icon is displayed bottom of the screen" );
					extent.extentLoggerPass("Use Sound Icon:","Use Sound Icon is displayed bottom of the screen");

				} else {
					logger.info("Use Sound Icon:" + "Use Sound Icon is not displayed bottom of the screen");
					extent.extentLoggerFail("Use Sound Icon:","Use Sound Icon is not displayed bottom of the screen");
				}
				
			
		}
		
		public void redirectToCreatorModuleWithTheSelectedSoundPreSelected(String userType) throws Exception {
			extent.HeaderChildNode("Checking redirect To Creator Module With The Selected Sound Pre-Selected ");
			System.out.println("TC_Mobile_028");
			extent.extentLogger("", "TC_Mobile_028");

			click(HipiMePage.objUsethisSoundIcon, "Use Sound Icon");

			if (verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo,
					"Allow ZEE5 to take pictures and record video?")) {
				logger.info("Permission dialog:" + "Allow ZEE5 to take pictures and record video?");
				verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow");
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				logger.info("Allow ZEE5 to take pictures and record video-" + "Allow button");
//				Thread.sleep(5000);

				logger.info("Permission dialog:" + "Allow ZEE5 to access photos, media, and files on your device");
				verifyElementExist(HipiCreateVideoPage.objCreateAllow,
						"Allow ZEE5 to access photos, media, and files on your device?");
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				logger.info("Allow ZEE5 to access photos, media, and files on your device-" + "Allow button");
//				Thread.sleep(5000);

//				logger.info("Permission dialog:" + "Allow ZEE5 to record audio");
//				verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?");
//				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
//				logger.info("Allow ZEE5 to record audio-" + "Allow button");
				//Thread.sleep(40000);
				waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
				
				verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
				click(HipiCreateVideoPage.objCreateReadyYes, "yes button");
				logger.info("Ready dialog displayed:" + "yes button");
				Thread.sleep(10000);
			}
			logger.info("Create video page:" + "Create video page displayed");
			
			if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Video Creation screen")) {
				logger.info("Video Creation Screen:" + "User is redirect to Video Creation Screen");
				extent.extentLoggerPass("Video Creation Screen:","User is redirect to Video Creation Screen");
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objSoundName,"Sound Name")){
				logger.info("Sound Name:" + "Video Creation Screen and Sound Name is displayed");
				extent.extentLoggerPass("Sound Name:","Video Creation Screen and Sound Name is displayed");
			} else {
				logger.info("Sound Name:"+ "Video Creation Screen and Sound Name is not displayed");
				extent.extentLoggerFail("Sound Name:","Video Creation Screen and Sound Name is not displayed");
			}
			} else {
				logger.info("Video Creation Screen:"+ "User is not redirect to Video Creation Screen");
				extent.extentLoggerFail("Video Creation Screen:","User is not redirect to Video Creation Screen");
			}
		}
		public void  invalidFBCredentials(String userType) throws Exception {
			extent.HeaderChildNode("Checking unable to share profile on FB by tapping share ");
			System.out.println("TC_Mobile_013");
			extent.extentLogger("", "TC_Mobile_013");
			waitTime(4000);
			clearFacebookData();
			waitTime(3000);
			click(HipiOtherProfileScreen.objShareButton, "Share icon");
			waitTime(10000);
			if (verifyElementExist(HipiShareScreen.objFBOption, "FB Option")) {

				logger.info("FB Option: " + "When evre click on share button FB Option is displayed");
				extent.extentLoggerPass("FB Option: ", "When evre click on share button FB Option is displayed");
				waitTime(3000);
			} else {
				logger.info("FB Option: " + "When evre click on share button FB Option is not displayed");
				extent.extentLoggerFail("FB Option: ", "When evre click on share button FB Option is not  displayed");
			}
			waitTime(5000);

			click(HipiShareScreen.objFBOption, "FaceBook Option");
			waitTime(10000);

//			waitTime(5000);
			click(HipiShareScreen.objLogintoAnotherAccount, "Loginto Another Account");
			waitTime(5000);
			if (verifyElementExist(HipiShareScreen.objFacebookPage, "FaceBook")) {

				logger.info("FaceBook" + "Facebbok login page is displayed");
				extent.extentLoggerPass("FaceBook", "Facebbok login page is displayed");
		
			} else {
				logger.info("FaceBook" + "Facebbok login page is not displayed");
				extent.extentLoggerFail("FaceBook", "Facebbok login page is not displayed");
			}
			waitTime(3000);
//			click(HipiEffectPage.objTryanotherWayButton, "Try another Way Button");

			String FBusername = getParameterFromXML("fbInvalidusername");
			waitTime(5000);
			click(HipiShareScreen.objEmailTextfield, "Phone Number Field");
			waitTime(3000);
			Actions a = new Actions(getDriver());
			a.sendKeys(FBusername);
			a.perform();
//		    type(HipiCoolGlassesEffect.objEmailTextfield,FBusername , "Email Field");
			waitTime(3000);
			hideKeyboard();
			waitTime(3000);

			String FBpassword = getParameterFromXML("fbInvalidPassword");
			waitTime(5000);
			click(HipiShareScreen.objPassWordfield, "PassWord Field");
			waitTime(3000);
			Actions ab = new Actions(getDriver());
			ab.sendKeys(FBpassword);
			ab.perform();
//		    type(HipiCoolGlassesEffect.objPassWordfield, FBpassword, "PassWord Field");
			hideKeyboard();
			waitTime(4000);
			click(HipiShareScreen.objFBLoginButton, "Log In");
			waitTime(5000);
//		    click(HipiCoolGlassesEffect.objSaveButton, "Save Button");
			waitTime(5000);
			if (verifyElementExist(HipiShareScreen.objIncorrectPassword, "Incorrect Password PopUP")) {

				logger.info("Incorrect Password PopUP:" + "Incorrect User Name and Password PopUP is displayed");
				extent.extentLoggerPass("Incorrect Password PopUP:", "Incorrect User Name and Password PopUP is displayed");

			} else {
				logger.info("Incorrect Password PopUP:" + "Incorrect User Name and Password PopUP is not displayed");
				extent.extentLoggerFail("Incorrect Password PopUP:",
						"Incorrect User Name and Password PopUP is not displayed");
			}
			waitTime(15000);
			getDriver().closeApp();
			waitTime(5000);
			getDriver().launchApp();
			waitTime(20000);
			click(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(4000);
			click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
			waitTime(4000);
			if(verifyElementExist(HipiDiscoverPage.objDiscoverScreen, "Discover Screen")){
				

				logger.info("Discover Screen:" + "When ever user click on Discover,Discover Page is displayed");
				extent.extentLoggerPass("Discover Screen:","When ever user click on Discover,Discover Page is displayed");

			} else {
				logger.info(
						"Discover Screen:" + "When ever user click on Discover,Discover Page is not displayed");
				extent.extentLoggerFail("Discover Screen:","When ever user click on Discover,Discover Page is not displayed");
			}
			click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
			waitTime(5000);
			String kundaliBhagya = getParameterFromXML("keyword");
			waitTime(5000);
			type(HipiDiscoverPage.objSearchButton, kundaliBhagya, "Kundali Bhagya");
			waitTime(3000);
			hideKeyboard();
			waitTime(4000);
			click(HipiOtherProfileScreen.objKundaliBhagya, "Kundali Bhagya");
			waitTime(4000);
			
			
		}
		public void  invalidInstagramCredentials(String userType) throws Exception {
			extent.HeaderChildNode("Checking unable to share profile on Instagram  by tapping share ");
			System.out.println("TC_Mobile_017");
			extent.extentLogger("", "TC_Mobile_017");
			Back(3);
			
			click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
			waitTime(5000);
			String kundaliBhagya = getParameterFromXML("keyword");
			waitTime(5000);
			type(HipiDiscoverPage.objSearchButton, kundaliBhagya, "Kundali Bhagya");
			waitTime(3000);
			hideKeyboard();
			waitTime(4000);
			click(HipiOtherProfileScreen.objKundaliBhagya, "Kundali Bhagya");
			waitTime(5000);
			waitTime(5000);
			clearInstagramData();
			waitTime(4000);
			click(HipiOtherProfileScreen.objShareButton, "Share icon");
			waitTime(10000);
			click(HipiShareScreen.objInstagramIcon, "Instagram Icon");
			waitTime(5000);
			click(HipiShareScreen.objInstagramSignUpButtin, "Sign UP Button");
			waitTime(5000);

			click(HipiShareScreen.objNoneOfTheAboveButton, "None Of The Above Button");
			waitTime(5000);
			click(HipiShareScreen.objInstagramLoginButtin, "Log IN Button");
			waitTime(5000);
//			 click(HipiCoolGlassesEffect.objInstagramUserName, "UserName Field");

			String invalidinstagramUserName = getParameterFromXML("invalidInstagramUserName");
			waitTime(5000);
			click(HipiShareScreen.objInstagramUserName, "User Name Field");
			waitTime(3000);
			Actions a = new Actions(getDriver());
			a.sendKeys(invalidinstagramUserName);
			a.perform();

			waitTime(3000);
			hideKeyboard();
			waitTime(3000);

			String invalidinstagramPassWord = getParameterFromXML("invalidInstagramPassword");
			waitTime(5000);
			click(HipiShareScreen.objInstagramPassword, "Instagram PassWord Field");
			waitTime(3000);
			Actions ab = new Actions(getDriver());
			ab.sendKeys(invalidinstagramPassWord);
			ab.perform();
			hideKeyboard();
			waitTime(4000);

			click(HipiShareScreen.objInstagramClickonLogin, "Log IN Button");

			waitTime(9000);

			if (verifyElementExist(HipiShareScreen.objIncorrectPasswordInstagram, "Incorrect Password Instagram")) {

				logger.info("Incorrect Password PopUP:" + "Incorrect User Name and Password PopUP is displayed");
				extent.extentLoggerPass("Incorrect Password PopUP:", "Incorrect User Name and Password PopUP is displayed");

			} else {
				logger.info("Incorrect Password PopUP:" + "Incorrect User Name and Password PopUP is not displayed");
				extent.extentLoggerFail("Incorrect Password PopUP:",
						"Incorrect User Name and Password PopUP is not displayed");
			}

			waitTime(15000);
			getDriver().closeApp();
			waitTime(5000);
			getDriver().launchApp();
			waitTime(20000);
			click(AMDOnboardingScreen.objHipiButton, "HiPi");
			waitTime(4000);
			click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
			waitTime(4000);
			if(verifyElementExist(HipiDiscoverPage.objDiscoverScreen, "Discover Screen")){
				

				logger.info("Discover Screen:" + "When ever user click on Discover,Discover Page is displayed");
				extent.extentLoggerPass("Discover Screen:","When ever user click on Discover,Discover Page is displayed");

			} else {
				logger.info(
						"Discover Screen:" + "When ever user click on Discover,Discover Page is not displayed");
				extent.extentLoggerFail("Discover Screen:","When ever user click on Discover,Discover Page is not displayed");
			}
			click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
			waitTime(5000);
			String kundaliBhagya1 = getParameterFromXML("keyword");
			waitTime(5000);
			type(HipiDiscoverPage.objSearchButton, kundaliBhagya1, "Kundali Bhagya");
			waitTime(3000);
			hideKeyboard();
			waitTime(4000);
			click(HipiOtherProfileScreen.objKundaliBhagya, "Kundali Bhagya");
			waitTime(4000);
			
			
			
		}	
		

		public static void clearInstagramData() 
		{
				String cmd = "adb shell pm clear com.instagram.android";
				try {
					Runtime.getRuntime().exec(cmd);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}



		
		
		
		
		//--------------------------------------------------------------------------------------------------------------
		
		
		
		

		//--------------------------------------------------Filter-------------------------------------------------------------------

		
		public void ValidatingFilter(String userType) throws Exception{
			if(userType.equalsIgnoreCase("NonSubscribedUser")){
	    		ValidateFilterUnusedByDefault(userType);
	    		ValidateFilterPage(userType);
	    		ValidateFilterCategory(userType);
	    		ValidateFilterDownloaded(userType);
	    		ValidateFilterDownloadButtonUndisplayed(userType);
	    		ValidateFilterClickedUsed(userType);
	    		ValidateAddFilterBackButtonNavigateToCreateVideoPage(userType);
	    		ValidateFilterUnderRecent(userType);
	    		ValidateCreateVideoPageRedirected(userType);
	    		ValidateAbleToCheckFilterOverlay(userType);
	    		ValidateAbleToRemoveFilter(userType);
	    		ValidateFilterUsedWhenVideoCreated(userType);
	    		ValidateFilterCanBeCancelled(userType);
	    	}
		}
		
		
		
		

		
		public void ValidateFilterUnusedByDefault(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if by default,filter is selected as normal");
			System.out.println("TC_Mobile_06");
			extent.extentLogger("", "TC_Mobile_06");
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(5000);
			click(AMDHipi.objcreatevideo, "Create video button");
			Thread.sleep(5000);
			if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo, "Allow ZEE5 to take pictures and record video?"))
			{
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				Thread.sleep(5000);
			}
			else
			{
				logger.info("Allow ZEE5 to take pictures and record video? unavailable");
			}
				
			if(verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to access photos, media, and files on your device?"))
			{
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				Thread.sleep(5000);
			}
			else
			{
				logger.info("Allow ZEE5 to access photos, media, and files on your device? unavailable");
			}
			
			if(verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?"))
			{
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");	
				Thread.sleep(40000);
			}
			else
			{
				logger.info("Allow ZEE5 to record audio? unavailable");
			}
			waitForElementDisplayed(HipiCreateVideoPage.objCreateReadyDialog,20);//added
			if(verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog"))
			{
				click(HipiCreateVideoPage.objCreateReadyYes, "yes button");	
				Thread.sleep(10000);
			}
			else
			{
				logger.info("Ready dialog unavailable");
			}
			
			if(verifyElementExist(HipiCreateVideoPage.objfilterbuttondisabledbydefault, "Filter disabled"))
			{
				logger.info("By default,filter is selected as normal");
				extent.extentLoggerPass("Create video page:","By default,filter is selected as normal");
			}
			else
			{
				logger.info("By default,filter is not selected as normal");
				extent.extentLoggerFail("Create video page:","By default,filter is not selected as normal");
			}
		}
		
		public void ValidateFilterPage(String userType) throws Exception		
		{
			extent.HeaderChildNode("Check layout of filter screen");
			System.out.println("TC_Mobile_01");
			extent.extentLogger("", "TC_Mobile_01");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objfilter, "Add filter button");	
			if(verifyElementExist(HipiCreateVideoPage.objaddfilterdialog, "Add filter dialog"))
			{
				logger.info("Add filter dialog available");
				extent.extentLoggerPass("Create video page:","Add filter dialog available");	
			}
			else
			{
				logger.info("Add filter dialog unavailable");
				extent.extentLoggerFail("Create video page:","Add filter dialog unavailable");
			}
			if(verifyElementExist(HipiCreateVideoPage.objaddfilterbackbtn, "Back button"))
			{
				logger.info("Back button available");
				extent.extentLoggerPass("Create video page:","Back button available");	
			}
			else
			{
				logger.info("Back button unavailable");
				extent.extentLoggerFail("Create video page:","Back button unavailable");
			}
			if(verifyElementExist(HipiCreateVideoPage.objaddfilteralltab, "All tab"))
			{
				logger.info("All tab available");
				extent.extentLoggerPass("Create video page:","All tab available");	
			}
			else
			{
				logger.info("All tab unavailable");
				extent.extentLoggerFail("Create video page:","All tab unavailable");
			}
			if(verifyElementExist(HipiCreateVideoPage.objaddfilterrecenttab, "Recent tab"))
			{
				logger.info("Recent tab available");
				extent.extentLoggerPass("Create video page:","Recent tab available");	
			}
			else
			{
				logger.info("Recent tab unavailable");
				extent.extentLoggerFail("Create video page:","Recent tab unavailable");
			}
			if(verifyElementExist(HipiCreateVideoPage.objaddclearctabtn, "Clear cta button"))
			{
				logger.info("Clear cta button available");
				extent.extentLoggerPass("Create video page:","Clear cta button available");	
			}
			else
			{
				logger.info("Clear cta button unavailable");
				extent.extentLoggerFail("Create video page:","Clear cta button unavailable");
			}
		}
			
		public void ValidateFilterCategory(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if user is able to tap on different filter categories");
			System.out.println("TC_Mobile_02");
			extent.extentLogger("", "TC_Mobile_02");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objfiltercategoryprimary, "Primary category");
			if(verifyElementExist(HipiCreateVideoPage.objfiltercategoryprimaryfiltercamera, "Camera filter"))
			{
				logger.info("Primary category clicked");
				extent.extentLoggerPass("Create video page:","Primary category clicked");	
			}
			else
			{
				logger.info("Primary category not clicked");
				extent.extentLoggerFail("Create video page:","Primary category not clicked");
			}
			click(HipiCreateVideoPage.objfiltercategoryparty, "Party category");
			if(verifyElementExist(HipiCreateVideoPage.objfiltercategorypartyfilteropening, "Opening filter"))
			{
				logger.info("Party category clicked");
				extent.extentLoggerPass("Create video page:","Party category clicked");	
			}
			else
			{
				logger.info("Party category not clicked");
				extent.extentLoggerFail("Create video page:","Party category not clicked");
			}
			click(HipiCreateVideoPage.objfiltercategorylovebeauty, "Love and beauty category");
			if(verifyElementExist(HipiCreateVideoPage.objfiltercategorylovebeautyfilterdhak, "Dhak filter"))
			{
				logger.info("Love and beauty category clicked");
				extent.extentLoggerPass("Create video page:","Love and beauty category clicked");	
			}
			else
			{
				logger.info("Love and beauty category not clicked");
				extent.extentLoggerFail("Create video page:","Love and beauty category not clicked");
			}
			click(HipiCreateVideoPage.objfiltercategoryaction, "Action category");
			if(verifyElementExist(HipiCreateVideoPage.objfiltercategoryactionfilterblink, "Blink filter"))
			{
				logger.info("Action category clicked");
				extent.extentLoggerPass("Create video page:","Action category clicked");	
			}
			else
			{
				logger.info("Action category not clicked");
				extent.extentLoggerFail("Create video page:","Action category not clicked");
			}
			click(HipiCreateVideoPage.objfiltercategoryretro, "Retro category");
			if(verifyElementExist(HipiCreateVideoPage.objfiltercategoryfilterglitch, "Glitch filter"))
			{
				logger.info("Retro category clicked");
				extent.extentLoggerPass("Create video page:","Retro category clicked");	
			}
			else
			{
				logger.info("Retro category not clicked");
				extent.extentLoggerFail("Create video page:","Retro category not clicked");
			}
		}
		
		public void ValidateFilterDownloaded(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if user is able to download filter, by tapping on download pin present on each filter");
			System.out.println("TC_Mobile_03");
			extent.extentLogger("", "TC_Mobile_03");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objfiltercategoryprimary, "Primary category");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objfiltercategorydownloadbtn, "Download pin");
			Thread.sleep(5000);
			if(verifyElementExist(HipiCreateVideoPage.objfirstfilterafterdownloadfinish, "Filter downloaded"))
			{
				logger.info("User is able to download filter, by tapping on download pin");
				extent.extentLoggerPass("Create video page:","User is able to download filter, by tapping on download pin");	
			}
			else
			{
				logger.info("User is unable to download filter, by tapping on download pin");
				extent.extentLoggerFail("Create video page:","User is unable to download filter, by tapping on download pin");
			}
			
		}

		public void ValidateFilterDownloadButtonUndisplayed(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if download pin is not visible on the filter which is downloaded");
			System.out.println("TC_Mobile_04");
			extent.extentLogger("", "TC_Mobile_04");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objfiltercategoryparty, "Party category");
			Thread.sleep(5000);
			while(verifyIsElementDisplayed(HipiCreateVideoPage.objfiltercategorydownloadbtn, "Download button"))
			{
				click(HipiCreateVideoPage.objfiltercategorydownloadbtn, "Download button");
				Thread.sleep(10000);
			}
			if(verifyIsElementDisplayed(HipiCreateVideoPage.objfiltercategorydownloadbtn,"Download button"))
			{
				logger.info("Download pin is visible on the filter which is downloaded");
				extent.extentLoggerFail("Create video page:","Download pin is visible on the filter which is downloaded");
				
			}
			else
			{
				logger.info("Download pin is not visible on the filter which is downloaded");
				extent.extentLoggerPass("Create video page:","Download pin is not visible on the filter which is downloaded");	
			}
			
		}

		public void ValidateFilterClickedUsed(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if user is able to preview the downloaded filter");
			System.out.println("TC_Mobile_05");
			extent.extentLogger("", "TC_Mobile_05");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objfiltercategoryprimary, "Primary category");
			Thread.sleep(10000);//changed 
			
			if(verifyElementExist(HipiCreateVideoPage.objfirstfilterafterdownloadfinish, "Filter preview"))
			{
				logger.info("User is able to preview the downloaded filter");
				extent.extentLoggerPass("Create video page:","User is able to preview the downloaded filter");	
			}
			else
			{
				logger.info("User is unable to preview the downloaded filter");
				extent.extentLoggerFail("Create video page:","User is unable to preview the downloaded filter");
			}
			
		}

		public void ValidateAddFilterBackButtonNavigateToCreateVideoPage(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if user is redirected to Video creation screen, when tapped back of filter screen");
			System.out.println("TC_Mobile_07");
			extent.extentLogger("", "TC_Mobile_07");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objaddfilterbackbtn, "Back button");
			Thread.sleep(5000);
			
			if(verifyElementExist(HipiCreateVideoPage.objfilter, "Add Filter button"))
			{
				logger.info("User is redirected to Video creation screen, when tapped back of filter screen");
				extent.extentLoggerPass("Create video page:","User is redirected to Video creation screen, when tapped back of filter screen");	
			}
			else
			{
				logger.info("User is not redirected to Video creation screen, when tapped back of filter screen");
				extent.extentLoggerFail("Create video page:","User is not redirected to Video creation screen, when tapped back of filter screen");
			}
			
		}

		public void ValidateFilterUnderRecent(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if user is able to view recently applied filter");
			System.out.println("TC_Mobile_08");
			extent.extentLogger("", "TC_Mobile_08");
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objfilter, "Add filter button");
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objfiltercategoryretro, "Retro category");//added
			Thread.sleep(5000);//added
			verifyElementPresentAndClick(HipiCreateVideoPage.objfiltercategoryfilterglitch, "Glitch filter");//added
			Thread.sleep(10000);//added
			verifyElementPresentAndClick(HipiCreateVideoPage.objfirstfilterafterdownloadfinish, "Filter");//changed 
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objaddfilterbackbtn, "Back button");
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record video button");
			Thread.sleep(1000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record video button");
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objfilter, "Add Filter button");
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objaddfilterrecenttab, "Recent tab");
			Thread.sleep(5000);
			if(verifyElementExist(HipiCreateVideoPage.objrecentfilterused, "Filter"))
			{
				logger.info("User view recently applied filter");
				extent.extentLoggerPass("Create video page:","User view recently applied filter");	
			}
			else
			{
				logger.info("User unable view recently applied filter");
				extent.extentLoggerFail("Create video page:","User unable view recently applied filter");
			}
			
		}

		public void ValidateCreateVideoPageRedirected(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if user is redirected to Video creation screen, when tapped anywhere on or above the filter section");
			System.out.println("TC_Mobile_09");
			extent.extentLogger("", "TC_Mobile_09");
			Thread.sleep(5000);
			Coordinate();
			Thread.sleep(5000);
			if(verifyElementExist(HipiCreateVideoPage.objfilter, "Add Filter button"))
			{
				logger.info("User is redirected to Video creation screen, when tapped anywhere on or above the filter section");
				extent.extentLoggerPass("Create video page:","User is redirected to Video creation screen, when tapped anywhere on or above the filter section");	
			}
			else
			{
				logger.info("User is not redirected to Video creation screen, when tapped anywhere on or above the filter section");
				extent.extentLoggerFail("Create video page:","User is not redirected to Video creation screen, when tapped anywhere on or above the filter section");
			}
		}

		public void Coordinate() throws Exception {
			AndroidTouchAction touch = new AndroidTouchAction(getDriver());
			int heightOfScreen = getDriver().manage().window().getSize().getHeight();
			int widthOfScreen = getDriver().manage().window().getSize().getWidth();
			int x = widthOfScreen / 2;
			int y = heightOfScreen / 2;
			touch.tap(PointOption.point(x, y)).perform();
			}

		public void ValidateAbleToCheckFilterOverlay(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if user is able to select a filter and its selected filter preview/overlay is displayed");
			System.out.println("TC_Mobile_010");
			extent.extentLogger("", "TC_Mobile_010");
			Thread.sleep(5000);
			if(verifyElementExist(HipiCreateVideoPage.objfilterdownloadedused, "Filter enabled"))
			{
				logger.info("User is able to select a filter and its selected filter preview/overlay is displayed");
				extent.extentLoggerPass("Create video page:","User is able to select a filter and its selected filter preview/overlay is displayed");	
			}
			else
			{
				logger.info("User unable to select a filter and its selected filter preview/overlay is displayed");
				extent.extentLoggerFail("Create video page:","User unable to select a filter and its selected filter preview/overlay is displayed");
			}
		}

		public void ValidateAbleToRemoveFilter(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if user is able to remove[undo] the selected filter");
			System.out.println("TC_Mobile_011");
			extent.extentLogger("", "TC_Mobile_011");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objfilter, "Add Filter button");
			Thread.sleep(10000);
			click(HipiCreateVideoPage.objfiltercategoryretro, "Retro category");//added
			Thread.sleep(5000);//added
			click(HipiCreateVideoPage.objaddclearctabtn, "Clear button");
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(5000);
			if(verifyElementExist(HipiCreateVideoPage.objfilterdownloadedremoved, "Filter disabled"))
			{
				logger.info("User is able to remove[undo] the selected filter");
				extent.extentLoggerPass("Create video page:","User is able to remove[undo] the selected filter");	
			}
			else
			{
				logger.info("User unable to remove[undo] the selected filter");
				extent.extentLoggerFail("Create video page:","User unable  to remove[undo] the selected filter");
			}
			
		}
		public void ValidateFilterUsedWhenVideoCreated(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if user is able to create a video by applying any filter type");
			System.out.println("TC_Mobile_014");
			extent.extentLogger("", "TC_Mobile_014");
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objdeletebtn, "Delete button");//added
			Thread.sleep(5000);//added
			verifyElementPresentAndClick(HipiCreateVideoPage.objdeleteyesbtn, "Yes button");//added
			Thread.sleep(5000);//added
			verifyElementPresentAndClick(HipiCreateVideoPage.objfilter, "Add Filter button");
			Thread.sleep(10000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objfirstfilterafterdownloadfinish, "Filter");
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objaddfilterbackbtn, "Back button");
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record video button");
			Thread.sleep(1000);//added
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record video button");
			Thread.sleep(5000);
			if(verifyElementExist(HipiCreateVideoPage.objfilterdownloadedused, "Filter enabled"))
			{
				logger.info("User is able to create a video by applying any filter type");
				extent.extentLoggerPass("Create video page:","User is able to create a video by applying any filter type");	
			}
			else
			{
				logger.info("User unable to create a video by applying any filter type");
				extent.extentLoggerFail("Create video page:","User unable to create a video by applying any filter type");
			}
			
		}
		public void ValidateFilterCanBeCancelled(String userType) throws Exception
		{
			extent.HeaderChildNode("Check if user is able to remove the filters applied");
			System.out.println("TC_Mobile_018");
			extent.extentLogger("", "TC_Mobile_018");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objfilter, "Add Filter button");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objaddclearctabtn, "Clear button");
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(5000);
			if(verifyElementExist(HipiCreateVideoPage.objfilterdownloadedremoved, "Filter disabled"))
			{
				logger.info("User is able to remove the filters applied");
				extent.extentLoggerPass("Create video page:","User is able to remove the filters applied");	
			}
			else
			{
				logger.info("User unable to remove the filters applied");
				extent.extentLoggerFail("Create video page:","User unable  to remove the filters applied");
			}
		}
		
		
		
		
		
		
		
		
		
		
		

		
		

//----------------------------------------------------------------------------------------------------------------------
		
		
		
		
		//--------------------------------------------------Filter pre shoot-------------------------------------------------------------------
		
		
		
			public void ValidatingFilterPreShoot(String userType) throws Exception{
				
		      	if(userType.equalsIgnoreCase("NonSubscribedUser")){
		      		ValidateAddFilterDialog(userType);
		      	}else{
		      		
		      	}
			}
		
		

			public void ValidateAddFilterDialog(String userType) throws Exception
			{
				extent.HeaderChildNode("Before shooting Check if on tapping Filters Icon user is navigated to Filters screen");
				System.out.println("TC_Mobile_01");
				extent.extentLogger("", "TC_Mobile_01");
				Thread.sleep(5000);
				click(AMDHipi.objHipiIcon, "Hipi icon");
				Thread.sleep(5000);
				click(AMDHipi.objcreatevideo, "Create video button");
				Thread.sleep(5000);
				if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo, "Allow ZEE5 to take pictures and record video?"))
				{
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");
					Thread.sleep(5000);
				}
				else
				{
					logger.info("Allow ZEE5 to take pictures and record video? unavailable");
				}
					
				if(verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to access photos, media, and files on your device?"))
				{
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");
					Thread.sleep(5000);
				}
				else
				{
					logger.info("Allow ZEE5 to access photos, media, and files on your device? unavailable");
				}
				
				if(verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?"))
				{
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");	
					Thread.sleep(40000);
				}
				else
				{
					logger.info("Allow ZEE5 to record audio? unavailable");
				}
				waitForElementDisplayed(HipiCreateVideoPage.objCreateReadyDialog,20);//added
				if(verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog"))
				{
					click(HipiCreateVideoPage.objCreateReadyYes, "yes button");	
					Thread.sleep(10000);
				}
				else
				{
					logger.info("Ready dialog unavailable");
				}
				waitForElementDisplayed(HipiCreateVideoPage.objfilter,20);//added
				click(HipiCreateVideoPage.objfilter, "Add Filter button");
				Thread.sleep(5000);
				if(verifyElementExist(HipiCreateVideoPage.objaddfilterdialog, "Add filter dialog"))
				{
					logger.info("Create Video Page:"+ "Tapping Filters Icon user is navigated to Filters screen");
					extent.extentLoggerPass("Create Video Page:", "Tapping Filters Icon user is navigated to Filters screen");
				}
				else
				{
					logger.info("Create Video Page:"+ "Tapping Filters Icon user is not navigated to Filters screen");
					extent.extentLoggerFail("Create Video Page:", "Tapping Filters Icon user is not navigated to Filters screen");
				}
		}

			
			
			
			
			
			//----------------------------------------------------------------------------------------------------------------------------------
			
			//--------------------------------------------------Creator tool-------------------------------------------------------------------

			
			public void ValidatingCreatorTool(String userType) throws Exception{
				
				if(userType.equalsIgnoreCase("NonSubscribedUser")){
		      		ValidateAddLanguageDialog(userType);
		      	}else{
		      		
		      	}
			}
			
			

			public void ValidateAddLanguageDialog(String userType) throws Exception
			{
				extent.HeaderChildNode("Check if the user is unable to post a video untill user do not select a language for video posting");
				System.out.println("TC_Mobile_01");
				extent.extentLogger("", "TC_Mobile_01");
				Thread.sleep(5000);
				click(AMDHipi.objHipiIcon, "Hipi icon");
				Thread.sleep(5000);
				click(AMDHipi.objcreatevideo, "Create video button");
				Thread.sleep(5000);
				if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo, "Allow ZEE5 to take pictures and record video?"))
				{
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");
					Thread.sleep(5000);
				}
				else
				{
					logger.info("Allow ZEE5 to take pictures and record video? unavailable");
				}
					
				if(verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to access photos, media, and files on your device?"))
				{
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");
					Thread.sleep(5000);
				}
				else
				{
					logger.info("Allow ZEE5 to access photos, media, and files on your device? unavailable");
				}
				
				if(verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?"))
				{
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");	
					Thread.sleep(50000);//added
				}
				else
				{
					logger.info("Allow ZEE5 to record audio? unavailable");
				}
				waitForElementDisplayed(HipiCreateVideoPage.objCreateReadyDialog,20);//added
				if(verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog"))
				{
					click(HipiCreateVideoPage.objCreateReadyYes, "yes button");	
					Thread.sleep(10000);
				}
				else
				{
					logger.info("Ready dialog unavailable");
				}
				click(HipiCreateVideoPage.objrecordbtn, "Record video button");
				Thread.sleep(20000);//added
				waitForElementDisplayed(HipiCreateVideoPage.objPostbutton, 20);//added
				click(HipiCreateVideoPage.objPostbutton, "Post button");
				Thread.sleep(5000);//added
				waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
				type(HipiCreateVideoPage.objadddescription,"Desc"+GeneratingRandomString(7),"Description added");
				Thread.sleep(5000);
				hideKeyboard();
				Thread.sleep(5000);
				click(HipiCreateVideoPage.objgenreclick, "Genre");
				click(HipiCreateVideoPage.objtcheckbox, "Checkbox");
				click(HipiCreateVideoPage.objpostbtn, "Post button");
				Thread.sleep(5000);
				if(verifyElementExist(HipiCreateVideoPage.objlanguagedialog, "Language dialog"))
				{
					logger.info("Create Video Page:"+ "User is unable to post a video untill user do not select a language for video posting");
					extent.extentLoggerPass("Create Video Page:", "User is unable to post a video untill user do not select a language for video posting");
				}
				else
				{
					logger.info("Create Video Page:"+ "User is able to post a video untill user do not select a language for video posting");
					extent.extentLoggerFail("Create Video Page:", "User is able to post a video untill user do not select a language for video posting");
				}
				click(HipiCreateVideoPage.objlanguageokbtn, "Yes button");
				Thread.sleep(5000);
				click(HipiCreateVideoPage.objlanguage, "English button");
				Thread.sleep(5000);
				click(HipiCreateVideoPage.objpostbtn, "Post button");
				Thread.sleep(5000);
			}
			

			
			
			
			
			
			//----------------------------------------------------------------------------------------------------------------
			
			//--------------------------------------------------Background Effect-------------------------------------------------------------------
	
			
			public void ValidatingBackgroundEffect(String userType) throws Exception{
				
		       	if(userType.equalsIgnoreCase("NonSubscribedUser")){
	        		ValidateVideoEditPage(userType);
	        	}else{
		      		
		      	}
			}
			
			
			
			public void ValidateVideoEditPage(String userType) throws Exception
			{
				extent.HeaderChildNode("Check layout of Video Edit Screen ");
				System.out.println("TC_Mobile_01");
				extent.extentLogger("", "TC_Mobile_01");
				Thread.sleep(5000);
				click(AMDHipi.objHipiIcon, "Hipi icon");
				Thread.sleep(5000);
				click(AMDHipi.objcreatevideo, "Create video button");
				Thread.sleep(5000);
				if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo, "Allow ZEE5 to take pictures and record video?"))
				{
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");
					Thread.sleep(5000);
				}
				else
				{
					logger.info("Allow ZEE5 to take pictures and record video? unavailable");
				}
					
				if(verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to access photos, media, and files on your device?"))
				{
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");
					Thread.sleep(5000);
				}
				else
				{
					logger.info("Allow ZEE5 to access photos, media, and files on your device? unavailable");
				}
				
				if(verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?"))
				{
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");	
					Thread.sleep(40000);
				}
				else
				{
					logger.info("Allow ZEE5 to record audio? unavailable");
				}
				waitForElementDisplayed(HipiCreateVideoPage.objCreateReadyDialog,20);//added
				if(verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog"))
				{
					click(HipiCreateVideoPage.objCreateReadyYes, "yes button");	
					Thread.sleep(10000);
				}
				else
				{
					logger.info("Ready dialog unavailable");
				}
				click(HipiCreateVideoPage.objrecordbtn, "Record video button");
				Thread.sleep(20000);
				if(verifyElementExist(HipiCreateVideoPage.objeditvideobackbtn, "Back button"))
				{
					logger.info("Create Video Page:"+ "Back button available");
					extent.extentLoggerPass("Create Video Page:", "Back button available");
				}
				else
				{
					logger.info("Create Video Page:"+ "Back button unavailable");
					extent.extentLoggerFail("Create Video Page:", "Back button unavailable");
				}
				if(verifyElementExist(HipiCreateVideoPage.objaddmusicbtneditvideopage, "Add music button"))
				{
					logger.info("Create Video Page:"+ "Add music button available");
					extent.extentLoggerPass("Create Video Page:", "Add music button available");
				}
				else
				{
					logger.info("Create Video Page:"+ "Add music button unavailable");
					extent.extentLoggerFail("Create Video Page:", "Add music button unavailable");
				}
				if(verifyElementExist(HipiCreateVideoPage.objtrim, "Trim button"))
				{
					logger.info("Create Video Page:"+ "Trim button available");
					extent.extentLoggerPass("Create Video Page:", "Trim button available");
				}
				else
				{
					logger.info("Create Video Page:"+ "Trim button unavailable");
					extent.extentLoggerFail("Create Video Page:","Trim button unavailable");
				}
				if(verifyElementExist(HipiCreateVideoPage.objvolumebtn, "Volume button"))
				{
					logger.info("Create Video Page:"+ "Volume button available");
					extent.extentLoggerPass("Create Video Page:", "Volume button available");
				}
				else
				{
					logger.info("Create Video Page:"+ "Volume button unavailable");
					extent.extentLoggerFail("Create Video Page:","Volume button unavailable");
				}
				if(verifyElementExist(HipiCreateVideoPage.objpost, "Post button"))
				{
					logger.info("Create Video Page:"+ "Post button available");
					extent.extentLoggerPass("Create Video Page:", "Post button available");
				}
				else
				{
					logger.info("Create Video Page:"+ "Post button unavailable");
					extent.extentLoggerFail("Create Video Page:","Post button unavailable");
				}
			}

			
			

	
	

			
			
	//--------------------------------------------------------------------------------------------------------------------
			
			
			
			
			
			// ----------------------------------Effects Details--------------------------------

			
			public void ValidatingEffectsDetailsPage(String userType) throws Exception {
				if (!userType.equals("Guest")) {
					
				
				NavigateToCoolGlasses(userType);
				effectNameOnEffectDetailsScreen(userType);
				clickingOnEffectThumbnail(userType);
				relatedVideosForExistingEffectUsed(userType);
				createVideoForExistingEffect(userType);
				//shareEffectSMSOnSend(userType);
				shareEffectOnFB(userType);

//		//		getDriver().closeApp();
//		//		waitTime(5000);
//		//		getDriver().launchApp();
//		//		waitTime(20000);
//				BackToFeedScreen();
//		//		click(AMDOnboardingScreen.objHipiButton, "HiPi");
//				NavigateToCoolGlasses(userType);
//
//			
//				shareEffectSMSOnCancel(userType);
//
//				getDriver().closeApp();
//				waitTime(5000);
//				getDriver().launchApp();
//				waitTime(20000);
//
//				click(AMDOnboardingScreen.objHipiButton, "HiPi");
//				NavigateToCoolGlasses(userType);
//
//				invalidFBcredentialsshareeffectvideoonFB(userType);
//
//				getDriver().closeApp();
//				waitTime(5000);
//				getDriver().launchApp();
//				waitTime(20000);
//
//				click(AMDOnboardingScreen.objHipiButton, "HiPi");
//				NavigateToCoolGlasses(userType);
//
//				Instagram(userType);
//
//				getDriver().closeApp();
//				waitTime(5000);
//				getDriver().launchApp();
//				waitTime(20000);
//
//				click(AMDOnboardingScreen.objHipiButton, "HiPi");
//				NavigateToCoolGlasses(userType);
//				invalidInstagram(userType);
//				
				}else {
					
				}
			}

			
			
			
			public void NavigateToCoolGlasses(String userType) throws Exception {
				  
		     	if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
					click(AMDOnboardingScreen.objHipiButton, "HiPi");
					Thread.sleep(6000);

				} else {

				}
				
				waitTime(9000);
				click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
				waitTime(5000);
				click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
				waitTime(5000);
//				click(HipiDiscoverPage.objDiscoverSearchButton, "Search");
//				waitTime(3000);
//				String coolglass = getParameterFromXML("coolglass");
				waitTime(5000);
				type(HipiDiscoverPage.objSearchButton, "cool glass", "cool glass");
				waitTime(3000);
				hideKeyboard();
				waitTime(3000);
				click(HipiDiscoverPage.objThumbnail1, "fun video");
				waitTime(3000);

				if (verifyElementExist(HipiEffectPage.objCoolGlassEffect, "Effect Screen")) {

					logger.info("Effect: " + " Cool Galsses Effect Screen is displayed");
					extent.extentLoggerPass("Effect:", " Cool Galsses Effect Screen is displayed");
					click(HipiEffectPage.objCoolGlassEffect, "Effect used-cool Glasses");
				} else {
					logger.info("Effect: " + " Cool Galsses Effect Screen is not displayed");
					extent.extentLoggerFail("Effect: ", " Cool Galsses Effect Screen is displayed");
				}
				
			}

			public void effectNameOnEffectDetailsScreen(String userType) throws Exception {

				extent.HeaderChildNode("Checking tap on effect in video description and view effect name on  Effect details screen ");
				System.out.println("TC_Mobile_001");
				extent.extentLogger("", "TC_Mobile_001");

				waitTime(4000);
				verifyElementExist(HipiEffectPage.objEffectDetailScreen, "Effect detail screen");
				waitTime(3000);
				String coolGlass = getText(HipiEffectPage.objCoolGlassesName);
				if (verifyElementExist(HipiEffectPage.objCoolGlassesName, "Effect Name")) {
					logger.info("Effect Name:" + coolGlass);
					extent.extentLoggerPass("Effect Name:", "Cool Glasses Effect Name is displayed ");
				} else {
					logger.info("Effect Name:");
					extent.extentLoggerFail("Effect Name:", "Cool Glasses Effect Name is not displayed");

				}
			}
			public void clickingOnEffectThumbnail(String userType) throws Exception {
				
				extent.HeaderChildNode("Check if user is able to preview Effect by clicking on Effect thumbnail");
				System.out.println("TC_Mobile_002");
				extent.extentLogger("", "TC_Mobile_002");
				
				click(HipiEffectPage.objEffectThumbnail, "Effect Thumbnail");
				waitTime(3000);
				if(verifyIsElementDisplayed(HipiEffectPage.objThumbnailImageScreen, "Thumbnail Image Screen")){

					logger.info("Thumbnail Image Screen:" + "Thumbnail Image Screen is displayed when ever click on Effect Thumbnail");
					extent.extentLoggerPass("Thumbnail Image Screen:", "Thumbnail Image Screen is displayed when ever click on Effect Thumbnail");

				} else {
					logger.info("Thumbnail Image Screen:" + "Thumbnail Image Screen is not displayed when ever click on Effect Thumbnail");
					extent.extentLoggerFail("Thumbnail Image Screen:", "Thumbnail Image Screen is not displayed when ever click on Effect Thumbnail");
				}
			}

			public void relatedVideosForExistingEffectUsed(String userType) throws Exception {

				extent.HeaderChildNode("Checking related videos for existing effect used");
				System.out.println("TC_Mobile_003");
				extent.extentLogger("", "TC_Mobile_003");
				waitTime(4000);
				Back(1);
				waitTime(5000);
				if (verifyElementExist(HipiEffectPage.objRelatedVideosEffects, " Related Videos ")) {

					logger.info("Related Videos Effects: " + "Related Videos Effects is displayed");
					extent.extentLoggerPass("Related Videos Effects: ", "Related Videos Effects is displayed");

				} else {
					logger.info("Related Videos Effects: " + "Related Videos Effects is not displayed");
					extent.extentLoggerFail("Related Videos Effects: ", "Related Videos Effects is not displayed");
				}

				waitTime(5000);
			}
			public void createVideoForExistingEffect(String userType) throws Exception {
				extent.HeaderChildNode("Check if user is able to create video for existing effect");
				System.out.println("TC_Mobile_004");
				extent.extentLogger("", "TC_Mobile_004");
				
				click(HipiEffectPage.objUseThisEffect, "Use This Effect");
				waitTime(5000);
				if (verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo,
						"Allow ZEE5 to take pictures and record video?")) {
					logger.info("Permission dialog:" + "Allow ZEE5 to take pictures and record video?");
					verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow");
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");
					logger.info("Allow ZEE5 to take pictures and record video-" + "Allow button");
					Thread.sleep(5000);

					logger.info("Permission dialog:" + "Allow ZEE5 to access photos, media, and files on your device");
					verifyElementExist(HipiCreateVideoPage.objCreateAllow,
							"Allow ZEE5 to access photos, media, and files on your device?");
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");
					logger.info("Allow ZEE5 to access photos, media, and files on your device-" + "Allow button");
					Thread.sleep(5000);

					logger.info("Permission dialog:" + "Allow ZEE5 to record audio");
					verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?");
					click(HipiCreateVideoPage.objCreateAllow, "Allow button");
					logger.info("Allow ZEE5 to record audio-" + "Allow button");
					//Thread.sleep(40000);
					waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
					verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
					click(HipiCreateVideoPage.objCreateReadyYes, "yes button");
					logger.info("Ready dialog displayed:" + "yes button");
					Thread.sleep(10000);
				}
				logger.info("Create video page:" + "Create video page displayed");
			    verifyElementPresentAndClick(HipiCreateVideoPage.objrecording," Recording");
				 
						 waitTime(20000);
							verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
							waitTime(15000);
							waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
							verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
							String postDescription = "Desc"+GeneratingRandomString(7);
							type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
							waitTime(3000);
							hideKeyboard();
							waitTime(3000);
							verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
							verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
							verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
									" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
							verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "posthipi");// saveasdraft
							waitTime(4000);
							verifyIsElementDisplayed(HipiCreateVideoPage.objVideoUploadPopup, "Video Upload Popup");
							click(HipiCreateVideoPage.objGoToFeedButton, "Go To Feed Button");
							
							waitTime(60000);
							verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
							for (int i = 0; i <= 50; i++) {
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
							String effectName = getText(HipiEffectPage.objCoolGlassEffect);

							extent.extentLogger("", "effect used : "+effectName);
							if (verifyElementExist(HipiEffectPage.objCoolGlassEffect, "effect name")) {
								logger.info("user is able to create new video using same  effect");
								extent.extentLoggerPass("videoscreated", "user is able to create new video using effect");
							} else {
								extent.extentLoggerFail("", "user is not able to create new video using effect");
							}

			}
			public void shareEffectOnFB(String userType) throws Exception {
				extent.HeaderChildNode("Checking valid FB credentials is able to share effect on FB");
				System.out.println("TC_Mobile_005");
				extent.extentLogger("", "TC_Mobile_005");
				//clearFacebookData();
				click(HipiEffectPage.objCoolGlassEffect, "Effect used-cool Glasses");

				waitTime(10000);
				click(HipiEffectPage.objShareIcon, "Share icon");	
				waitTime(10000);
				if (verifyElementExist(HipiShareScreen.objFBOption, "FB Option")) {

					logger.info("FB Option: " + "When evre click on share button FB Option is displayed");
					extent.extentLoggerPass("FB Option: ", "When evre click on share button FB Option is displayed");
					waitTime(3000);
				} else {
					logger.info("FB Option: " + "When evre click on share button FB Option is not displayed");
					extent.extentLoggerFail("FB Option: ", "When evre click on share button FB Option is not  displayed");
				}
				waitTime(10000);

				click(HipiShareScreen.objFBOption, "Facebook Option");
				waitTime(10000);
				
				if(verifyIsElementDisplayed(HipiShareScreen.objFBPostbutton, "Post button")){
					click(HipiShareScreen.objFBPostbutton, "Post Button");
					waitTime(10000);
				}else{
					click(HipiEffectPage.objNoneOfTheAbove, "None Of The Above");
//					if(verifyElementExist(HipiCoolGlassesEffect.objFacebookPage, "FaceBook")){
//						
//						 logger.info("Facebook" + "Facebook login page is displayed");
//							extent.extentLoggerPass("Facebook", "Facebook login page is displayed");
//							waitTime(3000);
//						}else {
//							logger.info("Facebook" + "Facebook login page is not displayed");
//							extent.extentLoggerFail("Facebook", "Facebook login page is not displayed");
//						}
//					waitTime(5000);
//					click(HipiShareScreen.objLogintoAnotherAccount, "Loginto Another Account");
					waitTime(5000);
//					click(HipiCoolGlassesEffect.objTryanotherWayButton, "Try another Way Button");
					waitTime(3000);

					String FBusername = getParameterFromXML("fbusername");
					waitTime(5000);
					click(HipiShareScreen.objEmailTextfield, "Phone Number Field");
					waitTime(3000);
					Actions a = new Actions(getDriver());
					a.sendKeys(FBusername);
					a.perform();
//				    type(HipiCoolGlassesEffect.objEmailTextfield,FBusername , "Email Field");
					waitTime(3000);
					hideKeyboard();
					waitTime(3000);

					String FBpassword = getParameterFromXML("fbPassword");
					waitTime(5000);
					click(HipiShareScreen.objPassWordfield, "PassWord Field");
					waitTime(3000);
					Actions ab = new Actions(getDriver());
					ab.sendKeys(FBpassword);
					ab.perform();
//				    type(HipiCoolGlassesEffect.objPassWordfield, FBpassword, "PassWord Field");
					hideKeyboard();
					waitTime(4000);
					click(HipiShareScreen.objFBLoginButton, "Log In");

//					if(checkElementExist(HipiShareScreen.objSaveButton, "Save Button")){
//						
			//
//						 logger.info("Save Button:" + "When ever click on login button save popup is displayed");
//							extent.extentLoggerPass("Save Button:", "When ever click on login button save popup is displayed");
//							click(HipiShareScreen.objSaveButton, "Save Button");
//						}else {
//							logger.info("Save Button:" + "When ever click on login button save popup is not displayed");
//							extent.extentLoggerFail("Save Button:", "When ever click on login button save popup is not displayed");
//						}
					waitTime(25000);

					click(HipiShareScreen.objFBPostbutton, "Post Button");
					waitTime(10000);
					
				}
				

			}


			public void shareEffectSMSOnCancel(String userType) throws Exception {
				extent.HeaderChildNode(
						"Checking  unable to share Effect to following people with a message by tapping on 'cancel'");
				System.out.println("TC_Mobile_006");
				extent.extentLogger("", "TC_Mobile_006");

				waitTime(10000);
				click(HipiEffectPage.objShareIcon, "Share icon");
				waitTime(5000);
				if (verifyElementExist(HipiShareScreen.objShareDeailsScreen, "Share Deails Screen")) {

					logger.info("Share Deails Screen:" + "When ever click on share button share deails screen is displayed");
					extent.extentLoggerPass("Share Deails Screen:",
							"When ever click on share button share deails screen is displayed");

				} else {
					logger.info(
							"Share Deails Screen:" + "When ever click on share button share deails screen is not displayed");
					extent.extentLoggerFail("Share Deails Screen:",
							"When ever click on share button share deails screen is not displayed");
				}

				click(HipiShareScreen.objSMS, "SMS Button");

				waitTime(9000);
				click(HipiShareScreen.objCancleButton, "Cancle Button");
//				
//		    if(verifyElementExist(HipiEffectPage.objEffectdetailscreen, "Effect Screen")){
//			    	
//			    	logger.info("Effect: " + "  Cool Galsses Effect Screen is not displayed");
//					extent.extentLoggerPass("Effect:", " Cool Galsses Effect Screen is displayed");
//					
//				}else {
//					logger.info("Effect: " + " Cool Galsses Effect Screen is not displayed");
//					extent.extentLoggerFail("Effect: ", " Cool Galsses Effect Screen is displayed");
//				}
////				 
//				 if(verifyElementExist(HipiCoolGlassesEffect.objStartChatButton, "Effect Screen")){
////				    	
//				    	logger.info("Effect: " + "  Cool Galsses Effect Screen is not displayed");
//						extent.extentLoggerPass("Effect:", " Cool Galsses Effect Screen is displayed");
//						
//					}else {
//						logger.info("Effect: " + " Cool Galsses Effect Screen is not displayed");
//						extent.extentLoggerFail("Effect: ", " Cool Galsses Effect Screen is displayed");
//					}
			}

			public void shareEffectSMSOnSend(String userType) throws Exception {
				extent.HeaderChildNode(
						"Checking  unable to share Effect to following people with a message by tapping on 'Send'");
				System.out.println("TC_Mobile_007");
				extent.extentLogger("", "TC_Mobile_007");
				click(HipiEffectPage.objCoolGlassEffect, "Effect used-cool Glasses");

//				NavigateToCoolGlasses(userType);
				waitTime(10000);
				click(HipiEffectPage.objShareIcon, "Share icon");
				waitTime(5000);
				 if (verifyElementExist(HipiShareScreen.objShareDeailsScreen, "Share Deails Screen")) {

						logger.info("Share Deails Screen:" + "When ever click on share button share deails screen is displayed");
						extent.extentLoggerPass("Share Deails Screen:",
								"When ever click on share button share deails screen is displayed");

					} else {
						logger.info(
								"Share Deails Screen:" + "When ever click on share button share deails screen is not displayed");
						extent.extentLoggerFail("Share Deails Screen:",
								"When ever click on share button share deails screen is not displayed");
					}

			 
				click(HipiShareScreen.objSMS, "SMS Button");
				waitTime(4000);
//				 click(HipiCoolGlassesEffect.objSelectContact, "Contect");

				click(HipiShareScreen.objNewMessage, "New Message");
				waitTime(4000);

				click(HipiShareScreen.objnumberIcon, "Number Icon");

				waitTime(4000);
				String enterphonenumber = getParameterFromXML("enterPhonenumber");

				type(HipiShareScreen.objtypeNumber, enterphonenumber, "Enter Number");
				waitTime(5000);
				click(HipiShareScreen.objclickonTICK, "Tick Button");
				waitTime(9000);
				click(HipiShareScreen.objSendButton, "Send Button");

//				waitTime(5000);
				hideKeyboard();
				waitTime(9000);

				if (verifyElementExist(HipiShareScreen.objchecksendlink, "Link")) {

					logger.info("Link:" + "Effect Link is displayed");
					extent.extentLoggerPass("Link:", "Effect Link is displayed");

					
				} else {
					logger.info("Link:" + "Effect Link is not displayed ");
					extent.extentLoggerFail("Link:", "Effect Link is not displayed ");
				}
				click(HipiShareScreen.objchecksendlink, "SMS Link");
				waitTime(15000);
				  
				if (verifyElementExist(HipiEffectPage.objEffectDetailScreen, "Effect detail screen")) {

					logger.info("Effect detail screen:" + "Cool Glass Effect screen is displayed");
					extent.extentLoggerPass("Effect detail screen:", "Cool Glass Effect screen is displayed");
					
				} else {
					logger.info("Effect detail screen:" + "Cool Glass Effect screen is not  displayed");
					extent.extentLoggerPass("Effect detail screen:", "Cool Glass Effect screen is not displayed");
				}
				
//				try {
//					String	cmd = "adb shell am start -n com.graymatrix.did/com.zee5.splash.SplashActivity";
//					Process p = Runtime.getRuntime().exec(cmd);
//					BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//				} catch (Exception e) {
//				}
//				waitTime(30000);
//				String	cmd = "adb shell am start -n com.facebook.katana/com.facebook.adscomposer.AdsComposerActivity-Facebook";
//				Process p = Runtime.getRuntime().exec(cmd);
//				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			}

			public void invalidFBcredentialsshareeffectvideoonFB(String userType) throws Exception {
				extent.HeaderChildNode("Checking invalid FB credentials is not able to share effect video on FB");
				System.out.println("TC_Mobile_008");
				extent.extentLogger("", "TC_Mobile_008");
				clearFacebookData();

				waitTime(5000);
				click(HipiEffectPage.objShareIcon, "Share icon");
				waitTime(10000);
				if (verifyElementExist(HipiShareScreen.objFBOption, "FB Option")) {

					logger.info("FB Option: " + "When evre click on share button FB Option is displayed");
					extent.extentLoggerPass("FB Option: ", "When evre click on share button FB Option is displayed");
					waitTime(3000);
				} else {
					logger.info("FB Option: " + "When evre click on share button FB Option is not displayed");
					extent.extentLoggerFail("FB Option: ", "When evre click on share button FB Option is not  displayed");
				}
				waitTime(5000);

				click(HipiShareScreen.objFBOption, "FaceBook Option");
				waitTime(10000);

//				waitTime(5000);
				click(HipiShareScreen.objLogintoAnotherAccount, "Loginto Another Account");
				waitTime(5000);
				if (verifyElementExist(HipiShareScreen.objFacebookPage, "FaceBook")) {

					logger.info("FaceBook" + "Facebbok login page is displayed");
					extent.extentLoggerPass("FaceBook", "Facebbok login page is displayed");
			
				} else {
					logger.info("FaceBook" + "Facebbok login page is not displayed");
					extent.extentLoggerFail("FaceBook", "Facebbok login page is not displayed");
				}
				waitTime(3000);
//				click(HipiEffectPage.objTryanotherWayButton, "Try another Way Button");

				String FBusername = getParameterFromXML("fbInvalidusername");
				waitTime(5000);
				click(HipiShareScreen.objEmailTextfield, "Phone Number Field");
				waitTime(3000);
				Actions a = new Actions(getDriver());
				a.sendKeys(FBusername);
				a.perform();
//			    type(HipiCoolGlassesEffect.objEmailTextfield,FBusername , "Email Field");
				waitTime(3000);
				hideKeyboard();
				waitTime(3000);

				String FBpassword = getParameterFromXML("fbInvalidPassword");
				waitTime(5000);
				click(HipiShareScreen.objPassWordfield, "PassWord Field");
				waitTime(3000);
				Actions ab = new Actions(getDriver());
				ab.sendKeys(FBpassword);
				ab.perform();
//			    type(HipiCoolGlassesEffect.objPassWordfield, FBpassword, "PassWord Field");
				hideKeyboard();
				waitTime(4000);
				click(HipiShareScreen.objFBLoginButton, "Log In");
				waitTime(5000);
//			    click(HipiCoolGlassesEffect.objSaveButton, "Save Button");
				waitTime(5000);
				if (verifyElementExist(HipiShareScreen.objIncorrectPassword, "Incorrect Password PopUP")) {

					logger.info("Incorrect Password PopUP:" + "Incorrect User Name and Password PopUP is displayed");
					extent.extentLoggerPass("Incorrect Password PopUP:", "Incorrect User Name and Password PopUP is displayed");

				} else {
					logger.info("Incorrect Password PopUP:" + "Incorrect User Name and Password PopUP is not displayed");
					extent.extentLoggerFail("Incorrect Password PopUP:",
							"Incorrect User Name and Password PopUP is not displayed");
				}
			}

		//	
//			public void twitter() throws Exception {
//				extent.HeaderChildNode("Checking  valid Twitter credentials is able to share effect video on Twitter");
//				 System.out.println("TC_Mobile_0011");
//				 click(HipiCoolGlassesEffect.objShareicon, "Share icon");
//				 waitTime(10000);
//				click(HipiCoolGlassesEffect.objTweetIcon, "Twitter");
//				waitTime(5000);
//				
//			}
			public void Instagram(String userType) throws Exception {

				extent.HeaderChildNode("Checking  valid Instagram credentials is able to share effect video on Instagram");
				System.out.println("TC_Mobile_009");
				extent.extentLogger("", "TC_Mobile_009");

				clearInstagramData();
				
				waitTime(10000);
				click(HipiEffectPage.objShareIcon, "Share icon");
				waitTime(10000);
				click(HipiShareScreen.objInstagramIcon, "Instagram Icon");
				waitTime(5000);
				click(HipiShareScreen.objInstagramSignUpButtin, "Sign UP Button");
				waitTime(5000);
				click(HipiShareScreen.objNoneOfTheAboveButton, "None Of The Above Button");
				waitTime(5000);
				click(HipiShareScreen.objInstagramLoginButtin, "Log IN Button");
				waitTime(5000);

//				 click(HipiCoolGlassesEffect.objInstagramUserName, "UserName Field");

				String instagramUserName = getParameterFromXML("InstagramUserName");
				waitTime(5000);
				click(HipiShareScreen.objInstagramUserName, "User Name Field");
				waitTime(3000);
				Actions a = new Actions(getDriver());
				a.sendKeys(instagramUserName);
				a.perform();

				waitTime(3000);
				hideKeyboard();
				waitTime(3000);

				String instagramPassWord = getParameterFromXML("InstagramPassword");
				waitTime(5000);
				click(HipiShareScreen.objInstagramPassword, "Instagram PassWord Field");
				waitTime(3000);
				Actions ab = new Actions(getDriver());
				ab.sendKeys(instagramPassWord);
				ab.perform();
				hideKeyboard();
				waitTime(4000);

				click(HipiShareScreen.objInstagramClickonLogin, "Log IN Button");

				waitTime(15000);

			}

			public void invalidInstagram(String userType) throws Exception {
				extent.HeaderChildNode("Checking  invalid Instagram credentials is able to share effect video on Instagram");
				System.out.println("TC_Mobile_010");
				extent.extentLogger("", "TC_Mobile_010");
				clearInstagramData();
				waitTime(10000);
				click(HipiEffectPage.objShareIcon, "Share icon");
				waitTime(10000);
				click(HipiShareScreen.objInstagramIcon, "Instagram Icon");
				waitTime(5000);
				click(HipiShareScreen.objInstagramSignUpButtin, "Sign UP Button");
				waitTime(5000);

				click(HipiShareScreen.objNoneOfTheAboveButton, "None Of The Above Button");
				waitTime(5000);
				click(HipiShareScreen.objInstagramLoginButtin, "Log IN Button");
				waitTime(5000);
//				 click(HipiCoolGlassesEffect.objInstagramUserName, "UserName Field");

				String invalidinstagramUserName = getParameterFromXML("invalidInstagramUserName");
				waitTime(5000);
				click(HipiShareScreen.objInstagramUserName, "User Name Field");
				waitTime(3000);
				Actions a = new Actions(getDriver());
				a.sendKeys(invalidinstagramUserName);
				a.perform();

				waitTime(3000);
				hideKeyboard();
				waitTime(3000);

				String invalidinstagramPassWord = getParameterFromXML("invalidInstagramPassword");
				waitTime(5000);
				click(HipiShareScreen.objInstagramPassword, "Instagram PassWord Field");
				waitTime(3000);
				Actions ab = new Actions(getDriver());
				ab.sendKeys(invalidinstagramPassWord);
				ab.perform();
				hideKeyboard();
				waitTime(4000);

				click(HipiShareScreen.objInstagramClickonLogin, "Log IN Button");

				waitTime(9000);

				if (verifyElementExist(HipiShareScreen.objIncorrectPasswordInstagram, "Incorrect Password Instagram")) {

					logger.info("Incorrect Password PopUP:" + "Incorrect User Name and Password PopUP is displayed");
					extent.extentLoggerPass("Incorrect Password PopUP:", "Incorrect User Name and Password PopUP is displayed");

				} else {
					logger.info("Incorrect Password PopUP:" + "Incorrect User Name and Password PopUP is not displayed");
					extent.extentLoggerFail("Incorrect Password PopUP:",
							"Incorrect User Name and Password PopUP is not displayed");
				}

				waitTime(5000);
			}
		
		
		
		
		
		
		
	//---------------------------------------------------------------------------------------------------------------------
			
			
	
			//--------------------------------Sound Detail Page-----------------------------------------
			
			
			public void ValidatingSoundDetailsPage(String userType) throws Exception {
				if (userType.equalsIgnoreCase("NonSubscribedUser")) {
					CreateVideoWithOriginalSoundDialogue(userType);
					verifyOriginalSoundDialogue(userType);
					createVideoWithExistingSoundDialogue(userType);
					viewVideoCreatedByExistingSoundDialogue(userType);
					SoundCheckLayoutOfSoundDetailScreen(userType);
					tappingBackInSoundDetailScreen(userType);
					verifySoundTitleIsDisplayed(userType);
					soundVerifyTheSoundIsAddedToProfileFavourites(userType);
					removeOriginalSoundFromFavourite(userType);
					soundIsRemovedFromProfileFavourites(userType);
					viewRelatedVideosForNewExistingSound(userType);
					viewVideoCountOnTappingSoundOnNewlyCreatedVideo(userType);
					createdTheVideoByOriginalSound(userType);
					createdTheVideoByDialogueExistingSound(userType);
					createVideoForExistingSoundEffect(userType);
					//messageByTappingOnSendSoundDetailsPage(userType);
					shareSoundUsingSocialMedia(userType);
					//messageByTappingOnCancel(userType);

				}else {
					
				}

			}		
			
	
				public void CreateVideoWithOriginalSoundDialogue(String userType) throws Exception {
					

					extent.HeaderChildNode("Sound Check if user is able to Create a video with original sound/dialogue");
			        System.out.println("TC_Mobile_001");
			        extent.extentLogger("", "TC_Mobile_001");
			        
			    	

			        if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
			    		click(AMDOnboardingScreen.objHipiButton, "HiPi");
			    		Thread.sleep(6000);

			    	} else {

			    	}
			        
			        verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"Create Button");

			        if (verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo,
			    			"Allow ZEE5 to take pictures and record video?")) {
			    		logger.info("Permission dialog:" + "Allow ZEE5 to take pictures and record video?");
			    		verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow");
			    		click(HipiCreateVideoPage.objCreateAllow, "Allow button");
			    		logger.info("Allow ZEE5 to take pictures and record video-" + "Allow button");
			    		Thread.sleep(5000);

			    		logger.info("Permission dialog:" + "Allow ZEE5 to access photos, media, and files on your device");
			    		verifyElementExist(HipiCreateVideoPage.objCreateAllow,
			    				"Allow ZEE5 to access photos, media, and files on your device?");
			    		click(HipiCreateVideoPage.objCreateAllow, "Allow button");
			    		logger.info("Allow ZEE5 to access photos, media, and files on your device-" + "Allow button");
			    		Thread.sleep(5000);

			    		logger.info("Permission dialog:" + "Allow ZEE5 to record audio");
			    		verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?");
			    		click(HipiCreateVideoPage.objCreateAllow, "Allow button");
			    		logger.info("Allow ZEE5 to record audio-" + "Allow button");
			    		//Thread.sleep(40000);
			    		waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
			    		verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
			    		click(HipiCreateVideoPage.objCreateReadyYes, "yes button");
			    		logger.info("Ready dialog displayed:" + "yes button");
			    		Thread.sleep(10000);
			    	}
 	logger.info("Create video page:" + "Create video page displayed");
 	
     verifyElementPresentAndClick(HipiCreateVideoPage.objrecording,"Recording Button");

		 waitTime(20000);
	
			if (verifyElementExist(HipiCreateVideoPage.objVideoEditScreen, "Video Edit Screen")) {

				logger.info("Vide oEdit Screen: " + " When ever recording complet video edit screen is displayed ");
				extent.extentLoggerPass("Video Edit Screen:", "When ever recording complet video edit screen is displayed ");
			} else {
				logger.info("Video Edit Screen: " + " When ever recording complet video edit screen is not displayed ");
				extent.extentLoggerFail("Video Edit Screen:",
						"When ever recording complet video edit screen is not displayed ");
			}

			verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
			waitTime(15000);
			waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
			verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
			String postDescription = "Desc"+GeneratingRandomString(7);
			type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
			waitTime(3000);
			hideKeyboard();
			waitTime(3000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
			verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
			verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
					" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
			verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "posthipi");// saveasdraft
			waitTime(4000);
			verifyIsElementDisplayed(HipiCreateVideoPage.objVideoUploadPopup, "Video Upload Popup");
			click(HipiCreateVideoPage.objGoToFeedButton, "Go To Feed Button");
			
			waitTime(60000);
//		
			verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
			for (int i = 0; i <= 100; i++) {
				scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
				if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
					Thread.sleep(4000);
					Back(1);
					Thread.sleep(4000);
					verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
				} else {
					verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), "Video");
					click(HipiCreateVideoPage.objselectfirstimage, "First video");
					waitTime(8000);
					break;
				}
			}
	}
	public void  verifyOriginalSoundDialogue(String userType) throws Exception {
		

		extent.HeaderChildNode("Sound Verify if user is able to view video created by original sound/dialogue");
     System.out.println("TC_Mobile_002");
     extent.extentLogger("", "TC_Mobile_002");
		
     String soundName = getText(HipiHomePage.objSoundName);
		if(verifyIsElementDisplayed(HipiHomePage.objSoundName, "Sound Name")){
			logger.info("Sound Name:" + soundName);
			extent.extentLoggerPass("Sound Name:","Original Sound is displayed");
		} else {
			logger.info("Sound Name:" + "Original Sound is displayed");
			extent.extentLoggerFail("Sound Name:","Original Sound is displayed");
		}	
	}
	
	public void createVideoWithExistingSoundDialogue(String userType) throws Exception {
		
		extent.HeaderChildNode("Sound Check if user is able to Create a video with existing sound/dialogue");
     System.out.println("TC_Mobile_003");
     extent.extentLogger("", "TC_Mobile_003");
		Back(2);
     verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"Create Button");

     waitTime(5000);
     
     logger.info("Create video page:" + "Create video page displayed");
     
     verifyElementPresentAndClick(HipiSoundDetailPage.objAddMusicButton, "Add Music Button");
     waitTime(4000);
     click(HipiSoundDetailPage.objSearchTextBox, "Search Text Box");
     waitTime(3000);
    String beautifulYouSong = getParameterFromXML("SearchSong");
     type(HipiSoundDetailPage.objSearchTextBox, beautifulYouSong , "Beautiful You Song");
     waitTime(4000);
     hideKeyboard();
     click(HipiSoundDetailPage.objBeautifulYouSong, "Beautiful You Song");
     waitTime(3000);
     click(HipiSoundDetailPage.objClickBeautifulYouSong, "Beautiful You Song Again");
     waitTime(5000);
     click(HipiSoundDetailPage.objClickPostTick, "Post Tick");
     waitTime(3000);
     verifyElementPresentAndClick(HipiCreateVideoPage.objrecording,"Recording Button");
		 waitTime(20000);
			if (verifyElementExist(HipiCreateVideoPage.objVideoEditScreen, "Video Edit Screen")) {
				logger.info("Vide oEdit Screen: " + " When ever recording complet video edit screen is displayed ");
				extent.extentLoggerPass("Video Edit Screen:", "When ever recording complet video edit screen is displayed ");
			} else {
				logger.info("Video Edit Screen: " + " When ever recording complet video edit screen is not displayed ");
				extent.extentLoggerFail("Video Edit Screen:",
						"When ever recording complet video edit screen is not displayed ");
			}

			verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
			waitTime(15000);
			waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
			verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
			String postDescription = "Desc"+GeneratingRandomString(7);
			type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
			waitTime(3000);
			hideKeyboard();
			waitTime(3000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
//			verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
			verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
					" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
			verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "posthipi");// saveasdraft
			waitTime(4000);
			verifyIsElementDisplayed(HipiCreateVideoPage.objVideoUploadPopup, "Video Upload Popup");
			click(HipiCreateVideoPage.objGoToFeedButton, "Go To Feed Button");
			
			waitTime(60000);
//		
			verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
			for (int i = 0; i <= 100; i++) {
				scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
				if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
					Thread.sleep(4000);
					Back(1);
					Thread.sleep(4000);
					verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
				} else {
					verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), "Video");
					click(HipiCreateVideoPage.objselectfirstimage, "First video");
					waitTime(8000);
					break;
				}
			}
	}
	
	public void viewVideoCreatedByExistingSoundDialogue(String userType) throws Exception {
		

		extent.HeaderChildNode("Sound Verify if user is able to view video created by existing sound/dialogue");
     System.out.println("TC_Mobile_004");
     extent.extentLogger("", "TC_Mobile_004");
   
     String soundName = getText(HipiHomePage.objSoundName);
		if(verifyIsElementDisplayed(HipiHomePage.objSoundName, "Sound Name")){
			logger.info("Sound Name:" + soundName);
			extent.extentLoggerPass("Sound Name:","Beautiful You Sound  is displayed");
		} else {
			logger.info("Sound Name:" + "Beautiful You Sound is displayed");
			extent.extentLoggerFail("Sound Name:","Beautiful You Sound is displayed");
		}	
	}
	
		
	public void SoundCheckLayoutOfSoundDetailScreen(String userType) throws Exception {
		
		extent.HeaderChildNode("Sound Check layout of sound detail screen");
     System.out.println("TC_Mobile_005");
     extent.extentLogger("", "TC_Mobile_005");
     
     click(HipiHomePage.objSoundName, "Sound Name");
		waitTime(4000);
		if(verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDetailScreen, "Sound Detail Screen")){
		
			logger.info("Sound Detail Screen:" + "Sound Detail Screen is displayed when ever click on Sound Name");
			extent.extentLoggerPass("Sound Detail Screen:","Sound Detail Screen is displayed when ever click on Sound Name");
		} else {
			logger.info("Sound Detail Screen:" + "Sound Detail Screen is not displayed when ever click on Sound Name");
			extent.extentLoggerFail("Sound Detail Screen:","Sound Detail Screen is not displayed when ever click on Sound Name");
		}	
		
		verifyIsElementDisplayed(HipiSoundDetailPage.objBackIcon, "Back Icon");
		verifyIsElementDisplayed(HipiSoundDetailPage.objShareIcon, "Share Icon");
		verifyIsElementDisplayed(HipiSoundDetailPage.objSoundThumbnail, "Sound Thumbnail");
		verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDescription, "Sound Description");
//		verifyIsElementDisplayed(HipiSoundDetailPage.objAddToFavouriteIcon, "Add To Favourite Icon");
		verifyIsElementDisplayed(HipiSoundDetailPage.objListOfVideosCreated, "List Of Videos Created");
		verifyIsElementDisplayed(HipiSoundDetailPage.objUseThisSoundBtn, "Use This Sound Icon");
		verifyIsElementDisplayed(HipiSoundDetailPage.objVerifyAllVideos, "Verify All Videos");
		
		
	}
	
	public void tappingBackInSoundDetailScreen(String userType) throws Exception {
		
		
		extent.HeaderChildNode("Sound Check if user is redirected to HiPi home screen on tapping back in Sound Detail Screen");
     System.out.println("TC_Mobile_006");
     extent.extentLogger("", "TC_Mobile_006");
     Back(3);
     
     click(HipiHomePage.objSoundName, "Sound Name");
		waitTime(4000);
		if(verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDetailScreen, "Sound Detail Screen")){
		
			logger.info("Sound Detail Screen:" + "Sound Detail Screen is displayed when ever click on Sound Name");
			extent.extentLoggerPass("Sound Detail Screen:","Sound Detail Screen is displayed when ever click on Sound Name");
		} else {
			logger.info("Sound Detail Screen:" + "Sound Detail Screen is not displayed when ever click on Sound Name");
			extent.extentLoggerFail("Sound Detail Screen:","Sound Detail Screen is not displayed when ever click on Sound Name");
		}	
		waitTime(4000);
		click(HipiSoundDetailPage.objBackIcon, "Back Icon");
		waitTime(5000);
		if(verifyIsElementDisplayed(HipiFeedPage.objHipiFeedScreen, "Hipi Feed Screen")){

			logger.info("Hipi Feed Screen:" + "User is redirected to HiPi Feed screen");
			extent.extentLoggerPass("Hipi Feed Screen:","User is redirected to HiPi Feed screen");
		} else {
			logger.info("Hipi Feed Screen:" + "User is not redirected to HiPi Feed screen");
			extent.extentLoggerFail("Hipi Feed Screen:","User is not redirected to HiPi Feed screen");
		}	
	}
	public void verifySoundTitleIsDisplayed(String userType) throws Exception {
		
		extent.HeaderChildNode("Sound Check if on tapping sound title user is directed to sound detail screen and verify sound title is displayed");
     System.out.println("TC_Mobile_007");
     extent.extentLogger("", "TC_Mobile_007");
     
     click(HipiHomePage.objSoundName, "Sound Name");
		waitTime(6000);
		if(verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDetailScreen, "Sound Detail Screen")){
		
			logger.info("Sound Detail Screen:" + "Sound Detail Screen is displayed when ever click on Sound Name");
			extent.extentLoggerPass("Sound Detail Screen:","Sound Detail Screen is displayed when ever click on Sound Name");
		} else {
			logger.info("Sound Detail Screen:" + "Sound Detail Screen is not displayed when ever click on Sound Name");
			extent.extentLoggerFail("Sound Detail Screen:","Sound Detail Screen is not displayed when ever click on Sound Name");
		}	
		waitTime(4000);
		String title = getText(HipiSoundDetailPage.objSoundDescription);
		if(verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDescription, "Title")){
			logger.info("Title: " + title );
			extent.extentLoggerPass("Title:","Title is displayed when ever click on Sound Name");
		} else {
			logger.info("Title:" + "Title is not displayed when ever click on Sound Name");
			extent.extentLoggerFail("Title:","Title is not displayed when ever click on Sound Name");
		}	
	}
	public void soundVerifyTheSoundIsAddedToProfileFavourites(String userType) throws Exception {
		
		extent.HeaderChildNode("Sound Verify the sound is added to profile favourites");
     System.out.println("TC_Mobile_008");
     extent.extentLogger("", "TC_Mobile_008");
//		click(HipiSoundDetailPage.objAddToFavouriteIcon, "Favourite Icon");
//		waitTime(3000);
//		click(HipiSoundDetailPage.objAddToFavouriteIcon, "Favourite Icon");

		 if(verifyElementExist(HipiMePage.objAddToYourFavourite, "Add To Your Favourite")){
				logger.info("Add To Your Favourite:" + "Add To Your Favourite is displayed when ever click on Favourite Icon");
				extent.extentLoggerPass("Add To Your Favourite:","Add To Your Favourite is displayed when ever click on Favourite Icon");
			waitTime(5000);
	        } else {
				logger.info("Add To Your Favourite:" + "Add To Your Favourite is not displayed when ever click on Favourite Icon");
				extent.extentLoggerFail("Add To Your Favourite:","Add To Your Favourite is not displayed when ever click on Favourite Icon");
			}
		Back(1);
		click(HipiMePage.objMeicon, "Me Icon");
		waitTime(5000);
		if(verifyIsElementDisplayed(HipiMePage.objHipiProfileScreen, "Profile Screen")){
			logger.info("Profile Screen:" + "Profile Screen is displayed when ever user click on ME icon");
			extent.extentLogger("Profile Screen:", "Profile Screen is displayed when ever user click on ME icon");
		}else {
			logger.info("Profile Screen:" + "Profile Screen is displayed when ever user click on ME icon");
			extent.extentLoggerFail("Profile Screen:", "Profile Screen is displayed when ever user click on ME icon");	
		}
		click(HipiMePage.objfavourite, "Favourite");
		waitTime(4000);
		click(HipiMePage.objsounds, "Sounds");
		waitTime(4000);
		String soundText = getText(HipiMePage.objSoundIsAddedInTheList);
		if(verifyIsElementDisplayed(HipiMePage.objSoundIsAddedInTheList, "Sound Is Added")){
			logger.info("Sound Is Added:" + soundText);
			extent.extentLogger("Sound Is Added:", " added favorite sound is displayed");
		}else {
			logger.info("Sound Is Added:" + " added favorite sound is not displayed");
			extent.extentLoggerFail("Sound Is Added:", " added favorite sound is not displayed");	
		}
	}
	
	public void  removeOriginalSoundFromFavourite(String userType) throws Exception {
		
		extent.HeaderChildNode("Sound Check if user is able to add and remove original sound from favourite");
     System.out.println("TC_Mobile_009");
     extent.extentLogger("", "TC_Mobile_009");
		Back(1);
		  
     click(HipiHomePage.objSoundName, "Sound Name");
		waitTime(4000);
		if(verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDetailScreen, "Sound Detail Screen")){
		
			logger.info("Sound Detail Screen:" + "Sound Detail Screen is displayed when ever click on Sound Name");
			extent.extentLoggerPass("Sound Detail Screen:","Sound Detail Screen is displayed when ever click on Sound Name");
		} else {
			logger.info("Sound Detail Screen:" + "Sound Detail Screen is not displayed when ever click on Sound Name");
			extent.extentLoggerFail("Sound Detail Screen:","Sound Detail Screen is not displayed when ever click on Sound Name");
		}	
//		click(HipiMePage.objRemoveFavouriteInProfile, "Favourite Icon");
//		waitTime(3000);
//		click(HipiSoundDetailPage.objAddToFavouriteIcon, "Favourite Icon");
//		waitTime(3000);
//		click(HipiSoundDetailPage.objAddToFavouriteIcon, "Favourite Icon");

		 if(verifyElementExist(HipiMePage.objRemovedFavouritepopup, "Removed Popup")){
				logger.info("Removed Popup:" + "Removed Popup is displayed when ever click on Favourite icon");
				extent.extentLoggerPass("Removed Popup:","Removed Popup is displayed when ever click on Favourite icon");
			} else {
				logger.info("Removed Popup:" + "Removed Popup is not displayed when ever click on Favourite icon");
				extent.extentLoggerFail("Removed Popup:","Removed Popup is not displayed when ever click on Favourite icon");
			}
	}
	public void soundIsRemovedFromProfileFavourites(String userType) throws Exception {
		
		extent.HeaderChildNode("Sound Verify the sound is removed from profile favourites");
     System.out.println("TC_Mobile_010");
     extent.extentLogger("", "TC_Mobile_010");
		waitTime(9000);
		
//		click(HipiSoundDetailPage.objAddToFavouriteIcon, "Favourite Icon");
		waitTime(3000);
		Back(1);
		click(HipiMePage.objMeicon, "Me Icon");
		waitTime(5000);
		if(verifyIsElementDisplayed(HipiMePage.objHipiProfileScreen, "Profile Screen")){
			logger.info("Profile Screen:" + "Profile Screen is displayed when ever user click on ME icon");
			extent.extentLogger("Profile Screen:", "Profile Screen is displayed when ever user click on ME icon");
		}else {
			logger.info("Profile Screen:" + "Profile Screen is displayed when ever user click on ME icon");
			extent.extentLoggerFail("Profile Screen:", "Profile Screen is displayed when ever user click on ME icon");	
		}
		click(HipiMePage.objfavourite, "Favourite");
		waitTime(4000);
		click(HipiMePage.objsounds, "Sounds");
		waitTime(4000);
		String soundText = getText(HipiMePage.objSoundIsAddedInTheList);
		if(verifyIsElementDisplayed(HipiMePage.objSoundIsAddedInTheList, "Sound Is Added")){
			logger.info("Sound Is Added:" + soundText);
			extent.extentLogger("Sound Is Added:", " added favorite sound is displayed");
		}else {
			logger.info("Sound Is Added:" + " added favorite sound is not displayed");
			extent.extentLoggerFail("Sound Is Added:", " added favorite sound is not displayed");	
		}
		click(HipiMePage.objRemoveFavouriteInProfile, "Favourite Icon");

		if(verifyElementExist(HipiMePage.objRemovedPopup, "Removed Popup")){
			logger.info("Removed Popup:" + "Removed Popup is displayed when ever click on Favourite icon");
			extent.extentLoggerPass("Removed Popup:","Removed Popup is displayed when ever click on Favourite icon");
		} else {
			logger.info("Removed Popup:" + "Removed Popup is not displayed when ever click on Favourite icon");
			extent.extentLoggerFail("Removed Popup:","Removed Popup is not displayed when ever click on Favourite icon");
		}
	}
	public void viewRelatedVideosForNewExistingSound(String userType) throws Exception {
		
		extent.HeaderChildNode("Sound Check if user is able to view related videos for a new/existing sound");
     System.out.println("TC_Mobile_011");
     extent.extentLogger("", "TC_Mobile_011");
	  Back(1);
     click(HipiHomePage.objSoundName, "Sound Name");
		waitTime(4000);
		if(verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDetailScreen, "Sound Detail Screen")){
		
			logger.info("Sound Detail Screen:" + "Sound Detail Screen is displayed when ever click on Sound Name");
			extent.extentLoggerPass("Sound Detail Screen:","Sound Detail Screen is displayed when ever click on Sound Name");
		} else {
			logger.info("Sound Detail Screen:" + "Sound Detail Screen is not displayed when ever click on Sound Name");
			extent.extentLoggerFail("Sound Detail Screen:","Sound Detail Screen is not displayed when ever click on Sound Name");
		}	
     
		if(verifyIsElementDisplayed(HipiSoundDetailPage.objVerifyVideo, "Verify Video")){

			logger.info("Verify Video:" + "Related videos is displayed");
			extent.extentLoggerPass("Verify Video:","Related videos is displayed");
		} else {
			logger.info("Verify Video:" + "Related videos is not displayed");
			extent.extentLoggerFail("Verify Video:","Related videos is not displayed");
		}	
     
	}
	
	public void  createVideoForExistingSoundEffect(String userType) throws Exception {

		extent.HeaderChildNode("Sound Check if user is able to create video for existing sound effect");
     System.out.println("TC_Mobile_012");
     extent.extentLogger("", "TC_Mobile_012");
	  click(HipiSoundDetailPage.objUseThisSoundBtn, "Use This Sound Button");
	 // waitTime(4000);
	  waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
	  verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
	click(HipiCreateVideoPage.objCreateReadyYes, "yes button");
	logger.info("Ready dialog displayed:" + "yes button");
	Thread.sleep(10000);

  
  logger.info("Create video page:" + "Create video page displayed");
  
  verifyElementPresentAndClick(HipiSoundDetailPage.objAddMusicButton, "Add Music Button");
  waitTime(4000);
  click(HipiSoundDetailPage.objSearchTextBox, "Search Text Box");
  waitTime(3000);
 String beautifulYouSong = getParameterFromXML("SearchSong");
  type(HipiSoundDetailPage.objSearchTextBox, beautifulYouSong , "Beautiful You Song");
  waitTime(4000);
  hideKeyboard();
  click(HipiSoundDetailPage.objBeautifulYouSong, "Beautiful You Song");
  waitTime(3000);
  click(HipiSoundDetailPage.objClickBeautifulYouSong, "Beautiful You Song Again");
  waitTime(5000);
  click(HipiSoundDetailPage.objClickPostTick, "Post Tick");
  waitTime(3000);
  verifyIsElementDisplayed(HipiSoundDetailPage.objReplaceMusicPopUp, "Replace Music Pop Up");
  click(HipiSoundDetailPage.objReplaceMusicYesButton, "Yes Button");
  waitTime(2000);
//  click(HipiSoundDetailPage.objClickPostTick, "Post Tick");

  verifyElementPresentAndClick(HipiCreateVideoPage.objrecording,"Recording Button");
		 waitTime(20000);
			if (verifyElementExist(HipiCreateVideoPage.objVideoEditScreen, "Video Edit Screen")) {
				logger.info("Vide oEdit Screen: " + " When ever recording complet video edit screen is displayed ");
				extent.extentLoggerPass("Video Edit Screen:", "When ever recording complet video edit screen is displayed ");
			} else {
				logger.info("Video Edit Screen: " + " When ever recording complet video edit screen is not displayed ");
				extent.extentLoggerFail("Video Edit Screen:",
						"When ever recording complet video edit screen is not displayed ");
			}

			verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
			waitTime(15000);
			waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
			verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
			String postDescription = "Desc"+GeneratingRandomString(7);
			type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
			waitTime(3000);
			hideKeyboard();
			waitTime(3000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
//			verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
			verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
					" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
			verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "posthipi");// saveasdraft
			waitTime(4000);
			verifyIsElementDisplayed(HipiCreateVideoPage.objVideoUploadPopup, "Video Upload Popup");
			click(HipiCreateVideoPage.objGoToFeedButton, "Go To Feed Button");
			
			waitTime(60000);
			verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
			waitTime(5000);
			verifyIsElementDisplayed(AMDHipi.objPublishingInProcess);
			
	}
	
	public void shareSoundUsingSocialMedia(String userType) throws Exception {
		extent.HeaderChildNode("Sound Check if user is able to share Sound using social media");
     System.out.println("TC_Mobile_013");
     extent.extentLogger("", "TC_Mobile_013");
  	Back(1);
	  click(HipiHomePage.objSoundName, "Sound Name");
			click(HipiSoundDetailPage.objShareIcon, "Share Icon");
			waitTime(4000);
			 if (verifyElementExist(HipiShareScreen.objShareDeailsScreen, "Share Deails Screen")) {

					logger.info("Share Deails Screen:" + "When ever click on share button share deails screen is displayed");
					extent.extentLoggerPass("Share Deails Screen:",
							"When ever click on share button share deails screen is displayed");

				} else {
					logger.info(
							"Share Deails Screen:" + "When ever click on share button share deails screen is not displayed");
					extent.extentLoggerFail("Share Deails Screen:",
							"When ever click on share button share deails screen is not displayed");
				}
			 if (verifyElementExist(HipiShareScreen.objFBOption, "FB Option")) {

					logger.info("FB Option: " + "When evre click on share button FB Option is displayed");
					extent.extentLoggerPass("FB Option: ", "When evre click on share button FB Option is displayed");
					waitTime(3000);
				} else {
					logger.info("FB Option: " + "When evre click on share button FB Option is not displayed");
					extent.extentLoggerFail("FB Option: ", "When evre click on share button FB Option is not  displayed");
				}
				waitTime(5000);

				click(HipiShareScreen.objFBOption, "Facebook Option");
				waitTime(10000);
				
				if(verifyIsElementDisplayed(HipiShareScreen.objFBPostbutton, "Post button")){
					click(HipiShareScreen.objFBPostbutton, "Post Button");
					waitTime(30000);
				}else{
					click(HipiEffectPage.objNoneOfTheAbove, "None Of The Above");

//					waitTime(5000);
//					click(HipiShareScreen.objLogintoAnotherAccount, "Loginto Another Account");
					waitTime(5000);
					waitTime(3000);

					String FBusername = getParameterFromXML("fbusername");
					waitTime(5000);
					click(HipiShareScreen.objEmailTextfield, "Phone Number Field");
					waitTime(3000);
					Actions a = new Actions(getDriver());
					a.sendKeys(FBusername);
					a.perform();
					waitTime(3000);
					hideKeyboard();
					waitTime(3000);

					String FBpassword = getParameterFromXML("fbPassword");
					waitTime(5000);
					click(HipiShareScreen.objPassWordfield, "PassWord Field");
					waitTime(3000);
					Actions ab = new Actions(getDriver());
					ab.sendKeys(FBpassword);
					ab.perform();
					hideKeyboard();
					waitTime(4000);
					click(HipiShareScreen.objFBLoginButton, "Log In");

					waitTime(20000);

					click(HipiShareScreen.objFBPostbutton, "Post Button");
					waitTime(30000);
				}
					
				
				

	}
	
	public void messageByTappingOnCancel(String userType) throws Exception {
		
		extent.HeaderChildNode("Sound Check if user is unable to share Sound to following people with a message by tapping on cancel");
     System.out.println("TC_Mobile_014");
     extent.extentLogger("", "TC_Mobile_014");
		
     waitTime(5000);
     
     click(HipiSoundDetailPage.objShareIcon, "Share Icon");
  	
     waitTime(10000);
     if (verifyElementExist(HipiShareScreen.objShareDeailsScreen, "Share Deails Screen")) {

			logger.info("Share Deails Screen:" + "When ever click on share button share deails screen is displayed");
			extent.extentLoggerPass("Share Deails Screen:",
					"When ever click on share button share deails screen is displayed");

		} else {
			logger.info(
					"Share Deails Screen:" + "When ever click on share button share deails screen is not displayed");
			extent.extentLoggerFail("Share Deails Screen:",
					"When ever click on share button share deails screen is not displayed");
		}

		click(HipiShareScreen.objSMS, "SMS Button");

		waitTime(9000);
		
//		click(HipiShareScreen.objCancleButton, "Cancle Button");
//		waitTime(5000);

		click(HipiShareScreen.objNewMessage, "New Message");
		waitTime(4000);
		click(HipiShareScreen.objBackNavigation , "Back Navigation ");
		waitTime(3000);
		verifyIsElementDisplayed(HipiShareScreen.objNotSentTapToTryAgain, "Not Sent Tap To Try Again");
		
	}
	
	public void  messageByTappingOnSendSoundDetailsPage(String userType) throws Exception {
		
		extent.HeaderChildNode("Sound Check if user is able to share Sound to following people with a message by tapping on send");
     System.out.println("TC_Mobile_015");
     extent.extentLogger("", "TC_Mobile_015");
 	Back(1);
		  click(HipiHomePage.objSoundName, "Sound Name");
			waitTime(4000);
			if(verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDetailScreen, "Sound Detail Screen")){
			
				logger.info("Sound Detail Screen:" + "Sound Detail Screen is displayed when ever click on Sound Name");
				extent.extentLoggerPass("Sound Detail Screen:","Sound Detail Screen is displayed when ever click on Sound Name");
			} else {
				logger.info("Sound Detail Screen:" + "Sound Detail Screen is not displayed when ever click on Sound Name");
				extent.extentLoggerFail("Sound Detail Screen:","Sound Detail Screen is not displayed when ever click on Sound Name");
			}	
     
     click(HipiSoundDetailPage.objShareIcon, "Share Icon");
		waitTime(8000);
		 if (verifyElementExist(HipiShareScreen.objShareDeailsScreen, "Share Deails Screen")) {

				logger.info("Share Deails Screen:" + "When ever click on share button share deails screen is displayed");
				extent.extentLoggerPass("Share Deails Screen:",
						"When ever click on share button share deails screen is displayed");

			} else {
				logger.info(
						"Share Deails Screen:" + "When ever click on share button share deails screen is not displayed");
				extent.extentLoggerFail("Share Deails Screen:",
						"When ever click on share button share deails screen is not displayed");
			}
		
		 click(HipiShareScreen.objSMS, "SMS Button");
			waitTime(4000);
//			 click(HipiCoolGlassesEffect.objSelectContact, "Contect");

			click(HipiShareScreen.objNewMessage, "New Message");
			waitTime(4000);

			click(HipiShareScreen.objnumberIcon, "Number Icon");

			waitTime(4000);
			String enterphonenumber = getParameterFromXML("enterPhonenumber");

			type(HipiShareScreen.objtypeNumber, enterphonenumber, "Enter Number");
			waitTime(5000);
			click(HipiShareScreen.objclickonTICK, "Tick Button");
			waitTime(9000);
			click(HipiShareScreen.objSendButton, "Send Button");

//			waitTime(5000);
			hideKeyboard();
			waitTime(9000);

			if (verifyElementExist(HipiShareScreen.objchecksendlink, "Sound")) {

				logger.info("Link:" + "Sound Link is displayed");
				extent.extentLoggerPass("Link:", "Sound Link is displayed");

				
			} else {
				logger.info("Link:" + "Sound Link is not displayed ");
				extent.extentLoggerFail("Link:", "Sound Link is not displayed ");
			}
			click(HipiShareScreen.objLinkSoundDetailsPage, "SMS Link");
			waitTime(15000);
			if(verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDetailScreen, "Sound Detail Screen")){
				
				logger.info("Sound Detail Screen:" + "Sound Detail Screen is displayed when ever click on Sound Name");
				extent.extentLoggerPass("Sound Detail Screen:","Sound Detail Screen is displayed when ever click on Sound Name");
			} else {
				logger.info("Sound Detail Screen:" + "Sound Detail Screen is not displayed when ever click on Sound Name");
				extent.extentLoggerFail("Sound Detail Screen:","Sound Detail Screen is not displayed when ever click on Sound Name");
			}	
			
	}
	
	public void viewVideoCountOnTappingSoundOnNewlyCreatedVideo(String userType) throws Exception {
		extent.HeaderChildNode("Sound Check if user is able to view Video count on tapping Sound on newly created video");
     System.out.println("TC_Mobile_028");
     extent.extentLogger("", "TC_Mobile_028");
     Object viewCount = getText(HipiSoundDetailPage.objVideoCount);
		if(verifyIsElementDisplayed(HipiSoundDetailPage.objVideoCount, "Video Count")){

			logger.info("Video Count: " + viewCount );
			extent.extentLoggerPass("Video Count:","Video Count is displayed when ever user click on sound name");
		} else {
			logger.info("Video Count:" + "Video Count is displayed when ever user click on sound name");
			extent.extentLoggerFail("Video Count:","Video Count is displayed when ever user click on sound name");
		}	
		
	}
	public void createdTheVideoByOriginalSound(String userType) throws Exception {
		
		extent.HeaderChildNode("Sound Check if user is able to view name of the user who has created the video by original sound");
     System.out.println("TC_Mobile_017");
     extent.extentLogger("", "TC_Mobile_017");
//		waitTime(60000);
     Back(1);
	 
     for(int i=1; i<=20; i++) {
 		String origenSound = getText(HipiHomePage.objSoundName);
 		
 		if (origenSound.contains("Original Sound")) {
 			waitTime(3000);
			verifyElementPresentAndClick(HipiHomePage.objSoundName, "Origen Sound");
				waitTime(10000);
				 break;
			}else {
				Swipe("UP", 1);
			}
			}
     if(verifyIsElementDisplayed(HipiSoundDetailPage.objSoundDescription, "Sound Name")){
			

			logger.info("Sound Name:" + "Sound Name is displayed when ever click on sound in feed screen");
			extent.extentLoggerPass("Sound Name:","Sound Name is displayed when ever click on sound in feed screen");
		} else {
			logger.info("Sound Name:" + "Sound Name is not displayed when ever click on sound in feed screen");
			extent.extentLoggerFail("Sound Name:","Sound Name is not displayed when ever click on sound in feed screen");
		}	
	}
	
	public void  createdTheVideoByDialogueExistingSound(String userType) throws Exception {

		extent.HeaderChildNode("Sound Check if user is unable to view name of the user who has created the video by dialogue/existing sound");
     System.out.println("TC_Mobile_018");
     extent.extentLogger("", "TC_Mobile_018");
     Back(1);
//     waitTime(30000);
     
     for(int i=1; i<=20; i++) {
 		String origenSound = getText(HipiHomePage.objSoundName);
 		
 		if (!origenSound.contains("Original Sound")) {
 			waitTime(3000);
			verifyElementPresentAndClick(HipiHomePage.objSoundName, "Sound");
				waitTime(10000);
				 break;
			}else {
				Swipe("UP", 1);
			}
			}
     
     
     
     String onlySoundName = getText(HipiSoundDetailPage.objSoundDescription);
     
     if(!onlySoundName.contains("Original Sound")) {

			logger.info("Sound Name:" + "Sound Name is displayed when ever click on sound in feed screen");
			extent.extentLoggerPass("Sound Name:","Sound Name is displayed when ever click on sound in feed screen");
		} else {
			logger.info("Original Sound:" + "Original Sound is displayed when ever click on sound in feed screen");
			extent.extentLoggerFail("Original Sound:","Original Sound is displayed when ever click on sound in feed screen");
		}	
     }
     
     
     
		
	
	//--------------------------------------------------------------------------------------------------------------------
	
	
	
	public void ValidatingHashtagDetailPage(String userType)throws Exception {
		
		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			hashtDetailScreen(userType);
			homeScreenOnTappingOnBackInHashTagDetailScreen(userType);
			tappingHashtagOnPausedPlayedVideo(userType);
			hashTagBannerInHiPiSearchDiscoverSection(userType);
			urlNewlyCreatedVideo(userType);

			hashtagTitleDescriptionToNewlyCreatedVideo(userType);
			hashtagTitle(userType);
			descriptionOnTappingHashtagOnNewlyCreatedVideo(userType);
			createdToFavourite(userType);
			profileFavouritesList(userType);
			removeNewlyHashtagAddedFromFavourite(userType);
			hashtagIRemovedFromProfileFavourites(userType);
			relatedVideosForNewExistingHashtag(userType);
			tappingOnUseThisHashTagIcon(userType);
			verifyOnTappingFullImageIsDisplayed(userType);
			viewTermsAndConditions(userType);
			disclaimerBelowToHashtagDescription(userType);
			videoCountOnTappingHashtag(userType);
			numberOfViewsTappingHashtag(userType);
			//messageByTappingOnSend(userType);
			shareHashtagUsingSocialMedia(userType);
			//messageByTappingOnBackButton(userType);
		}else{
			
		}
		
	}
	
	
		
	
	//---------------------------------Hashtag Detail page-------------------------------------------
		
		
		                  public void hashtDetailScreen(String userType) throws InterruptedException, Exception {
			                 extent.HeaderChildNode("Check the layout of Hashtag Detail Screen");
			                 System.out.println("TC_Mobile_001");
			                 extent.extentLogger("", "TC_Mobile_001");
			                 
			             	if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
			        			click(AMDOnboardingScreen.objHipiButton, "HiPi");
			        			Thread.sleep(6000);

			        		} else {

			        		}
			            	click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
			        		waitTime(5000);
			        		click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
			        		waitTime(5000);
			             	String fun = getParameterFromXML("#Fun");
			             	waitTime(3000);
			             	type(HipiDiscoverPage.objSearchButton, fun, "#Fun");
			               	waitTime(3000);
			                hideKeyboard();
			                waitTime(5000);
			             
			                Swipe("Up", 1);

			                waitTime(3000);

			                for(int i=1;i<=10;i++)
			                {
			             
			                if(verifyIsElementDisplayed(HipiDiscoverPage.objSpecificHashtagText(fun), fun)){
			               	 click(HipiDiscoverPage.objSpecificHashtagText(fun), fun);
			               	 break;
			                }else{
			               	 SwipeHashtagRail(HipiDiscoverPage.objHashtagSecondTumbnail);
			               	 waitTime(3000);
			                }
			                }
			               	
			             	waitTime(5000);
//			             	if(verifyIsElementDisplayed(HipiHomePage.objPlayerScreen, "Player Screen")){
	//
//			        			logger.info("Player Screen:" + "Hipi home screen is displayed");
//			        			extent.extentLoggerPass("Player Screen:","Hipi home screen is displayed");
//			        		
//			        		} else {
//			        			logger.info("Player Screen:" + "Hipi home screen is not displayed");
//			        			extent.extentLoggerFail("Player Screen:","Hipi home screen is not displayed");
//			        		}
//			             	
//			        
//			             boolean Hashtags = getDriver().findElement(HipiHomePage.objHashtagdescription).isDisplayed();
//			           	  
//			           	  if (Hashtags ) {
//			           	  logger.info("Hashtag:"  + Hashtags);
//			           	  extent.extentLogger("Hashtag:", "Hashtags is displayed");
//			           	  }else {
//			               logger.info("Hashtag:"  +   "Hastag not displayed ");	  
//			           	  extent.extentLoggerFail("Hashtag:", "Hashtags is not displayed");
	//
//			           	     }
//			           	  
//			           	  click(HipiHomePage.objHashtagdescription, "Hashtag Description");
//			           	  waitTime(4000);
//			           	  

			           	  
			           	  if (verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagDetailScreen, "Hashtag Detail Screen")) {

			        			logger.info("Hashtag Detail Screen:" + "Hashtag Detail Screen is displayed when ever click on Hashtag Description");
			        			extent.extentLoggerPass("Hashtag Detail Screen:","Hashtag Detail Screen is displayed when ever click on Hashtag Description");
			        		
			        		} else {
			        			logger.info("Hashtag Detail Screen:" + "Hashtag Detail Screen is not displayed when ever click on Hashtag Description");
			        			extent.extentLoggerFail("Hashtag Detail Screen:","Hashtag Detail Screen is not displayed when ever click on Hashtag Description");
			        		}
			        	if(verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagDetailLayout, "Hashtag Detail Layout")){

		        			logger.info("Hashtag Detail Layout:" + "Hashtag Detail Layout is displayed when ever click on Hashtag Description");
		        			extent.extentLoggerPass("Hashtag Detail Layout:","Hashtag Detail Layout is displayed when ever click on Hashtag Description");
		        		
		        		} else {
		        			logger.info("Hashtag Detail Layout:" + "Hashtag Detail Layout is not displayed when ever click on Hashtag Description");
		        			extent.extentLoggerFail("Hashtag Detail Layout:","Hashtag Detail Layout is not displayed when ever click on Hashtag Description");
		     
		        		}
			        		
			        	 verifyElementPresent(HipiHashtagDetailPage.objBackIcon, "Back Icon");
			        	 verifyElementPresent(HipiHashtagDetailPage.objHashtagThumnail, "Hashtag Thumnail");
			        	 verifyElementPresent(HipiHashtagDetailPage.objShareIcon, "Share Icon");
			        	 verifyElementPresent(HipiHashtagDetailPage.objThreeDots, "Three Dots");
			        	 verifyElementPresent(HipiHashtagDetailPage.objHashtagDescription, "Hashtag Description");
			        	 verifyElementPresent(HipiHashtagDetailPage.objListOfVideosScreen, "Videos Screen");
			        	 verifyElementPresent(HipiHashtagDetailPage.objFavouriteIcon, "Favourite Icon");
			        	 String views = getText(HipiHashtagDetailPage.objHashtagViews);
			        	 if(verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagViews, "views")){
			        		 logger.info("views" + views );
			        			extent.extentLoggerPass("views:","views count is displayed ");
			        		
			        		} else {
			        			logger.info("views:" + "views count is not displayed ");
			        			extent.extentLoggerFail("views:","views count is not displayed ");
			     
			        		}
			        	 
			        	 
			           	  }

		                  

		                  
		                  
		                  
		              	
		              	
		              	
		public void  homeScreenOnTappingOnBackInHashTagDetailScreen(String userType) throws Exception {
			
			  extent.HeaderChildNode("Check if user is able is redirected to HiPi home screen on tapping on back in HashTag Detail Screen");
	          System.out.println("TC_Mobile_002");
	          extent.extentLogger("", "TC_Mobile_002");
	    
	          click(HipiHashtagDetailPage.objOneofvideo, "One Of Video");
	          waitTime(5000);
	          if(verifyIsElementDisplayed(HipiHomePage.objPlayerScreen, "Player Screen")){
	        	  
	        	  		        			logger.info("Player Screen:" + "Hipi home screen is displayed");
	        	  		        			extent.extentLoggerPass("Player Screen:","Hipi home screen is displayed");
	        	  		        		
	        	  		        		} else {
	        	  		        			logger.info("Player Screen:" + "Hipi home screen is not displayed");
	        	  		        			extent.extentLoggerFail("Player Screen:","Hipi home screen is not displayed");
	        	  		        		}
	        	  		             	
	        	  		        
	        	  		             boolean Hashtags = getDriver().findElement(HipiHomePage.objHashtagDescription).isDisplayed();
	        	  		           	  
	        	  		           	  if (Hashtags ) {
	        	  		           	  logger.info("Hashtag:"  + Hashtags);
	        	  		           	  extent.extentLogger("Hashtag:", "Hashtags is displayed");
	        	  		           	  }else {
	        	  		               logger.info("Hashtag:"  +   "Hastag not displayed ");	  
	        	  		           	  extent.extentLoggerFail("Hashtag:", "Hashtags is not displayed");
	        	  
	        	  		           	     }
	        	  		           	  waitTime(5000);
	        	  		           	  click(HipiHomePage.objHashtagDescription, "Hashtag Description");
	        	  		           	  waitTime(9000);
	        	  		           	  

	          click(HipiHashtagDetailPage.objBackIcon, "Back Icon");
			
	          if(verifyIsElementDisplayed(HipiHomePage.objPlayerScreen, "Player Screen")){
	        	  
	    			logger.info("Player Screen:" + "Hipi home screen is displayed");
	    			extent.extentLoggerPass("Player Screen:","Hipi home screen is displayed");
	    		
	    		} else {
	    			logger.info("Player Screen:" + "Hipi home screen is not displayed");
	    			extent.extentLoggerFail("Player Screen:","Hipi home screen is not displayed");
	    		}
	         	
	    
			
		}
		
		
		public void tappingHashtagOnPausedPlayedVideo(String userType) throws Exception {
			
			  extent.HeaderChildNode("Check if user is able to view  HashTag  Banner in HiPi search/Discover section in the form of Carousal");
	        System.out.println("TC_Mobile_003");
	        extent.extentLogger("", "TC_Mobile_003");
			
	        click(HipiHomePage.objPlayerScreen, "Player Screen");
			waitTime(3000);
	        click(HipiHomePage.objPlayerScreen, "Player Screen again");
	        waitTime(3000);
	   	  click(HipiHomePage.objHashtagDescription, "Hashtag Description");
	     	  waitTime(6000);
	      	  
	       	  if (verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagDetailScreen, "Hashtag Detail Screen")) {

	    			logger.info("Hashtag Detail Screen:" + "Hashtag Detail Screen is displayed when ever click on Hashtag Description");
	    			extent.extentLoggerPass("Hashtag Detail Screen:","Hashtag Detail Screen is displayed when ever click on Hashtag Description");
	    		
	    		} else {
	    			logger.info("Hashtag Detail Screen:" + "Hashtag Detail Screen is not displayed when ever click on Hashtag Description");
	    			extent.extentLoggerFail("Hashtag Detail Screen:","Hashtag Detail Screen is not displayed when ever click on Hashtag Description");
	    		}
	    	if(verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagDetailLayout, "Hashtag Detail Layout")){

				logger.info("Hashtag Detail Layout:" + "Hashtag Detail Layout is displayed when ever click on Hashtag Description");
				extent.extentLoggerPass("Hashtag Detail Layout:","Hashtag Detail Layout is displayed when ever click on Hashtag Description");
			
			} else {
				logger.info("Hashtag Detail Layout:" + "Hashtag Detail Layout is not displayed when ever click on Hashtag Description");
				extent.extentLoggerFail("Hashtag Detail Layout:","Hashtag Detail Layout is not displayed when ever click on Hashtag Description");

			}

		}
		
		public void  hashTagBannerInHiPiSearchDiscoverSection(String userType) throws Exception {
			 extent.HeaderChildNode("Check if user is able to view  HashTag  Banner in HiPi search/Discover section in the form of Carousal");
		        System.out.println("TC_Mobile_004");
		        extent.extentLogger("", "TC_Mobile_004");
			Back(4);
		        if(verifyIsElementDisplayed(HipiDiscoverPage.objHashTagBanner, "HashTag Banner")){
		        	logger.info("HashTag Banner:" + "HashTag Banner is displayed when ever click on Discover");
					extent.extentLoggerPass("HashTag Banner:","HashTag Banner is displayed when ever click on Discover");
				
				} else {
					logger.info("HashTag Banner:" + "HashTag Banner is not displayed when ever click on Discover");
					extent.extentLoggerFail("HashTag Banner:","HashTag Banner is not displayed when ever click on Discover");

				}

			
		}
		
		
		
		public void  hashtagTitleDescriptionToNewlyCreatedVideo(String userType) throws Exception {
			
			 extent.HeaderChildNode("Check if user is able to add Hashtag Title, description to a newly created video");
		        System.out.println("TC_Mobile_006");
		        extent.extentLogger("", "TC_Mobile_006");
		        
		        Back(2);
		        verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"click on create a video");
		        
		        waitTime(4000);
		        
		      
//					verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload video video");
					 verifyElementPresentAndClick(HipiCreateVideoPage.objrecording," Recording");
					 
					 waitTime(20000);
					// SwipeUntilFindElement(HipiCreateVideoPage.objselectimage, "");

//					if (verifyElementExist(HipiCreateVideoPage.objselectFirstimage, "Video present")) {
//						verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "Video present");
	//
//						verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, "Edit HipiIT");
//						Thread.sleep(5000);
//						if (verifyElementExist(HipiCreateVideoPage.objtrimfinish, "finish")) {
	//
//							verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, "finish");

							verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
							waitTime(15000);
							verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
							String postDescription = getParameterFromXML("Description");
							type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
							waitTime(3000);
							hideKeyboard();
							waitTime(3000);
							verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
//							verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
							verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
									" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
							verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "posthipi");// saveasdraft
							waitTime(4000);
							verifyIsElementDisplayed(HipiCreateVideoPage.objVideoUploadPopup, "Video Upload Popup");
							click(HipiCreateVideoPage.objGoToFeedButton, "Go To Feed Button");
							
							waitTime(60000);
//						
							verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
							for (int i = 0; i <= 100; i++) {
								scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
								if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
									Thread.sleep(4000);
									Back(1);
									Thread.sleep(4000);
									verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
								} else {
									verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), "Video");
									click(HipiCreateVideoPage.objselectfirstimage, "First video");
									waitTime(8000);
									break;
								}
							}

							waitTime(5000);
							 boolean Hashtags = getDriver().findElement(HipiHomePage.objHashtagDescription).isDisplayed();
				           	  
				           	  if (Hashtags ) {
				           	  logger.info("Hashtag:"  + Hashtags);
				           	  extent.extentLogger("Hashtag:", "Hashtags is displayed");
				           	  }else {
				               logger.info("Hashtag:"  +   "Hastag not displayed ");	  
				           	  extent.extentLoggerFail("Hashtag:", "Hashtags is not displayed");
		
				           	     }
			
			
		}
		
		
		
		
		public void  urlNewlyCreatedVideo(String userType) throws Exception {
			
			 extent.HeaderChildNode("Check if user is able to add description with URL to a newly created video, for user created hashtags");
		        System.out.println("TC_Mobile_008");
		        extent.extentLogger("", "TC_Mobile_008");
		        
		        
	   verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"Create Button");
	   if (verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo,
				"Allow ZEE5 to take pictures and record video?")) {
			logger.info("Permission dialog:" + "Allow ZEE5 to take pictures and record video?");
			verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow");
			click(HipiCreateVideoPage.objCreateAllow, "Allow button");
			logger.info("Allow ZEE5 to take pictures and record video-" + "Allow button");
			Thread.sleep(5000);

			logger.info("Permission dialog:" + "Allow ZEE5 to access photos, media, and files on your device");
			verifyElementExist(HipiCreateVideoPage.objCreateAllow,
					"Allow ZEE5 to access photos, media, and files on your device?");
			click(HipiCreateVideoPage.objCreateAllow, "Allow button");
			logger.info("Allow ZEE5 to access photos, media, and files on your device-" + "Allow button");
			Thread.sleep(5000);

			logger.info("Permission dialog:" + "Allow ZEE5 to record audio");
			verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?");
			click(HipiCreateVideoPage.objCreateAllow, "Allow button");
			logger.info("Allow ZEE5 to record audio-" + "Allow button");
			//Thread.sleep(40000);
			waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
			verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
			click(HipiCreateVideoPage.objCreateReadyYes, "yes button");
			logger.info("Ready dialog displayed:" + "yes button");
			Thread.sleep(10000);
		}
		logger.info("Create video page:" + "Create video page displayed");
		

		        waitTime(4000);
		        verifyElementPresentAndClick(HipiCreateVideoPage.objrecording," Recording");
				 
				 waitTime(20000);
				// SwipeUntilFindElement(HipiCreateVideoPage.objselectimage, "");

//				if (verifyElementExist(HipiCreateVideoPage.objselectFirstimage, "Video present")) {
//					verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "Video present");
	//
//					verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, "Edit HipiIT");
//					Thread.sleep(5000);
//					if (verifyElementExist(HipiCreateVideoPage.objtrimfinish, "finish")) {
	//
//						verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, "finish");

						verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
						waitTime(15000);
						verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
						String postDescription = getParameterFromXML("DescriptionandURL");
						type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
						waitTime(3000);
						hideKeyboard();
						waitTime(3000);
						verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
						verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
						verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
								" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
						verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "posthipi");// saveasdraft
						waitTime(4000);
						verifyIsElementDisplayed(HipiCreateVideoPage.objVideoUploadPopup, "Video Upload Popup");
						click(HipiCreateVideoPage.objGoToFeedButton, "Go To Feed Button");
						
						waitTime(60000);
//						
//						boolean Popup = verifyElementDisplayed(HipiCreateVideoPage.objpopup);
//						if (Popup) {
//							extent.extentLoggerPass("Success", "Success Popup is displayed ");
//							logger.info("Success Popup is displayed ");
//						}
//						verifyElementPresentAndClick(HipiCreateVideoPage.objokbtn, "ok button");
//						Thread.sleep(10000);

						verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
						for (int i = 0; i <= 100; i++) {
							scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
							if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
								Thread.sleep(4000);
								Back(1);
								Thread.sleep(4000);
								verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
							} else {
								verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), "Video");
								click(HipiCreateVideoPage.objselectfirstimage, "First video");
								waitTime(8000);
								break;
							}
						}

						String descriptionWithURL = getText(HipiHashtagDetailPage.objDescriptionWithURL);
						if(descriptionWithURL.contains("#Fun Description https://www.google.com/")) {
							logger.info("Description With URL:" + descriptionWithURL );
							extent.extentLoggerPass("Description With URL:", "Description With URL is displayed  newly created video ");
						} else {
							logger.info("Description With URL:" + "Description With URL is not displayed  newly created video ");
							extent.extentLoggerFail("Description With URL:","Description With URL is not displayed  newly created video ");
						}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		public void  hashtagTitle(String userType) throws Exception {

			 extent.HeaderChildNode("Check if user is able to view Hashtag titletitlename on tapping  Hashtag  on newly created video");
		        System.out.println("TC_Mobile_005");
		        extent.extentLogger("", "TC_Mobile_005");
		       
//		        
//		        click(HipiMePage.objMeicon, "Me icon");
//		        waitTime(4000);
//		        click(HipiMePage.obOneOfVideo, "OneOfVideo");
//		        
//		        waitTime(5000);
		        
		        
		        
		        
		        
		        
		click(HipiHomePage.objPlayerScreen, "Player Screen");
		waitTime(3000);
	    click(HipiHomePage.objPlayerScreen, "Player Screen again");
	    waitTime(3000);
		  click(HipiHomePage.objHashtagDescription, "Hashtag Description");
	 	  waitTime(6000);
	  	  
	   	  if (verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagDetailScreen, "Hashtag Detail Screen")) {

				logger.info("Hashtag Detail Screen:" + "Hashtag Detail Screen is displayed when ever click on Hashtag Description");
				extent.extentLoggerPass("Hashtag Detail Screen:","Hashtag Detail Screen is displayed when ever click on Hashtag Description");
			
			} else {
				logger.info("Hashtag Detail Screen:" + "Hashtag Detail Screen is not displayed when ever click on Hashtag Description");
				extent.extentLoggerFail("Hashtag Detail Screen:","Hashtag Detail Screen is not displayed when ever click on Hashtag Description");
			}
		if(verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagDetailLayout, "Hashtag Detail Layout")){

			logger.info("Hashtag Detail Layout:" + "Hashtag Detail Layout is displayed when ever click on Hashtag Description");
			extent.extentLoggerPass("Hashtag Detail Layout:","Hashtag Detail Layout is displayed when ever click on Hashtag Description");
		
		} else {
			logger.info("Hashtag Detail Layout:" + "Hashtag Detail Layout is not displayed when ever click on Hashtag Description");
			extent.extentLoggerFail("Hashtag Detail Layout:","Hashtag Detail Layout is not displayed when ever click on Hashtag Description");

		}
		String hashtagTitle = getText(HipiHashtagDetailPage.objHashtagTitle);
		if(verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagTitle, "Hashtag Title")){

			logger.info("Hashtag Title:" + hashtagTitle);
			extent.extentLoggerPass("Hashtag Title:","Hashtag Title is displayed when ever tapping  Hashtag  on newly created video");
		
		} else {
			logger.info("Hashtag Title:" + "Hashtag Title is not displayed when ever tapping  Hashtag  on newly created video");
			extent.extentLoggerFail("Hashtag Title:","Hashtag Title is not displayed when ever tapping  Hashtag  on newly created video");

		}
		
	}
		
		public void  descriptionOnTappingHashtagOnNewlyCreatedVideo(String userType) throws Exception {
			
			 extent.HeaderChildNode("Check if user is able to view Hashtag description on tapping  Hashtag  on newly created video, for user created hashtags");
		        System.out.println("TC_Mobile_007");
		        extent.extentLogger("", "TC_Mobile_007");
			
	       	 verifyElementPresent(HipiHashtagDetailPage.objHashtagDescription, "Hashtag Description");
	       	 waitTime(6000);
	       	  
		}
		
		
		public void  createdToFavourite(String userType) throws Exception {
			 extent.HeaderChildNode("Check if user is able to add a newly Hashtag created to favourite");
		        System.out.println("TC_Mobile_009");
		        extent.extentLogger("", "TC_Mobile_009");
			
		        click(HipiHashtagDetailPage.objFavouriteIcon, "Add To Favourite Icon");
		        
		        if(verifyIsElementDisplayed(HipiMePage.objAddToYourFavourite, "Add To Your Favourite")){
					logger.info("Add To Your Favourite:" + "Add To Your Favourite is displayed when ever click on Favourite Icon");
					extent.extentLoggerPass("Add To Your Favourite:","Add To Your Favourite is displayed when ever click on Favourite Icon");
		        } else {
					logger.info("Add To Your Favourite:" + "Add To Your Favourite is not displayed when ever click on Favourite Icon");
					extent.extentLoggerFail("Add To Your Favourite:","Add To Your Favourite is not displayed when ever click on Favourite Icon");
				}
			
		}
		
		public void profileFavouritesList(String userType) throws Exception {
			
			extent.HeaderChildNode("Verify the hashtag is added to  profile favourites list");
	        System.out.println("TC_Mobile_010");
	        extent.extentLogger("", "TC_Mobile_010");
			waitTime(4000);

			Back(2);
			waitTime(3000);
			click(HipiMePage.objfavourite, "Favourite");
			waitTime(4000);
			click(HipiMePage.objHashtags, "Hashtags");
			waitTime(4000);
			String hashtagIsAddedInTheList = getText(HipiMePage.objHashtagIsAddedInTheList);
			if(verifyIsElementDisplayed(HipiMePage.objHashtagIsAddedInTheList, "Hashtag Is Added In The List")) {
				logger.info("Hashtag Is Added In The List:" + hashtagIsAddedInTheList );
				extent.extentLoggerPass("Hashtag Is Added In The List:","Hashtag Is Added In The List when ever click on Hashtags");
			} else {
				logger.info("Hashtag Is Added In The List:" + "Hashtag Is not Added In The List when ever click on Hashtags");
				extent.extentLoggerFail("Hashtag Is Added In The List:","Hashtag Is not Added In The List when ever click on Hashtags");
			}
			
		}
		public void  removeNewlyHashtagAddedFromFavourite(String userType) throws Exception {
			
			extent.HeaderChildNode("Check if user is able to remove newly Hashtag added from favourite");
	        System.out.println("TC_Mobile_011");
	        extent.extentLogger("", "TC_Mobile_011");
	        
			click(HipiMePage.objvideotab, "Video Tab");
			waitTime(4000);
			click(HipiCreateVideoPage.objselectfirstimage, "First video");
			waitTime(8000);
			  click(HipiHomePage.objHashtagDescription, "Hashtag Description");
			Thread.sleep(6000);
			  click(HipiHashtagDetailPage.objFavouriteIcon, "Favourite Icon");
			  waitTime(1000);
			  click(HipiHashtagDetailPage.objFavouriteIcon, "Favourite Icon");
			  if (verifyIsElementDisplayed(HipiMePage.objRemovieFavourite, "Removie Favourite")) {
					logger.info("Removie favourite popup:" + "Removie favourite popup is displayed");
					extent.extentLoggerPass("Removie favourite popup:","Removie favourite popup is displayed");
					
				} else {
					logger.info("Removie favourite popup:" + "Removie favourite popup is not displayed");
					extent.extentLoggerFail("Removie favourite popup:","Removie favourite popup is not displayed");
				}
			  
			  
		}
		public void hashtagIRemovedFromProfileFavourites(String userType) throws Exception {
			
			extent.HeaderChildNode("Verify the hashtag is removed from profile favourites");
	        System.out.println("TC_Mobile_012");
	        extent.extentLogger("", "TC_Mobile_012");
	        waitTime(10000);
	        click(HipiHashtagDetailPage.objFavouriteIcon, "Add To Favourite Icon");
	        
	        if(verifyElementExist(HipiMePage.objAddToYourFavourite, "Add To Your Favourite")){
				logger.info("Add To Your Favourite:" + "Add To Your Favourite is displayed when ever click on Favourite Icon");
				extent.extentLoggerPass("Add To Your Favourite:","Add To Your Favourite is displayed when ever click on Favourite Icon");
			waitTime(5000);
	        } else {
				logger.info("Add To Your Favourite:" + "Add To Your Favourite is not displayed when ever click on Favourite Icon");
				extent.extentLoggerFail("Add To Your Favourite:","Add To Your Favourite is not displayed when ever click on Favourite Icon");
			}
		
			Back(2);
			click(HipiMePage.objfavourite, "Favourite");
			waitTime(4000);
			click(HipiMePage.objHashtags, "Hashtags");
			waitTime(5000);
			String hashtagIsAddedInTheList = getText(HipiMePage.objHashtagIsAddedInTheList);
			if(verifyIsElementDisplayed(HipiMePage.objHashtagIsAddedInTheList, "Hashtag Is Added In The List")) {
				logger.info("Hashtag Is Added In The List:" + hashtagIsAddedInTheList );
				extent.extentLoggerPass("Hashtag Is Added In The List:","Hashtag Is Added In The List when ever click on Hashtags");
			} else {
				logger.info("Hashtag Is Added In The List:" + "Hashtag Is not Added In The List when ever click on Hashtags");
				extent.extentLoggerFail("Hashtag Is Added In The List:","Hashtag Is not Added In The List when ever click on Hashtags");
			}
			waitTime(5000);
	        click(HipiMePage.objFavouriteIcon, "Favourite Icon");
	        if(verifyElementExist(HipiMePage.objRemovedPopup, "Removed Popup")){
				logger.info("Removed Popup:" + "Removed Popup is displayed when ever click on Favourite icon");
				extent.extentLoggerPass("Removed Popup:","Removed Popup is displayed when ever click on Favourite icon");
			} else {
				logger.info("Removed Popup:" + "Removed Popup is not displayed when ever click on Favourite icon");
				extent.extentLoggerFail("Removed Popup:","Removed Popup is not displayed when ever click on Favourite icon");
			}
		}
		
		
		public void  relatedVideosForNewExistingHashtag(String userType) throws Exception {
			extent.HeaderChildNode("Check if user is able to view related videos for a new/existing Hashtag");
	        System.out.println("TC_Mobile_013");
	        extent.extentLogger("", "TC_Mobile_013");	
	        
			click(HipiMePage.objvideotab, "Video Tab");
			waitTime(5000);
			click(HipiCreateVideoPage.objselectfirstimage, "First video");
			waitTime(8000);
			  click(HipiHomePage.objHashtagDescription, "Hashtag Description");
			  waitTime(5000);
			if(verifyIsElementDisplayed(HipiHashtagDetailPage.objRelatedVideos, "Related Videos")){
				logger.info("Related Videos:" + "Related Videos is displayed when ever click on Hashtag Description");
				extent.extentLoggerPass("Related Videos:","Related Videos is displayed when ever click on Hashtag Description");
			} else {
				logger.info("Related Videos:" + "Related Videos is not displayed when ever click on Hashtag Description");
				extent.extentLoggerFail("Related Videos:","Related Videos is not displayed when ever click on Hashtag Description");
			}
		}
		
		public void tappingOnUseThisHashTagIcon(String userType) throws Exception {
			
			extent.HeaderChildNode("Check if user is able to create video for existing hashtag by tapping on  Use this HashTag Icon");
	        System.out.println("TC_Mobile_014");
	        extent.extentLogger("", "TC_Mobile_014");	
	        
	        click(HipiHashtagDetailPage.objUseThisHashtag, "Use This Hashtag");
	        waitTime(3000);
	      
			 verifyElementPresentAndClick(HipiCreateVideoPage.objrecording,"click on recording");
			 
			 waitTime(20000);
		
				if (verifyElementExist(HipiCreateVideoPage.objVideoEditScreen, "Video Edit Screen")) {

					logger.info("Vide oEdit Screen: " + " When ever recording complet video edit screen is displayed ");
					extent.extentLoggerPass("Video Edit Screen:", "When ever recording complet video edit screen is displayed ");
				} else {
					logger.info("Video Edit Screen: " + " When ever recording complet video edit screen is not displayed ");
					extent.extentLoggerFail("Video Edit Screen:",
							"When ever recording complet video edit screen is not displayed ");
				}
					verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
					waitTime(10000);
	        

						String alreadyHashtagPresent = getText(HipiHashtagDetailPage.objDescriptionTextBoxAlreadyHashtag);
						if(alreadyHashtagPresent.contains("#Fun")) {
							logger.info("Already Hashtag Present:" + alreadyHashtagPresent );
							extent.extentLoggerPass("Already Hashtag Present:", "Already Hashtag Present when ever click on post button");
						} else {
							logger.info("Already Hashtag Present:" + "Already Hashtag not Present when ever click on post button");
							extent.extentLoggerFail("Already Hashtag Present:","Already Hashtag not Present when ever click on post button");
						}
						verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
//						verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
						verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
								" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
						verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "posthipi");// saveasdraft
						waitTime(4000);
						verifyIsElementDisplayed(HipiCreateVideoPage.objVideoUploadPopup, "Video Upload Popup");
						click(HipiCreateVideoPage.objGoToFeedButton, "Go To Feed Button");
						
						waitTime(40000);
						verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
						for (int i = 0; i <= 100; i++) {
							scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
							if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
								Thread.sleep(4000);
								Back(1);
								Thread.sleep(4000);
								verifyElementPresentAndClick(AMDHipi.objmeicon, "me icon");
							} else {
								verifyElementExist(HipiCreateVideoPage.objSelectVideo(alreadyHashtagPresent), "Video");
								click(HipiCreateVideoPage.objselectfirstimage, "First video");
								waitTime(8000);
								break;
							}
						}
		}
		
		public void shareHashtagUsingSocialMedia(String userType) throws Exception {
			
			extent.HeaderChildNode("Check if user is able to share Hashtag using social media");
	        System.out.println("TC_Mobile_015");
	        extent.extentLogger("", "TC_Mobile_015");
	        //clearFacebookData();
	        
	        
	        click(HipiHashtagDetailPage.objShareIcon, "Share Icon");
	        waitTime(10000);
			if (verifyElementExist(HipiShareScreen.objFBOption, "FB Option")) {

				logger.info("FB Option: " + "When evre click on share button FB Option is displayed");
				extent.extentLoggerPass("FB Option: ", "When evre click on share button FB Option is displayed");
				waitTime(3000);
			} else {
				logger.info("FB Option: " + "When evre click on share button FB Option is not displayed");
				extent.extentLoggerFail("FB Option: ", "When evre click on share button FB Option is not  displayed");
			}
			waitTime(5000);

			click(HipiShareScreen.objFBOption, "Facebook Option");
			waitTime(10000);
			
			if(verifyIsElementDisplayed(HipiShareScreen.objFBPostbutton, "Post button")){
				click(HipiShareScreen.objFBPostbutton, "Post Button");
				waitTime(30000);
			}else{
				
				click(HipiEffectPage.objNoneOfTheAbove, "None Of The Above");

//				waitTime(5000);
//				click(HipiShareScreen.objLogintoAnotherAccount, "Loginto Another Account");
				waitTime(5000);
				waitTime(3000);

				String FBusername = getParameterFromXML("fbusername");
				waitTime(5000);
				click(HipiShareScreen.objEmailTextfield, "Phone Number Field");
				waitTime(3000);
				Actions a = new Actions(getDriver());
				a.sendKeys(FBusername);
				a.perform();
				waitTime(3000);
				hideKeyboard();
				waitTime(3000);

				String FBpassword = getParameterFromXML("fbPassword");
				waitTime(5000);
				click(HipiShareScreen.objPassWordfield, "PassWord Field");
				waitTime(3000);
				Actions ab = new Actions(getDriver());
				ab.sendKeys(FBpassword);
				ab.perform();
				hideKeyboard();
				waitTime(4000);
				click(HipiShareScreen.objFBLoginButton, "Log In");

//				if(checkElementExist(HipiShareScreen.objSaveButton, "Save Button")){
//					
		//
//					 logger.info("Save Button:" + "When ever click on login button save popup is displayed");
//						extent.extentLoggerPass("Save Button:", "When ever click on login button save popup is displayed");
//						click(HipiShareScreen.objSaveButton, "Save Button");
//					}else {
//						logger.info("Save Button:" + "When ever click on login button save popup is not displayed");
//						extent.extentLoggerFail("Save Button:", "When ever click on login button save popup is not displayed");
//					}
//				
//				click(HipiShareScreen.objContinueButton, "Continue Button");
				
				waitTime(40000);

				click(HipiShareScreen.objFBPostbutton, "Post Button");
				waitTime(30000);
//				clearFacebookData();
//				waitTime(60000);

			}
		}
		
		public void  messageByTappingOnBackButton(String userType) throws Exception {
			
			extent.HeaderChildNode("Check if user is unable to share Hashtag to following people with a message by tapping on back button");
	        System.out.println("TC_Mobile_016");
	        extent.extentLogger("", "TC_Mobile_016");
//	        click(HipiHomePage.objHashtagDescription, "Description");
	        waitTime(5000);
	        click(HipiHashtagDetailPage.objShareIcon, "Share Icon");
	        waitTime(10000);
	        if (verifyElementExist(HipiShareScreen.objShareDeailsScreen, "Share Deails Screen")) {

				logger.info("Share Deails Screen:" + "When ever click on share button share deails screen is displayed");
				extent.extentLoggerPass("Share Deails Screen:",
						"When ever click on share button share deails screen is displayed");

			} else {
				logger.info(
						"Share Deails Screen:" + "When ever click on share button share deails screen is not displayed");
				extent.extentLoggerFail("Share Deails Screen:",
						"When ever click on share button share deails screen is not displayed");
			}

			click(HipiShareScreen.objSMS, "SMS Button");

			waitTime(9000);
			
//			click(HipiShareScreen.objCancleButton, "Cancle Button");
//			waitTime(5000);

			click(HipiShareScreen.objNewMessage, "New Message");
			waitTime(4000);
			click(HipiShareScreen.objBackNavigation , "Back Navigation ");
			waitTime(3000);
			verifyIsElementDisplayed(HipiShareScreen.objNotSentTapToTryAgain, "Not Sent Tap To Try Again");
			
			
		}
		
		public void  messageByTappingOnSend(String userType) throws Exception {

			extent.HeaderChildNode("Check if user is able to share HashTag to following people with a message by tapping on send");
	        System.out.println("TC_Mobile_017");
	        extent.extentLogger("", "TC_Mobile_017");
	        
	        click(HipiHashtagDetailPage.objShareIcon, "Share Icon");
	        waitTime(10000);
	        if (verifyElementExist(HipiShareScreen.objShareDeailsScreen, "Share Deails Screen")) {

				logger.info("Share Deails Screen:" + "When ever click on share button share deails screen is displayed");
				extent.extentLoggerPass("Share Deails Screen:",
						"When ever click on share button share deails screen is displayed");

			} else {
				logger.info(
						"Share Deails Screen:" + "When ever click on share button share deails screen is not displayed");
				extent.extentLoggerFail("Share Deails Screen:",
						"When ever click on share button share deails screen is not displayed");
			}

	 
		click(HipiShareScreen.objSMS, "SMS Button");
		waitTime(4000);
//		 click(HipiCoolGlassesEffect.objSelectContact, "Contect");

		click(HipiShareScreen.objNewMessage, "New Message");
		waitTime(4000);

		click(HipiShareScreen.objnumberIcon, "Number Icon");

		waitTime(4000);
		String enterphonenumber = getParameterFromXML("enterPhonenumber");

		type(HipiShareScreen.objtypeNumber, enterphonenumber, "Enter Number");
		waitTime(5000);
		click(HipiShareScreen.objclickonTICK, "Tick Button");
		waitTime(9000);
		click(HipiShareScreen.objSendButton, "Send Button");

//		waitTime(5000);
		hideKeyboard();
		waitTime(9000);

		if (verifyElementExist(HipiShareScreen.objchecksendlink, "Link")) {

			logger.info("Link:" + "#Fun Link is displayed");
			extent.extentLoggerPass("Link:", "#Fun Link is displayed");

			
		} else {
			logger.info("Link:" + "#Fun Link is not displayed ");
			extent.extentLoggerFail("Link:", "#Fun Link is not displayed ");
		}
		click(HipiShareScreen.objchecksendlink, "SMS Link");
		waitTime(15000);
		  
	 	  if (verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagDetailScreen, "Hashtag Detail Screen")) {

				logger.info("Hashtag Detail Screen:" + "Hashtag Detail Screen is displayed when ever click on Hashtag Description");
				extent.extentLoggerPass("Hashtag Detail Screen:","Hashtag Detail Screen is displayed when ever click on Hashtag Description");
			
			} else {
				logger.info("Hashtag Detail Screen:" + "Hashtag Detail Screen is not displayed when ever click on Hashtag Description");
				extent.extentLoggerFail("Hashtag Detail Screen:","Hashtag Detail Screen is not displayed when ever click on Hashtag Description");
			}
	}
		
		public void verifyOnTappingFullImageIsDisplayed(String userType) throws Exception {
			

			extent.HeaderChildNode("Check if user is able to view hashtag tumbnail and verify on tapping  full image is displayed");
	        System.out.println("TC_Mobile_018");
	        extent.extentLogger("", "TC_Mobile_018");
	  	  click(HipiHomePage.objHashtagDescription, "Hashtag Description");
	  	  waitTime(5000);
	        if(verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagThumnail, "Hashtag Thumnail")){
	        	logger.info("Hashtag Thumnail:" + "Hashtag Thumnail is displayed when ever click on #fun");
				extent.extentLoggerPass("Hashtag Thumnail:","Hashtag Thumnail is displayed when ever click on #fun");
			click(HipiHashtagDetailPage.objHashtagThumnail, "Hashtag Thumnail");
			waitTime(4000);
			} else {
				logger.info("Hashtag Thumnail:" + "Hashtag Thumnail is not displayed when ever click on #fun");
				extent.extentLoggerFail("Hashtag Thumnail:","Hashtag Thumnail is not displayed when ever click on #fun");
			}
			
	        if(verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagImage, "Hashtag Image")){
	        	logger.info("Hashtag Image:" + "Hashtag Image is displayed when ever click on Hashtag Thumnail");
				extent.extentLoggerPass("Hashtag Image:","Hashtag Image is displayed when ever click on Hashtag Thumnail");
		
			} else {
				logger.info("Hashtag Image:" + "Hashtag Image is not displayed when ever click on Hashtag Thumnail");
				extent.extentLoggerFail("Hashtag Image:","Hashtag Image is not displayed when ever click on Hashtag Thumnail");
			}
		}
		
		public void  viewTermsAndConditions(String userType) throws Exception {

			extent.HeaderChildNode("Check if user is able to view terms and conditions by tapping on 3 dots icon at Hashtag detail screen");
	        System.out.println("TC_Mobile_021");
	        extent.extentLogger("", "TC_Mobile_021");
			
	        Back(1);
	        click(HipiHashtagDetailPage.objThreeDots, "Three Dots");
			waitTime(5000);
			if(verifyIsElementDisplayed(HipiHashtagDetailPage.objTermsAndConditions, "Terms And Conditions")){
				logger.info("Terms And Conditions:" + "Terms And Conditions is displayed when ever click on Three Dots");
				extent.extentLoggerPass("Terms And Conditions:","Terms And Conditions is displayed when ever click on Three Dots");
		click(HipiHashtagDetailPage.objTermsAndConditions, "Terms And Conditions");
		
			} else {
				logger.info("Terms And Conditions:" + "Terms And Conditions is not displayed when ever click on Three Dots");
				extent.extentLoggerFail("Terms And Conditions:","Terms And Conditions is not displayed when ever click on Three Dots");
			}
			waitTime(9000);
			if(verifyIsElementDisplayed(HipiHashtagDetailPage.objTermsAndConditionsScreen, "Terms And Conditions Screen")){
				logger.info("Terms And Conditions Screen:" + "Terms And Conditions Screen is displayed when ever click on Terms And Conditions");
				extent.extentLoggerPass("Terms And Conditions Screen:","Terms And Conditions Screen is displayed when ever click on Terms And Conditions");
		
			} else {
				logger.info("Terms And Conditions Screen:" + "Terms And Conditions Screen is not displayed when ever click on Terms And Conditions");
				extent.extentLoggerFail("Terms And Conditions Screen:","Terms And Conditions Screen is not displayed when ever click on Terms And Conditions");
			}
		}
		
		public void disclaimerBelowToHashtagDescription(String userType) throws Exception {
			extent.HeaderChildNode("Check if user is able to view disclaimer below to description on tapping  Hashtag  on newly created video");
	        System.out.println("TC_Mobile_022");
	        extent.extentLogger("", "TC_Mobile_022");
	        
	        Back(1);
			 if(verifyElementPresent(HipiHashtagDetailPage.objHashtagDescription, "Hashtag Description")) {
				 logger.info("Hashtag Description:" + "Disclaimer Hashtag description is displayed when ever click on Back Button");
					extent.extentLoggerPass("Hashtag Description:","Disclaimer Hashtag description is displayed when ever click on Back Button");
			
				} else {
					logger.info("Hashtag Description:" + "Disclaimer Hashtag description is displayed when ever click on Back Button");
					extent.extentLoggerFail("Hashtag Description:","Disclaimer Hashtag description is displayed when ever click on Back Button");
				}

		}
		
		public void  videoCountOnTappingHashtag(String userType) throws Exception {
			extent.HeaderChildNode("Check if user is able to view Hashtag number of video count on tapping  Hashtag  on newly created video");
	        System.out.println("TC_Mobile_032");
	        extent.extentLogger("", "TC_Mobile_032");
	        String numberOfLikeVideoCount = getText(HipiHashtagDetailPage.objHashtagNumberOfLikeVideoCount);
			
	        if(verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagNumberOfLikeVideoCount, "Number Of Like Video Count")) {
	        	 logger.info("Number Of Like Video Count:" + numberOfLikeVideoCount );
					extent.extentLoggerPass("Number Of Like Video Count:","Number Of Like Video Count is dislayed when ever click on #Fun");
			
				} else {
					logger.info("Number Of Like Video Count:" + "Number Of Like Video Count is not dislayed when ever click on #Fun");
					extent.extentLoggerFail("Number Of Like Video Count:","Number Of Like Video Count is not dislayed when ever click on #Fun");
				}
	        
		}
		
		public void numberOfViewsTappingHashtag(String userType) throws Exception {
			
			extent.HeaderChildNode("Check if user is able to view Hashtag number of  views  on tapping  Hashtag  on newly created video");
	        System.out.println("TC_Mobile_033");
	        extent.extentLogger("", "TC_Mobile_033");
			
	        String numberOfViewVideoCount = getText(HipiHashtagDetailPage.objHashtagNumberOfViewVideoCount);
	        
	        if(verifyIsElementDisplayed(HipiHashtagDetailPage.objHashtagNumberOfViewVideoCount, "Number Of View Video Count")) {
	       	 logger.info("Number Of View Video Count:" + numberOfViewVideoCount );
					extent.extentLoggerPass("Number Of View Video Count:","Number Of View Video Count is dislayed when ever click on #Fun");
			
				} else {
					logger.info("Number Of View Video Count:" + "Number Of View Video Count is not dislayed when ever click on #Fun");
					extent.extentLoggerFail("Number Of View Video Count:","Number Of View Video Count is not dislayed when ever click on #Fun");
				}
			
		}

		
		
		
		
		
	//------------------------------------------------------------------------------------------------------------------
		
		
		
		
		public void ValidationOfPopular(String userType) throws Exception {
			extent.HeaderChildNode("Validation of Popular");
			
			if(userType.equalsIgnoreCase("Guest")) {
				//Guest
				
			}else {
				validatingHipiSection(userType);

			}
		}
		
		
		public void validatingHipiSection(String userType) throws Exception {
			extent.HeaderChildNode("validatingHipiSection");
			waitTime(2);
			extent.HeaderChildNode("Popular Check if user is able to redirect to other Hipi sections by tapping on Hipi, Discover and Me icons");
			System.out.println("TC_Mobile_001");		
			extent.extentLogger("", "TC_Mobile_001");
			
			if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
    			click(AMDOnboardingScreen.objHipiButton, "HiPi");
    			Thread.sleep(6000);

    		} else {

    		}
			
			validatingScreenDisplayed(HipiFeedPage.objFeedButton, "Hipi Home", HipiFeedPage.objBottomMenuHighlighted, "Hipi Home screen" );
			Wait(2);
			validatingScreenDisplayed(HipiFeedPage.objDiscoverButton, "Discover", HipiFeedPage.objBottomMenuHighlighted, "Discover screen" );
			verifyElementPresentAndClick(HipiPopularPage.objpopulartext, "Popular screen");
			verifyElementDisplayed(HipiPopularPage.objpopulartitle);
			
			
			// verify popular screen is displayed
			extent.HeaderChildNode("Popular Check if on tapping on Popular Icon, Popular screen is displayed");
			System.out.println("TC_Mobile_003");		
			extent.extentLogger("", "TC_Mobile_003");
			validatingScreenDisplayed(HipiPopularPage.objpopulartext, "Popular", HipiFeedPage.objBottomMenuHighlighted, "Popular screen" );
			
			//Popular title name is displayed
			extent.HeaderChildNode("Popular Check layout of Popular Screen");
			System.out.println("TC_Mobile_002");		
			extent.extentLogger("", "TC_Mobile_002");
			verifyElementPresent(HipiPopularPage.objPopularLayout, "Popular screen Layout");
			
		   String pageName = getText(HipiPopularPage.objpopulartitle);
		   if(pageName.contains(HipiPopularPage.objtextPopular))
		   {extent.extentLogger("",HipiPopularPage.objtextPopular + " title is displayed" );
		   extent.extentLoggerPass("", "Popular title is displayed in popular screen");}
		   else
		   {extent.extentLogger("",HipiPopularPage.objtextPopular + " title is not displayed" );
		   extent.extentLoggerFail("", "Popular title is not displayed in popular screen");}
		   
		   //Different tiles are displaying
		   verifyElementPresent(HipiPopularPage.objCreatorName, "Creator1 name ");
		   String CreatorName =getText(HipiPopularPage.objCreatorName);
		   verifyElementPresent(HipiPopularPage.objCreatorName, "Creator2 name ");
		   String Creator2Name =getText(HipiPopularPage.objCreator2Name);
		   if(CreatorName.contentEquals(Creator2Name))
		   {extent.extentLoggerFail("", "Different tiles fails to display");}
		   else
		   {extent.extentLoggerPass("", "Different tiles are displayed");}
		   
		   //Followers validation
		   extent.HeaderChildNode("Popular Verify count format on tapping Followers/following list of popular icon");
			System.out.println("TC_Mobile_004");		
			extent.extentLogger("", "TC_Mobile_004");
			verifyElementPresent(HipiPopularPage.objCreatorName, "Creator name");
		   verifyElementPresent(HipiPopularPage.objCreatorfollowers, "Creators no of followers ");
		   verifyElementPresent(HipiPopularPage.objCreatorthumbnailimage, "Creator thumbnail image ");
		   
		  
		   verifyElementPresentAndClick(HipiPopularPage.objCreatorthumbnailimage, "a Creator");
		   waitTime(4);
		   if(verifyElementDisplayed(HipiPopularPage.objfollowerscount))
		   {
		   extent.extentLogger(""," Creators follower count is displayed" );
			   extent.extentLoggerPass("", "Creators follower count is displayed");}
		   else
		   {
			   extent.extentLoggerFail("", "Creators follower count is not displayed");}
		   
		   if(verifyElementDisplayed(HipiPopularPage.objfollowingcount))
		   {
			   extent.extentLoggerPass("", "Creators following count is displayed");}
		   else
		   {extent.extentLoggerFail("", "Creators following count is not displayed");}
		   
		   String followersCount = getText(HipiPopularPage.objfollowerscount);
		   String followingCount = getText(HipiPopularPage.objfollowingcount);
		   
		   verifyElementPresentAndClick(HipiPopularPage.objfollowerscount, "Followers Count : "+followersCount);
		   Wait(5);
		 //Verify both followers count is same
		   verifyElementPresent(HipiPopularPage.objFollowingScreen, "followers list screen");
		   Wait(2);
		   String txtFollowersCountScreen = getText(HipiPopularPage.objFollowingScreen);
		   String[] text = txtFollowersCountScreen.split("\\(");
		   String Text1 = text[1];
		   String[] text2 = Text1.split("\\)");
		   String followersCountScreen = text2[0];
		   
		   System.out.println(followersCountScreen);
		   extent.extentLogger("", "Followers count in list : "+followersCountScreen);
		   if(followersCount.contains(followersCountScreen))
			   
		   {
			   System.out.println(followersCountScreen);
			   extent.extentLoggerPass(""," followers count are in same format" );
		   }
		   else
		   {
			   extent.extentLoggerFail(""," followers count are not in same format" );
		   }
		   
		   verifyElementPresentAndClick(HipiPopularPage.objFollowScreenBackbutton, "back button");
		   
		   //Verify both following count is same
		   Wait(3);
		   verifyElementPresentAndClick(HipiPopularPage.objfollowingcount, "Following count : "+followingCount);
		   verifyElementPresent(HipiPopularPage.objFollowingScreen, "following list screen");
		   String txtFollowingCountScreen = getText(HipiPopularPage.objFollowingScreen);
		   
		   String[] count = txtFollowingCountScreen.split("\\(");
		   String count1 = count[1];
		   String[] count2 = count1.split("\\)");
		   String followingCountScreen = count2[0];
		   
		   extent.extentLogger("", "Following count in list : "+followingCountScreen);
		   
		   if(followingCount.contentEquals(followingCountScreen))
		   {
			   System.out.println(followingCountScreen);
			   extent.extentLoggerPass(""," following counts are in same format" );
			 }
		   else
		   {
		   extent.extentLoggerFail("", "following counts are not in same format");}
		   Wait(3);
		   verifyElementPresentAndClick(HipiPopularPage.objFollowScreenBackbutton, "back button");//
		   
		   extent.HeaderChildNode("Popular Check if on tapping on particular creator tile, Creator Profile is displayed and verify all options in creator profile screen");
			System.out.println("TC_Mobile_005");		
			extent.extentLogger("", "TC_Mobile_005");
			
		   //Verify the details displayed for the creator profile are as correct
			Wait(3);
			verifyElementDisplayed(HipiPopularPage.objCreatorUserName);
			String CreatorUserName = getText(HipiPopularPage.objCreatorUserName);
			if(CreatorUserName.contains(CreatorName))
			   {extent.extentLoggerPass("", "Creator profile displayed is correct");}
			   else
			   {extent.extentLoggerFail("", "Creator profile displayed is incorrect");}
			
			String videoDesc=getText(HipiPopularPage.objvideoDes);
			   
			verifyElementPresentAndClick(HipiPopularPage.objCreatorvideo, "Creator video");
			Wait(5);
			//add video fav
			longPress(HipiFeedPage.objFeedLongPress);
			if(verifyElementPresent(HipiPopularPage.objAddToFav,"Add Favourite button "))
			   {extent.extentLogger(""," Video can be added to Favourite" );
			   Wait(2);
			   click(HipiPopularPage.objAddToFav, "Video is Added to favourite");
			   }
			   else
			   {extent.extentLogger(""," Video is already added to Favourite" );
			   Back(1);
			   }
			   //verifyElementPresentAndClick(HipiPopularPage.objBack, "back button");
				
			   Wait(2);
			   
			   
			   
		   
//			   longPress(HipiFeedPage.objFeedLongPress);
//				if (verifyElementExist(HipiPopularPage.objAddToFav,"Add Favourite button")) {
//					 click(HipiPopularPage.objAddToFav, "Video is Added to favourite");}
//					 else 
//					 {extent.extentLogger(""," video is already added to Favourite" );}
			
			
			//Add sound fav
			
			verifyElementPresent(HipiPopularPage.objCreatorVideoSound, "creator Sound");
			String Sound = getText(HipiPopularPage.objCreatorVideoSound);
			click(HipiPopularPage.objCreatorVideoSound, "creator Sound");
			Wait(2);
//			verifyElementPresentAndClick(HipiPopularPage.objUsethisSound, "Use this sound");
//		   verifyElementPresentAndClick(HipiPopularPage.objReadyOkButton, "OK button");
//		   verifyElementPresentAndClick(HipiCreateVideoPage.objBack, "Back button");
			
		   
		   if(verifyElementPresent(HipiPopularPage.objAddMusicFav,"Add Music Favourite"))
		   {extent.extentLogger("","Sound can be added to Favourite" );
		   click(HipiPopularPage.objAddMusicFav,"Added to Favourite");
		   Wait(8);
		   verifyElementPresentAndClick(HipiPopularPage.objBack, "back button");
		   
		   }
		   else
		   {extent.extentLogger("","Sound is already added to Favourite" );
		   verifyElementPresentAndClick(HipiPopularPage.objBack, "back button");}
		   
		   
		   //tap on + to follow popular user
		   if(verifyElementPresent(HipiPopularPage.objfollowPlusIcon, "+ follow button"))
		   {click(HipiPopularPage.objfollowPlusIcon,"following a popular creator");
		   click(HipiPopularPage.objProfileImageview, "Profile");
		   Wait(2);
		   if(verifyElementPresent(HipiPopularPage.objfollowingButton , "Following button"))
		   {System.out.println("User is following a popular creator");
		   extent.extentLoggerPass("","User is following a popular creator");
		   Wait(2);
		   click(HipiPopularPage.objfollowingButton , "Following button");//Unfollow
			   }
		   else
		   {extent.extentLoggerFail("","User fails to follow a popular creator");
		   Wait(2);}
		   }
		   
		   else
		   {extent.extentLogger(""," user is already following a popular creator" );
		   click(HipiPopularPage.objProfileImageview, "Profile");
		   Wait(2);
		   if(verifyElementPresent(HipiPopularPage.objfollowButton , "Following"))
		   {extent.extentLoggerPass("","User is following a popular creator");
		   System.out.println("User is following a popular creator");
		   }
		   else
		   {extent.extentLoggerFail("","User fails to follow a popular creator");
		   }}
		   verifyElementPresentAndClick(HipiPopularPage.objbackbutton, "back button");
		   Wait(2);
		   verifyElementPresentAndClick(HipiPopularPage.objBack, "back button");
		   verifyElementPresentAndClick(HipiPopularPage.objbackbutton, "back button");
//		   verifyElementPresentAndClick(HipiPopularPage.objCreatorthumbnailimage, "a Creator");
		   
		   
		   //verifyElementPresentAndClick(HipiPopularPage.objbackbutton, "back button");
		   verifyElementPresentAndClick(HipiMePage.objMeicon, "Me");
		   verifyElementPresentAndClick(HipiPopularPage.objFavouritesTab, "Favourite tab");
		   
		   //Verify sound and video is fav
		   verifyElementPresent(HipiPopularPage.objVideosTab, "Videos tab");
		   Wait(5);
		   String FavVideo = getText(HipiPopularPage.objFavouritedVideo);
		   if(FavVideo.contains(videoDesc))
		   {extent.extentLoggerPass("", "Video is added to Favourites tab");
		   System.out.println("Video is added to Favourites tab");
		   click(HipiPopularPage.objStarIcon, "Star icon");
		   }
		   else
		   {extent.extentLoggerFail("", "Video fails to get added to Favourites tab");}
		   Wait(2);
		   verifyElementPresentAndClick(HipiPopularPage.objSoundsTab, "Sounds tab");
		   String FavSound = getText(HipiPopularPage.objFavouritedSound);
		   if(FavSound.contains(Sound))
		   {
			   System.out.println("Sound is added to Favourites tab");
			   extent.extentLoggerPass("", "Sound is added to Favourites tab");}
		   else
		   {extent.extentLoggerFail("", "Sound fails to get added to Favourites tab");}
		   Wait(2);
		   verifyElementPresentAndClick(HipiPopularPage.objUnfavouritedSound, "Unfavorite sound");
		   Wait(2);
		   
		   
		   
		   //verifyElementPresentAndClick(HipiMePage.objMeicon, "Me");//remove later
		   
		   verifyElementPresentAndClick(HipiPopularPage.objfollowingcount, "Following Count");
		   Wait(8);
		   verifyElementPresent(HipiMePage.objFollowersUsername, "followers Username"); 
		   
		   String UserName = getText(HipiMePage.objFollowersUsername);
		   
		   Wait(5);
		   verifyElementPresentAndClick(HipiMePage.objFollowersUsername, "Following user");
		   Wait(5);
		   String UserNameProfile = getText(HipiMePage.objFollowersProfileUsername);
		   if(UserName.contains(UserNameProfile))
		   {System.out.println("Followers username is displayed");
		   extent.extentLoggerPass("", "acessed user profile is dispalyed");}
		   else
		   {System.out.println("Followers username is not displayed");
		   extent.extentLoggerFail("", "acessed user profile is not dispalyed");}
		   Wait(2);
		  
		//   verifyElementPresentAndClick(HipiPopularPage.objbackbtn, "Back button");
		//   Back(1); //remove com
		   Wait(5);
	       if(verifyElementDisplayed(HipiPopularPage.objpopulartitle))
		   {extent.extentLoggerPass("", "User is redirected to Followers listing screen");}
		   else
		   {extent.extentLoggerFail("", "User is not redirected to Followers screen");}
		   Back(1);
		   verifyElementPresentAndClick(HipiMePage.objfollowerpagebackbtn, "Back button");
		   Wait(2);
		   verifyElementPresentAndClick(HipiPopularPage.objbackbtn, "Back button");
		   if(verifyElementDisplayed(HipiPopularPage.objpopulartext))
		   {extent.extentLoggerPass("", "User is redirected to Popular screen");}
		   else
		   {extent.extentLoggerFail("", "User is not redirected to Popular screen");}
		  
			

			
			
			
			
			
		}
		
		public void validatingScreenDisplayed(By locator, String str,By locator2, String str2) throws Exception{

			verifyElementPresentAndClick(locator, str);
			
			if(verifyIsElementDisplayed(locator2, str2)){
				extent.extentLoggerPass("", "User is navigated to "+ str2);
			}else{
				extent.extentLoggerFail("", "User is not navigated to " +str2);
			}
		}
		
		
		
		
		
	
		//---------------------------------------------------------------------------------------------------------------
		
		
		
		
		
		
		// ============================== Profile Settings Module - Satish ============================================
		
		
		public void ProfileSettings(String userType) throws Exception {
			extent.HeaderChildNode("Profile Settings");
		
			if(userType.equalsIgnoreCase("Guest")){
			
			}else{
			
				extent.HeaderChildNode("Check if on tapping setting icon user is directed HiPi Settings screen");
				extent.extentLogger("", "TC_Mobile_001");System.out.println("TC_Mobile_001");
			
				verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
			
				if (verifyIsElementDisplayed(HipiFeedPage.objfeed, "HiPi Feed")) {
					verifyElementPresentAndClick(HipiFeedPage.objMeImage, "Me icon");
					verifyElementPresentAndClick(HipiMePage.objsettingsicon, "Settings icon");
					if (verifyIsElementDisplayed(HipiSettingsPage.objHipiSettingsPageTitle, "HiPi Settings Screen Title")) {
						logger.info("User is navigated HiPi Settings screen");
						extent.extentLoggerPass("HiPi Landing screen", "User is navigated HiPi Settings screen");
					}else {
						logger.error("User is not navigated HiPi Settings screen");
						extent.extentLoggerFail("HiPi Landing screen", "User is not navigated HiPi Settings screen");
					}
				
					extent.HeaderChildNode("Check if on tapping Edit HiPi profile user is directed to Edit Profile screen");
					extent.extentLogger("", "TC_Mobile_002");System.out.println("TC_Mobile_002");
					verifyElementPresentAndClick(HipiSettingsPage.objEditHiPiProfileOption, "Edit HiPi Profile option");
					if (verifyIsElementDisplayed(HipiSettingsPage.objEditProfilePageTitle, "Edit Profile Screen Title")) {
						logger.info("User is navigated Edit Profile screen");
						extent.extentLoggerPass("Edit Profile screen", "User is navigated Edit Profile screen");
					}else {
						logger.error("User is not navigated Edit Profile screen");
						extent.extentLoggerFail("Edit Profile screen", "User is not navigated Edit Profile screen");
					}
				
					click(HipiSettingsPage.objHiPiImgBackButton, "Back Button in Edit Profile");
				
				
				
					extent.HeaderChildNode("Check if on tapping HiPi preferences user is directed to HiPi preferences screen");
					extent.extentLogger("", "TC_Mobile_003");System.out.println("TC_Mobile_003");
					verifyElementPresentAndClick(HipiSettingsPage.objHiPiPreferencesOption, "HiPi Preferences option");
					if (verifyIsElementDisplayed(HipiSettingsPage.objHiPiPreferencesPageTitle, "HiPi Preferences Screen Title")) {
						logger.info("User is navigated HiPi Preferences screen");
						extent.extentLoggerPass("HiPi Preferences screen", "User is navigated HiPi Preferences screen");
						
						extent.HeaderChildNode("Preferences Check by default allow like option is set to enabled");
						extent.extentLogger("", "TC_Mobile_004");System.out.println("TC_Mobile_004");
						if(toggleButtonStatusValidation(HipiSettingsPage.objToggleButton("Allow Likes"), "Allow Likes")) {
							logger.info("Allow like option is by default set to enabled");
							extent.extentLoggerPass("Allow like Preference", "Allow like option is by default set to enabled");
						}else {
							logger.error("Allow like option is by default set to disabled");
							extent.extentLoggerFail("Allow like Preference", "Allow like option is by default set to disabled");
						}
						
						extent.HeaderChildNode("Preferences Check by default allow Comments option is set to enabled");
						extent.extentLogger("", "TC_Mobile_007");System.out.println("TC_Mobile_007");
						if(toggleButtonStatusValidation(HipiSettingsPage.objToggleButton("Allow Comments"), "Allow Comments")) {
							logger.info("Allow Comments option is by default set to enabled");
							extent.extentLoggerPass("Allow Comments Preference", "Allow Comments option is by default set to enabled");
						}else {
							logger.error("Allow Comments option is by default set to disabled");
							extent.extentLoggerFail("Allow Comments Preference", "Allow Comments option is by default set to disabled");
						}
						
						extent.HeaderChildNode("Check by default allow Video Downloads option is set to enabled");
						extent.extentLogger("", "TC_Mobile_010");System.out.println("TC_Mobile_010");
						if(toggleButtonStatusValidation(HipiSettingsPage.objToggleButton("Allow Video Download"), "Allow Video Download")) {
							logger.info("Allow Video Downloads option is by default set to enabled");
							extent.extentLoggerPass("Allow Video Downloads Preference", "Allow Video Downloads option is by default set to enabled");
						}else {
							logger.error("Allow Video Downloads option is by default set to disabled");
							extent.extentLoggerFail("Allow Video Downloads Preference", "Allow Video Downloads option is by default set to disabled");
						}
					
						extent.HeaderChildNode("Check by default allow Sharing option is set to enabled");
						extent.extentLogger("", "TC_Mobile_013");System.out.println("TC_Mobile_013");
						if(toggleButtonStatusValidation(HipiSettingsPage.objToggleButton("Allow Sharing"), "Allow Sharing")) {
							logger.info("Allow Sharing option is by default set to enabled");
							extent.extentLoggerPass("Allow Sharing Preference", "Allow Sharing option is by default set to enabled");
						}else {
							logger.error("Allow Sharing option is by default set to disabled");
							extent.extentLoggerFail("Allow Sharing Preference", "Allow Sharing option is by default set to disabled");
						}
					
					
					
					
					}else {
						logger.error("User is not navigated HiPi Preferences screen");
						extent.extentLoggerFail("HiPi Preferences screen", "User is not navigated HiPi Preferences screen");
					}
					
					
					click(HipiSettingsPage.objHiPiBackButton, "Back Button HiPi Preferences");
				
					extent.HeaderChildNode("Check by default Download over WiFi only option is set to enabled");
					extent.extentLogger("", "TC_Mobile_016");System.out.println("TC_Mobile_016");
					if(toggleButtonStatusValidation(HipiSettingsPage.objToggleButton("Download over WiFi only"), "Download over WiFi only")) {
						logger.info("Allow Download over WiFi only option is by default set to enabled");
						extent.extentLoggerPass("Allow Download over WiFi only Preference", "Allow Download over WiFi only option is by default set to enabled");
					}else {
						logger.error("Allow Download over WiFi only option is by default set to disabled");
						extent.extentLoggerFail("Allow Download over WiFi only Preference", "Allow Download over WiFi only option is by default set to disabled");
					}
					ProfileSettingsPreferencesEnabledValidation(userType);
					
					BackToFeedScreen();
					waitTime(1000);
					Back(1);
					waitTime(1000);
					logout();
					waitTime(1000);
					LoginUsingAccountCredentials(getParameterFromXML("NonsubscribedUserName1"), getParameterFromXML("NonsubscribedPassword1"));
					ProfileSettingsPreferencesDisabledValidation(userType);
					
				} else {
					logger.error("User is not able to view HiPi Landing screen with logged in user");
					extent.extentLoggerFail("HiPi Landing screen", "User is not able to view HiPi Landing screen with logged in user");
				}
				
			}
		}
		
		public void ProfileSettingsPreferencesEnabledValidation(String userType) throws Exception {
			extent.HeaderChildNode("Profile Settings Preferences Validation");
		
			if(userType.equalsIgnoreCase("Guest")){
			
			}else{
				
				String postDescription = "Desc"+GeneratingRandomString(7);
				CreateVideoForHiPiPreferencesValidation(postDescription);
				
				waitTime(29000);

				Back(1);
				click(HipiFeedPage.objFeedScreenBackButton, "Back Button in Feed Screen");
				logout();
				waitTime(2000);
				if(userType.equalsIgnoreCase("NonSubscribedUser")){
					LoginUsingAccountCredentials(getParameterFromXML("NonsubscribedUserName2"), getParameterFromXML("NonsubscribedPassword2"));
				}else if(userType.equalsIgnoreCase("SubscribedUser")){
					LoginUsingAccountCredentials(getParameterFromXML("SubscribedUserName2"), getParameterFromXML("SubscribedPassword2"));
				}
				verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
				if (verifyElementExist(HipiFeedPage.objfeed, "HiPi Feed")) {
					verifyElementPresentAndClick(HipiFeedPage.objMeImage, "Me Button");
					verifyElementPresentAndClick(HipiMePage.objfollowing, "Following option");
					verifyElementPresentAndClick(HipiMePage.objFirstUserInFollowingScreen, "First User In Following Screen");
					verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), postDescription);
					scrolltomiddle(HipiCreateVideoPage.objSelectVideo(postDescription));
					click(HipiCreateVideoPage.objSelectVideo(postDescription), postDescription);
					
					extent.HeaderChildNode("Check if Normal User is allowed to comment on a video when allow Comments option is set to enabled");
					extent.extentLogger("", "TC_Mobile_008");System.out.println("TC_Mobile_008");
//					String clickableStatusOfCommentIcon = findElement(HipiFeedPage.objcommenticon).getAttribute("clickable");
					verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "Comment icon");
					waitTime(2000);
					if(verifyElementExist(HipiFeedPage.objcommentbox, "Comment Text field")) {
						logger.info("User is able to comment on a video when allow Comments option is set to enabled");
						extent.extentLoggerPass("Comment icon status", "User is able to comment on a video when allow Comments option is set to enabled");
						Back(1);
					}else {
						logger.error("User is unable to comment on a video when allow Comments option is set to enabled");
						extent.extentLoggerFail("Comment icon status", "User is unable to comment on a video when allow Comments option is set to enabled");
					}
					
					
					extent.HeaderChildNode("Check if Normal User is allowed to download a video when allow Video Downloads option is set to enabled");
					extent.extentLogger("", "TC_Mobile_011");System.out.println("TC_Mobile_011");
					longPress(HipiFeedPage.objFeedLongPress);
					waitTime(2000);
					if(verifyElementExist(HipiFeedPage.objdownloadvideo, "Download Video option")) {
						logger.info("User is able to download the video when allow Video Downloads option is set to enabled");
						extent.extentLoggerPass("Download option status", "User is able to download on a video when allow Video Downloads option is set to enabled");
						Back(1);
					}else {
						logger.error("User is unable to download the video when allow Video Downloads option is set to enabled");
						extent.extentLoggerFail("Download option status", "User is unable to download the video when allow Video Downloads option is set to enabled");
					}
					
					
					extent.HeaderChildNode("Check if Normal User is allowed to sharing a video when allow Sharing option is set to enabled");
					extent.extentLogger("", "TC_Mobile_014");System.out.println("TC_Mobile_014");
//					String clickableStatusOfShareIcon = findElement(HipiFeedPage.objshare).getAttribute("clickable");
					verifyElementPresentAndClick(HipiFeedPage.objshare, "Share icon");
					waitTime(2000);
					if(verifyElementExist(AMDPlayerScreen.objFacebook, "Facebook share option")) {
						logger.info("User is able to share on a video when allow Sharing option is set to enabled");
						extent.extentLoggerPass("Share icon status", "User is able to share on a video when allow Sharing option is set to enabled");
						Back(1);
					}else {
						logger.error("User is unable to share on a video when allow Sharing option is set to enabled");
						extent.extentLoggerFail("Share icon status", "User is unable to share on a video when allow Sharing option is set to enabled");
					}
					
					
					extent.HeaderChildNode("Check if user is allowed to download a video when Download over WiFi only option is set to enabled over WiFi");
					extent.extentLogger("", "TC_Mobile_017");System.out.println("TC_Mobile_017");
					longPress(HipiFeedPage.objFeedLongPress);
					verifyElementPresentAndClick(HipiFeedPage.objdownloadvideo, "Download Video option");
					
					if(verifyElementExist(HipiFeedPage.objDownloadCompletePopup, "Download Complete Popup")) {
						logger.info("User is able to download the video when allow Download over WiFi only option is set to enabled");
						extent.extentLoggerPass("Download over WiFi only option status", "User is able to download on a video when allow Download over WiFi only option is set to enabled");
//						Back(1);
					}else {
						logger.error("User is unable to download the video when allow Download over WiFi only option is set to enabled");
						extent.extentLoggerFail("Download over WiFi only option status", "User is unable to download the video when allow Download over WiFi only option is set to enabled");
					}
					
					
					
				}else {
					extent.extentLoggerFail("", "HiPi Feed Screen is not displayed");
				}
				
			}

		}
		
		
		
		public void ProfileSettingsPreferencesDisabledValidation(String userType) throws Exception {
			extent.HeaderChildNode("Profile Settings Preferences Validation");
		
			if(userType.equalsIgnoreCase("Guest")){
			
			}else{
				
				verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
				verifyElementPresentAndClick(HipiFeedPage.objMeImage, "Me icon");
				verifyElementPresentAndClick(HipiMePage.objsettingsicon, "Settings icon");
				verifyElementPresentAndClick(HipiSettingsPage.objHiPiPreferencesOption, "HiPi Preferences option");

				toggleHipiPreferences("Allow Likes", "Off");
				toggleHipiPreferences("Allow Comments", "Off");
				toggleHipiPreferences("Allow Video Download", "Off");
				toggleHipiPreferences("Allow Sharing", "Off");
				
				click(HipiSettingsPage.objHiPiBackButton, "Back Button HiPi Preferences");
				waitTime(2000);
				
				String postDescription = "Desc"+GeneratingRandomString(7);
				CreateVideoForHiPiPreferencesValidation(postDescription);
				
				waitTime(29000);

				Back(1);
				click(HipiFeedPage.objFeedScreenBackButton, "Back Button in Feed Screen");
				logout();
				
				LoginUsingAccountCredentials(getParameterFromXML("NonsubscribedUserName2"), getParameterFromXML("NonsubscribedPassword2"));
				
				verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
				if (verifyElementExist(HipiFeedPage.objfeed, "HiPi Feed")) {
					verifyElementPresentAndClick(HipiFeedPage.objMeImage, "Me Button");
					verifyElementPresentAndClick(HipiMePage.objfollowing, "Following option");
					verifyElementPresentAndClick(HipiMePage.objFirstUserInFollowingScreen, "First User In Following Screen");
					verifyElementExist(HipiCreateVideoPage.objSelectVideo(postDescription), postDescription);
					scrolltomiddle(HipiCreateVideoPage.objSelectVideo(postDescription));
					click(HipiCreateVideoPage.objSelectVideo(postDescription), postDescription);
//					verifyElementExist(HipiCreateVideoPage.objselectfirstimage, "First video");
//					scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
//					click(HipiCreateVideoPage.objselectfirstimage, "First video");
					
					extent.HeaderChildNode("Check if Normal User is not allowed to comment on a video when allow Comments option is set to disabled");
					extent.extentLogger("", "TC_Mobile_009");System.out.println("TC_Mobile_009");
					
//					String clickableStatusOfCommentIcon = findElement(HipiFeedPage.objcommenticon).getAttribute("clickable");
//					System.out.println();
					verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "Comment icon");
					waitTime(2000);
					if(verifyElementExist(HipiFeedPage.objcommentbox, "Comment text field")) {
						logger.error("User is able to comment on a video when allow Comments option is set to disabled");
						extent.extentLoggerFail("Comment icon status", "User is able to comment on a video when allow Comments option is set to disabled");
					}else {
						logger.info("User is unable to comment on a video when allow Comments option is set to disabled");
						extent.extentLoggerPass("Comment icon status", "User is unable to comment on a video when allow Comments option is set to disabled");
					}
					
					
					extent.HeaderChildNode("Check if Normal User is not allowed to download a video when allow Video Downloads option is set to disabled");
					extent.extentLogger("", "TC_Mobile_012");System.out.println("TC_Mobile_012");
					
					longPress(HipiFeedPage.objFeedLongPress);
					waitTime(2000);
					if(verifyElementExist(HipiFeedPage.objdownloadvideo, "Download Video option")) {
						logger.error("User is able to download the video when allow Video Downloads option is set to disabled");
						extent.extentLoggerFail("Download option status", "User is able to download on a video when allow Video Downloads option is set to disabled");
						Back(1);
					}else {
						logger.info("User is unable to download the video when allow Video Downloads option is set to disabled");
						extent.extentLoggerPass("Download option status", "User is unable to download the video when allow Video Downloads option is set to disabled");
						Back(1);
					}
					
					
					
					extent.HeaderChildNode("Check if Normal User is not allowed to sharing a video when allow Sharing option is set to disabled");
					extent.extentLogger("", "TC_Mobile_015");System.out.println("TC_Mobile_015");
//					String clickableStatusOfShareIcon = findElement(HipiFeedPage.objshare).getAttribute("clickable");
					verifyElementPresentAndClick(HipiFeedPage.objshare, "Share icon");
					waitTime(2000);
					if(verifyElementExist(AMDPlayerScreen.objFacebook, "Facebook Share option")) {
						logger.error("User is able to share on a video when allow Sharing option is set to disabled");
						extent.extentLoggerFail("Share icon status", "User is able to share on a video when allow Sharing option is set to disabled");
					}else {
						logger.info("User is unable to share on a video when allow Sharing option is set to disabled");
						extent.extentLoggerPass("Share icon status", "User is unable to share on a video when allow Sharing option is set to disabled");
					}
					
					
					
				}else {
					extent.extentLoggerFail("", "HiPi Feed Screen is not displayed");
				}
				
//				relaunch(true);
//				accessDeviceLocationPopUp("Allow", userType);
//				DisplayAndContentLanguage(userType);
				
//				Back(1);
//				
//				LoginUsingAccountCredentials(getParameterFromXML("NonsubscribedUserName"), getParameterFromXML("NonsubscribedPassword"));
//				
//				verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
//				verifyElementPresentAndClick(HipiFeedPage.objMeImage, "Me icon");
//				verifyElementPresentAndClick(HipiMePage.objsettingsicon, "Settings icon");
//				verifyElementPresentAndClick(HipiSettingsPage.objHiPiPreferencesOption, "HiPi Preferences option");
//				
//				toggleHipiPreferences("Allow Likes", "On");
//				toggleHipiPreferences("Allow Comments", "On");
//				toggleHipiPreferences("Allow Video Download", "On");
//				toggleHipiPreferences("Allow Sharing", "On");
			}

		}
		
		public void toggleHipiPreferences(String toggleButtonName, String toggleToStatus) throws Exception{
			
			
			if(toggleToStatus.equalsIgnoreCase("Off")) {
				verifyElementPresentAndClick(HipiSettingsPage.objToggleButton(toggleButtonName), toggleButtonName);
				waitTime(1000);
				if(toggleButtonStatusValidation(HipiSettingsPage.objToggleButton(toggleButtonName), toggleButtonName)==false) {
					logger.info(toggleButtonName+" option is set to OFF");
					extent.extentLoggerPass(toggleButtonName+" Preference", toggleButtonName+" option is set to OFF");
				}else {
					logger.error(toggleButtonName+" option is set to ON");
					extent.extentLoggerFail(toggleButtonName+" Preference", toggleButtonName+" option is set to ON");
				}
			}else if(toggleToStatus.equalsIgnoreCase("On")) {
				verifyElementPresentAndClick(HipiSettingsPage.objToggleButton(toggleButtonName), toggleButtonName);
				waitTime(1000);
				if(toggleButtonStatusValidation(HipiSettingsPage.objToggleButton(toggleButtonName), toggleButtonName)==true) {
					logger.info(toggleButtonName+" option is set to ON");
					extent.extentLoggerPass(toggleButtonName+" Preference", toggleButtonName+" option is set to ON");
				}else {
					logger.error(toggleButtonName+" option is set to OFF");
					extent.extentLoggerFail(toggleButtonName+" Preference", toggleButtonName+" option is set to OFF");
				}
			}
			
			
			
			
		}
		
		public void CreateVideoForHiPiPreferencesValidation(String postDescription) throws Exception {
			
			extent.HeaderChildNode("Create Video For HiPi Preferences Validation");
			
			
			click(HipiSettingsPage.objHiPiBackButton, "Back Button in HiPi Settings");
			waitTime(2000);
			click(HipiSettingsPage.objHiPiImgBackButton, "Back Button in Me Screen");
			waitTime(2000);
			verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
			waitTime(2000);

			if (verifyElementExist(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
				verifyElementPresent(HipiCreateVideoPage.objpermission, "zee5 picture and record permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow button");
				verifyElementPresent(HipiCreateVideoPage.objpermission, "Access Media permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow button");
				verifyElementPresent(HipiCreateVideoPage.objpermission, "Record Audio permission");
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow button");
				waitTime(15000);
				if(verifyElementExist(HipiMePage.objreadypopup, "Ready Popup")) {
					Thread.sleep(3000);
					verifyElementPresentAndClick(HipiMePage.objokbutton, "Ok button");
				}
			}
			
			waitTime(15000);
		
			if (verifyElementExist(HipiCreateVideoPage.objrecordbtn, "Record Button")) {
				verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record Button");
				waitTime(20000);
				verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "Post Button");
				waitTime(3000);
				if(verifyElementExist(HipiCreateVideoPage.objtitle, "Post HiPi Screen Title")) {
					
					
					type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
					waitTime(3000);
					hideKeyboard();
					waitTime(3000);
					verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "Video Genre Comedy");
					verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "Language English");
					verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox, "Terms and Conditions Checkbox");
					verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "Post HiPi Button");
					if(verifyElementExist(HipiCreateVideoPage.objVideoUploadPopupTitle, "Video Upload Popup Title")) {
						click(HipiCreateVideoPage.objGoToFeed, "Go To Feed Button");
//						waitTime(3000);
						if(verifyIsElementDisplayed(HipiCreateVideoPage.objVideoUploadSuccessfulMessage)) {
							logger.info("Video Upload Successful Message is Displayed");
							extent.extentLoggerPass("Video Upload Successful Message", "Video Upload Successful Message is Displayed");
						}else {
							logger.error("Video Upload Successful Message is not Displayed");
							extent.extentLoggerFail("Video Upload Successful Message", "Video Upload Successful Message is not Displayed");
						}
						waitTime(3000);
						verifyElementPresentAndClick(HipiFeedPage.objMeImage, "Me icon");
						for (int i = 0; i <= 50; i++) {
							scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
							if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
								Thread.sleep(2000);
								Back(1);
								Thread.sleep(2000);
								verifyElementPresentAndClick(AMDHipi.objmeicon, "Me icon");
							} else {
								if(verifyIsElementDisplayed(HipiCreateVideoPage.objSelectVideo(postDescription), "Uploaded video")){
									logger.info("Uploaded video is visible on Profile");
									extent.extentLoggerPass("", "Uploaded video is visible on Profile");
								}else{
									logger.error("Uploaded video is not visible on Profile");
									extent.extentLoggerFail("", "Uploaded video is not visible on Profile");
								}
								break;
							}
						}
						
						
						
					}else {
						extent.extentLoggerFail("", "Video Upload Popup is not displayed");
					}
				}else {
					extent.extentLoggerFail("", "Post HiPi Screen is not displayed");
				}
			}else{
				extent.extentLoggerFail("", "HiPi Feed screen is not displayed");
			}
		}

		public boolean toggleButtonStatusValidation(By toggleButton, String toggleButtonName) throws Exception{
		
			String toggleCurrentStatus = findElement(toggleButton).getText();
			if(toggleCurrentStatus.equalsIgnoreCase("ON")) {
				logger.info("Toggle Button status of "+toggleButtonName+" is "+toggleCurrentStatus);
				extent.extentLogger("Toggle Button Status", "Toggle Button status of "+toggleButtonName+" is "+toggleCurrentStatus);	
				return true;
			}else {
				logger.info("Toggle Button status of "+toggleButtonName+" is "+toggleCurrentStatus);
				extent.extentLogger("Toggle Button Status", "Toggle Button status of "+toggleButtonName+" is "+toggleCurrentStatus);	
				return false;
			}	
		
		}
		
		public void LoginUsingAccountCredentials(String Username, String Password) throws Exception {
			extent.HeaderChildNode("Login Functionality using "+Username);
			String pUserType = getParameterFromXML("userType");

			extent.extentLogger("Login Type", "Login Type : " + pUserType);
			
				// navigateToIntroScreen_DisplaylangScreen();
				extent.HeaderChildNode("Login as NonSubscribed User");
				if (verifyElementExist(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free")) {
					click(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");

					Thread.sleep(5000);
					hideKeyboard();
					Thread.sleep(5000);
					click(AMDLoginScreen.objEmailIdField, "Email field");
					hideKeyboard();
					type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
					verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
					verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
					type(AMDLoginScreen.objPasswordField, Password, "Password field");
					hideKeyboard();
					verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
					waitTime(9000);

				} else if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {

					click(AMDOnboardingScreen.objZeeMoreButton, "More button");

					if (verifyElementExist(AMDOnboardingScreen.objLoginLink, "Login Link")) {

						click(AMDOnboardingScreen.objLoginLink, "Login Link");

						Thread.sleep(5000);
						hideKeyboard();
						Thread.sleep(5000);
						click(AMDLoginScreen.objEmailIdField, "Email field");
						hideKeyboard();
						type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
						verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
						verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
						type(AMDLoginScreen.objPasswordField, Password, "Password field");
						hideKeyboard();
						verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
						waitTime(9000);

					} else {
						System.out.println("Already loggedin");

						Back(1);
					}
				}
		}
		
		

		
		
		
	//------------------------------------------------------------------------------------------------------------------
		
		
		
		
		
		//------------------------------------------------Notification-----------------------------------------------------

		
		public void ValidatingLikeNotification(String userType) throws Exception{
			if(userType.equalsIgnoreCase("NonSubscribedUser")){
				
				RegisterAndSendValue();
	    		ValidateLikeNotificationTC_Mobile_01ValidateClickedRedirectedToVideoPageTC_Mobile_05(userType);
	    		ValidateThumnailUserImageTC_Mobile_03(userType);
	    		ValidateThumbnailVideoAndProfileImageTC_Mobile_08(userType);
	    		ValidateVideoPlayPageTC_Mobile_09(userType);
	    	}
	    	else{}
		}
		
		
		
		
		public void RegisterAndSendValue() throws Exception {
			extent.HeaderChildNode("Register");
			Thread.sleep(5000);
			logout();
			
			waitTime(5000);
			click(AMDHomePage.objMoreMenu, "More Menu");
			
			waitTime(2000);
			click(AMDOnboardingScreen.objLoginLink, "Login Link");

			Thread.sleep(5000);					
			
			type(AMDLoginScreen.objEmailIdField,"email"+GeneratingRandomString(7)+"@gmail.com", "Email Field");
			Thread.sleep(5000);
			
			String username=findElement(AMDLoginScreen.objEmailIdField).getText();
			System.out.println(username);
			////String password = "abcdef";
			
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			Thread.sleep(5000);
//			click(HipiMePage.objfirstnamezee5hipi, "First name");
//			type(HipiMePage.objfirstnamezee5hipi,"vvvv","First name Field");
//			Thread.sleep(5000);
//			click(HipiMePage.objlastnamezee5hipi, "Last name");
//			type(HipiMePage.objlastnamezee5hipi,"vvvv","Last name Field");
//			Thread.sleep(5000);
//			click(HipiMePage.objdobzee5hipi, "Dob");
//			type(HipiMePage.objdobzee5hipi,"09/09/1999","Dob Field");
//			Thread.sleep(5000);
//			click(HipiMePage.objgenderzee5hipi, "Gender");
//			Thread.sleep(5000);
//			click(HipiMePage.objgendermale, "Gender");
//			Thread.sleep(5000);
//			click(HipiMePage.objpwd, "Password");
//			type(HipiMePage.objpwd,"password"+GeneratingRandomString(4),"Password Field");
//			hideKeyboard();
//			click(HipiMePage.objcheckbtn, "Check button");	
//			Thread.sleep(5000);
//			String password=findElement(HipiMePage.objpwd).getText();
//			System.out.println(password);
//			Thread.sleep(5000);
//			click(HipiMePage.objregisterpagebtnzee5hipi, "Register");
//			Thread.sleep(10000);
//			if(verifyElementExist(HipiMePage.objsavebtnzee5hipi, "Save"))//added 27/4/2021
//			{
//				click(HipiMePage.objsavebtnzee5hipi, "Save");
//				Thread.sleep(10000);	
//			}
//			click(HipiMePage.objsavebtnzee5hipi, "Register");
//			Thread.sleep(10000);
//			NotificationUsername = username;
//			NotificationPassword = password;  
		}
		
		
		
		public void ValidateLikeNotificationTC_Mobile_01ValidateClickedRedirectedToVideoPageTC_Mobile_05(String userType) throws Exception
		{
			extent.HeaderChildNode("Verify that user receives a notification if someone like his created video and on tapping notification Video maximized screen is displayed");
			System.out.println("TC_Mobile_01");
			extent.extentLogger("", "TC_Mobile_01");
			Thread.sleep(5000);
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objcreatevideo, "Create video button");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			
			String NonSubUsername1 = NotificationUsername;
			String NonSubPassword1 = NotificationPassword;
			Thread.sleep(5000);
			
			type(AMDLoginScreen.objEmailIdField, NonSubUsername1, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			type(AMDLoginScreen.objPasswordField, NonSubPassword1, "Password field");
			hideKeyboard();
			
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(10000);
//			if(verifyElementExist(HipiMePage.objsavebtnzee5hipi, "Save"))//added 27/4/2021
//			{
//				click(HipiMePage.objsavebtnzee5hipi, "Save");
//				Thread.sleep(10000);	
//			}
			click(HipiCreateVideoPage.objcreatevideo, "Create video button");
			Thread.sleep(5000);
			if(verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo, "Allow ZEE5 to take pictures and record video?"))
			{
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				Thread.sleep(5000);
			}
			else
			{
				logger.info("Allow ZEE5 to take pictures and record video? unavailable");
			}
				
			if(verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to access photos, media, and files on your device?"))
			{
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				Thread.sleep(5000);
			}
			else
			{
				logger.info("Allow ZEE5 to access photos, media, and files on your device? unavailable");
			}
			
			if(verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?"))
			{
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");	
				Thread.sleep(40000);
			}
			else
			{
				logger.info("Allow ZEE5 to record audio? unavailable");
			}
			Thread.sleep(50000);
			waitForElementDisplayed(HipiCreateVideoPage.objCreateReadyDialog,50);//added
			if(verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog"))
			{
				click(HipiCreateVideoPage.objCreateReadyYes, "yes button");	
				Thread.sleep(10000);
			}
			else
			{
				logger.info("Ready dialog unavailable");
			}

			click(HipiCreateVideoPage.objrecordbtn, "Record start button");
			Thread.sleep(7000);
			click(HipiCreateVideoPage.objrecordbtn, "Record start button");
			Thread.sleep(5000);
			click(HipiMePage.objvideofinishbutton, "Finish button");
			Thread.sleep(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "Post button");
			Thread.sleep(20000);

			type(HipiCreateVideoPage.objadddescription,"Desc"+GeneratingRandomString(7),"Description");
			Thread.sleep(5000);
			hideKeyboard();
			Thread.sleep(5000);
			
			click(HipiCreateVideoPage.objgenrevideo, "Genre button");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objlanguageclickedhindi, "Hindi button");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objcheckbox, "Checkbox");
			Thread.sleep(5000);
			click(HipiCreateVideoPage.objuploadpost, "Post button");
			Thread.sleep(5000);
			
			click(HipiMePage.objdraftvideopostpagegotofeed, "Go to feed button");
			logger.info("Waiting for video upload");
			Thread.sleep(40000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(10000);
			waitForElementDisplayed(AMDOnboardingScreen.objForMeButton,10);//added
			Thread.sleep(10000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			
			Back(1);//added 27/4/2021
			Thread.sleep(10000);//added 27/4/2021
			click(AMDOnboardingScreen.objForMeButton, "Me");//added 27/4/2021
			Thread.sleep(5000);//added 27/4/2021
			
			String profiledata=findElement(HipiMePage.objprofiledata).getText();
			System.out.println("Added Data:"+profiledata);
			Thread.sleep(5000);
			while(verifyElementExist(HipiMePage.objvideotabtobedeleted,"Video"))
			{
				longPress(HipiMePage.objvideotabtobedeleted);
				Thread.sleep(5000);
				click(HipiMePage.objpublishedvideodelete,"Delete button");
				Thread.sleep(5000);
				click(HipiMePage.objvideoyesbutton,"Yes button");
				Thread.sleep(5000);
				click(HipiMePage.objvideoyesbutton,"Done button");
				Thread.sleep(5000);
			}
			Back(1);
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(5000);
			
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
			
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(10000);
			
			
			
			
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			String NonSubUsername2 = getParameterFromXML("NotificationNonSubUsername2");
			String NonSubPassword2 = getParameterFromXML("NotificationNonSubPassword2");
			hideKeyboard();
			Thread.sleep(5000);
			type(AMDLoginScreen.objEmailIdField, NonSubUsername2, "Email Field");
			Thread.sleep(5000);
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			type(AMDLoginScreen.objPasswordField, NonSubPassword2, "Password field");
			hideKeyboard();
			Thread.sleep(5000);
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(10000);
			click(HipiMePage.objdiscovertext, "Discover button");
			Thread.sleep(5000);
			click(HipiMePage.objsearchfield, "Search button");
			Thread.sleep(5000);
			type(HipiMePage.objsearchfield, profiledata, "Search field");
			Thread.sleep(10000);
//			click(HipiMePage.objdiscoveraccountzee5hipi, "Account");//added locator 27/4/2021
			Thread.sleep(10000);//added 27/4/2021
//			click(HipiMePage.objdiscoveraccountvideozee5hipi, "Video");//added locator 27/4/2021
			Thread.sleep(10000);//added
			click(HipiMePage.objdiscovervideolikebutton, "Like button");
			Thread.sleep(10000);//added
			Back(5);//added locator 27/4/2021 one more back
			Thread.sleep(5000);
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			
			String NonSubUsername = NotificationUsername;
			String NonSubPassword = NotificationPassword;
			
			
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, NonSubUsername, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			Thread.sleep(5000);
			type(AMDLoginScreen.objPasswordField, NonSubPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			
			
			
			click(HipiMePage.objnotification,"Notification button");
			Thread.sleep(5000);
			
			
			String NotificationWhenVideoGotLiked = "liked your HiPiT";
			Thread.sleep(5000);
			String NotificationAvailable = getAttributValue("text",HipiMePage.objuserimagenotification);
			System.out.println(NotificationAvailable);
			if(NotificationAvailable.contains(NotificationWhenVideoGotLiked))
			{
			extent.extentLogger("", "Liked notification available in notification page");
			click(HipiMePage.objuserimagenotification,"Liked Notification");
			Thread.sleep(5000);
			if(verifyElementExist(HipiMePage.objauthordata, "Author data"))
			{
				logger.info("Notification if someone like his created video and on tapping notification Video maximized screen is displayed");
		    	extent.extentLoggerPass("Notification:","Notification if someone like his created video and on tapping notification Video maximized screen is displayed");
			}
			else
			{
				logger.info("Notification if someone like his created video and on tapping notification Video maximized screen not displayed");
		    	extent.extentLoggerFail("Notification:","Notification if someone like his created video and on tapping notification Video maximized screen not displayed");
			}
			}
			else
			{
				extent.extentLogger("", "Liked notification unavailable in notificatin page");
			}
			////////////////////////////////Notification TC_Mobile_05///////////////////////////////////////
			extent.HeaderChildNode("Verify that notification is displayed in the appropriate format");
			System.out.println("TC_Mobile_05");
			extent.extentLogger("", "TC_Mobile_05");
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(10000);
			if(NotificationAvailable.startsWith("@"))
			{
				logger.info("Notification starts with @ when video got liked by user");
		    	extent.extentLoggerPass("Notification:","Notification starts with @ when video got liked by user");
			}
			else
			{
				logger.info("Notification not starting with @ when video got liked by user");
				extent.extentLoggerFail("Notification:","Notification not starting with @ when video got liked by user");
			}
			Thread.sleep(5000);
			if(NotificationAvailable.endsWith("liked your HiPiT"))
			{
				logger.info("Notification ends with liked your HiPiT when video got liked by user");
		    	extent.extentLoggerPass("Notification:","Notification ends with liked your HiPiT when video got liked by user");
			}
			else
			{
				logger.info("Notification do not end with liked your HiPiT when video got liked by user");
				extent.extentLoggerFail("Notification:","Notification do not end with liked your HiPiT when video got liked by user");
			}
		}

		public void ValidateThumnailUserImageTC_Mobile_03(String userType) throws Exception
		{
			extent.HeaderChildNode("Verify that thumbnail of the profile picture of the user who liked the video should be displayed on notifications section");
			System.out.println("TC_Mobile_03");
			extent.extentLogger("", "TC_Mobile_03");
			Thread.sleep(5000);
			if(verifyElementExist(HipiMePage.objthumnailuserimage, "User image"))
			{
				logger.info("Thumbnail of the profile picture of user who liked the video is displayed");
		    	extent.extentLoggerPass("Notification:","Thumbnail of the profile picture of user who liked the video is displayed");
			}
			else
			{
				logger.info("Thumbnail of the profile picture of user who liked the video not displayed");
				extent.extentLoggerFail("Notification:", "Thumbnail of the profile picture of user who liked the video not displayed");
			}
			
		}
		public void ValidateThumbnailVideoAndProfileImageTC_Mobile_08(String userType) throws Exception
		{
			extent.HeaderChildNode("Verify that thumnail of the video and profile picture of the user is displayed who liked the video");
			System.out.println("TC_Mobile_08");
			extent.extentLogger("", "TC_Mobile_08");
			Thread.sleep(5000);
			if(verifyElementExist(HipiMePage.objthumnailuserimage, "User image"))
			{
				logger.info("Thumnail profile picture of the  user who liked the video is displayed");
		    	extent.extentLoggerPass("Notification:","Thumnail profile picture of the  user who liked the video is displayed");
			}
			else
			{
				logger.info("Thumnail profile picture of the  user who liked the video not displayed");
				extent.extentLoggerFail("Notification:", "Thumnail profile picture of the  user who liked the video not displayed");
			}
			Thread.sleep(5000);
			if(verifyElementExist(HipiMePage.objthumnailvideo, "Video"))
			{
				logger.info("Thumnail of the video of the  user who liked the video is displayed");
		    	extent.extentLoggerPass("Notification:","Thumnail of the video of the  user who liked the video is displayed");
			}
			else
			{
				logger.info("Thumbnail of the video of the  user who liked the video not displayed");
				extent.extentLoggerFail("Notification:", "Thumbnail of the video of the  user who liked the video not displayed");
			}
		}

		public void ValidateVideoPlayPageTC_Mobile_09(String userType) throws Exception
		{
			extent.HeaderChildNode("Verify that user is navigated to video play mode screen and video screen is not scrollable");
			System.out.println("TC_Mobile_09");
			extent.extentLogger("", "TC_Mobile_09");
			Thread.sleep(5000);
			if(verifyElementExist(HipiMePage.objthumnailvideo, "Video"))
			{
				click(HipiMePage.objthumnailvideo,"Video");
				Thread.sleep(10000);
					if(verifyElementExist(HipiMePage.objauthordata, "Author data"))
					{
						logger.info("User is navigated to video play mode screen and video screen");
				    	extent.extentLoggerPass("Notification:","User is navigated to video play mode screen and video screen");
				    	String BeforeScrollingAuthordata = getAttributValue("text",HipiMePage.objauthordata);
						Swipe("UP",1);
						Thread.sleep(5000);
						String AfterScrollingAuthordata = getAttributValue("text",HipiMePage.objauthordata);
						Thread.sleep(5000);
						if(BeforeScrollingAuthordata.equals(AfterScrollingAuthordata))
						{
							logger.info("Video screen is not scrollable");
					    	extent.extentLoggerPass("Notification:","Video screen is not scrollable");
						}
						else
						{
							logger.info("Video screen is scrollable");
					    	extent.extentLoggerFail("Notification:","Video screen is scrollable");
						}
					}
					else
					{
						logger.info("Video play mode screen and video screen unavailable");
				    	extent.extentLoggerFail("Notification:","Video play mode screen and video screen unavailable");
					}
					Back(1);
					Thread.sleep(5000);
					
					
				}
			else
			{
				logger.info("Video unavailable");
		    	extent.extentLoggerFail("Notification:","Video unavailable");
			}	
			}
		
		
		public void ValidatingMultipleLikesNotification(String userType) throws Exception{
		   	if(userType.equalsIgnoreCase("NonSubscribedUser")){
	    		ValidateLatestProfileImagesTC_Mobile_04AndFormatWhenVideoLikedByTwoUsersTC_Mobile_06(userType);
	    		ValidateNotificatioFormatWhenMultipleUsersLikedVideoTC_Mobile_07(userType);
	    	}
	    	else{}
		}
		
		
		
		public void ValidateLatestProfileImagesTC_Mobile_04AndFormatWhenVideoLikedByTwoUsersTC_Mobile_06(String userType) throws Exception
		{
			extent.HeaderChildNode("Verify that if multiple people like the video then thumbnail of the profile picture of the latest two user should displayed");
			System.out.println("TC_Mobile_04");
			extent.extentLogger("", "TC_Mobile_04");
			Thread.sleep(5000);
//			Back(1);
//			Thread.sleep(5000);
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			String NonSubUsername = NotificationUsername;
			String NonSubPassword = NotificationPassword;
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, NonSubUsername, "Email Field");
			Thread.sleep(5000);
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			Thread.sleep(5000);
			type(AMDLoginScreen.objPasswordField, NonSubPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(10000);
			String profiledata=findElement(HipiMePage.objprofiledata).getText();
			System.out.println("Added Data:"+profiledata);
			Thread.sleep(5000);
			Back(2);
			Thread.sleep(5000);
			
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
			
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(10000);
			
			
			
			
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			String NonSubUsername2 = getParameterFromXML("NonsubscribedUserName");
			String NonSubPassword2 = getParameterFromXML("NonsubscribedPassword");
			hideKeyboard();
			Thread.sleep(5000);
			type(AMDLoginScreen.objEmailIdField, NonSubUsername2, "Email Field");
			Thread.sleep(5000);
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			type(AMDLoginScreen.objPasswordField, NonSubPassword2, "Password field");
			hideKeyboard();
			Thread.sleep(5000);
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(10000);
			click(HipiMePage.objdiscovertext, "Discover button");
			Thread.sleep(5000);
			click(HipiMePage.objsearchfield, "Search button");
			Thread.sleep(5000);
			type(HipiMePage.objsearchfield, profiledata, "Search field");
			Thread.sleep(10000);
//			click(HipiMePage.objdiscoveraccountzee5hipi, "Account");//added locator 27/4/2021
			Thread.sleep(10000);//added 27/4/2021
//			click(HipiMePage.objdiscoveraccountvideozee5hipi, "Video");//added locator 27/4/2021
			Thread.sleep(10000);//added 27/4/2021
			click(HipiMePage.objdiscovervideolikebutton, "Like button");
			Thread.sleep(5000);
			Back(5);//added 27/4/2021 one more back added
			Thread.sleep(5000);
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			
			String NonSubUsername1 = NotificationUsername;
			String NonSubPassword1 = NotificationPassword;
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, NonSubUsername1, "Email Field");
			Thread.sleep(5000);
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			Thread.sleep(5000);
			type(AMDLoginScreen.objPasswordField, NonSubPassword1, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			
			click(HipiMePage.objnotification,"Notification button");
			Thread.sleep(5000);
			if(verifyElementExist(HipiMePage.objuserimagefirstimage, "First image"))
			{
				if(verifyElementExist(HipiMePage.objuserimageseconduserliked, "Second user image"))
				{
					logger.info("Notification:"+ "Multiple people like the video then thumbnail of the profile picture of the latest two user  displayed");
			    	extent.extentLoggerPass("Notification:","Multiple people like the video then thumbnail of the profile picture of the latest two user  displayed");
				}
				else
				{
					logger.info("Notification:"+ "Multiple people like the video then thumbnail of the profile picture of the latest two user not displayed");
			    	extent.extentLoggerFail("Notification:","Multiple people like the video then thumbnail of the profile picture of the latest two user not displayed");
				}
			}
			else
			{
				logger.info("Notification:"+ "Multiple people like the video then thumbnail of the profile picture of the latest two user not displayed");
		    	extent.extentLoggerFail("Notification:","Multiple people like the video then thumbnail of the profile picture of the latest two user not displayed");
			}
		////////////////////////////////Notification TC_Mobile_06///////////////////////////////////////
			extent.HeaderChildNode("Verify that displaying of notification is in appropriate format if 2 users like the video");
			System.out.println("TC_Mobile_06");
			extent.extentLogger("", "TC_Mobile_06");
			Thread.sleep(5000);
			String NotificationAvailable = getAttributValue("text",HipiMePage.objuserimagenotification);
			System.out.println(NotificationAvailable);
			if(NotificationAvailable.startsWith("@"))
			{
			logger.info("Notification displaying of notification is in appropriate format if 2 users like the video");
			extent.extentLoggerPass("Notification:","Notification displaying of notification is in appropriate format if 2 users like the video");
			}
			else
			{
			logger.info("Notification not displaying of notification is in appropriate format if 2 users like the video");
			extent.extentLoggerFail("Notification:","Notification not displaying of notification is in appropriate format if 2 users like the video");
			}
			Thread.sleep(5000);
			if(NotificationAvailable.endsWith("and 1 other liked your HiPiT"))
			{
			logger.info("Notification displaying of notification is in appropriate format if 2 users like the video");
			extent.extentLoggerPass("Notification:","Notification displaying of notification is in appropriate format if 2 users like the video");
			}
			else
			{
			logger.info("Notification  not displaying of notification is in appropriate format if 2 users like the video");
			extent.extentLoggerFail("Notification:","Notification  not displaying of notification is in appropriate format if 2 users like the video");
			}
		}

		public void ValidateNotificatioFormatWhenMultipleUsersLikedVideoTC_Mobile_07(String userType) throws Exception
		{
			extent.HeaderChildNode("Verify that displaying of notification is in appropriate format if multiple users like the video");
			System.out.println("TC_Mobile_07");
			extent.extentLogger("", "TC_Mobile_07");
			Thread.sleep(5000);
			String NotificationAvailable = getAttributValue("text",HipiMePage.objuserimagenotification);
			System.out.println(NotificationAvailable);
			if(NotificationAvailable.startsWith("@"))
			{
			logger.info("Notification is in appropriate format if multiple users like the video");
			extent.extentLoggerPass("Notification:","Notification is in appropriate format if multiple users like the video");
			}
			else
			{
			logger.info("Notification is not appropriate format if multiple users like the video");
			extent.extentLoggerFail("Notification:","Notification is not appropriate format if multiple users like the video");
			}
			Thread.sleep(5000);
			if(NotificationAvailable.endsWith("and 1 other liked your HiPiT"))
			{
			logger.info("Notification is in appropriate format if multiple users like the video");
			extent.extentLoggerPass("Notification:","Notification is in appropriate format if multiple users like the video");
			}
			else
			{
			logger.info("Notification is not appropriate format if multiple users like the video");
			extent.extentLoggerFail("Notification:","Notification is not appropriate format if multiple users like the video");
			}
		}

		
		
		
		
		public void ValidatingCommentsNotification(String userType) throws Exception{
			if(userType.equalsIgnoreCase("NonSubscribedUser")){
	    		ValidateCommentThumnailTC_Mobile_11CommentNotificationFormatTC_Mobile_10AndCountNotificationIncreasedTC_Mobile_02(userType);
	    		ValidateCommentNotificationRedirectVideoPageTC_Mobile_13(userType);
	    		ValidateCommentFormatWhenMultipleUsersCommentOnVideoTC_Mobile_12(userType);
	    	}
	    	else{}
		}
		
		
		
		
		public void ValidateCommentThumnailTC_Mobile_11CommentNotificationFormatTC_Mobile_10AndCountNotificationIncreasedTC_Mobile_02(String userType) throws Exception
		{
			extent.HeaderChildNode("Verify that video thumbnail of the user is displayed who commented on the video");
			System.out.println("TC_Mobile_11");
			extent.extentLogger("", "TC_Mobile_11");
			Thread.sleep(5000);	
			
//			Back(1);
//			Thread.sleep(5000);	
			
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			
			String NonSubUsername1 = NotificationUsername;
			String NonSubPassword1 = NotificationPassword;
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, NonSubUsername1, "Email Field");
			Thread.sleep(5000);
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			Thread.sleep(5000);
			type(AMDLoginScreen.objPasswordField, NonSubPassword1, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			
			click(HipiMePage.objnotification,"Notification button");
			Thread.sleep(5000);
			List<WebElement> notificationcount = getDriver().findElements(HipiMePage.objnotificationcount);
			int size = notificationcount.size();
			System.out.println(size);
			Thread.sleep(5000);	
			
			
			Back(1);
			Thread.sleep(5000);
			String profiledata=findElement(HipiMePage.objprofiledata).getText();
			System.out.println("Added Data:"+profiledata);
			Thread.sleep(5000);
			Back(2);
			Thread.sleep(5000);
			
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
			
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(10000);
			
			
			
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			String NonSubUsername2 = getParameterFromXML("NonsubscribedUserName");
			String NonSubPassword2 = getParameterFromXML("NonsubscribedPassword");
			hideKeyboard();
			
			type(AMDLoginScreen.objEmailIdField, NonSubUsername2, "Email Field");
			Thread.sleep(5000);
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			Thread.sleep(5000);
			type(AMDLoginScreen.objPasswordField, NonSubPassword2, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(10000);
			click(HipiMePage.objdiscovertext, "Discover button");
			Thread.sleep(5000);
			click(HipiMePage.objsearchfield, "Search button");
			Thread.sleep(5000);
			type(HipiMePage.objsearchfield, profiledata, "Search field");
			Thread.sleep(5000);
//			click(HipiMePage.objdiscoveraccountzee5hipi, "Account");//added locator 27/4/2021
			Thread.sleep(10000);//added 27/4/2021
//			click(HipiMePage.objdiscoveraccountvideozee5hipi, "Video");//added locator 27/4/2021
			Thread.sleep(10000);//added 27/4/2021
			
			
			
			
			
			
			click(HipiMePage.objdiscovervideocommentbutton, "Comment button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			type(HipiMePage.objcommentbox,"heyv"+GeneratingRandomString(7),"Description");
			Thread.sleep(5000);
			hideKeyboard();
			Thread.sleep(5000);
			
			
			
			
			touchOnCommentArrow();
			Thread.sleep(10000);
			
			
			Back(1);//added
			Thread.sleep(5000);//added
			Back(1);//added
			Thread.sleep(5000);//added
			Back(1);//added
			Thread.sleep(5000);//added
			Back(1);//added
			Thread.sleep(5000);//added
			Back(1);//added
			Thread.sleep(5000);//added
			Back(1);//added
			Thread.sleep(5000);//added 27/4/2021
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			
			String NonSubUsername = NotificationUsername;
			String NonSubPassword = NotificationPassword;
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, NonSubUsername, "Email Field");
			Thread.sleep(5000);
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			Thread.sleep(5000);
			type(AMDLoginScreen.objPasswordField, NonSubPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			
			click(HipiMePage.objnotification,"Notification button");
			Thread.sleep(5000);
			
			String NotificationWhenVideoGotCommented = "commented on your HiPiT";
			Thread.sleep(5000);
			String NotificationAvailable = getAttributValue("text",HipiMePage.objuserimagenotification);
			System.out.println(NotificationAvailable);
			if(NotificationAvailable.contains(NotificationWhenVideoGotCommented))
			{
			if(verifyElementExist(HipiMePage.objusercommentnotification, "Comment notification"))
			{
				logger.info("Video thumbnail of the user is displayed who commented on the video");
				extent.extentLoggerPass("Notification:","Video thumbnail of the user is displayed who commented on the video");
			}
			else
			{
				logger.info("Video thumbnail of the user is unavailable who commented on the video");
				extent.extentLoggerFail("Notification:","Video thumbnail of the user is unavailable who commented on the video");
			}
			}
			//--------------------------------------------------Notification TC_Mobile_010----------------------------------------------
			extent.HeaderChildNode("Verify that comment notification is displayed in appropriate format");
			System.out.println("TC_Mobile_10");
			extent.extentLogger("", "TC_Mobile_10");
			Thread.sleep(20000);	
				if(NotificationAvailable.startsWith("@"))
				{
				logger.info("Comment notification is displayed in appropriate format");
				extent.extentLoggerPass("Notification:","Comment notification is displayed in appropriate format");
				}
				else
				{
				logger.info("Comment notification is not displayed in appropriate format");
				extent.extentLoggerFail("Notification:","Comment notification is not displayed in appropriate format");
				}
				if(NotificationAvailable.contains(NotificationWhenVideoGotCommented))
				{
				logger.info("Comment notification is displayed in appropriate format");
				extent.extentLoggerPass("Notification:","Comment notification is displayed in appropriate format");
				}
				else
				{
				logger.info("Comment notification is not displayed in appropriate format");
				extent.extentLoggerFail("Notification:","Comment notification is not displayed in appropriate format");
				} 
			
			//--------------------------------------------------Notification TC_Mobile_02----------------------------------------------
			extent.HeaderChildNode("Verify that count of the notification increases when some like the video");
			System.out.println("TC_Mobile_02");
			extent.extentLogger("", "TC_Mobile_02");
			Thread.sleep(5000);	
			List<WebElement> notificationcountaftercommenting = getDriver().findElements(HipiMePage.objnotificationcount);
			int sizeaftercommenting = notificationcountaftercommenting.size();
			System.out.println(sizeaftercommenting);
			if(size<sizeaftercommenting)
			{
				logger.info("Count of the notification increases when some like the video");
				extent.extentLoggerPass("Notification:","Count of the notification increases when some like the video");
			}
			else
			{
				logger.info("Count of the notification do not increases when some like the video");
				extent.extentLoggerFail("Notification:","Count of the notification do not increases when some like the video");
			}

		}
		public void ValidateCommentNotificationRedirectVideoPageTC_Mobile_13(String userType) throws Exception
		{
			extent.HeaderChildNode("Verify that user is navigated to the video and when user clicks on comment notification");
			System.out.println("TC_Mobile_13");
			extent.extentLogger("", "TC_Mobile_13");
			Thread.sleep(5000);
			click(HipiMePage.objusercommentnotification, "Comment notification");
			Thread.sleep(5000);
			if(verifyElementExist(HipiMePage.objauthordata, "Author data"))
			{
				Back(1);//added 27/4/2021
				Thread.sleep(5000);//added 27/4/2021
				logger.info("User is navigated to the video and when user clicks on comment notification");
		    	extent.extentLoggerPass("Notification:","User is navigated to the video and when user clicks on comment notification");
			}
			else
			{
				logger.info("User not navigated to the video and when user clicks on comment notification");
		    	extent.extentLoggerFail("Notification:","User not navigated to the video and when user clicks on comment notification");
			}
		}

		public void ValidateCommentFormatWhenMultipleUsersCommentOnVideoTC_Mobile_12(String userType) throws Exception
		{
			extent.HeaderChildNode("Verify that format for the liked comment is as per the requirement");
			System.out.println("TC_Mobile_12");
			extent.extentLogger("", "TC_Mobile_12");
			Thread.sleep(20000);
			
			Back(1);//updated 27/4/2021
			Thread.sleep(5000);
			
			String profiledata=findElement(HipiMePage.objprofiledata).getText();
			System.out.println("Added Data:"+profiledata);
			Thread.sleep(5000);
			Back(2);
			Thread.sleep(5000);
			
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
	
			Thread.sleep(20000);//added
			
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(10000);
			
			
			
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			String NonSubUsername1 = getParameterFromXML("NotificationNonSubUsername2");
			String NonSubPassword1 = getParameterFromXML("NotificationNonSubPassword2");
			hideKeyboard();
			
			type(AMDLoginScreen.objEmailIdField, NonSubUsername1, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			type(AMDLoginScreen.objPasswordField, NonSubPassword1, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(10000);
			click(HipiMePage.objdiscovertext, "Discover button");
			Thread.sleep(5000);
			click(HipiMePage.objsearchfield, "Search button");
			Thread.sleep(5000);
			type(HipiMePage.objsearchfield, profiledata, "Search field");
			Thread.sleep(5000);
//			click(HipiMePage.objdiscoveraccountzee5hipi, "Account");//added locator 27/4/2021
			Thread.sleep(10000);//added 27/4/2021
//			click(HipiMePage.objdiscoveraccountvideozee5hipi, "Video");//added locator 27/4/2021
			Thread.sleep(10000);//added 27/4/2021
			
			
			
			
			
			click(HipiMePage.objdiscovervideocommentbutton, "Comment button");
			Thread.sleep(5000);
			click(HipiMePage.objcommentlikebutton, "Comment like button");
			Thread.sleep(5000);
			Back(6);//added one more back 27/4/2021
			Thread.sleep(5000);
			
			
			
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
			
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(10000);
			
			
			
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			String NonSubUsername2 = getParameterFromXML("NonsubscribedUserName");
			String NonSubPassword2 = getParameterFromXML("NonsubscribedPassword");
			hideKeyboard();
			
			type(AMDLoginScreen.objEmailIdField, NonSubUsername2, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			type(AMDLoginScreen.objPasswordField, NonSubPassword2, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(10000);//////////////////
			waitForElementDisplayed(HipiMePage.objdiscovertext,10);//added
			click(HipiMePage.objdiscovertext, "Discover button");
			Thread.sleep(5000);
			click(HipiMePage.objsearchfield, "Search button");
			Thread.sleep(5000);
			type(HipiMePage.objsearchfield, profiledata, "Search field");
			Thread.sleep(5000);
//			click(HipiMePage.objdiscoveraccountzee5hipi, "Account");//added locator 27/4/2021
			Thread.sleep(10000);//added 27/4/2021
//			click(HipiMePage.objdiscoveraccountvideozee5hipi, "Video");//added locator 27/4/2021
			Thread.sleep(10000);//added 27/4/2021
			
			
			
			
			
			click(HipiMePage.objdiscovervideocommentbutton, "Comment button");
			Thread.sleep(5000);
			click(HipiMePage.objcommentlikebutton, "Comment like button");
			Thread.sleep(5000);
			Back(6);//added one more back 27/4/2021
			Thread.sleep(5000);
			
			
			
			click(HipiMePage.objmorebutton, "More button");
			Thread.sleep(5000);
			Swipe("UP",1);
			Thread.sleep(5000);
			click(HipiMePage.objlogoutbutton, "Logout button");
			Thread.sleep(5000);
			click(HipiMePage.objdialoglogoutbutton, "Logout dialog button");
			Thread.sleep(5000);
			Back(1);
			Thread.sleep(5000);
			click(AMDHipi.objHipiIcon, "Hipi icon");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			click(HipiMePage.objregisterdialoginbutton, "LoginHipi button");
			Thread.sleep(5000);
			
			String NonSubUsername = NotificationUsername;
			String NonSubPassword = NotificationPassword;
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, NonSubUsername, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			Thread.sleep(5000);
			type(AMDLoginScreen.objPasswordField, NonSubPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			Thread.sleep(5000);
			click(AMDOnboardingScreen.objForMeButton, "Me");
			Thread.sleep(5000);
			
			click(HipiMePage.objnotification,"Notification button");
			Thread.sleep(5000);
			
			
			
			String NotificationWhenVideoCommentGotLikedByMultipleUsers = "others like your comment";
			Thread.sleep(5000);
			String NotificationAvailable = getAttributValue("text",HipiMePage.objuserimagenotification);
			System.out.println(NotificationAvailable);
			if(NotificationAvailable.contains(NotificationWhenVideoCommentGotLikedByMultipleUsers))
			{
				if(NotificationAvailable.startsWith("@"))
				{
				logger.info("Format for the liked comment is as per the requirement");
				extent.extentLoggerPass("Notification:","Format for the liked comment is as per the requirement");
				}
				else
				{
				logger.info("Format for the liked comment is not as per the requirement");
				extent.extentLoggerFail("Notification:","Format for the liked comment is not as per the requirement");
				}
				Thread.sleep(5000);
				if(NotificationAvailable.contains(NotificationWhenVideoCommentGotLikedByMultipleUsers))
				{
				logger.info("Format for the liked comment is as per the requirement");
				extent.extentLoggerPass("Notification:","Format for the liked comment is as per the requirement");
				}
				else
				{
				logger.info("Format for the liked comment is not as per the requirement");
				extent.extentLoggerFail("Notification:","Format for the liked comment is not as per the requirement");
				}
			}
			else
			{
				logger.info("Video comment liked by multiple users but notification is unavailable");
				extent.extentLoggerFail("Notification:","Video comment liked by multiple users but notification is unavailable");
			}
			
		}







//---------------------------------------------------------------------------------------------------------------






		
		
		
		
		//---------------------------------------------------------------------------------------------------------------
		
		
		
		
		//------------------------------ Effects-Preshoot-------------------------------------------	
		
		
		public void  effectsPreshoot(String userType) throws InterruptedException, Exception {
			
			if (userType.equalsIgnoreCase("NonSubscribedUser")) {
				navigatedToEffectsScreen(userType);
				tappedBackOfEffectScreen(userType);
				checkLayoutOfEffectsScreen(userType);
				downloadPinPresentOnEachEffect(userType);
				downloadPinIsNotVisible(userType);
				viewRecentlyAppliedEffect(userType);
				addAnEffectToFavourite(userType);
				favouriteEffectIsVisibleUnderFavouriteTab(userType);
				effectIsDisplayedInAccountFavouriteList(userType);
				removeTheAddedEffectFromFavourite(userType);
				effectIsRemovedFromEffectsFavouriteList(userType);
				effectIsRemovedFromAccountFavouriteList(userType);
				removeEffectFromAccountFavouriteList(userType);
				tappedAnywhereOnAboveTheEffectSection(userType);
				searchingFromDiscoverScreen(userType);
						
			}else {
				
			}	
		}
		

			
		
		public void  navigatedToEffectsScreen(String userType) throws InterruptedException, Exception {
			extent.HeaderChildNode("Check if on tapping Effects Icon user is navigated to Effects screen");
		    System.out.println("TC_Mobile_001");
		    extent.extentLogger("", "TC_Mobile_001");
		    
			

		    if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
				click(AMDOnboardingScreen.objHipiButton, "HiPi");
				Thread.sleep(6000);

			} else {

			}
		    verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"Create Button");

		    if (verifyElementExist(HipiCreateVideoPage.objCreatePermissionVideo,
					"Allow ZEE5 to take pictures and record video?")) {
				logger.info("Permission dialog:" + "Allow ZEE5 to take pictures and record video?");
				verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow");
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				logger.info("Allow ZEE5 to take pictures and record video-" + "Allow button");
				Thread.sleep(5000);

				logger.info("Permission dialog:" + "Allow ZEE5 to access photos, media, and files on your device");
				verifyElementExist(HipiCreateVideoPage.objCreateAllow,
						"Allow ZEE5 to access photos, media, and files on your device?");
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				logger.info("Allow ZEE5 to access photos, media, and files on your device-" + "Allow button");
				Thread.sleep(5000);

				logger.info("Permission dialog:" + "Allow ZEE5 to record audio");
				verifyElementExist(HipiCreateVideoPage.objCreateAllow, "Allow ZEE5 to record audio?");
				click(HipiCreateVideoPage.objCreateAllow, "Allow button");
				logger.info("Allow ZEE5 to record audio-" + "Allow button");
				//Thread.sleep(40000);
				waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
				verifyElementExist(HipiCreateVideoPage.objCreateReadyDialog, "Ready dialog");
				click(HipiCreateVideoPage.objCreateReadyYes, "yes button");
				logger.info("Ready dialog displayed:" + "yes button");
				Thread.sleep(10000);
			}
			logger.info("Create video page:" + "Create video page displayed");
			
			waitTime(5000);
			
			click(HipiCreateVideoPage.objeffect, "Effect Icon");
			waitTime(5000);
			if(verifyIsElementDisplayed(HipiEffectPage.objAddEffectsScreeen, "Add Effects Screeen")){
				logger.info("Add Effects Screeen:" + "Add Effects Screeen is displayed when ever click on Effect Icon");
				extent.extentLoggerPass("Add Effects Screeen:","Add Effects Screeen is displayed when ever click on Effect Icon");
			} else {
				logger.info("Add Effects Screeen:" + "Add Effects Screeen is not displayed when ever click on Effect Icon");
				extent.extentLoggerFail("Add Effects Screeen:","Add Effects Screeen is not displayed when ever click on Effect Icon");
			}	
		}
			
			public void  tappedBackOfEffectScreen(String userType) throws Exception {
				
				extent.HeaderChildNode("Check if user is redirected to Video creation screen, when tapped back of effect screen");
			    System.out.println("TC_Mobile_002");
			    extent.extentLogger("", "TC_Mobile_002");
				
				verifyIsElementDisplayed(HipiEffectPage.objEffectsScreenPopUp, "Effects Screen PopUp");
				waitTime(3000);
				click(HipiEffectPage.objTaponBackButton, "Tap on Back Button");
				if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Creation screen")) {
					logger.info("Creation Screen:"+ "Creation screen is displayed when ever click on Back button");
					extent.extentLoggerPass("Creation Screen:","Creation screen is displayed when ever click on Back button");
				} else {
					logger.info("Creation Screen:"+ "Creation screen is not displayed when ever click on Back button");
					extent.extentLoggerFail("Creation Screen:","Creation screen is not displayed when ever click on Back button");
				}
			}
			
			
			public void checkLayoutOfEffectsScreen(String userType) throws Exception {
				

				extent.HeaderChildNode("Check layout of effects screen");
			    System.out.println("TC_Mobile_003");
			    extent.extentLogger("", "TC_Mobile_003");
				
			    waitTime(3000);
				click(HipiCreateVideoPage.objeffect, "Effect Icon");
				waitTime(4000);
				verifyElementPresent(HipiEffectPage.objTaponBackButton, "Back Button");
				verifyElementPresent(HipiEffectPage.objAllButton, "All Button");
				verifyElementPresent(HipiEffectPage.objFavoritesButton, "Favorites Button");
				verifyElementPresent(HipiEffectPage.objRecentsButton, "Recents Button");
				verifyElementPresent(HipiEffectPage.objTrendingButton, "Trending Button");
				verifyElementPresent(HipiEffectPage.objPlugInsButton, "PlugIns Button");
				verifyElementPresent(HipiEffectPage.objBeautyButton, "Beauty Button");
				verifyElementPresent(HipiEffectPage.objCuteButton, "Cute Button");
				verifyElementPresent(HipiEffectPage.objActionButton, "Action Button");

			}
			
			public void downloadPinPresentOnEachEffect(String userType) throws Exception {
				

				extent.HeaderChildNode("Check if user is able to download effects, by tapping on download pin present on each effect");
			    System.out.println("TC_Mobile_006");
			    extent.extentLogger("", "TC_Mobile_006");
//			    BackToFeedScreen();
//
//				Back(1);
//				
//				waitTime(5000);
//				logout();
//				waitTime(5000);
//				click(AMDHomePage.objMoreMenu, "More Menu");
//				
//				waitTime(2000);
//				click(AMDOnboardingScreen.objLoginLink, "Login Link");
//				String Username = getParameterFromXML("MyProfileHipiNonsubUsername");
//				String Password = getParameterFromXML("MyProfileHipiNonsubPassword");
//
//				Thread.sleep(5000);
//				hideKeyboard();
//				Thread.sleep(5000);
//				click(AMDLoginScreen.objEmailIdField, "Email field");
//				hideKeyboard();
//				type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
//				verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
//				verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
//				hideKeyboard();
//
//				type(AMDLoginScreen.objPasswordField, Password, "Password field");
////				hideKeyboard();
//				verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
//				waitTime(9000);
//
//				verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
//				waitTime(5000);
//
//				
//				 verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"Create Button");
//				    waitTime(5000);
//					click(HipiCreateVideoPage.objeffect, "Effect Icon");
					waitTime(5000);
//					String effectName1 = getText(HipiEffectPage.objEffectName1);
					
					
					
					effectName = getText(HipiEffectPage.objEffectName);
					if(verifyElementExist(HipiEffectPage.objEffectDownloadButton(effectName),"Before download ")) {
						logger.info("Before download Symble is displayed");
						extent.extentLoggerPass("Before download ", "Before download Symble is displayed");
					}else {
						logger.error("Before download Symble is not displayed");
						extent.extentLoggerFail("Before download ", "Before download Symble is not displayed");
							}
					
				click(HipiEffectPage.objEffectDownloadButton(effectName), "One Of The Effect");
				waitTime(2000);
				if(verifyIsElementDisplayed(HipiEffectPage.objDownloadProgress, "Download Progress")){
					logger.info("Download Progress is displayed when ever click on download");
					extent.extentLoggerPass("Before download ", "Download Progress is displayed when ever click on download");
				}else {
					logger.error("Download Progress is not displayed when ever click on download");
					extent.extentLoggerFail("Download Progress:", "Download Progress is not displayed when ever click on download");
						}
				waitTime(60000);
				
				
			}
			
				public void downloadPinIsNotVisible(String userType) throws Exception {

				extent.HeaderChildNode("Check if download pin is not visible on the effect which is downloaded");
			    System.out.println("TC_Mobile_007");
			    extent.extentLogger("", "TC_Mobile_007");
				
			    if(verifyElementExist(HipiEffectPage.objEffectDownloadButton(effectName),"Download symble")) {
					logger.info("After download  Symbol is not displayed");
					extent.extentLoggerFail("After download ", "After download  Symbol is displayed");
				}else {
					logger.error("After download  Symbol is displayed");
					extent.extentLoggerPass("After download ", "After download  Symbol is not displayed");
						}
}

			public void  viewRecentlyAppliedEffect(String userType) throws Exception {
				extent.HeaderChildNode("Check if user is able to view recently applied effect");
			    System.out.println("TC_Mobile_009");
			    extent.extentLogger("", "TC_Mobile_009");
//			    String effectName1 = getText(HipiEffectPage.objEffectName1);	
			    click(HipiEffectPage.objDownloadedEffectOverlay(effectName), "Effect");
				Back(1);
//				click(HipiCreateVideoPage.objeffect, "Effect Icon");
//				waitTime(4000);
//			    click(HipiEffectPage.objClickOnEffect, "Click On Effect");
//				Back(1);

				  verifyElementPresentAndClick(HipiCreateVideoPage.objrecording,"Recording Button");

					 waitTime(20000);
				
						if (verifyElementExist(HipiCreateVideoPage.objVideoEditScreen, "Video Edit Screen")) {

							logger.info("Vide oEdit Screen: " + " When ever recording complet video edit screen is displayed ");
							extent.extentLoggerPass("Video Edit Screen:", "When ever recording complet video edit screen is displayed ");
						} else {
							logger.info("Video Edit Screen: " + " When ever recording complet video edit screen is not displayed ");
							extent.extentLoggerFail("Video Edit Screen:",
									"When ever recording complet video edit screen is not displayed ");
						}
//String  fav = getText(HipiCreateVideoPage.objpost);
//String fav2 = getText(HipiCreateVideoPage.objpost);
//
//if(fav.equals(fav2)) {
//
//}

						verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
						waitTime(15000);
						waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
						verifyElementPresentAndClick(HipiCreateVideoPage.objPostDescription, "Description input");
						String postDescription = getParameterFromXML("Description");
						hideKeyboard();

						type(HipiCreateVideoPage.objPostDescription, postDescription, "Description");
						waitTime(3000);						waitTime(3000);
						verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "genre video");
						verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "english");
						verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox,
								" 'By Continuing, you agree to our Terms & Privacy Policy' text ");
						verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "posthipi");// saveasdraft
						waitTime(4000);
						verifyIsElementDisplayed(HipiCreateVideoPage.objVideoUploadPopup, "Video Upload Popup");
						click(HipiCreateVideoPage.objGoToFeedButton, "Go To Feed Button");
						
						waitTime(20000);
						verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"Create Button");
						waitTime(4000);
						click(HipiCreateVideoPage.objeffect, "Effect Icon");
						waitTime(4000);
						click(HipiEffectPage.objRecentsButton, "Recents Button");
						waitTime(3000);
						if(verifyIsElementDisplayed(HipiEffectPage.objEffectName(effectName), "Recent Effect")){

							logger.info("Recent Effect:" + "Recent Effect is displayed when ever click on Recents Button");
							extent.extentLoggerPass("Recent Effect:", "Recent Effect is displayed when ever click on Recents Button");
						} else {
							logger.info("Recent Effect:" + "Recent Effect is displayed when ever click on Recents Button");
							extent.extentLoggerFail("Recent Effect:","Recent Effect is displayed when ever click on Recents Button");
						}
						
						
//						
				
				
			}
			
			
			public void addAnEffectToFavourite(String userType) throws Exception {
				extent.HeaderChildNode("Check if user is able to add an effect to favourite");
			    System.out.println("TC_Mobile_0010");
			    extent.extentLogger("", "TC_Mobile_010");
			    
				click(HipiEffectPage.objAllButton, "All Button");
				waitTime(5000);
			
				
				click(HipiEffectPage.objFavouriteAnEffect(effectName), "Favourite Button");
				waitTime(2000);
				if(verifyIsElementDisplayed(HipiEffectPage.objAddEffectPopUp, "Add Effect PopUp")) {
					logger.info("Add Effect PopUp:" + "Add Effect PopUp is displayed when ever click on Favourite Button");
					extent.extentLoggerPass("Add Effect PopUp:", "Add Effect PopUp is displayed when ever click on Favourite Button");
					click(HipiEffectPage.objClickYes, "Yes Button");
				} else {
					logger.info("Add Effect PopUp:" + "Add Effect PopUp is not displayed when ever click on Favourite Button");
					extent.extentLoggerFail("Add Effect PopUp:","Add Effect PopUp is not displayed when ever click on Favourite Button");
				
				}
				waitTime(5000);
			}
			
			public void favouriteEffectIsVisibleUnderFavouriteTab(String userType) throws Exception {
				extent.HeaderChildNode("Check if favourite effect is visible under favourite tab");
			    System.out.println("TC_Mobile_0011");
			    extent.extentLogger("", "TC_Mobile_011");
			    
//			    String effectName = getText(HipiEffectPage.objEffectName);
//			    
//			    String effectIsPresentProfile = getText(HipiEffectPage.objeffectIsPresentProfile);
			    
				click(HipiEffectPage.objFavoritesButton, "Favorites Button");
				waitTime(4000);
				if(verifyIsElementDisplayed(HipiEffectPage.objEffectName(effectName), "Favourited Effect")){

					logger.info("Add Favourite Effect:" + "Effect added Favourite");
					extent.extentLoggerPass("Add Favourite Effect:", "Effect added Favourite");
				} else {
					logger.info("Add Favourite Effect:" + "Effect not added Favourite");
					extent.extentLoggerFail("Add Favourite Effect:","Effect not added Favourite");
				}
				
			}

			public void effectIsDisplayedInAccountFavouriteList(String userType) throws Exception {
				
				extent.HeaderChildNode("Verify the selected effect is displayed in Account favourite list");
			    System.out.println("TC_Mobile_0012");
			    extent.extentLogger("", "TC_Mobile_012");
			    click(HipiEffectPage.objTaponBackButton, "Back Button");
				waitTime(2000);
				if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Creation screen")) {
					logger.info("Creation Screen:"+ "Creation screen is displayed when ever click on Back button");
					extent.extentLoggerPass("Creation Screen:","Creation screen is displayed when ever click on Back button");
				} else {
					logger.info("Creation Screen:"+ "Creation screen is not displayed when ever click on Back button");
					extent.extentLoggerFail("Creation Screen:","Creation screen is not displayed when ever click on Back button");
				}
				Back(1);
				click(HipiMePage.objMeicon, "Me Icon");
				waitTime(6000);
				click(HipiMePage.objfavourite, "Favourite");
				waitTime(5000);
				click(HipiMePage.objEffects, "Effects");
				waitTime(3000);
//				 String effectName1 = getText(HipiMePage.objEffectDisplayedInEffects);
//				    
//				    String effectIsPresentProfile = getText(HipiEffectPage.objeffectIsPresentProfile);
//				    
				if(verifyIsElementDisplayed(HipiEffectPage.objEffectName(effectName), "Effect Displayed In Effects")){
					logger.info("Effect Displayed In Effects:"+ "Effect is Displayed In Effects when ever click on Effects");
					extent.extentLoggerPass("Effect Displayed In Effects:","Effect is Displayed In Effects when ever click on Effects");
				} else {
					logger.info("Effect Displayed In Effects:"+ "Effect is not Displayed In Effects when ever click on Effects");
					extent.extentLoggerFail("Effect Displayed In Effects:","Effect is not Displayed In Effects when ever click on Effects");
				}
//				if(effectName.equals(effectIsPresentProfile)) {
//					logger.info("Effect Displayed In Effects:"+ "Effect is Displayed In Effects when ever click on Effects");
//					extent.extentLoggerPass("Effect Displayed In Effects:","Effect is Displayed In Effects when ever click on Effects");
//				} else {
//					logger.info("Effect Displayed In Effects:"+ "Effect is not Displayed In Effects when ever click on Effects");
//					extent.extentLoggerFail("Effect Displayed In Effects:","Effect is not Displayed In Effects when ever click on Effects");
//				}
				
			}
			
			public void  removeTheAddedEffectFromFavourite(String userType) throws Exception {
				extent.HeaderChildNode("Check if user is able to remove the added effect from favourite");
			    System.out.println("TC_Mobile_0013");
			    extent.extentLogger("", "TC_Mobile_013");
				Back(1);
			    verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"Create Button");
			    waitTime(5000);
				click(HipiCreateVideoPage.objeffect, "Effect Icon");
				waitTime(5000);
			    click(HipiEffectPage.objFavouriteAnEffect(effectName), "Favourite Button");
			    waitTime(2000);
			   if( verifyIsElementDisplayed(HipiEffectPage.objRemoveFromFavorite, "Remove From Favorite")) {
				   logger.info("Remove From Favorite:"+ "Remove From Favorite popup is Displayed when ever click on Favourite Button");
					extent.extentLoggerPass("Remove From Favorite:","Remove From Favorite popup is Displayed when ever click on Favourite Button");
				    click(HipiEffectPage.objClickYes, "Yes Button");

			   } else {
					logger.info("Remove From Favorite:"+ "Remove From Favorite popup is not Displayed when ever click on Favourite Button");
					extent.extentLoggerFail("Remove From Favorite:","Remove From Favorite popup is not Displayed when ever click on Favourite Button");
				}
				waitTime(5000);
				
				
			}
			
			
			public void effectIsRemovedFromEffectsFavouriteList(String userType) throws Exception {
				extent.HeaderChildNode("Verify the selected effect is removed from Effects favourite list");
			    System.out.println("TC_Mobile_0014");
			    extent.extentLogger("", "TC_Mobile_014");
			  
			    
				click(HipiEffectPage.objFavoritesButton, "Favorites Button");
				waitTime(5000);
				if (verifyIsElementDisplayed(HipiEffectPage.objEffectName(effectName), "Effect removed ")) {
					logger.info("Remove Effect:"+ "Effect is visible in Favorites");
					extent.extentLoggerFail("Remove Effect:","Effect is visible in Favorites");
				} else {
					logger.info("Remove Effect:"+ "Effect is not visible in Favorites");
					extent.extentLoggerPass("Remove Effect:","Effect is not visible in Favorites");
				}
			}
			
			public void effectIsRemovedFromAccountFavouriteList(String userType) throws Exception {
				extent.HeaderChildNode("Verify the selected effect is removed from Account favourite list");
			    System.out.println("TC_Mobile_0015");
			    extent.extentLogger("", "TC_Mobile_015");
				click(HipiEffectPage.objTaponBackButton, "Back Button");
				waitTime(2000);
				if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Creation screen")) {
					logger.info("Creation Screen:"+ "Creation screen is displayed when ever click on Back button");
					extent.extentLoggerPass("Creation Screen:","Creation screen is displayed when ever click on Back button");
				} else {
					logger.info("Creation Screen:"+ "Creation screen is not displayed when ever click on Back button");
					extent.extentLoggerFail("Creation Screen:","Creation screen is not displayed when ever click on Back button");
				}
				Back(1);
				waitTime(4000);
				click(HipiMePage.objMeicon, "Me Icon");
				waitTime(6000);
				click(HipiMePage.objfavourite, "Favourite");
				waitTime(5000);
				click(HipiMePage.objEffects, "Effects");
				waitTime(3000);
				if(verifyIsElementDisplayed(HipiEffectPage.objEffectName(effectName), "Effect Removed")){
					logger.info("Remove Effect:"+ "Effect is not removed from Profile");
					extent.extentLoggerFail("Remove Effect:","Effect is not removed from Profile");
				} else {
					logger.info("Remove Effect:"+ "Effect is removed from Profile");
					extent.extentLoggerPass("Remove Effect:","Effect is removed from Profile");
				}
				
				
			}
			public void removeEffectFromAccountFavouriteList(String userType) throws Exception {
				extent.HeaderChildNode("Check if user is able to remove effect from Account favourite list");
			    System.out.println("TC_Mobile_0016");
			    extent.extentLogger("", "TC_Mobile_016");
				Back(1);
			    verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"Create Button");
			    waitTime(5000);
				click(HipiCreateVideoPage.objeffect, "Effect Icon");
				waitTime(4000);
				click(HipiEffectPage.objFavouriteAnEffect(effectName), "Favourite Button");
				waitTime(2000);
				verifyIsElementDisplayed(HipiEffectPage.objAddEffectPopUp, "Add Effect PopUp");
				click(HipiEffectPage.objClickYes, "Yes Button");
				waitTime(5000);
			    click(HipiEffectPage.objTaponBackButton, "Back Button");
			    waitTime(3000);
			    if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Creation screen")) {
					logger.info("Creation Screen:"+ "Creation screen is displayed when ever click on Back button");
					extent.extentLoggerPass("Creation Screen:","Creation screen is displayed when ever click on Back button");
				} else {
					logger.info("Creation Screen:"+ "Creation screen is not displayed when ever click on Back button");
					extent.extentLoggerFail("Creation Screen:","Creation screen is not displayed when ever click on Back button");
				}
			    Back(1);
			    waitTime(5000);
				click(HipiMePage.objMeicon, "Me Icon");
				waitTime(6000);
				click(HipiMePage.objfavourite, "Favourite");
				waitTime(5000);
				click(HipiMePage.objEffects, "Effects");
				waitTime(4000);
				if(verifyIsElementDisplayed(HipiEffectPage.objEffectName(effectName), "Effect")){
					logger.info("Effect:"+ "Effect is Displayed In Effects when ever click on Effects");
					extent.extentLoggerPass("Effect:","Effect is Displayed In Effects when ever click on Effects");
				} else {
					logger.info("Effect:"+ "Effect is not Displayed In Effects when ever click on Effects");
					extent.extentLoggerFail("Effect:","Effect is not Displayed In Effects when ever click on Effects");
				}
				click(HipiMePage.objEffectDisplayedInEffects, "Effect ");
				waitTime(4000);
			    if(verifyIsElementDisplayed(HipiEffectPage.objRelatedVideosEffects, "Related Videos Effects")){
			    	logger.info("Related Videos Effects:"+ "Related Videos Effects is displayed when ever click on Effect");
					extent.extentLoggerPass("Related Videos Effects:","Related Videos Effects is displayed when ever click on Effect");
				} else {
					logger.info("Related Videos Effects:"+ "Related Videos Effects is not displayed when ever click on Effect");
					extent.extentLoggerFail("Related Videos Effects:","Related Videos Effects is not displayed when ever click on Effect");
				}
			    verifyIsElementDisplayed(HipiEffectPage.objEffectThumbnail, "Effect Thumbnail");
			    click(HipiEffectPage.objClickOnFavoriteInEffectDetailsScreen, "Favorite In Effect Details Screen");
			    if (verifyElementExist(HipiEffectPage.objEffectRemoved, "RemovedFavourite")) {
					logger.info("Removie favourite popup:" + "Effect is Removed");
					extent.extentLoggerPass("Removie favourite popup:","Effect is Removed");
					
				} else {
					logger.info("Removie favourite popup:" + "Effect is not Removed");
					extent.extentLoggerFail("Removie favourite popup:","Effect is not Removed");
				}
			    
			}
			
			public void  tappedAnywhereOnAboveTheEffectSection(String userType) throws Exception {
				extent.HeaderChildNode("Check if user is redirected to Video creation screen, when tapped anywhere on above the effect section");
			    System.out.println("TC_Mobile_0019");
			    extent.extentLogger("", "TC_Mobile_019");
			    Back(3);
			    verifyElementPresentAndClick(HipiCreateVideoPage.objcreatevideo,"Create Button");
			    waitTime(5000);
				click(HipiCreateVideoPage.objeffect, "Effect Icon");
			  		waitTime(8000);
				click(HipiEffectPage.objEffectLayout, "Effect Layout");
				waitTime(5000);
				  if (verifyElementExist(HipiCreateVideoPage.objcreationpage, "Creation screen")) {
						logger.info("Creation Screen:"+ "Creation screen is displayed when ever click on Back button");
						extent.extentLoggerPass("Creation Screen:","Creation screen is displayed when ever click on Back button");
					} else {
						logger.info("Creation Screen:"+ "Creation screen is not displayed when ever click on Back button");
						extent.extentLoggerFail("Creation Screen:","Creation screen is not displayed when ever click on Back button");
					}
				
				
			}
			
			public void searchingFromDiscoverScreen(String userType) throws Exception {
				extent.HeaderChildNode("Effects Check if user is able to view video with effect by searching from Discover screen");
			    System.out.println("TC_Mobile_0020");
			    extent.extentLogger("", "TC_Mobile_020");
			Back(1);
			click(HipiDiscoverPage.objDiscoverOption, "Discover Option");
			waitTime(5000);
			click(HipiDiscoverPage.objDiscoverSearchButton, "Search Button");
			waitTime(5000);
//			click(HipiDiscoverPage.objDiscoverSearchButton, "Search");
//			waitTime(3000);
			String coolglass = getParameterFromXML("coolglass");
			waitTime(5000);
			type(HipiDiscoverPage.objSearchButton, coolglass, "cool glass");
			waitTime(3000);
			hideKeyboard();
			waitTime(3000);
			click(HipiDiscoverPage.objThumbnail1, "fun video");
			waitTime(3000);

			if (verifyElementExist(HipiEffectPage.objCoolGlassEffect, "Effect Screen")) {

				logger.info("Effect: " + " Cool Galsses Effect Screen is displayed");
				extent.extentLoggerPass("Effect:", " Cool Galsses Effect Screen is displayed");
				click(HipiEffectPage.objCoolGlassEffect, "Effect used-cool Glasses");
			} else {
				logger.info("Effect: " + " Cool Galsses Effect Screen is not displayed");
				extent.extentLoggerFail("Effect: ", " Cool Galsses Effect Screen is displayed");
			}
			verifyElementExist(HipiEffectPage.objEffectDetailScreen, "Effect detail screen");
			waitTime(3000);
			if (verifyElementExist(HipiEffectPage.objRelatedVideosEffects, " Related Videos ")) {

				logger.info("Related Videos Effects: " + "Related Videos Effects is displayed");
				extent.extentLoggerPass("Related Videos Effects: ", "Related Videos Effects is displayed");

			} else {
				logger.info("Related Videos Effects: " + "Related Videos Effects is not displayed");
				extent.extentLoggerFail("Related Videos Effects: ", "Related Videos Effects is not displayed");
			}
			
			String coolGlass = getText(HipiEffectPage.objCoolGlassesName);
			if (verifyElementExist(HipiEffectPage.objCoolGlassesName, "Effect Name")) {
				logger.info("Effect Name:" + coolGlass);
				extent.extentLoggerPass("Effect Name:", "Cool Glasses Effect Name is displayed ");
			} else {
				logger.info("Effect Name:");
				extent.extentLoggerFail("Effect Name:", "Cool Glasses Effect Name is not displayed");

			}
			click(HipiEffectPage.objEffectThumbnail, "Effect Thumbnail");
			waitTime(3000);
			if(verifyIsElementDisplayed(HipiEffectPage.objThumbnailImageScreen, "Thumbnail Image Screen")){

				logger.info("Thumbnail Image Screen:" + "Thumbnail Image Screen is displayed when ever click on Effect Thumbnail");
				extent.extentLoggerPass("Thumbnail Image Screen:", "Thumbnail Image Screen is displayed when ever click on Effect Thumbnail");

			} else {
				logger.info("Thumbnail Image Screen:" + "Thumbnail Image Screen is not displayed when ever click on Effect Thumbnail");
				extent.extentLoggerFail("Thumbnail Image Screen:", "Thumbnail Image Screen is not displayed when ever click on Effect Thumbnail");
			}
			Back(1);
			String numberOfViewsBelowToTitle = getText(HipiEffectPage.objFollowedByNumberOfViewsBelowToTitle);
			if(verifyIsElementDisplayed(HipiEffectPage.objFollowedByNumberOfViewsBelowToTitle, "Followed Count")){
				logger.info("Followed Count:" + numberOfViewsBelowToTitle);
				extent.extentLoggerPass("Followed Count:", "Followed Count is displayed when ever click on Effect used-cool Glasses");

			} else {
				logger.info("Followed Count:" + "Followed Count is not displayed when ever click on Effect used-cool Glasses");
				extent.extentLoggerFail("Followed Count:", "Followed Count is not displayed when ever click on Effect used-cool Glasses");
			}
		
		
			}
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		//-----------------------------------------------------------------------------------------------------------------
			
			
			
			
			//------------------------------Add Sound-------------------------------------------
			public void PostShootingValidation(String userType) throws Exception {
					extent.HeaderChildNode("AddSoundPostShootValidation");
				  
					//TC_Mobile_001
					extent.HeaderChildNode("Check layout of Sound Screen");
					extent.extentLogger("", "TC_Mobile_001");System.out.println("TC_Mobile_001");
					verifyElementPresentAndClick(AMDHipi.objHipiIcon, "hipi icon");
					verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");			
					click(HipiAddMusicPage.objAllowToAddMusic,"Allow button");
					click(HipiAddMusicPage.objAllowToAddMusic,"Allow button");
					click(HipiAddMusicPage.objAllowToAddMusic,"Allow button");
					waitTime(6000);
					click(HipiAddMusicPage.objOkBtnInAddsoundPermissionPopup,"Ok button");
					waitTime(8000);
					verifyElementPresentAndClick(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
					click(HipiAddMusicPage.objFirstMusicInAddMusicScreen,"Music");
					verifyElementPresent(HipiAddMusicPage.objMusicTrimPopup, "Music Trim Pop up");
					verifyElementPresent(HipiAddMusicPage.objSelectMusicCloseIcon, "Music Trim Close icon");
					verifyElementPresent(HipiAddMusicPage.objSelectMusicPauseButton, "Pause button");
					verifyElementPresent(HipiAddMusicPage.objSelectMusicBtn, "Select Music button(Check Icon)");
					verifyElementPresent(HipiAddMusicPage.objMusicTrimEndTime,"Music Trim End time");
					verifyElementPresent(HipiAddMusicPage.objStartTrimTime, "Music Trin Start time");
					verifyElementPresent(HipiAddMusicPage.objMusicTrimRightHandle, "Music Trim Handle");
					verifyElementPresent(HipiAddMusicPage.objMusicTrimIndicatorLine, "Sound Track");
					Back(2);
					
					//TC_Mobile_002
					extent.HeaderChildNode("Check if user is able to add the music after recording");
					extent.extentLogger("", "TC_Mobile_002");System.out.println("TC_Mobile_002");
					click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
					click(HipiCreateVideoPage.objrecordbtn,"Video record button");
					waitTime(15000);
					verifyElementPresentAndClick(HipiCreateVideoPage.objaddmusicbtn, "Add Music icon in video edit screen");
					verifyElementExist(HipiAddMusicPage.objAddMusicTitle, "Add music Screen");
					click(HipiAddMusicPage.objFirstMusicInAddMusicScreen,"Music");
					click(HipiAddMusicPage.objSelectMusicBtn, "Select Music button(Check Icon)");
					if(verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Selected Music on top of the video edit screen" )) {
						logger.info("User is able to add the music after recording");
						extent.extentLoggerPass("AddSoundPreShoot", "User is able to add the music after recording");
					}else {
						logger.error("User is unable to add the music after recording");
						extent.extentLoggerFail("AddSoundPreShoot", "User is unable to add the music after recording");
							}	
						
					click(HipiAddMusicPage.objBackButtonInVideoEditScreen,"Back button");
					click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
					Back(1);
					click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
					
					//TC_Mobile_003
					extent.HeaderChildNode("Check if user is able to replace the already added sound");
					extent.extentLogger("", "TC_Mobile_003");System.out.println("TC_Mobile_003");
					click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
					click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
					click(HipiAddMusicPage.objFirstMusicInAddMusicScreen,"Music");
					click(HipiAddMusicPage.objSelectMusicBtn, "Select Music button(Check Icon)");
					verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Added music in Recording screen");
					String firstmusic = findElement(HipiAddMusicPage.objSelectedMusicInRecordingScreen).getText();
					System.out.println(firstmusic);
					click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
					String replacedmusic = findElement(HipiAddMusicPage.objFirstMusicFromAddMusicPage).getText();
					System.out.println(replacedmusic);
					click(HipiAddMusicPage.objFirstMusicFromAddMusicPage,"Music");
					verifyElementPresentAndClick(HipiAddMusicPage.objSelectMusicBtn, "Check icon");
					verifyElementExist(HipiAddMusicPage.objReplaceMusicPromptMsg, "Replace Music popup");
					click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Yes button");
					verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Updated music in Recording screen");
					String updatedmusic = findElement(HipiAddMusicPage.objSelectedMusicInRecordingScreen).getText();
					System.out.println(updatedmusic);
					if(replacedmusic.equalsIgnoreCase(updatedmusic)) {
						logger.info("User is able to replace the already added sound");
					extent.extentLoggerPass("AddSoundPreShoot", "User is able to replace the already added sound");
				}else {
					logger.error("User is not able to replace the already added sound");
					extent.extentLoggerFail("AddSoundPreShoot", "User is not able to replace the already added sound");
						}
					Back(1);
					
					//TC_Mobile_004
					extent.HeaderChildNode("Check if trim icon is enabled when video is created with original sound");
					extent.extentLogger("", "TC_Mobile_004");System.out.println("TC_Mobile_004");
					click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
					click(HipiCreateVideoPage.objrecordbtn,"Video record button");
					waitTime(10000);
					verifyElementPresentAndClick(HipiAddMusicPage.objTrimIconInVideoEditScreen, "Trim Icon");
					verifyElementExist(HipiAddMusicPage.objTrimPopup, "Trim pop up");
					waitTime(2000);
					extent.extentLogger("","Clicking BACK from Mobile Keyboard");System.out.println("Clicking BACK from Mobile Keyboard");
					Back(1);
					waitTime(4000);
					if(!verifyElementExist(HipiAddMusicPage.objTrimPopup, "Trim pop up")) {
						logger.info("On tapping back from mobile keyboard, user remains on Video Edit Screen ");
						extent.extentLoggerPass("AddSoundPostShoot", "On tapping back from mobile keyboard, user remains on Video Edit Screen ");
					}else {
						logger.error("On tapping back from mobile keyboard, user Fails to remain on Video Edit Screen");
						extent.extentLoggerFail("AddSoundPostShoot", "On tapping back from mobile keyboard, user Fails to remain on Video Edit Screen");
							}
					
					
					//TC_Mobile_005
					extent.HeaderChildNode("Check if trim icon is enabled when video is created with original sound");
					extent.extentLogger("", "TC_Mobile_005");System.out.println("TC_Mobile_005");
					verifyElementExist(HipiAddMusicPage.objTrimIconInVideoEditScreen, "Trim Icon");
					Boolean value = findElement(HipiAddMusicPage.objTrimIconInVideoEditScreen).isEnabled();
					if(value == true) {
						logger.info("Trim icon is enabled when video is created with original sound");
						extent.extentLoggerPass("AddSoundPreShoot", "Trim icon is enabled when video is created with original sound");
					}else {
						logger.error("Trim icon is not enabled when video is created with original sound");
						extent.extentLoggerFail("AddSoundPreShoot", "Trim icon is not enabled when video is created with original sound");
							}	
					
					Back(1);
					click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
					Back(1);
					click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
				
					//TC_Mobile_006
					extent.HeaderChildNode("Check if trim icon is enabled when video is created with some sound");
					extent.extentLogger("", "TC_Mobile_006");System.out.println("TC_Mobile_006");
					click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
					click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
					click(HipiAddMusicPage.objFirstMusicInAddMusicScreen,"Music");
					click(HipiAddMusicPage.objSelectMusicBtn, "Select Music button(Check Icon)");
					verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Added music in Recording screen");
					click(HipiCreateVideoPage.objrecordbtn,"Video record button");
					waitTime(10000);
					verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Selected music to video in video edit screen");
					verifyElementExist(HipiAddMusicPage.objTrimIconInVideoEditScreen, "Trim Icon");
					Boolean value2 = findElement(HipiAddMusicPage.objTrimIconInVideoEditScreen).isEnabled();
					if(value2 == true) {
						logger.info("Trim icon is 'enabled' when video is created with some sound");
						extent.extentLoggerPass("AddSoundPreShoot", "Trim icon is 'enabled' when video is created with some sound");
					}else {
						logger.error("Trim icon is not 'enabled' when video is created with some sound");
						extent.extentLoggerFail("AddSoundPreShoot", "Trim icon is not 'enabled' when video is created with some sound");
							}	
					
								
					//TC_Mobile_007
					extent.HeaderChildNode("Check if user is able to drag the trimmer of a sound selected during video creation");
					extent.extentLogger("", "TC_Mobile_007");System.out.println("TC_Mobile_007");
					    click(HipiAddMusicPage.objTrimIconInVideoEditScreen, "Trim Icon in video edit screen");
					    verifyElementExist(HipiAddMusicPage.objMusicTrimPopup, "Trim pop up");
					    
					    String EndTime = getDriver().findElement(HipiAddMusicPage.objMusicEndTime).getText();
					    System.out.println(EndTime);
					    Thread.sleep(5000);
					    MusicTrim(HipiAddMusicPage.objMusicTrimRightHandle2);
					    
					    String EndTimeAfterTrim = getDriver().findElement(HipiAddMusicPage.objMusicEndTime).getText();
					    System.out.println(EndTimeAfterTrim);
					    
					    if(EndTime.equals(EndTimeAfterTrim) == false){
					    	logger.info("User is able to drag the trimmer of a sound selected during video creation");
							extent.extentLoggerPass("AddSoundPostShoot", "User is able to drag the trimmer of a sound selected during video creation");
					    }else {
					    	logger.error("User is Unable to drag the trimmer of a sound selected during video creation");
							extent.extentLoggerFail("AddSoundPostShoot", "User is Unable to drag the trimmer of a sound selected during video creation");
					    }
					    
					  //TC_Mobile_009
						extent.HeaderChildNode("Check if user is able to post the video after applying the trimmed sound");
						extent.extentLogger("", "TC_Mobile_009");System.out.println("TC_Mobile_009"); 
					    click(HipiSoundDetailPage.objTrimFinishIcon,"Finish icon");
					 	click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
					 	click(HipiCreateVideoPage.objpost,"Finsih video icon");
						waitTime(8000);
						hideKeyboard();
						click(HipiCreateVideoPage.objSelectGenre,"Genre");
						click(HipiCreateVideoPage.objSelectLanguage,"Language");
						click(HipiCreateVideoPage.objCheckTerms,"Check Terms and conditions");
						click(HipiCreateVideoPage.objuploadpost,"Upload post");
						click(HipiAddMusicPage.objOkBtnInAddsoundPermissionPopup,"Go to Feed button");
						waitTime(15000);
						click(HipiCreateVideoPage.objMeIcon, "User profile");
						waitTime(5000);
						if(verifyElementExist(HipiCreateVideoPage.objVideoCreated, "created video")) {
							logger.info("User is able to post the video after applying the trimmed sound");
							extent.extentLoggerPass("AddSoundPostShoot", "User is able to post the video after applying the trimmed sound");
						}else {
							logger.error("User is Unable to post the video after applying the trimmed sound");
							extent.extentLoggerFail("AddSoundPostShoot", "User is Unable to post the video after applying the trimmed sound");
								}
						Back(1);
						

						//TC_Mobile_010
						extent.HeaderChildNode("Check if on tapping back from mobile keyboard, user remains on Video Edit Screen");
						extent.extentLogger("", "TC_Mobile_010");System.out.println("TC_Mobile_010"); 
						click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
						click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
						click(HipiAddMusicPage.objFirstMusicInAddMusicScreen,"Music");
						click(HipiAddMusicPage.objSelectMusicBtn, "Select Music button(Check Icon)");
						verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Added music in Recording screen");
						click(HipiCreateVideoPage.objrecordbtn,"Video record button");
						waitTime(10000);
						verifyElementPresentAndClick(HipiSoundDetailPage.objVolumeIconOnVideoeditScreen, "Volume icon ");
						verifyElementExist(HipiSoundDetailPage.objAdjustVolumePopup, "Adjust volume popup");
						waitTime(3000);
						extent.extentLogger("","Clicking BACK from Mobile Keyboard");System.out.println("Clicking BACK from Mobile Keyboard");
						Runtime.getRuntime().exec("adb shell input keyevent 4");
						waitTime(4000);
						if(!verifyElementExist(HipiSoundDetailPage.objAdjustVolumePopup, "Adjust volume popup")) {
							logger.info("While Changing volume- on tapping  back  from mobile keyboard, user remains on  Video Edit Screen ");
							extent.extentLoggerPass("AddSoundPostShoot", "While Changing volume- on tapping  back  from mobile keyboard, user remains on  Video Edit Screen ");
						}else {
							logger.error("While Changing volume- on tapping  back  from mobile keyboard, user Fails to remain on  Video Edit Screen ");
							extent.extentLoggerFail("AddSoundPostShoot", "While Changing volume- on tapping  back  from mobile keyboard, user Fails to remain on  Video Edit Screen ");
								}
						Back(1);
						click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
						Back(1);
						click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");				
						
						
						  //TC_Mobile_011
						extent.HeaderChildNode("Check if only Microphone with volume bar is enabled when video is created with original sound");
						extent.extentLogger("", "TC_Mobile_011");System.out.println("TC_Mobile_011"); 
						click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
						click(HipiCreateVideoPage.objrecordbtn,"Video record button");
						waitTime(10000);
						verifyElementPresentAndClick(HipiSoundDetailPage.objVolumeIconOnVideoeditScreen, "Volume icon ");
						verifyElementExist(HipiSoundDetailPage.objAdjustVolumePopup, "Adjust volume popup");
						Boolean a = verifyElementExist(HipiSoundDetailPage.objMicrophoneEnabled,"Microphone with volume bar");
						String Value = findElement(HipiSoundDetailPage.objMicrophoneEnabled).getText();
						System.out.println(Value);
						logger.info(Value);
						if((a == true)) {
							logger.info("Microphone with volume bar is 'enabled' when video is created with original sound");
							extent.extentLoggerPass("AddSoundPostShoot", "Microphone with volume bar is 'enabled' when video is created with original sound");
						}else {
							logger.error("Microphone with volume bar is Not 'enabled' when video is created with original sound");
							extent.extentLoggerFail("AddSoundPostShoot", "Microphone with volume bar is Not'enabled' when video is created with original sound");
								}
						Back(2);
						click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
						Back(1);
						click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
						
						//TC_Mobile_012
				        extent.HeaderChildNode("Check if Microphone icon is disabled when video is created with some added sound but value id 0");
						extent.extentLogger("", "TC_Mobile_012");System.out.println("TC_Mobile_012"); 
						click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
						click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
						click(HipiAddMusicPage.objFirstMusicInAddMusicScreen,"Music");
						click(HipiAddMusicPage.objSelectMusicBtn, "Select Music button(Check Icon)");
						verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Added music in Recording screen");
						click(HipiCreateVideoPage.objrecordbtn,"Video record button");
						waitTime(10000);
						verifyElementPresentAndClick(HipiSoundDetailPage.objVolumeIconOnVideoeditScreen, "Volume icon ");
						verifyElementExist(HipiSoundDetailPage.objAdjustVolumePopup, "Adjust volume popup");
						Boolean v = verifyElementExist(HipiSoundDetailPage.objMicrophoneDisabled,"Microphone with volume bar");
						String Value2 = findElement(HipiSoundDetailPage.objMicrophoneDisabled).getText();
						System.out.println(Value2);extent.extentLogger("", Value2);
						logger.info(Value2);
						if((v == true)) {
							logger.info("Microphone  icon is 'disabled' when video is created with some added sound with volume 0");
							extent.extentLoggerPass("AddSoundPostShoot", "Microphone  icon is 'disabled' when video is created with some added sound with volume 0");
						}else {
							logger.error("Microphone  icon is Not 'disabled' when video is created with some added sound with volume 0");
							extent.extentLoggerFail("AddSoundPostShoot", "Microphone  icon is Not 'disabled' when video is created with some added sound with volume 0");
								}
						
						Back(1);
						
						//TC_Mobile_014
						extent.HeaderChildNode("Video Editing Check if user is able to adjust the volume of the Music enabled on added sound");
						extent.extentLogger("", "TC_Mobile_014");System.out.println("TC_Mobile_014"); 
						verifyElementPresentAndClick(HipiSoundDetailPage.objVolumeIconOnVideoeditScreen, "Volume icon ");
						verifyElementExist(HipiSoundDetailPage.objAdjustVolumePopup, "Adjust volume popup");
						String totalVolume = getDriver().findElement(HipiSoundDetailPage.objMusicSeekbarValue).getText();
					    System.out.println(totalVolume);extent.extentLogger("", "Volume before Decrease : "+totalVolume);			    
					    DecreaseMusicVolume(HipiSoundDetailPage.objMusicSeekBar);
					    String totalVolumeAfter = getDriver().findElement(HipiSoundDetailPage.objMusicSeekbarValue).getText();
					    System.out.println(totalVolumeAfter);extent.extentLogger("", "Volume after Decrease : "+totalVolumeAfter);
					    if((totalVolume.equals(totalVolumeAfter))== false) {
					    	logger.info("user is able to adjust the volume of the audio track enabled [ on added sound ]");
							extent.extentLoggerPass("AddSoundPostShoot", "user is able to adjust the volume of the audio track enabled [ on added sound ]");
						}else {
							logger.error("user is Unable to adjust the volume of the audio track enabled [ on added sound ]");
							extent.extentLoggerFail("AddSoundPostShoot", "user is Unable to adjust the volume of the audio track enabled [ on added sound ]");
								}	
					    Back(2);
					    click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
						Back(1);
						click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Yes button");
						
						//TC_Mobile_016
						extent.HeaderChildNode("Video Editing Check if user is able to decrease the volume of the Music enabled on added sound");
						extent.extentLogger("", "TC_Mobile_016");System.out.println("TC_Mobile_016"); 
						click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
						click(HipiAddMusicPage.objAddMusicTogglebtn, "Add Music Toggle");
						click(HipiAddMusicPage.objFirstMusicInAddMusicScreen,"Music");
						click(HipiAddMusicPage.objSelectMusicBtn, "Select Music button(Check Icon)");
						verifyElementExist(HipiAddMusicPage.objSelectedMusicInRecordingScreen, "Added music in Recording screen");
						click(HipiCreateVideoPage.objrecordbtn,"Video record button");
						waitTime(10000);
						verifyElementPresentAndClick(HipiSoundDetailPage.objVolumeIconOnVideoeditScreen, "Volume icon ");
						verifyElementExist(HipiSoundDetailPage.objAdjustVolumePopup, "Adjust volume popup");
						String total = getDriver().findElement(HipiSoundDetailPage.objMusicSeekbarValue).getText();
					    System.out.println(total);extent.extentLogger("", "Volume before Decrease : "+total);
					    int i=Integer.parseInt(total);  
					    DecreaseMusicVolume(HipiSoundDetailPage.objMusicSeekBar);
					    String totalVolumeafter = getDriver().findElement(HipiSoundDetailPage.objMusicSeekbarValue).getText();
					    System.out.println(totalVolumeafter);extent.extentLogger("", "Volume after Decrease : "+totalVolumeafter);
					    int j=Integer.parseInt(totalVolumeafter);  
					    if(j<i) {
					    	logger.info("user is able to decrease the volume of the music enabled [ on added sound ]");
							extent.extentLoggerPass("AddSoundPostShoot", "user is able to decrease the volume of the music enabled [ on added sound ]");
						}else {
							logger.error("user is Unable to decrease the volume of the music enabled [ on added sound ]");
							extent.extentLoggerFail("AddSoundPostShoot", "user is Unable to decrease the volume of the music enabled [ on added sound ]");
								}	
					    click(HipiSoundDetailPage.objFinishAdjustVolume,"Finish icon on Adjust volume popup");
						click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
						Back(1);
						click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Continue button");
						Back(1);
						click(HipiAddMusicPage.objYesButtonOnReplaceMusicPopup,"Yes button");
						
						//TC_Mobile_013
						extent.HeaderChildNode("Check if user is able to increase the volume of the Music enabled on original sound");
						extent.extentLogger("", "TC_Mobile_013");System.out.println("TC_Mobile_013"); 
						click(HipiFeedPage.objCreateVideoIcon, "Create Video Icon");
						click(HipiCreateVideoPage.objrecordbtn,"Video record button");
						waitTime(10000);
						verifyElementPresentAndClick(HipiSoundDetailPage.objVolumeIconOnVideoeditScreen, "Volume icon ");
						verifyElementExist(HipiSoundDetailPage.objAdjustVolumePopup, "Adjust volume popup");
						DecreaseMusicVolume(HipiSoundDetailPage.objMicrophoneSeekbar);
					    String currentvolume = getDriver().findElement(HipiSoundDetailPage.objMicrophoneVolumeValue).getText();
					    System.out.println(currentvolume);extent.extentLogger("", "Volume after Decrease : "+currentvolume);
					    int k=Integer.parseInt(currentvolume);
					    IncreasingMusicVolume(HipiSoundDetailPage.objMicrophoneSeekbar); 	
					    String volume = getDriver().findElement(HipiSoundDetailPage.objMicrophoneVolumeValue).getText();
					    System.out.println(volume);extent.extentLogger("", "Volume after Decrease : "+volume);
					    int l=Integer.parseInt(volume);
					    if(l>k) {
					    	logger.info("user is able to increase the volume of the Music enabled on original sound");
							extent.extentLoggerPass("AddSoundPostShoot", "user is able to increase the volume of the Music enabled on original sound");
						}else {
							logger.error("user is Unable to increase the volume of the Music enabled on original sound");
							extent.extentLoggerFail("AddSoundPostShoot", "user is Unable to increase the volume of the Music enabled on original sound");
								}	
					    
						//TC_Mobile_015
						extent.HeaderChildNode("Video Editing Check if user is able to decrease the volume of the Music enabled on original sound");
						extent.extentLogger("", "TC_Mobile_015");System.out.println("TC_Mobile_015"); 
						  String currentVolume = getDriver().findElement(HipiSoundDetailPage.objMicrophoneVolumeValue).getText();
						  System.out.println(currentVolume);
						  logger.info(currentVolume);extent.extentLogger("", "Volume before Decrease : "+currentVolume);
						  int m =Integer.parseInt(currentVolume);
					      DecreaseMusicVolume(HipiSoundDetailPage.objMicrophoneSeekbar);  
					      String Volumevalue = getDriver().findElement(HipiSoundDetailPage.objMicrophoneVolumeValue).getText();
						  System.out.println(Volumevalue);
						  logger.info(Volumevalue);extent.extentLogger("", "Volume after Decrease : "+Volumevalue);
						  int n =Integer.parseInt(Volumevalue);
						  if(n<m) {
							  logger.info("user is able to decrease the volume of the music enabled [ on original sound ]");
								extent.extentLoggerPass("AddSoundPostShoot", "user is able to decrease the volume of the music enabled [ on original sound ]");
							}else {
								logger.error("user is Unable to decrease the volume of the music enabled [ on original sound ]");
								extent.extentLoggerFail("AddSoundPostShoot", "user is Unable to decrease the volume of the music enabled [ on original sound ]");
									} 
			   	}	
	
			
			public void MusicTrim1(By byLocator1) throws Exception {

				WebElement element = getDriver().findElement(byLocator1);
				Dimension size = element.getSize();
				int startx = (int) (size.width);

			//	Dimension size1 = getDriver().manage().window().getSize();
			//	int endx = (int) (size1.width * 0.5);

				WebElement element1 = getDriver().findElement(HipiAddMusicPage.objMusicTrimLayout);
				Dimension size1 = element1.getSize();
				int endx1 = (int)(size1.width * 0.5);

				
				
				
				
				AndroidTouchAction touch = new AndroidTouchAction(getDriver());
				touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(startx,endx1))
						.release().perform();
			}
			
			
			
			public void MusicTrim(By byLocator1) throws Exception {

				WebElement element = getDriver().findElement(byLocator1);
				Dimension size = element.getSize();
				 Point point = element.getLocation();

				int getY = point.getY();				
				int width = (int) (size.getHeight());
				int width1 = width/2;

				int endY = (int)getY+width1;
				
				Dimension size1 = getDriver().manage().window().getSize();
				int endx = (int) (size1.width * 0.5);

				AndroidTouchAction touch = new AndroidTouchAction(getDriver());
				touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(PointOption.point(endx, endY))
						.release().perform();
			}
			
			

		public void DecreaseMusicVolume(By byLocator) throws IOException {
				   System.out.println("Decreasing Music volume in Adjust Volume popup");
				   extent.extentLogger("", "Decreasing Music volume in Adjust Volume popup");
				    TouchAction action = new TouchAction(getDriver());
					 waitTime(5000);

					 Dimension size = getDriver().findElement(byLocator).getSize();
					 
					 WebElement ele = getDriver().findElement(byLocator);
					 Point point = ele.getLocation();
					 
					 System.out.println(point.getX());
					 System.out.println(point.getY());
					 System.out.println(size.height);
					 System.out.println(size.width);
					 
					 int X = point.getX();
					 int Y = point.getY();    			 
					 int height = size.height;
					 int width = size.width;   
					 
					 float height1 = height / 2;
					 
					 float width1 = width / 2;
					 
					 float pointY = Y+height1;
					 float pointX = width1;
					 
					 int pY = (int)pointY;
					 System.out.println(pY);
					 int pX = (int)pointX;
					 System.out.println(pX);			 
					 action.press(PointOption.point(pX, pY)).release().perform();
			}
			
			public void IncreasingMusicVolume(By byLocator) throws IOException {
				    System.out.println("Increasing Music volume in Adjust Volume popup");
				    extent.extentLogger("", "Increasing Music volume in Adjust Volume popup");
				    TouchAction action = new TouchAction(getDriver());
					 waitTime(5000);

					 Dimension size = getDriver().findElement(byLocator).getSize();
					 
					 WebElement ele = getDriver().findElement(byLocator);
					 Point point = ele.getLocation();
					 
					 System.out.println(point.getX());
					 System.out.println(point.getY());
					 System.out.println(size.height);
					 System.out.println(size.width);
					 
					 int X = point.getX();
					 int Y = point.getY();    			 
					 int height = size.height;
					 int width = size.width;   
					 
					 float height1 = height / 2;
					 
					 float width1 = width / 2;
					 
					 float pointY = Y+height1;
					 float pointX = X+width1;
					 
					 int pY = (int)pointY;
					 System.out.println(pY);
					 int pX = (int)pointX;
					 System.out.println(pX);			 
					 action.press(PointOption.point(pX, pY)).release().perform();
			}	
			
			
			
			
			
			
			
	//--------------------------------------------------------------------------------------------------------------------
			
			
			
			
			
			// ============================== HiPi Search Results Module - Satish ============================================
			
			
			public void HiPiSearchResults(String userType) throws Exception {
				extent.HeaderChildNode("HiPi Search Results");
					
				
				extent.HeaderChildNode("Check if on tapping the Discover icon, user is directed to HiPi Search Details screen");
				extent.extentLogger("", "TC_Mobile_002");System.out.println("TC_Mobile_002");
				
				verifyElementPresentAndClick(AMDOnboardingScreen.objHipiButton, "HiPi");
				
				if (verifyIsElementDisplayed(HipiFeedPage.objfeed, "HiPi Feed")) {
					verifyElementPresentAndClick(HipiFeedPage.objDiscoverButton, "Discover icon");
					if(verifyIsElementDisplayed(HipiDiscoverPage.objDiscoverTitle, "Discover Title in Search detail screen")) {
						logger.info("User is navigated to HiPi Discover screen");
						extent.extentLoggerPass("HiPi Discover screen", "User is navigated to HiPi Discover screen");
						
						extent.HeaderChildNode("Check layout of Discover/Search Screen");
						extent.extentLogger("", "TC_Mobile_001 and TC_Mobile_004");System.out.println("TC_Mobile_001 and TC_Mobile_004");
						extent.extentLogger("", "1. Verifying different rails are displayed along with thumbnails in Discover screen");
						System.out.println("1. Verifying different rails are displayed along with thumbnails in Discover screen");
						extent.extentLogger("", "Verifying user should be able to view video rails of Recent Searched and Trending videos");
						System.out.println("Verifying User should be able to view video rails of Recent Searched and Trending videos");
						
						if(verifyIsElementDisplayed(HipiDiscoverPage.objTray("Trending Videos"), "Trending Videos rail")) {
							logger.info("Trending Videos rail is displayed in HiPi Discover screen");
							extent.extentLoggerPass("Trending Videos rail", "Trending Videos rail is displayed in HiPi Discover screen");
						} else {
							logger.error("Trending Videos rail is not displayed in HiPi Discover screen");
							extent.extentLoggerFail("Trending Videos rail", "Trending Videos rail is not displayed in HiPi Discover screen");
						}
						
						if(verifyIsElementDisplayed(HipiDiscoverPage.objTray("Top HiPi Stars"), "Top HiPi Stars rail")) {
							logger.info("Top HiPi Stars rail is displayed in HiPi Discover screen");
							extent.extentLoggerPass("Top HiPi Stars rail", "Top HiPi Stars rail is displayed in HiPi Discover screen");
						} else {
							logger.error("Top HiPi Stars rail is not displayed in HiPi Discover screen");
							extent.extentLoggerFail("Top HiPi Stars rail", "Top HiPi Stars rail is not displayed in HiPi Discover screen");
						}
						
						verifyElementPresentAndClick(HipiDiscoverPage.objTrayFirstCard("Top HiPi Stars"), "First card of Top HiPi Stars rail");
						if(verifyIsElementDisplayed(HipiOtherProfileScreen.objUserHandle, "User Handle")) {
							logger.info("User is navigated to User Profile screen");
							extent.extentLoggerPass("Navigation to Profile screen", "User is navigated to User Profile screen");
							
							verifyElementPresent(HipiOtherProfileScreen.objProfileImage, "Profile Image");
							verifyElementPresent(HipiOtherProfileScreen.objUserName, "User Name");
							verifyElementPresent(HipiOtherProfileScreen.objUserBadge, "Badge");
							verifyElementPresent(HipiOtherProfileScreen.objFollowersCount, "Followers Count");
							verifyElementPresent(HipiOtherProfileScreen.objFollowingCount, "Following Count");
							verifyElementPresent(HipiOtherProfileScreen.objFollowButton, "Follow Button");
							verifyElementPresent(HipiOtherProfileScreen.objShareButton, "Share Button");
							String ProfileScreenVideoDescription = getText(HipiOtherProfileScreen.objFirstVideoDescription);
							String ProfileScreenVideoViewCount = getText(HipiOtherProfileScreen.objFirstVideoViewCount);
							String ProfileScreenVideoLikeCount = getText(HipiOtherProfileScreen.objFirstVideoLikeCount);
							String PlayerScreenVideoViewCount = "";
							String PlayerScreenVideoLikeCount = "";
							String MeScreenVideoDescription = "";
							
							verifyElementPresentAndClick(HipiOtherProfileScreen.objFirstVideo, "First Video");
							if(verifyElementExist(HipiFeedPage.objeyeicon, "Views Count in Player Screen")) {
								logger.info("User is navigated to Player screen");
								extent.extentLoggerPass("Player Screen", "User is navigated to Player screen");
								waitTime(2000);
								PlayerScreenVideoViewCount = getText(HipiFeedPage.objeyeicon);
								PlayerScreenVideoLikeCount = getText(HipiFeedPage.objlikecount);
								//View Count Validation
								if(PlayerScreenVideoViewCount.equalsIgnoreCase(ProfileScreenVideoViewCount)) {
									logger.info("View Count in Player screen and that in Profile screen are the same");
									extent.extentLoggerPass("View Count", "View Count in Player screen and that in Profile screen are the same");
									
								}else {
									logger.error("View Count in Player screen and that in Profile screen are not same");
									extent.extentLoggerFail("View Count", "View Count in Player screen and that in Profile screen are not same");
								}
								//Like Count Validation
								if(PlayerScreenVideoLikeCount.equalsIgnoreCase(ProfileScreenVideoLikeCount)) {
									logger.info("Like Count in Player screen and that in Profile screen are the same");
									extent.extentLoggerPass("Like Count", "Like Count in Player screen and that in Profile screen are the same");
									
								}else {
									logger.error("Like Count in Player screen and that in Profile screen are not same");
									extent.extentLoggerFail("Like Count", "Like Count in Player screen and that in Profile screen are not same");
								}
								//Add to Favorite Action
								//Favourite Video Validation	
								AndroidTouchAction touch = new AndroidTouchAction(getDriver());
								touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(findElement(HipiFeedPage.objFeedPlayerScreen))))
										.release().perform();
								
								if(verifyIsElementDisplayed(HipiFeedPage.objfavourites, "Add to Favorites")) {
									logger.info("Content Menu is displayed");
									extent.extentLoggerPass("Content Menu", "Content Menu is displayed");
									verifyElementPresentAndClick(HipiFeedPage.objfavourites, "Add to Favorites");
								}else {
									logger.error("Content Menu is not displayed");
									extent.extentLoggerFail("Content Menu", "Content Menu is not displayed");
									Back(1);
								}
								waitTime(4000);
								Back(1);
								waitTime(2000);
								verifyElementPresentAndClick(HipiOtherProfileScreen.objMusicTab, "Music Tab");
								String ProfileScreenSoundTitle = getText(HipiOtherProfileScreen.objFirstMusicContent);
								String MeScreenSoundTitle = "";
								String CreateVideoScreenSoundAdded = "";
								verifyElementPresentAndClick(HipiOtherProfileScreen.objFirstContentFavoriteIcon, "Favorite icon on first music content");
								verifyElementPresentAndClick(HipiOtherProfileScreen.objFirstMusicContent, "First Music Content");
								if(verifyIsElementDisplayed(HipiSoundDetailPage.objTitle, "Music Title in Sound Details Page")) {
									logger.info("User is navigated to Sound details page");
									extent.extentLoggerPass("Sound Details Page", "User is navigated to Sound details page");
									verifyElementPresentAndClick(HipiSoundDetailPage.objUseThisSoundBtn, "Use this Sound button");
									//Permissions
									if (verifyIsElementDisplayed(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
										verifyElementPresent(HipiCreateVideoPage.objpermission, "zee5 picture and record permission");
										verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow button");
										verifyElementPresent(HipiCreateVideoPage.objpermission, "Access Media permission");
										verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow button");
										verifyElementPresent(HipiCreateVideoPage.objpermission, "Record Audio permission");
										verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow button");
									}
									
									waitTime(10000);
									if(verifyIsElementDisplayed(HipiMePage.objreadypopup, "Ready popup")) {
										Thread.sleep(3000);
										verifyElementPresentAndClick(HipiMePage.objokbutton, "Ok button");
									}
									
									waitTime(10000);
									if(verifyIsElementDisplayed(HipiCreateVideoPage.objrecordbtn, "Record Button")) {
										logger.info("User is navigated to Create Video Screen");
										extent.extentLoggerPass("Create Video Screen", "User is navigated to Create Video Screen");
										CreateVideoScreenSoundAdded = getText(HipiCreateVideoPage.objmusicadded);
										if(CreateVideoScreenSoundAdded.contains(ProfileScreenSoundTitle)) {
											logger.info("Music used for Creating Video is added in Create video Screen");
											extent.extentLoggerPass("Music used for Creating Video", "Music used for Creating Video is added in Create video Screen");
											
										}else {
											logger.error("Music used for Creating Video is not added in Create video Screen");
											extent.extentLoggerFail("Music used for Creating Video", "Music used for Creating Video is not added in Create video Screen");
										}
										Back(1);
										waitTime(2000);
									}else {
										logger.error("User is not navigated to Create Video Screen");
										extent.extentLoggerFail("Create Video Screen", "User is not navigated to Create Video Screen");
									}
									Back(1);
									waitTime(2000);
								}else {
									logger.error("User is not navigated to Sound details page");
									extent.extentLoggerFail("Sound Details Page", "User is not navigated to Sound details page");
								}
								
								Back(1);
								waitTime(2000);
								if (verifyIsElementDisplayed(HipiDiscoverPage.objDiscoverTitle, "Discover Title")) {
									logger.info("User is navigated back to Discover Screen");
									extent.extentLoggerPass("Navigation to Discover screen", "User is navigated back to Discover Screen");
									verifyElementPresentAndClick(HipiFeedPage.objMeImage, "Me Button");
									verifyElementPresent(HipiMePage.objHipiProfileId, "User Handle");
									verifyElementPresentAndClick(HipiMePage.objfavouritetab, "Favorite Tab in Me page");
									MeScreenVideoDescription = getText(HipiOtherProfileScreen.objFirstVideoDescription);
									//Video Description Validation of Favorites tab
									if(MeScreenVideoDescription.equalsIgnoreCase(ProfileScreenVideoDescription)) {
										logger.info("Video added to Favorites is displayed in Profile->Favorites Tab");
										extent.extentLoggerPass("Favorited Video in Favorites Tab", "Video added to Favorites is displayed in Profile->Favorites Tab");
										
									}else {
										logger.error("Video added to Favorites is not displayed in Profile->Favorites Tab");
										extent.extentLoggerFail("Favorited Video in Favorites Tab", "Video added to Favorites is not displayed in Profile->Favorites Tab");
									}
									
									verifyElementPresentAndClick(HipiMePage.objFavoriteIconOnFirstThumbnail, "Favorite Icon on video thumbnail");
									verifyElementPresent(HipiMePage.objUndoOption, "Undo Button");
									
									//Sound Favorites validation
									waitTime(2000);
									verifyElementPresentAndClick(HipiMePage.objFavoriteTabCategoryTab("Sounds"), "Sound Tab under Favorites Tab");
									MeScreenSoundTitle = getText(HipiMePage.objFirstMusicTitleUnderFavorites);
									if(MeScreenSoundTitle.equalsIgnoreCase(ProfileScreenSoundTitle)) {
										logger.info("Music added to Favorites is displayed in Profile->Favorites Tab->Sound Tab");
										extent.extentLoggerPass("Favorited Music in Favorites Tab", "Music added to Favorites is displayed in Profile->Favorites Tab->Sound Tab");
										
									}else {
										logger.error("Music added to Favorites is not displayed in Profile->Favorites Tab->Sound Tab");
										extent.extentLoggerFail("Favorited Music in Favorites Tab", "Music added to Favorites is not displayed in Profile->Favorites Tab->Sound Tab");
									}
									
									verifyElementPresentAndClick(HipiMePage.objFavoriteIconOnFirstMusicContent, "Favorite Icon on Music");
									verifyElementPresent(HipiMePage.objUndoOption, "Undo Button");
									
									waitTime(2000);
									Back(1);
									waitTime(2000);
									
								}else {
									logger.error("User is not navigated back to Discover Screen");
									extent.extentLoggerFail("Navigation to Discover screen", "User is not navigated back to Discover Screen");
								}
								
							}else {
								logger.error("User is not navigated to Player screen");
								extent.extentLoggerFail("Player Screen", "User is not navigated to Player screen");
							}
							
						} else {
							logger.error("User is not navigated to User Profile screen");
							extent.extentLoggerFail("Navigation to Profile screen", "User is not navigated to User Profile screen");
						}
//						if(verifyIsElementDisplayed(HipiDiscoverPage.objDiscoverLandingCarousel, "Carousel in Discover Landing Screen")) {
//							logger.info("Carousel is displayed in HiPi Discover screen");
//							extent.extentLoggerPass("Carousel in HiPi Discover screen", "Carousel is displayed in HiPi Discover screen");
//						
//							
//						} else {
//							logger.error("Carousel is not displayed in HiPi Discover screen");
//							extent.extentLoggerFail("Carousel in HiPi Discover screen", "Carousel is not displayed in HiPi Discover screen");
//						}
						
					}else {
						logger.error("User is not navigated to HiPi Discover screen");
						extent.extentLoggerFail("HiPi Discover screen", "User is not navigated to HiPi Discover screen");
					}
					
					verifyElementPresentAndClick(HipiFeedPage.objDiscoverButton, "Discover icon");
					if(verifyIsElementDisplayed(HipiDiscoverPage.objDiscoverTitle, "Discover Title in Search detail screen")) {
						logger.info("User is navigated to HiPi Discover screen");
						extent.extentLoggerPass("HiPi Discover screen", "User is navigated to HiPi Discover screen");
						
						Swipe("Up", 1);
						if(verifyIsElementDisplayed(HipiDiscoverPage.objTray("#"), "# rail")) {
							logger.info("# rail is displayed in HiPi Discover screen");
							extent.extentLoggerPass("# rail", "# rail is displayed in HiPi Discover screen");
						} else {
							logger.error("# rail is not displayed in HiPi Discover screen");
							extent.extentLoggerFail("# rail", "# rail is not displayed in HiPi Discover screen");
						}
						
						PartialSwipe("Up", 1);
						if(verifyIsElementDisplayed(HipiDiscoverPage.objTray("Recommended Videos"), "Recommended Videos rail")) {
							logger.info("Recommended Videos rail is displayed in HiPi Discover screen");
							extent.extentLoggerPass("Recommended Videos rail", "Recommended Videos rail is displayed in HiPi Discover screen");
							verifyElementPresentAndClick(HipiDiscoverPage.objTrayFirstCard("Recommended Videos"), "First card in Recommended Videos rail");
							if(waitForElementDisplayed(HipiOtherProfileScreen.objFirstVideoViewCount, 10)) {
								logger.info("User is navigated to Player screen");
								extent.extentLoggerPass("Player Screen", "User is navigated to Player screen");
								waitTime(2000);
								
								//Comment action
//								verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "Comment icon");
//								if(verifyIsElementDisplayed(HipiFeedPage.objcommentbox, "Comment Text Field")) {
//									logger.info("Comments Popup is displayed");
//									extent.extentLoggerPass("Comments Popup", "Comments Popup is displayed");
//									verifyElementPresentAndClick(HipiFeedPage.objcommentbox, "Comment Text Field");
//									type(HipiFeedPage.objcommentbox, "Comm"+GeneratingRandomString(7), "Comment Text Field");
//									findElement(HipiFeedPage.objcommentbox).sendKeys(Keys.ENTER);
//									hideKeyboard();
//									
//								}else {
//									logger.error("Comments Popup is not displayed");
//									extent.extentLoggerFail("Comments Popup", "Comments Popup is not displayed");
//								}
								//Like Action
								
								//Share Action
								
								//Report Action
								
								//Not Interested Action
								
								//Download action
								
								//Follow User by clicking on Plus icon
								
								//Tap on User Image action and back to player screen
								
								//tap on Sound and back to player screen
								
								
								
								
							}else {
								logger.error("User is not navigated to Player screen");
								extent.extentLoggerFail("Player Screen", "User is not navigated to Player screen");
							}
							
							Back(1);
							waitTime(2000);
							
							if(verifyIsElementDisplayed(HipiDiscoverPage.objDiscoverTitle, "Discover Title in Search detail screen")) {
								logger.info("User is navigated to HiPi Discover screen");
								extent.extentLoggerPass("HiPi Discover screen", "User is navigated to HiPi Discover screen");
							}else {
								logger.error("User is not navigated to HiPi Discover screen");
								extent.extentLoggerFail("HiPi Discover screen", "User is not navigated to HiPi Discover screen");
							}
							
							extent.HeaderChildNode("Verifying if on tapping search text field to enter record,other options are displayed");
							extent.extentLogger("", "TC_Mobile_005");System.out.println("TC_Mobile_005");
							verifyElementPresentAndClick(HipiDiscoverPage.objSearchButton, "Search Icon");
							if(verifyElementPresent(HipiDiscoverPage.objDiscoverSearchInbox, "Search Textfield")) {
								click(HipiDiscoverPage.objDiscoverSearchInbox, "Search Textfield");
								String MetadataSearchKeyword = getParameterFromXML("MetadataSearchKeyword");
								type(HipiDiscoverPage.objDiscoverSearchInbox, MetadataSearchKeyword, "Search Textfield");
								hideKeyboard();
								waitTime(3000);
								
								verifyElementPresent(HipiDiscoverPage.objBackButton, "Back Button");
								verifyElementPresent(HipiDiscoverPage.objCrossIcon, "'X' icon");
								//TC_Mobile_007
								extent.HeaderChildNode("Discover Check if user is able to view matched record based on the text entered ie metadata");
								extent.extentLogger("", "TC_Mobile_007");System.out.println("TC_Mobile_007");
								
								List<WebElement> MetadataList = getDriver().findElements(HipiDiscoverPage.objMetadataSearchResults(MetadataSearchKeyword));
								System.out.println("List Size: "+MetadataList.size());
								
								ArrayList<String> MetadataArray = new ArrayList<String>();
								for(int i = 1; i <= MetadataList.size(); i++){  
								   String value = getAttributValue("text",HipiDiscoverPage.objMetadataSearchResults(MetadataSearchKeyword, i));
								   MetadataArray.add(value);
							       System.out.println("Value: "+value);
							       if(value.contains(MetadataSearchKeyword)) {
							    	   logger.info("Searched results match the text entered in Search field");
							    	   extent.extentLoggerPass("Searched Results","Searched results matches the text entered in Search field");
							    	   break;
							       }
							       
								}
								
								//------------------------
								click(HipiDiscoverPage.objCrossIcon, "'X' icon");
								String HashtagSearchKeyword = getParameterFromXML("HashtagSearchKeyword");
								type(HipiDiscoverPage.objDiscoverSearchInbox, HashtagSearchKeyword, "Search Textfield");
								hideKeyboard();
								waitTime(3000);
								Swipe("Up", 1);
								waitTime(3000);
								//TC_Mobile_008 and TC_Mobile_014
								extent.HeaderChildNode("Discover Check if user is able to view matched record based on the text entered ie Hash Tag");
								extent.extentLogger("", "TC_Mobile_008");System.out.println("TC_Mobile_008");
								
								List<WebElement> HashtagList = getDriver().findElements(HipiDiscoverPage.objHashtagSearchResults(HashtagSearchKeyword));
								System.out.println("List Size: "+HashtagList.size());
								
								ArrayList<String> HashtagArray = new ArrayList<String>();
								for(int i = 1; i <= HashtagList.size(); i++){  
								   String value = getAttributValue("text",HipiDiscoverPage.objHashtagSearchResults(HashtagSearchKeyword, i));
								   HashtagArray.add(value);
							       System.out.println("Value: "+value);
							       if(value.contains(HashtagSearchKeyword)) {
							    	   logger.info("Searched results match the text entered in Search field");
							    	   extent.extentLoggerPass("Searched Results","Searched results matches the text entered in Search field");
							    	   extent.HeaderChildNode("Discover Check if user is able to view detailed content when clicked on specific profile or hashtag");
							    	   extent.extentLogger("", "TC_Mobile_014");System.out.println("TC_Mobile_014");
							    	   verifyElementPresentAndClick(HipiDiscoverPage.objHashtagSearchResults(HashtagSearchKeyword, i), "Searched Hashtag "+HashtagSearchKeyword);
							    	   waitTime(2000);
							    	   if(verifyElementPresent(HipiHashtagDetailPage.objHashtagTitle, "Hashtag Title")) {
							    		   logger.info("User is navigated to Profile screen");
							    		   extent.extentLoggerPass("Profile screen", "User is navigated to Profile screen");
							    	   }else {
							    		   logger.error("User is not navigated to Profile screen");
							    		   extent.extentLoggerFail("Profile screen", "User is not navigated to Profile screen");
							    	   }
							    	   Back(1);
							    	   waitTime(2000);
							    	   break;
							       }
								} 
								System.out.println("Array: "+HashtagArray);
								Swipe("Down", 1);
								waitTime(3000);
								
								//------------------------
								click(HipiDiscoverPage.objCrossIcon, "'X' icon");
								String ProfileSearchKeyword = getParameterFromXML("ProfileSearchKeyword");
								type(HipiDiscoverPage.objDiscoverSearchInbox,ProfileSearchKeyword, "Search Textfield");
								hideKeyboard();
								waitTime(3000);
								//TC_Mobile_009 and TC_Mobile_014
								extent.HeaderChildNode("Discover Check if user is able to view matched record based on the text entered ie Profile");
								extent.extentLogger("", "TC_Mobile_009");System.out.println("TC_Mobile_009");
								
								List<WebElement> ProfileList = getDriver().findElements(HipiDiscoverPage.objProfileSearchResults(ProfileSearchKeyword));
								System.out.println("List Size: "+ProfileList.size());
								
								ArrayList<String> ProfileArray = new ArrayList<String>();
								for(int i = 1; i <= ProfileList.size(); i++){  
								   String value = getAttributValue("text",HipiDiscoverPage.objProfileSearchResults(ProfileSearchKeyword, i));
								   ProfileArray.add(value);
							       System.out.println("Value: "+value);
							       if(value.contains(ProfileSearchKeyword)) {
							    	   logger.info("Searched results match the text entered in Search field");
							    	   extent.extentLoggerPass("Searched Results","Searched results matches the text entered in Search field");
							    	   extent.HeaderChildNode("Discover Check if user is able to view detailed content when clicked on specific profile or hashtag");
							    	   extent.extentLogger("", "TC_Mobile_014");System.out.println("TC_Mobile_014");
							    	   verifyElementPresentAndClick(HipiDiscoverPage.objProfileSearchResults(ProfileSearchKeyword, i), "Searched Profile "+ProfileSearchKeyword);
							    	   waitTime(2000);
							    	   if(verifyElementPresent(HipiOtherProfileScreen.objUserName, "User Name")) {
							    		   logger.info("User is navigated to Profile screen");
							    		   extent.extentLoggerPass("Profile screen", "User is navigated to Profile screen");
							    	   }else {
							    		   logger.error("User is not navigated to Profile screen");
							    		   extent.extentLoggerFail("Profile screen", "User is not navigated to Profile screen");
							    	   }
							    	   Back(1);
							    	   waitTime(2000);
							    	   break;
							       }
								} 
								System.out.println("Array: "+ProfileArray);
								
								//------------------------
								click(HipiDiscoverPage.objCrossIcon, "'X' icon");
								String SoundSearchKeyword = getParameterFromXML("SoundSearchKeyword");
								type(HipiDiscoverPage.objDiscoverSearchInbox,SoundSearchKeyword, "Search Textfield");
								hideKeyboard();
								waitTime(3000);
								//TC_Mobile_010 and TC_Mobile_011
								extent.HeaderChildNode("Discover Check if user is able to view matched record based on the text entered ie Sound Name");
								extent.extentLogger("", "And Discover Check if user is able to view matched record based on the text entered ie Descriptive Keywords");
								extent.extentLogger("", "TC_Mobile_010 and TC_Mobile_011");System.out.println("TC_Mobile_010 and TC_Mobile_011");
								
								List<WebElement> SoundList = getDriver().findElements(HipiDiscoverPage.objMetadataSearchResults(SoundSearchKeyword));
								System.out.println("List Size: "+SoundList.size());
								
								ArrayList<String> SoundArray = new ArrayList<String>();
								for(int i = 1; i <= SoundList.size(); i++){  
								   String value = getAttributValue("text",HipiDiscoverPage.objMetadataSearchResults(SoundSearchKeyword, i));
								   SoundArray.add(value);
							       System.out.println("Value: "+value);
							       if(value.toLowerCase().contains(SoundSearchKeyword.toLowerCase())) {
							    	   logger.info("Searched results match the text entered in Search field");
							    	   extent.extentLoggerPass("Searched Results","Searched results matches the text entered in Search field");
							    	   break;
							       }
								} 
								System.out.println("Array: "+SoundArray);
								
								//---------------------------------------
								//TC_Mobile_017
								extent.HeaderChildNode("Discover Check for user is able to view video or image content on a carousel and on tapping user is directed to redirected to landing page within the Application itself");
						    	extent.extentLogger("", "TC_Mobile_017");System.out.println("TC_Mobile_017");
						    	click(HipiDiscoverPage.objCrossIcon, "'X' icon");
								String SearchKeyword = findElement(HipiDiscoverPage.objThirdTrendingSearchSuggestion).getText();
								System.out.println("First Trending Search Suggestion: "+SearchKeyword);
								click(HipiDiscoverPage.objThirdTrendingSearchSuggestion, "First Trending Search Suggestion");
//								type(HipiDiscoverPage.objDiscoverSearchInbox,SearchKeyword, "Search Textfield");
//								findElement(HipiDiscoverPage.objDiscoverSearchInbox).sendKeys(Keys.ENTER);
//								waitTime(2000);
//								verifyElementPresentAndClick(HipiDiscoverPage.objSearchButtonOnKeyboard, "Search Button on Keyboard");
//								hideKeyboard();
								waitTime(3000);
								//All Tab
								verifyElementPresentAndClick(HipiDiscoverPage.objSearchTab("All"), "All Tab");
								verifyElementPresentAndClick(HipiDiscoverPage.objFirstSearchedResultAllTab, "First Searched Result");
								if(verifyElementPresent(HipiOtherProfileScreen.objUserName, "User Name")) {
									logger.info("User is navigated to Profile screen");
									extent.extentLoggerPass("Profile screen", "User is navigated to Profile screen");
								}else {
									logger.error("User is not navigated to Profile screen");
									extent.extentLoggerFail("Profile screen", "User is not navigated to Profile screen");
								}
								Back(1);
								//User Tab
								verifyElementPresentAndClick(HipiDiscoverPage.objSearchTab("User"), "User Tab");
								waitTime(2000);
								
								if(verifyIsElementDisplayed(HipiDiscoverPage.objFirstSearchedResultUserTab, "First Searched Result")){
									
									verifyElementPresentAndClick(HipiDiscoverPage.objFirstSearchedResultUserTab, "First Searched Result");
									if(verifyElementPresent(HipiOtherProfileScreen.objUserName, "User Name")) {
										logger.info("User is navigated to Profile screen");
										extent.extentLoggerPass("Profile screen", "User is navigated to Profile screen");
									}else {
										logger.error("User is not navigated to Profile screen");
										extent.extentLoggerFail("Profile screen", "User is not navigated to Profile screen");
									}
									Back(1);										
								}else{
									extent.extentLoggerWarning("", "Oops, no result found");
								}
								
								//HiPiTs Tab
								verifyElementPresentAndClick(HipiDiscoverPage.objSearchTab("HiPiTs"), "HiPiTs Tab");
								waitTime(2000);
								if(verifyIsElementDisplayed(HipiDiscoverPage.objFirstSearchedResultHiPiTsTab(SearchKeyword), "First Searched Result")){
									
									verifyElementPresentAndClick(HipiDiscoverPage.objFirstSearchedResultHiPiTsTab(SearchKeyword), "First Searched Result");
									if(verifyElementPresent(HipiFeedPage.objeyeicon, "View Count in Player Screen")) {
										logger.info("User is navigated to Player screen");
										extent.extentLoggerPass("Player Screen", "User is navigated to Player screen");
									}else {
										logger.error("User is not navigated to Profile screen");
										extent.extentLoggerFail("Profile screen", "User is not navigated to Profile screen");
									}
									Back(1);											
								}else{
									extent.extentLoggerWarning("", "Oops, no result found");
								}
								
								//Sound Tab
								verifyElementPresentAndClick(HipiDiscoverPage.objSearchTab("Sound"), "Sound Tab");
								waitTime(2000);
								if(verifyIsElementDisplayed(HipiDiscoverPage.objFirstSearchedResultSoundTab, "First Searched Result")){
									verifyElementPresentAndClick(HipiDiscoverPage.objFirstSearchedResultSoundTab, "First Searched Result");
									if(verifyElementPresent(HipiSoundDetailPage.objTitle, "Sound title in Sound Detail Screen")) {
										logger.info("User is navigated to Sound Detail screen");
										extent.extentLoggerPass("Sound Detail Screen", "User is navigated to Sound Detail screen");
									}else {
										logger.error("User is not navigated to Profile screen");
										extent.extentLoggerFail("Sound Detail screen", "User is not navigated to Sound Detail screen");
									}
									Back(1);												
								}else{
									extent.extentLoggerWarning("", "Oops, no result found");
								}
								
								
								//Hashtag Tab
								verifyElementPresentAndClick(HipiDiscoverPage.objSearchTab("Hashtag"), "Hashtag Tab");
								waitTime(2000);
								if(verifyIsElementDisplayed(HipiDiscoverPage.objFirstSearchedResultHashtagTab, "First Searched Result")){
									
									verifyElementPresentAndClick(HipiDiscoverPage.objFirstSearchedResultHashtagTab, "First Searched Result");
									if(verifyElementPresent(HipiHashtagDetailPage.objHashtagTitle, "Hashtag title in Hashtag Detail Screen")) {
										logger.info("User is navigated to Hashtag Detail screen");
										extent.extentLoggerPass("Hashtag Detail Screen", "User is navigated to Hashtag Detail screen");
									}else {
										logger.error("User is not navigated to Profile screen");
										extent.extentLoggerFail("Hashtag Detail screen", "User is not navigated to Hashtag Detail screen");
									}
									Back(1);												
								}else{
									extent.extentLoggerWarning("", "Oops, no result found");
								}
								
							}
						} else {
							logger.error("Recommended Videos rail is not displayed in HiPi Discover screen");
							extent.extentLoggerFail("Recommended Videos rail", "Recommended Videos rail is not displayed in HiPi Discover screen");
						}
					}else {
						logger.error("User is not navigated to HiPi Discover screen");
						extent.extentLoggerFail("HiPi Discover screen", "User is not navigated to HiPi Discover screen");
					}
				} else {
					logger.error("User is not able to view HiPi Landing screen with logged in user");
					extent.extentLoggerFail("HiPi Landing screen", "User is not able to view HiPi Landing screen with logged in user");
				}
			}
			
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
}



	
	