package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiProfilePage {

//----------------------------------------Kartheek Reddy-----------------------------------------------------
	
	//shoppable tab
	public static By objShoppableTab = By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tab_layout']]/*/*[@class='android.widget.ImageView' and ./parent::*[@class='android.widget.LinearLayout']])[2]");
	//No shoppable Videos
	public static By objNoShoppableVideos = By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");
	//Shoppable Videoso
	public static By objShoppableVideosIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/ivShop']");
	// 3 Dots
	public static By objThreeDots = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgSetting']");
	//Profile Header
	public static By objProfileHeader = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtUserHandle']");
	//User Profile Picture
	public static By objProfilePicture = By.xpath("//*[@resource-id='com.zee5.hipi:id/profile_pic']");
	//Find Frieds icon
	public static By objFindFriedsIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgAddUser']");
	// Notification bell
	public static By objNotificationBell = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgNotification']");
	
	//Follow CTA
	public static By objFollowCTAText = By.xpath("//*[@text='Follow']");
	
	
	//Follow CTA
		public static By objFollowCTA = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvFollow']");

	//Following
	public static By objFollowing = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtFollowing']");
	//Followers 
	public static By objFollowers = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtFollow']");
	//Like sections
	public static By objLikeSections = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtLike']");
	//Edit profile
	public static By objEditProfile = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtEditProfile']");
	//Save video
	public static By objFavoritesButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgOption']");
	//List of video section
	public static By objListOfVideoSection = By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tab_layout']]/*/*[@class='android.widget.ImageView' and ./parent::*[@class='android.widget.LinearLayout']])[1]");
	//private video tab
	public static By objPrivateVideoTab= By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tab_layout']]/*/*[@class='android.widget.ImageView' and ./parent::*[@class='android.widget.LinearLayout']])[3]");
	//video under All tabs
	public static By objVideoUnderAllTabs= By.xpath("//*[@resource-id='com.zee5.hipi:id/imgLayout']");
	//Share Button
	public static By objShareButton= By.xpath("//*[@resource-id='com.zee5.hipi:id/share_profile']");
	//Back Button
	public static By objBackButton= By.xpath("//*[@resource-id='com.zee5.hipi:id/imgBack']");
	//Drafts Videos
	public static By objDraftVideo= By.xpath("(//*[@id='draftsVideosRecycleraView']/*/*[@id='title'])[1]");

	//Find Friends 
		public static By objFindFriendsScreen=By.xpath("//*[@resource-id='com.zee5.hipi:id/my_edit_profile_text']");
	//Sounds Tab 
		public static By objSoundsTab=By.xpath("//*[@contentDescription='Sounds']");

		//Sounds Tab 
				public static By objSoundsList=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtGenreName']");

		
				public static By objSearchResultOnFollowers(String SearchResultText) {
					return By.xpath("//*[@resource-id='com.zee5.hipi:id/music_name' and @text='" + SearchResultText + "']");
				}
				
		//Hashtags Selected
				public static By objHashtagsSelected=By.xpath("//*[@contentDescription='Hashtags']//child::*[@selected='true']");
		//Video Selected
				public static By objVideoSelected=By.xpath("//*[@contentDescription='Videos']//child::*[@selected='true']");
		//Sounds Selected
				public static By objSoundsSelected=By.xpath("//*[@contentDescription='Sounds']//child::*[@selected='true']");
		//Effects Selected
				public static By objEffectsSelected=By.xpath("//*[@contentDescription='Effects']//child::*[@selected='true']");
	//Filters Selected
				public static By objFiltersSelected=By.xpath("//*[@contentDescription='Filters']//child::*[@selected='true']");
	//	Hashtags
				public static By objHashtags=By.xpath("//*[@contentDescription='Hashtags']");
	//Video
				public static By objVideo=By.xpath("//*[@contentDescription='Videos']");
	//Sounds
				public static By objSounds=By.xpath("//*[@contentDescription='Sounds']");
	//Effects
				public static By objEffects=By.xpath("//*[@contentDescription='Effects']");
	//Filters
				public static By objFilters=By.xpath("//*[@contentDescription='Filters']");

				//Find contacts
				public static By objFindContact=By.xpath("//*[@id='tvFindFriends']");
				
	//------------------------Muthu kumaran M------------------------------------
				//Favourites Screen
				public static By objFavouriteScreen=By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");
				//Video Thumbnail in All Activity
				public static By objVideoThumbnailInAllActivity=By.xpath("//*[@resource-id='com.zee5.hipi:id/videoImageView']");
				//Video screen
				public static By objVideoScreenInAllActivity=By.xpath("//*[@class='android.widget.FrameLayout']//*[@resource-id='com.zee5.hipi:id/profile_container']");
				//FollowerTextInNotification
				public static By objFollowerTextInNotification=By.xpath("(//*[@text='Followers'])[1]");

				//LikeTextInNotification
				public static By objLikeTextInNotification=By.xpath("(//*[@text='Likes'])[1]");
				//Liked video in all activity 
				public static By objLikedVideoInAllActivities=By.xpath("//*[@resource-id='com.zee5.hipi:id/titleTxt'][1]");
			
				//Liked video in all activity 
				public static By objLikedVideoInAllActivity=By.xpath("//*[@resource-id='com.zee5.hipi:id/titleTxt']");
				//All Activity 
				public static By objAllActivity=By.xpath("(//*[@resource-id='com.zee5.hipi:id/textView'])[1]");
				//Likes 
				public static By objLikesInAllActivityDropDown=By.xpath("(//*[@resource-id='com.zee5.hipi:id/textView'])[2]");
				//All Activity 
				public static By objCommentsInAllActivityDropDown=By.xpath("(//*[@resource-id='com.zee5.hipi:id/textView'])[3]");
				//All Activity 
				public static By objMentionsInAllActivityDropDown=By.xpath("(//*[@resource-id='com.zee5.hipi:id/textView'])[4]");
				//All Activity 
				public static By objFollowersInAllActivityDropDown=By.xpath("(//*[@resource-id='com.zee5.hipi:id/textView'])[5]");
				
				//Followers header in all activity
				public static By objFollowersHeaderInAllActivity=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtUserHandle']//following::*[@class='android.view.ViewGroup']/child::*[@resource-id='com.zee5.hipi:id/userImage']");
				//Notification Bell AllActivity
				public static By objAllActivityTitle=By.xpath("//*[@id='txtUserHandle' and (./preceding-sibling::* | ./following-sibling::*)[@id='imgBack']]");
				
				//Search field close button
				public static By objSearchFieldCloseButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/iv_clear_text']");
				//Empty username error
				public static By objEmptyUsernameError =By.xpath("//*[@resource-id='com.zee5.hipi:id/snackbar_text']");
				//Bio update success
				public static By objBioUpdateSuccess =By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@text='Bio updated successfully.']]");
				//username header
				public static By objUserNameHeader=By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");
		//Find Facebook Friends
				public static By objFindFacebbokFriendsButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvFaceBookFriends' and @text='Find Facebook Friends']");
				//Facebook Header
				public static By objLogInHeader=By.xpath("//*[@class='android.view.ViewGroup' and @contentDescription='Log In']");
		//Followers Profile
		public static By objFollowersProfile=By.xpath("//*[@class='android.view.ViewGroup']//*[@resource-id='com.zee5.hipi:id/music_name']");
		//Followers Profile Header
		public static By objFollowersProfileHeader=By.xpath("//*[@class='android.widget.TextView' and @id='txtUserHandle']");
		//Private Tab video
				public static By objPrivateTabVideoSelect=By.xpath("//*[@resource-id='com.zee5.hipi:id/videoImg']");
				//share button in private tab
				public static By objPrivateTabShareButton=By.xpath("//*[@id='image_view_option_share']");
				//Share To Title
				public static By objprivateTabShareToTitle=By.xpath("//*[@resource-id='com.zee5.hipi:id/title' and @text='Share to']");
		
				//Allow Hipi to take pictures
				public static By objAllowHipiTakePictures=By.xpath("//*[@id='permission_message']");
				//Allow Button
				public static By objAllowButton =By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']");
				//Allow Hipi Access Contacts
				public static By objAllowHipiAccessContacts=By.xpath("//*[@id='permission_message']");
				//Deny Button
				public static By objDenyButton=By.xpath("//*[@id='permission_deny_button']");
				//Permissions OK Button
				public static By objPermissionsOkButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/btn_yes']");
				//App Info
				public static By objAppInfo=By.xpath("//*[@resource-id='com.android.settings:id/right_button'] | //*[@resource-id='com.android.settings:id/entity_header_icon']");
		//Edit Profile Title
		public static By objEditProfileTitle=By.xpath("//*[@resource-id='com.zee5.hipi:id/my_edit_profile_text']");
		
		//Back To Home Page From Edit profile Page
		public static By objbackbutton=By.xpath("//*[@resource-id='com.zee5.hipi:id/imgAddUser']");
		//Profile photo
		public static By objprofilephotoEditProfilePage=By.xpath("//*[@resource-id='com.zee5.hipi:id/assetCover']");
		//name text field
		public static By objNameText=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvName']");
		//user name text
		public static By objUserNameText=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvUsername']");
		//user bio
		public static By objBioText=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvBio']");
		//Draft Video
		public static By objDraftVideos=By.xpath("//*[@resource-id='com.zee5.hipi:id/ivDraft']");
		//Draft Title
		public static By objDraftTitle=By.xpath("//*[@resource-id='com.zee5.hipi:id/draft_title']");
		//Drafts video
		public static By objDraftsPageVideo=By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");
		//Delete Draft popup
		public static By objDeleteDrafts=By.xpath("//*[@resource-id='android:id/message']");
		//Yes Option for delete
		public static By objDeleteDraftsYes=By.xpath("//*[@resource-id='android:id/button1']");
		//Draft Page BackButton
		public static By objDraftPageBackBtn=By.xpath("//*[@resource-id='com.zee5.hipi:id/imgAddUser']");
		//Invite Friends Icon
		public static By objInviteIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/imgAddUser']");
		//Invite Friends Text
		public static By objInviteFriendsText=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvInviteFriends']");
		
		//Bio Description 
			public static By objBioDescription=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvBioText']");
			
			//Following Search Field 
			public static By objFollowingSearch = By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");//*[@resource-id='com.zee5.hipi:id/editTextSearch']
			public static By objFollowingBackButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/back'] | //*[@resource-id='com.zee5.hipi:id/imgBack']");
			
			//Followers Search
			public static By objFollowersSearch=By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");
			
			//Back Button in Follower page
			public static By objFollowersBackButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/back']");
			
			//Spin Directory Options
			public static By objSpinDirectoryOptions=By.xpath("//*[@resource-id='com.zee5.hipi:id/spinDirectory']");
			//Spin Directory Option Camera
			public static By objSpinDirectoryOptionCamera=By.xpath("//*[@class='android.widget.CheckedTextView' and @text='Camera']");
			//Camera Image View
			public static By objCameraImageView = By.xpath("(//*[@resource-id='com.zee5.hipi:id/tvHeading']//following::*//*[@resource-id='com.zee5.hipi:id/imageView'])[1]");
			//Camera Capture Button
			public static By objCameraCaptureButton =By.xpath("//*[@class='android.widget.ImageView' and @id='shutter_button']");
			//Tick Button
			public static By objTickButton=By.xpath("//*[@class='android.widget.ImageView' and @id='done_button']");
			//Done button
			public static By objDoneButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvNext']");
			//profile photo success
			public static By objProfilePhotoSuccess=By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@text='Profile picture updated successfully']]");
			//Edit profile Name
			public static By objEditProfileName = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvName']//following::*[@resource-id='com.zee5.hipi:id/tvNameValue']");
			//user text field In Name
			public static By objUserTextFieldInName = By.xpath("//*[@resource-id='com.zee5.hipi:id/userEditText']");
			//Save button in Name
			public static By objSaveButton =  By.xpath("//*[@resource-id='com.zee5.hipi:id/tvSave']");
			//Username in Edit profile
		public static By objUserNameInEditProfile = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvUsername']//following::*[@resource-id='com.zee5.hipi:id/tvUsernameValue']");
		//Error after editing username
		public static By objEditUsernameErrorText=By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@text='An error has occurred. Please try after some time.']]");
		
		//Error after editing username
				public static By objEditUsernameSuccessText=By.xpath("//*[@resource-id='com.zee5.hipi:id/snackbar_text']");
				
				//Followers Name list
				public static By objFollowersNameList=By.xpath("//*[@resource-id='com.zee5.hipi:id/music_name']");
				//Following Names List
				public static By objFollowingNamesList=By.xpath("//*[@resource-id='com.zee5.hipi:id/music_name']");
				//FirstFollowingUserName
				public static By objFirstFollowingUserName=By.xpath("(//*[@resource-id='com.zee5.hipi:id/music_name'])[1]");

				//First Index Profile Image
				public static By objFirstProfileImageInFollowingList=By.xpath("(//*[@resource-id='com.zee5.hipi:id/image_user'])[1]");
		
				//videos in favourites
				public static By objVideoInFavourites=By.xpath("//*[@resource-id='com.zee5.hipi:id/videoImg']");
				//Videos Screen in Favourites
				public static By objVideosInFavouriteScreen=By.xpath("//*[@resource-id='com.zee5.hipi:id/videoImg']");
				//options in favorite videos
	               public static By ObjPopupOptions=By.xpath("//*[@resource-id='com.zee5.hipi:id/optionLayout']");
				
	             //  add to favorite
					public static By objAddToFavorite=By.xpath("//*[@resource-id='com.zee5.hipi:id/hashtagAddFav']");
				
				
					//Hashtags 
					public static By objHashhtagsName=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtGenreName']");

	//hashtag title
					public static By objHashTagTitle=By.xpath("//*[@resource-id='com.zee5.hipi:id/hashtagName']"); 

	//added to favorite
					public static By objAddedToFavorite=By.xpath("//*[@resource-id='com.zee5.hipi:id/hashtagAddFav']");
	//--------------------------------------Sohail------------------------------------------
	//  Posted video music title
		public static By objPostedvideoMusicTitle= By.xpath("//*[@id='text_view_music_title']");	
		//video screen music name
			public static By objPostedVideoEffectTitle= By.xpath("//*[@id='text_view_effect_title']");
		//Posted video filter title
		public static By objPostedvideoFilterTitle= By.xpath("//*[@id='text_view_filter_title']");	
			public static By objFollowingListTab= By.xpath("//*[contains(@text,'Following ')]");
			// followers list tab
			public static By objFollowListTab= By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");
			//following user's first user profile
			public static By objFirstFollowingUser= By.xpath("(//*[@resource-id='com.zee5.hipi:id/music_name'])[1]");
			//Search icon under following Tab
			public static By objSearchIconFollowingTab= By.xpath("//*[@resource-id='com.zee5.hipi:id/back_button']");
			//Following under Following list
			public static By objFollowingbutton_followingTab= By.xpath("(//*[@resource-id='com.zee5.hipi:id/follow_btn'])[1]");
			//first Video under Profile page
			public static By objFirstVideo= By.xpath("(//*[@resource-id='com.zee5.hipi:id/videoImg'])[1] | //*[@resource-id='com.zee5.hipi:id/viewCount']");
		    //verify Hashtag
			public static By objHashTagDescription= By.xpath("(//*[contains(@text,'#')])[1]");
			// video screen discription
			public static By objVideoScreenDisc= By.xpath("//*[@id='text_view_video_description']");
			// like icon
			public static By objLikeIcon= By.xpath("//*[@id='image_view_option_like']");
	
			//Search bar
			public static By objSearchBar= By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");
			//Profile draft video
			public static By objDrafttab= By.xpath("((//*[@id='allRecyclerView']/*[@id='adapterView'])[1]/*[@class='android.widget.TextView'])[1]");
			//Verify hashtag
			public static By objVerifyHastag = By.xpath("//*[contains(@text,'#')]");
			//tagged user in posted video
			public static By objPostedVideoMentionedUser= By.xpath("//*[@id='text_view_video_description']");
			
			

	//---------------------------------Deepa----------------------------------------------------
			//usePhone or Email
			public static By objUsePhoneOrEmail = By.xpath("//*[@resource-id='com.zee5.hipi:id/viaPhoneEmail']");
			//Email option
			public static By objEmailOption = By.xpath("//*[@content-desc='Email']");
			
			
			
			//-------------------------Sindhu-------------------------------------
			public static By objEditprofilepage= By.xpath("//*[@resource-id='com.zee5.hipi:id/my_edit_profile_text']");
			
			
			//draft in profile page
			public static By objDraftinProfilepage = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvTitle']");
			
			//draft page
			public static By objDraftpage = By.xpath("//*[@resource-id='com.zee5.hipi:id/draft_title']");
			public static By objVideoDraftPage =By.xpath("//*[@resource-id='com.zee5.hipi:id/rootLayout']");
			public static By objDeletedraftpopupicon = By.xpath("//*[@resource-id='android:id/message']");
			public static By objDeleteyesbutton = By.xpath("//*[@resource-id='android:id/button1']");
			public static By objDraftEmpty = By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");
			public static By objDeleteNoButton = By.xpath("//*[@resource-id='android:id/button2']");
			//not published draft video
			public static By objnotPublishedDraftVideo= By.xpath("//*[@resource-id='com.zee5.hipi:id/message']");
			
			
			
			
			
			//Bio tab
				public static By objBiotab = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvBioText']");
			//Bio page	
				
				public static By objBiopage = By.xpath("//*[@resource-id='com.zee5.hipi:id/my_edit_profile_text']");
			//name textfield in bio page	
				public static By objBioNametextfield = By.xpath("//*[@resource-id='com.zee5.hipi:id/userEditText']");
			//backtohomepagebutton	
				public static By objbacktohomepagebutton = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgAddUser']");
			//followers tab	
				public static By objFollowerstab = By.xpath("(//*[@class='android.widget.TextView'])[3]");	
			//follow button
				public static By objFollowbutton = By.xpath("//*[@resource-id='com.zee5.hipi:id/follow_btn']");
			//following button
				public static By objFollowingbutton = By.xpath("//*[@text='Following']");

				//SubFollowing Button 
				public static By objSubFollowingButton = By.xpath("(//*[@text='Following'])[2]");

				
				//-----------------------------------------------------------------------------------
				
				
				
		//list or count of following
				public static By objListOfFollowing= By.xpath("//*[@resource-id='com.zee5.hipi:id/txtFollowingValue']");	
				//list or count of following		
				public static By objListOfLikes= By.xpath("//*[@resource-id='com.zee5.hipi:id/txtLikeValue']");
		//list of viedoes
				public static By objListOfVideos= By.xpath("//*[@resource-id='com.zee5.hipi:id/thumbnail'] | //*[@resource-id='com.zee5.hipi:id/videoImg']");	
		// shear icon		
				public static By objShearIcon= By.xpath("//*[@resource-id='com.zee5.hipi:id/imgShare'] | //*[@resource-id='com.zee5.hipi:id/share_profile']");	
				
			//  drafted first video
				public static By objDraftFirstVideo= By.xpath("(//*[@id='draftsVideosRecycleraView']/*[@id='rootLayout'])[1]");
				
				
				
