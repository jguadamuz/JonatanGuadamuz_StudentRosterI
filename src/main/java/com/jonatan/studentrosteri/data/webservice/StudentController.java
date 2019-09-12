package com.jonatan.studentrosteri.data.webservice;

import java.util.ArrayList;
import java.util.List;

import com.jonatan.studentrosteri.data.entity.Student;
import com.jonatan.studentrosteri.data.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * StudentController
 */
@RestController
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @RequestMapping(value = "/ws/students", method = RequestMethod.GET)
    List<Student> findAll(@RequestParam(required = false) String lastName) {
        List<Student> students = new ArrayList<>();
        if (null == lastName) {
            Iterable<Student> results = this.repository.findAll();
            results.forEach(student-> {students.add(student);});
        } else {
            Student student = this.repository.findStudentByLastName(lastName);
            if (null != student) {
                students.add(student);
            }
        }
        return students;
    }

    @RequestMapping(value = "/ws/students/add", method = RequestMethod.POST)
    void addStudent (@RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "lastName", required = false) String lastName,
            @RequestParam(name = "age", required = false) String age) {
        
        System.out.println("jona: " + name + lastName + age);
        Student s = new Student();
        s.setFirstName(name);
        s.setLastName(lastName);
        s.setAge(Integer.parseInt(age));

        this.repository.save(s);

    }
}