package com.business.zee;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Reporter;

import com.driverInstance.DriverInstance;
import com.driverInstance.Drivertools;
import com.emailReport.GmailInbox;
import com.excel.Time_ExcelUpdate;
import com.extent.ExtentReporter;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;
import com.zee5.iOSHipiPages.IOSHiPiNeoDiscoverPage;
import com.zee5.iOSHipiPages.IOSHipiNeoHomePage;
import com.zee5.iOSHipiPages.IOSHipiNeoProfilePage;
import com.zee5.iOSHipiPages.IOSHipiNeoSettingsPage;
import com.zee5.iOSmWebHipiPages.IOSHipiMwebDiscoverPage;
import com.zee5.iOSmWebHipiPages.IOSHipiMwebHomePage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;


@SuppressWarnings("static-access")
public class Zee5mWebiOSHipiNeoSanityBusinessLogic extends Utilities {

	public Date date;
	Robot robo;
	
	Drivertools tools;

	@SuppressWarnings("unused")
	private static final String Expectedresult = null;

	public static String iosModel;
	public static String iosVersion;

	public Zee5mWebiOSHipiNeoSanityBusinessLogic(String Application) {
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

	@SuppressWarnings("rawtypes")
	public TouchAction touchAction;

	/** The iOS driver. */
	public IOSDriver<WebElement> iOSDriver;

	@Override
	public int getTimeout() {
		return timeout;
	}



	String pUserType = getParameterFromXML("userType");

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


	public void init() {
		try {
		if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getSuite().getName()
				.equals("MPWA")) {
			System.out.println("===================Platform : MPWA==============================");
			iosModel = testtest.deviceName("");
			//iosModel = (String) getDriver().getCapabilities().getCapability("device.model");
			System.out.println(iosModel + "--- Model Name ");
			iosVersion = testtest.deviceVersion("");
			//iosVersion = (String) getDriver().getCapabilities().getCapability("device.version");
			System.out.println(iosVersion + "--- Version ");
		} else if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getSuite().getName()
				.equals("HIPI_iOS")) {
			iosModel = testtest.deviceName("");
			iosVersion = testtest.deviceVersion("");
			//iosModel = (String) getDriver().getCapabilities().getCapability("device.model");
			System.out.println(iosModel + "--- Model Name ");
			//iosVersion = (String) getDriver().getCapabilities().getCapability("device.version");
			System.out.println(iosVersion + "--- Version ");
		} else if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getSuite().getName()
				.equals("Web")) {
			System.out.println("Platform : Web");
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
		setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
		setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
		// logger.info("Loaded the following properties" + " TimeOut :" +
		// getTimeout() + " RetryCount :" + getRetryCount());
	}
	public void closeSafariTabs() throws InterruptedException{

		WebElement browserTab = getDriver().findElementByXPath("//*[@label='Tabs']");
		//XCUIElementTypeButton[contains(@label,'New Tab')]

		browserTab.click();
		Thread.sleep(8000);

		
		getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='AddTabButton']")).click();

		Thread.sleep(8000);
		
		try{
		
			Set<String> contextNames = (getDriver()).getContextHandles();
			for (String contextName : contextNames) {                       
				System.out.println("contextName " + contextName);
				if (contextName.contains("WEBVIEW")) 
					(getDriver()).context(contextName);
				getDriver().close();
			}
			getDriver().manage().deleteAllCookies();
		}catch(Exception e){};
		Thread.sleep(8000);
		
		
	}
	
	public void getURl() throws Exception {
		extent.HeaderChildNode("Launch hipi.co.in");
		String url = getParameterFromXML("url");
		Time_ExcelUpdate.TestCaseIDNode("MPWA_TC002");
		
		Time_ExcelUpdate.ModuleNode("MPWA--URL Loading");
		Time_ExcelUpdate.TestCaseSummaryNode1("Launch hipi.co.in");
		
		
		waitTime(5000);
//		try {
//			getDriver().removeApp("com.zee5.hipi", null);
//			System.out.println("App uninstalled");
//		} catch (Exception e) {
//			System.out.println("App not present");
//		}
//		getDriver().quit();
//		waitTime(10000);
//		new Zee5mWebiOSHipiNeoSanityBusinessLogic("safari");
//		waitTime(4000);
		
		TimeStampclick(IOSHipiMwebHomePage.objiosmwebSearchAddress, "searchtab in safari");
		waitTime(3000);
		TimeStamptype(IOSHipiMwebHomePage.objiosmwebSearchTabInSafari, url, url+"Typing url");
		waitTime(3000);
		TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebSearchButtonInKeyboard,"search button in keyboard");
		Instant start = Instant.now();
		if(TimeStampwaitForElementDisplayedFastPolling(IOSHipiMwebHomePage.objiOSmwebDiscoverBtnInBelowTabBar, 50, "Explore tab")) {	
			Instant end = Instant.now();
			
			Duration timeElapsed = Duration.between(start, end);
			String Processingtimesec=Long.toString(timeElapsed.getSeconds());
			String Processingtimemilli=Long.toString(timeElapsed.toMillis());
			int l=Processingtimemilli.length();
			String mili=Processingtimemilli.substring(l-3, l);
			extent.HeaderChildNode("the time for loading URL  " +"Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds");
			System.out.println("Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds" );
			extent.HeaderChildNode("the time for loading URL  " +"Time taken in milliseconds : "+timeElapsed.toMillis()+" milliSeconds");
			//System.out.println("Time taken in milliseconds : "+timeElapsed.toMillis()+" milliSeconds" );
			
			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+mili + "  Sec");
			extent.extentLogger("", "the time for loading URL------  " + end);

		//Time_ExcelUpdate.timeStamp("========================");
		}else {
			extent.extentLoggerFail("", "User not able to enter the URL");
			System.out.println("User not able to enter the URL");
		}
		
		
	}
	
	

public void FeedScreenArrivalTimeFromSplashScreen(String userType) throws Exception{
String url=getParameterFromXML("url");
	Time_ExcelUpdate.TestCaseIDNode("TC001");
	
	Time_ExcelUpdate.ModuleNode("MPWA--FeedArrival");
	Time_ExcelUpdate.TestCaseSummaryNode1("Launch hipi.co.in");
	extent.HeaderChildNode("Launch hipi.co.in");
	getDriver().quit();
	waitTime(10000);
	new Zee5mWebiOSHipiNeoSanityBusinessLogic("safari");
	waitTime(4000);
	if(TimeStampverifyElementExist(IOSHipiMwebHomePage.objiosmwebSearchAddress, "searchtab in safari")) {
		TimeStampclick(IOSHipiMwebHomePage.objiosmwebSearchAddress, "searchtab in safari");
		waitTime(3000);
		TimeStamptype(IOSHipiMwebHomePage.objiosmwebSearchTabInSafari,url, "Typing url");
		waitTime(3000);
		TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebSearchButtonInKeyboard,"search button in keyboard");
		
	Instant start = Instant.now();

	extent.extentLogger("", "clicked on hipi at Time----- "+ start);
	if(TimeStampwaitForElementDisplayedFastPolling(IOSHipiNeoHomePage.objiOSForYouBtnInFeedScreen, 50, "for you button in feed")) {	
	//screencapture();
	Instant end = Instant.now();
	
	Duration timeElapsed = Duration.between(start, end);
	String Processingtimesec=Long.toString(timeElapsed.getSeconds());
	String Processingtimemilli=Long.toString(timeElapsed.toMillis());
	int l=Processingtimemilli.length();
	String mili=Processingtimemilli.substring(l-3, l);
	extent.HeaderChildNode("the arrival time of feed screen from splash screen " +"Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds");
	System.out.println("Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds" );
	extent.HeaderChildNode("the arrival time of feed screen from splash screen " +"Time taken in milliseconds : "+timeElapsed.toMillis()+" milliSeconds");
	//System.out.println("Time taken in milliseconds : "+timeElapsed.toMillis()+" milliSeconds" );
	
	Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+mili + "  Sec");
	extent.extentLogger("", "Feed screen seen  at Time----- " + end);
	
	}else {
		extent.extentLoggerFail("", "Feed screen is not visible");
	}
}
}
		
