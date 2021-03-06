package kr.co.restaurant.restauranteatgo.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class RestaurantTests {

    //create Object
    @Test
    public void creation(){
        //restaurant객체 생성시 "Korean Restuarant"생성
        Restaurant restaurant = new Restaurant(1004L,"Korean Restaurant","Seoul");
         //Red TDD
        assertThat(restaurant.getId(),is(1004L));
        assertThat(restaurant.getName(),is("Korean Restaurant"));
        assertThat(restaurant.getAddress(),is("Seoul"));
    }
    @Test
    public void information(){
        Restaurant restaurant = new Restaurant(1004L,"Korean Restaurant","Seoul");
        assertThat(restaurant.getInformation(),is("Korean Restaurant in Seoul") );


    }

}