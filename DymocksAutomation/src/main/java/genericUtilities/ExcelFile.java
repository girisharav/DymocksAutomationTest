/**
 * Contains Utilities for Dymocks Project
 */
package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author ManjuAnju
 *	Utilty file to Read data from excel file
 */
public class ExcelFile {

	public String getExcelData(String sheetName, int rowNum, int cellNum) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/DymocksExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		
		DataFormatter df = new DataFormatter();
		return df.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		
	}
}
