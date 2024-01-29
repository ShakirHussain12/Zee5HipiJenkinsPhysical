package com.zee5.iOSmWebHipiPages;

import org.openqa.selenium.By;

public class IOSHipiMwebHomePage {
	

	public static By objiosmwebSearchAddress=By.xpath("//XCUIElementTypeOther[@name='Address'] | //XCUIElementTypeButton[@name='URL']");
	
	

	//Discover button in below Tab Bar
	public static By objiOSmwebDiscoverBtnInBelowTabBar=By.xpath("//*[contains(@name,'Explore') and contains(@type,'Text')]");	

	
//public static By objiosmwebSearchAddress=By.xpath("//XCUIElementTypeOther[@name='Address']");
	
	public static By objiosmwebSearchTabInSafari=By.xpath("//XCUIElementTypeTextField[@name='URL']");	
	
	
	public static By objiosSwipeUpForNxtVideoInSafari=By.xpath("//XCUIElementTypeStaticText[@name='Swipe up for next video']");
	
	//login to hipi

	public static By objiiosmwebLoginPopUp=By.xpath("//XCUIElementTypeOther[@name='Login to Hipi']");

	//Reload button
	public static By objiiosmwebReloadBtn=By.xpath("//XCUIElementTypeButton[@name='ReloadButton']");

	//For You
	public static By objiOSmwebForYouBtnInFeedScreen=By.xpath("(//*[contains(@name,'For You')])[1]");

	//Profile button in below Tab Bar
	public static By objiOSmwebProfileBtnInBelowTabBar=By.xpath("//XCUIElementTypeStaticText[@name='Profile']"); 

	//Use email or phone 
	public static By objiOSmwebUseEmailOrPhoneInBelowTabBar=By.xpath("//XCUIElementTypeStaticText[@name='Use phone or Email']");
	
	public static By  objiOSmwebEmailOption=By.xpath("(//*[contains(@name,'Email')])[1]");
		//XCUIElementTypeStaticText[@name="Email"]
	
	public static By objiOSmwebEmailIdField=By.xpath("//*[@type='XCUIElementTypeTextField' and @value='Email address']");
	//*[@type='XCUIElementTypeTextField' and @value='Email address']

	public static By objiosmWebPasswordField=By.xpath("//*[@type='XCUIElementTypeSecureTextField' and @value='Password']");
	//*[@type='XCUIElementTypeSecureTextField' and @value='Password']
	
	
	public static By objiiosmWebLoginBtn=By.xpath("//XCUIElementTypeButton[@name='Log in' and @enabled='true']");
	//*[@type='XCUIElementTypeButton' and @name='Log in']

	//3dotsmenu
	public static By objiOS3dotsmenu=By.xpath("//*[contains(@name,'black')]");	
		
	
	//Home button in below Tab Bar
	public static By objiOSnmwebHomeBtnInBelowTabBar=By.xpath("//*[contains(@name,'Home') and contains(@type,'Text')] | //XCUIElementTypeOther[@name='com.zee5.hipi:id/Id-FeedScreenForYou'] |//XCUIElementTypeButton[contains(@label,'Home')] ");

//	//Discover button in below Tab Bar
//	public static By objiOSmwebDiscoverBtnInBelowTabBar=By.xpath("//*[contains(@name,'Explore') and contains(@type,'Text')] | //*[contains(@name,'Feed-')] |//XCUIElementTypeButton[contains(@label,'Home')]");	

	
	//like btn

	public static By objiOSmwebLikeBtn=By.xpath("");

	//Discover button in below Tab Bar
	public static By objiOSmwebCancelbtn=By.xpath("//XCUIElementTypeButton[@name='Cancel']");
	
	//User Name In FeedScreen
			public static By objiOSmwebUserNameInFeedScreen=By.xpath("(//*[contains(@name,'@')])[1]");

			//Create button in below Tab Bar
			public static By objiOSmwebCreateBtnInBelowTabBar=By.xpath("//*[contains(@name,'Create') and contains(@type,'Text')]");	


			//Create button in below Tab Bar
			public static By objiOSmwebOpenHipiAppBtnInBelowTabBar=By.xpath("//XCUIElementTypeButton[@name='Open the Hipi app']");
			
			
			//Home button in below Tab Bar
			public static By objiOSmwebHomeBtnInBelowTabBar=By.xpath("//*[contains(@value,'Home') and contains(@class,'utton')] | //*[contains(@name,'Feed-')] |//XCUIElementTypeButton[contains(@label,'Home')]| //*[contains(@name,'Home')] ");


			//Download button in below Tab Bar
			public static By objiOSmwebDownloadBtnInAppStore=By.xpath("//XCUIElementTypeButton[@name='re-download']");
					
			

}
