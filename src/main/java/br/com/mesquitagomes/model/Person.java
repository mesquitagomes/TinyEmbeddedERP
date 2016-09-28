package main.java.br.com.mesquitagomes.model;

import java.io.Serializable;
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
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Basic
	@Column(name = "name", length = 200, nullable = false)
	private String name;
	@Basic
	@Column(name = "cpf", unique = true)
	private Integer CPF;
	@Column(name = "rg", length = 15, unique = true)
	private String RG;
	@Basic
	@Column(name = "cnpj", unique = true)
	private Integer CNPJ;
	@Basic
	@Column(name = "ie", unique = true)
	private Integer IE;
	@OneToMany(mappedBy = "person")
	private List<Phone> phones;
	@OneToMany(mappedBy = "person")
	private List<Adress> adresses;

	public enum PersonColumn {

		ID("id"), NAME("name"), CPF("cpf"), RG("rg"), CNPJ("cnpj"), IE("ie");

		String name;

		PersonColumn(String name) {
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

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Integer getCPF() {

		return CPF;
	}

	public void setCPF(Integer cPF) {

		CPF = cPF;
	}

	public String getRG() {

		return RG;
	}

	public void setRG(String rG) {

		RG = rG;
	}

	public Integer getCNPJ() {

		return CNPJ;
	}

	public void setCNPJ(Integer cNPJ) {

		CNPJ = cNPJ;
	}

	public Integer getIE() {

		return IE;
	}

	public void setIE(Integer iE) {

		IE = iE;
	}

	public List<Phone> getPhones() {

		return phones;
	}

	public void setPhones(List<Phone> phones) {

		this.phones = phones;
	}

	public List<Adress> getAdresses() {

		return adresses;
	}

	public void setAdresses(List<Adress> adresses) {

		this.adresses = adresses;
	}

	public void addPhone(Phone phone) {

		phones.add(phone);
	}

	public void removePhone(Phone phone) {

		phones.remove(phone);
	}

	public void addAdress(Adress adress) {

		adresses.add(adress);
	}

	public void removeAdress(Adress adress) {

		adresses.remove(adress);
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