public void LikeVideo(String userType) throws Exception{
	
	extent.HeaderChildNode("Tapping on like button");
	Time_ExcelUpdate.TestCaseIDNode("TC002");
	
	Time_ExcelUpdate.ModuleNode("Like scenario");
	Time_ExcelUpdate.TestCaseSummaryNode1("Tapping on like button");
	TimeStampScrollToElementiOS_Up(IOSHipiNeoHomePage.objiOSLikeBtn, "Like button");
	
	TimeStampclick(IOSHipiNeoHomePage.objiOSLikeBtn, "Like button");
	
	Instant start = Instant.now();
	
	//extent.extentLogger("", "clicked on like button at Time----- "+ start);
	if(TimeStampwaitForElementDisplayedFastPolling(IOSHipiNeoHomePage.objiOSLikedBtnInFeedScreen,50,"Liked button")) {
	Instant end = Instant.now();
	//extent.extentLogger("", "Liked button seen  at Time----- " + end);
	Duration timeElapsed = Duration.between(start, end);
	screencapture();
	String Processingtimesec=Long.toString(timeElapsed.getSeconds());
	
	extent.HeaderChildNode("Time take to like a Video " +"  in Seconds : "+timeElapsed.getSeconds()+" Seconds");
	System.out.println("Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds" );
	String Processingtimemilli=Long.toString(timeElapsed.toMillis());
	int l=Processingtimemilli.length();
	String mili=Processingtimemilli.substring(l-3, l);
	
	Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+mili + "  Sec");
	waitTime(1000);
	extent.extentLogger("", "Total time to like----- " + Processingtimesec);
	
	}else {
		extent.extentLoggerFail("", "user not able to like video");
	}
	
}

public void TimeStampLoginAndNivigateToHipi(String loginMethod) throws Exception {
	extent.HeaderChildNode("Login Functionality");
	String pUserType = getParameterFromXML("userType");

	//extent.extentLogger("Login Type", "Login Type : " + pUserType);

	switch (loginMethod) {
	case "Guest":
		extent.HeaderChildNode("Guest User");
		extent.extentLogger("Accessing the application as Guest user", "Accessing the application as Guest user");
		TimeStampclick(IOSHipiMwebHomePage.objiOSmwebProfileBtnInBelowTabBar, "Profile Button");
		waitTime(8000);
		//TimeStampwaitForElementDisplayediOS(null, CommentTitleCount1, pUserType)
		TimeStampwaitForElementDisplayediOS(IOSHipiMwebHomePage.objiiosmwebLoginPopUp, 10, "Login in to Hipi");
		if (TimeStampverifyElementExist(IOSHipiMwebHomePage.objiiosmwebLoginPopUp, "Login in to Hipi")) {
			logger.info(" UserType: Guest user");
			//extent.extentLogger("", " UserType: Guest user");
			waitTime(3000);
			TimeStampclick(IOSHipiMwebHomePage.objiiosmwebReloadBtn, "Reload button");
			waitTime(2000);

		} else {
			TimeStampLogout();
			logger.info(" Logged out Successfully now UserType: Guest user");
			extent.extentLogger("", " Logged out Successfully now UserType: Guest user");
		}

		break;

	case "NonSubscribedUser":
		// navigateToIntroScreen_DisplaylangScreen();
		extent.HeaderChildNode(" log in as NonSubscribed User using email");

		// click on Profile icon
		if(!TimeStampverifyElementExist(IOSHipiMwebHomePage.objiOSmwebProfileBtnInBelowTabBar, "Profile button")) {
		PartialCommentsSwipeiOS("UP", 1);
			waitTime(3000);
		}
		TimeStampwaitForElementDisplayediOS(IOSHipiMwebHomePage.objiOSmwebProfileBtnInBelowTabBar, 15, "Profile button"); 
			TimeStampclick(IOSHipiMwebHomePage.objiOSmwebProfileBtnInBelowTabBar, "Profile Icon");
			waitTime(3000);
//			if (TimeStampverifyElementExist(IOSHipiNeoProfilePage.objiOS3dotsmenu, "3 dots menu")) {
//				TimeStampLogout();
//				waitTime(3000);
//				TimeStampclick(IOSHipiNeoHomePage.objiOSProfileBtnInBelowTabBar, "Profile Icon");
//			}

			TimeStampclick(IOSHipiMwebHomePage.objiOSmwebUseEmailOrPhoneInBelowTabBar, "Use Phone Or Email");

			String Username = getParameterFromXML("NonsubscribedUserName");
			String Password = getParameterFromXML("NonsubscribedPassword");
			waitTime(2000);

			TimeStamphideKeyboard();
			TimeStampclick(IOSHipiMwebHomePage.objiOSmwebEmailOption, "Email Option");
			waitTime(2000);
			TimeStampclick(IOSHipiMwebHomePage.objiOSmwebEmailIdField, "Email field");
			waitTime(2000);
			TimeStamphideKeyboard();

			TimeStamptype(IOSHipiMwebHomePage.objiOSmwebEmailIdField, Username, "Email Field");
			waitTime(2000);
			TimeStamphideKeyboard();

			TimeStampclick(IOSHipiMwebHomePage.objiosmWebPasswordField, "Password Field");
			waitTime(2000);
			TimeStamphideKeyboard();

			TimeStamptype(IOSHipiMwebHomePage.objiosmWebPasswordField, Password, "Password field");
			waitTime(2000);
			TimeStamphideKeyboard();
			TimeStampclick(IOSHipiMwebHomePage.objiiosmWebLoginBtn, "Login Button");

			if (TimeStampwaitForElementDisplayediOS(IOSHipiMwebHomePage.objiOSmwebProfileBtnInBelowTabBar, 30, "Loggeg-In Successfully")) {
				logger.info("Logged-In Successfully toast msg");
				//extent.extentLoggerPass("", "Logged-In Successfully toast msg");
			} else {
				logger.error("Logged-In Successfully toast msg is not displayed");
				//extent.extentLoggerFail("", "Loggeg-In Successfully toast msg is not displayed");
			}

			waitTime(5000);
			
			if(TimeStampwaitForElementDisplayediOS(IOSHipiMwebHomePage.objiosSwipeUpForNxtVideoInSafari, 100, "Swipe foe next video animation")) {
				TimeStampclick(IOSHipiMwebHomePage.objiosSwipeUpForNxtVideoInSafari,  "Swipe foe next video animation");
			}
			
			// click on feed button
			TimeStampclick(IOSHipiMwebHomePage.objiOSnmwebHomeBtnInBelowTabBar, "Home Icon");

			break;
		} 

}

