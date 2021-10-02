package kr.co.restaurant.restauranteatgo.interfaces;

import kr.co.restaurant.restauranteatgo.application.RestaurantService;
import kr.co.restaurant.restauranteatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//가게목록들을 프론트에 JSON으로 뿌리기위한 과정
//각 URL에 대한 요청을 처리하는 Controller
//Restcontroller로 인스턴스를 자동으로 생성하여줌
@RestController
public class RestaurantController {
    //private RestaurantRepository repository = new RestaurantRepository();
    //Controller를 생성할 때 Spring이 알아서 RestaurantRepository 생성
    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }
    //가게 detail API
    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id")Long id){
        //레스토랑 기본정보 + 메뉴 정보 리턴
        Restaurant restaurant = restaurantService.getRestaurant(id);
        //레스토랑 정보 repository에서 생성
        //findById(id) id넣을때 해당 레스토랑
//        Restaurant restaurant = restaurantRepository.findById(id);
//


        return restaurant;
    }

}
