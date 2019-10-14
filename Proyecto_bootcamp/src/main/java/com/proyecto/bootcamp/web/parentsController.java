package com.proyecto.bootcamp.web;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

import com.proyecto.bootcamp.bean.Parents;
import com.proyecto.bootcamp.service.parentsServiceImpl;
import com.sun.el.stream.Stream;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/index")
public class parentsController {

	@Autowired
	private parentsServiceImpl service;



	@GetMapping(value = "/listall", produces = { MediaType.APPLICATION_STREAM_JSON_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Flux<Parents>> listStudents() {

		System.out.println("Prueba");
		Flux<Parents> lista = service.findAll();

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(lista);

	}

	@PostMapping(value = "/entities", produces = { MediaType.APPLICATION_STREAM_JSON_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Parents> postParents(@RequestBody @Validated Mono<Parents> request) {

		return request.flatMap(e -> service.save(e));
	}

//	  @PutMapping(value = "/entities/{entityId}", produces = {
//			    MediaType.APPLICATION_STREAM_JSON_VALUE,
//			    MediaType.APPLICATION_JSON_VALUE
//	  })
//			  public Mono<Parents> putParents(
//			                                        @PathVariable Integer entityId,
//			                                        @RequestBody @Validated Mono<Parents> requestEntity) {
//			    
//			    return requestEntity
//			      .flatMap(e -> service.put(e, entityId));
//			  }

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> eliminar(@PathVariable String id) {
		return service.findById(id).flatMap(p -> {
			return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).onErrorReturn(new ResponseEntity<Void>(HttpStatus.BAD_REQUEST));

	}

//	  @PutMapping("/{id}")
//		public Mono<Parents> editar(@PathVariable("id") final String id, @RequestBody final Parents parents){
//			return service.update(id, parents);
//		}
//	

	@PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_STREAM_JSON_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Mono<ResponseEntity<Parents>> updateParents(@PathVariable("id") String id, @RequestBody Parents parents) {
		return service.findById(id).flatMap(resultado -> {
			resultado.setComplementName(resultado.getComplementName());
			resultado.setDateBirth(parents.getDateBirth());
			resultado.setNumberidentify(parents.getNumberidentify());
			resultado.setSex(parents.getSex());
			resultado.setTypeidentify(parents.getTypeidentify());
			return service.save(resultado);
		}).map(respuesta -> new ResponseEntity<Parents>(respuesta, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

//	  
//	  
//	  
//	  @GetMapping(
//			    value = "/index",
//			    produces = {
//			      MediaType.APPLICATION_STREAM_JSON_VALUE,
//			      MediaType.APPLICATION_JSON_VALUE
//			    }
//)
//	  public void listParents() {
//		  
//		  
//		  
//		  
//	  }

}
