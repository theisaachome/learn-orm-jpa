package com.isaac.learn.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ManyToManyStudentCourseTest {

    static EntityManagerFactory emf ;

    @BeforeAll
    static  void init(){
        emf = Persistence.createEntityManagerFactory("default");
    }
    @AfterAll
    static void close(){
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }


    @Test
    public void manageManyToManyAssociation() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // get the primary key of a course and a professor
        Long courseId1 = createCourse();
        Long courseId2 = createCourse();
        Long studentId1 = createStudent();
        Long studentId2 = createStudent();

        // load Course entities by primary key
        Course course1 = em.find(Course.class, courseId1);
        Course course2 = em.find(Course.class, courseId2);

        // load Student entities by primary key
        Student student1 = em.find(Student.class, studentId1);
        Student student2 = em.find(Student.class, studentId2);

        // add the associations
        course1.getStudents().add(student1);
        student1.getCourses().add(course1);
        course1.getStudents().add(student2);
        student2.getCourses().add(course1);

        course2.getStudents().add(student2);
        student2.getCourses().add(course2);

        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void readAndUpdateAssociation() {
        Long courseId = prepareTestData();

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Course course = em.find(Course.class, courseId);

        // get all students of this course
        for (Student student : course.getStudents()) {
            System.out.println(student.getName());
        }


        // unenroll a student from this course
        Student student = (Student) course.getStudents().toArray()[0];
        course.unenrollStudent(student);

        em.getTransaction().commit();
        em.close();
    }

    private Long createCourse() {
        return createCourse("Software Development 1");
    }

    private Long createCourse(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Course course = new Course();
        course.setName(name);
        course.setStartDate(LocalDate.of(2018, 8, 15));
        course.setEndDate(LocalDate.of(2019, 5, 31));
        em.persist(course);

        em.getTransaction().commit();
        em.close();

        return course.getId();
    }

    private Long createStudent() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student s = new Student();
        s.setName("Peter Doe");
        em.persist(s);

        em.getTransaction().commit();
        em.close();

        return s.getId();
    }

    private Long prepareTestData() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // get the primary key of a course and a professor
        Long courseId1 = createCourse();
        Long courseId2 = createCourse();
        Long studentId1 = createStudent();
        Long studentId2 = createStudent();

        // load Course entities by primary key
        Course course1 = em.find(Course.class, courseId1);
        Course course2 = em.find(Course.class, courseId2);

        // load Student entities by primary key
        Student student1 = em.find(Student.class, studentId1);
        Student student2 = em.find(Student.class, studentId2);

        // add the associations
        course1.getStudents().add(student1);
        student1.getCourses().add(course1);
        course1.getStudents().add(student2);
        student2.getCourses().add(course1);

        course2.getStudents().add(student2);
        student2.getCourses().add(course2);

        em.getTransaction().commit();
        em.close();

        return course1.getId();
    }
}
