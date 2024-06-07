package com.example.demo.student;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("list")
    public List<Student> list() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public String create(@RequestBody Student student) {
        studentService.createStudent(student);
        return "Student created";
    }

    @DeleteMapping(path = "{studentId}")
    public void delete(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void update(@PathVariable("studentId") Long studentId,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
