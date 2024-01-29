package com.zee5.iOSHipiPages;

import org.openqa.selenium.By;

public class IOSHipiSoundPage {


	//Appium Studio


	public static By iosUseThisSound=By.xpath("//*[@knownSuperClass='UIButtonLabel' and @id='Use this sound']");


	//BackButtonFromSounddetailsPage
	public static By objiOSBackButtonFromSounddetailsPage=By.xpath("//*[contains(@id,'back_a')]");

	//CrossIconInPreviewSoundTab
	public static By objiOSCrossIconInPreviewSoundTab=By.xpath("//*[contains(@id,'cross')]");


	//Access popUp

	public static By objiOSMusicAccessPopUp=By.xpath("//*[contains(@id,' would like to access Apple Music')]");

	//OK Button
	public static By objiOSMusicAccessPopUpOKBtn=By.xpath("//*[contains(@id,'OK')]");

	//FavoritesTab
	public static By objiOSFavoritesTab=By.xpath("//*[contains(@id,'Favorites')]");

	//DiscoverTab
	public static By objiOSDiscoverTab=By.xpath("//*[contains(@id,'Discover')]");

	public static By objiOSAddToFavouriteInSoundScreen=By.xpath("//*[contains(@id,'btn_add_to_favourite_')]");

	public static By objiosPlaylistTextInSoundsScreen=By.xpath("//*[contains(@id,'playlist')]");

	public static By objiosHipiNightOutTextInSoundsScreen=By.xpath("//*[contains(@text,'#HipiNightOut')]");

	public static By objiosSeeAllButtonInSoundsScreen=By.xpath("(//*[@id='See all'])[1]");

	public static By objiosBannerScreenInSoundsScreen=By.xpath("//*[@class='UIAPageIndicator']");

	public static By objiosSecondAddToFavouriteInSoundsScreen=By.xpath("(//*[contains(@id,'com.zee5.hipi:id/btn_add_to_favourite_2')])[1]");

	public static By objiOSFirstSongNameInSoundScreen=By.xpath("//*[contains(@id,'sound_1_song_name')]");

	public static By objiOSAddedToFavouriteInSoundScreen=By.xpath("//*[contains(@id,'added_to_favourite')]");

	public static By objiOSFirstSongTitleInSoundScreen=By.xpath("//*[contains(@id,'Song_Title_1')]");

	public static By objiOSFirstSongArtistInSoundScreen=By.xpath("(//*[contains(@id,'Artist_1')])[1]");

	public static By objiOSSongDurationInSoundScreen=By.xpath("(//*[contains(@id,'songDuration_')])[1]");

	public static By objiOSSoundsTextInSoundScreen=By.xpath("//*[contains(@id,'Sounds')]");

	public static By objiOSFirstvideoInUseThisSounds=By.xpath("//*[contains(@id,'total_views_1')]");

	public static By SongTitle(String SongTitle) {
		return By.xpath("//*[contains(@text,'"+SongTitle+"')]");
	}

	public static By objiOSAllCategoriesInUseThisSounds=By.xpath("//*[contains(@id,'Playlist_12')]");







	/*
	//Appium Server

	//FavoritesTab
	public static By objiOSFavoritesTab=By.xpath("//XCUIElementTypeOther[@name='Favorites']");

	//DiscoverTab
	public static By objiOSDiscoverTab=By.xpath("//XCUIElementTypeOther[@name='Discover']");

	//Use This Sound
	public static By iosUseThisSound=By.xpath("//XCUIElementTypeButton[@name='Use this sound']");

	//BackButtonFromSounddetailsPage
	public static By objiOSBackButtonFromSounddetailsPage=By.xpath("//XCUIElementTypeButton[contains(@name,'back_arrow')]");

	//Access popUp
	public static By objiOSMusicAccessPopUp=By.xpath("//XCUIElementTypeStaticText[contains(@name,'would like to access Apple Music')]");

	//OK Button
	public static By objiOSMusicAccessPopUpOKBtn=By.xpath("//XCUIElementTypeButton[@name='OK']");

	public static By objiOSAddToFavouriteInSoundScreen=By.xpath("//XCUIElementTypeButton[contains(@name,'add_to_favourite_')]");

	public static By objiosPlaylistTextInSoundsScreen=By.xpath("//XCUIElementTypeStaticText[contains(@name,'playlist_')]");

	public static By objiOSAddedToFavouriteInSoundScreen=By.xpath("//XCUIElementTypeButton[contains(@name,'added_to_favourite')]");

	public static By objiOSFirstSongTitleInSoundScreen=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Song_Title_1')]");

	public static By objiOSFirstSongArtistInSoundScreen=By.xpath("(//XCUIElementTypeStaticText[contains(@name,'Song_Artist_1')])[1]");

	public static By objiOSSongDurationInSoundScreen=By.xpath("(//XCUIElementTypeStaticText[contains(@name,'songDuration')])[1]");

	public static By objiOSSoundsTextInSoundScreen=By.xpath("//XCUIElementTypeStaticText[@name='Sounds']");

	public static By objiOSAllCategoriesInUseThisSounds=By.xpath("//XCUIElementTypeStaticText[contains(@name,'Playlist_12')]");

	public static By SongTitle(String SongTitle) {
		return By.xpath("//XCUIElementTypeStaticText[@value='"+SongTitle+"']");
	}

	public static By objiosSeeAllButtonInSoundsScreen=By.xpath("(//XCUIElementTypeStaticText[@name='See all'])[1]");

	public static By objiosBannerScreenInSoundsScreen=By.xpath("//XCUIElementTypeScrollView[contains(@name,'Banner_')]");

	public static By objiosSecondAddToFavouriteInSoundsScreen=By.xpath("(//XCUIElementTypeButton[contains(@name,'add_to_favourite_2')])[1]");

	public static By objiOSFirstSongNameInSoundScreen=By.xpath("//XCUIElementTypeStaticText[contains(@name,'sound_1_song_name')]");

	public static By objiOSFirstvideoInUseThisSounds=By.xpath("//XCUIElementTypeStaticText[contains(@name,'total_views_count_1')]");

	//CrossIconInPreviewSoundTab
	public static By objiOSCrossIconInPreviewSoundTab=By.xpath("//XCUIElementTypeButton[@name='cross']");




	//public static By objiosHipiNightOutTextInSoundsScreen=By.xpath("//*[contains(@text,'#HipiNightOut')]");

	 */






}
