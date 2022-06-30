package com.asclepius.pojo;

public class Schedule {
    private Integer sId;

    private Integer docId;

    private Long scStartTime;

    private Float docPrice;

    private Integer num;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Long getScStartTime() {
        return scStartTime;
    }

    public void setScStartTime(Long scStartTime) {
        this.scStartTime = scStartTime;
    }

    public Float getDocPrice() {
        return docPrice;
    }

    public void setDocPrice(Float docPrice) {
        this.docPrice = docPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}