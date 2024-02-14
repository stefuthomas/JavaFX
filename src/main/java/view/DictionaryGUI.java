package view;

import controller.DictionaryController;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class DictionaryGUI extends Application {
    private Label result = new Label("");
    private DictionaryController controller;
    TextField searchField = new TextField();
    TextField addField = new TextField();
    TextField addMeaningField = new TextField();
    public void start(Stage stage) {
        Button searchButton = new Button("Search");
        Button addButton = new Button("Add");

        searchField.setPromptText("Search");
        addField.setPromptText("Add word");
        addMeaningField.setPromptText("Add meaning");

        FlowPane searchPane = new FlowPane();
        FlowPane addPane = new FlowPane();

        stage.setTitle("Dictionary");

        Insets insets = new Insets(10, 10, 10, 10);
        searchPane.setMargin(searchField, insets);
        searchPane.setMargin(searchButton, insets);
        addPane.setMargin(addField, insets);
        addPane.setMargin(addMeaningField, insets);

        result.setMinWidth(50);
        result.setAlignment(Pos.CENTER);

        searchPane.getChildren().add(searchField);
        searchPane.getChildren().add(searchButton);
        addPane.getChildren().add(addField);
        addPane.getChildren().add(addMeaningField);
        addPane.getChildren().add(addButton);
        searchPane.getChildren().add(result);
        VBox layout = new VBox();
        layout.getChildren().addAll(searchPane, addPane);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    controller.searchWord();
                    if (result.getText().equals("Word not found")) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    result.setText("Word not found");
                }
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (addField.getText().equals("") || addMeaningField.getText().equals("")) {
                    result.setText("Please enter a word and its meaning");
                } else {
                    controller.addWord();
                }
            }
        });

        stage.show();
    }

    public void init() {
        controller = new DictionaryController(this);
    }
    public String getWord() {
        return searchField.getText();
    }
    public void setResult(String meaning) {
        this.result.setText(meaning);
    }

    public String setWord() {
        return addField.getText();
    }

    public String setMeaning() {
        return addMeaningField.getText();
    }
}
