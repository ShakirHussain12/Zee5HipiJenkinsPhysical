package com.zee5.iOS_HiPi_NeoScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasteriOSHipiNeoSanityBusinessLogic;

public class IOS_HiPi_Neo_Priority_P2_Test_cases { 

	private Zee5ApplicasteriOSHipiNeoSanityBusinessLogic Zee5ApplicasterHipiNeoBusinessLogic;

	@BeforeTest
	public void init() throws InterruptedException {

		Zee5ApplicasterHipiNeoBusinessLogic = new Zee5ApplicasteriOSHipiNeoSanityBusinessLogic("Zee");
	}
	
/*
	@Test(priority = 0)
	@Parameters({ "userType", "InstallBuild" })
	public void ZeeAppInstallationLaunch_P2(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.devicedetails();
	}


	@Test(priority = 1)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_part1_P2(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_NT023(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T1651_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T1649_T1646_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T466_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_Shoppable_video_Following_T164(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T163_P2(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T425_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T442_P2(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T446_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_SaveLook_corousel_sheet_T193_T228_p2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T099(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T438(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T262_T275(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T263_T277(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T439(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T453(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T436(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T457(userType);//27
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T455(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T454(userType);
		
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T1650_T1647_P2(userType);
		//Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T451(userType);Removed TC's
	}


	@Test(priority = 2)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_part2_P2(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T115(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T116(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T117(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T118(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T119(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T221(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T222(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T336(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T239(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T219(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T226_T191(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T205(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T1648_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T202(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T060_T110_T121(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T448_T459(userType);//20


	}


	@Test(priority = 3)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_part3_P2(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T079(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T092(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T098(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T104(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T106(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T108(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T248_T256(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T258(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T208(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T206(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T463(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T067_T127(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T069_T130(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T078(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T093(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T102(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T014(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T405(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T024(userType);//28
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T100(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T212(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T235_T200(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T209(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T148(userType);
	}


	@Test(priority = 4)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_part4_P2(String userType, String InstallBuild) throws Exception {

		//----------------------------------------comment---------------------------------------------------------------
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T151(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T152(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T157(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T159(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T161(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T160(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T133(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T139(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T149(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T150(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T468(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T475(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T483(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T485(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T486(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T488(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T493(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T495(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T496(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T497(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T498(userType);//26
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T144(userType);
		
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T472(userType);hold
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T484(userType);hold
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T469(userType);hold
//		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T474(userType);hold

	}
	
	@Test(priority = 5)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyFeedScreen_part5_P2(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T354_T365(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T356_T367(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T259(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T270(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T272(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T339_T346(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T340_T347(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T386_T391(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T260_T274(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T335_T342(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T370_T373(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T366(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T371_T374(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T377_T380(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T288(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T348_T359(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T379(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T334_T341(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_T201(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T234(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T345(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T198(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Feed_Screen_T456(userType);//39
		
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T259_T273(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.FeedScreen_T265_T280(userType);

		//total=140
	}

	
	
	@Test(priority = 6)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Discover_Screen_part1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1316(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1307(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1301_T1302_T1311_T1312(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1322(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1324(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1574_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1317_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1334(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1342_T1346(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1589_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1353(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1362(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1369(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1462(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1377(userType);// 20
		
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1375(userType);
	}


	@Test(priority = 7)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Discover_Screen_part2(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1381(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1384(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1385(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1386(userType); 		
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1390(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1341(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1370(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1372(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1410(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1412(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1414(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1415(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1420_T1451(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1422(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1438(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1445(userType);//20	
		//Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1586_T1579_T1570(userType);

	}


	@Test(priority = 8)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Discover_Screen_Part3(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1446(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1447(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1391(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1392(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1394(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1395(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1396(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1397(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1398(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1402(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1399(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1382(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1530_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1531_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1540_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1541_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1542_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1543_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1547_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1548_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1549_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1550_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1553_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1559_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1560_P2(userType);
	}

	@Test(priority = 9)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Discover_Screen_Part4(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1562_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1468_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1555(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1525(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1520(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1521(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1467(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1457_T1437(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1305(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1405(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1514(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1571(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1450_T1419(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1455_T1435(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1452(userType);// 52
		
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1588(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1587(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1583(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1577(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1573(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1565(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1464(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1493_T1505(userType);
	}



/*
	@Test(priority = 10)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyLogin_P2_part1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T775_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T778_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T784_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T785_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T794_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T797_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T801_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T806_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T814_P2(userType);			
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T812_P2(userType);				
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T820_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T821_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T823_P2(userType);			
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T829_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T830_P2(userType);				
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T833_P2(userType);				
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T853(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T849_T844(userType);// s				
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T854(userType);// s		
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T836(userType);// s			
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T857(userType);//dbt
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T860(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T915(userType);
		// Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T848(userType);//s--not	
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T888_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T810_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T818_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T835(userType);// s
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T834(userType);// s
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T839(userType);// s	
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T965(userType);

	}

	@Test(priority = 11)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyLogin_P2_part2(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T884_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T886_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T947(userType);				
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T958(userType);			
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T963(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T972(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T921(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T924(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T925(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T926(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T902_T931_T932(userType);			
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T919(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T894_T898(userType);				
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T928(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T1010(userType);				
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T889(userType); 
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T900(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T880_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T879_P2(userType);				
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T877_P2(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T874_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T872_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T873_P2(userType);
		//total--61
		//Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T1593_P2(userType);
		//Zee5ApplicasterHipiNeoBusinessLogic.LoginOrSignupScreen_T875_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Login_SignupScreen_T960(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.LoginSignupScreen_T981(userType);

	}




	@Test(priority = 12)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Creator_Screen_part1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T703_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T694_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T692_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T620_P2(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T507(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T567(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T594(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T595(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T569(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T590(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T589(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T564(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T501(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T577(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T585(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T602(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T524_P2(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T528_P2(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T530_P2(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T596_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T573(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T503(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T607_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T695_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T578(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T608(userType);// big Dbt	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T665_P2(userType);//--hold	
		//Zee5ApplicasterHipiNeoBusinessLogic.Creator_T560(userType);//hold
		//Zee5ApplicasterHipiNeoBusinessLogic.Creator_T621_P2(userType);//hold

	}




	@Test(priority = 13)
	@Parameters({ "userType", "InstallBuild" })
	public void Verify_Creator_Screen_Part2(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T645(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T643(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T631(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T632(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T633(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T634(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T635(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T636(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T637(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T639(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T617(userType);			
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T502_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_Video_Speed_T518_P2_(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_Video_Speed_T519_P2_(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_Video_Speed_T520_P2_(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_Video_Speed_T521_P2_(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_Video_Speed_T522_P2_(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T571_P2(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T622(userType);		
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T626(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T627(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T628(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T653(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T638(userType);	
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T693(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Creator_T697(userType);//55

		//total-55
		//(T567)--this tc is not tc sheet
	}	



	@Test(priority = 14)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyProfilePage_P2(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);	

		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1122(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1132(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1136(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1141(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1138(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1139(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1146(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1147(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1211_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1180_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1183_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1188_T1192_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1196_T1199_T1203_T1207_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1198_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1172_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1171_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1168_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1166_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1161_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1159_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1156_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1157_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1154_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1083_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1105_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1106_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1111_T1119_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_1110_T1118_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1155_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1056(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1065(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1068(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1070(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1079(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1076(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1061(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1066(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1084(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1088_T1113(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1092(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1089_T1114(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1091_T1116(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1112(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1149(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1148(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1145(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1144(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1169(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Profile_T1170(userType);	
		//total---58

	}	
	


	@Test(priority = 15)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifySettingsAndPrivacy_P2(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T705_P2(userType);						
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T752_P2(userType);					
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T765_P2(userType);						
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T720_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T722_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T721_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T723_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T724_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T725_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T726_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T727_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T728_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T729_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T730_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T753_P2(userType);						
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T766_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingAndPrivacy_T769_P2(userType);

		// total---17
	}
*/	



