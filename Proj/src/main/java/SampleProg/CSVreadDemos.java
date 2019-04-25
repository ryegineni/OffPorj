package SampleProg;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVreadDemos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			// Create an object of filereader
			// class with CSV file as a parameter.
			FileReader filereader = new FileReader("C:\\Users\\ravikanth.yegineni\\Desktop\\Book1.csv");

			// create csvReader object passing
			// file reader as a parameter
			// CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;

			// below commented code is to skip one line
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();

			/*
			 * for(String[] row:allData){ for (String cell : row) {
			 * System.out.print(cell + "\t"); } System.out.println(); }
			 */
			// we are going to read data line by line
			List<String> lines = new ArrayList<String>();
			while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {
					System.out.print(cell + "\t");

				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
