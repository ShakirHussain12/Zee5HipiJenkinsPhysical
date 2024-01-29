package com.zee5.iOSHipiPages;

import org.openqa.selenium.By;

public class IOSHipiCreateVideoPage {



	//--------------------------------------------new-------------------------------------------------------------			

	//Record Screen In Creator 

	//record button In Record Screen
	public static By iosRecordButon=By.xpath("//*[contains(@text,'record')]");

	//speed selected true CTA In Record Screen
	public static By objiosSpeedSeletedCTAInRecordScreen=By.xpath("//*[contains(@id,'Speed_Btn_Selected_true')]");

	//speed selected false In Record Screen
	public static By objiosSpeedNotSelectedCTAInRecordScreen=By.xpath("//*[contains(@id,'Speed_Btn_Selected_false')]");

	//speed selected false In Record Screen
	public static By objiosSpeedCTAInRecordScreen=By.xpath("//*[contains(@id,'Speed_Btn')]");

	//BeautyModeSelected  true In Record Screen
	public static By objiosBeautyModeSelected = By.xpath("//*[contains(@id,'Beauty_Btn_Selected_true')]");

	//BeautyMode Selected false In Record Screen
	public static By objiosBeautyModeCTA = By.xpath("//*[contains(@id,'Beauty_Btn_Selected_false')]");

	//Filter Button Selected false In Record Screen
	public static By objiosFilterButtonInVideoPage=By.xpath("//*[contains(@id,'Filter_')]");

	//Timer In Record Screen
	public static By objiosTimerInCreateVideo=By.xpath("//*[@id='cf_ic_timer']");

	//Flash Light In Record Screen
	public static By objFlashLightInCreatevideo=By.xpath("//*[contains(@id,'cf_ic_flash')]");

	// Create video speed 0.3x
	public static By objiosvideospeed0_3x = By.xpath("//*[contains(@id,'0.3x_')]");

	//Create video speed  0.3x selected
	public static By objiosvideospeed_0_3x_selected = By.xpath("//*[contains(@id,'Speed_0.3x_Btn_Selected_true')]");


	// Create video speed 0.5x
	public static By objiosvideospeed0_5x = By.xpath("//*[contains(@id,'0.5x_')]");

	//Create video speed  0.5x selected
	public static By objiosvideospeed_0_5x_selected = By.xpath("//*[contains(@id,'Speed_0.5x_Btn_Selected_true')]");

	// Create video speed 1x
	public static By objiosvideospeed_1x = By.xpath("//*[contains(@id,'1x_')]");

	//Create video speed 1x selected
	public static By objiosvideospeed_1x_selected = By.xpath("//*[contains(@id,'Speed_1x_Btn_Selected_true')]");

	//Create video speed 1x not selected
	public static By objiosvideospeed_1x_Notselected = By.xpath("//*[contains(@id,'Speed_1x_Btn_Selected_false')]");

	//Create video speed 2x selected
	public static By objiosvideospeed_2x_selected = By.xpath("//*[contains(@id,'Speed_2x_Btn_Selected_true')]");

	//Create video speed 2x not selected
	public static By objiosvideospeed_2x_Notselected = By.xpath("//*[contains(@id,'Speed_2x_Btn_Selected_false')]");

	// Create video speed 1.5x
	public static By objiosvideospeed1_5x = By.xpath("//*[contains(@id,'1.5x_')]");

	//Create video speed  1.5x selected
	public static By objiosvideospeed_1_5x_selected = By.xpath("//*[contains(@id,'Speed_1.5x_Btn_Selected_true')]");

	// Create video speed 2x
	public static By objiosvideospeed_2x = By.xpath("//*[contains(@id,'2x_')]");

	//SoundsInRecordScreen
	public static By objiosSoundsInRecordScreen = By.xpath("//*[contains(@id,'Sounds')]");

	//EffectCTAinRecordingScreen
	public static By objiosEffectCTAinRecordingScreen = By.xpath("//*[contains(@accessibilityLabel,'Effects')]");

	//Upload in Recording Screen
	public static By objUploadinRecordingScreen=By.xpath("//*[contains(@id,'gallery')]");

