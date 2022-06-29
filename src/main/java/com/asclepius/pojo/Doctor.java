package com.asclepius.pojo;

public class Doctor {
    private Integer docId;

    private Integer dId;

    private String docName;

    private Integer docSex;

    private Integer docRank;

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    public Integer getDocSex() {
        return docSex;
    }

    public void setDocSex(Integer docSex) {
        this.docSex = docSex;
    }

    public Integer getDocRank() {
        return docRank;
    }

    public void setDocRank(Integer docRank) {
        this.docRank = docRank;
    }
}