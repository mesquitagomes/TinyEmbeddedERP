package main.java.br.com.mesquitagomes.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE")
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	@Basic
	@Column(name = "type", length = 20, nullable = false)
	private String type;
	@Basic
	@Column(name = "ddi", nullable = false)
	private Integer ddi;
	@Basic
	@Column(name = "number", nullable = false)
	private Integer number;

	public enum PhoneColumn {

		ID("id"), PERSON("person_id"), TYPE("type"), DDI("ddi"), NUMBER("number");

		String name;

		PhoneColumn(String name) {
			this.name = name;
		}

		public String getName() {

			return name;
		}
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public Person getPerson() {

		return person;
	}

	public void setPerson(Person person) {

		this.person = person;
	}

	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public Integer getDdi() {

		return ddi;
	}

	public void setDdi(Integer ddi) {

		this.ddi = ddi;
	}

	public Integer getNumber() {

		return number;
	}

	public void setNumber(Integer number) {

		this.number = number;
	}

	public String toString() {

		return person + " " + type + " Phone id:[" + id + "] (" + ddi + ") " + number;
	}

}