	//Close Icon In Creator Page
	public static By objCloseIconInCreatorPage=By.xpath("//*[contains(@id,'close')] |//*[contains(@id,'back')]");

	//SoundTitleInRecordScreen
	public static By objiosSoundTitleInRecordScreen = By.xpath("//*[@id='Nvback']//following-sibling::*[@knownSuperClass='UILabel']");

	//SoundBtnAfterRecording
	public static By objiosSoundBtnAfterRecording = By.xpath("//*[contains(@id,'NvSelectMusic')] | //*[contains(@id,'Sounds') and contains(@class,'utton')]");

	//Flash Light Pop Up
	public static By objFlashLightPopUpInCreateVideo=By.xpath("//*[contains(@id,'No Flash Detected')]");	

	//closeBtnInRecoedScreen
	public static By objioscloseBtnInRecoedScreen = By.xpath("//*[@id='com.zee5.hipi:id/closeButtonimg'] | //*[@id='Nvback']");

	//15secoinds for create video
	public static By objios15secondsInCreateVideo=By.xpath("//*[@class='UIAButton' and @id='15s']");

	//New Button
	public static By objiosNewTrendingInFilterScreen(String category) {
		return By.xpath("//*[contains(@id,'"+category+"')]");
	}

	//Category Selected
	public static By objiosCategorySelectedgInFilterScreen(String category) {
		return By.xpath("//*[contains(@id,'"+category+"')]//ancestor::*[contains(@id,'Selected_true')]");
	}
	//*[contains(@id,'"+category+"')]//ancestor::*[contains(@id,'Selected_true')]

	//Category not  Selected
	public static By objiosCategoryNotSelectedgInFilterScreen(String category) {
		return By.xpath("//*[contains(@id,'"+category+"')]//ancestor::*[contains(@id,'Selected_false')]");
	}

	//EffectsScreen
	public static By objiosEffectsScreenInRecording = By.xpath("//*[contains(@id,'Selected')]//*[@id='Trending']");

	//Upload select video
	public static By objiosSelectVideo=By.xpath("//*[contains(@id,'Select Video')]");

	//Upload back button
	public static By objiosbackbuttoninselectvideo=By.xpath("//*[contains(@id,'back')]");

	//visible the song in create video page
	public static By objiosSongVisibleInCreateVideo=By.xpath("//*[@id='Nvback']//preceding-sibling::*[1]");

	//Cross icon in Recording screen
	public static By objiosCrossIconInVideoRecordingScreen=By.xpath("//*[contains(@id,'back')]");		

	//Edit the video
	public static By objiosEditTheVideo=By.xpath("(//*[contains(@id,'Edit this video')])[1]");




	// Sound Screen In Creator

	//SearchPlaceholder
	public static By objiosSearchPlaceholder = By.xpath("//*[contains(@placeholder,'Search for sounds')] | //*[contains(@placeholder,'Search')]");


	//SearchInSounds
	public static By objiosSearchFieldInSounds = By.xpath("//*[contains(@id,'edit')]");

	//Sounds Songs page Back Button
	public static By objSoundsSongspageBackButton=By.xpath("//*[contains(@id,'back')]");

	//Back Button In Create video
	public static By objiosBackButtonInvideoPage=By.xpath("//*[@class='UIAButton' and @id='ic back arrow']");

	//Keyboard Search Btn In creator
	public static By objiosSearchBtnInSounds = By.xpath("//*[contains(text(),'search')]");

	//Sounds Page 
	public static By objSoundsSongsListInCreateVideoPage=By.xpath("//*[@id='Sounds' and @class='UIAStaticText'] |//*[@id='NvSelectMusic' and @class='UIAButton']//following-sibling::*[@knownSuperClass='UILabel']");	

	//cross Icon In Recent Search Songs Page
	public static By objiosCrossIconSearchSongsPage=By.xpath("(//*[contains(@id,'close')])[1] | //*[contains(@text,'Nvback')]");

	//replace the song
	public static By objiosReplaceSong=By.xpath("//*[contains(@id,'Replace sound ?')]");

	//yes the replace the song
	public static By objiosYesTheReplaceTheSong=By.xpath("(//*[@id='YES'])[1]");

