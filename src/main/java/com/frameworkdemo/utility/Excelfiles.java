package com.frameworkdemo.utility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.frameworkdemo.generics.Base;

public class Excelfiles extends Base{
	static FileInputStream fi;
	static Workbook w;
	static Sheet s;
	static Row r;
	Properties p=new Properties();
	
	public void writedatabycreatingsheet(String excelfilename,String sheetname,int row,int cell,String cellvalue) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		
		fi = new FileInputStream(gv.excel.getProperty(excelfilename));
		w=WorkbookFactory.create(fi);
		s=w.createSheet(sheetname);
		r=s.createRow(row);
		r.createCell(cell).setCellValue(cellvalue);
	}
	public void writedataby(String excelfilename,String sheetname,int row,int cell,String cellvalue) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		fi = new FileInputStream(gv.excel.getProperty(excelfilename));
		w=WorkbookFactory.create(fi);
		s=w.getSheet(sheetname);
		r=s.createRow(row);
		r.createCell(cell).setCellValue(cellvalue);
	}
	public String readdata(String excelfilename,String sheetname,int row,int cell) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		fi = new FileInputStream(gv.excel.getProperty(excelfilename));
		w=WorkbookFactory.create(fi);
		s=w.getSheet(sheetname);
		r=s.getRow(row);
		return r.getCell(cell).getStringCellValue();
	}
	public void readData(String excelfilename,String sheetname,int numrows,int numcell) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		fi = new FileInputStream(gv.excel.getProperty(excelfilename));
		w=WorkbookFactory.create(fi);
		s=w.getSheet(sheetname);
		for(int i=0;i<=numrows;i++)
		{
			r=s.getRow(i);
			for(int j=0;j<=numcell;j++)
			{
				System.out.println(r.getCell(j).getStringCellValue());
			}
		}
	}
	public String readDatafromexcel(String excelfilename,String sheetname,String tcid) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		fi = new FileInputStream(gv.excel.getProperty(excelfilename));
		w=WorkbookFactory.create(fi);
		s=w.getSheet(sheetname);
		int i=0;
		for(i=0;i<s.getLastRowNum();i++)
		{
			if(s.getRow(i).getCell(0).equals(tcid))
				break;
		}
		return s.getRow(i).getCell(1).getStringCellValue();
	}
}
