package main.java.br.com.mesquitagomes.model.validation;

import java.util.List;

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

}
