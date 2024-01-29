package com.zee5.iOS_HiPi_NeoScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasteriOSHipiNeoSanityBusinessLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class IOS_HiPi_Neo_Priority_P0_Test_cases {

	private Zee5ApplicasteriOSHipiNeoSanityBusinessLogic Zee5ApplicasterHipiNeoBusinessLogic;


	@BeforeTest
	public void init() throws InterruptedException {
		Zee5ApplicasterHipiNeoBusinessLogic = new Zee5ApplicasteriOSHipiNeoSanityBusinessLogic("zee");  
	}

	
	@Test(priority = 0)
	@Parameters({ "userType", "InstallBuild" })
	public void ZeeAppInstallationLaunch_P0(String userType,String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.devicedetails();
	}


	
	@Test(priority = 1)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_part1(String userType, String InstallBuild) throws Exception {

		//Guest
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T009(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_GT011(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T012(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_ForYou_Share_Video_T080(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_User_Profile_T088(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shoppable_video_T165(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shopbutton_video_T173(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shopbutton_video_T177(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shopbutton_video_T175_T176(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_SaveLook_T180(userType);

		//NonSubscribedUser
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_NT019(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T030(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_ForYou_Not_Interested_T105(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shoppable_video_T166(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shop_T251(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shop_T257(userType);

		//Both Guest and NonSubscribedUser
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_ForYou_Save_Video_T059_T109(userType);

		//Execute for Both
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shoppable_video_T162(userType);

	}

	@Test(priority = 2)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_part2(String userType, String InstallBuild) throws Exception {

		
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Following_T401(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Following_T403(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T183_T197_T232_T218(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T190_T225(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T192_T227(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T215(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T181_T216(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T210(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T211(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T182_T217(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T249_Feed_Shop(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shopbutton_video__T207(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T241ShopPage(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T204(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T243(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T097(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T123(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T431(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T039(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T402_T406(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T231_T196_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T134(userType);// 33
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shoppable_video_Following_T395(userType);

	}



	@Test(priority = 3)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_part3(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T269(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T287(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T289(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T293_T303(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T261_T276(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T378_T381(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T337(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T266_T278(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T292_T302(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T358_T369(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T372_T375(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T352_T363(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T357_T368(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T284(userType);

	}




	@Test(priority = 4)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_part4(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T094(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T125(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T126(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T129(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T137(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shoppable_video_T171(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shoppable_video_T172(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T179(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T214(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T237_T238(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T246_T254(userType);
		
	}
	
	
	
		@Test(priority = 5)
		@Parameters({ "userType", "InstallBuild" })
		public void VerifyFeedScreen_part5_p0(String userType, String InstallBuild) throws Exception {
		
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T404_T409(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T407(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_Screen_T412(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_Screen_T429(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_Screen_T449(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T461(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_Screen_T467_T131(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T073(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T091(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T096(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T111(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T128(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T174_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T184(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T186(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T187(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T195_T230(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T199(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T299_T309(userType);//44
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T101(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T103(userType);    
    	Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T245_T253_T393(userType);
    	Zee5ApplicasterHipiNeoBusinessLogic.Feed_Screen_T447(userType);
    	 
	}
		
		


	@Test(priority = 6)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_part6_P0(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T233(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T236(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T283(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T301(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T308(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T351_T362(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T353_T364(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T394(userType);				
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T398(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T408(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T426(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T432(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T435(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T437(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T440(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T464(userType);					
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T462(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T470(userType);				
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T473(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T179(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T007_p1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_GT006(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T025(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T396(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T397(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T400(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T416_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T424_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T433(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T465_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T443_P2(userType);//46
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T338(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T291(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T298(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T290_T300(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T343(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T350_T361(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T026(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T441(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T344(userType);	
		
	}




	@Test(priority = 7)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_part7(String userType, String InstallBuild) throws Exception {

		
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Sound_T046(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Sound_T047(userType);
		//Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Sound_T049(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Profile_T052(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_Screen_T061(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_Screen_T063(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_Screen_T089_T090(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_Screen_T131(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T065(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T070(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T010(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T008(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T005(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T018(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T077(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T013_T027_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T048_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T020_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T057(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T068(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T071(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T028(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T022(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T053(userType);//30
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T029(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T038(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T034(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T297_T307(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T296_T306(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T392(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T032(userType);
		//Feed total=196

	}



/*
	
	@Test(priority = 8)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Discover_Screen_part1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1326_T1333(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1328_T1335(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1371(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1376_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1378(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1379(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1400(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1409(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1411(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1413(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1416(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1443_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1469(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1486(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1496_T1497(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1492_T1504(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1499(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1507(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1510(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1511(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1517(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1526_T1518(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1524_T1563(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1528(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1557(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1575(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1569_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1585(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1578_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1581_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1329_T1336(userType);//43
		
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1509(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1403(userType);
		
		//Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1554(userType);//hold
	
	}	

	
	@Test(priority = 9)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Discover_Screen_Part2(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1304_T1314(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1308_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1313_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1344(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1350(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1352(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1404(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1417_T1448(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1421_T1423(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1466(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1515(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1567(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1568(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1584(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1306(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1596_T1600(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1597_T1601(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1309_T1310(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1318(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1330(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1595_T1599(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1598_1602(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1406(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1485(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1591(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1556(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1561(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1564(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1580(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1340(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1299(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1300(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1592(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1522(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1516(userType);			
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1495(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1463(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1508(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1380(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1337(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1441(userType);
		
		//Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1487(userType);//48---this feature is removed
		//Discover total=91

	}

	/*

	@Test(priority = 10)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyLogin_P0_part1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T805_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T825_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T827_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T832_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T851(userType);// s
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T871_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T876_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T878_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T890(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T906(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T920(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T922(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T923(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T956(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T962(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T964(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T927(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T815_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T930_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T887(userType);
		//total=21
		//Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T899(userType);//Hold
	}


	@Test(priority = 11)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyLogin_P0_Part2(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T774_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T776_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T777_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T786_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T796_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T811_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T822(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T883(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T917_p0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T968(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T971(userType);//12
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T781(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T782(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T787(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T788(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T789(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T790(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T791(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T793(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T802(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T803(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T824(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T826(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T828(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T837(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T850(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T980(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_Continue_VerifyFBsiteInHiPi_T838(userType);																								
		Zee5ApplicasterHipiNeoBusinessLogic.Login_Continue_FBLogin_T840(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T855(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T856(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T858(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T859_T946(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T869_T916(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T918(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T925(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T957(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T959(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T961(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T966(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T969(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T970(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T979(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T1008(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T893(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T868_T955(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T1009(userType); // P0
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T867_T914_T954(userType);//42
		//Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T897(userType);//Hold
		//Login total=42+12+21 =   75
	}





	@Test(priority = 12)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Creator_Screen_module1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T563_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T568(userType);
		
		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T604_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T606_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T609_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T613_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T623(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T642(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T644(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T654(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T610_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T611_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T683_P2(userType);//14
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T576(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T592_P2(userType);
		//(T570)--yet to developed	

	}

	
	@Test(priority = 13)
	@Parameters({ "userType", "InstallBuild"})
	public void Verify_Creator_Module2(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T574(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T575_P0(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T646(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T648(userType);//dbt
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T650(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T668(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T666(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T664(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T662(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T670(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T672(userType);
		
		
		Zee5ApplicasterHipiNeoBusinessLogic.CreatorDeeplinkMsgInvoke();
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T676_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T674_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T678_P0(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.CreatorDeeplinkMsgInvoke();
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T685_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T684_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T680_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T599(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T682_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T698_P0(userType);//26
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T570(userType);//27		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T619(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T656(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T659_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T593_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T591_P0(userType);
	}

	
	
	@Test(priority = 14)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Creator_Module3(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		//Zee5ApplicasterHipiNeoBusinessLogic.Creator_T558(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T499(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T500(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T506(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T525_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T526_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T529_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T527_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T532(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T534_T539_(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T533_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T541_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T542(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T546_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T545_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T547_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T548_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T549_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T550_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T551(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T552_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T553_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T536_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T537_P2(userType);// 26
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T504(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_Video_Speed_T517(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_Video_Beauty_T523(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_Sound_T566(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_Sound_T586(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T603_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T561_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T580_P0(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T660(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.CreatorDeeplinkMsgInvoke();
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T690(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T531(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T514(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T679(userType);//16
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T565(userType);	
		//Creater total=82

        Zee5ApplicasterHipiNeoBusinessLogic.Creator_T540(userType);
        Zee5ApplicasterHipiNeoBusinessLogic.Creator_T582_P0(userType);
	}

/*

	@Test(priority = 15)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Profile_Module_P0(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1057(userType);				
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1140(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1120(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1160(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1115(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1117(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1220(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1178(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1048(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1054(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1064(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1080(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1085(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1086(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1077(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1047(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1222(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1223(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1224(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1225(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1121(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1126(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1123(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1087(userType);
		//Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1164(userType);
		//Profile total---26
		 
        Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1177(userType); 

	}
	



	@Test(priority = 16)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifySettings_and_Privacy_P0(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Settings_and_Privacy_T704_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Settings_and_Privacy_T758_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T762_P2(userType);
		//Setting and Privacy total = 3

	}	



	@Test(priority = 17)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyDetailScreen_P0(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1901(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1913(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1918(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1919(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1914(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1925(userType);//6


	}
*/

	
	 
//	@Test(priority = 18)
//	@Parameters({ "userType", "InstallBuild" })
//	public void VerifyCreateVideo_P0(String userType, String InstallBuild) throws Exception {
//		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
//		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
//
//		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1952(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1954(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1955(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1956(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1959(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1963(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1971(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1951(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1962(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1965_T1966_P0(userType);//11
//
//
//
//	}
//
//
//	@Test(priority = 19)
//	@Parameters({ "userType", "InstallBuild" })
//	public void VerifyDiscover_P0(String userType, String InstallBuild) throws Exception {
//		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
//		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
//
//		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1860_T1861(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1884(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1889(userType);//4
//
//	}
//
//
//	@Test(priority = 20)
//	@Parameters({ "userType", "InstallBuild" })
//	public void SettingAndPrivacy_P0(String userType, String InstallBuild) throws Exception {
//		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1712(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1713(userType);//2
//	}
//
//	
//	@Test(priority = 21)
//	@Parameters({ "userType", "InstallBuild" })
//	public void HybridModule_P0(String userType, String InstallBuild) throws Exception {
//
//
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T1671(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.MyProfile_T1917_P0(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.MyProfile_T1920_P0(userType);//4
//		
//		Zee5ApplicasterHipiNeoBusinessLogic.Following_T1670_P0(userType);//mahesh review this tcs
//
//	}
//
//	@Test(priority = 22)
//	@Parameters({ "userType", "InstallBuild" })
//	public void VerifyDeeplinks_P1(String userType, String InstallBuild) throws Exception {
//
//		Zee5ApplicasterHipiNeoBusinessLogic.VerifyDeeplinks_T1928_P0(userType);	//1
//
//	}

	/*
	//Total P0 TC's = 501

	//3rdChecklist
		@Test(priority = 23)
		@Parameters({ "userType", "InstallBuild" })
		public void FollowingTab_P0(String userType, String InstallBuild) throws Exception {
			Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
			Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

			//P0
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1974(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1985_T1991(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1992(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1986(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1975(userType);
			
			//P1
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1976(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1977_T1987(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1978_T1988(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1979_T1989(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1980_T1990(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1981(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.FollowingTab_T1982(userType);
			
			
			//P1
			Zee5ApplicasterHipiNeoBusinessLogic.Feed_T1994(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.Feed_T1995(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.Feed_T1997(userType);
			
			Zee5ApplicasterHipiNeoBusinessLogic.Feed_T1998(userType);//Mahesh review this tcs
//			Zee5ApplicasterHipiNeoBusinessLogic.Feed_T2010(userType);hold
			
			//P1
			Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1996(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.Profile_T2003(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.Profile_T2004(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.Profile_T2008(userType);
			Zee5ApplicasterHipiNeoBusinessLogic.Profile_T2009(userType);

		}
	*/


        @AfterClass
         public void tearDownApp() {
	     System.out.println("Quit the App");
	     Zee5ApplicasterHipiNeoBusinessLogic.tearDown();	
       }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   /*     
        
    	@Test(priority =0)
    	@Parameters({ "userType", "InstallBuild" })
    	public void LoginInThread(String userType,String InstallBuild) throws Exception {
    		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
    		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
    		Zee5ApplicasterHipiNeoBusinessLogic.devicedetails();


    		for(int i=0;i<=99;i++) {
    			Zee5ApplicasterHipiNeoBusinessLogic.count(i);
    			Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
    			Zee5ApplicasterHipiNeoBusinessLogic.PhonenumberLoginMethod(i);
    			Zee5ApplicasterHipiNeoBusinessLogic.FacebookLoginMethod(i);
    			Zee5ApplicasterHipiNeoBusinessLogic.GoogleLoginMethod(2,i);
    			Zee5ApplicasterHipiNeoBusinessLogic.GoogleLoginMethod(6,i);
    			Zee5ApplicasterHipiNeoBusinessLogic.GoogleLoginMethod(12,i);
    		}

    	}
      

       /*
        	// jenkins test cases
        	@Test(priority =1)
        	@Parameters({ "userType", "InstallBuild" })
        	public void FeedScreenArrivalTime(String userType, String InstallBuild) throws Exception{
        		Zee5ApplicasterHipiNeoBusinessLogic.TimeStamprelaunch(InstallBuild,"Yes");
        		Zee5ApplicasterHipiNeoBusinessLogic.TimeStampLoginAndNivigateToHipi(userType);
        		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreenArrivalTimeFromSplashScreen(userType);
        			
        	}
        	
        	@Test(priority =2)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToLikeAvideo(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.LikeVideo(userType);
        	}
        	
        	
        	@Test(priority =3)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToPostAcomment(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.commentOnvideo(userType);
        	
        	}
        	
        	@Test(priority =4)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToPostAcreatedVideo15s(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Post(15,userType,"TC004","4");
        	}
        	
        	@Test(priority =5)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToPostAcreatedVideo30(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Post(30,userType,"TC005","5");
        	}
        	
        	
        	@Test(priority =6)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToPostAcreatedVideo45(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Post(45,userType,"TC006","6");
        	}
        	
        	@Test(priority =7)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToPostAcreatedVideo60(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Post(60,userType,"TC007","7");
        	}
        	
        	@Test(priority =8)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToPostAcreatedVideo90(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.create_Video_And_Post(90,userType,"TC008","8");
        	}

        	
        	@Test(priority =9)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToStartVideoAfterSwipe(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.video_Start_Time_After_Swipe(userType,"TC009");
        	}
        	
        	@Test(priority =10)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadDiscoverPage(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.discover_Screen_LoadTime(userType,"TC010");
        	}
        	
         
        	@Test(priority =11)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadSearshResultInDiscoverPage(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.searchResultScreen(userType,"TC011");
        	
        	}
        	
        	@Test(priority =12)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadAutoSuSearshResultInDiscoverPage(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.searchAutoSuggestionsResultScreen(userType,"TC012");
        	
        	}
        	@Test(priority =13)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadCarousalBannersInDiscoverPage(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.Carousel_or_Banner_LoadTime(userType,"TC013");
        	
        	}
        	//@Test(priority =14)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadBannerClickedLandingScreenInDiscoverPage(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.Banner_clicked_landing_Screen(userType,"TC014");
        	
        	}
        	
        	@Test(priority =15)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadRailsPage(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.Rails_Page_Loading(userType,"TC015");
        	
        	}
        	
        	
        	//---------12/07/2022---------------------------------------------------------------------
        	
        	@Test(priority =16)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadHashtagRailsPage(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.Hashtag_details_page(userType,"TC016");
        	
        	}
        	
        	@Test(priority =17)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadSoundscreen(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.CreatorSoundScreenLoadTime(userType,"TC017");
        	
        	}
        	
        	@Test(priority =18)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadLogoutscenario(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.logout_scenario(userType,"TC018");
        	
        	}
        	
        	@Test(priority =19)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadLoginScenario(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.login_scenario(userType,"TC019");
        	
        	}
        	
        	@Test(priority =20)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadEffects_screen(String userType,String InstallBuild) throws Exception{
        	
        	//Zee5ApplicasterHipiNeoBusinessLogic.Effects_LoadTime(userType,"TC020");
        	Zee5ApplicasterHipiNeoBusinessLogic.Effects_LoadTime(userType,"TC0020");
        	
        	}
        	
        	@Test(priority =21)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadFilter_screen(String userType,String InstallBuild) throws Exception{
        	
        	//Zee5ApplicasterHipiNeoBusinessLogic.Filters_LoadTime(userType,"TC021");
        	Zee5ApplicasterHipiNeoBusinessLogic.Filters_LoadTime(userType,"TC021");
        	
        	}
        	
        	@Test(priority =22)
        	@Parameters({ "userType", "InstallBuild" })
        	public void TimeTakenToloadPostScreenFromNextCTA_screen(String userType,String InstallBuild) throws Exception{
        	
        	Zee5ApplicasterHipiNeoBusinessLogic.Next_CTA_from_video_detail_page(userType,"TC022");
        	
        	}
	*/
	

}
