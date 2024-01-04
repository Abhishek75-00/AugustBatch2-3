package utilityPac;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass {

	public static void capturesnap(WebDriver driver,int testid,String MethodName) throws Exception {
	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss");
		Date date= new Date();
		String DateTime=sdf.format(date);
		
		String ScreenSnap=DateTime+" "+testid+" "+MethodName;
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest=".\\test-output\\ScreenShots\\"+ScreenSnap+".png";
		File destination=new File(dest);
		ImageIO.write(ImageIO.read(source), "png", destination);
	
}
	private static final String FILE_NAME="src/main/resources/TestData/ExcelDataAugustBAtch23.xlsx";
	
	
	public static String FetchData(String sheetname, int row ,int cell) {
		
		String data=null;
		FileInputStream file=null;
		Workbook workbook=null;
		
		
		try {
			
			file=new FileInputStream(FILE_NAME);
			workbook=new XSSFWorkbook(file);
			Sheet sheet=workbook.getSheet(sheetname);
			Row rowobj=sheet.getRow(row);
			Cell cellobj=rowobj.getCell(cell);
			data=cellobj.getStringCellValue();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(data!=null) {
					file.close();
				}
				if(file!=null) {
					file.close();
				}
				if(file!=null) {
					file.close();
				}}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			return data;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
