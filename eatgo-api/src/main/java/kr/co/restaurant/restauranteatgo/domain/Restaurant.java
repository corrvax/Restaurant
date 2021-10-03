package kr.co.restaurant.restauranteatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String address;
    private Long id;
    private List<MenuItem> menuItems = new ArrayList<>();
    //json형성시 기본constructor생성자 필수
    public Restaurant() {
    }

    public Restaurant(Long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    public String getInformation() {
        return name + " in " + address;
    }

    public Long getId() {
        return id ;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
    public List<MenuItem> getMenuItems(){
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        for(MenuItem menuItem: menuItems){
            addMenuItem(menuItem);
        }
    }
}
