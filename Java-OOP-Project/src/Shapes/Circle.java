package Shapes;

import java.awt.Color;
import java.awt.Graphics2D;

import Shapes.Interfaces.Shape;

public class Circle extends Shape {
    private double radius;

    public Circle(int id, double cx, double cy, double radius, Color fillColor) {
        super(id, cx, cy, fillColor);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void translate(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
}
