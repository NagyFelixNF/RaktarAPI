/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Raktar.Api;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Desmor
 */
public interface ItemRepository extends CrudRepository<Item, String>{
    
    @Override
    Optional<Item> findById(String id);
    @Override
    ArrayList<Item> findAll();
}
