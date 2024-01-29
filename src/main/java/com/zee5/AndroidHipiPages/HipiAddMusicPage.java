package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiAddMusicPage {

	public static By objAddMusicTitle = By
			
			.xpath("//*[@resource-id='com.zee5.hipi:id/toolbar_text' and @text='Add Music']");

	public static By objFirstMusicFromAddMusicPage = By
			.xpath("(//*[@resource-id='com.zee5.hipi:id/music_name'])[3]");

	public static By objFirstMusicStarIconFromAddMusicPage = By.xpath(
			"(((((((//*[@resource-id='com.zee5.hipi:id/music_name'])[3])//parent::*//parent::*)//child::*)//child::*)[1])//child::*)[3]");

	public static By objSelectedMusic(String music) {
		return By.xpath("//*[@resource-id='com.zee5.hipi:id/select_music_name' and @text='" + music + "']");
	}

	public static By objPostAppliedMusic(String music) {
		return By.xpath("//*[@resource-id='com.zee5.hipi:id/musicName' and @text='" + music + "']");
	}

	public static By objMusicTrimRightHandle = By.xpath("(//*[contains(@resource-id,'rightHandle')])[2]");
	public static By objMusicTrimleftHandle = By.xpath("(//*[contains(@resource-id,'leftHandle')])[2]");


	public static By objMusicTrimEndTime = By.xpath("//*[contains(@resource-id,'select_music_time_end')]");

	public static By objMusicTrimFinishButton = By
			.xpath("//*[@resource-id='com.zee5.hipi:id/select_music_use_btn']");

	public static By objContinueShootPopup = By
			.xpath("//*[@resource-id='com.zee5.hipi:id/title_popup' and @text='Continue Shoot']");

	public static By objContinueShootPopupContinueButton = By
			.xpath("//*[@resource-id='com.zee5.hipi:id/btn_yes']");

	public static By objDiscardShootPopup = By
			.xpath("//*[@resource-id='com.zee5.hipi:id/title_popup' and @text='Discard Shoot']");

	public static By objDiscardShootPopupContinueButton = By.xpath("//*[contains(@resource-id,'btn_yes')]");

	public static By objAddSoundAlertPermissionPopup = By.xpath("//*[@id='msg_popup']");
	public static By objOkBtnInAddsoundPermissionPopup = By.xpath("//*[@id='btn_yes']");
	public static By objAddMusicTogglebtn = By.xpath("//*[@id='music_toggle']");
	public static By objBackBtnInAddMusic = By.xpath("//*[@id='backBtn']");
	public static By objEditsearch = By.xpath("//*[@id='editTextSearch']");
	public static By objClearSearch = By.xpath("//*[@id='img_clear']");
	public static By objSuggestedSearchResults = By.xpath("//*[@id='tv_auto_suggest']");
	public static By objTrendingRailInSearchScreen = By.xpath("//*[@id='tv_trending']");
	public static By objFirstSearchResult = By.xpath("(//*[@id='rl_car'])[1]");
	public static By objMusicName = By.xpath("//*[@id='music_name']");
	public static By objSelectMusicBtn = By.xpath("//*[@id='select_music_use_btn']");
	public static By objSelectedMusicInRecordingScreen = By.xpath("//*[@id='musicName']");
	public static By objSelectedMusicInRecordingScreen(String musicName){
		return By.xpath("//*[@id='musicName' and @text='"+musicName+"']");
	}
	public static By objAllowToAddMusic = By.xpath("//*[@id='permission_allow_foreground_only_button' or @id='permission_allow_button']");
	public static By objPreviewMusic = By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@id='select_music_name']]");
	public static By objSelectMusicPauseButton = By.xpath("//*[@id='select_music_pause_btn']");
	public static By objMusicListsinAddMusicScreen = By.xpath("(//*[@id='music_details'])[1]");
	public static By objReplaceMusicPromptMsg = By.xpath("//*[@id='title_popup' and @text='Replace Music']");
	public static By objMusicremoveIconInrecordingScreen = By.xpath("//*[@id='musicRemove']");
	public static By objYesButtonOnReplaceMusicPopup = By.xpath("//*[@id='btn_yes']");
	public static By objBackBtnInSearchScreen = By.xpath("//*[@id='img_back']");
	public static By objMusicListsInAddMusic = By.xpath("//*[@id='title']");
	public static By objTrendingRailInAddMusic = By.xpath("//*[@id='title' and @text='Trending Challenges']");
	public static By objMusicPlayIconOnTrendingRailMusic = By.xpath("(//*[@id='music_play_btn'])[1]");
	public static By objMusicTrimPopup = By.xpath("(//*[@id='main_layout']/*[@class='android.widget.ImageView'])[2]");
	public static By objFirstMusicInAddMusicScreen = By.xpath("(//*[@id='music_name'])[1]");
	public static By objTrimIconInVideoEditScreen = By.xpath("//*[@id='trimTextView']");
	public static By objTrimPopupTitle = By.xpath("//*[@id='bottomtitle']");
	public static By objTrimclosebtn = By.xpath("//*[@id='select_trim_close_btn']");
	public static By objStartTrimTime = By.xpath("//*[@id='select_music_time']");
	public static By objfifthmusicinAddmusic = By.xpath("(//*[@id='music_name'])[5]");
	public static By objMusicEndTime = By.xpath("//*[@id='select_music_time_end']");
	public static By objBackButtonInVideoEditScreen = By.xpath("//*[@id='close_btn']");
	public static By ObjMusicTime = By.xpath("//*[@id='music_time']");
	public static By obj15sVideoDuration = By.xpath("//*[@class='android.widget.TextView' and @text='15s']");

	public static By objMusicRailsTitle = By.xpath("//*[@id='title']");
	public static By objMusicnamelistsInAddMusic = By.xpath("//*[@id='music_name']");

	public static By objMusicUsedInVideo(String musicName){
		return By.xpath("//*[@id='songNameMTextView' and @text='"+musicName+"']");
	}
	
	public static By objPlayIconOnMusic = By.xpath("(//*[@id='music_play_btn' and @checked='false'])[1]");
	public static By objPauseIconOnMusic = By.xpath("(//*[@id='music_play_btn' and @checked='true'])[1]");
	
	public static By objSelectMusicCloseIcon = By.xpath("//*[@id='select_music_close_btn']");
	public static By objTrimPopup = By.xpath("//*[@id='bottomtitle' and @text='Trim']");
	
	public static By objMusicTrimRightHandle2 = By.xpath("(//*[@resource-id='com.zee5.hipi:id/rightHandle'])[2]");
	
	public static By objMusicTrimIndicatorLine = By.xpath("//*[@id='indicator_view']");
	
	public static By objMusicTrimLayout = By.xpath("((((//*[@id='rightHandle'])[2])//parent::*//parent::*)//child::*[3])[2]");
	
	
	
	
	
	
	
	
	
	
	
}
