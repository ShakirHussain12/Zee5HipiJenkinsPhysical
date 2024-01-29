package com.zee5.Android_HipiScripts;

import org.apache.xmlbeans.UserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utility.Utilities;
import com.zee5.Applicaster.HIPI.HipiHomePage;

public class AndroidHiPiNeoP1 {
	private com.business.zee.Zee5ApplicasterHipiNeoBusinessLogic Zee5ApplicasterHipiNeoBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		Zee5ApplicasterHipiNeoBusinessLogic = new com.business.zee.Zee5ApplicasterHipiNeoBusinessLogic("zee");
	}

/*
	@Test(priority = 1)
	@Parameters({ "userType"})
	public void feedP1TCs(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);	

		Zee5ApplicasterHipiNeoBusinessLogic.verifyFeedscreen__T005__T018(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ForYouAndFollowingTabs__T006__T019(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkTheOptionsArePresentFeedSection__T007__T020(userType);//Shop
		Zee5ApplicasterHipiNeoBusinessLogic.selectedByDefaultInFeedScreen__T008(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.videoIsPlayingByDefaultInForYouTab__T010(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.videoIsPlayingByDefaultInForYouTab__T009__T025(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ValidatePlayandPause__T012_T026(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.defaultVideoByTappingOnIt__T029(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.listOfActionsPresentOnLongPress__T034(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.profileDetailsScreenIsDisplayed__T038(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingOnBackArrowinSoundDetailScreen__T097__T052(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.redirectToFeedScreenOnTappingOnDeviceBackButtonInSoundDetailScreen__T098__T053(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToNavigateToUserProfilePage__T058(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.performNotInterestedActionByTapping__T069(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userCheckIfProfileDetailsScreenDisplayedWhenTappedOnProfilePictureOfVideo__T137(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeTheLikeIconForYouScreen__T078(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToLikeAVideoOnPlayedPausedVideo__T106(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ableToSeeProfilePictureOnTheVideoScreenOfFeed__T138__T072(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.checkifuserIsAbleToNavigateToUserProfilePage__T071(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeThePlusFollowIconForYouScreen__T076(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.useIsAbleTooViewNumberOFLikesOnPlayedPausedVideo__T080(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToTapOnCommentIconInFeedScrrenAndLoginPopUpIsDisplay__T083(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tapOnMusicOnPlayerScreen__T096__T051(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userCheckDisplayOfLatestCommentAppearOnTop__T157(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyPerformverticalScrollCommentScreen_T148(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToAddMultipleComments__T149(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForCloseIconCorouselSheet__T243(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userCheckIfCommentScreenIsDisplayedWhenTappedOnComment__T492(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickableFunctionalityOnShopButton__T185__T221(userType);//Shop
		Zee5ApplicasterHipiNeoBusinessLogic.verifyProfilePicture__T514(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTagUserInComment__T512(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyProfilePictureOfAnotherViewer__T504(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyProfileDetailsScreen__T486(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyShareScreen__T474(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.saveVideoActionByTapping__T472(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.redirectedFeedScreenTappingBackSoundDetailScreen__T454(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.actionsPresentOnLongPressPopup__T437(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.resumePausedVideoByTappinG__T434(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userAbleToSeeTheListOfActionableItems__T432(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userPauseAndPlayVideoFollowingTab__T429(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToSeeFollowingTabInFeedScreen__T418(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.productCardDetails__T370__T381(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.changeThePositionOfMiniPlayer_T331__T344(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.thirdPartySiteWithinTheAppClickingOnProductImage__T310__T320(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.navigatedToRespectiveThirdPartySiteClickingOnArrowButton__T311__T321(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ableSwipeDownPageToSeeTopProducts__T283__T297(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ableSwipeUpPageToSeeBottomProducts__T282__T296(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickingTheBackButton__T260__T269(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.swipeDownTheShopPage__T259__T268(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickingOnSavedProductRailsOnTheSavedVideo__T258__T267(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shopDetailPageScreen__T255__T264(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shoppableVideo__T176__T180(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shoppableVideoFollowingSectionNonSub__T181(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shopableVideosArePresentOnTheFeed__T178__T182(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userVerifyForPINAnimationCircleOonTheVideoScreenCollectingMomentsFromTheVideo__T201(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.redIndicatorShouldBeDisplayed__T202__T238(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ableToDeleteSavedItems__T218__T254(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userCheckByTappingOnBackFromAnyKeySectionUserIsNavigatedToFeedScreen__T424(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserIsAbleToSeeTheUserNameInForYouTab_T141(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfCommentScreenIsDisplayedWhenTappedOnCommentChatIcon_T143(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserIsAbleToViewProfilePictureIfUserUploadedThePicture_T165(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.shopValidation__T184__T220(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.scrollsTheVideoForFewMins__T191__T227(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T216_T252ShopPage(userType);

		//		Zee5ApplicasterHipiNeoBusinessLogic.viewerCreatorAbleToLikeExistingNewComment__T166(userType);//imp
		//		Zee5ApplicasterHipiNeoBusinessLogic.verifyLikeCountofComment__T168(userType);//imp
		//		Zee5ApplicasterHipiNeoBusinessLogic.viewNumberOfCommentsOnPlayedPausedVideo__T144(userType);//imp
		//		Zee5ApplicasterHipiNeoBusinessLogic.performReportActionByTapping__T470(userType);----------Impediment
		//		Zee5ApplicasterHipiNeoBusinessLogic.verifylikeCountOfComment__T517(userType);//imp
		//		Zee5ApplicasterHipiNeoBusinessLogic.viewerCreatorIsAbleToLike__T515(userType);//imp		
		//				Zee5ApplicasterHipiNeoBusinessLogic.performReportActionByTapping__T067(userType);//inactive
	}	


	

	@Test(priority = 2)
	@Parameters({ "userType"})
	public void DiscoverP1TCs(String userType) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);	


		Zee5ApplicasterHipiNeoBusinessLogic. verifyForDiscoverOptionClick_T1328_T1338(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForSearchFieldClickAndNavigation_T1333_T1342(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForSearchFieldPosition_T1344(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForSearchParentPageRecentSearchPageField_T1348(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForSearchParentPageRecentSearchPageSearchField_T1350_T1357(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyIfUserGetsTheAutoSuggestionsUponEnteringThreeCharacters_T1352(userType);      	     
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTheSearchedResultPage_T1356_T1363(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserIsAbleToViewFullPlayerOfHashTagVideos_T1490(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserIsAbleToNavigateBackToDiscoverPageByTappingBackFromVideo_T1491(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.clickOnTheVideoBannerDisplayedInTheDiscoverPage_T1516(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForAddFavoriteButtonFunctionality_T1533(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForCreateVideoCameraButtonClickAndNavigation_T1537(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SwipeRailsToLeftAndRight__T1540(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForArrowMarkInFrontOfRailTitleName_T1544(userType);       
		Zee5ApplicasterHipiNeoBusinessLogic.bannersAtTheTopOfTheDiscoverPage__T1515(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForCreateVideoCameraButtonClickAndNavigation_T1525(userType);        
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForClickOnProfileImageAndNameFromTheUserListPage_T1548(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForSearchFieldOnTheUserFollowingTab_T1560(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForArrowMarkInFrontOfRailTitleName_T1583(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFollowButtonAndItsClickOnTheUserProfilePage_T1592(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFollowingTabAndItsClickOnTheUserProfilePage_T1593(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.validateTheAutoSuggestionListUnderFollowingTabRespectiveToSearchInput_T1601(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForClickOnDisplayedUserNameFromTheSearchResultAndNaigation_T1609(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyIfUserGetsTheAutoSuggestionsUponEnteringThreeCharacters_T1352(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTheSearchedResultPage_T1356_T1363(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyIfUserAbleToClickOnTheOtherTabsFromTheDisplayedResults_T1368(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForUserShouldBeAbleToSeeAllCategoriesResultsInTheTopTab_T1370(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyIfUserAbleToSeeAllCategoriesResultsInTheTopTab_T1369(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUsersTabOnTheSearchResultPage_T1372(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserProfilePage_T1374(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFollowButtonAndItsClickOnTheUserProfilePage_T1375(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFollowingTabAndItsClickOnTheUserProfilePage_T1376(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFollowingTabAndItsClickOnTheUserProfilePage_T1377(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userCanSearchAnyFollowingUserFromTheList_T1380(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForClickOnDisplayedUserNameFromTheSearchResultAndNavigation_T1386(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyBackButtonAndItsClickOnTheUserProfilePage_T1399(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.verifyIfUserAbleToPlayAnyVideoFromTheVideosTabOfTheSearchedResults_T1429(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyIfUserClicksOnAnySoundsFromTheRespectiveTabAndValidate_T1432(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.soundsPosterFromTheRespectiveTab__T1433(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsRedirectedToSoundTabOnTheSearchedResultPageByTappingDeviceBackButtonInSoundDetailScreen_T1443(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsRedirectedToSoundTabOnTheSearchedResultPageByTappingBackInSoundDetailScreen_T1442(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToAddAndRemoveOriginalSoundFromFavourite_T1448(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToViewRelatedVideosForANewOrExistingSound_T1450(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToCreateVideoForExistingSoundEffect_T1451(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToViewNumberOfLikesOnVideoInTheSoundDetailsPage_T1464(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToViewNumberOnViewsOnVideoInTheSoundDetailsPage_T1465(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifySelectedSoundIsDisplayedInCreatorScreenAfterTappingOnUsethisSoundButtonInSoundDetailPage_T1467(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsRedirectedToSoundTabOnTheSearchedResultPageByTappingBackInSoundDetailScreen_T1473(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsRedirectedToSoundTabOnTheSearchedResultPageByTappingDeviceBackButtonInSoundDetailScreen_T1474(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToViewFullPlayerOfTheVideosByTappingOnAnyVideoInSoundDetailPage_T1483(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.validateTheAutoSuggestionListUnderFollowingTabRespectiveToSearchInput_T1384(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForUserCanSearchAnyFollowingUserFromTheList_T1385(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForUserCanSearchAnyFollowingUserFromTheList_T1413(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToAddANewlyOriginalSoundToFavourite_T1446(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToRemoveTheSoundFromFavourites_T1449(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyForVideoClicksOnTheBannersDetailsPage_T1519(userType);

	}
	
	
	@Test(priority = 3)
	@Parameters({ "userType"})
	public void loginScreenP1TCs(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);	

		Zee5ApplicasterHipiNeoBusinessLogic.enterLessThan10Digits__T824(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyPleaseProvideYourFullName__T992(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.invalidCodeMessageIsDisplayedWhenUserTappingOnVerfyOTPCTAWithoutEnteringOTP__T838(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyPleaseProvideValidPhoneNumber__T825(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToGetOTPForUnregisteredPhoneNumbe__T834(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.loginToHipiByTappingOnProfileIcon__T799(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.closeLoginToHipiPopupByTappingOnCrossIcon_T801(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToNavigateToLoginInScreenAfterTappingOnUsePhoneOrEmailCTA__T802(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.performReportActionByTapping__T804(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.selectCountryRegionScreenByTappingOn91__T808(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsNavigateToLoginWithPhoneNumberScreenByTappingOnCrossIconInSelectCountryRegionScreen__T811(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.removeTheEnteredPhoneNumberByTappingOnCrossIcon__T821(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.uIOfTheSignUpScreenFOrPhoneNumbern__T932(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userNavigateToVerificationScreenAfterTappingOnSendOTPCTA__T836(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToEnterThePhoneNumberInPhoneNumberFieldInLoginWithOTPScreen__T829(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserIsAbleToNavigateToEmailTabScreenByTappingOnEmailTabInLoginInScreen__T847(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkTheUIOfTheLoginWithPhoneNumber__T906(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.navigateToVerificationScreenAfterTappingOnSendOTPCTAInLoginWithPhoneNumberScreen__T908(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToResetThePhoneNumberByTappingOnResetCTA__T920(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToremoveTheEnteredPhoneNnumberByTappingOnCrossIconInForgotPasswordResetScreen__T922(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyPhoneNumberIsAcceptOnly10Digits__T823(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUISignUpScreenForPhoneNumber__T895(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.userIsAbleToRemoveRnteredPassworByTappingOnCrossIcon__T996(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.removeTheEnteredPhoneNumberByTappingOnCrossIcon__T993(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ScrollUPTheMonth__T887(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.scrollUpTheYear__T888(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.scrollDownTheDate__T889(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.scrollDownTheMonth__T890(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.scrollDownTheYear__T891(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.scrollUpTheDate__T933(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.scrollUpTheMonth__T934(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToTapOnSendOtp_T1760(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyInvalidOtpPopup_T1764(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyInvalidOtpPopup_T1767(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserAbleToEnterPhoneNumberAftertappingOnCrossIcon_T1777(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserAbleToEnterPhoneNumber_T1776(userType);

	}
	
	*/

	@Test(priority = 4)
	@Parameters({ "userType"})
	public void createrP1TCs(String userType) throws Exception 
	{
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

//		Zee5ApplicasterHipiNeoBusinessLogic.VerifyloginPopupOntappingPlusicon_T524(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.VerifyloginPopupOntappingPlusicon_T552(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.VerifyloginPopupOntappingPlusicon_T530(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingOnDeviceBackButton_T563(userType);
//
//		Zee5ApplicasterHipiNeoBusinessLogic.replaceAddedMusic_T612(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.createVideoWithExistingSound_T624(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyDescriptionAndHashtagPresentInNewVideo_T644(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.addAlphabetAndSpecialTextToVideo_T655(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyVoulmeDisplayedInVideoEditScreen_T674(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserIsAbleToTapOnVoulmeButton_T675(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyWithoutDescriptionUserCanCreateVideo_T680(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanUploadVideoWithHashtag_T681(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyWithoutHashtagUserCanCreateVideo_T682(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanMentionSinglePersonWhileUpload_T684(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.setVisibilityToPrivate_T689(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanEnableComments_T691(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanDisableComments_T693(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSetPrivacyToEnableLikes_T695(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSetPrivacyToDisableLikes_T697(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSetPrivacyToEnableDuet_T699(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSetPrivacyToDisableDuet_T701(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSetPrivacyToEnableDuet_T703(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSetPrivacyToDisableDuet_T705(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSaveVideoAsDraft_T707(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyvideoSavedAsDraft_T723(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifySaveAsDraftCtaIsVisible_T709(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyCoverPhotoIsDisplayedInVIdeoPostingPage_T710(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUSerCanCreateShortVIdeo_T726(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanAdjustMicrophoneVolume_T676(userType);

		//		Zee5ApplicasterHipiNeoBusinessLogic.verifyVideoCreation_T604(userType);		inva		
		//		Zee5ApplicasterHipiNeoBusinessLogic.addingMusic_T600(userType);//inva
		//		Zee5ApplicasterHipiNeoBusinessLogic.verifyPauseAndPlay_T599(userType);//inva

	}
	/*
	@Test(priority = 5)
	@Parameters({ "userType"})
	public void profileP1TCs(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.checkOnTappingFollowersUserIsNavigatedTOFollowersListScreen_T1094(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfOnTappingBackButtonUserIsRedirectedBackToProfileScreen_T1096(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkByTappingFollowingUserIsNavigatedToFollowingListScreen_T1103(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserIsAbleToTapOnInviteFriendsIcon_T1204(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkWhetherPermissionPopUpGetsDisplayedOrNot_T1206(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserIsAbleToClickOnCTAOnAllowAllRequiredPermissionPopup_T1212(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfOnTappingAnyUserFromFollowersListUserIsRedirectedToSelectedUserProfileDetailScreen_T1100(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserIsAbleToSharePrivateVideo_T1198(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.seeShoppableTabInProfile__T1244(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkWhetherDisclaimer__T1246(userType);


	}

	
	@Test(priority = 6)
	@Parameters({ "userType"})
	public void  settingAndPrivacyP1TCs(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.checkIfAfterTappingOn3DotsOnTopRightCornerUnderProfileUserIsDirectingUserToSettingsAndPrivacyScreen_T729(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfSearchingForASpecificKeywordIsLandingUserToRelevantInformation_T779(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfBackButtonAvailableOnTopLeftCornerIsFunctionalForUser_T782(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfTappingOnCommunityGuidelinesIsTakingUserToSpecificScreenWithRelevantInformation_T783(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfBackButtonAvailableOnTopLeftCornerIsFunctionalForUser_T786(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.logOutOpensAPopup__T795(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.noCTAClosesThePopup__T796(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingOutssideThePopupScreen__T797(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingOnYesCTALogsOutTheUser__T798(userType);

}	


	
	
	@Test(priority = 7)
	@Parameters({ "userType"})
	public void feedNewP1TCs(String userType) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);	
		
		Zee5ApplicasterHipiNeoBusinessLogic.CheckIfUserAbleToSeeMessageButtonOrCreatorProfileWhenUserTapsOnUsernameInFeedScreen_T1746(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CheckIfUserAbleToSeeMessageButtonOrCreatorProfileWhenUserTapsOnthumbnailInFeedScreen_T1747(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CheckUserAbleToComposeANewMessageAndSendToCreator_T1750(userType, "Hi");
		Zee5ApplicasterHipiNeoBusinessLogic.userAbleToSeeFollowButtonNextToUserhandle__T1923__T1924(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.detailsLikeEffectsFiltersSoundUserRedirectsToParticularPage__T1943(userType);//Fail

	}




	
	@Test(priority = 8)
	@Parameters({ "userType"})
	public void newDiscoverP1TCs(String userType) throws Exception 
	{
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.CheckUserIsAbleTOSeeCommentBoxInVideoRails_T1816_T1827(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic. ChecKUserIsAbleTOSeeCommentBoxInVideoRails_T1817_T1828(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ChecKUserIsAbleTOSeeCommentBoxInVideoRails_T1818_T1829(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ChecKUserIsAbleTOSeeCommentBoxInSoundDetailScreen_T1819_T1830(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ChecKUserIsAbleTOSeeCommentBoxInSoundDetailScreen_T1820_T1831(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ChecKIfLoginPopUpIsDisplayedWheneverUserTriesToPostAComment_T1835(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ChecKIfUserIsAbleToSeeCommentsPostedByOtherUsersOnTappingOnCommentBox_T1836(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ChecKIfLoginPopUpIsDisplayedWheneverUserTriesOnUserHandleOrThumbnailBesideComment_T1838(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ChecKIfUserIsAbleToNavigateToProfileDetailsScreenOnTappingUserHandleOrThumbnailInComments_T1933(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeCommentBoxInDiscoverSearchResult_T1812_T1823(userType,"Himanshi khurana");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeCommentBoxInSearchedProfileVideo_T1813_T1824(userType,"Himanshi khurana");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeCommentBoxInBytappingDifferentTabs_T1814_T1825(userType,"Himanshi khurana");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeCommentBoxInRailsProfileVideos_T1815_T1826(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.ChecKIfUserIsAbleToNavigateToProfileDetailsScreenOnTappingUserHandleOrThumbnailInComments_T1845(userType);

	}
	


	@Test(priority = 9)
	@Parameters({ "userType"})
	public void  creatorNewP1TCs(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanAddMultipleMediaInEditClipScreen_T1661(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeAddMediaCTA_T1662(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyOnTappingAddMediaUserNavigatesToEditclipScreenAndMediaIsUploaded_T1663(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfDuetsCreatorScreen_T1787(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfDuetsPostScreen_T1791(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfDuetsEditScreen_T1796(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFilterIcon_T1802(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyFilterscreenClosedOnTappingPlayerscreen_T1806(userType);//Not Feasible
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyEffectscreenClosedOnTappingPlateerscreen_T1798(userType);//Not Feasible
		
	}

	

	/*
	@Test(priority = 11)
	@Parameters({ "userType"})
	public void  PostScreenNewP1TCs(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.verifyAfterTappingOnSaveAsDraftUserNavigatesToFeedScreen_T1638(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyAfterTappingOnPostButtonUserNavigatesToFeedScreenAndUploadProgressIsDisplayed_T1639(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyAfterTappingOnSaveAsDraftUserNavigatesToFeedScreenAndUploadProgressIsDisplayed_T1640(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyVideoUploadStatusPopUpDisappers_T1647(userType);//Fail
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTappingOnCrossIconUserNavigatesToPostScreen_T1953(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTappingOnCrossIconUserNavigatesToPostScreen_T1954(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTappingOnBackArrowPopupIsDisplayed_T1955(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTappingOnBackArrowPopupComponentsAreDisplayed_T1956(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTappingOnKeepInDiscardEditPopupUserNavigatesToTrimScreen_T1958(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTappingOnKeepInDiscardEditPopupUserNavigatesToTrimScreen_T1960(userType);	
		System.out.println("All Detail P1 Tc's");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserAddCommentAsGuest_T1852(userType,"wow");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyCommentPopupIsDisplayedWhileCommenting_T1853(userType,"Himanshi");
		
		//----------------Draft P1 Tc's--------------------------
		
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfPostScreen_T1948(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserNavigatesToTrimScreenFromPostScreenByTappinEditCta_T1949(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserWhileLikingExistingCommentsLoginPopupIsDisplayed_T1854(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyGuestUserCanSeeLoginPopupOnTappingThumbnailOfUserCommented_T1855(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserAddedCommentsTimeGetsUpdated_T1874(userType,"Himanshi");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyHeightOfCommentBoxAndNavigationalBarIsSame_T1862(userType);//fails	

	}



	@Test(priority = 12)
	@Parameters({ "userType"})
	public void  profileNewP1TCs(String userType) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.CheckUserAbleToSeeMessageButtonInProfileScreenNextToBookMarkIcon_T1748(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CheckIfUserIsAbleToViewCommentPopUpOnTappingCommentBoxOverVideoPlayingOrPaused_T1866(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CheckIfUserAbleToCommentToOwnProfileVideoOnTappingCommentBoxWhenTheCommentIsDisabled_T1873(userType);				
		Zee5ApplicasterHipiNeoBusinessLogic.CheckTheMostRecentMessageShownInTop_T1754(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.socialMediaPlatformUserAbleToGetTheTextMessage__T1745(userType);

		
		
	}		


	
	@Test(priority = 13)				
	@Parameters({ "userType"})
	public void HashTagRelatedTcs(String userType) throws Exception 
	{	
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanViewHashTagDetailScreen_T046(userType);//Feed p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserNavigatedToFeedScreenByTappingOnBackInHastagScreen_T048_T092(userType);//feed p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserNavigatedToFeedScreenByTappingBackInHashTagScreen_T446(userType);//All detail p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserNavigatedToCreatorScreenByTappingOnVideoInHashTagDetailScreen_T1497(userType);//Discover p1Tc
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanCreateVideoWithHashTagDisplayedInFeedScreen_T1499(userType);//Discover p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyDafaultThumbnailOfHastagIsDisplayedInHashTagScreen_T1496(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserViewCommentBoxInHaghtagRelatedVideoScreen_T1821_T1832(userType);//T1821 p1 T1832 p2
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserViewCommentBox_T1822_T1833(userType);//T1822 p1 T1833 p1


	}

	*//*
	
	@Test(priority = 14)			
	@Parameters({ "userType"})
	public void AllNewModules(String userType) throws Exception 
	{
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);


		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanTapOnDuet_T2225(userType);//feed p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanTapOnDuetInFollowingTab_T2229(userType);//feed p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyLinkIsNonClickableInSoundDetailScreen_T2135(userType);//Profile p1 need to check
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfDuetCreatorScreen_T2232(userType);//feed p1	
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfDuetCreatorScreenFromFollowinTab_T2233(userType);//feed p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfDuetsEditScreen_T1789_T2236(userType);//feed p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfDuetsEditScreenFromFollowingTab_T2237(userType);//feed p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeUserHandlerWhileDuetVideo_T2238(userType);//feed p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeUserHandlerWhileDuetVideoInFollowingTab_T2239(userType);//feed p1	
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUiOfDuetsPostScreenFromFollowingTab_T2241(userType);//feed p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserDuetIsDisbledInPostScreenWhileDuetingWithOtherUsersFromFollowingTab_T2243(userType);//feed p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyOriginalSoundWithUserNameIsVisibleInSoundScreen_T2277_T2278(userType);//feed p1     Fail 
		Zee5ApplicasterHipiNeoBusinessLogic.verifyOriginalSoundisVisibleinFeedScreen_T2279_T2280(userType);//feed p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyOriginalSoundisVisibleinFeedScreenUnderFollowingTab_T2282(userType);//feed p1//Wrong Steps for2281
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeTextUploadingWhilePostingVideo_T1645(userType);
		//-------------------Creator Module----------------------- 
		Zee5ApplicasterHipiNeoBusinessLogic.discoverTabSelectedByDefault__T2257(userType);//M
		Zee5ApplicasterHipiNeoBusinessLogic.verifyTheUIOfSoundScreenSearchBar_T2250(userType); //P1
		Zee5ApplicasterHipiNeoBusinessLogic.verifysoundSearchResultHasThumbnailAndPlayIcon_T2254(userType);//creator p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanUploadVideoPostSelectingSound_T2274(userType);//creator p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanUploadVideoPostSelectingSoundIsSame_T2275(userType);//creator p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanUploadVideoPostReplacingAddedMusic_T2276(userType);//creator p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserBookmarkedSoundIsDisplayedUnderFavoritesTab_T2266(userType);//creator p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyMusicAddedIsDisplayedUnderFavoritesTab_T2267(userType);//creator p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeVolumeAsDefaultBy100_T2272(userType);								//creator p1   Need Code
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanReplaceMusicPostUseThisSound_T2273(userType);//creator p1									
		Zee5ApplicasterHipiNeoBusinessLogic.favouriteTabHasTheListOfSoundsAddedToFavourite__T2258(userType);//M   //P1
		Zee5ApplicasterHipiNeoBusinessLogic.tappedSeeAllOption__T2261(userType);//M   //P1
		//============================================================SettingsPrivacyP1Tcs===================================================
		//		Zee5ApplicasterHipiNeoBusinessLogic.checkIfOnTappinxIconInSearchBarSearchedItemWillDisappear_T2144(userType); // P1
		Zee5ApplicasterHipiNeoBusinessLogic.checkUIOfSearchBar_T2145(userType);// P1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyIfTheCorrespondingResultRspectiveToSearchedKeywordUsingSpecialCharacterShouldNotDisplay_T2147(userType, "@#$"); // P1
		//=========================================SoundDetailPage=================================
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserAbleToSeeOriginalSoundWithUserNameInSoundDetailPage_T2286_T2287(userType); //P1
		//================================================ProfileP1=================================================
		Zee5ApplicasterHipiNeoBusinessLogic.checkUserIsAbleTOShareHisPrivateVideo_T2226(userType);	//P1
		//=========================================Draft_PostVideoScreen===================================================
		Zee5ApplicasterHipiNeoBusinessLogic.checkUIOfThePostVideoScreenByTappingOnVideoDescriptionOfSavedDraftVideo_T2246(userType);//P1

		
		//		Fail
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateBackToVideoEditScreenFromTrimScreen_T1686(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserExitFromTrimScreenByTappigOnCrossIcon_T2214(userType);//creator p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanTrimMusicFromLocalTab_T2213(userType);//creator p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateBackToVideoEditScreenByTappingDeviceBackButtonTrimScreen_T1687(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserTextInTrimScreenIsDisplayed_T1688(userType);

		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.checkIfUserIsAbleToSearchTheContactListedInInviteFriendsScreen_T2143(userType); //P1
		}
		Zee5ApplicasterHipiNeoBusinessLogic.verifyIfTheCorrespondingResultRespectiveToSearchedKeywordDisplayedUnderTopMatchesBelowSearchBar_T2146(userType);// P1
		Zee5ApplicasterHipiNeoBusinessLogic.checkAddToFavoriteOptionDoesnotDisplayingWhenUserDoLongPressOnVideo_T2342(userType);//P1
		Zee5ApplicasterHipiNeoBusinessLogic.checkByTappingVideoThumbnailOnDraftVideosUserGetNavigatedToVideoPlayerScreen_T2337(userType); //P1

		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeRisingStarInSoundDetailPage_T2302(userType);//feed p1//Wrong Steps for2301
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeRisingStar_T2310(userType);//feed p1//Wrong Steps for2309


	}
	
	@Test(priority = 15)			
	@Parameters({ "userType"})
	public void NewTcs(String userType) throws Throwable 
	{
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		System.out.println("Settings And Privacy");
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeChangePassword_T2375(userType); // p1
		Zee5ApplicasterHipiNeoBusinessLogic.verifyPasswordCannotBeSamePopupDisplayed_T2383(userType);//p1
		Zee5ApplicasterHipiNeoBusinessLogic.miniPlayerContinuesToPlaySwitchedBetweenINTHISVIDEOAndSAVEDMOMENTSTab__T2393__T2400(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.switchedBetweenINTHISVIDEOAndSAVEDMOMENTSTabAndViceVersa__T2407__T2414(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.switchedBetweenINTHISVIDEOAndSAVEDMOMENTSTabAndViceVersaHashtag__T2421__T2428(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.VerifyCountOFLikes__T1485(userType);//Doubt
		System.out.println("Creator");
			if(userType.equalsIgnoreCase("NonSubscribedUser")) {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyClipInEditClipScreen_T1656(userType);
	}
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateToEditClipScreen_T1654(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateToTrimScreen_T1684(userType);
		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
			Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
			Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.textMessageUrlAndVideoAfterReceiving__T1692(userType);//non
		}
		Zee5ApplicasterHipiNeoBusinessLogic.CheckByTappingOnShareProfileUserGetsPopUpScreenToShareViaSocialMedia_T1695(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserNavigatesToRespectiveSocialMediaScreenOntappingShareeOption_T1696(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeUrlAndTextWhileSharingProfile_T1697(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserNavigatesToRespectiveSocialMediaScreenOntappingShareeOptionInCreatorsProfileVideo_T1702(userType);
		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
			Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
			Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeUrlTextAndVideoAsSender_T1703(userType);
		}
		
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSeeTextmessageandUrlIsVisibleAsSenderEnd_T1715(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyByTappingOnSharedLinkProfileIsOpened_T1718(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingShareIconOnSoundScreen__T1725(userType);//Fail
		Zee5ApplicasterHipiNeoBusinessLogic.tappingShareIconOnEffect__T1731(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.seeTheTextMessageUrl__T1733(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.textMessageUrlAfterReceiving__T1734(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingShareIconOnFilterScreen__T1737(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.textMessageUrlAfterReceivingFilter__T1740(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CheckHistoryOfMessageGetsDisplayedInProfileScreen_T1755(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.ableToSeeCommentBoxAtTheBottomOfTheScreen__T1865(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.tappingCommentBoxAtTheBottomOfTheScreenIfVideo__T1881(userType);

		
		Zee5ApplicasterHipiNeoBusinessLogic.commentBoxSharedFromSoundDetailScreen__T1879(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanSplitVideoOnEditClipScreen_T1681(userType);
		if(userType.equalsIgnoreCase("NonSubscribedUser")) {
			Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
			Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.checkWhenUserTapToshareVideoUserNavigatedToRespectiveSocialMediaScreen_T1708(userType);//Fail Doubt
		}
		
		
		//	//need to Bucket icon
		//	Zee5ApplicasterHipiNeoBusinessLogic.switchedBetweenINTHISVIDEOAndSAVEDMOMENTSTabAndViceVersaEffect__T2435__T2442(userType);
		//	//Dont run cover in p0
		////Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanNavigateToShareToScreen_T1701_T1713(userType);//Cover in p0 
		//	Zee5ApplicasterHipiNeoBusinessLogic.checkUserCanPostFiveSecondVideoWithHipiPassTheMicHashtag_T2462(userType);// Need to maintain 5 Sec Video Gallary //p1
//		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(false);
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyBypostingHipiPassTheMicDraftedVideoUserGetsBannerInFeedScreen_T2466(userType);//p1
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyInviteNowBannerIsDisappearedOnTappingOnIt_T2470(userType);//p1
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanShareToAnySocialMediaUnderShareSheet_T2473(userType);//p1
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyUserCanShareToAnySocialMedia_T2474(userType);//p1
//		Zee5ApplicasterHipiNeoBusinessLogic.switchedBetweenINTHISVIDEOAndSAVEDMOMENTSTabAndViceVersaFilter__T2449__T2456(userType);//Not Feasible
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyOnTappingOnJoinNowUserNavigatesToHastagDetailScreen_T2483(userType);//p1 Inactive
	}
	*/
	
