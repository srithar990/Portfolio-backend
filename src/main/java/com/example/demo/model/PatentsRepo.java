package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatentsRepo extends JpaRepository<Patents, String> {

}
