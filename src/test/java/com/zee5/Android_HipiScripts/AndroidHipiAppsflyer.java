package com.zee5.Android_HipiScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterHipiAppsFlyerBusinessLogic;
import com.utility.Utilities;

public class AndroidHipiAppsflyer {
	
	
	private Zee5ApplicasterHipiAppsFlyerBusinessLogic zee5ApplicasterHipiAppsFlyerBusinessLogic;
	
	
	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		zee5ApplicasterHipiAppsFlyerBusinessLogic = new Zee5ApplicasterHipiAppsFlyerBusinessLogic("zee");
	}
	
	
	
	@Test(priority = 1)
	@Parameters({ "userType"})
	public void HiPiEventsValidation(String userType) throws Exception{
		//Clear App Data
		zee5ApplicasterHipiAppsFlyerBusinessLogic.clearAppData("zee");
		//Trigger AppsFlyerLink to capture events
		zee5ApplicasterHipiAppsFlyerBusinessLogic.triggerAppsflyerLink("zee");
		//launch HiPi app through playstore and perform functionality
		zee5ApplicasterHipiAppsFlyerBusinessLogic.launchapp();
		
		zee5ApplicasterHipiAppsFlyerBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		
		//zee5ApplicasterHipiAppsFlyerBusinessLogic.LoginAndNivigateToHipi(userType);
		
		zee5ApplicasterHipiAppsFlyerBusinessLogic.HiPiRegisterAndUploadValidation(userType);
		
		zee5ApplicasterHipiAppsFlyerBusinessLogic.HiPiPlaybackValidation(userType);
		
//		zee5ApplicasterHipiAppsFlyerBusinessLogic.downloadAppsFlyerReport();
		
//		zee5ApplicasterHipiAppsFlyerBusinessLogic.extractFilesForValidation(userType);
		
	}
	
	
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		zee5ApplicasterHipiAppsFlyerBusinessLogic.tearDown();	
	}
	
	
	
	
}
