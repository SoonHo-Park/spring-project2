package com.fastcampusallinone.project3.mycontact.service;

import com.fastcampusallinone.project3.mycontact.domain.Block;
import com.fastcampusallinone.project3.mycontact.domain.Person;
import com.fastcampusallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampusallinone.project3.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlock();

//        System.out.println(result);
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

    private void givenBlocks(){
        givenBlock("MARTIN");
    }

    private Block givenBlock(String name) {
        return blockRepository.save(new Block(name));
    }

    private void givenBlockPerson(String name, int age, String bloodType){
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(givenBlock(name));

        personRepository.save(blockPerson);
    }
}