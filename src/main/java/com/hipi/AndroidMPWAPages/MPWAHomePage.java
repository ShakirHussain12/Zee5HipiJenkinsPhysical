package com.hipi.AndroidMPWAPages;

import org.openqa.selenium.By;

public class MPWAHomePage {

	public static By objDiscoverButton = By.xpath("(//*[@class='flex flex-col text-white text-xs items-center'])[2]");

	public static By objProfileIcon = By.xpath("//*[@class='flex flex-col  items-center justify-between']");

	public static By objForYou = By.xpath("//*[@nodeName='H2' and @css='H2.font-bold'] | //*[@text='For You'] | //*[@text='Unmute']");

	public static By objHomeIcon = By.xpath("(//*[@class='flex flex-col text-white text-xs items-center'])[1]");

	public static By objLikeIcon = By.xpath("(//*[@id='like'])[1]");

	public static By objUserNameInFeedScreen = By.xpath("//*[@class=' mb-1 mt-1.5 font-semibold text-sm flex ']");

	public static By objSwipeUpForNextVideo = By.xpath("//*[@class='flex py-2 px-4 bg-gray text-white font-medium mt-12']");

	public static By objCommentButton = By.xpath("(//*[@id='comment'])[2] | //*[@class='android.widget.Image'][@index='3']");

	public static By objOpenApp = By.xpath("//*[@class='flex justify-center items-center text-sm md:text-base w-full font-semibold']");

	public static By objCreatorButton = By.xpath("//*[@class='relative py-3  px-1 text-center flex flex-col text-white text-xs  items-center']");

	public static By objOpenButton = By.xpath("(//*[@text='Open'])[2]| //*[@class='font-semibold text-sm border border-hipired rounded py-1 px-2 mr-1 bg-hipired text-white'] | //*[@text='Open']");

	public static By objInstallButton = By.xpath("//*[@contentDescription='Install']");

	public static By objProgressBar=By.xpath("//*[@class='absolute top-0 left-0 h-1 bg-gray-100 ']");

	public static By objProgressBarID=By.xpath("//*[@css='SPAN.absolute.top-0.left-0.h-1.bg-gray-100']");

	public static By objCancelButton=By.xpath("//*[@resource-id='com.daemon.shelper:id/CANCEL']");

	public static By objContinueAsHipi = By.xpath("//*[contains(@text,'Continue')]");
	
	public static By objSignInHeader = By.xpath("//*[contains(@text,'Sign in to hipi.co.in with Google')]");
	
	public static By objLoggedInAccount = By.xpath("//*[contains(@text,'.com')]");
	
	public static By objYesIn = By.xpath("//*[@resource-id='com.android.chrome:id/button_primary' and contains(@text,'Yes')]");
}




