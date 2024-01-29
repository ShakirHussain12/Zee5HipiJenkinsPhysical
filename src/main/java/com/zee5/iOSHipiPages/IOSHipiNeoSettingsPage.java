package com.zee5.iOSHipiPages;

import org.openqa.selenium.By;

public class IOSHipiNeoSettingsPage {


	//Appium Studio

	
    //Logout Button 
	public static By objiOSLogOutBtn=By.xpath("//*[@id='Log out' and @knownSuperClass='UILabel']");

	//YES Button After clicking on Logout
	public static By objiOSLogOutConfirmBtn=By.xpath("//*[@id='Logout' and @knownSuperClass='UIButtonLabel'] | //*[contains(@id,'YES')]");

    //Version Below Logout
	public static By objiOSversionInSettingsScreen=By.xpath("//*[contains(text(),'Version')]");

	//Setting and Privacy Tab Bar
	public static By objiosSettingAndPrivacyTabBar=By.xpath("//*[@class='UIANavigationBar' and @id='Settings & Privacy']");


	// all tabs in setting and privacy page
	public static By SettingAndPrivacyPageTabs(String tabname) {
		return By.xpath("//*[@id='"+tabname+"']");
	}

	//Search text field in help center page
	public static By objiOSsearchTextFieldInHelpCenterPage=By.xpath("//*[@placeholder='Search articles']");


	// Search icon on search text field in help center page	
	public static By objiOSsearchIconInHelpCenterPage=By.xpath("//*[@id='Search']");




	//Hipi Community  Guidelines Tab Bar
	public static By objiosCommunityGuidelinesTabBar=By.xpath("(//*[@id='Hipi Community Guidelines'])[1]");

	//Are you Sure text in logout popup
		public static By objiosAreYouSureTextInLogoutPOpUp=By.xpath("//*[contains(@id,'re you sure')] | //*[contains(@name,'Are you sure')]");

	// Cancel Button in Logout pop
	public static By objiosLogOutButtonInLogoutPOpUp=By.xpath("//*[@id='Cancel' and @class='UIAButton'] | //*[contains(@text,'NO')]");

	//Search text results
		public static By objiOSrespectedSearchResultInHelpCenterPage=By.xpath("(//*[contains(text(),'Search results')])[1]");


	//==============================05-01-2022--------------------n
	//english as defult app language in app language page

	public static By objiosEngLangInAppLanguage=By.xpath("//*[@id='English']");

	//get to know hipi link in help center

	public static By objiosGetToKnowHipiLinkInHelpCenterPage=By.xpath("//*[@id='Get to know Hipi' and @class='UIAStaticText']");

	//Get to Know page
	public static By objiosGetToKnowPage=By.xpath("//*[@id='Get to know Hipi!' and @class='UIAStaticText']");

	//Term of Use page

	public static By objiosTermsOfUsePage=By.xpath("(//*[@id='Terms of Use'])[4]");	

	//				Privacy page		
	public static By objiosPrivacyPage=By.xpath("//*[@id='Privacy' and @class='UIANavigationBar']");	

	//Change password page
	public static By objiosChangePasswordPage=By.xpath("//*[@id='Change Password' and @class='UIAStaticText']");	

	//old password text field in change password page
	public static By objiosOldPasswordTexFieldInChangePasswordPage=By.xpath("//*[@placeholder='Old Password']");

	//New password text field in change password page
	public static By objiosNewPasswordTexFieldInChangePasswordPage=By.xpath("//*[@placeholder='Password']");			


	//Submit button disabled in change password page
	public static By objiosSubmitButtonDisabledInChangePasswordPage=By.xpath("//*[@id='Submit' and @class='UIAButton' and @enabled='false']");		

	//submit button enabled in change password page			
	public static By objiosSubmitButtonEnabledInChangePasswordPage=By.xpath("//*[@id='Submit' and @class='UIAButton' and @enabled='true']");

	//Password was changed successfully toast message
	public static By objiosPasswordWasChangedSuccessfullyToastMessage=By.xpath("//*[@id='Password was changed successfully.']");

	//Password length text in change password page
	public static By objiosPasswordLengthInChangePasswordPage=By.xpath("//*[@id='Password length should be at least 6 characters.']");		

	//Help center UI verification		
	public static By objiosHelpCenterUiVerification(String tabname) {
		return By.xpath("[contains(//*[@id,'"+tabname+"'])]");
	}
	// Hipi Logo
	public static By objiosHipiLogo=By.xpath("(//*[@class='UIAImage' and @XCElementType='XCUIElementTypeImage'])[1]");		



