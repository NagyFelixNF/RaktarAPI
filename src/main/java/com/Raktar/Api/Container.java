/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Raktar.Api;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *  This is one of our entity class this has all the annotation to save to the database and also to serilazie it to JSON to send out with our API
 *  You can see the databse realtion in our documentation (page 7)
 * @author Desmor
 */


@Entity
@IdClass(ContainerID.class)
public class Container implements Serializable {

    public String getShelf() {
        return Shelf;
    }

    public void setShelf(String Shelf) {
        this.Shelf = Shelf;
    }

    public String getBox() {
        return Box;
    }

    public void setBox(String Box) {
        this.Box = Box;
    }
    //@JsonBackReference
    @JsonIgnore
    public Item getItem() {
        return Item;
    }

    public void setItem(Item Item) {
        this.Item = Item;
    }
    
    //Composite key
    @Id
    String Shelf;
    @Id
    String Box;
    
    //Foregin Key to Item
    @ManyToOne()
    @JoinColumn(name="ItemID")
    //@JsonBackReference
    @JsonIgnore
    private Item Item;

    public Container() {}
    
    public Container(String Shelf, String Box, Item Item) {
        this.Shelf = Shelf;
        this.Box = Box;
        this.Item = Item;
    }
    
    
    
}

