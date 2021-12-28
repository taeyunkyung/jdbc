package com.javaex.ex01;

public class BookAllVO {

	// 필드
	private int bookId;
	private String Title;
	private String Pubs;
	private String pubDate;
	private int authorId;
	private String authorName;
	private String authorDesc;

	// 생성자
	public BookAllVO() {

	}

	public BookAllVO(int bookId, String title, String pubs, String pubDate, int authorId, String authorName,
			String authorDesc) {
		this.bookId = bookId;
		Title = title;
		Pubs = pubs;
		this.pubDate = pubDate;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}

	// 메소드 g/s
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPubs() {
		return Pubs;
	}

	public void setPubs(String pubs) {
		Pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

	// 메소드 일반
	@Override
	public String toString() {
		return "BookAllVO [bookId=" + bookId + ", Title=" + Title + ", Pubs=" + Pubs + ", pubDate=" + pubDate
				+ ", authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}

}
