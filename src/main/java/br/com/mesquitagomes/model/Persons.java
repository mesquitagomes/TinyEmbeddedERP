package main.java.br.com.mesquitagomes.model;

import java.util.ArrayList;
import java.util.List;

public class Persons extends AbstractModel {

	protected List<Person> persons = new ArrayList<Person>();

	public enum PersonsPropertyChangeEnum {

		persons();

	}

	public List<Person> getPersons() {

		return persons;
	}

	public void setPersons(List<Person> persons) {

		List<Person> oldValue = this.persons;
		this.persons = new ArrayList<Person>(persons);
		firePropertyChange(PersonsPropertyChangeEnum.persons.name(), oldValue, this.persons);
	}

	public void addPerson(Person person) {

		List<Person> oldValue = persons;
		persons = new ArrayList<Person>(persons);
		persons.add(person);
		firePropertyChange(PersonsPropertyChangeEnum.persons.name(), oldValue, persons);
	}

	public void removePerson(Person person) {

		List<Person> oldValue = persons;
		persons = new ArrayList<Person>(persons);
		persons.remove(person);
		firePropertyChange(PersonsPropertyChangeEnum.persons.name(), oldValue, persons);
	}

	public Person getPerson(int index) {

		Person person = null;
		if (index >= 0 && index < persons.size()) person = persons.get(index);
		return person;
	}

	public int getPersonsCount() {

		return persons.size();
	}

}
