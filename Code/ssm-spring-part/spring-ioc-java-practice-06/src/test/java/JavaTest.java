import com.hut.config.JavaConfig;
import com.hut.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController controller = applicationContext.getBean(StudentController.class);
        controller.getAllStudent();
        applicationContext.close();
    }
}
