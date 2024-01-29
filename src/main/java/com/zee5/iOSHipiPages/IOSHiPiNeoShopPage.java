package com.zee5.iOSHipiPages;

import org.openqa.selenium.By;

public class IOSHiPiNeoShopPage {
	
	//Appium Studio
	

	public static By objiosPullBarInShopPage= By.xpath("//*[contains(@id,'pull-bar')]");

	public static By objiosSavedMomentsInShopPage= By.xpath("//*[contains(@value,'SAVED MOMENTS')]");


	public static By objiosNoOfDeleteButtonsSavedMomentsInShopPage= By.xpath("//*[contains(@id,'Name-SavedMomentsDeleteButton')]");

	public static By objiosNoOfDeleteButtons(int index) {
		return  By.xpath("(//*[@id='Delete'])["+index+"]");

	}

	public static By objiosTotalNosBesideSavedMomentsInShopPage= By.xpath("((//*[contains(text(),'SAVED MOMENTS')]//parent::*)[1]/*)[2]");

	public static By objiosTotalNosBesideInThisVideoTabShopPage= By.xpath("((//*[contains(text(),'IN THIS VIDEO')]//parent::*)[1]/*)[2]");

	public static By objiosCloseButtonInCarouselPage= By.xpath("//*[@id='cbsdk close black' and @class='UIAButton']");


	//public static By objiosCloseButtonInCarouselPage= By.xpath("//*[@id='cbsdk close black' and @class='UIAButton']");

	//You Can Buy Text In CarousalSheet
	public static By objiosProductsYouCanBuyTextInCarousalSheet= By.xpath("//*[contains(@id,'this look')]");


	public static By objiosInThisVideoInShopePage= By.xpath("//*[contains(@value,'IN THIS VIDEO')]");

	//Product List In Shop Button
	public static By objiOSProductListInShopButton=By.xpath("//*[contains(@id,'this look')]");

	//Cross Icon In Shop Page
	public static By objiOSCrossIconInShopPage=By.xpath("//*[@id='cbsdk close black' and @knownSuperClass='UIButton']");

	//Saved Moments In Save page
	public static By objiOSSavedMomentsInShopPage=By.xpath("//*[@value='SAVED MOMENTS' and @knownSuperClass='UILabel']");

	//public static By obj
	public static By objiOSInThisVideoInShopPage=By.xpath("//*[@value='IN THIS VIDEO' and @knownSuperClass='UILabel']");

	public static By ExpandLessButtonInShopPage(String buttontype) {
		return By.xpath("//*[@value='"+buttontype+"' and @class='UIAButton']");
	}


	public static By objiOSOutfitAfterExpandInSavedMoments=By.xpath("//*[contains(@id,'outfit_S')]");

	public static By objiosRightArrowInShopePage=By.xpath("//*[@id='com.zee5.hipi:id/Arrow_1']");

	//MyntraSiteInHipi
	public static By objiosMyntraSiteInHipi=By.xpath("//*[@id='URL' and @label='Address' and @class='UIAView']");

	public static By objiosDoneButtonInMyntraSite=By.xpath("//*[@id='Done' and @class='UIAButton']");


	public static By objiOSOutfitSelectedTrueAfterExpandInSavedMoments=By.xpath("//*[contains(@id,'Outfit_Selected_True')]");


	public static By objiOSOutfitSelectedFalseAfterExpandInSavedMoments=By.xpath("//*[contains(@id,'Outfit_Selected_False')]");


	public static By objiOSAccessoriesSelectedTrueAfterExpandInSavedMoments=By.xpath("//*[contains(@id,'Accessories_Selected_True')]");

	public static By objiOSAccessoriesSelectedFalseAfterExpandInSavedMoments=By.xpath("//*[contains(@id,'accessories_Selected_False')]");


	public static By objiOSBeautySelectedTrueAfterExpandInSavedMoments=By.xpath("//*[contains(@id,'Beauty_Selected_True')]");

