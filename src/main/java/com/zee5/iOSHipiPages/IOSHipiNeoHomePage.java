package com.zee5.iOSHipiPages;

import org.openqa.selenium.By;

public class IOSHipiNeoHomePage {


	//Shopping the look---Alright Got it button
	public static By objiOSAlrightGotitBtn=By.xpath("//*[contains(text(),'Alright! Got it')]//* | //*[contains(@id,'Shop_CoachMark_OK')]");
	//save overlook--ok button
	public static By objiOSOkCoolBtn=By.xpath("//*[contains(text(),'Ok, Cool')]//* | //*[contains(@id,'_CoachMark_OK')]");
	//Discover button in below Tab Bar
	public static By objiOSDiscoverBtnInBelowTabBar=By.xpath("//*[contains(@accessibilityLabel,'Discover-')]|//*[@id='Discover']");	
	//Create button in below Tab Bar
	public static By objiOSCreateBtnInBelowTabBar=By.xpath("//*[contains(@accessibilityLabel,'Create-')] |//*[@value='Create']");
	//Profile button in below Tab Bar
	public static By objiOSProfileBtnInBelowTabBar=By.xpath("//*[contains(@accessibilityLabel,'Profile-')] | //*[@name='Profile'] "); 

	//Home button in below Tab Bar
	public static By objiOSHomeBtnInBelowTabBar=By.xpath("//*[contains(@value,'Home') and contains(@class,'utton')] | //*[contains(@id,'Feed-')]");


	public static By objiosNameInMsgWindow(String name) {
		return By.xpath("//*[@id='"+name+"']");
	}
	public static By objiosShopMsgInMessageApp=By.xpath("//*[@id='shop']");


	public static By objiosFollowBtnOnUserCardsInFoolowingTab=By.xpath("//*[@id='Follow' and @class='UIAButton']");	

	//save video
	public static By objiOSsave_video=By.xpath("//*[@id='Save video' and contains(@knownSuperClass,'UIButton')]");



	//Following
	public static By objiOSFollowingBtnInFeedScreen=By.xpath("//*[@id='Following']");

	//like btn

	public static By objiOSLikeBtn=By.xpath("//*[contains(@id,'like video') and contains(@knownSuperClass,'utton')] |//*[contains(@id,'LikeVideo')]");

	//comment btn

	public static By objiOSCommentBtn=By.xpath("//*[contains(@id,'comment video') and contains(@knownSuperClass,'utton')]");



	public static By objiosgoogleaccounts(int k) {
		return By.xpath("(//*[contains(@id,'@gmail.com')])["+k+"]");
	}
	//Mobile Number orPhone Number
	public static By objiosMobileNumberField=By.xpath("//*[@placeholder='  Phone number']");
	//backbtnFrom msg

	public static By objiosMessagebackBtn = By.xpath("//*[@knownSuperClass='UIControl']");

	//Swipe for next video Handgesture

	public static By objiosSwipeForNxtVideo = By.xpath("//*[contains(@text,' next video')]");

	// Account pop up while downloding from appstore
	public static By objiosAccPopUp = By.xpath("//*[contains(text(),'ACCOUNT')]");

	// Install Btn In Account pop up while downloding from appstore
	public static By objiosInstallBtnInAccPopUp = By.xpath("//*[contains(text(),'Install')]");

	// Search Tab Button
	public static By objiosSearchBar = By.xpath("//*[contains(text(),'Games, Apps, Stories')] | //*[contains(text(),'App Store')]");




	//hipi in testflight

	public static By objiosHipiInTestFlight = By.xpath("//*[@id='Hipi - Indian Short Video App' and @class='UIAStaticText']");

	//previous builds in testFlight

	public static By objiosPreviousBuildsInTestFlight = By.xpath("//*[@id='Previous Builds' and @knownSuperClass='UILabel']");

	//version in testfilght
	public static By objiosVersionIntestFlight(String version) {
		return By.xpath("//*[@id='"+version+"']");
	}

