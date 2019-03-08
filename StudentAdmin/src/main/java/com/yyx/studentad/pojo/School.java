package com.yyx.studentad.pojo;

public class School {
    private Integer schoolId;

    private String schoolNumber;

    private String schoolName;

    private String schoolAddress;

    private String schoolTell;

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber == null ? null : schoolNumber.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress == null ? null : schoolAddress.trim();
    }

    public String getSchoolTell() {
        return schoolTell;
    }

    public void setSchoolTell(String schoolTell) {
        this.schoolTell = schoolTell == null ? null : schoolTell.trim();
    }
}