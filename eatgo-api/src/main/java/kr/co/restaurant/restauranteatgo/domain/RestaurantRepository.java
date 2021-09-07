package kr.co.restaurant.restauranteatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private List<Restaurant> restaurants = new ArrayList<>();
    public  RestaurantRepository(){
        restaurants.add(new Restaurant(1004L,"Korean Restaurant","Seoul"));
        restaurants.add(new Restaurant(2020L,"Cyber Food","Seoul"));
    }
    public List<Restaurant> findAll() {
        return null;
    }

    public Restaurant findById(Long id) {
        return restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);//c찾을 식당아이디 없을 경우null
    }
}
