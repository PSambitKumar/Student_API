package com.csm.Controller;

import com.csm.Entity.Student;
import com.csm.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

   @ResponseBody
   @PostMapping("SaveStudent1")
    public Student saveStudent(){
        Student student = new Student();
        student.setName("Hrusikesh");
        student.setDept("BSS");
        student.setMark(34);
        return studentRepository.save(student);
   }

    @ResponseBody
    @PostMapping("SaveStudent")
    public Student saveStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @ResponseBody
    @PostMapping("GetAllStudent")
    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }
}
