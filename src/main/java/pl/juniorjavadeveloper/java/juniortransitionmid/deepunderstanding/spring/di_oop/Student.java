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

    public void notebookPages(int pages) {
        notebook.setPages(pages);
    }

    public void startNote(String noteContent, int page) {
        notebook.goToPage(page);
        notebook.writeNoteContent(noteContent);
    }

    @Override
    public String toString() {
        return "Student{" +
                "notebook=" + notebook +
                '}';
    }
}