	// Help Center text In Help Center Page(Help center page)
	public static By objiosHelpCenterTextInHelpCenterpage=By.xpath("//*[@id='Help Center' and @class='UIAStaticText' and @knownSuperClass='NSObject']");

	//links present in help center page			
	public static By objiosFollowingHeadersFirstLinkInHelpcenterPage(String HeaderName,int index){
		return By.xpath("(//*[@id='"+HeaderName+" ']//parent::*//following-sibling::*//*[@class='UIAView']//child::*)["+index+"]");
	}

	// title of link page            
	public static By objiosTitleOfHeaderLink=By.xpath("(//*[@id='main']//*[@id='article']//child::*)[1]");



	//Connect With us text
	public static By objiosConnectWithUsTextInHelpCenterPage=By.xpath("//*[contains(@id,'Connect with us')]");            

	// @2020 text in help center page        
	public static By objios2020TextInHelpCenterPage=By.xpath("//*[@id='@2020 ZEE Digital All rights reserved.']");       


	// Back to home Button Link page
	public static By objiosBackToHomeButtonInLinkPage=By.xpath("//*[@id='← Back to Home']");  


	//arrow mark to navigate to top of screen
	public static By objiosArrowMarkAtBottmOfScreen=By.xpath("//*[contains(@id,'Connect with us')]//following::*//*[contains(@knownSuperClass,'bject') and contains(@class,'mage')]");


	//Share Profile In Profile Page
	public static By objiosShareProfile=By.xpath("//*[contains(@id,'Share ')]");  

	public static By objiosClearTextInOldPasswordField=By.xpath("//*[@id='Clear text']");

	public static By objiosClearTextInNewPasswordField=By.xpath("//*[@id='Clear text']");

