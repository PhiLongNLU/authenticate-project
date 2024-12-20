package com.nonglam.authentication.model;

import java.time.LocalDate;

public class User {
	private int id;
	private String name;
	private LocalDate bdate;
	
	/**
	 * @param id
	 * @param name
	 * @param bdate
	 */
	public User(int id, String name, LocalDate bdate) {
		super();
		this.id = id;
		this.name = name;
		this.bdate = bdate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bdate
	 */
	public LocalDate getBdate() {
		return bdate;
	}

	/**
	 * @param bdate the bdate to set
	 */
	public void setBdate(LocalDate bdate) {
		this.bdate = bdate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bdate=" + bdate + "]";
	}
}
