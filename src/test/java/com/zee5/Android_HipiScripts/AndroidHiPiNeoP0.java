package com.zee5.Android_HipiScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.excel.Time_ExcelUpdate;
import com.utility.Utilities;
import com.zee5.Applicaster.HIPI.HipiHomePage;

public class AndroidHiPiNeoP0 {
	private com.business.zee.Zee5ApplicasterHipiNeoBusinessLogic Zee5ApplicasterHipiNeoBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		Zee5ApplicasterHipiNeoBusinessLogic = new com.business.zee.Zee5ApplicasterHipiNeoBusinessLogic("zee");
	} 
	/**
	The Description of the method to explain what the method does
	@param the parameters used by the method
	@return the value returned by the method
	@throws what kind of exception does this method throw
	 */ 
	
	@Test(priority = 0)
	@Parameters({ "userType"})
	public void launchApptime(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.TimeStamprelaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.launchApptime("TC001");	
		Zee5ApplicasterHipiNeoBusinessLogic.launchApp_And_Check_ProgressBar();
		Zee5ApplicasterHipiNeoBusinessLogic.verifyProgressBar();
	}
	
	@Test(priority = 1)
	@Parameters({ "userType"})
	public void Login(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.loginWithGoogle(userType);
		//Zee5ApplicasterHipiNeoBusinessLogic.videoUIRepate(userType);

	}
	
	@Test(priority = 2)
	@Parameters({ "userType"})
	public void likeTimeCount(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.likeTime(userType);
	}
	
	@Test(priority = 3)
	@Parameters({ "userType"})
	public void commentTimeCount(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.commentTime(userType);
		}
	
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void DiscoverScreenLoadTime(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.DiscoverScreenLoadTime();
	} 	

	@Test(priority = 5)
	@Parameters({ "userType"})
	public void AutoSuggestionTime(String userType) throws Exception {
	
		Zee5ApplicasterHipiNeoBusinessLogic.AutoSuggestionTime("kundali");
	
	}
	
	@Test(priority = 6)
	@Parameters({ "userType"})
	public void OnClickingBannerScreenLoadTime(String userType) throws Exception {
	
		Zee5ApplicasterHipiNeoBusinessLogic.OnClickingBannerScreenLoadTime(userType);
	
	}
	
	@Test(priority = 7)
	@Parameters({ "userType"})
	public void railsPageTime(String userType) throws Exception {
	
		Zee5ApplicasterHipiNeoBusinessLogic.railsPageTime();
	}
	@Test(priority = 8)
	@Parameters({ "userType"})
	public void hashtagDetailPageTime(String userType) throws Exception {
	
		Zee5ApplicasterHipiNeoBusinessLogic.hashtagDetailPageTime();
	
	}
	
	@Test(priority = 9)
	@Parameters({ "userType"})
	public void BannerLoadTime(String userType) throws Exception {
	
		Zee5ApplicasterHipiNeoBusinessLogic.BannerLoadTime();
		
	}
	
	@Test(priority = 10)
	@Parameters({ "userType"})
	public void SearchScreenTimePostSearchingAKeyword(String userType) throws Exception {
	
		Zee5ApplicasterHipiNeoBusinessLogic.SearchScreenTimePostSearchingAKeyword("kundali");
		
	}

	@Test(priority = 11)
	@Parameters({ "userType"})
	public void videoNextTime__15Sec(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Next("15s", userType, "TC014" , "TC015");
	}

	@Test(priority = 12)
	@Parameters({ "userType"})
	public void videoNextTime__30Sec(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Next("30s", userType, "TC016" , "TC017");

		
	}
	
	@Test(priority = 13)
	@Parameters({ "userType"})
	public void videoNextTime__45Sec(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Next("45s", userType, "TC018" ,"TC019");


	}
	
	@Test(priority = 14)
	@Parameters({ "userType"})
	public void videoNextTime__60Sec(String userType) throws Exception {
	
		Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Next("60s", userType, "TC020" , "TC021");
	}
	
	@Test(priority = 15)
	@Parameters({ "userType"})
	public void videoNextTime__90Sec(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Next("90s", userType, "TC022" , "TC023");
	
	}
	

	
	@Test(priority = 16)
	@Parameters({ "userType"})
	public void CreatorPlatformSoundScreenLoadTime(String userType) throws Exception {
	
		Zee5ApplicasterHipiNeoBusinessLogic.CreatorPlatformSoundScreenLoadTime();
	
	}
	
	@Test(priority =17)
	@Parameters({ "userType"})
	public void EffectsLoadTime(String userType) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.EffectsLoadTime();
	
	}
	@Test(priority = 18)
	@Parameters({ "userType"})
	public void FilterLoadTime(String userType) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.FilterLoadTime();
		
	}
	
	@Test(priority = 19)
	@Parameters({ "userType"})
	public void VideoStartUpTimeAfterSwipe(String userType) throws Exception {
	
		Zee5ApplicasterHipiNeoBusinessLogic.VideoStartUpTimeAfterSwipe();
	
	}
		
	@Test(priority = 20)
	@Parameters({ "userType"})
	public void logout(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.searchResults("shivangi","TC029");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResults("shraddha arya","TC030");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResults("punjabi singers","TC031");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResults("Nora Fatehi","TC032");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResults("punjabi videos", "TC033");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResults("funny video", "TC034");
		
		Zee5ApplicasterHipiNeoBusinessLogic.searchResultsPlaylist("funny video", "TC039");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResultsPlaylist("shraddha arya", "TC039");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResultsPlaylist("Nora Fatehi", "TC039");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResultsPlaylist("shivangi", "TC039");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResultsPlaylist("punjabi videos", "TC039");
		
		Zee5ApplicasterHipiNeoBusinessLogic.searchResultsShop("Saree", "TC040");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResultsShop("Perfume", "TC040");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResultsShop("Bottle", "TC040");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResultsShop("Modern", "TC040");
		Zee5ApplicasterHipiNeoBusinessLogic.searchResultsShop("Ethnic", "TC040");

//		Zee5ApplicasterHipiNeoBusinessLogic.searchResults("xxx", "TC035");
		Zee5ApplicasterHipiNeoBusinessLogic.Shop();
		Zee5ApplicasterHipiNeoBusinessLogic.createDuetVideo("TC037");
		Zee5ApplicasterHipiNeoBusinessLogic.UploadVideoFromGallery("TC038");
		Zee5ApplicasterHipiNeoBusinessLogic.videoUIRepate(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.unFollow();
		Zee5ApplicasterHipiNeoBusinessLogic.TimeStamplogOut();
////	Zee5ApplicasterHipiNeoBusinessLogic.TimeStamprelaunch(true);
////	Zee5ApplicasterHipiNeoBusinessLogic.VerifyRemoveDefaultUserName(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.TimeStamprelaunch(true);
//		Zee5ApplicasterHipiNeoBusinessLogic.loginWithGoogle(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.TimeStamprelaunch(true); 
//		Zee5ApplicasterHipiNeoBusinessLogic.loginWithPhoneNumber(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.TimeStamprelaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.loginWithFacebook(userType);
//	
	}
	
	
	/*
	@Test(priority = 1)
	@Parameters({ "userType"})
	public void FeedModuleP0TCs(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true); 
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.moreDataByClickingTheExpandButton__T281__T293(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.switchBetweenTabsWithInINTHISVIDEOPage__T284__T298(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tabsOnShopDetailsPageInsideINTHIDVIDEOSection__T285__T299(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.productName_T302(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.navigateToProductWebsite__T372____T383(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ArrowMarkUserNavigateToProductWebSite__T373__T384(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.beautyCardImageClickAndGetButton__T387__T390(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.beautyCardImageClickAndGetButtonHair__T393__T396(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.thirdPartySiteWithinTheAppClickingOnArrowMark__T309__T319(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.expandAllThePanelsAtATime__T352__T359(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.videoIsShopable__T174(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shopableVideosArePresentOnTheFeed__T178__T182(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shoppableVideo__T175__T179(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userWatchingShoppableVideos__T186__T222(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shopButtonDisplayedComingFromAnyOtherTabs__T188__T224(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shopButtonShouldNotVisibleWhenUserInotherTab__T189__T225(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userRedirectToShopPage__T190__T226(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickableFunctionalityOnShopButton__T185__T221(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shopDetailsPage__T256__T265(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickingLessDropDownOn__T276__T291(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyforMiniPlayer__T326__T337(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.afterClosingTheProductThirdPartySite__T336__T347(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.closingMiniPlayerBehaviour__T330__T341(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerOnSaveMomentTab__T335__T346(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickingOnTheMiniPlayer__T364__T375(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.lessDataForTheProduct_T367__T378(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyInAppBrowserT397_T399_T402_T404(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickingUponArowMarkT398_T400_T403_T405(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.saveLookButtonFunctionality__T230__T194(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.savedProductDeletedFrom__T196__T232(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clicksAndRedirectionOnProductImageFromTheBottomSheetCorousel__T205__T241(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.saveAndUnSaveTheVideoObjects__T246__T210(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SAVELOOKbuttonOnTheShopableVideo__T193__T229(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.savedButtonFunctionality__T217__T253(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.videoIsPlayingByDefaultInForYouTab__T009__T025(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.refreshTheListOnContents__T011__T023(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ValidatePlayandPause__T012_T026(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ForYouAndFollowingTabs__T006__T019(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingOnBbackFromAnyKeySection__T021(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.resumePausedVideoByTappingPlayerScreen__T030(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.switchBetweenTheFollowingAndForYouSection__T039(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shoppableVideoUnderUserProfilePage__T060(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shoppableVideoUnderDiscoverPage__T061(userType,"Sunny Leone");
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeTheShareIconForYouScreen__T086(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.loginPopUpIsDisplayedByTappingOnProfileTabOnTheApp__T095(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ableToLikeDislikeAMultipleVideo__T109(userType);	

		Zee5ApplicasterHipiNeoBusinessLogic.verifyThatShoppableVideoInsideDiscoverPage_T407_T408(userType,"Sunny Leone");
		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
			Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
			Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToRefreshTheListOnContentsInFollowingTab__T426(userType);
		}
		Zee5ApplicasterHipiNeoBusinessLogic.verticalScrollingOfFollowingTabSectionIsInfinte__T427(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToVerifyTheVideoIsPlayingInFollowingTab__T428(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingBackMobileOptionInListOfActionsScreen__T440(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToViewNumberOfLikesOnPlayedPausedVideo__T456(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ableToAddAndPostCommentByEnteringDescriptionInTextField__T146(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ShoppableVideo__T420(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.saveVideoActionByTapping__T065__T121(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.saveVideoObjectsFromMultipleShoppableVideos__T245__T209(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.seeASinglePopUpFoRLoginSignupPhoneNumer(userType, "9059995072");
		Zee5ApplicasterHipiNeoBusinessLogic.seeASinglePopUpFoRLoginSignupPhoneNumer(userType, "nagakartheek.dasareddy@gmail.com");
		Zee5ApplicasterHipiNeoBusinessLogic.SignUpNew(userType , "Hipinewmaam@gmail.com");
		Zee5ApplicasterHipiNeoBusinessLogic.SignUpNew(userType , "9059997071" );
		
		Zee5ApplicasterHipiNeoBusinessLogic.enterAge(userType, "Hipinewmaam@gmail.com");
		Zee5ApplicasterHipiNeoBusinessLogic.enterAge(userType, "9059997071");
		
//		Zee5ApplicasterHipiNeoBusinessLogic.clickOnMiniPlayer__T332__T343(userType);//in active
	

	}



	@Test(priority = 2)
	@Parameters({ "userType"})
	public void DiscoverModuleP0TCs(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);		
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.discoverOptionOnApplication__T1324__T1334(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.backButtonOnTheBannerDetailsPageAndClick__T1520(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userAbleToSeeSearchFieldInTheTopOfTheDiscoverPage__T1331(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userAbleToClickOonTheDiscoverOptionFromTheBottomMenuBar__T1325__T1335(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userAbleToClickOnTheDisplayedResultsInTheSearchPage__T1355(userType, "Himanshi");
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleIsSeeAllHashtagRelatedRailsInDiscover__T1488(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SearchFieldClickAndNavigation__T1343(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.railOnTheDiscoverPage__T1547(userType);//fail
		Zee5ApplicasterHipiNeoBusinessLogic.userProfileOnRail__T1581(userType);//fail
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserprofileonRail__T1541(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForProfileDetailsPage__T1589(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyfollowButtonFromListPage__T1586(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verticalScrollInTheDiscoverPage__T1616(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.searchFieldOnTheUserFollowersTab__T1605(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickOnAnyItemInTheEachRail__T1617(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyCommentBoxIsVisibleInDiscoverScreen_T1810_T1811(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanLikeTheComments_T1837(userType,"Sunny Leone");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanAddComments_T1834(userType,"Sunny Leone");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateToCommentScreen_T1839(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingOnFollowUserGetsLoginPopUp_T1925(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingOnFollowUserGetsLoginPopUp_T1936(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingProfileUserNavigatesToProfileScreen_T1940(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingProfileUserNavigatesToProfileScreen_T1941(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyHahtagIsDisplayedInDiscoverScreen_T1508(userType);
		

//		Zee5ApplicasterHipiNeoBusinessLogic.productThumnailImage__T1622__T1626(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.productImagesOfPlayingVideoDisplays__T1621___T1625(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.TapOnProductImages__T1623__T1627(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.saveLookCTANavigationOnShoppableVideo__T1620__T1624(userType);
		
		//		Zee5ApplicasterHipiNeoBusinessLogic.verifyClickOnTheVideoBanner__T1516(userType);//UTT
	}

	@Test(priority = 3)
	@Parameters({ "userType"})
	public void LoginSignupScreenModuleP0TCs(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeTheSelectCountryRegionScreenAfterTappingOnPlus91InLogInScreen__T806(userType);//1
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToCloseTheSelectCountryRegionScreenByTappingOnCrossIcon__T807(userType);//2
		Zee5ApplicasterHipiNeoBusinessLogic.userNavigateToForgotPasswordResetScreenAfterTappingTheForgotPassword__T818(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToLoginToTheApplication__T827(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToNavigateToLoginWithOTPScreen__T828(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeTheContinueWithFacebookCTA__T862(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeTheContinueWithGoogleCTA__T875(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeTheSignUpLink__T880(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeTheSignUpForHiPiPopUp__T881(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbletoTCloseTheSignUpForHiPiPopUp__T883(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeTheContinueWithFacebookCTA__T1004(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeTheContinueWithGoogleCTAInSignUpForHiPiPopUp__T1033(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToEnterThePhoneNumber__T812(userType);//3
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToEnterThePassowrdInPasswordFieldInPhoneLoginScreen__T814(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToRemoveTheEnteredPasswordByTappingOnCrossIconInLoginScreen__T815(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToResetThePhoneNumberByTappingOnResetCTAInForgotPasswordResetScreen__T820(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToEnterTheEmailAddressInEmailAddressFieldInLoginScreen__T849(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToEnterThePasswordInPasswordFieldInEmailScreen__T851(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToLoginToTheApplicationWhenuserEnterValidDetailsInEmailTab__T853(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToLoginToTheApplicationByTappingOnAnyGoogleAccount__T877(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeTheSelectSCountryRregion__T943(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToLoginWithPasswordByTappingOnLoginWithPasswordLink__T918(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToLoginWithPasswordByTappingOnLoginWithPasswordLink__T917(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyResetCTA__T856(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.navigateToSignUpScreen__T884(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ageShouldBeAbove18Year__T893(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.navigatePhoneNumberScreenAfterTappingOnNextCTA__T894(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.removeTheEnteredNewPhoneNumber__T950(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.navigateToEmailAddressScreen__T982(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.emailScreenByTappingOnBackButton__T984(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.emailAddressInEmailAddressFieldInSignUpScreen__T986(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.fullNameInSignUpScreen__T991(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.downArrowInSignUpScreen__T994(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.enteringPassowrdInSignUpScreen__T995(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.navigateToCreateUsernamePage__T998(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.defaultUserNameIsDisplayedInCreateUsernamePage__T1000(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.VeifySkipCreateUsernamePage__T1002(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.VerifyRemoveDefaultUserName__T1003(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeTheListOfGoogleAccount__T1034(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeLoginWithOTPInLoginPopUp_T1766(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanEnterPhoneNumberInLoginWithOTPScreen_T1768(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingCrossIconEnteredDataIsRemoved_T1769(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingCrossIconEnteredDataIsRemoved_T1774(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserAbleToTapOnForgetPasswordButton_T1775(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyErrorMessageOnTapping_T1782(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserRemovePhoneNumberByTappingOnCrossIcon_T813(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToLoginToTheApplication__T816(userType);
		
	}
		
	
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void createrModuleP0TCs(String userType) throws Exception {
				Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
				Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);					
				Zee5ApplicasterHipiNeoBusinessLogic.verifyUsercanCreateVideoWithoutLoggingIn_T525(userType);
				Zee5ApplicasterHipiNeoBusinessLogic.verifyVideoCreation_T529(userType);
				Zee5ApplicasterHipiNeoBusinessLogic.verifyAddMusicScreen_T556(userType);	
				Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
				Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);		
				Zee5ApplicasterHipiNeoBusinessLogic.verifyEffectSCreen_T715(userType);
				Zee5ApplicasterHipiNeoBusinessLogic.setVisibilityToPublic_T685(userType);
				Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserIsAbleToFlipCameraAndFlashLightIsDisabledInSelfieMode_T539(userType);
				
				
				Zee5ApplicasterHipiNeoBusinessLogic.checKUserIsAbleToSeeVideoSpeedBarOptionOnTappingVideoSpeedIcon_T542(userType); 
				Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserIsAbleToAddTheMusicAfterRecording_T611(userType); 
				Zee5ApplicasterHipiNeoBusinessLogic.verifyVideoEditScreenByTappingOnFinish_T554(userType);
				Zee5ApplicasterHipiNeoBusinessLogic.addingMusic_T591(userType);
				Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanTrimSound_T605(userType);
				Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanUploadVideoFromGallery_T584(userType);		
				Zee5ApplicasterHipiNeoBusinessLogic.verifyVideoCreationWithMusic_T607(userType); 
				Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanIncreaseAndDecreaseTheVolume_T622(userType);
				Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanIncreaseAndDecreaseTheVolumeInOriginalsound_T623(userType);
//				Zee5ApplicasterHipiNeoBusinessLogic.tapOnDifferentFilterCategories_T628(userType);//Tapping on different Filter categories
//				Zee5ApplicasterHipiNeoBusinessLogic.downlaodVideo_T704(userType);
	}
		

	@Test(priority = 5)
	@Parameters({ "userType"})
	public void ProfileModuleP0TCs(String userType) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFollowingCtaIsProvidedToVerifyUserHasBeenFollowed_T1110(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserAbleToUnfollowTheFollowingUserByTappingOnFollowingCta_T1111(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.scrollingUpVideoWithIndexfinger_T1183(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingOnAnyPrivateVideo_T1185(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkTheLayoutOfEditProfileScreen_T1074(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserIsAbleToNaviagateBackToProfileScreenOnTappingBackButtonInEditProfilePage_T1075(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserIsAbleToSeeInviteFriendsIcon_T1203(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserIsAbleToSeeBioOnProfileScreen_T1202(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.RedirectToProfileScreenOnTappingBackButton_T1105(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userRedirectedToAccountDetailScreenWhenTappedOnBack_T1142(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToEnterCharactersInBio_T1089(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ToVerifyUserIsEnableTheFollowTheFollowersOnTapingOnFollowCta_T1102(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyLoginSignUpPopupDisplaysOnProfileTab__T1072(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.TappingEditProfileUserIsDirectedToEditProfileScreen__T1073(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyVideoSavedAsDraftIsDisplayedInProfileScreen__T1112(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shoppableTabInProfile__T1245(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ableToUpdateName__T1079(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyDraftedVideoIsDeletedWhenUserTapsOnYesOnTheDeletePopup__T1140(userType);
		
	}
	
	@Test(priority = 6)
	@Parameters({ "userType"})
	public void FeedModuleNewP0(String userType) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.tappingOnShareOption__T1689(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingOnnAnySocialMediaIcon__T1690(userType);
		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
			Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
			Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.linkUrlUserShouldRedirectedToHipiApp__T1694(userType);//non
		}
		Zee5ApplicasterHipiNeoBusinessLogic.socialMediaIconFromThePopUpScreen__T1726(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.urlWhileSendingTheSoundThrough__T1727(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.receiverIsAbleSeeTheTextMessage__T1728(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingOnAnySocialMediaIcon__T1732(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingOnAnySocialMediaUserNavigatesToTheParticularPlatform__T1738(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.listOfActionsPresentByTappingOnShare__T1783(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ableToTapOnDuetOption__T1785(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingOnFollowButton__T1922(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.textMessageUrl__T1691(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserhasReceivedTextAndUrlBysharingProfile_T1698(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanAddCommenOnOwnProfileVideo_T1867(userType,"Himanshi");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanDislikeOwnProfileVideo_T1870(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserNavigatesToRespectiveSocialMediaScreenOntappingShareeOption_T1696(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CheckByTappingOnShareProfileUserGetsPopUpScreenToShareViaSocialMedia_T1695(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CheckByTappingOnShareOptionOnTheVideoUserGetsPopUpScreen_T1707(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CheckByTappingOnInviteFriendsUserAbleToRedirectToInviteFriendsScreen_T1743(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.textMessageUrlWhileSendingTheFilterThroughTheSocailMedia__T1739(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.VerifyUrlTextAndVideoIsDisplayedWhileSharingOwnProfileVideoAsSender_T1709(userType);
		
		//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateToHipiScreenBytappIngOnRecevedLink_T1700(userType); //Inactive 


	}
	
	@Test(priority = 7)
	@Parameters({ "userType"})
	public void createrModuleNewP0TCs(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfEditScreen_T1653(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateToEditClipScreen_T1654(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyClipInEditClipScreen_T1656(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserNavigatedToMediaScreenByTappinOnPlusIconOfEditClipScreen_T1657(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserNavigatedToMediaScreenByTappinOnRightPlusIconOfEditClipScreen_T1659(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserNavigatedToMediaScreenByTappinOnLeftPlusIconOfEditClipScreen_T1660(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanDeletePhotoInEditClipScreen_T1673(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanDeleteMultiplePhotoInEditClipScreen_T1680(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateToCreatorScreenOnTappingShareDuet_T1786(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserHandlerIsAddedOnPostScreenByDuetWithUserHandler_T1790(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserDuetIsDisbledInPostScreenWhileDuetingWithOtherUsers_T1792(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSplitVideoOnEditClipScreen_T711(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateToEffectScreen_T1794(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanDragVideoInTrimScreen_T1685(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserNavigatesToRespectiveApplicationOntappingLinkReceived_T1706(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateToShareToScreen_T1701_T1713(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingOnCreatorsShareIconUserNavigatesToSocialMediaPage_T1714(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserTextAndUrlIsVisibleAsAreceiverEnd_T1716(userType);


	}

	@Test(priority = 8)	 //No Guest 
	@Parameters({ "userType"})
	public void postModuleP0Tcs(String userType) throws Exception 
	{
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserAddComment_T1864(userType,"wow");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyHeightOfCommentBoxAndNavigationalBarIsSame_T1862_T1851(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyOnTappingOnFOllowButtonUserGetsLoginPopup_T2220(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateToFeedScreenByTappingOnPost_T1637(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserByClickingDescriptionOnPostScreenUserNavigatesToPostScreen_T1947(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTappingOnNextCtaInDraftedVideoUserCanNavigateToPostVideoScreen_T1961(userType);//p0
		//
		//		System.out.println("***************Start Edit Video Screen **************************");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanEditvideoBeforeNavigatingToPostScreen_T1962(userType);
		////		=========================AllDetailP0Tcs==============================================
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanViewCommentPopup_T1863(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserAddedCommentsTimeGetsUpdated_T1875(userType,"Himanshi");

		////		=========================HashTagRelatedTcs==============================================

		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyHahtagIsDisplayedInProfileScreen_T1178(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.checkTheNotificationFormat_T1155(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkTheThumbnailAndProfileIsDisplayed_T1157(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.VerifyUserOnTappingFollowingTabUnderProfileUserCanSeeFollowersDetails_T1404(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyDefaultEffectScreen_T719(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserTrimDraftedVideo_T1952(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserCanLikeHisOwnCommentOrNotInPrivateVideo_T1195(userType);
				
		

	}	



	@Test(priority = 9)			
	@Parameters({ "userType"})
	public void AllNewModules(String userType) throws Exception 
	{
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAsUserBAndNavigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanPostVideoWithUrl_T2132(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTrendingCreatorIsDisplayedInFollowingTab_T2148(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyLoginPopupIsDisplayedOnTappingOnFollowButtonInTrendingCreatorscreen_T2150(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserAbleToTapOnFollowingTabPostSuccesfulLogin_T2151(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanUnfollowFollowingUser_T2158(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTickmarkIsNotDisplayed_T2218(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFollowIsDisplayedNextToUserhandler_T2219(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFollowIsDisplayedNextToUserhandler_T2221(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingOnFollowIconPlusIconDisappear_T2222(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfShareScreen_T2223(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFollowingButtonIsNotVisibleInFollowingTab_T2295(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyPlusIconIsNotVisibleInFollowingTab_T2296(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfShareScreenUnderFollowingTab_T2227(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeVideosOnlyFromCreatorThatUserIsFollowing_T2300(userType);

	}


	@Test(priority = 10)			
	@Parameters({ "userType"})
	public void creatorModulePart2(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.userAbleseeTwoTabsUnderTheSoundScreen__T2256(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserAbleToSeeTheLocalTabInSoundScreenPage_T2209(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkDeviceInternalSoundsArePresentInLocalTab_T2210(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyWhetherUserIsAbleToSearchForSoundUsinArtistName_T2252(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.verifyIfUserIsAbleTOObserveTheBookmarkSymbolAgainstEachSound_T2264(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ableToSeeSearchBarOnSoundsScreen__T2249(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ableToAddSoundForVideo__T2248(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.differentCategoriesUnderDiscoverTab__T2259(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.seeAllOptionGIvenAboveTheSoundCategories__T2260(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleTotapOnUseThisSoundCta_T2268(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToCreateVideoPostUseThisSoundCta_T2270(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserMusicAddedFromLocalSoundsIsDisplayedInTrimScreen_T2215(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeBookmarkForSounds_T2264(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyWhetherUserIsAbleToSearchForSoundUsingSoundName_T2251(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.verifySearchListInSearchedSoundResults_T2253(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanCreateVideoFromLocalSound_T2216(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserAbleToSeeVideoWithSameSoundSelectedInFeedScreen_T2271(userType);//Defect

	}


	@Test(priority = 11)			
	@Parameters({ "userType"})
	public void SettingsPrivacyModulePart2(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		//	=================================================SettingsPrivacyP0_P1Tcs================================================
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserisAbleToSeeInviteFriendsOption_T2141(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserIsAbleToSeeSearchBarInviteFriendsOption_T2142(userType);
		//================================Login==========================================
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfTheSignUpOptionIsShownCompletelyOnLoginScreen_T2169(userType); 
		//	//===============================ProfileP0Tcs================================================================
		//
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserAbleToNavigateToEditProfileScreenOnTappingEditProfileButton_T2288(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyWhetherTheUsernameFieldIsReplacedWithUserHandleInProfileEditScreen_T2289(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTheUIOfEditprofileScreen_T2290(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTheUIOfEditprofileScreen_T2291(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkByTappingOnAnyVideoFromAllTabTheOptionShouldGetDisplayedInVideo_T2341(userType);

		//=================================Discover==================================================

		Zee5ApplicasterHipiNeoBusinessLogic.userNameInSoundDetailPage__T2247(userType);//M //P0
		Zee5ApplicasterHipiNeoBusinessLogic.checkErrorMessageAreDisplayedIfVideosAreNotAvailableInSoundScreen_T2160_T2161(userType); //P0
		Zee5ApplicasterHipiNeoBusinessLogic.checkErrorMessageIsShownInHashtagDetailScreenIfNoDetailsAreAvailable_T2162_T2163(userType,"AAAA"); //P0
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFollowingBesideUserhandlerIsNotDisplayed_T2217(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyOriginalSoundWithUserNameIsVisibleInSoundScreen_T2277_T2278(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyOriginalSoundisVisibleinFeedScreen_T2279_T2280(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyOriginalSoundisVisibleinFeedScreenUnderFollowingTab_T2282(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserAbleToSeeOriginalSoundWithUserNameInSoundDetailPage_T2286_T2287(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUIOfVideoPlayerScreenByTappingOnVideoThumbnailOnDraftVideos_T2338(userType);



	}

	@Test(priority = 12)			
	@Parameters({ "userType"})
	public void AllNewModules1(String userType) throws Exception  
	{
		
		
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerByClickingCorouselSheet__T2387__T2394(userType);// T2387- P0 T2394-P0
		Zee5ApplicasterHipiNeoBusinessLogic.closingMiniPlayerBehaviour__T2388__T2395(userType); //T2388-P0 T2395-P0
		Zee5ApplicasterHipiNeoBusinessLogic.closingTheProductThirdPartySite__T2391__T2398(userType);//T2391 P0 T2398 P0
		Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerOnSaveMomentTab__T2392__T2399(userType);// T2392-P0 T2399-P0
		Zee5ApplicasterHipiNeoBusinessLogic.closingMiniPlayerBehaviourSound__T2402__T2409(userType);//T2402-P0 T2409-P0
		Zee5ApplicasterHipiNeoBusinessLogic.closinTheProductThirdPartySite__T2405__T2412(userType);//T2405 P0 T2412 P0
		Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerOnSaveMomentTabSound__T2406__T2413(userType);//T2406-P0 T2413 P0
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserViewMiniPlayerByClickingOnCoroselSheet_T2415__T2422(userType);// T2415- P0 T2422 P0
		Zee5ApplicasterHipiNeoBusinessLogic.closingMiniPlayerBehaviourHashtag__T2416__T2423(userType);//T2416-P0 T2423-P0
		Zee5ApplicasterHipiNeoBusinessLogic.closingTheProductThirdPartySiteHashtag__T2419__T2426(userType);// T2419-P0 T2426-P0
		Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerOnSaveMomentTabHashtag__T2420__T2427(userType);//T2420-P0 T2427 P0
		Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerByClickingCorouselSheetSound__T2401__T2408(userType);//T2401-P0 T2408-P0

		//====================================Dont run==================================================================
		//	Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerByClickingCorouselSheetEffect__T2429__T2436(userType);//T2429 P0 T2436 p0    			 Fail No Bucket Icon Effect details screen
		//	Zee5ApplicasterHipiNeoBusinessLogic.closingMiniPlayerBehaviourEffect__T2430__T2437(userType);//T2430 p1 T2437 p0     				 Fail No Bucket Icon Effect details screen
		//	Zee5ApplicasterHipiNeoBusinessLogic.closingTheProductThirdPartySiteWillMiniPlayerEffect__T2433__T2440(userType);// T2433-p0 T2440-p0 Fail No Bucket Icon Effect details screen
		//	Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerOnSaveMomentTabEffect__T2434__T2441(userType);//T2434-p0 T2441 p0                      Fail No Bucket Icon Effect details screen
		//	Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerByClickingCorouselSheetFilter__T2443__T2450(userType);//T2443-p0 T2450 p0              Fail No Bucket Icon Effect details screen
		//	Zee5ApplicasterHipiNeoBusinessLogic.closingMiniPlayerBehaviourFilter__T2444__T2451(userType);//T2444 p0 T2451 p0                     Fail No Bucket Icon Effect details screen
		//	Zee5ApplicasterHipiNeoBusinessLogic.thirdPartySiteWillMiniPlayerStillPlayingOnShopPage__T2447__T2454(userType);//T2447-p0 T2454 p0   Fail No Bucket Icon Effect details screen
		//	Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerOnSaveMomentTabFilter__T2448__T2455(userType);// T2448-p0 T2455 p0                  	 Fail No Bucket Icon Effect details screen


	}

	
	@Test(priority = 13)			
	@Parameters({ "userType"})
	public void FeedPart3ModulesTcs(String userType) throws Throwable 
	{
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		System.out.println("Feed");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFollowingCtaChangedToFOllowCta_T2373(userType);//p0
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserCannavigateToFeedScreenAfterPostingVideoWithHipiPassTheMicHashtag_T2458(userType);//p0
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(false);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserWhilePostingPrivateVideoInviteNowBannerIsNotDisplayed_T2461(userType);//p0

		Zee5ApplicasterHipiNeoBusinessLogic.checkIUserIsNotAbleToSeeOfficialTagWithWhiteTextAndRedBackgroundOnVideoThumbnailInProfileDetailPage_T2193_T2202(userType);//T2193 p0 T2202 p0
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserNotAbleToSeeMostPopularTagWithWhiteTextAndRedBackgroundOnVideoThumbnailInProfileDetailPage_T2199_T2208(userType);// both p0
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserAbleToSeeMostPopularTagWithWhiteTextAndRedBackgroundOnVideoThumbnailInHashtagDetailPage_T2184_T2190(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkMostPopularTagOverHashtagDetailScreen_T2189_T2183(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.verifyLoginPopupIsDisplayedOnTappingOnFollowCtaInCreator_T2374(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserNotAbleToSeeOfficialTagWithWhiteTextAndRedBackgroundOnVideoThumbnailInEffectDetailPage_T2191_T2200(userType);//T2191 p0 T2200 po
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserIsNotAbleToSeeOfficialTagWithWhiteTextAndRedBackgroundOnVideoThumbnailInFilterDetailPage_T2192_T2201(userType);//T2192 p0 T2201 p0
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserNotAbleToSeeMostPopularTagWithWhiteTextAndRedBackgroundOnVideoThumbnailInEffectDetailPage_T2197_T2206(userType);//T2197 p0 T2206 p0
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserNotAbleToSeeMostPopularTagWithWhiteTextAndRedBackgroundOnVideoThumbnailInFilterDetailPage_T2198_T2207(userType);//T2198 p0 T2207 p0

		//=====================================Inactive=================================================================

		//		Zee5ApplicasterHipiNeoBusinessLogic.checkUserCanSeeFeedScreenWhilePostingFiveSecondVideoWithHipiPassTheMicHashtag_T2464(userType);//p0
		//		Zee5ApplicasterHipiNeoBusinessLogic.checkUserCanViewBannerAfterPostingVideoWithPassTheMicHashtag_T2459(userType);//p0
		//		Zee5ApplicasterHipiNeoBusinessLogic.checkUserCanViewBannerAfterPostingDraftVideoWithPassTheMicHashtag_T2460(userType);//p0
		//		Zee5ApplicasterHipiNeoBusinessLogic.checkUserCreateVideoWithHipiPassTheMicHastag_T2457(userType);//p0
		//		Zee5ApplicasterHipiNeoBusinessLogic.checkUiOfBanner_T2467(userType);//p0
		//		Zee5ApplicasterHipiNeoBusinessLogic.verifyInviteNowBannerIsDisappearedOnTappingOnIt_T2469(userType);//p0
		//		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingOnInviteNowCtaUserCanSeeShareSheet_T2472(userType);//po
		//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeVideoPostedByCreator_T2478(userType);//p0
		//		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(false);
		//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeBannerInReceivedLink_T2479(userType);//p0
		//		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(false);
		//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfBanner_T2480(userType);//p0
	}
	
	//	@Test(priority = 14)			
	@Parameters({ "userType"})
	public void UnfollowTcs(String userType) throws Throwable 
	{
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAsUserBAndNavigateToHipi(userType);;
		//Unfollow TCs

		Zee5ApplicasterHipiNeoBusinessLogic.checkUiOfFollowingTab_T2153_T2149(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeFollowingUserPostRefreshing_T2154(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUsernavigates_T2155(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingOnFollowForTrendingCreatorFollowButtonChangedToFollowing_T2156(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingOnUserhandlerPostFolowingUserCanSeeFollowingInProfileSCreen_T2157(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTextIsDispayedInFollowingTab_T2152(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeVideosOnlyFromCreatorThatUserIsFollowing_T2297(userType);//feed p1         Fail

	}


		*/

//	@Test(priority = 16)
//	@Parameters({ "userType"})
//	public void videoPostTime__15Sec(String userType) throws Exception {
//		Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Post("15s", userType, "TC019");
//
//	
//	}
//	
//	@Test(priority = 17)
//	@Parameters({ "userType"})
//	public void videoPostTime__30Sec(String userType) throws Exception {
//		Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Post("30s", userType, "TC020");
//		
//	}
//	
//	@Test(priority = 18)
//	@Parameters({ "userType"})
//	public void videoPostTime__45Sec(String userType) throws Exception {
//		Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Post("45s", userType, "TC021");
//
//
//	}
//
//	@Test(priority = 19)
//	@Parameters({ "userType"})
//	public void videoPostTime__60Sec(String userType) throws Exception {
//	
//		
//		Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Post("60s", userType, "TC022");
//	
//	}
//	
//	@Test(priority = 20)
//	@Parameters({ "userType"})
//	public void videoPostTime__90Sec(String userType) throws Exception {
//		Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Post("90s", userType, "TC023");
//	
//	}
	
	//No 
//	@Test(priority = 25)
//	@Parameters({ "userType"})
//	public void videoPostTime__45SecCheckProcessingTime_15s(String userType) throws Exception {
//		
//		
//		Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Post_And_CheckProcessingTime_15s("60s", userType, "TC028");
//		
//
//	}
	
	@AfterTest						

	public void tearDownApp() {		
		System.out.println("Quit the App");
		Zee5ApplicasterHipiNeoBusinessLogic.tearDown();	
		Time_ExcelUpdate.AutoFitColumn();
	}									
}
