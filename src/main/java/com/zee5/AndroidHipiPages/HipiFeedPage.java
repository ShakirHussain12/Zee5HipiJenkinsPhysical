package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiFeedPage {

	public static By objNotificationIcon = By.xpath("//*[@id='imgNotification']");
	
	public static By objNotificationVideosTab = By.xpath("//*[@text='Videos']");
	
	public static By objNotificationCommentTab = By.xpath("//*[@text='Comments']");
	
	public static By objNotificationLikeText = By.xpath("(//*[@id='txt_title'])[1]");
	
	public static By objNotificationCommentText = By.xpath("(//*[@id='txt_title'])[1]");
	
	public static By objTumbnailInNotification = By.xpath("(//*[@id='img_message'])[1]");
	
	public static By objProfilePicInNotification = By.xpath("(//*[@id='circular_first_img' or @id='circular_img'])[1]");
	
	public static By objDiscoverButton = By.xpath("//*[@class='android.widget.TextView' and @text='Discover']");
	
	public static By objFeedButton = By.xpath("//*[contains(@resource-id,'feedimage')]");
	
	public static By objbackbtn=By.xpath("//*[contains(@resource-id,'imgBack')]");
	
	public static By objFollowingUser = By.xpath("(//*[@id='music_name'])[1]");
	//backviewinfeed
	public static By objbackviewinfeed=By.id("com.zee5.hipi:id/backView");
	//Hipiicon
	public static By objHipiIcon=By.xpath("//*[@class='android.widget.TextView' and @text='HiPi']");
	//morezee5rail
	public static By objmorezee5rail=By.xpath("//*[@class='android.widget.TextView' and @text='More on ZEE5']");
	//internetpopup
	public static By objinternetpopup=By.xpath("//*[@text='Network Error']");
	//hipishortvideos
	public static By objHipishortvideos=By.xpath("((//*[@class='android.widget.TextView' and @text='HiPi Short Videos'])//parent::*)[1]");
	
	public static By objdescription=By.xpath("//*[contains(@resource-id,'authorContentTextView')]");
	
	public static By objdescription2=By.xpath("//*[contains(@resource-id,'authorContentTextView')]");
	//playbutton
	public static By objplaybutton=By.xpath("//*[contains(@resource-id,'playImageView')]");
	//progress bar
	public static By objprogressbar=By.xpath("//*[contains(@resource-id,'videoprogressBar')]");
	//soundused
	public static By objsoundused=By.xpath("//*[contains(@resource-id,'songNameMTextView')]");
	//likecount
	//public static By objlikecount=By.id("com.zee5.hipi:id/likeCount");
	public static By objlikecount=By.xpath("//*[@id='likeCount']");
	
	//commenticon
	public static By objcommenticon=By.id("com.zee5.hipi:id/comment_icon");
	
	public static By objEmptyCommentBox=By.xpath("//*[@id='commentBox']");
	
	//backbuttonin effectused
	public static By objbackbuttonineffect=By.xpath("//*[contains(@resource-id,'backView')]");
	//backbuttonineffect
	public static By objbackbutton=By.xpath("//*[contains(@resource-id,'img_back')]");
	//longpress
	public static By objFeedLongPress=By.xpath("//*[@class='android.widget.LinearLayout'] ");
	//downloadvideo
	public static By objdownloadvideo=By.xpath("//*[@text='Download Video']");
	
	public static By objVideoSavedPopup=By.xpath("//*[@text='Video Saved!']");
	//favourites
	public static By objfavourites=By.xpath("//*[@text='Add to Favorites']");
	//report video
	public static By objreportvideo=By.xpath("//*[@text='Report Video']");
	//notinterested
	public static By objnotinterested=By.xpath("//*[@text='Not Interested']");
	//share
	public static By objshare=By.xpath("//*[contains(@resource-id,'share')]");
	//registerpopup
	public static By objRegisterPop=By.id("com.zee5.hipi:id/title_registerforVibe");
	
	public static By objCreateVideoIcon = By.xpath("//*[contains(@resource-id,'createvideoimage')]");
	
	
	
	
	public static By objfeed=By.id("com.zee5.hipi:id/feedimage");
	//foryou
	public static By objforyou=By.xpath("//*[contains(@resource-id,'forYou')]");
	//profileimagecircle
	public static By objprofilepic=By.xpath("//*[contains(@resource-id,'avatarCircleImageView')]");
	//follow
	public static By objfollow=By.xpath("//*[contains(@resource-id,'txtEditProfile')]");
	//followingcount
	public static By objfollowingcount=By.xpath("//*[contains(@resource-id,'txtFollowingValue')]");
	//following
	public static By objfollowing=By.xpath("//*[contains(@resource-id,'txtFollowing')]");
	//following title
	public static By objfollowingtitle=By.xpath("//*[contains(@resource-id,'offers_title')]");
	//followinglistusername
	public static By objfollowinglistusername=By.xpath("//*[contains(@resource-id,'music_name')]");
	//followinginfeed
	public static By objfollowinginfeed=By.xpath("//*[contains(@resource-id,'following')]");
	//followingprofilepic
	public static By objfollowingprofilepic=By.xpath("//*[contains(@resource-id,'avatarCircleImageView')]");
	//following listbackbutton
	public static By objfollowinglistbackbutton=By.xpath("//*[contains(@resource-id,'back')]");
	//back in profile
	public static By objbackinprofile=By.xpath("//*[contains(@resource-id,'imgBack')]");
	//backbuttoninselectedprofile'
	public static By objbackbuttoninselectedimage=By.xpath("//*[contains(@resource-id,'imgBack')]");
	//followinginprofile
	public static By objfollowinginprofile=By.xpath("//*[contains(@resource-id,'txtEditProfile') and @text='Following']");
	//novideo
	public static By objNoResultsFoundInFollowing=By.xpath("//*[contains(@resource-id,'txt_no_data_found')]");
	
	//afvouritesound
			public static By objfavouritesound=By.xpath("//*[contains(@resource-id,'addmusic_fav')]");

			//favouritemessagepopup
			public static By objfavouritepopop=By.xpath("//*[contains(@resource-id,'msg_popup')]");

			//musictitle
			public static By objmusictitle=By.xpath("//*[contains(@resource-id,'musicTitle')]");

	
			
			public static By objMeImage= By.xpath("//*[@id='meimage']");
			
			public static By objPopularImage = By.xpath("//*[@id='challengesimage']");

			public static By objchooseLanguageORGeners = By.xpath("//*[@text='Choose Genres' or @text='Choose Content Language']");
			
			public static By objCommentCount = By.xpath("//*[@id='commentCount']");
			
			public static By objCommentsCommentCount = By.xpath("//*[@id='commentsCount']");

			public static By objLikeIcon = By.xpath("//*[@id='like_icon']");

			public static By objPlusIconOnProfileImage = By.xpath("//*[@id='follow_icons']");

			//public static By objfeed=By.xpath("//*[@id='feedimage']");
			
			public static By objPopularCreators =By.xpath("//*[@text='Popular Creators']");
			
			public static By objPopularCreatorCards =By.xpath("//*[@id='item_name']");

			public static By objCreatorName(int index) {
				return By.xpath("(//*[@id='item_name'])[" + index + "]");
			}
			
			
			public static By objProfileFollowicon = By.xpath("//*[@id='follow_icons']");
			
			public static By objfollowicon=By.xpath("//*[contains(@resource-id,'txtEditProfile') and @text='Follow']");
			//followingicon
			public static By objfollowingicon=By.xpath("//*[contains(@resource-id,'txtEditProfile') and @text='Following']");
			//followerscount
			public static By objfollowerscount=By.xpath("//*[contains(@resource-id,'txtFollowValue')]");
			
			//videosavedpopup
			public static By objvideosavedpopup=By.xpath("//*[contains(@resource-id,'title_popup')]");
			
			//mobiledatapopup
			public static By objmobiledatapopup=By.xpath("//*[contains(@resource-id,'tv_message')]");
			//ok
			public static By objokbutton=By.xpath("//*[contains(@resource-id,'btn_yes')]");
			//profilepiccreator
			public static By objprofilepiccreator=By.xpath("//*[contains(@resource-id,'likerImage')]");
			
			public static By objProfilePicWithComment=By.xpath("(//*[@id='userImage'])[1]");
			
			public static By objselectcategory=By.xpath("//*[contains(@resource-id,'subTypeLabel')]");
			//categorytype
			public static By objcategorytype=By.xpath("//*[contains(@resource-id,'reportCheck') and @text='Violent and graphic']");
//description
			public static By objdescriptiontext=By.xpath("//*[contains(@resource-id,'descedit')]");
//attachbutton
			public static By objattachbutton=By.xpath("//*[contains(@resource-id,'fileAttach')]");
			//submitbutton
			public static By objsubmitbutton=By.xpath("//*[contains(@resource-id,'nextBtn')]");
			//descriptionlayer
			public static By objdescriptionlayer=By.xpath("//*[contains(@resource-id,'descLayer')]");
			//attachthumbnailone
			public static By objattachthumbnailone=By.xpath("//*[@resource-id='com.google.android.documentsui:id/icon_thumb'][1]");
			//videoreportpopup
			public static By objreportvideopopup=By.xpath("//*[contains(@resource-id,'title_popup')]");
			//backbuttoninreportvideo
			public static By objbackbuttonreportvideo=By.xpath("//*[contains(@resource-id,'backview')]");
			//reportvideodescription
			public static By objreportvideodescriptioncounter=By.xpath("//*[contains(@resource-id,'textinput_counter')]");
			//emoji
			public static By objemogitype=By.xpath("//*[@id='icon' and ./parent::*[@id='key_pos_switch_to_next_language']]");
			//emojitype1
			public static By objemojitype1=By.xpath("//*[@resource-id='com.google.android.inputmethod.latin:id/emoji_view'][1]");
			//commentbox
			//public static By objcommentbox=By.xpath("//*[contains(@resource-id,'commentBox']");
			//paste
			public static By objpaste=By.xpath("//*[@text='Paste']");

			public static By objCommentHeartIconGrey=By.xpath("(//*[@id='commentlikepics'])[1]");
			public static By objCommentHeartIconGrey1=By.xpath("(//*[@id='commentlikepics'])[2]");

			public static By objCommentHeartIconRed=By.xpath("(//*[@id='commentlikepics'])[1]");
			public static By objCommentHeartIconRed1=By.xpath("(//*[@id='commentlikepics'])[2]");
	
			
			public static String FeedScreen = ("Feed");

			public static By objHeartIcon=By.xpath("//*[@id='like_icon']");

			public static By objHeartIconGrey=By.xpath("//*[@id='like_icon' and @selected='false']");
						
			public static By objHeartIconRed=By.xpath("//*[@id='like_icon' and @selected='true']");
			
			public static By objBottomMenuHighlighted1(String page) {
				return By.xpath("//*[@text='"+page+"' and @selected='true']");
			}
			//LIKECOMMENT
			public static By objlikecomment=By.xpath("//*[contains(@resource-id,'commentlikepics')][1]");
			//commentlikecount
			public static By objcommentlikecount=By.xpath("(//*[contains(@resource-id,'commentlikecount')])[1]");
			public static By objcommentlikecount1=By.xpath("(//*[contains(@resource-id,'commentlikecount')])[2]");
			//commentcount
			public static By objcommentcountundercomment=By.xpath("//*[contains(@resource-id,'commentsCount')]");
         //adddtofavouritepopupinfeed
			public static By objaddtofavouritepopup=By.xpath("//*[contains(@resource-id,'title_popup')]");
			//timeofcomment
			public static By objtimeofcomment=By.xpath("(((((//*[contains(@resource-id,'comment')])//parent::*//parent::*)[1])//child::*)[12])");

			public static By objcommentcount=By.xpath("//*[contains(@resource-id,'commentCount')]");
			//eyeicon
			public static By objeyeicon=By.xpath("//*[contains(@resource-id,'videoViews')]");
			//downnloadpopup
			public static By objdownloadpopup=By.xpath("//*[contains(@resource-id,'title_popup')]");
		//commentpopup
			public static By objcommentpopup=By.xpath("//*[@text='Be the first to comment!']");
			//profilepiccomment
			public static By objprofilepiccomment=By.xpath("//*[contains(@resource-id,'likerImage')]");
			//commentperson
			public static By objcommentperson=By.xpath("//*[contains(@resource-id,'comment')][1]");
			//commenttitle
			public static By objcommenttitle=By.xpath("//*[contains(@resource-id,'commentsCount')]");
			//registerlogin
			public static By objloginregister=By.xpath("//*[contains(@resource-id,'btnHiPiLogin')]");
//descriptioncomment
			public static By objcommentdescription=By.xpath("//*[contains(@resource-id,'textinput_counter')]");
			
			public static By objFirstCommentFromCommentScreen=By.xpath("(//*[@id='comment'])[1]");
			
			//commentbox
			public static By objcommentbox=By.xpath("//*[contains(@resource-id,'commentBox')]");
			public static By objFeedCommentorProfilepicDataundercomment=By.xpath("(//*[contains(@resource-id,'comment')])[1]");
			//nameused
			public static By objnameused=By.xpath("//*[contains(@resource-id,'music_name')][1]");
			//framelayutfirst
			public static By objframelayoufirst=By.xpath("//*[contains(@resource-id,'videoimg')][1]");
	//selectreason
			public static By objselectreason=By.xpath("//*[contains(@resource-id,'mainTypeLabel')]");
	//reasontype
			public static By objreasontype=By.xpath("//*[contains(@resource-id,'reportCheck') and @text='Violence & graphic']");

			public static By objNotInterestedPopup=By.xpath("//*[@id='title_popup']");
	
			public static By objUseThisSoundCTA = By.xpath("//*[@id='fab_text']");
			
			public static By objHipiFeedScreen=By.xpath("//*[contains(@resource-id,'home_activity_layout')]");

			public static By objBottomMenuHighlighted=By.xpath("(//*[ @selected='true'])[1]");

			//Feed Screen Back Button
			public static By objFeedScreenBackButton = By.xpath("//*[contains(@resource-id,'backView')]");

			//Feed Screen
			public static By objFeedPlayerScreen = By.xpath("(//*[contains(@resource-id,'share')]//parent::*//parent::*//parent::*//parent::*)[1]");
			//Download Complete Popup
			public static By objDownloadCompletePopup = By.xpath("//*[contains(@resource-id,'msg_popup') and contains(text(),'Download Complete')]");


			public static By objTextFewSecondsAgo=By.xpath("(//*[@class='android.widget.TextView'])[3]");
			public static By objDeleteComment=By.xpath("//*[@id='delete_comment']");
			public static By objComment=By.xpath("(//*[@id='comment'])[1]");
			public static By objlikecomment2=By.xpath("(//*[contains(@resource-id,'commentlikepics')])[2]");
			public static By objPause=By.xpath("//*[@id='bottomLayer']");
			public static By objComments=By.xpath("(//*[@id='rootCommentCopy'])");
			
			
			public static By objFacebook = By.xpath("//*[@text='News Feed' or @text='Facebook']");
			public static By objFacebookPost = By.xpath("//*[@text='POST' or @text='Post' or @text='Share' or @text='SHARE' or @contentDescription='POST' or @contentDescription='Post']");

			
			public static By objDownloadsOption = By.xpath(
					"//*[@id='bb_bottom_bar_icon' and (./preceding-sibling::* | ./following-sibling::*)[@text='Downloads']]");
			
			// Search icon
			public static By objSearchIcon2 = By.xpath("((//*[@id='title'] | //*[@id='logo'])//following::*)[1]");
			
			public static By objSearchEditBox = By.xpath("//*[@id='searchToolbarTitle']");

			public static By objSearchBoxBar = By.xpath("//*[@resource-id='com.graymatrix.did:id/searchBar']");
			
			public static By objSelectFirstEpisodeResult = By.xpath("//*[@id='item_secondary_text'][1]");
			
			public static By objHashTagHeader = By.xpath("//*[@id='hashtagName']");
			
//----------------------------------Kartheek Reddy----------------------------------------------------
	
	
			
			
			public static By objHashTagBackButton = By.xpath("//*[@id='imgBack']");
			public static By objHashTagThumbnail = By.xpath("//*[@id='hashImage']");
			public static By objfollowingsinfeed=By.xpath("//*[contains(@resource-id,'Following')]");
			
			
			
			
			
}
