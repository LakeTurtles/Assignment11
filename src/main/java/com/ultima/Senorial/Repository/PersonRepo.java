package com.ultima.Senorial.Repository;

import com.ultima.Senorial.Domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonRepo {

    private Map<Integer, Person> peopleHashMap = new HashMap<>();

    public Person savePerson (Person person) {
        peopleHashMap.put(person.getId(), person);
        return person;
    }

    public Person findById (Integer personId){
        return peopleHashMap.get(personId);
    }

    public List<Person> findAll(){
//        peopleHashMap.entrySet().stream().map(s -> s.getKey()).toList();

        return peopleHashMap.values().stream().toList();
    }


    public void delete(Integer personId){
        peopleHashMap.remove(personId);
    }



    //////////////////////////////////////////////////////////////////////////////////////////

    private List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
        return personList;
    }
}
