package com.fastcampusallinone.project3.mycontact.domain.dio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

// 엔티티에 속해있는 클래스
@Embeddable
@Data
@NoArgsConstructor
public class Birthday {
    private int yearOfBirthday;
    private int monthOfBirthday;
    private int dayOfBirthday;

    // 위의 변수들이 int값이기 때문에 유효성 검사를 위한 생성자
    public Birthday(LocalDate birthday){
        this.yearOfBirthday = birthday.getYear();
        this.monthOfBirthday = birthday.getMonthValue();
        this.dayOfBirthday = birthday.getDayOfMonth();
    }
}
