package org.mustafa.aslan.dto;

import lombok.Data;


@Data
public class AddressDto {

    private long userId;
    private String street;
    private int number;
    private int postCode;

    public AddressDto(long userId, String street, int number, int postCode) {
        this.userId = userId;
        this.street = street;
        this.number = number;
        this.postCode = postCode;
    }
}
