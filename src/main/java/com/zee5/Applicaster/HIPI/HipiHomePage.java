package com.zee5.Applicaster.HIPI;

import org.openqa.selenium.By;

public class HipiHomePage {

	
	public static By objHipiIcon = By.xpath("//*[contains(@resource-id,'bb_bottom_bar_title') and @text='HiPi']");
	
	public static By objSaveBtn = By.xpath("//*[@text='Save']");
	
	
	
	public static By objPlayicon = By.xpath("//*[contains(@resource-id,'playImageView')]");
	
	public static By objShareIcon = By.xpath("//*[contains(@resource-id,'share')] | //*[@resource-id='com.zee5.hipi:id/imgShare']");
	
	public static By objReportVideo = By.xpath("//*[@text='Report Video']");

	public static By objHashtagDescription = By.xpath("//*[contains(@resource-id,'authorContentTextView')]");
	public static By objSoundName = By.xpath("//*[contains(@resource-id,'songNameMTextView')]");
	public static By objSoundDetailScreen = By.xpath("//*[contains(@resource-id,'head_layout')]");


	//Back Button
	public static By objBackButton = By.xpath("//*[contains(@resource-id,'backView')]");
	//comment icon
	public static By objCommentIcon = By.xpath("//*[contains(@resource-id,'comment_icon')]");	
	//comment screen
	public static By objCommentScreen = By.xpath("//*[contains(@resource-id,'commentsCount')]");
	//Click on one comment 
	public static By objOneofComment = By.xpath("//*[contains(@resource-id,'comment')]");

	public static By objClickOnProfileInCommentScreen = By.xpath("//*[contains(@resource-id,'userImage')]");

	
	
	//-------------------------------------------Kartheek------------------------------------------------
		//Profile Icon
		public static By objProfileIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/smallLabel' and @text='Profile']");
		//Home Icon
		public static By objHomeIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/navigation_home']");
		//Description
		public static By objDescription = By.xpath("//*[@resource-id='com.zee5.hipi:id/text_view_account_handle']");
		//Save Look
		public static By objSaveLook = By.xpath("//*[@resource-id='com.zee5.hipi:id/save_look_text']");
		
		public static By objSaveLookProduct = By.xpath("//*[@resource-id='com.zee5.hipi:id/content_image_view']");

		// PIN Animation Circle
		public static By objPINAnimationCircle  = By.xpath("//*[@resource-id='com.zee5.hipi:id/newCharmIndicator']");
		//Allright! Got it
		public static By objAllrightGotIt = By.xpath("//*[@text='Allright! Got it']");
		//Ok, Cool
		public static By objOkCool = By.xpath("//*[@text='Ok, Cool']");
		
		//Shop Button
		public static By objShopButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/shopNowTv']");
		// product image 1
		public static By objProductImage = By.xpath("(//*[@resource-id='com.zee5.hipi:id/content_image_view'])[1]");
		// product image 2
		public static By objProductImage2 = By.xpath("(//*[@resource-id='com.zee5.hipi:id/content_image_view'])[2]");
		// product image 3
		public static By objProductImage3 = By.xpath("(//*[@resource-id='com.zee5.hipi:id/content_image_view'])[3]");
				
