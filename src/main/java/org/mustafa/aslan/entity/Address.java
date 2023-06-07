package org.mustafa.aslan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long id ;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

// todo : user id ile değil relation ile olacak
    @Column(
            name = "user_id",
            columnDefinition = "INT"
    )
    private long userId;

    @Column(
            name = "street",
            columnDefinition = "VARCHAR(100)"
    )
    private String street;

    @Column(
            name = "number",
            columnDefinition = "INT"
    )
    private int number;

    @Column(
            name = "post_code",
            columnDefinition = "INT"
    )
    private int postCode;

    @Column(
            name = "create_at",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalDateTime createAt;

    public Address() {
    }

    public Address(long userId, String street, int number, int postCode) {
        this.userId = userId;
        this.street = street;
        this.number = number;
        this.postCode = postCode;
    }

}
