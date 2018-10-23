package com.newface.dao;

import com.newface.domain.Reservation;
import com.newface.domain.ReservationList;
import com.newface.domain.ReservationMenu;

import java.util.List;

/**
 * Created by HeemangHan on 2016. 9. 17..
 */
public interface ReservationDAO {

    public int addReservation(Reservation reservation);

    public void addReservationMenu(ReservationMenu reservationMenu);

    public List<ReservationList> selectAllReservationList();
}