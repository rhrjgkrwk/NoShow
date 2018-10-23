package com.newface.domain;

import com.sun.tools.javac.util.List;

/**
 * Created by HeemangHan on 2016. 9. 17..
 */
public class ReservationMenu {

    private Reservation reservation;
    private Menu menu;
    private int menuCount;

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getMenuCount() {
        return menuCount;
    }

    public void setMenuCount(int menuCount) {
        this.menuCount = menuCount;
    }
}