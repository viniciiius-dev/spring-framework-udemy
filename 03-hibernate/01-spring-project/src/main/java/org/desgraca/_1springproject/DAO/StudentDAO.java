package org.desgraca._1springproject.DAO;

import org.desgraca._1springproject.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student find(int id);

    List<Student> findAll();
    void update(Student student);
    void deleteStudent(int id);
    int deleteAll();
}
