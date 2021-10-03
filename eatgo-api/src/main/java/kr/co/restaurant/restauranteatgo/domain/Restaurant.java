package kr.co.restaurant.restauranteatgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Restaurant {
    private String name;
    private String address;

    @GeneratedValue
    @Id
    private Long id;
    @Transient
    private List<MenuItem> menuItems = new ArrayList<>();
    //json형성시 기본constructor생성자 필수
    public Restaurant() {
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
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

    public void setId(long id) {
        this.id = id;
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
