package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.spring.without_boot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.spring.di_oop.Student;

public class SpringApplicationWithoutSpringBoot {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(
                        "pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.spring");

        Student firstStudentBean = applicationContext.getBean(Student.class);
        firstStudentBean.notebookPages(100);

        Student secondStudentBean = applicationContext.getBean(Student.class);
        secondStudentBean.notebookPages(60);
        secondStudentBean.startNote("Hello World!", 11);
    }
}
