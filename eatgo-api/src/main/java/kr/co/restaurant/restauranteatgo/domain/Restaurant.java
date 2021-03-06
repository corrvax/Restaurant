package kr.co.restaurant.restauranteatgo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String address;

    @Transient
    private List<MenuItem> menuItems = new ArrayList<>();

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Restaurant(Long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getInformation() {
        return name + " in " + address;
    }


    public void setId(long id) {
        this.id = id;
    }
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }


    public void setMenuItems(List<MenuItem> menuItems) {
        for(MenuItem menuItem: menuItems){
            addMenuItem(menuItem);
        }
    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
