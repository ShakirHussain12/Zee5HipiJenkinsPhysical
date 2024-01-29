package com.zee5.Applicaster.HIPI;
import org.openqa.selenium.By;

public class AMDPopular {
	//hipi
			public static By objBottomNavigation(String tabName) {
					return By.xpath("//*[@id='bb_bottom_bar_title' and @text='" +tabName+ "']");
				}
	////populartext
	public static By objpopulartext=By.xpath("//*[@resource-id='com.graymatrix.did:id/challengestext']");
	//thumbnail profile
	public static By thumnailprofile(int index) {
		return By.xpath("(//*[@resource-id='com.graymatrix.did:id/roundedImageView'])[" + index + "]");
	}
	//popularcelebrity profile
	public static By objprofilepic=By.xpath("//*[@resource-id='com.graymatrix.did:id/profile_pic']");
	//tapping on profile pic
	public static By objthumbnailimage=By.xpath("//*[@resource-id='com.graymatrix.did:id/image']");
	//follow celebrity
	public static By objfollow =By.xpath("//*[@resource-id='com.graymatrix.did:id/txtEditProfile']");
	//firstname
	public static By objprofilename=By.xpath("//*[@resource-id='com.graymatrix.did:id/txtUserName']");
	//followers count
	public static By objfollowerscount=By.xpath("//*[@id='txtFollowValue']");
	//following count
	//public static By objfollowingcount=By.xpath("//*[@resource-id='com.graymatrix.did:id/txtFollowingValue']");
	//profilename
	public static By objfirstName(String text) {
		return By.xpath("//*[@resource-id='com.graymatrix.did:id/txtName'])[" + text + "]");
	}
//	public static By objprofilename=By.xpath("(//*[@id='recycler']/*/*[@id='txtName'])[1]");
	//followerscountin thumbnail
	public static By objcount(int index) {
		return By.xpath("//*[@resource-id='com.graymatrix.did:id/txtFollowers'])[" + index + "]");
	}
	//public static By objcount=By.xpath("//*[@resource-id='com.graymatrix.did:id/txtFollowers']")["+index+"]");
	//Editprofile
			public static By objeditprofile=By.xpath("//*[@resource-id='com.graymatrix.did:id/txtEditProfile']");
			//Editprofiletitle
			public static By objedit=By.xpath("//*[@resource-id='com.graymatrix.did:id/my_edit_profile_text']");
			//firstname
			public static By objfirstname=By.xpath("//*[@resource-id='com.graymatrix.did:id/firstNameInputLayout']");
			//firstname text
			public static By objfirstnametxt=By.xpath("//*[@resource-id='com.graymatrix.did:id/firstNameEditText']");
			//lastname
		    public static By objlastname=By.xpath("//*[@resource-id='com.graymatrix.did:id/lastNameInputLayout']");
		    //lastnametxt
		    public static By objlastnametxt=By.xpath("//*[@resource-id='com.graymatrix.did:id/lastNameInputLayout']") ;
		    //userhandle
		    public static By objuserhandle=By.xpath("//*[@resource-id='com.graymatrix.did:id/userHandleInputLayout']");
		    //userhandletext
		    public static By objuserhandletxt=By.xpath("//*[@resource-id='com.graymatrix.did:id/userHandleEditText']");
		    //dob
		    public static By objdob=By.xpath("//*[@resource-id='com.graymatrix.did:id/dobInputLayout']");
		    //dobtext
		    public static By objdobtext=By.xpath("//*[@resource-id='com.graymatrix.did:id/dobEditText']");
		    //userbio
		    public static By objuserbio=By.xpath("//*[@resource-id='com.graymatrix.did:id/userBioEditText']");
		    //counter
		    public static By objcount=By.xpath("//*[@resource-id='com.graymatrix.did:id/textinput_counter']");
		    //edittext
		    public static By objedittext=By.xpath("//*[@resource-id='com.graymatrix.did:id/imgEdit']");
		    //backbtn
		    public static By objbckbtn=By.xpath("//*[@resource-id='com.graymatrix.did:id/imgBack']");
		    //shareprofle
		    public static By objshareprofile=By.xpath("//*[@resource-id='com.graymatrix.did:id/share']");
		    //Hipiprofiel
		    public static By objHipiprofile=By.xpath("//*[@resource-id='miui:id/alertTitle']");
		    //cancel
		    public static By objcancel=By.xpath("//*[@resource-id='android:id/button2']");
		    //followers
		    //public static By objfollowers =By.xpath(")
		    //backbtn
		    public static By objbackbutn=By.xpath("//*[@resource-id='com.graymatrix.did:id/imgBack']");
		    //edit
		   // public static By objedit=By.xpath("//*[@resource-id='com.graymatrix.did:id/imgEdit']");
		    //editprofile back
		    public static By  objbackbtn=By.xpath("//*[@resource-id='com.graymatrix.did:id/imgBack']");
		  //*[@resource-id='com.graymatrix.did:id/imgBack']
		    //followcount
		    //public static By objfollowercount=By.xpath("//*[@resource-id='com.graymatrix.did:id/txtFollowValue']");
		    //followingcount
		    public static By objfollowingcount=By.xpath("//*[@resource-id='com.graymatrix.did:id/txtFollowingValue']");
		    //followers
		    public static By objfollowers=By.xpath("//*[@resource-id='com.graymatrix.did:id/txtFollow']");
		    //following
		    public static By objfollowing=By.xpath("//*[@resource-id='com.graymatrix.did:id/txtFollowing']");
		    //followers title
		    public static By objfollowerstitle=By.xpath("//*[@resource-id='com.graymatrix.did:id/offers_title']");
		    //followingback
		    public static By objfollowerbackbutton=By.xpath("//*[@resource-id='com.graymatrix.did:id/back']");
		    //followingbackbutton
		    public static By objfollowingbackbutton=By.xpath("//*[@resource-id='com.graymatrix.did:id/back']");
		    //editprofilebackbutton
		    public static By objeditbackbutton=By.xpath("//*[@resource-id='com.graymatrix.did:id/imgBack']");
		    //feedbackbutton
		    public static By objfeedbackbutton=By.xpath("//*[@resource-id='com.graymatrix.did:id/backView']");
		    

}
