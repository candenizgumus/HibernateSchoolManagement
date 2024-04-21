package com.candenizgumus.repository;


import com.candenizgumus.entity.GradeRecord;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;

import java.util.List;

public class GradeRecordRepository extends RepositoryManager<GradeRecord,Long>
{

    public GradeRecordRepository()
    {
        super(GradeRecord.class);
    }

    public List<GradeRecord> findGradesByStudent(Long studentId) {
        Query query = getEntityManager().createNamedQuery("GradeRecord.findGradesByStudent", GradeRecord.class);
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    public void printHighestGrade() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
        Root<GradeRecord> root = query.from(GradeRecord.class);

        Subquery<Double> subquery = query.subquery(Double.class);
        Root<GradeRecord> subRoot = subquery.from(GradeRecord.class);
        subquery.select(criteriaBuilder.max(subRoot.get("grade")));

        Predicate condition = criteriaBuilder.equal(root.get("grade"), subquery);

        query.multiselect(root.get("student").get("name"), root.get("grade")).where(condition);

        List<Object[]> results = getEntityManager().createQuery(query).getResultList();
        if (!results.isEmpty()) {
            Object[] result = results.get(0);
            String studentName = (String) result[0];
            Double grade = (Double) result[1];
            System.out.println("En yüksek notu alan öğrenci: " + studentName);
            System.out.println("Notu: " + grade);
        } else {
            System.out.println("Herhangi bir öğrenciye ait not kaydı bulunamadı.");
        }
    }
}
