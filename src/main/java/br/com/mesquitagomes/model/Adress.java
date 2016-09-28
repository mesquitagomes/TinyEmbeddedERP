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
public class Adress implements Serializable {

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

	public enum AdressColumn {

		ID("id"), PERSON("person_id"), ZIPCODE("zipcode"), ADRESS("adress"), NUMBER("number"), COMPLEMENT("complement"), CITY(
				"city"), REGION("region"), COUNTRY("country");

		String name;

		AdressColumn(String name) {
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

	public Integer getZipcode() {

		return zipcode;
	}

	public void setZipcode(Integer zipcode) {

		this.zipcode = zipcode;
	}

	public String getAdress() {

		return adress;
	}

	public void setAdress(String adress) {

		this.adress = adress;
	}

	public Integer getNumber() {

		return number;
	}

	public void setNumber(Integer number) {

		this.number = number;
	}

	public String getComplement() {

		return complement;
	}

	public void setComplement(String complement) {

		this.complement = complement;
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) {

		this.city = city;
	}

	public String getRegion() {

		return region;
	}

	public void setRegion(String region) {

		this.region = region;
	}

	public String getCountry() {

		return country;
	}

	public void setCountry(String country) {

		this.country = country;
	}

}
