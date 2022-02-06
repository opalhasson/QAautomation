package Store;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ReadExcl {

	public static int rowCount;
	public static Sheet guru99Sheet;

	public void readExcel(String filePath,String fileName,String sheetName) throws IOException{


		File file =    new File(filePath+"//"+fileName);

		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));


		if(fileExtensionName.equals(".xls")) {
			guru99Workbook = new HSSFWorkbook(inputStream);
		}


		guru99Sheet = guru99Workbook.getSheet(sheetName);

		rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
	}



	public static int getRowcount(){
		return rowCount;}


	public static Sheet getsheet(){
		return guru99Sheet;}
}




