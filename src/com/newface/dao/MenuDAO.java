package com.newface.dao;

import com.newface.domain.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HeemangHan on 2016. 9. 14..
 */
public interface MenuDAO {

    public List<Menu> selectMenuByRestaurant(int restaurantNo);

    public Menu selectMenuByNum(@Param("restaurantNo") int restaurantNo, @Param("menuNum") int menuNum);

    public int addMenu(Menu menu);
}
