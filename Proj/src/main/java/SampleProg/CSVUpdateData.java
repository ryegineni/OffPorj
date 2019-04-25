package SampleProg;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVUpdateData {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File inputFile = new File("C:\\Users\\ravikanth.yegineni\\Desktop\\Book1.csv");

		// Read existing file
		CSVReader reader = new CSVReader(new FileReader(inputFile));
		List<String[]> csvBody = reader.readAll();
		// get CSV row column and replace with by using row and column
		for (int i = 1; i < csvBody.size(); i++) {
			String[] strArray = csvBody.get(i);
			for (int j = 1; j < strArray.length; j++) {
				if (!strArray[j].equalsIgnoreCase("Update_date")) {
					csvBody.get(i)[j] = "Updated_date";
				}
			}
		}
		reader.close();

		// Write to CSV file which is open
		File rename = new File("C:\\Users\\ravikanth.yegineni\\Desktop\\Book1.csv");
		CSVWriter writer = new CSVWriter(new FileWriter(rename, inputFile.renameTo(rename)));
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
	}

}
