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
	@Column(name = "name", length = 200, nullable = false)
	private String name;
	@Basic
	@Column(name = "cpf")
	private Integer CPF;
	@Column(name = "rg", length = 15)
	private String RG;
	@Basic
	@Column(name = "cnpj")
	private Integer CNPJ;
	@Basic
	@Column(name = "ie")
	private Integer IE;
	@Basic
	@Column(name = "email")
	private String email;
	@OneToMany(mappedBy = "person")
	private List<Phone> phones;
	@OneToMany(mappedBy = "person")
	private List<Adress> adresses;

	public enum PersonColumns {

		ID("id"), NAME("name"), CPF("cpf"), RG("rg"), CNPJ("cnpj"), IE("ie"), EMAIL("email");

		private String name;

		PersonColumns(String name) {
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
		firePropertyChange(PersonColumns.ID.getName(), oldValue, this.id);
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		String oldValue = this.name;
		this.name = name;
		firePropertyChange(PersonColumns.NAME.getName(), oldValue, this.name);
	}

	public Integer getCPF() {

		return CPF;
	}

	public void setCPF(Integer cPF) {

		Integer oldValue = CPF;
		CPF = cPF;
		firePropertyChange(PersonColumns.CPF.getName(), oldValue, CPF);
	}

	public String getRG() {

		return RG;
	}

	public void setRG(String rG) {

		String oldValue = RG;
		RG = rG;
		firePropertyChange(PersonColumns.RG.getName(), oldValue, RG);
	}

	public Integer getCNPJ() {

		return CNPJ;
	}

	public void setCNPJ(Integer cNPJ) {

		Integer oldValue = CNPJ;
		CNPJ = cNPJ;
		firePropertyChange(PersonColumns.CNPJ.getName(), oldValue, CNPJ);
	}

	public Integer getIE() {

		return IE;
	}

	public void setIE(Integer iE) {

		Integer oldValue = IE;
		IE = iE;
		firePropertyChange(PersonColumns.IE.getName(), oldValue, IE);
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		String oldValue = this.email;
		this.email = email;
		firePropertyChange(PersonColumns.EMAIL.getName(), oldValue, this.email);
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
		firePropertyChange("phones", oldValue, phones);
	}

	public void removePhone(Phone phone) {

		List<Phone> oldValue = phones;
		phones = new ArrayList<Phone>(phones);
		phones.remove(phone);
		firePropertyChange("phones", oldValue, phones);
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
		firePropertyChange("adresses", oldValue, adresses);
	}

	public void removeAdress(Adress adress) {

		List<Adress> oldValue = adresses;
		adresses = new ArrayList<Adress>(adresses);
		phones.remove(adress);
		firePropertyChange("adresses", oldValue, adresses);
	}

	public String toString() {

		String str = "id:[" + id + "] name:[" + name + "]";
		if (CPF != null) str += " cpf:[" + CPF + "]";
		if (RG != null) str += " rg:[" + RG + "]";
		if (CNPJ != null) str += " cnpj:[" + CNPJ + "]";
		if (IE != null) str += " ie:[" + IE + "]";

		return str;
	}

}
