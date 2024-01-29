package com.zee5.AndroidHipiPages;

import org.openqa.selenium.By;

public class HipiReportProfileScreen {

	
	public static By objReportProfile = By.xpath("//*[contains(@resource-id,'offers_title')]");
	//Select Reason 
	public static By objSelectReason = By.xpath("//*[contains(@resource-id,'mainTypeLabel')]");
	//Select Anti Social
	public static By objAntiSocial = By.xpath("//*[@text='Anti social']");
	//Select Category
	public static By objSelectCategory = By.xpath("//*[@text='Select Category']");
	//Select it's copied content
	public static By objitscopiedcontent = By.xpath("//*[@text='Its copied content']");
	//click Description
	public static By objDescription = By.xpath("//*[contains(@resource-id,'descedit')]");
	//Submit Button
	public static By objSubmitButton = By.xpath("//*[contains(@resource-id,'nextBtn')]");
	//Reported Profile POP UP
	public static By objReportedProfilePopUp = By.xpath("//*[@text='Thank for your report. We will review it and get back to you.']");
	//Back to Video Listing Tab
	public static By objBackVideoListingTab = By.xpath("//*[contains(@resource-id,'backView')]");
	//Verify layout of report content screen
	public static By objVerifylayoutofreportcontentscreen= By.xpath("//*[contains(@resource-id,'fragment_frame')]");
	//spam Arrow
	public static By objspamArrow= By.xpath("//*[contains(@resource-id,'arrow_spam')]");
	//Inappropriate Arrow
	public static By objInappropriateArrow= By.xpath("//*[contains(@resource-id,'arrow_inapproprite')]");
	//Attachment icon
	public static By objAttachmenticon= By.xpath("//*[contains(@resource-id,'fileAttach')]");
	//Maximum characters entered : 0/150
	public static By objMaximumcharactersentered= By.xpath("//*[contains(@resource-id,'textinput_counter')]");
	//Select image
	public static By objSelectimage= By.xpath("//*[@id='icon_thumb']");
	//Select Select
	public static By objSelectAttachment= By.xpath("//*[contains(@resource-id,'fetchedFile')]");
	//To removed attachment - tap on cross button on image attached
	public static By objremovedattachment= By.xpath("(//*[@id='attachedLayer']/*[@class='android.widget.ImageView'])[2]");
	//Nudity And Sexual Content 
	public static By objNudityAndSexualContent = By.xpath("//*[contains(@resource-id,'reportCheck')]");
	//Video Is Sexual in Natur
	public static By objVideoIsSexualInNature = By.xpath("//*[contains(@resource-id,'reportCheck')]");
	//Thank for your report. We will review it and get back to you.
	public static By objThankForYourReport = By.xpath("//*[contains(@resource-id,'reportCheck')]");

	
	
}
