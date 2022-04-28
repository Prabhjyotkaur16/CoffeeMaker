package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="Beverages")
public class Beverages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="beverageId")
    private Integer beverageId;

    @Column(name="beverageName")
    private String beverageName;

    public Beverages(String beverageName) {
        this.beverageName = beverageName;
    }
    public Beverages(){

    }

    public Integer getBeverageId() {
        return beverageId;
    }

    public void setBeverageId(Integer beverageId) {
        this.beverageId = beverageId;
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    @Override
    public String toString() {
        return "Beverages{" +
                "beverageName='" + beverageName + '\'' +
                '}';
    }
}
