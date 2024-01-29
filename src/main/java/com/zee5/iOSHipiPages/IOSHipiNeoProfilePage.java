package com.zee5.iOSHipiPages;

import org.openqa.selenium.By;

public class IOSHipiNeoProfilePage {
	public static By objiosFollowersFollowingLikes(String type) {
		return By.xpath("(//*[contains(@id,'"+type+"')])[2]");
		////*[contains(@id,'bookmark')]
	}

	//Videos In private Button
	public static By objiosVideosInprivateButton= By.xpath("(//*[contains(@id,'VideoCreated')])[1]");

	//no shoppable inside shoppable tab
	public static By objiosNoshoppable=By.xpath("//*[contains(@id,'hoppable')]"); 

	public static By nameUsernameDescription(String title) {
		return By.xpath("//*[contains(@id,'"+title+"')]//following-sibling::*[1]");
	}


	public static By objiOSProfileNamesInProfileDetailsPage=By.xpath("//*[contains(@id,'Name-UsernameProfilePage')]");

	//KeyboardDoneBtn

	public static By objiiosKeyboardDoneBtn = By.xpath("//*[@id='Done']");

	// OpenThisPageFBPopUp

	public static By objiiosOpenThisPageFBPopUp = By.xpath("//*[contains(@id,'Open in')]");

	// openBtnInFbPopUp

	public static By objiiosopenBtnInFbPopUp = By.xpath("//*[contains(text(),'Open')  and  contains(@class,'Button')]");

	//login to hipi

	public static By objiiosLoginPopUp=By.xpath("//*[@id='Login in to Hipi' and @knownSuperClass='UILabel']");

	//3dotsmenu
	public static By objiOS3dotsmenu=By.xpath("//*[@id='ic more black' and @class='UIAButton']");

	//manage account
	public static By objiOSmanageAcct=By.xpath("//*[contains(@id,'Manage account')]");

	//Login PopUp close button
	public static By objiOSLoginPopUpCloseBtn=By.xpath("//*[@id='ic close' and @knownSuperClass='UIButton']");

	//username profile details page
	public static By objiOSUserNameInProfileDetailsPage=By.xpath("//*[@knownSuperClass='UINavigationBar']//child::*[contains(text(),'@')]");

	//BackButtonFromProfileDetailsPage
	public static By objiOSBackButtonFromProfileDetailsPage=By.xpath("//*[@knownSuperClass='UINavigationBar']//child::*[@id='ic back arrow'] | //*[contains(@id,'back')]");

	//edit profile in ProfileDetailsPage
	public static By objiOSeditprofileButtonFromProfileDetailsPage=By.xpath("//*[@id='Edit Profile' and @knownSuperClass='UIButton']");

	//following label in profile details page
	public static By objiOSFollowingLabelInProfileDetailsPage=By.xpath("//*[@id='Following' and @knownSuperClass='UILabel']");

	//followers label in profile details page
	public static By objiOSFollowersLabelInProfileDetailsPage=By.xpath("//*[@id='Followers' and @knownSuperClass='UILabel']");

	//Likes label in profile details page
	public static By objiOSLikesLabelInProfileDetailsPage=By.xpath("//*[@id='Likes' and @knownSuperClass='UILabel']");

	//Continue with profile
	public static By objiosContnueWithFB=By.xpath("//*[@id='Continue with Facebook' and @knownSuperClass='UIButton']");


	//FBallowPopUpContinueCTA
	public static By objiosFBallowPopUpContinueCTA=By.xpath("//*[@id='Continue' and @class='UIAButton']");

	//facebookSiteInHipi
	public static By objiosfacebookSiteInHipi=By.xpath("//*[@id='URL' and @label='Address' and @class='UIAView']");

	//facebookAllowPopUp
	public static By objiosfacebookAllowPopUp=By.xpath("//*[contains(text(),'facebook.com')]");

	//Save password PopUp
	public static By objiosSavePasswordPopUp=By.xpath("//*[contains(text(),'Save Password') and @class='UIAButton']");

	//Not now cta
	public static By objiosNotNowButtonInSavePasswordPopUp=By.xpath("//*[contains(text(),'Not Now') and @class='UIAButton']");

	//facebookSiteInHipiContinueCTA
	public static By objiosfacebookSiteInHipiContinueCTA=By.xpath("//*[contains(text(),'Continue') and @knownSuperClass='NSObject']");


	//facebookSiteInHipi
	public static By objiosfacebookSiteCancelCTAInHipi=By.xpath("//*[@id='Cancel' and @knownSuperClass='UIButton']");


	//Logged-in Successfully Toast msg
	public static By objiosLoggedinSuccessfullyCTA=By.xpath("//*[@id='Logged-in Successfully' and @knownSuperClass='UILabel']");

	//facebook page
	public static By objiosFacebookTextInFacebookPage=By.xpath("//*[@value='‎facebook.com, secure and validated connection' and @class='UIAView']");





	//s/////7-12//////////////
	//Private Video Button in profile page
	public static By objiosPrivateVideoButtonInProfilePage=By.xpath("//*[@id='ic profile tab lock unselected']");


	//Save Video In Private Videos
	public static By objiosSaveVideoInPrivateVideos=By.xpath("//*[@id='Save video' and @class='UIAButton']");

	//Back Arrow In Private Video
	public static By objiosBackArrowInPrivateVideo=By.xpath("//*[@id='ic back arrow'] |  //*[contains(@id,'back')]");

	//Verify User Page
	public static By objiosVerifyUserpage=By.xpath("//*[contains(@text,'@')]");

	//Draft video
	public static By objiosDraftVideoInProfilePage=By.xpath("//*[@id='Drafts']");

	//Draft Page
	public static By objiosDraftPageInProfilePage=By.xpath("//*[@id='Drafts' and @class='UIANavigationBar']");

	//Video Button Play In Drafts Page
	public static By objiosVideoButtonPlayInDraftsPage=By.xpath("//*[@id='btnPlay']");

	//Delete Button In drafts Video
	public static By objiosDeleteButtonIndraftsVideo=By.xpath("//*[@id='Delete' and @class='UIAButton']");


	//Delete Popup
	public static By objiosDeletePopup=By.xpath("//*[@id='Delete Video?']");

	//Delete Button Yes
	public static By objiosDeleteButtonYes=By.xpath("//*[@id='YES']");

	//Profil Page verify
	public static By objiosProfilPageVerify=By.xpath("(//*[contains(@text,'@')])[2]");




	//Shoppable video Tab
	public static By objiosShoppablevideoTabInProfilePage=By.xpath("//*[@id='No shoppable videos']");


	//Next btn after record
	public static By objiosNextBtn=By.xpath("//*[@id='Next']");

	//Share btn FB
	public static By objiosShareBtn=By.xpath("//*[@id='Share']");




	//===================================KIRAN============================================================================	



	//Phone Number Text Field in login page /Phone tab screen
	public static By objiosPhoneNumberTextFieldInLogInPage=By.xpath("//*[contains(@placeholder,'Phone')]");

	//Clear button for Phone Number Text Field in login page /Phone tab screen
	public static By objiosClearBtnInPhoneNumberTextField=By.xpath("//*[@id='Clear text' and @class='UIAButton']");

	//Dropdown button for Phone Number Text Field in login page / Phone tab screen
	public static By objiosDropdownBtndInLogInPage=By.xpath("//*[@class='UIAButton' and @id='D']");

	//Afghanistan in country region dropdown Phone tab screen
	public static By objiosAfghanistanPhoneNumberTextField=By.xpath("//*[@class='UIAStaticText' and @id='Afghanistan']");

	//Albania in country region dropdown /Phone tab screen
	public static By objiosAlbaniaPhoneNumberTextField=By.xpath("//*[@class='UIAStaticText' and @id='Albania']");
	//n==========28-12-2021=======
	//India in Country region dropdown/phone tab screen 
	public static By objiosIndiaPhoneNumberTextField=By.xpath("//*[@class='UIAStaticText' and @id='India']");
	//Albania in country region  dropdown /Phone tab screen
	public static By objiosAlgeriaPhoneNumberTextField=By.xpath("//*[@class='UIAStaticText' and @id='Albania']");

	//Close button in country region dropdown /Phone tab screen
	public static By objiosCloseButtonInCountryRegionDropdown=By.xpath("//*[@class='UIAButton' and @id='Stop']");

	//login page
	public static By objiosLoginPage=By.xpath("//*[@knownSuperClass='UILabel' and @id='Log in']");

	//Password Text Field in login page /Phone tab screen
	public static By objiosLoginPassWordTextField=By.xpath("//*[@class='UIATextField' and @placeholder='  Password']");

	//Clear button for Password Text Field in login page /Phone tab screen
	public static By objiosLoginPassWordClearTextField=By.xpath("//*[@id='Clear text' and @class='UIAButton']");

	//Back Button In Login Page /Phone tab screen
	public static By objiosBackButtonInLoginPage=By.xpath("//*[@class='UIAButton' and @id='ic back arrow'] |//*[contains(@id,'back')]");

	//Login Button  In Login Page /Phone tab screen
	public static By objiosLoginButtonInLoginPage=By.xpath("//*[@class='UIAButton' and @id='Log in']");

	//Forgot Password link in Login Page/Phone tab screen
	public static By objiosForgotPasswordLinkInLoginPage=By.xpath("//*[@knownSuperClass='UIButtonLabel' and @id='Forgot password?']");

	//Reset In Reset Page
	public static By objiosResetInResetPage=By.xpath("//*[@knownSuperClass='UILabel' and @id='Reset']");

	//log out button in setting & privacy page
	public static By objiosLogOutButtonInSettingsPage=By.xpath("//*[@knownSuperClass='UILabel' and @id='Log out']");

	//Pop Up log out button in setting & privacy page
	public static By objiosPopUpLogOutButtonInSettingsPage=By.xpath("//*[@knownSuperClass='UIButtonLabel' and @id='Logout']");

	//				//Pop Up Not Now Button In Save Password PopUp
	//				public static By objiosNotNowButtonInSavePasswordPopUp=By.xpath("//*[@id='Not Now' and @class='UIAButton']");

	//Log in With OTP Link In LogIn Page
	public static By objiosLoginWithOTPLinkInLogInPage=By.xpath("//*[@knownSuperClass='UIButtonLabel' and @id='Login with OTP']");

	//Log in With Password Link In LogIn Page
	public static By objiosLoginWithPasswordLinkInLogInPage=By.xpath("//*[@knownSuperClass='UIButtonLabel' and @id='Login with Password']");

	//Email Tab In LogIn Page
	public static By objiosEmailTabInLogInPage=By.xpath("//*[@class='UIAView' and @id='Email']");

	//Email Address Text Field in Email Tab
	public static By objiosEmailAddressTextFieldInLogInPage=By.xpath("//*[@class='UIATextField' and @placeholder='  Email address']");

	//Password Text Field in Email Tab
	public static By objiosPasswordTextFieldInLogInPage=By.xpath("//*[@class='UIATextField' and @placeholder='  Password']");

