package com.business.zee;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.deviceDetails.DeviceDetails;
import com.driverInstance.DriverInstance;
import com.emailReport.GmailInbox;
import com.excel.Time_ExcelUpdate;
import com.extent.ExtentReporter;
import com.hipi.AndroidMPWAPages.MPWADiscoverPage;
import com.hipi.AndroidMPWAPages.MPWAHomePage;
import com.hipi.AndroidMPWAPages.MPWALoginPage;
import com.hipi.AndroidMPWAPages.MPWAProfilePage;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;
import com.zee5.AndroidHipiPages.HipiDiscoverPage;
import com.zee5.AndroidHipiPages.HipiHashtagDetailPage;
import com.zee5.AndroidHipiPages.HipiLoginPage;
import com.zee5.AndroidHipiPages.HipiProfilePage;
import com.zee5.AndroidHipiPages.HipiSettingsPage;
import com.zee5.AndroidHipiPages.HipiShopPage;
import com.zee5.Applicaster.HIPI.AMDHomePage;
import com.zee5.Applicaster.HIPI.AMDLoginScreen;
import com.zee5.Applicaster.HIPI.HipiHomePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

public class AndroidHipiMPWABusinessLogic extends Utilities {
	 
	public AndroidHipiMPWABusinessLogic(String Application) {
		new DriverInstance(Application);
		init();
	}
		public SoftAssert softAssert = new SoftAssert();
		private int timeout;

		/** Retry Count */
		private int retryCount;
		ExtentReporter extent = new ExtentReporter();

		/** The Constant logger. */
		// final static Logger logger = Logger.getLogger("rootLogger");
		static LoggingUtils logger = new LoggingUtils();

		/** The Android driver. */
		public AndroidDriver<AndroidElement> androidDriver ;
		
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
		
		public com.business.zee.Zee5ApplicasterHipiNeoBusinessLogic Zee5ApplicasterHipiNeoBusinessLogic;

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
			new com.business.zee.Zee5ApplicasterHipiNeoBusinessLogic("chrome");
			waitUntilElementDisplayed(MPWAHomePage.objForYou, 10);	
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
	
	public void Discover() throws Exception {
		
		extent.HeaderChildNode("Discover");

		System.out.println("Start Discover");
		waitTime(3000);
		Swipe("UP", 1);
		waitTime(4000);
		verifyElementPresentAndClick(MPWAHomePage.objDiscoverButton, "Discover Button");
		waitTime(4000);
		verifyElementPresentAndClick(MPWADiscoverPage.objSearchTab, "Search Tab");
		waitTime(3000);
		type(MPWADiscoverPage.objSearchTab, "shivangi", "Send text ");
		
	}
	public void SearchRelatedTcs(String userName,String TCsNumber) throws Exception {
		Time_ExcelUpdate.TestCaseIDNode(TCsNumber);
		Time_ExcelUpdate.ModuleNode("Discover");
		Time_ExcelUpdate.TestCaseSummaryNode1("Top 5 Suggestion Results");
		extent.HeaderChildNode("Top 5 Suggestion Results");
		waitTime(3000);
		TimeStampverifyElementPresentAndClick(MPWAHomePage.objDiscoverButton, "Discover Button");
		waitTime(5000);
		TimeStampverifyElementPresentAndClick(MPWADiscoverPage.objSearchTab, "Search Tab");
		waitTime(3000);
		TimeStamptype(MPWADiscoverPage.objSearchTab, userName, "Type value");
//		TimeStampclick(MPWADiscoverPage.objSearchTab, "Search Tab");
//		TimeStamptype(MPWADiscoverPage.objSearchTab, " ", "Type value");

		waitTime(5000);
	  	boolean Listresults = verifyIsElementDisplayed(MPWADiscoverPage.objListOfSearchResult);
//	  	extent.extentLoggerPass("", "");
		extent.extentLoggerPass("", "");
		if (Listresults) {
			int ListofsearchResults = getDriver().findElements(MPWADiscoverPage.objListOfSearchResult).size();
			if (ListofsearchResults == 0) {
				extent.extentLoggerFail("MPWA - Verify share options", "MPWA - Share Options are not available");
				logger.info("Share Options are not available");
			} else {
				for (int i = 1; i <= ListofsearchResults; i++) {
					String TotalsearchResults = getText(MPWADiscoverPage.objsearchResults(i));
					logger.info("List of Search results: \"" + TotalsearchResults + "\"");
					
					Time_ExcelUpdate.TestCaseSummaryNode1(TotalsearchResults);
					extent.extentLoggerPass("List of Search results ",
							"List of Search results : \"" + TotalsearchResults + "\"");

				}
			}
		} else {
			logger.info("List of Search results  are not displayed after clicking on Search button");
//			extent.extentLoggerFail("Share through options screen",
//					"Share Options are not displayed after clicking on Share CTA");
		}
		
		Time_ExcelUpdate.TestCaseIDNode("TC028");
		Time_ExcelUpdate.ModuleNode("Discover");
		Time_ExcelUpdate.TestCaseSummaryNode1("Top Users Pofile");
		extent.HeaderChildNode("Top Users Pofile");
		
		TimeStampclick(MPWADiscoverPage.objSearchResult, "Search result");
		waitTime(3000);
//		
		boolean Profileresults = verifyIsElementDisplayed(MPWADiscoverPage.objListOfSearchUserProfiles);
//	  	extent.extentLoggerPass("", "");
		extent.extentLoggerPass("", "");
		if (Profileresults) {
			int ListofProfileresults = getDriver().findElements(MPWADiscoverPage.objListOfSearchUserProfiles).size();
			if (ListofProfileresults == 0) {
				extent.extentLoggerPass("", "");
				logger.info("");
			} else {
				for (int i = 1; i <= ListofProfileresults; i++) {
					String TotalListofProfileresults = getText(MPWADiscoverPage.objListFirstuserProfile(i));
					logger.info("Top Users Pofile: \"" + TotalListofProfileresults + "\" is available ");
					
					Time_ExcelUpdate.TestCaseSummaryNode1(TotalListofProfileresults);
					extent.extentLoggerPass("Top Users Pofile ",
							"Top Users Pofile : \"" + TotalListofProfileresults + "\" is available");
				}
			}
		} else {
			logger.info("Top Users Pofile are not displayed ");
		}
//		
//		Time_ExcelUpdate.ModuleNode("Discover");
//		Time_ExcelUpdate.TestCaseSummaryNode1("List of Videos");
//		extent.HeaderChildNode("List of Videos");
//		PartialSwipe("UP", 1);
//		boolean Videothumbnail = verifyIsElementDisplayed(HipiDiscoverPage.objVideosInVideosTab);
////		extent.extentLoggerPass("", "");
//		if (Videothumbnail) {
//			int listofVideothumbnail = getDriver().findElements(HipiDiscoverPage.objVideosInVideosTab).size();
//			if (listofVideothumbnail == 0) {
////				extent.extentLoggerFail("", "");
//				
//				logger.info("");
//			} else {
//				for (int i = 1; i <= listofVideothumbnail; i++) {																			
//					String totallistofVideothumbnail = getText(HipiDiscoverPage.objListOfVideos(i));
//					logger.info("llist Of video User Name " + totallistofVideothumbnail + "\" is available ");
//					
//					Time_ExcelUpdate.TestCaseSummaryNode1(totallistofVideothumbnail);
//					extent.extentLoggerPass("llist Of video User Name ",
//							"llist Of video User Name : \"" + totallistofVideothumbnail + "\" is available");
//
//				}
//			}
//		} else {
//			logger.info("llist Of video User Name are not displayed after clicking on Search result CTA");
//		}
//		
//		
//		
////		Time_ExcelUpdate.TestCaseIDNode("TC029");
//		Time_ExcelUpdate.ModuleNode("Discover");
//		Time_ExcelUpdate.TestCaseSummaryNode1("List of Hashhtags");
//		extent.HeaderChildNode("List of Hashhtags");
//		
//		boolean Hashhtagsresults = verifyIsElementDisplayed(HipiDiscoverPage.objHashhtags);
//		extent.extentLoggerPass("", "");
////		extent.extentLoggerPass("", "");
//		if (Hashhtagsresults) {
//		int HashhtagsearchResult = getDriver().findElements(HipiDiscoverPage.objHashhtags).size();
//		if (HashhtagsearchResult == 0) {
//			extent.extentLoggerFail("", "");
//			logger.info("");
//		} else {
//			for (int i = 1; i <= HashhtagsearchResult; i++) {
//				String listHashhtagsearchResult = getText(HipiDiscoverPage.objListOfHashhtags(i));
//				logger.info("List of Hashhtags : \"" + listHashhtagsearchResult + "\" is available ");
//				
//				Time_ExcelUpdate.TestCaseSummaryNode1(listHashhtagsearchResult);
//				extent.extentLoggerPass("List of Hashhtags ",
//						"List of Hashhtags : \"" + listHashhtagsearchResult + "\" is available ");
//
//			}
//		}
//	} else {
//		logger.info("List of Hashhtags are not displayed after clicking on Hashhtags CTA");
//	}
//		Time_ExcelUpdate.ModuleNode("Discover");
//		Time_ExcelUpdate.TestCaseSummaryNode1("List of Sounds");
//		extent.HeaderChildNode("List of Sounds");
//		waitTime(4000);
//		TimeStampSwipe("UP", 2);
//		if (TimeStampverifyElementExist(HipiDiscoverPage.objFirstSongInSoundTab, "Sound names")) {
//			boolean SoundNamesTopTab = verifyIsElementDisplayed(HipiDiscoverPage.objFirstSongInSoundTab);
//			extent.extentLoggerPass("", "" );
//			if (SoundNamesTopTab) {
//				int listOfSoundNameTopTab = getDriver().findElements(HipiDiscoverPage.objFirstSongInSoundTab).size();
//				if (listOfSoundNameTopTab == 0) {
////					extent.extentLoggerPass("", "");
//					logger.info("");
//				} else {
//					for (int i = 1; i <= listOfSoundNameTopTab; i++) {																			
//						String TotallistOfSoundNameTopTab = getText(HipiDiscoverPage.objListofFirstSongInSoundTab(i));
//						logger.info("llist Of Sound Name" + TotallistOfSoundNameTopTab + "\" is available ");
//						
//						Time_ExcelUpdate.TestCaseSummaryNode1(TotallistOfSoundNameTopTab);
//						extent.extentLoggerPass("llist Of Sound Name",
//								"llist Of Sound Name" + TotallistOfSoundNameTopTab + "\" is available");
//					}
//				}
//			} else {
//				logger.info("Sound are not displayed after clicking on Sound CTA");
//			}
//		}else {
//			logger.info("Sound are not displayed after clicking on Sound CTA");
//		}
//		
//		
//		
//
////		Time_ExcelUpdate.TestCaseIDNode("TC030");
//		Time_ExcelUpdate.ModuleNode("Discover");
//		Time_ExcelUpdate.TestCaseSummaryNode1("Users Tab Results");
//		extent.HeaderChildNode("Users Tab Results");
//		
//		TimeStampclick(HipiDiscoverPage.objUserTab, "User Tab");
//		waitTime(3000);
//		
//		boolean UserTabresults = verifyIsElementDisplayed(HipiDiscoverPage.objListOfSearchUserProfiles);
////		extent.extentLoggerPass("", "");
//	extent.extentLoggerPass("", "");
//	if (UserTabresults) {
//		int UserTabSearchresults = getDriver().findElements(HipiDiscoverPage.objListOfSearchUserProfiles).size();
//		if (UserTabSearchresults == 0) {
//			extent.extentLoggerFail("", "");
//			logger.info("");
//		} else {
//			for (int i = 1; i <= 2; i++) {																			
//				String listofUserTabSearchresults = getText(HipiDiscoverPage.objListFirstuserProfile(i));
//				logger.info("Users Tab Results : \"" + listofUserTabSearchresults + "\" is available ");
//				
//				Time_ExcelUpdate.TestCaseSummaryNode1(listofUserTabSearchresults);
//				extent.extentLoggerPass("Users Tab Results ",
//						"Users Tab Results : \"" + listofUserTabSearchresults + "\" is available");
//
//			}
//		}
//	} else {
//		logger.info("Users Tab Results  are not displayed after clicking on User CTA");
//	}
////		Time_ExcelUpdate.TestCaseIDNode("TC031");
//		Time_ExcelUpdate.ModuleNode("Discover");
//		Time_ExcelUpdate.TestCaseSummaryNode1("Videos Tab");
//		extent.HeaderChildNode("Videos Tab");
//		TimeStampclick(HipiDiscoverPage.objVideoTab, "Video Tab");
//		waitTime(3000);
//		extent.extentLoggerPass("", "");
////		extent.extentLoggerFail("", "");
//		TimeStampverifyElementExist(HipiDiscoverPage.objrelatedvioedosSound,"");
//		List<WebElement> listOfCountrys = getDriver().findElements(HipiDiscoverPage.objrelatedvioedosSound);
//		int size = listOfCountrys.size();
//		System.out.println(size);
//		logger.info("Numbers of  " + size);	
//		Time_ExcelUpdate.TestCaseSummaryNode1("Numbers of " + size);
//		boolean UserNames = verifyIsElementDisplayed(HipiDiscoverPage.objVideosInVideosTab);
//		extent.extentLoggerPass("", "Numbers of " + size);
//		if (UserNames) {
//			int listOfUserName = getDriver().findElements(HipiDiscoverPage.objVideosInVideosTab).size();
//			if (listOfUserName == 0) {
////				extent.extentLoggerFail("", "");
//				
//				logger.info("");
//			} else {
//				for (int i = 1; i <= listOfUserName; i++) {																			
//					String TotallistOfUserName = getText(HipiDiscoverPage.objListOfVideos(i));
//					logger.info("llist Of video User Name" + TotallistOfUserName + "\" is available ");
//					
//					Time_ExcelUpdate.TestCaseSummaryNode1(TotallistOfUserName);
//					extent.extentLoggerPass("llist Of video User Name",
//							"llist Of video User Name : \"" + TotallistOfUserName + "\" is available");
//
//				}
//			}
//		} else {
//			logger.info("llist Of video User Name are not displayed after clicking on Video CTA");
//		}
//		
////		Time_ExcelUpdate.TestCaseIDNode("TC032");
//		Time_ExcelUpdate.ModuleNode("Discover");
//		Time_ExcelUpdate.TestCaseSummaryNode1("Sounds Tab");
//		extent.HeaderChildNode("Sounds Tab");
//		TimeStampclick(HipiDiscoverPage.objSoundtabinSearchresultpage, "Sound Tab");
//		if (TimeStampverifyElementExist(HipiDiscoverPage.objFirstSongInSoundTab, "Sound names")) {
//			boolean SoundNames = verifyIsElementDisplayed(HipiDiscoverPage.objFirstSongInSoundTab);
//			extent.extentLoggerPass("", "Numbers of " + size);
//			if (SoundNames) {
//				int listOfSoundName = getDriver().findElements(HipiDiscoverPage.objFirstSongInSoundTab).size();
//				if (listOfSoundName == 0) {
//					extent.extentLoggerPass("", "");
//					logger.info("");
//				} else {
//					for (int i = 1; i <= listOfSoundName; i++) {																			
//						String TotallistOfSoundName = getText(HipiDiscoverPage.objListofFirstSongInSoundTab(i));
//						logger.info("llist Of Sound Name" + TotallistOfSoundName + "\" is available ");
//						
//						Time_ExcelUpdate.TestCaseSummaryNode1(TotallistOfSoundName);
//						extent.extentLoggerPass("llist Of Sound Name",
//								"llist Of Sound Name" + TotallistOfSoundName + "\" is available");
//					}
//				}
//			} else {
//				logger.info("Sound are not displayed after clicking on Sound CTA");
//			}
//		}else {
//			logger.info("Sound are not displayed after clicking on Sound CTA");
//		}
//		
////		Time_ExcelUpdate.TestCaseIDNode("TC032");
//		Time_ExcelUpdate.ModuleNode("Discover");
//		Time_ExcelUpdate.TestCaseSummaryNode1("Hashtags Tab");
//		extent.HeaderChildNode("Hashtags Tab");
//		TimeStampclick(HipiDiscoverPage.objHashtagsTab, "Hashtags Tab");
//		
//		if (TimeStampverifyElementExist(HipiDiscoverPage.objFirstHashtagsInSoundTab, "Hashtags names")) {
//			boolean HashtagsNames = verifyIsElementDisplayed(HipiDiscoverPage.objFirstHashtagsInSoundTab);
//			extent.extentLoggerPass("", "Numbers of " + size);
//			if (HashtagsNames) {
//				int listOfHashtagsName = getDriver().findElements(HipiDiscoverPage.objFirstHashtagsInSoundTab).size();
//				if (listOfHashtagsName == 0) {
//					extent.extentLoggerPass("", "");
//					logger.info("");
//				} else {
//					for (int i = 1; i <= listOfHashtagsName; i++) {																			
//						String TotallistOfHashtagsName = getText(HipiDiscoverPage.objListofFirstHashtagsInSoundTab(i));
//						logger.info("llist Of Sound Name" + TotallistOfHashtagsName + "\" is available ");
//						
//						Time_ExcelUpdate.TestCaseSummaryNode1(TotallistOfHashtagsName);
//						extent.extentLoggerPass("llist Of Sound Name",
//								"llist Of Sound Name" + TotallistOfHashtagsName + "\" is available");
//					}
//				}
//			} else {
//				logger.info("Sound are not displayed after clicking on Sound CTA");
//			}
//		}else {
//			logger.info("Sound are not displayed after clicking on Sound CTA");
//		}
//		
//		TimeStampnavigateToHomePage();
//		
	}
	
	
	
