package hello.proxy.app.study.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

public class Student extends Person {

    private String studentId;
    private String grade;

    public Student() {
        super();
        this.studentId = "명진입니다";
    }

    public void show() {
        //상속 받은 person 에 대한 필드값을 바로 사용함
        System.out.println("학생 이름 X : " + getName());
        System.out.println("학생 나이 : " + getAge());
        System.out.println("학생 이름 : " + getHeight());
        System.out.println("학생 이름 : " + getWeight());

        //student 클레스 안에만 있는 필드 및 함수 사용
        System.out.println("학생 학번 : " + getStudentId());
        System.out.println("학생 학년 : " + getGrade());
    }

    public String getStudentId() {
        return studentId;
    }

    public String getGrade() {
        return grade;
    }
}
