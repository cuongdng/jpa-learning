package com.berserker.jpa_learning.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
  @Id
  @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
  private Long courseId;

  private String title;
  private Integer credits;

  @OneToOne(mappedBy = "course")
  private CourseMaterial courseMaterial;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
  private Teacher teacher;
}
