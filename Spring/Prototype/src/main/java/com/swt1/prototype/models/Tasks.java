package com.swt1.prototype.models;

public class Tasks {

	private String name;
	private String user;
	private String description;
	private String documentID;
	
	public Tasks(String name, String user, String description, String documentID) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.user = user;
		this.description = description;
		this.documentID = documentID;
	}
	
	/**
	 * @return the documentID
	 */
	public String getDocumentID() {
		return documentID;
	}

	/**
	 * @param documentID the documentID to set
	 */
	public void setDocumentID(String documentID) {
		this.documentID = documentID;
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
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