	public static By objiOSBeautySelectedFalseAfterExpandInSavedMoments=By.xpath("//*[contains(@id,'beauty_Selected_False')]");


	public static By objiOSHairSelectedTrueAfterExpandInSavedMoments=By.xpath("//*[contains(@id,'Hair_Selected_True')]");

	public static By objiOSHairSelectedFalseAfterExpandInSavedMoments=By.xpath("//*[contains(@id,'hair_Selected_False')]");



	//Shop Site In Shop Page
	public static By objiOSShopSiteNameExpandInSavedMoments(int index) {
		return By.xpath("(//*[contains(@id,'1_shop_site')])["+index+"]");
	}

	//Outfit Product Name
	public static By objiOSOutfitProductNameExpandInSavedMoments(int index) {
		return By.xpath("(//*[contains(@id,'outfit_topwear_"+index+"')])[1]");
	}

	//Accessories Product Name
	public static By objiOSAccessoriesProductNameExpandInSavedMoments(int index) {
		return By.xpath("(//*[contains(@id,'accessories_jewellery_"+index+"')])[1]");
	}

	//Beauty Product Name
	public static By objiOSBeautyProductNameExpandInSavedMoments(int index) {
		return By.xpath("(//*[contains(@id,'beauty_face_"+index+"')])[1]");
	}

	//Hair Product Name
	public static By objiOSHairProductNameExpandInSavedMoments(int index) {
		return By.xpath("(//*[contains(@id,'hair_hair_care_"+index+"')])[1]");
	}


	//Outfit Image
	public static By objiOSImageExpandInSavedMoments(int index) {
		return By.xpath("(//*[contains(@id,'outfit_')])["+index+"]/..");
	}

	//Accessories Image
	public static By objiOSAccessoriesImageExpandInSavedMoments(int index) {
		return By.xpath("//*[contains(@id,'accessories_jewellery_1')]/..");
	}

	//Beauty Image
	public static By objiOSBeautyImageExpandInSavedMoments(int index) {
		return By.xpath("//*[contains(@id,'beauty_face_"+index+"')]/..");
	}

	//Hair Image
	public static By objiOSHairImageExpandInSavedMoments(int index) {
		return By.xpath("//*[contains(@id,'hair_hair_care_"+index+"')]/..");
	}

	//Arrow Button
	public static By objiOSArrowExpandInSavedMoments(int index) {
		return By.xpath("(//*[@id='com.zee5.hipi:id/Arrow_"+index+"'])[1]");
	}

	public static By objiOSInThisVideoSelectedTrueInShoppage=By.xpath("//*[contains(@id,'IN_THIS_VIDEO_Selected')]");

	public static By objiOSSavedMomentsSelectedTrueInShoppage=By.xpath("//*[contains(@id,'SAVED_MOMENTS_Selected')]");

	public static By objiOSCrossIconInSmallVideo=By.xpath("//*[contains(@id,'close black')]");

	public static By objiOSTitleBesideLessOrExpandButtonInInThisVideo=By.xpath("//*[contains(@id,'Username_1')]");

	public static By objiOSProductNameBelowOutfitTabInShopPage=By.xpath("//*[contains(@id,'outfit_topwear_1')]/../../child::*[1]");

	public static By objiOSBannerNameInBeautyTab=By.xpath("//*[contains(@id,'Beauty_Banner_Name')]");

	public static By objiOSBannerDescriptionInBeautyTab=By.xpath("//*[contains(@id,'Beauty_Banner_Description')]");

	public static By objiOSBannerImageInBeautyTab=By.xpath("//*[contains(@id,'Beauty_Banner_Name')]/..");

	public static By objiOSBannerNameInHairTab=By.xpath("//*[contains(@id,'Hair_Banner_Name')]");

