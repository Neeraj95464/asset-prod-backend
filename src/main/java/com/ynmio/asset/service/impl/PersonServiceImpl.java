package com.ynmio.asset.service.impl;

import com.ynmio.asset.model.Person;
import com.ynmio.asset.repository.PersonRepository;
import com.ynmio.asset.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long personId, Person person) {
        Person existingPerson = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        existingPerson.setFullName(person.getFullName());
        existingPerson.setEmployeeId(person.getEmployeeId());
        existingPerson.setEmail(person.getEmail());
        existingPerson.setPhoneNumber(person.getPhoneNumber());
        existingPerson.setDepartment(person.getDepartment());
        return personRepository.save(existingPerson);
    }

    @Override
    public void deletePerson(Long personId) {
        Person existingPerson = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        personRepository.delete(existingPerson);
    }

    @Override
    public Person getPersonById(Long personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}

