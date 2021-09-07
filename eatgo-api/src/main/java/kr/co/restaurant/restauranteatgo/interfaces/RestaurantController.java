package kr.co.restaurant.restauranteatgo.interfaces;

import kr.co.restaurant.restauranteatgo.domain.Restaurant;
import kr.co.restaurant.restauranteatgo.domain.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//가게목록들을 프론트에 JSON으로 뿌리기위한 과정
//각 URL에 대한 요청을 처리하는 Controller
@RestController
public class RestaurantController {
    private RestaurantRepository repository = new RestaurantRepository();

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = repository.findAll();
        return restaurants;
    }
    //가게 detail API
    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id")Long id){
        //레스토랑 정보 repository에서 생성
        //findById(id) id넣을때 해당 레스토랑
        Restaurant restaurant = repository.findById(id);

        return restaurant;
    }

}