	//Log In Button in Email Tab
	public static By objiosLogInButtonInLogInPage=By.xpath("//*[@class='UIAButton' and @id='Log in']");

	//Continue With Facebook Button in Login In To HiPI PopUp 
	public static By objiosContinueWithFacebookButtonInLoginInToHiPIPopUp=By.xpath("//*[@knownSuperClass='UIButtonLabel' and @id='Continue with Facebook']");

	//Continue With Google Button in Login In To HiPI PopUp
	public static By objiosContinueWithGoogleButtonInLoginInToHiPIPopUp=By.xpath(" //*[@id='Continue with Google' and @knownSuperClass='UIButtonLabel']");


	//Sign Up for hipi text in Login In To HiPI PopUp
	public static By objiosSignUpForHipiLinkInLoginInToHiPIPopUp=By.xpath(" //*[@id='Sign up for Hipi' and @knownSuperClass='UILabel']");


	//edit profile in edit page
	public static By objiosEditProfileInEditePage=By.xpath("//*[@id='Edit Profile' and @class='UIANavigationBar']");


	public static By objiosEditProfileInProfilePage=By.xpath("//*[@id='Edit Profile' and @class='UIAStaticText']");



	public static By objiosFollowingBtnSUserName=By.xpath("((//*[@id='Following' and @class='UIAButton'])[1]/preceding-sibling::*//child::*)[1]");

	public static By objiosFollowingIconUnderFollowingTab=By.xpath("//*[@id='Following' and @knownSuperClass='UIButton']");


	//Profile Picture In Profile Page
	public static By objiosProfilePictureInProfilePage=By.xpath("//*[contains(@id,'ProfilePictureProfilePage')]");

	//Share Profile In Profile Page
	public static By objiosShareProfileInProfilePage=By.xpath("//*[@id='Share Profile' and @knownSuperClass='UIButton']");


	public static By objiosChangePhotoInEditPage=By.xpath("//*[@id='Change Photo' and @class='UIAButton']");


	public static By objiosPersonAddInEditPage=By.xpath("//*[@id='ic person add' and @knownSuperClass='UIButton']");


	public static By objiosInviteFriendsInEditPage=By.xpath("//*[@id='Invite Friends' and @knownSuperClass='UILabel']");




	public static By objiosBioInEditPage=By.xpath("//*[@id='Edit Profile']/..//following-sibling::*//descendant::*");

	public static By objiosBioDescriptionInEditscreen=By.xpath("//*[@id='Bio']//following-sibling::*[2]");

	public static By nameArrowMark(String title) {
		return By.xpath("//*[@id='"+title+"']//following-sibling::*[2]");
	}
	public static By usernameBioArrowMark(String title) {
		return By.xpath("//*[@id='"+title+"']//following-sibling::*[3]");
	}
	public static By objioscloseInNameEditscreen=By.xpath("//*[contains(@id,'close')]");

	public static By objiosEditNameInNameEditscreen=By.xpath("//*[@XCElementType='XCUIElementTypeTextView']");

	public static By objiosSaveInNameEditscreen=By.xpath("//*[@id='Save' and @class='UIAButton']");



	public static By objiosFollowingBtnInFollowingScreen=By.xpath("(//*[@id='Following' and @class='UIAButton'])[1]");

	public static By objiosFollowingUsersNameDetailsInFollowingcreen=By.xpath("(//*[@id='Following' and @class='UIAButton'])[1]//preceding-sibling::*//child::*[1]");

	public static By objiosFollowingUsersIdDetailsInFollowingcreen=By.xpath("(//*[@id='Following' and @class='UIAButton'])[1]//preceding-sibling::*//child::*[2]");


	public static By objiosFollowBtnInFollowerScreen=By.xpath("(//*[@id='Follow' and @class='UIAButton'])[1]");

	public static By objiosFollowUsersNameDetailsInFollowerScreen=By.xpath("(//*[@id='Follow' and @class='UIAButton'])[1]//preceding-sibling::*//child::*[1]");

	public static By objiosFollowUsersIdDetailsInFollowerScreen=By.xpath("(//*[@id='Follow' and @class='UIAButton'])[1]//preceding-sibling::*//child::*[2]");

	//09/12/21=================================================================================================================








	public static By objiosFollowingBlackBtnInFollowerScreen=By.xpath("//*[@id='ic following black']");

	public static By VideosHashTagsSoundsInFavourite(String TabName) {
		return By.xpath("//*[@id='"+TabName+"' and @XCElementType='XCUIElementTypeOther']");
	}

	public static By ScrollDateMonthYear(int number) {
		return By.xpath("(//*[@class='UIAPickerWheel'])["+number+"]");
	}

	public static By objiosSearchFieldInFollowingPage=By.xpath("//*[@placeholder='Search Following' and @knownSuperClass='UITextField']");


	public static By objiosSearchFieldInFollowersPage=By.xpath("//*[@placeholder='Search Followers' and @knownSuperClass='UITextField']");

	//@Mahesh1e613bb5



	//Phone Number Text Field in Reset password page /Phone tab screen
	public static By objiosPhoneNumberTextFieldInResetPage=By.xpath("//*[@placeholder='Phone Number']");	

	//Login Button  enabled In Login Page /Phone tab screen
	public static By objiosLoginButtonEnabledInLoginPage=By.xpath("//*[@class='UIAButton' and @id='Log in' and @enabled='true' ]");

	// Send OTP button in  loginwith otp page
	public static By objiosSendOTPButtonInLoginPage=By.xpath("//*[@name='Send OTP' and @class='UIAButton']");

	//OTP verification Page
	public static By objiosVerifyOTPButtonInLoginPage=By.xpath("//*[@id='Verify OTP' and @class='UIAButton']");

	//invalid phone Number error toast messgae 
	public static By objiosinvalidErrorToastMessageInLoginPage=By.xpath("//*[@id='Invalid input parameter']");

	//invalid phone Number error toast messgae less Than 10 digits and valid phone number and invalid password
	public static By objiosinvalidErrorToastMessageForMobileNumberLessThan10DigitsInLoginPage=By.xpath("//*[@id='The mobile number and password combination was wrong during login.']");

	public static By objiosOTPField(int index){
		return By.xpath("(//*[@class='UIATextField'])["+index+"]");
	}

	//OTP error message
	public static By objiosOTPErrorToastMessageInLoginPage=By.xpath("//*[@id='Either OTP is not valid or has expired']");





	//s===================================================================

	////////////////////s////////////profile
	//Add person
	public static By objiosAddPerson=By.xpath("//*[@id='ic person add']");

	//Find Friends
	public static By objiosFindFriends=By.xpath("//*[@id='Find Friends' and @class='UIANavigationBar']");

	//Invite Freinds
	public static By objiosInviteFreinds=By.xpath("//*[@id='Invite Friends' and @class='UIAStaticText']");


	//ok button
	public static By objiosOkAllowContacts=By.xpath("//*[@id='OK']");


	//Find Contacts
	public static By objiosFindContactsInFindFriends=By.xpath("//*[@id='Find Contacts']");	


	//================================n================================
	//Delete  button in Draft video screen
	public static By objiosDraftVideoDeleteButton=By.xpath("(//*[@id='Delete'])[1]");

	//Toast Message Video is saved as draft
	public static By objiosSaveAsDraftTostMessage=By.xpath("//*[@id='Video is saved as draft!']");




	public static By objiosFollowingTabInFollowingScreen=By.xpath("//*[contains(text(),'Following') and @XCElementType='XCUIElementTypeCell']");

	public static By objiosFollowerTabInFollowingScreen=By.xpath("//*[contains(text(),'Follower') and @XCElementType='XCUIElementTypeCell']");

	public static By objiosFollowerNameInFollowerTab(String name) {
		return By.xpath("(//*[contains(text(),'"+name+"')])[2]");
	}


	//============================================================28-12=2021==============
	//manage your account in login to hipi popup(manage your account)
	public static By objiosManageYourAccountTextInLoginToHipiPopUp=By.xpath("//*[@id='Manage your account, check notifications, comment \\non videos and more']");

	//By continuing, you Agree,Terms of use text in login to hipi popup(Terms of Use)
	public static By objiosByContinuningYouAgreeTermsofUsetextInLoginToHipiPopUp=By.xpath("//*[@id=concat('By continuing, you agree to Hipi', \"'\", 's Terms of Use and confirm that you have read Hipi', \"'\", 's Privacy Policy.')]");	


	//Don't have an account?Sign up text in login popup
	public static By objiosDontHaveAnAccountSignUpTextInLoginToHipiPopUp=By.xpath("(//*[@text='Sign up']/..)[1]");			



	//  +91 text in drop down in phone number text field		
	public static By objios91Textindropdown=By.xpath("//*[@id='+91']");	

	// forgot password text in reset page
	public static By objiosForgotPasswordTextInResetpage=By.xpath("//*[@id='Forgot Password']");		

	//	we'll sms you a code text
	public static By objiosSMSYouTextInResetpage=By.xpath("//*[@id=concat('We', \"'\", 'll SMS you a code to reset your password')]");	

	//resetCTA in reset page
	public static By objiosResetCTAInResetpage=By.xpath("//*[@id='Reset'and@class='UIAButton']");	

	// resetCTA Enabled in reset page		
	public static By objiosResetCTAEnabledInResetpage=By.xpath("//*[@id='Reset' and @enabled='true' and @class='UIAButton']");

	// Send OTP Enabled in Login with OTP Screen	
	public static By objiosSendOTPCTAEnabledInLoginWithOTPPage=By.xpath("//*[@id='Send OTP' and @enabled='true' and @class='UIAButton']");

	//Resend Code text in OTP Verification page
	public static By objiosResendCodeTextInOTPVerificationPage=By.xpath("//*[contains(text(),'Resend')]");

	//Enter 4-digit code  text in OTP Verification page 
	public static By objiosEnter4DigitCodeTextInOTPVerificationPage=By.xpath("//*[contains(@id,'Enter 4-digit')]");

	// Your Code was messaged text
	public static By objiosYouCodeWasMessagedTextInOTPVerificationPage=By.xpath("//*[contains(text(),'Your code was messaged to')]");


	//Haven't recieved OTP text  in OTP Verification page
	public static By objiosHavenotRecivedOTPTextInOTPVerificationPage=By.xpath("(//*[@id='Send again']/../child::*)[1]");

	//Send again
	public static By objiosSendAgainLinkInOTPVerificationPage=By.xpath("//*[@id='Send again' and @class='UIAStaticText']");



	//====================================================================================================12-01-2021=================


	//===================================================29-12-2021------N======================================================
	//please use valid email address toast message
	public static By objiosPleaseUseValidEmailAddressToastMessageInLoginPage=By.xpath("//*[@id='Please use valid Email Address.']");

	//Email textField  in Reset page
	public static By objiosEmailAddressTextFieldInResetPage=By.xpath("//*[@placeholder='Email']");

	//we will email you a link  to reset your password text in reset page
	public static By objiosWeWillEmailYouTextInResetPage=By.xpath("//*[@id=concat('We', \"'\", 'll email you a link to reset your password')]");

