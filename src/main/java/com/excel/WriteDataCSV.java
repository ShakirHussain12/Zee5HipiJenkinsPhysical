package com.excel;

import java.awt.FontFormatException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.math3.optim.nonlinear.scalar.LineSearch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.utils.Reader;
import com.csvreader.CsvWriter;
import com.extent.ExtentReporter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.opencsv.CSVWriter;
//import com.spire.pdf.graphics.LineInfo;
import java.awt.FontFormatException;

public class WriteDataCSV {

	private static String currentDate;
	private static String currentTime;
	public static Date date = new Date();

	public static String  PresentDate() {
		DateFormat dateFormat  = new SimpleDateFormat("dd/MM/yyyy");

		currentDate = dateFormat.format(date).toString().replaceFirst(" ", "_").replaceAll("/", "_").replaceAll(":",
				"_");
		return currentDate;
	}	
	public static String  CurrentTime() {
		DateFormat dateFormat  = new SimpleDateFormat("HH:mm:ss");

		currentTime = dateFormat.format(date).toString().replaceFirst(" ", "_").replaceAll("/", "_").replaceAll(":",
				"_");
		return currentTime;
	}	

	public static   String time()  {
		SimpleDateFormat simple= new SimpleDateFormat("HH:mm:ss");
		String dateString = simple.format(date).toString().replaceAll(":", "_");;
		return dateString;
	}	



	static final String xlpath2 = System.getProperty("user.dir") + "/Description_Data"+"/"+ "TextData" +".txt";
//	static final String file2 = "file2.txt";

//	public static String xlpath2 = System.getProperty("user.dir") + "/Description_Data"+"/"+ "TextData" +".txt";
	

	static BufferedReader b1 = null;
	static BufferedWriter b2 = null;


	

	public static void creatCSV(String description,String UDID,String Username) throws IOException {

	List list_file1 = new ArrayList();

	    String lineText ;
	    Path path = Paths.get(xlpath2);
		String content = null;
		 try {
			 List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
	            content = String.join(System.lineSeparator(), lines);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
//		System.out.println(content);
		
		boolean areEqual = true;
		
		
		
		while (content !=null) {
			
			if (content.contains(description + "," + Username + "," + UDID  + ",")) {
				System.out.println("Fail");
				areEqual = false;
				
				
			}else {
				System.out.println("Pass");
				areEqual = true;
				break;
			}
			
			
		}
	
		System.out.println(description + "," + Username + "," + UDID + ",");

		try {
//			File dir = new File(System.getProperty("user.dir") + "\\Analysed_Reports");
			File dir = new File(System.getProperty("user.dir") + "/Description_Data"+"/");
			System.out.println("===creating Excel");
			
			if (!dir.isDirectory()) {
				dir.mkdir();
			}
			FileWriter file = new FileWriter(xlpath2,true);
			BufferedWriter br = new BufferedWriter(file);
			br.write("\n");
			br.write(description+ ",");
			br.write(Username+ ",");
			br.write(UDID+ ",");					
			br.flush();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			}
	}			
	
	public   void reader() throws IOException {
		
		FileReader reader = new FileReader(xlpath2);
		BufferedReader dr1 = new BufferedReader(reader);
		String line;
		while ((line=dr1.readLine()) !=null) {
			
			System.out.println(line);
		}
//		while((ch=reader.read()) !=-1) {
//			System.out.println(ch);
//		}
		reader.close();  
		
	}
	

	
	public static void main(String[] args) throws IOException {
		creatCSV("fsdsf", "fsfs", "vcvcv");
	}


}