	public void loginTime(String userType) throws Exception {
		
		// navigateToIntroScreen_DisplaylangScreen();
					Time_ExcelUpdate.TestCaseIDNode("MPWA TC005");
//					Time_ExcelUpdate.SlNoNode("2");
					Time_ExcelUpdate.ModuleNode("Login Module");
					Time_ExcelUpdate.TestCaseSummaryNode1("Login Time");
					Time_ExcelUpdate.ExpectedProcessingTime("7.5 Sec");

					extent.HeaderChildNode("Launching hipi ");
//					extent.HeaderChildNode("NonSubscribed User");
					
					TimeStampSwipe("UP", 1);
					
					waitUntilElementDisplayed(MPWAHomePage.objProfileIcon, 10);
					//click on Profile icon
					TimeStampverifyElementPresentAndClick(MPWAHomePage.objProfileIcon, "Profile Icon");
					waitTime(5000);
					if (TimeStampverifyElementExist(MPWAProfilePage.objThreeDots, "Three Dots")) {
						TimeStampverifyElementPresentAndClick(MPWAProfilePage.objThreeDots, "Three Dots");
						waitTime(3000);
						//			SwipeUntilFindElement(HipiSettingsPage.objLogOut, "Log out Button");
						//			TimeStampSwipe("UP", 2);
						TimeStampverifyElementPresentAndClick(MPWAProfilePage.objLogOut, "Log out");
						TimeStampverifyElementPresentAndClick(MPWAProfilePage.objYesCTA, "Yes CTA");
						waitTime(4000);
						TimeStampverifyElementPresentAndClick(MPWAHomePage.objProfileIcon, "Profile Icon");
					}
					waitTime(5000);
					TimeStampverifyElementPresentAndClick(MPWALoginPage.objUsePhoneOrEmail,"Use Phone Or Email");
					
					String Username = getParameterFromXML("NonsubscribedUserName");
					String Password = getParameterFromXML("NonsubscribedPassword");
					
					waitTime(5000);
//					hideKeyboard();
//					TimeStampverifyElementPresentAndClick(MPWALoginPage.objEmailOption, "Email Option");
//					waitTime(4000);
//					TimeStampclick(MPWALoginPage.objEmailIdField, "Email Field");
//					waitTime(4000);
					TimeStampverifyElementPresentAndClick(MPWALoginPage.objEmailIdField, "Email Field");
					waitTime(4000);
					
					TimeStamptype(MPWALoginPage.objEmailIdField, Username, "Email Field");
					TimeStamphideKeyboard();
					TimeStampverifyElementPresentAndClick(MPWALoginPage.objProceed, "Proceed Button");
					waitUntilElementDisplayed(MPWALoginPage.objLoginWithPassword, 2);
					TimeStampverifyElementPresentAndClick(MPWALoginPage.objLoginWithPassword, "Login With Password");
					
					TimeStampverifyElementPresentAndClick(MPWALoginPage.objPasswordField, "Password Field");
//					hideKeyboard();

					TimeStamptype(MPWALoginPage.objPasswordField, Password, "Password field");
//					
					TimeStamphideKeyboard();
					waitTime(5000);
					TimeStampverifyElementPresentAndClick(MPWALoginPage.objLoginBtn, "Login Button");
//					TimeStamptype(MPWALoginPage.objEmailIdField, Username, "Email Field");
//					TimeStamphideKeyboard();
//					TimeStampverifyElementPresentAndClick(MPWALoginPage.objLoginBtn, "Login Button");
					Instant start=Instant.now();
					logger.info("Start Time : " + start);
//					extent.extentLogger("", "<b>Start Time : " + start+"<b>");
				if (waitUntilElementDisplayed(MPWAHomePage.objForYou, 2)) {
						logger.info("User is able to see Home screen");
//						extent.extentLogger("", "User is able to see Home screen");
						Instant end=Instant.now();
						logger.info("End Time : " + end);
//						extent.extentLogger("", "<b>End Time : " + end+"<b>");
						Duration processingTime = Duration.between(start, end);
						logger.info("Processing time: " + processingTime);
						String Processingtimesec=Long.toString(processingTime.getSeconds());
						String Processingtimemilli=Long.toString(processingTime.toMillis());	
						Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
						extent.extentLogger("", "<b>Processing time: " + processingTime+"<b>");

//						extent.HeaderChildNode("<b>Processing time: " + processingTime+"<b>");
					}
					else {
						logger.error("Processing time calculation failed");
						Time_ExcelUpdate.timeStampNode("Processing time calculation failed");
						extent.extentLoggerFail("", "MPWA - Processing time calculation failed");
						
					}
				
				TimeStampnavigateToHomePage();
//					waitUntilElementDisplayed(HipiHomePage.objForYou, 2000);
					//click on feed button
				TimeStampverifyElementPresentAndClick(MPWAHomePage.objHomeIcon, "Home Icon");
					
	}
		public void DiscoverScreenLoadTime() throws Exception {
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC006");
//			Time_ExcelUpdate.SlNoNode("4");
			Time_ExcelUpdate.ModuleNode("MPWA - Discover");
			Time_ExcelUpdate.ExpectedProcessingTime("2.5 Sec");
			TimeStampSwipe("UP", 1);
			Time_ExcelUpdate.TestCaseSummaryNode1("Discover screen load time");
			extent.HeaderChildNode("MPWA - Discover screen load time");
			waitUntilElementDisplayed(MPWAHomePage.objDiscoverButton, 5);
			TimeStampverifyElementPresentAndClick(MPWAHomePage.objDiscoverButton, "Discover Button");
			Instant start=Instant.now();
			logger.info("Start Time : " + start);
//			extent.extentLogger("", "<b>Start Time : " + getDateDetails(startTime)+"<b>");
			if(waitUntilElementDisplayed(MPWADiscoverPage.objFirstProfileName, 10)) {
			Instant end=Instant.now();
			logger.info("End Time : " + end);
//			extent.extentLogger("", "<b>End Time : " + end+"<b>");
			Duration processingTime = Duration.between(start, end);
			logger.info("Processing time: " + processingTime);
			String Processingtimesec=Long.toString(processingTime.getSeconds());
			String Processingtimemilli=Long.toString(processingTime.toMillis());	
			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
			extent.extentLogger("", "<b>Processing time: " + processingTime+"<b>");
		
			extent.HeaderChildNode("<b>Discover screen Processing time: " + processingTime+"<b>");
			}else {
				Time_ExcelUpdate.timeStampNode("MPWA - Discover screen is not displayed");
				extent.extentLoggerFail("", "MPWA - Discover screen is not displayed");	
			}
			TimeStampnavigateToHomePage();
//			TimeStampBack(1);
//			waitTime(5000);
			
		}
		
