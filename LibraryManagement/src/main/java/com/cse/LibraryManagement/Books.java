package com.cse.LibraryManagement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Books {

	@Id
	private int ISBN;
	private String Bookname;
	private String AuthorName;
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
	public Books(int iSBN, String bookname, String authorName) {
		super();
		ISBN = iSBN;
		Bookname = bookname;
		AuthorName = authorName;
	}
	public Books() {
		super();
	}
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", Bookname=" + Bookname + ", AuthorName=" + AuthorName + "]";
	}
	
	
}
