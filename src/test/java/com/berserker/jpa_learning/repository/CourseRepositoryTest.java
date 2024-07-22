package com.berserker.jpa_learning.repository;

import com.berserker.jpa_learning.entity.Course;
import com.berserker.jpa_learning.entity.Teacher;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseRepositoryTest {
  @Autowired private CourseRepository courseRepository;

  @Test
  public void saveCourse() {
    Teacher teacher = Teacher.builder().lastName("Do").firstName("Cuong").build();
    Course course = Course.builder().title("AWS").credits(2).teacher(teacher).build();
    courseRepository.save(course);
  }

  @Test
  public void printCourses() {
    List<Course> courses = courseRepository.findAll();
    System.out.println("course: " + courses);
  }

  public void saveCourseWithTeacher() {
    Course course = Course.builder().title("AWS").credits(2).teacher(null).build();
  }
}
