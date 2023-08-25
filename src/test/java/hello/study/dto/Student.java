package hello.study.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
//@NoArgsConstructor
public class Student extends Person{

    private String studentId;
    private String grade;
    private String GPA;

//    public Student(String name, int age, int height, int weight, String studentId, String grade, String GPA) {
//        super(name, age, height, weight);
//        this.studentId = studentId;
//        this.grade = grade;
//        this.GPA = GPA;
//    }

//    public String getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(String studentId) {
//        this.studentId = studentId;
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
//
//    public String getGPA() {
//        return GPA;
//    }
//
//    public void setGPA(String GPA) {
//        this.GPA = GPA;
//    }
//
//    @Override
//    public String getName() {
//        return super.getName();
//    }
//
//    @Override
//    public void setName(String name) {
//        super.setName(name);
//    }
//
//    @Override
//    public int getAge() {
//        return super.getAge();
//    }
//
//    @Override
//    public void setAge(int age) {
//        super.setAge(age);
//    }
//
//    @Override
//    public int getHeight() {
//        return super.getHeight();
//    }
//
//    @Override
//    public void setHeight(int height) {
//        super.setHeight(height);
//    }
//
//    @Override
//    public int getWeight() {
//        return super.getWeight();
//    }
//
//    @Override
//    public void setWeight(int weight) {
//        super.setWeight(weight);
//    }

    public void show() {
        //상속 받은 person 에 대한 필드값을 바로 사용함
        System.out.println("학생 이름 : " + getName());
        System.out.println("학생 나이 : " + getAge());
        System.out.println("학생 이름 : " + getHeight());
        System.out.println("학생 이름 : " + getWeight());

        //student 클레스 안에만 있는 필드 및 함수 사용
        System.out.println("학생 학번 : " + getStudentId());
        System.out.println("학생 학년 : " + getGrade());
        System.out.println("학생 학점 : " + getGPA());
    }
}
