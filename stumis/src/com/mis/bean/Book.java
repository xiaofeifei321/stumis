package com.mis.bean;

/**
 * 实体类
 */
public class Book {
	private int id;
	private String isbn;
	private String bookName;
	private String author;
	private int price;
	private String publishPress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublishPress() {
		return publishPress;
	}

	public void setPublishPress(String publishPress) {
		this.publishPress = publishPress;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", bookName=" + bookName
				+ ", author=" + author + ", price=" + price + ", publishPress="
				+ publishPress + "]";
	}

}
