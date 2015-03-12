package myProject;

import java.text.DecimalFormat;

public class TestNew {
	public static void main(String[] args) {
		double d = 1234567;
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		System.out.println(decimalFormat.format(d));
	}
}
