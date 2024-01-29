package com.zee5.Applicaster.HIPI;

import org.openqa.selenium.By;


public class AMDHipi {
		
	public static By objZee5Logo=By.xpath("//*[@text='ZEE5']");
//	public static By objZee5Logo=By.xpath("//*[@resource-id='com.graymatrix.did:id/logo']");
	
//	public static By objHipiIcon=By.xpath("//android.widget.TextView[contains(@resource-id,'/bb_bottom_bar_title') and @text='HiPi']");
	public static By objHipiIcon=By.xpath("//*[@text='HiPi']");
	
	//FeedIcon
	public static By objFeedIcon=By.xpath("//*[contains(@resource-id,'feedtext')]");
	//DiscoverText
	public static By objDiscovertext=By.id("com.zee5.hipi:id/discoverimage");
	//create video
	public static By objcreatevideo=By.xpath("//*[@id='createvideoimage']");
	//populartext
	public static By objpopulartext=By.xpath("//*[contains(@resource-id,'challengestext')]");
	//back btn
	//public static By objbackbtn=By.xpath("//*[@id='back']");
	//metext
	public static By objmeicon=By.xpath("//*[contains(@resource-id,'metext')]");

	public static By objPublishingInProcess = By.xpath("//*[@text='Publishing in process']");
	//following
	public static By objFollowing=By.xpath("//*[contains(@resource-id,'following')]");
	//foryou
	public static By objForYou=By.xpath("//*[contains(@resource-id,'forYou')]");
	//Registerforvibe
	public static By objRegisterforVibe=By.xpath("//*[contains(@resource-id,'title_registerforVibe')]");
	//Loginbtn
	public static By objLoginbtn=By.xpath("//*[contains(@resource-id,'btnHiPiLogin')]");
	//Registerbtn
	public static By objRegisterbtn=By.xpath("//*[contains(@resource-id,'btnHiPiRegister')]");
	//LoginTitle
	public static By objLogintitle=By.xpath("//*[contains(@resource-id,'screen_title')]");
	//skiptitle
	public static By objskiptitle=By.xpath("//*[contains(@resource-id,'skip_link')]");
	//Emailidtitle
	public static By objEmailidtitle=By.xpath("//*[contains(@resource-id,'txtHeader')]");
	//emailidfield
	public static By objemailfield=By.xpath("//*[contains(@resource-id,'edit_email')]");
	//GoogleIcon
	public static By objGoogleIcon=By.xpath("//*[contains(@resource-id,'btnGoogle')]");
	//facebookIcon
	public static By objFacebookIcon=By.xpath("//*[contains(@resource-id,'btnFacebook')]");
	//TwitterIcon
	public static By objTwitterIcon=By.xpath("//*[contains(@resource-id,'btnTwitter')]");
	//carousel title
	public static By objcarouseltitle=By.xpath("(//*[@resource-id='com.zee5.hipi:id/image'])[1]");
	//public static By objCarouselTitleByIndx(int index) {
		//return By.xpath("//*[@resource-id='com.graymatrix.did:id/image'])[" + index + "]");
	
	//traytitle
	//*[@resource-id='com.graymatrix.did:id/title'])[1]
	public static By objTrayTitle=By.xpath("//*[@text='Top HiPi Stars']");
	//public static By objTrayTitleByIndx(int index) {
		//return By.xpath("//*[@resource-id='com.graymatrix.did:id/title'])[" + index + "]");
	
	//traytitletext
	//*[@resource-id='com.graymatrix.did:id/text_view']
	public static By objtraytitletext=By.xpath("(//*[@resource-id='com.zee5.hipi:id/text_view'])[3]");
	//public static By objTrayTitletextByIndx(int index) {
		//return By.xpath("//*[@resource-id='com.graymatrix.did:id/text_view'])[" + index + "]");
	
