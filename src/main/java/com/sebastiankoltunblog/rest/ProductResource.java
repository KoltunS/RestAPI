package com.sebastiankoltunblog.rest;

import com.sebastiankoltunblog.commandhandler.CommandGateway;
import com.sebastiankoltunblog.commandhandler.Gateway;
import com.sebastiankoltunblog.dto.AddToCartCommand;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/productcart")
public class ProductResource {
    private static final Logger log = Logger.getLogger(ProductResource.class);
    @Inject
    @Gateway
    private CommandGateway gateway;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addToCart(AddToCartCommand command) {
        log.info(command);
        gateway.execute(command);
        return Response.ok().build();
    }
}
