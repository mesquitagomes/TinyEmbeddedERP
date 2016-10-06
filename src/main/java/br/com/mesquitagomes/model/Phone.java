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
public class Phone extends AbstractModel implements Serializable {

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

	public enum PhoneColumns {

		id(), person_id(), type(), ddi(), number();

	}

	public enum PhonePropertyChangeEnum {

		id(), person(), type(), ddi(), number();

	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		Integer oldValue = this.id;
		this.id = id;
		firePropertyChange(PhonePropertyChangeEnum.id.name(), oldValue, this.id);
	}

	public Person getPerson() {

		return person;
	}

	public void setPerson(Person person) {

		Person oldValue = this.person;
		this.person = person;
		firePropertyChange(PhonePropertyChangeEnum.person.name(), oldValue, this.person);
	}

	public String getType() {

		return type;
	}

	public void setType(String type) {

		String oldValue = this.type;
		this.type = type;
		firePropertyChange(PhonePropertyChangeEnum.type.name(), oldValue, this.type);
	}

	public Integer getDdi() {

		return ddi;
	}

	public void setDdi(Integer ddi) {

		Integer oldValue = this.ddi;
		this.ddi = ddi;
		firePropertyChange(PhonePropertyChangeEnum.ddi.name(), oldValue, this.ddi);
	}

	public Integer getNumber() {

		return number;
	}

	public void setNumber(Integer number) {

		Integer oldValue = this.number;
		this.number = number;
		firePropertyChange(PhonePropertyChangeEnum.number.name(), oldValue, this.number);
	}

	public String toString() {

		return type + " Phone id:[" + id + "] (" + ddi + ") " + number;
	}

}
