package com.medsoftware.model.one2many;

public class Book {

	private String id;
	private String bookName;
	private int bookPages;
	private String authorId;

	public Book(String bookName, int bookPages, String authorId) {
		super();
		this.bookName = bookName;
		this.bookPages = bookPages;
		this.authorId = authorId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPages() {
		return bookPages;
	}

	public void setBookPages(int bookPages) {
		this.bookPages = bookPages;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookPages=" + bookPages + "]";
	}

}
