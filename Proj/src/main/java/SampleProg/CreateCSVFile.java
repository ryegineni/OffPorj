package SampleProg;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CreateCSVFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CSVWriter csvWriter = new CSVWriter(new FileWriter(System.getProperty("user.dir") + "/csvFile/example.csv"));
		csvWriter.writeNext(new String[] { "1", "ravi" });
		csvWriter.writeNext(new String[] { "2", "kanth" });

		csvWriter.close();
		try {
			FileReader filereader = new FileReader(System.getProperty("user.dir") + "/csvFile/example.csv");

			@SuppressWarnings("resource")
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;

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
