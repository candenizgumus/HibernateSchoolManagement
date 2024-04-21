package com.candenizgumus;

import com.candenizgumus.entity.Course;
import com.candenizgumus.entity.GradeRecord;
import com.candenizgumus.entity.Student;
import com.candenizgumus.entity.Teacher;
import com.candenizgumus.repository.CourseRepository;
import com.candenizgumus.repository.GradeRecordRepository;
import com.candenizgumus.repository.StudentRepository;
import com.candenizgumus.repository.TeacherRepository;
import com.candenizgumus.services.CourseService;
import com.candenizgumus.services.StudentService;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        StudentRepository studentRepository = new StudentRepository();
        CourseRepository courseRepository = new CourseRepository();
        TeacherRepository teacherRepository = new TeacherRepository();
        GradeRecordRepository gradeRecordRepository = new GradeRecordRepository();
        StudentService studentService = new StudentService();


        /*
        Student student = Student.builder()
                .name("Ayse")
                .studentnumber("103")
                .department("Civil Engineering")
                .build();

        Course course1 = Course.builder()
                .coursename("Sosyal")
                .coursecode("102")
                .credit(3)
                .build();

        Course course2 = Course.builder()
                .coursename("Kimya")
                .coursecode("103")
                .credit(5)
                .build();



        Teacher teacher = Teacher.builder()
                .name("Ahmet")
                .teachernumber("106")
                .department("Tarih")

                .build();


        GradeRecord gradeRecord1 = GradeRecord.builder()
                .student(student)
                .course(course2)
                .grade(95.5d)
                .build();




        student.setEnrolledcourses(List.of(course1,course2));


        course1.setStudents(List.of(student));
        course2.setStudents(List.of(student));

        course1.setStudents(List.of(student));
        course2.setStudents(List.of(student));

        course1.setTeacher((teacher));
        course2.setTeacher((teacher));


        teacher.setCourses(List.of(course1,course2));


        studentRepository.save(student);
        teacherRepository.save(teacher);
        courseRepository.save(course1);
        courseRepository.save(course2);
        gradeRecordRepository.save(gradeRecord1);*/


        studentRepository.findEnrolledCoursesByStudentId(2L).forEach(System.out::println);
        System.out.println(courseRepository.countStudentsInCourse(2L));
        System.out.println(courseRepository.findAverageGradeByTeacher(2L));
        System.out.println(studentRepository.findStudentsByDepartment("Civil Engineering"));
        System.out.println(courseRepository.findTeachersWithCoursesCreditGreaterThanThree());
        System.out.println(gradeRecordRepository.findGradesByStudent(4L));
        gradeRecordRepository.printHighestGrade();
        System.out.println(courseRepository.findDepartmentByCourseName("Fizik"));
        studentRepository.printStudentsByCourseName("Matematik");
        studentRepository.printStudentCountsByDepartment();


    }
}