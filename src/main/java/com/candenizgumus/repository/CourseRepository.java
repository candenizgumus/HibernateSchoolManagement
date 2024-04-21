package com.candenizgumus.repository;

import com.candenizgumus.entity.Course;
import com.candenizgumus.entity.Teacher;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.List;

public class CourseRepository extends RepositoryManager<Course,Long>
{

    public CourseRepository()
    {
        super(Course.class);
    }

    public Long countStudentsInCourse(Long courseId) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);

        Root<Course> courseRoot = query.from(Course.class);

        // Dersin ID'sine göre filtreleme
        Predicate courseIdPredicate = criteriaBuilder.equal(courseRoot.get("id"), courseId);

        // Öğrenci listesini almak için birleştirme
        courseRoot.join("students", JoinType.INNER);

        // Dersin öğrenci sayısını saymak
        Expression<Long> countExpression = criteriaBuilder.count(courseRoot.get("id"));

        query.select(countExpression)
                .where(courseIdPredicate);

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public Double findAverageGradeByTeacher(Long teacherId) {
        Query query = getEntityManager().createNamedQuery("Course.averageGradeByTeacher");
        query.setParameter("teacherId", teacherId);
        List<Object[]> resultList = query.getResultList();
        Double averageGrade = null;
        if (!resultList.isEmpty()) {
            Object[] result = resultList.get(0);
            averageGrade = (Double) result[1];
        }
        return averageGrade;
    }

    public List<Teacher> findTeachersWithCoursesCreditGreaterThanThree() {
        String jpql = "SELECT DISTINCT t FROM Course c JOIN c.teacher t WHERE c.credit > 3";
        TypedQuery<Teacher> query = getEntityManager().createQuery(jpql, Teacher.class);
        return query.getResultList();
    }

    public String findDepartmentByCourseName(String courseName) {
        String sql = "SELECT t.department FROM tblteacher t JOIN tblcourse c ON t.id = c.teacher_id WHERE c.coursename = :courseName";
        Query query = getEntityManager().createNativeQuery(sql);
        query.setParameter("courseName", courseName);
        List<String> result = query.getResultList();
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

}
