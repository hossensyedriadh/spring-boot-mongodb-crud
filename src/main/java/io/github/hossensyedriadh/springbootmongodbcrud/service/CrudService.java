package io.github.hossensyedriadh.springbootmongodbcrud.service;

import io.github.hossensyedriadh.springbootmongodbcrud.entity.Student;

import java.util.List;

public interface CrudService {
    List<Student> getStudents();

    Student getStudent(Integer id);

    void addStudent(Student student);

    void updateStudent(Student updatedStudent);

    void deleteStudent(Integer id);
}
