package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiSoundDetailPage {

	public static By objFavIcon =By.xpath("//*[@id='addmusic_fav']");
	
	public static By objPlayIcon =By.xpath("//*[@id='music_play_btn']");
	
	public static By objDuration =By.xpath("//*[@id='duration']");
	
	public static By objTitle =By.xpath("//*[@id='musicTitle']");
	
	public static By objImage =By.xpath("//*[@id='image_view']");
	
	public static By objShareIcon =By.xpath("(//*[@class='android.widget.ImageButton'])[1]");
	
	public static By objCreatorImage =By.xpath("//*[@id='creator_icon']");
	
	public static By objCreatorName =By.xpath("//*[@id='authorName']");

	public static By objVideoCount =By.xpath("//*[@id='videoCount']");

	public static By objListOfVideos =By.xpath("//*[@id='detail']");

	public static By objOriginalSound =By.xpath("//*[@id='songNameMTextView']");
	
	public static By objLoginOrRegisterPopUp =By.xpath("//*[@id='title_registerforVibe']");
	
	public static By objFacebook = By.xpath("//*[@text='News Feed' or @text='Facebook']");

	public static By objHipiSoundSharePopUp = By.xpath("//*[@text='HiPi Sound']");
	
	public static By objFacebookPost = By.xpath("//*[@text='POST' or @text='Post' or @text='Share' or @text='SHARE']");

	public static By objUseThisSoundBtn = By.xpath("//*[@text and ./parent::*[@id='createVideo']]");
	
	public static By objVideoThumbnail =By.xpath("(//*[@id='thumbnail'])[1]");
	
	public static By objForYou =By.xpath("//*[@id='forYou']");
	
	public static By objNoData = By.xpath("//*[@id='txt_no_data_found']");
	
	public static By objSoundDetailScreen = By.xpath("//*[contains(@resource-id,'head_layout')]");

	public static By objAddMusicButton = By.xpath("//*[contains(@resource-id,'music_toggle')]");

	public static By objSearchTextBox = By.xpath("//*[contains(@resource-id,'editTextSearch')]");

	public static By objBeautifulYouSong = By.xpath("//*[@text='Beautiful You' and @class='android.widget.TextView']");

	public static By objClickBeautifulYouSong = By.xpath("//*[contains(@resource-id,'music_name')]");

	public static By objClickPostTick = By.xpath("//*[contains(@resource-id,'select_music_use_btn')]");

	public static By objBackIcon = By.xpath("//*[contains(@resource-id,'backView')]");

	public static By objSoundThumbnail = By.xpath("//*[contains(@resource-id,'music_play_btn')]");

	public static By objSoundDescription = By.xpath("//*[contains(@resource-id,'musicTitle')]");

	public static By objAddToFavouriteIconText = By.xpath("//*[@text='Add to Favourites']");

	public static By objListOfVideosCreated = By.xpath("//*[contains(@resource-id,'videoCount')]");

	public static By objVerifyAllVideos= By.xpath("//*[contains(@resource-id,'swiperefresh')]");

	public static By objVerifyVideo= By.xpath("//*[contains(@resource-id,'thumbnail')]");

	public static By objReplaceMusicPopUp= By.xpath("//*[contains(@resource-id,'title_popup')]");
		//Replace music PopUp Click on YES Button
		public static By objReplaceMusicYesButton= By.xpath("//*[contains(@resource-id,'btn_yes')]");

		

		   public static By objTrimFinishIcon = By.xpath("//*[@id='trimFinish']");
			public static By objVolumeIconOnVideoeditScreen = By.xpath("//*[@id='volumeButton']");
			public static By objAdjustVolumePopup = By.xpath("//*[@id='bottomtitle' and @text='Adjust Volume']");
			public static By objMicrophoneEnabled = By.xpath("//*[@id='videoVoiceSeekBarValue']");
			public static By objMicrophoneDisabled = By.xpath("//*[@id='videoVoiceSeekBarValue' and @text='0']");
			public static By objMusicSeekbarValue = By.xpath("//*[@id='musicVoiceSeekBarValue']");
			public static By objmusicvolumebar = By.xpath("//*[@id='mTextView']");
			public static By objMusicSeekBar = By.xpath("//*[@id='musicVoiceSeekBar']");
			public static By objFinishAdjustVolume =  By.xpath("//*[@id='finish']");
			public static By objMicrophoneVolumeValue = By.xpath("//*[@id='videoVoiceSeekBarValue']");
			public static By objMicrophoneSeekbar = By.xpath("//*[@id='videoVoiceSeekBar']");
			
			public static By objMicrophoneMaxValue = By.xpath("//*[@resource-id='com.zee5.hipi:id/videoVoiceSeekBarValue']");
			public static By objMicrophoneMinValue = By.xpath("//*[@id='videoVoiceSeekBarValue']");

//==================================================Kartheek===============================================
			//music Title
			public static By objMusicTitle = By.xpath("//*[@resource-id='com.zee5.hipi:id/musicTitle']");
			//Back Arrow
			public static By objBackArrow = By.xpath("//*[@resource-id='com.zee5.hipi:id/back_image'] | //*[@resource-id='com.zee5.hipi:id/imgBack']");
			
			
		//Added To Favorite	
			public static By objAddedToFavorite	 = By.xpath("//*[@text='Added to Favourite']");
			
			public static By objPlayIconEnable= By.xpath("//*[@resource-id='com.zee5.hipi:id/music_play_btn' and @checked='true']");
			//Add To Favorite With Out Text
			public static By objAddToFavoriteWithOutText= By.xpath("//*[@resource-id='com.zee5.hipi:id/soundAddFav']");
			
			//User Name Sound Page
			public static By objUserNameSoundPage= By.xpath("//*[@resource-id='com.zee5.hipi:id/authorName']");


			//==================================Muthu kumaran M================
			//Sound Text
			public static By objsoundtext=By.xpath("//*[@resource-id='com.zee5.hipi:id/toolbar_text']");
			//Search For Sounds
			public static By objsearchforsound=By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");		
			
			
			
			//Back Icon
			//Search For Sounds
			public static By objBackArrowIconSoundDeailesPage=By.xpath("//*[@resource-id='com.zee5.hipi:id/imgBack']");		
			
			
			//view count
			public static By objNoOFViewCount=By.xpath("//*[@id='txtPlayCount']");
			
			
			

}
