package com.business.zee;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.appsflyerValidation.AppsFlyer;
import com.driverInstance.DriverInstance;
import com.emailReport.GmailInbox;
import com.extent.ExtentReporter;
import com.metadata.ResponseInstance;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;
import com.zee5.AndroidHipiPages.HipiCreateVideoPage;
import com.zee5.AndroidHipiPages.HipiFeedPage;
import com.zee5.AndroidHipiPages.HipiMePage;
import com.zee5.Applicaster.HIPI.AMDHipi;
import com.zee5.Applicaster.HIPI.AMDHomePage;
import com.zee5.Applicaster.HIPI.AMDLoginScreen;
import com.zee5.Applicaster.HIPI.AMDOnboardingScreen;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Zee5ApplicasterHipiAppsFlyerBusinessLogic extends Utilities{
	
	
	public Zee5ApplicasterHipiAppsFlyerBusinessLogic(String Application) {
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

	private PropertyFileReader handler;
	
	protected void setHandler(PropertyFileReader handler) {
		this.handler = handler;
	}
	
	protected PropertyFileReader getHandler() {
		return handler;
	}
	
	private String appPackage;
	
	protected void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}

	protected String getAppPackage() {
		return this.appPackage;
	}
	
	String idNumber;
	
	static AppsFlyer appsFlyerObj = new AppsFlyer();
	
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

	}

	
	
	
	
	/**
	 * To Remove the permission of an application
	 * 
	 * @param packagename
	 */
	public void clearAppData(String application) {
		waitTime(15000);
		logger.info("****Clearing the App Data****");
		extent.HeaderChildNode("ClearAppData");
		
		setHandler(new PropertyFileReader("properties/AppPackageActivity.properties"));
		setAppPackage(getHandler().getproperty(application + "Package"));
		
		String packagename = getAppPackage();
		
		String cmd2 = "adb shell pm clear " + packagename;
		try {
			Runtime.getRuntime().exec(cmd2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void triggerAppsflyerLink(String application) throws IOException {
		waitTime(15000);
		logger.info("****triggering AppsflyerLink****");
		extent.HeaderChildNode("triggering AppsflyerLink");
		setHandler(new PropertyFileReader("properties/AppPackageActivity.properties"));
		setAppPackage(getHandler().getproperty(application + "Package"));
		
		idNumber = RandomIntegerGenerator(10);
		System.out.println("pid : Basapplicastertest"+idNumber);
		String packagename = getAppPackage();
		
		String cmd = "adb shell am start -W -a android.intent.action.VIEW -d https://app.appsflyer.com/"+packagename+"?pid=Basapplicastertest"+idNumber+"&c=Bastesting"+idNumber+"&advertising_id="+ResponseInstance.AdID;
		extent.extentLogger("","AppsFlyerLink to capture events : "+cmd);
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void launchapp() throws Exception{
		extent.HeaderChildNode("launch Zee5 through playstore");
		waitTime(15000);
		
		if(verifyIsElementDisplayed(AMDHomePage.objPlaystoreHiPiText, "HiPi app screen in playstore")){
			extent.extentLoggerPass("", "HiPi app screen in playstore is displayed");
			
			if(verifyIsElementDisplayed(AMDHomePage.objOpenButton, "Open button")){
				verifyElementPresentAndClick(AMDHomePage.objOpenButton, "Open button");
			}else{
				System.out.println("Open Button is not displayed");
			}
			
		}else{
			extent.extentLoggerFail("", "HiPi app screen in playstore is not displayed");			
		}
		waitTime(15000);
	}
	
	
	
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
			break;

		case "NonSubscribedUser":
			// navigateToIntroScreen_DisplaylangScreen();
			extent.HeaderChildNode("NonSubscribed User");
			
			
			//click on me icon
			verifyElementPresentAndClick(AMDHipi.objmeicon, "Me Icon");
			waitTime(8000);
			//click on login button
			verifyElementPresentAndClick(AMDHipi.objLoginbtn, "Login Button");
			
			String Username = getParameterFromXML("NonsubscribedUserName");
			String Password = getParameterFromXML("NonsubscribedPassword");
			
			waitTime(8000);
			hideKeyboard();
			waitTime(8000);
			click(AMDLoginScreen.objEmailIdField, "Email field");
			hideKeyboard();

			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
//			hideKeyboard();
			waitTime(8000);
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			waitTime(8000);
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			hideKeyboard();

			type(AMDLoginScreen.objPasswordField, Password, "Password field");
//			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(9000);
			waitTime(8000);
			//click on feed button
			verifyElementPresentAndClick(HipiFeedPage.objFeedButton, "Feed Button");
			waitTime(8000);
			
			

			break;

		case "SubscribedUser":
			// navigateToIntroScreen_DisplaylangScreen();
			extent.HeaderChildNode("Login as Subscribed User");
			verifyElementPresentAndClick(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");
			String SubscribedUsername = getParameterFromXML("SubscribedUserName");
			String SubscribedPassword = getParameterFromXML("SubscribedPassword");

			Thread.sleep(5000);

			hideKeyboard();
			Thread.sleep(5000);
			click(AMDLoginScreen.objEmailIdField, "Email field");
			// getDriver().getKeyboard().sendKeys(Username);
			hideKeyboard();
			type(AMDLoginScreen.objEmailIdField, SubscribedUsername, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(9000);

			if (verifyElementExist(AMDOnboardingScreen.objHipiButton, "HiPi")) {
				click(AMDOnboardingScreen.objHipiButton, "HiPi");
				Thread.sleep(6000);

			} else {

			}

			break;
		}
	}
	
	
	
	
	public void HiPiRegisterAndUploadValidation(String userType) throws Exception{
		extent.HeaderChildNode("HiPi Events Validation");
		
		
		if(userType.equalsIgnoreCase("Guest")){
			
			for(int i=0 ; i<=50 ; i++){
				verifyElementPresentAndClick(HipiFeedPage.objFeedButton, "Feed Button");
				waitTime(4000);
			}
			waitTime(10000);
			waitTime(10000);
			waitTime(10000);
		}else{
			
		String pDOB = "01/01/1990";
		ResponseInstance.password = "123456";
		String firstName = generateRandomString(6);
		String lastName = generateRandomString(6);

		verifyElementPresentAndClick(AMDHipi.objmeicon, "Me Icon");
		waitTime(8000);
		//click on login button
		verifyElementPresentAndClick(AMDHipi.objRegisterbtn, "Register Button");
		
		ResponseInstance.username = "hipi"+generateRandomString(8) + "@gmail.com";
		extent.extentLogger("", "New username : "+ResponseInstance.username);
		System.out.println("New username : "+ResponseInstance.username);
		type(AMDHipi.objEmailIDTextField, ResponseInstance.username, "Email field");
		click(AMDHipi.objProceedBtn, "Proceed button");
		
		verifyElementPresentAndClick(AMDHipi.objFirstNameTxtField, "First name field");		
		type(AMDHipi.objFirstNameTxtField, firstName, "First name");
//		hideKeyboard();
		
		verifyElementPresentAndClick(AMDHipi.objLastNameTxtField, "Last Name field");
		type(AMDHipi.objLastNameTxtField, lastName, "Last Name");
//		hideKeyboard();
		
		click(AMDHipi.objDOBTxtField, "DOB field");
		type(AMDHipi.objDOBTxtField, pDOB, "DOB");
//		hideKeyboard();		
		
		verifyElementPresentAndClick(AMDHipi.objGederTxtField, "Gender field");
		verifyElementPresentAndClick(AMDHipi.objMale, "Gender male");
		
		verifyElementPresentAndClick(AMDHipi.objPasswordTxtField, "Passowrd field");
		type(AMDHipi.objPasswordTxtField, ResponseInstance.password, "Password");
		hideKeyboard();
		waitTime(5000);
		verifyElementPresentAndClick(AMDHipi.objRegisterBtn, "Register button");
		waitTime(10000);

		verifyElementPresentAndClick(AMDHipi.objTermsConditionPopup, "Agree Terms and Condition");
		waitTime(5000);
		verifyElementPresentAndClick(AMDHipi.objTermsConditionPopupSaveBtn, "Save button");
		
		waitTime(10000);
		verifyElementPresentAndClick(HipiFeedPage.objCreateVideoIcon, "CreateVideoIcon");
		waitTime(2000);

		if (verifyElementExist(HipiCreateVideoPage.objaccesspictures, "zee5 picture permission")) {
			verifyElementPresent(HipiCreateVideoPage.objpermission, "zee5 picture and record permission");
			verifyElementPresentAndClick(HipiCreateVideoPage.objpicallowbtn, "allow button");
			verifyElementPresent(HipiCreateVideoPage.objpermission, "Access Media permission");
			verifyElementPresentAndClick(HipiCreateVideoPage.objpermissionallow, "allow button");
			verifyElementPresent(HipiCreateVideoPage.objpermission, "Record Audio permission");
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordallow, "allow button");
			
			waitForElementAndClickIfPresent(HipiMePage.objreadypopup, 120, "Ready Popup");
			Thread.sleep(3000);
			verifyElementPresentAndClick(HipiMePage.objreadypopup, "ready popup");
			verifyElementPresentAndClick(HipiMePage.objokbutton, "ok button");
			waitTime(20000);
		}
		
		waitTime(15000);
	
		if (verifyElementExist(HipiCreateVideoPage.objrecordbtn, "Record Button")) {
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record Button");
			waitTime(1000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordbtn, "Record Button");
			waitTime(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordDeletebtn, "Delete Button");
			waitTime(5000);
			verifyElementPresentAndClick(HipiCreateVideoPage.objrecordDeleteYesbtn, "Delete Button");
			waitTime(5000);
			
			verifyElementPresentAndClick(HipiCreateVideoPage.objuploadvideo, "upload video");
			
			verifyElementPresentAndClick(HipiCreateVideoPage.objselectFirstimage, "Video present");

			verifyElementPresentAndClick(HipiCreateVideoPage.objEditHipiit, "Edit HipiIT");
			Thread.sleep(5000);

			verifyElementPresentAndClick(HipiCreateVideoPage.objtrimfinish, "finish");

			verifyElementPresentAndClick(HipiCreateVideoPage.objpost, "post");
			waitTime(15000);
			waitForElementDisplayed(HipiCreateVideoPage.objPostDescription, 20);
				
				type(HipiCreateVideoPage.objPostDescription, "Description", "Description");
				waitTime(3000);
				hideKeyboard();
				waitTime(3000);
				verifyElementPresentAndClick(HipiCreateVideoPage.objgenrevideo, "Video Genre Comedy");
				verifyElementPresentAndClick(HipiCreateVideoPage.objlanguage, "Language English");
				verifyElementPresentAndClick(HipiCreateVideoPage.objcheckbox, "Terms and Conditions Checkbox");
				verifyElementPresentAndClick(HipiCreateVideoPage.objposthipi, "Post HiPi Button");
				if(verifyElementExist(HipiCreateVideoPage.objVideoUploadPopupTitle, "Video Upload Popup Title")) {
					click(HipiCreateVideoPage.objGoToFeed, "Go To Feed Button");

					waitTime(8000);
					verifyElementPresentAndClick(HipiFeedPage.objMeImage, "Me icon");
					for (int i = 0; i <= 50; i++) {
						scrolltomiddle(HipiCreateVideoPage.objselectfirstimage);
						if (verifyIsElementDisplayed(AMDHipi.objPublishingInProcess)) {
							Thread.sleep(2000);
							Back(1);
							Thread.sleep(2000);
							verifyElementPresentAndClick(AMDHipi.objmeicon, "Me icon");
						} else {
							waitTime(3000);
							if(verifyIsElementDisplayed(HipiCreateVideoPage.objSelectVideo("Description"), "Uploaded video")){
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
				extent.extentLoggerFail("", "Record Button is not displayed");
			}
				
		}
		
	}
	
	
	
	public void HiPiPlaybackValidation(String userType) throws Exception{
		extent.HeaderChildNode("Validating PlayBack Share Like comment Events");
		
		if(userType.equalsIgnoreCase("Guest")){
			extent.extentLogger("", "Validating PlayBack Share Like comment Events for Guest user is not possible");
		}else{
		
		BackToFeedScreen();
		//Play events
		Swipe("UP", 18);
		
		
		for(int i=1; i<=10; i++){
			
			if(verifyIsElementDisplayed(HipiFeedPage.objchooseLanguageORGeners, "chooseLanguageORGeners")) {
				Swipe("UP", 2);
			}else {
				
			}
			waitTime(20000);
			break;
		}
			
			//follow
			if(verifyElementExist(HipiFeedPage.objProfileFollowicon,"follow option present")) {
				
				click(HipiFeedPage.objProfileFollowicon,"follow option present");
			} else {
				System.out.println("follow icon is not displayed");
			}
			waitTime(15000);
			
			//like event
			verifyElementPresentAndClick(HipiFeedPage.objHeartIconGrey, "Heart icon");//like video
			waitTime(15000);
			
			//comment event
			verifyElementPresentAndClick(HipiFeedPage.objcommenticon, "Comment icon");
			addComment("abc");
			touchOnCommentArrow();
			BackToFeedScreen();
			
			//share event
			for(int i=1; i<=25; i++){
				waitTime(5000);
				if(verifyIsElementDisplayed(HipiMePage.objEnabledShareIcon, "Share button")){
					extent.extentLoggerPass("", "Share button is displayed");
					
					click(HipiMePage.objEnabledShareIcon, "Share button");
					
					if(verifyIsElementDisplayed(HipiMePage.objShareHipiVideoPopup, "HipiVideo")){
						verifyElementPresentAndClick(HipiFeedPage.objFacebook, "Facebook option");
						waitTime(15000);
						verifyElementPresentAndClick(HipiFeedPage.objFacebookPost, "Post/Share button");
						waitTime(10000);
					}else{
						extent.extentLogger("", "SharePopup not displayed");
						Back(1);
					}
					
				}else{
					extent.extentLoggerFail("", "Share button is not displayed");
					Swipe("UP", 1);
				}
				
				BackToFeedScreen();
			}

			BackToFeedScreen();
			
			for(int i=0 ; i<=30 ; i++){
				verifyElementPresentAndClick(HipiFeedPage.objFeedButton, "Feed Button");
				waitTime(4000);
			}
			
			BackToFeedScreen();

			
		}
		

		
	}
	
	
	
	public void addComment(String st1) throws Exception{


	waitTime(8000);

	String commentInputValue = fetchcommentInputCountof200();

	click(HipiFeedPage.objEmptyCommentBox, "Comment Box");
	
	int initialValue = Integer.parseInt(commentInputValue);
	System.out.println(initialValue);
	type(HipiFeedPage.objEmptyCommentBox, st1, "Comment box");

	hideKeyboard();
	String commentInputValue1 = fetchcommentInputCountof200();
	int initialValue1 = Integer.parseInt(commentInputValue1);
	System.out.println(initialValue1);
//	hideKeyboard();
	if(initialValue<initialValue1){
		 extent.extentLoggerPass("", "Count increased");
	}else{
		
		extent.extentLoggerFail("", "Count not increased");        				 
	}

	}

	public String fetchcommentInputCountof200() throws Exception {

		String description = getText(HipiFeedPage.objcommentdescription);
		String value = description.split("/")[0];

		return value;
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
	
	
	public void touchOnCommentArrow(){
		 TouchAction action = new TouchAction(getDriver());
		 waitTime(5000);

		 Dimension size = getDriver().findElement(HipiFeedPage.objEmptyCommentBox).getSize();
		 
		 WebElement ele = getDriver().findElement(HipiFeedPage.objEmptyCommentBox);
		 Point point = ele.getLocation();
		 
//		 System.out.println(point.getX());
//		 System.out.println(point.getY());
//		 System.out.println(size.height);
//		 System.out.println(size.width);
		 
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
	



	public void downloadAppsFlyerReport() throws InterruptedException{
		
		appsFlyerObj.deleteOldAppsFlyerFiles();
		appsFlyerObj.deleteOldAppsFlyerEventExcelFiles();
		waitTime(15000);
		
      // Setting chrome driver path
//    System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
 	WebDriverManager.chromedriver().version("90.0.4430.24").setup();
    // Setting new download directory path
    Map<String, Object> prefs = new HashMap<String, Object>();
    // Use File.separator as it will work on any OS
    prefs.put("download.default_directory",
            System.getProperty("user.dir") + "//AppsflyerReport");
    // Adding cpabilities to ChromeOptions
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("prefs", prefs);
    // Printing set download directory
    System.out.println(options.getExperimentalOption("prefs"));
    // Launching browser with desired capabilities
    ChromeDriver driver= new ChromeDriver(options);
    // URL loading
    Date date = new Date();
	String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
	System.out.println(modifiedDate);
    driver.get("https://hq.appsflyer.com/export/com.zee5.hipi/in_app_events_report/v5?api_token=8d127012-8a4b-4776-b42b-df2a787af8a0from="+modifiedDate+"&to="+modifiedDate+"&timezone=Asia%2fKolkata&media_source=basapplicastertest"+idNumber+"&category=basapplicastertest"+idNumber+"&maximum_rows=100");
 //   driver.get("https://hq.appsflyer.com/export/com.zee5.hipi/in_app_events_report/v5?api_token=8d127012-8a4b-4776-b42b-df2a787af8a0&from=2021-06-30&to=2021-06-30&timezone=Asia%2fKolkata&media_source=Basapplicastertest3766951513&category=Basapplicastertest3766951513&maximum_rows=100");
    // Click on download selenium server jar file
    Thread.sleep(60000);
    driver.quit();	
	}
	
	
	public static void main(String[] args){
		
		appsFlyerObj.convertCsvToXlsxReport(appsFlyerObj.fetchTheDownloadedAppsFlyerReportName());
		
	}
	
	
	public void extractFilesForValidation(String userType) throws IOException, ParseException{
		waitTime(15000);
		
		appsFlyerObj.convertCsvToXlsxReport(appsFlyerObj.fetchTheDownloadedAppsFlyerReportName());
		System.out.println(idNumber);

		if(userType.equalsIgnoreCase("Guest")){
			appsFlyerObj.extractFilesForValidationFunction(userType,idNumber,"ugc_play");
			appsFlyerObj.extractFilesForValidationFunction(userType,idNumber,"ugc_played_10");
			appsFlyerObj.extractFilesForValidationFunction(userType,idNumber,"ugc_played_20");
			appsFlyerObj.extractFilesForValidationFunction(userType,idNumber,"ugc_played_25");
			appsFlyerObj.extractFilesForValidationFunction(userType,idNumber,"ugc_played_50");
			appsFlyerObj.extractFilesForValidationFunction(userType,idNumber,"ugc_played_complete");
			
		}else{
			
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","af_complete_registration");
			
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","clip_recording_ended");
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","clip_recording_started");
	
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","user_followed");
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","comment_added");
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","ugc_liked");
			
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","ugc_shared");
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","ugc_shared_5");
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","ugc_shared_10");
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","ugc_shared_25");
			
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","ugc_play");
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","ugc_played_5");
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","ugc_played_10");
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","ugc_played_25");
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","ugc_played_50");
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","ugc_played_complete");
			
			appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","clip_upload_result");

		//	appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","clip_upload_result_5");
		//	appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","clip_upload_result_10");
		//	appsFlyerObj.extractFilesForValidationFunction("NonSubscribedUser","8234","clip_upload_result_25");			
			
		}
		

		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
