package com.newface.dao;

import com.newface.domain.Restaurant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HeemangHan on 2016. 9. 13..
 */
public interface RestaurantDAO {

    public List selectAll();

    public Restaurant selectOne(int restaurantNo);

    public Restaurant selectOneByMemberId(int memberNo);

    public int add(Restaurant restaurant);

    public int updateRestaurantState(@Param("restaurantNo") int restaurantNo,
                                     @Param("restaurantState") String restaurantState, @Param("memberType") String memberType);
}
