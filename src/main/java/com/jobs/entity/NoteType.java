package com.jobs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Wan on 2017/8/27.
 */
@Entity
public class NoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private Boolean isDir;
    private String parentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }


    public Boolean getDir() {
        return isDir;
    }

    public void setDir(Boolean dir) {
        isDir = dir;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NoteType(String type, Boolean isDir, String parentType) {
        this.type = type;
        this.isDir = isDir;
        this.parentType = parentType;
    }

    public NoteType() {
    }
}
