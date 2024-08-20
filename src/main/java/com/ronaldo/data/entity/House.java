package com.ronaldo.data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HouseID")
    private Integer HouseID;

    @Column(name = "HouseImage")
    private String HouseImage;

    @Column(name = "Address")
    private String Address;

    @Column(name = "Type")
    private String Type;

    @Column(name = "City")
    private String City;

    @Column(name = "Area")
    private String Area;

    @Column(name = "Floorspace")
    private String Floorspace;

    @Column(name = "Price")
    private Integer Price;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Room> rooms;

    // Getters and Setters

    public Integer getHouseID() {
        return HouseID;
    }

    public void setHouseID(Integer houseID) {
        HouseID = houseID;
    }

    public String getHouseImage() {
        return HouseImage;
    }

    public void setHouseImage(String houseImage) {
        HouseImage = houseImage;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getFloorspace() {
        return Floorspace;
    }

    public void setFloorspace(String floorspace) {
        Floorspace = floorspace;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
