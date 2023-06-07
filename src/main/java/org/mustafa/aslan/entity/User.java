package org.mustafa.aslan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id ;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @Column(name = "first_name",
            columnDefinition = "VARCHAR(50)"
    )
    String firstName;
    @Column(name = "last_name",
            columnDefinition = "VARCHAR(50)"
    )
    String lastName;
    @Column(name = "email",
            columnDefinition = "VARCHAR(100)"
    )
    String email;

    @Column(name = "password",
            columnDefinition = "VARCHAR(50)"
    )
    String password;
    @Column(name = "grade",
            columnDefinition = "INT"
    )
    int grade;
    @Column(name = "dob",
            columnDefinition = "DATETIME"
    )
    LocalDate dob;

    @Column(
            name = "create_at",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalDateTime createAt;

    public User() {
    }

    public User(String firstName,
                String lastName,
                String email,
                String password,
                int grade,
                LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.grade = grade;
        this.dob = dob;
    }




}