	///////////////////////28-12-21/////////////////----s
	//Intetnet Error
	public static By objiosInternetError=By.xpath("//*[@id='Internet error']");

	//Invalid Combination
	public static By objiosInvalidDetails=By.xpath("//*[@id='The email address and password combination was wrong during login.']");

	//previously logged in facebook
	public static By objiosPreviouslyLoggedInFacebook=By.xpath("//*[@id='You previously logged in to HiPi with Facebook.']");

	//would you like to continue
	public static By objiosLikeToContinueInFacebook=By.xpath("//*[@id='Would you like to continue?']");

	//contonue
	public static By objiosConrtinueInFacebook=By.xpath("//*[@id='Continue']");

	//Cancel in facebook
	public static By objiosCancelInFacebook=By.xpath("(//*[@id='Cancel' and @class='UIAButton'])[2]");

	//Privacy Policy
	public static By objiosPrivacyPolicyInFacebook=By.xpath("(//*[@id='Privacy Policy']");

	//Terms In facebook
	public static By objiosTermsInFacebook=By.xpath("//*[@id='Terms']");

	//Continuing Hipi
	public static By objiosByContinuingHipiInFacebook=By.xpath("//*[contains(text(),'By continuing, HiPi')]");


	//Saved/Bookmark
	public static By objiosSavedBookmarkVideoInProfileTab=By.xpath("//*[contains(@id,'bookmark')]");

	//////s-24-12-21
	//Notifiaction in profile pic
	public static By objiosNotificationInProfilePage=By.xpath("//*[@id='ic push notification']");

	public static By objiosTotalNumberOfDraftVideos=By.xpath("//*[@id='Drafts']//parent::*//following-sibling::*[contains(text(),'Video')]");


	//04-01-2022------mahi========================
	public static By objiosPrivateProfile=By.xpath("//*[contains(text(),'private')]");


	//=============================================================================Profile page=====

	//n===========================04-1=2022===============================================

	//Last video Created 
	public static By objiosLastVideoCreatedInProfilePage=By.xpath("(//*[contains(@id,'VideoCreated')])[1]");

	//Shoppable Video In Profile Page

	public static By objiosShoppableVideoInProfilePage=By.xpath("//*[contains(@id,'ic profile tab like')]");

	//ic profile tab video 

	public static By objiosprofiletab=By.xpath("//*[contains(@id,'ic profile tab video')]");



	//----kiran--jan--27-------------------------------------------------------------------------------
	public static By objiosUserNameAboveProfilePic=By.xpath("(//*[contains(@id,'@')])[2]");


	public static By objiosUserNameBelowNameInFollowerAndFollowingScreen=By.xpath("//*[contains(@id,'@')]");

	public static By objiosUserNameInFollowerAndFollowingScreen=By.xpath("(//*[contains(@id,'@')])[1]//preceding-sibling::*");

	public static By objiosListOfFollowBtnInFollowerScreen=By.xpath("//*[@id='Follow' and @class='UIAButton']");

	//Bell Icon in Profile page
	public static By objiosBellIconInProfileScreen=By.xpath("//*[@id='ic push notification']");

	//All Activity,Like,Comments,Mentions,Followers Icon In Bell Screen

	public static By AllActivityLikeCommentsMentionsFollowersInBellScreen(String IconName) {
		return By.xpath("//*[contains(@id,'"+IconName+"')]");
	}

	public static By objiosListOfLikedVideoInLikePage=By.xpath("//*[contains(@id,'liked your video')]");

	public static By objiosNotificationsNotAvailableInBellScreen=By.xpath("//*[@id='Notifications aren’t available']");

	public static By objiosFriendsBtnInBellpage=By.xpath("//*[@id='Friends' and @class='UIAButton']");	

	public static By objiosProfileInBellPage=By.xpath("//*[@id='ic_profile']");	

	public static By objiosFavouriteTitleInBookmarkPage=By.xpath("//*[@id='Favourite' and @class='UIAStaticText']");

	public static By objiosTotalLikesInProfilePage=By.xpath("//*[contains(@id,'like')]/following-sibling::*");

	public static By objiosTotalFollowersInProfilePage=By.xpath("//*[contains(@id,'TotalFollowers')]");

	public static By objiosTotalFollowingInProfilePage=By.xpath("//*[contains(@id,'TotalFollowing')]");

	public static By objiosEditProfileBookmarkchatIcon(String IconName) {
		return By.xpath("//*[@id='"+IconName+"' and @class='UIAButton']");
	}




	//--N-----------jan--27--------------------------------------------------
	public static By objiosProfileNameBelowProfilePhotoInProfilePage=By.xpath("(//*[@id='Follow']//preceding::*//*[@knownSuperClass='UIStackView'])[1]");


	//==================12-01-2022-=========================

	//user 
	public static By objiosusernamelist(int index){
		return By.xpath("(//*[@id='Follow' and @class='UIAButton'])[1]//preceding-sibling::*//child::*["+index+"]");
	}






	//n===========18-01-22--------------------------------------

	// invite tabs in invate page (eg:facebook,sms)		
	public static By objiosAllTabsInInviteFriendsPage(String name)	{
		return By.xpath("//*[@id='"+name+"']");

	}

	//FaceBook Page ------

	public static By objiosFacebookPage=By.xpath("(//*[@id='URL'])[2]");
	//facebookApp
	public static By objiosFacebookApp=By.xpath("//*[contains(text(),'Facebook')]");
	//contact page
	public static By objiosContactPage=By.xpath("(//*[@id='Contacts'])[2]");

	//===================20-01-2022
	public static By objiosCreatedVideoInProfilePage(int index){
		return By.xpath("(//*[contains(@id,'VideoCreated')])["+index+"]");
	}


	public static By objiosFirstFollowingUserNameInFollowersFollowingTab=By.xpath("(//*[@id='Following' and @class='UIAButton']//preceding-sibling::*)[2]/child::*[1]");

	//follwer zero

	public static By objiosZeroFollowerTab=By.xpath("//*[@id='Follower 0']");
	// zero follower screen	
	public static By objiosZeroFollowerScreen=By.xpath("//*[@id='noUserFollow']");
	//zero following	
	public static By objiosZeroFollowingTab=By.xpath("//*[@id='Following 0']");	

	// draft first viedo
	public static By objiosFirstVideoInDraftScreen=By.xpath("(//*[@id='  Drafts are only visible to you.']/following::*)[4]");	

	//Public Tab in profile page
	public static By objiosPulicTabInDraftScreen=By.xpath("//*[@id='ic profile tab video unselecte']");

	;	



	//videos in profile page
	public static By objiosVideosInProfile=By.xpath("(//*[@id='ic_outline_play'])[1] |(//*[contains(@id,'outline_Play_')])[1]"); 

	//Add a caption in draft video
	public static By objiosAddCaptionInDraftVideo=By.xpath("(//*[@id='Add a caption'])[1]");



	//no in delete draft
	public static By objiosNoInDeleteDraft=By.xpath("//*[@id='NO']");

	//favourite under bookmark
	public static By objiosFavouriteUnderBookmark=By.xpath("(//*[@id='Favourite'])[1]");	

	//favourite under bookmark
	public static By objiosfavouriteHipiGoat=By.xpath("//*[contains(@id,'#HipiGOAT')]");		

	//arrow mark in name
	public static By ArrowMarkInEditProfile(int index){
		return By.xpath("(//*[@id='ic arrow next'])["+index+"]");
	}

	//username updated sucessfully
	public static By objiosUserNameUpdatedSuccessfully=By.xpath("//*[contains(@id,'updated successfully')]");



	//cancel in name edit screen
	public static By objiosCancelButton=By.xpath("//*[contains(@id,'Cancel')]");



	//Bio updated Successfully
	public static By objiosBioiUpdated=By.xpath("//*[contains(@id,'User Bio updated successfully')]");	

	//username can't be empty
	public static By objiosUserNameEmpty=By.xpath("//*[@id='Username cannot be empty']");

	//first name error
	public static By objiosNmaeEmptyErroe=By.xpath("//*[@id='First name cannot be empty']");



	//userprofile 
	public static By objiosUserNameInUserProfilePage=By.xpath("//*[contains(@id,'UsernameProfilePage')]");

	//following tab in user followed list
	public static By objiosFollowingTabInUserFollowedList=By.xpath("//*[@id='Following']");


	//error message of user handle to value
	public static By objiosNameAlreadyTaken=By.xpath("//*[contains(@id,'Username is already taken')]");



	public static By objiosDateBoxInSignupScreen = By.xpath("(//*[@class='UIAPicker']//child::*)[1]"); // -------------date
	// box

	public static By objiosMonthBoxInSignupScreen = By.xpath("(//*[@class='UIAPicker']//child::*)[2]"); // -----month
	// box

	public static By objiosYearBoxInSignupScreen = By.xpath("(//*[@class='UIAPicker']//child::*)[3]"); // --------------------year
	// box
	//--------------------------------------------------fed--18----------------------------------------------


	//Sign Up Button
	public static By objiosSignUpButtonInLogInToHipiPopUp=By.xpath("//*[contains(@id,'Sign_')]");

	//Sign up for Hipi Text
	public static By objiosSignUpForHipiTextInLogInToHipiPopUp=By.xpath("//*[@id='Sign up for Hipi']");

	//Create a profile Text
	public static By objiosCreateAProfileTextInLogInToHipiPopUp=By.xpath("//*[contains(@id,'Create a profile, follow other accounts, make your own videos and more')]");

	//Log In Link
	public static By objiosLogInLinkInLogInToHipiPopUp=By.xpath("//*[contains(@id,'Log in')]");

	//Sign Up Text In Sign Up Screen
	public static By objiosSignUpTextInSignUpScreen=By.xpath("//*[@id='Sign up' and @class='UIAStaticText']");

	//Next Button In Sign Up Screen
	public static By objiosNextButtonInSignUpScreen=By.xpath("//*[@id='Next' and @enabled='true']");

	//Cross Icon In Login/signUp Pop Up
	public static By objiosCrossIconInLoginSignUpPopUp=By.xpath("//*[contains(@id,'close')]");




	public static By objiosCrossIconInSelectCountryRegion=By.xpath("//*[@id='Stop']");

	public static By objiosClearTextInPhoneNumberTextField=By.xpath("//*[@id='Clear text']");



	public static By objiosGenderDropDownInSignUpScreen=By.xpath("//*[@id='ic drop selection change']");

	public static By objiosGenderTextFieldInSignUpScreen=By.xpath("//*[@id='ic drop selection change']//preceding-sibling::*");

	public static By objiosPasswordTextFieldInSignUpScreen=By.xpath("//*[@placeholder='  Password']");

	public static By objiosCompleteButtonInSignUpScreen=By.xpath("//*[@id='Complete' and @class='UIAButton']");

	public static By objiosMaleGenderInSignUpScreen=By.xpath("//*[@id='Male']");

	public static By objiosTellUsMoreTexInSignUpScreen=By.xpath("//*[contains(@id,'Tell us more ')]");

	public static By objiosUseYourNameTexInSignUpScreen=By.xpath("//*[contains(@id,'Use your Name')]");

