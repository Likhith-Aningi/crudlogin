package com.h2example.crudlogin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class EmpEntity {
    @Id
    @GeneratedValue
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
