package com.qa.domain;

import javax.persistence.*;

@Entity
public class BookingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingInfoId;
    private Long standardScreeningId;
    private Long deluxScreeningId;
    private String firstName;
    private String surname;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private String postCode;


    @ManyToOne (targetEntity = StandardScreen.class)
    private StandardScreen standardScreen;

    @ManyToOne (targetEntity = DeluxeScreen.class)
    private DeluxeScreen deluxScreen;

    public BookingInfo() {

    }

    public BookingInfo(Long standardScreeningId, Long deluxScreeningId, String firstName, String surname, String dateOfBirth, String email, String phoneNumber, String address, String postCode) {
        this.standardScreeningId = standardScreeningId;
        this.deluxScreeningId = deluxScreeningId;
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.postCode = postCode;
    }

    public BookingInfo(Long bookingInfoId, Long standardScreeningId, Long deluxScreeningId, String firstName, String surname, String dateOfBirth, String email, String phoneNumber, String address, String postCode) {
        this.bookingInfoId = bookingInfoId;
        this.standardScreeningId = standardScreeningId;
        this.deluxScreeningId = deluxScreeningId;
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.postCode = postCode;
    }
}
