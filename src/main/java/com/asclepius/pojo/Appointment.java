package com.asclepius.pojo;

public class Appointment {
    private Integer apId;

    private Integer cId;

    private Integer apNum;

    private Long apTime;

    private String docName;

    private String dName;

    private String cName;

    private Float apCost;

    private Integer apStatus;

    private Integer sId;

    public Integer getApId() {
        return apId;
    }

    public void setApId(Integer apId) {
        this.apId = apId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getApNum() {
        return apNum;
    }

    public void setApNum(Integer apNum) {
        this.apNum = apNum;
    }

    public Long getApTime() {
        return apTime;
    }

    public void setApTime(Long apTime) {
        this.apTime = apTime;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Float getApCost() {
        return apCost;
    }

    public void setApCost(Float apCost) {
        this.apCost = apCost;
    }

    public Integer getApStatus() {
        return apStatus;
    }

    public void setApStatus(Integer apStatus) {
        this.apStatus = apStatus;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }
}