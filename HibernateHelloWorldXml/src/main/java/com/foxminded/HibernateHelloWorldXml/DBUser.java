package com.foxminded.HibernateHelloWorldXml;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Dbuser generated by hbm2java
 */
@Entity
@Table(name = "DBUSER")
public class DBUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1815149901774645023L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false, precision = 5, scale = 0)
	private int userId;

	@Column(name = "username", nullable = false, length = 20)
	private String username;

	@Column(name = "created_by", nullable = false, length = 20)
	private String createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	public DBUser() {
	}

	public DBUser(int userId, String username, String createdBy,
			Date createdDate) {
		this.userId = userId;
		this.username = username;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}