		public void	AutoSuggestionTime(String userName) throws Exception {
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC007");
//			Time_ExcelUpdate.SlNoNode("4");
			Time_ExcelUpdate.ModuleNode("MPWA - Discover");
			Time_ExcelUpdate.ExpectedProcessingTime("2 Sec");

			Time_ExcelUpdate.TestCaseSummaryNode1("Auto suggestion time.");
			extent.HeaderChildNode("MPWA - Auto suggestion time.");
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objDiscoverButton, 5);
			TimeStampverifyElementPresentAndClick(MPWAHomePage.objDiscoverButton, "Discover Button");
			waitUntilElementDisplayed(MPWADiscoverPage.objBannersBelowTheSearchField, 5);
			TimeStampverifyElementPresentAndClick(MPWADiscoverPage.objSearchTab, "Send text ");
			waitTime(4000);
			TimeStamptype(MPWADiscoverPage.objSearchTab, userName, "Type value");
			Instant start=Instant.now();
			logger.info("Start Time : " + start);
//			Date startTime = new Date();
//			logger.info("Start Time : " + getDateDetails(startTime));
//			extent.extentLogger("", "<b>Start Time : " + getDateDetails(startTime)+"<b>");
			if(waitUntilElementDisplayed(MPWADiscoverPage.objListOfSearchResult, 10)) {
			Instant end=Instant.now();
			logger.info("End Time : " + end);
//			extent.extentLogger("", "<b>End Time : " + end+"<b>");
			Duration processingTime = Duration.between(start, end);
			logger.info("Processing time: " + processingTime);
			String Processingtimesec=Long.toString(processingTime.getSeconds());
			String Processingtimemilli=Long.toString(processingTime.toMillis());	
			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
//			extent.extentLogger("", "<b>Processing time: " + processingTime+"<b>");
			extent.extentLogger("", "<b> MPWA -  Auto suggestion Processing time: " + processingTime+"<b>");
//			extent.HeaderChildNode("<b> Auto suggestion Processing time: " + processingTime+"<b>");
			}else {
				Time_ExcelUpdate.timeStampNode("MPWA - Auto suggestion result is not displayed");
				extent.extentLoggerFail("", "MPWA - Auto suggestion result is not displayed");
			}
			TimeStampnavigateToHomePage();
//			TimeStampBack(1);
//			waitTime(5000);
		}
		
		public void TimeStampnavigateToHomePage() throws Exception {
			boolean flag;
			for (int i = 1; i < 10; i++) {
				flag = verifyElementDisplayed(MPWAHomePage.objForYou);
				
				//For You is display its store in T
				////For You is NOT display its store in F
//				Back(1);
				System.out.println(flag);
				if (flag) {
//					if (verifyElementDisplayed(HipiShopPage.objSavedMomentTab)) {
//						TimeStampBack(1);
//					}
					waitTime(4000);
					break;
				} else {
					TimeStampBack(1);
					TimeStampSwipe("DOWN", 1);
					waitTime(5000);
				}
			}
//			click(HipiHomePage.objHomeIcon, "Home Icon");
			if(TimeStampverifyElementExist(HipiHomePage.objEngleshButton, "Englesh Icon")) {
				System.out.println("User is able to see Englesh Icon");
				TimeStampclick(HipiHomePage.objEngleshButton, "Englesh Icon");
				TimeStampclick(HipiHomePage.objCrossIcon, "Cross Icon");
			}else {
				
				System.out.println("User is not able to see Englesh Icon");
				
			}
			waitTime(4000);
		}
		
		
		public void OnClickingBannerScreenLoadTime(String userType) throws Exception {
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC008");
			Time_ExcelUpdate.ModuleNode("MPWA - Discover");
			Time_ExcelUpdate.ExpectedProcessingTime("2.5 Sec");

			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - On clicking Banner, screen load time.");
			extent.HeaderChildNode("MPWA - On clicking Banner, screen load time.");
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objDiscoverButton, 5);
			TimeStampverifyElementPresentAndClick(MPWAHomePage.objDiscoverButton, "Discover Button");
//			waitTime(5000);
			waitUntilElementDisplayed(MPWADiscoverPage.objBannersBelowTheSearchField, 5);
			waitTime(5000);
			TimeStampverifyElementPresentAndClick(MPWADiscoverPage.objBannersBelowTheSearchField, "Video Banner");
			
			Instant start=Instant.now();
			logger.info("Start Time : " + start);
//			Date startTime = new Date();
//			logger.info("Start Time : " + getDateDetails(startTime));
//			extent.extentLogger("", "<b>Start Time : " + getDateDetails(startTime)+"<b>");
			if(waitUntilElementDisplayed(MPWADiscoverPage.objBannerHeader, 20)) {
			Instant end=Instant.now();
			logger.info("End Time : " + end);
//			extent.extentLogger("", "<b>End Time : " + end+"<b>");
			Duration processingTime = Duration.between(start, end);
			logger.info("Processing time: " + processingTime);
			String Processingtimesec=Long.toString(processingTime.getSeconds());
			String Processingtimemilli=Long.toString(processingTime.toMillis());	
			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
			extent.extentLogger("", "<b> MPWA - Processing time: " + processingTime+"<b>");
//			extent.HeaderChildNode("<b>Banner screen Processing time: " + processingTime+"<b>");
//			TimeStampBack(1);
//			waitTime(5000);
//			TimeStampBack(1);
//			waitTime(5000);
			}else {
				Time_ExcelUpdate.timeStampNode("MPWA - On clicking Banner, screen load time is not displayed");
				extent.extentLoggerFail("", "MPWA - On clicking Banner, screen load time is not displayed");
			}
			TimeStampnavigateToHomePage();
		}
		
		public void hashtagDetailPageTime() throws Exception {
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC009");
			Time_ExcelUpdate.ModuleNode("MPWA - Discover");
			Time_ExcelUpdate.ExpectedProcessingTime("2.5 Sec");

			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - hashtag detail page time.");
			extent.HeaderChildNode("MPWA - hashtag detail page time.");
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objDiscoverButton, 5);
			TimeStampverifyElementPresentAndClick(MPWAHomePage.objDiscoverButton, "Discover Button");
			waitUntilElementDisplayed(MPWADiscoverPage.objBannersBelowTheSearchField, 5);
			TimeStampclick(MPWADiscoverPage.objMoreButtonTrendingOnHipi, "More Button");
			Instant start=Instant.now();
			logger.info("Start Time : " + start);