	//for respin release build
	public static By objiosRealeseIntestFlight(String Release) {
		return By.xpath("//*[contains(text(),' ("+Release+")')]//parent::*/*[@text='INSTALL']");
	}

	public static By objiosOlderVersionPopUp=By.xpath("//*[contains(text(),'Older ')]");


	public static By objiosInstallBtnOnOlderVersionPopUp=By.xpath("//*[@id='Install']");

	//open the specific build in testflight after installing
	public static By objiosOpenBtnIntestFlight(String Release) {
		return By.xpath("//*[contains(text(),' ("+Release+")')]//parent::*/*[@text='OPEN']");
	}

	//latest version in testFlight

	public static By objiosLatestBuildVersionInTestFlight = By.xpath("(//*[@id='- Indian Short Video App']//*[contains(@id,'Version')])[2]");

	//update in testflight

	public static By objiosUpdateBtnInTestFlight = By.xpath("//*[contains(text(),' - Indian Short Video App')]/*[@text='UPDATE']");




	//Install button in Testflight
	public static By objiosInstallButton = By.xpath("//*[contains(text(),'- Indian Short Video App')]/*[@text='INSTALL']");

	//Open Button in Testflight
	public static By objiosOpenButton = By.xpath("//*[contains(text(),'- Indian Short Video App')]/*[@text='OPEN']");


	//From The Developer
	public static By objiosFromTheDeveloper = By.xpath("//*[@text='From the Developer']");

	//Back arrow from Feed Screen

	public static By objiosBackArrowButtonFromFeed=By.xpath("//*[contains(@id,'back_arrow')]");

	//Next button
	public static By objiosNextButton = By.xpath("(//*[@XCElementType='XCUIElementTypeButton' and @text='Next'])[1]");
	//Share Feedback
	public static By objiosShareFeedback = By.xpath("//*[@text='Share Feedback']");
	//Start Testing
	public static By objiosStartTesting = By.xpath("(//*[@XCElementType='XCUIElementTypeButton' and @text='Start Testing'])[1]");


	//Open Button
	public static By objiosAppStoreOpenBtn = By.xpath("//*[contains(text(),'- Indian Short Video App') and contains(text(),' ratings')]/*[@text='open']");


	//Popup Allow button
	public static By objiosAllowButton = By.xpath("//*[@id='Allow' and @class='UIAButton']");

	//HiP Would Like to Send You Notifications' popup
	//		public static By objiosNotificationsPopup = By.xpath("//*[@id='"hipi" Would Like to Send You Notifications']");

	//AllowAccesssToPhotos
	//		public static By objiosNotificationAllowAccesssToPhotosPopup = By.xpath("//*[@id='"hipi" Would Like to Access Your Photos']");


	//Popup ok button for save access
	public static By objiosSaveVideoAccessPopUpOKButton = By.xpath("//*[@id='OK']");
	//Search Tab Button
	public static By objiosSearchTabBtn = By.xpath("//*[@class='UIATabBar']//*[@class='UIAButton' and @text='Search']");


	//Re-Download button
	public static By objiosAppStoreHipiReDownloadBtn = By.xpath("//*[contains(text(),'- Indian Short Video App') and contains(text(),' ratings')]/*[@text='re-download'] | //*[contains(text(),'- Indian Short Video App') and contains(text(),' ratings')]//*[@id='get']");


	//WiFi-off
	public static By objiOSWifiOff=By.xpath("//*[@id='wifi-button' and @value='0']");

	//wifi on but NotConnected		
	public static By objiOSWifiOnButNotConnected=By.xpath("//*[@id='wifi-button' and @value='1'  and @text='Wi-Fi, Searching']");

	//WiFi-On
	public static By objiOSWifiIsOn=By.xpath("//*[@id='wifi-button' and @value='1']");



	//network error
	public static By objiOSNetworkError=By.xpath("//*[contains(@id,'onnection')]");


	//Feed Screen
	public static By objiOSFeedScreen=By.xpath("(//*[@id='Progress']//ancestor::*//*[@class='UIAScrollView']//following-sibling::*//child::*)[4]");


