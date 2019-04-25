package SampleProg;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVReadDemo {

	public static void main(String[] args) {

		// List<String> s=getColData(1,2);
		System.out.println(getColData(1, 2));
	}

	public static List<String> getColData(int row, int col) {
		List<String> colData = new ArrayList<String>();

		try {

			String filereader = "C:\\Users\\ravikanth.yegineni\\Desktop\\Book1.csv";
			@SuppressWarnings("resource")
			CSVReader reader = new CSVReader(new FileReader(filereader));
			List<String[]> csvBody = reader.readAll();
			System.out.println("size=" + csvBody.size());
			int j = col;
			for (int i = row; i < csvBody.size(); i++) {
				colData.add(csvBody.get(0)[j]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colData;

	}

}
