import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stage2.Student;

public class AddStudentTests extends Student{
    Student student = new Student();
    @ParameterizedTest()
    @ValueSource(strings = {"J", "j", "He-", "1", "He1", "He--h"})
    public void invalidFirstLastName(String name){
        Assertions.assertFalse(student.validateString(name));
    }

    @ParameterizedTest()
    @ValueSource(strings = {"James", "ja", "He", "on", "He-e", "He'h", "JXOr"})
    public void validFirstLastName(String name){
        Assertions.assertTrue(student.validateString(name));
    }

    @Test
    public void incorrectCredentialsError(){
        Assertions.assertEquals(student.studentValidation("exit"),"Incorrect credentials.");
    }

    @Test
    public void incorrectFirstNameError(){
        Assertions.assertEquals(student.studentValidation("V Vovan 123@mail.com"),"Incorrect first name.");
    }

    @Test
    public void incorrectLastNameError(){
        Assertions.assertEquals(student.studentValidation("Vova V 123@mail.com"),"Incorrect last name.");
    }

    @Test
    public void incorrectEmailError(){
        Assertions.assertEquals(student.studentValidation("Vova Vovan 123mail.com"),"Incorrect email.");
    }

    @Test
    public void checkValidUser(){
        Assertions.assertEquals(student.studentValidation("Vova Vovan 123@mail.com"),"Valid");
    }
}
