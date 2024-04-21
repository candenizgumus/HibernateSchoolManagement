package com.candenizgumus.services;

import com.candenizgumus.repository.CourseRepository;

public class CourseService
{
    CourseRepository courseRepository;

    public CourseService()
    {
        this.courseRepository = new CourseRepository();
    }
}
