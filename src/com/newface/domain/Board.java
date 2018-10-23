package com.newface.domain;

import java.sql.Date;

/**
 * Created by HeemangHan on 2016. 8. 25..
 */
public class Board {
    private int review_idx;
    private String review_writer;
    private String review_content;
    private int review_rating;
    private Date review_regdate;
    private int restaurant_no;

    public int getReview_idx() {
        return review_idx;
    }

    public void setReview_idx(int review_idx) {
        this.review_idx = review_idx;
    }

    public String getReview_writer() {
        return review_writer;
    }

    public void setReview_writer(String review_writer) {
        this.review_writer = review_writer;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }

    public int getReview_rating() {
        return review_rating;
    }

    public void setReview_rating(int review_rating) {
        this.review_rating = review_rating;
    }

    public Date getReview_regdate() {
        return review_regdate;
    }

    public void setReview_regdate(Date review_regdate) {
        this.review_regdate = review_regdate;
    }

    public int getRestaurant_no() {
        return restaurant_no;
    }

    public void setRestaurant_no(int restaurant_no) {
        this.restaurant_no = restaurant_no;
    }
}