public void keyboardaction(String TypeEnter) throws AWTException {
	robo=new Robot();
	if(TypeEnter.equalsIgnoreCase("Enter")) {
		robo.keyPress(KeyEvent.VK_ENTER);	
	}
}




public void TimeStampLogout() throws Exception {

	if (TimeStampwaitForElementDisplayediOS(IOSHipiNeoHomePage.objiOSHomeBtnInBelowTabBar, 20, "Home Icon")) {
		waitTime(2000);
		TimeStampclick(IOSHipiNeoHomePage.objiOSProfileBtnInBelowTabBar, "Profile");
		waitTime(2000);
		TimeStampclick(IOSHipiNeoProfilePage.objiOS3dotsmenu, "3 dots");
		waitTime(2000);
		TimeStampScrollToElementiOS_Up(IOSHipiNeoSettingsPage.objiOSversionInSettingsScreen, "Version of the app");
		waitTime(2000);
		TimeStampclick(IOSHipiNeoSettingsPage.objiOSLogOutBtn, "logout");
		waitTime(2000);

		TimeStampverifyElementExist(IOSHipiNeoSettingsPage.objiosAreYouSureTextInLogoutPOpUp, "Are u sure for logout");
		waitTime(2000);
		TimeStampclick(IOSHipiNeoSettingsPage.objiOSLogOutConfirmBtn, "logout Confirm button");
		waitTime(800);
		if (TimeStampwaitForElementDisplayediOS(IOSHipiNeoHomePage.objiiosLogOutToastMsg, 15, "Logged-Out Successfully")) {
			logger.info("Logged-Out Successfully toast msg");
			//extent.extentLoggerPass("", "Logged-Out Successfully toast msg");
		} else {
			logger.error("Logged-Out Successfully toast msg is not displayed");
			//extent.extentLoggerFail("", "Logged-Out Successfully toast msg is not displayed");
		}
		waitTime(2000);
	//	ScrollToRailiOS_Up(null, Commentsdeeplink6);

	}
}		

