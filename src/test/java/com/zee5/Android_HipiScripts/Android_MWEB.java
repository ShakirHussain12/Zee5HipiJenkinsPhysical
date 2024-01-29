package com.zee5.Android_HipiScripts;

import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.excel.Time_ExcelUpdate;
import com.utility.Utilities;

public class Android_MWEB {
	private com.business.zee.AndroidHipiMPWABusinessLogic AndroidHipiMPWABusinessLogic;

	@BeforeTest
	public void AppLaunch() throws Exception {
		System.out.println("Launching MWEB App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		AndroidHipiMPWABusinessLogic = new com.business.zee.AndroidHipiMPWABusinessLogic("Chrome");
		
		
		
	} 
	
	@BeforeMethod
	public void chromePopup() throws Exception{
		System.out.println("Handling chrome login popup");
		AndroidHipiMPWABusinessLogic.chromeLoginPopup();
		
	}
	@Test(priority = 0)
	@Parameters({ "userType"})
	public void launchApptime(String userType) throws Exception {

		AndroidHipiMPWABusinessLogic.launchApptime();	
		AndroidHipiMPWABusinessLogic.launchApp_And_Check_ProgressBar();
		
		AndroidHipiMPWABusinessLogic.verifyProgressBar();

	}

	@Test(priority = 1)
	@Parameters({ "userType"})
	public void Login(String userType) throws Exception {
				AndroidHipiMPWABusinessLogic.SwipeUpForNextVideoAnimation(userType);
//		AndroidHipiMPWABusinessLogic.loginTime(userType);
		
//		AndroidHipiMPWABusinessLogic.loginWithPhoneNumberTime(userType);

	}
	
	
	
	@Test(priority = 2)
	@Parameters({ "userType"})
	public void DiscoverScreenLoadTime(String userType) throws Exception {
		AndroidHipiMPWABusinessLogic.DiscoverScreenLoadTime();
	} 	

	@Test(priority = 3)
	@Parameters({ "userType"})
	public void AutoSuggestionTime(String userType) throws Exception {

		AndroidHipiMPWABusinessLogic.AutoSuggestionTime("kundali");

	}
	
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void OnClickingBannerScreenLoadTime(String userType) throws Exception {

		AndroidHipiMPWABusinessLogic.OnClickingBannerScreenLoadTime(userType);

	}

	@Test(priority = 5)
	@Parameters({ "userType"})
	public void hashtagDetailPageTime(String userType) throws Exception {

		AndroidHipiMPWABusinessLogic.hashtagDetailPageTime();

	}

	@Test(priority =6)
	@Parameters({ "userType"})
	public void BannerLoadTime(String userType) throws Exception {

		AndroidHipiMPWABusinessLogic.BannerLoadTime();

	}
	@Test(priority = 7)
	@Parameters({ "userType"})
	public void SearchScreenTimePostSearchingAKeyword(String userType) throws Exception {

		AndroidHipiMPWABusinessLogic.SearchScreenTimePostSearchingAKeyword("kundali");
		
	}
	
	@Test(priority = 8)
	@Parameters({ "userType"})
	public void Search(String userType) throws Exception {
		AndroidHipiMPWABusinessLogic.searchResults("Love","MPWA  TC012");
		AndroidHipiMPWABusinessLogic.searchResults("shraddha arya","MPWA  TC013");
		AndroidHipiMPWABusinessLogic.searchResults("punjabi singers","MPWA  TC014");
		AndroidHipiMPWABusinessLogic.searchResults("Nora Fatehi","MPWA  TC015");
		AndroidHipiMPWABusinessLogic.searchResults("punjabi videos", "MPWA  TC016");
		AndroidHipiMPWABusinessLogic.searchResults("funny video", "MPWA  TC017");
		//AndroidHipiMPWABusinessLogic.searchResults("xxx", "MPWA  TC015");
	}
	

	@Test(priority = 9)
	@Parameters({ "userType"})
	public void WithAppWithOutAppTCs(String userType) throws Exception {

//	AndroidHipiMPWABusinessLogic.commentWithApp(userType);
//	AndroidHipiMPWABusinessLogic.relaunch(false);

//	AndroidHipiMPWABusinessLogic.TimeStamprelaunch(false);
	AndroidHipiMPWABusinessLogic.openOptionINMPWA(userType);
//	AndroidHipiMPWABusinessLogic.TimeStamprelaunch(false);
//	AndroidHipiMPWABusinessLogic.editProfile(userType);
//	AndroidHipiMPWABusinessLogic.relaunch(false);
//	AndroidHipiMPWABusinessLogic.withOutAppCommentButton(userType);
//	AndroidHipiMPWABusinessLogic.relaunch(false);
//	AndroidHipiMPWABusinessLogic.withOutAppCreatorButton(userType);
//	AndroidHipiMPWABusinessLogic.relaunch(false);
//	AndroidHipiMPWABusinessLogic.openOptionINMPWAWithoutApp(userType);
//	AndroidHipiMPWABusinessLogic.relaunch(false);
//	AndroidHipiMPWABusinessLogic.WithOutAppEditProfile(userType);
	
	}
	@Test(priority = 10)
	@Parameters({ "userType"})
	public void logout(String userType) throws Exception {
		AndroidHipiMPWABusinessLogic.TimeStamprelaunch(false);
//		AndroidHipiMPWABusinessLogic.TimeStamplogOut();
		AndroidHipiMPWABusinessLogic.CreatorWithApp(userType);
	}


	
	@AfterTest						
	public void tearDownApp() {		
		System.out.println("Quit the App");
		AndroidHipiMPWABusinessLogic.tearDown();	
		Time_ExcelUpdate.AutoFitColumn();
	}		
}
