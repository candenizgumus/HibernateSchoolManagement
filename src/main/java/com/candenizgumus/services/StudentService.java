package com.candenizgumus.services;

import com.candenizgumus.entity.Course;
import com.candenizgumus.repository.StudentRepository;
import jakarta.persistence.Query;

import java.util.List;

public class StudentService
{
    StudentRepository studentRepository;

    public StudentService()
    {
        this.studentRepository = new StudentRepository();
    }


}
