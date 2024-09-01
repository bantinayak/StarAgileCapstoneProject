package scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CustomData {

	public XSSFWorkbook wb;

	@DataProvider(name = "Excel")
	public Object[][] excelData() {
		File f1 = new File(System.getProperty("user.dir") + "\\testdata\\userDetail.xlsx");

		FileInputStream fis;
		Object arr[][] = null;
		try {
			fis = new FileInputStream(f1);
			wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("userdata");
			// Number of rows
			int row = sheet.getPhysicalNumberOfRows();
			int cell = sheet.getRow(0).getPhysicalNumberOfCells();

			arr = new Object[row][cell];

			for (int i = 1; i < row; i++) {
				for (int j = 0; j < cell; j++) {
					arr[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

				}

			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return arr;

	}
}
