package pet.model;

import javafx.scene.image.*;
public class Pet {
    private int x;
    private int y;
    private final int width = 50;
    private final int height = 50;
    private Image image = new Image("file:src/main/resources/pet.png");
    private ImageView petImage;
    public Pet(int x, int y) {
        this.x = x;
        this.y = y;
        this.petImage = new ImageView(image);
        petImage.setFitWidth(width);
        petImage.setFitHeight(height);
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public Image getImage() {
        return image;
    }
}
