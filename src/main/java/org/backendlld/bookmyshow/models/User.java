package org.backendlld.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Users")
@Getter
@Setter
public class User extends  BaseModel {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private String role;
    private String status;
    private String profilePic;
}
