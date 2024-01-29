package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiMePage {
	
	//video
	public static By objvideotab=By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tab_layout']]/*[@class='android.widget.LinearLayout' and ./*[@class='android.widget.ImageView']])[1]");
//music
	public static By objmusictab=By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tab_layout']]/*[@class='android.widget.LinearLayout' and ./*[@class='android.widget.ImageView']])[2]");
	//favourites
	public static By objfavourite=By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.ImageView[@index='0']");

	public static By objfavouritetab=By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tab_layout']]/*[@class='android.widget.LinearLayout' and ./*[@class='android.widget.ImageView']])[3]");
	//xpath(“//android.widget.LinearLayout[@index=’1′]/android.widget.Button[@index=’1′]”)
//video
	public static By objvideo=By.xpath("//*[contains(@resource-id,'txtVideo')]");
	//hashtag
	public static By objHashtags=By.xpath("//*[contains(@resource-id,'txtHashtags')]");
	//sounds
	public static By  objsounds=By.xpath("//*[contains(@resource-id,'txtSounds')]");

	public static By objFavouritedSound(String sound){
		return By.xpath("//*[contains(@resource-id,'music_name') and @text='"+sound+"']");
	}
	
	public static By objFavouritedSondStarIcon = By.xpath("//*[contains(@resource-id,'addmusic_fav')]");
	
	//Effects
	public static By objEffects=By.xpath("//*[@class='android.widget.TextView' and @text='Effects']");
	//palyicon
	public static By objplayicon=By.xpath("(//*[contains(@resource-id,'music_play_btn')])[1]") ;
	//editprofilebackbutton
	public static By objbackbutton=By.xpath("//*[@resource-id='com.zee5.hipi:id/imgBack']");//*[contains(@resource-id,'imgBack']
	//hashtag text
	public static By objtext=By.xpath("//*[contains(@resource-id,'txtEffectName') and @text='HipiDiwali']");
	//video text
	public static By objVideostext=By.xpath("//*[@text='#MakeUpTutorials #Fun #StayConnected #Masti #Jokes #Music #hipistars']");
	
	//all
	public static By objall=By.xpath("//*[contains(@resource-id,'TabAll')]");
	//private
	public static By objprivate=By.xpath("//*[contains(@resource-id,'text_private')]");
	//draft
	public static By objdraft=By.xpath("//*[contains(@resource-id,'text_draft')]");
	
	public static By objUploadAllButton=By.xpath("//*[@id='txt_Upload_all']");
	//settingsicon
	public static By objsettingsicon=By.xpath("//*[contains(@resource-id,'imgSetting')]");
	//edithipiprofile
//	public static By objEditprofile=By.xpath("//*[@text='Edit HiPi Profile']");
	public static By objEditprofile=By.xpath("//*[@text='Edit HiPi Profile']");
	public static By objeditprofile=By.xpath("//*[@text='Edit Profile']");
	//Hipipreferrences
	public static By objhipipreferences=By.xpath("//*[@text='HiPi Preferences']");
	//setvisibility
	public static By objsetvisibility=By.xpath("//*[contains(@resource-id,'txt_visibility')]");
	//visiblemode
	public static By objvisiblemode=By.xpath("//*[contains(@resource-id,'visibleMode')]");
	//public
	public static By objpublicicon=By.xpath("//*[@text='Public']");
	//followersonly
	public static By objfollowersonly=By.xpath("//*[@text='Followers-Only']");
	//Me
	public static By objMeicon=By.xpath("//*[@text='Me']");
	//DefaultSelectedPUBLICVisibility
	public static By objdefaultVisibilityPublic = By.xpath("//*[contains(@resource-id,'visibleMode') and @text='Public']");
	
	//DefaultSelectedfollowersonlyVisibility
	public static By objdefaultfollowersonlyVisibility = By.xpath("//*[contains(@resource-id,'visibleMode') and @text='Follower Only']");
	
	//DefaultSelectedMeVisibility
	public static By objdefaultVisibilityMe = By.xpath("//*[contains(@resource-id,'visibleMode') and @text='Me']");
	
	//allowlikes
	public static By objallowlikes=By.xpath("//*[contains(@resource-id,'allowLikes')]");
	//downloadoverwifuonly
	public static By objdownload=By.xpath("//*[@text='Download over WiFi only']");//*[@text='Download over WiFi only']")
	//onstate
	public static By objAllowLikestoggleon=By.xpath("//*[contains(@resource-id,'allowLikes')]//following-sibling::*[text()='ON']");
	//offstate
	public static By objAllowLikestoogleoff=By.xpath("//*[contains(@resource-id,'allowLikes')]//following-sibling::*[text()='OFF']");
	//allowcomments
	public static By objalowcomment=By.xpath("//*[contains(@resource-id,'allowComment')]");
	public static By objallowcommenttoggleon=By.xpath("//*[contains(@resource-id,'allowComment')]//following-sibling::*[text()='ON']");
	//allowcommenttoggleoff
	public static By objallowcommenttoggleoff=By.xpath("//*[contains(@resource-id,'allowComment')]//following-sibling::*[text()='OFF']");
	//allowvideodownload
	//public static By objallowvideodownload=By.xpath("*[contains(@resource-id,'allowVideoDownload']");
	//allowvideodownloadtoogleon
	public static By objallowvideodownloadtoggleon=By.xpath("//*[contains(@resource-id,'allowVideoDownload')]//following-sibling::*[text()='ON']");
	//allowtooglevideooff
	public static By objallowvideodownloadtoggleoff=By.xpath("//*[contains(@resource-id,'allowVideoDownload')]//following-sibling::*[text()='OFF']");
	//allowsharing
	//public static By objallowsharing=By.xpath("//*[contains(@resource-id,'allowSharing']");
	//allowsharingon
	public static By objallowsharingon=By.xpath("//*[contains(@resource-id,'allowSharing')]//following-sibling::*[text()='ON']");
	//allowsharingoff
	public static By objallowsharingoff=By.xpath("//*[contains(@resource-id,'allowSharing')]//following-sibling::*[text()='OFF']");
	//allowvideodownload
	public static By objallowvideodownload=By.xpath("//*[contains(@resource-id,'allowVideoDownload')]");
	//allowsharing
	public static By objallowsharing=By.xpath("//*[contains(@resource-id,'allowSharing')]");
	
	public static By objtoogle (By state){
		return By.xpath("//*[contains(@resource-id,'allowLikes')]//following-sibling::*[text()='"+state+"']");
	}
		//toggle in download
		public static By objontoggle= By.xpath("//*[contains(@resource-id,'switch2')]");
		
		//back button in hipipreferences
		public static By objbackbuttonhipi=By.xpath("//*[contains(@resource-id,'back')]");
		//notification
		public static By objnotification=By.xpath("//*[contains(@resource-id,'imgNotification')]");
		//likedvideo
		public static By objlikedvideo=By.xpath("(//*[@id='recyclerView']/*/*/*/*/*[@text='@Nanjunda01c6472d liked your HiPiT'])[1]");
		//hipidiwalieffect
		public static By objeffecttext=By.xpath("//*[contains(@resource-id,'txtEffectName') and @text='HipiDiwali']");
		//coolglasses
		public static By objeffectcoolglasses=By.xpath("//*[@class='android.widget.TextView' and @text='Cool Glasses']");
		
		public static By objfirstEffect=By.xpath("(//*[contains(@resource-id,'txtEffectName')])[1]");
		
		//*[contains(@resource-id,'txtEffectName' and @text='HipiDiwali']
		//effectimage
		public static By objeffectimage=By.xpath("//*[contains(@resource-id,'effectImage')]");
		//effectname
		public static By objeffectname=By.id("com.zee5.hipi:id/displayName");
		//effectcount
		public static By objeffectcount=By.id("com.zee5.hipi:id/playCount");
		
		public static By objeffectcount1=By.xpath("//*[contains(@resource-id,'playCount')]");
		//videos created using this effect
		public static By objvideoscreatedeffect=By.xpath("//*[@class='android.widget.TextView' and @text='Videos Created Using Effect']");
		//use effect
		public static By objuseefffect=By.xpath("//*[@class='android.widget.TextView' and @text='Use this Effect']");
		
		public static By objuseThisSound=By.xpath("//*[@class='android.widget.TextView' and @text='Use this Sound']");
		
		
		//favouriteeffect
		public static By objfavouriteeffect=By.xpath("//*[contains(@resource-id,'addmusic_fav')]");
		//shareeffect
		public static By objshareeffect=By.xpath("//*[@class='android.widget.ImageButton' and @index='1']");
		//hipieffectshare
		public static By objhipieffect=By.id("miui:id/alertTitle");
		
		public static By objhipieffect1=By.xpath("//*[@resource-id='miui:id/alertTitle']");
		//cancelhipieffectbutton
		public static By objcancelhipi=By.id("android:id/button2");
		//ready popup
		public static By objreadypopup=By.xpath("//*[contains(@resource-id,'title_popup')]");
		//ok
		public static By objokbutton=By.xpath("//*[contains(@resource-id,'btn_yes')]");
		//Effectusedin me
		public static By objeffectusedme=By.id("com.zee5.hipi:id/usedEffect");
		//backview
		public static By objbackview=By.id("com.zee5.hipi:id/imgBack");
		//backbutton in firstname
		public static By objbackimage=By.id("com.zee5.hipi:id/backView");
		//effectimage
		public static By objeffectsuse =By.xpath("//*[contains(@resource-id,'txtEffectName') and @text='Cyber Helmet ']");
		//musicname
		public static By objmusicname=By.xpath("(//*[@id='mRecyclerView']/*/*/*/*[@id='music_name'])[1]");
		//playbutton
		public static By objplaybutton=By.xpath("//*[contains(@resource-id,'music_play_btn')]");
		//allow comment
		public static By objallowcomment=By.xpath("//*[contains(@resource-id,'allowComment')]");
		//on
				public static By objtoggleon=By.xpath("//*[@id='switch2']");
				
			//	com.zee5.hipi:id/meimage
		
		
		
				public static By objmeicon=By.id("com.zee5.hipi:id/meimage");//com.zee5.hipi:id/meimage
				//following in me icon
				public static By objfollowing=By.xpath("//*[contains(@resource-id,'txtFollowing')]");
				//following in me
				public static By objfollowingtext=By.xpath("//*[contains(@resource-id,'music_name') and @text='Abhishek Kapur']");
	
				public static By objfollowingProfile(String profileName){
					return By.xpath("//*[contains(@resource-id,'music_name') and @text='"+profileName+"']");
				}

				public static By objfollowingUser=By.xpath("(//*[@id='music_name'])[1]");
				
				//effectused
				public static By objeffectused=By.xpath("//*[@text='Effect Used -Cool Glasses']");
		
				
				public static By objUsedEffect=By.xpath("//*[contains(@resource-id,'usedEffect')]");
				
				
				//sharewidgettitle
				public static By objsharewidgettitle=By.xpath("//*[@resource-id='miui:id/alertTitle']");
				//share widgets
				public static By objsharewidgets=By.xpath("//*[@resource-id='android:id/text1']");
				 //cancel
			    public static By objcancel=By.xpath("//*[@resource-id='android:id/button2']");
			  //hashtaguseeffect
			    public static By objhastaguseeffect=By.xpath("//*[contains(@resource-id,'hashtagText')]");
				
				public static By objPublishingInProcess = By.xpath("//*[@text='Publishing in process']");
				
				public static By objHashtagShare = By.xpath("((//*[contains(@resource-id,'toolbar_hashtag')])//child::*)[4]");
				//musiclist
				public static By objmusiclist=By.xpath("//*[contains(@resource-id,'music_name')]");
				//backinme
				public static By objbackinme=By.xpath("//*[contains(@resource-id,'imgBack')]");
				//musictitle
				public static By objmusictitle=By.xpath("//*[contains(@resource-id,'musicTitle')]");

				//backsettings
				public static By objsettingback=By.xpath("//*[contains(@resource-id,'back')]");
				
				
				//backbuttonin hipisettings
				public static By objbackbuttonhipisettings=By.xpath("//*[contains(@resource-id,'back')]");

//likevideotext
				public static By objlikedvideotext=By.xpath("//*[contains(@resource-id,'txt_title')]");

				//noresultfound
				public static By objnoresultfound=By.xpath("//*[contains(@resource-id,'txt_no_data_found')]");

				//videosnotification
				public static By objvideotabinnotification=By.xpath("//*[@class='android.widget.TextView' and @text='Videos']");
				
				//firstsound
				public static By objfirstsoundused=By.xpath("//*[contains(@resource-id,'music_name')][1]");
				
				//downloadoverwifi
				public static By objdownloadoverwifi=By.xpath("//*[@text='Download over WiFi only']");
				//toggleoff
				public static By objtoggleoff=By.xpath("//*[contains(@resource-id,'switch2')]");
				
				
				
				public static By objContentText = By.xpath("//*[contains(@resource-id,'authorContentTextView')]");
				
				
				public static By objHipiProfileName = By.xpath("//*[@id='txtUserName']");
				
				public static By objHipiProfileId=By.xpath("//*[@id='txtUserHandle']");
				
				public static By objSearchedUser(String searchUser){
					return By.xpath("//*[@id='music_name' and @text='"+searchUser+"']");
				}
				
				public static By objUnfollow=By.xpath("//*[@id='txtEditProfile']");
				
				public static By objVideoDescription = By.xpath("//*[@id='authorContentTextView']");
				
				
				public static By objEnabledCommentIcon = By.xpath("//*[contains(@resource-id,'comment') and @enabled='true']");
				public static By objEnabledLikeIcon = By.xpath("//*[contains(@resource-id,'like') and @enabled='true']");
				public static By objEnabledShareIcon = By.xpath("//*[contains(@resource-id,'share') and @enabled='true']");
				
				public static By objDisabledCommentIcon = By.xpath("//*[contains(@resource-id,'comment') and @enabled='false']");
				public static By objDisabledLikeIcon = By.xpath("//*[contains(@resource-id,'like') and @enabled='false']");
				public static By objDisabledShareIcon = By.xpath("//*[contains(@resource-id,'share') and @enabled='false']");
				
				public static By objShareHipiVideoPopup = By.xpath("//*[@text='HiPi Video']");
				
				
				
				
				
				
				
				
				
				public static By objMe=By.xpath("//*[contains(@resource-id,'meimage')]");
				public static By objprofileimage=By.xpath("//*[contains(@resource-id,'profile_pic')]");
				public static By objuploadusingcamera=By.xpath("//*[@text='Upload using Camera']");
				public static By objuploadusinggallery=By.xpath("//*[@text='Upload using Gallery']");
				public static By objcancelbtn=By.xpath("//*[@text='Cancel']");
				public static By objcameraappopened=By.xpath("//*[@resource-id='com.android.camera2:id/shutter_button']");
				public static By objcameraappopened1=By.xpath("//*[@resource-id='com.android.camera:id/shutter_button' or @resource-id='com.android.camera:id/v9_shutter_button_internal']");
				public static By objprofilenameavailable=By.xpath("//*[contains(@resource-id,'txtUserName')]");
				public static By objpicturesandrecordvideodialog=By.xpath("//*[@id='permission_message']");
				public static By objallowbtn=By.xpath("//*[@id='permission_allow_foreground_only_button' or @id='permission_allow_button' or @text='ALLOW' or @text='Allow']");
				public static By objphotomediadialog=By.xpath("//*[@id='permission_message']");
				
				public static By objfollowvalue=By.xpath("//*[contains(@resource-id,'txtFollowValue')]");
				public static By objfollowicon=By.xpath("//*[contains(@resource-id,'txtFollow')]");
				public static By objfollowingvalue=By.xpath("//*[contains(@resource-id,'txtFollowingValue')]");
				public static By objfollowingicon=By.xpath("//*[contains(@resource-id,'txtFollowing')]");
				public static By objfollowpage=By.xpath("//*[contains(@resource-id,'offers_title')]");
				
				public static By objfollowerpagebackbtn=By.xpath("//*[contains(@resource-id,'back')]");
				public static By objsearchicon=By.xpath("//*[contains(@resource-id,'icon_search')]");
				public static By objsearchfolllowerlabel=By.xpath("//*[@text='Search Followers']");
				public static By objfollowerimage=By.xpath("(//*[contains(@resource-id,'userImage')])[1]");
				public static By objprofilename=By.xpath("(//*[contains(@resource-id,'music_name')])[1]");
				public static By objfollowercount=By.xpath("(//*[contains(@resource-id,'user_followers')])[1]");
				public static By objfollowbtn=By.xpath("(//*[contains(@resource-id,'follow_btn')])[1]");
			//	public static By objprofilehandle=By.xpath("//*[contains(@resource-id,'txtUserHandle']");
				public static By objprofilehandle=By.xpath("//*[contains(@resource-id,'text_user_handle')]");
				public static By objsearchfield=By.xpath("//*[contains(@resource-id,'editTextSearch')]");
				public static By objsearchfieldbackbtn=By.xpath("//*[contains(@resource-id,'fake_back')]");
				public static By objsearchfieldclosebtn=By.xpath("//*[contains(@resource-id,'iv_clear_text')]");
				public static By objfolloweraccountdata=By.xpath("//*[contains(@resource-id,'txtUserHandle')]");
				public static By objfollowbtnuser=By.xpath("//*[@text='Follow']");
				public static By objfollowingbtnuser=By.xpath("//*[@text='Following']");
				public static By objaccountname=By.xpath("(//*[contains(@resource-id,'text_user_handle')])[1]");
				public static By objplusbtn=By.xpath("(//*[contains(@resource-id,'follow_btn')])[1]");
				public static By objfollowingpage=By.xpath("//*[contains(@resource-id,'offers_title')]");
				public static By objfollowingpagebackbtn=By.xpath("//*[contains(@resource-id,'back')]");
				public static By objfollowingpagesearch=By.xpath("//*[contains(@resource-id,'back_button')]");
				public static By objfollowingpagesearchfollowinglabel=By.xpath("//*[@text='Search Following']");
				public static By objfollowingpageimage=By.xpath("(//*[contains(@resource-id,'userImage')])[1]");
				public static By objfollowingpagename=By.xpath("(//*[contains(@resource-id,'music_name')])[1]");
				public static By objfollowingpagefollowercount=By.xpath("(//*[contains(@resource-id,'user_followers')])[1]");
				public static By objfollowingpagehandle=By.xpath("(//*[contains(@resource-id,'text_user_handle')])[1]");
				public static By objfollowingpagetickbtn=By.xpath("(//*[contains(@resource-id,'follow_btn')])[1]");
				public static By objfollowingpageclosebtn=By.xpath("//*[contains(@resource-id,'ic_clear')]");
				public static By objfollowingpagebacklabelbtn=By.xpath("//*[contains(@resource-id,'fake_back')]");
				public static By objfollowingaccountclicked=By.xpath("//*[contains(@resource-id,'txtUserName')]");	
				public static By objfollowvalueprofile=By.xpath("//*[contains(@resource-id,'txtFollowValue')]");	
				public static By objfollowvaluefollowlistpage=By.xpath("//*[contains(@resource-id,'offers_title')]");
				public static By objfollowingvalueprofile=By.xpath("//*[contains(@resource-id,'txtFollowingValue')]");	
				public static By objfollowingvaluefollowinglistpage=By.xpath("//*[contains(@resource-id,'offers_title')]");
				public static By objfollowlistuser=By.xpath("//*[@id='text_user_handle']");
				
				public static By objfollowinglistuser=By.xpath("//*[contains(@resource-id,'music_name')]");
				
				public static By objeditprofilepage=By.xpath("//*[contains(@resource-id,'my_edit_profile_text')]");
				public static By objeditprofilepagebackbtn=By.xpath("//*[contains(@resource-id,'imgBack')]");
				public static By objeditprofilepageeditbtn=By.xpath("//*[contains(@resource-id,'imgEdit')]");
				public static By objeditprofilepageimage=By.xpath("//*[contains(@resource-id,'assetCover')]");	
				public static By objeditprofilepagefirstname=By.xpath("//*[contains(@resource-id,'firstNameEditText')]");
				public static By objeditprofilepagelastname=By.xpath("//*[contains(@resource-id,'lastNameEditText')]");
				public static By objeditprofilepagehandle=By.xpath("//*[contains(@resource-id,'userHandleEditText')]");
				public static By objeditprofilepagedob=By.xpath("//*[contains(@resource-id,'dobEditText')]");
				public static By objeditprofilepagebio=By.xpath("//*[contains(@resource-id,'userBioEditText')]");
				public static By objeditprofilepageuploadusingcamera=By.xpath("//*[@text='Upload using Camera']");
				public static By objeditprofilepageuploadusinggallery=By.xpath("//*[@text='Upload using Gallery']");
				public static By objeditprofilepageuploadcancel=By.xpath("//*[@text='Cancel']");
				public static By objeditprofilepageuploadclick=By.xpath("//*[@resource-id='com.android.camera2:id/shutter_button']");
				public static By objeditprofilepageuploadcameradone=By.xpath("//*[@resource-id='com.android.camera2:id/done_button']"); 
				public static By objeditprofilepageenabled=By.xpath("//*[contains(@resource-id,'assetCover') and @enabled='true']");
				public static By objeditprofilepagedone=By.xpath("//*[contains(@resource-id,'btn_yes')]");
				public static By objeditprofilepageyourprofilehasbeenupdatedsuccessfullydialog=By.xpath("//*[@text='Your profile has been updated successfully.']");
				public static By objeditprofilepagesavechangesdialog=By.xpath("//*[@text='Do you want to save these changes ?']");	
				public static By objeditprofilepageduplicatehandledialog=By.xpath("//*[@text='Looks like this handle is taken. Try something fun & new.']");
				public static By objeditprofilepageeditbuttonavailable=By.xpath("//*[contains(@resource-id,'imgPencil')]");
				public static By objeditprofilepagecalendardata=By.xpath("//*[@text='5']");
				public static By objeditprofilepagecalendardata6=By.xpath("//*[@text='6']");
				public static By objeditprofilepagecalendarok=By.xpath("//*[@resource-id='android:id/button1']");
				public static By objeditprofilepagedobcreated=By.xpath("//*[contains(@resource-id,'dobEditText') and @enabled='true']");
				public static By objeditprofilepagebiocountervalue=By.xpath("//*[contains(@resource-id,'textinput_counter')]");
				public static By objprofilepagebio=By.xpath("//*[contains(@resource-id,'txtUserBio')]");
				public static By objprofilepagesharebtn=By.xpath("//*[contains(@resource-id,'share')]");
				public static By objprofilepagesharewidget=By.xpath("//*[@text='Share']");
				public static By objprofilepagesharewidget1=By.xpath("//*[@text='HiPi Profile']");
				public static By objprofilepagebiodialog=By.xpath("//*[contains(@resource-id,'msg_popup')]");
				public static By objfacebookbtn=By.xpath("//*[@text='News Feed' or @text='Facebook']");
				public static By objemail=By.xpath("//*[@contentDescription='Username']");
				public static By objpassword=By.xpath("//*[@contentDescription='Password']");
				public static By objlogin=By.xpath("//*[@content-desc='Log In']");
				public static By objpost=By.xpath("//*[@content-desc='POST']");
				public static By objcontenttobesharedavailable=By.xpath("//*[@contentDescription='About This Content']");
				public static By objbar=By.xpath("//*[@contentDescription='Menu, Tab 6 of 6']");
				public static By objlogout=By.xpath("//*[@content-desc='Log Out, Button 1 of 1']");
				public static By objlog=By.xpath("//*[@text='Log Into Another Account']");
				public static By objdialog=By.xpath("//*[@text='Incorrect Password']");
				public static By objdialognothanks=By.xpath("//*[@text='NO THANKS']");
				public static By objdialogok=By.xpath("//*[@text='OK']");
				public static By objprofilepagedefaulttab=By.xpath("//*[@text='All']");
				public static By objprofilepagevideopublishedavailable=By.xpath("(//*[contains(@resource-id,'videoimg')])[1]");
				public static By objprofilepagevideopublishedpreviewdata=By.xpath("//*[contains(@resource-id,'authorContentTextView')]");
				public static By objpublishingvideo=By.xpath("//*[contains(@resource-id,'publish_video')]");
				public static By objpublishedvideo=By.xpath("(//*[contains(@resource-id,'videoimg')])[1]");
				public static By objpublishedvideodelete=By.xpath("//*[contains(@resource-id,'txt_delete')]");
				public static By objprofiledraft=By.xpath("//*[@text='Draft']");
				public static By objprofiledraftvideo=By.xpath("(//*[contains(@resource-id,'img_upload')])[1]");
				public static By objdraftvideopostpage=By.xpath("//*[@text='Post HiPiT']");
				public static By objdraftvideopostpagebackbtn=By.xpath("//*[contains(@resource-id,'backImage')]");
				
				public static By objdraftvideopostpagemoreoptionbtn=By.xpath("(//*[contains(@resource-id,'more_option')])[1]");	
				public static By objdraftvideopostpageremovebtn=By.xpath("//*[contains(@resource-id,'tvRemove')]");		
				public static By objdraftvideopostpagedeletedialog=By.xpath("//*[@text='Do you want to delete your video ?']");		
				public static By objdraftvideopostpagecancelbtn=By.xpath("//*[@text='Cancel']");			
				public static By objdraftvideopostpageokbtn=By.xpath("//*[@text='OK']");					
				public static By objdraftvideopostpagevideodataavailabletobedeleted=By.xpath("(//*[contains(@resource-id,'desc')])[1]");
				public static By objdraftvideopostpagegotofeed=By.xpath("//*[@text='Go To Feed']");
				public static By objdraftvideopostpagevideonottobedeleted=By.xpath("(//*[contains(@resource-id,'desc')])[1]");
				public static By objdraftvideopostpagesettingsbutton=By.xpath("//*[contains(@resource-id,'imgSetting')]");
		
				public static By objdraftvideodesc=By.xpath("(//*[contains(@resource-id,'desc')])[1]");
				public static By objdraftunpublishvideobtn=By.xpath("//*[contains(@resource-id,'txt_unpublish')]");
				public static By objdraftunpublishvideodialogokbtn=By.xpath("//*[contains(@resource-id,'btn_yes')]");
				public static By objvideounpublisheddialogdonebtn=By.xpath("//*[contains(@resource-id,'btn_yes')]");
				public static By objdraftunpublishedvideodesc=By.xpath("(//*[contains(@resource-id,'desc')])[1]");
				public static By objhipinotificationbutton=By.xpath("//*[contains(@resource-id,'imgNotification')]");
				public static By objhipinotificationaltab=By.xpath("//*[@text='All']");
				public static By objhipinotificationvideotab=By.xpath("//*[@text='Videos']");
				public static By objhipinotificationcommenttab=By.xpath("//*[@text='Comments']");
				public static By objhipinotificationnoticationavailable=By.xpath("//*[contains(@resource-id,'txt_title')]");
				public static By objhipinotificationvideotabdialog=By.xpath("//*[@text='You’re all caught up!']");
				public static By objhipinotificationcommenttabdialog=By.xpath("//*[@text='You’re all caught up!']");
				public static By objvideotobedeleted=By.xpath("(//*[contains(@resource-id,'videoimg')])[1]");
				public static By objdoyouwanttodeletevideoyesbtn=By.xpath("//*[contains(@resource-id,'btn_yes')]");
				public static By objvideotobedeleteddescriptiondata=By.xpath("(//*[contains(@resource-id,'desc')])[1]");
				public static By objvideodeleteddialogdonebtn=By.xpath("//*[contains(@resource-id,'btn_yes')]");
				public static By objprofilepagevideotab=By.xpath("//*[@text='All']");
				public static By objprofilepagefollowerpagedialog=By.xpath("//*[@text='Oops, no results found.']");

				public static By objduplicatehandledata=By.xpath("//*[contains(@resource-id,'txtUserHandle')]");
				
				public static By objaccountdialog=By.xpath("//*[@text='OK']");
				
				
				
				
				public static By objsettingsbutton=By.xpath("//*[contains(@resource-id,'imgSetting')]");
				public static By objpreferences=By.xpath("//*[@text='HiPi Preferences']");
				public static By objvisibilitymode=By.xpath("//*[contains(@resource-id,'visibleMode')]");
				public static By objprofilewhichispublic=By.xpath("//*[contains(@resource-id,'txtUserName')]");
				public static By objdiscover=By.xpath("//*[@text='Discover']");
				public static By objsearchbtn=By.xpath("//*[contains(@resource-id,'editTextSearch')]");
				public static By objsearch=By.xpath("//*[contains(@resource-id,'editTextSearch')]");
				public static By objprofilesetaspublicrecord=By.xpath("(//*[contains(@resource-id,'music_name')])[1]");
				public static By objfolloweronlybtn=By.xpath("//*[@text='Followers-Only']");
				public static By objfolloweronlyenabled=By.xpath("//*[contains(@resource-id,'visibleMode') and @text='Follower Only']");
				public static By objpublicbtn=By.xpath("//*[@text='Public']");
				public static By objpublicenabled=By.xpath("//*[contains(@resource-id,'visibleMode') and @text='Public']");
				
				
				public static By objauthorimageview=By.xpath("//*[contains(@resource-id,'avatarCircleImageView')]");
				public static By objnovideocreateddialog=By.xpath("//*[@text='No video created - Start now to HiPi On!']");	
				public static By objnovideocreatehipibtn=By.xpath("//*[contains(@resource-id,'create_vibes')]");	
				public static By objcreatehipipermissionpicturesrecordvideodialog=By.xpath("//*[@text='Allow ZEE5 to take pictures and record video?']");
				public static By objcreatehipiallowbtn=By.xpath("//*[@text='ALLOW']");
				public static By objcreatehipipermissiondevicedialog=By.xpath("//*[@text='Allow ZEE5 to access photos, media, and files on your device?']");
				public static By objcreatehipipermissionrecordaudiodialog=By.xpath("//*[@text='Allow ZEE5 to record audio?']");
				public static By objcreatehipipermissionreadydialogokbtn=By.xpath("//*[contains(@resource-id,'btn_yes')]");	
				public static By objcreatehipipermissionrecordbtn=By.xpath("//*[contains(@resource-id,'record_btn')]");	
				
				public static By objemailfield=By.xpath("//*[@contentDescription='Username']");

				public static By objnotnow=By.xpath("//*[@text='Not Now']");
				
				
				//one of video
				public static By obOneOfVideo  = By.xpath("(//*[contains(@resource-id,'videoimg')])[1]");
				//Original sound
				public static By objOriginalsoundTab = By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tab_layout']]/*/*[@class='android.widget.ImageView' and ./parent::*[@class='android.widget.LinearLayout']])[2]");
				//view list of sounds in original sound tab.
				public static By objListOfSounds = By.xpath("//*[contains(@resource-id,'lay_root')]");
				
				public static By objListOfSounds1 = By.xpath("(//*[@id='music_name'])[1]");
				
				public static By objUserSound = By.xpath("(//*[@id='music_name'])[1]");
				//Use Sound
				public static By objUseSoundButton = By.xpath("//*[contains(@resource-id,'useSound')]");
				//Tap on the sound
				public static By objTaponthesound = By.xpath("(//*[contains(@resource-id,'music_name')])[1]");
				//Thumbnail of the sound
				public static By objThumbnailofthesound = By.xpath("//*[contains(@resource-id,'image_view')]");
				//added to  your favourite popup
				public static By objAddedfavourite= By.xpath("//*[contains(@resource-id,'addmusic_fav')]");
				//Favourite icon to mark-unmark the sound as favourite.
				public static By objFavouriteicon = By.xpath("//*[contains(@resource-id,'addmusic_fav')]");
				//Remove to  your favourite popup
				public static By objRemovieFavourite= By.xpath("//*[contains(@resource-id,'title_popup')]");
				//sound name 
				public static By objSoundName= By.xpath("//*[contains(@resource-id,'musicTitle')]");
				//sound Duration
				public static By objsoundDuration= By.xpath("//*[contains(@resource-id,'duration')]");
				//Use Sound Icon
				public static By objUsethisSoundIcon= By.xpath("//*[contains(@resource-id,'fab')]");
				//Under Favorites videos 
				public static By objvideosUnderFavorites = By.xpath("//*[contains(@resource-id,'recVideo')]");
				
				public static By objNoFavourites = By.xpath("//*[@text='No Favorites']");
				
				//@userName 
				public static By objuserName  = By.xpath("//*[contains(@resource-id,'txtUserHandle')]");
				//video text
				public static By objVideoText =By.xpath("(//*[contains(@resource-id,'desc')])[1]");
				
				public static By objVideo(String videoname){
					return By.xpath("(//*[@text='"+videoname+"'])[1]");
				}
				//Add to Favorites
				public static By obAddtoFavorites = By.xpath("//*[contains(@resource-id,'txt_favorite')]");
				//Tap on Video favourite icon
				public static By objVideoFavouriteIcon = By.xpath("(//*[contains(@resource-id,'imgFavActive')])[1]");
				//removed popup and a message is displayed at bottom
				public static By objRemovedPopup =By.xpath("//*[contains(@resource-id,'textMsg')]");
				//Do you want to delete your video ? popup
				public static By objDeleteVideoPopUp = By.xpath("//*[contains(@resource-id,'msg_popup')]");
				//Delete Video?
				public static By objDeleteVideo = By.xpath("//*[contains(@resource-id,'txt_delete')]");
				//Video successfully deleted popup
				public static By objVideoSuccessfullyDeletePopUp = By.xpath("//*[contains(@resource-id,'msg_popup')]");
				//Do you want to delete your video YES Button
				public static By objYesButton = By.xpath("//*[contains(@resource-id,'btn_yes')]");
				//Navigation 
				public static By objNavigation = By.xpath("//*[contains(@resource-id,'imgBack')]");

				public static By objHipiProfileScreen = By.xpath("//*[contains(@resource-id,'blurlayout')]");
				//Profile name 
				public static By objProfileName = By.xpath("//*[contains(@resource-id,'txtUserName')]");
				//Bio description
				public static By objBioDescription = By.xpath("//*[contains(@resource-id,'txtUserBio')]");
				//follower count
				public static By objFollowersCount = By.xpath("//*[contains(@resource-id,'txtFollowValue')]");
				//Following count
				public static By objFollowingCount = By.xpath("//*[contains(@resource-id,'txtFollowingValue')]");
				

				public static By objVideoTabIsSelectedByBeafult  = By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tab_layout']]/*[@class='android.widget.LinearLayout' and ./*[@class='android.widget.ImageView']])[1]");

				public static By objprivateTab=By.xpath("//*[contains(@resource-id,'text_private')]");

				public static By objprivateVideosScreen  = By.xpath("//*[@class='android.widget.ImageView' and @selected='true']");

				public static By objUnpublishVideo =By.xpath("//*[contains(@resource-id,'txt_unpublish')]");

				public static By objUnpublishVideoPopUP =By.xpath("//*[contains(@resource-id,'msg_popup')]");

				public static By objSuccessfullyUnpublishPopUp  =By.xpath("//*[contains(@resource-id,'msg_popup')]");

				public static By objNoFavorites = By.xpath("//*[contains(@resource-id,'text_error')]");

				public static By objAddToYourFavourite =By.xpath("//*[contains(@resource-id,'title_popup')]");

				public static By objUndoOption = By.xpath("//*[contains(@resource-id,'btnUndo')]");

				public static By objHipiProfile = By.xpath("//*[contains(@resource-id,'profile_pic')]");

				public static By objMusicDetailScreen = By.xpath("//*[contains(@resource-id,'head_layout')]");

				public static By objVideoScreenUnderDraft = By.xpath("//*[contains(@resource-id,'text_draft')]");

				public static By objVideoScreenUnderPrivat = By.xpath("//*[contains(@resource-id,'privateRecyclerView')]");

				public static By objVideoScreenUnderProfile = By.xpath("//*[contains(@resource-id,'allRecyclerView')]");
			//	public static By objVideoTab = By.xpath("//*[@class='android.widget.ImageView' and @selected='true')]");
				public static By objVideoTab = By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tab_layout']]/*/*[@class='android.widget.ImageView' and ./parent::*[@class='android.widget.LinearLayout']])[1]");
				public static By objClickOnVideo = By.xpath("//*[contains(@resource-id,'adapterView')][1]");
				public static By objfullscreenPlayer = By.xpath("//*[contains(@resource-id,'fragment_kaltura')]");
				public static By objBackVideoListingTab = By.xpath("//*[contains(@resource-id,'backView')]");


				public static By objSoundIsAddedInTheList = By.xpath("//*[contains(@resource-id,'music_name')]");

				public static By objRemovedFavouritepopup=By.xpath("//*[contains(@resource-id,'title_popup')]");

				public static By objRemoveFavouriteInProfile = By.xpath("//*[contains(@resource-id,'addmusic_fav_infav')]");


				public static By objfollowlistuserText(int i)
				{
				return By.xpath("(//*[@id='text_user_handle'])["+i+"]");
				}
				
				public static By objfollowinglistuserText(int i)
				{
				return By.xpath("(//*[contains(@resource-id,'music_name')])["+i+"]");
				}

				public static By objHashtagIsAddedInTheList = By.xpath("//*[contains(@resource-id,'txtGenreName')]");

				public static By objHashtagInFavourite(String hashtag){
					return By.xpath("//*[@id='txtGenreName' and @text='"+hashtag+"']");
				}
				
				public static By objFavouriteIcon = By.xpath("//*[contains(@resource-id,'cart_badge')]");

//				public static By objFollowersUsername=By.id("(//*[@id='userImage'])[1]");
//		        public static By objFollowersProfileUsername=By.id("//*[@id='txtUserName']");
				
				public static By objFollowersUsername=By.xpath("(//*[@id='music_name'])[1]");
		        public static By objFollowersProfileUsername=By.xpath("//*[@id='txtUserName']");

		        public static By objFirstUserInFollowingScreen = By.xpath("(//*[contains(@resource-id,'userImage')])[1]");


		        public static By objFollowingSearchTextBox = By.xpath("//*[@id='editTextSearch']");




	
				public static By objuserimagefirstimage=By.xpath("//*[contains(@resource-id,'circular_first_img')]");
				public static By objuserimageseconduserliked=By.xpath("//*[contains(@resource-id,'circular_second_img')]");
				public static By objuserimagenotification=By.xpath("(//*[contains(@resource-id,'txt_title')])[1]");
				public static By objuserimagenotificationlist=By.xpath("//*[contains(@resource-id,'txt_title')]");
				public static By objauthordata=By.xpath("//*[contains(@resource-id,'authorContentTextView')]");
				public static By objauthorvideonotification=By.xpath("(//*[contains(@resource-id,'img_message')])[1]");
				public static By objnotificationText(int i)
				{
				return By.xpath("(//*[contains(@resource-id,'txt_title')])["+i+"]");
				}
				public static By objmorebutton=By.xpath("//*[contains(@resource-id,'navigationTitleTextView') and @text='More']");
				public static By objlogoutbutton=By.xpath("//*[@text='Logout']");
				public static By objdialoglogoutbutton=By.xpath("//*[contains(@resource-id,'logoutButton')]");
				public static By objregisterdialoginbutton=By.xpath("//*[contains(@resource-id,'btnHiPiLogin')]");
				public static By objdiscovertext=By.xpath("//*[contains(@resource-id,'discovertext')]");
				public static By objdiscoverprofile=By.xpath("(//*[contains(@resource-id,'music_name')])[1]");
				public static By objdiscovervideodata=By.xpath("(//*[@id='videoimg'])[1]");
				
				public static By objdiscovervideocommentbutton=By.xpath("//*[contains(@resource-id,'comment_icon')]");
				public static By objdiscovervideolikebutton=By.xpath("//*[contains(@resource-id,'like_icon')]");
				public static By objdiscovervideosharebutton=By.xpath("//*[contains(@resource-id,'share')]");
				public static By objvideotabtobedeleted=By.xpath("//*[@resource-id='com.zee5.hipi:id/desc']");
				public static By objvideoyesbutton=By.xpath("//*[contains(@resource-id,'btn_yes')]");
				public static By objvideofinishbutton=By.xpath("//*[contains(@resource-id,'finishtext')]");
				public static By objagedialog=By.xpath("//*[@text='Are you 18 yrs+? Add DOB in your HiPi Profile to create your first HiPiT!']");
				public static By objagedialogokbutton=By.xpath("//*[contains(@resource-id,'btn_yes')]");
				public static By objuserimage=By.xpath("(//*[contains(@resource-id,'circular_img')])[1]");
				public static By objcommentbox=By.xpath("//*[contains(@resource-id,'commentBox')]");
				public static By objusercommentnotification=By.xpath("(//*[contains(@resource-id,'txt_title')])[1]");
				public static By objthumnailuserimage=By.xpath("(//*[contains(@resource-id,'circular_img')])[1]");
				public static By objthumnailvideo=By.xpath("(//*[contains(@resource-id,'img_message')])[1]");
				public static By objnotificationcount=By.xpath("//*[contains(@resource-id,'txt_title')]");
				public static By objcommentlikebutton=By.xpath("(//*[contains(@resource-id,'commentlikepics')])[1]");
		        
				//Effect displayed in effects
				public static By objEffectDisplayedInEffects=By.xpath("//*[contains(@resource-id,'txtEffectName')]");
		        
				public static By objdraftvideodata=By.xpath("(//*[contains(@resource-id,'music_name')])[1]");
		        
				public static By objprofiledata=By.xpath("//*[contains(@resource-id,'txtUserHandle')]");
		        
		        
		        
				//Favorite icon on the first video thumbnail
		        public static By objFavoriteIconOnFirstThumbnail = By.xpath("(//*[contains(@resource-id,'imgFavActive')])[1]");
		        //Me page Favorite contents Tabs
		        public static By objFavoriteTabCategoryTab(String category) {
		        	return By.xpath("//*[contains(@resource-id,'tabs')]//*[@text='"+category+"']");
		        }
		        //First Sound content under Favorites
		        public static By objFirstMusicTitleUnderFavorites = By.xpath("(//*[@id='relative_click']//*[contains(@resource-id,'music_name')])[1]"); 
		        //Favorite icon on the first Music
		        public static By objFavoriteIconOnFirstMusicContent = By.xpath("(//*[@id='relative_click']//*[contains(@resource-id,'addmusic_fav_infav')])[1]");
		        
		        
		        public static By objprofilehandledata=By.xpath("//*[contains(@resource-id,'txtUserHandle')]");
		        public static By objsearchaccountdata=By.xpath("(//*[contains(@resource-id,'music_name')])[1]");


		        
		        
		        public static By objregister=By.xpath("//*[@resource-id='com.zee5.hipi:id/btnHiPiRegister']");
		        public static By objfirstname=By.xpath("//*[@resource-id='com.zee5.hipi:id/first_name_input']");  
		        public static By objlastname=By.xpath("//*[@resource-id='com.zee5.hipi:id/last_name_input']");  
		        public static By objdob=By.xpath("//*[@resource-id='com.zee5.hipi:id/dobEditText']");
		        public static By objgender=By.xpath("//*[@resource-id='com.zee5.hipi:id/genderTextView']");  
		        public static By objgendermale=By.xpath("//*[@text='Male']");
		        public static By objregisterpagebtn=By.xpath("//*[@resource-id='com.zee5.hipi:id/registerProgress']");  
		        public static By objsavebtn=By.xpath("//*[@resource-id='com.zee5.hipi:id/btnNext']"); 


		        public static By objcheckbtn=By.xpath("//*[@id='text_input_end_icon']");
		        
		        public static By objpwd=By.xpath("//*[@id='password_input']");
		        
}