//			Date startTime = new Date();
//			logger.info("Start Time : " + getDateDetails(startTime));
//			extent.extentLogger("", "<b>Start Time : " + getDateDetails(startTime)+"<b>");
			if(waitUntilElementDisplayed(MPWADiscoverPage.objBannerHeader, 10)) {
			Instant end=Instant.now();
			logger.info("End Time : " + end);
//			extent.extentLogger("", "<b>End Time : " + end+"<b>");
			Duration processingTime = Duration.between(start, end);
			logger.info("Processing time: " + processingTime);
			String Processingtimesec=Long.toString(processingTime.getSeconds());
			String Processingtimemilli=Long.toString(processingTime.toMillis());	
			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
			extent.extentLogger("", "<b> MPWA - Hashtag detail page Processing time: " + processingTime+"<b>");
//			extent.HeaderChildNode("<b>Hashtag detail page Processing time: " + processingTime+"<b>");
//			TimeStampBack(1);
//			waitTime(5000);
//			TimeStampBack(1);
//			waitTime(5000);
		}else {
			Time_ExcelUpdate.timeStampNode("MPWA - hashtag detail page time is not displayed");
			extent.extentLoggerFail("", "MPWA - hashtag detail page time is not displayed");
		}
			TimeStampnavigateToHomePage();
		} 
		
		public void BannerLoadTime() throws Exception {
			
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC010");
			Time_ExcelUpdate.ModuleNode("MPWA - Discover");
			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Carrousel/ Banner load time.");
			extent.HeaderChildNode("MPWA - Carrousel/ Banner load time.");
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objDiscoverButton, 5);
			TimeStampverifyElementPresentAndClick(MPWAHomePage.objDiscoverButton, "Discover Button");
			Instant start=Instant.now();
			logger.info("Start Time : " + start);
//			Date startTime = new Date();
//			logger.info("Start Time : " + getDateDetails(startTime));
//			extent.extentLogger("", "<b>Start Time : " + getDateDetails(startTime)+"<b>");
			if(waitUntilElementDisplayed(MPWADiscoverPage.objBannersBelowTheSearchField, 10)) {
			Instant end=Instant.now();
			logger.info("End Time : " + end);
//			extent.extentLogger("", "<b>End Time : " + end+"<b>");
			Duration processingTime = Duration.between(start, end);
			logger.info("Processing time: " + processingTime);
			String Processingtimesec=Long.toString(processingTime.getSeconds());
			String Processingtimemilli=Long.toString(processingTime.toMillis());	
			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
			extent.extentLogger("", "<b> MPWA - Banner load Processing time: " + processingTime+"<b>");
//			extent.HeaderChildNode("<b>Banner load Processing time: " + processingTime+"<b>");
//			TimeStampBack(1);
//			waitTime(5000);
		}else {
			Time_ExcelUpdate.timeStampNode("MPWA - Carrousel/ Banner load time is not displayed");
			extent.extentLoggerFail("", "MPWA - Carrousel/ Banner load time is not displayed");
		}
			TimeStampnavigateToHomePage();
			
		}
		
		public void SearchScreenTimePostSearchingAKeyword(String name) throws Exception {
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC011");
			Time_ExcelUpdate.ModuleNode("MPWA - Discover");
			Time_ExcelUpdate.ExpectedProcessingTime("4.5 Sec");
			
			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Search screen time post searching a keyword");
			extent.HeaderChildNode("MPWA - Search screen time post searching a keyword");
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objDiscoverButton, 5);
			TimeStampverifyElementPresentAndClick(MPWAHomePage.objDiscoverButton, "Discover Button");
			waitUntilElementDisplayed(MPWADiscoverPage.objBannersBelowTheSearchField, 5);
			TimeStampverifyElementPresentAndClick(MPWADiscoverPage.objSearchTab, "Search Box");
			waitTime(4000);
			TimeStamptype(MPWADiscoverPage.objSearchTab, name, "Type value");
//			TimeStamphideKeyboard();
			waitTime(3000);
			TimeStampclick(MPWADiscoverPage.objListOfSearchResult, "Search result");
			Instant start=Instant.now();
			logger.info("Start Time : " + start);
//			Date startTime = new Date();
//			logger.info("Start Time : " + getDateDetails(startTime));
//			extent.extentLogger("", "<b>Start Time : " + getDateDetails(startTime)+"<b>");
			if(waitUntilElementDisplayed(MPWADiscoverPage.objTopButton, 10)) {
			Instant end=Instant.now();
			logger.info("End Time : " + end);
//			extent.extentLogger("", "<b>End Time : " + end+"<b>");
			Duration processingTime = Duration.between(start, end);
			logger.info("Processing time: " + processingTime);
			String Processingtimesec=Long.toString(processingTime.getSeconds());
			String Processingtimemilli=Long.toString(processingTime.toMillis());	
			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
			extent.extentLogger("", "<b> MPWA - Search screen time post searching a keyword Processing time: " + processingTime+"<b>");
//			extent.HeaderChildNode("<b>Search screen time post searching a keyword Processing time: " + processingTime+"<b>");
//			TimeStampBack(1);
//			waitTime(5000);
//			TimeStampBack(1);
//			waitTime(5000);
		}else {
			Time_ExcelUpdate.timeStampNode("MPWA - Search screen time post searching a keyword is not displayed");
			extent.extentLoggerFail("", "MPWA - Search screen time post searching a keyword is not displayed");
		}
			TimeStampnavigateToHomePage();
		}
		public String getDateDetails(Date date) throws Exception {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			String dateString = dateFormat.format(date).toString();
			return dateString;
		}	
		String description = null;
		String description1 = null;
		public void VideoStartUpTimeAfterSwipe() throws Exception {
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC009");
			Time_ExcelUpdate.ModuleNode("Feed");
			Time_ExcelUpdate.ExpectedProcessingTime("1.1 Sec");
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objDiscoverButton, 5);
			Time_ExcelUpdate.TestCaseSummaryNode1("Video start up time after swipe.");
			extent.HeaderChildNode("Video start up time after swipe.");
			description = getText(HipiHomePage.objDescription);
			TimeStampSwipe("DOWN", 1);
			Instant start=Instant.now();
			logger.info("Start Time : " + start);
			Date startTime = new Date();
			logger.info("Start Time : " + getDateDetails(startTime));
			description1 = getText(HipiHomePage.objDescription);
			if (!description.equals(description1)) {
				logger.info("user able to swipe Down Screen");
			}else {
				logger.info("user not able to swipe Down Screen");

			}
//			extent.extentLogger("", "<b>Start Time : " + getDateDetails(startTime)+"<b>");
//			waitUntilElementDisplayed(HipiHomePage.objProgressBarStart, 10);
			Instant end=Instant.now();
			logger.info("End Time : " + end);
//			extent.extentLogger("", "<b>End Time : " + end+"<b>");
			Duration processingTime = Duration.between(start, end);
			logger.info("Processing time: " + processingTime);
			String Processingtimesec=Long.toString(processingTime.getSeconds());
			String Processingtimemilli=Long.toString(processingTime.toMillis());	
			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
			extent.extentLogger("", "<b>Video start up time after swipe Processing time: " + processingTime+"<b>");
