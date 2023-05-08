package Utils;

import Editor.Editor;
import Shapes.Circle;
import Shapes.Enums.ShapeType;
import Shapes.Interfaces.Shape;
import Shapes.Manager.ShapeManager;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SVGParser {
    public SVGParser(String filename) throws IOException {
        List<String> lines = Editor.getInstance().getContent();
        for (String line : lines) {
            String[] tokens = line.split("\\s+");

            if (tokens.length < 2) {
                continue;
            }
            ShapeType type = ShapeType.valueOf(tokens[0].toUpperCase());

            switch (type) {
                case RECTANGLE: {
                    double x = Double.parseDouble(tokens[1]);
                    double y = Double.parseDouble(tokens[2]);
                    double width = Double.parseDouble(tokens[3]);
                    double height = Double.parseDouble(tokens[4]);
                    Color fillColor = Color.decode(tokens[5]);
                    double[] params = new double[] {x, y, width, height};

                    ShapeManager.getInstance().createShape(ShapeType.RECTANGLE, fillColor, params);

                    break;
                }
                case CIRCLE: {
                    double cx = Double.parseDouble(tokens[1]);
                    double cy = Double.parseDouble(tokens[2]);
                    double radius = Double.parseDouble(tokens[3]);
                    Color fillColor = Color.decode(tokens[4]);
                    double[] params = new double[] {cx, cy, radius};

                    ShapeManager.getInstance().createShape(ShapeType.CIRCLE, fillColor, params);

                    break;
                }
                default:
                    System.err.println("Unsupported shape type: " + tokens[0]);
                    break;
            }
        }
        /*
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("<circle")) {
                String[] parts = line.split("\"");
                double cx = Double.parseDouble(parts[1]);
                double cy = Double.parseDouble(parts[3]);
                double r = Double.parseDouble(parts[5]);
                Color color = Color.decode(parts[7]);
                double[] params = new double[] {cx, cy, r};
                ShapeManager.getInstance().createShape(ShapeType.CIRCLE, color, params);
            }

            // Add more shape types here as needed
        }

         */
    }

}
