package com.zee5.iOS_HiPi_NeoScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasteriOSHipiNeoSanityBusinessLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class IOS_HiPi_Neo_Priority_P1_Test_cases {



	private Zee5ApplicasteriOSHipiNeoSanityBusinessLogic Zee5ApplicasterHipiNeoBusinessLogic;


	@BeforeTest
	public void init() throws InterruptedException {

		Zee5ApplicasterHipiNeoBusinessLogic = new Zee5ApplicasteriOSHipiNeoSanityBusinessLogic("zee");
	}


	@Test(priority = 0)
	@Parameters({ "userType", "InstallBuild" })
	public void ZeeAppInstallationLaunch_P1(String userType,String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.devicedetails();

	}
	
/*
	
	@Test(priority = 1)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_P1_part1(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shoppable_video_T167(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shoppable_video_Following_T168(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shoppable_video_T169(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T178(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_SaveLook_corousel_sheet_T194_T229(userType);//6
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T220(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T242_T244_T250_T252(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T056(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T066(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T247_T255(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_Screen_T213(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T185(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T203_ShopPage(userType);//13
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T072(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T074(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T076(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T132(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T095(userType);//5
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T240(userType);
	}
*/




	@Test(priority = 2)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_P1_part4(String userType, String InstallBuild) throws Exception {
		// ----------------------------------------comment------------------------------------------------------------

		
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T156(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T481(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T487(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T492(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T138(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T145(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T124(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T267_T281(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T268(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T355(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_P1_T154(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_P1_T490(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_HashTag_T041(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T045_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T050(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T051(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_P2_T155(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T282(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T423_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T427(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T428(userType);//25
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T480(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T136(userType);
		//total-feed--48
	}

/*
	@Test(priority = 5)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Discover_Screen_part1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1348_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1383(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1389(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1393(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1459(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1460(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1303_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1321(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1325_T1332(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1327(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1320(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1323(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1331_T1338(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1424(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1407(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1315(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1458(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1519_T1558(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1523(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_Screen_T1594_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1387(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1343(userType);
		
		//Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1576_T1582(userType);dbt
		
	}

	@Test(priority = 6)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Discover_Screen_part2(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1319(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1489_T1501(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1500(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1512(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1494(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1347(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1374(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1345(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1388(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1439(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1440(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1349(userType);
        Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1425(userType);
        
        Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1465(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1426(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1442(userType);// 44

	}


/*
	@Test(priority = 7)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyLogin_P1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T783_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T870_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T800_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T804_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T813_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T907(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T864_T911_T951(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T865_T912_T952(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T866_T913_T953(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T861_T908_T948(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T862_T909_T949(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T863_T910_T950(userType);// 27
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T798_P1(userType);//Hold
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T799_P1(userType);//Hold
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T881(userType);//Hold

	}


	@Test(priority = 8)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Creator_Screen(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T629(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T652(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T505(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.CreatorDeeplinkMsgInvoke();			
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T649(userType); 			
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T647(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.CreatorDeeplinkMsgInvoke();			
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T701(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T630(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T508(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T572(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T579_P1(userType);
		
//		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T655(userType); Features is changed (Video uploaded successfully)
//		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T657(userType);	Features is changed (Video uploaded successfully)
//		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T696_P1(userType);Features is changed (Video uploaded successfully)		
		

		
		//13

	}




	@Test(priority = 9)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyProfile_P2(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1181_T1184(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1051(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1058(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1059(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1067(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1074_P2(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1179(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1069(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1071(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1078(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1075(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1173(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1049(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1050(userType);//15

	}


	@Test(priority = 10)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifySettingsAndPrivacy_P1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T755_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Settings_and_Privacy_T754_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Settings_and_Privacy_T756_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Settings_and_Privacy_T757_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Settings_and_Privacy_T761_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Settings_and_Privacy_T770_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Settings_and_Privacy_T771_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Settings_and_Privacy_T772_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Settings_and_Privacy_T773_P1(userType);

	}



	@Test(priority = 11)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyDetailScreen_P1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1902(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1903(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1904(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1905(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1912(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1921(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1924(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1926(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1927(userType);//9

	}


	@Test(priority = 12)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyCreateVideo_P1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1953(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1957(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1961(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1964(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1969(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1970(userType);
		//Zee5ApplicasterHipiNeoBusinessLogic.CreateVideo_T1973(userType);//7

	}


	//New discover Tcs 
	@Test(priority = 13)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyDiscover_P1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1862(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1865_T1876(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1866_T1877(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1869_T1880(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1870_T1881(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1871(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1873(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1887(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1872_T1882_T1883(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1888(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1894(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1895(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1875(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1874(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1863(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1864(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1886(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1867_T1878(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1868_T1879(userType);//27

	}


	@Test(priority = 14)
	@Parameters({ "userType", "InstallBuild" })	
	public void VerifyShare_Module_P1(String userType, String InstallBuild) throws Exception{

		Zee5ApplicasterHipiNeoBusinessLogic.Share_T1803_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Share_T1804_P1_T1805_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Share_T1815_T1816_T1817_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Share_T1827_T1828_T1829_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Share_T1839_T1840_T1841_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Share_T1857_T1858_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Share_T1851_T1852_T1853_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Share_T1845_T1846_T1847_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Share_T1821_T1822_T1823_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Share_T1811_T1810_T1809_P1(userType);//26

	}


	@Test(priority = 15)
	@Parameters({ "userType", "InstallBuild" })
	public void SettingAndPrivacy_P1(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1714(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1715(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1717(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1724(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1731(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1716(userType);//6
	}	


//	@Test(priority = 16)hold
//	@Parameters({ "userType", "InstallBuild" })
//	public void VerifyDeeplinks_P1(String userType, String InstallBuild) throws Exception {	
//
//		Zee5ApplicasterHipiNeoBusinessLogic.VerifyDeeplinks_T1915_P1(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.VerifyDeeplinks_T1930_P1(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.VerifyDeeplinks_T1931_P1(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.VerifyDeeplinks_T1933_P1(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.VerifyDeeplinks_T1932_P1(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.VerifyDeeplinks_T1929_P1(userType);//6
//
//	}


	@Test(priority = 17)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFollowing_P1(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.Following_T1673_P1(userType);//1

	}


	@Test(priority = 18)
	@Parameters({ "userType", "InstallBuild" })
	public void HybridModule_P1(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T1672(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Following_T1673_P1(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.OwnProfile_T1923(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.MyProfile_T1916_P1(userType);//4

	}
*/

	@AfterClass
	public void tearDownApp() {
		System.out.println("Quit the App");
		Zee5ApplicasterHipiNeoBusinessLogic.tearDown();	
	}

}
