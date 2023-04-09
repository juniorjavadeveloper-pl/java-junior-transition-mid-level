package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.spring.di_oop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Student {
    private final Notebook notebook;

    public Student(Notebook notebook) {
        this.notebook = notebook;
    }

    void startNote(String noteContent, int page) {
        notebook.goToPage(page);
        notebook.writeNoteContent(noteContent);
    }
}
