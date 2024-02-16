package converter.view;

import converter.controller.ConverterController;
import converter.model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.List;

public class ConverterGUI extends Application {
    private ConverterController controller;
    private BorderPane layout = new BorderPane();
    private HBox top = new HBox();
    private ComboBox<String> currencyFrom = new ComboBox<>();
    private ComboBox<String> currencyTo = new ComboBox<>();
    private TilePane conversion = new TilePane();
    private TextField currencyAmount = new TextField();
    private Label currencyResult = new Label();
    public void start(Stage stage) {
        top.setAlignment(Pos.CENTER);
        top.setSpacing(50);

        controller.passCurrencyNamesToGui();

        layout.setTop(top);
        BorderPane.setMargin(top, new Insets(10, 10, 10, 10));

        conversion.setAlignment(Pos.CENTER);

        currencyAmount.setPromptText("Input amount");
        currencyResult.setText("Nothing yet...");

        conversion.getChildren().add(currencyAmount);
        conversion.getChildren().add(currencyResult);

        Button convertButton = new Button("Convert");
        conversion.getChildren().add(convertButton);

        layout.setCenter(conversion);
        BorderPane.setMargin(conversion, new Insets(10, 10, 10, 10));

        Scene scene = new Scene(layout);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();

        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                try {
                    if (currencyAmount.getText().isEmpty()) {
                        throw new Exception();
                    }
                double amount = Double.parseDouble(currencyAmount.getText());
                String from = currencyFrom.getValue();
                String to = currencyTo.getValue();
                controller.convert(amount, from, to);
            }
            catch (Exception e) {
                currencyResult.setText("Amount field is empty!");
            }
            }
        });

        stage.show();
    }

    public void setCurrencyNames(List<String> currencyNames) {
        currencyFrom.setItems(FXCollections.observableArrayList(currencyNames));
        currencyTo.setItems(FXCollections.observableArrayList(currencyNames));
        currencyFrom.setValue(currencyNames.get(0));
        currencyTo.setValue(currencyNames.get(1));
        top.getChildren().addAll(currencyFrom, currencyTo);

    }

    public void init() {
        controller = new ConverterController(this);
    }

    public void setResult(String result) {
        currencyResult.setText(result);
    }
}