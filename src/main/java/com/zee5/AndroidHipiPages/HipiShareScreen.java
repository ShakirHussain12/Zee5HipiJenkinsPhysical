package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiShareScreen {

	public static By objFBOption= By.xpath("//*[@text='News Feed']");


	public static By objFacebookPage = By.xpath("//*[@class='android.view.ViewGroup' and ./*[@class='android.view.ViewGroup']]");

	
	public static By objEmailTextfield = By.xpath("//*[@text='Phone or email']");//*[@contentDescription='Username']

	public static By objPassWordfield = By.xpath("//*[@contentDescription='Password']");//*[@contentDescription='Password']

	public static By objFBLoginButton = By.xpath("//*[@contentDescription='Log In']");
	
	public static By objSaveButton = By.xpath("//*[contains(@resource-id,'autofill_save_yes')]");
	
	public static By objSMS = By.xpath("//*[@text='Messages']");
	
	
	public static By objSelectContact = By.xpath("//*[contains(@resource-id,'details_container')]");

	public static By objSendButton = By.xpath("//*[contains(@resource-id,'send_message_button_icon')]");

	public static By objClickOnSmslink = By.xpath("//*[@id='message_text' and ./parent::*[./parent::*[@contentDescription='You said, https://www.zee5.com/hipi/effect/563eed60-f2db-43e0-96b7-47c58ff628de, 12 minutes, SMS']]]");
	
	public static By objNewMessage = By.xpath("//*[contains(@resource-id,'button1')]");
	
	
	public static By objnumberIcon = By.xpath("//*[contains(@resource-id,'action_ime_dialpad_toggle')]");

	public static By objLogintoAnotherAccount = By.xpath("//*[@text='Log Into Another Account']");

	public static By objtypeNumber = By.xpath("//*[contains(@resource-id,'recipient_text_view')]");
	
	
	public static By objclickonTICK = By.xpath("//*[@class='android.widget.FrameLayout' and ./parent::*[@id='key_pos_ime_action'] and ./*[@id='0_resource_name_obfuscated' and @class='android.widget.ImageView']]");
	
	public static By objchecksendlink = By.xpath("//*[contains(@resource-id,'thumbnail_image_container')]");

	public static By objIncorrectPassword = By.xpath("//*[@text='Incorrect Password']");
	
	public static By objFBPostbutton = By.xpath("//*[@contentDescription='POST']");

	public static By objTweetIcon = By.xpath("(//*[@class='com.android.internal.widget.RecyclerView']/*/*[@id='resolver_item_icon'])[2]");

	public static By objInstagramIcon = By.xpath("//*[@text='Direct']");
	
	public static By objInstagramSignUpButtin = By.xpath("//*[contains(@resource-id,'right_button')]");

	public static By objInstagramLoginButtin = By.xpath("//*[contains(@resource-id,'log_in_button')]");

	public static By objInstagramUserName = By.xpath("//*[contains(@resource-id,'login_username')]");
	
	public static By objInstagramPassword = By.xpath("//*[contains(@resource-id,'password')]");

	public static By objInstagramClickonLogin = By.xpath("//*[contains(@resource-id,'button_text')]");

	public static By objNoneOfTheAboveButton = By.xpath("//*[contains(@resource-id,'cancel')]");
	
	
	public static By objIncorrectPasswordInstagram = By.xpath("//*[@id='content']");//*[@id='panorama_dialog_headline']
	
	public static By objCancleButton = By.xpath("//*[contains(@resource-id,'button2')]");
	
	public static By objTryanotherWayButton = By.xpath("//*[@class='android.widget.Button']");

	public static By objShareDeailsScreen = By.xpath("//*[@text='HiPi Video']");
	
	public static By objSoundShareDeailsScreen = By.xpath("//*[@text='HiPi Sound']");

	public static By objSugarBox = By.xpath("//*[contains(@resource-id,'connectToSbLayout')]");
	
	public static By objStartChatButton = By.xpath("//*[contains(@resource-id,'start_new_conversation_button')]");

	public static By objContinueButton = By.xpath("//*[@contentDescription='Continue']");

	//Back Navigation 
	public static By objBackNavigation  = By.xpath("//*[@content-desc='Navigate up']");
	
	//Not sent. Tap to try again
	public static By objNotSentTapToTryAgain  = By.xpath("//*[contains(@resource-id,'conversation_timestamp')]");

	//click  on link sound details
	public static By objLinkSoundDetailsPage  = By.xpath("(//*[@id='list']/*/*/*/*[@id='message_text'])[2]");

	//-============================New=============================
	//Add to Favourites
	public static By objAddToFavourites = By.xpath("//*[@resource-id='com.zee5.hipi:id/addFavTitle']");
	//Save Video
	public static By objSaveVideo = By.xpath("//*[@resource-id='com.zee5.hipi:id/saveVideoTitle']");
	//Report
	public static By objReport = By.xpath("//*[@resource-id='com.zee5.hipi:id/reportVideoTitle']");
	//Not Interested
	public static By objNotInterested = By.xpath("//*[@resource-id='com.zee5.hipi:id/intrstVideoTitle']");
	//Duet
	public static By objDuet = By.xpath("//*[@resource-id='com.zee5.hipi:id/addFavTitle']//preceding-sibling::*[@resource-id='com.zee5.hipi:id/duetVideo']");
	
	
	//Account logo
	public static By objAccountLogo = By.xpath("//*[@resource-id='com.google.android.gm:id/og_apd_ring_view']");
	//Another Gmail account
	public static By objIgs2Mail = By.xpath("//*[@text='igst2507@gmail.com']");
	//First mail
	public static By objFirstMail = By.xpath("(//*[@resource-id='com.google.android.gm:id/senders'])[1]");
	//I Enjoyed Watching On Hipi
	public static By objIEnjoyedWatchingOnHipi = By.xpath("//*[@text='Check out the effect Heart Crown I liked on Hipi '] | //*[@text='Check out this video I enjoyed watching on Hipi '] | //*[@text='Check out this sound I liked on Hipi ']");
	//Link Inbox
	public static By objLinkInbox = By.xpath("//*[contains(@text,'https://')]");
	//Hipi Logo
	public static By objHipiLogo= By.xpath("//*[@text='Hipi'] | //*[@resource-id='android:id/button_once']");
	
	//Chrome Option
	public static By objChromeOption= By.xpath("//*[@text='Chrome']");

	
	//Gmail Option
	public static By objGmailOption= By.xpath("//*[@text='Gmail']");
	//After More Button
	public static By objAfterMoreButton= By.xpath("//*[@resource-id='vivo:id/resolver_slide'] | //*[@resource-id='android:id/sem_chooser_recycler_ranked_app'] | //*[@class='com.android.internal.widget.RecyclerView']");

	//list of share options
	public static By objListOfShareOptions= By.xpath("//*[@resource-id='com.zee5.hipi:id/rvApps']");
	//More Button
	public static By objMoreButton= By.xpath("//*[@text='More']");
	
	//Video sharing screen									
	public static By objVideoGmailSharingScreen= By.xpath("//*[@resource-id='com.google.android.gm:id/attachment_tile_icon']");
	//Share Link Gmail page
	public static By objShareLinkGmailpage = By.xpath("//*[@class='android.webkit.WebView']//child::*//*[@class='android.widget.EditText']");
	
	// To Field
	public static By objToField = By.xpath("//*[@resource-id='com.google.android.gm:id/peoplekit_autocomplete_chip_group']//child::* | //*[@resource-id='com.google.android.gm:id/to']");
	
	//Send Button Gmail Share Screen
	public static By objSendButtonGmailShareScreen = By.xpath("//*[@resource-id='com.google.android.gm:id/send']");

	
	
	//Browser Option 
	public static By objBrowserOption  = By.xpath("//*[@text='Chrome']");

	//Open Option in chrome
	public static By objOpenOptioninChrome  = By.xpath("//*[@css='DIV.font-semibold.text-sm.border.border-hipired.rounded-md.py-1.px-2.mr-1.bg-hipired.text-white']");

	public static By objMessagesOption  = By.xpath("//*[@text='Messages']");
	
	//Delete Option Gmail
	public static By objDeleteOptionGmail  = By.xpath("//*[@resource-id='com.google.android.gm:id/delete']");

	//Sound Name Chrome Browser
	public static By objSoundNameChromeBrowser  = By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div[5]/div[2]/div[1]/div/div[2]/div/div[2]/span/p");
	//*[@class='
//    m-0 m-auto 
//    whitespace-nowrap
//    overflow-hidden
//  ']					
	//*[@id="__next"]/div[1]/div[1]/div[5]/div[2]/div[1]/div/div[2]/div/div[2]/span/p/span
	//*[contains(@css,'P.m-0.m-auto')])[1]
	//*[@css='P.text-sm']
	//*[@id="__next"]/div[1]/div[1]/div[5]/div[2]/div[1]/div/div[2]/div/div[2]/span/p
	//html/body/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div/div[2]/div/div[2]/span/p
	//document.querySelector("#__next > div:nth-child(1) > div.feed_screen.overflow-hidden.relative > div.swiper-container.swiper-container-initialized.swiper-container-vertical.swiper-container-pointer-events.max-h-full > div.swiper-wrapper > div.swiper-slide.swiper-slide-active > div > div.bottom-28.videoFooter.absolute.left-0.flex.text-white.ml-2 > div > div.w-8\\/12.my-1.text-sm > span > p")
	public static By objGmailDescriptionField= By.xpath("//*[@text and @class='android.widget.EditText' and ./parent::*[@class='android.webkit.WebView']]");
	public static By objCheckOutMyProfile(String text)
	{
		return By.xpath("//*[@text='"+text+"']");
	}
	public static By objVerifyUrl= By.xpath("(//*[contains(@text,'https://')])[1]");
	public static By objWhatsAppLink= By.xpath("(//*[contains(@text,'https://')])[2]");

	public static By objVerifyCheckOutVideo= By.xpath("//*[contains(@text,'Check out this video I enjoyed')]"); 
	public static By objCheckOutMyProfile= By.xpath("//*[contains(@text,'Check out ')]");
	//Whatsapp Option
	public static By objWhatsappOption= By.xpath("//*[@text='WhatsApp']");
	public static By objWhatsappSearchIcon= By.xpath("//*[@id='menuitem_search']");
	public static By objWhatsappSearchTextField= By.xpath("//*[@id='search_src_text']");
	public static By objWhatsappRecentUser= By.xpath("(//*[@id='list']/*/*/*/*/*[@id='contactpicker_row_name'])[1]");
	public static By objWhatsappSendArrow= By.xpath("//*[@id='send']");
	public static By objWhatsappUser= By.xpath("//*[@text='Igs']");
	
	
	//Message Text Box
	public static By objMessageTextBox= By.xpath("//*[@resource-id='com.android.mms:id/embedded_text_editor']");
	
	public static By objSharescreenMoreRail= By.xpath("//*[@class='com.android.internal.widget.RecyclerView']");

	public static By objListOfShareRail= By.xpath("//*[@id='oplus_resolver_pager'] | //*[@resource-id='android:id/text1'] | //*[@resource-id='oppo:id/oppo_pager']");
	public static By objHipiPassTheMic= By.xpath("//*[contains(@text,'#HipiPassTheMic')]");
}