public void TimeStampSwipeTillElement(By locator,String locatorName) throws Exception {
	for(int i=0;i<=9;i++) {
		try {
			if(TimeStampverifyElementExist(locator, locatorName)) {
				break;
			}else {
				TimeStampPartialSwipe("Up", 1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public void searchResults(String SearchItem,String TCID) throws Exception {
	
	extent.HeaderChildNode("Search Result for "+SearchItem);
	String Suggestions1="";
	String Suggestions2="";
	String Profile1="";
	String Profile2="";
	String Video1="";
	String Video2="";
	String Hashtags1="";
	String Hashtags2="";
	String Sounds1="";
	String Sounds2="";
	waitTime(4000);
	String url = getParameterFromXML("url");
		new Zee5mWebiOSHipiNeoSanityBusinessLogic("safari");
		waitTime(10000);
		closeSafariTabs();
		waitTime(4000);
		TimeStampclick(IOSHipiMwebHomePage.objiosmwebSearchAddress, "searchtab in safari");
		waitTime(3000);
		TimeStamptype(IOSHipiMwebHomePage.objiosmwebSearchTabInSafari, url, url+"Typing url");
		waitTime(3000);
		TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebSearchButtonInKeyboard,"search button in keyboard");
		
		TimeStampwaitForElementDisplayedFastPolling(IOSHipiMwebHomePage.objiOSmwebDiscoverBtnInBelowTabBar, 50, "Explore tab");
		waitTime(4000);
	
	logger.info("Search Result for "+SearchItem);
	Time_ExcelUpdate.TestCaseIDNode(TCID);
	Time_ExcelUpdate.ModuleNode("Search Suggetions: "+SearchItem);
	Time_ExcelUpdate.TestCaseSummaryNode1("Search Suggetions: "+SearchItem);
	
	TimeStampclick(IOSHipiMwebHomePage.objiOSnmwebHomeBtnInBelowTabBar,"Home button");
	waitTime(2000);
	TimeStampclick(IOSHipiMwebHomePage.objiOSmwebDiscoverBtnInBelowTabBar,"Discover button");
	waitTime(4000);
	TimeStampclick(IOSHipiMwebHomePage.objiiosmwebReloadBtn,"Reload screen");
	waitTime(7000);
	WebElement ele=getDriver().findElement(IOSHipiMwebDiscoverPage.objiosmwebSearchFieldInDiscoverPage);
	ele.clear();
	waitTime(4000);
	int x=ele.getLocation().getX();
	int y=ele.getLocation().getY();
	System.out.println(x+"========="+y);
	int k=x+ 100;
	int l=y;
	ele.clear();
	tapiOSAtCoOrdinates(k,l,1);
	//TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebSearchFieldInDiscoverPage,"Search field in Discover Page");
	waitTime(5000);
	TimeStamptype(IOSHipiMwebDiscoverPage.objiosmwebSearchFieldInDiscoverPage, SearchItem, SearchItem);
	waitTime(5000);
	if(TimeStampverifyElementExist(IOSHipiMwebDiscoverPage.objiosmwebAutoSuggestionsInSearchParentPage(1), "suggestions")) {
	Suggestions1=getText(IOSHipiMwebDiscoverPage.objiosmwebAutoSuggestionsInSearchParentPage(1));
	System.out.println(Suggestions1);
	Suggestions2=getText(IOSHipiMwebDiscoverPage.objiosmwebAutoSuggestionsInSearchParentPage(2));
	System.out.println(Suggestions2);
	waitTime(3000);
	
	
	Time_ExcelUpdate.TestCaseSummaryNode1("1 "+Suggestions1);
	extent.extentLogger("","Search  1st Suggestion done");
	
	Time_ExcelUpdate.TestCaseSummaryNode1("2 "+Suggestions2);
	}else {
		
		//Time_ExcelUpdate.TestCaseSummaryNode1("Suggestion  not present");
		extent.extentLoggerFail("",TCID + "Suggestion  not present");
	}
	
	TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebreturnButtonInKeyboard, "Search button in keyboard");
	//keyboardaction("Enter");
	waitTime(2000);
	TimeStampwaitForElementDisplayedFastPolling(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("Top"), 100, "results after search");
	extent.extentLogger("","Search done");

	
	Time_ExcelUpdate.ModuleNode("Top Users Section :"+SearchItem);
	Time_ExcelUpdate.TestCaseSummaryNode1("Top Users Result: "+SearchItem);
	Profile1=getText(IOSHipiMwebDiscoverPage.objiosmwebProfileInDiscoverpage(2));
	System.out.println(Profile1);
	Profile2=getText(IOSHipiMwebDiscoverPage.objiosmwebProfileInDiscoverpage(6));
	System.out.println(Profile2);
	waitTime(3000);
	
	
	Time_ExcelUpdate.TestCaseSummaryNode1("1 "+Profile1);
	extent.extentLogger("","Top Users 1 st profile name fetched");
	
	Time_ExcelUpdate.TestCaseSummaryNode1("2 "+Profile2);
	extent.extentLogger("","Top Users 2nd profile name fetched");
	
	
	Time_ExcelUpdate.ModuleNode("Top Videos Section:"+SearchItem);
	Time_ExcelUpdate.TestCaseSummaryNode1("Top Videos Result:"+SearchItem);
	
	
	if(TimeStampverifyElementExist(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("VIDEOS"), "Videos in under Top section ")) {
//	Video1=getText(IOSHiPiNeoDiscoverPage.objiosSearchResultVideosInTopSection(1,9));
//	System.out.println(Video1);
//	Video2=getText(IOSHiPiNeoDiscoverPage.objiosSearchResultVideosInTopSection(2,9));
//	System.out.println(Video2);
//	waitTime(3000);
	
	waitTime(3000);
	TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebPlayIconInVideosTab(1),"1 st video");
	waitTime(5000);
	WebElement name=getDriver().findElement(IOSHipiMwebHomePage.objiOSmwebUserNameInFeedScreen);
	String name1=name.getAttribute("name");
	//String Video1Username=getText(IOSHipiMwebHomePage.objiOSmwebUserNameInFeedScreen);
	TimeStampclick(IOSHipiMwebDiscoverPage.objmwebBackButtonInDiscoverPage, "Back button");
	waitTime(7500);
	
	TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebPlayIconInVideosTab(2),"2nd video");
	waitTime(3000);
	WebElement secname=getDriver().findElement(IOSHipiMwebHomePage.objiOSmwebUserNameInFeedScreen);
	String name2=secname.getAttribute("name");
	//String Video2Username=getText(IOSHipiMwebHomePage.objiOSmwebUserNameInFeedScreen);
	TimeStampclick(IOSHipiMwebDiscoverPage.objmwebBackButtonInDiscoverPage, "Back button");
	waitTime(7500);
	
	
	
	
	
	
	Time_ExcelUpdate.TestCaseSummaryNode1("1 st video is from  "+name1);
	extent.extentLogger("","Top videos 1 st video name fetched");
	
	Time_ExcelUpdate.TestCaseSummaryNode1("2 nd video is from "+name2);
	extent.extentLogger("","Top videos 2nd video name fetched");
	
	}else {
		Time_ExcelUpdate.TestCaseIDNode(TCID);
		//Time_ExcelUpdate.TestCaseSummaryNode1("Videos  not present");
		extent.extentLoggerFail("","Videos  not present");
		
//		Time_ExcelUpdate.TestCaseSummaryNode1("Videos  not present");
//		extent.extentLoggerFail("","Videos  not present");
	}

	
	
	Time_ExcelUpdate.ModuleNode("Top Hashtag Section: "+SearchItem);
	TimeStampSwipeTillElement(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("HASHTAGS"), "Hashtags");
	waitTime(3000);
	if(TimeStampverifyElementExist(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("HASHTAGS"), "Hashtags")) {
		
		Hashtags1=getText(IOSHipiMwebDiscoverPage.objiOSmwebHashTagitemUnderTopSection(1));
		System.out.println(Hashtags1);
		Hashtags2=getText(IOSHipiMwebDiscoverPage.objiOSmwebHashTagitemUnderTopSection(2));
		System.out.println(Hashtags2);
		waitTime(3000);
		
		
		Time_ExcelUpdate.TestCaseSummaryNode1("1."+Hashtags1);
		extent.extentLogger("","1 st Hashtag fetched");
		
		Time_ExcelUpdate.TestCaseSummaryNode1("2."+Hashtags2);
		extent.extentLogger("","2 nd Hashtag fetched");
		
		
	}else {
		
		//Time_ExcelUpdate.TestCaseSummaryNode1("Hashtag  not present");
		extent.extentLoggerFail("","Hashtag  not present");
		
//		Time_ExcelUpdate.TestCaseSummaryNode1("Hashtag  not present");
//		extent.extentLoggerFail("","Hashtag  not present");
	}

	
	
//	Time_ExcelUpdate.ModuleNode("Top Sounds Section:"+SearchItem);
//	TimeStampSwipeTillElement(IOSHiPiNeoDiscoverPage.objiosSoundsSectionUnderTopresults, "Sounds");
//	waitTime(3000);
//	if(TimeStampverifyElementExist(IOSHiPiNeoDiscoverPage.objiosSoundsSectionUnderTopresults, "Sounds")) {
//		
//		Sounds1=getText(IOSHiPiNeoDiscoverPage.objiOSSounditemUnderTopSection(1));
//		System.out.println(Sounds1);
//		Sounds2=getText(IOSHiPiNeoDiscoverPage.objiOSSounditemUnderTopSection(2));
//		System.out.println(Sounds2);
//		waitTime(3000);
//		
//		
//		Time_ExcelUpdate.TestCaseSummaryNode1("1."+Sounds1);
//		extent.extentLogger("","1 st Sound fetched");
//		
//		Time_ExcelUpdate.TestCaseSummaryNode1("2."+Sounds2);
//		extent.extentLogger("","2 nd Sound fetched");
//		
//		
//	}else {
//		
//		//Time_ExcelUpdate.TestCaseSummaryNode1("Sound  not present");
//		extent.extentLoggerFail("","Sound  not present");
//		
////		Time_ExcelUpdate.TestCaseSummaryNode1("Sound  not present");
////		extent.extentLoggerFail("","Sound  not present");
//	}
	
	waitTime(5000);
	TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("Users"), "Users");
	Time_ExcelUpdate.ModuleNode("Users Section: "+SearchItem);
	if(TimeStampverifyElementExist(IOSHipiMwebDiscoverPage.objiOSmwebSearchResultsUnderUsersSection(1), "Results under Users Tab")) {
	waitTime(3000);
	String UsersProfile1=getText(IOSHipiMwebDiscoverPage.objiOSmwebSearchResultsUnderUsersSection(1));
	String UsersProfile2=getText(IOSHipiMwebDiscoverPage.objiOSmwebSearchResultsUnderUsersSection(2));
	String UsersProfile3=getText(IOSHipiMwebDiscoverPage.objiOSmwebSearchResultsUnderUsersSection(3));
	String UsersProfile4=getText(IOSHipiMwebDiscoverPage.objiOSmwebSearchResultsUnderUsersSection(4));
	String UsersProfile5=getText(IOSHipiMwebDiscoverPage.objiOSmwebSearchResultsUnderUsersSection(5));
	
	
	Time_ExcelUpdate.TestCaseSummaryNode1("1."+UsersProfile1);
	extent.extentLogger("","1 st Result under Users Tab");
	
	Time_ExcelUpdate.TestCaseSummaryNode1("2."+UsersProfile2);
	extent.extentLogger("","2 nd Result under Users Tab");
	
	Time_ExcelUpdate.TestCaseSummaryNode1("3."+UsersProfile3);
	extent.extentLogger("","3rd Result under Users Tab");
	
	Time_ExcelUpdate.TestCaseSummaryNode1("4."+UsersProfile4);
	extent.extentLogger("","4th Result under Users Tab");
	
	Time_ExcelUpdate.TestCaseSummaryNode1("5."+UsersProfile5);
	extent.extentLogger("","5 th Result under Users Tab");
	
	
	}else {
	
		//Time_ExcelUpdate.TestCaseSummaryNode1("Users tap result  not present");
		extent.extentLoggerFail("","Users tap result  not present");
		
//		Time_ExcelUpdate.TestCaseSummaryNode1("Users tap result  not present");
//		extent.extentLoggerFail("","Users tap result  not present");
//		
//		Time_ExcelUpdate.TestCaseSummaryNode1("Users tap result  not present");
//		extent.extentLoggerFail("","Users tap result  not present");
//		
//		Time_ExcelUpdate.TestCaseSummaryNode1("Users tap result  not present");
//		extent.extentLoggerFail("","Users tap result  not present");
//		
//		Time_ExcelUpdate.TestCaseSummaryNode1("Users tap result  not present");
//		extent.extentLoggerFail("","Users tap result  not present");
		
	}

	
	
	waitTime(5000);
	
	Time_ExcelUpdate.ModuleNode("Videos Section: "+SearchItem);
	Time_ExcelUpdate.TestCaseSummaryNode1("Videos section in search Result: "+SearchItem);
	
	TimeStampverifyElementExist(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("Videos"), "Videos Tab in search result ");
		TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("Videos"), "Videos");
		waitTime(5500);
		TimeStampwaitForElementDisplayedFastPolling(IOSHipiMwebDiscoverPage.objiosmwebSearchResultVideosInTopSection(1), 25, "videos");
		if(TimeStampverifyElementExist(IOSHipiMwebDiscoverPage.objiosmwebSearchResultVideosInTopSection(1),"Videos Result")){
//		Video1=getText(IOSHiPiNeoDiscoverPage.objiosSearchResultVideosInTopSection(1,9));
//		System.out.println(Video1);
//		 Video2=getText(IOSHiPiNeoDiscoverPage.objiosSearchResultVideosInTopSection(2,9));
//		System.out.println(Video2);
		
		
		waitTime(3000);
		TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebSearchResultVideosInTopSection(1),"1 st video");
		waitTime(3000);
		
		String Video1Username=getAttributValue("name", IOSHipiMwebHomePage.objiOSmwebUserNameInFeedScreen);
		waitTime(5000);
		TimeStampclick(IOSHipiMwebDiscoverPage.objmwebBackButtonInSafariBrowserPage, "Back button");
		waitTime(5500);
		TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("Videos"), "Videos");
		waitTime(3000);
		TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebSearchResultVideosInTopSection(2),"2nd video");
		waitTime(3000);
		String Video2Username=getAttributValue("name", IOSHipiMwebHomePage.objiOSmwebUserNameInFeedScreen);
		waitTime(5000);
		TimeStampclick(IOSHipiMwebDiscoverPage.objmwebBackButtonInSafariBrowserPage, "Back button");
		waitTime(5500);
		TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("Videos"), "Videos");
		waitTime(3000);
		TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebSearchResultVideosInTopSection(3),"3 rd video");
		waitTime(5000);
		String Video3Username=getAttributValue("name", IOSHipiMwebHomePage.objiOSmwebUserNameInFeedScreen);
		waitTime(3000);
		TimeStampclick(IOSHipiMwebDiscoverPage.objmwebBackButtonInSafariBrowserPage, "Back button");
		waitTime(5500);
		
	
		
		
		Time_ExcelUpdate.TestCaseSummaryNode1("1 st video is from  "+Video1Username);
		extent.extentLogger(""," in videos section 1 st video name fetched");
		
		Time_ExcelUpdate.TestCaseSummaryNode1("2 nd video is from "+Video2Username);
		extent.extentLogger(""," in videos section 2 nd video name fetched");
		
		
		
		Time_ExcelUpdate.TestCaseSummaryNode1("3 rd video is from "+Video3Username);
		extent.extentLogger(""," in videos section 3 rd video name fetched");
		
		
		}else {
			
			//Time_ExcelUpdate.TestCaseSummaryNode1("Videos  not present");
			extent.extentLoggerFail("","Videos  not present");
			
			
		}


