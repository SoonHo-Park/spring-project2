package com.fastcampusallinone.project3.mycontact.service;

import com.fastcampusallinone.project3.mycontact.domain.Block;
import com.fastcampusallinone.project3.mycontact.domain.Person;
import com.fastcampusallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampusallinone.project3.mycontact.repository.PersonRepository;
import jdk.vm.ci.meta.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks(){
        givenPeople();

        List<Person> result = personService.getPeopleExcludeBlock();

        result.forEach(System.out::println);
    }

    @Test
    void cascadeTest(){
        givenPeople();

        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);

        Person person = result.get(3);
        person.getBlock().setStartDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);

        personRepository.delete(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);
    }

    @Test
    void getPerson(){
        givenPeople();

        Person person = personService.getPerson(3L);
    }

    @Test
    void getPeopleByName(){
        givenPeople();

        List<Person> result = personService.getPeopleByName("MARTIN");

        result.forEach(System.out::println);
    }
    private void givenPeople(){
        givenPerson("MARTIN",10,"A");
        givenPerson("DAVID",9,"B");
        givenPerson("DENNIS",7,"O");
        givenBlockPerson("MARTIN",11,"AB");
    }

    private void givenPerson(String name, int age, String bloodType){
        personRepository.save(new Person(name, age, bloodType));
    }

    private void givenBlockPerson(String name, int age, String bloodType){
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(new Block(name));

        personRepository.save(blockPerson);
    }
}