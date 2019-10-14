package com.proyecto.bootcamp.service;


import com.proyecto.bootcamp.bean.Parents;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface parentsService {

	
	
	Flux<Parents> findAll();
	
	
	Mono<Parents> save(Parents parent);
	


    Mono<Void> delete(Parents parent);
    
   Mono<Parents> findById(String id);
    

}