		//For You 
		public static By objForYou = By.xpath("//*[@resource-id='com.zee5.hipi:id/rbForYou']");
		//For You highlighted
		public static By objForYouhigHlighted = By.xpath("//*[@resource-id='com.zee5.hipi:id/rbForYou' and @checked='true']");
		//Player Screen
		public static By objPlayerScreen = By.xpath("//*[@resource-id='com.zee5.hipi:id/exo_overlay']");
		// Following  Button
		public static By objFollowingButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/rbFollowing']");
		//Following  Button highlighted
		public static By objFollowingButtonHighlighted = By.xpath("//*[@resource-id='com.zee5.hipi:id/rbFollowing' and @checked='true']");
		//Login Button Following screen
		public static By objFollowCTAFollowingScreen = By.xpath("//*[@resource-id='com.zee5.hipi:id/followBtn']");
		//Discover Button
		public static By objDiscoverButton = By.xpath("//*[@class='android.widget.TextView' and @text='Discover']");
		//Saved CTA
		public static By objSavedCTAText = By.xpath("//*[@text='SAVED']");
		//Save Look CTA
		public static By objSaveLookCTAText = By.xpath("//*[@text='DISCOVER\\nTHE LOOK']");
		//close button carousel sheet
		public static By objCloseButtonCarouselSheet = By.xpath("//*[@resource-id='com.zee5.hipi:id/closeProducts']");
		//video create Icon OR + Icon
		public static By objVideoCreateIcon = By.xpath("//*[contains(@resource-id,'navigation_inbox')]");
		//playbutton
		public static By objplaybutton=By.xpath("//*[@resource-id='com.zee5.hipi:id/volumne_indicator']");
		//Profile Picture		
		public static By objProfilePicture=By.xpath("//*[@resource-id='com.zee5.hipi:id/image_view_profile_pic']");
		//Plus Follow ICON
		public static By objPlusFollowICON=By.xpath("//*[@resource-id='com.zee5.hipi:id/image_view_follow_option']");
		//Like Icon
		public static By objLikeICON=By.xpath("//*[@resource-id='com.zee5.hipi:id/image_view_option_like']");
		//Comment icon
		public static By objCommentICON=By.xpath("//*[@resource-id='com.zee5.hipi:id/image_view_option_comment']");
		//Share icon
		public static By objShareICON=By.xpath("//*[@resource-id='com.zee5.hipi:id/image_view_option_share']");
		//Heart symbol
		public static By objHeartICON=By.xpath("//*[@resource-id='com.zee5.hipi:id/shop_icon']");
		// Hashtag Button
		public static By objHashtagButtonDescription =By.xpath("//*[@resource-id='com.zee5.hipi:id/text_view_video_description']");
		//Music button below left side
//		public static By objMusicButtonBelowLeftSide=By.xpath("//*[@resource-id='com.zee5.hipi:id/text_view_music_title']");
		
		public static By objMusicButtonBelowLeftSide=By.xpath("//*[contains(@id,'text_view_music_title')]");

		// Like Count
		public static By objLikeCount=By.xpath("//*[@resource-id='com.zee5.hipi:id/image_view_option_like_title']");
		//Comment Count
		public static By objCommentCount=By.xpath("//*[@resource-id='com.zee5.hipi:id/image_view_option_comment_title']");
		//Save Video
		public static By objSaveVideo=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvSaveOption']");
		//Add To Favourites
		public static By objAddToFavourites=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvFavOption']");
		//Report
		public static By objReport=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvReportOption']");
		//Not Interested
		public static By objNotInterested=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvIntrestOption']");
		//Video saved
		public static By objVideoSaved=By.xpath("//*[@resource-id='com.zee5.hipi:id/title_popup']");
		//Add a comment
		public static By objAddAComment=By.xpath("//*[@resource-id='com.zee5.hipi:id/commentBox']");
		//Comment post Icon
		public static By objCommentPostIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/commentPost']");
		//First Comment
		public static By objFirstComment=By.xpath("(//*[@id='likeListRecyclerView']/*/*[@id='comment'])[1]");
		//First Comment User Name
		public static By objFirstCommentUserName=By.xpath("(//*[@id='likeListRecyclerView']/*/*[@id='userName'])[1]");
		//Comment Text
		public static By obCommentText=By.xpath("(//*[@resource-id='com.zee5.hipi:id/comment'])[1]");

		//Other user Profile Picture
		public static By objOtherUserProfilePicture=By.xpath("(//*[@id='likeListRecyclerView']/*/*[@id='userImage'])[1]");
		//Like Icon Comment Screen
		public static By objLikeIconCommentScreen=By.xpath("(//*[@id='likeListRecyclerView']/*/*[@id='commentLike'])[1]");
		//Like Count Comment Screen 
		public static By objLikeCountCommentScreen=By.xpath("(//*[@id='likeListRecyclerView']/*/*[@id='commentLikeCount'])[1]");
		//Report Video Title
		public static By objReportVideoTitle=By.xpath("//*[@resource-id='com.zee5.hipi:id/offers_title']");
		//First Reason
		public static By objFirstReason=By.xpath("(//*[@id='recyclerView']/*[@id='tvReason'])[1]");
		//Report Description
		public static By objReportDescription=By.xpath("//*[@resource-id='com.zee5.hipi:id/descedit']");
		//Attachment Option
		public static By objAttachmentOption=By.xpath("//*[@resource-id='com.zee5.hipi:id/fileAttach']");
		//Select gallery image
		public static By objSelectGalleryImage=By.xpath("//*[@id='imageView' and (./preceding-sibling::* | ./following-sibling::*)[@id='tvSelected']]");
		//Done Option Gallery Page
		public static By objDoneOptionGalleryPage=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvNext']");
		//Submit Button Report Video Page
		public static By objSubmitButtonReportVideoPage=By.xpath("//*[@resource-id='com.zee5.hipi:id/nextBtn']");
		
