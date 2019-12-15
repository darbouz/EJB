package org.tuto.service.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="accounts") // Data base table
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -102510678368705661L;
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	@Column(name = "CODE") 
	private long code;
	private double balance;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	private boolean active;
	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(double balance, Date craetionDate, boolean active) {
		super();
		this.balance = balance;
		this.creationDate = craetionDate;
		this.active = active;
	}
	public long getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Acount [code=" + code + ", balance=" + balance + ", creationDate=" + creationDate + ", active=" + active
				+ "]";
	}

}
