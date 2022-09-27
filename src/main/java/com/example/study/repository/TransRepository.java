package com.example.study.repository;

import com.example.study.entity.TransEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TransRepository extends JpaRepository<TransEntity, Long> {

    List<TransEntity> findTop10ByOrderByTrafficAmoutDesc();
}
