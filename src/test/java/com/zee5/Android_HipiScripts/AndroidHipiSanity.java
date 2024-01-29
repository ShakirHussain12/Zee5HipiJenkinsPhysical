package com.zee5.Android_HipiScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterHipiSanityBusinessLogic;
import com.utility.Utilities;

public class AndroidHipiSanity {
	
	
	private Zee5ApplicasterHipiSanityBusinessLogic ZEE5ApplicasterHipiSanityBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		ZEE5ApplicasterHipiSanityBusinessLogic = new Zee5ApplicasterHipiSanityBusinessLogic("zee");
	}
	
	//-----------------------------Himadri : SaveAsDraft---------------------------------
	@Test(priority = 1)
	@Parameters({ "userType"})
	public void saveasdraft(String userType) throws Exception{
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingSaveAsDraft(userType);
	}
	
	
	
	//-----------------------------Basavaraj : UploadFromGallery---------------------------------
	@Test(priority = 2)
	@Parameters({ "userType"})
	public void UploadFromGallery(String userType) throws Exception{
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
	
		ZEE5ApplicasterHipiSanityBusinessLogic.UploadFromGalleryValidation(userType);
	}
	
	
	
	
	//-----------------------------Basavaraj : CameraToolsPreShoot---------------------------------
	@Test(priority = 3)
	@Parameters({ "userType"})
	public void CameraToolsPreShoot(String userType) throws Exception{
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
	
		ZEE5ApplicasterHipiSanityBusinessLogic.CameraToolsPreShootValidation(userType);
	}
	
	
	//-----------------------------Basavaraj : UploadPostingScreen---------------------------------
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void UploadPostingScreen(String userType) throws Exception{
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
	
		ZEE5ApplicasterHipiSanityBusinessLogic.UploadPostingScreenValidation(userType);
	}
	
	
	
	
	//-----------------------------Himadri : Scheduling---------------------------------
	@Test(priority = 5)
	@Parameters({ "userType"})
	public void scheduling(String userType) throws Exception{
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingScheduling(userType);
		
	}
	
	
	

	//-----------------------------Manasa : HipiHomeScreen---------------------------------
	@Test(priority = 6)
	@Parameters({ "userType" })
	public void ZeeHipiHomeScreenValidation(String userType) throws Exception {
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiSanityBusinessLogic.hipiHomeScreenValidation(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.popularCardsValidation(userType);
		
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiSanityBusinessLogic.denyPermissionValidation(userType);
		
	}
	

	
	//-----------------------------Gauthami : PlayerView---------------------------------
	@Test(priority = 7)
	@Parameters({ "userType"})
	public void Playerview(String userType) throws Exception{
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
	
		ZEE5ApplicasterHipiSanityBusinessLogic.Taggeduserprofile(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.Soundusedvalidation(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.Favouritesorlikesvalidation(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.NotInterestedvalidation(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.Addtomyfavouritesvalidation(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.Effectvalidation(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.Savevideovalidation(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.PlayerviewValidation(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.CommentsectionValidation(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.ReportVideo(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.followuser(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.likeandunlikevalidation(userType);
		
		ZEE5ApplicasterHipiSanityBusinessLogic.VideoLikeDislikeFunctionality(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.CommentsFunctionality(userType);
		
	}
	
	
	
	
	//-----------------------------Himadri : viewerprofile---------------------------------
	@Test(priority = 8)
	@Parameters({ "userType"})
	public void viewerprofile(String userType) throws Exception{
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingViewerProfile(userType);
		
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
    	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
    	
    	ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingDraftVideoUnavailable(userType);
  }

	
	
	
	//-----------------------------Kartheek : Clip Segmentation---------------------------------
	@Test(priority = 9)
	@Parameters({ "userType"})
	public void clipSegmentation(String userType) throws Exception{
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiSanityBusinessLogic.clipSegmentationModule(userType);
	}
	
	
	//-----------------------------Kartheek : HipiStar-----------------------------------------
	@Test(priority = 10)
	@Parameters({ "userType"})
	public void hipiStar(String userType) throws Exception {
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiSanityBusinessLogic.guestUserViewHipiStarIconAnotherUserProfiles(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.viewHipiStarIconAnotherUserProfiles(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.checkStarIconIsDisplayedOnUserProfile(userType);
	
	}
	
	
	
	//-----------------------------Bhavana : AddsoundPreshoot-----------------------------------------
    @Test(priority = 11) //only for logged in user
    @Parameters({ "userType" })
    public void AddsoundPreshootValidation(String userType) throws Exception {
    	ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
    	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
    	
    	ZEE5ApplicasterHipiSanityBusinessLogic.BeforeShootingMethod1(userType);

    	ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
    	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);

    	ZEE5ApplicasterHipiSanityBusinessLogic.BeforeShootingMethod2(userType);		
    }
	
	
	
	
	//-----------------------------Himadri : HiPiViewerProfile-----------------------------------------
      @Test(priority = 12) //only for logged in user
      @Parameters({ "userType" })
      public void HiPiViewerProfile(String userType) throws Exception {
    	ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
      	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
      	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
      	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
      	
      	ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingHiPiViewerProfile(userType);
      }
	
	
	
    //-----------------------------Kartheek : playerViewMore-----------------------------------------
    @Test(priority = 13)
  	@Parameters({ "userType"})
  	public void playerViewMore(String userType) throws Exception {
  		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
  		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
  
  		ZEE5ApplicasterHipiSanityBusinessLogic.playerViewMoreGuest(userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.playerViewMoreNonSubscribedUser(userType);
  	}
  	
    
    
  //-----------------------------Kartheek : playerVerticalPreview-----------------------------------------
  	@Test(priority = 14)
  	@Parameters({ "userType"})
  	public void playerVerticalPreview(String userType) throws Exception {
  		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
  		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
 
  		ZEE5ApplicasterHipiSanityBusinessLogic.playerVerticalPreviewGuest(userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.playerVerticalPreviewNonSub(userType);
  	}
	

  //-----------------------------Kartheek : hipiMyProfile-----------------------------------------
  	@Test(priority = 15)
	@Parameters({ "userType"})
	public void hipiMyProfile(String userType) throws Exception {
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiSanityBusinessLogic.hipiMyProfile(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.guestHipiMyProfile(userType);

	}
	
	
  //-----------------------------Kartheek : creatorProfile-----------------------------------------
  	@Test(priority = 16)
	@Parameters({ "userType"})
	public void creatorProfile(String userType) throws Exception {
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiSanityBusinessLogic.creatorProfile(userType);
	}
	
	
	
  	
  	
	
	//-----------------------------Himadri : Filter-----------------------------------------
    @Test(priority = 17)
    @Parameters({ "userType" })
    public void Filter(String userType) throws Exception {
  	ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
    	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
 
    	ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingFilter(userType); 
    }
	
  	
    
    
    //-----------------------------Himadri : Filter pre shoot-----------------------------------------
    @Test(priority = 18)
      @Parameters({ "userType" })
      public void FilterPreShoot(String userType) throws Exception {
    	ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
      	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
      	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
      	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
      	
      	ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingFilterPreShoot(userType);
      }
	
    //-----------------------------Himadri : Creator tool-----------------------------------------
    @Test(priority = 19)
      @Parameters({ "userType" })
      public void CreatorTool(String userType) throws Exception {
    	ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
      	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
      	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
      	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
      	
      	ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingCreatorTool(userType);
      }
	
    //-----------------------------Himadri : Background effect-----------------------------------------
      @Test(priority = 20)
        @Parameters({ "userType" })
        public void BackgroundEffect(String userType) throws Exception {
      		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
        	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
        	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
        	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
        	
        	ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingBackgroundEffect(userType);
        }

    //-----------------------------Kartheek : EffectDetailsPage-----------------------------------------  
   @Test(priority = 21)
  	@Parameters({ "userType"})
  	public void effectDetailsPage(String userType) throws Exception{
    	ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
    	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);

  		ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingEffectsDetailsPage(userType);
  	}
      
      
    //-----------------------------Kartheek : soundDetailsPage-----------------------------------------  
    @Test(priority = 22)
	@Parameters({ "userType"})
	public void soundDetailsPage(String userType) throws Exception {
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);

		ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingSoundDetailsPage(userType);
	}
    
  	
  //-----------------------------Kartheek : HashtagDetailPage----------------------------------------- 
    @Test(priority = 23)
	@Parameters({ "userType"})
	public void hashtagDetailPage(String userType) throws Exception {
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingHashtagDetailPage(userType);
	}
    
    
    
  //-----------------------------Veena : Popular---------------------------------
  	@Test(priority = 24)
  	@Parameters({ "userType"})
  	public void ValidationOfPopular(String userType) throws Exception{
  		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
  		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
  	
  		ZEE5ApplicasterHipiSanityBusinessLogic.ValidationOfPopular(userType);
  	}
    
    
    
  	
  	
  	
  //-----------------------------Satish : Profile Settings---------------------------------
  	@Test(priority = 25)
  	@Parameters({ "userType"})
  	public void ProfileSettings(String userType) throws Exception{
  		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
  		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.separateLogin(userType);
  	
  		ZEE5ApplicasterHipiSanityBusinessLogic.ProfileSettings(userType);
  		
  	}
    
    
  	
  	 //-----------------------------Himadri : Notifications---------------------------------
  	@Test(priority = 26)
    @Parameters({ "userType" })
    public void Notifications(String userType) throws Exception {
  		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
    	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
    	
    	ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingLikeNotification(userType);

    	
    	ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
    	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);

    	ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingMultipleLikesNotification(userType);

    	ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
    	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);

   		ZEE5ApplicasterHipiSanityBusinessLogic.ValidatingCommentsNotification(userType);
    } 
  	
  	
  	
  	 //--------------------------Kartheek :  Effects-Preshoot--------------------------------
  	@Test(priority = 27)
  	@Parameters({ "userType"})
  	public void effectsPreshoot(String userType) throws Exception {
		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
		ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
		
		ZEE5ApplicasterHipiSanityBusinessLogic.effectsPreshoot(userType);
		
	}
  	
  	
  	 //--------------------------Bhavana :  AddSound--------------------------------
    @Test(priority = 28) 
    @Parameters({ "userType" })
    public void AddSoundPOSTshootValidation(String userType) throws Exception {
    	ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
    	ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
    	ZEE5ApplicasterHipiSanityBusinessLogic.LoginAndNivigateToHipi(userType);
    	
    	ZEE5ApplicasterHipiSanityBusinessLogic.PostShootingValidation(userType);
    }
  	
  	
    //-----------------------------Satish : HiPi Search Results---------------------------------
  	@Test(priority = 29)  
  	@Parameters({ "userType"})
  	public void HiPiSearchResults(String userType) throws Exception{
  		ZEE5ApplicasterHipiSanityBusinessLogic.relaunch(true);
  		ZEE5ApplicasterHipiSanityBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.DisplayAndContentLanguage(userType);
  		ZEE5ApplicasterHipiSanityBusinessLogic.separateLogin(userType);
  		
  		ZEE5ApplicasterHipiSanityBusinessLogic.HiPiSearchResults(userType);
  		
  	}
	
  	
  	
  	
  	
  	
  	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		ZEE5ApplicasterHipiSanityBusinessLogic.tearDown();	
	}
	

}
