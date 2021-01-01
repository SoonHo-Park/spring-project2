package com.fastcampusallinone.project3.mycontact.domain;

import com.fastcampusallinone.project3.mycontact.domain.dio.Birthday;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Person {

    @Id // id라는 것을 표시
    @GeneratedValue // 자동 생성 (default = auto)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;

    @NonNull
    private String bloodType;

    private String address;

    @Embedded
    private Birthday birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;

    // CASCADE : PERSON과 BLOCK사이의 연관관계로 인한 튜플 생성/제거 시 발생하는 문제를 어떻게 해결할지
    // orphanRemoval :
    // fetch :
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    //ToString 에서 해당 필드를 제외함
    @ToString.Exclude
    private Block block;
}
