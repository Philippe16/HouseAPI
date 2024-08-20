package com.ronaldo.data.resource;


import com.ronaldo.data.entity.Room;
import com.ronaldo.data.repository.HouseRepository;
import com.ronaldo.data.repository.RoomRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {


    @Inject
    RoomRepository roomRepository;

    @GET
    @Path("/hello")
    public Response hello() {
        return Response.ok("Hello World!").build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response removeRoomById(@PathParam("id") Integer id) {
        roomRepository.removeRoomFromHouse(id);
        return Response.noContent().build();
    }


}
