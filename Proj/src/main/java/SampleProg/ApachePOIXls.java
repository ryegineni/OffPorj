package SampleProg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ApachePOIXls {

	private static HSSFSheet sheet1;
	private static HSSFWorkbook workbook1;
	private static HSSFCell cell1;
	private static HSSFRow row1;

	private static HSSFSheet sheet2;
	private static HSSFWorkbook workbook2;
	private static HSSFCell cell2;

	public static String cellValues(Cell cell) {
		String cellValue = null;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			cellValue = cell.getStringCellValue();
			break;

		case Cell.CELL_TYPE_FORMULA:
			cellValue = cell.getCellFormula();
			break;

		case Cell.CELL_TYPE_NUMERIC:
			cellValue = Double.toString(cell.getNumericCellValue());
			break;

		case Cell.CELL_TYPE_BLANK:
			cellValue = "";
			break;

		case Cell.CELL_TYPE_BOOLEAN:
			cellValue = Boolean.toString(cell.getBooleanCellValue());
			break;

		}
		return cellValue;
	}

	public static String getCellData1(int RowNum, int ColNum) throws Exception {

		try {
			// cell1.setCellType(Cell.CELL_TYPE_STRING);
			// int cellType = cell1.getCellType();
			// System.out.println("cell 1 type===========" + cellType);

			cell1 = sheet1.getRow(RowNum).getCell(ColNum);

			String CellData = cellValues(cell1);
			return CellData;
		} catch (Exception e) {
			return "";
		}

	}

	public static String getCellData2(int RowNum, int ColNum) throws Exception {

		try {
			// cell2.setCellType(Cell.CELL_TYPE_STRING);
			// int cellType = cell2.getCellType();
			// System.out.println("cell 2 type===========" + cellType);
			// cell2 = sheet2.getRow(RowNum).getCell(ColNum);
			// String CellData = cellValues(cell2);
			cell2 = sheet2.getRow(RowNum).getCell(ColNum);

			String CellData = cellValues(cell2);
			return CellData;
		} catch (Exception e) {
			return "";
		}

	}

	public static void main(String[] args) throws Exception {
		FileInputStream inputStream1 = new FileInputStream("C:\\Users\\ravikanth.yegineni\\Desktop\\Book1.xls");
		FileInputStream inputStream2 = new FileInputStream("C:\\Users\\ravikanth.yegineni\\Desktop\\Book2.xls");
		FileOutputStream fileOut = null;

		workbook1 = new HSSFWorkbook(inputStream1);
		sheet1 = workbook1.getSheetAt(0);
		int rowCount1 = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
		System.out.println("row count" + rowCount1);

		workbook2 = new HSSFWorkbook(inputStream2);
		sheet2 = workbook2.getSheetAt(0);
		int rowCount2 = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
		System.out.println("row count" + rowCount2);

		List<Integer> rowNo = new ArrayList<Integer>();
		List<Integer> colNo = new ArrayList<Integer>();
		List<String> data = new ArrayList<String>();
		for (int i = 0; i <= rowCount1; i++) {
			row1 = sheet1.getRow(i);
			sheet2.getRow(i);

			for (int j = 0; j < row1.getLastCellNum(); j++) {
				String data1 = getCellData1(i, j);
				String data2 = getCellData2(i, j);

				System.out.println("Cell value(" + i + "," + j + ")" + data1);
				System.out.println("Cell value(" + i + "," + j + ")" + data2);

				if (data1.equalsIgnoreCase(data2)) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
					System.out.println("Difference in cell value=(" + i + "," + j + ")");
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

		Font headerFont2 = workbook1.createFont();
		headerFont2.setBoldweight((short) 0);
		headerFont2.setFontHeightInPoints((short) 14);
		headerFont2.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook1.createCellStyle();
		headerCellStyle.setFont(headerFont);
		for (int i = 0; i < rowNo.size(); i++) {

			System.out.println("Row no=" + rowNo.get(i));
			System.out.println("Col no=" + colNo.get(i));
			row1 = sheet1.getRow(rowNo.get(i));
			cell1 = row1.getCell(colNo.get(i));
			if (!data.get(i).isEmpty()) {

				cell1.setCellValue(data.get(i));
				cell1.setCellStyle(headerCellStyle);
			} else {
				// cell1.setCellValue("null");
				cell1.setCellStyle(headerCellStyle);
			}

		}
		fileOut = new FileOutputStream("C:\\Users\\ravikanth.yegineni\\Desktop\\Book1.xls");
		workbook1.write(fileOut);
		fileOut.flush();
		fileOut.close();

	}

}
