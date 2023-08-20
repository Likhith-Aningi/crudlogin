package com.h2example.crudlogin.Entities.h2entity;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "EMP")
public class H2Entity {
    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;
    private float esal;
    private String ename;

    public Float getEsal() {
        return esal;
    }

    public void setEsal(Float esal) {
        this.esal = esal;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

}
