package SampleProg;

public class ReplaceAllChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="$  %100";
		str.replaceAll("([$,/s])", "");
		System.out.println(str);
		System.out.println(str.replaceAll("([$,/s])", ""));
		System.out.println(str.replaceAll("([$,%,/s])", ""));

	}

}
