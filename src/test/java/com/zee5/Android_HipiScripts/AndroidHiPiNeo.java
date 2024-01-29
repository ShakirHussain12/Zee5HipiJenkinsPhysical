package com.zee5.Android_HipiScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utility.Utilities;



public class AndroidHiPiNeo {
	private com.business.zee.Zee5ApplicasterHipiNeoBusinessLogic Zee5ApplicasterHipiNeoBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		Zee5ApplicasterHipiNeoBusinessLogic = new com.business.zee.Zee5ApplicasterHipiNeoBusinessLogic("zee");
	}
	
	@Test(priority = 0)
	@Parameters({ "userType"})
	public void ZeeAppInstallationLaunch(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
//		Zee5ApplicasterHipiNeoBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		
	}
	
		
//============================================Shop >In app Browser=====================================================================
	@Test(priority = 1)				
	@Parameters({ "userType"})
	public void ShopInAppBrowserT397_To_T408(String userType) throws Exception {
	
		
//		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		
		
//		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyInAppBrowserT397_T399_T402_T404(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickingUponArowMarkT398_T400_T403_T405(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.closingInAppBrowser_T401_T406(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyThatShoppableVideoInsideDiscoverPage_T407_T408(userType,"Himanshi");

		
		
	}
//============================================Shoppable==================================================================================	
/*
	@Test(priority = 2)
	@Parameters({ "userType"})
		public void Shoppable__T1244__To__T1246(String userType) throws Exception {
		
	
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		if(userType.equalsIgnoreCase("Nonsubscribeduser")) {
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
			
		Zee5ApplicasterHipiNeoBusinessLogic.seeShoppableTabInProfile__T1244(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shoppableTabInProfile__T1245(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkWhetherDisclaimer__T1246(userType);
		
		}
	}
//======================================Shop page > Mini player====================================================================
	
	@Test(priority = 3)
	@Parameters({ "userType"})
	public void shopPageMiniPlayer__T326__TO__T347(String userType) throws Exception {
	
		
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		
		if(userType.equalsIgnoreCase("Guest") || userType.equalsIgnoreCase("Nonsubscribeduser")) {
			
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.verifyforMiniPlayer__T326__T337(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerByClckingCorouselSheet_T327__T338(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerBehaviour__T329__T340(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.closingMiniPlayerBehaviour__T330__T341(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickOnMiniPlayer__T332__T343(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerOnSaveMomentTab__T335__T346(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.behaviorOfMiniPlayerWhenUserCloses__T334__T345(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.afterClosingTheProductThirdPartySite__T336__T347(userType);
		
		}
	}
	
//======================================Shop Button====================================================================
	@Test(priority = 4)
	@Parameters({ "userType"})
	
	public void shopButton__T184__To__T191AndT202__NonSub__T220__T227AndT238(String userType) throws Exception {
	
		
			Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
			
			
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shopValidation__T184__T220(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.scrollsTheVideoForFewMins__T191__T227(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userWatchingShoppableVideos__T186__T222(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickableFunctionalityOnShopButton__T185__T221(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shopButtonDisplayedComingFromAnyOtherTabs__T188__T224(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shopButtonShouldNotVisibleWhenUserInotherTab__T189__T225(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userRedirectToShopPage__T190__T226(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.redIndicatorShouldBeDisplayed__T202__T238(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.nonShopableVideoValidation__T187__T223(userType);
		
		
	
	}	
	
	//======================================Shop Page> Saved Moment====================================================================
		@Test(priority = 5)
		@Parameters({ "userType"})
		public void shopPageSavedMoment(String userType) throws Exception {
			
			Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
			Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.savedMomentTab__T349__T356(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.savedMomenttabUI__T350__T357(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.expandAllThePanelsAtATime__T359(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.expandedProductsDetailsPage__T360(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.switchBetweenTheOutfitAccessoriesBeautyHairTab__T361(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.scrollDownScrollUp__T363__T374(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.clickingOnTheMiniPlayer__T364__T375(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.productImagesAreClickable__T365__T376(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.arrowButtonsAreClickable__T366__T377(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.closingTheShopDetailsPage__T369__T380(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.seeRespectiveProduct__T362(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.lessButtonOnTheProductDetailsPage__T368__T379(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.thirdPartySiteNameBelowTheProductImages__T371__T382(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.navigateToProductWebsite__T372____T383(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.ArrowMarkUserNavigateToProductWebSite__T373__T384(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.productCardDetails__T370__T381(userType);
			
			
		}
		
		//=====================================Shop >Beauty=====================================================================
		@Test(priority = 6)
		@Parameters({ "userType"})
		public void shopBeauty(String userType) throws Exception {
			
			Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
			Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.beautyBannerImage__T385__T388(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.beatyDetails__T386__T389(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.beautyCardImageClickAndGetButton__T387__T390(userType);
			
		}
			
		//=====================================Shop >Hair=====================================================================
				@Test(priority = 7)
				@Parameters({ "userType"})
				public void shopHair(String userType) throws Exception {
					
					Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
					Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.beautyBannerImageHair__T391__T395(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.beatyDetailsHair__T392__T394(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.beautyCardImageClickAndGetButtonHair__T387__T396(userType);
					
				}
				
				
				
//=====================================Shoppable Vidoes=====================================================================
				@Test(priority = 8)
				@Parameters({ "userType"})
				public void shoppableVidoes(String userType) throws Exception {
					
					Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
					Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.videoIsShopable__T174(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.shoppableVideo__T175__T179(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.shoppableVideo__T176__T180(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.shoppableVideoFollowingSection__T177(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.shopableVideosArePresentOnTheFeed__T178__T182(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.shoppableVideoFollowingSectionNonSub__T181(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.saveLookCTANavigationOnShoppableVideo__T1620__T1624(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.productImagesOfPlayingVideoDisplays__T1621___T1625(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.productThumnailImage__T1622__T1626(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.TapOnProductImages__T1623__T1627(userType);
				}
	
				
				
//=====================================Shop>carousel sheet=====================================================================
				@Test(priority = 9)
				@Parameters({ "userType"})
				public void shopCarouselSheet(String userType) throws Exception {
					Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
					Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.userShouldBeLandedOnINTHISVIDEOTab__T313__T323(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.productByClickingTheSavedSmallCarouselImages__T325(userType);
				
				}
				
//================================================Feed > SHOP | And | Feed > Saved==============================================================
				@Test(priority = 10)
				@Parameters({ "userType"})
				public void feedSHOP(String userType) throws Exception {
					Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
					Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.feedSHOPWifiConnectionToOFF__T411__T414(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.feedSavedWifiConnectionToOFF__T410__T413(userType);
					
				}
								
//==============================================Shop > Shop page==================================================
									
				@Test(priority = 11)
			@Parameters({ "userType"})
				public void shopShopPage(String userType) throws Exception {
					Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
					Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.UnSaveAndSaveTheProductAgain__T212__T248(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.productDataInsideSavedMomentTab__T215__T251(userType);
								
				}					
			*/				
