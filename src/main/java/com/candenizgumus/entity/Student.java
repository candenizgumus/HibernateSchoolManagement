package com.candenizgumus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@NamedQuery(
        name = "Student.countByDepartment",
        query = "SELECT s.department, COUNT(s) FROM Student s GROUP BY s.department"
)
@Table(name = "tblstudent")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String studentnumber;
    String department;
    @ManyToMany(mappedBy = "students")
    List<Course> enrolledcourses;

}
