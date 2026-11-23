package org.desgraca._1springproject;

import org.desgraca._1springproject.DAO.StudentDAO;
import org.desgraca._1springproject.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class  Application {
    private final StudentDAO studentDAO;
    public Application(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
            createMultipleStudents();
        };
    }
    private int deleteAll(){
        return studentDAO.deleteAll();
    }

    private List<Student> getAllStudents(StudentDAO studentDAO){
        return  studentDAO.findAll();

    }

    private void createMultipleStudents(){
        Student tempStudent1 = new Student("Arthur", "Rodriguez", "ArthurRodriguez@gmail.com");
        Student tempStudent2 = new Student("Walter", "White", "walterwhite@gmail.com");
        Student tempStudent3 = new Student("Jesse", "Pinkman", "jessepinkman@gmail.com");

        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);




    }

    private void deleteStudent(int id, StudentDAO studentDAO){
        System.out.println(studentDAO.find(1));
        studentDAO.deleteStudent(1);
        System.out.println(studentDAO.find(1));
    }

    private void updateStudent(StudentDAO studentDAO){
        Student student = studentDAO.find(1);
        System.out.println("Getting Student with id: "+ 1);
        student.setFirstName("modificado");
        studentDAO.update(student);
        System.out.println(student);

    }
    private Student readStudent(int id, StudentDAO studentDAO){
        return studentDAO.find(id);
    }

    private void createStudent(StudentDAO studentDAO) {
        //create student object
        System.out.println("Creating new student object.");
        Student tempStudent = new Student("paul", "walker", "paulwalker@gmail.com");
        // save student object
        System.out.println("Saving student...");
        studentDAO.save(tempStudent);
        //display id of saved student
        System.out.println("Saved student. Student ID: " + tempStudent.getId());

    }

}
