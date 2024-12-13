package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patents {
	@Id
	String title;
	String authors;
	String applicationno;
	String status;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getApplicationno() {
		return applicationno;
	}
	public void setApplicationno(String applicationno) {
		this.applicationno = applicationno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Patents [title=" + title + ", authors=" + authors + ", applicationno=" + applicationno + ", status="
				+ status + "]";
	}
	

}