	//For You
	public static By objiOSForYouBtnInFeedScreen=By.xpath("//*[contains(@id,'Foryou_')]");

	//Tab Bar
	public static By objiOSBelowTabBarInFeedScreen=By.xpath("//*[ @class='UIATabBar']");



	//Shop button in below Tab Bar
	public static By objiOSShopBtnInBelowTabBar=By.xpath("//*[@id='SHOP' and @knownSuperClass='UIButton']");




	//profileCloseBtn

	public static By objiOSProfileCloseBtnInBelowTabBar=By.xpath("//*[@id='ic close' and @knownSuperClass='UIButton']");


	//Play button
	public static By objiOSPlayBtnInFeedScreen=By.xpath("//*[@id='b' and @class='UIAButton']");



	public static By objiOSUsePhoneOrEmail=By.xpath("//*[@id='Use Phone or Email' and @class='UIAButton']");

	public static By  objiOSEmailOption=By.xpath("//*[@class='UIACollectionView']//child::*//*[@id='Email']");

	public static By objiOSEmailIdField=By.xpath("//*[@placeholder='  Email address' and @class='UIATextField']");

	public static By objiosPasswordField=By.xpath("//*[@placeholder='  Password' and @class='UIATextField']");

	public static By objiiosLoginBtn=By.xpath("//*[@id='Log in' and @knownSuperClass='UIButton']");

	public static By objiiosLoginToastMsg=By.xpath("//*[contains(@text,'ogged-in')]");

	public static By objiiosLogOutToastMsg=By.xpath("//*[contains(@text,'ogged-out')]");

	//Refresh on top of screen

	public static By objiiosRefresh=By.xpath("//*[@id='In progress' and @knownSuperClass='UIActivityIndicatorView']");

	//followbutton

	public static By objiOSFollowBtn=By.xpath("//*[contains(@id,'Username')]/..//following-sibling::*");



	//saveLook

	public static By objiOSSaveLookBtn=By.xpath("//*[contains(text(),' LOOK')]");



	//Heart btn
	public static By objiOSHeartBtn=By.xpath("//*[@id='cbsdk_save_look' and @knownSuperClass='UIImageView']");


	//Heart btn Selected
	public static By objiOSHeartBtn_Seleted=By.xpath("//*[@id='cbsdk_save_look_selected' and @knownSuperClass='UIImageView']");



	//User Name In FeedScreen
	public static By objiOSUserNameInFeedScreen=By.xpath("//*[contains(@id,'Username')]");

	//HashTag
	public static By objiOSHashTagInFeedScreen=By.xpath("//*[contains(@id,'Hashtags')]");

	//Music
	public static By objiOSMusicInFeedScreen=By.xpath("//*[contains(@id,'sound video')]//parent::*[@class='UIAView']//child::*[contains(@knownSuperClass,'abel')]");

	//AddedEffectOnScreen
	public static By objiOSAddedEffectOnScreen=By.xpath("//*[contains(@id,'effect')]//parent::*[@class='UIAView']//child::*[contains(@knownSuperClass,'abel')]");


	//AddedFiltersOnScreen
	public static By objiOSAddedFiltersOnScreen=By.xpath("//*[contains(@id,'filters')]//parent::*[@class='UIAView']//child::*[contains(@knownSuperClass,'abel')]");

	//SaveVideo
	public static By objiOSSaveVideoPopUp=By.xpath("//*[@id='Save video' and @knownSuperClass='UIButton']");

	//AddToFavourites
	public static By objiOSAddToFavouritesPopUp=By.xpath("//*[contains(@id,'Add to Favourite')]");

	//Report
	public static By objiOSReportPopUp=By.xpath("//*[@id='Report' and @knownSuperClass='UIButton']");

	//Not interested
	public static By objiOSNotinterestedPopUp=By.xpath("//*[@id='Not interested' and @knownSuperClass='UIButton']");

