/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Raktar.Api;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Desmor
 */
public interface ContainerRepository extends CrudRepository<Container, ContainerID> {
    
    @Query(value = "SELECT * FROM container WHERE itemid = 'name'", nativeQuery = true)
    ArrayList<Container> findAllByItemID( @Param("name") String Id);
}
