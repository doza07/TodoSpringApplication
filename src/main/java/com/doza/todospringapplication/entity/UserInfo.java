package com.doza.todospringapplication.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class UserInfo {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address addressId;

    public UserInfo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User user) {
        this.userId = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address address) {
        this.addressId = address;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
               "id=" + id +
               ", user=" + userId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", phone='" + phone + '\'' +
               ", birthDate=" + birthDate +
               ", address=" + addressId +
               '}';
    }
}
