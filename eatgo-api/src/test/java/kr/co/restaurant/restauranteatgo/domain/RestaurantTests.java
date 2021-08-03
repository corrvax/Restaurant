package kr.co.restaurant.restauranteatgo.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTests {

    //create Object
    @Test
    public void creation(){
        //restaurant객체 생성시 "Korean Restuarant"생성
        Restaurant restaurant = new Restaurant("Korean Restaurant","Seoul");
        //Red TDD
        assertThat(restaurant.getName(),is("Korean Restaurant"));
        assertThat(restaurant.getAddress(),is("Seoul"));
    }
    @Test
    public void information(){
        Restaurant restaurant = new Restaurant("Korean Restaurant","Seoul");
        assertThat(restaurant.getInformation(),is("Korean Restaurant in Seoul") );
    }

}