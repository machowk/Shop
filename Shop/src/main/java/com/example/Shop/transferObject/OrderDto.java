package com.example.Shop.transferObject;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    /* OrderDto - data transfer object*/

    private String firstName;
    private String lastName;
    private String address;
    private String postCode;
    private String city;

}
