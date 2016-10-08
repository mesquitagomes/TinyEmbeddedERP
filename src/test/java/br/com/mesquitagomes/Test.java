package test.java.br.com.mesquitagomes;

public class Test {

	public static void main(String[] args) {

		String test = "%123%";
		System.out.println(test.contains("%"));
		test = test.replaceAll("%", "");
		System.out.println(test);

	}

}
