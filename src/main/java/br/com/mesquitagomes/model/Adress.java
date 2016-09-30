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
@Table(name = "ADRESS")
public class Adress extends AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	@Basic
	@Column(name = "zipcode", nullable = false)
	private Integer zipcode;
	@Basic
	@Column(name = "adress", length = 200, nullable = false)
	private String adress;
	@Basic
	@Column(name = "number", nullable = false)
	private Integer number;
	@Basic
	@Column(name = "complement", length = 200, nullable = false)
	private String complement;
	@Basic
	@Column(name = "city", length = 100, nullable = false)
	private String city;
	@Basic
	@Column(name = "region", length = 100, nullable = false)
	private String region;
	@Basic
	@Column(name = "country", length = 100, nullable = false)
	private String country;

	public enum AdressColumns {

		ID("id"), PERSON("person_id"), ZIPCODE("zipcode"), ADRESS("adress"), NUMBER("number"), COMPLEMENT("complement"), CITY(
				"city"), REGION("region"), COUNTRY("country");

		private String name;

		AdressColumns(String name) {
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

		Integer oldValue = this.id;
		this.id = id;
		firePropertyChange(AdressColumns.ID.getName(), oldValue, this.id);
	}

	public Person getPerson() {

		return person;
	}

	public void setPerson(Person person) {

		Person oldValue = this.person;
		this.person = person;
		firePropertyChange(AdressColumns.PERSON.getName(), oldValue, this.person);
	}

	public Integer getZipcode() {

		return zipcode;
	}

	public void setZipcode(Integer zipcode) {

		Integer oldValue = this.zipcode;
		this.zipcode = zipcode;
		firePropertyChange(AdressColumns.ZIPCODE.getName(), oldValue, this.zipcode);
	}

	public String getAdress() {

		return adress;
	}

	public void setAdress(String adress) {

		String oldValue = this.adress;
		this.adress = adress;
		firePropertyChange(AdressColumns.ADRESS.getName(), oldValue, this.adress);
	}

	public Integer getNumber() {

		return number;
	}

	public void setNumber(Integer number) {

		this.number = number;
		Integer oldValue = this.number;
		this.number = number;
		firePropertyChange(AdressColumns.NUMBER.getName(), oldValue, this.number);
	}

	public String getComplement() {

		return complement;
	}

	public void setComplement(String complement) {

		String oldValue = this.complement;
		this.complement = complement;
		firePropertyChange(AdressColumns.COMPLEMENT.getName(), oldValue, this.complement);
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) {

		String oldValue = this.city;
		this.city = city;
		firePropertyChange(AdressColumns.CITY.getName(), oldValue, this.city);
	}

	public String getRegion() {

		return region;
	}

	public void setRegion(String region) {

		String oldValue = this.region;
		this.region = region;
		firePropertyChange(AdressColumns.REGION.getName(), oldValue, this.region);
	}

	public String getCountry() {

		return country;
	}

	public void setCountry(String country) {

		String oldValue = this.country;
		this.country = country;
		firePropertyChange(AdressColumns.COUNTRY.getName(), oldValue, this.country);
	}

}
