/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Raktar.Api;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 *  This class performs the nessecary configuration for Jersey to provide the API
 * @author Desmor
 */
@Configuration
@ApplicationPath("/rest")
public class JerseyConfiguration extends ResourceConfig {

    //Init the register method for our controllers
    @PostConstruct
    public void init() {
        register(TetsApi.class);
}
}