	//No In Replace Song popup
	public static By objiosNoInReplaceSong=By.xpath("(//*[@id='NO'])[1]");

	//play music
	public static By objiosPlayMusicInCreateVideo=By.xpath("(//*[contains(@id,'btn_trending_play')])[1]");

	//pause music
	public static By objiosPauseMusicInCreateVideo=By.xpath("(//*[contains(@id,'btn_trending_pause')])[1]");

	//play music
	public static By objiosPlayButtonInSoundsScreen=By.xpath("(//*[contains(@id,'btn_trending_play')])[1]");

	//Trim icon
	public static By objTrimIconinVideoEditScreen=By.xpath("//*[contains(@id,'sound_trim')]");



	//Trim left thumb
	public static By objTrimLeftThumb=By.xpath("//*[contains(@id,'Trimmer_Left_thumb')]");

	//Trim left thumb
	public static By objTrimRightThumb=By.xpath("//*[contains(@id,'Trimmer_Right_thumb')]");

	//Trim Timer Left
	public static By objiosTrimTimerAtLeft=By.xpath("(//*[contains(@id,'Trimmer_Right_thumb')]//preceding-sibling::*[@XCElementType='XCUIElementTypeStaticText'])[1]");

	//Trim Timer Right
	public static By objiosTrimTimerAtRight=By.xpath("(//*[contains(@id,'Trimmer_Right_thumb')]//following-sibling::*[@XCElementType='XCUIElementTypeStaticText'])[1]");

	//Trim Box
	public static By objiosTrimmerBox=By.xpath("//*[@id='audiotrimmerthumb']//following-sibling::*//*[@class='UIAView']");

	public static By objiosSuggestedRecordsInSearchScreen=By.xpath("//*[@accessibilityLabel='com.zee5.hipi:id/suggestion_1']");

	public static By objiosSearchPlaceHolderInSearchScreen=By.xpath("//*[contains(@placeholder,'Search for sounds')] | //*[contains(@placeholder,'Search')]");	

	//Play Button in video edit screen
	public static By objiosPlayPauseBtnInVideoEditScreen=By.xpath("//*[contains(@id,'video play')]");



	//Cross Icon In Edit Video
	public static By objiosCrossIconInEditVideo=By.xpath("//*[contains(@id,'cross')]");

	//Tick Icon In Edit Video
	public static By objiosTickIconInEditVideo=By.xpath("//*[contains(@id,'ick')]");

	//Sound Text In Sounds Screen				
	public static By objiosSoundTitleInSoundsScreen=By.xpath("//*[@id='Sounds' and @XCElementType='XCUIElementTypeStaticText']");				


	//Trim_frame1 in edit screen
	public static By objiosTrim_frame1=By.xpath("//*[contains(@id,'Trimmer_Frame_1')]");

	//Trim_frame2 in edit screen
	public static By objiosTrim_frame2=By.xpath("//*[contains(@id,'Trimmer_Frame_2')]");




	// After record Screen In Creator(Next Btn)


	//Next btn after record
	public static By iosNextBtnAfterrecord=By.xpath("//*[contains(@id,'Next')]");

	//tickMarkInSoundSeletion
	public static By objiostickMarkInSoundSeletion = By.xpath("(//*[@id='Done'])[2]");

	//BackBtnFromRecordingScreen
	public static By objiosBackBtnFromRecordingScreen = By.xpath("//*[contains(@id,'back')]");

	//DiscardEdit
	public static By objiosDiscardEditInRecordingScreen = By.xpath("(//*[contains(@id,'DISCARD EDITS')])[2]");

	//Discard Edits button in discard edits popup
	public static By objDiscardEditsButtonInDiscardEditsPopUp=By.xpath("(//*[contains(@id,'DISCARD EDITS')])[1]");

	//cross icon in Recording Screen
	public static By objCrossIconInRecordingScreen=By.xpath("(//*[contains(@id,'close')] |//*[contains(@id,'Nvback')])[1]");

	//volume in edit screen
	public static By objiosVolumeInEditScreen=By.xpath("//*[contains(@accessibilityLabel,'Volume_')]");

	public static By objiosAdjustVolumeInCreatorPage=By.xpath("//*[@class='UIASlider']");

