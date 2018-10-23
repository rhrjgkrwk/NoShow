package com.newface.domain;

import com.sun.tools.javac.util.List;

/**
 * Created by HeemangHan on 2016. 9. 22..
 */
public class ReservationList {

    private Reservation reservation;
    private List<ReservationMenuList> menuList;

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public List<ReservationMenuList> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<ReservationMenuList> menuList) {
        this.menuList = menuList;
    }
}
