package com.fastcampusallinone.project3.mycontact.repository;

import com.fastcampusallinone.project3.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    List<Person> findByBlockIsNull();

    List<Person> findByBloodType(String BloodType);

    // JPQL : java + SQL
    // ?1 : 첫번째 인자, ?2 : 두번째 인자 (위치 기반 파라미터 매칭 방식)
    //@Query(value = "select person from Person person where person.birthday.monthOfBirthday =?1 and person.birthday.dayOfBirthday =?2")
    //List<Person> findByMonthOfBirthday(int monthOfBirthday, int dayOfBirthday);

    // 이름 기반 파라미터 매칭 방식
    // nativeQuery = true 설정 시 sql문 그대로 사용 가능
    @Query(value = "select person from Person person where person.birthday.monthOfBirthday =:monthOfBirthday")
    List<Person> findByMonthOfBirthday(@Param("monthOfBirthday") int monthOfBirthday);
}
