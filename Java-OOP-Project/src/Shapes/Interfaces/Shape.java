package Shapes.Interfaces;
import java.awt.Color;

public abstract class Shape {
    private int id;
    private double x;
    private double y;
    private Color fillColor;

    public Shape(int id, double x, double y, Color fillColor) {
        this.setId(id);
        this.setFillColor(fillColor);
        this.setX(x);
        this.setY(y);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public abstract void translate(double dx, double dy);
}
