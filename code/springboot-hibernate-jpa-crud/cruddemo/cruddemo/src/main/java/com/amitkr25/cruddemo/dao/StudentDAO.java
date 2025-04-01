package com.amitkr25.cruddemo.dao;

import com.amitkr25.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);
}
