package com.fuegodequasar.bean;

public class Position {
    
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position(double[] pos) {
        this.x = pos[0];
        this.y = pos[1];
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

    public double[] toArray() {
        double[] pos = {this.x, this.y};
        return pos;
    }
}
