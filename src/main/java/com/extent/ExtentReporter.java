package com.extent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Stream;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.deviceDetails.DeviceDetails;
import com.driverInstance.DriverInstance;
import com.driverInstance.ExcelFunctions;
import com.emailReport.MailReport;
import com.excel.ExcelUpdate;

import com.excel.Time_ExcelUpdate;
import com.excel.WriteDataCSV;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;


import io.appium.java_client.AppiumDriver;

public class ExtentReporter implements ITestListener  {

	private static String report;
	private static String platform;
	public static ThreadLocal<ExtentReports> extent = new ThreadLocal<>();
	private static ThreadLocal<ExtentHtmlReporter> htmlReport = new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> childTest = new ThreadLocal<>();
	private static File src;
	public static String iosModel;
	public static String iosVersion;
	public  static String currentDate;
	private boolean runmode = true;
	private static String BrowserType;
	public static String filePath;
	public static String fileName;
	private static String AppVersion;
	public static ArrayList<String> mailBodyPart = new ArrayList<String>();

	/** The Constant logger. */
	static LoggingUtils logger = new LoggingUtils();

	@SuppressWarnings("static-access")
	public void setReport(String report) {
		this.report = report;
	}

	@SuppressWarnings("static-access")
	public String getReport() {
		return this.report;
	}

	@SuppressWarnings("static-access")
	public String getPlatform() {
		return this.platform;
	}

	@SuppressWarnings("static-access")
	public void setPlatform(String platform) {
		this.platform = platform; 
	}

	public String getPlatformFromtools() {
		return DriverInstance.getPlatform();
	}
	@SuppressWarnings("static-access")
	public String getAppVersion() {
		return this.AppVersion;
	}

	@SuppressWarnings("static-access")
	public void setAppVersion(String versionName) {
		this.AppVersion = versionName;
	}

	public static AppiumDriver<WebElement> getDriver() {
		return DriverInstance.tlDriver.get();
	}

	private WebDriver getWebDriver() {
		return DriverInstance.tlWebDriver.get();
	}

	

	
	
	public void initExtentDriver() {
		if (getPlatformFromtools().equals("Web")) {
			src = ((TakesScreenshot) getWebDriver()).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		} else if (getPlatformFromtools().equals("HIPI") ) {
			src = ((TakesScreenshot) getDriver()).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		}
		else if (getPlatformFromtools().equals("HIPI_iOS") ) {
			src = ((TakesScreenshot) getDriver()).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			
		} else if (getPlatformFromtools().equals("ANDROIDMPWA") ) {
			src = ((TakesScreenshot) getDriver()).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		}
	}
	
	

	@Override
	public void onStart(ITestContext context) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		currentDate = dateFormat.format(date).toString().replaceFirst(" ", "_").replaceAll("/", "_").replaceAll(":",
				"_");
		setReport(context.getName());
		setPlatform(context.getSuite().getName());
		appVersion();

		
		filePath = System.getProperty("user.dir") + "/Reports" + "/" + currentDate + "/" + getPlatform() + "/"
				+ context.getCurrentXmlTest().getParameter("userType") + "/" + context.getName() + "/"
				+ context.getCurrentXmlTest().getParameter("userType") + "_" + context.getName() + "_" + getAppVersion()
				+ "_" + getDate() + ".html";

		fileName = context.getCurrentXmlTest().getParameter("userType") + "_" + context.getName() + "_" + getAppVersion() + "_" + getDate() + ".html";

		htmlReport.set(new ExtentHtmlReporter(filePath));
		htmlReport.get().loadXMLConfig(new File(System.getProperty("user.dir") + "/ReportsConfig.xml"), true);
		extent.set(new ExtentReports());
		extent.get().attachReporter(htmlReport.get());
		BrowserType = context.getCurrentXmlTest().getParameter("browserType");
		ExcelUpdate.UserType = context.getCurrentXmlTest().getParameter("userType");
		
