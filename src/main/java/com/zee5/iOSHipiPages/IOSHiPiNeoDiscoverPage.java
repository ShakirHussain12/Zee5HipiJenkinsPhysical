package com.zee5.iOSHipiPages;

import org.openqa.selenium.By;

import aj.org.objectweb.asm.Type;

public class IOSHiPiNeoDiscoverPage {

	public static By objiosPlayIconInVideosOfHashtagVideoDetailPage=By.xpath("(//*[contains(@id,'_video_')])[1]");

	public static By objiosSortIconInSoundTab=By.xpath("(//*[contains(@id,'ort')])[1]");

	public static By objiosPlayIconInVideosTab=By.xpath("(//*[contains(@id,'outline_Play')])[1] | //*[contains(@id,'total_views_1')]");
	public static By objiosAddToFavouritesInSoundTab=By.xpath("//*[contains(@id,'Add_to')  and contains(@class,'Button')] | //*[contains(@id,'Add to') and contains(@class,'Button')]");

	public static By objiosAddedToFavouritesInSoundTab=By.xpath("//*[contains(@id,'Added_to') and contains(@class,'utton')] | //*[contains(@id,'Added to') and contains(@class,'utton')]|//*[contains(@id,'added_')]");


	//Back Button In Discover Page
	public static By objBackButtonInDiscoverPage=By.xpath("//*[contains(@id,'back')]");

	public static By objiosAddToFavoriteInSoundTab=By.xpath("//*[contains(@text,'add favourite')]");
	////*[contains(@id,'added_')]

	public static By objiosTrendingHipiRail=By.xpath("//*[contains(text(),'#HipiStunner')]");

	//	public static By objiosShoppableIconVideo(int index) {
	//		return By.xpath("(//*[@id='ic_shoppable'])["+index+"]");
	//	}

	public static By objiosShoppableIconVideo(int index) {
		return By.xpath("(//*[contains(text(),'hoppable')])["+index+"]");
	}

	public static By SortIconsInSoundTab(int index) {
		return By.xpath("(//*[@id='ic sort'])["+index+"]");
	}

	//Search Field In Discover Page
	public static By objiosSearchFieldInDiscoverPage=By.xpath("//*[@placeholder='Search' and @class='UIATextField']");


	//Sound Tab In Search Page
	public static By objiosSoundTabInSearchPage=By.xpath("//*[@id='Sounds' and @knownSuperClass='UICollectionViewCell']");


	public static By objiosNameInSoundTab=By.xpath("//*[contains(text(),'Himanshikhu')]");


	//Tabnames are Top, Users,  Videos,  Sounds,  HashTags
	public static By objiosTabnameInDiscoverSearchResultsPage(String tabname) {
		return By.xpath("//*[@class='UIACollectionView']//*[@id='"+tabname+"']");
	}


	public static By objiosRailsnameInDiscoverSearchResultsPage(String Railname) {
		return By.xpath("//*[contains(@text,'"+Railname+"')]");
	}




	public static By objiosUsersProfileNameInDiscoverPage(String Profile) {
		return By.xpath("//*[@id='Bollywood Zone']//following::*//*[@knownSuperClass='UICollectionView']//*[@id='"+Profile+"']");
	}

	public static By objiosBollywoodZoneInSearchPage=By.xpath("//*[@value='Bollywood Zone']");


	public static By objiosRightFacingArrowForTray(String trayTitle){
		return By.xpath("//*[contains(@text,'"+trayTitle +"')]//parent::*//*[@id='ic arrow next']");

	}


	public static By objiosFollowInRails=By.xpath("//*[@id='Follow' and @knownSuperClass='UIButton']");



	public static By getUserNameWithFollowrefference(int followRef,int nameRef) {
		return By.xpath("((//*[@id='Follow' and @knownSuperClass='UIButton'])["+followRef+"]//preceding-sibling::*//child::*)["+nameRef+"]");
	}


	public static By getUserNameWithFollowingReference(int followingRef,int nameRef) {
		return By.xpath("(//*[@id='Following' and @knownSuperClass='UIButton'])["+followingRef+"]//preceding-sibling::*//child::*["+nameRef+"]");
	}
	public static By getUserNameINFollowReference(String Name) {
		return By.xpath("//*[@id='Follow' and @class='UIAButton']//preceding-sibling::*//child::*[@id='"+Name+"']");
	}




