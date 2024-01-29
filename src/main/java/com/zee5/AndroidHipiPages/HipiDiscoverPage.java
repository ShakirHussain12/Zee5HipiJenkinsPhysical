package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiDiscoverPage {

	
	
	public static By objDiscoverSearchButton = By.xpath("//*[@class='android.widget.FrameLayout' and @index='1']");
	
	public static By objhashtagBanner = By.xpath("//*[@id='banner_layer']");
	


	public static By objDiscovertext=By.id("com.zee5.hipi:id/discoverimage");
	//discoversearch
	public static By objdiscoversearchtext=By.xpath("//*[@class='android.widget.ImageView'and @index='0']");
	//framelayout
	public static By objframelayout=By.xpath("//*[contains(@resource-id,'thumbnail')]");
	//effectused
	public static By objeffectused=By.id("com.zee5.hipi:id/usedEffect");
	
	public static By objeffectused1=By.xpath("//*[contains(@resource-id,'usedEffect')]");
	
	//searchtext
	public static By objsearchtext=By.id("com.zee5.hipi:id/editTextSearch");
	//search
	public  static By objsearchbutton=By.xpath("//*[@resource-id='com.google.android.inputmethod.latin:id/icon' and @index='1']");
	//hastagtext
	public static By objhastagtext=By.xpath("//*[@text='Hashtag']");
	//hashtagtext
	public static By objhashtag=By.xpath("//*[@resource-id='com.zee5.hipi:id/title' and @text='Hashtags ']");
	//hashtagname
	public static By objhashtagname=By.xpath("//*[@resource-id='com.zee5.hipi:id/title' and @text='#FitHitChallenge']");

	public static By objFirstHashtag=By.xpath("(((//*[@resource-id='com.zee5.hipi:id/hashtagRail'])//child::*//child::*//child::*)//child::*//child::*)[1]");
	
	public static By objHashtagSecondTumbnail=By.xpath("(((((((//*[@text='Hashtags'])//parent::*)//parent::*)//child::*[2])//child::*[2])//child::*)//child::*)[2]");
	
	public static By objSpecificHashtagText(String hashtagText){
		return By.xpath("(((((((((//*[@text='Hashtags'])//parent::*)//parent::*)//child::*[2])//child::*)//child::*)//child::*)//child::*) [@text='"+hashtagText+"'])");
	}
	
	//hashtagnameused
	public static By objhashtagnameused=By.xpath("//*[contains(@resource-id,'hashtagName')]");
	//thumbnail image
	public static By objthumbnail=By.xpath("//*[contains(@resource-id,'hashImage')]");
	//videos created using hashtag
	public static By objlistofvideos=By.xpath("//*[@text='Videos Created Using Hashtag']");//*[@text='Videos Created Using Hashtag']
	//thumbnailvideos
	public static By objthumbnailvideos=By.xpath("//*[contains(@resource-id,'thumbnail')]");
	
	public static By objThumbnailTexts=By.xpath("//*[contains(@resource-id,'detail')]");
	
	public static By objThumbnailText(int i){
		return By.xpath("(//*[@resource-id='com.zee5.hipi:id/detail'])["+i+"]");
				
	}
	
	public static By objthumbnailVideosText=By.xpath("//*[contains(@resource-id,'detail')]");
	
	public static By objthumbnailVideosText(int i){
		return By.xpath("(//*[@resource-id='com.zee5.hipi:id/detail'])["+i+"]");
	}
	
	//usethishashtag
	public static By objusethishashtag=By.xpath("//*[contains(@resource-id,'hashtagText')]");
	//hashtagfamilyname
	public static By objfamilyname=By.xpath("//*[@text='#FAMILY']");
	//familythumbnailname
	public static By objfamilythumbnailname=By.xpath("//*[@text='family']");
	//familythumbnail
	public static By objfamilythumbnail=By.xpath("//*[contains(@resource-id,'hashImage')]");
	//familyvideos
	public static By objfamilyvideos=By.xpath("//*[contains(@resource-id,'hashtagVideosCount')]");
	//favoritebutton
	public static By objfavourite=By.xpath("//*[contains(@resource-id,'favBtn')]");
	//videos
	public static By objvideos=By.xpath("//*[contains(@resource-id,'hashtagVideosCount')]");

	
	
	
	
public static By objRecentSearch = By.xpath("//*[@id='recent_and_trending_layout']");
	
	public static By objTrending = By.xpath("//*[@id='tv_trending']");
	
	public static By objAllTab = By.xpath("//*[@text='All']");
	
	public static By objUserTab = By.xpath("//*[contains(@text,'User')]");
	
	public static By objHipiTsTab = By.xpath("//*[@text='HiPiTs']");
	
	public static By objSoundTab = By.xpath("//*[@text='Sound']");
	
	public static By objHashtagTab = By.xpath("//*[@text='Hashtag']");
	
	public static By objMore = By.xpath("(//*[@contentDescription='More'])[2]");
	
	public static By objTrayTitle = By.xpath("(//*[@id='title'])[1]");
	
	public static By objThumbnail = By.xpath("//*[@id='thumbnail']");
	
	public static By objMusicTitle(String title) {
		return By.xpath("(//*[@id='music_name' and @text='"+title+"'])[1]");
	}
	
	public static By objHashtagTitle(String title) {
		return By.xpath("(//*[@id='title' and @text='"+title+"'])[1]");
	}
	
	public static By objThumbnail1 = By.xpath("(//*[@id='thumbnail'])[1]");
	
	public static By objDiscoverOption= By.xpath("//*[contains(@resource-id,'discoverimage')]");
	
	
	public static By objSearchButton = By.xpath("//*[@id='editTextSearch']");
	
	
	public static By objTrendingSearch = By.xpath("(//*[@class='android.widget.TextView'])[2]");
	
	public static By objDiscoverTitle = By.xpath("(//*[@class='android.widget.TextView' and @text='Discover'])[1]");
	
	
	
	
	public static By objDiscoverScreen = By.xpath("//*[@text='Discover']");
	
	
	public static By objTrendingVideos = By.xpath("//*[contains(@resource-id,'image')]");
	
	public static By objStarIconInImage = By.xpath("//*[contains(@resource-id,'favBtn')]");
	
	public static By objHashtagFun = By.xpath("//*[@id='thumbnail' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='#fun']]]");
	
	public static By objHashTagBanner = By.xpath("//*[contains(@resource-id,'image')]");


	//Search Results - Metadata
		public static By objMetadataSearchResults(String searchMetadata) {
			return By.xpath("//*[@resource-id='com.zee5.hipi:id/thumbnail']//following-sibling::*//*[@resource-id='com.zee5.hipi:id/detail' and contains(text(),'"+searchMetadata+"')]");
		}
		//Search Results - Metadata
		public static By objMetadataSearchResults(String searchMetadata, int i) {
			return By.xpath("(//*[@resource-id='com.zee5.hipi:id/thumbnail']//following-sibling::*//*[@resource-id='com.zee5.hipi:id/detail' and contains(text(),'"+searchMetadata+"')])["+i+"]");
		}
		//Search Results - Hashtag
		public static By objHashtagSearchResults(String searchHashtag) {
			return By.xpath("//*[@resource-id='com.zee5.hipi:id/hashtagRail']//*[@resource-id='com.zee5.hipi:id/hashtagResultRecyclerView']//*[@class='android.widget.TextView' and contains(text(),'"+searchHashtag+"')]");
		}
		//Search Results - Hashtag
		public static By objHashtagSearchResults(String searchHashtag, int i) {
			return By.xpath("(//*[@resource-id='com.zee5.hipi:id/hashtagRail']//*[@resource-id='com.zee5.hipi:id/hashtagResultRecyclerView']//*[@class='android.widget.TextView' and contains(text(),'"+searchHashtag+"')])["+i+"]");
		}
		//Search Results - Profile
		public static By objProfileSearchResults(String searchProfile) {
			return By.xpath("//*[@resource-id='com.zee5.hipi:id/userResult']//*[@resource-id='com.zee5.hipi:id/music_name' and contains(text(),'"+searchProfile+"')]");
		}
		//Search Results - Profile
		public static By objProfileSearchResults(String searchProfile, int i) {
			return By.xpath("(//*[@resource-id='com.zee5.hipi:id/userResult']//*[@resource-id='com.zee5.hipi:id/music_name' and contains(text(),'"+searchProfile+"')])["+i+"]");
		}
		//Cross Icon in Search Textfield
		public static By objCrossIcon = By.xpath("//*[contains(@resource-id,'img_clear')]");
		//Search Tabs
		public static By objSearchTab(String tabName) {
			return By.xpath("//*[@resource-id='com.zee5.hipi:id/tabs']//*[@text='"+tabName+"']");
		}
		//First Searched Result under All Tab
		public static By objFirstSearchedResultAllTab(String searchKeyword) {
			return By.xpath("(//*[@resource-id='com.zee5.hipi:id/dynamic_add_discover_result_layout']//*[contains(text(),'"+searchKeyword+"')])[1]");
		}
		//First Searched Result under User Tab
		public static By objFirstSearchedResultUserTab(String searchKeyword) {
			return By.xpath("(//*[@resource-id='com.zee5.hipi:id/allDiscoverResultUserRecyclerView']//*[contains(text(),'"+searchKeyword+"')])[1]");
		}
		//First Searched Result under HiPiTs Tab
		public static By objFirstSearchedResultHiPiTsTab(String searchKeyword) {
			return By.xpath("(//*[@resource-id='com.zee5.hipi:id/searchDiscoverRecyclerView']//*[contains(text(),'"+searchKeyword+"')])[1]");
		}
		//First Searched Result under Sound Tab
		public static By objFirstSearchedResultSoundTab(String searchKeyword) {
			return By.xpath("(//*[@resource-id='com.zee5.hipi:id/discover_result_music_adapter_recycler_view']//*[contains(text(),'"+searchKeyword+"')])[1]");
		}
		//First Searched Result under HashTag Tab
		public static By objFirstSearchedResultHashtagTab = By.xpath("(//*[@id='discover_result_all_hashtags_recyclerView']//*[@resource-id='com.zee5.hipi:id/title'])[1]");
	
		//Landing screen Tray title
		public static By objTray(String trayTitle) {
			return By.xpath("(//*[@resource-id='com.zee5.hipi:id/layoutHeader']//*[@id='title' and contains(text(),'"+trayTitle+"')])[1]");
		}
		//Landing Screen Tray first card
		public static By objTrayFirstCard(String trayTitle) {
			return By.xpath("(//*[@id='title' and @text='"+trayTitle+"']/parent::*[@id='layoutHeader']//following-sibling::*[contains(@id,'discover_landing_item_section_recycler_view')]//*[@id='adapterView'])[1]");
		}
	
	
		//Back Icon
		public static By objBackButton = By.xpath("//*[contains(@resource-id,'img_back')]");
	
		
		//First Searched Result under All Tab
		public static By objFirstSearchedResultAllTab = By.xpath("(//*[@resource-id='com.zee5.hipi:id/allDiscoverResultUserRecyclerView']//*[@resource-id='com.zee5.hipi:id/music_name'])[1]");
		
		//First Searched Result under User Tab
		public static By objFirstSearchedResultUserTab = By.xpath("(//*[@resource-id='com.zee5.hipi:id/allDiscoverResultUserRecyclerView']//*[@resource-id='com.zee5.hipi:id/music_name'])[1]");
		
		//First Searched Result under Sound Tab
		public static By objFirstSearchedResultSoundTab = By.xpath("(//*[@resource-id='com.zee5.hipi:id/musicName'])[1]");
		
		//First Trending Search Suggestion
		public static By objThirdTrendingSearchSuggestion = By.xpath("(//*[@resource-id='com.zee5.hipi:id/rv_trending_search']//*[@class='android.widget.TextView'])[1]");

		
		
		//===============================================Kartheek===============================
		
		public static By objDiscoverSearchBar = By.xpath("//*[@resource-id='com.zee5.hipi:id/search'] | //*[@resource-id='com.zee5.hipi:id/tvSearch']");
		
		//Search result
		public static By objSearchResult = By.xpath("(//*[@resource-id='com.zee5.hipi:id/searchTitle'])[1] | //*[@class='bne$a' and @index='42'] | //*[@id='0_resource_name_obfuscated' and @class='android.widget.ImageView' and ./parent::*[./parent::*[@id='key_pos_ime_action']] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.ImageView']] | (//*[@id='keyboardView']/*[@class='cca'])[43] | //*[@content-desc='Enter']");
		
		//Videos Tab
		public static By objVideoTab = By.xpath("//*[@contentDescription='Videos']");
		//Bucket Icon
		public static By objBucketIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/ivShop']");

		//Discover Search Inbox
		public static By objDiscoverSearchInbox = By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");

		//More Button trending On Hipi
		public static By objMoreButtonTrendingOnHipi = By.xpath("//*[@resource-id='com.zee5.hipi:id/btnMore']");											

		//5th Profile
		public static By obj5thProfile = By.xpath("(//*[@text='Bollywood Zone']//following::*//*[@resource-id='com.zee5.hipi:id/imageView'])[5]");


		//More Button trending On Hipi
		public static By objMoreButtonProfile = By.xpath("//*[@resource-id='com.zee5.hipi:id/btnMore' and @index='1']");											

		
		
		//===========================================Deepa===============================================
		//Back Button Search Bar present in discover page
		public static By objBackButtonSearchBar = By.xpath("//*[@resource-id='com.zee5.hipi:id/img_back']");
		//Top on Search Results  screen
		public static By objTopButton = By.xpath("//*[@contentDescription='Top'] | //*[@text='Top'] ");
		//Banners
				public static By objBannersBelowTheSearchField = By.xpath("//*[@resource-id='com.zee5.hipi:id/image']");	
		        //Back Button Search Bar in banner  detail page 
		        public static By objBannerDetailsPageBackButton  = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgBack']");  
		        //Banner Detail page header
		        public static By objBannerDetailsPageHeader = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgBack']");
		        // Arrow mark present in-front of title name
		        public static By objArrowMarkPresentInfrontTitleName  = By.xpath("(//*[@resource-id='com.zee5.hipi:id/btnMore'])[1]");
//		        		By.xpath("//*[@id='btnMore' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@contentDescription='ID2circular']]]]");		        //Follow button
		        public static By objFollowButton = By.xpath("//*[@id='tvFollow']");
		        //Profile From Rail
		      	public static By objProfileFromRail = By.xpath("//*[@id='imageView' and ./parent::*[@contentDescription='ID0User'] and (./preceding-sibling::* | ./following-sibling::*)[@text]]");		        
		      	//related hashtag videos
		      	public static By objRelatedHashtagVideos = By.xpath("//*[@id='thumbnail' and ./parent::*[@contentDescription='ID0Video']]");		        
		      	//Following tab
		      	public static By objFollowingTab= By.xpath("//*[@text='Following']");		        
		      	//Search Field On The Following Tab
		    	public static By objSearchFieldOnTheFollowingTab= By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");
		    	//Rail Names
		    	public static By objRailsTitle= By.xpath("(//*[@resource-id='com.zee5.hipi:id/title'])[1]");
		    	//Videos Banner Detail page
		        public static By objVideosBannerDetailPage = By.xpath("(//*[@id='recyclerView']/*/*[@id='thumbnail'])[1]");
		    	
		        
		        
		        
		    	//---------------------------------------------------Nithin---------------------------
		    	
				
				//Searchpage (search parent page)
				public static By objDiscoversearchparentpage = By.xpath("//*[@resource-id='com.zee5.hipi:id/search']");	
		//keypad
				public static By objkeyboard = By.xpath("//*[@resource-id='com.facemoji.lite.xiaomi:id/keyboard_view']");
		//auto Suggest
				public static By objautoSuggest = By.xpath("(//*[@id='rv_suggest']/*/*[@id='searchTitle'])[1]");
				
		//Search button in keyboard
				public static By objkeyboardSearchbutton = By.xpath("//*[@class='android.widget.FrameLayout' and ./parent::*[@id='key_pos_ime_action'] and ./*[@id='0_resource_name_obfuscated' and @class='android.widget.ImageView']]");
		//cross icone 
				public static By objcrossicone = By.xpath("//*[@resource-id='com.zee5.hipi:id/iv_clear_text']");
		//Top tab in Search result page
				public static By objToptabinSearchresultpage = By.xpath("//*[@text and @class='android.widget.TextView' and ./parent::*[@contentDescription='Top']]");

		// user tab in Search result page       
				public static By objUsertabinSearchresultpage = By.xpath("//*[@contentDescription='Users']");

		// videos tab in Search result page
				public static By objVideostabinSearchresultpage = By.xpath("//*[@contentDescription='Videos']");	
		// Sound tab in Search result page
				public static By objSoundtabinSearchresultpage = By.xpath("//*[@contentDescription='Sounds']");
			
		// HAshtags tab in Search result page	
				public static By objHashtagsTab = By.xpath("//*[@class='android.widget.TextView' and @text='Hashtags']");	
				
				//for loop
//				public static By objForloopSearchresultpage = By.xpath("//*[@contentDescription='Top']/following-sibling::*[i]");
				
//			verify top page	after clicking
				public static By objUsersTopPage = By.xpath("//*[@contentDescription='Users']");	
				
//			verify USer page	after clicking
				public static By objUserpageasSearchresultpage = By.xpath("(//*[@id='UserRecyclerView']/*/*[@id='musicName' and (./preceding-sibling::*./following-sibling::*)[@id='userFollowers']])[1]");		

//				verify videos page after clicking
				public static By objvideospageasSearchresultpage = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgLayout']");	

//				verify Sounds page after clicking
				public static By objsoundspageasSearchresultpage = By.xpath("(//*[@id='SoundResultRecyclerView']/*/*[@id='musicName'])[1]");

//				verify hashtage page after clicking
				public static By objhashtagepageasSearchresultpage = By.xpath("//*[@id='txtGenreName']");
				
		// categories in top page		
				
				//user
				public static By objUserTopTabpage = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvUsers']");	

				
			//videos
				public static By objtoppagevideosrail = By.xpath("//*[@id='tvVideo']");	
		//hashtags	
				public static By objtoppagehashtagsrail = By.xpath("//*[@id='tvHashtag']");	
		//sounds	
				public static By objtoppagesoundsrail = By.xpath("//*[@id='tvSound']");
				
		// related search
				public static By objtrelatedsearch = By.xpath("//*[@id='musicName']");
			//followers USer tab
				public static By objFollowersCount = By.xpath("//*[@id='userFollowers']");
				//  user image in user tab
				public static By objimage_USertab = By.xpath("//*[@id='imageView']");
				//user name in user tab
				public static By objname_USertab = By.xpath("//*[@id='musicName']");
		//follow button		
				public static By objfollowbutton_USertab = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvFollow']");
		//one of the user in list	
				public static By objUserPageFirstUser = By.xpath("(//*[@resource-id='com.zee5.hipi:id/musicName'])[1]");	
		//following tab	
				public static By objFollowingtab_USertab = By.xpath("//*[@text='Following']");
			//following tab search user
				public static By objuserfromlist_USertab = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtUserHandle']");	
			//first search
				public static By objfirstuserfromlist_USertab = By.xpath("(//*[@resource-id='com.zee5.hipi:id/music_name'])[1]");	
			//respected serach
				public static By objfirstuserfrom_ram_USertab = By.xpath("//*[@text='Ram pyaare sirf hamare']");
				
		//back button		
				public static By objbackbutton_USertab = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgBack']");
		// use sound button 
				public static By objUseThisSound = By.xpath("//*[@text and ./parent::*[@id='createVideo']]");	
		// Add to Favourites Button
				public static By objaddtofavouritesbutton_Soundtab = By.xpath("//*[@resource-id='com.zee5.hipi:id/soundAddFav']");
		//added to  Favourites Button
				public static By objAddedToFavouritesbutton = By.xpath("//*[@text='Added to Favourite']");
				
			// favourites sounds after add to favourites	
				public static By objaddtofavouriteAddSound_Soundtab = By.xpath("//*[@class='android.view.ViewGroup' and ./*[@id='imgEffect']]");	
		//related viedo xpath
				public static By objrelatedvioedosSound = By.xpath("//*[@resource-id='com.zee5.hipi:id/thumbnail']");//*[@resource-id='com.zee5.hipi:id/thumbnail']
		// like counts 		
				public static By objnumberoflikesforvioedosSound = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtLikeCount']");	
		// view count
				public static By objnumberofviewforvioedosSound = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtPlayCount']");	
		//device back button
				public static By objDevicebackbutton = By.xpath("//*[@resource-id='com.android.systemui:id/back']");
		//full player screen 
				public static By objFullPlayerScreen = By.xpath("//*[@resource-id='com.zee5.hipi:id/exo_controller']");
		//banner rail
				public static By objBannersRail = By.xpath("//*[@resource-id='com.zee5.hipi:id/bannerLayer']");
		//banner related header
				public static By objBannerHeader = By.xpath("//*[@resource-id='com.zee5.hipi:id/hashtagName'] | //*[@resource-id='com.zee5.hipi:id/profile_pic']");	
		//favourites rail to hashtag
				public static By objfavoriteshashtags = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtGenreName']");
			//swipeing	
				public static By objSwipconformation = By.xpath("(//*[@id='tabIndicators']//child::*)//*[@class='android.widget.LinearLayout' and @selected='true']");	
			//	(//*[@id='tabIndicators']//child::*)//*[@class='android.widget.LinearLayout' and @selected='true']

		//create video button
				public static By objCreateVideoButton = By.xpath("//*[@text='Create video']");
		//record button
				public static By objRecordButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/record_btn']");	
		//bollywood rail		
				public static By objBollywoodRail = By.xpath("(//*[@resource-id='com.zee5.hipi:id/imageView'])[6]");
				
//			first profile
		public static By objFirstProfileName = By.xpath("(//*[@resource-id='com.zee5.hipi:id/textView'])[1]");	
		//respected sound Tittle	
				public static By objSoundTittle = By.xpath("//*[@resource-id='com.zee5.hipi:id/musicTitle']");			
		//Hashtag videos
				public static By objHashtagVideos = By.xpath("//*[@resource-id='com.zee5.hipi:id/ivIcon']//following::*//*[@resource-id='com.zee5.hipi:id/thumbnail']");

			
		//Top Page Selected
				public static By objTopPageSelected = By.xpath("//*[@text='Top' and @selected='true']");
	
				//User Page Selected
				public static By objUserPageSelected = By.xpath("//*[@text='Users' and @selected='true']");	
				//Videos Page Selected
				public static By objVideosPageSelected = By.xpath("//*[@text='Videos' and @selected='true']");		
				//Sounds Page Selected
				public static By objSoundsPageSelected = By.xpath("//*[@text='Sounds' and @selected='true']");	
				
				//Hashtags Page Selected
				public static By objHashtagsPageSelected = By.xpath("//*[@text='Hashtags' and @selected='true']");	
				//Hashtags Top Page
				public static By objHashtagsTapPage = By.xpath("//*[@contentDescription='Hashtags']");	
				//Soundes Top Page
				public static By objSoundesTapPage = By.xpath("//*[@contentDescription='Sounds']");	
				
		//------------------------------------muthu--------------------------------------------------------------------------------
				public static By objAddToFavorite=By.xpath("//*[@resource-id='com.zee5.hipi:id/hashtagAddFav']");
				//Bollywood Zone Header
				public static By objFirstRailHeader=By.xpath("(//*[@resource-id='com.zee5.hipi:id/title'])[1]");

				//Rail for Bollywood Zone
				public static By objFirstRailImage=By.xpath("(//*[@resource-id='com.zee5.hipi:id/imageView'])[1]");
				//Banner Pictures
				public static By objBannerPictures=By.xpath("//*[@resource-id='com.zee5.hipi:id/bannerLayer']");
				//Bollywood ZOne arrow mark
				public static By objArrowMarkFirstRailProfile=By.xpath("//*[@resource-id='com.zee5.hipi:id/title']//following::*[@resource-id='com.zee5.hipi:id/btnMore' and @index='1']");
				//Bollywood Zone After tapping arrow button
				public static By objBollywoodZoneAfterTappingArrow=By.xpath("//*[@resource-id='com.zee5.hipi:id/btnMore']");
				//Bollywood zone profile icon
				public static By objProfileIconInBollywoodZone=By.xpath("//*[@resource-id='com.zee5.hipi:id/userHandle']");
				//Bollywood Zone profile icon User header
				public static By objProfileUserHeaderInBollywoodZone=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtUserHandle']");
				//Following button in profile details
				public static By objFollowingInProfileDetails=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtFollowing']");
				//Follow Button
//				public static By objFollowButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvFollow']");
				//Name in User Details    //*[@resource-id='com.zee5.hipi:id/btnMore' and @index='1']
				public static By objNameUserDetails =By.xpath("(//*[@id='UserRecyclerView']/*/*[@id='userName'])[1]");
				//Tv shorts headline
				public static By objTVShortsHeader=By.xpath("(//*[@text='TV Zone']//following::*//*[@resource-id='com.zee5.hipi:id/imageView'])[1]");
				//Tv shorts 
				public static By objTvShortsFirstRail=By.xpath("(//*[@text='TV Zone']//following::*[@resource-id='com.zee5.hipi:id/textView' ])[1]");
				//Following Button inside Profile Details
				public static By objFollowingButtonInsideProfileDetails=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtFollowing']");
				//Search Following 
				public static By objSearchFollowing=By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");
				//Followers in profile details 
				public static By objFollowersButtonInsideProfileDetails=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtFollow']");
				//followers name list 
				public static By objFollowersListClick=By.xpath("(//*[@resource-id='com.zee5.hipi:id/music_name'])[1]");
				//Hashtag name
				public static By objHashTagNameInBannerPictures=By.xpath("//*[@resource-id='com.zee5.hipi:id/hashtagName']");
				//Banner pictures index 1
				public static By objBannerPictureIndex1=By.xpath("(//*[@class='android.widget.LinearLayout'])[4]/child::*[1]");
				//Banner pictures index 2
				public static By objBannerPictureIndex2=By.xpath("(//*[@class='android.widget.LinearLayout'])[4]/child::*[2]");
				//Banner pictures index 3
				public static By objBannerPictureIndex3=By.xpath("(//*[@class='android.widget.LinearLayout'])[4]/child::*[3]");
				//Banner pictures index 4
				public static By objBannerPictureIndex4=By.xpath("(//*[@class='android.widget.LinearLayout'])[4]/child::*[4]");
				//Banner pictures index 5
				public static By objBannerPictureIndex5=By.xpath("(//*[@class='android.widget.LinearLayout'])[4]/child::*[5]");
				//
				//public static By objBannerAutoSlide(int index) {
					//return By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tabIndicators']]/*[@class='android.widget.LinearLayout'])[" + index + "]");
				//}
				public static By objRespectedFollowingUser(String name1) {
					return By.xpath("//*[@resource-id='com.zee5.hipi:id/music_name' and @text='" + name1 +"']");
				}
				
				public static By objBannerAutoSlide(int traytitle) {
					return By.xpath("//*[@id='tabIndicators']//child::*[@index='" + traytitle +"']");
				}
				
				
						public static By objBanner4=By.xpath("(//*[@id='title'])[1]");	
				public static By objBanner2=By.xpath("//*[@id='tabIndicators']//child::*[@selected='true']");
						//("//*[@id='tabIndicators']//child::*[@selected ='true']");
				//*[@resource-id='com.zee5.hipi:id/tabIndicators']//*[@selected='true']
				//Banner Image
				

				public static By objBannerImage=By.xpath("(//*[@class='androidx.recyclerview.widget.RecyclerView'])/child::*[@resource-id='com.zee5.hipi:id/image']");
				//Trending in Hipi Videos
				public static By objAnyHipiVideo=By.xpath("(//*[@resource-id='com.zee5.hipi:id/thumbnail'])[1]");
				//Like Icon
				public static By objLikeIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/image_view_option_like']");
				//Back Button in video
				public static By objBackButtonInVideo=By.xpath("//*[@resource-id='com.zee5.hipi:id/back_image']");
				
				//*[@id='recyclerView' and @contentDescription='ID1circular']/child::*[@resource-id='com.zee5.hipi:id/adapterView']/child::*[@resource-id='com.zee5.hipi:id/imageView']
				public static By objFirstUserProfileInRail=By.xpath("(//*[@resource-id='com.zee5.hipi:id/textView'])[1]");
				public static By objID6User=By.xpath("//*[@contentDescription='ID6User']");
				public static By objRecyclerView=By.xpath("(//*[@class='androidx.recyclerview.widget.RecyclerView'])[3]");
				//Share button in the user profile
				public static By objShareButtonInUserProfile=By.xpath("//*[@resource-id='com.zee5.hipi:id/imgShare']");
				//Fourth Banner pictures
				public static By objFourthBannerPicture=By.xpath("(//*[@resource-id='com.zee5.hipi:id/bannerLayer']//child::*[@index='0'])[5]");
				//("(//*[@resource-id='com.zee5.hipi:id/bannerLayer']//child::*[@index='2'])");
				//Carousel dots
				public static By objTabIndicator3=By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tabIndicators']]/*[@class='android.widget.LinearLayout'])[1]");
				//Select video 
				public static By objFirstVideoBannerPage=By.xpath("(//*[@resource-id='com.zee5.hipi:id/thumbnail'])[1]");
				
				//Overlay player screen
				public static By objOverlayPlayerScreen=By.xpath("//*[@resource-id='com.zee5.hipi:id/exo_overlay']");
				//Create video
				public static By objCreateVideo=By.xpath("//*[@text and ./parent::*[@id='createVideo']]");
				//Login popup
				public static By objLoginpopup=By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");
				//Swiping the Bollywood zone rail
				public static By objSwipeBollywoodRail=By.xpath("(//*[@resource-id='com.zee5.hipi:id/adapterView']//*[@resource-id='com.zee5.hipi:id/imageView'])[6]");
			// first text in boollywood Zone ranbir
				public static By objFirstTextInBollywood=By.xpath("(//*[@text='Bollywood Zone']//following::*//*[@resource-id='com.zee5.hipi:id/textView'])[1]");
				//
				public static By objFifthImageBollywoodZone=By.xpath("(//*[@text='Bollywood Zone']//following::*//*[@resource-id='com.zee5.hipi:id/imageView'])[5]");
				
				//Bollywood Zone Rails
				public static By objBollywoodZoneRails=By.xpath("//*[@text='Bollywood Zone']//parent::*//parent::*//following::*//*[@id='recyclerView']");
				//First Rail Swipe
				public static By objFirstRailSwipe=By.xpath("//*[@resource-id='com.zee5.hipi:id/imageView']//parent::*[@resource-id='com.zee5.hipi:id/adapterView']//parent::*[@resource-id='com.zee5.hipi:id/recyclerView']");
				// model face header
		        public static By objModelfaceHeader = By.xpath("  //*[@class='android.view.ViewGroup' and ./*[@id='hashImage']]");
		        //model face First video
		        public static By objModelfaceFirstVideo = By.xpath("(//*[@id='recyclerView']/*/*[@id='thumbnail'])[1]");
		        //Goat page
		        public static By objGoatPage = By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@contentDescription='ID1video']]");
		        //model 
		        public static By objGoatPageParticularElement = By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tabIndicators']]/*[@class='android.widget.LinearLayout'])[4]");
		
		      //Firstprofile 
		        public static By objFirstuserProfile = By.xpath("(//*[@resource-id='com.zee5.hipi:id/musicName'])[1]");
		      //secondprofile 
		        public static By objSeconduserProfile = By.xpath("(//*[@resource-id='com.zee5.hipi:id/musicName'])[2]");
		       //releated search result
		        public static By objReleatedSearchResult=By.xpath("//*[@id='rv_suggest']");
		        //profile name
		        public static By objProfileName=By.xpath("(//*[@id='UserRecyclerView']/*/*[@id='userName' and (./preceding-sibling::* | ./following-sibling::*)[@id='userFollowers']])[1]");
		      //Hashtags 
				public static By objHashhtags=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtGenreName']");
		        //=====================================Kartheek==============================================================
		      //list of following 
		        public static By objListOFFollowing=By.xpath("//*[@id='recyclerView']");
		        //user In followers tab
		        public static By objuserTab=By.xpath("(//*[@id='recyclerView']/*[./*[@id='image_user']])[1]");
		        //list of users
		        public static By objListOfUsers=By.xpath("//*[@id='UserRecyclerView']/*[./*[@id='userFollowers']]");
		        //Play button
		        public static By objPlayButton=By.xpath("(//*[@id='SoundResultRecyclerView']/*/*[@id='musicPlayBtn'])[1]");
		        //pause button
		        public static By objPauseButton=By.xpath("(//*[@id='SoundResultRecyclerView']/*/*[@id='musicPlayBtn'])[1]");
		        //list of songs
		        public static By objListOfSongs=By.xpath("//*[@class='androidx.recyclerview.widget.RecyclerView' and ./*[@class='android.widget.FrameLayout']]");
		        //music duration
		        public static By objDuration=By.xpath("(//*[@id='SoundResultRecyclerView']/*/*[@id='musicTime'])[1]");
		        //3 lines details in sound tab
		        public static By objThreeLinesDetailsInSoundTab=By.xpath("(//*[@resource-id='com.zee5.hipi:id/useSound'])[1]");
		


		     
		      //seemore tab
		        public static By objSoundSeeMore=By.xpath("//*[@id='tvSoundSeeMore']");
		        //public music poster
		        public static By objMusicPaster=By.xpath("//*[@id='musicImage']");
		        //View counts of hashtag
		        public static By objViewCountsOfHashTag=By.xpath("(//*[@id='hashtagResultRecyclerView']/*/*[@id='txtSeeCount'])");
		        //Hashtag in 
		        public static By objHashTag=By.xpath("(//*[@id='hashtagResultRecyclerView']/*/*[@id='imgEffect'])[1]");
		        //banner img
		        public static By objBannerImageinDetailsPage=By.xpath("//*[@id='hashImage']");
		        //Description below banner image
		        public static By objDescriptionBelowImage=By.xpath("//*[@id='hashtagDesc']");
		        //Bollywood zone rail name
		        public static By objBollywoodRailInDiscoverScreen=By.xpath("(//*[@resource-id='com.zee5.hipi:id/recyclerView'])[1]");
		       //bollywood profile name
		        public static By objBollywoodProfileName=By.xpath("(//*[@resource-id='com.zee5.hipi:id/textView'])[1]");
		       //bollywood image
		        public static By objBollywoodImage=By.xpath("//*[@id='imageView' and ./parent::*[@contentDescription='ID0User']]");
		        //bollywood user profile list
		        public static By objBollywoodProfileUserList=By.xpath("//*[@id='UserRecyclerView']/*[./*[@id='userName']][1]");
		        
		        //bollywood Follow button
		        public static By objBollywoodFollowButton=By.xpath("//*[@id='UserRecyclerView']/*/*[@id='followBtn' and (./preceding-sibling::* | ./following-sibling::*)[@id='userName']]");
		        //profile image
		        public static By objProfileImage=By.xpath("//*[@id='profile_pic']");
		        //Followers list Profilename
		        public static By objFollowersListProfileName=By.xpath("(//*[@id='recyclerView']/*/*[@id='music_name'])[1]");
		        //Search result through text 
		        public static By objSearchResultByText(String text)
		        {
		        	return By.xpath("//*[@text='" + text +"']");
		        }
		        //Title name
		        public static By objTitleName=By.xpath("//*[@id='title_name']");
		        
		        //FollowersTab After clicking on profile icon
		        public static By objFollowersTabInTitleName=By.xpath("//*[@class='android.widget.TextView' and ./parent::*[contains(@contentDescription,'Followers')]]");
		        
		      //FollowingTab After clicking on profile icon
		        public static By objFollowingTabInTitleName=By.xpath("//*[@class='android.widget.TextView' and ./parent::*[contains(@contentDescription,'Following')]]");
		        
		        //PlayIcon with count
		        public static By objPlayIconWithCount=By.xpath("//*[@id='VideoResultRecyclerView']/*/*[@id='ivView' and 'viewCount']");
		        
		        
		        //hand icon on video
		        public static By ObjHandIconOnVideo=By.xpath("//*[@resource-id='com.zee5.hipi:id/ivLike']");
		        

   public static By objListOFContact=By.xpath("//*[@id='contactsRecyclerview']/*[./*[@id='iconView']]");
		        
		        //All Friends
		        public static By objAllFriends=By.xpath("//*[@resource-id='com.zee5.hipi:id/allFriendsTxt']");
		     // following icon
		        public static By objFollowingIcon=By.xpath("//*[@id='imgFollowing']");//
		        //discover page search Textfield
		        public static By objSearchTextField=By.xpath("//*[@id='search']");
		        public static By objFollowUnfollow=By.xpath("//*[@id='tvFollow']");
		        
		        //suhail
		        
		        public static By objsoundspageasSearchresultpageIterating(int traytitle) {
					return By.xpath("(//*[@id='SoundResultRecyclerView']/*/*[@id='musicName'])["+traytitle+"]");
				}
		        public static By objThreeLinesDetailsInSoundTabIterator(int text)
		        {
		        	return By.xpath("(//*[@id='SoundResultRecyclerView']/*/*[@id='useSound'])[" + text +"]");
		        }
		    	//BollywoodZone Profile name
				public static By objBollywoodPageProfileName=By.xpath("//*[@id='txtUserName']");
				//Discover Searched Inbox
				public static By objDiscoverSearchedInbox = By.xpath("(//*[@resource-id='com.zee5.hipi:id/editTextSearch'])[1]");
				//following list user name
				public static By objFollowingListUserName =By.xpath("(//*[@id='recyclerView']/*/*[@id='music_name'])[1]");
		        public static By objFirstSuggestedUser=By.xpath("(//*[@id='UserRecyclerView']/*/*[@id='musicName' and (./preceding-sibling::* | ./following-sibling::*)[@id='userName']])[1]");

		        //Description Banner details Page
		        public static By obDescriptionBannerDetailsPage=By.xpath("//*[@resource-id='com.zee5.hipi:id/hashtagDesc']");

		        //Search Result In Followers Tab
		        public static By obSearchResultInFollowersTab=By.xpath("(//*[@resource-id='com.zee5.hipi:id/music_name'])[1]");

		      //add to favourite button
				public static By objAddToFavouriteOfSoundTab=By.xpath("//*[@resource-id='com.zee5.hipi:id/soundAddFav']");
				 //SOunds tab
				public static By objSoundsTab=By.xpath("//*[@class='android.widget.TextView' and contains(text(),'Sounds')]");
				
				//First Song Sound Tab
				public static By objFirstSongSoundTab=By.xpath("(//*[@resource-id='com.zee5.hipi:id/musicName'])[1]");

				 public static By objHashtagsButton=By.xpath("//*[@class='android.widget.TextView' and contains(text(),'Hashtags')]");

					public static By objAddToFavoriteText=By.xpath("//*[@text='Add to Favourites']");

					
					public static By objHashhtagged=By.xpath("//*[@id='hashtagName']");

				
					
					public static By objHashhtagsIteratable(int traytitle) {
						return By.xpath("(//*[@resource-id='com.zee5.hipi:id/txtGenreName'])[" + traytitle +"]");
					}		
					 public static By objCommentBox=By.xpath("//*[@id='comment_box']");
				        public static By objCommentOneMinuteAgo=By.xpath("//*[contains(@text,'1 minute ago')]");
				        public static By objCommentTitle=By.xpath("//*[@id='commentsCount']");
				        public static By objArrowFirstProfile=By.xpath("(//*[@id='UserRecyclerView']/*/*[@id='userHandle' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[1]");

				    	public static By objUserHandle=By.xpath("//*[@resource-id='com.zee5.hipi:id/userHandle']");     
				        
						
						
						public static By objHashtagVideoMoreBtn=By.xpath("//*[contains(text(),'#')]/..//following::*[@resource-id='com.zee5.hipi:id/btnMore']");
						
			
						
						public static By objCommentLikeCount=By.xpath("(//*[@resource-id='com.zee5.hipi:id/commentLikeCount'])[1] | ");
						
						public static By objCommentLike=By.xpath("//*[@resource-id='com.zee5.hipi:id/commentLike']");
						
						public static By objVideoThumbnail=By.xpath("//*[@resource-id='com.zee5.hipi:id/thumbnail'] | //*[@resource-id='com.zee5.hipi:id/videoImg']");     
				        
						 public static By objCommentTime=By.xpath("//*[contains(@text,'ago')]");
					        public static By objNavigationBar=By.xpath("//*[@id='exo_progress']");
					        public static By objVideoScreenSoundAdded=By.xpath("//*[@id='text_view_music_title']");


					        public static By objViewsOfHashTag=By.xpath("//*[@id='txtPlayCount']");
					    	public static By objHashTagvideo=By.xpath("(//*[contains(@resource-id,'thumbnail')])[1]");
					    	public static By objHashTagvideoIcon=By.xpath("(//*[@id='imgPlayCount'])[1]");
					    	public static By objHashTagShareScreenrail=By.xpath("//*[@class='com.android.internal.widget.RecyclerView']");


					    	public static By objRailProfileName=By.xpath("(//*[@id='userHandle'])[1]");

					    	
					    	 public static By objKeyboardSearchButton=By.xpath("//*[@resource-id='com.google.android.inputmethod.latin:id/key_pos_ime_action']//child::*[contains(@id,'obfuscated')]");
						        
						        public static By objErrorTitle=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvErrorTitle']");
						        
						        public static By objErrorSubTitle=By.xpath("//*[@resource-id='com.zee5.hipi:id/tvErrorSubtitle']");
						     
						        
						        
						        public static By objOfficialTag=By.xpath("//*[@text='Official'");
						        
						        public static By objMostPopoular=By.xpath("//*[@text='Most Popular']");
						      
						        public static By objHashtagDetailMostPopular=By.xpath("(//*[@id='txtPopular'and @text='Most Popular'])[1]");
						        public static By objUserHandles(int number)
						        {
						        	return By.xpath("(//*[@resource-id='com.zee5.hipi:id/userHandle'])["+number+"]");
						        }

						        public static By objBollywoodZone=By.xpath("//*[@text='Bollywood Zone']");

						        
						        
						        public static By objListOfSearchResult=By.xpath("//*[@resource-id='com.zee5.hipi:id/searchTitle']");
						        public static By objsearchResults(int index) {
						        	return By.xpath("(//*[@resource-id='com.zee5.hipi:id/searchTitle'])[" + index + "]");

						        }
						        public static By objListOfSearchUserProfiles=By.xpath("//*[@resource-id='com.zee5.hipi:id/musicName']");

						        public static By objListFirstuserProfile(int index) {
						        	return By.xpath("(//*[@resource-id='com.zee5.hipi:id/musicName'])[" + index + "]");

						        }
						        public static By objListOfHashhtags(int index) {
						        	return By.xpath("(//*[@resource-id='com.zee5.hipi:id/txtGenreName'])[" + index + "]");

						        }
						        public static By objVideosInVideosTab=By.xpath("//*[@resource-id='com.zee5.hipi:id/user_handle']");
						        public static By objListOfVideos(int index) {
						        	return By.xpath("(//*[@resource-id='com.zee5.hipi:id/user_handle'])[" + index + "]");

						        }
						        public static By objFirstSongInSoundTab=By.xpath("//*[@resource-id='com.zee5.hipi:id/musicName']");
						        public static By objListofFirstSongInSoundTab(int index) {
						        	return By.xpath("(//*[@resource-id='com.zee5.hipi:id/musicName'])[" + index + "]");
						        }
						        public static By objFirstHashtagsInSoundTab=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtGenreName']");
						        public static By objListofFirstHashtagsInSoundTab(int index) {
						        	return By.xpath("(//*[@resource-id='com.zee5.hipi:id/txtGenreName'])[" + index + "]");
						        }
								public static By objAnyHipiVideo(int index) {
									return By.xpath("(//*[@resource-id='com.zee5.hipi:id/thumbnail'])[" + index + "]");
								}

						        public static By objContestTag=By.xpath("//*[contains(@text,'Contest')]");
						        
						        public static By objTrendingTag=By.xpath("//*[contains(@text,'Trending')]");
						      
						        public static By objChallengeTag=By.xpath("//*[contains(@text,'Challenge')]");
						        
						        
						        public static By objViewCount=By.xpath("(//*[@resource-id='com.zee5.hipi:id/viewCount'])[1]");
								public static By objLikeCount=By.xpath("(//*[@resource-id='com.zee5.hipi:id/likeCount'])[1]");

								
								
								//Playlist
								
								public static By objPlaylistsTab = By.xpath("//*[@text='Playlists']");
								
								public static By objPlaylistsOption = By.xpath("//*[@resource-id='com.zee5.hipi:id/title' and @text='Playlists']");
								
								public static By objPlaylistsSeeMoreBtn  =By.xpath("//*[@resource-id='com.zee5.hipi:id/title' and @text='Playlists']/following-sibling::*");
								
								public static By objFirstPlaylistTopTab = By.xpath("((//*[@resource-id='com.zee5.hipi:id/title' and @text='Playlists']/parent::*)/following-sibling::*)/descendant::*");
								
								public static By objPlaylistsSelected = By.xpath("//*[@text='Playlists' and @selected='true']");
								
								public static By objFirstPlaylistPlaylistsTab = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvTittle']");
								
								public static By objPlaylistPage = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvPlaylist']");
								
								//Shop tab search results
								public static By objShopTab = By.xpath("//*[@text='Shop']");
								
								public static By objShopOption = By.xpath("//*[@resource-id='com.zee5.hipi:id/title' and @text='Shop']");
								
								public static By objShopSeeMoreBtn = By.xpath("//*[@resource-id='com.zee5.hipi:id/title' and @text='Shop']/following-sibling::*");
								
								public static By objShopSelected = By.xpath("//*[@text='Shop' and @selected='true']");
								
								public static By objFirstShopProduct = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgThumbnail']");
								
								public static By objShopDetailsPage = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvAddToCart']");
								
								public static By objBuyCTAShopTab = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvBuyNow']");
								
								
								
								        
}