//			extent.HeaderChildNode("<b>Video start up time after swipe Processing time: " + processingTime+"<b>");
			
			
		}
		
		public void searchResults(String SearchItem,String TCID) throws Exception {
			
			extent.HeaderChildNode("MPWA - Search Result for "+SearchItem);
			String Suggestions1="";
			String Suggestions2="";
			String Profile1="";
			String Profile2="";
			String Video1="";
			String Video2="";
			String Video3="";
			String Video4="";
			String Hashtags1="";
			String Hashtags2="";
			String Sounds1="";
			String Sounds2="";
			
			logger.info("MPWA - Search Result for "+SearchItem);
			Time_ExcelUpdate.TestCaseIDNode(TCID);
			Time_ExcelUpdate.ModuleNode("MPWA - Search Suggetions: "+SearchItem);
			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Search Suggetions: "+SearchItem);
			TimeStampSwipe("UP", 1);
//			waitTime(2000);
			waitUntilElementDisplayed(MPWAHomePage.objDiscoverButton, 5);
			TimeStampverifyElementPresentAndClick(MPWAHomePage.objDiscoverButton, "Discover Button");
			waitUntilElementDisplayed(MPWADiscoverPage.objBannersBelowTheSearchField, 5);
			TimeStampverifyElementPresentAndClick(MPWADiscoverPage.objSearchTab, "Search Tab");
			waitTime(3000);
			TimeStamptype(MPWADiscoverPage.objSearchTab, SearchItem, "Type value");
			waitTime(5000);
			
			if(TimeStampverifyElementExist(MPWADiscoverPage.objsearchResults(1), "suggestions")) {
			Suggestions1=getText(MPWADiscoverPage.objsearchResults(1));
			System.out.println(Suggestions1);
			Suggestions2=getText(MPWADiscoverPage.objsearchResults(2));
			System.out.println(Suggestions2);
			waitTime(3000);
			
			
			Time_ExcelUpdate.TestCaseSummaryNode1("1 "+Suggestions1);
			extent.extentLogger("","Search  1st Suggestion done");
			
			Time_ExcelUpdate.TestCaseSummaryNode1("2 "+Suggestions2);
			}else {
				
				//Time_ExcelUpdate.TestCaseSummaryNode1("Suggestion  not present");
				
				logger.info(TCID + "Suggestion  not present");
			}
			
			TimeStampverifyElementPresentAndClick(MPWADiscoverPage.objListOfSearchResult, "Search result");
////			waitTime(3000);
			waitUntilElementDisplayed(MPWADiscoverPage.objListFirstuserProfile(1), 10);
////			TimeStampwaitForElementDisplayedFastPolling(IOSHiPiNeoDiscoverPage.objiosProfileInDiscoverpage(1), 100, "results after search");
			extent.extentLogger("","Search done");
			
			Time_ExcelUpdate.ModuleNode("MPWA - Top Users Section :"+SearchItem);
			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Top Users Result: "+SearchItem);
			Profile1=getText(MPWADiscoverPage.objListFirstuserProfile(1));
			System.out.println(Profile1);
			Profile2=getText(MPWADiscoverPage.objListFirstuserProfile(2));
			System.out.println(Profile2);
			waitTime(3000);
			
			
			Time_ExcelUpdate.TestCaseSummaryNode1("1 "+Profile1);
			extent.extentLogger("","MPWA - Top Users 1 st profile name fetched");
			
			Time_ExcelUpdate.TestCaseSummaryNode1("2 "+Profile2);
			extent.extentLogger("","MPWA - Top Users 2nd profile name fetched");
			
			
			Time_ExcelUpdate.ModuleNode("MPWA - Top Videos Section:"+SearchItem);
			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Top Videos Result:"+SearchItem);
			
////			PartialSwipe("UP", 1);
//			if(TimeStampverifyElementExist(HipiDiscoverPage.objListOfVideos(1), "Videos in under Top section ")) {
//			Video1=getText(HipiDiscoverPage.objListOfVideos(1));
//			System.out.println(Video1);
//			Video2=getText(HipiDiscoverPage.objListOfVideos(2));
//			System.out.println(Video2);
			if(TimeStampverifyElementExist(MPWADiscoverPage.objListOfVideos(1), "Videos in under Top section ")) {
			waitTime(3000);
			TimeStampclick(MPWADiscoverPage.objListOfVideos(1),"1 st video");
			waitUntilElementDisplayed(MPWAHomePage.objUserNameInFeedScreen, 5);
			String Video1Username=getText(MPWAHomePage.objUserNameInFeedScreen);
			TimeStampBack(1);
			waitTime(5000);
			
			TimeStampclick(MPWADiscoverPage.objListOfVideos(2),"2nd video");
			waitUntilElementDisplayed(MPWAHomePage.objUserNameInFeedScreen, 5);
			String Video2Username=getText(MPWAHomePage.objUserNameInFeedScreen);
			TimeStampBack(1);
			waitTime(5000);
			
			TimeStampclick(MPWADiscoverPage.objListOfVideos(3),"3 rd video");
			waitUntilElementDisplayed(MPWAHomePage.objUserNameInFeedScreen, 5);
			String Video3Username=getText(MPWAHomePage.objUserNameInFeedScreen);
			TimeStampBack(1);
			waitTime(5000);
		
			Time_ExcelUpdate.TestCaseSummaryNode1("1 st video is from  "+Video1Username);
			extent.extentLogger("","Top videos 1 st video name fetched");
			
			Time_ExcelUpdate.TestCaseSummaryNode1("2 nd video is from "+Video2Username);
		extent.extentLogger("","MPWA - Top videos 2nd video name fetched");

			Time_ExcelUpdate.TestCaseSummaryNode1("3 rd video is from "+Video3Username);
			extent.extentLogger("","MPWA - Top videos 3rd video name fetched");
//			
			}else {
				Time_ExcelUpdate.TestCaseIDNode(TCID);
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Videos not present");
				extent.extentLoggerFail("","MPWA - Videos  not present");
				
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Videos  not present");
//				extent.extentLoggerFail("","Videos  not present");
			}
//			waitTime(4000);
//			PartialSwipe("UP", 1);
			Time_ExcelUpdate.ModuleNode("MPWA - Top Hashtag Section: "+SearchItem);
////			TimeStampSwipeTillElement(IOSHiPiNeoDiscoverPage.objiosHashtagSectionUnderTopresults, "Hashtags");
			waitTime(3000);
			if(TimeStampverifyElementExist(MPWADiscoverPage.objListOfHashhtags(1), "Hashtags")) {
				
				Hashtags1=getText(MPWADiscoverPage.objListOfHashhtags(1));
				System.out.println(Hashtags1);
				Hashtags2=getText(MPWADiscoverPage.objListOfHashhtags(2));
				System.out.println(Hashtags2);
				waitTime(3000);
				
				
				Time_ExcelUpdate.TestCaseSummaryNode1("1."+Hashtags1);
				extent.extentLogger("","1 st Hashtag fetched");
				
				Time_ExcelUpdate.TestCaseSummaryNode1("2."+Hashtags2);
				extent.extentLogger("","2 nd Hashtag fetched");
				
				
			}else {
				
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Hashtag  not present");
				logger.info("MPWA - Hashtag  not present");
				
				
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Hashtag  not present");
//				extent.extentLoggerFail("","Hashtag  not present");
			}
//			
//			
			waitTime(5000);
			TimeStampclick(MPWADiscoverPage.objUsersButton, "User Tab");
			waitUntilElementDisplayed(MPWADiscoverPage.objListUserProfile(1), 5);
			Time_ExcelUpdate.ModuleNode("Users Section: "+SearchItem);
			if(TimeStampverifyElementExist(MPWADiscoverPage.objListUserProfile(1), "Results under Users Tab")) {
			waitTime(3000);
			String UsersProfile1=getText(MPWADiscoverPage.objListUserProfile(1));
			String UsersProfile2=getText(MPWADiscoverPage.objListUserProfile(2));
			String UsersProfile3=getText(MPWADiscoverPage.objListUserProfile(3));
			String UsersProfile4=getText(MPWADiscoverPage.objListUserProfile(4));
			String UsersProfile5=getText(MPWADiscoverPage.objListUserProfile(5));
			
			
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
				extent.extentLoggerFail("","MPWA - Users tap result  not present");
				
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Users tap result  not present");
				extent.extentLoggerFail("","MPWA - Users tap result  not present");
				
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Users tap result  not present");
				extent.extentLoggerFail("","MPWA - Users tap result  not present");
				
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Users tap result  not present");
				extent.extentLoggerFail("","MPWA - Users tap result  not present");
				
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Users tap result  not present");
				extent.extentLoggerFail("","MPWA - Users tap result  not present");
				
			}
			
		/*	
			waitTime(5000);
			
			Time_ExcelUpdate.ModuleNode("Videos Section: "+SearchItem);
			Time_ExcelUpdate.TestCaseSummaryNode1("Videos section in search Result: "+SearchItem);
			

				TimeStampclick(MPWADiscoverPage.objVideosButton, "Video Tab");
				waitTime(3000);	

				if(TimeStampverifyElementExist(MPWADiscoverPage.objListOfVideosInVideoStab(1),"Videos Result")){
				waitTime(3000);
				TimeStampclick(MPWADiscoverPage.objListOfVideosInVideoStab(1),"1 st video");
				waitUntilElementDisplayed(MPWAHomePage.objUserNameInFeedScreen, 5);
				Video1=getText(MPWAHomePage.objUserNameInFeedScreen);
				TimeStampBack(1);
				waitUntilElementDisplayed(MPWADiscoverPage.objListOfVideosInVideoStab(1), 10);
				
				TimeStampclick(MPWADiscoverPage.objListOfVideosInVideoStab(2),"2nd video");
				waitUntilElementDisplayed(MPWAHomePage.objUserNameInFeedScreen, 5);
				 Video2=getText(MPWAHomePage.objUserNameInFeedScreen);
				TimeStampBack(1);
				waitUntilElementDisplayed(MPWADiscoverPage.objListOfVideosInVideoStab(1), 10);
				
				TimeStampclick(MPWADiscoverPage.objListOfVideosInVideoStab(3),"3 rd video");
				waitUntilElementDisplayed(MPWAHomePage.objUserNameInFeedScreen, 5);
				 Video3=getText(MPWAHomePage.objUserNameInFeedScreen);
				TimeStampBack(1);
				waitUntilElementDisplayed(MPWADiscoverPage.objListOfVideosInVideoStab(1), 10);
				TimeStampclick(MPWADiscoverPage.objListOfVideosInVideoStab(4),"4 th video");
				waitUntilElementDisplayed(MPWAHomePage.objUserNameInFeedScreen, 5);
				Video4=getText(MPWAHomePage.objUserNameInFeedScreen);
				TimeStampBack(1);
				waitUntilElementDisplayed(MPWADiscoverPage.objListOfVideosInVideoStab(1), 10);

				
				Time_ExcelUpdate.TestCaseSummaryNode1("1 st video is from  "+Video1);
				extent.extentLogger(""," in videos section 1 st video name fetched");
				
				Time_ExcelUpdate.TestCaseSummaryNode1("2 nd video is from "+Video2);
				extent.extentLogger(""," in videos section 2 nd video name fetched");
				
				
				
				Time_ExcelUpdate.TestCaseSummaryNode1("3 rd video is from "+Video3);
				extent.extentLogger(""," in videos section 3 rd video name fetched");
				
				Time_ExcelUpdate.TestCaseSummaryNode1("4 th video is from "+Video4);
				extent.extentLogger(""," in videos section 4 th video name fetched");
				}else {
					
					Time_ExcelUpdate.TestCaseSummaryNode1("Videos  not present");
					extent.extentLoggerFail("","Videos  not present");
					
					
				}
		*/
				waitTime(5000);
			
			Time_ExcelUpdate.ModuleNode("MPWA - HashTag Section: "+SearchItem);
			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - HashTag Section in Search results: "+SearchItem);
			
////			TimeStampverifyElementExist(IOSHiPiNeoDiscoverPage.objiosTabnameInDiscoverSearchResultsPage("Hashtags"), "HashTags Tab in search result ");
////				TimeStampclick(IOSHiPiNeoDiscoverPage.objiosTabnameInDiscoverSearchResultsPage("Hashtags"), "Hashtags");
				TimeStampclick(MPWADiscoverPage.objHashhtagsButton, "Hashtags Tab");	
				waitUntilElementDisplayed(MPWADiscoverPage.objListofFirstHashtags(1), 5);
				if(TimeStampverifyElementExist(MPWADiscoverPage.objListofFirstHashtags(1), "Hashtag result")) {
				String HashTag1=getText(MPWADiscoverPage.objListofFirstHashtags(1));
				System.out.println(HashTag1);
				String HashTag2=getText(MPWADiscoverPage.objListofFirstHashtags(2));
				System.out.println(HashTag2);
				
				String HashTag3=getText(MPWADiscoverPage.objListofFirstHashtags(3));
				System.out.println(HashTag3);
				
				String HashTag4=getText(MPWADiscoverPage.objListofFirstHashtags(4));
				System.out.println(HashTag4);
				
				String HashTag5=getText(MPWADiscoverPage.objListofFirstHashtags(5));
				System.out.println(HashTag5);
				
				Time_ExcelUpdate.TestCaseSummaryNode1("1. "+HashTag1);
				extent.extentLogger("","MPWA -  in HashTag section 1 st HashTag name fetched");
				
				Time_ExcelUpdate.TestCaseSummaryNode1("2. "+HashTag2);
				extent.extentLogger("","MPWA -  in HashTag section 2 nd HashTag name fetched");
				

				Time_ExcelUpdate.TestCaseSummaryNode1("3. "+HashTag3);
				extent.extentLogger("","MPWA -  in HashTag section 3 rd HashTag name fetched");
				

				Time_ExcelUpdate.TestCaseSummaryNode1("4. "+HashTag4);
				extent.extentLogger("","MPWA -  in HashTag section 4 th HashTag name fetched");
				

				Time_ExcelUpdate.TestCaseSummaryNode1("5. "+HashTag5);
				extent.extentLogger("","MPWA -  in HashTag section 5 th HashTag name fetched");
				
				
				}else {
					
					Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - HashTag  not present");
					extent.extentLoggerFail("","MPWA - HashTag  not present");
					
					
				}
//				TimeStampBack(1);
//				waitTime(5000);
//				TimeStampBack(1);
//				waitTime(5000);
				TimeStampnavigateToHomePage();
				
				
		}
		
		public void TimeStamplogOut() throws Exception {
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC021");
			Time_ExcelUpdate.ModuleNode("MPWA - Profile");
			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Logout Time");
			Time_ExcelUpdate.ExpectedProcessingTime("5 Sec");
			extent.HeaderChildNode("MPWA - Logout Time");
			TimeStampSwipe("UP", 1);
//			TimeStampnavigateToHomePage();
			TimeStampverifyElementPresentAndClick(MPWAHomePage.objProfileIcon,"Profile Icon");
//			waitUntilElementDisplayed(HipiProfilePage.objUsePhoneOrEmail, 20);
			if (TimeStampverifyElementExist(MPWALoginPage.objUsePhoneOrEmail,"Use Phone Or Email")) {
				logger.info("User is all ready Logout application");	
//				extent.extentLoggerPass("", "User is all ready Logout application");
				TimeStampBack(2);
			}else {
				waitUntilElementDisplayed(MPWAProfilePage.objThreeDots, 5);
				TimeStampverifyElementPresentAndClick(MPWAProfilePage.objThreeDots, "Three Dots");
				waitUntilElementDisplayed(MPWAProfilePage.objLogOut, 1);
				
				TimeStampverifyElementPresentAndClick(MPWAProfilePage.objLogOut, "Log out");
				TimeStampverifyElementPresentAndClick(MPWAProfilePage.objYesCTA, "Yes CTA");
			Instant start = Instant.now();
//			extent.extentLogger("", "clicked on hipi at Time----- "+ start);
			if(waitForElementDisplayediOS(MPWAHomePage.objForYou, 10, "for you button in feed")) {	
			Instant end=Instant.now();
			logger.info("End Time : " + end);
//			extent.extentLogger("", "<b>End Time : " + end+"<b>");
			Duration processingTime = Duration.between(start, end);
			logger.info("Processing time: " + processingTime);

			String Processingtimesec=Long.toString(processingTime.getSeconds());
			String Processingtimemilli=Long.toString(processingTime.toMillis());	
			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
			extent.extentLogger("", "<b>Filter download Processing time: " + processingTime+"<b>");
			}else {
				Time_ExcelUpdate.timeStampNode("MPWA - User is not able to Logout");
				extent.extentLoggerFail("", "MPWA - User is not able to Logout");
			}
			if(TimeStampverifyElementExist(MPWAHomePage.objHomeIcon, "Home ICON")) {
				logger.info("User is able to Logout application");	
//				extent.extentLoggerPass("", "User is able to Logout application");	
		  }else {
				logger.info("User is not able to Logout application");	
//				extent.extentLoggerFail("", "User is not able to Logout application");
			}
			if(TimeStampverifyElementExist(HipiHomePage.objEngleshButton, "Englesh Icon")) {
				System.out.println("User is able to see Englesh Icon");
				TimeStampclick(HipiHomePage.objEngleshButton, "Englesh Icon");
				TimeStampclick(HipiHomePage.objCrossIcon, "Cross Icon");
			}else {
				
				System.out.println("User is not able to see Englesh Icon");
				
			}
			}
		}
		public void launchApptime() throws Exception {
		
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC001");
//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.ModuleNode("MPWA - FeedArrival");
			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Feed Screen launch time.");
			Time_ExcelUpdate.ExpectedProcessingTime("3.75 Sec");
			extent.HeaderChildNode("MPWA - Launching hipi PWA");
			
//			extent.HeaderChildNode("Launch hipi app");
			getDriver().quit();
			waitTime(3000);
			new Zee5ApplicasterHipiNeoBusinessLogic("Chrome");
			if(TimeStampverifyElementExist(HipiHomePage.objEngleshButton, "Englesh Icon")) {
				System.out.println("User is able to see Englesh Icon");
				TimeStampclick(HipiHomePage.objEngleshButton, "Englesh Icon");
				TimeStampclick(HipiHomePage.objCrossIcon, "Cross Icon");
			}else {
				
				System.out.println("User is not able to see Englesh Icon");
				
			}
			Instant start = Instant.now();
//			extent.extentLogger("", "clicked on hipi at Time----- "+ start);
			extent.extentLogger("", "clicked on hipi at Time----- "+ start);
			logger.info("clicked on hipi at Time----- "+ start);
//			waitTime(10000);
//			TimeStampSwipe("UP", 1);
//			waitTime(4000);
			waitUntilElementDisplayed(MPWAHomePage.objForYou, 10);		
//			screencapture();
			Instant end = Instant.now();
			Duration timeElapsed = Duration.between(start, end);
			extent.HeaderChildNode("the arrival time of feed screen from splash screen " +"Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds");
			System.out.println("Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds" );
//			extent.HeaderChildNode("the arrival time of feed screen from splash screen " +"Time taken in milliseconds : "+timeElapsed.toMillis()+" milliSeconds");
			
			String Processingtimesec=Long.toString(timeElapsed.getSeconds());
			String Processingtimemilli=Long.toString(timeElapsed.toMillis());	
			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
			extent.extentLogger("", "Feed screen seen  at Time----- " + end);

		}
		
		public void SwipeUpForNextVideoAnimation(String userType) throws Exception {
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC004");
//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.ModuleNode("MPWA - Feed");
//			Time_ExcelUpdate.TestCaseSummaryNode1("Verify Swipe up for next video Animation");
			extent.HeaderChildNode("MPWA - Verify Swipe up for next video Animation");
			
			waitUntilElementDisplayed(MPWAHomePage.objSwipeUpForNextVideo, 20);
			
			if(TimeStampverifyElementExist(MPWAHomePage.objSwipeUpForNextVideo, "Swipe Up For Next Video")){
				logger.info("MPWA - User is able to see Swipe Up For Next Video Animation");	
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - User is able to see Swipe Up For Next Video Animation");
				extent.extentLoggerPass("", "MPWA - User is able to see Swipe Up For Next Video Animation");
			}else {
				logger.info("MPWA - User is able to see Swipe Up For Next Video Animation");	
//				extent.extentLoggerFail("", "User is not able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - User is not able to see Swipe Up For Next Video Animation");

			}
			}
			
		
		public void commentWithApp(String userType) throws Exception {
			//Zee5ApplicasterHipiNeoBusinessLogic = new com.business.zee.Zee5ApplicasterHipiNeoBusinessLogic("zee");
			
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC018");
//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.ModuleNode("Click on Comment: with App");
//			Time_ExcelUpdate.TestCaseSummaryNode1("Verify Swipe up for next video Animation");
			extent.HeaderChildNode("User is navigate to App when click on comment: with App");
			
			TimeStampSwipe("UP", 1);
		waitUntilElementDisplayed(MPWAHomePage.objCommentButton, 5);
			TimeStampclick(MPWAHomePage.objCommentButton, "Comment Button");
			waitUntilElementDisplayed(MPWAHomePage.objOpenApp, 10);
			TimeStampclick(MPWAHomePage.objOpenApp, "Open App Button");
			waitTime(20000);
			getDriver().context("NATIVE_APP");
			waitTime(5000);
			waitUntilElementDisplayed(HipiHomePage.objMusicButtonBelowLeftSide, 20);
			
			if(TimeStampverifyElementExist(HipiHomePage.objMusicButtonBelowLeftSide, "Description")) {
				logger.info("User is able to navigate the App when click on comment Button");	
//				extent.extentLoggerPass("", "User is able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("User is able to navigate the App when click on comment Button");
		  }else {
				logger.info("User is not able to navigate the App when click on comment Button");	
				Time_ExcelUpdate.TestCaseSummaryNode1("User is not able to navigate the App when click on comment Button");
				extent.extentLoggerFail("", "MPWA - User is not able to navigate the App when click on comment Button");

			}
			
			getDriver().context("WEBVIEW_1");
			waitTime(4000);
//			getDriver().quit();
		}
		
		
		public void CreatorWithApp(String userType) throws Exception
		{
//			getDriver().context("WEBVIEW_1");
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC018");
//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.ModuleNode("MPWA - Click on Creator: with App");
//			Time_ExcelUpdate.TestCaseSummaryNode1("Verify Swipe up for next video Animation");
			extent.HeaderChildNode("MPWA - User is navigate to App when click on Creator: with App");
			
//			new AndroidHipiMPWABusinessLogic("chrome");
			waitUntilElementDisplayed(MPWAHomePage.objForYou, 10);
			TimeStampSwipe("UP", 1);
			waitTime(4000);
			TimeStampclick(MPWAHomePage.objCreatorButton, "Creator Button");
			
			waitUntilElementDisplayed(MPWAHomePage.objOpenApp, 10);
			TimeStampclick(MPWAHomePage.objOpenApp, "Open App Button");
			waitTime(10000);
			getDriver().context("NATIVE_APP");
			waitTime(5000);
//			if(TimeStampverifyElementExist(HipiHomePage.objUpdate, "Update Button"))
//			{
//		
//			TimeStampclick(HipiHomePage.objUpdate, "Update Button");
//			waitTime(4000);
//			waitForElementNotDisplayed(HipiHomePage.objCancelDownload);
//			waitTime(10000);
////			TimeStamprelaunch(false);
//			if(TimeStampverifyElementExist(HipiHomePage.objDone, "Done Button")) {
//				TimeStampclick(HipiHomePage.objDone, "Done Button");
//				
//			}
//			
//			}else{
//				System.out.println("Update Popup is not displayed");
//				}
//			waitUntilElementDisplayed(HipiLoginPage.objMaybeLater, 1);
			if(TimeStampverifyElementExist(HipiLoginPage.objMaybeLater, "Maybe Later"))
			{
				TimeStampclick(HipiLoginPage.objMaybeLater, "Maybe Later");
				System.out.println("Update Popup is displayed");
			}else{
				System.out.println("Update Popup is not displayed");
			}
			waitUntilElementDisplayed(HipiHomePage.objDescription, 20);
			
			if(TimeStampverifyElementExist(HipiHomePage.objDescription, "Description")) {
				logger.info("User is able to navigate the App when click on Creator Button");	
//				
				Time_ExcelUpdate.TestCaseSummaryNode1("User is able to navigate the App when click on Creator Button");
				extent.extentLoggerPass("", "User is able to Logout application");
		  }else {
				logger.info("MPWA - User is not able to navigate the App when click on Creator Button");	
//				extent.extentLoggerFail("", "User is not able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - User is not able to navigate the App when click on Creator Button");
				extent.extentLoggerFail("", "MPWA - User is not able to navigate the App when click on Creator Button");

		  }
			
		}		
		
		public void openOptionINMPWA(String userType) throws Exception {
			
			
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC019");
//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.ModuleNode("MPWA - Click on Open Option in feed Screen: with App");
//			Time_ExcelUpdate.TestCaseSummaryNode1("Verify Swipe up for next video Animation");
			extent.HeaderChildNode("MPWA - User is navigate to App when click on Option Option: with App");
			waitUntilElementDisplayed(MPWAHomePage.objForYou, 10);
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objOpenButton, 10);
			
			TimeStampclick(MPWAHomePage.objOpenButton, "Open Button");
			waitTime(10000);
			getDriver().context("NATIVE_APP");
