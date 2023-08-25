package hello.proxy.app.study.dto;

import lombok.*;

//@AllArgsConstructor

//@Setter
@Getter
//@NoArgsConstructor
public class Person {

    public Person() {
        this.name = "명진";
    }

    private String name;
    private int age;
    private int height;
    private int weight;


}
