package test.java.br.com.mesquitagomes.model;

import main.java.br.com.mesquitagomes.model.Person.PersonPropertyChangeEnum;

public class PersonTest {

	public static void main(String[] args) {

		System.out.println("valueOf(\"ID\"): " + PersonPropertyChangeEnum.valueOf("ID"));
		PersonPropertyChangeEnum[] personColumns = PersonPropertyChangeEnum.CNPJ.values();
		for (PersonPropertyChangeEnum personColumn : personColumns) {
			System.out.println(personColumn);
		}
	}

}