//---------------------------------Kartheek-------------------------------------------------------
				//Name Value
				public static By objNameValue = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvNameValue']");

			//Name Text Feald
				public static By objNameTextFeald = By.xpath("//*[@resource-id='com.zee5.hipi:id/userEditText']");
	
				//Drafts Are Not Available
				
				public static By objDraftsAreNotAvailable = By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");

				public static By objMusicVideoName= By.xpath("//*[@id='text_view_music_title']");
			
				public static By objSearchResult(String text) {
					return By.xpath("//*[@resource-id='com.zee5.hipi:id/music_name' and  @text='" + text + "']");
				}
				
				//user name 
				public static By objUserName= By.xpath("//*[@resource-id='com.zee5.hipi:id/txtUserName']");


				//verify url in posted video
					public static By objVerifyUrl = By.xpath("//*[contains(@text,'http')]");

//followin and follow button			
public static By objFollowUnfollow = By.xpath("//*[@id='tvFollow']");




//no contacts available 
		        public static By objNoContactAvalible=By.xpath("//*[@resource-id='com.zee5.hipi:id/text_error']");



public static By objPrivateTabVideo=By.xpath("//*[@resource-id='com.zee5.hipi:id/videoImg']");

//LikeButtonText
public static By objLikeButtonText=By.xpath("//*[@id='image_view_option_like_title']");

