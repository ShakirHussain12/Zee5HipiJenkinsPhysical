package com.hipi.AndroidMPWAPages;

import org.openqa.selenium.By;

public class MPWADiscoverPage {

	
	public static By objSearchTab = By.xpath("//*[contains(@name,'Sear')]");

    public static By objListOfSearchResult=By.xpath("//*[@class='pl-2']");

    
    public static By objsearchResults(int index) {
    	return By.xpath("(//*[@class='pl-2'])[" + index + "]");

    }
//   (//*[@resource-id='com.zee5.hipi:id/searchTitle'])[1] | //*[@class='bne$a' and @index='42'] | //*[@id='0_resource_name_obfuscated' and @class='android.widget.ImageView' and ./parent::*[./parent::*[@id='key_pos_ime_action']] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.ImageView']] | (//*[@id='keyboardView']/*[@class='cca'])[43] | (//*[@class='bne$a'])[43]
	public static By objSearchResult = By.xpath("(//*[@id='keyboardView']/*[@class='bne$a'])[43]");

    public static By objListOfSearchUserProfiles=By.xpath("//*[@class='font-bold text-sm text-gray-700']");

    public static By objListFirstuserProfile(int index) {
    	return By.xpath("(//*[@class='font-bold text-sm text-gray-700'])[" + index + "]");

    }
	public static By objFirstProfileName= By.xpath("(//*[@class='text-xs pt-2 truncate max-w-20v  text-center'])[1]");

	public static By objBannersBelowTheSearchField = By.xpath("//*[@class='explore_carousel flex min-w-full overflow-x-auto h-56v no_bar mt-16 overflow-y-hidden'] | //*[@class='android.view.View' and ./*[@id='0']] | ((//*[@id='__next']/*[@class='android.view.View'])[1]/*/*[@class='android.view.View' and ./*[@class='android.widget.TextView']])[1] | //*[@css='DIV.swiper-slide.swiper-slide-active']");	

	public static By objBannerHeader = By.xpath("(//*[@id='__next']/*[@class='android.widget.TextView'])[1] | //*[@class='text-sm font-semibold'] | //*[@class='font-bold '] | //*[@nodeName='H1']");	

	public static By objBollywoodZoneAfterTappingArrow=By.xpath("(//*[@class='flex items-center justify-center'])[1]");

	public static By objMoreButtonTrendingOnHipi = By.xpath("(//*[@class='flex items-center justify-center'])[2]");											

	public static By objTopButton = By.xpath("//*[@class='text-black ']");

	 public static By objListOfHashhtags(int index) {
     	return By.xpath("(//*[@class='mx-3'])[" + index + "]");

     }
	 //(//*[@class='trending_card bg-gray-300 m-1 w-28v min-h-38 relative'])[" + index + "]
	 public static By objListOfVideos(int index) {
     	return By.xpath("(//*[@alt='hipi'])[" + index + "]");

     }
		public static By objUsersButton = By.xpath("(//*[@class=''])[1]");

		public static By objVideosButton = By.xpath("(//*[@class=''])[2]");

		public static By objHashhtagsButton = By.xpath("(//*[@class=''])[3]");
		 public static By objListUserProfile(int index) {
		    	return By.xpath("(//*[@class='font-medium text-sm text-gray-700'])[" + index + "]");

		    }
		 public static By objListOfVideosInVideoStab(int index) {
		     	return By.xpath("(//*[@class='video-card relative z-0'])[" + index + "]");

		     }
		 public static By objListofFirstHashtags(int index) {
	        	return By.xpath("(//*[@class='ml-4'])[" + index + "]");
	        }
		 
}
