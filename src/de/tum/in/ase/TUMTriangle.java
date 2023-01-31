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
     * @param top The offset from the top (contingency commit necessary)!
     * @param left The offset from the left
     * @param height The height of the triangle
     * @param depth The recursion depth
     */
    public void createTUMTriangle(double top, double left, double height, int depth) {
        // TODO: Task 1: create the TUM triangle
    }


    @Override
    public void start(Stage stage) {
        this.triangles = new ArrayList<>();

        SimplePad simplePad = new SimplePad(400 * Math.sqrt(3) / 2, 400);
        stage.setTitle("TUM triangle");
        stage.setScene(simplePad);
        stage.setResizable(false);
        stage.show();

        createTUMTriangle(0, 0, 400, 4);

        for (Triangle triangle : triangles) {
            simplePad.drawTriangle(triangle);
        }
    }
}
