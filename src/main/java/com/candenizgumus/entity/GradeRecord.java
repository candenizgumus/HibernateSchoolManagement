package com.candenizgumus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@NamedQuery(
        name = "GradeRecord.findGradesByStudent",
        query = "SELECT gr FROM GradeRecord gr WHERE gr.student.id = :studentId"
)
@Table(name = "tblgraderecord")
public class GradeRecord
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    Student student;
    @ManyToOne
    Course course;
    Double grade;
}
