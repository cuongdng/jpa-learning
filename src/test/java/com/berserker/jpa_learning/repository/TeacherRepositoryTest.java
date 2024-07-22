package com.berserker.jpa_learning.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.berserker.jpa_learning.entity.Course;
import com.berserker.jpa_learning.entity.Teacher;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {
  @Autowired private TeacherRepository teacherRepository;

  @Test
  public void saveTeacher() {
    Course course = Course.builder().title("DBA").credits(5).build();
    Course courseJava = Course.builder().title("Java 8").credits(10).build();
    Teacher teacher = Teacher.builder().firstName("Issac").lastName("Newton").build();
    teacherRepository.save(teacher);
  }

  @Test
  public void findAll() {
    List<Teacher> teachers = teacherRepository.findAll();
    System.out.println("All teachers: " + teachers);
  }
}
