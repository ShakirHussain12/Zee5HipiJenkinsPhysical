package com.zee5.Applicaster.HIPI;

import org.openqa.selenium.By;

public class AMDFeed {
	//Feed text
	public static By objfeedtext=By.xpath("//*[contains(@resource-id,'feedtext')]");
	
//sound
	public static By objsound=By.xpath("//*[contains(@resource-id,'songNameMTextView')]");
	//share
	public static By objshare=By.xpath("//*[contains(@resource-id,'share')]");
	//like
	public static By objlike=By.xpath("//*[contains(@resource-id,'like_icon')]");
	//ciomment
	public static By objcomment=By.xpath("//*[contains(@resource-id,'comment_icon')]");
	//description
	public static By objdescription=By.xpath("//*[contains(@resource-id,'authorContentTextView')]");
	//followicon
	public static By objfollowicon=By.xpath("//*[contains(@resource-id,'follow_icons')]");
	//profile picicon
	public static By objprofilepic=By.xpath("//*[contains(@resource-id,'avatarCircleImageView')]");
	//profile
	public static By objprofile=By.xpath("//*[contains(@resource-id,'profile_pic')]");
	//following
	public static By objfollowing=By.xpath("//*[contains(@resource-id,'txtFollowing')]");
	//followinginfeed
	public static By objfollowingicon=By.xpath("//*[contains(@resource-id,'following')]");
	//back
	public static By objbackbtn=By.xpath("//*[contains(@resource-id,'imgBack')]");




	public static By objFeedActionFollowButton=By.xpath("//*[contains(@resource-id,'follow_icons')]");

	public static By objGetLikeCountButton = By.xpath("//*[contains(@resource-id,'likeCount')]");

	public static By objFeedActionLikeButton=By.xpath("//*[contains(@resource-id,'like_icon')]");

	public static By objCommentPageAppear = By.xpath("//*[contains(@resource-id,'commentsCount')]");

	public static By objCommentBoxAppear = By.xpath("//*[contains(@resource-id,'commentBox')]");


	public static By objFeedAuthorData=By.xpath("//*[contains(@resource-id,'authorContentTextView')]");

	public static By objPauseButton= By.xpath("//*[contains(@resource-id,'playImageView')]");

	public static By objFeedProgressBar=By.xpath("//*[contains(@resource-id,'videoprogressBar')]");
	
	public static By objSongButton= By.xpath("//*[contains(@resource-id,'songNameMTextView')]");
	
	public static By objFeedActionUnLikeButton=By.xpath("//*[contains(@resource-id,'like_icon')]");
	
	public static By objFeedEffectData=By.xpath("//*[@id='usedEffect']");
	
	public static By objFeedCreatorProfilePicture=By.xpath("//*[contains(@resource-id,'avatarCircleImageView')]");
	
	public static By objFeedLongPress=By.xpath("//*[@class='android.widget.LinearLayout' and @text='1']");
	
	public static By objFeedLongPressDownload=By.xpath("//*[@text='Download Video']");
	
	public static By objFeedLongPressAddFav=By.xpath("//*[@text='Add to Favorites']");
	
	public static By objFeedLongPressReport=By.xpath("//*[@text='Report Video']");
	
	public static By objFeedLongPressNotInterested=By.xpath("//*[@text='Not Interested']");
	
	public static By objFeedLongPressNotInterestedDialog=By.xpath("//*[contains(@resource-id,'title_popup')]");
	
	public static By objFeedvideodataAddFav=By.xpath("(//*[contains(@resource-id,'desc')])[1]");
	
	public static By objMe=By.xpath("//*[contains(@resource-id,'meimage')]");
	
	public static By objFeedLongPressAddFavDialog=By.xpath("//*[contains(@resource-id,'title_popup') and @text='Added to your favorites']");

	public static By objFeedvideodata=By.xpath("//*[contains(@resource-id,'authorContentTextView')]");
	
	
	public static By objAddFavIcon=By.xpath("//*[contains(@resource-id,'tab_layout')]//*[@class='android.widget.LinearLayout'])[4])//*[@class='android.widget.ImageView']");
	
	public static By objFeedDownloadedVideoDialog=By.xpath("//*[contains(@resource-id,'title_popup') and @text='Video Saved!']");

	public static By objFeedReportVideoPage=By.xpath("//*[contains(@resource-id,'offers_title')]");
	public static By objFeedReportreason=By.xpath("//*[contains(@resource-id,'mainTypeLabel')]");
	public static By objFeedReportcategory=By.xpath("//*[contains(@resource-id,'subTypeLabel')]");
	public static By objFeedReportdescription=By.xpath("//*[contains(@resource-id,'descedit')]");
	public static By objFeedReportsubmit=By.xpath("//*[contains(@resource-id,'nextBtn')]");
	public static By objFeedReportreasondata=By.xpath("//*[contains(@resource-id,'reportCheck') and @text='Nudity & Sexual Content']");
	public static By objFeedReporcategorydata=By.xpath("//*[contains(@resource-id,'reportCheck') and @text='Video is sexual in nature']");
	
	public static By objFeedVideoReportedDialog=By.xpath("//*[contains(@resource-id,'title_popup')]");
	public static By objFeedVideoSharingGmail=By.xpath("//*[@text='Gmail']");
	public static By objFeedVideoSharingGmailPageavailable=By.xpath("//*[@text='Compose']");

	public static By objFeedCommentLikeButton=By.xpath("(//*[@id='commentlikepics'])[1]");
	public static By objFeedCommentLikeButtonCountBeforeLiking=By.xpath("(//*[@id='commentlikecount'])[1]");
	public static By objFeedCommentorProfilepic=By.xpath("(//*[@id='userImage'])[1]");
	public static By objFeedCommentorProfilepicDataundercomment=By.xpath("(//*[contains(@resource-id,'comment')])[2]");
	public static By objFeedCommentorProfileData=By.xpath("//*[contains(@resource-id,'txtUserHandle')]");

	public static By objFeedLongPressDownloadPermissionDialog=By.xpath("//*[@id='permission_message']");
	public static By objFeedLongPressDownloadPermissionDialogAllow=By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_allow_button']");
	
	public static By objFeedActionCommentButton=By.xpath("//*[contains(@resource-id,'comment_icon')]");
	
	public static By objFeedFollowingbtn=By.xpath("//*[contains(@resource-id,'txtEditProfile') and @text='Following']");
	
	//share video button clicked
	public static By objsharevideobtn=By.xpath("//*[contains(@resource-id,'share')]");

	public static By objsharepagedisplayed=By.xpath("//*[@resource-id='android:id/title') and @text='Share']");
	
	//Fav
	public static By objFeedAddFav=By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.ImageView[@index='0']");
	//Video
	public static By objFeedAddFavVideo=By.xpath("(//*[contains(@resource-id,'videoimg')])[1]");
	//Fav data
	public static By objfavvideodata=By.xpath("//*[contains(@resource-id,'authorContentTextView')]");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
