package com.jobs.entity;

import javax.persistence.*;

/**
 * Created by Wan on 2017/8/27.
 */
@Entity
public class NoteBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String autority;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutority() {
        return autority;
    }

    public void setAutority(String autority) {
        this.autority = autority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NoteBook(String name, String autority, String type) {
        this.name = name;
        this.autority = autority;
        this.type = type;
    }

    public NoteBook() {
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "type='" + type + '\'' +
                ", autority='" + autority + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
