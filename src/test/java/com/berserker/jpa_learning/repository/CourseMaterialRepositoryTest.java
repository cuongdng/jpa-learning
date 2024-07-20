package com.berserker.jpa_learning.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.berserker.jpa_learning.entity.Course;
import com.berserker.jpa_learning.entity.CourseMaterial;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {
  @Autowired private CourseMaterialRepository repository;

  @Test
  public void saveCourseMaterial() {
    Course course = Course.builder().title("DSA").credits(6).build();

    CourseMaterial courseMaterial =
        CourseMaterial.builder().url("www.google.com").course(course).build();
    repository.save(courseMaterial);
  }

  @Test
  public void printAllCoursesMaterial() {
    List<CourseMaterial> courseMaterials = repository.findAll();
    System.out.println("Course Material List: " + courseMaterials);
  }
}
