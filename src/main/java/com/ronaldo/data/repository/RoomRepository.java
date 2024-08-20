package com.ronaldo.data.repository;

import com.ronaldo.data.entity.House;
import com.ronaldo.data.entity.Room;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;



@ApplicationScoped
public class RoomRepository implements PanacheRepository<Room> {

    @Transactional
    public Room addRoom(Room room) {
        persist(room);
        return room;
    }

    @Transactional
    public void removeRoomFromHouse(int roomId){
        Room room = find("id", roomId).firstResult();
        if (room != null) {
            House house = room.getHouse();
            if(house !=null){
                house.getRooms().remove(room);
                delete(room);
            }
        }
    }

}
