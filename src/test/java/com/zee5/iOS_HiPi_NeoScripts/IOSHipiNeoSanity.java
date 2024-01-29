package com.zee5.iOS_HiPi_NeoScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasteriOSHipiNeoSanityBusinessLogic;

public class IOSHipiNeoSanity {
private Zee5ApplicasteriOSHipiNeoSanityBusinessLogic Zee5ApplicasterHipiNeoBusinessLogic;
	
	
@BeforeTest
public void init() throws InterruptedException {

	Zee5ApplicasterHipiNeoBusinessLogic = new Zee5ApplicasteriOSHipiNeoSanityBusinessLogic("hipi");
}

	@Test(priority = 0)
	@Parameters({ "userType", "InstallBuild" })
	public void ZeeAppInstallationLaunch(String userType,String InstallBuild) throws Exception {
		//Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		
		
		
	}

	
	//@Test(priority = 1)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyAppLaunch_T002_and_T004(String userType,String InstallBuild) throws Exception {
	//	Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		System.out.println("AppLauchModule");
		//Zee5ApplicasterHipiNeoBusinessLogic.AppLaunchModule();
		
	}
	
	@Test(priority = 2)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen(String userType,String InstallBuild) throws Exception {
//		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
//		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		//Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T005(userType);--Feed Screen-No unique identifier
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_GT006_NT019(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T007_T020(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T009(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_GT011_NT023(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T012(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T013(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T029_T030(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T034(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T038(userType);
//=======================================HashTag=====================================================		
		//Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_HashTag_T041(userType);
		//Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_HashTag_T042(userType);-----HashTag does not have unique identifier
		//Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_HashTag_T043(userType);-----HashTag does not have unique identifier
//===========================================sound=================================================
		//Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Sound_T045(userType);
		//Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Sound_T046(userType);
		//Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Sound_T047(userType);
		//Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Sound_T048(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Sound_T049(userType);
//====================================profile======================================================
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Profile_T052(userType);
			
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@AfterClass
	public void tearDownApp() {
		System.out.println("Quit the App");
		Zee5ApplicasterHipiNeoBusinessLogic.tearDown();	
	}
}
