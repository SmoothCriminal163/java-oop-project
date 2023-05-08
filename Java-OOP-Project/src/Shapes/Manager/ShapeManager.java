package Shapes.Manager;

import Shapes.Circle;
import Shapes.Enums.ShapeType;
import Shapes.Interfaces.Shape;
import Shapes.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;

public class ShapeManager {
    private static ShapeManager instance = null;
    private ArrayList<Shape> shapes;
    private int nextID;

    private ShapeManager() {
        shapes = new ArrayList<Shape>();
        nextID = 1;
    }

    public static ShapeManager getInstance() {
        if (instance == null) {
            instance = new ShapeManager();
        }
        return instance;
    }

    public int createShape(ShapeType type, Color color, double... params) {
        int id = nextID++;
        Shape shape;
        switch (type) {
            case RECTANGLE:
                shape = new Rectangle(id, params[0], params[1], params[2], params[3], color);
                break;
            case CIRCLE:
                shape = new Circle(id, params[0], params[1], params[2], color);
                break;
            default:
                throw new IllegalArgumentException("Unsupported shape type: " + type);
        }
        shapes.add(shape);
        return id;
    }

    public void eraseShape(int id) {
        Shape shape = getShapeById(id);
        if (shape != null) {
            shapes.remove(shape);
        }
    }

    public void eraseAllShapes() {
        shapes.clear();
    }

    public void translateShape(int id, double dx, double dy) {
        Shape shape = getShapeById(id);
        if (shape != null) {
            shape.translate(dx, dy);
        }
    }

    public void translateAllShapes(double dx, double dy) {
        for (Shape shape : shapes) {
            shape.translate(dx, dy);
        }
    }

    public void printAll() {
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
    }

    private Shape getShapeById(int id) {
        for (Shape shape : shapes) {
            if (shape.getId() == id) {
                return shape;
            }
        }
        System.out.println("Shape with id " + id + " not found.");
        return null;
    }
}
