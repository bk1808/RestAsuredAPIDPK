package com.backend.DataDrivenTesting.DPK;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class provide the data from excel file to execute API test scripts
 *  @author Praveen
 *  28-Jun-2024
 */

public class ExcelUtility {

	/**
	 * this method will provide the overall Cell count from the sheet
	 * @param sheet
	 * @param row
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getCellCount(String sheet) throws EncryptedDocumentException, IOException {

		FileInputStream fin = new FileInputStream("./src/test/resources/testData/APITestData.xlsx");

		Workbook wb = WorkbookFactory.create(fin);

		int cellNum = wb.getSheet(sheet).getRow(0).getLastCellNum();
		wb.close();
		return cellNum;

	}
	
	/**
	 * this method will provide the overall row count from the sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fin = new FileInputStream("./src/test/resources/testData/APITestData.xlsx");

		Workbook wb = WorkbookFactory.create(fin);

		int rowNum = wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return rowNum;

	}

	/**
	 * this method will fetch the data from excel file
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fin = new FileInputStream("./src/test/resources/testData/APITestData.xlsx");

		Workbook wb = WorkbookFactory.create(fin);
		
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		
		wb.close();
		return data;

	}

}
