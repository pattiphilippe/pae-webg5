package patti.philippe.recap.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    private BeanValidationUtil<Student> validator;

    @Test
    public void isValid(){
        Student student = new Student(40111, "Philippe", 3, Section.G);
        validator.assertIsValid(student);
    }
}