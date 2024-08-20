package com.ronaldo.data.repository;

import com.ronaldo.data.entity.House;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;

@ApplicationScoped
public class HouseRepository implements PanacheRepository<House> {

    public Optional<House> getHouseById(Integer id) {
        House house = find("SELECT h FROM House h LEFT JOIN FETCH h.rooms WHERE h.HouseID = ?1", id).firstResult();
        house.setHouseImage("http://localhost:8080/static/" + house.getHouseImage());
        return Optional.of(house);
    }

    @Transactional
    public House addHouse(House house) {
        persist(house);
        return house;
    }

    @Transactional
    public House removeHouseById(int id) {
        House house = find("id", id).firstResult();
        if (house != null) {
            delete(house);
            return house;
        }
        return null;
    }


}