	//09/12/21=================================================================================================================

	//		public static By objiosUserNameInSearch=By.xpath("//*[@id='USERS']/../..//following-sibling::*[1]//child::*[3]//child::*[1]");
	//	
	//		public static By objiosSearchIconInDiscoverPage=By.xpath("//*[@id='ic search']");
	//		
	//		//Mobile Keyboard
	//		public static By keyboard(String alphabet ) {
	//			return By.xpath("//*[@id='"+alphabet+"' and @class='UIAKey']");
	//		}
	//	
	//		public static By objiosAutoSuggestionsInSearchParentPage=By.xpath("(//*[@id='ic arrow top left'])[1]//preceding-sibling::*[1]");
	//	
	//	    public static By TopTabInSideCategoriesResults(String categories) {
	//	    	return By.xpath("//*[@id='"+categories+"']");
	//	    }
	//	


	public static By objiosUserNameInSearch=By.xpath("//*[@id='USERS']/../..//following-sibling::*[1]//child::*[3]//child::*[1]");

	public static By objiosSearchIconInDiscoverPage=By.xpath("//*[@id='ic search']");

	//Mobile Keyboard
	public static By keyboard(String alphabet ) {
		return By.xpath("//*[@id='"+alphabet+"' and @class='UIAKey']");
	}

	public static By objiosAutoSuggestionsInSearchParentPage=By.xpath("(//*[@id='ic arrow top left'])[1]//preceding-sibling::*[1]");

	public static By TopTabInSideCategoriesResults(String categories) {
		return By.xpath("//*[@id='"+categories+"']");
	}






	//***Discover page

	//-----------------------------------N---------------------------------------	
	//Search text field in discovery page
	public static By objSearchTextFieldInDiscoverPage=By.xpath("//*[@placeholder='Search']");
	//Search Button In Keyboard
	public static By objiosSearchButtonInKeyboard=By.xpath("//*[@class='UIAKeyboard']//child::*[contains(@id,'earch')]");

	public static By CategoriesResultsInTheTopTab(String Categories) {
		return By.xpath("//*[@id='"+Categories+"' and @knownSuperClass='UIView']");
	}
	//first Search result in hashtag			
	public static By objiosFirstSearchResultOfHashTag(String keyword) {
		return By.xpath("//*[contains(text(),'#"+keyword+"')]");
	}



	//=================s=========================================================
	public static By objiosrailname=By.xpath("(//*[@value='ic arrow next']//preceding-sibling::*[@class='UIAView']//child::*)[1]");


	//rail view all button
	public static By objiosrailviewallbutton(String railName) {
		return By.xpath("//*[@class='UIAView']//child::*[@text='"+railName+"']//parent::*[@class='UIAView']//*[contains(@value,'arrow')]");
	}

	//View All Page Header
	public static By objiosViewAllPageHeader=By.xpath("//*[@class='UIAButton' and @text='Add to Favourites']//preceding-sibling::*[@class='UIAView']//child::*");


	//Comedy Zone
	public static By objiosComedyZone=By.xpath("//*[contains(text(),'Comedy ')]");

	public static By objiosArrowicon=By.xpath("//*[@id='ic arrow next' and (./preceding-sibling::* | ./following-sibling::*)[@id='Comedy Zone']]");


	//Right Facing Arrow For Tray
	public static By objRightFacingArrowForTray(String trayTitle){
		return By.xpath("//*[contains(@text,'"+trayTitle +"')]//parent::*//*[@id='ic arrow next']");
	}

	//Follow Button on Profile
	public static By objFollowButtononProfile=By.xpath("(//*[@id='Follow'])[1]");

	//Login To Hipi In Discover Page
	public static By objLoginToHipiInDiscoverPage=By.xpath("//*[@id='Login in to Hipi']");

	//Close Icon In Discover Page
	public static By objCloseIconInDiscoverPage=By.xpath("//*[@id='ic close'] | //*[contains(@id,'close')]");



	//21//12/21 new================================================


	public static By objBollywoodZonePageInDiscoverPage=By.xpath("//*[@value='Bollywood Zone' and @class='UIANavigationBar']");

	public static By objiosFollowUsersNameDetailsInBollywoodZoneScreen=By.xpath("(//*[@id='Follow' and @class='UIAButton'])[1]//preceding-sibling::*//child::*[1]");

