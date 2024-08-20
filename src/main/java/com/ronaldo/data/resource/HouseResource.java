package com.ronaldo.data.resource;

import com.ronaldo.data.entity.House;
import com.ronaldo.data.entity.Room;
import com.ronaldo.data.repository.HouseRepository;
import com.ronaldo.data.repository.RoomRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Path("/houses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HouseResource {

    @Inject
    HouseRepository houseRepository;

    @Inject
    RoomRepository roomRepository;

    @GET
    @Path("/hello")
    public Response hello() {
        return Response.ok("Hello World!").build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHouse(@PathParam("id") Integer id) {
        Optional<House> house = houseRepository.getHouseById(id);

        return Response.ok(house).build();
    }

    @POST
    @ResponseStatus(201)
    @Transactional
    public Response addHouse(House house){
        if(house.getRooms() != null && !house.getRooms().isEmpty()){
            for (Room room: house.getRooms()){
                room.setHouse(house);
            }
        }

      House newHouse = houseRepository.addHouse(house);
      return Response.status(Response.Status.CREATED).entity(newHouse).build();
    }


    @POST
    @Path("/{id}/rooms")
    public Response addRoomToHouse(@PathParam("id") int houseId, List<Room> rooms){
        Optional<House> houseOptional = houseRepository.getHouseById(houseId);
        if (houseOptional.isPresent()){

            House house = houseOptional.get();

            for (Room room: rooms) {
                room.setHouse(house);
                roomRepository.addRoom(room);
            }
            house = houseRepository.getHouseById(houseId).orElse(house);
            return Response.ok(house).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @DELETE
    @Path("/{id}")
    public Response deleteHouse(@PathParam("id") Integer id) {
        houseRepository.removeHouseById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
