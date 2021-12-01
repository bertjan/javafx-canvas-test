package eu.openvalue;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    GraphicsContext createCanvasContext(int width, int height, Stage stage) {
        Canvas canvas = new Canvas(width, height);
        GraphicsContext context = canvas.getGraphicsContext2D();
        Group root = new Group();
        stage.setScene(new Scene(root));
        root.getChildren().add(context.getCanvas());
        return context;
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Canvas test");
        GraphicsContext context = createCanvasContext(640, 480, stage);
        stage.show();
        drawShapes(context);
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
    }

}
