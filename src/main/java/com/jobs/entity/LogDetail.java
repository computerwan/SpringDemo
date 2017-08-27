package com.jobs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Wan on 2017/8/27.
 */
@Entity
public class LogDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long logId;
    private Long typeId;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LogDetail(Long logId, Long typeId, String value) {
        logId = logId;
        this.typeId = typeId;
        this.value = value;
    }

    public LogDetail() {
    }

    @Override
    public String toString() {
        return "LogDetail{" +
                "id=" + id +
                ", LogId=" + logId +
                ", typeId=" + typeId +
                ", value='" + value + '\'' +
                '}';
    }
}
