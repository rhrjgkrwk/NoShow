package com.newface.domain;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by HeemangHan on 2016. 9. 17..
 */
public class Reservation {
    private int reservationNo;
    private Date reservationDate;
    private Time reservationTime;
    private String reservationRequest;
    private Restaurant restaurant;
    private Member member;

    public int getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(int reservationNo) {
        this.reservationNo = reservationNo;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Time getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Time reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getReservationRequest() {
        return reservationRequest;
    }

    public void setReservationRequest(String reservationRequest) {
        this.reservationRequest = reservationRequest;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
