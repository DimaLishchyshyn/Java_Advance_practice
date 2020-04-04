package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "university")
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column()
	private Integer levelOfAccredetation;

	@Column()
	private Integer quantityOfInstitute;

	@Column()
	private Integer quantityOfStudent;

	@Column()
	private String addressOfUniversity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLevelOfAccredetation() {
		return levelOfAccredetation;
	}

	public void setLevelOfAccredetation(Integer levelOfAccredetation) {
		this.levelOfAccredetation = levelOfAccredetation;
	}

	public Integer getQuantityOfInstitute() {
		return quantityOfInstitute;
	}

	public void setQuantityOfInstitute(Integer quantityOfInstitute) {
		this.quantityOfInstitute = quantityOfInstitute;
	}

	public Integer getQuantityOfStudent() {
		return quantityOfStudent;
	}

	public void setQuantityOfStudent(Integer quantityOfStudent) {
		this.quantityOfStudent = quantityOfStudent;
	}

	public String getAddressOfUniversity() {
		return addressOfUniversity;
	}

	public void setAddressOfUniversity(String addressOfUniversity) {
		this.addressOfUniversity = addressOfUniversity;
	}

	@Override
	public String toString() {
		return "Університет №= " + id + ", рівень акредитації= " + levelOfAccredetation + ", кількість інститутів= "
				+ quantityOfInstitute + ", кількість студентів= " + quantityOfStudent + ", адреса університету= "
				+ addressOfUniversity + "]";
	}

}