		//User Name
		public static By objUserName=By.xpath("//*[@resource-id='com.zee5.hipi:id/text_view_account_handle'] | //*[@resource-id='com.zee5.hipi:id/userName']");
		//List of Hashtag
		public static By objListOfHashtag=By.xpath("//*[@resource-id='com.zee5.hipi:id/rv_auto_suggestion']");

		
		
		   //==================================Deepa====================================================
				//Exit title	
				public static By objExit=By.xpath("//*[@resource-id='android:id/alertTitle']");
				// Are you Sure Want To Exit Text
				public static By objAreYouSureWantToExitText = By.xpath("//*[@resource-id='android:id/message']");
				//No CTA
				public static By objNoCTA = By.xpath("//*[@resource-id='android:id/button2']");
				//Yes CTA
				public static By objYesCTA= By.xpath("//*[@resource-id='android:id/button1']");
				//Comment screen Title
				public static By objCommentTitle = By.xpath("//*[@resource-id='com.zee5.hipi:id/commentsCount']");
				//Login to follow users
				public static By objLoginToFollowUsers = By.xpath("//*[@resource-id='com.zee5.hipi:id/errorTextView']");
				
				//tapping outsside the popup 
				public static By objTappingOutssideThePopup  = By.xpath("//*[@resource-id='com.android.systemui:id/status_bar_container']");

		//-------------------------------------------------
				// share to Facebook icon
				public static By objSharetofacebook= By.xpath("//*[@id='icon' and (./preceding-sibling::* | ./following-sibling::*)[@text='News Feed']]");
				//share Facebook un textfield
				public static By objShareFbUsername= By.xpath("//*[@contentDescription='Username']");
				//share Facebook un textfield
				public static By objShareFbPassword= By.xpath("//*[@contentDescription='Password']");		
				//Share screen facebook login button
				public static By objShareFbLoginBtn= By.xpath("//*[@contentDescription='Log In']");		
				//Share screen header facebook 
				public static By objFbnewsfeedHeader= By.xpath("//*[@text and @class='android.widget.Button']");
				//Share With News Feed
				public static By objShareWithNewsFeed= By.xpath("//*[@text='News Feed']");
				//Post Button
				public static By objPostButton= By.xpath("//*[@contentDescription='POST']");

				public static By objSwipe= By.xpath("(//*[@resource-id='com.zee5.hipi:id/recyclerView'])[1]");

				public static By objShareButtons= By.xpath("//*[@id='title']");

			public static By objShareoptions(int index) {
				return By.xpath("(//*[@id='title'])[" + index + "]");
				
			}
				public static By objLikeIconCoomentScreen(int index) {
					return By.xpath("(//*[@resource-id='com.zee5.hipi:id/commentLike'])[" + index + "]");
				}
				public static By objLikeCountCoomentScreen(int index) {
					return By.xpath("(//*[@resource-id='com.zee5.hipi:id/commentLikeCount'])[" + index + "]");
				}
				//Player Screen for filters/effects
				public static By objPlayerScreenForFilters = By.xpath("//*[@resource-id='com.zee5.hipi:id/layout']");
				//Create New Facebook Account 
				public static By objCreateNewFacebookAccount = By.xpath("//*[@content-desc='Create new Facebook account']");

				//===========================new============================ 
				
				//Follow Button 
				public static By objFollowButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/follow_btn']");
				

				//For You In Browser
				public static By objForYouInBrowser = By.xpath("/html/body/div[2]/div[1]/div[1]/div[4]/div/span[2]");

				//Effect Option								
				public static By objEffectOption= By.xpath("//*[@resource-id='com.zee5.hipi:id/text_view_effect_title']");
				
