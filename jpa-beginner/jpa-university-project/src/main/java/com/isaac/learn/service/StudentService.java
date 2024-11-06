package com.isaac.learn.service;

import com.isaac.learn.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class StudentService {

    private EntityManager em;
    public StudentService(EntityManager em) {this.em = em;}
    public Student saveStudent(Student student) {
        em.persist(student);
        return student;
    }
    public Student findById(Long id){
        return em.find(Student.class, id);
    }
    public void removeStudent(Student student) {
        em.remove(student);
    }

    public Student findByFirstNameAndLastName(String firstName, String lastName) {
      TypedQuery<Student> query= em.createNamedQuery(Student.QUERY_STUDENT_BY_FIRSTNAME_AND_LASTNAME, Student.class);
      query.setParameter(Student.PARAM_FIRSTNAME, firstName);
      query.setParameter(Student.PARAM_LASTNAME, lastName);
      return query.getSingleResult();
    }
}
