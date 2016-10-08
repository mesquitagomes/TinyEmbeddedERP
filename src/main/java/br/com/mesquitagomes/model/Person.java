package main.java.br.com.mesquitagomes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
	@Column(name = "name", length = 200, nullable = false)
	private String name;
	@Basic
	@Column(name = "cnpj", length = 20)
	private String cnpj;
	@Basic
	@Column(name = "ie", length = 20)
	private String ie;
	@Basic
	@Column(name = "cpf", length = 20)
	private String cpf;
	@Basic
	@Column(name = "rg", length = 20)
	private String rg;
	@Basic
	@Column(name = "email")
	private String email;
	@OneToMany(mappedBy = "person", cascade = { CascadeType.ALL })
	private List<Phone> phones = new ArrayList<>();
	@OneToMany(mappedBy = "person", cascade = { CascadeType.ALL })
	private List<Adress> adresses = new ArrayList<>();

	public enum PersonColumnsEnum {

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

	public String getCnpj() {

		return cnpj;
	}

	public void setCnpj(String cnpj) {

		if (cnpj.matches(".*\\d+.*")) {
			String oldValue = this.cnpj;
			this.cnpj = cnpj;
			firePropertyChange(PersonPropertyChangeEnum.cnpj.name(), oldValue, this.cnpj);
		}
	}

	public String getIe() {

		return ie;
	}

	public void setIe(String ie) {

		if (ie.matches(".*\\d+.*")) {
			String oldValue = this.ie;
			this.ie = ie;
			firePropertyChange(PersonPropertyChangeEnum.ie.name(), oldValue, this.ie);
		}
	}

	public String getCpf() {

		return cpf;
	}

	public void setCpf(String cpf) {

		if (cpf.matches(".*\\d+.*")) {
			String oldValue = this.cpf;
			this.cpf = cpf;
			firePropertyChange(PersonPropertyChangeEnum.cpf.name(), oldValue, this.cpf);
		}
	}

	public String getRg() {

		return rg;
	}

	public void setRg(String rg) {

		if (rg.matches(".*\\d+.*")) {
			String oldValue = this.rg;
			this.rg = rg;
			firePropertyChange(PersonPropertyChangeEnum.rg.name(), oldValue, this.rg);
		}
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

	public Phone getPhone(int index) {

		Phone phone = null;
		if (index >= 0 && index < phones.size()) phone = phones.get(index);
		return phone;
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

	public Adress getAdress(int index) {

		Adress adress = null;
		if (index >= 0 && index < adresses.size()) adress = adresses.get(index);
		return adress;
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