//	
//		waitTime(5000);
//	
//	Time_ExcelUpdate.ModuleNode("Sounds Section: "+SearchItem);
//	Time_ExcelUpdate.TestCaseSummaryNode1("Sounds Section in Search results: "+SearchItem);
//	
//	TimeStampverifyElementExist(IOSHiPiNeoDiscoverPage.objiosTabnameInDiscoverSearchResultsPage("Sounds"), "Sounds Tab in search result ");
//		TimeStampclick(IOSHiPiNeoDiscoverPage.objiosTabnameInDiscoverSearchResultsPage("Sounds"), "Sounds");
//		
//		if(TimeStampverifyElementExist(IOSHiPiNeoDiscoverPage.objiOSSounditemUnderSoundSection(1), "Sounds")) {
//		String Sound1=getText(IOSHiPiNeoDiscoverPage.objiOSSounditemUnderSoundSection(1));
//		System.out.println(Sound1);
//		String Sound2=getText(IOSHiPiNeoDiscoverPage.objiOSSounditemUnderSoundSection(2));
//		System.out.println(Sound2);
//		
//		String Sound3=getText(IOSHiPiNeoDiscoverPage.objiOSSounditemUnderSoundSection(3));
//		System.out.println(Sound3);
//		
//		String Sound4=getText(IOSHiPiNeoDiscoverPage.objiOSSounditemUnderSoundSection(4));
//		System.out.println(Sound4);
//		
//		String Sound5=getText(IOSHiPiNeoDiscoverPage.objiOSSounditemUnderSoundSection(5));
//		System.out.println(Sound5);
//		
//		Time_ExcelUpdate.TestCaseSummaryNode1("1. "+Sound1);
//		extent.extentLogger(""," in Sound section 1 st Sound name fetched");
//		
//		Time_ExcelUpdate.TestCaseSummaryNode1("2. "+Sound2);
//		extent.extentLogger(""," in Sound section 2 nd Sound name fetched");
//		
//
//		Time_ExcelUpdate.TestCaseSummaryNode1("3. "+Sound3);
//		extent.extentLogger(""," in Sound section 3 rd Sound name fetched");
//		
//
//		Time_ExcelUpdate.TestCaseSummaryNode1("4. "+Sound4);
//		extent.extentLogger(""," in Sound section 4 th Sound name fetched");
//		
//
//		Time_ExcelUpdate.TestCaseSummaryNode1("5. "+Sound5);
//		extent.extentLogger(""," in Sound section 5 th Sound name fetched");
//		
//		
//		}else {
//			
//			//Time_ExcelUpdate.TestCaseSummaryNode1("Sounds  not present");
//			extent.extentLoggerFail("","Sounds  not present");
//			
//			
//		}
//	
	