	public static By objiosTheOldPasswordWasNotCorrectToastMessageInChangePasswordScreen=By.xpath("//*[@id='The old password was not correct.']");

	 
















//	//Appium Server
//
//
//	
//	
//	//Setting and Privacy Tab Bar
//	public static By objiosSettingAndPrivacyTabBar=By.xpath("//XCUIElementTypeNavigationBar[@name='Settings & Privacy']");
//
//	// all tabs in setting and privacy page
//	public static By SettingAndPrivacyPageTabs(String tabname) {
//		return By.xpath("//XCUIElementTypeStaticText[@name='"+tabname+"']]");
//	}
//
//	//Logout Button 
//	public static By objiOSLogOutBtn=By.xpath("//XCUIElementTypeStaticText[@name='Log out']");
//
//	//Are you Sure text in logout popup
//	public static By objiosAreYouSureTextInLogoutPOpUp=By.xpath("//XCUIElementTypeStaticText[@name='Are you sure you want to logout?']");
//
//	//YES Button After clicking on Logout
//	public static By objiOSLogOutConfirmBtn=By.xpath("//XCUIElementTypeButton[@name='YES']");
//
//	// Cancel Button in Logout pop
//	public static By objiosLogOutButtonInLogoutPOpUp=By.xpath("//XCUIElementTypeButton[@name='NO']");
//
//	//Version Below Logout
//	public static By objiOSversionInSettingsScreen=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Version')]");
//
//	//Search text field in help center page
//	public static By objiOSsearchTextFieldInHelpCenterPage=By.xpath("(//XCUIElementTypeStaticText[@name='Search articles'])[1]");
//
//	// Search icon on search text field in help center page	
//	public static By objiOSsearchIconInHelpCenterPage=By.xpath("//XCUIElementTypeButton[@name='Search']");
//
//	//english as defult app language in app language page
//	public static By objiosEngLangInAppLanguage=By.xpath("//XCUIElementTypeStaticText[@name='English']");
//
//	//get to know hipi link in help center
//	public static By objiosGetToKnowHipiLinkInHelpCenterPage=By.xpath("//XCUIElementTypeStaticText[@name='Get to know Hipi']");
//
//	//Get to Know page
//	public static By objiosGetToKnowPage=By.xpath("(//XCUIElementTypeStaticText[@name='Get to know Hipi!'])[1]");
//
//	//Term of Use page
//	public static By objiosTermsOfUsePage=By.xpath("//XCUIElementTypeNavigationBar[@name='Terms of Use']");	
//
//	//Privacy page		
//	public static By objiosPrivacyPage=By.xpath("//XCUIElementTypeNavigationBar[@name='Privacy']");	
//
//	//Change password page
//	public static By objiosChangePasswordPage=By.xpath("//XCUIElementTypeStaticText[@name='Change Password']");	
//	
//	//old password text field in change password page
//	public static By objiosOldPasswordTexFieldInChangePasswordPage=By.xpath("//*[@value='Old Password']");
//
//	//New password text field in change password page
//	public static By objiosNewPasswordTexFieldInChangePasswordPage=By.xpath("//*[@value='Password']");			
//
//	//Submit button disabled in change password page
//	public static By objiosSubmitButtonDisabledInChangePasswordPage=By.xpath("//XCUIElementTypeButton[@name='Submit' and @enabled='false']");		
//
//	//submit button enabled in change password page			
//	public static By objiosSubmitButtonEnabledInChangePasswordPage=By.xpath("//XCUIElementTypeButton[@name='Submit' and @enabled='true']");
//
//	// Hipi Logo
//	public static By objiosHipiLogo=By.xpath("//XCUIElementTypeOther[@name=\"banner\"]/XCUIElementTypeLink/XCUIElementTypeImage");		
//
//	//Connect With us text
//	public static By objiosConnectWithUsTextInHelpCenterPage=By.xpath("//XCUIElementTypeStaticText[@name='Connect with us']");            
//
//	// @2020 text in help center page        
//	public static By objios2020TextInHelpCenterPage=By.xpath("//XCUIElementTypeStaticText[@name=\"@2020 ZEE Digital All rights reserved.\"]");       
//
//
//	// Back to home Button Link page
//	public static By objiosBackToHomeButtonInLinkPage=By.xpath("//XCUIElementTypeLink[@name='← Back to Home']");  
//
//	//Share Profile
//	public static By objiosShareProfile=By.xpath("//XCUIElementTypeStaticText[@name='Share profile']");  
//	
//	public static By objiosClearTextInOldPasswordField=By.xpath("//XCUIElementTypeButton[@name='Clear text']");
//
//	public static By objiosClearTextInNewPasswordField=By.xpath("//XCUIElementTypeButton[@name='Clear text']");
//
//	//Password length text in change password page
//	public static By objiosPasswordLengthInChangePasswordPage=By.xpath("//XCUIElementTypeStaticText[@name='Password length should be at least 6 characters.']");
//	
//	
//	
//	
//	public static By objiosTheOldPasswordWasNotCorrectToastMessageInChangePasswordScreen=By.xpath("//*[@name='The old password was not correct.']");
//
//	//Password was changed successfully toast message
//	public static By objiosPasswordWasChangedSuccessfullyToastMessage=By.xpath("//*[@name='Password was changed successfully.']");
//
//	//Help center UI verification		
//	public static By objiosHelpCenterUiVerification(String tabname) {
//		return By.xpath("[contains(//*[@name,'"+tabname+"'])]");
//	}
//
//	// Help Center text In Help Center Page(Help center page)
//	public static By objiosHelpCenterTextInHelpCenterpage=By.xpath("(//XCUIElementTypeStaticText[@name='Help Center'])[2]");
//
//	//Search text results
//	public static By objiOSrespectedSearchResultInHelpCenterPage=By.xpath("((//*[contains(@name,'Search results')])[1]//following-sibling::*//XCUIElementTypeStaticText)[1]");
//
//	//Hipi Community  Guidelines Tab Bar
//	public static By objiosCommunityGuidelinesTabBar=By.xpath("//XCUIElementTypeStaticText[contains(@name,'ipi')]");
//
//	public static By objiosCommunityGuidelinesInsideText=By.xpath("(//XCUIElementTypeStaticText[contains(@name,'ipi')]//parent::*//following-sibling::*//XCUIElementTypeStaticText)[1]");
//	
//	//links present in help center page			
//	public static By objiosFollowingHeadersFirstLinkInHelpcenterPage(String HeaderName,int index){
//		return By.xpath("(//XCUIElementTypeStaticText[contains(@name,'"+HeaderName+"')])["+index+"]");
//	}
//
//	// title of link page            
//	public static By objiosTitleOfHeaderLink=By.xpath("(//*[@name='main']//*[@name='article']//child::*)[1]");
//	
//	//arrow mark to navigate to top of screen
//	//public static By objiosArrowMarkAtBottmOfScreen=By.xpath("//*[contains(@id,'Connect with us')]//following::*//*[contains(@knownSuperClass,'bject') and contains(@class,'mage')]");


	
		
}