	//Creator disabled
	public static By objiOSCreatordisabled=By.xpath("//*[contains(text(),' creator disabled')]");


	//video_saved

	public static By objiOSVideo_saved=By.xpath("//*[@id='Video Saved' and @knownSuperClass='UILabel']");

	//video_saved

	public static By objiOSHipiNoLongerAppear=By.xpath("//*[contains(text(),'This HiPi will no longer appear in your feed')]");


	//LoginBtnInFollwingSection

	public static By objiOSHipiLoginBtnInFollwingSection=By.xpath("//*[contains(@text,'ollow an')]");



	public static By objiOSHipiFollowBtnInFollwingSection=By.xpath("//*[contains(@class,'Collection')]//following-sibling::*[contains(@text,'ollow')]");



	//image after clicking on saveLook button
	public static By objiOSHipiImageAferSavedInfeedSection(int index) {
		return By.xpath("//*[contains(@id,'Name-ProductImage"+index+"')]");
	}

	//number of shoppable images
	public static By objiOSHipiTotalShoppableImagesfeedSection=By.xpath("//*[@class='UIACollectionView']/*/*/*[@class='UIAImage']");


	public static By objiOSHipiSavedButtonInHomePage=By.xpath("//*[@id='SAVED' and @knownSuperClass='UILabel']");

	public static By objiosFollowIconInHomePage=By.xpath("//*[@id='ic like video']/..//preceding-sibling::*//child::*[2]");

	//09/12/21=================================================================================================================

	public static By objiosMidPointInVideos=By.xpath("(//*[@id='Button']/../../..//*[@knownSuperClass='UIView'])[1]");

	public static By objiosPauseButtonInVideos=By.xpath("//*[@id='b']");



	//===============================s=====================================================
	//Save look Icon In Home Page
	public static By objiOSSaveLookIcon=By.xpath("//*[@id='cbsdk_save_look' and @knownSuperClass='UIImageView']");
	public static By objiOSSavedVideos = By.xpath("//*[@id='SAVED' and @knownSuperClass='UILabel']");
	//Save Video
	public static By objSaveVideo=By.xpath("//*[@id='Save video' and @knownSuperClass='UIButton']");
	//Saved Video
	public static By objSavedVideo=By.xpath("//*[@id='Video Saved']");

	//Add following below code in
	//rail name
	public static By objiosrailname=By.xpath("(//*[@value='ic arrow next']//preceding-sibling::*[@class='UIAView']//child::*)[1]");
	//rail view all button
	public static By objiosrailviewallbutton(String railName) {
		return By.xpath("//*[@class='UIAView']//child::*[@text='"+railName+"']//parent::*[@class='UIAView']//following-sibling::*[@class='UIAButton']");
	}


	//////////////////////8-12////////////feed///////////p1////////////////////

	//Login Popup
	public static By objiosLoginPopUp=By.xpath("//*[@id='Login in to Hipi']");

	//music page in feed screen
	public static By objiosMusicPageInFeedScreen=By.xpath("(//*[@id='Use this sound'])[1]");



	//Cross Icon In Comment Button
	public static By objiosCrossIconInCommentbutton=By.xpath("//*[contains(@id,'close')] | //*[contains(@id,'lose')]");

	public static By objiosCrossIconInPrivateCommentbutton=By.xpath("//*[@id='closeButton']");

	//Add To Favourites In Share Button		
	public static By objiosAddToFavouritesInShareBtn=By.xpath("//*[contains(@id,'avourite') and contains(@class,'Button')]");

	//Added To Favorite
	public static By objiosAddedToFavorites=By.xpath("//*[contains(@id,'avourite')]");

	//Message In Share Button
	public static By objiosMessagesInShareButton=By.xpath("//*[@class='UIAView' and ./*[@class='UIAView' and ./*[@class='UIAView' and ./*[@text='Messages']]]]");

	//Cross Icon In share Button
	public static By objiosCrossIconInShareButton=By.xpath("//*[@id='Close']");





