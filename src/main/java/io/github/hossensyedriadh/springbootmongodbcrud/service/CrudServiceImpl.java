package io.github.hossensyedriadh.springbootmongodbcrud.service;

import io.github.hossensyedriadh.springbootmongodbcrud.entity.Student;
import io.github.hossensyedriadh.springbootmongodbcrud.repository.StudentRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CrudServiceImpl implements CrudService {
    private final ObjectFactory<StudentRepository> studentRepositoryObjectFactory;

    @Autowired
    public CrudServiceImpl(ObjectFactory<StudentRepository> studentRepositoryObjectFactory) {
        this.studentRepositoryObjectFactory = studentRepositoryObjectFactory;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepositoryObjectFactory.getObject().findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Student getStudent(Integer id) {
        if (studentRepositoryObjectFactory.getObject().findById(id).isPresent()) {
            return studentRepositoryObjectFactory.getObject().findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void addStudent(Student student) {
        int count = (int) studentRepositoryObjectFactory.getObject().count();
        student.setId(count + 1);
        studentRepositoryObjectFactory.getObject().save(student);
    }

    @Override
    public void updateStudent(Student updatedStudent) {
        if (studentRepositoryObjectFactory.getObject().findById(updatedStudent.getId()).isPresent()) {
            studentRepositoryObjectFactory.getObject().save(updatedStudent);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void deleteStudent(Integer id) {
        if (studentRepositoryObjectFactory.getObject().findById(id).isPresent()) {
            studentRepositoryObjectFactory.getObject().deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
