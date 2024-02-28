package notebook.controller;

import notebook.model.Notebook;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import notebook.view.NotebookGUI;

public class NotebookController {
    @FXML
    private TextArea noteField;
    @FXML
    private TextField titleField;
    @FXML
    private TextArea savedNotes;
    @FXML
    private Button addButton;
    private Notebook notebook;

    @FXML
    public void initialize() {
        notebook = new Notebook();
        addButton.setOnAction(event -> createNote());
    }

    private void createNote() {
        String title = titleField.getText();
        String note = noteField.getText();
        notebook.addNote(title, note);
        addNote();
    }

    private void addNote() {
        savedNotes.appendText(notebook.getNoteTitle()+ "\n" + notebook.getNoteContent() + "\n");
    }

    public static void main(String[] args) {
        NotebookGUI.launch(NotebookGUI.class);
    }
}
