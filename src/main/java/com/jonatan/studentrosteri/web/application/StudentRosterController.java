package com.jonatan.studentrosteri.web.application;

import com.jonatan.studentrosteri.data.entity.Student;
import com.jonatan.studentrosteri.data.repository.StudentRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * StudentRosterController
 */
@Controller
public class StudentRosterController {

    private final StudentRepository studentRepository;

    public StudentRosterController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(path = "/students/new", method = RequestMethod.GET)
    public String newStudentView() {
        return "newStudent";
    }

    @RequestMapping(path = "/students/new", method = RequestMethod.POST)
    public String createStudent(
        @RequestParam(name = "firstName") String firstName,
        @RequestParam(name = "lastName") String lastName,
        @RequestParam(name = "age") String age) {

            Student s = new Student();
            s.setFirstName(firstName);
            s.setLastName(lastName);
            s.setAge(Integer.parseInt(age));

            studentRepository.save(s);

        return "redirect:/students/new";
    }
    
    @RequestMapping(path = "/contact/new", method = RequestMethod.GET)
    public String newContactView(Model model) {
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);

        return "newContact";
    }

    @RequestMapping(path = "/contact/new", method = RequestMethod.POST)
    public String createContact() {
        return "";
    }

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    public String getStudents(Model model) {
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "allStudents";
    }
}