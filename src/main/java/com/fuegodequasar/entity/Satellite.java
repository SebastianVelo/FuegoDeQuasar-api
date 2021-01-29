package com.fuegodequasar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="SATELLITE")
@Entity
public class Satellite implements Serializable {
    
    private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
    private long id;
    
    @Column(name="name")
    private String name;

    @Column(name="x")
    private double x;

    @Column(name="y")
    private double y;

    public Satellite() {

    }

    public Satellite(long id, String name, double x, double y) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


}
