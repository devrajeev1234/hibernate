package klh.exp_4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import klh.exp_4.Student;
public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Applicationcontext.xml");

        Student student = context.getBean("student", Student.class);
        student.display();
    }
}
