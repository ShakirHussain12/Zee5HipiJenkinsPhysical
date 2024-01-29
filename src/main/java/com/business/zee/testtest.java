package com.business.zee;
import io.appium.java_client.ios.IOSDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class testtest {
	public static  String deviceUDID(String ConnectivityType) throws IOException{
		
		String line="";
		
		
		String[] Commands= {"idevice_id -"+ConnectivityType};
		
		//String[] Commands= {"idevice_id -n","ideviceinfo -n -k ProductType","ideviceinfo -n -k ProductVersion"};
	
int k=Commands.length;

for(int i=0;i<k;i++) {
        ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", "/usr/local/bin/"+Commands[i]);

        builder.redirectErrorStream(true);

        Process p = builder.start();

        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

       

        line = r.readLine();

        System.out.println(line);

       
}
return line;

    }
	
//public static  String ConnectedToNetworkDeviceUDID() throws IOException{
//		
//		String line="";
//		
//		
//		String[] Commands= {"idevice_id -n"};
//		
//		//String[] Commands= {"idevice_id -n","ideviceinfo -n -k ProductType","ideviceinfo -n -k ProductVersion"};
//	
//int k=Commands.length;
//
//for(int i=0;i<k;i++) {
//        ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", "/usr/local/bin/"+Commands[i]);
//
//        builder.redirectErrorStream(true);
//
//        Process p = builder.start();
//
//        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//
//       
//
//        line = r.readLine();
//
//        System.out.println(line);
//
//       
//}
//return line;
//
//    }
	
	
	public static String deviceName(String ConnectivityType) throws IOException {
		String cmd="ideviceinfo "+ConnectivityType+" -k ProductType";
		System.out.println(cmd);
		String deviceName=" ";
		 ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", "/usr/local/bin/"+cmd);

	        builder.redirectErrorStream(true);

	        Process p = builder.start();

	        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

	       

	        deviceName = r.readLine();

	        System.out.println(deviceName);
	        String []   deviceName1 = deviceName.split(",");
	        System.out.println(deviceName1[0]);
		
		return deviceName1[0];
		
	}
	
	
	public static String deviceVersion(String ConnectivityType) throws IOException {
		String cmd="ideviceinfo "+ConnectivityType+" -k ProductVersion";
		
		String deviceVersion=" ";
		 ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", "/usr/local/bin/"+cmd);

	        builder.redirectErrorStream(true);

	        Process p = builder.start();

	        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

	       

	        deviceVersion = r.readLine();

	        System.out.println(deviceVersion);
	       
		
		return deviceVersion;
		
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		//Process p = Runtime.getRuntime().exec("/bin/bash -c zsh");
//		IOSDriver driver;
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("platformName", "iOS");
//		capabilities.setCapability("platformVersion", "14.7.1");
//		capabilities.setCapability("deviceName", "iPhone 7");
//		//capabilities.setCapability("udid", "00008030-000A4922119A402E");
//		capabilities.setCapability("bundleId", "com.zee5.hipi");
//		capabilities.setCapability("updatedWDABundleId", "com.zee5.hipi");
//
//		driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
//		
//	
//		String[] cmd = {"mkdir", "test"};
//		Runtime.getRuntime().exec(cmd);
		deviceUDID("l");
		deviceName("");
		deviceVersion("");
		
		}
	}