	//Discard your edits popup text
	public static By objDiscardYourEditsPopUpText=By.xpath("//*[contains(@id,'Discard your edits?')]");

	//Keep button in discard edits popup
	public static By objKeepButtonInDiscardEditsPopUp=By.xpath("//*[contains(@id,'KEEP')]");

	//Next Button in video edit
	public static By objiosNextButtoninVideoEdit=By.xpath("(//*[@id='Next'])[1]");

	//Drag the selectors Text In Trim Screen
	public static By objiosTrimTheSongs=By.xpath("//*[@id='Done']//following-sibling::*[3]");

	//Tick the trim
	public static By objiosTickTheTrim=By.xpath("(//*[@id='Done'])[2]");

	//check the volume in Volume Screen
	public static By objiosCheckVolumeInVideoEditScreen=By.xpath("//*[@id='Nvcheck']");

	//Voume adjust screen
	public static By objiosVoulmeAdjustScreenInCreateVideo=By.xpath("//*[@id='Nvcheck']");



	//Trim music in trim pop up
	public static By objTrimMusicInTrimPopUp=By.xpath("(//*[@id='TRIM MUSIC'])[2]");

	//stickers in video edit screen
	public static By objiosstickersInVideoEditScreen=By.xpath("//*[contains(@id,'NvEmoji')]");

	//keepe the edits
	public static By objiosKeepYourEdits=By.xpath("(//*[contains(@id,'KEEP')])[1]");

	//cancel the song
	public static By objioscancelthesonginvideoeditscreen=By.xpath("//*[contains(@id,'Nvback')]");

	//cross icon in selected music
	public static By objiosCrossIconInSelectedMusic=By.xpath("(//*[@id='Nvback'])[2]");

	//Trending Music
	public static By objiosTrendingMusic=By.xpath("//*[@id='Trending']");

	//Back arrow in sticker screen
	public static By objiosBackArrowInStickerScreen=By.xpath("//*[contains(@id,'back arrow')]");

	//plus icon in adding text/sticker
	public static By objiosPlusIconInVideoEditingScreenInstickersAndAddText=By.xpath("//*[contains(@id,'NvAddCaptionButton')]");

	//Back Arrow In Edit screen
	public static By objiosBackArrowInVideoEditingScreen=By.xpath("//*[contains(@id,'back')]");






	// Post Screen In Creator

	// Save To Device Enable Toggle Button (To See the Save To Device Button in Enable)
	public static By objSaveToDeviceEnableToggleButtonInPostPage=By.xpath("(//*[@id='Save to device'])[2]");

	// Save To Device  Disable Toggle Button (To See the Save To Device Button in disable)
	public static By objSaveToDeviceDisableToggleButtonInPostPage=By.xpath("//*[contains(@id,'Save_toggle_Button_selected_False')]");

	// Allow Sharing Enable Toggle Button (To See the Save To Device Button in Enable)
	public static By objAllowSharingEnableToggleButtonInPostPage=By.xpath("(//*[@id='Allow Duet'])[2]");

	// Save To Device  Disable Toggle Button (To See the Save To Device Button in disable)
	public static By objAllowSharingDisableToggleButtonInPostPage=By.xpath("//*[contains(@id,'Allow_Duet_toggle_Button_selected_False')]");	

	//Allow Likes Enable In Toggle Button In Post Page
	public static By objAllowLikesEnableInToggleButtonInPostPage=By.xpath("(//*[@id='Allow Likes'])[2]");

	//Disable Likes Enable In Toggle Button In Post Page
	public static By objAllowLikesDisableInToggleButtonInPostPage=By.xpath("//*[contains(@id,'Allow_Likes_toggle_Button_selected_False')]");


	//Post btn after recording
	public static By iosPostBtnAfterRec0rdng=By.xpath("//*[@id='Post' and @knownSuperClass='UIButton']");

	//WhoCanViewThisvideo
	public static By objiosWhoCanViewThisvideoRecording = By.xpath("(//*[@text='Who can view this video']//parent::*/child::*[@knownSuperClass='UILabel'])[2]");

	public static By objiosWhoCanViewThisVideoSelectedOptionInPostScreen=By.xpath("//*[@id='Who can view this video']//following-sibling::*[1]");