waitTime(5000);
	
	Time_ExcelUpdate.ModuleNode("HashTag Section: "+SearchItem);
	Time_ExcelUpdate.TestCaseSummaryNode1("HashTag Section in Search results: "+SearchItem);
	
	TimeStampverifyElementExist(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("Hashtags"), "HashTags Tab in search result ");
		TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("Hashtags"), "Hashtags");
		if(TimeStampverifyElementExist(IOSHipiMwebDiscoverPage.objiOSmwebHashTagitemUnderTopSection(1), "Hashtag result")) {
		String HashTag1=getText(IOSHipiMwebDiscoverPage.objiOSmwebHashTagitemUnderTopSection(1));
		System.out.println(HashTag1);
		String HashTag2=getText(IOSHipiMwebDiscoverPage.objiOSmwebHashTagitemUnderTopSection(2));
		System.out.println(HashTag2);
		
		String HashTag3=getText(IOSHipiMwebDiscoverPage.objiOSmwebHashTagitemUnderTopSection(3));
		System.out.println(HashTag3);
		
		String HashTag4=getText(IOSHipiMwebDiscoverPage.objiOSmwebHashTagitemUnderTopSection(4));
		System.out.println(HashTag4);
		
		String HashTag5=getText(IOSHipiMwebDiscoverPage.objiOSmwebHashTagitemUnderTopSection(5));
		System.out.println(HashTag5);
		
		Time_ExcelUpdate.TestCaseSummaryNode1("1. "+HashTag1);
		extent.extentLogger(""," in HashTag section 1 st HashTag name fetched");
		
		Time_ExcelUpdate.TestCaseSummaryNode1("2. "+HashTag2);
		extent.extentLogger(""," in HashTag section 2 nd HashTag name fetched");
		

		Time_ExcelUpdate.TestCaseSummaryNode1("3. "+HashTag3);
		extent.extentLogger(""," in HashTag section 3 rd HashTag name fetched");
		

		Time_ExcelUpdate.TestCaseSummaryNode1("4. "+HashTag4);
		extent.extentLogger(""," in HashTag section 4 th HashTag name fetched");
		

		Time_ExcelUpdate.TestCaseSummaryNode1("5. "+HashTag5);
		extent.extentLogger(""," in HashTag section 5 th HashTag name fetched");
		
		
		}else {
			
			//Time_ExcelUpdate.TestCaseSummaryNode1("HashTag  not present");
			extent.extentLoggerFail("","HashTag  not present");
			
			
		}
		waitTime(5000);
		getURl();
//	TimeStampclick(IOSHipiMwebDiscoverPage.objmwebBackButtonInSafariBrowserPage, "Back button");
//	waitTime(2500);
//	TimeStampclick(IOSHipiNeoHomePage.objiOSHomeBtnInBelowTabBar,"Home");
//	waitTime(2500);
	
}
public void tapiOSAtCoOrdinates(int x, int y, int k) throws IOException {
	@SuppressWarnings("rawtypes")
	TouchAction touchAction=new TouchAction(getDriver());
	
	for(int i=1;i<=k;i++) {
		org.openqa.selenium.Dimension size = getDriver().manage().window().getSize();
		int startx =  x;
		
		int starty = y;
	
		touchAction.press(PointOption.point(startx, starty)).perform().release();


		logger.info("Tapped on Screen for "+ i +" time");
	extent.extentLogger("", "Tapped on Screen for "+ i +" time");
	}
}
public void SwipeUpAnimation() throws  Exception {
	extent.HeaderChildNode("Swipe up for next video----- Animation");
	
	Time_ExcelUpdate.TestCaseIDNode("MPWA_TC001");
	
	Time_ExcelUpdate.ModuleNode("MPWA--Swipe up-- Animation");
	Time_ExcelUpdate.TestCaseSummaryNode1("Swipe up for next video----- Animation");
	Instant start = Instant.now();
	if(TimeStampwaitForElementDisplayediOS(IOSHipiMwebHomePage.objiosSwipeUpForNxtVideoInSafari, 200, "Swipe foe next video animation")) {
		Instant end = Instant.now();
		
		Duration timeElapsed = Duration.between(start, end);
		String Processingtimesec=Long.toString(timeElapsed.getSeconds());
		String Processingtimemilli=Long.toString(timeElapsed.toMillis());
		int l=Processingtimemilli.length();
		String mili=Processingtimemilli.substring(l-3, l);
		extent.HeaderChildNode("the time for Swipe up for next video----- Animation  " +"Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds");
		System.out.println("Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds" );
		extent.HeaderChildNode("the time for Swipe up for next video----- Animation  " +"Time taken in milliseconds : "+timeElapsed.toMillis()+" milliSeconds");
		//System.out.println("Time taken in milliseconds : "+timeElapsed.toMillis()+" milliSeconds" );
		
		Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+mili + "  Sec");
		extent.extentLogger("", "the time for loading URL------  " + end);

	//Time_ExcelUpdate.timeStamp("========================");
	}else {
		extent.extentLoggerFail("", "User not able to see the  Swipe up for next video----- Animation  ");
		System.out.println("User not able to see the  Swipe up for next video----- Animation  ");
	}
	//TimeStampwaitForElementDisplayediOS(IOSHipiMwebHomePage.objiosSwipeUpForNxtVideoInSafari, 200, "Swipe foe next video animation")
		TimeStampclick(IOSHipiMwebHomePage.objiosSwipeUpForNxtVideoInSafari,  "Swipe foe next video animation");
		
		//System.out.println(getDriver().getPageSource());
	
}
public void discover_Screen_LoadTime(String userType,String TCID) throws Exception {
	
	extent.HeaderChildNode("MPWA--discover screen");
	String url = getParameterFromXML("url");
	Time_ExcelUpdate.TestCaseIDNode(TCID);
	Time_ExcelUpdate.ModuleNode("MPWA-discover screen");
	Time_ExcelUpdate.TestCaseSummaryNode1("MPWA--Check  time of navigation to discover screen ");
	getDriver().quit();
	waitTime(5000);
	new Zee5mWebiOSHipiNeoSanityBusinessLogic("safari");
	waitTime(10000);
	getDriver().quit();
	waitTime(5000);
	new Zee5mWebiOSHipiNeoSanityBusinessLogic("safari");
	waitTime(10000);
	closeSafariTabs();
	waitTime(4000);
	TimeStampclick(IOSHipiMwebHomePage.objiosmwebSearchAddress, "searchtab in safari");
	waitTime(3000);
	TimeStamptype(IOSHipiMwebHomePage.objiosmwebSearchTabInSafari, url, url+"Typing url");
	waitTime(3000);
	TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebSearchButtonInKeyboard,"search button in keyboard");
	waitTime(4000);
	TimeStampwaitForElementDisplayediOS(IOSHipiMwebHomePage.objiosSwipeUpForNxtVideoInSafari, 200, "Swipe foe next video animation");
	TimeStampclick(IOSHipiMwebHomePage.objiosSwipeUpForNxtVideoInSafari,  "Swipe foe next video animation");
			
	TimeStampclick(IOSHipiMwebHomePage.objiOSmwebDiscoverBtnInBelowTabBar, "Discover button");
	TimeStampclick(IOSHipiMwebHomePage.objiiosmwebReloadBtn,"Reload screen");
	Instant start = Instant.now();
	
	//extent.extentLogger("", "Clicked on discover at Time----- "+ start);	
	if(TimeStampwaitForElementDisplayedFastPolling(IOSHipiMwebDiscoverPage.objiosmwebSearchFieldInDiscoverPage,100,"Banner in discover")) {
		
		Instant end = Instant.now();
		//extent.extentLogger("", "Discover screen is seen  at Time----- " + end);
		Duration timeElapsed = Duration.between(start, end);
		//screencapture();
		extent.HeaderChildNode("Discover screen is seen at ----- : "+timeElapsed.getSeconds()+" Seconds");
		System.out.println("Discover screen is seen at ---- "+timeElapsed.getSeconds()+" Seconds" );
//		extent.HeaderChildNode("Discover screen is seen at ---- " + " in milliseconds : " + timeElapsed.toMillis() + " milliSeconds");
//		System.out.println("Discover screen is seen at ---- "+timeElapsed.toMillis()+" milliSeconds" );	
		String Processingtimesec=Long.toString(timeElapsed.getSeconds());
		String Processingtimemilli=Long.toString(timeElapsed.toMillis());
		int l=Processingtimemilli.length();
		String mili=Processingtimemilli.substring(l-3, l);
		
		Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+mili + "  Sec");
		waitTime(1000);
		extent.extentLogger("", "Time taken to navigate to discover screen is ----- " + Processingtimesec);
		
	}else {
		extent.extentLoggerFail("", "navigation for discover screen failed");
	}
	TimeStampclick(IOSHipiNeoHomePage.objiOSHomeBtnInBelowTabBar, "Home ");
	
	waitTime(4000);
}



