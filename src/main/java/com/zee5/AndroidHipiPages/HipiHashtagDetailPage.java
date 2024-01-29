package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiHashtagDetailPage {
	////Hashtag detail screen
	public static By objHashtagDetailScreen = By.xpath("//*[contains(@resource-id,'root_layout')]");

	//Hashtag detail layout
	public static By objHashtagDetailLayout = By.xpath("//*[contains(@resource-id,'head_layout')]");
	
	//Back Icon
	public static By objBackIcon = By.xpath("//*[contains(@resource-id,'backView')]");

	//Share Icon
	public static By objShareIcon = By.xpath("//*[@class='android.widget.ImageButton']");

	//3 dots
	public static By objThreeDots = By.xpath("//*[contains(@resource-id,'report_menu')]");

	//Hashtag thumnail
	public static By objHashtagThumnail = By.xpath("//*[contains(@resource-id,'hashImage')]");

	//Hashtag description
	public static By objHashtagDescription = By.xpath("//*[contains(@resource-id,'hashtagDesc')]");

	//Add to Favourite Icon
	public static By objFavouriteIcon = By.xpath("//*[contains(@resource-id,'favBtn')]");
	
	//Hashtag Views
	public static By objHashtagViews = By.xpath("//*[contains(@resource-id,'hashtagLikeCount')]");

	//List of videos Screen
	public static By objListOfVideosScreen = By.xpath("//*[contains(@resource-id,'swiperefresh')]");
	
	//one of video
	public static By objOneofvideo = By.xpath("//*[contains(@resource-id,'thumbnail')]");

	//Hashtag Title
	public static By objHashtagTitle = By.xpath("//*[contains(@resource-id,'hashtagName')]");
	// Related videos for a new/existing Hashtag
	public static By objRelatedVideos = By.xpath("//*[contains(@resource-id,'swiperefresh')]");
	//Use This Hashtag
	public static By objUseThisHashtag = By.xpath("//*[contains(@resource-id,'hashtagView')]");
	//Description text box already has Hashtag
	public static By objDescriptionTextBoxAlreadyHashtag = By.xpath("//*[contains(@resource-id,'commentBox')]");
	//Hashtag Image
	public static By objHashtagImage = By.xpath("//*[contains(@resource-id,'fullViewImage')]");
	//Terms and Conditions
	public static By objTermsAndConditions = By.xpath("//*[@text='Terms & Conditions']");
	//Terms and Conditions  screen
	public static By objTermsAndConditionsScreen = By.xpath("//*[contains(@resource-id,'action_bar_root')]");
	// hashtag number of like video count
	public static By objHashtagNumberOfLikeVideoCount = By.xpath("//*[contains(@resource-id,'hashtagVideosCount')]");
	//hashtag number of View video count
	public static By objHashtagNumberOfViewVideoCount = By.xpath("//*[contains(@resource-id,'hashtagLikeCount')]");
	//description with URL 
	public static By objDescriptionWithURL = By.xpath("//*[contains(@resource-id,'authorContentTextView')]");
	
	
}
