/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Raktar.Api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * This is one of our entity class this has all the annotation to save to the database and also to serilazie it to JSON to send out with our API
 * You can see the databse realtion in our documentation (page 7)
 * @author Desmor
 */
@Entity
public class Item implements Serializable {

    public Item(String ItemID, String Category, String Name, Integer Quantity, String OperatorName, LocalDateTime TimePlaced, LocalDateTime TimeModified, Boolean NeedsReorder, List<Container> Container) {
        this.ItemID = ItemID;
        this.Category = Category;
        this.Name = Name;
        this.Quantity = Quantity;
        this.OperatorName = OperatorName;
        this.TimePlaced = TimePlaced;
        this.TimeModified = TimeModified;
        this.NeedsReorder = NeedsReorder;
        this.Container = Container;
    }
    
    //@JsonManagedReference
    public List<Container> getContainer() {
        return Container;
    }

    public void setContainer(List<Container> Container) {
        this.Container = Container;
    }



    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public String getOperatorName() {
        return OperatorName;
    }

    public void setOperatorName(String OperatorName) {
        this.OperatorName = OperatorName;
    }

    public LocalDateTime getTimePlaced() {
        return TimePlaced;
    }

    public void setTimePlaced(LocalDateTime TimePlaced) {
        this.TimePlaced = TimePlaced;
    }

    public LocalDateTime getTimeModified() {
        return TimeModified;
    }

    public void setTimeModified(LocalDateTime TimeModified) {
        this.TimeModified = TimeModified;
    }

    public Boolean getNeedsReorder() {
        return NeedsReorder;
    }

    public void setNeedsReorder(Boolean NeedsReorder) {
        this.NeedsReorder = NeedsReorder;
    }
    
    @Id
    String ItemID;
    
    String Category;
    String Name;
    Integer Quantity;
    String OperatorName;
    LocalDateTime TimePlaced;
    LocalDateTime TimeModified;
    Boolean NeedsReorder;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "Item")
    //@JsonManagedReference
    List<Container> Container;
    
    public Item() {}
      
     public Item(String ItemID, String Category, String Name, int Quantity, String OperatorName, LocalDateTime TimePlaced, LocalDateTime TimeModified, Boolean NeedsReorder) {
        this.ItemID = ItemID;
        this.Category = Category;
        this.Name = Name;
        this.Quantity = Quantity;
        this.OperatorName = OperatorName;
        this.TimePlaced = TimePlaced;
        this.TimeModified = TimeModified;
        this.NeedsReorder = NeedsReorder;
    }
    
    
}
