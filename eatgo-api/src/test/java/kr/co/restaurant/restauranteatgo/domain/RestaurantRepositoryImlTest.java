package kr.co.restaurant.restauranteatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantRepositoryImlTest {
    @Test
    public void save(){
        RestaurantRepository  repository = new RestaurantRepositoryIml();
        int oldCount = repository.findAll().size();
        Restaurant restaurant  = new Restaurant("Eun jo","Seoul");
        repository.save(restaurant);

        assertThat(restaurant.getId(),is(1234L));
        int newCount = repository.findAll().size();

        assertThat(newCount - oldCount,is(1));
    }

}