				//Filter Option
				public static By objFilterOption= By.xpath("//*[@resource-id='com.zee5.hipi:id/text_view_filter_title']");
				
				public static By objHomescreenShareIcon = By.xpath("(//*[contains(@resource-id,'share')])[1]");
				public static By objDuet = By.xpath("//*[@id='duetVideo']");
				public static By objDuetScreenRecord = By.xpath("//*[@id='record_btn']");
				public static By objCommentscreenTextField = By.xpath("//*[@id='commentBox']");
				
				//Comment Box
				public static By objCommentBox = By.xpath("//*[@id='image_view_option_comment']");

				public static By objFeedScreenMore = By.xpath("//*[contains(@text,'MORE')]");
				public static By objFeedScreenHashTag = By.xpath("//*[contains(@text,'#')]");


				public static By objFeedScreenLess = By.xpath("//*[contains(@text,'LESS')]");

				
				public static By objFollowingTabCtreatorAccount = By.xpath("//*[@id='userHandle']");
				public static By objFollowingTabFollowCta = By.xpath("(//*[@id='followBtn'])[2]");
				public static By objFollowingTabFollowText = By.xpath("//*[@id='follow_account']");
				public static By objFollowingTabUsername = By.xpath("//*[@id='userName']");
				public static By objFollowingTabUserprofile = By.xpath("//*[@id='imageView']");
				public static By objFollowingTabFollowingCta = By.xpath("//*[@id='followBtn'and @text='Following']");
				public static By objShareScreenAddToFavorites = By.xpath("//*[@id='addFavTitle']");
				public static By objShareScreenSaveVideo = By.xpath("//*[@id='saveVideoTitle']");
				public static By objShareScreenReport = By.xpath("//*[@id='reportVideoTitle']");
				public static By objShareScreenNotInterested = By.xpath("//*[@id='intrstVideoTitle']");
				public static By objSoundscreenOriginal = By.xpath("//*[@id='txtPopular']");
				public static By objSoundAuthorName = By.xpath("//*[@id='authorName']");
				public static By objOriginalSoundText = By.xpath("//*[contains(@text,'Original Sound')]");
				public static By objRaisingStar = By.xpath("//*[@id='txtPopular']");

				public static By objShareToTitleOption=By.xpath("//*[contains(@id,'Title')]");
				
				public static By objShareToTitleOption(int index) {
					return By.xpath("(//*[contains(@id,'Title')])[" + index + "]");}
				public static By objVerifySound(String Text) {
					return By.xpath("//*[contains(@text,'"+Text+"')]");}
				public static By objWaitComment=By.xpath("//*[@text='Hi Few seconds ago']");

				
				public static By objProgressBarID=By.xpath("//*[@id='exo_progress']");

				public static By objProgressBar=By.xpath("//*[@resource-id='com.zee5.hipi:id/exo_progress']");
				
				public static By objVideoUIID=By.xpath("//*[@resource-id='com.zee5.hipi:id/videoId']");
					
				public static By objCountOfUnreadNotifications=By.xpath("//*[@resource-id='com.zee5.hipi:id/badge_text_view']");
					
				
					
				public static By objmonetizationCard=By.xpath("//*[@resource-id='com.zee5.hipi:id/content_image_view']");

				
				
				public static By objDownloadNow=By.xpath("//*[@resource-id='com.zee5.hipi:id/vmaxAdKnowMore']");
				public static By objUpdate=By.xpath("//*[@text='Update']");
				public static By objCancelDownload=By.xpath("//*[@contentDescription='Cancel this download']");
				
				public static By objDone=By.xpath("//*[@resource-id='com.zee5.hipi:id/snackbar_action']");
				
				
				public static By objEngleshButton=By.xpath("//*[@resource-id='com.android.chrome:id/translate_infobar_tab_text' and @text='English']");
				
				public static By objCrossIcon=By.xpath("//*[@resource-id='com.android.chrome:id/infobar_close_button']");
				
				
				public static By objRewardsPage=By.xpath("//*[@resource-id='com.zee5.hipi:id/rewards_text']");
				
				public static By objClaimNowButton = By.xpath("//*[@text='Claim Now']");			}
			
				//public static By objCrossIcon = By.xpath("//*[@resource-id='com.android.chrome:id/infobar_close_button']");

