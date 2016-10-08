package main.java.br.com.mesquitagomes.model.validation;

import java.text.ParseException;
import java.util.List;

import javax.swing.text.MaskFormatter;

import main.java.br.com.mesquitagomes.model.Person;

public class PersonValidator extends Validator {

	public boolean supports(Class<?> cls) {

		return Person.class.equals(cls);
	}

	public void validate(Object obj, List<String> errors) {

		Person person = (Person) obj;

		if (person == null) errors.add("O objeto nulo.");

		if (person.getName() == null || person.getName().isEmpty()) errors.add("Nome nulo.");

	}

	public static MaskFormatter getCnpjMaskFormatter() {

		MaskFormatter maskFormatter = new MaskFormatter();
		try {
			maskFormatter.setMask("##.###.###/####-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return maskFormatter;
	}

	public static MaskFormatter getIeMaskFormatter() {

		MaskFormatter maskFormatter = new MaskFormatter();
		try {
			maskFormatter.setMask("##.###.###.###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return maskFormatter;
	}

	public static MaskFormatter getCpfMaskFormatter() {

		MaskFormatter maskFormatter = new MaskFormatter();
		try {
			maskFormatter.setMask("###.###.###.###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return maskFormatter;
	}

	public static MaskFormatter getRgMaskFormatter() {

		MaskFormatter maskFormatter = new MaskFormatter();
		try {
			maskFormatter.setMask("##.###.###.AAA");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return maskFormatter;
	}

}
