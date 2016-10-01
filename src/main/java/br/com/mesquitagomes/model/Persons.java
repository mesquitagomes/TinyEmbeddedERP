package main.java.br.com.mesquitagomes.model;

import java.util.ArrayList;
import java.util.List;

public class Persons extends AbstractModel {

	protected List<Person> persons = new ArrayList<Person>();

	public List<Person> getPersons() {

		return persons;
	}

	public void setPersons(List<Person> persons) {

		List<Person> oldValue = this.persons;
		this.persons = new ArrayList<Person>(persons);
		firePropertyChange(getPropertyChangeName(), oldValue, this.persons);
	}

	public int getPersonsCount() {

		return persons.size();
	}

	public void addPerson(Person person) {

		List<Person> oldValue = persons;
		persons = new ArrayList<Person>(persons);
		persons.add(person);
		firePropertyChange(getPropertyChangeName(), oldValue, persons);
	}

	public void removePerson(Person person) {

		List<Person> oldValue = persons;
		persons = new ArrayList<Person>(persons);
		persons.remove(person);
		firePropertyChange(getPropertyChangeName(), oldValue, persons);
	}

	public String getPropertyChangeName() {

		return "persons";
	}

}
