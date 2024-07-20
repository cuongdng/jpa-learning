package com.berserker.jpa_learning.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.berserker.jpa_learning.entity.Course;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseRepositoryTest {
  @Autowired private CourseRepository courseRepository;

  @Test
  public void printCourses() {
    List<Course> courses = courseRepository.findAll();
    System.out.println("course: " + courses);
  }
}
