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
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long noteBookId;
    private Date insertTime;
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNoteBookId() {
        return noteBookId;
    }

    public void setNoteBookId(Long noteBookId) {
        this.noteBookId = noteBookId;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Log(Long noteBookId, Date insertTime, Date updateTime) {
        this.noteBookId = noteBookId;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }

    public Log() {
    }
}