		if (!getPlatform().equals("Web")&&(!getPlatform().equals("HIPI_iOS"))) {
			DeviceDetails.getTheDeviceManufacturer();
			DeviceDetails.getTheDeviceOSVersion();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		
		System.out.println(DriverInstance.getRunModule());
		if ((Stream.of(result.getName(), "Suite").anyMatch(DriverInstance.getRunModule()::equals)
				&& DriverInstance.startTest) || result.getName().equals("Login")
				|| result.getName().equals("PWAWEBLogin")) {
			DriverInstance.methodName = result.getName();
			logger.info(":::::::::Test " + result.getName() + " Started::::::::");
//======================================new lines====================================================			
			 if (!getPlatformFromtools().equals("HIPI_iOS")) {
			test.set(extent.get().createTest(result.getName(),DriverInstance.getENvironment()
					+"<p>Build Version : "+getAppVersion().replace("Build", "")+"</p>"));
			 }else {
				 
				
				 test.set(extent.get().createTest(result.getName(),DriverInstance.getENvironment()
							+"<p>Build Version : "+DriverInstance.buildversion() +"</p>"));
				
					 
				 }
			 
//=======================================================================================================			 
			ExcelUpdate.ModuleName = result.getName();
			ExcelUpdate.creatExcel();
			Time_ExcelUpdate.creatExcel1();
			ExcelUpdate.passCounter = ExcelUpdate.failCounter = ExcelUpdate.warningCounter = 0;
		} else {
			runmode = false;
			throw new SkipException("");
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		screencapture();
		childTest.get().log(Status.PASS, result.getName() + " is PASSED");
		logger.info("::::::::::Test " + result.getName() + " PASSED::::::::::");
		mailBodyPart.add(result.getName()+","+ExcelUpdate.passCounter+","+ExcelUpdate.failCounter);
	}

	@Override
	public void onTestFailure(ITestResult result) { 
		screencapture();
		childTest.get().log(Status.FAIL, result.getName() + " is FAILED");
		logger.info("::::::::::Test " + result.getName() + " FAILED::::::::::");
		mailBodyPart.add(result.getName()+","+ExcelUpdate.passCounter+","+ExcelUpdate.failCounter);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if (runmode) {
			HeaderChildNode(result.getTestName());
			childTest.get().log(Status.SKIP, result.getName() + " is SKIPPED");
			logger.info("::::::::::Test " + result.getName() + " SKIPPED::::::::::");
			mailBodyPart.add(result.getName()+","+ExcelUpdate.passCounter+","+ExcelUpdate.failCounter);
		}
	}
	
	public static void HeaderChildNode(String header) {
		if (test.get() != null)
			childTest.set(test.get().createNode(header));
			ExcelUpdate.Node(header);
	}

//	public void extentLogger(String stepName, String details) {
//		childTest.get().log(Status.INFO, details);
//		ExcelUpdate.writeData(details, "Pass", "");
//	}
//	
//	public void extentLoggerPass(String stepName, String details) {
//		childTest.get().log(Status.PASS, details);
//		ExcelUpdate.writeData(details, "Pass", "");
//	}
//
//	public void extentLoggerFail(String stepName, String details) {
//		childTest.get().log(Status.FAIL, details);
//		screencapture();
//		ExcelUpdate.writeData("", "Fail", details);
//	}
//
//	public void extentLoggerWarning(String stepName, String details) {
//		childTest.get().log(Status.WARNING, details);
//		ExcelUpdate.writeData("", "Warning", details);
//	}
	public void extentLogger(String UDID, String details) throws IOException {
		childTest.get().log(Status.INFO, details);
		ExcelUpdate.writeData(details, "Pass", "");
		Time_ExcelUpdate.writeData1(details, "Pass", "");
//		WriteDataCSV.creatCSV(details,UDID);
	}
	public void extentLogger1(String UDID, String details,String userName) throws IOException {
		childTest.get().log(Status.INFO, details);
		ExcelUpdate.writeData(details, "Pass", "");
		Time_ExcelUpdate.writeData1(details, "Pass", "");
		
	}
	
	public void extentLoggerPass(String stepName, String details) {
		childTest.get().log(Status.PASS, details);
		ExcelUpdate.writeData(details, "Pass", "");
		
		Time_ExcelUpdate.writeData1(details, "Pass", "");
	}

//	public void extentLoggerFail(String stepName, String details) {
//		childTest.get().log(Status.FAIL, details);
//		screencapture();
//		ExcelUpdate.writeData("", "Fail", details);
//		Time_ExcelUpdate.writeData1(details, "Fail", "");
//	}
	// mail extent reports
				String[] to = { "prashantkumar.vairat@zee.com" };
				String[] cc = { "jwala.agrawal@zee.com" ,  "bindu.vm@igsindia.net" ,"shakir.muchumarri@igsindia.net"};
				String[] bcc = {};

		@SuppressWarnings("static-access")
		public void extentLoggerFail(String stepName, String details) {
			int k=ExcelFunctions.getRowCount(Time_ExcelUpdate.xlpath1, Time_ExcelUpdate.CurrentTime())-1;
			String TCid=ExcelFunctions.getTCidCell(Time_ExcelUpdate.xlpath1, Time_ExcelUpdate.CurrentTime(),1);
			//String TCid=ExcelFunctions.getCellValue(Time_ExcelUpdate.xlpath1, Time_ExcelUpdate.CurrentTime(),k , 1);
			String summarry=ExcelFunctions.getCellValue(Time_ExcelUpdate.xlpath1, Time_ExcelUpdate.CurrentTime(),k , 6);
			
			
			
//			int k=ExcelFunctions.getRowCount(ExcelUpdate.xlpath, "Analysed_Reports");
//			System.out.println(k);
//			String summarry=ExcelFunctions.getTCidCell(ExcelUpdate.xlpath, "Analysed_Reports",1);
			//System.out.println(TCid);
			//String TCid=ExcelFunctions.getCellValue(Time_ExcelUpdate.xlpath1, Time_ExcelUpdate.CurrentTime(),k , 1);
			//String summarry=ExcelFunctions.getCellValue(ExcelUpdate.xlpath, "Analysed_Reports",k , 4);
			System.out.println(summarry);
			System.out.println("==========================="+summarry+"===================================");
			childTest.get().log(Status.FAIL, details);
			screencapture();
			ExcelUpdate.writeData("", "Fail", details);
			Time_ExcelUpdate.writeData1(details, "Fail", "");
			MailReport mail=new MailReport();
			mail.sendMail("igsindiajenkins@gmail.com", "csoehouykebabvlc", "smtp.gmail.com", "587", "true", "true", true, "javax.net.ssl.SSLSocketFactory",
					"false", to, cc, bcc, "Hipi Android Automation Fail Alert",
					"TestCAse ID"," "+summarry );
//			SearchScenarios_ExcelUpdate.writeData1(details, "Fail", "");
		}
	public void extentLoggerWarning(String stepName, String details) {
		childTest.get().log(Status.WARNING, details);
		ExcelUpdate.writeData("", "Warning", details);
		Time_ExcelUpdate.writeData1(details, "warning", "");
	}
	@Override
	public void onFinish(ITestContext context) {
		if (!getPlatformFromtools().equals("Web")&&(!getPlatformFromtools().equals("HIPI_iOS"))){
			extent.get().setSystemInfo("Device Info ", DeviceDetails.DeviceInfo(context.getName()));
			extent.get().setSystemInfo("App version : ", getAppVersion().replace("Build", ""));
		} else if (getPlatformFromtools().equals("HIPI_iOS")) {
			extent.get().setSystemInfo("Device Name : ", iosModel);
			extent.get().setSystemInfo("OS Version : ", iosVersion);
		}else if (getPlatformFromtools().equals("Web")) {
			extent.get().setSystemInfo("Browser Name ", BrowserType);
//			extent.get().setSystemInfo("Browser Version ", BrowserType);
		}
		extent.get().flush();
		ExcelUpdate.updateResult();
		//SendEmail.EmailReport();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult context) {
	}

	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String name = dateFormat.format(date).toString().replaceFirst(" ", "_").replaceAll("/", "_").replaceAll(":","_");
		return name;
	}

