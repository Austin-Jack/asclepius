package com.asclepius.dto;

/**
 * @Author sny
 * @CreateTime 2022-07-07  16:06
 * @Description TODO
 * @Version 1.0
 */
public class PrescriptionDTO {

    private Integer apId;

    private String patient;

    private Float preCost;

    private String preComment;

    private Integer preStatus;

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

    public Float getPreCost() {
        return preCost;
    }

    public void setPreCost(Float preCost) {
        this.preCost = preCost;
    }

    public String getPreComment() {
        return preComment;
    }

    public void setPreComment(String preComment) {
        this.preComment = preComment;
    }

    public Integer getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(Integer preStatus) {
        this.preStatus = preStatus;
    }
}
