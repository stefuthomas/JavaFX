package pet.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pet.controller.PetController;

public class PetView extends Application {
    private Canvas canvas;
    private GraphicsContext gc;
    private PetController controller;
    public void start(Stage primaryStage) {
        controller = new PetController(this);
        canvas = new Canvas(400, 400);
        gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 600, 600);

        canvas.setOnMouseMoved(event -> {
            controller.movePet((int) event.getX(), (int) event.getY());
        });

        primaryStage.setTitle("Gorilla");
        primaryStage.setScene(scene);
        primaryStage.show();
        updateCanvas(controller.getPetX(), controller.getPetY());
    }

    public void updateCanvas(int petX, int petY) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.drawImage(controller.getPet().getImage(), petX, petY, controller.getPet().getWidth(), controller.getPet().getHeight());
    }

    public int getCanvasWidth() {
        return (int) canvas.getWidth();
    }

    public int getCanvasHeight() {
        return (int) canvas.getHeight();
    }
}