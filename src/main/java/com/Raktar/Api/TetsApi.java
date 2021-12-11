/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Raktar.Api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Desmor
 */
@Path("/test")
public class TetsApi {
    
    @Autowired
    private ItemRepository repo;
    @Autowired
    private ObjectMapper objectMapper;
    
     @PostConstruct
    public void init() {
        objectMapper.findAndRegisterModules();
    }
            
    @GET
    @Path("/help")
    @Produces(MediaType.TEXT_PLAIN)
    public String gettext(){
        repo.save(new Item("a","a","a",1,"a",LocalDateTime.now(),LocalDateTime.now(),true));
        return "text";
    }
    
    @GET
    @Path("item/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Item getItem(@PathParam("id") String id) throws JsonProcessingException {
        
        return repo.findById(id).orElse(null);

    }
    
    @GET
    @Path("items")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Item> getAllItem() throws JsonProcessingException {
        return repo.findAll();

    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addItem(Item item,@Context UriInfo uriInfo)
    {
        repo.save(new Item(item.getItemID(),item.getName(),item.getOperatorName(),item.getQuantity(),item.getCategory()
                ,item.getTimeModified(),item.getTimePlaced(),item.getNeedsReorder()));
        
        return Response.status(Response.Status.CREATED.getStatusCode()).header("Created", item).build();
    }
}
