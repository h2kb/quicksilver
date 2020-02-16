package io.github.h2kb.dto;

import java.util.Date;

public class OutgoingCallTaskDto {

    private String orderNumber;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Date createAt;

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getCreateAt() {
        return createAt;
    }
}
