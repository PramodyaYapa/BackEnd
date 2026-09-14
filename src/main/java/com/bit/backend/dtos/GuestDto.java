package com.bit.backend.dtos;

import java.util.Date;

public class GuestDto {

    private Long id;
    private String guest_code;
    private String first_name;
    private String last_name;
    private String email;
    private int phone;
    private String nic_passport;
    private String address;
    private Date date_of_birth;
    private Date registered_date;
    private StatusDto status;

    public GuestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuest_code() {
        return guest_code;
    }

    public void setGuest_code(String guest_code) {
        this.guest_code = guest_code;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNic_passport() {
        return nic_passport;
    }

    public void setNic_passport(String nic_passport) {
        this.nic_passport = nic_passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(Date registered_date) {
        this.registered_date = registered_date;
    }

    public StatusDto getStatus() {
        return status;
    }

    public void setStatus(StatusDto status) {
        this.status = status;
    }
}