//comment button 
public static By objCommentButtonInPrivateTab =By.xpath("//*[@resource-id='com.zee5.hipi:id/image_view_option_comment']");

//comment title in private tab
public static By objCommentTitleInPrivateTab=By.xpath("//*[@resource-id='com.zee5.hipi:id/commentsCount']");

//add to comment 
public static By objAddToComments=By.xpath("//*[@resource-id='com.zee5.hipi:id/commentBox']");

//Adding post
public static By objAddingPost=By.xpath("//*[@resource-id='com.zee5.hipi:id/commentPost']");

//comment box text
public static By objCommentBoxText=By.xpath("//*[@resource-id='com.zee5.hipi:id/comment']");

//commentlike count
public static By objCommentLikeCount=By.xpath("(//*[@resource-id='com.zee5.hipi:id/commentLikeCount'])[1]");

//like button in comment
public static By objLikeButtonInComment=By.xpath("//*[@resource-id='com.zee5.hipi:id/commentLike']");

//comment close button
public static By objCommentCloseButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/commentClose']");

//share option in private tab
public static By objShareOption=By.xpath("//*[@resource-id='com.zee5.hipi:id/image_view_option_share']");

//Invite Friends Headline
public static By objInviteFriendsHeader=By.xpath("//*[@resource-id='com.zee5.hipi:id/my_edit_profile_text']");

