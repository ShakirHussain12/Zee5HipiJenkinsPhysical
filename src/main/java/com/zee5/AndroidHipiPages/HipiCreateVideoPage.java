package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiCreateVideoPage {

	// create video
	public static By objcreatevideo = By.xpath("//*[contains(@resource-id,'createvideoimage')]");// *[contains(@resource-id,'createvideoimage']
	// record btn
	public static By objrecordbtn = By.xpath("//*[@id='record_btn']");

	public static By objrecordDeletebtn = By.xpath("//*[@id='delete']");
	
	public static By objrecordDeleteYesbtn = By.xpath("//*[@id='btn_yes']");
	
	public static By objFinishButton = By.xpath("//*[@class='android.widget.TextView' and @text='Finish']");

	public static By objAddMusicPostRecording = By
			.xpath("//*[contains(@resource-id,'musicImageView') and @text='m']");

	// recording
	public static By objrecording = By.xpath("//*[contains(@resource-id,'record_btn')]");
	// post
	public static By objpost = By.xpath("//*[@id='finishImageView']");

	public static By objPostDescription = By.xpath("//*[contains(@resource-id,'commentBox')]");
	// genreofvideo
	public static By objgenrevideo = By.xpath("//*[@class='android.widget.TextView' and @text='Fashion']");
	// title
	public static By objtitle = By.xpath("//*[contains(@resource-id,'pv_title')]");
	// language selection
	public static By objselectlang = By.xpath("//*[contains(@resource-id,'addLanguagelabel')]");
	// back button
	public static By objbackbutton = By.xpath("//*[contains(@resource-id,'backImage')]");
	// englishlang
	public static By objlanguage = By.xpath("//*[@class='android.widget.TextView' and @text='English']");
	// terms and conditions
	public static By objterms = By.xpath("//*[contains(@resource-id,'termsTextView')]");
	// checkbox
	public static By objcheckbox = By.xpath("//*[contains(@resource-id,'checkterms')]");
	// draft
	public static By objdraft = By.xpath("//*[@id='btn_save_draft']");
	// savedraft
	public static By objsavedraft = By.xpath("//*[contains(@resource-id,'btn_save_draft')]");
	// uploadpost
	public static By objuploadpost = By.xpath("//*[contains(@resource-id,'uploadPost')]");
	// popupsuccess
	public static By objsuccess = By.xpath("//*[@id='tv_title']");
	// okbutton
	public static By objokbtn = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	// finish
	public static By objfinish = By.xpath("//*[contains(@resource-id,'finishtext')]");
	// videodraft
	// public static By objdraftvideo=By.xpath("//*[@id='videoimg' and
	// (./preceding-sibling::* |
	// ./following-sibling::*)[@class='android.widget.LinearLayout' and
	// ./*[@text]]]");
	// uploadvideo
	public static By objuploadvideo = By.xpath("//*[contains(@resource-id,'gallery_video_button')]");// *[contains(@resource-id,'textupload']
	// popup
	public static By objpopup = By.xpath("//*[@id='tv_title']");

	public static By objSaveDraftPopup = By.xpath("//*[@id='tv_title']");
	// draftvideo
	public static By objdraftvideo = By
			.xpath("//*[@id='videoimg' and (./preceding-sibling::* | ./following-sibling::*)[@id='main_progress']]");
	// selecttitlehipi
	public static By objselect = By.xpath("//*[contains(@resource-id,'text_center')]");
	// image
	public static By objselectFirstimage = By.xpath("(//*[contains(@resource-id,'iv_item_image')])[1]");
	// xpath(“//android.widget.Button[@text=’5′ and @index=’1′]”)
	// xpath(“//android.widget.LinearLayout[@index=’1′]/android.widget.Button[@index=’1′]”)

	public static By objSelectHiPiTitle = By.xpath("//*[@text='Select HiPiT']");
	// EditHipiit
	public static By objEditHipiit = By.xpath("//*[@class='android.widget.TextView' and @text='Edit this HiPiT']");
	// trimvideo
	public static By objtrimvideo = By.xpath("//*[@class='android.widget.TextView' and @text='Trim Video']");
	// trimfinish
	public static By objtrimfinish = By.xpath("//*[contains(@resource-id,'trimFinish')]");
	// draftimage
	public static By objdraftiamge = By
			.xpath("//*[@id='videoimg' and (./preceding-sibling::* | ./following-sibling::*)[@id='main_progress']]");
	// allow button
	public static By objallowbtn = By.xpath("//*[@id='permission_allow_foreground_only_button']");
	// deny button
	public static By objdenybutton = By.xpath("//*[@text='DENY' or @text='Deny']");
	// takepictures
	public static By objaccesspictures = By.xpath("//*[@id='permission_message']");
	// allowbutton
	public static By objpicallowbtn = By.xpath("//*[@text='ALLOW' or @text='Allow' or @text='WHILE USING THE APP' or @text='While using the app']");
	// permission
	public static By objpermission = By.xpath("//*[@id='permission_message']");
	// permission allow
	public static By objpermissionallow = By.xpath("//*[@text='ALLOW' or @text='Allow' or @text='WHILE USING THE APP' or @text='While using the app']");
	// audiorecord
	public static By objrecordpermission = By.xpath("//*[@id='permission_message']");
	// audioallow
	public static By objrecordallow = By.xpath("//*[@text='ALLOW' or @text='Allow' or @text='WHILE USING THE APP' or @text='While using the app']");
	// readypopup
	public static By objreadypopup = By.xpath("//*[contains(@resource-id,'title_popup')]");
	// readyok
	public static By objreadyokbtn = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	// posthipi
	public static By objposthipi = By.xpath("//*[contains(@resource-id,'uploadPost')]");
	// allimage
	public static By objall = By.xpath("//*[@class='android.widget.TextView' and @text='All']");
	public static By objDraftTab = By.xpath("//*[@class='android.widget.TextView' and @text='Draft']");
	// image slectin me
	public static By objselectfirstimage = By.xpath("(//*[contains(@resource-id,'videoimg')])[1]");

	public static By objPublishedVideo = By.xpath("(//*[contains(@resource-id,'desc')])[1]");

	public static By objSelectVideo(String videoText) {
		return By.xpath("(//*[contains(@resource-id,'desc') and @text='" + videoText + "'])[1]");
	}
	// video screen discription  
		public static By objVideoScreenDisc= By.xpath("//*[@id='text_view_video_description']");
	public static By objSelectDraftVideo(String text) {
		return By.xpath("(//*[contains(@resource-id,'desc') and @text='" + text + "'])[1]");
	}

	public static By objVideo(String videoText) {
		return By.xpath("(//*[contains(@resource-id,'desc') and @text='" + videoText + "in'])[1]");
	}

	// effects
	// public static By objeffect=By.xpath("//*[@class='android.widget.TextView'
	// and @text='Effects']");
	public static By objeffect = By.xpath("//*[@id='effect_button_img']");
	// favourite effect
	public static By objeffectfavourite = By.xpath("//*[@class='android.widget.TextView' and @text='Cyber Helmet ']");
	// download
	public static By objdownload = By.id("com.zee5.hipi:id/download");
	// closebuttoneffect
	public static By objcloseeffect = By.xpath("//*[contains(@resource-id,'closeButtonimg')]");
	// create video back btn
	public static By objbackbuttoncreate = By.xpath("//*[contains(@resource-id,'backImage')]");
	// addtofavourite
	public static By objaddtofavourite = By.id("com.zee5.hipi:id/title_popup");
	// yesfavouroite
	public static By objfavouriteyes = By.id("com.zee5.hipi:id/btn_yes");
	// no
	public static By objfavouriteno = By.xpath("//*[contains(@resource-id,'btn_no')]");
	// staricon
	public static By objstaricon = By.id("com.zee5.hipi:id/cart_badge");
	// favourites
	public static By objfavourites = By.id("com.zee5.hipi:id/filterfav");// *[contains(@resource-id,'filterfav'])
	// favouritecyber
	public static By objfavouritescyber = By.xpath("//*[@class='android.widget.TextView' and @text='Cyber Helmet ']");
	// backinvideo
	public static By objbackviewinvideo = By.id("com.zee5.hipi:id/backImage");
	// backviewinfeed
	public static By objbackviewinfeed = By.id("com.zee5.hipi:id/backView");
	// backviewinme
	public static By objbackviewinme = By.id("com.zee5.hipi:id/imgBack");

	public static By objAddMusicButton = By
			.xpath("//*[contains(@resource-id,'music_toggle') and @selected='false']");

	public static By objAddMusicButtonHiglighted = By
			.xpath("//*[contains(@resource-id,'music_toggle') and @selected='true']");


	public static By objFlashLight = By.xpath("//*[@id='flashButton' and @checked='false']");
	public static By objFlashLightEnabled = By.xpath("//*[@id='flashButton' and @checked='true']");

	public static By objCameraFlip = By.xpath("//*[@id='flipButton' and @checked='false']");
	public static By objCameraFlipEnabled = By.xpath("//*[@id='flipButton' and @checked='true']");


	// filter
	public static By objfilter = By.xpath("(//*[@id='operation_layout']/*/*[@id='toggle_image'])[3]");
	public static By objHighlightedFiltericon = By
			.xpath("//*[contains(@resource-id,'filter_toggle') and @checked='true']");
	// firsteffectbeforedownload
	public static By objfirstfilterbeforedownlload = By
			.xpath("(//*[contains(@resource-id,'transparent')])[1]");
	// firsteffectbeforedownloadbutton
	public static By objfirstfilterbeforedownloadbutton = By
			.xpath("((((//*[contains(@resource-id,'assetName')])[1])//parent::*)//child::*)[3]");
	// firsteffectafterdownload
	public static By objfirstfilterafterdownloadfinish = By
			.xpath("(//*[@resource-id='com.zee5.hipi:id/assetCover'])[1]");
	// secondeffectbeforedownload
	public static By objsecondfilterbeforedownload = By
			.xpath("(//*[contains(@resource-id,'transparent')])[1]");
	// secondfilterbeforedownloadbutton
	public static By objsecondfilterbeforedownloadbutton = By
			.xpath("((((//*[contains(@resource-id,'assetName')])[2])//parent::*)//child::*)[3]");
	// secondfilterafterdownload
	public static By objsecondfilterafterdownload = By
			.xpath("(//*[contains(@resource-id,'assetCover')])[2]");
	// closefilter
	public static By objclosefilter = By.xpath("//*[contains(@resource-id,'closeButtonimg')]");
	// backbutton
	public static By objbackbuttoneffectused = By.xpath("//*[contains(@resource-id,'backView')]");
	// filterused 
	public static By objfilterused = By.xpath("//*[contains(@resource-id,'usedFilter')]");
	// filtername
	public static By objfiltername = By.xpath("//*[contains(@resource-id,'assetName')][1]");
	// recentfilter
	public static By objrecentfilter = By.xpath("//*[contains(@resource-id,'filterrecent')]");
	// recentfiltername
	public static By objrecentfiltername = By.xpath("//*[contains(@resource-id,'assetName')][1]");

	public static By objalltab = By.xpath("//*[contains(@resource-id,'filterall')]");
	// firsteffectafterdownload
	public static By objfirsteffectafterdownload = By
			.xpath("(//*[contains(@resource-id,'assetCover')])[1]");
	// secondeffectafterdownload
	public static By objsecondeffectafterdownload = By
			.xpath("(//*[contains(@resource-id,'assetCover')])[2]");
	// secondeffectfavourite
	public static By objsecodeffectfavourite = By
			.xpath("((((//*[contains(@resource-id,'assetName')])[3])//parent::*)//child::*)[2]");

	public static By objsecodeffectfavouriteText = By
			.xpath("((((//*[contains(@resource-id,'assetName')])[3])//parent::*)//child::*)[3]");

	// favourite
	public static By objfavouritetab = By.xpath("//*[contains(@resource-id,'filterfav')]");

	// favouriteeffect
	public static By objeffectafterfavourite = By
			.xpath("//*[contains(@resource-id,'assetName') and @text='Cyber Helmet ']");

	public static By objeffectafterfavouriting(String favouriteEffect) {
		return By.xpath("//*[contains(@resource-id,'assetName') and @text='" + favouriteEffect + "']");
	}

	// removepopup
	public static By objtitlepopup = By.xpath("//*[contains(@resource-id,'title_popup')]");
	// yesremovepopup
	public static By objyesemovepopup = By.xpath("//*[contains(@resource-id,'btn_yes')]");

	// effects
	public static By objeffectsbutton = By.xpath("//*[contains(@resource-id,'effect_button_img')]");
	public static By objfirstEffectBeforDownloadButton = By
			.xpath("((((//*[contains(@resource-id,'assetName')])[2])//parent::*)//child::*)[3]");

	public static By objEffectDownloadIconBeforeDownloading = By
			.xpath("((((//*[contains(@resource-id,'transparent')])[1])//parent::*)//child::*)[3]");
	public static By objEffectNameBeforeDownloading = By
			.xpath("((((//*[contains(@resource-id,'transparent')])[1])//parent::*)//child::*)[5]");

	public static By objfirsteffectdownload = By.xpath("(//*[contains(@resource-id,'transparent')])[1]");
	public static By objfirsteffectAfterDownload = By
			.xpath("((//*[contains(@resource-id,'assetName')])[2])");

	public static By objSelectingEffectAfterDownloading(String effectname) {
		return By.xpath("(//*[contains(@resource-id,'assetName') and @text='" + effectname + "'])");
	}

	public static By objHighlightedEffectIcon = By
			.xpath("//*[contains(@resource-id,'effect_button_img') and @checked='true']");

	public static By objeffectDownloadProgressBar = By
			.xpath("(//*[contains(@resource-id,'downloadProgressBar')])[1]");

	// recent
	public static By objrecenttab = By.xpath("//*[contains(@resource-id,'filterrecent')]");

	public static By objNoRecentEffects = By.xpath("//*[@id='tvRecentError']");
	// recenteffect
	public static By objrecenteffect = By
			.xpath("//*[contains(@resource-id,'assetName') and @text='Cool Glasses']");

	public static By objRecentEffectUsed(String recentEffect) {
		return By.xpath("//*[contains(@resource-id,'assetName') and @text='" + recentEffect + "']");
	}

	public static By objRecentlyUsedFirstEffect = By.xpath("(//*[contains(@resource-id,'assetName')])[2]");

	// effectcoolglasses
	public static By objeffectcool = By
			.xpath("//*[contains(@resource-id,'assetName') and @text='Cool Glasses']");

	public static By objdownloadbuttonofeffect2 = By
			.xpath("((((//*[contains(@resource-id,'assetName')])[3])//parent::*)//child::*)[3]");

	// deletevideo
	public static By objdeleteclip = By.xpath("//*[contains(@resource-id,'delete')]");
	// deleteyes
	public static By objdeleteyes = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	// deletepopup
	public static By objdeletepopup = By.xpath("//*[contains(@resource-id,'title_popup')]");
	// alerttitle
	public static By objalertdeletetitle = By.xpath("//*[contains(@resource-id,'alert_title')]");

	// back button in video
	public static By objbackbuttoninvideo = By.xpath("//*[contains(@resource-id,'backView')]");

	public static By objCreateButton = By.xpath("//*[@id='createvideoimage']");
	public static By objCreatePermissionVideo = By.xpath("//*[@id='permission_message']");
	public static By objCreateAllow = By.xpath("//*[@id='permission_allow_foreground_only_button' or @id='permission_allow_button']");
	public static By objCreateDeny = By.xpath("//*[@id='permission_deny_button']");
	public static By objCreatePermissiondevice = By
			.xpath("//*[@id='permission_message']");
	public static By objCreatePermissionRecordAudio = By.xpath("//*[@id='permission_message']");
	public static By objCreatePermissionRecordAudioyes = By
			.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_allow_button']");
	public static By objCreateReadyDialog = By.xpath("//*[@id='msg_popup']");
	public static By objCreateReadyYes = By.xpath("//*[@id='btn_yes']");
	public static By objCreateVideoFlip = By.xpath("//*[contains(@resource-id,'flipButton')] | //*[contains(@text,'Flip')]");
	public static By objCreateVideoFlipEnabled = By
			.xpath("//*[contains(@resource-id,'flipButton') and @checked='true']");

	public static By objCreateVideoFlash = By.xpath("//*[contains(@resource-id,'flashButton')] | //*[contains(@text,'Flash')]");
	public static By objCreateVideoFlashEnabled = By
			.xpath("//*[contains(@resource-id,'flashButton') and @checked='true']");

	public static By objCreateVideoSpeedButton = By.xpath("(//*[@id='operation_layout']/*/*[@id='toggle_image'])[1]");
	public static By objsuper_slow_speed_btn = By
			.xpath("//*[contains(@resource-id,'super_slow_speed_btn')]");
	public static By objslow_speed_btn = By.xpath("//*[contains(@resource-id,'slow_speed_btn')]");
	public static By objfast_speed_btn = By.xpath("//*[contains(@resource-id,'fast_speed_btn')]");
	public static By objsuper_fast_speed_btn = By
			.xpath("//*[contains(@resource-id,'super_fast_speed_btn')]");
	public static By objstandard_speed_btn = By.xpath("//*[contains(@resource-id,'standard_speed_btn')]");

	public static By objMusicBtn = By.xpath("//*[contains(@resource-id,'music_toggle')]");

	public static By objtimerbtn = By.xpath("(//*[@id='operation_layout']/*/*[@id='toggle_image'])[4]");
	public static By objtimerbtn_timer_3s = By.xpath("//*[contains(@resource-id,'btn_timer_3s')]");
	public static By objtimerbtn_timer_5s = By.xpath("//*[contains(@resource-id,'btn_timer_5s')]");
	public static By objtimerbtn_timer_10s = By.xpath("//*[contains(@resource-id,'btn_timer_10s')]");
	//create video Timer 15s 	
			public static By objTimerFifteenSeconds=By.xpath("//*[@id='btn_timer_15s']");	
		//create video Timer 20s 	
			public static By objTimerTwentySeconds=By.xpath("//*[@id='btn_timer_20s']");
	public static By objtimerbtntimer3senabled = By
			.xpath("//*[contains(@resource-id,'btn_timer_3s') and @checked='true']");
	public static By objtimerbtn_timer_5senabled = By
			.xpath("//*[contains(@resource-id,'btn_timer_5s') and @checked='true']");
	public static By objtimerbtn_timer_10senabled = By
			.xpath("//*[contains(@resource-id,'btn_timer_10s') and @checked='true']");

	public static By objbeautybtn = By.xpath("(//*[@id='operation_layout']/*/*[@id='toggle_image'])[2]");
	public static By objbeautybtnenabled = By
			.xpath("//*[contains(@resource-id,'beauty_toggle') and @checked='true']");
	public static By objbeautybtndisabled = By
			.xpath("//*[contains(@resource-id,'beauty_toggle') and @checked='false']");

	public static By objDefaultSelectedTime = By.xpath("((//*[@id='tabsNew'])//child::*//*[@selected='true'])[2]");

	// public static By
	// objrecordbtn=By.xpath("//*[contains(@resource-id,'record_btn']");
	public static By objbeautytoggle = By.xpath("(//*[@id='operation_layout']/*/*[@id='toggle_image'])[2]");
	// public static By
	// objfilter=By.xpath("//*[contains(@resource-id,'filter_toggle']");
	public static By objfiltertobeDownloadavailable = By
			.xpath("(//*[contains(@resource-id,'download')])[1]");// check
	public static By objfilterUse = By.xpath("(//*[contains(@resource-id,'assetCover')])[1]");
	public static By objfilterImgClear = By.xpath("//*[contains(@resource-id,'img_clear')]");
	public static By objfilterrecent = By.xpath("//*[contains(@resource-id,'filterrecent')]");
	public static By objfilterrecentdata = By.xpath("(//*[contains(@resource-id,'assetCover')])[1]");

	// public static By
	// objeffect=By.xpath("//*[contains(@resource-id,'effect_button_img']");
	public static By objeffectDownload = By
			.xpath("(//*[@id='recycler']/*/*[@id='download'])[1]");
	public static By objeffectuse = By
			.xpath("//*[contains(@resource-id,'assetName') and @text='Cool Glasses']");
	public static By objEffectUsed = By
			.xpath("//*[contains(@resource-id,'filter_toggle') and @checked='false']");
	public static By objEffectImgClear = By.xpath("//*[contains(@resource-id,'clearImage')]");
	public static By objEffectCleared = By
			.xpath("//*[contains(@resource-id,'filter_toggle') and @checked='true']");
	public static By objEffectrecent = By.xpath("//*[contains(@resource-id,'filterrecent')]");
	public static By objeffectrecentdata = By.xpath("//*[contains(@resource-id,'tvRecentError')]");

	public static By objaddmusiceditbtn = By.xpath("//*[contains(@resource-id,'musicImageView')]");
	public static By objaddmusicpage = By.xpath("//*[@text='Add Music']");
	public static By objmusictobeadded = By.xpath("(//*[contains(@resource-id,'music_name')])[3]");
	public static By objmusictobeadded1 = By.xpath("(//*[contains(@resource-id,'music_name')])[4]");
	public static By objmusicplaypause = By.xpath("//*[contains(@resource-id,'select_music_pause_btn')]");
	public static By objmusicdialogavailable = By.xpath("//*[contains(@resource-id,'select_music_name')]");
	public static By objlefthandle = By.xpath("//*[contains(@resource-id,'leftHandle')]");
	public static By objindicator = By.xpath("//*[contains(@resource-id,'indicator_view')]");
	public static By objmusicusebtn = By.xpath("//*[contains(@resource-id,'select_music_use_btn')]");
	public static By objmusicavailable = By.xpath("//*[contains(@resource-id,'musicName')]");
	public static By objremove = By.xpath("//*[contains(@resource-id,'musicRemove')]");

	public static By objdefaultvideotime = By
			.xpath("//*[contains(@resource-id,'recordTime') and @text='0:15']");

	public static By objdefaultRecordTime = By.xpath("//*[@text and ./parent::*[@contentDescription='30s']and @selected='true']");
	public static By objactualRecoredTime = By.xpath("//*[@id='recordTime']");

	public static By objrecordclipcontinueshootdialog = By.xpath("//*[contains(@resource-id,'msg_popup')]");
	public static By objeditpagecontinuebtn = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	public static By objvideoprogressbar = By.xpath("//*[@text='15s' and @enabled='true']");

	public static By objaddmusicbtn = By.xpath("//*[@id='musicTextView']");
	public static By objmusic = By.xpath("(//*[contains(@resource-id,'music_name')])[3]");
	public static By objpausebtn = By.xpath("//*[contains(@resource-id,'select_music_pause_btn')]");
	public static By objselectmusicbtn = By.xpath("//*[contains(@resource-id,'select_music_use_btn')]");
	public static By objmusicadded = By.xpath("//*[contains(@resource-id,'musicName')]");

	public static By objvideodeletebtn = By.xpath("//*[contains(@resource-id,'delete')]");
	public static By objvideodeletedialog = By.xpath("//*[contains(@resource-id,'title_popup')]");
	public static By objdeletevideoyesbtn = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	public static By objclipgotdeletedalert = By.xpath("//*[@id='alert_title']");

	public static By objPostbutton = By.xpath("//*[contains(@resource-id,'finishImageView')]");
	public static By objposthipiTpage = By
			.xpath("//*[contains(@resource-id,'pv_title') and @text='Post HiPiT']");
	public static By objadddescription = By.xpath("//*[contains(@resource-id,'commentBox')]");
	public static By objadddescriptioncount = By.xpath("//*[contains(@resource-id,'commentBox')]");
	public static By objcoverphotorecordedvideo = By
			.xpath("//*[contains(@resource-id,'live_window') and @enabled='true']");
	public static By objtredinghashtagvailable = By
			.xpath("//*[contains(@resource-id,'tv_auto_suggest') and @text='Trending Hashtags']");
	public static By objhashtagname = By.xpath("(//*[contains(@resource-id,'hashtag_name')])[1]");
	public static By objtredinghashtagviews = By.xpath("(//*[contains(@resource-id,'views')])[1]");
	public static By objadddescriptionboxhavehashtagclicked = By
			.xpath("//*[contains(@resource-id,'commentBox')]");
	public static By objvisibilitymodebutton = By.xpath("//*[contains(@resource-id,'visibleMode')]");
	public static By objvisibilitymodepublicbutton = By.xpath("//*[@text='Public']");
	public static By objvisibilitymodefolloweronlybutton = By.xpath("//*[@text='Followers-Only']");
	public static By objvisibilitymodemebutton = By.xpath("//*[@text='Me']");
	public static By objadvancedsettingsbutton = By.xpath("//*[contains(@resource-id,'advTextView')]");

	public static By objallowcommentbar = By.xpath("//*[contains(@resource-id,'commentswitch')]");
	public static By objallowcommentsenabledbar = By
			.xpath("//*[contains(@resource-id,'commentswitch') and @checked='true']");
	public static By objallowcommentsdisabledbar = By
			.xpath("//*[contains(@resource-id,'commentswitch') and @checked='false']");

	public static By objallowlikedislikebar = By.xpath("//*[contains(@resource-id,'likeswitch')]");
	public static By objallowlikedislikeenabledbar = By
			.xpath("//*[contains(@resource-id,'likeswitch') and @checked='true']");
	public static By objallowlikedislikedisabledbar = By
			.xpath("//*[contains(@resource-id,'likeswitch') and @checked='false']");

	public static By objallowsharingbar = By.xpath("//*[contains(@resource-id,'shareswitch')]");
	public static By objallowsharingenabledbar = By
			.xpath("//*[contains(@resource-id,'shareswitch') and @checked='true']");
	public static By objallowsharingdisabledbar = By
			.xpath("//*[contains(@resource-id,'shareswitch') and @checked='false']");

	public static By objallowvideodownloadbar = By.xpath("//*[contains(@resource-id,'downloadswitch')]");
	public static By objallowvideodownloadenabledbar = By
			.xpath("//*[contains(@resource-id,'downloadswitch') and @checked='true']");
	public static By objallowvideodownloaddisabledbar = By
			.xpath("//*[contains(@resource-id,'downloadswitch') and @checked='false']");

	public static By objlanguageforyourvideolabel = By
			.xpath("//*[contains(@resource-id,'addLanguagelabel')]");
	public static By objlanguageclickedenglish = By.xpath("//*[@text='English']");

	public static By objgenreclick = By.xpath("(//*[contains(@resource-id,'language_chip_text')])[1]");
	public static By objsaveasdraft = By.xpath("//*[contains(@resource-id,'btn_save_draft')]");
	public static By objsavedasdraftdialog = By.xpath("//*[@id='tv_title']");
	public static By objsavedasdraftokbtn = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	public static By objtcheckbox = By.xpath("//*[contains(@resource-id,'checkterms')]");
	public static By objpostbtn = By.xpath("//*[contains(@resource-id,'uploadPost')]");
	public static By objvideouploadeddialog = By
			.xpath("//*[contains(@resource-id,'msg_popup') and @text='Your Video Uploaded Successfully!']");
	public static By objvideouploadedokbtn = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	public static By objbtniconclear = By.xpath("//*[@id='icon' and ./parent::*[@id='key_pos_del']]");
	public static By objbtnicontogonextline = By.xpath(
			"//*[@class='android.widget.FrameLayout' and ./parent::*[@id='key_pos_ime_action'] and ./*[@id='icon']]");

	public static By objtrim = By.xpath("//*[contains(@resource-id,'trimImageView')]");
	public static By objtrimdialog = By.xpath("//*[contains(@resource-id,'bottomtitle') and @text='Trim']");
	public static By objtrimlefthandle = By.xpath("//*[contains(@resource-id,'leftHandle')]");
	public static By objtrimrighthandle = By.xpath("//*[contains(@resource-id,'rightHandle')]");
	public static By objtrimvideohandle = By.xpath("(//*[@class='android.widget.ImageView' and @index='5'])[1]");
	public static By objtrimvideofinishbtn = By.xpath("//*[contains(@resource-id,'trimFinish')]");
	public static By objtrimvideocontinuebtn = By
			.xpath("//*[contains(@resource-id,'btn_yes') and @text='Continue']");
	public static By objdialogwannatrimchanges = By
			.xpath("//*[contains(@resource-id,'msg_popup') and @text='Wanna apply trim changes?']");

	// ---------------------------------------------------------------------------------------------------------

	// saveAsDraft
	public static By objPostHipiTPageHeader = By
			.xpath("//*[contains(@resource-id,'pv_title') and @text='Post HiPiT']");
	public static By objBack = By.xpath("//*[contains(@resource-id,'backImage')]");
	public static By objadddescriptionlimit = By
			.xpath("//*[contains(@resource-id,'textinput_counter') and @text='0/200']");
	public static By objlanguageofyourvideolabel = By.xpath("//*[@text='Select the language of your video']");
	public static By objenglish = By.xpath("//*[@text='English']");
	public static By objhindi = By.xpath("//*[@text='हिन्दी']");
	//public static By objreligional = By.xpath("//*[@text='ಕನ್ನಡ']");
	public static By objreligional = By.xpath("(//*[contains(@resource-id,'language_chip_text')])[5]");
	public static By objmore = By.xpath("//*[@text='More' and ./parent::*[./parent::*[@id='langGroup']]]");
	public static By objadjustsettingslabel = By.xpath("//*[@text='Adjust Settings']");
	public static By objtermsandconditionslabel = By.xpath("//*[contains(@resource-id,'termsTextView')]");
	public static By objtermsandconditionslink = By.xpath("//*[@text='Terms & Conditions']");
	public static By objtermsandconditionspage = By.xpath("//*[@text='Terms & Conditions']");
	public static By objcontinueshootdialog = By.xpath("//*[@text='Continue Shoot']");
	public static By objcontinuebtn = By.xpath("//*[@text='Continue']");
	public static By objcancelbtn = By.xpath("//*[@text='Cancel']");
	public static By objaddmusicbtneditvideopage = By.xpath("//*[contains(@resource-id,'musicTextView')]");
	public static By objMe = By.xpath("//*[contains(@resource-id,'meimage')]");
	public static By objDraft = By.xpath("//*[contains(@resource-id,'text_draft')]");
	public static By objvideosavedasdraft = By.xpath("(//*[contains(@resource-id,'desc')])[1]");
	public static By objpublishprogressvideo = By.xpath("//*[@text='Publishing in process']");
	public static By objlongpress = By.xpath("(//*[contains(@resource-id,'desc')])[1]");
	public static By objunpublish = By.xpath("//*[contains(@resource-id,'txt_unpublish')]");
	public static By objunpublishdialog = By.xpath("//*[@text='Do you want to unpublish your video ?']");
	public static By objunpublishdialogyes = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	public static By objunpublisheddonedialog = By.xpath("//*[@text='Video Successfully Unpublished.']");
	public static By objunpublishedone = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	public static By objcontinuedialog = By.xpath("//*[@text='Continue Shoot']");
	public static By objcontinuedialogcontinuebtn = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	public static By objeditvideobackbtn = By.xpath("//*[contains(@resource-id,'close_btn')]");
	public static By objcontinuedialogvideoeditpage = By.xpath("//*[@text='Continue Shoot']");
	public static By objcontinuedialogcontinuebtnvideoeditpage = By
			.xpath("//*[contains(@resource-id,'btn_yes')]");
	public static By objdiscarddialog = By.xpath("//*[@text='Discard Shoot']");
	public static By objdiscarddialogokbtn = By.xpath("//*[contains(@resource-id,'btn_yes')]");

	// Scheduling

	public static By objtimerdialogbtn = By.xpath("//*[@text='Choose Countdown Timer']");
	public static By objtimertimelapsed = By.xpath("//*[@text='10']");
	public static By objtimertimelapsed1 = By.xpath("//*[contains(@resource-id,'countDownTextView')]");
	public static By objaddfilterdialog = By.xpath("//*[@text='Add Filter']");
	public static By objaddeffectdialog = By.xpath("//*[@text='Add Effects']");
	public static By objfirsteffectbeforedownlload = By
			.xpath("(//*[contains(@resource-id,'assetName')])[2]");
	public static By objfirsteffectafterdownloadfinish = By
			.xpath("(//*[contains(@resource-id,'assetCover')])[1]");
	public static By objaddmusicsearch = By.xpath("//*[@text='Search for sounds, playlists and dialogues....']");
	public static By objaddmusicsearcheddata = By.xpath("//*[contains(@resource-id,'editTextSearch')]");
	public static By objaddmusicdataclicked = By.xpath("(//*[@class='android.widget.TextView'])[5]");
	public static By objaddmusic = By.xpath("//*[contains(@resource-id,'music_name')]");
	public static By objvideotimerlapsedenabled10s = By.xpath("//*[@text='10']");
	public static By objcancel = By.xpath("//*[contains(@resource-id,'countdown_btn_cancel')]");
	public static By objback = By.xpath("//*[contains(@resource-id,'backImage')]");
	public static By objdiscardvideodialog = By.xpath("//*[@text='Discard Shoot']");
	public static By objdiscardvideodialogyes = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	public static By objddtimerdisabled = By
			.xpath("//*[contains(@resource-id,'timer_toggle') and @focused='false']");
	public static By objddtimerEnabled = By
			.xpath("//*[contains(@resource-id,'timer_toggle') and @focused='true']");
	public static By objAddFilterButtonHiglighted = By
			.xpath("//*[contains(@resource-id,'filter_toggle') and @selected='true']");
	public static By objAddEffectButtonHiglighted = By
			.xpath("//*[contains(@resource-id,'filter_toggle') and @selected='true']");

	public static By objRotatingIcon = By.xpath("//*[@class='android.widget.ToggleButton']");

	public static By objCrossIcon = By.xpath("//*[@id='select_music_close_btn']");

	public static By objRecordVideo = By.xpath("//*[@id='record_btn']");

	public static By objAlertAfterDenying = By.xpath("//*[@id='msg_popup']");

	public static By objImageView = By.xpath("//*[@id='live_window']");

	public static By objTrendingHashtag(String hashtag) {
		return By.xpath("//*[@id='hashtag_name' and @text='" + hashtag + "']");
	}
	
	public static By objTrendingHashtagFromList = By.xpath("(//*[@id='hashtag_name'])[2]");

	public static By objeffectused = By.xpath("//*[contains(@resource-id,'usedEffect')]");

	public static By objlanguageclickedhindi = By.xpath("//*[@text='हिन्दी']");

	// recordprogress
	public static By objrecordprogress = By.xpath("//*[contains(@resource-id,'record_progress')]");

	// delete_last_clip_click_on_No
	public static By objdeleteNo = By.xpath("//*[contains(@resource-id,'btn_no')]");

	// creation_page
	public static By objcreationpage = By.xpath("//*[contains(@resource-id,'douyin_capture_layout')]");

	// Video_Edit_Screen
	public static By objVideoEditScreen = By.xpath("//*[contains(@resource-id,'topLayout')]");

	// recording_Screen
	public static By objrecordingScreen = By.xpath("//*[contains(@resource-id,'design_bottom_sheet')]");

	public static By objLastClipdeleted = By.xpath("//*[contains(@resource-id,'alert_message')]");

	public static By objSoundName = By.xpath("//*[contains(@resource-id,'musicName')]");

	public static By objSelectGenre = By.xpath("(//*[@id='language_chip_text'])[1]");
	public static By objSelectLanguage = By.xpath("(//*[@id='language_chip_text'])[6]");
	public static By objCheckTerms = By.xpath("//*[@id='checkterms']");
	public static By objMeIcon = By.xpath("//*[@id='metext']");
	public static By objVideoCreated = By.xpath("//*[@id='videoimg']");

	public static By objAddToFvrts = By.xpath("(//*[@id='addmusic_fav'])[1]");
	public static By objSoundFavouritedOrNot(String soundName){
		return By.xpath("((((((//*[@text='"+soundName+"'])[1])//parent::*)//parent::*)//child::*)[5])");
	}
	public static By objSoundIsAlreadyFavourited = By.xpath("(//*[@id='addmusic_fav' and @checked='true'])[1]");
	public static By objAddedTofvrtPopup = By.xpath("//*[@id='title_popup' and @text='Added to your favorites']");

	public static By objfilterbuttondisabledbydefault = By
			.xpath("//*[contains(@resource-id,'filter_toggle') and @checked='false']");
	public static By objaddfilterbackbtn = By.xpath("//*[contains(@resource-id,'closeButtonimg')]");
	public static By objaddfilteralltab = By.xpath("//*[@text='All']");
	public static By objaddfilterrecenttab = By.xpath("//*[@text='Recents']");
	public static By objaddclearctabtn = By.xpath("//*[contains(@resource-id,'img_clear')]");

	public static By objfiltercategoryprimary = By.xpath("//*[@text='Primary']");
	public static By objfiltercategoryprimaryfiltercamera = By
			.xpath("//*[contains(@resource-id,'assetName') and @text='Camera']");

	public static By objfiltercategoryparty = By.xpath("//*[@text='Party']");
	public static By objfiltercategorypartyfilteropening = By
			.xpath("//*[contains(@resource-id,'assetName') and @text='Opening']");

	public static By objfiltercategorylovebeauty = By.xpath("//*[@text='Love n Beauty']");
	public static By objfiltercategorylovebeautyfilterdhak = By
			.xpath("//*[contains(@resource-id,'assetName') and @text='Dhak']");

	public static By objfiltercategoryaction = By.xpath("//*[@text='Action']");
	public static By objfiltercategoryactionfilterblink = By
			.xpath("//*[contains(@resource-id,'assetName') and @text='Blink']");

	public static By objfiltercategoryretro = By.xpath("//*[@text='Retro']");
	public static By objfiltercategoryfilterglitch = By
			.xpath("//*[contains(@resource-id,'assetName') and @text='Glitch']");
	public static By objfiltercategorydownloadbtn = By.xpath("(//*[contains(@resource-id,'download')])[1]");
	public static By objfiltercategorydownloadprogressbar = By
			.xpath("//*[contains(@resource-id,'downloadProgressBar')]");
	public static By objfiltercategorydownloadedused = By
			.xpath("(//*[contains(@resource-id,'assetCover')])[1]");
	public static By objfiltercategorydownloadedpreview = By.xpath("//*[@text='Camera Reel']");
	public static By objfilterdownloadedused = By
			.xpath("//*[contains(@resource-id,'filter_toggle') and @checked='true']");
	public static By objrecentfilterused = By.xpath("//*[contains(@resource-id,'assetCover')]");
	public static By objfilterdownloadedremoved=By.xpath("//*[contains(@resource-id,'filter_toggle') and @checked='false']");

	public static By objvolumebtn=By.xpath("//*[contains(@resource-id,'volumeImageView')]");
	public static By objlanguageokbtn=By.xpath("//*[contains(@resource-id,'btn_yes')]");
	public static By objlanguagedialog=By.xpath("//*[contains(@resource-id,'msg_popup')]");

	public static By objVideoUploadPopup=By.xpath("//*[contains(@resource-id,'tv_title')]");

	public static By objGoToFeedButton=By.xpath("//*[contains(@resource-id,'btn_yes')]");
	
	//Video Upload Popup - Go To Feed Button
	public static By objGoToFeed=By.xpath("//*[@id='btn_yes' and @text='Go To Feed']");
	
	//Video Upload Popup Title
	public static By objVideoUploadPopupTitle=By.xpath("//*[contains(@resource-id,'tv_title') and @text='Video Upload']");
	//Video Upload Successful message
	public static By objVideoUploadSuccessfulMessage = By.xpath("//*[contains(@resource-id,'textMsg') and @text='Congrats ! Your video has been successfully uploaded!']");


	public static By objMusicUsedInVideo(String MusicName){
		return org.openqa.selenium.By.xpath("(//*[@id='songNameMTextView' and @text='"+MusicName+"'])");
	}



	public static By objdeletebtn = By.xpath("//*[contains(@resource-id,'deleteText')]");
	public static By objdeleteyesbtn = By.xpath("//*[contains(@resource-id,'btn_yes')]");



	public static By objbackarrow = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgBack']");//added 15/4/2021

	
	public static By objcompleted = By.xpath("//*[@text='Completed']");

//==============================================Muthu kumaran M===========================================
	
		//Speed Button
	public static By objSpeedButton=By.xpath("(//*[@id='operation_layout']/*/*[@id='toggle_image'])[1]");
		
		//Speed Option 0.3x
		public static By objSpeedZeropointhree=By.xpath("//*[@resource-id='com.zee5.hipi:id/super_slow_speed_btn']");
		//Speed Option 0.5x
		public static By objSpeedZeropointfive=By.xpath("//*[@resource-id='com.zee5.hipi:id/slow_speed_btn']");
			//Speed Option 1x
		public static By objSpeedOne=By.xpath("//*[@resource-id='com.zee5.hipi:id/standard_speed_btn']");
			//Speed Option 1.5x
		public static By objSpeedOnePointFive=By.xpath("//*[@resource-id='com.zee5.hipi:id/fast_speed_btn']");
			//Speed Option 2x
		public static By objSpeedTwo=By.xpath("//*[@resource-id='com.zee5.hipi:id/super_fast_speed_btn']");
		//Flash Button
		public static By objFlashButton=By.xpath("(//*[@id='operation_layout']/*/*[@id='toggle_image'])[5]");
		//Flash Disable Popup
		public static By objFlashDisablePopup=By.xpath("//*[@resource-id='com.zee5.hipi:id/alert_message']");
		//Recording Video
		public static By objRecordingVideo=By.xpath("//*[@resource-id='com.zee5.hipi:id/record_play_pause']");
		//Effect Icon 
		public static By objEffectIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/effect_button_img']");
		//Discard Edits
		public static By objDiscardEdits=By.xpath("//*[@resource-id='com.zee5.hipi:id/ok_btn']");
		//Camera Flip new
		public static By objCameraFlipnew = By.xpath("(//*[@id='operation_layout']/*/*[@id='toggle_image'])[6]");		//Sound in Video Recording
		public static By objSoundInVideoRecord=By.xpath("//*[@resource-id='com.zee5.hipi:id/musicImageView']");
		//Sound search in video recording
		public static By objSoundSearchInVideoRecord=By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");
		//Sound Search for Input
		public static By objSoundSearchInput=By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");
		//Select Sound Search
		public static By objSelectFirstSound=By.xpath("(//*[@resource-id='com.zee5.hipi:id/music_name'])[1] |(//*[@resource-id='com.zee5.hipi:id/music_name'])[1] | //*[@resource-id='com.zee5.hipi:id/txtCreator']");
		//Sound Header Text
		public static By objSoundHeaderText=By.xpath("//*[@resource-id='com.zee5.hipi:id/toolbar_text']");
		//Select Music Button
		public static By objSelectMusicButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/select_music_use_btn'] | //*[@resource-id='com.zee5.hipi:id/tvDone']");
		//Music Header After adding
		public static By objMusicHeader=By.xpath("//*[@resource-id='com.zee5.hipi:id/selectMusic']");
		//Select Record Video
		public static By objSelectRecord=By.xpath("//*[@resource-id='com.zee5.hipi:id/ll_next']");
		//Search Button On Search Page
		public static By objFirstSearchResults=By.xpath("(//*[@id='rv_auto_suggestion']/*/*/*[@class='android.widget.TextView' and ./parent::*[@class='android.widget.LinearLayout' and ./parent::*[@id='rl_car']]])[1]| (//*[@resource-id='com.zee5.hipi:id/txtGenreName'])[1] | (//*[@resource-id='com.zee5.hipi:id/tvTitle'])[1]");
		//*[@resource-id='com.zee5.hipi:id/volumeTextView']//preceding-sibling::*[1]
		//Adjust Volume
		public static By objFirstSearchSong=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtCreator']");

		public static By objAdjustVolume100=By.xpath("//*[@text='100']//preceding-sibling::*[1]");
		public static By objAdjustVolume50=By.xpath("//*[@text='50']//preceding-sibling::*[1]");
	//  Sound screen cross icon
		public static By objSoundScreenCrossIcon=By.xpath("//*[@contentDescription='ID0two_lined_horizontal']");

//----------------------------------Kartheek-----------------------------------
		
		//Next Button
		public static By objNextButton= By.xpath("//*[@resource-id='com.zee5.hipi:id/next']");
		//Visibility Public Button
		public static By objvisibilityPublicButtonAndMeAndFrinds= By.xpath("//*[@resource-id='com.zee5.hipi:id/tvVisiblityValue']");
		//Visibility Private Button
//		public static By objvisibilityFrindsButton= By.xpath("");
		//Visibility Frinds Button
//		public static By objVisibilityFrindsButton= By.xpath("");
		//Who Can View this video
		//Public Button
		public static By objPublicButton= By.xpath("//*[@resource-id='com.zee5.hipi:id/rbEveryOne']");
		//Frinds Button
		public static By objFrindsButton= By.xpath("//*[@resource-id='com.zee5.hipi:id/rbFriends']");
		//Private Button
		public static By objPrivateButton= By.xpath("//*[@resource-id='com.zee5.hipi:id/rbNoOne']");
		
		//Select First Video
		public static By objselectfirstVideo= By.xpath("//*[@resource-id='com.zee5.hipi:id/imgLayout'][1]");
	//-------------------------------------------------------
	
	  //-------------------------------suhail--------------------------
		//video edit screen first effect
				public static By objEffectsFirstEffect=By.xpath("(//*[@resource-id='com.zee5.hipi:id/transparent'])[1] | //*[@resource-id='com.zee5.hipi:id/assetCover']");
			// Downloaded First Filter 
				public static By objDownloadedFirstFilter=By.xpath("(//*[@resource-id='com.zee5.hipi:id/assetCover'])[1]");
	
				
		//Player Screen for filters/effects
		public static By objPlayerScreenForFilters = By.xpath("//*[@resource-id='com.zee5.hipi:id/layout']");
		//filter category first filter
		public static By objFirstFilter=By.xpath("(//*[@id='recycler']/*/*[@id='assetName'])[2]");	
		//discard popu alert message
		public static By objDiscardPopupAlertMessager=By.xpath("//*[@id='alert_message']");	
		//Sound screen back button
		public static By objSoundScreenBackButtton=By.xpath("//*[@id='backBtn']");	
		//Suggested Sound screen back button
		public static By objSuggestedSoundScreenBackButtton=By.xpath("//*[@resource-id='com.zee5.hipi:id/img_back']");	
		//Sounds screen Popular artist rail
		public static By objSoundsScreenPopularArtistRail=By.xpath("//*[@id='layoutHeader' and (./preceding-sibling::* | ./following-sibling::*)[@contentDescription='ID2circular']]");	
		//Sounds screen Trending music rail
		public static By objSoundsScreenTrendingMusicRail=By.xpath("//*[@contentDescription='ID3two_lined_horizontal']");
		//Video edit screen Music Remove icon
		public static By objVideoeditscreenMusicRemove=By.xpath("//*[@id='musicRemove']");
		//Suggested sound screen Cross Icon
		public static By objSuggestedSoundScreenCrossIcon=By.xpath("//*[@id='img_clear']");
		// sound screen in demand rail
		public static By objSoundScreenIndemendRail=By.xpath("//*[@contentDescription='ID2two_lined_horizontal']");

			
		//create video 0.3x highlighted
		public static By objSpeedZeroPointThreeHighlighted=By.xpath("//*[@id='super_slow_speed_btn'and@checked='true']");
		//create video 0.5x highlighted	
		public static By objSpeedZeroPointFiveHighlighted=By.xpath("//*[@id='slow_speed_btn'and@checked='true']");
		//create video 1.5x highlighted	
		public static By objSpeedOnePointFiveHighlighted=By.xpath("//*[@id='fast_speed_btn'and@checked='true']");
		//create video 1x highlighted	
		public static By objSpeedOneHighlighted=By.xpath("//*[@id='standard_speed_btn'and@checked='true']");
		//create video 2x highlighted	
		public static By objSpeedTwoHighlighted=By.xpath("//*[@id='super_fast_speed_btn'and@checked='true']");
		//Speed HighLighted
				public static By objSpeedButtonHighLighted=By.xpath("//*[@resource-id='com.zee5.hipi:id/super_slow_speed_btn']");
		//Camera icon on Create video
		public static By objRecordIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/record_btn']");
		// Timer countdown video edit page
		public static By objTimerCountdown=By.xpath("//*[@id='countDownTextView']");
		
	//Sound verify
		
		public static By objSoundIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/addsoundTextView']");
	//SoundScreenSearchIcon
		public static By objSoundScreenSearchIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/searchIcon']");
	//video Screen sound button
		public static By objVideoScreenSoundbtn = By.xpath("//*[@resource-id='com.zee5.hipi:id/addsoundTextView']");
	// sound screen Searchfield
		public static By objSoundScreenSearchField = By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");
	//First suggested Text
		public static By objSoundFirstSuggestedText = By.xpath("(//*[@id='rv_auto_suggestion']/*/*/*[@text and @class='android.widget.TextView' and ./parent::*[@class='android.widget.LinearLayout' and ./parent::*[@id='rl_car']]])[1] | (//*[@resource-id='com.zee5.hipi:id/tvTitle'])[1]");
	//Sounds Header Screen
		public static By objSoundsHeaderScreen = By.xpath("//*[@resource-id='com.zee5.hipi:id/toolbar_text']");

	//first Existing record item
		public static By objSoundsExistingRecord = By.xpath("(//*[@id='addMusicResultAllRecyclerView']/*/*/*/*[@id='music_name'])[1] | (//*[@resource-id='com.zee5.hipi:id/txtGenreName'])[1] | //*[@resource-id='com.zee5.hipi:id/trimEnd']");
	//music screen header
		public static By objMusicScreenHeader = By.xpath("//*[@resource-id='com.zee5.hipi:id/select_music_name']");
		//Selected Music
		public static By objSelectedMusic = By.xpath("//*[@resource-id='com.zee5.hipi:id/musicName']");

	//Music Screen pause Icon
		public static By objMusicScreenPauseBtn = By.xpath("//*[@id='select_music_pause_btn']");
	//Music Screen Tick Icon
		public static By objMusicScreenTickIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/select_music_use_btn'] | //*[@resource-id='com.zee5.hipi:id/tvDone']");
	// Video Screen Header
		public static By objVideoScreenHeader = By.xpath("//*[@id='musicName']");
	//any video suggested in sounds page
		public static By objSoundsAnySound = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtGenreName'] | //*[@resource-id='com.zee5.hipi:id/musicName']");
	//Trnding on Hipi
		public static By objTrandingOnHipi = By.xpath("//*[@resource-id='com.zee5.hipi:id/textView']");

	//video edit screen header
		public static By objVideoEditScreenHeader = By.xpath("//*[@id='musicName']");
	//Video edit screen Volumebtn
		public static By objVideoEditScreenVoulmebtn = By.xpath("//*[@id='volumeImageView']");
	//Volume screen header
		public static By objVolumeScreenHeader = By.xpath("//*[@resource-id='com.zee5.hipi:id/bottomtitle']");
	//video screen tick icon
		public static By objVideoTickBtn = By.xpath("//*[@resource-id='com.zee5.hipi:id/ll_next']");
	//video edit text screen
		public static By objVideoedittext = By.xpath("//*[@id='ttImageView']");
	// video edit text plus icon
		public static By objVideoedittextplusicon = By.xpath("//*[@resource-id='com.zee5.hipi:id/ll_traditional_caption']");
	//Video edit Textfield
		public static By objVideoEditTextfield = By.xpath("//*[@resource-id='com.zee5.hipi:id/etCaption']");
	//Effects trending
		public static By objEffectsTrending = By.xpath("//*[@text='Trending']");
	//save video header popup
		public static By objSavedVideoHeaderPopup = By.xpath("//*[@text='Video Saved']");
	// video edit next button
		public static By objVideoEditNextBtn = By.xpath("//*[@id='next']");
	//Privacy button of video posting screen
		public static By objVideoPostPrivacyBtn = By.xpath("//*[@id='tvVisiblityValue']");
	//privacy public of video posting screen
		public static By objVideoPostPublicBtn = By.xpath("//*[@resource-id='com.zee5.hipi:id/rbEveryOne']");
	//privacy friends of video posting screen
		public static By objVideoPostFriendsBtn = By.xpath("//*[@resource-id='com.zee5.hipi:id/rbFriends']");
	//privacy private of video posting screen
		public static By objVideoPostPrivateBtn = By.xpath("//*[@resource-id='com.zee5.hipi:id/rbNoOne']");
	//privacy page tick button
		public static By objVideoPostPrivacyTick = By.xpath("//*[contains(@id,'rbEveryOne') and @checked='true']");
	//video flash disabled
		public static By objCreateVideoFlashDisabled = By.xpath("//*[contains(@resource-id,'flashButton') and @checkable='false']");
	//flash light icon
		public static By objCreateVideoFlashlight = By.xpath("//*[@id='flashButton' ]");
	//Flash light popup header
	    public static By objCreateVideoFlashlightpopup = By.xpath("//*[@id='alert_title']");
	//camera flip enabled update the existing one
		public static By objCameraFlipEnabledd = By.xpath("//*[@id='flipButton' and @enabled='true']");
	// fileter category party filter
		public static By objFilterParty = By.xpath("(//*[@id='textview'])[2]");
	// fileter category action filter
		public static By objFilterAction = By.xpath("(//*[@id='textview'])[3]");
	// fileter category Love_n_Beauty
		public static By objFilterLove_n_Beauty = By.xpath("(//*[@id='textview'])[4]");
	// fileter category Retro
		public static By objFilterRetro = By.xpath("(//*[@id='textview'])[5]");	
	//video screen record time
		public static By objVideoRecordtime = By.xpath("//*[@id='recordTime']");	
	// audio screen music time
		public static By objMusicTime = By.xpath("//*[@id='select_music_time']");	
		//Discard changes popup discard button
		public static By objDiscardPopupDiscaedEdits = By.xpath("//*[@id='ok_btn']|//*[contains(@text,'Discard video')]");
		
		public static By objmusicvolumebar = By.xpath("//*[@id='mTextView']");
		//Post Video SCreen Header
		public static By objPostSCreenHeader = By.xpath("//*[@id='title']");
		//filterscreen firstfilter
		public static By objFilterScreenFirstFilter = By.xpath("(//*[@id='recycler']/*/*[@id='assetName'])[1]");

		public static By objFilterScreenFirstFilter_party = By.xpath("(//*[@id='recycler']/*/*[@id='assetName' and (./preceding-sibling::* | ./following-sibling::*)[@id='download']])[1]");

		//uploaded video popup
		public static By objUploadedVideoPopup= By.xpath("//*[@id='videoUploadsSubs']");
		//video edit Screen sound button
		public static By objVideoEditScreenSoundbtn = By.xpath("//*[@id='musicImageView']");
		//video Text edit screen next botton
		public static By objVideoEditScreenNextButton= By.xpath("//*[@id='ok_btn']");
		//video Text edit screen Done botton
		public static By objVideoEditScreenDoneButton= By.xpath("//*[@id='ok_btn']");
		public static By objVideoEditScreenNext= By.xpath("//*[@id='next']");
		//upload video from gallery First video	
		public static By objGalleryFirstVideo= By.xpath("(//*[@id='media_recycleView']/*/*[@id='iv_item_image'])[1]");
	//upload video from gallery Edit This Video Button	
		public static By objGalleryEditThisVideoButton= By.xpath("//*[@id='sigle_tv_startEdit'] | //*[@resource-id='com.zee5.hipi:id/media_tv_startEdit']");
	//upload video from gallery video Tick button
		public static By objGalleryVideoTickButton= By.xpath("//*[@id='trimFinish']");
	//upload video from gallery video trim left handler
		public static By objTrimlefthandle = By.xpath("(//*[contains(@resource-id,'leftHandle')])[2]");	
	//uploaded video Thumbnail
		public static By objVideoThumbnail = By.xpath("//*[@id='live_window']");
		//upload video from gallery header popup
		public static By objGallerySelectVideoPopup= By.xpath("//*[@id='text_center']");
		//Misic screen Right Trim Enable 
		public static By objMusicscreenRightTrimEnable= By.xpath("//*[@resource-id='com.zee5.hipi:id/rightHandle' and @enabled='true']");
		//any video suggested in sounds 2 page
		public static By objSoundsAnySound2 = By.xpath("(//*[@resource-id='com.zee5.hipi:id/musicName'])[2] | (//*[@resource-id='com.zee5.hipi:id/txtGenreName'])[2]");
		
		//video upload progress popup
		public static By objuploadInProgressPopup= By.xpath("//*[@id='videoUploadsSubs']");	
	//Select First Video
//		public static By objselectfirstVideo= By.xpath("//*[@resource-id='com.zee5.hipi:id/imgLayout'][1]");
//		downloadin video percentage popup
		public static By objDownloadingVideopopUp= By.xpath("//*[@id='downloadVideoProgressLayout']");
	//permission popup ok button
		public static By objPermissionPopUpOkButton= By.xpath("//*[@id='btn_yes']");
		//post video screenTag friend @ button
		public static By objPostScreenFriendsBotton= By.xpath("//*[@id='txtFriends']");
	//Post screen First suggested user/friend;
		public static By objPostScreenFirstFriendSuggestedUser= By.xpath("//*[@resource-id='com.zee5.hipi:id/userName']");
		//postscreen comments enabled
		public static By objPostScreenCommentsEnabled= By.xpath("//*[@id='tvComment' and @enabled='true']");
	//postscreen likes enabled
		public static By objPostScreenLikesEnabled= By.xpath("//*[@id='tvLikes'and@checked='true']");	
	//postscreen duet enabled
		public static By objPostScreenAllowduetEnabled= By.xpath("//*[@id='tvStitch'and@checked='true']");
	//postscreen save to device enabled
		public static By objPostScreenSaveToDeviceEnabled= By.xpath("//*[@id='tvSave'and@checked='true']");
	//postscreen comments disabled
		public static By objPostScreenCommentsDisabled= By.xpath("//*[@id='tvComment' and @checked='false']");
	//postscreen likes disabled
		public static By objPostScreenLikesDisabled= By.xpath("//*[@id='tvLikes'and@checked='false']");	
	//postscreen allow duet disabled
		public static By objPostScreenAllowduetDisabled= By.xpath("//*[@id='tvStitch'and@checked='false']");
	//postscreen Save to device disabled
		public static By objPostScreenSaveToDeviceDisabled= By.xpath("//*[@id='tvSave'and@checked='false']");
	//postscreen comments
		public static By objPostScreenComments= By.xpath("//*[@id='tvComment']");
	//postscreen likes
		public static By objPostScreenLikes= By.xpath("//*[@id='tvLikes']");	
	//postscreen duet 
		public static By objPostScreenAllowduet= By.xpath("//*[@id='tvStitch']");
	//postscreen save to device 
		public static By objPostScreenSaveToDevice= By.xpath("//*[@id='tvSave']");
		
		//save as draft popup
		public static By objSaveasDraftPopup= By.xpath("//*[@id='videoUploadsSubs']");
		//Video creation time 30 seconds
		public static By objVideoCreationTime30Sec=By.xpath("//*[@text and ./parent::*[@contentDescription='30s']]");
		
		//Discard Popup keep Button
		public static By objDiscardPopupkeepButton=By.xpath("//*[@id='cancel_btn'] | //*[@id='cancel']");
//		Trim screen heaader
		public static By objTrimScreenHeader=By.xpath("//*[@id='bottomtitle']");
		//microphone enabled in volume screen
		public static By objMicrophoneEnabled=By.xpath("//*[@text='100'and@enabled='true']");
		
		
		
		//Filter screen Tabs
		public static By filterTabsXpaths(int a)
		{
			return   By.xpath("(//*[@id='tabRecycler']/*/*[@id='textview'])["+a+"]");
		}
		//filter screen clear icon
		public static By objFIlterScreenClearIcon=By.xpath("//*[@id='img_clear']");


				//Filter screen Tab filters
				public static By filterTabsFilters(int a)
				{
					return   By.xpath("(//*[@id='recycler']/*/*[@id='assetName'])["+a+"]");
				}

				public static By objFilterScreenTrimlayout=By.xpath("//*[@id='sequenceLayout']");
				//filter screen Play button
				public static By objFilterScreenPlayButton=By.xpath("//*[@id='videoPlay']");
				//Sticker screen plus icon
					public static By objStickerScreenPlusIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/videoPlay']");
					//Post screen First suggested user/friend;
					
						public static By objPostFirstFriendSuggestedUser(int a)
						{
							return By.xpath("(//*[@id='user_name'])["+a+"]");
						}
				//effets screen Trending Button
				public static By objEffectsScreenTrendingButton = By.xpath("(//*[@id='tabRecycler']/*/*[@id='textview'])[1]");
				//Video Edit  Screen Sticker
				public static By objVideoEditScreenSticker=By.xpath("//*[@id='emojiImageView']");
				//Edit Text screen back button
				public static By objEditTextScreenBackButton=By.xpath("//*[@id='filterBack']");	
				//Edit Text Screen Trimlayout
				public static By objEditTextScreenTrimlayout=By.xpath("//*[@id='timeline_edit_layout']");	
				//Edit Text screen Play button
				public static By objEditTextScreenPlayButton=By.xpath("//*[@id='play_btn']");
				public static By objSoundsScreenSecondRail=By.xpath("(//*[@resource-id='com.zee5.hipi:id/adapterView'])[5]");	

				//  Screen Sticker done button
				public static By objStickerEditScreenDoneButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/stickerFinish']");
				public static By objTotalRecordTime = By.xpath("//*[@id='recordTotalTime']");
				public static By objSoundCrossIcon=By.xpath("//*[@id='backBtn']");
				
				//====================New===================

				// filter
				public static By objVideoEditFilter = By.xpath("//*[@resource-id='com.zee5.hipi:id/filterImageView']");
				
				public static By objVideoEditScreenEditclip = By.xpath("//*[@id='stickerImageView']");
				public static By objEditclipVideo = By.xpath("//*[@resource-id='com.zee5.hipi:id/edit_centerimage']");
				public static By objEditclipscreenTick = By.xpath("//*[@id='edit_commitButton']");
				public static By objEditclipscreenLeftPlusIcon = By.xpath("//*[@id='addImage_left']");
				public static By objEditclipscreenRightPlusIcon = By.xpath("//*[@id='addImage_right']");
						public static By objEditclipVideos(int a)
						{
							return By.xpath("(//*[@resource-id='com.zee5.hipi:id/edit_centerimage'])["+a+"]");
						}
						public static By objEditClipAddMedia = By.xpath("//*[@id='media_tv_startEdit']");
						public static By objEditClipPhotoTab = By.xpath("//*[@contentDescription='Photos']");
						public static By objEditClipDuration = By.xpath("(//*[@id='effectRecyclerView']/*/*[@id='imageAsset'])[1]");
						public static By objEditClipDeleteButton = By.xpath("(//*[@id='effectRecyclerView']/*/*[@id='imageAsset'])[4]");
						public static By objEditclipSecondVideo = By.xpath("(//*[@resource-id='com.zee5.hipi:id/edit_centerimage'])[2]");
						public static By objEditclipCopy = By.xpath("(//*[@id='effectRecyclerView']/*/*[@id='imageAsset'])[3]");
						public static By objEditClipKeepAtleastPopup = By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@id='dialog_first_tip']]");
						public static By objEditclipTrim = By.xpath("(//*[@id='effectRecyclerView']/*/*[@id='imageAsset'])[1] | //*[contains(@text,'Trim')]");
						public static By objEditClipTrimscreenTick = By.xpath("//*[@id='trimFinish']");
						public static By objEditClipDurationInfo = By.xpath("//*[@id='trimDurationVal'] | //*[@resource-id='com.zee5.hipi:id/trimEnd']");
						public static By objEditClipDragInfo = By.xpath("");
						public static By objEditClipSplit = By.xpath("(//*[@id='effectRecyclerView']/*/*[@id='imageAsset'])[2]");
						public static By objEditclipSplitScreenDragger= By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@id='topHandle']]");
						public static By objEditclipSplitScreenLastSegment= By.xpath("(//*[@class='android.view.ViewGroup']/*[@class='android.widget.ImageView'])[8]");
						public static By objEditClipSlipscreenTick = By.xpath("//*[@id='spiltFinish']");
						public static By objGalleryFirstVideo(int a)
						{
							return By.xpath("(//*[@id='media_recycleView']/*/*[@id='iv_item_image'])["+a+"]");
						}
						public static By objCreateDuetLeftScreen = By.xpath("//*[@id='exo_overlay']");
						public static By objCreateDuetRightScreen = By.xpath("//*[@id='livewidow']");
						public static By objPostscreenHashtag = By.xpath("//*[@id='txtHashtag']");
						public static By objSaveasDraft= By.xpath("//*[@id='btn_save_draft']");
						public static By objPostscreenWhoCanViewThisVideo = By.xpath("//*[@id='tvVisiblity']");


						
						
						
						public static By objPostScreenEditButton= By.xpath("//*[@id='editbtn']");
						public static By objTrimscreenCrossIcon= By.xpath("//*[@id='select_music_close_btn'] | //*[@resource-id='com.zee5.hipi:id/tvCancel']");
						public static By objDiscardText= By.xpath("//*[@id='dialog_first_tip']");
						public static By objSelectMediaAllTab= By.xpath("//*[@text and ./parent::*[@contentDescription='All']]");
						public static By objSelectMediaVideoTab= By.xpath("//*[@text and ./parent::*[@contentDescription='Videos']]");
						public static By objSlectMediaFirstPhoto= By.xpath("(//*[@id='media_recycleView']/*/*[@id='iv_item_image'])[1]");
						public static By objEditclipFirstVideo = By.xpath("(//*[@resource-id='com.zee5.hipi:id/edit_centerimage'])[1]");
						public static By objEditClipDefaultDuration= By.xpath("//*[@text='2']");
						public static By objDurationScreenTick= By.xpath("//*[@id='durationFinish']");
						public static By objEditScreenBack= By.xpath("//*[@id='durationFinish']");
						public static By objEditClipSlipscreenTickIcon = By.xpath("//*[@id='edit_commitButton']");
						public static By objEditclipSplittedVideo = By.xpath("(//*[@resource-id='com.zee5.hipi:id/edit_centerimage'])[3]");
						public static By objEditclipHeader= By.xpath("//*[@id='dragAndReorder']");
						public static By objUploadFailed= By.xpath("//*[@id='txtTitle']");
						public static By objUploadPopupRetry= By.xpath("//*[@id='txtRetry']");
						public static By objUploadDeleteIcon= By.xpath("//*[@id='ivDeleteVideo']");
						public static By objUploadPopupuploatindText= By.xpath("//*[@text='Uploading']");
						public static By objTrimVideoScreenHeader= By.xpath("//*[@text and (./preceding-sibling::* | ./following-sibling::*)[@id='selectRotateClip'] and ./parent::*[@class='android.widget.RelativeLayout']]");
						public static By objTrimVideoScreenDragText= By.xpath("//*[@text and (./preceding-sibling::* | ./following-sibling::*)[@id='select_music_close_btn'] and ./parent::*[@class='android.widget.RelativeLayout']]");

						
						
						public static By objDiscoverTab= By.xpath("//*[contains(text(),'Discover')]");
						public static By objFavoritesTab= By.xpath("//*[contains(text(),'Favorites')]");
						public static By objLocalTab=By.xpath("//*[contains(text(),'Local')]");
						
						public static By objByDefaultDiscoverTabSelected=By.xpath("//*[@class='android.widget.TextView' and @selected='true']");
						
						public static By objBookmarked=By.xpath("//*[@resource-id='com.zee5.hipi:id/fav_download']");
						
						public static By objSeeAllButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/btnMore']");

						public static By objDetailedCategory=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtGenreName']");

						
						public static By objSoundSearchedList(int num)
						{
						return By.xpath("(//*[@resource-id='com.zee5.hipi:id/txtGenreName'])["+num+"]");
						}
						
						
						public static By objPostFirstFriendSuggestedUser(String name)
						{
							return By.xpath("//*[contains(@text,'"+name+"')]");
						}
						public static By objSoundName(String name)
						{
							return By.xpath("//*[contains(@text,'"+name+"')and(@id='text_view_music_title')]");
						}
						public static By objLocalSoundFirstMusic= By.xpath("(//*[@id='recSounds']/*/*[@id='txtGenreName'])[1]");
						public static By objLocalSoundsHeader=By.xpath("//*[@id='select_music_name']");
						public static By objLocalSoundsTrimTick=By.xpath("//*[@id='select_music_use_btn'] | //*[@resource-id='com.zee5.hipi:id/tvDone']");
						
						public static By objSoundSearchListPlayIcon=By.xpath("(//*[@id='addMusicResultAllRecyclerView']/*/*/*/*/*[@id='music_play_btn'])[1] | //*[@resource-id='com.zee5.hipi:id/musicPlayBtn']");
						public static By objSoundSearchListThumbnail=By.xpath("(//*[@resource-id='com.zee5.hipi:id/image_view'])[1] | (//*[@resource-id='com.zee5.hipi:id/imgEffect'])[1]");
						public static By objSoundScreenFirstCategory=By.xpath("//*[@id='textView' and ./parent::*[@contentDescription='ID0Playlist']]");
						public static By objSoundNameList(int num)
						{
						return By.xpath("(//*[@id='txtGenreName'])["+num+"]");
						}
						public static By objSoundCategoryFavoriteIcon(int num)
						{
						return By.xpath("(//*[@id='fav_download'])["+num+"]");
						}
						public static By objSoundScreenFirstBookmark=By.xpath("(//*[@id='fav_download'])[1]");
						public static By objSoundScreenFirstSound=By.xpath("(//*[@id='txtGenreName'])[1]");
	
						public static By objBookmarkSymbol=By.xpath("//*[@resource-id='com.zee5.hipi:id/fav_download']");
						
						
						
						public static By objShareAndWinHeader=By.xpath("//*[@id='txtFirst']");
						public static By objShareAndWinThumbnail=By.xpath("//*[@id='imgBannerIcon']");
						public static By objShareAndWinDesc=By.xpath("//*[@id='txtSecond']");
						public static By objShareAndWinInviteNowCta=By.xpath("//*[@id='txtInvite']");
						public static By objShareAndWinBanner=By.xpath("//*[@id='topLayout']");
						public static By objGallery90SecVideo= By.xpath("//*[@text='01:30']||//*[@text='00:90']");
						public static By objGallery5SecVideo= By.xpath("//*[@text='00:05']");
						public static By objTrimscreenHeader= By.xpath("//*[@id='dragAndReorder']");
						
						public static By objSongDuration= By.xpath("//*[@resource-id='com.zee5.hipi:id/tvDuration']");
						public static By objTrimSong= By.xpath("//*[@resource-id='com.zee5.hipi:id/musicCutView']");

						
						//record time below record button---changed-------------08-03-2022
						public static By objiosCreationTimesInBelowRecordingBtn(String time) {
						return By.xpath("//*[contains(@accessibilityLabel,'com.zee5.hipi:id/Duration_"+time+"')]");
						}
						
						public static By objDownloadedEffect= By.xpath("//*[@resource-id='com.zee5.hipi:id/assetCover' and @index='0']");
						
						
						public static By obj15seco(String time) {
							return By.xpath("//*[@text='" + time + "']");
						}
						public static By obj15sec = By.xpath("//*[@text='15s']");

						public static By obj30sec = By.xpath("//*[@text='30s']");
						public static By obj45sec = By.xpath("//*[@text='45s']");
						public static By obj60sec = By.xpath("//*[@text='60s']");
						public static By obj90sec = By.xpath("//*[@text='90s']");
						public static By obj00sec = By.xpath("//*[@text='00:00']");
						
						
						
						public static By objRetry = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtRetry']");
						
						public static By objEnglishLanguage = By.xpath("//*[contains(@text,'English')]");

						public static By objdownloadTxtProgress = By.xpath("//*[@resource-id='com.zee5.hipi:id/downloadTxtProgress']");


						public static By objGalleryVideos(int a)
						{
							return   By.xpath("(//*[@id='media_recycleView']/*/*[@id='iv_item_image'])["+a+"]");
						}

						public static By objSeletedGalleryVideos(int a)
						{
							return   By.xpath("(//*[@resource-id='com.zee5.hipi:id/item_media_hideLayout'])["+a+"]");
						}
						
						public static By objPhotesTab = By.xpath("//*[contains(@text , 'Photos')]");
						
						
						public static By objEditOptions(int a)
						{	
							return   By.xpath("(//*[@resource-id='com.zee5.hipi:id/nameAsset'])["+a+"]");
						}
							
						public static By objTrimOptions = By.xpath("//*[contains(@text,'Trim V')]");
						
						public static By objDurationOptions = By.xpath("//*[contains(@text,'Duration')]");
						
						public static By objDurationSeekBar = By.xpath("//*[@resource-id='com.zee5.hipi:id/durationSeekBar']");

						public static By objFineshButtonEditScreen = By.xpath("//*[@resource-id='com.zee5.hipi:id/trimFinish']");
						
						public static By objFineshButtonImageEditScreen = By.xpath("//*[@resource-id='com.zee5.hipi:id/durationFinish']");

						
						
						public static By objSelectedFirstVideo = By.xpath("//*[@resource-id='com.zee5.hipi:id/tv_selected_num']");

						public static By objSelectedVideo(int a)
						{	
							return   By.xpath("(//*[@resource-id='com.zee5.hipi:id/tv_selected_num'])["+a+"]");
						}
						
						
						public static By objDragTheSliderToAdjust = By.xpath("//*[contains(@text,'Drag the slider to adjust')]");

						
						public static By objHoldAndDragVideosPhotosToChangeTheirOrder= By.xpath("//*[@resource-id='com.zee5.hipi:id/dragAndReorder']");
						
						public static By objDownloadProgressBar = By.xpath("//*[@resource-id='com.zee5.hipi:id/downloadProgressBar']");

						
						
						
						public static By objShareSheet = By.xpath("//*[@resource-id='com.zee5.hipi:id/share_sheet']");
						
						
						public static By objVideoLanguageSelect = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvLanguageValue']");
						
						public static By objDoneCTC = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvDone']");
						
						//select video category
						public static By objSelectVideoCategory = By.xpath("//*[@resource-id='com.zee5.hipi:id/videoCategoryValue']");
						
						//Video category value
						public static By objVideoCategoryValue = By.xpath("//*[@resource-id='com.zee5.hipi:id/lang_name']");
						
						public static By objNeedfeedbackPopUp = By.xpath("//android.widget.TextView[contains(@resource-id,'com.zee5.hipi:id/needFeedbackTextView')]");

						public static By objNoCtaOnNeedFeedbackPopUp = By.xpath("//android.widget.TextView[contains(@resource-id,'com.zee5.hipi:id/negativeTv')]");
}
