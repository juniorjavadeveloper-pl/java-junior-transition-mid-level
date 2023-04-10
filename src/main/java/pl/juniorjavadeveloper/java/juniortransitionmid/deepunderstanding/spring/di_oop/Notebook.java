package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.spring.di_oop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
@Scope(value = "prototype")
public class Notebook {
    private static final Logger LOGGER = Logger.getLogger(Notebook.class.getName());

    protected int pages;
    protected int currentPage;
    protected Map<Integer, String> contents = new HashMap<>();

    public void setPages(int pages) {
        LOGGER.info("setPages(" + pages + ")");
        this.pages = pages;
    }

    public void writeNoteContent(String noteContent) {
        LOGGER.info("writeNoteContent(" + noteContent + ")");
        contents.merge(currentPage, noteContent,
                (oldContent, newContent)
                        -> oldContent + " " + newContent);

        LOGGER.info("Notebook - append note content" +
                " to the current page: " + noteContent);
    }

    public void goToPage(int page) {
        LOGGER.info("startNote(" + page + ")");
        if (page < pages) {
            currentPage = page;
        }
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "pages=" + pages +
                ", currentPage=" + currentPage +
                ", contents=" + contents +
                '}';
    }
}