	public static By SaveVideoReportNotInterestedAddToFavourites(String type){
		return By.xpath("//*[@id='"+type+"' and @knownSuperClass='UIButton']");

	}

	// n ============24-12-2021==========================================================

	//No Internet Connection 
	public static By objiosNoInternetConnectionTostMessage=By.xpath("//*[contains(@id,'onnection')]");

	public static By objiosNoInternetErrorTostMessageInLoginScreen=By.xpath("//*[contains(@id,'Internet error')]");

	// n ============25-12-2021==========================================================	

	// login button in login to continue page
	public static By objiosLoginButtonInLoginToContinuePage=By.xpath("//*[@id='Login']");

	//pop up when user hold the player screen (long press) 



	public static By ShareScreenAllTabs(String tabname){
		return By.xpath("(//*[@id='"+tabname+"'])[2]");
	}	

	// toast message for not interested tab 

	public static By objiosNotInterestedTostMessage=By.xpath("//*[@id='This Hipi will no longer appear in your feed']");	



	///////////////s/////24-12-21------------------------s
	//Following Tab
	public static By objiosFollowingTabInFeedScreen=By.xpath("//*[contains(@id,'Following_')]");

	//network error in comment icon
	public static By onjiosNetworkErrorInCommentIcon=By.xpath("//*[@id='Network Error']");


	/////////////27-12-21
	//Not Interested In Share Icon
	public static By objiosNotInterestedInShareIcon=By.xpath("(//*[@id='Not Interested'])[1]");

	/////////////////////////////////29/12/21////////////////////////////////////////////
	//saved look
	public static By objiosSavedLook=By.xpath("//*[@id='SAVED']");

	///////////////28-12-21
	//hipi google popup
	public static By objiosGooglePopup=By.xpath("(//*[contains(@text,'google.com')])[2]");

	//continue with the google
	public static By objiosContinueWithGoogle=By.xpath("//*[@id='Continue']");

	//Internet Error In Google Poup
	public static By objiosInternetErrorInGooglePoup=By.xpath("//*[@id='Safari cannot open the page because your iPhone is not connected to the internet.']");

	//cancel the Google Page
	public static By objiosCancelTheGoogle=By.xpath("(//*[@id='Cancel'])[1]");

	//Continue with thwe google
	public static By objiosContinuewithTheGoogle=By.xpath("(//*[@id='Continue with Google'])[1]");

	//Continue with the Facebook
	public static By objiosContinuewithTheFacebook=By.xpath("(//*[@id='Continue with Facebook'])[1]");

	//Verify List of Goggle Accounts
	public static By objiosVerifyListofGoogleAccounts=By.xpath("(//*[contains(text(),'gmail')])[2]");

	//facebook popup
	public static By objiosFacebookPopup=By.xpath("(//*[contains(@text,'facebook.com')])[2]");

	//Term of Service
	public static By objiosTermofSerivceInGoogleAccount=By.xpath("(//*[@id='Terms of Service'])[1]");

	//use another account
	public static By objiosUseAnotherAccount=By.xpath("(//*[@id='Use another account'])[1]");

	//Privacy Policy
	public static By objiosPrivacyPolicy=By.xpath("(//*[@id='privacy policy'])[1]");

	//Create Account In facebook
	public static By objiosCreateAccountInfacebook=By.xpath("(//*[@id='Create account'])[1]");

	//Forgot Password In Facebook
	public static By objiosForgotPasswordInFacebook=By.xpath("(//*[@id='Forgotten password?'])[1]");

	//LogIn Facebook
	public static By objiosLogInFacebook=By.xpath("//*[@id='Log In']");

	//Mobile Number orPhone Number
	public static By objiosMobileNumberorPhoneNumber=By.xpath("//*[@label='Mobile number or email address']");

	//facebook password
	public static By objiosFacebookPassword=By.xpath("//*[@placeholder='Facebook password' and @class='UIATextField']");


	//Tag Name In Feed Screen
	public static By objiosTagsNameInFeedScreen=By.xpath("//*[contains(@id,'Hashtags-')]");		



