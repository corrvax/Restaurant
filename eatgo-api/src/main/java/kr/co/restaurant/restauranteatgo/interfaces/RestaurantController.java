package kr.co.restaurant.restauranteatgo.interfaces;

import kr.co.restaurant.restauranteatgo.domain.MenuItem;
import kr.co.restaurant.restauranteatgo.domain.MenuItemRepository;
import kr.co.restaurant.restauranteatgo.domain.Restaurant;
import kr.co.restaurant.restauranteatgo.domain.RestaurantRepository;
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
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }
    //가게 detail API
    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id")Long id){
        //레스토랑 정보 repository에서 생성
        //findById(id) id넣을때 해당 레스토랑
        Restaurant restaurant = restaurantRepository.findById(id);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

}
