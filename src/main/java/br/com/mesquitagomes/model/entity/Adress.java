package main.java.br.com.mesquitagomes.model.entity;

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
public class Adress {

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
	@Column(name = "city", length = 100, nullable = false)
	private String city;
	@Basic
	@Column(name = "region", length = 100, nullable = false)
	private String region;
	@Basic
	@Column(name = "country", length = 100, nullable = false)
	private String country;

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
