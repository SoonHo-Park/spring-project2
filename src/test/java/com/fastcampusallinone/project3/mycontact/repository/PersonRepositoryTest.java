package com.fastcampusallinone.project3.mycontact.repository;

import com.fastcampusallinone.project3.mycontact.domain.Person;
import com.fastcampusallinone.project3.mycontact.domain.dio.Birthday;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){
        Person person = new Person();
        person.setName("martin");
        person.setAge(10);
        person.setBloodType("A");
        personRepository.save(person);

        System.out.println(personRepository.findAll());
        List<Person> people = personRepository.findAll();

        Assertions.assertThat(people.size()).isEqualTo(1);
        Assertions.assertThat(people.get(0).getName()).isEqualTo("martin");
        Assertions.assertThat(people.get(0).getAge()).isEqualTo(10);
        Assertions.assertThat(people.get(0).getBloodType()).isEqualTo("A");
    }

    @Test
    void hashCodeAndEquals(){
        Person person1 = new Person();
    }

    // Repository에 쿼리문을 작성할 때 List형태로 작성해야 하는 이유
    // 단순 오브젝트 형으로 쿼리문을 작성하면 한 가지 이상의 경우가 출력되는 경우 수행 불가함
    @Test
    void findByBloodType(){
        givenPerson("MARTIN", 10, "A");
        givenPerson("DAVID", 9, "B");
        givenPerson("DENNIS", 8, "O");
        givenPerson("SOPHIA", 7, "AB");
        givenPerson("BENNY", 6, "A");
        givenPerson("JOHN", 11, "A");

        List<Person> result = personRepository.findByBloodType("A");

        System.out.println(result);
    }

    @Test
    void findByBirthdayBetween(){

        givenPerson("MARTIN", 10, "A", LocalDate.of(1991,8,15));
        givenPerson("DAVID", 9, "B", LocalDate.of(1992,8,31));
        givenPerson("DENNIS", 8, "O", LocalDate.of(1993,9,15));
        givenPerson("SOPHIA", 7, "AB", LocalDate.of(1997,8,15));
        givenPerson("BENNY", 6, "A", LocalDate.of(1994,10,15));
        givenPerson("JOHN", 11, "A", LocalDate.of(1995,8,16));

        List<Person> result = personRepository.findByMonthOfBirthday(8);

        result.forEach(System.out::println);
    }

    // 메소드 오버로딩
    private void givenPerson(String name, int age, String bloodType){
        givenPerson(name, age, bloodType, null);
    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthday){

        Person person = new Person(name, age, bloodType);
        person.setBirthday(new Birthday(birthday));
        personRepository.save(person);

    }
}