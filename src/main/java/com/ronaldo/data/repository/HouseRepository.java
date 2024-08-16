package com.ronaldo.data.repository;

import com.ronaldo.data.entity.House;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class HouseRepository implements PanacheRepository<House> {

}
