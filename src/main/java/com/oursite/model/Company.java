package main.java.com.oursite.model;

public class Company {
	private String nameCompany;
	private String description;
	private String telephone;
	private String email;
	private String contactPerson;
	private Vacancy listVacancy;

	@Override
	public String toString() {
		return "Company [nameCompany=" + nameCompany + ", description="
				+ description + ", telephone=" + telephone + ", email=" + email
				+ ", contactPerson=" + contactPerson + "]";
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Vacancy getListVacancy() {
		return listVacancy;
	}

	public void setListVacancy(Vacancy listVacancy) {
		this.listVacancy = listVacancy;
	}

}
