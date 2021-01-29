package com.fuegodequasar.model;

import java.util.List;

import com.fuegodequasar.bean.Message;
import com.fuegodequasar.bean.Position;

public class MSatellite {
    
    private String name;
    private double distance;
    private Position position;
    private List<String> message;

    public MSatellite() {

    }
    
    public MSatellite(String name, double x, double y) {
        this.name = name;
        this.position = new Position(x, y);
    }
    
    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(double x, double y) {
        this.position = new Position(x, y);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Message getMessage() {
        return new Message(message);
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
    
}
