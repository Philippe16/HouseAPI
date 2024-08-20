package com.ronaldo.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RoomID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HouseID", nullable = false)
    @JsonBackReference
    private House house;

    @Column(nullable = false)
    private String RoomType;

    @Column(nullable = false)
    private String RoomImage;

    // Getters and Setters


    public Integer getRoomID() {
        return RoomID;
    }

    public void setRoomID(Integer roomID) {
        RoomID = roomID;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public String getRoomImage() {
        return RoomImage;
    }

    public void setRoomImage(String roomImage) {
        RoomImage = roomImage;
    }
}