	//hipi
	public static By objBottomNavigation(String tabName) {
			return By.xpath("//*[@id='bb_bottom_bar_title' and @text='" +tabName+ "']");
		}
	//agreeterms
	public static By objAgreetermspopup=By.xpath("//*[contains(@resource-id,'textView3')]");
 public static By objcheckbox=By.xpath("//*[contains(@resource-id,'checkBox')]");
 public static By objsave=By.xpath("//*[contains(@resource-id,'btnNext')]");
 public static By objproceedbtn=By.xpath("//*[contains(@resource-id,'btnProceed')]");
 //passwordfield
//*[@resource-id='com.graymatrix.did:id/txtET_password_input']
 public static By objpasstext=By.xpath("//*[contains(@resource-id,'txtET_password_input')]");
 //login
 public static By objloginbtn=By.xpath("//*[contains(@resource-id,'btnLogin')]");
 //errorpwsd
 public static By objforgotpass=By.xpath("//*[contains(@resource-id,'tv_forgotPassword')]");
 //popular title
 public static By objpopulartitle=By.xpath("//*[contains(@resource-id,'txtUserHandle')]");
	
//profilecard
//public static By objprofiletext=By.xpath("(//*[@resource-id='com.graymatrix.did:id/txtName'])["+index"]");
 public static By objprofiletext(String text) {
		return By.xpath("//*[@id='txtName' and @text='Abhishek']");
	}

//network error
public static By objnetworkerror = By.xpath("//*[contains(@resource-id,'errorTextView')]");
//retry
public static By objretry=By.xpath("//*[contains(@resource-id,'btn_retry')]");
public static By objpause=By.xpath("//*[contains(@resource-id,'playImageView')]");
//back btn
public static By objbackbtn=By.xpath("//*[contains(@resource-id,'imgBack')]");
//*[@resource-id='com.graymatrix.did:id/backView']
//back btn in feed
public static By objbackbutton=By.xpath("//*[@id='backView']");
//following back
public static By objbackfollowingbtn=By.xpath("//*[contains(@resource-id,'back')]");
//following in me icon
public static By objfollowing=By.xpath("//*[contains(@resource-id,'txtFollowing')]");
//back in following
public static By objpopularbackbtn=By.xpath("//*[contains(@resource-id,'back')]");
//feediconback
//public static By objfeedbackbtn=By.xpath("//*[@resource-id='com.graymatrix.did:id/backView']");
//*[@resource-id='com.graymatrix.did:id/imgBack']
//following in me
public static By objfollowingtext=By.xpath("//*[@resource-id='com.zee5.hipi:id/music_name' and @text='Abhishek Kapur']");
//discoversearch
public static By objdiscoversearchtext=By.xpath("//*[@class='android.widget.ImageView'and @index='0']");
//searchtext
public static By objsearchtext=By.id("com.zee5.hipi:id/editTextSearch");
//framelayout
public static By objframelayout=By.xpath("(//*[@id='thumbnail'])[1]");
//effect used
public static By objeffectused=By.xpath("//*[@class='android.widget.TextView' and @text='Effect Used -Cool Glasses']");
//effectname
public static By objeffectname=By.xpath("//*[@id='displayName']");

public static By objeffectname1(String effectName){
	return By.xpath("//*[@resource-id='com.zee5.hipi:id/displayName' and @text='"+effectName+"']");
}
//videoscreatedcount
public static By objvideocount=By.id("com.zee5.hipi:id/playCount");
//videoscreatedusingeffect
public static By objvideoscreated=By.xpath("//*[@class='android.widget.TextView' and @text='Videos Created Using Effect']");
//effectthumbnail
public static By objthumbnail=By.id("com.zee5.hipi:id/effectImage");
//effectthumbnailname
public static By objeffectthumbnailname=By.xpath("//*[@class='android.widget.RelativeLayout' and @index='0']");
//effectthumbnailone
public static By objeffectthumbnsilone=By.xpath("//*[@class='android.widget.TextView' and  @text='Getting know all the effects and filters!! 😃 #hipi #fun #breaktime #inbetween #Shoot']");

public static By objeffectthumbnsilone1=By.xpath("(//*[@resource-id='com.zee5.hipi:id/thumbnail'])[1]");


//effectusedinone
public static By objeffectusedone=By.id("com.zee5.hipi:id/usedEffect");

public static By objeffectusedone1(String effectName){
	return By.xpath("//*[@resource-id='com.zee5.hipi:id/usedEffect' and @text='Effect Used -"+effectName+"']");
}

public static By objSoundUsed(String soundUsed){
	return By.xpath("//*[@id='songNameMTextView' and @text='"+soundUsed+"']");
}

public static By objeffectLayer = By.xpath("//*[contains(@resource-id,'effectLayer')]");

//eefectthumbnailtwo
public static By objeffectthumbnailtwo=By.xpath("//*[@class='android.widget.TextView' and @text='#Foryou #support #manshi khati#trendling']");
//usethis effect
public static By objuseeffect=By.id("com.zee5.hipi:id/fab_text");
//registerpopup
public static By objRegisterPop=By.id("com.zee5.hipi:id/title_registerforVibe");
//thumbnaileffect
public static By objthumbnails=By.id("com.zee5.hipi:id/thumbnail");

public static By objSoundUsed=By.xpath("//*[@id='songNameMTextView']");



public static By objEmailIDTextField  = By.xpath("//*[@id='edit_email']");
	
public static By objProceedBtn  = By.xpath("//*[@id='btnProceed']");

public static By objFirstNameTxtField = By.xpath("//*[@id='first_name_input']");

public static By objLastNameTxtField = By.xpath("//*[@id='last_name_input']");

public static By objDOBTxtField = By.xpath("//*[@id='dobTextView'] | //*[@id='dobEditText']");

public static By objGederTxtField = By.xpath("//*[@id='genderTextView']");

public static By objMale = By.xpath("//*[@text='Male']");

public static By objPasswordTxtField = By.xpath("//*[@id='password_input']");

public static By objRegisterBtn = By.xpath("//*[@id='registerProgress']");

public static By objTermsConditionPopup = By.xpath("//*[@text='Agree to Terms & Conditions']");

public static By objTermsConditionPopupSaveBtn = By.xpath("//*[@id='btnNext' and @text='Save']");

	}
	

