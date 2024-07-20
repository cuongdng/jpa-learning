package com.berserker.jpa_learning.repository;

import com.berserker.jpa_learning.entity.Student;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  List<Student> findByFirstName(String firstName);

  List<Student> findByFirstNameContaining(String firstName);

  @Query("select s.firstName from Student s where s.emailAddress = ?1")
  String getStudentByEmailAddress(String EmailId);

  @Query(value = "select * from tbl_student", nativeQuery = true)
  List<Student> findAllStudents();

  @Modifying
  @Transactional
  @Query(
      value = "update tbl_student set first_name = ?1 where email_address = ?2",
      nativeQuery = true)
  int updateStudentNameByEmail(String firstName, String email);
}
