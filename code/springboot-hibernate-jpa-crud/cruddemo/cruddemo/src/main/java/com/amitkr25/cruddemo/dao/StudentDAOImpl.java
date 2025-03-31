package com.amitkr25.cruddemo.dao;

import com.amitkr25.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define fields for entity manager
    private EntityManager entityManager;

    //inject entity manager using contructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save menthod
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
