package com.lbg.demo.library.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.library.domain.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
