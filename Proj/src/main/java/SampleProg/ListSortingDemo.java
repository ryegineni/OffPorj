package SampleProg;

import java.util.ArrayList;
import java.util.Collections;

public class ListSortingDemo {

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				ArrayList<String> arraylist = new ArrayList<String>();
				arraylist.add("10/12/2019");
				arraylist.add("11/11/2018");
				arraylist.add("NONE");
				arraylist.add("NONE");

				/* Unsorted List: ArrayList content before sorting */
				System.out.println("Before Sorting:");
				for (String str : arraylist) {
					System.out.println(str);
				}
				/* Sorting in acreasing order */
				Collections.sort(arraylist);
				
				System.out.println("ArrayList in ascending order:");
				for (String str : arraylist) {
					System.out.println(str);
				}
				/* Sorting in decreasing order */
				Collections.sort(arraylist, Collections.reverseOrder());
				System.out.println("ArrayList in descending order:");
				for (String str : arraylist) {
					System.out.println(str);
				}

			}


}