	public static By objiosTrayselement(String TrayName,int index) {
		return By.xpath("(//*[@value='"+TrayName+"']//following::*//*[contains(@class,'Text')])["+index+"]");

		//(//*[@value='Bollywood Zone']//following::*//*[contains(@class,'Text')])[1]
	}


	public static By ProfileImageInAnyTray(String TrayName, int index) {
		return By.xpath("(//*[@value='"+TrayName+"']//following::*//*[@class='UIAImage'])["+index+"]");
	}





	public static By objiosBannerInDiscoverpage=By.xpath("//*[@class='UIAPageIndicator']");

	public static By objiosNameInUserProfile(String name) {
		return By.xpath("//*[contains(text(),'"+name+"')]");
	}

	//---------------------kiran---27-jan-----------------------------------------------------------

	// Cross Icon In search field Discover Page
	public static By objCrossIconInSearchField = By.xpath("//*[@id='ic close'] | //*[contains(@id,'close')]");

	public static By AutoSuggestionsNameInSearchParentPage(int index) {
		return By.xpath("(//*[@id='ic arrow top left'])[" + index + "]//preceding-sibling::*[1]");
	}

	//				public static By UserProfileNameInUserTabPage(int index1, int index2) {
	//					return By.xpath(
	//							"(//*[@class='UIAImage'])["+index1+"]//following-sibling::*//child::*[" + index2 + "]");
	//				}

	public static By objListOfUserProfileNameInUserTabPage = By.xpath("//*[@class='UIAImage']");

	//				public static By objiosFirstSearchedResultInDiscoverPage(String Name) {
	//					return By
	//							.xpath("((//*[@class='UIACollectionView'])[2]//child::*//*[contains(@id,'" + Name + "')])");
	//					// ((//*[@class='UIACollectionView'])[2]//child::*//*[contains(@id,'Mohit
	//					// Yadav')])
	//				}

	public static By DurationInSoundsScreen(int index) {
		return By.xpath("(//*[contains(@id,'ort')]//following::*[contains(@value,':') and contains(@class,'Text')])[" + index + "]");


		//(//*[contains(@id,'ort')]//following::*[contains(@value,':') and contains(@class,'Text')])[1]

	}

	public static By UserNameInSoundsScreen(String name,int index) {
		return By.xpath("(//*[contains(@value,'"+name+"')and contains(@id,'Sound_')])[" + index + "]");


		//(//*[contains(@id,'ort')]//following::*[contains(@value,':') and contains(@class,'Text')])[1]

	}

	public static By objUseThisSoundButtonInSoundPage = By
			.xpath("//*[@id='Use this sound' and @class='UIAButton']");

	public static By objShareButtonInSoundPage = By.xpath("//*[contains(@id,'share')]");

	// Search Field Xpath after entered Name
	public static By objiosSearchFollowingFieldInDiscoverPage = By
			.xpath("//*[@placeholder='Search Following']");

	public static By IdValue(String ID) {
		return	By.xpath("//*[@id='"+ID+"']");
	}

	//----N---jan-27------------------------------------------------------------------------------





	//				  Rails present in Discover Page        

	public static By objiosRailsPresentInDiscoverPage(String tabname) {
		return By.xpath("[contains(//*[@id,'" + tabname + "'])]");
	}		 




	public static By objiosFirstItemInAnyVideoTray(String TrayName) {
		return By.xpath("(//*[@value='"+TrayName+"']//parent::*//following::*[@class='UIACollectionView']//*[contains(@id,'outline_')])[1]");
	}

	////*[@value='#BollywoodMasala']//parent::*//following::*[@class='UIACollectionView']//*[@id='ic_outline_play'])[1] | (//*[@value='#BollywoodMasala']//parent::*//following::*[@class='UIACollectionView']//*[contains(@id,'Video')])[1]	


	public static By objiosPageIndicator = By.xpath("//*[@class='UIAPageIndicator']");




	public static By objiosRecentSearchesTextinSearchParentPage = By.xpath("(//*[@id='Recent searches'])[2]");

	// See More button in Discover Page

	public static By objiosSeeeMoreButton = By.xpath("//*[@id='See more']");


	public static By objiosSeeMoreArrowForSearchedResults(String trayTitle){
		return By.xpath("//*[contains(@text,'"+trayTitle +"')]//parent::*//*[@id='See more']");

	}



