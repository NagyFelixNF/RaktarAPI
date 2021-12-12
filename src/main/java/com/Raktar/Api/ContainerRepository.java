/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Raktar.Api;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Desmor
 */
public interface ContainerRepository extends CrudRepository<Container, ContainerID> {
    
}
