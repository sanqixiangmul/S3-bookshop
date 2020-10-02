package com.yc.bookshop.bean;

import java.util.Date;

public class Cart implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer uId;

    private Integer bId;

    private Integer cnt;

    private Date createTime;
    
    private Book book;
    

    @Override
	public String toString() {
		return "Cart [id=" + id + ", uId=" + uId + ", bId=" + bId + ", cnt=" + cnt + ", createTime=" + createTime
				+ ", book=" + book + "]";
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}