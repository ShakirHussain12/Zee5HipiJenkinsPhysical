package com.zee5.Applicaster.HIPI;

import org.openqa.selenium.By;

public class AMDMore {
	//more
		public static By objMore=By.xpath("//*[@text='More']");
		//header
		public static By objheader=By.xpath("//*[@resource-id='com.graymatrix.did:id/header']");
		//profiletitle
		public static By objprofiletitle=By.xpath("//*[@resource-id='com.graymatrix.did:id/header']");
		//moreeditprofile
		public static By objmoreeditprofile=By.xpath("//*[@resource-id='com.graymatrix.did:id/txt_edit_profile']");
		//editprofile
		public static By objeditprofile=By.xpath("//*[@resource-id='com.graymatrix.did:id/screen_title']");
		//back button
		public static By objbackbutton=By.xpath("//*[@resource-id='com.graymatrix.did:id/icon_back']");
		//myprofilebackbtn
		public static By objprofilebackbtn=By.xpath("//*[@resource-id='com.graymatrix.did:id/icon_back']");
		
		public static By objZeeProfileName(String username){
			return By.xpath("//*[@resource-id='com.graymatrix.did:id/header' and @text='"+username+"']");
		}
}
