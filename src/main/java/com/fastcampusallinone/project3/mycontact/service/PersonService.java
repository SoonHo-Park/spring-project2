package com.fastcampusallinone.project3.mycontact.service;

import com.fastcampusallinone.project3.mycontact.domain.Block;
import com.fastcampusallinone.project3.mycontact.domain.Person;
import com.fastcampusallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampusallinone.project3.mycontact.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleExcludeBlock(){
//        List<Person> people = personRepository.findAll();
//        return people.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());
        return personRepository.findByBlockIsNull();
    }

    public List<Person> getPeopleByName(String name){
//        List<Person> people = personRepository.findAll();
//        return people.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
        return personRepository.findByName(name);
    }

    public Person getPerson(Long id){
        Person person = personRepository.findById(id).get();

        log.info("person : {}", person);

        return person;
    }
}
