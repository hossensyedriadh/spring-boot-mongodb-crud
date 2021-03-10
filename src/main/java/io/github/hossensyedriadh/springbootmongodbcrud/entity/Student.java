package io.github.hossensyedriadh.springbootmongodbcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@Document
public class Student {
    @Id
    private int id;

    private String fullName;

    private String phone;

    private String email;

    private String address;
}
