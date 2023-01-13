package stage3;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private static final AtomicInteger ID = new AtomicInteger(-1);
    private int id;
    private int java;
    private int dsa;
    private int dataBase;
    private int spring;

    public Student (String firstName, String lastName, String email) {
        this.id = ID.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
