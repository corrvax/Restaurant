package kr.co.restaurant.restauranteatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//레스토랑 Repository를 Spring이 관리
@Component
public class RestaurantRepositoryIml implements RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();
    public RestaurantRepositoryIml(){
        restaurants.add(new Restaurant(1004L,"Korean Restaurant","Seoul"));
        restaurants.add(new Restaurant(2020L,"Cyber Food","Seoul"));
    }
    @Override
    public List<Restaurant> findAll() {
        return restaurants;
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);//c찾을 식당아이디 없을 경우null
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        restaurants.add(restaurant);
        restaurant.setId(1234L);
        return restaurant;
    }
}