	public static By objiOSBannerDescriptionInHairTab=By.xpath("//*[contains(@id,'Hair_Banner_Description')]");








/*
   //Appium Server


	public static By objiosPullBarInShopPage= By.xpath("//XCUIElementTypeButton[contains(@name,'pull-bar')]");
	
	//Saved Moments In Save page
	public static By objiOSSavedMomentsInShopPage=By.xpath("//XCUIElementTypeStaticText[contains(@name,'SAVED_MOMENTS')]");
	public static By objiosSavedMomentsInShopPage= By.xpath("//XCUIElementTypeStaticText[contains(@name,'SAVED_MOMENTS')]");

	public static By objiosNoOfDeleteButtonsSavedMomentsInShopPage= By.xpath("//XCUIElementTypeButton[contains(@name,'SavedMomentsDeleteButton')]");

	//Cross Icon In Shop Page
	public static By objiOSCrossIconInShopPage=By.xpath("//XCUIElementTypeButton[@name='cbsdk close black']");
	public static By objiosCloseButtonInCarouselPage= By.xpath("//XCUIElementTypeButton[@name='cbsdk close black']");
	
	public static By objiOSCrossIconInSmallVideo=By.xpath("//XCUIElementTypeButton[@name='cbsdk close black']");

	
	public static By objiosNoOfDeleteButtons(int index) {
		return  By.xpath("(//XCUIElementTypeStaticText[@name='Delete'])["+index+"]");
	}
	
	//IN_THIS_VIDEO In Save Page
	public static By objiosInThisVideoInShopePage= By.xpath("//XCUIElementTypeStaticText[contains(@name='IN_THIS_VIDEO')]");
	public static By objiOSInThisVideoInShopPage=By.xpath("//XCUIElementTypeStaticText[contains(@name='IN_THIS_VIDEO')]");

	public static By objiOSOutfitAfterExpandInSavedMoments=By.xpath("//XCUIElementTypeStaticText[contains(@name,'outfit_S')]");

	public static By objiosRightArrowInShopePage=By.xpath("(//XCUIElementTypeButton[contains(@name,'Arrow_1')])[1]");

	//MyntraSiteInHipi
	public static By objiosMyntraSiteInHipi=By.xpath("//XCUIElementTypeButton[@name='URL']");

	public static By objiosDoneButtonInMyntraSite=By.xpath("//XCUIElementTypeButton[@name='Done']");

	public static By objiOSOutfitSelectedTrueAfterExpandInSavedMoments=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Outfit_Selected_True')]");

	public static By objiOSOutfitSelectedFalseAfterExpandInSavedMoments=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Outfit_Selected_False')]");


	public static By objiOSAccessoriesSelectedTrueAfterExpandInSavedMoments=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Accessories_Selected_True')]");

	public static By objiOSAccessoriesSelectedFalseAfterExpandInSavedMoments=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Accessories_Selected_False')]");


	public static By objiOSBeautySelectedTrueAfterExpandInSavedMoments=By.xpath("//XCUIElementTypeStaticText[contains(@name,'beauty_Selected_True')]");

	public static By objiOSBeautySelectedFalseAfterExpandInSavedMoments=By.xpath("//XCUIElementTypeStaticText[contains(@name,'beauty_Selected_False')]");


	public static By objiOSHairSelectedTrueAfterExpandInSavedMoments=By.xpath("//XCUIElementTypeStaticText[contains(@name,'hair_Selected_True')]");

	public static By objiOSHairSelectedFalseAfterExpandInSavedMoments=By.xpath("//XCUIElementTypeStaticText[contains(@name,'hair_Selected_False')]");

	public static By objiOSInThisVideoSelectedTrueInShoppage=By.xpath("//XCUIElementTypeStaticText[contains(@name,'IN_THIS_VIDEO_Selected')]");

	public static By objiOSSavedMomentsSelectedTrueInShoppage=By.xpath("//XCUIElementTypeStaticText[contains(@name,'SAVED_MOMENTS_Selected')]");

	//Shop Site In Shop Page
	public static By objiOSShopSiteNameExpandInSavedMoments(int index) {
		return By.xpath("(//XCUIElementTypeStaticText[contains(@name,'1_shop_site')])["+index+"]");
	}

	//Outfit Product Name
	public static By objiOSOutfitProductNameExpandInSavedMoments(int index) {
		return By.xpath("//XCUIElementTypeStaticText[contains(@name,'outfit_topwear_"+index+"')])[1]");
	}

	//Accessories Product Name
	public static By objiOSAccessoriesProductNameExpandInSavedMoments(int index) {
		return By.xpath("//XCUIElementTypeStaticText[contains(@name,'accessories_jewellery_"+index+"')])[1]");
	}

	//Beauty Product Name
	public static By objiOSBeautyProductNameExpandInSavedMoments(int index) {
		return By.xpath("(//XCUIElementTypeStaticText[contains(@name,'beauty_face_"+index+"')])[1]");
	}

	//Hair Product Name
	public static By objiOSHairProductNameExpandInSavedMoments(int index) {
		return By.xpath("(//XCUIElementTypeStaticText[contains(@name,'hair_hair_care_"+index+"')])[1]");
	}

	//Outfit Image
	public static By objiOSImageExpandInSavedMoments(int index) {
		return By.xpath("(//XCUIElementTypeStaticText[contains(@name,'outfit_')])["+index+"]/..");
	}

	//Accessories Image
	public static By objiOSAccessoriesImageExpandInSavedMoments(int index) {
		return By.xpath("//XCUIElementTypeStaticText[contains(@name,'accessories_jewellery_"+index+"')]/..");
	}

	//Beauty Image
	public static By objiOSBeautyImageExpandInSavedMoments(int index) {
		return By.xpath("//XCUIElementTypeStaticText[contains(@name,'beauty_face_"+index+"')]/..");
	}

	//Hair Image
	public static By objiOSHairImageExpandInSavedMoments(int index) {
		return By.xpath("(//XCUIElementTypeStaticText[contains(@name,'hair_hair_care_"+index+"')])/..");
	}

	//Arrow Button
	public static By objiOSArrowExpandInSavedMoments(int index) {
		return By.xpath("//XCUIElementTypeButton[contains(@name,'Arrow_"+index+"')])[1]");
	}

	public static By objiOSBannerNameInBeautyTab=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Beauty_Banner_Name')]");

	public static By objiOSBannerDescriptionInBeautyTab=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Beauty_Banner_Description')]");

	public static By objiOSBannerNameInHairTab=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Hair_Banner_Name')]");

	public static By objiOSBannerDescriptionInHairTab=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Hair_Banner_Description')]");
	
	public static By objiOSTitleBesideLessOrExpandButtonInInThisVideo=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Username_1')]");
	
	//You Can Buy Text In CarousalSheet
	public static By objiosProductsYouCanBuyTextInCarousalSheet= By.xpath("//XCUIElementTypeStaticText[contains(@name,'this look')]");

	//Product List In Shop Button
	public static By objiOSProductListInShopButton=By.xpath("//XCUIElementTypeStaticText[contains(@name,'this look')]");

	public static By objiosTotalNosBesideSavedMomentsInShopPage= By.xpath("//XCUIElementTypeStaticText[contains(@name,'SAVED_MOMENTS')]//following-sibling::*");

	public static By objiosTotalNosBesideInThisVideoTabShopPage= By.xpath("//XCUIElementTypeStaticText[contains(@name,'IN_THIS_VIDEO')]//following-sibling::*");

	public static By ExpandLessButtonInShopPage(String buttontype) {
		return By.xpath("//XCUIElementTypeButton[@name='"+buttontype+"']");
	}
	
	
	
	
	
	
	
	
	//public static By objiOSProductNameBelowOutfitTabInShopPage=By.xpath("//*[contains(@id,'outfit_topwear_1')]/../../child::*[1]");

//	public static By objiOSBannerImageInBeautyTab=By.xpath("//*[contains(@id,'Beauty_Banner_Name')]/..");

	
*/


}


