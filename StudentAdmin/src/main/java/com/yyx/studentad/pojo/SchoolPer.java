package com.yyx.studentad.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SchoolPer {
    private Integer perId;

    @NotEmpty
    private String perUsername;

    @NotNull
    private Integer perPassword;

    private String perType;

    private String updatetime;

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerUsername() {
        return perUsername;
    }

    public void setPerUsername(String perUsername) {
        this.perUsername = perUsername == null ? null : perUsername.trim();
    }

    public Integer getPerPassword() {
        return perPassword;
    }

    public void setPerPassword(Integer perPassword) {
        this.perPassword = perPassword;
    }

    public String getPerType() {
        return perType;
    }

    public void setPerType(String perType) {
        this.perType = perType == null ? null : perType.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    @Override
    public String toString() {
        return "SchoolPer{" +
                "perId=" + perId +
                ", perUsername='" + perUsername + '\'' +
                ", perPassword=" + perPassword +
                ", perType='" + perType + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}