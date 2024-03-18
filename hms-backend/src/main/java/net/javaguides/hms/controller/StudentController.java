package net.javaguides.hms.controller;

import lombok.AllArgsConstructor;
import net.javaguides.hms.dto.StudentDto;
import net.javaguides.hms.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    //build Add student rest api
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudent=studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    //build Get student rest api

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId){
        StudentDto studentDto=studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentDto);
    }

    //build Get all student rest api

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students=studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    //update student rest api
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId,@RequestBody StudentDto updatedStudent){
        StudentDto studentDto=studentService.updateStudent(studentId,updatedStudent);
        return ResponseEntity.ok(studentDto);
    }

    //delete student rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Successfully deleted!");
    }
}
