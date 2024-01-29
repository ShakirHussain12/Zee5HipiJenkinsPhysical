package com.zee5.iOSHipiPages;

import org.openqa.selenium.By;

public class IOSHipiNeoHashTagPage {

	//Appium Studio

	//back button from hashtag page
	public static By objiOSbackButtonFromHashtagPageInHashTagPage=By.xpath("//*[contains(@id,'back')]");

	//HashTag
	public static By objiOSUsernameInHashTagPage=By.xpath("//*[contains(text(),'#') and @knownSuperClass='UILabel']");

	//network error
	public static By objiOSNetworkErrorInHashTagPage=By.xpath("//*[@id='Netwrok Error' and @class='UIAStaticText']");

	//network error Symbol
	public static By objiOSNetworkErrorSymbolInHashTagPage=By.xpath("//*[@id='ic_no_network1' and @knownSuperClass='UIImageView']");


	//Saved Moments
	public static By objiOSSavedMomentsInHashTagPage=By.xpath("//*[@id='SAVED MOMENTS' and @knownSuperClass='UILabel']");



	public static By HashtagDetailsPageVideo(int index){
		return By.xpath("(//*[contains(@id,'Hashtag_video_')])["+index+"]");
	}


	
	
	
	
	
/*
	//Appium Server

	//back button from hashtag page
	public static By objiOSbackButtonFromHashtagPageInHashTagPage=By.xpath("//XCUIElementTypeButton[contains(@name,'back')]");

	//HashTag
	public static By objiOSUsernameInHashTagPage=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Hashtag_title')]");

	//network error
	public static By objiOSNetworkErrorInHashTagPage=By.xpath("//*[@name='Netwrok Error']");

	//network error Symbol
	public static By objiOSNetworkErrorSymbolInHashTagPage=By.xpath("//*[@name='ic_no_network1']");


	public static By HashtagDetailsPageVideo(int index){
		return By.xpath("(//XCUIElementTypeOther[contains(@name,'Hashtag_video_')])["+index+"]");
	}
	
	//Saved Moments
	//public static By objiOSSavedMomentsInHashTagPage=By.xpath("//*[@id='SAVED MOMENTS' and @knownSuperClass='UILabel']");

	
*/
	
}
