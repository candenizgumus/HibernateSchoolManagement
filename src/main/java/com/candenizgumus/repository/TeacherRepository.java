package com.candenizgumus.repository;


import com.candenizgumus.entity.Teacher;

public class TeacherRepository extends RepositoryManager<Teacher,Long>
{

    public TeacherRepository()
    {
        super(Teacher.class);
    }
}
