package com.asclepius.dto;

/**
 * @Author sny
 * @CreateTime 2022-07-07  09:32
 * @Description TODO
 * @Version 1.0
 */
public class AppointmentExtDTO {
    private Integer apId;

    private Integer cId;

    private Integer sId;

    private String patient;

    private Long apTime;

    private String docName;

    private String dName;

    private Integer cLevel;

    private Float apCost;

    private Integer apStatus;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getApId() {
        return apId;
    }

    public void setApId(Integer apId) {
        this.apId = apId;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
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
        this.docName = docName;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public Integer getcLevel() {
        return cLevel;
    }

    public void setcLevel(Integer cLevel) {
        this.cLevel = cLevel;
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
}
