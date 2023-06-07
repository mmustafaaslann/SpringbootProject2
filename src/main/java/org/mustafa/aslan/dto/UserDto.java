package org.mustafa.aslan.dto;

import lombok.Data;
import org.mustafa.aslan.entity.Address;

import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private int grade;
    private LocalDate dob;
    @Transient
    private int age;

    public UserDto(String firstName, String lastName, String email, int grade, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.grade = grade;
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