public static By objInviteFriends=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvInviteFriends']");

public static By objSoundsInProfile=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtGenreName']");

//Bookmark icon
public static By objBookmarkIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/imgOption']");

//Option in private tab
public static By objOptionsInPrivateTab=By.xpath("//*[@resource-id='com.zee5.hipi:id/optionLayout']");
		
//Like Count
public static By objLikeCount=By.xpath("//*[@resource-id='com.zee5.hipi:id/image_view_option_like_title']");

public static By objGalleryHeader=By.xpath("//*[@resource-id='com.zee5.hipi:id/spinDirectory']");

public static By objEditNameCrossIcon = By.xpath("//*[@id='ivClear']");

public static By objBadRequestErrorPopup = By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@id='snackbar_text']]");


//Followers header in all activity
public static By objFollowersHeaderInAllActivities=By.xpath("(//*[@resource-id='com.zee5.hipi:id/txtUserHandle']//following::*[@class='android.view.ViewGroup']/child::*[@resource-id='com.zee5.hipi:id/userImage'])[1]");

//Video Thumbnail in All Activity
public static By objVideoThumbnailInAllActivities=By.xpath("(//*[@resource-id='com.zee5.hipi:id/videoImageView'])[1]");


//Favourites Screen
public static By objFavouriteScreenheader=By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");

