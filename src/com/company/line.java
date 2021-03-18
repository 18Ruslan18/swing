package com.company;

public class line {
    private Point2d a;
    private Point2d b;

    public line(Point2d a, Point2d b) {
        this.a = a;
        this.b = b;
    }

    public Point2d getA() {
        return a;
    }

    public void setA(Point2d a) {
        this.a = a;
    }

    public Point2d getB() {
        return b;
    }

    public void setB(Point2d b) {
        this.b = b;
    }
}
