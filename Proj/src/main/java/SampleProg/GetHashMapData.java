package SampleProg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

public class GetHashMapData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * HashMap<String, String> hash=new HashMap<String,String>();
		 * hash.put("1", "str1"); hash.put("2", "str2"); hash.put("3", "str3");
		 * for ( Map.Entry<String, String> entry : hash.entrySet()) { String key
		 * = entry.getKey(); String tab = entry.getValue(); // do something with
		 * key and/or tab System.out.println("Key="+key);
		 * System.out.println("Value="+tab); }
		 */

		List<Integer> intList = new ArrayList<Integer>();

		intList.add(1);
		intList.add(3);
		intList.add(2);
		intList.add(4);
		intList.add(12);
		intList.add(7);

		List<Integer> intList2 = new ArrayList<Integer>();

		intList2.add(1);
		intList2.add(3);
		intList2.add(2);
		intList2.add(4);
		intList2.add(11);
		intList2.add(7);

		Collections.sort(intList);
		System.out.println("Array list" + intList);
		// for(int i=1;i<intList.size();i++){
		// if(intList.get(i-1)<=intList.get(i)){
		// System.out.println("I-1 value="+intList.get(i-1));
		// System.out.println("I value="+intList.get(i));
		// System.out.println("i value is big");
		// }
		//
		// }
		Assert.assertEquals(intList, intList2);
	}

}
