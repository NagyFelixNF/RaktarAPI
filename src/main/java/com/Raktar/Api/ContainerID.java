/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Raktar.Api;

import java.io.Serializable;
import java.util.Objects;

/**
 *  This is our composite key for Container entity
 * @author Desmor
 */

public class ContainerID implements Serializable{

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

        
    String Shelf;
    String Box;

    public ContainerID() {
    }

    public ContainerID(String Shelf, String Box) {
        this.Shelf = Shelf;
        this.Box = Box;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContainerID other = (ContainerID) obj;
        if (!Objects.equals(this.Shelf, other.Shelf)) {
            return false;
        }
        if (!Objects.equals(this.Box, other.Box)) {
            return false;
        }
        return true;
    }
}