	public static By objiosWhoCanViewThisVideoButtonInPostScreen=By.xpath("//*[@id='Who can view this video']");

	//Save as Draft button in post page
	public static By objSaveAsDraftButton=By.xpath("//*[contains(@id,'Save as Draft')]");

	public static By PostScreenEnabledToggleButtons(String togglename) {
		return By.xpath("//*[contains(@id,'"+togglename+"_toggle_Button_selected_True')]");
	}
	public static By PostScreenDisabledToggleButtons(String togglename) {
		return By.xpath("//*[contains(@id,'"+togglename+"_toggle_Button_selected_False')]");
	}

	public static By WhoCanViewThisVideoScreenAllOptions(String type) {
		return By.xpath("//*[@id='"+type+"']");
	}

	// Description Box in post screen 
	public static By objDescriptionBoxInPostPage=By.xpath("//*[contains(@id,'commentBox')]");

	//Post Video Btn 
	public static By objiosPostVideoInPostPage=By.xpath("//*[contains(@id,'Post') and contains(@class,'Button')]");


	//Post Page Text 
	public static By objiosPostVideoPage=By.xpath("(//*[@id='Post' and @class='UIAStaticText'])[1]");



	//Video posted sucessfully toast msg
	public static By objiosVideoPostedSucessfully=By.xpath("//*[contains(@id,'Uploading')]|(//*[@id='Progress'])[2]");

	//Description In Post page
	public static By objDescriptionInVideoPostPage=By.xpath("//*[contains(@id,'Describe your video')]");

	//Keyboard Done btn 
	public static By objDoneTheDescriptionInVideoPostPage=By.xpath("//*[contains(@id,'Done')]");

	//Add description to your video
	public static By iosAddDescriptiontoyourvideo=By.xpath("(//*[@id='#Hashtags']//preceding-sibling::*)[1]");

	//Draft video successful toast msg
	public static By objiosDraftToastMsg=By.xpath("//*[contains(text(),'draft!')]");

	//video saved as draft
	public static By objiosSavedAsDraft=By.xpath("//*[contains(text(),'draft!')]");

	//comment section
	public static By objioscommentsection=By.xpath("//*[contains(@id,'commentBox')]");	

	//HashTag In video posting screen
	public static By objiosHastagInPostingScreen=By.xpath("(//*[@id='#Hashtags'])[1]");

	//Cover photo in video created Screen
	public static By objCoverPhotoInViedoCreatedScreen=By.xpath("//*[@class='UIAImage'and @knownSuperClass='UIImageView']");

	//  first user in'Invite friends' Screen in post page 
	public static By objFirstUserInInviteFriendsScreenInPostPage=By.xpath("(//*[contains(@id,'commentBox')]//following::*//*[@class='UIATable']//child::*[contains(text(),'@')])[1]");







	//PopUp after clicking on Creator

	//camera popup
	public static By objiosCameraPopup=By.xpath("(//*[contains(@id,'Camera')])[1]");

	//Allow acees of camera and microphone ok button
	public static By objiosOkInAllowPopup=By.xpath("//*[@id='OK']");

	//Don't Allow
	public static By objiosDontAllowPopup=By.xpath("//*[@id='Don’t Allow']");

	//microphone phone
	public static By objiosMicrophone=By.xpath("(//*[contains(@id,'Microphone')])[1]");

	//allow reqried permission
	public static By objiosAllowPermission=By.xpath("//*[@id='You need to allow all required permissions']");

	//ok permission
	public static By objiosOkPermission=By.xpath("//*[@id='Ok']");

	//Login To Hipi PopUp In CreateButton
	public static By objLoginToHipiPopUpInCreateButton=By.xpath("//*[@id='Login in to Hipi']");

	//Microphone Enabled
	public static By objiosMicrophoneEnabled=By.xpath("//*[@id='Microphone' and @enabled='true']");

	//upload Btn popup
	public static By objiosVideoUpoloadpoup=By.xpath("//*[@id='Only videos can be uploaded. The photos can not be uploaded at this time']");

	//upload Btn popup
	public static By objiosOkAllowvideoUpload=By.xpath("//*[@id='OK']");