	// views in hashtages page
	public static By objiosViewsInHashtagePage = By.xpath("//*[contains(text(),' Views')] | //*[contains(@id,'views')]");

	// ================= given by s
	// 12-01-2022========================================

	// Followers list in user profile
	public static By objiosFollwersListOfUser = By.xpath("(//*[contains(text(),'Follower')])[1]");



	// username in the userlist page
	public static By objiosUsernameInUserPage = By.xpath("(//*[@id='ic back arrow']//following-sibling::* | //*[contains(@id,'back')]//following::*//*[@class='UIACollectionView']//child::*//*[@knownSuperClass='UIStackView']//child::*)[1]");

	//S==============jan-27-------------------------------------------------------------------------------

	//Followers In uSer Profile
	public static By objiosFollowerInUserProfile=By.xpath("//*[@id='Followers']");

	//first follower in user list
	public static By objiosFirstFollwerInUserList=By.xpath("((//*[@id='Follow'])[1]//parent::*//following-sibling::*//*[@class='UIAStaticText'])[1]");

	//userprofile 
	public static By objiosUserNameInUserProfilePage=By.xpath("//*[contains(@id,'Name-UsernameProfilePage')]");




	public static By FollowInFollwersForUser(int index){
		return By.xpath("(//*[@id='Follow'])["+index +"]");
	}

	//Followers Page
	public static By objiosSearchFieldInFollwersPage=By.xpath("//*[@class='UIATextField']");


	////////////////////////6-1-22///////////////////////////////////////////////////



	public static By UserProfileNameInUserTabPage(int index1,int index2) {
		return By.xpath("(//*[@class='UIAImage'])["+index1+"]//following-sibling::*//child::*["+index2+"]");
	}

	//following is user profile
	public static By objiosFollowingInUserProfile=By.xpath("//*[@id='Following']");


	public static By objiosFirstSearchedResultInDiscoverPage(String Name) {
		return By.xpath("//*[contains(@id,'profile_1')]");
		//((//*[@class='UIACollectionView'])[2]//child::*//*[contains(@id,'Mohit Yadav')])
	}

	////////////////////////////10-1-22////////////////////////////////////////////////////////


	public static By TrayInDiscoverPage(String Trayname) {
		return By.xpath("//*[@value='"+Trayname+"' and contains(@accessibilityLabel,'RailName')]");
	}
	// //*[@value='Bollywood Zone' and contains(@accessibilityLabel,'RailName')]

	public static By NavigationBarTrayTitle(String Trayname) {
		return By.xpath("//*[@class='UIANavigationBar']/child::*[contains(@value,'"+Trayname+"')]");
	}



	public static By FirstItemNameInTrayInDiscoverPage(String TrayName) {
		return By.xpath("(//*[@value='"+TrayName+"']//following::*//*[contains(@accessibilityLabel,'Profile_Name_0')])[2]");
	}



	//////////////////////////////12-1-22////////////////////////////////////////////////////////////////////

	//HashTag in Discover Search Tab

	public static By HastagInDiscoverSearchTab(int index){
		return By.xpath("(//*[contains(text(),'#')])["+index+"]");
	}

	//verify profile name in video
	public static By objiosUserNameInVideo=By.xpath("//*[contains(text(),'@')]");

	//Views Sound in Sound details page
	public static By objiosViewsInSoundsVideos=By.xpath("//*[@id='ic_outline_play']//following-sibling::*[1] | //*[contains(@id,'views_count_1')]");

	//Likes In sound videos Page
	public static By objiosLikesInSoundVideos=By.xpath("//*[@id='ic_unlike_video']//following-sibling::*");

	///////////////////////////////////////////13-1-22/////////////////////////////////////////////////////////////
	//shop button in videos tab
	public static By onjiosShopTabInVideo=By.xpath("(//*[@id='ic_shoppable'])[1] | (//*[contains(@id,'hoppable')])[1]");

	//Like Videos In Icon In Videos
	public static By objiosLikeVideoIconInVideos=By.xpath("(//*[@id='ic_unlike_video'])[1]| (//*[contains(@id,'Like')])[1]");

	//user name below profile photo 
	public static By objiosProfileNameBeloProfilePhotoInProfilePage=By.xpath("(//*[@id='Follow']//preceding::*//*[@knownSuperClass='UIStackView'])[1]");


	//////////////////21-1-22//////////////////////////


