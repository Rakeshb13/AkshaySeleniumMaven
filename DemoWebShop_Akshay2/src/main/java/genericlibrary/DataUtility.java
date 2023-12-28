package genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility implements FrameworkConstants {
	
	FileInputStream fis;
	
	public String getDataFromProperties(String key) throws Exception
	{
		fis = new FileInputStream(properties_Path);
		Properties pobj=new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
	}
	
	public String getSingleDataFromExcel(String sheetName, int rowNum, int cellNum) throws Exception
	{
		fis = new FileInputStream(excel_Path);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet(sheetName);
//		DataFormatter format = new DataFormatter();
//		format.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
		return sheet.getRow(rowNum).getCell(cellNum).toString();
	}
	
	public Object[][] getAllDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excel_Path);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		
		int lastRowNum=sh.getPhysicalNumberOfRows();
		int lastCellNum=sh.getRow(0).getPhysicalNumberOfCells();
//		System.out.println(lastRowNum);
//		System.out.println(lastCellNum);
		
		Object [][] arr = new Object [lastRowNum-1][lastCellNum];
		
		for(int i = 1 ;i<lastRowNum;i++)
		{
			for(int j=0;j<lastCellNum;j++)
			{
				//System.out.print(sh.getRow(i).getCell(j).toString()+" ");
				arr[i-1][j]=sh.getRow(i).getCell(j).toString();
			}
			
		}
		return arr;
	}

}