	public static By objiosSignUpTextInLogInToHipiPopUp=By.xpath("//*[@id='Sign up' and @knownSuperClass='UILabel']");

	public static By objiosPhoneTabInLogInPage=By.xpath("//*[@id='Phone' and @XCElementType='XCUIElementTypeCell']");

	public static By objios91DropownInLogInPage=By.xpath("//*[@id='+91']");

	public static By objiosTermsOfUseInLogInPage=By.xpath("//*[@id='Terms of Use']");

	public static By objiosPrivacyPolicyInLogInPage=By.xpath("//*[@id='Privacy Policy']");

	public static By objiosLoginWithPasswordInSignUpPage=By.xpath("//*[@id='Login with Password' and @class='UIAButton']");

	public static By objiosLoginTextInSignUpPage=By.xpath("(//*[@id='Log in' and @class='UIAStaticText'])[1]");

	public static By objiosVerifyOtpButtonInSignUpPage=By.xpath("//*[@id='Verify OTP' and @class='UIAButton']");

	public static By objiosAgeToastMessageInSignUpPage=By.xpath("//*[contains(@id,'above 18 year')]");


	// Sign up Screen
	public static By objiosSignUppage=By.xpath("(//*[@id='Sign up'])[2]");	


	// cross icon in phone number text field in sign up page
	public static By objiosCrossIconInPhoneNumberTexFieldInSignUppage=By.xpath("//*[@id='Clear text']");


	//Already Have An Account Wtih This Number toast message 

	public static By objiosAlreadyhaveAnAccountWithThisNumber=By.xpath("//*[@id='Already have an account with this number.']");	



	//when is your birthday
	public static By objiosWhensYourBirthday=By.xpath("(//*[contains(text(),'birthday')])[1]");






	//sign up screen
	public static By objiosSignupScreen=By.xpath("(//*[@id='Sign up'])[2]");

	public static By objiosFullNameTextFieldInSignUpScreen=By.xpath("//*[contains(@placeholder,'  Full name')]");

	//clear text in email
	public static By objiosClearTextInLoginScreen=By.xpath("//*[@id='Clear text']");

	//Select countrty region
	public static By objiosSelectCountryInSignUpScreen=By.xpath("(//*[@id='D'])[1]");

	//Profile button in below Tab Bar
	public static By objiOSProfileBtnInBelowTabBar=By.xpath("//*[@text='Profile' and @knownSuperClass='UITabBarButton']");	

	//search country
	public static By objiosSearchCountry=By.xpath("//*[@id='Search']");

	//cancel in country field
	public static By objiosCancelInCountry=By.xpath("(//*[@id='Cancel'])[1]");

	//invalid otp
	public static By objiosInvalidOtp=By.xpath("//*[contains(text(),'not valid')]");

	//send again
	public static By objiosSendAgainCode=By.xpath("(//*[@id='Send again'])[1]");

	//Resend code
	public static By objiosResendCode=By.xpath("//*[contains(text(),'Resend')]");

	//your code messgae to this number
	public static By objiosYourCodeWasMessagesInSignUpScreen=By.xpath("//*[contains(text(),'Your')]");

	///////////////7-2-22////////////////////////
	//mobile number/email id
	public static By objiosMobileNumberOrEmailId=By.xpath("//*[contains(text(),'email')]");

	//Facebook password
	public static By objiosfacebookPassword=By.xpath("(//*[contains(text(),'Facebook')])[7]");

	//LogIn facebook button
	public static By objiosLogInFacebook=By.xpath("//*[@id='Log In']");

	//create account
	public static By objiosCreateAccountInFacebookPage=By.xpath("(//*[@id='Create account'])[1]");

	//otp sent successfully
	public static By objiosOtpSentSuccessfully=By.xpath("//*[contains(text(),'successfully')]");

	//network error
	public static By objiOSNetworkError=By.xpath("//*[contains(@id,'onnection')]");

	public static By objiOSProfilePictureInFeedScreen=By.xpath("//*[contains(@id,'ProfilePictureForYou')]");

	public static By objiOSTotalCountOfFollowingInProfile=By.xpath("//*[contains(@id,'TotalFollowing')]");


	//PopUP Allow Contacts
	public static By objiosPopAllowContacts=By.xpath("(//*[contains(@id, 'Would Like to Access Your Contacts')])[2]");

	public static By objiosSearchFieldInFollowrsPage=By.xpath("//*[contains(@placeholder,'Search Follower')] | //*[contains(@placeholder,'Search')]");


	public static By objiosSearchPlaceholderFollowrsPage=By.xpath("//*[contains(@placeholder,'Search Followers')]");;

	public static By objiosTextInScreen(String text) {
		return By.xpath("//*[@id='"+text+"']");	
	}



	public static By objiOSPublishingInProcessInProfileScreen=By.xpath("//*[contains(@id,'Publishing in process')]");

	public static By objiOSTakeAPhotoPopupInEditProfileScreen=By.xpath("//*[@id='Take a Photo']");

	public static By objiOSPhotoCaptureButtonInCamaraScreen=By.xpath("//*[@id='PhotoCapture']");

	public static By objiOSUsePhotoButtonInCamaraScreen=By.xpath("//*[@id='Use Photo']");

	public static By objiOSProfilePictureUploadedSuccessfullyToustMessageInEditProfileScreen=By.xpath("//*[contains(@id,'Profile picture uploaded successfully')]");

	public static By objiOSFirstVideoInPrivateVideoScreen=By.xpath("(//*[contains(@id,'Play_')])[1]");

	public static By objiOSFewSecondsAgoCommentInCommentScreen=By.xpath("//*[contains(@id,'few seconds ago')]");

	public static By objiOSAllVideoInPrivateVideoScreen=By.xpath("//*[contains(@id,'Play_')]");



	public static By objiOSHashtagImageInFavouriteHashtagPage=By.xpath("//*[contains(@id,'Hashtag_Image_')]");	





	public static By objiOSHashtagInProfileVideos=By.xpath("//*[contains(@id,'Hashtags-Hashtag')]");

	public static By username(String Name) { 
		return By.xpath("(//*[contains(@text,'"+Name+"')])[2]");
	}


	public static By  BlockUserOptionIn3dotsPopUp=By.xpath("//*[contains(@id,'Block User') and @class='UIAButton']");

	public static By   objiOSHipiWouldLikeToAccessYourContacts=By.xpath("//*[@id='“Hipi” Would Like to Access Your Contacts']");

	public static By   objiOSSearchContactsInInviteFriendsScreen=By.xpath("//*[@placeholder='Search Contacts']");

	public static By   objiOSInviteViaInInviteFriendsScreen=By.xpath("//*[contains(@id,'Invite Via')]");

	public static By   objiOSLensIconInInviteFriendsScreen=By.xpath("//*[contains(@id,'ic search')]");

	public static By   objiOSCrossIconInSearchContactsInInviteFriendsScreen=By.xpath("//*[contains(@id,'close_button')]");

	public static By objiosSearchedContactsInInviteFriendsScreen=By.xpath("//*[@id='ic_profile']//preceding-sibling::*[2]");

	public static By objiosUserHasDisabledCommentsForTheVideoToastMessage=By.xpath("//*[@id='User has disabled comments for the video']");






	//	27/06/2022

	public static By objiosFollowButtonInUserProfile=By.xpath("(//*[@id='Follow'])[1]");

	public static By objiosChatIconInUserProfile=By.xpath("//*[@id='chatIcon']");

	public static By objiosSuggestedAccountsDownArrowButtonInUserProfile=By.xpath("//*[@id='ic down arrow']");

	public static By objiosSuggestedAccountsUpArrowButtonInUserProfile=By.xpath("//*[@id='ic up arrow']");

	public static By objiosSuggestedAccountsInUserProfile=By.xpath("//*[@id='Suggested accounts']");

	public static By objiosSeeAllSuggestedAccountsInUserProfile=By.xpath("(//*[@id='See all'])[1]");

	public static By objiosFollowButtonInSuggestedAccountSeeAll=By.xpath("//*[@id='Follow']");

	public static By objiosFirstFollowButtonInSuggestedAccount=By.xpath("((//*[@id='com.zee5.hipi:id/ProfilePictureProfilePage'])[2]//following-sibling::*)[2]");

	public static By objiosSendAMessageTextFieldInMessageScreen=By.xpath("(//*[@id='Empty list']//following-sibling::*)[2]");

	public static By objiosProfileIconInMessageScreen=By.xpath("//*[@id='ic_profile']");

	public static By objiosEmptyMessageInMessageScreen=By.xpath("//*[@id='Empty list']");

	public static By objiosPostButtonInMessageScreen=By.xpath("//*[@id='ic send black']");

	public static By objiosPostedMessageInMessageScreen=By.xpath("(//*[contains(@id,'PM')]//following-sibling::*)[3]|(//*[contains(@id,'AM')]//following-sibling::*)[3]");

	public static By objiosHistoryOfMessageInDirectMessageScreen=By.xpath("//*[contains(@id,'@')]");

	public static By objiosDirectMessagePageTextInMessageScreen=By.xpath("//*[@id='Direct Messages']");

	public static By objiosPlusIconInDirectMessageScreen=By.xpath("//*[@id='ic plus']");

	public static By RandomMessagesInMessageScreen(String Message) { 
		return By.xpath("//*[@id='"+Message+"']");
	}

