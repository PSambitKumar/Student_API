package com.csm.Controller;

import com.csm.Entity.Student;
import com.csm.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
public class StudentController{

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

    @ResponseBody
    @DeleteMapping("DeleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        studentRepository.deleteById(id);
       return "Deletion Successsfully";
    }

    @ResponseBody
    @GetMapping("FindById/{id}")
    public Optional<Student> studentById(@PathVariable("id") int id){
       return studentRepository.findById(id);
    }

    @ResponseBody
    @GetMapping("FindByName/{name}")
    public List<Student> studentByName(@PathVariable("name") String name){
       return studentRepository.findStudentByName(name);
    }

    @ResponseBody
    @PostMapping("UpdateStudent/{id}")
    public String updateStudent(@PathVariable("id") int id,@RequestBody Student student){
       int sid = id;
       student.setId(sid);
       studentRepository.save(student);
        return "Student Updated Successfully";
    }
}
