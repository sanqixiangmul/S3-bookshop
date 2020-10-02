package com.yc.bookshop.bean;

public class Booktype implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;

	private Integer btId;

    private String btName;

    private Integer btPid;
    
    private Book book;

    public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public String getBtName() {
        return btName;
    }

    public void setBtName(String btName) {
        this.btName = btName == null ? null : btName.trim();
    }

    public Integer getBtPid() {
        return btPid;
    }

    public void setBtPid(Integer btPid) {
        this.btPid = btPid;
    }

	@Override
	public String toString() {
		return "Booktype [btId=" + btId + ", btName=" + btName + ", btPid=" + btPid + ", book=" + book + "]";
	}
    
}