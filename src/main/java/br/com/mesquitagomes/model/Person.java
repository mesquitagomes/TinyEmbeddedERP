package main.java.br.com.mesquitagomes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person extends AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Basic
	@Column(name = "value", length = 200, nullable = false)
	private String name;
	@Basic
	@Column(name = "cnpj")
	private Integer cnpj;
	@Basic
	@Column(name = "ie")
	private Integer ie;
	@Basic
	@Column(name = "cpf")
	private Integer cpf;
	@Basic
	@Column(name = "rg", length = 15)
	private String rg;
	@Basic
	@Column(name = "email")
	private String email;
	@OneToMany(mappedBy = "person")
	private List<Phone> phones;
	@OneToMany(mappedBy = "person")
	private List<Adress> adresses;

	public enum PersonColumns {

		id(), name(), cpf(), rg(), cnpj(), ie(), email();

	}

	public enum PersonPropertyChangeEnum {

		id(), name(), cpf(), rg(), cnpj(), ie(), email(), phones(), adresses();

	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		Integer oldValue = this.id;
		this.id = id;
		firePropertyChange(PersonPropertyChangeEnum.id.name(), oldValue, this.id);
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		String oldValue = this.name;
		this.name = name;
		firePropertyChange(PersonPropertyChangeEnum.name.name(), oldValue, this.name);
	}

	public Integer getCnpj() {

		return cnpj;
	}

	public void setCnpj(Integer cnpj) {

		Integer oldValue = this.cnpj;
		this.cnpj = cnpj;
		firePropertyChange(PersonPropertyChangeEnum.cnpj.name(), oldValue, this.cnpj);
	}

	public Integer getIe() {

		return ie;
	}

	public void setIe(Integer ie) {

		Integer oldValue = this.ie;
		this.ie = ie;
		firePropertyChange(PersonPropertyChangeEnum.ie.name(), oldValue, this.ie);
	}

	public Integer getCpf() {

		return cpf;
	}

	public void setCpf(Integer cpf) {

		Integer oldValue = this.cpf;
		this.cpf = cpf;
		firePropertyChange(PersonPropertyChangeEnum.cpf.name(), oldValue, this.cpf);
	}

	public String getRg() {

		return rg;
	}

	public void setRg(String rg) {

		String oldValue = this.rg;
		this.rg = rg;
		firePropertyChange(PersonPropertyChangeEnum.rg.name(), oldValue, this.rg);
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		String oldValue = this.email;
		this.email = email;
		firePropertyChange(PersonPropertyChangeEnum.email.name(), oldValue, this.email);
	}

	public List<Phone> getPhones() {

		return phones;
	}

	public void setPhones(List<Phone> phones) {

		this.phones = phones;
	}

	public void addPhone(Phone phone) {

		List<Phone> oldValue = phones;
		phones = new ArrayList<Phone>(phones);
		phones.add(phone);
		firePropertyChange(PersonPropertyChangeEnum.phones.name(), oldValue, phones);
	}

	public void removePhone(Phone phone) {

		List<Phone> oldValue = phones;
		phones = new ArrayList<Phone>(phones);
		phones.remove(phone);
		firePropertyChange(PersonPropertyChangeEnum.phones.name(), oldValue, phones);
	}

	public List<Adress> getAdresses() {

		return adresses;
	}

	public void setAdresses(List<Adress> adresses) {

		this.adresses = adresses;
	}

	public void addAdress(Adress adress) {

		List<Adress> oldValue = adresses;
		adresses = new ArrayList<Adress>(adresses);
		adresses.add(adress);
		firePropertyChange(PersonPropertyChangeEnum.adresses.name(), oldValue, adresses);
	}

	public void removeAdress(Adress adress) {

		List<Adress> oldValue = adresses;
		adresses = new ArrayList<Adress>(adresses);
		phones.remove(adress);
		firePropertyChange(PersonPropertyChangeEnum.adresses.name(), oldValue, adresses);
	}

	public String toString() {

		String str = "id:[" + id + "] value:[" + name + "]";
		if (cpf != null) str += " cpf:[" + cpf + "]";
		if (rg != null) str += " rg:[" + rg + "]";
		if (cnpj != null) str += " cnpj:[" + cnpj + "]";
		if (ie != null) str += " ie:[" + ie + "]";

		return str;
	}

}