//first Hashtag

public static By objFirstHashtag=By.xpath("	(//*[@id='txtGenreName'])[1]");

public static By objCreateVideo= By.xpath("//*[@text and ./parent::*[@id='createVideo']]");

public static By objInviteFriendsHeaders=By.xpath("(//*[@resource-id='com.zee5.hipi:id/my_edit_profile_text'])[1]");
public static By objFindContacts=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvFindFriends']");
public static By objDraftsVideo=By.xpath("//*[@resource-id='com.zee5.hipi:id/ivDraft']");


public static By objVerifyDraft(String SearchResultText) {
	return By.xpath("//*[@text='"+SearchResultText+"']");
}

public static By objVideoDraftedPage =By.xpath("(//*[@resource-id='com.zee5.hipi:id/rootLayout'])[1]");


public static By objDeleteOption=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvDeleteOption']");

public static By objHashTagsButton=By.xpath("//*[@class='android.widget.TextView' and @class='android.widget.TextView' and contains(text(),'Hash')]");
public static By objLikeValue=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtLikeValue']");
public static By objThumbnailImage(int num) {
	return By.xpath("(//*[@id='notificationsRecyclerview']/*/*[@id='userImage1'])[" + num + "]");
}

public static By objVideoTabInFavourites=By.xpath("//*[@resource-id='com.zee5.hipi:id/videoImg']");
//No favourites in favorite screen 
public static By objNoFavouritesText=By.xpath("//*[@id='text_error']");

