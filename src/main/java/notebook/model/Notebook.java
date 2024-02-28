package notebook.model;

import java.util.ArrayList;
import java.util.List;

class Note {
    String title;
    String note;
    public Note(String title, String note) {
        this.title = title;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }
}
public class Notebook {
    private List<Note> notes = new ArrayList<>();
    public void addNote(String title, String note) {
        notes.add(new Note(title, note));
    }

    public String getNoteTitle() {
        return notes.get(notes.size()-1).title;
    }

    public String getNoteContent() {
        return notes.get(notes.size()-1).note;
    }
}
