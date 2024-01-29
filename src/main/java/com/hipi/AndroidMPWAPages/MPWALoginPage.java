package com.hipi.AndroidMPWAPages;

import org.openqa.selenium.By;

public class MPWALoginPage {

	
	public static By objUsePhoneOrEmail = By.xpath("(//*[@class='flex justify-center items-center text-sm md:text-base w-full text-gray-600 font-semibold'])[1]");

	public static By objEmailOption = By.xpath("//*[@class=' py-2 w-1/2 flex justify-center align-center cursor-pointer']");

	public static By objEmailIdField = By.xpath("//*[@placeholder='Email address'] | //*[@name='phone']");

	public static By objPhoneNumberTextField = By.xpath("(//*[@name='phone'])[1]");
	
	public static By objPasswordField = By.xpath("//*[@placeholder='Password']");

	//public static By objLoginBtn = By.xpath("//*[@text=' Log in']");
	
	public static By objLoginBtn = By.linkText(" Log in");
	
	
	public static By objProceed = By.xpath("//*[@text=' Proceed']");
	
	public static By objLoginWithPassword = By.xpath("(//*[@class='cursor-pointer'])[2]");

}
