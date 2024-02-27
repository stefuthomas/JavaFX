package pet.controller;

import javafx.application.Platform;
import pet.model.Pet;
import pet.view.PetView;

public class PetController {
    private PetView gui;
    private Pet pet;

    public PetController(PetView gui) {
        this.pet = new Pet(0,0);
        this.gui = gui;
    }
    public int getPetX() {
        return pet.getX();
    }

    public int getPetY() {
        return pet.getY();
    }

    public void movePet(int x, int y) {
        new Thread (() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            Platform.runLater(() -> {
                pet.move(x, y);
                gui.updateCanvas(pet.getX(), pet.getY());
            });
        }).start();
    }

    public Pet getPet() {
        return pet;
    }
    public static void main(String[] args) {
        PetView.launch(PetView.class, args);
    }
}
