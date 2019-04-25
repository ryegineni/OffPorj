package SampleProg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVFileDelete {

	public static void main(String[] args) throws IOException, InterruptedException {
		// List<String> s=getColData(1,2);
		List<String> colData = new ArrayList<String>();

		try {

			String filereader = "C:\\Users\\ravikanth.yegineni\\Desktop\\Book1.csv";
			@SuppressWarnings("resource")
			CSVReader reader = new CSVReader(new FileReader(filereader));
			List<String[]> csvBody = reader.readAll();
			System.out.println("size=" + csvBody.size());
			int j = 2;
			for (int i = 1; i < csvBody.size(); i++) {
				colData.add(csvBody.get(0)[j]);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(2000);
		try {
			File file = new File("C:\\Users\\ravikanth.yegineni\\Desktop\\Book1.csv");
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
