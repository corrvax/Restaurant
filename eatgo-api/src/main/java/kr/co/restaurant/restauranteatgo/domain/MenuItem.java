package kr.co.restaurant.restauranteatgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MenuItem {
    @GeneratedValue
    @Id
    private Long id;
    private Long restaurantId;
    private final String name;

    public MenuItem(String name){
        this.name = name;
    }
    public String getName(){
        return  name;
    }
}
