package de.tum.in.ase;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class TUMTriangle extends Application {

    private static final Color PAINT_BLUE = Color.valueOf("#316EB2");
    private static final Color PAINT_WHITE = Color.valueOf("#ffffff");

    private @NonNull List<Triangle> triangles = new ArrayList<>();

    /**
     * Creates the TUM triangle recursively by adding the generated triangles to the triangles
     * to the triangles attribute in the object.
     * @param top The offset from the top
     * @param left The offset from the left
     * @param height The height of the triangle
     * @param depth The recursion depth
     */
    public void createTUMTriangle(double top, double left, double height, int depth) {
        // TODO: Task 1: create the TUM triangle
        if (depth <= 0) {
            return;
        }

        double triovar = left + Math.sqrt(3) * height / 4;


            Point bp1 = new Point(left, top);
            Point bp2 = new Point(left, top + height);
            Point bp3 = new Point(left + Math.sqrt(3) * height / 2, top + (height / 2));
            Triangle blueTrio = new Triangle(bp1, bp2, bp3, PAINT_BLUE);
            triangles.add(blueTrio);


            Point wp1 = new Point(left, top + height / 2);
            Point wp2 = new Point(triovar, top + height / 4);
            Point wp3 = new Point(triovar, top + 3 * height / 4);
            Triangle whiteTrio = new Triangle(wp1, wp2, wp3, PAINT_WHITE);
            triangles.add(whiteTrio);

            createTUMTriangle(top, left, height / 2 , depth - 1);
            createTUMTriangle(top + height / 2, left, height / 2 ,depth - 1);
            createTUMTriangle(top + height / 4, triovar, height / 2 ,depth - 1);


        //createTUMTriangle(top / 4 , left / 4, height / 2 ,depth - 1);
        //createTUMTriangle(3 + top / 4 , left / 4, height / 2 ,depth - 1);

        /*if (depth == 1) {
            Point bp1 = new Point(left, top);
            Point bp2 = new Point(left, top + height);
            Point bp3 = new Point(left + Math.sqrt(3) * height/2, top + (height / 2));
            Triangle blueTrio = new Triangle(bp1, bp2, bp3, PAINT_BLUE);
            triangles.add(blueTrio);

            double triovar = left + Math.sqrt(3) * height / 4;
            Point wp1 = new Point(left, top + height / 2);
            Point wp2 = new Point(triovar, top + height / 4);
            Point wp3 = new Point(triovar, top + 3 * height / 4);
            Triangle whiteTrio = new Triangle(wp1, wp2, wp3, PAINT_WHITE);
            triangles.add(whiteTrio);
        }*/

    }


    @Override
    public void start(Stage stage) {
        this.triangles = new ArrayList<>();

        SimplePad simplePad = new SimplePad(400 * Math.sqrt(3) / 2, 400);
        stage.setTitle("TUM triangle");
        stage.setScene(simplePad);
        stage.setResizable(false);
        stage.show();

        createTUMTriangle(0, 0, 400, 9);

        for (Triangle triangle : triangles) {
            simplePad.drawTriangle(triangle);
        }
    }
}
