package com.asclepius.pojo;

public class Doctor {
    private Integer docId;

    private Integer dId;

    private String docName;

    private Integer docSex;

    private Integer docRank;

    private String docImage;

    private String docDetail;

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

    public String getDocImage() {
        return docImage;
    }

    public void setDocImage(String docImage) {
        this.docImage = docImage == null ? null : docImage.trim();
    }

    public String getDocDetail() {
        return docDetail;
    }

    public void setDocDetail(String docDetail) {
        this.docDetail = docDetail == null ? null : docDetail.trim();
    }
}