public static By objPostScreenEdit = By.xpath("//*[@id='editbtn']");
public static By objPostScreenTrimVideoTitle = By.xpath("//*[@text and (./preceding-sibling::* | ./following-sibling::*)[@id='selectRotateClip'] and ./parent::*[@class='android.widget.RelativeLayout']]");				
public static By objPostScreenTrimsTick = By.xpath("//*[@id='trimFinish']");
public static By objVideoTabFirstVideo = By.xpath("(//*[@id='VideoResultRecyclerView']/*/*[@id='imgLayout' and (./preceding-sibling::* | ./following-sibling::*)[@id='title']])[1] | (//*[@resource-id='com.zee5.hipi:id/thumbnail'])[3]");


public static By objFirstVideoIteratable(int index) {
	return By.xpath("(//*[@resource-id='com.zee5.hipi:id/videoImg'])["+index+"]");
}
//Message Button
public static By objMessageButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/messageOption']");

//plus icon
public static By objPlusIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/plusIcon']");

public static By objUsrName=By.xpath("//*[@resource-id='com.zee5.hipi:id/text_user_handle' and contains(text(),'@Pradeepd5c')]");

public static By objMessageBox=By.xpath("//*[@resource-id='com.zee5.hipi:id/messageBox']");

public static By objSendMessageButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/sendMessage']");

