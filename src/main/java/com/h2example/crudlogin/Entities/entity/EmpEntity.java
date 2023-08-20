package com.h2example.crudlogin.Entities.entity;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "emp")
public class EmpEntity {
    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)//for indepedent id generation instead of sequence
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
