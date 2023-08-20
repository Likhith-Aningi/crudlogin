package com.h2example.crudlogin.Entities.entity;

import javax.persistence.*;

@Entity
@Table(name = "Images")
public class MysqlImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iid;
    @Column(name = "Ipath")
    private String ipath;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getIpath() {
        return ipath;
    }

    public void setIpath(String ipath) {
        this.ipath = ipath;
    }
}