	@Test(priority = 16)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyEffectAndFilterDetailScreen_P2(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild,"Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.verifyEffectDetailScreen_T1899_T1909_P2(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.verifyFilterDetailScreen_T1900_T1910_P2(userType);//4

	}


	@Test(priority = 17)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyDetailScreen_P1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.DetailScreen_T1934_T1935(userType);//2


	}

	@Test(priority = 18)
	@Parameters({ "userType", "InstallBuild" })
	public void SettingAndPrivacy_P1(String userType, String InstallBuild) throws Exception {

		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1725(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1726(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1727(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1728(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1729(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1730(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.SettingsAndPrivacy_T1732(userType);//7
	}	


	@Test(priority = 19)
	@Parameters({ "userType", "InstallBuild" })
	public void VerifyDiscover_P1(String userType, String InstallBuild) throws Exception {
		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);

		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1890(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1891(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1892(userType);
		Zee5ApplicasterHipiNeoBusinessLogic.Discover_T1893(userType);//4
	}

/*
//	@Test(priority = 20)
//	@Parameters({ "userType", "InstallBuild" })
//	public void HybridModule_P2(String userType, String InstallBuild) throws Exception {
//		Zee5ApplicasterHipiNeoBusinessLogic.relaunch(InstallBuild, "Yes");
//		Zee5ApplicasterHipiNeoBusinessLogic.LoginAndNivigateToHipi(userType);
//
//		Zee5ApplicasterHipiNeoBusinessLogic.UserProfile_T1908(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.SoundDetails_T1896_T1906(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.ProfileDetails_1898(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.MyProfile_T1911_P2(userType);
//		Zee5ApplicasterHipiNeoBusinessLogic.HashTagDetail_T1897_T1907_P2(userType);//7
//
//	}
*/

	@AfterClass
	public void tearDownApp() {
		System.out.println("Quit the App");
		Zee5ApplicasterHipiNeoBusinessLogic.tearDown();
	}

}
