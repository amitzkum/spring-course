package com.amitkr25.cruddemo.dao;

import com.amitkr25.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> finaAll();
}