public void searchResultScreen(String userType,String TCID) throws Exception {
	extent.HeaderChildNode("MPWA--Searching a keyword in Discover screen");
	Time_ExcelUpdate.TestCaseIDNode(TCID);
	Time_ExcelUpdate.ModuleNode("MPWA--discover screen search result");
	Time_ExcelUpdate.TestCaseSummaryNode1("MPWA--Check  time of Searching a keyword in Discover screen ");
	TimeStampclick(IOSHipiMwebHomePage.objiOSmwebDiscoverBtnInBelowTabBar, "Discover button");
	TimeStampclick(IOSHipiMwebHomePage.objiiosmwebReloadBtn,"Reload screen");
	waitTime(4000);
	WebElement ele=getDriver().findElement(IOSHipiMwebDiscoverPage.objiosmwebSearchFieldInDiscoverPage);
	int x=ele.getLocation().getX();
	int y=ele.getLocation().getY();
	System.out.println(x+"========="+y);
	int k=x+ 100;
	int l=y;
	
	TimeStamptapiOSAtCoOrdinates(k,l,1);
	waitTime(5000);
	TimeStamptype(IOSHipiMwebDiscoverPage.objiosmwebSearchFieldInDiscoverPage, "Mohit", "Mohit");
	waitTime(3000);
//	hideKeyboard();
//	waitTime(2500);
	
	TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebSearchButtonInKeyboard, "search");
//	keyboardaction("Enter");
	Instant start = Instant.now();
	
	//extent.extentLogger("", "typed a keyword and clicked on search button at time----- "+ start);
	
	if(TimeStampwaitForElementDisplayedFastPolling(IOSHipiMwebDiscoverPage.objiosmwebTabnameInDiscoverSearchResultsPage("Top"),50,"Top tab of searched results in discover")) {
		
		Instant end = Instant.now();
		//extent.extentLogger("", "Discover Searched result screen is seen  at Time----- " + end);
		Duration timeElapsed = Duration.between(start, end);
		screencapture();
		extent.HeaderChildNode("Discover Searched result screen is seen  at Time----- "+timeElapsed.getSeconds()+" Seconds");
		System.out.println("Discover Searched result screen is seen  at Time----- "+timeElapsed.getSeconds()+" Seconds" );
//		extent.HeaderChildNode("Discover Searched result screen is seen  at Time----- " + " in milliseconds : " + timeElapsed.toMillis() + " milliSeconds");
//		System.out.println("Discover Searched result screen is seen  at Time----- "+timeElapsed.toMillis()+" milliSeconds" );	
		
		String Processingtimesec=Long.toString(timeElapsed.getSeconds());
		String Processingtimemilli=Long.toString(timeElapsed.toMillis());
		int j=Processingtimemilli.length();
		String mili=Processingtimemilli.substring(j-3, j);
		
		Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+mili + "  Sec");
		waitTime(1000);
		extent.extentLogger("", "Time taken to for search result screen is ----- " + Processingtimesec);
		
	}else {
		extent.extentLoggerFail("", "search result screen failed");
	}
	TimeStampclick(IOSHipiMwebDiscoverPage.objmwebBackButtonInDiscoverPage, "back");
	waitTime(3000);
	TimeStampclick(IOSHipiMwebHomePage.objiOSnmwebHomeBtnInBelowTabBar, "Home ");
	waitTime(4000);
	
	
	
}

public void searchAutoSuggestionsResultScreen(String userType,String TCID) throws Exception {
	extent.HeaderChildNode("MPWA--Searching a keyword for Auto-suggestion in Discover screen");
	waitTime(4000);
	Time_ExcelUpdate.TestCaseIDNode(TCID);
	Time_ExcelUpdate.ModuleNode("MPWA--Auto-suggestion in discover screen");
	Time_ExcelUpdate.TestCaseSummaryNode1("MPWA--Check  time for  Auto-suggestion Searching a keyword in Discover screen ");
	TimeStampclick(IOSHipiMwebHomePage.objiOSmwebDiscoverBtnInBelowTabBar, "Discover button");
	TimeStampclick(IOSHipiMwebHomePage.objiiosmwebReloadBtn,"Reload screen");
	waitTime(4000);
	WebElement ele=getDriver().findElement(IOSHipiMwebDiscoverPage.objiosmwebSearchFieldInDiscoverPage);
	int x=ele.getLocation().getX();
	int y=ele.getLocation().getY();
	System.out.println(x+"========="+y);
	int k=x+ 100;
	int l=y;
	
	TimeStamptapiOSAtCoOrdinates(k,l,1);
	waitTime(5000);
	TimeStamptype(IOSHipiMwebDiscoverPage.objiosmwebSearchFieldInDiscoverPage, "Moh", "Moh");
	
	Instant start = Instant.now();
	
	//extent.extentLogger("", "typed a keyword in search field at time----- "+ start);
	
	if(	TimeStampwaitForElementDisplayedFastPolling(IOSHipiMwebDiscoverPage.objiosmwebAutoSuggestionsInSearchParentPage(1),50,"Auto suggestion when typed some keyword")) {
		
		Instant end = Instant.now();
		
		Duration timeElapsed = Duration.between(start, end);
		screencapture();
		extent.HeaderChildNode("Auto suggestion is seen  at Time----- "+timeElapsed.getSeconds()+" Seconds");
		System.out.println("Auto suggestion is seen  at Time----- "+timeElapsed.getSeconds()+" Seconds" );
	
		
		
		String Processingtimesec=Long.toString(timeElapsed.getSeconds());
		String Processingtimemilli=Long.toString(timeElapsed.toMillis());
		int j=Processingtimemilli.length();
		String mili=Processingtimemilli.substring(j-3, j);
		
		Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+mili + "  Sec");
		waitTime(1000);
		extent.extentLogger("", "Time taken to for  Auto-suggestion search result screen is ----- " + Processingtimesec);
		
	}else {
		extent.extentLoggerFail("", " Auto-suggestion search result screen failed");
	}
	TimeStamphideKeyboard();
	waitTime(4000);
	TimeStampclick(IOSHipiMwebHomePage.objiiosmwebReloadBtn,"Reload screen");
	waitTime(4000);
	TimeStampclick(IOSHipiMwebDiscoverPage.objmwebBackButtonInDiscoverPage, "back");
	waitTime(3000);
	TimeStampclick(IOSHipiMwebHomePage.objiOSnmwebHomeBtnInBelowTabBar, "Home ");
	
	
}