	//Allow to access your photo
	public static By objiosAllowAcessToYourPhotos=By.xpath("(//*[@id='“hipi” Would Like to Access Your Photos'])[2]");//		

	//Allow Acesss Photos
	public static By objiosAllowAcessPhotos=By.xpath("//*[@id='Allow Access to All Photos']");




	//Publishing in process
	public static By objiosPublishingInProcessMessage=By.xpath("//*[contains(@id,'Publishing in process')]");












	//FirstSearchedSound---changed-------------08-03-2022
	public static By objiosFirstSearchedSound(String sound) {
		return By.xpath("(//*[contains(@id,'song_name') and contains(@text,'"+sound+"')])[1]");
		//*[contains(@id,'song_name') and contains(@text,'Chandigarh Mein')])[1]
	}
	//(//*[contains(@accessibilityLabel,'song_name') and contains(@text,'Chandigarh Mein')])[1]

	//buttons in edit screen----changed-------------08-03-2022
	public static By videoCreationScreenIcons(String type) {
		return By.xpath("//*[contains(@accessibilityLabel,'"+type+"')]");//timer
	}
	////*[contains(@accessibilityLabel,'Beauty')]


	//buttons in edit screen----changed-------------08-03-2022
	public static By filtersTypes(String filtertype) {
		return By.xpath("//*[contains(@id,'"+filtertype+"')]");
	}
	//*[contains(@id,'New')]

	public static By objiosPrivateVideos(int index) {
		return By.xpath("(//*[contains(@id,'VideoCreated')])["+index+"]");
	}


	public static By objiosSeletytabInProfilePage(String tab) {
		return By.xpath("//*[contains(@id,'profile tab "+tab+"')]");
	}

	//download effects
	public static By objiosDownloadBtnForEffectsPresent(int index){
		return By.xpath("(//*[@text='NvNodownloadButton'])["+index+"]");
	}
	//first block in effect screen
	public static By objiosEffectInEffectsScreen(int index){
		return By.xpath("//*[contains(@id,'assetCover"+index+"')]");
	}

	public static By objiosListOfDownloadedFilters=By.xpath("//*[contains(@value,'com.zee5.hipi:id/download_button')]");

	public static By objiosDownloadedFilters(int index){
		return By.xpath("(//*[contains(@value,'com.zee5.hipi:id/download_button')])["+index+"]");
	}

	//(//*[contains(@value,'com.zee5.hipi:id/download_button')])[2]
	public static By objiosTotalFiltersUnderAcategory=By.xpath("//*[@accessibilityLabel='com.zee5.hipi:id/download_button']");

	public static By objiosFiltersUnderAcategory(int index){
		return By.xpath("(//*[@accessibilityLabel='com.zee5.hipi:id/download_button'])["+index+"]");
	}

	public static By objiosFiltersNotDownloadedUnderAcategory(int index){
		return By.xpath("(//*[contains(@value,'NvNodownloadButton')])["+index+"]");
	}


	//record time below record button---changed-------------08-03-2022
	public static By objiosCreationTimesInBelowRecordingBtn(String time) {
		return By.xpath("//*[contains(@accessibilityLabel,'com.zee5.hipi:id/Duration_"+time+"')]");
	}

	public static By objiosTimerInBelowRecordingBtnSelectedTrue(String time) {
		return By.xpath("//*[contains(@id,'Duration_"+time+"_Btn_Selected_true')]");

	}
	public static By objiosTimerInBelowRecordingBtnSelectedFalse(String time) {
		return By.xpath("//*[contains(@id,'Duration_"+time+"_Btn_Selected_false')]");

	}


	//timer above record button---changed-------------08-03-2022
	public static By objiosTimerInAboveRecordingBtn(String time) {
		return By.xpath("//*[contains(@accessibilityLabel,'Timer_"+time+"')]");

	}
	public static By objiosTimerInAboveRecordingBtnSelectedTrue(String time) {
		return By.xpath("//*[contains(@id,'"+time+"_Btn_Selected_true')]");

	}
	public static By objiosTimerInAboveRecordingBtnSelectedFalse(String time) {
		return By.xpath("//*[contains(@id,'"+time+"_Btn_Selected_false')]");

	}

