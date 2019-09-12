package com.jonatan.studentrosteri.data.repository;

import com.jonatan.studentrosteri.data.entity.Student;

import org.springframework.data.repository.CrudRepository;

/**
 * StudentRepository
 */
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findStudentByLastName(String lastName);
    
}
