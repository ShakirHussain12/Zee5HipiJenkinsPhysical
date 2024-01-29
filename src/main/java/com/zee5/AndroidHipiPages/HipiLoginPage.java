package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiLoginPage {
//	Login Popup
	public static By objLoginPopup = By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");
	
	
	//Sign Up Link
	public static By objSignUpLink = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvSign']");

	//usePhone or Email
		public static By objUsePhoneOrEmail = By.xpath("//*[@resource-id='com.zee5.hipi:id/viaPhoneEmail']");
		//Email option
		public static By objEmailOption = By.xpath("//*[@content-desc='Email']");
		//Sign Up Title 
		public static By objSignUpTitle = By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");
		//Select Year
		public static By objSelectYear = By.xpath("(//*[@id='pickers']/*/*[@id='numberpicker_input'])[3]");
		//Next Button Sign Up Page
		public static By objNextButtonSignUpPage = By.xpath("//*[@resource-id='com.zee5.hipi:id/btnDateNext']");
		
		public static By objContinue = By.xpath("(//*[@text='Continue'])[2] | (//*[@text='Continue'])[1]");
		
		//Age Should Be Above 18 years Toster Message
		public static By objAgeShouldBeAbove18TosterMessage = By.xpath("//*[@resource-id='com.zee5.hipi:id/snackbar_text']");
		//Back Button 
		public static By objBackButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/back']");
		//Next Button email Option
		public static By objNextButtonEmailOption = By.xpath("//*[@resource-id='com.zee5.hipi:id/btnSendCode']");
		//Full Name Text Field
		public static By objFullNameTextField = By.xpath("//*[@resource-id='com.zee5.hipi:id/etName']");
		//Gender Drop Down
		public static By objGenderDropDown = By.xpath("//*[@resource-id='com.zee5.hipi:id/etGender']");
		//Gender Text Field
		public static By objGenderTextField = By.xpath("//*[@id='etGender'] | //*[@resource-id='com.zee5.hipi:id/tv_gender_type']");
		//Phone Number Text Feald
		public static By objPhoneNumberTextField = By.xpath("//*[@resource-id='com.zee5.hipi:id/et_phone']");
		//Remove Button
		public static By objPasswordRemoveButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/iv_clear_text_Pass']");
		//Complete CTA
		public static By objCompleteCTA = By.xpath("//*[@resource-id='com.zee5.hipi:id/btnNext']");
		//Create Username
		public static By objCreateUsername = By.xpath("//*[@id='innerTitle' and (./preceding-sibling::* | ./following-sibling::*)[@id='iv_available']]");
		//Skip CTA
		public static By objSkipCTA = By.xpath("//*[@resource-id='com.zee5.hipi:id/back' and @text='Skip']");
		//default username
		public static By objDefaultUsername = By.xpath("(//*[@resource-id='com.zee5.hipi:id/etName'])[2]");
		//Submit Button
		public static By objSubmitButton= By.xpath("//*[contains(@text,'Submit')]");
		
		//Email Text Feaild Forgot Password Page
		public static By objEmailTextFeaildForgotPasswordPage= By.xpath("//*[@id='et_email' and ./parent::*[@id='ll_email']]");
		//Reset Button
		public static By objResetButton= By.xpath("//*[@resource-id='com.zee5.hipi:id/btnReset']");
		//Create New Facebook Account
		public static By objCreateNewFacebookAccount= By.xpath("//*[@contentDescription='Create New Facebook Account']");
		//Join Facebook Next Button
		public static By objJoinFacebookNextButton= By.xpath("//*[@text='Next']");
		//None Of The Above
		public static By objNoneOfTheAboveButton= By.xpath("//*[@text='NONE OF THE ABOVE']");
		//First Name TextFeaild  Facebook
		public static By objFirstNameTextFeaildFacebook= By.xpath("//*[@text='First Name']");
		//Last Name TextFeaild  Facebook
		public static By objLastNameTextFeaildFacebook= By.xpath("//*[@text='Last Name']");
		//Birthday Title
		public static By objBirthdayTitle= By.xpath("//*[@text='Birthday']");
		//Stop Creating Account
		public static By objStopCreatingAccount= By.xpath("//*[@text='Stop Creating Account']");
		//Wrong Info Real Birthday
		public static By objWrongInfoRealBirthday= By.xpath("//*[@text='It looks like you entered the wrong info. Please be sure to use your real birthday.']");
		
		//Please provide a valid phone number
		public static By objPleaseProvideValidPhoneNumberTosterMessage = By.xpath("//*[@resource-id='com.zee5.hipi:id/snackbar_text']");
		//Phone Number TAB
		public static By objPhoneNumberTAB = By.xpath("//*[@class='android.widget.TextView' and ./parent::*[@contentDescription='Phone']]");

		//Email Number TAB
		public static By objEmaileNumberTAB = By.xpath("//*[@class='android.widget.TextView' and ./parent::*[@contentDescription='Email']]");
		
		//By Continuing Message
		public static By objByContinuingMessage = By.xpath("//*[@resource-id='com.zee5.hipi:id/privacy']");
		
		//phone number after typing 
				public static By objPhoneNumberAfterText=By.xpath("//*[@id='et_phone']");
		
		// You can always change this later 
				public static By objYouCanAlwaysChangeThisLater=By.xpath("(//*[@resource-id='com.zee5.hipi:id/innerSubtitle'])[2]");
	
		//Tick Mark Create Screen
				public static By objTickMarkCreateScreen=By.xpath("//*//*[@resource-id='com.zee5.hipi:id/iv_available']");

				
				
				


		
		//--------------------------------------------Deepa--------------------------------------------------------------
		
//		Login In Title
		public static By objLoginTitle = By.xpath("//*[@resource-id='com.zee5.hipi:id/title' and @text='Log in']");
		
//		+91 Drop down
		public static By objPlus91DropDwon = By.xpath("//*[@resource-id='com.zee5.hipi:id/arrow_imv']");
		
	// Select country/region
		public static By objSelectCountryRegion = By.xpath("//*[@id='title' and ./parent::*[@id='layHeader']]");
	

//		Remove Phone Number 
		public static By objRemovePhoneNumber = By.xpath("//*[@resource-id='com.zee5.hipi:id/iv_clear_text']");
//		remove Option rest screen
		public static By objRemoveOptionRestScreen = By.xpath("//*[@resource-id='com.zee5.hipi:id/iv_clear_email']");

//		Password Text Field 
		public static By objPasswordTextField = By.xpath("//*[@resource-id='com.zee5.hipi:id/etPassword']");
		
//		Remove Password from password Text Field 
//		public static By obj= By.xpath("//*[@resource-id='com.zee5.hipi:id/etPassword']");
	
		
//		Forgot Password Button 
		public static By objForgotPasswordButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/forgotPass']");
		
//		Forgot Password Text 
		public static By objForgotPasswordResetScreen = By.xpath("//*[@resource-id='com.zee5.hipi:id/innerTitle']");
		
		
	//Email button on login screen
		public static By objEmailButton = By.xpath("//*[@text and @class='android.widget.TextView' and ./parent::*[@contentDescription='Email']]");
		
		
//		Email Address text field 
//		public static By objEmailAddressField = By.xpath("//*[@resource-id='com.google.android.gms:id/account_display_name']");
		
		
//		Continue with Facebook CTA in login popup
		public static By objContinuewithFacebookCTA = By.xpath("//*[@resource-id='com.zee5.hipi:id/viaFacebook']");
		
	// Facebook text in app browser
		public static By objFacebookHeader = By.xpath("//*[@nodeName='I' and ./parent::*[@nodeName='A']]");
		
		//facebook email text field browser
		public static By objFacebookEmailTextFieldBrowser = By.xpath("//*[@type='email']");
		//facebook Password text field browser
		public static By objFacebookPasswordTextFieldBrowser = By.xpath("//*[@type='password']");
		//facebook Login Button browser
		public static By objFacebookLoginButtonBrowser = By.xpath("//*[@text='Log In']");
		//facebook Continue Button Browser
		public static By objFacebookContinueButtonBrowser = By.xpath("//*[@text='Log In']");

		
//		Continue with Google CTA in login popup
		public static By objContinueWithGoogleCTA = By.xpath("//*[@resource-id='com.zee5.hipi:id/viaGoogle']");

		
		
	//Sign Up Screen Tittle
		public static By objSignUpScreenTittle = By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");

		
//		Click on Google Id 
		public static By objGoogleAccount = By.xpath("//*[@resource-id='com.google.android.gms:id/account_display_name']");
		
//		Sign up for HiPi Title
		public static By objSignUpHiPiTitle= By.xpath("//*[@resource-id='com.zee5.hipi:id/title' and @text='Sign up at Hipi'] | //*[@resource-id='com.zee5.hipi:id/title' and @text='Sign up']");
		
//		Log in link
		public static By objLogInLink= By.xpath("//*[@resource-id='com.zee5.hipi:id/tvSign']");
	
		//------------------
		//Cross Icon
		public static By objCrossIcon = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgBack']");
		//Cross Icon In Search Bar
		public static By objCrossIconInSearchBar = By.xpath("//*[@resource-id='com.zee5.hipi:id/iv_clear_text']");

		
		//Cross Icon LoginPopUp
		public static By objCrossIconLoginPopUp = By.xpath("//*[@resource-id='com.zee5.hipi:id/ivBack']");

		
//Login Button
		public static By objLoginButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/btnSendCode']");
		
//		Login With OTP Button
		public static By objLoginWithOTPButton = By.xpath("//*[@resource-id='com.zee5.hipi:id/withPass' and @text='Login with OTP']");
		
	//Login with Password
		public static By objLoginWithPassword= By.xpath("//*[@resource-id='com.zee5.hipi:id/withPass' and @text='Login with password']");

//		Scroll year cloum
		public static By objScrollYearColum = By.xpath("(//*[@resource-id='android:id/numberpicker_input'])[2]");
		
//		Facebook Icon 
		public static By objFacebookIcon = By.xpath("//*[@class='android.widget.ImageView' and ./parent::*[@id='(name removed)']]");
	// Facebook Email Text field
		public static By objFaceBookEmailTextfield = By.xpath("//*[@contentDescription='Username']");
		
	//Facebook Password  Text field	
		public static By objPasswordTextfield = By.xpath("//*[@contentDescription='Password']");
		
	//Facebook Login Button
		public static By objFacebookLoginButton = By.xpath("//*[@contentDescription='Log In']");
		
//		Cross Icon On Login Popup
		public static By objCrossIconOnLoginPopup= By.xpath("//*[@resource-id='com.zee5.hipi:id/ivBack']");
	//Month Field
		
		
	//Date Field	
		public static By objDateField=By.xpath("(//*[@id='numberpicker_input' and (./preceding-sibling::* | ./following-sibling::*)])[1]");
		// Send OTP
		   public static By objSendOTP = By.xpath("//*[@resource-id='com.zee5.hipi:id/btnSendCode']");
		   
		   
		 //Month Field	
			public static By objMonthField=By.xpath("(//*[@id='numberpicker_input' and (./preceding-sibling::* | ./following-sibling::*)])[2]");
		
			//Year Field	
			public static By objYearField=By.xpath("(//*[@id='numberpicker_input' and (./preceding-sibling::* | ./following-sibling::*)])[3]");
		   
		   
			  // Phone Tab Is Selected By Default
			   public static By objPhoneTabIsSelectedByDefault= By.xpath("//*[@text='Phone' and @clickable='false']");
			   // Email Tab Is Selected By Default
			   public static By objEmailTabIsSelectedByDefault= By.xpath("//*[@text='Email' and @clickable='false']");
			// Search Tab
				  public static By objSearchTab = By.xpath("//*[@resource-id='com.zee5.hipi:id/editTextSearch']");
				  
				// Search CTA
				  public static By objSearchCTA = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvSearch']");
				  
				   public static By objcountryOrRegionList = By.xpath(" //*[@resource-id='com.zee5.hipi:id/countryName']");
				// Toster Message/ not register with mobile number
				   public static By objNotRegisterMobileNumberTosterMessage = By.xpath("//*[@resource-id='com.zee5.hipi:id/snackbar_text']");
				   
				//OTP Verification Screen
				   public static By objOtpVerificationScreen = By.xpath("//*[@resource-id='com.zee5.hipi:id/titleCode']");
				   
				   
				//   Verify OTP button
				   public static By objVerifyOTPCTA = By.xpath("//*[@resource-id='com.zee5.hipi:id/btnVerifyCode']");

				//   Invalid code
				   public static By objInvalidCode = By.xpath("//*[@resource-id='com.zee5.hipi:id/snackbar_text']");
				// Reset Header
				   public static By objResetHeader = By.xpath("//*[@id='title' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text]]]");
				// When's your birthday ?
				   public static By objWhensYourBirthDay= By.xpath("//*[@resource-id='com.zee5.hipi:id/calendarTitle']");

				   // Your birthday won't be shown publicly
				   public static By objYourBirthdayWontBeShownPublicly= By.xpath("//*[@resource-id='com.zee5.hipi:id/calendarsSubtitle']");

//---------------------------------------------------------------------------------------------------------------------
				   //	Metadata of Login screen
				   public static By objMetaDataOfLoginPopUp= By.xpath("//*[@resource-id='com.zee5.hipi:id/subtitle']");
				   
//				 Terms of use and privacy policy
				   public static By objTermsOfUseandPrivacyPolicy= By.xpath("//*[@resource-id='com.zee5.hipi:id/termsprivacy']");
				   
//				  Dont have an account? Signup link
				   public static By objTDontHaveAnAccountSignupLink= By.xpath("//*[@resource-id='com.zee5.hipi:id/donthaveacnt']");
				   
//				   Metadata of reset screen
			      public static By objWellSMSYouaOTPtoResetYourPassword= By.xpath("//*[@resource-id='com.zee5.hipi:id/innerSubtitle']"); 
				 
			  	//   Enter 4-digit otp
				   public static By objEnterFourDigitOTP = By.xpath("//*[@resource-id='com.zee5.hipi:id/titleCode']");
				   
				//   Verify OTP screen Metadata
				   public static By objVerifyOTPScreenMetadata = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvCodeHint']");
				   
				//   First digit
				   public static By objFirstDigit = By.xpath("//*[@resource-id='com.zee5.hipi:id/et1']");
				   
				  //   Second digit
				   public static By objSecondDigit = By.xpath("//*[@resource-id='com.zee5.hipi:id/et2']");
				   
				   //   Third digit
				   public static By objThirdDigit = By.xpath("//*[@resource-id='com.zee5.hipi:id/et3']");
				   
				   //   Fourth digit
				   public static By objFourthDigit = By.xpath("//*[@resource-id='com.zee5.hipi:id/et4']");
			
				   //   Havn't Recived OTP? Send Again
				   public static By objHavntRecivedOTPSendAgain = By.xpath("//*[@id='llResend'] | //*[@resource-id='com.zee5.hipi:id/tv_sendAgain']");
				   
				   //Send Again
				   public static By objSendAgain = By.xpath("//*[@resource-id='com.zee5.hipi:id/tv_sendAgain']");

				   
				//   Resend OTP text allong with time
				   public static By objResendOTPtextAllongWithTime = By.xpath("//*[@resource-id='com.zee5.hipi:id/resendCode']");
				   
				//   Please use valid email address
				   public static By objPleaseUseValidEmailAddress = By.xpath("//*[@resource-id='com.zee5.hipi:id/snackbar_text']");

//					Metadata of forgot screen
					public static By objWellEmailYouALinkToResetYourPassword= By.xpath("//*[@resource-id='com.zee5.hipi:id/innerSubtitle']");

					
					public static By objSearchCountry(String country) {
					return By.xpath("//*[@resource-id='com.zee5.hipi:id/countryName' and @text='" + country +"']");
					}
//					Metadata of signup  screen
					public static By objCreateAProfileFollowOtherAccountsMakeYourOwnVideosAndMore= By.xpath("//*[@resource-id='com.zee5.hipi:id/subtitle']");
					
			//Cross icon on Country region screen
			public static By objCrossIconOnContryorRegionScreen = By.xpath("//*[@resource-id='com.zee5.hipi:id/back']");
					
			
			
			   // OTP sent successfully
			public static By objOTPSentSuccessfully = By.xpath("//*[@resource-id='com.zee5.hipi:id/snackbar_text']");
			
			
			//User your Name and Gender
			public static By objUserYourNameGenderandOtherInfo=By.xpath("//*[@resource-id='com.zee5.hipi:id/innerSubtitle']");
			//The mobile number and passowrd combination was wrong 
			public static By objTheMobileNumberAndPassowrdCombinationWasWrong=By.xpath("//*[@resource-id='com.zee5.hipi:id/snackbar_text']");

			//ZEE5 Logo
			public static By objZEE5Logo=By.xpath("//*[@resource-id='com.google.android.gms:id/app_icon']");


			//Chose An Account
			public static By objChoseAnAccount=By.xpath("//*[@resource-id='com.google.android.gms:id/main_title']");
			//To Continue To Hipi 
			public static By objToContinueToHipi=By.xpath("//*[@resource-id='com.google.android.gms:id/subtitle']");
			
			//ADD Another Account
			public static By objADDAnotherAccount=By.xpath("//*[@resource-id='com.google.android.gms:id/add_account_chip_title']");
			
			//To Continue Google Will Share
			public static By objToContinueGoogleWillShare=By.xpath("//*[@resource-id='com.google.android.gms:id/consent_text']");

			//Terms Of User And Confirm Text
			public static By objTermsOfUserAndConfirmText=By.xpath("//*[@resource-id='com.zee5.hipi:id/privacy']");

			

			public static By objLoginWithOtpScreenCrossIcon= By.xpath("//*[@id='iv_clear_text']");
			public static By objLoginWithOtpScreenInvalidOtpPopup= By.xpath("//*[@id='snackbar_text']");
			public static By objResetScreenPhoneNumberTextField = By.xpath("(//*[@resource-id='com.zee5.hipi:id/et_phone'])[1]");



			public static By objGoogleAccounts1(int index) {
				return By.xpath("(//*[@resource-id='com.google.android.gms:id/account_display_name'])[" + index + "]");
			}




			public static By objDoneButtonLanguage= By.xpath("//*[@resource-id='com.zee5.hipi:id/content_done']");


			public static By objSelectGendeTitler= By.xpath("(//*[@resource-id='com.zee5.hipi:id/title'])[1]");
			public static By objGenderButton= By.xpath("//*[@resource-id='com.zee5.hipi:id/etGender']");
			public static By objDoneCTASelectGenderPage= By.xpath("//*[@resource-id='com.zee5.hipi:id/btnNext']");
			

			public static By objMale= By.xpath("//*[contains(@text, 'Male')]");
			
			public static By objFemale= By.xpath("//*[contains(@text, 'Female')]");
			
			public static By objSelectVideoLanguage= By.xpath("//*[contains(@text,'Select video lang')]");
			
			public static By objTotalSelectedLanguages= By.xpath("//*[@resource-id='com.zee5.hipi:id/languageCheckbox']");

			
			//*[@resource-id='com.zee5.hipi:id/languageCheckbox']
			public static By objSelectedContentLanguage(int index) {
				return By.xpath("(//*[@resource-id='com.zee5.hipi:id/languageCheckbox']//child::*)[" + index + "]");
			}
			
			public static By objTotalLanguages(int index) {
				return By.xpath("(//*[@resource-id='com.zee5.hipi:id/languageThumbnail'])[" + index + "]");
			}
			
			
			
			
			
			
			
			//New Login Sign in 
			
			public static By objLoginOrSignIn= By.xpath("//*[@resource-id='com.zee5.hipi:id/title']");
			
			//subtitle
			public static By objMakeYourVideoSubtitle= By.xpath("//*[@resource-id='com.zee5.hipi:id/subtitle']");
			
		
			public static By objEmailIDOrMobileNumberFileld= By.xpath("//*[@resource-id='com.zee5.hipi:id/et_email']");
			
			public static By objProceedButton= By.xpath("//*[@resource-id='com.zee5.hipi:id/btnProceed']");
			
			public static By objProceedCTCHighlighted= By.xpath("//*[@resource-id='com.zee5.hipi:id/btnProceed' and @focusable='true']");
			
			
			public static By objVerifyOTPHeader= By.xpath("//*[@resource-id='com.zee5.hipi:id/title' and @text='Verify OTP']");

			   public static By objEnter4DigitOTP = By.xpath("//*[@resource-id='com.zee5.hipi:id/titleCode']");

			 
			 
			   public static By objBackButtonVerifyOTP = By.xpath("//*[@resource-id='com.zee5.hipi:id/imgBackEmail']");
			 
			   public static By objEmailorPhoneField = By.xpath("//*[@resource-id='com.zee5.hipi:id/etEmail']");
			 
			   public static By objAgeField = By.xpath("//*[@resource-id='com.zee5.hipi:id/etAge']");
			   
			 
			   public static By objMaybeLater = By.xpath("//*[@resource-id='com.zee5.hipi:id/tvUpdateLater']");
			   
			   public static By objfbuserName= By.xpath("//*[@id='m_login_email'] | (//*[@nodeName='INPUT'])[1]");
			   public static By objFBpassword = By.xpath("//*[@id='m_login_password'] | (//*[@nodeName='INPUT'])[2]");
			   public static By  objFbloginbutton= By.xpath("//*[@id='login_password_step_element']//*[@nodeName='BUTTON']");
			   
					   public static By  objFbEnglesh= By.xpath("//*[@name='login']");
}
				 

			    
				   