	public static By objiosListOfFollowingBtnInNewChatScreen=By.xpath("//*[@id='Following' and @class='UIAButton']");


	
	
	
	
	
	
	
	
	
//	//Appium Server
//	
//	
//
//
//
//	//===================================KIRAN============================================================================	
//
//
//
//	//Phone Number Text Field in login page /Phone tab screen
//	public static By objiosPhoneNumberTextFieldInLogInPage=By.xpath("//XCUIElementTypeStaticText[@name='+91']//parent::*");
//
//	//Clear button for Phone Number Text Field in login page /Phone tab screen
//	public static By objiosClearBtnInPhoneNumberTextField=By.xpath("//XCUIElementTypeButton[@name='Clear text']");
//
//	//Dropdown button for Phone Number Text Field in login page / Phone tab screen
//	public static By objiosDropdownBtndInLogInPage=By.xpath("//XCUIElementTypeButton[@name='D']");
//
//	//Afghanistan in country region dropdown Phone tab screen
//	public static By objiosAfghanistanPhoneNumberTextField=By.xpath("//XCUIElementTypeStaticText[@name='Afghanistan']");
//
//	//Albania in country region dropdown /Phone tab screen
//	public static By objiosAlbaniaPhoneNumberTextField=By.xpath("//XCUIElementTypeStaticText[@name='Albania']");
//
//	//India in Country region dropdown/phone tab screen 
//	public static By objiosIndiaPhoneNumberTextField=By.xpath("(//XCUIElementTypeStaticText[@name='India'])[1]");
//
//	//Albania in country region  dropdown /Phone tab screen
//	public static By objiosAlgeriaPhoneNumberTextField=By.xpath("//XCUIElementTypeStaticText[@name='Algeria']");
//
//	//login page
//	public static By objiosLoginPage=By.xpath("(//XCUIElementTypeStaticText[@name='Log in'])[1]");
//
//	//Password Text Field in login page /Phone tab screen
//	public static By objiosLoginPassWordTextField=By.xpath("(//XCUIElementTypeStaticText[@name='+91']//parent::*//following-sibling::*)[2]");
//
//	//Clear button for Password Text Field in login page /Phone tab screen
//	public static By objiosLoginPassWordClearTextField=By.xpath("//XCUIElementTypeButton[@name='Clear text']");
//
//	//Login Button  In Login Page /Phone tab screen
//	public static By objiosLoginButtonInLoginPage=By.xpath("//XCUIElementTypeButton[@name='Log in']");
//
//	//Forgot Password link in Login Page/Phone tab screen
//	public static By objiosForgotPasswordLinkInLoginPage=By.xpath("//XCUIElementTypeButton[@name='Forgot password?']");
//
//	//Log in With OTP Link In LogIn Page
//	public static By objiosLoginWithOTPLinkInLogInPage=By.xpath("//XCUIElementTypeButton[@name='Login with OTP']");
//
//	//Log in With Password Link In LogIn Page
//	public static By objiosLoginWithPasswordLinkInLogInPage=By.xpath("//XCUIElementTypeButton[@name='Login with Password']");
//
//	//Email Tab In LogIn Page
//	public static By objiosEmailTabInLogInPage=By.xpath("//XCUIElementTypeCell[@name='Email']");
//
//	//Email Address Text Field in Email Tab
//	public static By objiosEmailAddressTextFieldInLogInPage=By.xpath("//*[contains(@type,'XCUIElementTypeTextField')]");
//
//	//Password Text Field in Email Tab
//	public static By objiosPasswordTextFieldInLogInPage=By.xpath("//*[contains(@type,'XCUIElementTypeSecureTextField')]");
//
//	//Log In Button in Email Tab
//	public static By objiosLogInButtonInLogInPage=By.xpath("//XCUIElementTypeButton[@name='Log in']");
//
//	//Reset In Reset Page
//	public static By objiosResetInResetPage=By.xpath("//XCUIElementTypeButton[@name='Reset']");
//
//	//log out button in setting & privacy page
//	public static By objiosLogOutButtonInSettingsPage=By.xpath("//XCUIElementTypeStaticText[@name='Log out']");
//
//	//Continue With Facebook Button in Login In To HiPI PopUp 
//	public static By objiosContinueWithFacebookButtonInLoginInToHiPIPopUp=By.xpath("//XCUIElementTypeButton[@name='Continue with Facebook']");
//
//	//Continue With Google Button in Login In To HiPI PopUp
//	public static By objiosContinueWithGoogleButtonInLoginInToHiPIPopUp=By.xpath("//XCUIElementTypeButton[@name='Continue with Google']");
//
//	//Sign Up for hipi text in Login In To HiPI PopUp
//	public static By objiosSignUpForHipiLinkInLoginInToHiPIPopUp=By.xpath("//XCUIElementTypeStaticText[@name='Sign up for Hipi']");
//
//	public static By objiosChangePhotoInEditPage=By.xpath("//XCUIElementTypeButton[@name='Change Photo']");
//
//	//edit profile in edit page
//	public static By objiosEditProfileInEditePage=By.xpath("//XCUIElementTypeStaticText[@name='Edit Profile']");
//
//	public static By objiosEditProfileInProfilePage=By.xpath("//XCUIElementTypeButton[@name='Edit Profile']");
//
//	//Back Button In Login Page /Phone tab screen
//	public static By objiosBackButtonInLoginPage=By.xpath("//XCUIElementTypeButton[contains(@name,'back_arrow')]");
//
//	//Profile Picture In Profile Page
//	public static By objiosProfilePictureInProfilePage=By.xpath("//XCUIElementTypeImage[contains(@name,'ProfilePictureProfilePage')]");
//
//	//Add person
//	public static By objiosAddPerson=By.xpath("//XCUIElementTypeButton[contains(@name,'person add')]");
//	public static By objiosPersonAddInEditPage=By.xpath("//XCUIElementTypeButton[contains(@name,'person add')]");
//
//	//Invite Freinds
//	public static By objiosInviteFreinds=By.xpath("//XCUIElementTypeStaticText[@name='Invite Friends']");
//	public static By objiosInviteFriendsInEditPage=By.xpath("//XCUIElementTypeStaticText[@name='Invite Friends']");
//
//	//Find Contacts
//	public static By objiosFindContactsInFindFriends=By.xpath("//XCUIElementTypeStaticText[@name='Find Contacts']");	
//
//	//ok button
//	public static By objiosOkAllowContacts=By.xpath("//XCUIElementTypeButton[@name='OK']");
//
//	//Phone Number Text Field in Reset password page /Phone tab screen
//	public static By objiosPhoneNumberTextFieldInResetPage=By.xpath("//*[@type='XCUIElementTypeTextField']");	
//
//	//Login Button  enabled In Login Page /Phone tab screen
//	public static By objiosLoginButtonEnabledInLoginPage=By.xpath("//XCUIElementTypeButton[@name='Reset' and @enabled='true']");
//
//	//OTP verification Page
//	public static By objiosVerifyOTPButtonInLoginPage=By.xpath("//XCUIElementTypeButton[@name='Verify OTP']");
//
//	// Send OTP button in  loginwith otp page
//	public static By objiosSendOTPButtonInLoginPage=By.xpath("//XCUIElementTypeButton[@name='Send OTP']");
//
////  +91 text in drop down in phone number text field		
//	public static By objios91Textindropdown=By.xpath("//XCUIElementTypeStaticText[@name='+91']");	
//
//	// forgot password text in reset page
//	public static By objiosForgotPasswordTextInResetpage=By.xpath("//XCUIElementTypeStaticText[@name='Forgot Password']");		
//
//	//	we'll sms you a code text
//	public static By objiosSMSYouTextInResetpage=By.xpath("//XCUIElementTypeStaticText[contains(@name,'SMS you a code to reset your password')]");	
//
//	//resetCTA in reset page
//	public static By objiosResetCTAInResetpage=By.xpath("//XCUIElementTypeButton[@name='Reset']");	
//
//	// resetCTA Enabled in reset page		
//	public static By objiosResetCTAEnabledInResetpage=By.xpath("//XCUIElementTypeButton[@name='Reset' and @enabled='true']");
//
//
//	// Send OTP Enabled in Login with OTP Screen	
//	public static By objiosSendOTPCTAEnabledInLoginWithOTPPage=By.xpath("//XCUIElementTypeButton[@name='Send OTP' and @enabled='true']");
//
//	//Resend Code text in OTP Verification page
//	public static By objiosResendCodeTextInOTPVerificationPage=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Resend')]");
//
//	//Enter 4-digit code  text in OTP Verification page 
//	public static By objiosEnter4DigitCodeTextInOTPVerificationPage=By.xpath("//XCUIElementTypeStaticText[@name='Enter 4-digit OTP']");
//
//	// Your Code was messaged text
//	public static By objiosYouCodeWasMessagedTextInOTPVerificationPage=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Your code was messaged to')]");
//
//
//	//Haven't recieved OTP text  in OTP Verification page
//	public static By objiosHavenotRecivedOTPTextInOTPVerificationPage=By.xpath("//XCUIElementTypeStaticText[contains(@name,'recieved OTP?')]");
//
//	//Send again
//	public static By objiosSendAgainLinkInOTPVerificationPage=By.xpath("//XCUIElementTypeStaticText[@name='Send again']");//49
//
//	//Close button in country region dropdown /Phone tab screen
//	public static By objiosCloseButtonInCountryRegionDropdown=By.xpath("//XCUIElementTypeButton[@name='Stop']");
//
//	public static By objiosCrossIconInSelectCountryRegion=By.xpath("//XCUIElementTypeButton[@name='Stop']");
//
//
//	//Sign Up Button
//	public static By objiosSignUpButtonInLogInToHipiPopUp=By.xpath("//XCUIElementTypeStaticText[@name='Signup']");
//
//	//Sign up for Hipi Text
//	public static By objiosSignUpForHipiTextInLogInToHipiPopUp=By.xpath("//XCUIElementTypeStaticText[@name='Sign up for Hipi']");
//
//	//Create a profile Text
//	public static By objiosCreateAProfileTextInLogInToHipiPopUp=By.xpath("//XCUIElementTypeStaticText[@name='Create a profile, follow other accounts, make your own videos and more.']");
//
//	//Log In Link
//	public static By objiosLogInLinkInLogInToHipiPopUp=By.xpath("//XCUIElementTypeButton[contains(@name,'Log_in')]");
//	
//	//Sign Up Text In Sign Up Screen
//	public static By objiosSignUpTextInSignUpScreen=By.xpath("//XCUIElementTypeStaticText[@name='Sign up']");
//
//	//Next Button In Sign Up Screen
//	public static By objiosNextButtonInSignUpScreen=By.xpath("//XCUIElementTypeButton[@name='Next' and @enabled='true']");
//
//	//Cross Icon In Login/signUp Pop Up
//	public static By objiosCrossIconInLoginSignUpPopUp=By.xpath("//XCUIElementTypeButton[contains(@name,'close')]");
//	
//
//	public static By objiosClearTextInPhoneNumberTextField=By.xpath("//XCUIElementTypeButton[@name='Clear text']");
//
//	// cross icon in phone number text field in sign up page
//	public static By objiosCrossIconInPhoneNumberTexFieldInSignUppage=By.xpath("//XCUIElementTypeButton[@name='Clear text']");
//
//	//when is your birthday
//	public static By objiosWhensYourBirthday=By.xpath("//XCUIElementTypeStaticText[contains(@name,'your birthday?')]");
//
//	public static By objiosVerifyOtpButtonInSignUpPage=By.xpath("//XCUIElementTypeButton[@name='Verify OTP']");
//
//	public static By objios91DropownInLogInPage=By.xpath("//XCUIElementTypeStaticText[@name='+91']");
//
//	public static By objiosTermsOfUseInLogInPage=By.xpath("//XCUIElementTypeLink[@name='Terms of Use']");
//
//	public static By objiosPrivacyPolicyInLogInPage=By.xpath("//XCUIElementTypeLink[@name='Privacy Policy']");//16
//	
//	//Login PopUp close button
//	public static By objiOSLoginPopUpCloseBtn=By.xpath("//XCUIElementTypeButton[contains(@name,'close')]");
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//		
//		
//	
//
//
//	public static By objiosFollowingBtnSUserName=By.xpath("((//*[@id='Following' and @class='UIAButton'])[1]/preceding-sibling::*//child::*)[1]");
//
//	public static By objiosFollowingIconUnderFollowingTab=By.xpath("//*[@id='Following' and @knownSuperClass='UIButton']");
//
//	//Share Profile In Profile Page
//	public static By objiosShareProfileInProfilePage=By.xpath("//*[@id='Share Profile' and @knownSuperClass='UIButton']");
//
//	public static By objiosBioInEditPage=By.xpath("//*[@id='Edit Profile']/..//following-sibling::*//descendant::*");
//
//	public static By objiosBioDescriptionInEditscreen=By.xpath("//*[@id='Bio']//following-sibling::*[2]");
//
//	public static By nameArrowMark(String title) {
//		return By.xpath("//*[@id='"+title+"']//following-sibling::*[2]");
//	}
//	public static By usernameBioArrowMark(String title) {
//		return By.xpath("//*[@id='"+title+"']//following-sibling::*[3]");
//	}
//	public static By objioscloseInNameEditscreen=By.xpath("//*[contains(@id,'close')]");
//
//	public static By objiosEditNameInNameEditscreen=By.xpath("//*[@XCElementType='XCUIElementTypeTextView']");
//
//	public static By objiosSaveInNameEditscreen=By.xpath("//*[@id='Save' and @class='UIAButton']");
//
//	public static By objiosFollowingBtnInFollowingScreen=By.xpath("(//*[@id='Following' and @class='UIAButton'])[1]");
//
//	public static By objiosFollowingUsersNameDetailsInFollowingcreen=By.xpath("(//*[@id='Following' and @class='UIAButton'])[1]//preceding-sibling::*//child::*[1]");
//
//	public static By objiosFollowingUsersIdDetailsInFollowingcreen=By.xpath("(//*[@id='Following' and @class='UIAButton'])[1]//preceding-sibling::*//child::*[2]");
//
//	public static By objiosFollowBtnInFollowerScreen=By.xpath("(//*[@id='Follow' and @class='UIAButton'])[1]");
//
//	public static By objiosFollowUsersNameDetailsInFollowerScreen=By.xpath("(//*[@id='Follow' and @class='UIAButton'])[1]//preceding-sibling::*//child::*[1]");
//
//	public static By objiosFollowUsersIdDetailsInFollowerScreen=By.xpath("(//*[@id='Follow' and @class='UIAButton'])[1]//preceding-sibling::*//child::*[2]");
//
//	
//	public static By objiosFollowingBlackBtnInFollowerScreen=By.xpath("//*[@id='ic following black']");
//
//	public static By VideosHashTagsSoundsInFavourite(String TabName) {
//		return By.xpath("//*[@id='"+TabName+"' and @XCElementType='XCUIElementTypeOther']");
//	}
//
//	public static By ScrollDateMonthYear(int number) {
//		return By.xpath("(//*[@class='UIAPickerWheel'])["+number+"]");
//	}
//
//	public static By objiosSearchFieldInFollowingPage=By.xpath("//*[@placeholder='Search Following' and @knownSuperClass='UITextField']");
//
//
//	public static By objiosSearchFieldInFollowersPage=By.xpath("//*[@placeholder='Search Followers' and @knownSuperClass='UITextField']");
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	//@Mahesh1e613bb5
//	
//	//invalid phone Number error toast messgae 
//	public static By objiosinvalidErrorToastMessageInLoginPage=By.xpath("//*[@id='Invalid input parameter']");
//
//	//invalid phone Number error toast messgae less Than 10 digits and valid phone number and invalid password
//	public static By objiosinvalidErrorToastMessageForMobileNumberLessThan10DigitsInLoginPage=By.xpath("//*[@id='The mobile number and password combination was wrong during login.']");
//
//	public static By objiosOTPField(int index){
//		return By.xpath("(//*[@class='UIATextField'])["+index+"]");
//	}
//
//	//OTP error message
//	public static By objiosOTPErrorToastMessageInLoginPage=By.xpath("//*[@id='Either OTP is not valid or has expired']");
//	
//	//Find Friends
//		public static By objiosFindFriends=By.xpath("//*[@id='Find Friends' and @class='UIANavigationBar']");
//
//	//Delete  button in Draft video screen
//	public static By objiosDraftVideoDeleteButton=By.xpath("(//*[@id='Delete'])[1]");
//
//	//Toast Message Video is saved as draft
//	public static By objiosSaveAsDraftTostMessage=By.xpath("//*[@id='Video is saved as draft!']");
//
//	public static By objiosFollowingTabInFollowingScreen=By.xpath("//*[contains(text(),'Following') and @XCElementType='XCUIElementTypeCell']");
//
//	public static By objiosFollowerTabInFollowingScreen=By.xpath("//*[contains(text(),'Follower') and @XCElementType='XCUIElementTypeCell']");
//
//	public static By objiosFollowerNameInFollowerTab(String name) {
//		return By.xpath("(//*[contains(text(),'"+name+"')])[2]");
//	}
//
//	//manage your account in login to hipi popup(manage your account)
//	public static By objiosManageYourAccountTextInLoginToHipiPopUp=By.xpath("//*[@id='Manage your account, check notifications, comment \\non videos and more']");
//
//	//By continuing, you Agree,Terms of use text in login to hipi popup(Terms of Use)
//	public static By objiosByContinuningYouAgreeTermsofUsetextInLoginToHipiPopUp=By.xpath("//*[@id=concat('By continuing, you agree to Hipi', \"'\", 's Terms of Use and confirm that you have read Hipi', \"'\", 's Privacy Policy.')]");	
//
//
//	//Don't have an account?Sign up text in login popup
//	public static By objiosDontHaveAnAccountSignUpTextInLoginToHipiPopUp=By.xpath("(//*[@text='Sign up']/..)[1]");			
//
//
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	//please use valid email address toast message
//	public static By objiosPleaseUseValidEmailAddressToastMessageInLoginPage=By.xpath("//*[@id='Please use valid Email Address.']");
//
//	//Email textField  in Reset page
//	public static By objiosEmailAddressTextFieldInResetPage=By.xpath("//*[@placeholder='Email']");
//
//	//we will email you a link  to reset your password text in reset page
//	public static By objiosWeWillEmailYouTextInResetPage=By.xpath("//*[@id=concat('We', \"'\", 'll email you a link to reset your password')]");
//
//	///////////////////////28-12-21/////////////////----s
//	//Intetnet Error
//	public static By objiosInternetError=By.xpath("//*[@id='Internet error']");
//
//	//Invalid Combination
//	public static By objiosInvalidDetails=By.xpath("//*[@id='The email address and password combination was wrong during login.']");
//
//	//previously logged in facebook
//	public static By objiosPreviouslyLoggedInFacebook=By.xpath("//*[@id='You previously logged in to HiPi with Facebook.']");
//
//	//would you like to continue
//	public static By objiosLikeToContinueInFacebook=By.xpath("//*[@id='Would you like to continue?']");
//
//	//contonue
//	public static By objiosConrtinueInFacebook=By.xpath("//*[@id='Continue']");
//
//	//Cancel in facebook
//	public static By objiosCancelInFacebook=By.xpath("(//*[@id='Cancel' and @class='UIAButton'])[2]");
//
//	//Privacy Policy
//	public static By objiosPrivacyPolicyInFacebook=By.xpath("(//*[@id='Privacy Policy']");
//
//	//Terms In facebook
//	public static By objiosTermsInFacebook=By.xpath("//*[@id='Terms']");
//
//	//Continuing Hipi
//	public static By objiosByContinuingHipiInFacebook=By.xpath("//*[contains(text(),'By continuing, HiPi')]");
//
//
//	//Saved/Bookmark
//	public static By objiosSavedBookmarkVideoInProfileTab=By.xpath("//*[contains(@id,'bookmark')]");
//
//	//////s-24-12-21
//	//Notifiaction in profile pic
//	public static By objiosNotificationInProfilePage=By.xpath("//*[@id='ic push notification']");
//
//	public static By objiosTotalNumberOfDraftVideos=By.xpath("//*[@id='Drafts']//parent::*//following-sibling::*[contains(text(),'Video')]");
//
//
//	//04-01-2022------mahi========================
//	public static By objiosPrivateProfile=By.xpath("//*[contains(text(),'private')]");
//
//
//	//=============================================================================Profile page=====
//
//	//n===========================04-1=2022===============================================
//
//	//Last video Created 
//	public static By objiosLastVideoCreatedInProfilePage=By.xpath("(//*[contains(@id,'VideoCreated')])[1]");
//
//	//Shoppable Video In Profile Page
//	public static By objiosShoppableVideoInProfilePage=By.xpath("//*[contains(@id,'ic profile tab like')]");
//
//	//ic profile tab video 
//	public static By objiosprofiletab=By.xpath("//*[contains(@id,'ic profile tab video')]");
//
//
//
//	//----kiran--jan--27-------------------------------------------------------------------------------
//	public static By objiosUserNameAboveProfilePic=By.xpath("(//*[contains(@id,'@')])[2]");
//
//
//	public static By objiosUserNameBelowNameInFollowerAndFollowingScreen=By.xpath("//*[contains(@id,'@')]");
//
//	public static By objiosUserNameInFollowerAndFollowingScreen=By.xpath("(//*[contains(@id,'@')])[1]//preceding-sibling::*");
//
//	public static By objiosListOfFollowBtnInFollowerScreen=By.xpath("//*[@id='Follow' and @class='UIAButton']");
//
//	//Bell Icon in Profile page
//	public static By objiosBellIconInProfileScreen=By.xpath("//*[@id='ic push notification']");
//
//	//All Activity,Like,Comments,Mentions,Followers Icon In Bell Screen
//
//	public static By AllActivityLikeCommentsMentionsFollowersInBellScreen(String IconName) {
//		return By.xpath("//*[contains(@id,'"+IconName+"')]");
//	}
//
//	public static By objiosListOfLikedVideoInLikePage=By.xpath("//*[contains(@id,'liked your video')]");
//
//	public static By objiosNotificationsNotAvailableInBellScreen=By.xpath("//*[@id='Notifications aren’t available']");
//
//	public static By objiosFriendsBtnInBellpage=By.xpath("//*[@id='Friends' and @class='UIAButton']");	
//
//	public static By objiosProfileInBellPage=By.xpath("//*[@id='ic_profile']");	
//
//	public static By objiosFavouriteTitleInBookmarkPage=By.xpath("//*[@id='Favourite' and @class='UIAStaticText']");
//
//	public static By objiosTotalLikesInProfilePage=By.xpath("//*[contains(@id,'like')]/following-sibling::*");
//
//	public static By objiosTotalFollowersInProfilePage=By.xpath("//*[contains(@id,'TotalFollowers')]");
//
//	public static By objiosTotalFollowingInProfilePage=By.xpath("//*[contains(@id,'TotalFollowing')]");
//
//	public static By objiosEditProfileBookmarkchatIcon(String IconName) {
//		return By.xpath("//*[@id='"+IconName+"' and @class='UIAButton']");
//	}
//
//
//
//
//	//--N-----------jan--27--------------------------------------------------
//	public static By objiosProfileNameBelowProfilePhotoInProfilePage=By.xpath("(//*[@id='Follow']//preceding::*//*[@knownSuperClass='UIStackView'])[1]");
//
//
//	//==================12-01-2022-=========================
//
//	//user 
//	public static By objiosusernamelist(int index){
//		return By.xpath("(//*[@id='Follow' and @class='UIAButton'])[1]//preceding-sibling::*//child::*["+index+"]");
//	}
//
//
//
//
//
//
//	//n===========18-01-22--------------------------------------
//
//	// invite tabs in invate page (eg:facebook,sms)		
//	public static By objiosAllTabsInInviteFriendsPage(String name)	{
//		return By.xpath("//*[@id='"+name+"']");
//
//	}
//
//	//FaceBook Page ------
//
//	public static By objiosFacebookPage=By.xpath("(//*[@id='URL'])[2]");
//	//facebookApp
//	public static By objiosFacebookApp=By.xpath("//*[contains(text(),'Facebook')]");
//	//contact page
//	public static By objiosContactPage=By.xpath("(//*[@id='Contacts'])[2]");
//
//	//===================20-01-2022
//	public static By objiosCreatedVideoInProfilePage(int index){
//		return By.xpath("(//*[contains(@id,'VideoCreated')])["+index+"]");
//	}
//
//
//	public static By objiosFirstFollowingUserNameInFollowersFollowingTab=By.xpath("(//*[@id='Following' and @class='UIAButton']//preceding-sibling::*)[2]/child::*[1]");
//
//	//follwer zero
//
//	public static By objiosZeroFollowerTab=By.xpath("//*[@id='Follower 0']");
//	// zero follower screen	
//	public static By objiosZeroFollowerScreen=By.xpath("//*[@id='noUserFollow']");
//	//zero following	
//	public static By objiosZeroFollowingTab=By.xpath("//*[@id='Following 0']");	
//
//	// draft first viedo
//	public static By objiosFirstVideoInDraftScreen=By.xpath("(//*[@id='  Drafts are only visible to you.']/following::*)[4]");	
//
//	//Public Tab in profile page
//	public static By objiosPulicTabInDraftScreen=By.xpath("//*[@id='ic profile tab video unselecte']");
//
//	;	
//
//
//
//	//videos in profile page
//	public static By objiosVideosInProfile=By.xpath("(//*[@id='ic_outline_play'])[1] |(//*[contains(@id,'outline_Play_')])[1]"); 
//
//	//Add a caption in draft video
//	public static By objiosAddCaptionInDraftVideo=By.xpath("(//*[@id='Add a caption'])[1]");
//
//
//
//	//no in delete draft
//	public static By objiosNoInDeleteDraft=By.xpath("//*[@id='NO']");
//
//	//favourite under bookmark
//	public static By objiosFavouriteUnderBookmark=By.xpath("(//*[@id='Favourite'])[1]");	
//
//	//favourite under bookmark
//	public static By objiosfavouriteHipiGoat=By.xpath("//*[contains(@id,'#HipiGOAT')]");		
//
//	//arrow mark in name
//	public static By ArrowMarkInEditProfile(int index){
//		return By.xpath("(//*[@id='ic arrow next'])["+index+"]");
//	}
//
//	//username updated sucessfully
//	public static By objiosUserNameUpdatedSuccessfully=By.xpath("//*[contains(@id,'updated successfully')]");
//
//
//
//	//cancel in name edit screen
//	public static By objiosCancelButton=By.xpath("//*[contains(@id,'Cancel')]");
//
//
//
//	//Bio updated Successfully
//	public static By objiosBioiUpdated=By.xpath("//*[contains(@id,'User Bio updated successfully')]");	
//
//	//username can't be empty
//	public static By objiosUserNameEmpty=By.xpath("//*[@id='Username cannot be empty']");
//
//	//first name error
//	public static By objiosNmaeEmptyErroe=By.xpath("//*[@id='First name cannot be empty']");
//
//
//
//	//userprofile 
//	public static By objiosUserNameInUserProfilePage=By.xpath("//*[contains(@id,'UsernameProfilePage')]");
//
//	//following tab in user followed list
//	public static By objiosFollowingTabInUserFollowedList=By.xpath("//*[@id='Following']");
//
//
//	//error message of user handle to value
//	public static By objiosNameAlreadyTaken=By.xpath("//*[contains(@id,'Username is already taken')]");
//
//
//
//	public static By objiosDateBoxInSignupScreen = By.xpath("(//*[@class='UIAPicker']//child::*)[1]"); // -------------date
//	// box
//
//	public static By objiosMonthBoxInSignupScreen = By.xpath("(//*[@class='UIAPicker']//child::*)[2]"); // -----month
//	// box
//
//	public static By objiosYearBoxInSignupScreen = By.xpath("(//*[@class='UIAPicker']//child::*)[3]"); // --------------------year
//	// box
//	//--------------------------------------------------fed--18----------------------------------------------
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//	
//	
//	
//	
//	public static By objiosGenderDropDownInSignUpScreen=By.xpath("//*[@id='ic drop selection change']");
//
//	public static By objiosGenderTextFieldInSignUpScreen=By.xpath("//*[@id='ic drop selection change']//preceding-sibling::*");
//
//	public static By objiosPasswordTextFieldInSignUpScreen=By.xpath("//*[@placeholder='  Password']");
//
//	public static By objiosCompleteButtonInSignUpScreen=By.xpath("//*[@id='Complete' and @class='UIAButton']");
//
//	public static By objiosMaleGenderInSignUpScreen=By.xpath("//*[@id='Male']");
//
//	public static By objiosTellUsMoreTexInSignUpScreen=By.xpath("//*[contains(@id,'Tell us more ')]");
//
//	public static By objiosUseYourNameTexInSignUpScreen=By.xpath("//*[contains(@id,'Use your Name')]");
//
//	//public static By objiosSignUpTextInLogInToHipiPopUp=By.xpath("//*[@id='Sign up' and @knownSuperClass='UILabel']");
//
//	public static By objiosPhoneTabInLogInPage=By.xpath("//*[@id='Phone' and @XCElementType='XCUIElementTypeCell']");
//	
//
//	public static By objiosLoginWithPasswordInSignUpPage=By.xpath("//*[@id='Login with Password' and @class='UIAButton']");
//
//	public static By objiosLoginTextInSignUpPage=By.xpath("(//*[@id='Log in' and @class='UIAStaticText'])[1]");
//
//
//	public static By objiosAgeToastMessageInSignUpPage=By.xpath("//*[contains(@id,'above 18 year')]");
//
//
//	// Sign up Screen
//	public static By objiosSignUppage=By.xpath("(//*[@id='Sign up'])[2]");	
//	
//	//Already Have An Account Wtih This Number toast message 
//	public static By objiosAlreadyhaveAnAccountWithThisNumber=By.xpath("//*[@id='Already have an account with this number.']");	
//
//	
//
//
//
//
//	
//	
//	
//
//	//sign up screen
//	public static By objiosSignupScreen=By.xpath("(//*[@id='Sign up'])[2]");
//
//	public static By objiosFullNameTextFieldInSignUpScreen=By.xpath("//*[contains(@placeholder,'  Full name')]");
//
//	//clear text in email
//	public static By objiosClearTextInLoginScreen=By.xpath("//*[@id='Clear text']");
//
//	//Select countrty region
//	public static By objiosSelectCountryInSignUpScreen=By.xpath("(//*[@id='D'])[1]");
//
//	//Profile button in below Tab Bar
//	public static By objiOSProfileBtnInBelowTabBar=By.xpath("//*[@text='Profile' and @knownSuperClass='UITabBarButton']");	
//
//	//search country
//	public static By objiosSearchCountry=By.xpath("//*[@id='Search']");
//
//	//cancel in country field
//	public static By objiosCancelInCountry=By.xpath("(//*[@id='Cancel'])[1]");
//
//	//invalid otp
//	public static By objiosInvalidOtp=By.xpath("//*[contains(text(),'not valid')]");
//
//	//send again
//	public static By objiosSendAgainCode=By.xpath("(//*[@id='Send again'])[1]");
//
//	//Resend code
//	public static By objiosResendCode=By.xpath("//*[contains(text(),'Resend')]");
//
//	//your code messgae to this number
//	public static By objiosYourCodeWasMessagesInSignUpScreen=By.xpath("//*[contains(text(),'Your')]");
//
//	///////////////7-2-22////////////////////////
//	//mobile number/email id
//	public static By objiosMobileNumberOrEmailId=By.xpath("//*[contains(text(),'email')]");
//
//	//Facebook password
//	public static By objiosfacebookPassword=By.xpath("(//*[contains(text(),'Facebook')])[7]");
//
//	//LogIn facebook button
//	public static By objiosLogInFacebook=By.xpath("//*[@id='Log In']");
//
//	//create account
//	public static By objiosCreateAccountInFacebookPage=By.xpath("(//*[@id='Create account'])[1]");
//
//	//otp sent successfully
//	public static By objiosOtpSentSuccessfully=By.xpath("//*[contains(text(),'successfully')]");
//
//	//network error
//	public static By objiOSNetworkError=By.xpath("//*[contains(@id,'onnection')]");
//
//	public static By objiOSProfilePictureInFeedScreen=By.xpath("//*[contains(@id,'ProfilePictureForYou')]");
//
//	public static By objiOSTotalCountOfFollowingInProfile=By.xpath("//*[contains(@id,'TotalFollowing')]");
//
//
//	//PopUP Allow Contacts
//	public static By objiosPopAllowContacts=By.xpath("(//*[contains(@id, 'Would Like to Access Your Contacts')])[2]");
//
//	public static By objiosSearchFieldInFollowrsPage=By.xpath("//*[contains(@placeholder,'Search Follower')] | //*[contains(@placeholder,'Search')]");
//
//
//	public static By objiosSearchPlaceholderFollowrsPage=By.xpath("//*[contains(@placeholder,'Search Followers')]");;
//
//	public static By objiosTextInScreen(String text) {
//		return By.xpath("//*[@id='"+text+"']");	
//	}
//
//
//
//	public static By objiOSPublishingInProcessInProfileScreen=By.xpath("//*[contains(@id,'Publishing in process')]");
//
//	public static By objiOSTakeAPhotoPopupInEditProfileScreen=By.xpath("//*[@id='Take a Photo']");
//
//	public static By objiOSPhotoCaptureButtonInCamaraScreen=By.xpath("//*[@id='PhotoCapture']");
//
//	public static By objiOSUsePhotoButtonInCamaraScreen=By.xpath("//*[@id='Use Photo']");
//
//	public static By objiOSProfilePictureUploadedSuccessfullyToustMessageInEditProfileScreen=By.xpath("//*[contains(@id,'Profile picture uploaded successfully')]");
//
//	public static By objiOSFirstVideoInPrivateVideoScreen=By.xpath("(//*[contains(@id,'Play_')])[1]");
//
//	public static By objiOSFewSecondsAgoCommentInCommentScreen=By.xpath("//*[contains(@id,'few seconds ago')]");
//
//	public static By objiOSAllVideoInPrivateVideoScreen=By.xpath("//*[contains(@id,'Play_')]");
//
//
//
//	public static By objiOSHashtagImageInFavouriteHashtagPage=By.xpath("//*[contains(@id,'Hashtag_Image_')]");	
//
//
//
//
//
//	public static By objiOSHashtagInProfileVideos=By.xpath("//*[contains(@id,'Hashtags-Hashtag')]");
//
//	public static By username(String Name) { 
//		return By.xpath("(//*[contains(@text,'"+Name+"')])[2]");
//	}
//
//
//	public static By  BlockUserOptionIn3dotsPopUp=By.xpath("//*[contains(@id,'Block User') and @class='UIAButton']");
//
//	public static By   objiOSHipiWouldLikeToAccessYourContacts=By.xpath("//*[@id='“Hipi” Would Like to Access Your Contacts']");
//
//	public static By   objiOSSearchContactsInInviteFriendsScreen=By.xpath("//*[@placeholder='Search Contacts']");
//
//	public static By   objiOSInviteViaInInviteFriendsScreen=By.xpath("//*[contains(@id,'Invite Via')]");
//
//	public static By   objiOSLensIconInInviteFriendsScreen=By.xpath("//*[contains(@id,'ic search')]");
//
//	public static By   objiOSCrossIconInSearchContactsInInviteFriendsScreen=By.xpath("//*[contains(@id,'close_button')]");
//
//	public static By objiosSearchedContactsInInviteFriendsScreen=By.xpath("//*[@id='ic_profile']//preceding-sibling::*[2]");
//
//	public static By objiosUserHasDisabledCommentsForTheVideoToastMessage=By.xpath("//*[@id='User has disabled comments for the video']");
//
//
//
//
//
//
//	//	27/06/2022
//
//	public static By objiosFollowButtonInUserProfile=By.xpath("(//*[@id='Follow'])[1]");
//
//	public static By objiosChatIconInUserProfile=By.xpath("//*[@id='chatIcon']");
//
//	public static By objiosSuggestedAccountsDownArrowButtonInUserProfile=By.xpath("//*[@id='ic down arrow']");
//
//	public static By objiosSuggestedAccountsUpArrowButtonInUserProfile=By.xpath("//*[@id='ic up arrow']");
//
//	public static By objiosSuggestedAccountsInUserProfile=By.xpath("//*[@id='Suggested accounts']");
//
//	public static By objiosSeeAllSuggestedAccountsInUserProfile=By.xpath("(//*[@id='See all'])[1]");
//
//	public static By objiosFollowButtonInSuggestedAccountSeeAll=By.xpath("//*[@id='Follow']");
//
//	public static By objiosFirstFollowButtonInSuggestedAccount=By.xpath("((//*[@id='com.zee5.hipi:id/ProfilePictureProfilePage'])[2]//following-sibling::*)[2]");
//
//	public static By objiosSendAMessageTextFieldInMessageScreen=By.xpath("(//*[@id='Empty list']//following-sibling::*)[2]");
//
//	public static By objiosProfileIconInMessageScreen=By.xpath("//*[@id='ic_profile']");
//
//	public static By objiosEmptyMessageInMessageScreen=By.xpath("//*[@id='Empty list']");
//
//	public static By objiosPostButtonInMessageScreen=By.xpath("//*[@id='ic send black']");
//
//	public static By objiosPostedMessageInMessageScreen=By.xpath("(//*[contains(@id,'PM')]//following-sibling::*)[3]|(//*[contains(@id,'AM')]//following-sibling::*)[3]");
//
//	public static By objiosHistoryOfMessageInDirectMessageScreen=By.xpath("//*[contains(@id,'@')]");
//
//	public static By objiosDirectMessagePageTextInMessageScreen=By.xpath("//*[@id='Direct Messages']");
//
//	public static By objiosPlusIconInDirectMessageScreen=By.xpath("//*[@id='ic plus']");
//
//	public static By RandomMessagesInMessageScreen(String Message) { 
//		return By.xpath("//*[@id='"+Message+"']");
//	}
//	
//
//	public static By objiosFollowersFollowingLikes(String type) {
//		return By.xpath("(//*[contains(@id,'"+type+"')])[2]");
//		////*[contains(@id,'bookmark')]
//	}
//
//	//Videos In private Button
//	public static By objiosVideosInprivateButton= By.xpath("(//*[contains(@id,'VideoCreated')])[1]");
//
//	//no shoppable inside shoppable tab
//	public static By objiosNoshoppable=By.xpath("//*[contains(@id,'hoppable')]"); 
//
//	public static By nameUsernameDescription(String title) {
//		return By.xpath("//*[contains(@id,'"+title+"')]//following-sibling::*[1]");
//	}
//
//
//	public static By objiOSProfileNamesInProfileDetailsPage=By.xpath("//*[contains(@id,'Name-UsernameProfilePage')]");
//
//	//KeyboardDoneBtn
//
//	public static By objiiosKeyboardDoneBtn = By.xpath("//*[@id='Done']");
//
//	// OpenThisPageFBPopUp
//
//	public static By objiiosOpenThisPageFBPopUp = By.xpath("//*[contains(text(),'this page')]");
//
//	// openBtnInFbPopUp
//
//	public static By objiiosopenBtnInFbPopUp = By.xpath("//*[contains(text(),'Open')  and  contains(@class,'Button')]");
//
//	//login to hipi
//
//	public static By objiiosLoginPopUp=By.xpath("//*[@id='Login in to Hipi' and @knownSuperClass='UILabel']");
//
//	//3dotsmenu
//	public static By objiOS3dotsmenu=By.xpath("//*[@id='ic more black' and @class='UIAButton']");
//
//	//manage account
//	public static By objiOSmanageAcct=By.xpath("//*[contains(@id,'Manage account')]");
//
//	
//	//username profile details page
//	public static By objiOSUserNameInProfileDetailsPage=By.xpath("//*[@knownSuperClass='UINavigationBar']//child::*[contains(text(),'@')]");
//
//	//BackButtonFromProfileDetailsPage
//	public static By objiOSBackButtonFromProfileDetailsPage=By.xpath("//*[@knownSuperClass='UINavigationBar']//child::*[@id='ic back arrow'] | //*[contains(@id,'back')]");
//
//	//edit profile in ProfileDetailsPage
//	public static By objiOSeditprofileButtonFromProfileDetailsPage=By.xpath("//*[@id='Edit Profile' and @knownSuperClass='UIButton']");
//
//	//following label in profile details page
//	public static By objiOSFollowingLabelInProfileDetailsPage=By.xpath("//*[@id='Following' and @knownSuperClass='UILabel']");
//
//	//followers label in profile details page
//	public static By objiOSFollowersLabelInProfileDetailsPage=By.xpath("//*[@id='Followers' and @knownSuperClass='UILabel']");
//
//	//Likes label in profile details page
//	public static By objiOSLikesLabelInProfileDetailsPage=By.xpath("//*[@id='Likes' and @knownSuperClass='UILabel']");
//
//	//Continue with profile
//	public static By objiosContnueWithFB=By.xpath("//*[@id='Continue with Facebook' and @knownSuperClass='UIButton']");
//
//
//	//FBallowPopUpContinueCTA
//	public static By objiosFBallowPopUpContinueCTA=By.xpath("//*[@id='Continue' and @class='UIAButton']");
//
//	//facebookSiteInHipi
//	public static By objiosfacebookSiteInHipi=By.xpath("//*[@id='URL' and @label='Address' and @class='UIAView']");
//
//	//facebookAllowPopUp
//	public static By objiosfacebookAllowPopUp=By.xpath("//*[contains(text(),'facebook.com')]");
//
//	//Save password PopUp
//	public static By objiosSavePasswordPopUp=By.xpath("//*[contains(text(),'Save Password') and @class='UIAButton']");
//
//	//Not now cta
//	public static By objiosNotNowButtonInSavePasswordPopUp=By.xpath("//*[contains(text(),'Not Now') and @class='UIAButton']");
//
//	//facebookSiteInHipiContinueCTA
//	public static By objiosfacebookSiteInHipiContinueCTA=By.xpath("//*[contains(text(),'Continue') and @knownSuperClass='NSObject']");
//
//
//	//facebookSiteInHipi
//	public static By objiosfacebookSiteCancelCTAInHipi=By.xpath("//*[@id='Cancel' and @knownSuperClass='UIButton']");
//
//
//	//Logged-in Successfully Toast msg
//	public static By objiosLoggedinSuccessfullyCTA=By.xpath("//*[@id='Logged-in Successfully' and @knownSuperClass='UILabel']");
//
//	//facebook page
//	public static By objiosFacebookTextInFacebookPage=By.xpath("//*[@value='‎facebook.com, secure and validated connection' and @class='UIAView']");
//
//
//
//
//
//	//s/////7-12//////////////
//	//Private Video Button in profile page
//	public static By objiosPrivateVideoButtonInProfilePage=By.xpath("//*[@id='ic profile tab lock unselected']");
//
//
//	//Save Video In Private Videos
//	public static By objiosSaveVideoInPrivateVideos=By.xpath("//*[@id='Save video' and @class='UIAButton']");
//
//	//Back Arrow In Private Video
//	public static By objiosBackArrowInPrivateVideo=By.xpath("//*[@id='ic back arrow'] |  //*[contains(@id,'back')]");
//
//	//Verify User Page
//	public static By objiosVerifyUserpage=By.xpath("//*[contains(@text,'@')]");
//
//	//Draft video
//	public static By objiosDraftVideoInProfilePage=By.xpath("//*[@id='Drafts']");
//
//	//Draft Page
//	public static By objiosDraftPageInProfilePage=By.xpath("//*[@id='Drafts' and @class='UIANavigationBar']");
//
//	//Video Button Play In Drafts Page
//	public static By objiosVideoButtonPlayInDraftsPage=By.xpath("//*[@id='btnPlay']");
//
//	//Delete Button In drafts Video
//	public static By objiosDeleteButtonIndraftsVideo=By.xpath("//*[@id='Delete' and @class='UIAButton']");
//
//
//	//Delete Popup
//	public static By objiosDeletePopup=By.xpath("//*[@id='Delete Video?']");
//
//	//Delete Button Yes
//	public static By objiosDeleteButtonYes=By.xpath("//*[@id='YES']");
//
//	//Profil Page verify
//	public static By objiosProfilPageVerify=By.xpath("(//*[contains(@text,'@')])[2]");
//
//
//
//
//	//Shoppable video Tab
//	public static By objiosShoppablevideoTabInProfilePage=By.xpath("//*[@id='No shoppable videos']");
//
//
//	//Next btn after record
//	public static By objiosNextBtn=By.xpath("//*[@id='Next']");
//
//	//Share btn FB
//	public static By objiosShareBtn=By.xpath("//*[@id='Share']");
//
//
//	public static By objiosListOfFollowingBtnInNewChatScreen=By.xpath("//*[@id='Following' and @class='UIAButton']");
//
//	//Pop Up log out button in setting & privacy page
//		public static By objiosPopUpLogOutButtonInSettingsPage=By.xpath("//*[@knownSuperClass='UIButtonLabel' and @id='Logout']");
//
//		//				//Pop Up Not Now Button In Save Password PopUp
//		//				public static By objiosNotNowButtonInSavePasswordPopUp=By.xpath("//*[@id='Not Now' and @class='UIAButton']");
//
//		
//		
}
