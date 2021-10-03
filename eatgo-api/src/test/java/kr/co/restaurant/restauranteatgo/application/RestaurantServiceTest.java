package kr.co.restaurant.restauranteatgo.application;

import kr.co.restaurant.restauranteatgo.domain.MenuItem;
import kr.co.restaurant.restauranteatgo.domain.MenuItemRepository;
import kr.co.restaurant.restauranteatgo.domain.Restaurant;
import kr.co.restaurant.restauranteatgo.domain.RestaurantRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

public class RestaurantServiceTest {
    private RestaurantService restaurantService;
    @Mock
    private RestaurantRepository restaurantRepository;
    @Mock
    private MenuItemRepository menuItemRepository;
    //먼저 실행되는 것
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockRestaurantRepository();
        mockMenuItemRepository();
        restaurantService = new RestaurantService(
                restaurantRepository,menuItemRepository);

    }

    private void mockMenuItemRepository() {
        List<MenuItem>  menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));

        given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);
    }

    private void mockRestaurantRepository() {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L,"Bob zip","Seoul");
        restaurants.add(restaurant);
        given(restaurantRepository.findAll()).willReturn(restaurants);
        given(restaurantRepository.findById(1004L)).willReturn(restaurant);
    }

    @Test
    public void getRestaurants(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        //command+option+v(extract variable)
        Restaurant restaurant = restaurants.get(0);
        assertThat(restaurant.getId(),is(1004L));
    }


    @Test
    public void getRestaurant(){
        Restaurant restaurant = restaurantService.getRestaurant(1004L);

        assertThat(restaurant.getId(), is(1004L));
        MenuItem menuItem = restaurant.getMenuItems().get(0);
        assertThat(menuItem.getName(),is("Kimchi"));

    }

    @Test
    public void addRestaurant(){
        Restaurant restaurant = new Restaurant("EunJo","Seoul");
        Restaurant created = restaurantService.addRestaurant(restaurant);

        assertThat(created.getId(),is(1234L));

    }

}