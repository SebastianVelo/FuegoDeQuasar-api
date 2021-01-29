package com.fuegodequasar.model;

import com.fuegodequasar.bean.Message;
import com.fuegodequasar.bean.Position;

public class MSatellite {
    
    private String name;
    private double distance;
    private Position position;
    private Message message;

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
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
}
