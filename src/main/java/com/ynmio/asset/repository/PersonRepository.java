package com.ynmio.asset.repository;

import com.ynmio.asset.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
