package myProject;

public class Testchufa {
	public static void main(String[] args) {
		int age = 4;
		int pageling =2;
		int pageCount = 0;
		if(age%pageling==0)
		{
			pageCount = age/pageling;
		}else
		{
			pageCount = age/pageling+1;
		}
		System.out.println(pageCount);
	}
}
