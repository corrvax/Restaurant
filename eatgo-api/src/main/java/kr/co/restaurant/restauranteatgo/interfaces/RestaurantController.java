package kr.co.restaurant.restauranteatgo.interfaces;

import kr.co.restaurant.restauranteatgo.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//가게목록들을 프론트에 JSON으로 뿌리기위한 과정
//각 URL에 대한 요청을 처리하는 Controller
@RestController
public class RestaurantController {
    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L,"Korean Restaurant","Seoul");
        restaurants.add(restaurant);
        return restaurants;
    }

}
