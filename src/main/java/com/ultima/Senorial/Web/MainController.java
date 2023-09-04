package com.ultima.Senorial.Web;

import com.ultima.Senorial.Domain.Person;
import com.ultima.Senorial.Repository.PersonRepo;
import com.ultima.Senorial.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepo personRepo;



    ///////////////////////////////////////////////////////////////////////////////
    @GetMapping("")
    public String getRootWebPage(ModelMap model){

        Integer id = 255;
        String firstName = "Dexter Manley";
        model.put("firstName", firstName);
        model.put("id", id);
        return "mainIndex";
    }

    ////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("persons")
    public String getPersonWebPage(ModelMap model){
        List<Person> peopleList = personService.findAll();

//        Person person1 = new Person("Dexter", "Manley", 45, 255);

//        model.put("person", person1);

        model.put("people", peopleList);

        Person person2 = new Person();
        model.put("person", person2);

        return "personIndex";
    }
    //////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("persons")
    public String postPersonWebPage (Person person){

        Integer personId = personRepo.getPersonList().size() +1;
        person.setId(personId);

        personRepo.getPersonList().add(person);

        personRepo.getPersonList().forEach(System.out::println);
        ////////////////////////////////////////////////////////////





        Person savedPerson = personService.save(person);
        System.out.println("Saved Person = " + savedPerson);

        System.out.println("------------------------------------------->");

        return "redirect:/persons";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/persons/{personId}")
    public String getPersonById(@PathVariable Integer personId, ModelMap model){


        Person person = personService.findById(personId);
        model.put("person", person);

        return "personIndex";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("persons/{personId}")
    public String postUpdatePeople(Person person){
        Person savedPerson = personService.save(person);
        System.out.println(savedPerson);
        return "redirect:/persons/" + savedPerson.getId();
    }


    //////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("persons/{personId}/delete")
    public String deletePerson(@PathVariable Integer personId){

        personService.delete(personId);


        return "redirect:/persons";
    }


    //////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("secrets")
    public String getSecretsPage(){

        return "secret";
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("movies")
    public String getMovieRankingPage(){

        return "movieRanking";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("google")
    public String redirectToGoogle(){
        return "redirect:/www.google.com";
    }


}
