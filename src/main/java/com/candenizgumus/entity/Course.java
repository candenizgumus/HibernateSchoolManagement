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
        name = "Course.averageGradeByTeacher",
        query = "SELECT gr.course, AVG(gr.grade) FROM GradeRecord gr WHERE gr.course.teacher.id = :teacherId GROUP BY gr.course"
)





@Table(name = "tblcourse")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String coursename;
    String coursecode;
    Integer credit;
    @ManyToOne
    Teacher teacher;
    @ManyToMany
    List<Student> students;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Course{")
                .append("id=").append(id)
                .append(", coursename='").append(coursename).append('\'')
                .append(", coursecode='").append(coursecode).append('\'')
                .append(", credit=").append(credit);

        if (teacher != null) {
            stringBuilder.append(", teacher=").append(teacher.getName());
        } else {
            stringBuilder.append(", teacher=null");
        }

        stringBuilder.append(", students=[");
        if (students != null) {
            for (Student student : students) {
                stringBuilder.append(student.getName()).append(", ");
            }
        }
        stringBuilder.append("]}");

        return stringBuilder.toString();
    }

}
