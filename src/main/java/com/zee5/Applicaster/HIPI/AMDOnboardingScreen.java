package com.zee5.Applicaster.HIPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class AMDOnboardingScreen {
	
	public static By objDisplayLanguageTitle = By.xpath("//*[contains(@resource-id,'screen_title') and @text='Display Language']");
	
	public static By objDefaultDisplayLanguage = By.xpath("(((//*[contains(@resource-id,'selectionImage')])//parent::*)//child::*)[2]");
	
	//public static By objBrowseForFreeBtn = By.xpath("//*[contains(@resource-id,'browseForFreeButton']");
	public static By objBrowseForFreeBtn = By.xpath("//*[@class='android.widget.Button' and @text='Browse for Free']");
	
	public static By objSubscribeNowBtn = By.xpath("//*[@class='android.widget.Button' and @text='Subscribe Now']");
			
			
	public static By objSkip=By.xpath("//*[@class='android.widget.TextView' and @text='Skip']");

	public static By objHipiButton=By.xpath("//*[@class='android.widget.TextView' and @text='HiPi']");
	
	//public static By objZeeMoreButton = By.xpath("//*[contains(@resource-id,'bb_bottom_bar_title' and @text='More']");
	public static By objZeeMoreButton = By.xpath("//*[contains(@resource-id,'navigationTitleTextView') and @text='More']");	
	public static By objLoginLink = By.xpath("//*[contains(@resource-id,'sub_header') and @text='Login/Register for best experience']");
	
	public static By objLogoutButton = By.xpath("//*[contains(@resource-id,'list_item') and @text='Logout']");
	
	public static By objAreYouSurePopupLogoutButton = By.xpath("//*[contains(@resource-id,'logoutButton')]");
	
	public static By objAgreeToTerms = By.xpath("//*[contains(@resource-id,'textView3') and @text='Agree to Terms & Conditions']");

	public static By objNextButton=By.xpath("//*[@id='com.zee5.hipi:id/btnNext']");

	public static By objAgreeToTermSaveButton = By.xpath("//*[contains(@resource-id,'btnNext') and @text='Save']");

	public static By objFeedButton=By.xpath("//*[@id='feedtext']");

	public static By objFeedActionLikeButton=By.xpath("//*[@id='like_icon']");

	public static By objFeedActionCommentButton=By.xpath("//*[contains(@resource-id,'comment_icon')]");

	public static By objFeedActionFollowButton=By.xpath("//*[contains(@resource-id,'follow_icons')]");
	public static By objFeedSectionProfileFollowIcon = By.xpath("//*[contains(@resource-id,'follow_icons')]");
	
	public static By objLoginDialog=By.xpath("//*[@text='Register to start using HiPi']");

	public static By objBackButton=By.xpath("//*[@id='com.android.systemui:id/back']");

	public static By objDiscoverButton=By.xpath("//*[@id='discovertext']");

	public static By objDiscoverHiglighted = By.xpath("//*[contains(@resource-id,'discovertext') and @selected='true']");
	
	public static By objCreateButton=By.xpath("//*[@id='createvideoimage']");

	public static By objPopularButton=By.xpath("//*[@text='Popular']");
	
	public static By objPopularHiglighted = By.xpath("//*[contains(@resource-id,'challengestext') and @selected='true']");

	public static By objForMeButton=By.xpath("//*[@id='metext']");

	public static By objForMeHighlightedHiglighted = By.xpath("//*[contains(@resource-id,'metext') and @selected='true']");
	
	// Get Screen Title
//	public static By objScreenTitle = By.xpath("//*[contains(@resource-id,'screen_title']");
	public static By objScreenTitle = By.xpath("//*[@class='android.widget.TextView' and @text='Content Language']");
	
	public static By objLoginRegisterTitle = By.xpath("//*[@class='android.widget.TextView' and @index='1']");
	
	public static By objSubscribeTitle = By.xpath("//*[@class='android.widget.TextView' and @index='1']");

	// Continue button in the Display language screen
//	public static By objDiplay_ContinueBtn = By.xpath("//*[@class='android.widget.Button']");
//	public static By objDiplay_ContinueBtn = By.xpath("//*[contains(@resource-id,'dl_language_selection']");
	public static By objDiplay_ContinueBtn = By.xpath("//*[@class='android.widget.Button' and @text='Continue']");
//	public static By objDiplay_ContinueBtn = By.xpath("//*[@id='dl_language_selection']");
//	public static By objDiplay_ContinueBtn = By.xpath("//*[contains(@resource-id,'dl_language_selection' and @text='Continue']");	
	
	// Back Icon
//	public static By objBackBtn = By.xpath("//*[contains(@resource-id,'icon_back']");
	public static By objBackBtn = By.xpath("//*[@class='android.widget.TextView' and @text='b']");



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static By objTellUsMore = By.xpath("//*[@text='Tell us more']");
	public static By objPermissionMsg = By.xpath("//*[@id='permission_message']");
	
	
	
	public static By objUpdateZee5PopUpNOTHANKSButton = By.xpath("//*[@text='NO THANKS']");
	
	public static By objAllowLocationAccessPopup = By.xpath("//*[@id='permission_message']");
	public static By objLocationAccessAllowOption = By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']");
	public static By objLocationAccessDenyOption = By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_deny_button']");
	
	public static By objFirstPermissionButton = By.xpath("(//*[@class='android.widget.Button'])[1]");
	public static By objSecondPermissionButton = By.xpath("(//*[@class='android.widget.Button'])[2]");	
	public static By ele1Allow(String str){
		return By.xpath("//*[@text='"+str+"']");
	}
	
	public static By objAllowBtn = By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']");
	public static By objDenyBtn = By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_deny_button']");
	public static By objFeatureCarousel = By.xpath("//*[@class='androidx.recyclerview.widget.RecyclerView' and @index='0']");
	public static By objBenefitsTextSection = By.xpath("//*[@class='androidx.recyclerview.widget.RecyclerView' and @index='1']");
	public static By objDotsIndicator = By.xpath("//*[@class='android.widget.LinearLayout' and @index='1']");
	// Selected Display Language
	public static By objSelectedDisplayLang = By.xpath("//*[@id='selectionImage']//following::*[@id='display_language_content'][1]");
 




	// To Select the Display language
	public static By objSelectDisplayLang(String Language) {
		int index = 0;
		if (Language.equalsIgnoreCase("Hindi")) {
			index = 1;
		} else if (Language.equalsIgnoreCase("English")) {
			index = 2;
		} else if (Language.equalsIgnoreCase("Marathi")) {
			index = 3;
		} else if (Language.equalsIgnoreCase("Telugu")) {
			index = 4;
		} else if (Language.equalsIgnoreCase("Kannada")) {
			index = 5;
		} else if (Language.equalsIgnoreCase("Tamil")) {
			index = 6;
		} else if (Language.equalsIgnoreCase("Malayalam")) {
			index = 3;
		} else if (Language.equalsIgnoreCase("Bengali")) {
			index = 4;
		} else if (Language.equalsIgnoreCase("Gujarati")) {
			index = 5;
		} else if (Language.equalsIgnoreCase("Punjabi")) {
			index = 6;
		} else if (Language.equalsIgnoreCase("Bhojpuri")) {
			index = 7;
		}
		return By.xpath("(//*[@id='display_language_content'])[" + index + "]");
	}

//	public static By objContentLanguageContainer = By.xpath("//*[contains(@resource-id,'content_lang_container']");
//	public static By objContentLanguagePageTitle = By.xpath("//*[contains(@resource-id,'content_lang_screen_title']");

	public static By objContentLanguagePageTitle = By.xpath("//*[contains(@resource-id,'content_lang_screen_title')]");
	public static By objContentLanguageContainer = By.xpath("//*[contains(@resource-id,'content_lang_container')]");
	
	//kanada language
	public static By objcontentlang=By.xpath("(//*[contains(@resource-id,'btn_content_lang')])[5]");
	//English lang
	public static By objcontentlanguage=By.xpath("(//*[contains(@resource-id,'btn_content_lang')])[2]");
	

	// Select content language
	public static By objSelectContentLang(String language) {
		return By.xpath("//*[@id='btn_content_lang' and @text='" + language + "']");
	}

	// Continue button in the Content language screen
	public static By objContent_ContinueBtn = By.xpath("//*[contains(@resource-id,'btn_content_language_selection')]");
//	public static By objContent_ContinueBtn = By.xpath("//*[contains(@resource-id,'btn_content_language_selection']");

	// Login OR Skip Button in Intro Screen
	public static By objLoginLnk = By.xpath("//*[@id='skip_link']");

	public static By objLabels(String text) {
		return By.xpath("//*[@id='becomeATextView' and contains(text(),'" + text + "')]");
	}

	public static By objDotsIndicator(int index) {
		return By.xpath(
				"//*[@id='dotsIndicator']//following-sibling::*[@class='android.widget.ImageView'][" + index + "/]");
	}



	//public static By objSubscribeNowBtn = By.xpath("//*[contains(@resource-id,'joinNowButton']");

	public static By objHavePrepaidBtn = By.xpath("//*[@id='haveACouponCodeButton']");

	public static By objPrepaidPopupLabel = By.xpath("//*[@id='txt_prepaid_code']");

	public static By objPrepaidCodeField = By.xpath("//*[@id='edit_prepaid_code']");

	public static By objPopUpDivider = By.xpath("//*[@id='dialog_divider']");

	// What is Prepaid code? button in the Prepaid code Pop-up
	public static By objWhatIsPrepaidCodeBtn = By.xpath("//*[@id='txt_what_is_promo_code']");

	// Get description from About Prepaid Code
	public static By objDescriptionTxt = By.xpath("//*[@id='description']");

	// Apply Button
	public static By objApplyBtn = By.xpath("//*[@id='btn_promo_code_next']");

	// Pop-up screen elements
	public static By objFaceIcon = By.xpath("//*[@id='iconSmile']");
	public static By objSuccessTitle = By.xpath("//*[@id='txt_success_title']");
	public static By objSuccessDesc = By.xpath("//*[@id='txt_success_desc']");
	public static By objLoginBtn = By.xpath("//*[@id='btn_dialog_login']");
	public static By objRegisterBtn = By.xpath("//*[@id='btn_dialog_register']");
	public static By objDoneBtn = By.xpath("//*[@id='btn_dialog_done']");
	public static By objWatchNowBtn = By.xpath("//*[@id='btn_dialog_watch_now']");

	// Pop-up screen title
	public static By objSuccessTitle(String popupTitle) {
		return By.xpath("//*[@id='txt_success_title' and @text='" + popupTitle + "']");
	}

	public static By objNextBtnPopUpInCalender = By.xpath("//*[@id='next']");

	public static By objNextDate(String date) {
		return By.xpath("//*[@text='" + date + "']");
	}

	public static By objWaitForSplashScreenDisapear = By.xpath(
			"//*[@id='permission_allow_button'] | //*[@id='browseForFreeButton'] | //*[@id='title' and @text='Home']");
	/**
	 * Kushal
	 */

	public static By objContentLangBtns = By.xpath("//*[@id='btn_content_lang']");

	public static By objgetContentLangName(int index) {
		return By.xpath("(//*[@id='btn_content_lang'])[" + index + "]");
	}

	public static By objExitPopup = By.xpath("//*[contains(@resource-id,'verify_account_desc')]");

	public static By objExitYes = By.xpath("//*[contains(@resource-id,'btn_exit_yes')]");

	public static By objExitNo = By.xpath("//*[contains(@resource-id,'btn_exit_no')]");
	
	public static By objExitPopupDivider = By.xpath("//*[contains(@resource-id,'dialog_divider')]");

	public static By objExitPopupHorizontalLinebar = By.xpath("(//*[@class='android.view.View'])[2]");

	public static By objContinueBtnInDebugBuild = By.xpath("//*[contains(@resource-id,'continue_button')]");
	
	public static By objContinueBtnInCountryPopUp = By.xpath("//*[contains(@resource-id,'country_selection_button')]");

}
