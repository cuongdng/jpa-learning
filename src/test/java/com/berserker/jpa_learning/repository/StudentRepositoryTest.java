package com.berserker.jpa_learning.repository;

import com.berserker.jpa_learning.entity.Student;
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
            .guardianName("DoVanCuong")
            .guardianEmail("cuongdovan@gmail.com")
            .guardianMobile("0389345944")
            .build();
  }
}