	public void screencapture() {
		try {
			initExtentDriver();
			
			org.apache.commons.io.FileUtils.copyFile(src,
					new File(System.getProperty("user.dir") + "/Reports" + "/" + currentDate + "/" + getPlatform() + "/"
							+ Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
									.getParameter("userType")
							+ "/" + getReport() + "/Screenshots/" + getReport() + "_" + getDate() + ".jpg"));
			childTest.get().addScreenCaptureFromBase64String(base64Encode(src));
			logger.log(src, "Attachment");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String base64Encode(File file) {
		if (file == null || !file.isFile()) {
			return null;
		}
		try {
			@SuppressWarnings("resource")
			FileInputStream fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			if (fileInputStreamReader.read(bytes) != -1) {
				return "data:image/png;base64," + new String(Base64.getEncoder().encode(bytes), "UTF-8");
			}
			return null;
		} catch (Throwable e) {
			return null;
		}
	}

	public void appVersion() {
		if (getPlatform().equals("Android") || getPlatform().equals("HIPI") || getPlatform().equals("HIPI_iOS")) {
			PropertyFileReader handler = new PropertyFileReader("properties/AppPackageActivity.properties");
			setAppVersion("Build " + DeviceDetails.getAppVersion(handler.getproperty("zeePackage")).trim()
					.replace("versionName=", ""));
			logger.info(getAppVersion());
		}
		else {
			setAppVersion("");
		}
	}

	public static StringBuilder updateResult() {
		StringBuilder builder = new StringBuilder();
		if (mailBodyPart.size() > 0) {
			for (int i = 0; i < mailBodyPart.size(); i++) {
				String result[] = mailBodyPart.get(i).toString().split(",");
				System.out.println(result[0]+result[1]+result[2]);
				builder.append("        <tr>\r\n" + "          <td> " + result[0] + " </td>\r\n" + "          <td> "
						+ result[1] + " </td>\r\n" + "          <td> " + result[2] + " </td>\r\n"
						+ "        </tr>\r\n");
			}
			return builder;
		}else {
			return null;
		}
	}
	
	
}
