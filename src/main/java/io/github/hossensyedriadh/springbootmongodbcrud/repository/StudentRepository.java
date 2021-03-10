package io.github.hossensyedriadh.springbootmongodbcrud.repository;

import io.github.hossensyedriadh.springbootmongodbcrud.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {
}