public static By objSenderChatImage=By.xpath("//*[@class='android.view.ViewGroup']//*[@resource-id='com.zee5.hipi:id/userChatImage']");

public static By objReceiverChatImage=By.xpath("//*[@resource-id='com.zee5.hipi:id/receiverChatImage']");

public static By objUserNameTextView=By.xpath("//*[@resource-id='com.zee5.hipi:id/myUserNameTextView']");

public static By objUserHandle=By.xpath("(//*[@resource-id='com.zee5.hipi:id/userHandleTextView'])[1]");

public static By objMessage=By.xpath("//*[@resource-id='com.zee5.hipi:id/myMessageTextView']");

public static By objCommentPopup=By.xpath("//*[@resource-id='com.zee5.hipi:id/root']");

public static By objCommentOff=By.xpath("//*[@resource-id='com.zee5.hipi:id/comment_off']");

public static By objSMSIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/smsIcon']");

public static By objWhatsappIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/whatsappIcon']");

public static By objFacebookIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/facebookIcon']");


public static By objCopyLinkIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/copyLinkIcon']");

public static By objOthersIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/otherIcon']");

public static By objSoundName=By.xpath("//*[@id='text_view_music_title']");
public static By objFollowingTabErrorText=By.xpath("//*[@id='tvErrorSubtitle']");

public static By objDraftVideoThumbnail=By.xpath("//*[@resource-id='com.zee5.hipi:id/videoTumbNailImg'] | //*[@resource-id='com.zee5.hipi:id/playIcon']");

public static By objBioValue=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvBioValue']");


public static By objChangePhoto=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvChangePic']");

public static By objUserNameValue=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvUsernameValue']");

public static By objUserHandleUrl=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvUserUrl']");


public static By objFollowingCrossIcon=By.xpath("//*[@id='iv_clear_text']");
public static By objFollowingTabUserHandler=By.xpath("(//*[@id='text_user_handle'])[1]");
public static By objDraftpageThumbNail=By.xpath("(//*[@id='playIcon'])[1]");
public static By objSoundsThreeLines=By.xpath("//*[@id='useSound']");
public static By objAddedToFavorites=By.xpath("//*[@id='soundAddFav' and @text='Added to Favourite']");
public static By objSoundsAddToFavorite=By.xpath("//*[@id='soundAddFav']");
public static By objDraftVideoBackArrow=By.xpath("//*[@id='back_image']");
public static By objGalleryFirstPicture=By.xpath("(//*[@id='rvGallery']/*/*[@id='imageView'])[2]");


public static By objNotificationLikeFormat=By.xpath("(//*[contains(@text,'@')])[1]");
public static By objNotificationLikeFormat2=By.xpath("(//*[contains(@text,'others liked your video')])[1]");
public static By objNotificationProfileThumbnail=By.xpath("(//*[@id='notificationsRecyclerview']/*/*[@id='userImage'])[1]");

public static By objThreeDotsOtherUser=By.xpath("//*[@resource-id='com.zee5.hipi:id/imgSetting']");



public static By objFollowingButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtFollowingValue']");

public static By objNotificationsOnNotificationsIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/unreadCount']");


		public static By objAllNotifications=By.xpath("(//*[@resource-id='com.zee5.hipi:id/txtUserHandle'])[2]");
		
		public static By objTimeOfTheMessage=By.xpath("//*[@resource-id='com.zee5.hipi:id/descriptionTxt']");
}
