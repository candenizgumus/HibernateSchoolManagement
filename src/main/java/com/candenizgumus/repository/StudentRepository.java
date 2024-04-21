package com.candenizgumus.repository;


import com.candenizgumus.entity.Course;
import com.candenizgumus.entity.Student;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentRepository extends RepositoryManager<Student,Long>
{

    public StudentRepository()
    {
        super(Student.class);
    }

    public List<Course> findEnrolledCoursesByStudentId(Long studentId) {
        Query query = getEntityManager().createQuery(
                "SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId");
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    public List<Student> findStudentsByDepartment(String departmentName) {
        Query query = getEntityManager().createNativeQuery(
                "SELECT * FROM tblstudent WHERE department = :departmentName", Student.class);
        query.setParameter("departmentName", departmentName);
        return query.getResultList();
    }

    public void printStudentsByCourseName(String courseName) {
        String jpql = "SELECT s.name, s.studentnumber FROM Student s JOIN s.enrolledcourses c WHERE c.coursename = :courseName";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("courseName", courseName);
        List<Object[]> students = query.getResultList();
        for (Object[] student : students) {
            String name = (String) student[0];
            String studentNumber = (String) student[1];
            System.out.println("Öğrenci Adı: " + name + ", Öğrenci Numarası: " + studentNumber);
        }
    }

    public void printStudentCountsByDepartment() {
        TypedQuery<Object[]> query = getEntityManager().createNamedQuery("Student.countByDepartment", Object[].class);
        List<Object[]> studentCounts = query.getResultList();
        for (Object[] result : studentCounts) {
            String department = (String) result[0];
            long studentCount = (long) result[1];
            System.out.println(department + " bölümünde " + studentCount + " öğrenci bulunmaktadır.");
        }
    }
}
