package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class BookingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingInfoId;
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
    private DeluxeScreen deluxeScreen;

    public BookingInfo() {

    }

    public BookingInfo(String firstName, String surname, String dateOfBirth, String email, String phoneNumber, String address, String postCode) {
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.postCode = postCode;
    }

    public BookingInfo(Long bookingInfoId, String firstName, String surname, String dateOfBirth, String email, String phoneNumber, String address, String postCode) {
        this.bookingInfoId = bookingInfoId;
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.postCode = postCode;
    }

    public Long getBookingInfoId() {
        return bookingInfoId;
    }

    public void setBookingInfoId(Long bookingInfoId) {
        this.bookingInfoId = bookingInfoId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public StandardScreen getStandardScreen() {
        return standardScreen;
    }

    public void setStandardScreen(StandardScreen standardScreen) {
        this.standardScreen = standardScreen;
    }

    public DeluxeScreen getDeluxeScreen() {
        return deluxeScreen;
    }

    public void setDeluxeScreen(DeluxeScreen deluxeScreen) {
        this.deluxeScreen = deluxeScreen;
    }

    @Override
    public String toString() {
        return "BookingInfo{" +
                "bookingInfoId=" + bookingInfoId +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", standardScreen=" + standardScreen +
                ", deluxeScreen=" + deluxeScreen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingInfo)) return false;
        BookingInfo that = (BookingInfo) o;
        return Objects.equals(getBookingInfoId(), that.getBookingInfoId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getSurname(), that.getSurname()) &&
                Objects.equals(getDateOfBirth(), that.getDateOfBirth()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getPostCode(), that.getPostCode()) &&
                Objects.equals(getStandardScreen(), that.getStandardScreen()) &&
                Objects.equals(getDeluxeScreen(), that.getDeluxeScreen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingInfoId(), getFirstName(), getSurname(), getDateOfBirth(), getEmail(), getPhoneNumber(), getAddress(), getPostCode(), getStandardScreen(), getDeluxeScreen());
    }
}
