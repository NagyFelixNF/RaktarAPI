/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Raktar.Api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("/item")
public class ItemController {
    
    @Autowired
    private ItemRepository itemRepo;
    @Autowired
    private ContainerRepository containerRepo;
    @Autowired
    private ObjectMapper objectMapper;
    
     @PostConstruct
    public void init() {
        objectMapper.findAndRegisterModules();
    }
            
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Item getItem(@PathParam("id") String id) throws JsonProcessingException {
        
        return itemRepo.findById(id).orElse(null);

    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Item> getAllItem() throws JsonProcessingException {
          ArrayList<Item> findAllWithConatiner = itemRepo.findAll();
          //String a = findAllWithConatiner.get(1).Container.getBox();
        return findAllWithConatiner;
    }
    
    
    //Save the Item if the item already in the db then updates it;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addItem(Item item,@Context UriInfo uriInfo)
    {
        itemRepo.save(new Item(item.getItemID(),item.getCategory(),item.getName(),item.getQuantity(),item.getOperatorName()
                ,item.getTimePlaced(),item.getTimeModified(),item.getNeedsReorder()));
        
        return Response.status(Response.Status.CREATED.getStatusCode()).header("Created", item.ItemID).build();
    }
    
    @POST
    @Path("/withcontainer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addItemWithConainer(Item item, @Context UriInfo uriInfo)
    {
        itemRepo.save(new Item(item.getItemID(),item.getCategory(),item.getName(),item.getQuantity(),item.getOperatorName()
        ,item.getTimePlaced(),item.getTimeModified(),item.getNeedsReorder()));
        for(Container con : item.getContainer())
        {
            con.setItem(item);
            containerRepo.save(con);
        }

        
        return Response.status(Response.Status.CREATED.getStatusCode()).header("Created", item.ItemID).build();
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("id") String id) throws JsonProcessingException {
        Item item = itemRepo.findById(id).orElse(null);
        if(item == null)
        {
            return Response.status(Response.Status.NO_CONTENT.getStatusCode()).build();
        }
        ArrayList<Container> containers = containerRepo.findAllByItemID(item.ItemID);
        for(Container con : item.getContainer())
        {
            con.setItem(null);
            containerRepo.save(con);
        }
        itemRepo.delete(item);
        return Response.status(Response.Status.OK.getStatusCode()).header("Deleted", item.ItemID).build();
    }
}
