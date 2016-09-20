package main.java.br.com.mesquitagomes.model.entity;

import java.util.Set;

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
public class Person {

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
	@Basic
	@Column(name = "cnpj")
	private Integer CNPJ;
	@Basic
	@Column(name = "ierg")
	private Integer IERG;
	@OneToMany(mappedBy = "person")
	private Set<Phone> phones;
	@OneToMany(mappedBy = "person")
	private Set<Adress> adresses;

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

	public Integer getCNPJ() {

		return CNPJ;
	}

	public void setCNPJ(Integer cNPJ) {

		CNPJ = cNPJ;
	}

	public Integer getIERG() {

		return IERG;
	}

	public void setIERG(Integer iERG) {

		IERG = iERG;
	}

	public Set<Phone> getPhones() {

		return phones;
	}

	public void setPhones(Set<Phone> phones) {

		this.phones = phones;
	}

	public Set<Adress> getAdresses() {

		return adresses;
	}

	public void setAdresses(Set<Adress> adresses) {

		this.adresses = adresses;
	}

	public String toString() {

		return id + " - " + name;
	}

}
