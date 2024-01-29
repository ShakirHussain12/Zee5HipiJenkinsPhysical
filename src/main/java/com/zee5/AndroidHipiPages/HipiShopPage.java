package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

import com.zee5.Applicaster.HIPI.HipiHomePage;

public class HipiShopPage {
	
	
	//Mini player
	public static By objMiniPlayer = By.xpath("//*[@resource-id='com.zee5.hipi:id/exo_overlay']");
	//Close Icon Mini Player
	public static By objcloseIconMiniPlayer = By.xpath("//*[@resource-id='com.zee5.hipi:id/close_button']");
	public static By objInThisVideo = By.xpath("(//*[@resource-id='com.zee5.hipi:id/tabTitleTxt'])[1]");
	
	//Saved Moments
	public static By objSavedMomentTab = By.xpath("//*[@resource-id='com.zee5.hipi:id/tabTitleTxt' and @text='SAVED MOMENTS']");
	//Product Image
	public static By objProductImageThumbnail = By.xpath("//*[@resource-id='com.zee5.hipi:id/content_image_view']");
	//close Button Third party Site
	public static By objCloseButtonThirdPartySite = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgBack']");
	 //product website 
	public static By objProductWebsitePage  = By.xpath("//*[@resource-id='com.zee5.hipi:id/titleUrl']");
	//Arrow mark  below the product 
	public static By objArrowMarkBelowTheProduct  = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgAdd']");
	//Expan Button
	public static By objExpanButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/show_details']");
	// outfit tab
	public static By objOutfitTab = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtSubCategory' and @text='Outfit ']");
	//Accessories tab
	public static By objAccessoriesTab = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtSubCategory' and @text='Accessories ']");
	//Beauty Tab
	public static By objBeautyTab = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtSubCategory' and @text='Beauty ']");
	//Hair Tab
	public static By objHairTab = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtSubCategory' and @text='Hair ']");
	//Thumbnail of the video
	public static By objThumbnailOfTheVideo= By.xpath("(//*[@resource-id='com.zee5.hipi:id/charms_layout']//following::*//*[@resource-id='com.zee5.hipi:id/card_image'])[1]");
	//Artist Title
	public static By  objArtistTitle = By.xpath("(//*[@class='android.widget.LinearLayout']//following::*[@resource-id='com.zee5.hipi:id/card_text'])[1]");
	//Less Button
	public static By  objLessButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/hide_details']");
	//Thumbnail image of the video
	public static By  objThumbnailImageOfTheVideo = By.xpath("//*[@resource-id='com.zee5.hipi:id/card_image']");
	//Images of product available in this page in a single row
	public static By  objImagesOfProductSingleRow = By.xpath("//*[@resource-id='com.zee5.hipi:id/charm_product_image']");
	//Product details page or Product Name 
	public static By  objProductDetailsPage = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtItemName']");
	//Delete Option
	public static By  objDeleteOption = By.xpath("//*[@resource-id='com.zee5.hipi:id/delete']");
	//Third Party Site Name
	public static By  objThirdPartySiteName = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtItemSite']");
	//Beauty banner image
	public static By  objBeautyBannerImage = By.xpath("//*[@resource-id='com.zee5.hipi:id/first_image']");
	//beaty cover heading
	public static By  objBeautyCoverHeading = By.xpath("//*[@resource-id='com.zee5.hipi:id/heading']");
	// beaty cover message
	public static By  objBeautyCoverMessage = By.xpath("//*[@resource-id='com.zee5.hipi:id/sub_heading']");
	//Product card poster image
	public static By  objProductCardPosterImage = By.xpath("//*[@resource-id='com.zee5.hipi:id/product_card_image']");
	// multiple saved video 
	public static By  objMultipleSavedVideos = By.xpath("//*[@resource-id='com.zee5.hipi:id/charms_layout']");
	
	//*[@resource-id='com.zee5.hipi:id/tabTitleTxt']
	
	public static By  objTotalNosBesideSavedMomentsInShopPage = By.xpath("//*[@id='numberTxt' and ./parent::*[./parent::*[@contentDescription='Saved Moments']]]");
 
	//shop tab on video 
		public static By objShopTabOnVideo=By.xpath("//*[@id='VideoResultRecyclerView']/*/*[@id='ivShop']");

		
		public static By objPullBarInShopPage=By.xpath("//*[@resource-id='com.zee5.hipi:id/view']");

		
}
