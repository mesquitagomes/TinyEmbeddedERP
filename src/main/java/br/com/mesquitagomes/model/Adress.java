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
	@Column(name = "zipcode", length = 20)
	private String zipcode;
	@Basic
	@Column(name = "adress", length = 200)
	private String adress;
	@Basic
	@Column(name = "number", length = 20)
	private String number;
	@Basic
	@Column(name = "complement", length = 100)
	private String complement;
	@Basic
	@Column(name = "district", length = 100)
	private String district;
	@Basic
	@Column(name = "city", length = 100)
	private String city;
	@Basic
	@Column(name = "region", length = 100)
	private String region;
	@Basic
	@Column(name = "country", length = 100)
	private String country;

	public enum AdressColumnsEnum {

		id(), person_id(), zipcode(), adress(), number(), complement(), district(), city(), region(), country();

	}

	public enum AdressPropertyChangeEnum {

		id(), person(), zipcode(), adress(), number(), complement(), district(), city(), region(), country();

	}

	public Adress() {}

	public Adress(Person person) {

		setPerson(person);
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		Integer oldValue = this.id;
		this.id = id;
		firePropertyChange(AdressPropertyChangeEnum.id.name(), oldValue, this.id);
	}

	public Person getPerson() {

		return person;
	}

	public void setPerson(Person person) {

		Person oldValue = this.person;
		this.person = person;
		firePropertyChange(AdressPropertyChangeEnum.person.name(), oldValue, this.person);
	}

	public String getZipcode() {

		return zipcode;
	}

	public void setZipcode(String zipcode) {

		String oldValue = this.zipcode;
		this.zipcode = zipcode;
		firePropertyChange(AdressPropertyChangeEnum.zipcode.name(), oldValue, this.zipcode);
	}

	public String getAdress() {

		return adress;
	}

	public void setAdress(String adress) {

		String oldValue = this.adress;
		this.adress = adress;
		firePropertyChange(AdressPropertyChangeEnum.adress.name(), oldValue, this.adress);
	}

	public String getNumber() {

		return number;
	}

	public void setNumber(String number) {

		String oldValue = this.number;
		this.number = number;
		firePropertyChange(AdressPropertyChangeEnum.number.name(), oldValue, this.number);
	}

	public String getComplement() {

		return complement;
	}

	public void setComplement(String complement) {

		String oldValue = this.complement;
		this.complement = complement;
		firePropertyChange(AdressPropertyChangeEnum.complement.name(), oldValue, this.complement);
	}

	public String getDistrict() {

		return district;
	}

	public void setDistrict(String district) {

		String oldValue = this.district;
		this.district = district;
		firePropertyChange(AdressPropertyChangeEnum.district.name(), oldValue, this.district);
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) {

		String oldValue = this.city;
		this.city = city;
		firePropertyChange(AdressPropertyChangeEnum.city.name(), oldValue, this.city);
	}

	public String getRegion() {

		return region;
	}

	public void setRegion(String region) {

		String oldValue = this.region;
		this.region = region;
		firePropertyChange(AdressPropertyChangeEnum.region.name(), oldValue, this.region);
	}

	public String getCountry() {

		return country;
	}

	public void setCountry(String country) {

		String oldValue = this.country;
		this.country = country;
		firePropertyChange(AdressPropertyChangeEnum.country.name(), oldValue, this.country);
	}

}
