package com.medsoftware.model.one2many;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("author")
public class Author {
	private String id;
	private String authorName;
	private String country;

	public Author(String authorName, String country) {
		this.authorName = authorName;
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", authorName=" + authorName + ", country=" + country + "]";
	}

}
