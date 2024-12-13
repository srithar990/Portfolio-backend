package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Publication {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		long id;
		String title;
		String authors;
		String journal;
		String volume;
		String year;
		String indexing;
		String quartile;
		String link;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
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
		public String getJournal() {
			return journal;
		}
		public void setJournal(String journal) {
			this.journal = journal;
		}
		public String getVolume() {
			return volume;
		}
		public void setVolume(String volume) {
			this.volume = volume;
		}
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		public String getIndexing() {
			return indexing;
		}
		public void setIndexing(String indexing) {
			this.indexing = indexing;
		}
		public String getQuartile() {
			return quartile;
		}
		public void setQuartile(String quartile) {
			this.quartile = quartile;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		
		
	}