	public static By objiosTimerCloseIcon=By.xpath("//*[contains(@id,'record timer close')]");


	//*[contains(@accessibilityLabel,'Timer_10s')]

	//first video in draft screen
	public static By objiosBlockOfDraftVideo(int index){
		return By.xpath("(//*[contains(text(),'Drafts are')]//following-sibling::*//*[@class='UIAView'])["+index+"]");
	}

	//Timer Seconds---changed-------------08-03-2022
	public static By TimerSeconds(String Timersecond) {
		return By.xpath("//*[contains(@accessibilityLabel,'Timer_"+Timersecond+"')]");//timer in timericon
	}





	//s===========================================================================   
	//search music
	public static By objsearchedmusicInCreateVideo=By.xpath("(//*[contains(@accessibilityLabel,'song_name')])[1]");

	//Sounds play music
	public static By objiosPlayMusicInsounds=By.xpath("(//*[contains(@accessibilityLabel,'lbl_song_name')])[1] | (//*[contains(@id,'Song_Title')])[1]");//(//*[contains(@id,'btn_trending_play')])[1]

	//sound 2
	public static By objiosPlaymusicSound2=By.xpath("(//*[contains(@id,'Trending_song')])[3]");   

	public static By objiosRecoredInSearchScreen=By.xpath("(//*[contains(@accessibilityLabel,'lbl_song_name')])[1]");

	//play music random
	public static By objiosPlayMusicRandom=By.xpath("(//*[contains(@id,'song_name')])[1]");

	//first video selecteds
	public static By objiosFirstVideoSelected=By.xpath("(//*[contains(text(),'0')])[1]");

	//Slider In Edit Video
	public static By objiosSliderInEditVideo=By.xpath("//*[@id='NvTailoringLeft' and @class='UIAImage']");




	//None In Sticker Screen
	public static By objiosNoneInStickerScreeen=By.xpath("//*[@id='NvCaptionOutlineNone']");

	//Filter Screen
	public static By objiosFilterScreen=By.xpath("//*[@id='block']");

	//Effect In Trending
	public static By objEffectInTrending=By.xpath("(//*[contains(@accessibilityLabel,'Effects')])[1]");


	//first video in draft screen
	public static By objEffectInTrending(int index){
		return By.xpath("(//*[contains(@accessibilityLabel,'Effects')])["+index+"]");
	}		


	public static By SelfieCameraSelected=By.xpath("//*[@accessibilityLabel='com.zee5.hipi:id/Flip_Btn_Front_camera_Selected_true']");			

	public static By RearCameraSelected=By.xpath("//*[@accessibilityLabel='com.zee5.hipi:id/Flip_Btn_Rear_camera_Selected_true']");			


	public static By FlashLightDisabled=By.xpath("//*[@accessibilityLabel='com.zee5.hipi:id/Flash_Btn_Front_camera_Disabled']");

	public static By DownloadBtnOnFiltersOrEffects(int index) {
		return By.xpath("(//*[contains(@id,'download_button')])["+index+"]");
	}

	public static By DownloadedFilterOrEffets(int index) {
		return  By.xpath("(//*[contains(@value,'download_button')])["+index+"]");
	}
	public static By FiltersSelectedTrue=By.xpath("//*[contains(@id,'Filter_Item_Selected_true')]");

	public static By EffectsSelectedTrue=By.xpath("//*[contains(@id,'Effects_Item_Selected_true')]");

	public static By objiosrecordbtnSelected=By.xpath("//*[contains(@id,'Shooting_Btn_Selected_true')]");

	public static By objiosrecordbtnNotSelected=By.xpath("//*[contains(@id,'Shooting_Btn_Selected_false')]");

	public static By objiosTotalSeekBarTopofScreen=By.xpath("//*[contains(@id,'Total_video_seekBar')]");


	public static By objiosSeekBarTopofScreen(String tab) {
		return By.xpath("//*[contains(@id,'video_seekBar_"+tab+"')]");
	}

	public static By objiosNoOfSeekBarsSegmentsAtTopOfScreen=By.xpath("//*[contains(@id,'video_seekBar_')]");

	public static By objiosOnRecTimeAtBottomofScreen=By.xpath("//*[contains(@id,'Recording_Status_Btn_On_record_time')]");