	/*
	 * public static By ShareScreenAllTabs(String tabname){ return
	 * By.xpath("//*[@id='"+tabname+"' and @class='UIAButton']"); }
	 */

	public static By objiosToastMessageByClickNotInterestedInShareScreen=By.xpath("//*[@id='This Hipi will no longer appear in your feed']");



	//19-01-22============================
	//comment box in comment screen	
	public static By objiosCommentBoxInCommentScreen=By.xpath("//*[@id='Add comment...']");	
	//send button in comment box
	public static By objiosSendButtonIncommentbox=By.xpath("//*[@id='ic send black']");

	//============20-01-22
	//Number of Likes 
	public static By objiosTotalNumberOfLikes=By.xpath("//*[contains(@id,'TotalLikes')]");

	//----------------deeplinkURL----------------------------------------------------------------------

	public static By objiosDeepLinkURLInMessageApp=By.xpath("//*[contains(text(),'co.in') and contains(@id,'com.apple.messages.URLBalloonProvider')] | //*[contains(text(),'.app') and contains(@id,'com.apple.messages.URLBalloonProvider')]");

	public static By objiosComposeBtnInMessageApp=By.xpath("//*[contains(@text,'Compose')]");

	public static By objiosTOTextFieldInMessageApp=By.xpath("(//*[@value='To:'])[1]");
	//(//*[contains(@value,'To:')])[1]

	public static By objiosMsgBodyFieldInMessageApp=By.xpath("//*[contains(@id,'messageBodyField')]");

	public static By objiosSendBtnInMessageApp=By.xpath("//*[contains(@id,'send')]");

	public static By objiosBackBtnInMessageApp=By.xpath("//*[@knownSuperClass='UIControl']");

	//User Name In FeedScreen-For You
	public static By objiOSUserNameInForYouScreen=By.xpath("//*[contains(@accessibilityLabel,'Id-UsernameForYou')]");

	//User Name In FeedScreen-Following
	public static By objiOSUserNameInFollowingScreen=By.xpath("//*[contains(@accessibilityLabel,'Id-UsernameFollowing')]");



	//-------------------------feb--18-----------------------------------------------------------------------

	//============20-01-22

	/////////////////////////////9-2-22/////////////////////////////////////////////////
	//profile picture
	public static By objiosprofilepicture=By.xpath("//*[contains(@id,'ProfilePictureForYou')] | //*[contains(@id,'ProfilePictureFollowing')]");

	//Total comments
	public static By objiosTotalComments=By.xpath("//*[contains(@id,'TotalComments')]");

	//liked video
	public static By objiosLikedVideo=By.xpath("//*[contains(text(),'like')]");



	//following in home page
	public static By objiosFollowingInHomePage=By.xpath("(//*[@id='Following'])[2]");

	//comments count
	public static By objiosCommentCount=By.xpath("(//*[contains(@text,'Comments')])[2]");

	//profile picture forming
	public static By objiosProfilePictureFollowing=By.xpath("//*[contains(@id,'ProfilePictureFollowing')]");





	// + Icon In Feed Screen 
	public static By objiOSFollowBtnSelectedFalseInFeedScreen=By.xpath("//*[contains(@id,'Name-FollowButton_Selected-false')]");

	public static By objiOSFollowBtnSelectedTrueInFeedScreen=By.xpath("//*[contains(@id,'Name-FollowButton_Selected-true')]");

	public static By objiOSProfilePictureInFeedScreen=By.xpath("//*[contains(@id,'ProfilePicture')]");

	public static By objiOSFollowingTabSelectedTrueInFeedScreen=By.xpath("//*[contains(@id,'Following_Selected-true')]");

	public static By objiOSFollowingTabSelectedFalseInFeedScreen=By.xpath("//*[contains(@id,'Following_Selected-false')]");

	public static By objiOSForYouTabSelectedTrueInFeedScreen=By.xpath("//*[contains(@id,'Foryou_Selected-true')]");

