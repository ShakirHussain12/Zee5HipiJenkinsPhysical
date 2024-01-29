package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiOtherProfileScreen {
	//Kundali Bhagya 
	public static By objKundaliBhagya = By.xpath("//*[@text='KundaliBhagya']");
	//Kundali Bhagya Profile Details
	public static By objProfileDetails = By.xpath("//*[contains(@resource-id,'blurBackground')]");
	//Kundali Bhagya User Name
	public static By objUserNameText = By.xpath("//*[contains(@resource-id,'txtUserName')]");
	//Kundali Bhagya Followers Button
	public static By objKundaliBhagyaFollowers = By.xpath("//*[@id='txtFollow']");
	//Kundali Bhagya Following Button
	public static By objKundaliBhagyaFollowing = By.xpath("//*[@id='txtFollowing']");
	//Kundali Bhagya Views Button
	public static By objKundaliBhagyaViews = By.xpath("//*[@id='txtLike']");
	//Kundali Bhagya Follow Button
	public static By objKundaliBhagyaFollow = By.xpath("//*[@id='txtEditProfile']");
	//Kundali Bhagya Share Button
	public static By objKundaliBhagyaShare = By.xpath("//*[@id='share']");
	
	//Kundali Bhagya Profile Pic
	public static By objProfilePic = By.xpath("//*[@id='profile_pic']");
	//Kundali Bhagya video tab
	public static By objKundaliBhagyaVideoTab = By.xpath("//*[@class='android.widget.ImageView' and @selected='true']");

	//Kundali Bhagya created videos 

	public static By objUserCreatedVideos = By.xpath("//*[@id='allRecyclerView']");

	//Kundali Bhagya Followers Count
	public static By objFollowersCount = By.xpath("//*[@id='txtFollowValue']");

	//Kundali Bhagya Following Count
	public static By objFollowingCount = By.xpath("//*[@id='txtFollowingValue']");
	//Kundali Bhagya Following Count
	public static By objFollowersList = By.xpath("//*[contains(@resource-id,'recyclerView')]");
	//any one of Follower
	public static By objAnyOneOfFollower = By.xpath("(//*[@id='music_name'])[1]");
	//Tap On Back Button
	public static By objTapOnBackButton = By.xpath("//*[contains(@resource-id,'imgBack')]");
	//Again Tap on Back Button
	public static By objAgainTapOnBackButton = By.xpath("//*[contains(@resource-id,'back')]");
	
	//Like count
	public static By objLikeCount = By.xpath("//*[@id='likeCount']");
	//3 dots Icon
	public static By obj3dotsIcon = By.xpath("//*[@id='imgOption']");
	//Report Profile
	public static By objReportProfileBttton = By.xpath("//*[@id='report_user']");
	//Report Profile Screen
	
	//Block Profile
	public static By objBlockProfile = By.xpath("//*[contains(@resource-id,'text_block')]");
	//Block? This will prevent them from seeing your information on HiPi POP UP
	public static By objBlockPopUP = By.xpath("//*[@text='Block? This will prevent them from seeing your information on HiPi.']");
	//click on yes
	public static By objBlockYesButton = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	//You have blocked the user!
	
	public static By objhaveBlockedTheUser = By.xpath("//*[contains(@resource-id,'msg_popup')]");
	//Click On Done Button
	public static By objclickdone = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	//middle options in profile screen
	public static By objmiddleoptionsprofilescreen = By.xpath("//*[contains(@resource-id,'layContainer')]");
	//Original sound
	public static By objOriginalsoundTab = By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tab_layout']]/*/*[@class='android.widget.ImageView' and ./parent::*[@class='android.widget.LinearLayout']])[2]");
	
	
	//view list of sounds in original sound tab.
	public static By objListOfSounds = By.xpath("//*[contains(@resource-id,'lay_root')]");
	//click on one of video
	public static By objClickOnVideo = By.xpath("//*[contains(@resource-id,'adapterView')][1]");
	
	
	//Any one of the following people
	public static By objoneoffollowingpersion= By.xpath("(//*[@id='music_name'])[1]");
	//following page
	public static By objFollowingPage= By.xpath("//*[contains(@resource-id,'profile_container')]");
	//Share Button
	public static By objShareButton= By.xpath("//*[contains(@resource-id,'share')]");

	
	//Search Results Module objects
		//User Handle
		public static By objUserHandle = By.xpath("//*[contains(@resource-id,'txtUserHandle')]");
		//Profile Image
		public static By objProfileImage = By.xpath("//*[contains(@resource-id,'profile_pic')]");
		//User Name
		public static By objUserName = By.xpath("//*[contains(@resource-id,'txtUserName')]");
		//User Badge
		public static By objUserBadge = By.xpath("//*[contains(@resource-id,'user_badge')]");
		//Back icon
		public static By objBackIcon = By.xpath("//*[contains(@resource-id,'imgBack')]");
		//Follow Button
		public static By objFollowButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtEditProfile' and @text='Follow']");
		//First Video
		public static By objFirstVideo = By.xpath("//*[contains(@resource-id,'videoimg')][1]");
		//View Count of First Video
		public static By objFirstVideoViewCount = By.xpath("(//*[@resource-id='com.zee5.hipi:id/videoimg'])[1]//following-sibling::*//*[@resource-id='com.zee5.hipi:id/viewcount']");
		//Like Count of First Video
		public static By objFirstVideoLikeCount = By.xpath("(//*[@resource-id='com.zee5.hipi:id/videoimg'])[1]//following-sibling::*//*[@resource-id='com.zee5.hipi:id/likecount']");
		//Description of First Video
		public static By objFirstVideoDescription = By.xpath("(//*[@resource-id='com.zee5.hipi:id/videoimg'])[1]//following-sibling::*//*[@resource-id='com.zee5.hipi:id/desc']");
		//Music Tab
		public static By objMusicTab = By.xpath("(//*[@resource-id='com.zee5.hipi:id/tab_layout']//*[@class='android.widget.ImageView'])[2]");
		//Favorite icon on first Music content
		public static By objFirstContentFavoriteIcon = By.xpath("(//*[@resource-id='com.zee5.hipi:id/relative_click'])[1]//*[@resource-id='com.zee5.hipi:id/addmusic_fav_infav']");
		//First Music content
		public static By objFirstMusicContent = By.xpath("(//*[@resource-id='com.zee5.hipi:id/music_details']//*[@resource-id='com.zee5.hipi:id"+ "/music_name'])[1]");
	
}
