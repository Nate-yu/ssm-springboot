import com.hut.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        StudentController studentController = applicationContext.getBean(StudentController.class);
        studentController.getAllStudent();
        applicationContext.close();
    }
}
