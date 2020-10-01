package com.yc.bookshop.bean;

public class Booktype implements java.io.Serializable{
    private Integer btId;

    private String btName;

    private Integer btPid;

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
}