public void NavigationToAppFromCreateButton(String userType,String TCID) throws Exception {
	extent.HeaderChildNode("MPWA--User is navigate to App when click on Creator: with App");
	waitTime(4000);
	Time_ExcelUpdate.TestCaseIDNode(TCID);
	Time_ExcelUpdate.ModuleNode("MPWA--Nagigation to App");
	Time_ExcelUpdate.TestCaseSummaryNode1("MPWA-User is navigate to App when click on Creator: with App ");
	
	TimeStampclick(IOSHipiMwebHomePage.objiOSmwebCreateBtnInBelowTabBar, "create button");
	waitTime(5000);
	if(!TimeStampwaitForElementDisplayediOS(IOSHipiMwebHomePage.objiOSmwebOpenHipiAppBtnInBelowTabBar,10,"Open the Hipi app")) {
		TimeStampclick(IOSHipiMwebHomePage.objiOSmwebCreateBtnInBelowTabBar, "create button");
		waitTime(5000);
	}
	
	TimeStampclick(IOSHipiMwebHomePage.objiOSmwebOpenHipiAppBtnInBelowTabBar,"Open the Hipi app");
	
	Instant start = Instant.now();
	
	if(	TimeStampwaitForElementDisplayedFastPolling(IOSHipiMwebHomePage.objiOSmwebHomeBtnInBelowTabBar,25,"App navigation")){
		Instant end = Instant.now();
		
		Duration timeElapsed = Duration.between(start, end);
		screencapture();
		extent.HeaderChildNode("App navigation is seen  at Time----- "+timeElapsed.getSeconds()+" Seconds");
		System.out.println("App navigation is seen  at Time----- "+timeElapsed.getSeconds()+" Seconds" );
	
		
		
		String Processingtimesec=Long.toString(timeElapsed.getSeconds());
		String Processingtimemilli=Long.toString(timeElapsed.toMillis());
		int j=Processingtimemilli.length();
		String mili=Processingtimemilli.substring(j-3, j);
		
		Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+mili + "  Sec");
		waitTime(1000);
		extent.extentLogger("", "Time taken to for  App navigation after clicking on create is ----- " + Processingtimesec);
		
	}else {
		extent.extentLoggerFail("", "App navigation after clicking on create is failed");
	}
}

public void NavigationToAppStoreFromCreateButton(String userType,String TCID) throws Exception {
	extent.HeaderChildNode("MPWA--User is navigate to Play Store when click on Creator:with out App");
	
	String url = getParameterFromXML("url");
	waitTime(4000);
	try {
	getDriver().removeApp("com.zee5.hipi", null);
	System.out.println("App uninstalled");
} catch (Exception e) {
	System.out.println("App not present");
	
}
	waitTime(4000);
	new Zee5mWebiOSHipiNeoSanityBusinessLogic("safari");
	waitTime(10000);
	closeSafariTabs();
	waitTime(4000);
	TimeStampclick(IOSHipiMwebHomePage.objiosmwebSearchAddress, "searchtab in safari");
	waitTime(3000);
	TimeStamptype(IOSHipiMwebHomePage.objiosmwebSearchTabInSafari, url, url+"Typing url");
	waitTime(3000);
	TimeStampclick(IOSHipiMwebDiscoverPage.objiosmwebSearchButtonInKeyboard,"search button in keyboard");
	
	TimeStampwaitForElementDisplayedFastPolling(IOSHipiMwebHomePage.objiOSmwebDiscoverBtnInBelowTabBar, 50, "Explore tab");
	waitTime(4000);
	Time_ExcelUpdate.TestCaseIDNode(TCID);
	Time_ExcelUpdate.ModuleNode("MPWA--Nagigation to App Store");
	Time_ExcelUpdate.TestCaseSummaryNode1("MPWA-User is navigate to Play Store when click on Creator: with out App");
	
	TimeStampclick(IOSHipiMwebHomePage.objiOSmwebCreateBtnInBelowTabBar, "create button");
	waitTime(2000);
	if(!TimeStampwaitForElementDisplayediOS(IOSHipiMwebHomePage.objiOSmwebOpenHipiAppBtnInBelowTabBar,10,"Open the Hipi app")) {
		TimeStampclick(IOSHipiMwebHomePage.objiOSmwebCreateBtnInBelowTabBar, "create button");
		waitTime(5000);
	}
	TimeStampclick(IOSHipiMwebHomePage.objiOSmwebOpenHipiAppBtnInBelowTabBar,"Open the Hipi app");
	
	Instant start = Instant.now();
	
	if(	TimeStampwaitForElementDisplayedFastPolling(IOSHipiMwebHomePage.objiOSmwebDownloadBtnInAppStore,100,"Download button")){
		Instant end = Instant.now();
		
		Duration timeElapsed = Duration.between(start, end);
		screencapture();
		extent.HeaderChildNode("App navigation is seen  at Time----- "+timeElapsed.getSeconds()+" Seconds");
		System.out.println("App navigation is seen  at Time----- "+timeElapsed.getSeconds()+" Seconds" );
	
		
		
		String Processingtimesec=Long.toString(timeElapsed.getSeconds());
		String Processingtimemilli=Long.toString(timeElapsed.toMillis());
		int j=Processingtimemilli.length();
		String mili=Processingtimemilli.substring(j-3, j);
		
		Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+mili + "  Sec");
		waitTime(1000);
		extent.extentLogger("", "Time taken to for  App navigation after clicking on create is ----- " + Processingtimesec);
		
	}else {
		extent.extentLoggerFail("", "App navigation after clicking on create is failed");
	}
}



	/**
	 * Function to quit the driver
	 */
	@SuppressWarnings("unused")
	public void tearDown() {
		getDriver().quit();

//		String pUserType = getParameterFromXML("userType");
//		
//		String NonsubscribedUserName = getParameterFromXML("NonsubscribedUserName");
//		String NonsubscribedPassword = getParameterFromXML("NonsubscribedPassword");
		

	}

}
