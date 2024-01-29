package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiPopularPage {

	
	public static By objpopulartext=By.xpath("//*[contains(@resource-id,'challengestext')]");
	//popular title
	public static By objpopulartitle=By.xpath("//*[contains(@resource-id,'txtUserHandle')]");
	//profiletext
//	public static By objprofiletext=By.xpath("//*[@resource-id='com.graymatrix.did:id/txtName' and @text='Abhishek']");
	public static By objprofiletext=By.xpath("//*[contains(@resource-id,'txtName')][1]");
	
	public static By objProfileDetailPageUserName = By.xpath("//*[contains(@resource-id,'txtUserName')]");
	
	//popularcelebrity profile
	public static By objprofilepic=By.xpath("//*[contains(@resource-id,'profile_pic')]");
	//tapping on profile pic
	public static By objthumbnailimage=By.xpath("//*[contains(@resource-id,'image')]");
	//follow celebrity
	public static By objProfilepagefollowButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtEditProfile' and @text='Follow']");
	
	public static By objProfilepageFollowingButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/txtFollowing' and @text='Following']");
	//back button in popular
	public static By objbackbutton=By.xpath("//*[contains(@resource-id,'imgBack')]");
	//followingbackbutton
	public static By objfollowingbackbutton=By.xpath("//*[contains(@resource-id,'back')]");
	
	//edithipiprofile
	//public static By objeditprofile=By.xpath("//*[@text='Edit HiPi Profile']");
	public static By objeditprofile=By.xpath("//*[@text='Edit Profile']");
	//Editprofiletitle
	public static By objedit=By.xpath("//*[contains(@resource-id,'my_edit_profile_text')]");
	
	//editprofilebackbutton
	public static By objeditbackbutton=By.xpath("//*[contains(@resource-id,'imgBack')]");

	//editprofile back
	public static By  objbackbtn=By.xpath("//*[contains(@resource-id,'imgBack')]");

	//feedbackbutton
	public static By objfeedbackbutton=By.xpath("//*[contains(@resource-id,'backView')]");

	//followers count
	public static By objfollowerscount=By.xpath("//*[@id='txtFollowValue']");

	//followingcount
	public static By objfollowingcount=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtFollowingValue']");

	//followers
	public static By objfollowers=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtFollow']");

	//followers title
	public static By objfollowerstitle=By.xpath("//*[@resource-id='com.zee5.hipi:id/offers_title']");

	//nodatafound
	public static By objNoResultsFoundInFollowing=By.xpath("//*[@resource-id='com.zee5.hipi:id/txt_no_data_found']");
	
	
	//followerslistusername
	public static By objfollowerslistusername=By.xpath("//*[@resource-id='com.zee5.hipi:id/music_name']");

	//followingback
	public static By objfollowerbackbutton=By.xpath("//*[@resource-id='com.zee5.hipi:id/back']");

	//following
	public static By objfollowing=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtFollowing']");


	//firstname
	public static By objfirstname=By.xpath("//*[contains(@resource-id,'firstNameInputLayout')]");
	//firstname text
	public static By objfirstnametxt=By.xpath("//*[contains(@resource-id,'firstNameEditText')]");

	//Editprofile
	public static By objeditprofile1=By.xpath("//*[contains(@resource-id,'txtEditProfile')]");

	//lastname
	public static By objlastname=By.xpath("//*[contains(@resource-id,'lastNameInputLayout')]");
	//lastnametxt
	public static By objlastnametxt=By.xpath("//*[contains(@resource-id,'lastNameInputLayout')]") ;
	//userhandle
	public static By objuserhandle=By.xpath("//*[contains(@resource-id,'userHandleInputLayout')]");
	//userhandletext
	public static By objuserhandletxt=By.xpath("//*[contains(@resource-id,'userHandleEditText')]");
	//dob
	public static By objdob=By.xpath("//*[contains(@resource-id,'dobInputLayout')]");
	//dobtext
	public static By objdobtext=By.xpath("//*[contains(@resource-id,'dobEditText')]");
	//userbio
	public static By objuserbio=By.xpath("//*[contains(@resource-id,'userBioEditText')]");

	//shareprofle
	public static By objshareprofile=By.xpath("//*[contains(@resource-id,'share')]");


	//cancel
	public static By objcancel=By.xpath("//*[contains(@resource-id,'button2')]");
	
	//edittextafter
	public static By objeditpenciltext=By.xpath("//*[contains(@resource-id,'imgPencil')]");
	
	//editpopup
	public static By objeditpopup=By.xpath("//*[contains(@resource-id,'msg_popup')]");

	//yesbutton
	public static By objyesbtn=By.xpath("//*[contains(@resource-id,'btn_yes')]");

	//msgpopup
	public static By objmsgpopup=By.xpath("//*[contains(@resource-id,'msg_popup')]");

	//done
	public static By objdone=By.xpath("//*[@text='Done']");
	
	
	//followinglistusername
	public static By objfollowinglistusername=By.xpath("//*[contains(@resource-id,'music_name')]");
	
	//editprofileheader
	public static By objeditprofileheader=By.xpath("//*[contains(@resource-id,'my_edit_profile_text')]");
	
	
	//edittext
	public static By objedittext=By.xpath("//*[contains(@resource-id,'imgEdit')]");
	
	
	public static By objUserHandle =By.xpath("//*[@id='text_user_handle']");
	
	public static By objSpecificUserHandle(String user) {
		return By.xpath("//*[@id='text_user_handle' and @text=+'"+user+"']");
	}
	
	
	public static By objstaricon=By.xpath("//*[contains(@resource-id,'user_badge')]");
	
	
	
	public static By objPopularLayout=By.xpath("//*[contains(@resource-id,'recycler')]");

	public static String objtextPopular="Popular";

	public static By objCreatorName=By.xpath("(//*[@id='txtName'])[1]");
	
	public static By objCreator2Name=By.xpath("(//*[@id='txtName'])[2]");
	
	public static By objCreatorUserName=By.xpath("//*[@id='txtUserName']");


	public static By objCreatorfollowers=By.xpath("(//*[@resource-id='com.zee5.hipi:id/txtFollowers'])[1]");
	
	public static By objCreatorthumbnailimage=By.xpath("(//*[@id='roundedImageView'])[1]");

	public static By objFollowingScreen=By.xpath("//*[contains(@resource-id,'offers_title')]");

	public static By objFollowingScreenTitle=By.xpath("//*[@resource-id='com.zee5.hipi:id/offers_title' and contains(@text,'Following')]");
	public static By objFollowScreenBackbutton=By.xpath("//*[contains(@resource-id,'back')]");
	public static By objvideoDes=By.xpath("(//*[@resource-id='com.zee5.hipi:id/desc'])[1]");
	
	public static By objCreatorvideo=By.xpath("(//*[@id='videoimg'])[1]");

	public static By objAddToFav=By.xpath("//*[contains(@resource-id,'add_to_fav_layout')]");
	public static By objAddMusicFav=By.xpath("//*[@resource-id='com.zee5.hipi:id/addmusic_fav' and @checked='false']");
		

	public static By objBack=By.xpath("//*[contains(@resource-id,'backView')]");

	public static By objfollowPlusIcon=By.xpath("//*[@resource-id='com.zee5.hipi:id/follow_icons' and @checkable= 'false']");
	public static By objProfileImageview=By.xpath("//*[contains(@resource-id,'avatarCircleImageView')]");

	public static By objfollowingButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtEditProfile' and @text='Following']");
		

	public static By objSoundsTab=By.xpath("//*[contains(@resource-id,'txtSounds')]");
	public static By objUnfavouritedSound=By.xpath("(//*[@id='addmusic_fav_infav'])[1]");
		
	public static By objCreatorVideoSound=By.xpath("//*[contains(@resource-id,'songNameMTextView')]");
	public static By objfollowButton=By.xpath("//*[@resource-id='com.zee5.hipi:id/txtEditProfile' and @text='Follow']");
	public static By objFavouritesTab=By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='tab_layout']]/*/*[@class='android.widget.ImageView' and ./parent::*[@class='android.widget.LinearLayout']])[3]");
	public static By objVideosTab=By.xpath("//*[contains(@resource-id,'txtVideo')]");	
		
	public static By objFavouritedVideo=By.xpath("(//*[@resource-id='com.zee5.hipi:id/desc'])[1]");
	public static By objFavouritedSound=By.xpath("(//*[@id='music_name'])[1]");

	public static By objStarIcon=By.xpath("(//*[@resource-id='com.zee5.hipi:id/imgFavActive'])[1]");
}