//			if(TimeStampverifyElementExist(HipiHomePage.objUpdate, "Update Button"))
//			{
//		
//			TimeStampclick(HipiHomePage.objUpdate, "Update Button");
//			waitTime(4000);
//			waitForElementNotDisplayed(HipiHomePage.objCancelDownload);
//			waitTime(10000);
////			TimeStamprelaunch(false);
//			if(TimeStampverifyElementExist(HipiHomePage.objDone, "Done Button")) {
//				TimeStampclick(HipiHomePage.objDone, "Done Button");
//				
//			}
//			
//			}else{
//				System.out.println("Update Popup is not displayed");
//				}
//			waitUntilElementDisplayed(HipiLoginPage.objMaybeLater, 1);
			if(TimeStampverifyElementExist(HipiLoginPage.objMaybeLater, "Maybe Later"))
			{
				TimeStampclick(HipiLoginPage.objMaybeLater, "Maybe Later");
				System.out.println("Update Popup is displayed");
			}else{
				System.out.println("Update Popup is not displayed");
			}
			waitUntilElementDisplayed(HipiHomePage.objDescription, 10);
			
			if(TimeStampverifyElementExist(HipiHomePage.objRewardsPage, "Rewards Page")) {
				logger.info("User is able to navigate the App when click on Open Button");	
//				
				Time_ExcelUpdate.TestCaseSummaryNode1("User is able to navigate the App when click on Open Button");
				extent.extentLoggerPass("", "User is able to navigate the App when click on Open Button");
		  }else {
				logger.info("User is not able to navigate the App when click on Open Button");	
//				extent.extentLoggerFail("", "User is not able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - User is not able to navigate the App when click on Open Button");
				extent.extentLoggerFail("", "MPWA - User is not able to navigate the App when click on Open Button");

		  }
			}
		public void editProfile(String userType) throws Exception {
			
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC020");
//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.ModuleNode("Click on Edit Profile Option in Profile Screen: with App");
//			Time_ExcelUpdate.TestCaseSummaryNode1("Verify Swipe up for next video Animation");
			extent.HeaderChildNode("Click on Edit Profile Option in Profile Screen: with App");
			waitUntilElementDisplayed(MPWAHomePage.objForYou, 10);
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objOpenButton, 10);

			TimeStampverifyElementPresentAndClick(MPWAHomePage.objProfileIcon,"Profile Icon");
			waitUntilElementDisplayed(MPWAProfilePage.objThreeDots, 5);
			TimeStampverifyElementPresentAndClick(MPWAProfilePage.objEditProfile, "Edit Profile");
			waitUntilElementDisplayed(MPWAHomePage.objOpenApp, 10);
			TimeStampclick(MPWAHomePage.objOpenApp, "Open App Button");
			waitTime(10000);
			getDriver().context("NATIVE_APP");
			if(TimeStampverifyElementExist(HipiLoginPage.objMaybeLater, "Maybe Later"))
			{
				TimeStampclick(HipiLoginPage.objMaybeLater, "Maybe Later");
				System.out.println("Update Popup is displayed");
			}else{
				System.out.println("Update Popup is not displayed");
			}
			
