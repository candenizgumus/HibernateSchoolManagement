package com.candenizgumus.services;

import com.candenizgumus.repository.TeacherRepository;

public class TeacherService
{
    TeacherRepository teacherRepository;

    public TeacherService()
    {
        this.teacherRepository = new TeacherRepository();
    }
}
