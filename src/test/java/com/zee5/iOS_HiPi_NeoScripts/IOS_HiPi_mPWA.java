package com.zee5.iOS_HiPi_NeoScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5mWebiOSHipiNeoSanityBusinessLogic;
import com.excel.Time_ExcelUpdate;

public class IOS_HiPi_mPWA {
	private Zee5mWebiOSHipiNeoSanityBusinessLogic Zee5mWebHipiNeoBusinessLogic;


	@BeforeTest
	public void init() throws InterruptedException {

		Zee5mWebHipiNeoBusinessLogic = new Zee5mWebiOSHipiNeoSanityBusinessLogic("safari");  
	}

	
	@Test(priority=0)
	@Parameters({"userType","InstallBuild"})
	public void getUrl(String userType,String InstallBuild) throws Exception {
		Zee5mWebHipiNeoBusinessLogic.closeSafariTabs();
		Zee5mWebHipiNeoBusinessLogic.getURl();
		Zee5mWebHipiNeoBusinessLogic.SwipeUpAnimation();
		Zee5mWebHipiNeoBusinessLogic.getURl();
		//	Zee5mWebHipiNeoBusinessLogic.TimeStampLoginAndNivigateToHipi(userType);
		}
	
	@Test(priority =1)
	@Parameters({ "userType", "InstallBuild" })
	public void TimeTakenToAppNavigationToAppClickingOnCreateButton(String userType,String InstallBuild) throws Exception{
	
		Zee5mWebHipiNeoBusinessLogic.NavigationToAppFromCreateButton(userType,"MPWA_TC003");
	
	}
	
	
	
	@Test(priority =2)
	@Parameters({ "userType", "InstallBuild" })
	public void TimeTakenToAppNavigationToAppStoreClickingOnCreateButton(String userType,String InstallBuild) throws Exception{
	
	

		Zee5mWebHipiNeoBusinessLogic.NavigationToAppStoreFromCreateButton(userType,"MPWA_TC004");
	
	}
	
	
	
		@Test(priority =3)
		@Parameters({ "userType", "InstallBuild" })
		public void MPWATimeTakenToloadDiscoverPage(String userType,String InstallBuild) throws Exception{
		
			Zee5mWebHipiNeoBusinessLogic.discover_Screen_LoadTime(userType,"MPWA_TC005");
		}
		@Test(priority =4)
		@Parameters({ "userType", "InstallBuild" })
		public void TimeTakenToloadSearshResultInDiscoverPage(String userType,String InstallBuild) throws Exception{
		
			Zee5mWebHipiNeoBusinessLogic.searchResultScreen(userType,"MPWA_TC006");
		
		}
		
		@Test(priority =5)
		@Parameters({ "userType", "InstallBuild" })
		public void TimeTakenToloadAutoSuSearshResultInDiscoverPage(String userType,String InstallBuild) throws Exception{
		
			Zee5mWebHipiNeoBusinessLogic.searchAutoSuggestionsResultScreen(userType,"MPWA_TC007");
		
		}
		
		
	
	@Test(priority =6)
	@Parameters({ "userType", "InstallBuild" })
	public void FeedScreenArrivalTime(String userType, String InstallBuild) throws Exception{
		
		//Zee5mWebHipiNeoBusinessLogic.FeedScreenArrivalTimeFromSplashScreen(userType);
		
		Zee5mWebHipiNeoBusinessLogic.searchResults("shivangi", "MPWA_TC008");
		Zee5mWebHipiNeoBusinessLogic.searchResults("shraddha arya", "MPWA_TC009");
		Zee5mWebHipiNeoBusinessLogic.searchResults("punjabi singers", "MPWA_TC0010");
		Zee5mWebHipiNeoBusinessLogic.searchResults("bollywood actress", "MPWA_TC0011");
		Zee5mWebHipiNeoBusinessLogic.searchResults("xxx", "MPWA_TC0012");
		Zee5mWebHipiNeoBusinessLogic.searchResults("punjabi videos", "MPWA_TC0013");
		Zee5mWebHipiNeoBusinessLogic.searchResults("funny video", "MPWA_TC0014");
	}
//	
//	@Test(priority =2)
//	@Parameters({ "userType", "InstallBuild" })
//	public void TimeTakenToLikeAvideo(String userType,String InstallBuild) throws Exception{
//	
//		Zee5mWebHipiNeoBusinessLogic.LikeVideo(userType);
//	}
//	
	 @AfterClass
     public void tearDownApp() {
     System.out.println("Quit the App");
     Zee5mWebHipiNeoBusinessLogic.tearDown();	
     Time_ExcelUpdate.AutoFitColumn();
   }	
	
	
	
	
}
