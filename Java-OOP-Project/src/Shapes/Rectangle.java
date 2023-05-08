package Shapes;

import Shapes.Interfaces.Shape;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(int id, double x, double y, double width, double height, Color fillColor) {
        super(id, x, y, fillColor);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return this.width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public void translate(double dx, double dy) {
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);
    }
}