	public static By objiosClipSegmentDeleteButtonAtBottomofScreen=By.xpath("(//*[contains(@text,'record')]//following::*[contains(@class,'Button')])[1]");

	//Voume adjust screen
	public static By objiosVoulme_Percentage_InEditVideoScreen=By.xpath("//*[contains(@id,'volume_Percentage')]");

	public static By objiosClearButtonInEditScreen=By.xpath("//*[contains(@id,'Clear_Btn')]");

	public static By objiosClearButtonSelectedFalseInEditScreen=By.xpath("//*[contains(@id,'Clear_Btn_Selected_false')]");

	public static By objiosClearButtonSelectedTrueInEditScreen=By.xpath("//*[@id='block']");



	public static By objios15secondsSelectedTrueInCreateVideo=By.xpath("//*[contains(@id,'15s_Btn_Selected_true')]");

	public static By objiosDoneButtonInKeyBoard=By.xpath("//*[@id='Done']");

	public static By objiosTextIconInEditScreen=By.xpath("//*[contains(@id,'Text_Selected_false')]");

	public static By objiosStickerIconInEditScreen=By.xpath("//*[contains(@id,'Sticker')]");

	public static By objiosDoneButtonInTextScreen=By.xpath("//*[@id='Done']");

	public static By objiosPlayButtonInTextScreen=By.xpath("//*[contains(@id,'Playback')]");

	public static By objiosTrimOptionInEditScreen=By.xpath("//*[@id='NvPlayback']/..");

	public static By objiosPlusIconInEditScreen=By.xpath("//*[contains(@id,'AddCaptionButton')]");

	public static By objiosTextOnMiddleInEditScreen=By.xpath("//*[contains(@id,'text_On_Screen')]");

	public static By objiosStickerItem1InEditScreen=By.xpath("//*[contains(@id,'Sticker_Item_1_Selected_false')]");

	public static By objiosStickerItem1SelectedTrueInEditScreen=By.xpath("//*[contains(@id,'Sticker_Item_1_Selected_true')]");


	public static By objiosAllowCommentsToggleButtonInPostScreen=By.xpath("//*[@id='Allow Comments'][2]");

	public static By objiosLoadingPercentageInSaveAsDraft=By.xpath("//*[contains(text(),'%')]");	


	public static By Suggested(String name) {
		return By.xpath("(//*[contains(@text,'"+name+"')])[2]");

	}


	public static By objiosSongTitleInSoundScreen=By.xpath("(//*[contains(@id,'Song_Title_1')])[1]");

	//Sounds play music
	public static By objios2PlayMusicInsounds=By.xpath("(//*[contains(@accessibilityLabel,'lbl_song_name')])[1] | (//*[contains(@id,'Song_Title')])[3]");


	//Allow Comment Enable Toggle Button (To See the Save To Device Button in Enable)
	public static By objAllowCommentEnableToggleButtonInPostPage=By.xpath("(//*[@id='Allow Comments'])[2]");


	//railname
	public static By objSoundRailname(int index) {
		return By.xpath("(//*[contains(@id,'_railname')])["+index+"]");
	}

	public static By objLastsongInRail(String railname) {
		return By.xpath("//*[contains(@id,'"+railname+"_12')]");
	}


	public static By objRequireSongTitle=By.xpath("(//*[@id='com.zee5.hipi:id/Song_Title_3'])[2]");


	public static By objSongTitle(int index) {
		return By.xpath("//*[contains(@id,'Song_Title_"+index+"')]");
	}

	public static By objAddToFavBtn(int index,int index1) {
		return By.xpath("(//*[contains(@id,'add_to_favourite_"+index+"')])["+index1+"]");
	}

	public static By objSongTraySeeAllBtn(int index) {

		return By.xpath("(//*[@id='See all'])["+index+"]");
	}

	public static By objiosSongsInsideSoundTray=By.xpath("//*[contains(@id,'song_name')]");

	public static By objiosFavoriteTabPopUp=By.xpath("(//*[contains(@id,'your music and video activity')])[1]");
	
	public static By objiosPostVideoTextInPostScreen=By.xpath("(//*[@id='Post Video'])[2]");


}
