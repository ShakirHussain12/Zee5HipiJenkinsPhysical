package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiEffectPage {

	public static By objCoolGlassEffect = By.xpath("//*[contains(@resource-id,'usedEffect')]");
	
	public static By objEffectDetailScreen = By.xpath("//*[contains(@resource-id,'root_layout')]");

	public static By objCoolGlassesName = By.xpath("//*[contains(@resource-id,'displayName')]");
	
	public static By objRelatedVideosEffects = By.xpath("//*[contains(@resource-id,'swiperefresh')]");
	
//	public static By objShareIcon = By.xpath("//*[@class='android.widget.ImageButton']");
	
	//Effect thumbnail
	public static By objEffectThumbnail = By.xpath("//*[contains(@resource-id,'effectImage')]");

	//Thumbnail Image screen
	public static By objThumbnailImageScreen = By.xpath("//*[contains(@resource-id,'fullViewImage')]");
	//Use This Effect
	public static By objUseThisEffect = By.xpath("//*[contains(@resource-id,'fab_text')]");
	//None Of The Above
	public static By objNoneOfTheAbove = By.xpath("//*[contains(@resource-id,'cancel')]");

	//Add Effects Screeen
	public static By objAddEffectsScreeen = By.xpath("//*[contains(@resource-id,'textView3')]");
	//Effects screen pop up
	public static By objEffectsScreenPopUp = By.xpath("(//*[contains(@resource-id,'lay_root')])[1]");
	//Tap on Back button
	public static By objTaponBackButton = By.xpath("//*[contains(@resource-id,'closeButtonimg')]");
	//ALL Button
	public static By objAllButton= By.xpath("//*[contains(@resource-id,'filterall')]");
	//Favorites Button
	public static By objFavoritesButton= By.xpath("//*[contains(@resource-id,'filterfav')]");
	//Recents Button
	public static By objRecentsButton= By.xpath("//*[contains(@resource-id,'filterrecent')]");
	//Trending Button
	public static By objTrendingButton= By.xpath("//*[@text='Trending']");
	//Plug Ins Button
	public static By objPlugInsButton= By.xpath("//*[@text='Plug Ins']");
	//Beauty Button
	public static By objBeautyButton= By.xpath("//*[@text='Beauty']");
	//cute Button
	public static By objCuteButton= By.xpath("//*[@text='Cute']");
	//Action Button
	public static By objActionButton= By.xpath("//*[@text='Action']");
	//One of the effect
	public static By objOneOfTheEffect= By.xpath("(//*[contains(@resource-id,'transparent')])[2]");
	// Download progress
	public static By objDownloadProgress= By.xpath("//*[contains(@resource-id,'downloadProgressBar')]");
	//Downloaded Effect 
	public static By objDownloadedEffect= By.xpath("(//*[contains(@resource-id,'assetCover')])[2]");
	//Recent Effect
	public static By objRecentEffect= By.xpath("//*[contains(@resource-id,'assetCover')]");
	//click On Effect
	public static By objClickOnEffect= By.xpath("(//*[contains(@resource-id,'assetCover')])[2]");
	//Favourite Button
	public static By objAddFavouriteButton= By.xpath("(//*[contains(@resource-id,'cart_badge')])[2]");
	//Add Effect Pop Up 
	public static By objAddEffectPopUp = By.xpath("//*[contains(@resource-id,'title_popup')]");
	//Add Effect Pop Up Click Yes
	public static By objClickYes = By.xpath("//*[contains(@resource-id,'btn_yes')]");
	// Checkh Add Favourite Effect
	public static By objCheckhAddFavouriteEffect= By.xpath("//*[contains(@resource-id,'assetCover')]");
	//Remove from Favorite
	public static By objRemoveFromFavorite= By.xpath("//*[contains(@resource-id,'title_popup')]");
	//No Favorites -Add Now
	public static By objNoFavoritesAddNow= By.xpath("//*[contains(@resource-id,'tvFavError')]");
	//Click on Favorite in effect details screen 
	public static By objClickOnFavoriteInEffectDetailsScreen= By.xpath("//*[contains(@resource-id,'addmusic_fav')]");
	
	public static By objEffectRemoved=By.xpath("(//*[contains(@resource-id,'addmusic_fav') and @checked='false'])");
	//Effect Layout
	public static By objEffectLayout= By.xpath("//*[contains(@resource-id,'layout')]");
	//followed by number of views below to title
	public static By objFollowedByNumberOfViewsBelowToTitle = By.xpath("//*[contains(@resource-id,'playCount')]");
	
	//effect Name 
	//public static By  objEffectName = By.xpath("(//*[@id='recycler']/*/*[@id='assetName' and (./preceding-sibling::* | ./following-sibling::*)[@id='assetCover']])[2]");
	
	//effect is present in my profile  
	//public static By  objeffectIsPresentProfile = By.xpath("//*[@class='android.widget.FrameLayout']");

	
	
	//effect Name 
		public static By  objEffectName1 = By.xpath("(((//*[@resource-id='com.zee5.hipi:id/assetName'])[2]//parent::*)//child::*)[3]");
			
		//effect is present in my profile  
		public static By  objeffectIsPresentProfile = By.xpath("//*[@class='android.widget.FrameLayout']");

		public static By  objEffectName  = By.xpath("(((//*[@resource-id='com.zee5.hipi:id/transparent'])[1]//parent::*)//child::*)[4]");

//		                                                                    (((//*[@resource-id='com.graymatrix.did:id/assetName'])[1]//parent::*)//child::*)[5]
		
		public static By objAfterDownload(String effectName) {
			return By.xpath("((//*[@text='"+effectName+"'])//parent::*)//child::*[@resource-id='com.zee5.hipi:id/download']");
		}
		

	public static By objEffectDownloadButton(String effectName1) {
			return By.xpath("((//*[contains(text(),'"+effectName1+"')])//parent::*)//child::*[@resource-id='com.zee5.hipi:id/download']");
		}

	public static By objDownloadedEffectOverlay(String effectName) {
		return By.xpath("((//*[contains(text(),'"+effectName+"')])//parent::*)//child::*[@id='assetCover']");
	}

	public static By objFavouriteAnEffect(String effectName) {
		return By.xpath("((//*[contains(text(),'"+effectName+"')])//parent::*)//child::*[@resource-id='com.zee5.hipi:id/cart_badge']");
	}




	public static By objEffectName(String effectName) {
		return By.xpath("//*[contains(text(),'"+effectName+"')]");
	}

		public static By objEffectInFavourite(String effectName1) {
			return By.xpath("//*[@resource-id='com.zee5.hipi:id/assetName' and @text='"+effectName1+"']");
		} 	
		
		public static By objEffectRemoveInFavorites(String effectName1) {
			return By.xpath("((//*[@text='"+effectName1+"'])//parent::*)//child::*[@resource-id='com.zee5.hipi:id/cart_badge']");
		}
		
	
		//Share Icon
		public static By objShareIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgShare']");
		
		//Effect Header
		public static By objEffectHeader = By.xpath("//*[@resource-id='com.zee5.hipi:id/effectName']");
		
		//Filter Header
		public static By objFilterHeaderr = By.xpath("//*[@resource-id='com.zee5.hipi:id/effectName']");

		
		
	
	
	
	
	
	}
