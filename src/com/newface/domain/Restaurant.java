package com.newface.domain;

/**
 * Created by HeemangHan on 2016. 9. 6..
 */
public class Restaurant {

    private int restaurantNo;
    private String restaurantRegnum;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantTel;
    private float restaurantLatitude;
    private float restaurantLongitude;
    private String restaurantState;
    private Member member;

    public int getRestaurantNo() {
        return restaurantNo;
    }

    public void setRestaurantNo(int restaurantNo) {
        this.restaurantNo = restaurantNo;
    }

    public String getRestaurantRegnum() {
        return restaurantRegnum;
    }

    public void setRestaurantRegnum(String restaurantRegnum) {
        this.restaurantRegnum = restaurantRegnum;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantTel() {
        return restaurantTel;
    }

    public void setRestaurantTel(String restaurantTel) {
        this.restaurantTel = restaurantTel;
    }

    public float getRestaurantLatitude() {
        return restaurantLatitude;
    }

    public void setRestaurantLatitude(float restaurantLatitude) {
        this.restaurantLatitude = restaurantLatitude;
    }

    public float getRestaurantLongitude() {
        return restaurantLongitude;
    }

    public void setRestaurantLongitude(float restaurantLongitude) {
        this.restaurantLongitude = restaurantLongitude;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getRestaurantState() {
        return restaurantState;
    }

    public void setRestaurantState(String restaurantState) {
        this.restaurantState = restaurantState;
    }
}
