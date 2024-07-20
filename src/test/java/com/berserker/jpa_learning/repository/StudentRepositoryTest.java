package com.berserker.jpa_learning.repository;

import com.berserker.jpa_learning.entity.Guardian;
import com.berserker.jpa_learning.entity.Student;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

  @Autowired private StudentRepository studentRepository;

  @Test
  public void saveStudent() {
    Student student =
        Student.builder()
            .emailAddress("cuongdn.sun@gmail.com")
            .firstName("Cuong")
            .lastName("Do")
            .build();
    studentRepository.save(student);
  }

  @Test
  public void printAllStudents() {
    List<Student> studentList = studentRepository.findAll();
    System.out.println("student list = " + studentList);
  }

  @Test
  public void saveStudentWithGuardian() {
    Guardian guardian =
        Guardian.builder()
            .email("guardianMail@gmail.com")
            .name("adfasf")
            .mobile("12313123")
            .build();
    Student student =
        Student.builder()
            .firstName("Cuongtest 1")
            .emailAddress("cuongdn@test")
            .lastName("asd")
            .guardian(guardian)
            .build();
    studentRepository.save(student);
  }

  @Test
  public void printStudentByFirstName() {
    List<Student> studentList = studentRepository.findByFirstName("Cuongtest 1");
    System.out.println("students = " + studentList);
  }

  @Test
  public void printStudentByFirstNameContaining() {
    List<Student> studentList = studentRepository.findByFirstNameContaining("test");
    System.out.println("students = " + studentList);
  }

  @Test
  public void printGetStundetByEmail() {
    String student = studentRepository.getStudentByEmailAddress("cuongdn@test");
    System.out.println("your result: " + student);
  }

  @Test
  public void findAll() {
    List<Student> studentList = studentRepository.findAllStudents();
    System.out.println("students = " + studentList);
  }

  @Test
  public void updateFirstNameByEmail() {
    int res = studentRepository.updateStudentNameByEmail("Mikami", "cuongdn@test");
    System.out.println("result = " + res);
  }
}
