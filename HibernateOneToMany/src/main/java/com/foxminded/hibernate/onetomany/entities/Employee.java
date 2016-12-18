package com.foxminded.hibernate.onetomany.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="firstname")
	@NotNull
	private String firstname;
	
	@Column(name="lastname")
    @NotNull
	private String lastname;

	@Column(name = "salary")
    @Min(500)
    @Max(10_000)
	private int salary;

    @Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="cell_phone")
	private String cellphone;

	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	public Employee() {
	}
	
	public Employee(String firstname, String lastname, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = new Date(System.currentTimeMillis());
		this.cellphone = phone;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                ", cellphone='" + cellphone + '\'' +
                ", department=" + department +
                '}';
    }
}