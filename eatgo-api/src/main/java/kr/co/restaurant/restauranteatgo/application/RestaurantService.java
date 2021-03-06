package kr.co.restaurant.restauranteatgo.application;

import kr.co.restaurant.restauranteatgo.domain.MenuItem;
import kr.co.restaurant.restauranteatgo.domain.MenuItemRepository;
import kr.co.restaurant.restauranteatgo.domain.Restaurant;
import kr.co.restaurant.restauranteatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MenuItemRepository menuItemRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    public Restaurant getRestaurant(long id){
        //findById Optional타입으로 변경해서 없으면null(실무에선 에러처리해야함)
        Restaurant restaurant =  restaurantRepository.findById(id).orElse(null);
        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);
        return  restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
    @Transactional
    public Restaurant updateRestaurant(long id, String name, String address) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
        restaurant.updateInformation(name,address);
        return restaurant;
    }
}