//==============================================Shop ==================================================================
				
				@Test(priority = 12)
				@Parameters({ "userType"})
				public void shop(String userType) throws Exception {
//					Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
//					Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.ableToDeleteSavedItems__T218__T254(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.shopDetailPageScreen__T255__T264(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.shopDetailsPage__T256__T266(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.clickingOnSavedProductRailsOnTheSavedVideo__T258__T267(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.swipeDownTheShopPage__T259__T268(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.clickingTheBackButton__T260__T269(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.InThisVideoTabOnShopDetailsPage__T274__T288(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.twoSectionsOfShopPageAre__T262__T271(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.productFromTheCurrentlyPlayingVideo__T273__T287(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.iNTHISVideoTabUI__T275__T289(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.clickLESSiconOnINTHISVIDEO__T277__T290(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.clickOnExpandIconINTHISVIDEO__T278__T292(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.pageObjectDetails__T280__T295(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.moreDataByClickingTheExpandButton__T280__T295(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.ableSwipeUpPageToSeeBottomProducts__T282__T296(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.ableSwipeDownPageToSeeTopProducts__T283__T297(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.tabsOnShopDetailsPageInsideINTHIDVIDEOSection__T285__T299(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.switchBetweenTabsWithInINTHISVIDEOPage__T284__T298(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.eachProductImagesAreClickable__T305__T315(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.arrowPresentOnTheProductSiteShouldBeClickable__T306__T316(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.thirdPartySiteWithinTheAppClickingOnArrowMark__T309__T319(userType);
//					Zee5ApplicasterHipiNeoBusinessLogic.thirdPartySiteWithinTheAppClickingOnProductImage__T310__T320(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.navigatedToRespectiveThirdPartySiteClickingOnArrowButton__T311__T321(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.navigatedToRespectiveThirdPartySiteClickingOnImage__T312__T322(userType);
				}		
				
//===========================================Settings and Privacy=============================================				
				
//				@Test(priority = 13)
				@Parameters({ "userType"})
				public void SettingsAndPrivacy(String userType) throws Exception {
					Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
					Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.directingToSettingsAndPrivacyScreen__T729(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.checkTheUIOfSettingAndPrivacyScreen__T730(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.appLanguageIsSetToEnglish__T777(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.noCTAClosesThePopup__T796(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.tappingOutssideThePopupScreen__T797(userType);
					Zee5ApplicasterHipiNeoBusinessLogic.tappingOnYesCTALogsOutTheUser__T798(userType);
					
					
				}	
								
	@AfterTest						
	public void tearDownApp() {		
		System.out.println("Quit the App");
		Zee5ApplicasterHipiNeoBusinessLogic.tearDown();	
	}									
	
	
}
