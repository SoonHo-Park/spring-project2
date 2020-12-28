package com.fastcampusallinone.project3.mycontact.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {

    @Id // id라는 것을 표시
    @GeneratedValue // 자동 생성 (default = auto)
    private Long id;

    @NonNull
    private String name;

    private int age;

    private String hobby;

    private String bloodType;

    @ToString.Exclude
    private String address;

    private LocalDate birthday;

    private String job;
}