	public static By objiosBackArrowInSoundTab=By.xpath("//*[contains(@id,'back_arrow')]");		

	//---------------------------------Kiran--march--31st--------------------	
	public static By objiosUserProfileInUserTab=By.xpath("//*[contains(@id,'profile_image_')]");

	public static By objiosProfileImage_1InUserTab=By.xpath("//*[contains(@id,'profile_image_1')]");

	public static By objiosProfile_1InUserTab=By.xpath("//*[contains(@id,'profile_1')][1]");

	public static By objiosProfileName_1InUserTab=By.xpath("//*[contains(@id,'profile_name_1')]");

	public static By objiosprofile_1_total_followersInUserTab=By.xpath("//*[contains(@id,'profile_1_total_followers')]");

	public static By objiosSound_1_Play_btnInSoundsTab=By.xpath("//*[contains(@id,'Sound_1_Play_btn_play')]");

	public static By objiosSound_1_Pause_btnInSoundsTab=By.xpath("//*[contains(@id,'Sound_1_Play_btn_pause')]");

	public static By objiosSoundTitleInSoundsTab=By.xpath("//*[contains(@id,'Sound_1')][2]");

	public static By objiosFirstSoundTitleInSoundsTab=By.xpath("(//*[@id='com.zee5.hipi:id/Sound_1'])[1]");

	public static By objiosSoundTitleInUseThisSoundsScreen=By.xpath("//*[@id='com.zee5.hipi:id/Sound_Name']");


	public static By objiosSoundTitleInSoundScreen=By.xpath("//*[contains(@id,'playback_singers_name')]");


	public static By objiosDiscoverScreen=By.xpath("//*[contains(@id,'DiscoverScreen')]");

	public static By objiosOriginalSoundSoundScreen=By.xpath("//*[contains(@id,'playback_singers_name')]");

	public static By objiosTotalLikesCountsInUseThisSoundScreen=By.xpath("//*[contains(@id,'total_likes_count_1')]");

	public static By objiosTotalViewCountsInUseThisSoundScreen=By.xpath("//*[contains(@id,'total_views_count_1')]");

	public static By objiosTitleInFullSoundScreen=By.xpath("//*[contains(@id,'sound video')]//following-sibling::*");

	public static By objiosFirstVideoInVideosScreen=By.xpath("(//*[contains(@id,'Video1')])[1]");

	public static By objiosProfileImage1InTopScreen=By.xpath("//*[contains(@id,'profile_image_1')]");

	public static By objiosProfileImage2InTopScreen=By.xpath("//*[contains(@id,'profile_image_2')]");	

	public static By objiosfavouriteInHastag=By.xpath("(//*[@id='Add to Favourites'])[1]");

	public static By objiosShareButtonInHastagPage=By.xpath("//*[contains(@id,'share')]");

	public static By objiosCreateVideoButtonInHastagPage=By.xpath("//*[contains(@id,'Create Video')]");

	public static By objiosFirstVideoInHastagPage=By.xpath("//*[contains(@id,'_total_')]"); 

	public static By objiosHashtagSceenInHastagPage=By.xpath("//*[contains(@id,'HashtagScreen')]");

	public static By objiosBannerImageInDiscoverpage=By.xpath("//*[contains(@id,'Banner_')]");

	public static By objiosBannerImage3InDiscoverpage=By.xpath("//*[contains(@id,'Banner_3')]");

	public static By objiosArrowNextInDiscoverpage=By.xpath("(//*[contains(@id,'ic arrow next')])[2]");

	public static By objiosProfile1InDiscoverpage=By.xpath("//*[contains(@id,'Profile_Name_0')][1]");

	public static By objiosProfile1InProfileRailScreen=By.xpath("(//*[contains(@id,'Followers')])[1]");

	public static By objiosHashTagRailNameInDiscoverpage=By.xpath("(//*[contains(@id,'HashTag_RailName')])[1]");


	public static By objiosHashtagTitle=By.xpath("//*[@name='com.zee5.hipi:id/Hashtag_title']");

	public static By objiosHastagTrayArrowButton=By.xpath("(//*[@id='ic_hashtag']//following::*//*[@id='com.zee5.hipi:id/HashTag_RailName'])[1]");


	//1-08-2022

	//Suggestion
	public static By SuggestionInDiscoverSearch(int i){
		return By.xpath("(//*[@id='loupe']/following-sibling::*[2])["+i+"]");
	}



}
