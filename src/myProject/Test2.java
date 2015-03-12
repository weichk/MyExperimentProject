package myProject;

public class Test2 {
	public static void main(String[] args) {
		String str1 = "2014-11-02 11:31:43.000";
		String str2 = "2014-11-01 11:31:44.000";
        double longstr1 = Double.valueOf(str1.replaceAll("[-\\s:]",""));
        double longstr2 = Double.valueOf(str2.replaceAll("[-\\s:]",""));
        System.out.println(longstr1);
		System.out.println(longstr1>longstr2);
	}
}
