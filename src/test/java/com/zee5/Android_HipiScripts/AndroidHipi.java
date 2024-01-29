package com.zee5.Android_HipiScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterHipiBusinessLogic;
import com.utility.Utilities;

public class AndroidHipi {
	private Zee5ApplicasterHipiBusinessLogic ZEE5ApplicasterHipiBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		ZEE5ApplicasterHipiBusinessLogic = new Zee5ApplicasterHipiBusinessLogic("zee");
	}

	//-------------------------Gauthami : ZeeAppInstallation&Launch--------------------------------------
//	@Test(priority = 0)
	@Parameters({ "userType"})
	public void ZeeAppInstallationLaunch(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		//ZEE5ApplicasterHipiBusinessLogic.BrowseForFreeSubscribeAndPrepaidCode(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);
	
	}

	//-------------------------Gauthami : EffectDetailPage--------------------------------------
//	@Test(priority=1)
	@Parameters({"userType"})
	public void ZeeHipiEffectDetailpage(String userType) throws Exception{
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiBusinessLogic.Effectdetailpage(userType);
	}
	
	
	//-------------------------Himadri : Navigation Bar--------------------------------------
//	@Test(priority = 2)
	@Parameters({ "userType"})
	public void ZeeHipiNavigationBar(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiBusinessLogic.ValidateNavigationBar(userType);
	}

	//-------------------------Gauthami : Popular--------------------------------------	
//	@Test(priority = 3)
	@Parameters({ "userType"})
	public void ZeeHipiPopularscreen(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiBusinessLogic.Popularscreen(userType);
	
	}
	
	
	
	//-------------------------Gauthami : GuestUserEntersHipi--------------------------------------	
//	@Test(priority = 4)
	@Parameters({ "userType" }) 
	public void ZeeHipiGuestUserEntersHipi(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiBusinessLogic.GuestUserloggedinAndComingFirstTime(userType); 
	 }
	
	
	
	//-------------------------Gauthami : FeedViewer--------------------------------------	
//	@Test(priority = 5)
	@Parameters({ "userType" }) 
	public void ZeeHipiFeedViewer(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiBusinessLogic.FeedViewer(userType);
	 }
	
	
	
	//-------------------------Himadri : HipiFeedScreen--------------------------------------	
//	@Test(priority = 6)
	@Parameters({ "userType"})
	public void ZeeHipiFeedScreen(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiBusinessLogic.ValidatingHiPiFeedScreen(userType);
		
	}
	
	
	
	//-------------------------Basavaraj : AddSoundPostShoot--------------------------------------	
//	@Test(priority = 7)
	@Parameters({ "userType" }) 
	public void ZeeHipiAddSoundPostShoot(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiBusinessLogic.ValidatingAddSoundPostShoot(userType);
	 }
	
	
	
	//-------------------------Gauthami : HipiHomeScreen+EntryPointToZee5--------------------------------------	
//	@Test(priority = 8)
	@Parameters({ "userType" }) 
	public void ValidatingHomeScreen(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiBusinessLogic.HipiHomeScreen(userType);
		ZEE5ApplicasterHipiBusinessLogic.EntryPointToZee5(userType);
	 }
	
	
	
	
	//-------------------------Gauthami : ApplyFilterduringshooting--------------------------------------	
//	@Test(priority = 9)
	@Parameters({ "userType" }) 
	public void ApplyingFilterDuringShoot(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiBusinessLogic.ApplyFilterduringshooting(userType);
	 }
	
	
	
	
	//-------------------------Gauthami : ApplyEffectduringshooting--------------------------------------	
//	@Test(priority = 10)
	@Parameters({ "userType" }) 
	public void ApplyEffectduringshooting(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiBusinessLogic.ApplyEffectduringshooting(userType);
	 }
	
	
	
	//-------------------------Gauthami : HashTagDetailPage--------------------------------------	
//	@Test(priority = 11)
	@Parameters({ "userType" }) 
	public void HashtagDetailPage(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiBusinessLogic.HashtagDetailPage(userType);
	 }
	
	
	
	//-------------------------Gauthami : Navigationbar--------------------------------------	
//	@Test(priority = 12)
	@Parameters({ "userType" }) 
	public void Navigationbar(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiBusinessLogic.ValidatingNavigationBar(userType);
		
	 }
	
	
	
	//-------------------------Gauthami : --------------------------------------
//	@Test(priority = 13)
	@Parameters({ "userType"})
	public void accessDeviceLocation(String userType) throws Exception {
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.VerifyLoginWithEmailId(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);
	}
	
	
	
	
	//-------------------------Gauthami : HelpCenter--------------------------------------
//	@Test(priority=14)
	@Parameters({"userType"})
	public void HelpCenter(String userType) throws Exception{
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiBusinessLogic.HelpCenter(userType);
	}
	
	
	//-------------------------Gauthami : Profile--------------------------------------
	@Test(priority = 15)
	@Parameters({ "userType" })
	public void Profile(String userType) throws Exception {
		
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiBusinessLogic.ValidatingProfile(userType);
		
	}
	
	
	
	
	//-------------------------Himadri : CreateVideo--------------------------------------	
	@Test(priority = 16)
	@Parameters({ "userType"})
	public void ZeeHipiCreateVideo(String userType) throws Exception {
	ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
	ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
	ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
	ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);
		
	ZEE5ApplicasterHipiBusinessLogic.ValidatingZeeHipiCreateVideo(userType);	
		
	}
	
	
	
	
	
	//-------------------------Himadri : UploadVideo--------------------------------------	
	@Test(priority = 17)
	@Parameters({ "userType"})
	public void ZeeHipiUploadVideo(String userType) throws Exception {
	ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
	ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
	ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
	ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);
		
	ZEE5ApplicasterHipiBusinessLogic.ValidatingZeeHipiUploadVideo(userType);
		
	}
	
	
	
	
	
	//-------------------------Manasa : SoundDetailPage--------------------------------------	
	@Test(priority = 18)
	@Parameters({ "userType"})
	public void ZeeHipiSoundDetailPage(String userType) throws Exception {
	ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
	ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
	ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
	ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);

	ZEE5ApplicasterHipiBusinessLogic.soundDetailPageValidation(userType);
	}
	
	
	
	//-------------------------Manasa : Discover--------------------------------------	
	@Test(priority = 19)
	@Parameters({"userType"})
	public void discoverPageValidation(String userType) throws Exception{
		ZEE5ApplicasterHipiBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiBusinessLogic.discoverPageValidation(userType);
	}

	
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		ZEE5ApplicasterHipiBusinessLogic.tearDown();
		

	}

}
