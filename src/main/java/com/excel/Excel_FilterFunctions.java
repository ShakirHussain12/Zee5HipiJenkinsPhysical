package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.AutoFilter;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFAutoFilter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;

//import com.spire.xls.Workbook;
//import com.spire.xls.Worksheet;
//import com.spire.xls.collections.AutoFiltersCollection;


public class Excel_FilterFunctions {
	
	
	static String path=System.getProperty("user.dir");
	
	  static String excelpath=path+"\\Analysed_Reports\\08_08_2022\\14_39_10.xlsx";
	
	
	public static int getrowcount() throws Exception {
		int k;
		FileInputStream fis = new FileInputStream(new File(excelpath));
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet= wb.getSheet("Analysed_Reports");
		System.out.println(sheet.getLastRowNum());
		return  k=sheet.getLastRowNum();
		
		
		
		
	}
	
	private static void copyRow(HSSFWorkbook workbook, HSSFSheet worksheet, int sourceRowNum, int destinationRowNum) {
	    // Get the source / new row
	    HSSFRow newRow = worksheet.getRow(destinationRowNum);
	    HSSFRow sourceRow = worksheet.getRow(sourceRowNum);

	    // If the row exist in destination, push down all rows by 1 else create a new row
	    if (newRow != null) {
	        worksheet.shiftRows(destinationRowNum, worksheet.getLastRowNum(), 1);
	    } else {
	        newRow = worksheet.createRow(destinationRowNum);
	    }

	    // Loop through source columns to add to new row
	    for (int i = 0; i < sourceRow.getLastCellNum(); i++) {
	        // Grab a copy of the old/new cell
	        HSSFCell oldCell = sourceRow.getCell(i);
	        HSSFCell newCell = newRow.createCell(i);

	        // If the old cell is null jump to next cell
	        if (oldCell == null) {
	            newCell = null;
	            continue;
	        }

	        // Copy style from old cell and apply to new cell
	        HSSFCellStyle newCellStyle = workbook.createCellStyle();
	        newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
	        ;
	        newCell.setCellStyle(newCellStyle);

	        // If there is a cell comment, copy
	        if (oldCell.getCellComment() != null) {
	            newCell.setCellComment(oldCell.getCellComment());
	        }

	        // If there is a cell hyperlink, copy
	        if (oldCell.getHyperlink() != null) {
	            newCell.setHyperlink(oldCell.getHyperlink());
	        }

	        // Set the cell data type
	        newCell.setCellType(oldCell.getCellType());

	        // Set the cell data value
//	        switch (oldCell.getCellType()) {
//	            case Cell.CELL_TYPE_BLANK:
//	                newCell.setCellValue(oldCell.getStringCellValue());
//	                break;
//	            case Cell.CELL_TYPE_BOOLEAN:
//	                newCell.setCellValue(oldCell.getBooleanCellValue());
//	                break;
//	            case Cell.CELL_TYPE_ERROR:
//	                newCell.setCellErrorValue(oldCell.getErrorCellValue());
//	                break;
//	            case Cell.CELL_TYPE_FORMULA:
//	                newCell.setCellFormula(oldCell.getCellFormula());
//	                break;  
//	            case Cell.CELL_TYPE_NUMERIC:
//	                newCell.setCellValue(oldCell.getNumericCellValue());
//	                break;
//	            case Cell.CELL_TYPE_STRING:
//	                newCell.setCellValue(oldCell.getRichStringCellValue());
//	                break;
//	        }
	    }
	}
	
	
	public static void copyLinesFromExcels() throws Exception {
		 HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("c:/input.xls"));
		    HSSFSheet sheet = workbook.getSheet("Sheet1");
		    copyRow(workbook, sheet, 0, 1);
		    FileOutputStream out = new FileOutputStream("c:/output.xls");
		    workbook.write(out);
		    out.close();
	}
	
	
	// Generic method to return the column values in the sheet.
			public static String getCellValue(String xlPath, String sheet, int row, int col) {
				String data = "";
				try {
					XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(xlPath));
					XSSFSheet myExcelSheet = myExcelBook.getSheet(sheet);
					data = myExcelSheet.getRow(row).getCell(col).toString();
				}
				catch (Exception e) {
//					System.out.println(e);
				}
				return data;
			}
	
	public static void main(String[] args) throws Exception {
		System.out.println(ExcelFunctions.getCellValue(excelpath,"Analysed_Reports", getrowcount(), 4));
		System.out.println(ExcelFunctions.getCellValue(excelpath,"Analysed_Reports", getrowcount(), 1));
		System.out.println(path);
		System.out.println(getrowcount());
		System.out.println(getTCidCell(excelpath,"Analysed_Reports", 1));
		//autoFilter();
	}
	
	
	public static String  getTCidCell(String xlPath, String sheet, int col) {
		String data="";
		
		try {
			for(int i=getrowcount();i>0;i--) {
				data=getCellValue(xlPath, sheet, i, col);
				//System.out.println(data);
				if(data.equals("")) {
					
				}else {
				System.out.println(data);
				break;
				
				}
				
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
//	public static void autoFilter() throws Exception {
//		//FileInputStream fis = new FileInputStream(new File(excelpath));
//		Workbook wb= new Workbook();
//		 wb.loadFromFile(excelpath);
//		 
//		 Worksheet sheet = wb.getWorksheets().get(0);
//			int k= sheet.getLastRow();
//			int l=sheet.getLastColumn();
//		//Get the AutoFiltersCollection object
//		 AutoFiltersCollection filters = sheet.getAutoFilters();
//		 //Set the cell range where the filters will be added
//		 //sheet.FirstRow, sheet.FirstColumn, sheet.LastRow, 2
//		 filters.setRange(sheet.getCellRange(1,1,k,l));
//		 //Add a color filter to the first column of the selected range and set the filter criteria, that is, the background color of cell B4
//		// filters.addFillColorFilter(0, sheet.getCellRange("B4").getStyle().getColor());
//		 //Execute filter function
//		 
//		 filters.filter();
//		 
//		 filters.addFilter(7, "Fail");
//		//Execute filter function
//		filters.filter();
//		//Save to file
//		wb.saveToFile("TextFilter.xlsx");
//		 
//		 
//		
//		
////		AutoFiltersCollection filters = sheet.getAutoFilters();	
////				FileOutputStream out = new FileOutputStream("AutoFilterSetTest.xlsx");
////		  wb.write(out);
////		  out.close();
////		  wb.close();
//		  //XSSFAutoFilter filter=sheet.fi
//		  
//				
//	}
	
//	private static void setCriteriaFilter(XSSFSheet sheet, int colId, int firstRow, int lastRow, String[] criteria) throws Exception {
//		  CTAutoFilter ctAutoFilter = sheet.getCTWorksheet().getAutoFilter();
//		  ctFilterColumn ctFilterColumn = null;
//		  for (CTFilterColumn filterColumn : ctAutoFilter.getFilterColumnList()) {
//		   if (filterColumn.getColId() == colId) ctFilterColumn = filterColumn;
//		  }
//		  if (ctFilterColumn == null) ctFilterColumn = ctAutoFilter.addNewFilterColumn();
//		  ctFilterColumn.setColId(colId);
//		  if (ctFilterColumn.isSetFilters()) ctFilterColumn.unsetFilters();
//
//		  CTFilters ctFilters = ctFilterColumn.addNewFilters();
//		  for (int i = 0; i < criteria.length; i++) {
//		   ctFilters.addNewFilter().setVal(criteria[i]);
//		  }
//
//		  //hiding the rows not matching the criterias
//		  DataFormatter dataformatter = new DataFormatter();
//		  for (int r = firstRow; r <= lastRow; r++) {
//		   XSSFRow row = sheet.getRow(r);
//		   boolean hidden = true;
//		   for (int i = 0; i < criteria.length; i++) {
//			    String cellValue = dataformatter.formatCellValue(row.getCell(colId));
//			    if (criteria[i].equals(cellValue)) hidden = false;
//			   }
//			   if (hidden) {
//			    row.getCTRow().setHidden(hidden);
//			   } else {
//			    if (row.getCTRow().getHidden()) row.getCTRow().unsetHidden();
//			   }
//			  }
//			 }

}
