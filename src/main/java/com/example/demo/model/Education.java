package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Education {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		long id;
		String degree;
		String spec;
		String univ;
		String year;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getDegree() {
			return degree;
		}
		public void setDegree(String degree) {
			this.degree = degree;
		}
		public String getSpec() {
			return spec;
		}
		public void setSpec(String spec) {
			this.spec = spec;
		}
		public String getUniv() {
			return univ;
		}
		public void setUniv(String univ) {
			this.univ = univ;
		}
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		
		
	}


