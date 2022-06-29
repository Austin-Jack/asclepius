package com.asclepius.pojo;

public class Clinic {
    private Integer cliId;

    private String cliName;

    private Integer cliLevel;

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getCliName() {
        return cliName;
    }

    public void setCliName(String cliName) {
        this.cliName = cliName == null ? null : cliName.trim();
    }

    public Integer getCliLevel() {
        return cliLevel;
    }

    public void setCliLevel(Integer cliLevel) {
        this.cliLevel = cliLevel;
    }
}