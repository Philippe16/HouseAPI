package com.ronaldo.data.resource;

import com.ronaldo.data.entity.House;
import com.ronaldo.data.repository.HouseRepository;
import com.ronaldo.data.service.HouseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/houses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HouseResource {

    @Inject
    HouseRepository houseRepository;

    @GET
    @Path("/{id}")
    public Response getHouse(@PathParam("id") long id) {
        Optional<House> house = houseRepository.findByIdOptional(id);
        if (house.isPresent()) {
            return Response.ok(house.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
