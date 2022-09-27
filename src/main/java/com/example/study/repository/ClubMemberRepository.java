package com.example.study.repository;

import com.example.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClubMemberRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
