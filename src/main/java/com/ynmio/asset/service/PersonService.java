package com.ynmio.asset.service;

import com.ynmio.asset.model.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);
    Person updatePerson(Long personId, Person person);
    void deletePerson(Long personId);
    Person getPersonById(Long personId);
    List<Person> getAllPersons();
}

