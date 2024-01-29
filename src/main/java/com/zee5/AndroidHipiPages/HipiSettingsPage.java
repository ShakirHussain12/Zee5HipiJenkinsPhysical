package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiSettingsPage {

	//Hipitoggle
	public static By objHipitoggle=By.xpath("//*[@resource-id='a2']");

	//zee5toggle
	public static By objzee5toggle=By.xpath("//*[@resource-id='a1']");
	//backtohome
	public static By objbacktohome=By.xpath("//*[@text='Back to Home']");
	//stepitup
	public static By objstepitup=By.xpath("//*[@text='Step It Up  ']");
	//needhelp
	public static By objneedhelp=By.xpath("//*[@text='Need Help ']");
	//quicklinks
	public static By objquicklinks=By.xpath("//*[@text='Quick Links ']");
	//Gettingstarted
	public static By objgettingstarted=By.xpath("//*[@text='Getting Started ']");
	public static By objQueriesHeader(String text) {
	return By.xpath("//*[@class='android.widget.TextView' and @text= '"+text+"']");
}
	//*[@class='android.view.View' and @text='Get to know HiPi!']
	public static By objArticleTitle(String text) {
		return By.xpath("//*[@class='android.view.View' and @text= '"+text+"']");
	}
	//}
	//public static By objArticleTitle(String title) {
		//return By.xpath("(//*[contains(@content-desc,'" + title + "')] | //*[contains(@text,'" + title + "')])[2]");
	//}
	//gettoknow
	public static By objgettoknow=By.xpath("//*[@class='android.widget.TextView' and @text='Get to know HiPi']");
	//gettoknowarticle
	public static By objgettoknowarticle=By.xpath("//*[@text='Get to know HiPi!']");
	//myaccount
	public static By objmyaccountHipi=By.xpath("//*[@text='My Account ']");
	//ismyaccount
	public static By objismyaccount=By.xpath("//*[@text='Is my HiPi account separate from my ZEE5 account?  ']");
	//queriesheadercreatevideo
	public static By objcreatevideo=By.xpath("//*[@text='Create a video ']");
//articlhowdoisign
	public static By objhowdoisignarticle=By.xpath("//*[@class='android.view.View' and @text='How do I sign in for HiPi?']");
	//tipstogetpopulararticle
	public static By objtipsarticle=By.xpath("//*[@class='android.view.View' and @text='Tips to get popular on HiPi']");
	//joinchallenge
	public static By objjoinchallenge=By.xpath("//*[@text='Join a challenge ']");
	//linkaccountarticle
	public static By objlinkaccountarticle=By.xpath("//*[@class='android.view.View' and @text='Link a social account']");
	//hipiaccountarticle
	public static By objarticlehipiaccount=By.xpath("//*[@class='android.view.View' and @text='My HiPi Account']");
	//video/audioheader
	public static By objvideoheader=By.xpath("//*[@text='Video or Audio']");
	//followlikes
	public static By objfollowlikes=By.xpath("//*[@text='Follow/Like/Comment']");
	//articlelikes
	public static By objarticleslike=By.xpath("//*[@class='android.view.View' and @text='Follow/ Like/ Comment']");
	//notificationmessage
	public static By objnotification=By.xpath("//*[@text='My Notifications/Messages']");
	//appperformance
//linksaccount
	public static By objlinkaccount=By.xpath("//*[@text='Link a social account ']");
	//appperformance
	public static By objappperformanceheader=By.xpath("//*[@text='My App performance']");
	
	public static By objComminityStandards=By.xpath("//*[@text='Community Standards']");
	//reportcontentheader
	public static By objreportcontentheader=By.xpath("//*[@text='Report inappropriate content']");
	//privacy&securityheader
	public static By objprivacyheader=By.xpath("//*[@text='Privacy & Security']");
	//cannotfindvideo
	public static By objcannotfindvideo=By.xpath("//*[@text='I cannot find my video']");
	//premiereleagueheader
	public static By objpremierleague=By.xpath("//*[@text='HiPi Premier League']");
	//hipiaccountheader
	public static By objhipiaccountheader=By.xpath("//*[@text='My HiPi account']");
	//getpremiumleaguearticle
	public static By objpremiereleaguearticle=By.xpath("//*[@text='Get ready for the HiPi Premier League!']");
	//subtitlear
	public static By objarticlesubtitles=By.xpath("//*[@class='android.view.View' and @text='All about subtitles']");
	public static By obSettingScreen=By.xpath("//*[contains(@resource-id,'profile_container')]");

	//Edit Profile Screen Title
	public static By objEditProfilePageTitle = By.xpath("//*[contains(@resource-id,'my_edit_profile_text')]");

	//HiPi Preferences Toggle Buttons
			public static By objToggleButton(String HiPiPreferences) {
				return By.xpath("//*[@class='android.widget.Switch' and (./preceding-sibling::* | ./following-sibling::*)[@text='"+HiPiPreferences+"']]");
			}
			//HiPi Settings Page title
			public static By objHipiSettingsPageTitle = By.xpath("//*[contains(@resource-id,'offers_title')]");
			//Edit HiPi Profile Option
			public static By objEditHiPiProfileOption = By.xpath("//*[@text='Edit HiPi Profile']");
			//HiPi Preferences Option
			public static By objHiPiPreferencesOption = By.xpath("//*[@text='HiPi Preferences']");
			//Country/Region Option
			public static By objCountryRegionOption = By.xpath("//*[@text='Country/Region']");
			//Download over WiFi only Option
			public static By objDownloadOverWifiOnlyOption = By.xpath("//*[@text='Download over WiFi only']");
			//HiPi Back Button
			public static By objHiPiBackButton = By.xpath("//*[contains(@resource-id,'back')]");
			//Edit Profile Screen Back Button
			public static By objHiPiImgBackButton = By.xpath("//*[@id='imgBack']");
			//HiPi Preferences Title
			public static By objHiPiPreferencesPageTitle = By.xpath("//*[@text='HiPi Preferences']");

//----------------------------------------------------------------------------------------------------------------------
	//Kartheek
	
	//Setting  & Privacy
		public static By objSettingAndPrivacy = By.xpath("//*[@resource-id='com.zee5.hipi:id/my_edit_profile_text']");
	//Account
		public static By objAccount = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvAccount'] | //*[contains(@text,'ACCOUNT')]");
	//Change password
		public static By objChangePassword = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvManageAcnt'] | //*[contains(@text,'Change password')]");
	//Privacy
		public static By objPrivacy = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvPrivacy'] |(//*[contains(@text,'Privacy')])[2]");
	//Share Profile
		public static By objShareProfile = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvSharePrfl'] | //*[contains(@text,'Share profile')]");
	//CONTENT AND ACTIVITY
		public static By objContentAndActivity= By.xpath("//*[@resource-id='com.zee5.hipi:id/tvContent']");
	//App language
		public static By objAppLanguage= By.xpath("//*[@resource-id='com.zee5.hipi:id/tvLanguage']");
	//Support
		public static By objSupport = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvSupport']");
	//Help Center
		public static By objHelpCenter = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvHelp'] | //*[contains(@text,'Help')]");
	//Content Complaints
		public static By objContentComplaints = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvComplaint'] | //*[contains(@text,'Content Com')]");
	//About
		public static By objAbout = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvAbout']");
	//Community Guidelines
		public static By objCommunityGuidelines = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvCommnty'] | //*[contains(@text,'Community G')]");
	//Terms of Use
		public static By objTermsOfUse = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvTerms'] | //*[contains(@text,'Terms')]");
	//Community Centre
		public static By objCommunityCentre = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvPrivacyPolicy'] | //*[contains(@text,'Community C')]");
	//Log out
		public static By objLogOut = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvLogout'] | //*[contains(@text,'Log')]");
	//Version
		public static By objVersion = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvVersion']");	
	//App Language Title
		public static By objAppLanguageTitle = By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");
	//English 
		public static By objEnglish = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvLanguage']");
	//Log out Title
		public static By objLogOutTitle = By.xpath("//*[@resource-id='com.zee5.hipi:id/alertTitle']");
	//Are you Sure you want to logout
		public static By objAreYouSureYouWantToLogout= By.xpath("//*[@resource-id='android:id/message']");
	//No CTA Log Out popup
		public static By objNoCTALogOutPopup = By.xpath("//*[@resource-id='android:id/button2']");
	//Yes CTA Log Out popup
		public static By objYesCTALogOutPopup = By.xpath("//*[@resource-id='android:id/button1']");
	//outsside the popup screen
		public static By objOutssideThePopupScreen = By.xpath("//*[@resource-id='android:id/button2']");
	//Hipi Logo
		public static By objHipiLogo = By.xpath("//*[@text='hipi-logo']");
	//Help center Title
		public static By objHelpCenterTitle = By.xpath("//*[@resource-id='headerContent']//child::*[@text='Help Center']");
	//Search Field in help center	
		public static By objSearchFieldInHelpCenter	 = By.xpath("//*[@class='android.widget.EditText']");

		//Search result
				public static By objSearchResultHelpCenter=By.xpath("//*[contains(text(),'Search results for')]");
				//Search Button in Help Centre
				public static By objSearchButton=By.xpath("//*[@class='android.widget.Button']");
				//Help Center Back Button
				public static By objHelpcenterBackButton =By.xpath("//*[@resource-id='com.zee5.hipi:id/imgAddUser']");
				//community Guidelines
				public static By objCommunityGuidelinesHeader=By.xpath("//*[@resource-id='com.zee5.hipi:id/title' and @text='Community Guidelines']");
				//Community Guidelines Back Button
				public static By objCommunityGuidelinesBackButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/imgAddUser']");
				
				public static By objToggleButtonOff=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvPrivateAcnt' and @checked='false']");
			
				public static By objToggleButtonOn=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvPrivateAcnt' and @checked='true']");

				//change password
				public static By objChangePasswordHeader=By.xpath("//*[@resource-id='com.zee5.hipi:id/innerTitle']");

				//old password field
				public static By objOldPasswordField=By.xpath("//*[@resource-id='com.zee5.hipi:id/etPasswordOld']");
				
				//New password field
				public static By objNewPasswordField=By.xpath("//*[@resource-id='com.zee5.hipi:id/etPassword']");
		
				//submit button
				public static By objSubmit = By.xpath("//*[@resource-id='com.zee5.hipi:id/btnNext']");
					
				//Invite Friends
				public static By objInviteFriends=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvReferEarn'] | //*[contains(@text,'Invite Friend')]");
				public static By objPasswordPromptMessage=By.xpath("//*[@resource-id='com.zee5.hipi:id/snackbar_text']");
				
				//Dowload your video on/off button
				public static By objDownloadYourVideoButton=By.xpath("//*[@id='tvAlwDwnldValue']");
				//who can Duet your video button
					public static By objCommentPrivacy=By.xpath("//*[@id='tvCommentValue']");				
			//who can Duet your video button
				public static By objDuetPrivacy=By.xpath("//*[@id='tvDuetValue']");
			//who can like your video button
				public static By objLikePrivacy=By.xpath("//*[@id='tvLikeValue']");				
			//Like privacy everyone button
				public static By objLikeEveryOne=By.xpath("//*[@id='rbEveryOne']");		
			//Like privacy Noone button
				public static By objLikeNoOne=By.xpath("//*[@id='rbNoOne']");	//*[@contentDescription='How do I sign in for Hipi?'and@clickable='true']
				//Getting started first link
					public static By objGettingStartedFirstLink=By.xpath("//*[@contentDescription='Get to know Hipi'and@clickable='true']");
					//My account first link
				public static By objMyaccountFirstLink=By.xpath("//*[@contentDescription='How do I sign in for Hipi?'and@clickable='true']");
				//Step it Up first link
				public static By objStepItUpFirstLink=By.xpath("//*[@text and @class='android.widget.TextView' and ./parent::*[@contentDescription='Perform a Hipi action'and@clickable='true']]");
				//Need help first link
				public static By objNeedHelpFirstLink=By.xpath("	//*[@text and @class='android.widget.TextView' and ./parent::*[@contentDescription='My Hipi account'and@clickable='true']]");
				//Need help first link
					public static By objQuickLinksFirstLink=By.xpath("//*[@id='tvCommnty'and@clickable='true'] | //*[@contentDescription='Community Standards']");
			//connect with us button in help center
					public static By objConnectWithUs=By.xpath("(//*[@id='footerContainer' and ./parent::*[@id='footerContainer']]/*[@text and @class='android.widget.TextView'])[2]");
			//connect with us facebook 
					public static By objConnectWithUsFacebook=By.xpath("//*[@contentDescription='274026673665543']");
			//connect with us twitter 
					public static By objConnectWithUsTwitter=By.xpath("//*[@contentDescription='1278278692112744451?s=20']");
			//connect with us Instagram 
					public static By objConnectWithUsInstagram=By.xpath("//*[@contentDescription='CCGHx0HlR2p']");
			//rigtsReservedText 
					public static By objRightsReserved=By.xpath("//*[@id='nav_view']");
			//Landing Screen of Hipi help center links
					public static By objLandingScreenHiperlinkOfHelpCentre=By.xpath("//*[@id='tvReferEarn'] | //*[@contentDescription='← Back to Home']");
			//terms of use Header screen
					public static By objTermsOfUseHeaderScreen=By.xpath("//*[@id='my_edit_profile_text']");
			//terms of use back button 
					public static By objTermsOfUseBackButton=By.xpath("//*[@id='imgAddUser']");

					//wrong password popup
					public static By objWrongPasswordPopup=By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@id='snackbar_text']]");

					public static By objShareOptionsSettings=By.xpath("//*[@resource-id='android:id/text1'] | //*[@resource-id='vivo:id/text1'] | //*[@resource-id='oppo:id/resolver_item_name']");

					public static By objShareoptionsSettings(int index) {
						return By.xpath("(//*[@resource-id='android:id/text1'] | //*[@resource-id='vivo:id/text1'] | //*[@resource-id='oppo:id/resolver_item_name'])[" + index + "]");
					}					
					//*[@resource-id='android:id/text1']

					public static By objSearchBar=By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");

					public static By objContactName=By.xpath("//*[@resource-id='com.zee5.hipi:id/nameTxt']");
					
					public static By objClearIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/iv_clear_text']");
					
					public static By objSearchIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/back_button']");
					
					public static By objSearchContacts(String text) {
						return By.xpath("//*[contains(@resource-id,'editTextSearch') and @text='" + text + "']");
					}
					
					
					public static By objOldPassWordCrossIcon=By.xpath("//*[@id='iv_clear_text_old']");
					public static By objPasswordCantBeSamePopup=By.xpath("//*[@id='snackbar_text' and @text='Password can not be the same']");
					public static By objNewPassWordCrossIcon=By.xpath("//*[@id='iv_clear_text']");


					public static By objDataSaverButton=By.xpath("//*[contains(text(),'Data Sa')]");

					public static By objcellularData=By.xpath("//*[contains(text(),'CELLULAR DATA')]");
					public static By objDataSaverHeader=By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");
					
					public static By objDataSaverOFF=By.xpath("//*[contains(text(),'OFF')]");
					public static By objDataSaverOn=By.xpath("//*[contains(text(),'ON')]");
					public static By objContentLanguageOption=By.xpath("//*[contains(@text,'Select your L')]");
					
					public static By objContentLanguageTitle=By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");

					public static By objBackButtonDatasaverScreen=By.xpath("(//*[@resource-id='com.zee5.hipi:id/imgBack'])[2]");

					public static By objDataSaverConent=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvPrvtAcntHint']");
					
							public static By objDataSaver=By.xpath("(//*[contains(text(),'Data Saver')])[2]");
}