	public static By objiOSForYouTabSelectedFalseInFeedScreen=By.xpath("//*[contains(@id,'Foryou_Selected-false')]");	


	public static By objiOSLikedBtnInFeedScreen=By.xpath("//*[contains(@id,'LikedVideo')]");



	public static By objiOSTotalLikesBtn=By.xpath("//*[contains(@id,'TotalLikes')]");

	public static By objiOSLikeBtnInFeedScreen=By.xpath("//*[contains(@id,'icLikeVideo')]");
	public static By objiOSTotalCommentInFeedScreen=By.xpath("//*[contains(@id,'TotalComments')]");


	//=======================


	//save overlook--pop up
	public static By objiOSSaveOverLookPopUp=By.xpath("//*[contains(text(),'Save the overall look')]");



	//=============================================		


	//Track Activity Popup 'Ask App not to Track' button
	public static By objiosAskAppNotToTrackButton = By.xpath("//*[contains(@text,'Ask App')] |//*[@text='Don’t Allow']");	



	//Popup Don't Allow button
	public static By objiosDontAllowButton = By.xpath("//*[contains(@text,'Ask App')] |//*[@text='Don’t Allow']");

	//AllowAccesssToPhotos
	public static By objiosNotificationAllowAccesssToPhotosPopup = By.xpath("//*[contains(@id,'Would Like to Access Your Photos')]");

	//Popup Allow button for save access
	public static By objiosSaveVideoAccessPopUpAllowButton = By.xpath("//*[contains(@id,'Allow Access')]");

	//Track Activity Popup
	public static By objiosTrackActivityPermissionPopup = By.xpath("(//*[contains(@id,'track your activity')])[1] | //*[contains(@id,'Would Like to Send You Notifications')]");

	//'“HiPI” Would Like to Send You Notifications' popup
	public static By objiosNotificationsPopup = By.xpath("(//*[contains(@id,'track your activity')])[1] | //*[contains(@id,'Would Like to Send You Notifications')]");

	//Shopping the look
	public static By objiOSShoppingthelookLookBtn=By.xpath("//*[contains(@accessibilityLabel,'Shop_CoachMark_Title')]");


	//=================================comment==========================================================
	public static By objiOSAddACommentTextFieldInFeedScreen=By.xpath("//*[contains(@id,'Add_comme')]");

	public static By objiOSAddedCommentTextFieldInFeedScreen=By.xpath("//*[contains(@id,'Added_comment')]");

	public static By objiOSUserCommentInFeedScreen=By.xpath("//*[contains(@id,'ser_1_')]//*");

	public static By objiOSPostButtonInCommentScreen=By.xpath("//*[contains(@id,'Post')]");

	public static By objiOSAddedCommentInCommentScreen=By.xpath("//*[contains(@id,'Added_')]//*");

	public static By objiOSAddedCommentBoxInCommentScreen=By.xpath("//*[contains(@id,'Added_comment')]");

	public static By UserNameInCommentScreen(int index) {
		return By.xpath("(//*[@class='UIATable']//*[contains(@text,'@') ])["+index+"]");
	}//(//*[contains(@id,'User_1_desc')]//following-sibling::*)[3]

	public static By UserCommentDescInCommentSection(int index) {
		return By.xpath("(//*[contains(@id,'_desc')]//child::*)["+index+"]");
	}

	public static By objiOSMinutesAgoInCommentScreen=By.xpath("//*[contains(@id,'minute')]");

	public static By objiOSHoursAgoInCommentScreen=By.xpath("//*[contains(@id,'hours')]");

	public static By objiOSMonthsAgoInCommentScreen=By.xpath("//*[contains(@id,'month')]");

	public static By objiOSJustNowInCommentScreen=By.xpath("//*[contains(@id,'few seconds ago')]");

	public static By objiOSDaysAgoInCommentScreen=By.xpath("//*[contains(@id,'day')]");

	public static By objiOSWeekAgoInCommentScreen=By.xpath("//*[contains(@id,'week')]");

