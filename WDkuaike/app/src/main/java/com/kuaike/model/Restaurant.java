package com.kuaike.model;

/**
 * Created by Administrator on 2016/7/29.
 */
public class Restaurant {

    public String restaurantName;
    public String resraurantPrice;
    public int rantingBar;
    public String restaurantClassify;
    public String restaurantDestince;

    public int getRantingBar() {
        return rantingBar;
    }

    public String getResraurantPrice() {
        return resraurantPrice;
    }

    public String getRestaurantClassify() {
        return restaurantClassify;
    }

    public String getRestaurantDestince() {
        return restaurantDestince;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public Restaurant(String restaurantName, String resraurantPrice, int rantingBar, String restaurantClassify, String restaurantDestince) {
        this.restaurantName = restaurantName;
        this.resraurantPrice = resraurantPrice;
        this.rantingBar = rantingBar;
        this.restaurantClassify = restaurantClassify;
        this.restaurantDestince = restaurantDestince;
    }
}
