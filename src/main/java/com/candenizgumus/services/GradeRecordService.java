package com.candenizgumus.services;

import com.candenizgumus.repository.GradeRecordRepository;

public class GradeRecordService
{
    GradeRecordRepository gradeRecordRepository;

    public GradeRecordService()
    {
        this.gradeRecordRepository = new GradeRecordRepository();
    }
}
