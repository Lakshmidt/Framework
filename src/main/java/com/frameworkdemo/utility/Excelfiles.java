package com.frameworkdemo.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	//static public Excelfiles e=new Excelfiles();
	static FileInputStream fi;
	static FileOutputStream fo;
	static Workbook w;
	static Sheet s;
	static Row r;
	public void writedatabycreatingsheet(String excelfilename,String sheetname,int row,int cell,String cellvalue) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		
		fi = new FileInputStream(gv.excel.getProperty(excelfilename));
		w=WorkbookFactory.create(fi);
		s=w.createSheet(sheetname);
		r=s.createRow(row);
		r.createCell(cell).setCellValue(cellvalue);
	}
	public void writedatabycreatingrow(String excelfilename,String sheetname,int row,int cell,String cellvalue) throws EncryptedDocumentException, InvalidFormatException, IOException
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
	public void writeData(String excelfilename,String sheetname,String tcid,String cellvalue) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		//init();
		System.out.println(gv.excel);
		System.out.println(gv.currentdir);
		System.out.println(gv.currentdir+gv.excel.getProperty(excelfilename));
		fi=new FileInputStream(gv.currentdir+gv.excel.getProperty(excelfilename));
		w=WorkbookFactory.create(fi);
		s=w.getSheet(gv.excel.getProperty(sheetname));
		for(int i=0;i<s.getPhysicalNumberOfRows();i++)
		{
			if(s.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(tcid))
				s.getRow(i).createCell(1).setCellValue(cellvalue);
		}
		fo=new FileOutputStream(gv.currentdir+gv.excel.getProperty(excelfilename));
		w.write(fo);
		fo.flush();
		fi.close();
		fo.close();
	}
	public void writeData(String excelFilenamekey,String sheetnamekey,String cellvalue,int cellindex) throws EncryptedDocumentException, IOException
	{
	
		fi=new FileInputStream(gv.currentdir+gv.excel.getProperty(excelFilenamekey));
		w=WorkbookFactory.create(fi);
		s=w.getSheet(gv.excel.getProperty(sheetnamekey));
		for(int i=0;;i++)
		{
			if(s.getRow(i)==null)
				r=s.createRow(i);
			else
				break;
		}
		r.createCell(cellindex).setCellValue(cellvalue);
		fo=new FileOutputStream(gv.currentdir+gv.excel.getProperty(excelFilenamekey));	
		w.write(fo);
		fo.flush();
		fo.close();
		fi.close();
	}
}