	public static By objiOSSuggestedUserNameInCommentScreen(String username) {
		return By.xpath("//*[@id='Suggestions']//parent::*//following-sibling::*[@class='UIATable']//*[contains(@id,'"+username+"')]");
	}
	//*[@id='Suggestions']//parent::*//following-sibling::*[@class='UIATable']//*[contains(@id,'@Himanshikhurana')]

	public static By objiOSSuggestedHashTagInCommentScreen(String username) {
		return By.xpath("//*[@class='UIATable']//*[contains(@id,'"+username+"')]");
	}

	public static By objiOSTotalLikesInCommentScreen=By.xpath("//*[contains(@id,'Total_Likes')]");

	public static By UserNameXpath(String Text1) {
		return By.xpath("//*[@class='UIATable']//*[contains(text(),'"+Text1+"')]");
	}
	////*[@class='UIATable']//*[contains(text(),'@royalindia51')]

	public static By LikedIconInCommentScreen(int index) {
		return By.xpath("//*[contains(@id,'Liked_comment_"+index+"')]");
	}

	public static By AnyLikedIconInCommentScreen=By.xpath("//*[contains(@id,'Liked_')]");

	public static By LikeIconInCommentScreen(int index) {
		return By.xpath("//*[contains(@id,'Like_comment_"+index+"')]");
	}

	public static By AnyLikeIconInCommentScreen=By.xpath("//*[contains(@id,'Like_')]");

	public static By AnyLikecountbelowComment=By.xpath("//*[contains(@id,'Total_Likes')]");

	public static By LikecountbelowComment(int index) {
		return By.xpath("(//*[contains(@id,'Total_Likes')])["+index+"]");
	}


	public static By EmojiInKeyBoardBtn=By.xpath("//*[contains(@id,'Emoji')]");

	public static By OneOFEmojisInKeyBoardBtn(int index) {
		return By.xpath("(//*[contains(@id,'SMILEYS &')]//following-sibling::*)["+index+"]");
	}


	public static By objiosGifOrimage=By.xpath("//*[@id='GIF/Image']");

	public static By objiosCommentCopiedToastMsg=By.xpath("//*[contains(@id,'opied')]");




	//share btn

	public static By objiOSShareBtn=By.xpath("//*[contains(@id,'share video')]");

	//Back Arrow
	public static By objiosBackArrowInMusicPage=By.xpath("//*[contains(@id,'back_arrow')]");

	//closeicon for poup
	public static By objiosCloseIconPoup=By.xpath("//*[contains(@id,'close')]");


	public static By objiosCancelButtonInMessageInShareButton=By.xpath("//*[contains(@id,'Cancel')]");

	public static By objiosNewMessagesInMessageInShareButton=By.xpath("//*[contains(@id,'New Message')]");	




	public static By objiosAddCommentFieldInBottomNavigationBar=By.xpath("//*[contains(@id,'Add comment')]");

	public static By objiosthumbnailBesideCommentsAddedByOtherUsers=By.xpath("//*[contains(@id,'Like_comment_1')]//following-sibling::*[3]");

	public static By objiosCommentCopiedInCommentScreen=By.xpath("//*[contains(@id,'Comment Copied')]");

	public static By objiosProgressiveBarInFeedScreen=By.xpath("//*[contains(@id,'Progress')]");

	public static By objiosSoundsInFeedScreen=By.xpath("//*[@id='ic sound video']//following-sibling::*");		

	public static By objiosBottomNavigationBarInFeedScreen=By.xpath("//*[contains(@class,'UIATabBar')]");



	//28_06_2022

	public static By objiosFollowSuggestionButtonInFollowingScreen=By.xpath("//*[@id='Follow']");

	public static By objiosProfilePictureInFollowingScreen=By.xpath("(//*[@id='com.zee5.hipi:id/ProfilePictureProfilePage'])[1]");

	public static By objiosProfilePictureUserNameInFollowingScreen=By.xpath("((//*[@id='com.zee5.hipi:id/ProfilePictureProfilePage']//following-sibling::*)[1]//child::*)[1]");















}
