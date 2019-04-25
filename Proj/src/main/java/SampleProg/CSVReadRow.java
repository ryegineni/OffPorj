package SampleProg;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVReadRow {

	public static void main(String[] args) {

		// List<String> s=getColData(1,2);
		List<String> colData = new ArrayList<String>();

		try {

			String filereader = "C:\\Users\\ravikanth.yegineni\\Desktop\\Book1.csv";

			@SuppressWarnings("resource")
			CSVReader reader = new CSVReader(new FileReader(filereader));
			List<String[]> csvBody = reader.readAll();
			System.out.println("size=" + csvBody.size());
			for (int i = 0; i < csvBody.size(); i++) {
				// colData.add(csvBody.get(0)[i]);
				System.out.println(csvBody.get(0)[i]);
			}
			System.out.println("col data=" + colData);
		} catch (Exception e) {
		}
	}

}