//			if(TimeStampverifyElementExist(HipiHomePage.objUpdate, "Update Button"))
//			{
//		
//			TimeStampclick(HipiHomePage.objUpdate, "Update Button");
//			waitTime(4000);
//			waitForElementNotDisplayed(HipiHomePage.objCancelDownload);
//			waitTime(10000);
////			TimeStamprelaunch(false);
//			if(TimeStampverifyElementExist(HipiHomePage.objDone, "Done Button")) {
//				TimeStampclick(HipiHomePage.objDone, "Done Button");
//				
//			}
//			
//			}else{
//				System.out.println("Update Popup is not displayed");
//				}
			waitUntilElementDisplayed(HipiHomePage.objDescription, 5);
			
			if(TimeStampverifyElementExist(HipiHomePage.objDescription, "Description")) {
				logger.info("User is able to navigate the App when click on Edit Profile Button");	
//				
				Time_ExcelUpdate.TestCaseSummaryNode1("User is able to navigate the App when click on Edit Profile Button");
				extent.extentLoggerPass("", "User is able to navigate the App when click on Edit Profile Button");
		  }else {
				logger.info("User is not able to navigate the App when click on Edit Profile Button");	
//				extent.extentLoggerFail("", "User is not able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("User is not able to navigate the App when click on Edit Profile Button");
				extent.extentLoggerFail("", "MPWA - User is not able to navigate the App when click on Edit Profile Button");

		  }
		}
		
		
		
		
		public void withOutAppCommentButton(String userType) throws Exception {
			
			
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC022");
//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.ModuleNode("Click on Comment: with out App");
//			Time_ExcelUpdate.TestCaseSummaryNode1("Verify Swipe up for next video Animation");
			extent.HeaderChildNode("User is navigate to App when click on comment: with out App");
			Runtime.getRuntime().exec("adb uninstall com.zee5.hipi");
			waitUntilElementDisplayed(MPWAHomePage.objForYou, 10);
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objOpenButton, 10);
		
			waitUntilElementDisplayed(MPWAHomePage.objCommentButton, 5);
			TimeStampclick(MPWAHomePage.objCommentButton, "Comment Button");
			waitUntilElementDisplayed(MPWAHomePage.objOpenApp, 10);
			TimeStampclick(MPWAHomePage.objOpenApp, "Open App Button");
			waitTime(5000);
			getDriver().context("NATIVE_APP");
			waitTime(5000);
			
			waitUntilElementDisplayed(MPWAHomePage.objInstallButton, 20);

			if(TimeStampverifyElementExist(MPWAHomePage.objInstallButton, "Install Button")) {
				logger.info("User is able to navigate the Play Store App when click on Comment Button");	
				//				extent.extentLoggerPass("", "User is able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("User is able to navigate the Play Store App when click on Comment Button");
			}else {
				logger.info("User is not able to navigate the Play Store App when click on Comment Button");	
				//				extent.extentLoggerFail("", "User is not able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("User is not able to navigate the Play Store App when click on Comment Button");
				extent.extentLoggerFail("", "MPWA - User is not able to navigate the Play Store App when click on Comment Button");

			}	
		}
		
		
		public void withOutAppCreatorButton(String userTyupe) throws Exception {

			Time_ExcelUpdate.TestCaseIDNode("MPWA TC023");
			//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.ModuleNode("Click on Creator: with out App");
			//			Time_ExcelUpdate.TestCaseSummaryNode1("Verify Swipe up for next video Animation");
			extent.HeaderChildNode("User is navigate to App when click on Creator: with out App");
			Runtime.getRuntime().exec("adb uninstall com.zee5.hipi");
			waitUntilElementDisplayed(MPWAHomePage.objForYou, 10);
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objCreatorButton, 10);
			TimeStampclick(MPWAHomePage.objCreatorButton, "Creator Button");

			waitUntilElementDisplayed(MPWAHomePage.objOpenApp, 10);
			TimeStampclick(MPWAHomePage.objOpenApp, "Open App Button");
			waitTime(5000);
			getDriver().context("NATIVE_APP");
			waitTime(5000);

			waitUntilElementDisplayed(MPWAHomePage.objInstallButton, 20);

			if(TimeStampverifyElementExist(MPWAHomePage.objInstallButton, "Install Button")) {
				logger.info("User is able to navigate the Play Store App when click on Creator Button");	
				//				extent.extentLoggerPass("", "User is able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("User is able to navigate the Play Store App when click on Creator Button");
			}else {
				logger.info("User is not able to navigate the Play Store App when click on Creator Button");	
				//				extent.extentLoggerFail("", "User is not able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("User is not able to navigate the Play Store App when click on Creator Button");
				extent.extentLoggerFail("", "MPWA - User is not able to navigate the Play Store App when click on Creator Button");

			}	


		}
		
		public void openOptionINMPWAWithoutApp(String userType) throws Exception {


			Time_ExcelUpdate.TestCaseIDNode("MPWA TC024");
			//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.ModuleNode("Click on Open Option in feed Screen: with out App");
			//			Time_ExcelUpdate.TestCaseSummaryNode1("Verify Swipe up for next video Animation");
			extent.HeaderChildNode("User is navigate to App when click on Option Option: with out App");
			Runtime.getRuntime().exec("adb uninstall com.zee5.hipi");
			waitUntilElementDisplayed(MPWAHomePage.objForYou, 10);
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objOpenButton, 10);
			TimeStampclick(MPWAHomePage.objOpenButton, "Open Button");
			waitTime(10000);
			getDriver().context("NATIVE_APP");
			waitTime(5000);

			waitUntilElementDisplayed(MPWAHomePage.objInstallButton, 20);

			if(TimeStampverifyElementExist(MPWAHomePage.objInstallButton, "Install Button")) {
				logger.info("User is able to navigate the Play Store App when click on open Button");	
				//				extent.extentLoggerPass("", "User is able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("User is able to navigate the Play Store App when click on open Button");
			}else {
				logger.info("User is not able to navigate the Play Store App when click on open Button");	
				//				extent.extentLoggerFail("", "User is not able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("User is not able to navigate the Play Store App when click on open Button");
				extent.extentLoggerFail("", "MPWA - User is not able to navigate the Play Store App when click on open Button");

			}			
		}

		
		public void WithOutAppEditProfile(String userType) throws Exception {

			Time_ExcelUpdate.TestCaseIDNode("MPWA TC025");
			//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.ModuleNode("Click on Edit Profile Option in Profile Screen: with out App");
			//			Time_ExcelUpdate.TestCaseSummaryNode1("Verify Swipe up for next video Animation");
			extent.HeaderChildNode("Click on Edit Profile Option in Profile Screen: with out App");

			Runtime.getRuntime().exec("adb uninstall com.zee5.hipi");
			waitUntilElementDisplayed(MPWAHomePage.objForYou, 10);
			TimeStampSwipe("UP", 1);
			waitUntilElementDisplayed(MPWAHomePage.objOpenButton, 10);
			TimeStampverifyElementPresentAndClick(MPWAHomePage.objProfileIcon,"Profile Icon");
			waitUntilElementDisplayed(MPWAProfilePage.objThreeDots, 5);
			TimeStampverifyElementPresentAndClick(MPWAProfilePage.objEditProfile, "Edit Profile");
			waitUntilElementDisplayed(MPWAHomePage.objOpenApp, 10);
			TimeStampclick(MPWAHomePage.objOpenApp, "Open App Button");
			waitTime(10000);
			getDriver().context("NATIVE_APP");
			waitTime(5000);

			waitUntilElementDisplayed(MPWAHomePage.objInstallButton, 20);

			if(TimeStampverifyElementExist(MPWAHomePage.objInstallButton, "Install Button")) {
				logger.info("User is able to navigate the Play Store App when click on Edit Profile Button");	
				//				extent.extentLoggerPass("", "User is able to Logout application");
				TimeStampclick(MPWAHomePage.objInstallButton, "Install Button");
				Time_ExcelUpdate.TestCaseSummaryNode1("User is able to navigate the Play Store App when click on Edit Profile Button");
			}else {
				logger.info("User is not able to navigate the Play Store App when click on Edit Profile Button");	
				//				extent.extentLoggerFail("", "User is not able to Logout application");
				Time_ExcelUpdate.TestCaseSummaryNode1("User is not able to navigate the Play Store App when click on Edit Profile Button");
				extent.extentLoggerFail("", "MPWA - User is not able to navigate the Play Store App when click on Edit Profile Button");

			}			
		
		}
		
		
		public void launchApp_And_Check_ProgressBar() throws Exception {
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC002");
//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.ModuleNode("MPWA - FeedArrival");
			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Feed Screen Progress bar launch time.");
//			Time_ExcelUpdate.ExpectedProcessingTime("3.75 Sec");
			extent.HeaderChildNode("MPWA - Launching hipi and check Progress bar");
			
//			extent.HeaderChildNode("Launch hipi app");
			getDriver().quit();
			waitTime(3000);
			new Zee5ApplicasterHipiNeoBusinessLogic("Chrome");
			if(TimeStampverifyElementExist(HipiHomePage.objEngleshButton, "Englesh Icon")) {
				System.out.println("User is able to see Englesh Icon");
				TimeStampclick(HipiHomePage.objEngleshButton, "Englesh Icon");
				TimeStampclick(HipiHomePage.objCrossIcon, "Cross Icon");
			}else {
				
				System.out.println("User is not able to see Englesh Icon");
				
			}
			Instant start = Instant.now();
//			extent.extentLogger("", "clicked on hipi at Time----- "+ start);
//			extent.extentLogger("", "clicked on hipi at Time----- "+ start);
			
			waitUntilElementDisplayed(MPWAHomePage.objForYou, 10);	
//			screencapture();
			Instant end = Instant.now();
			Duration timeElapsed = Duration.between(start, end);
			extent.HeaderChildNode("the arrival time of feed screen from splash screen " +"Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds");
			System.out.println("Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds" );
			extent.HeaderChildNode("the arrival time of feed screen from splash screen " +"Time taken in milliseconds : "+timeElapsed.toMillis()+" milliSeconds");
			
			String Processingtimesec=Long.toString(timeElapsed.getSeconds());
			String Processingtimemilli=Long.toString(timeElapsed.toMillis());	
			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
			extent.extentLogger("", "MPWA - Feed screen seen  at Time----- " + end);
//			TimeStampnavigateToHomePage();
		}
		
		public void verifyProgressBar() throws Exception {
			Time_ExcelUpdate.TestCaseIDNode("MPWA TC003");
//			Time_ExcelUpdate.SlNoNode("1");
			Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - Verify Progress bar is moving");
			Time_ExcelUpdate.ModuleNode("MPWA - Verify Progress bar is moving");
//			Time_ExcelUpdate.ExpectedProcessingTime("3.75 Sec");
			extent.HeaderChildNode("MPWA - Launching hipi and check Progress bar");
			
//			extent.HeaderChildNode("Launch hipi app");
			TimeStampwaitForElementDisplayediOS(MPWAHomePage.objProgressBar, 10, "Progress Bar");	
			
			String str1 = getAttributValue("style", MPWAHomePage.objProgressBar);
			System.out.println(str1);
			waitTime(5000);
			String str2 = getAttributValue("style", MPWAHomePage.objProgressBarID);
			System.out.println(str2);
			if (!str1.equals(str2)) {
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - progress bar is moving Properly");
				System.out.println("MPWA - progress bar is moving Properly");
			}else {
				Time_ExcelUpdate.TestCaseSummaryNode1("MPWA - progress bar is not moving Properly");
				System.out.println("MPWA - progress bar is not moving Properly");
			}
			

//			Instant start = Instant.now();
//			extent.extentLogger("", "clicked on hipi at Time----- "+ start);
//			extent.extentLogger("", "clicked on hipi at Time----- "+ start);

			
////			screencapture();
//			Instant end = Instant.now();
//			Duration timeElapsed = Duration.between(start, end);
//			extent.HeaderChildNode("the arrival time of feed screen from splash screen " +"Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds");
//			System.out.println("Time taken in Seconds : "+timeElapsed.getSeconds()+" Seconds" );
//			extent.HeaderChildNode("the arrival time of feed screen from splash screen " +"Time taken in milliseconds : "+timeElapsed.toMillis()+" milliSeconds");
//			
//			String Processingtimesec=Long.toString(timeElapsed.getSeconds());
//			String Processingtimemilli=Long.toString(timeElapsed.toMillis());	
//			Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
//			extent.extentLogger("", "Feed screen seen  at Time----- " + end);

		}
		
		
		
		
		public void loginWithPhoneNumberTime(String userType) throws Exception {
			
			// navigateToIntroScreen_DisplaylangScreen();
						Time_ExcelUpdate.TestCaseIDNode("MPWA TC005");
//						Time_ExcelUpdate.SlNoNode("2");
						Time_ExcelUpdate.ModuleNode("Login Module");
						Time_ExcelUpdate.TestCaseSummaryNode1("Login Time");
						Time_ExcelUpdate.ExpectedProcessingTime("7.5 Sec");

						extent.HeaderChildNode("Launching hipi ");
//						extent.HeaderChildNode("NonSubscribed User");
						
						TimeStampSwipe("UP", 1);
						
						waitUntilElementDisplayed(MPWAHomePage.objProfileIcon, 10);
						//click on Profile icon
						TimeStampverifyElementPresentAndClick(MPWAHomePage.objProfileIcon, "Profile Icon");
						if (TimeStampverifyElementExist(MPWAProfilePage.objThreeDots, "Three Dots")) {
							TimeStampverifyElementPresentAndClick(MPWAProfilePage.objThreeDots, "Three Dots");
							waitTime(3000);
							//			SwipeUntilFindElement(HipiSettingsPage.objLogOut, "Log out Button");
							//			TimeStampSwipe("UP", 2);
							TimeStampverifyElementPresentAndClick(MPWAProfilePage.objLogOut, "Log out");
							TimeStampverifyElementPresentAndClick(MPWAProfilePage.objYesCTA, "Yes CTA");
							waitTime(4000);
							TimeStampverifyElementPresentAndClick(MPWAHomePage.objProfileIcon, "Profile Icon");
						}
						waitTime(4000);
						TimeStampverifyElementPresentAndClick(MPWALoginPage.objUsePhoneOrEmail,"Use Phone Or Email");
						
						String Username = getParameterFromXML("PhoneNumber");
						String Password = getParameterFromXML("Password");
						
						waitTime(5000);
//						hideKeyboard();
//						TimeStampverifyElementPresentAndClick(MPWALoginPage.objEmailOption, "Email Option");
//						waitTime(4000);
//						TimeStampclick(MPWALoginPage.objEmailIdField, "Email Field");
//						waitTime(4000);
//						TimeStampverifyElementPresentAndClick(MPWALoginPage.objEmailIdField, "Email Field");
//						waitTime(4000);
						waitUntilElementDisplayed(MPWALoginPage.objPhoneNumberTextField, 2);
						TimeStampverifyElementPresentAndClick(MPWALoginPage.objPhoneNumberTextField, "Phone Number Text Field");
						TimeStamptype(MPWALoginPage.objPhoneNumberTextField, Username, "Phone Number Field");
						TimeStamphideKeyboard();
						
						TimeStampverifyElementPresentAndClick(MPWALoginPage.objPasswordField, "Password Field");
//						hideKeyboard();

						TimeStamptype(MPWALoginPage.objPasswordField, Password, "Password field");
//						
						TimeStamphideKeyboard();
						waitTime(5000);
						TimeStampverifyElementPresentAndClick(MPWALoginPage.objLoginBtn, "Login Button");
//						TimeStamptype(MPWALoginPage.objEmailIdField, Username, "Email Field");
//						TimeStamphideKeyboard();
//						TimeStampverifyElementPresentAndClick(MPWALoginPage.objLoginBtn, "Login Button");
						Instant start=Instant.now();
						logger.info("Start Time : " + start);
//						extent.extentLogger("", "<b>Start Time : " + start+"<b>");
					if (waitUntilElementDisplayed(MPWAHomePage.objForYou, 2)) {
							logger.info("User is able to see Home screen");
//							extent.extentLogger("", "User is able to see Home screen");
							Instant end=Instant.now();
							logger.info("End Time : " + end);
//							extent.extentLogger("", "<b>End Time : " + end+"<b>");
							Duration processingTime = Duration.between(start, end);
							logger.info("Processing time: " + processingTime);
							String Processingtimesec=Long.toString(processingTime.getSeconds());
							String Processingtimemilli=Long.toString(processingTime.toMillis());	
							Time_ExcelUpdate.timeStampNode(Processingtimesec+"."+Processingtimemilli + " Sec");
							extent.extentLogger("", "<b>Processing time: " + processingTime+"<b>");

//							extent.HeaderChildNode("<b>Processing time: " + processingTime+"<b>");
						}else {
							logger.error("Processing time calculation failed");
							Time_ExcelUpdate.timeStampNode("Processing time calculation failed");
							extent.extentLoggerFail("", "MPWA - Processing time calculation failed");	
						}
					
				
//						waitUntilElementDisplayed(HipiHomePage.objForYou, 2000);
						//click on feed button
					TimeStampverifyElementPresentAndClick(MPWAHomePage.objHomeIcon, "Home Icon");
						
		}
		
		public void chromeLoginPopup() throws Exception{
			
			
				getDriver().get("www.hipi.co.in");
				
				waitTime(5000);
				if(TimeStampverifyElementExist(HipiHomePage.objEngleshButton, "Englesh Icon")) {
					System.out.println("User is able to see Englesh Icon");
					TimeStampclick(HipiHomePage.objEngleshButton, "Englesh Icon");
					TimeStampclick(HipiHomePage.objCrossIcon, "Cross Icon");
				}else {
					
					System.out.println("User is not able to see Englesh Icon");
					
				}
		}
}
	
