package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "guest")
public class GuestEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "guest_code")
    private String guest_code;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

    @Column(name = "nic_passport")
    private String nic_passport;

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "registered_date")
    private Date registered_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", nullable = false)
    private StatusEntity status;

    public GuestEntity() {
    }

    public GuestEntity(Long id, String guest_code, String first_name, String last_name, String email, int phone, String nic_passport, String address, Date date_of_birth, Date registered_date, StatusEntity status) {
        this.id = id;
        this.guest_code = guest_code;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.nic_passport = nic_passport;
        this.address = address;
        this.date_of_birth = date_of_birth;
        this.registered_date = registered_date;
        this.status = status;
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

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }
}
