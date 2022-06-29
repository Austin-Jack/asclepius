package com.asclepius.pojo;

public class Prescription {
    private Integer preId;

    private Integer apId;

    private String preComment;

    private Float preCost;

    private Integer preStatus;

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

    public Integer getApId() {
        return apId;
    }

    public void setApId(Integer apId) {
        this.apId = apId;
    }

    public String getPreComment() {
        return preComment;
    }

    public void setPreComment(String preComment) {
        this.preComment = preComment == null ? null : preComment.trim();
    }

    public Float getPreCost() {
        return preCost;
    }

    public void setPreCost(Float preCost) {
        this.preCost = preCost;
    }

    public Integer getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(Integer preStatus) {
        this.preStatus = preStatus;
    }
}