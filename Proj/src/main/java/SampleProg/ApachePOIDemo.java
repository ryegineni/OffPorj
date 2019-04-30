package SampleProg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOIDemo {
	private static XSSFSheet sheet1;
	private static XSSFWorkbook workbook1;
	private static XSSFCell cell1;
	private static XSSFRow row1;

	private static XSSFSheet sheet2;
	private static XSSFWorkbook workbook2;
	private static XSSFCell cell2;
	private static XSSFRow row2;

	private static XSSFWorkbook workbook3;
	private static XSSFSheet sheet3;
	private static XSSFCell cell3;
	private static XSSFRow row3;
	

	public static String getCellData1(int RowNum, int ColNum) throws Exception {
		System.out.println("POI Demmo");

		try {

			cell1 = sheet1.getRow(RowNum).getCell(ColNum);
			String CellData = cell1.getRawValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}

	}

	public static String getCellData2(int RowNum, int ColNum) throws Exception {

		try {

			cell2 = sheet2.getRow(RowNum).getCell(ColNum);
			String CellData = cell2.getRawValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}

	}

	public static void setCellData(String Result, int RowNum, int ColNum,FileInputStream inputStream1  ) throws Exception {

		try {

			row1 = sheet1.getRow(RowNum);
			cell1 = row1.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (cell1 == null) {
				//cell1 = row1.createCell(ColNum);
				cell1.setCellValue(Result);
			} else {
				cell1.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\ravikanth.yegineni\\Desktop\\Sample1.xlsx");
			workbook1.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);

		}

		/* int rowCnt = sheet1.getLastRowNum();
		    try{
		        for(int i = 1; i <= rowCnt; i++){
		            XSSFRow r = sheet1.getRow(i);
		            int res = i;
		            Cell cell = null;
		            if(cell == null){
		                cell = r.createCell(5);
		                cell.setCellType(Cell.CELL_TYPE_STRING);
		                cell.setCellValue("f" + res);
		            }
		        }
		    }catch(Exception e){
		        e.printStackTrace();
		    }finally{
		        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\gotpist1\\Desktop\\SRBNOI.xlsx"));
		        workbook1.write(out);
		        out.close();
		        inputStream1.close();
		        System.out.println("done");
		    }
		*/
		
	}
	
	/*public void setData(){
		row1 = sheet1.getRow(i);
		cell1 = row1.getCell(j, Row.RETURN_BLANK_AS_NULL);

		if (cell1 == null) {
			//cell1 = row1.createCell(ColNum);
			cell1.setCellValue("Diff");
		} else {
			cell1.setCellValue("Diff");
		}
		 fileOut = new FileOutputStream("C:\\Users\\ravikanth.yegineni\\Desktop\\Sample1.xlsx");
		workbook1.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
*/
	public static void main(String[] args) throws Exception {
		FileInputStream inputStream1 = new FileInputStream("C:\\Users\\ravikanth.yegineni\\Desktop\\Sample1.xlsx");
		FileInputStream inputStream2 = new FileInputStream("C:\\Users\\ravikanth.yegineni\\Desktop\\Sample2.xlsx");
		// FileOutputStream inputStream3 = new
		// FileOutputStream("C:\\Users\\ravikanth.yegineni\\Desktop\\Sample1.xlsx");
		FileOutputStream fileOut =null;

		workbook1 = new XSSFWorkbook(inputStream1);
		sheet1 = workbook1.getSheetAt(0);
		int rowCount1 = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
		System.out.println("row count" + rowCount1);

		workbook2 = new XSSFWorkbook(inputStream2);
		sheet2 = workbook2.getSheetAt(0);
		int rowCount2 = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
		System.out.println("row count" + rowCount2);

		// workbook3=new XSSFWorkbook(inputStream3);
		// sheet3 = workbook3.getSheetAt(0);

		List<Integer> rowNo=new ArrayList<Integer>();
		List<Integer> colNo=new ArrayList<Integer>();
		List<String> data=new ArrayList<String>();
		for (int i = 0; i <= rowCount1; i++) {
			row1 = sheet1.getRow(i);
			row2 = sheet2.getRow(i);

			for (int j = 0; j < row1.getLastCellNum(); j++) {
				String data1 = getCellData1(i, j);
				String data2 = getCellData2(i, j);

				System.out.println("Cell value(" + i + "," + j + ")" + data1);
				System.out.println("Cell value(" + i + "," + j + ")" + data2);
				

				if (data1.equalsIgnoreCase(data2)) {
					System.out.println("Yes");
					//setCellData(data1, i, j,inputStream1);
				} else {
					System.out.println("No");
					System.out.println("Difference in cell value=("+  i + "," + j + ")");
					//setCellData("Difference", i, j,inputStream1);
					rowNo.add(i);
					colNo.add(j);
					data.add(data1);

				}
			}
			

		}
		
		System.out.println(rowNo);
		System.out.println(colNo);
		System.out.println(data);
		
		
		 // Create a Font for styling header cells
        Font headerFont = workbook1.createFont();
        headerFont.setBoldweight((short) 0);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook1.createCellStyle();
        headerCellStyle.setFont(headerFont);
        for(int i = 0; i < rowNo.size(); i++) {
           // Cell cell = headerRow.createCell(i);
        	//int row=rowNo.get(i);
        	
        	System.out.println("Row no="+rowNo.get(i));
        	System.out.println("Col no="+colNo.get(i));
        	row1 = sheet1.getRow(rowNo.get(i));
    		cell1 = row1.getCell(colNo.get(i));

            cell1.setCellValue(data.get(i));
            cell1.setCellStyle(headerCellStyle);
           
    		
        }
        fileOut = new FileOutputStream("C:\\Users\\ravikanth.yegineni\\Desktop\\Sample1.xlsx");
 		workbook1.write(fileOut);
        fileOut.flush();
		fileOut.close();

			
	}

}
