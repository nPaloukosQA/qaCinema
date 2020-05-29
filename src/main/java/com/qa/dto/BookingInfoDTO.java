package com.qa.dto;

import java.util.Objects;

public class BookingInfoDTO {

    private Long bookingInfoId;
    private Long standardScreeningId;
    private Long deluxeScreeningId;
    private String firstName;
    private String surname;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private String postCode;

    public BookingInfoDTO() {

    }

    public BookingInfoDTO(Long standardScreeningId, Long deluxeScreeningId, String firstName, String surname, String dateOfBirth, String email, String phoneNumber, String address, String postCode) {
        super();
        this.standardScreeningId = standardScreeningId;
        this.deluxeScreeningId = deluxeScreeningId;
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

    public Long getStandardScreeningId() {
        return standardScreeningId;
    }

    public void setStandardScreeningId(Long standardScreeningId) {
        this.standardScreeningId = standardScreeningId;
    }

    public Long getDeluxeScreeningId() {
        return deluxeScreeningId;
    }

    public void setDeluxeScreeningId(Long deluxeScreeningId) {
        this.deluxeScreeningId = deluxeScreeningId;
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

    @Override
    public String toString() {
        return "BookingInfoDTO{" +
                "bookingInfoId=" + bookingInfoId +
                ", standardScreeningId=" + standardScreeningId +
                ", deluxeScreeningId=" + deluxeScreeningId +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingInfoDTO)) return false;
        BookingInfoDTO that = (BookingInfoDTO) o;
        return Objects.equals(getBookingInfoId(), that.getBookingInfoId()) &&
                Objects.equals(getStandardScreeningId(), that.getStandardScreeningId()) &&
                Objects.equals(getDeluxeScreeningId(), that.getDeluxeScreeningId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getSurname(), that.getSurname()) &&
                Objects.equals(getDateOfBirth(), that.getDateOfBirth()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getPostCode(), that.getPostCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingInfoId(), getStandardScreeningId(), getDeluxeScreeningId(), getFirstName(), getSurname(), getDateOfBirth(), getEmail(), getPhoneNumber(), getAddress(), getPostCode());
    }
}