//	@Test(priority = 15)			
	@Parameters({ "userType"})
	public void NewTcs1(String userType) throws Throwable 
	{
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		
		
//		Zee5ApplicasterHipiNeoBusinessLogic.verifyRedirectedToGalleryPhone__T2606(userType);	
//		Zee5ApplicasterHipiNeoBusinessLogic.selectMultipleVideosFromGallery__T2607(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.selectAMultipleImagesFromGallery__T2608(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.selectACombinationsOfMultipleVideosAndImagesFromGallery__T2609(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.uploadedMultipleVideosInLoopWithTimerForCurrentPosition__T2610(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.uploadedMultipleImagesInLoopWithTimerForCurrentPosition__T2611(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.uploadedCombinationOfMultipleVideosAndImages__T2612(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.maximumDurationForAnImageFileIs10Seconds__T2613(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.removeTheAddedVideos__T2614(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.removeTheAddedImages__T2615(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.videosUsingEditClipsOptionOnVideoEditScreen__T2616(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.videosUsingEditClipsOptionOnImageEditScreen__T2617(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.selectAsingleVideoFromGallery__T2653(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.selectAMultipleVideoFromGallery__T2654(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.selectAsingleImageFromGallery__T2655(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.selectAMultipleImageFromGallery__T2656(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.redirectedToTrimScreenSingleVideo__T2657(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.redirectedToTrimScreenMultipleVideo__T2658(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.redirectedToTrimScreenSingleImage__T2659(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.redirectedToTrimScreenmultipleImage__T2660(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.ableToSeeTrendingTagInTheRails__T2619__T2620(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.ableToSeeChallengeTagInTheRails__T2621__T2622(userType);
		
//		Zee5ApplicasterHipiNeoBusinessLogic.ableToSeeContestTagInTheRails__T2623__T2624(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.likeCountOnThumbnail__T2747__T2746(userType);
		
//		Zee5ApplicasterHipiNeoBusinessLogic.ableToSeeMonetizationCard__T2581__T2582(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.seeTheCountOfUnreadNotifications__T2570(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.seeTheCountOfUnreadNotificationsOnNotificationsIcon__T2574(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.sameCountOfUnreadNotificationsOnProfileIcon__T2576(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.redirectedToNotificationsScreen__T2577(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.readTheMessagesInTheNotificationScreen__T2578(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.seeTheTimeOfTheMessagesInTheNotificationScreen__T2579(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.countOfNotificationIsZeroOnceReadAllTheNotifications__T2580(userType);
		
		
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
//		Zee5ApplicasterHipiNeoBusinessLogic.ContentLanguagesDuringSignup__T2760(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
//		Zee5ApplicasterHipiNeoBusinessLogic.selectSingleLanguage__T2762(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.MultipleLanguage__T2764(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(true);
		Zee5ApplicasterHipiNeoBusinessLogic.moreLanguagesPreferenceAreSavedPostTapping__T2767(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.ableToSeeALabelTheMonetizationCardOnDiscoverScreen__T2584__T2585(userType);
		
		
		Zee5ApplicasterHipiNeoBusinessLogic.monetizationCardOnFollowingScreen__T2584__T2583(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.seeAnVideoADifItsAvailable__T2677__T2678(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LikeTheVideoAdsInFeed__T2681__T2682(userType);
		
	
	}
	

	@AfterTest						
	public void tearDownApp() {		
		System.out.println("Quit the App");
		Zee5ApplicasterHipiNeoBusinessLogic.tearDown();	
	}									
}
