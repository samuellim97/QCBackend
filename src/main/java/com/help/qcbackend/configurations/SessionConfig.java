/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.help.qcbackend.configurations;

import com.fasterxml.jackson.databind.Module;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.geo.GeoModule;
import org.springframework.session.data.mongo.AbstractMongoSessionConverter;
import org.springframework.session.data.mongo.JacksonMongoSessionConverter;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;

/**
 *
 * @author shath
 */

@EnableMongoHttpSession
@Configuration        
class HttpSessionConfig {
    @Bean
    public AbstractMongoSessionConverter mongoSessionConverter(){
        return new JacksonMongoSessionConverter(Collections.<Module>singletonList(new GeoModule()));
    }
    

}
