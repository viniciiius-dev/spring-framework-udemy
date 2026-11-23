package org.desgraca._3restcontrollersjsondemo.rest;

import jakarta.annotation.PostConstruct;
import org.desgraca._3restcontrollersjsondemo.dto.StudentErrorResponse;
import org.desgraca._3restcontrollersjsondemo.entity.Student;
import org.desgraca._3restcontrollersjsondemo.exception.StudentNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> theStudents = new ArrayList<>();

    // define endpoint for "/students" - return a list of students
    @PostConstruct
    public void loadData(){
        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

        studentErrorResponse.setStatusCode(HttpStatus.NOT_FOUND);
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return theStudents;
    }
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        if (id >= theStudents.size() || id < 0){
            throw new StudentNotFoundException("Student not found");
        }
        return theStudents.get(id);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGenericException(Exception exc){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

        studentErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST);
        studentErrorResponse.setMessage(exc.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}






