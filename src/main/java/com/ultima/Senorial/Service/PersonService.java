package com.ultima.Senorial.Service;

import com.ultima.Senorial.Domain.Person;
import com.ultima.Senorial.Repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    Integer personId = 1;

    @Autowired
    private PersonRepo personRepo;

    public Person save(Person person){
        if(person.getId() == null) {
            person.setId(personId++);
        }

       return   personRepo.savePerson(person);
    }

    public Person findById(Integer personId){
        return personRepo.findById(personId);
    }

    public List<Person> findAll(){
        return personRepo.findAll();
    }

    public void delete(Integer personId){
        personRepo.delete(personId);
    }

}
